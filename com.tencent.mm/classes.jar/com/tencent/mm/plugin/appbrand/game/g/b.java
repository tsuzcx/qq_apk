package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.hilive.mediasdk.LoadDelegate.ILoadLibrary;
import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static volatile Map<String, b> krd;
  private static b.c kre;
  public aq krf;
  public a.a krg;
  private MediaSdk krh;
  private e kri;
  private c.a krj;
  private c.a krk;
  private final Runnable krl;
  
  static
  {
    AppMethodBeat.i(45375);
    krd = new HashMap(1);
    kre = b.c.krH;
    AppMethodBeat.o(45375);
  }
  
  private b(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(45366);
    this.krh = new MediaSdk();
    this.kri = e.krJ;
    this.krj = null;
    this.krk = null;
    this.krl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174740);
        if (b.b(b.this) == b.e.krK)
        {
          ae.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
          b.j(b.this).uint();
          b.i(b.this);
          b.a(b.this, b.e.krJ);
          AppMethodBeat.o(174740);
          return;
        }
        ae.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
        AppMethodBeat.o(174740);
      }
    };
    this.krf = new aq("wegame_screen_recorder_worker");
    if (kre != b.c.krG) {
      this.krg = new a.b(paramMagicBrushView);
    }
    this.krf.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45320);
        b.a(b.this);
        AppMethodBeat.o(45320);
      }
    });
    AppMethodBeat.o(45366);
  }
  
  public static b a(String paramString, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(45367);
    if (bu.isNullOrNil(paramString))
    {
      paramString = new RuntimeException("Null or nil appid");
      AppMethodBeat.o(45367);
      throw paramString;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!krd.containsKey(paramString)) {
      localObject1 = localObject2;
    }
    try
    {
      if (!krd.containsKey(paramString))
      {
        localObject1 = new b(paramMagicBrushView);
        krd.put(paramString, localObject1);
      }
      paramMagicBrushView = (MagicBrushView)localObject1;
      if (localObject1 == null) {
        paramMagicBrushView = (b)krd.get(paramString);
      }
      AppMethodBeat.o(45367);
      return paramMagicBrushView;
    }
    finally
    {
      AppMethodBeat.o(45367);
    }
  }
  
  public final void a(final String paramString, final d<a> paramd)
  {
    AppMethodBeat.i(222365);
    this.krf.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45322);
        try
        {
          ae.i("MicroMsg.GameRecorderMgr", "hy: requestAnalyze %s", new Object[] { paramString });
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("filePath", paramString);
          b.j(b.this).analysis(localJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
          {
            public final void onResult(byte[] paramAnonymous2ArrayOfByte)
            {
              AppMethodBeat.i(174731);
              try
              {
                paramAnonymous2ArrayOfByte = new JSONObject(new String(paramAnonymous2ArrayOfByte));
                b.a locala = new b.a(b.this);
                locala.duration = paramAnonymous2ArrayOfByte.optLong("duration", 0L);
                locala.fileSize = paramAnonymous2ArrayOfByte.optLong("size", 0L);
                ae.i("MicroMsg.GameRecorderMgr", "hy: duration is %d, size is %d", new Object[] { Long.valueOf(locala.duration), Long.valueOf(locala.fileSize) });
                b.2.this.krc.a(0, 0, "ok", locala);
                AppMethodBeat.o(174731);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.2.this.krc.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(174731);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.2.this.krc.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(174731);
              }
            }
          });
          AppMethodBeat.o(45322);
          return;
        }
        catch (JSONException localJSONException)
        {
          paramd.a(1, -1, "analysis error: " + localJSONException.getMessage(), null);
          AppMethodBeat.o(45322);
          return;
        }
        catch (Exception localException)
        {
          paramd.a(1, -1, "analysis error: " + localException.getMessage(), null);
          AppMethodBeat.o(45322);
        }
      }
    });
    AppMethodBeat.o(222365);
  }
  
  public final void a(final JSONObject paramJSONObject, final d<JSONObject> paramd)
  {
    AppMethodBeat.i(222366);
    this.krf.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45324);
        try
        {
          ae.i("MicroMsg.GameRecorderMgr", "hy: trigger remux " + paramJSONObject.toString());
          b.j(b.this).remux(paramJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
          {
            public final void onResult(byte[] paramAnonymous2ArrayOfByte)
            {
              AppMethodBeat.i(174732);
              try
              {
                paramAnonymous2ArrayOfByte = new JSONObject(new String(paramAnonymous2ArrayOfByte));
                int i = paramAnonymous2ArrayOfByte.optInt("errCode", 601);
                if (i == 0)
                {
                  b.3.this.krc.a(0, 0, "ok", paramAnonymous2ArrayOfByte);
                  AppMethodBeat.o(174732);
                  return;
                }
                b.3.this.krc.a(1, i, String.format("remux failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymous2ArrayOfByte);
                AppMethodBeat.o(174732);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.3.this.krc.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
                AppMethodBeat.o(174732);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.3.this.krc.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
                AppMethodBeat.o(174732);
              }
            }
          });
          AppMethodBeat.o(45324);
          return;
        }
        catch (Exception localException)
        {
          paramd.a(1, -1, "remux error: " + localException.getMessage(), new JSONObject());
          AppMethodBeat.o(45324);
        }
      }
    });
    AppMethodBeat.o(222366);
  }
  
  public final void e(final d<String> paramd)
  {
    AppMethodBeat.i(45368);
    ae.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
    this.krf.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45352);
        if (!b.f(b.this))
        {
          ae.w("MicroMsg.GameRecorderMgr", "hy: pause failed: not started");
          paramd.a(2, 201, "not start yet!", null);
          AppMethodBeat.o(45352);
          return;
        }
        if (b.b(b.this) == b.e.krM)
        {
          ae.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
          paramd.a(2, 202, "already paused!", null);
          AppMethodBeat.o(45352);
          return;
        }
        b.a(b.this, b.e.krM);
        b.d(b.this).b(new d() {});
        AppMethodBeat.o(45352);
      }
    });
    AppMethodBeat.o(45368);
  }
  
  public final void f(final d<String> paramd)
  {
    AppMethodBeat.i(45369);
    ae.i("MicroMsg.GameRecorderMgr", "hy: trigger resume");
    this.krf.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45354);
        if (!b.f(b.this))
        {
          ae.w("MicroMsg.GameRecorderMgr", "hy: resume failed: not started");
          paramd.a(2, 301, "not start yet!", null);
          AppMethodBeat.o(45354);
          return;
        }
        if (b.b(b.this) == b.e.krL)
        {
          ae.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
          paramd.a(2, 302, "already running!", null);
          AppMethodBeat.o(45354);
          return;
        }
        b.a(b.this, b.e.krL);
        b.d(b.this).c(new d() {});
        AppMethodBeat.o(45354);
      }
    });
    AppMethodBeat.o(45369);
  }
  
  public final class a
  {
    public long duration;
    public long fileSize;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void sX(long paramLong);
  }
  
  public final class d
  {
    public int audioBitrate = 64000;
    public int audioChannelCount = 2;
    public int audioSampleRate = 44100;
    
    public d() {}
    
    public final String toString()
    {
      AppMethodBeat.i(45362);
      String str = "RemuxResult{audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + '}';
      AppMethodBeat.o(45362);
      return str;
    }
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(45365);
      krJ = new e("NotInit", 0);
      krK = new e("Inited", 1);
      krL = new e("Running", 2);
      krM = new e("Paused", 3);
      krN = new e[] { krJ, krK, krL, krM };
      AppMethodBeat.o(45365);
    }
    
    private e() {}
  }
  
  public final class f
  {
    public c.a krO;
    public c.a krP;
    
    public f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b
 * JD-Core Version:    0.7.0.1
 */