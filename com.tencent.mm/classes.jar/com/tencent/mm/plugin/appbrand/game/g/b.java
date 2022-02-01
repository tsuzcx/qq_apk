package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import com.hilive.mediasdk.LoadDelegate.ILoadLibrary;
import com.hilive.mediasdk.LogDelegate.ILog;
import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static volatile Map<String, b> knN;
  private static b.c knO;
  public ap knP;
  public a.a knQ;
  private MediaSdk knR;
  private e knS;
  private c.a knT;
  private c.a knU;
  private final Runnable knV;
  
  static
  {
    AppMethodBeat.i(45375);
    knN = new HashMap(1);
    knO = b.c.kor;
    AppMethodBeat.o(45375);
  }
  
  private b(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(45366);
    this.knR = new MediaSdk();
    this.knS = e.kot;
    this.knT = null;
    this.knU = null;
    this.knV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174740);
        if (b.b(b.this) == b.e.kou)
        {
          ad.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
          b.j(b.this).uint();
          b.i(b.this);
          b.a(b.this, b.e.kot);
          AppMethodBeat.o(174740);
          return;
        }
        ad.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
        AppMethodBeat.o(174740);
      }
    };
    this.knP = new ap("wegame_screen_recorder_worker");
    if (knO != b.c.koq) {
      this.knQ = new a.b(paramMagicBrushView);
    }
    this.knP.postToWorker(new Runnable()
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
    if (bt.isNullOrNil(paramString))
    {
      paramString = new RuntimeException("Null or nil appid");
      AppMethodBeat.o(45367);
      throw paramString;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!knN.containsKey(paramString)) {
      localObject1 = localObject2;
    }
    try
    {
      if (!knN.containsKey(paramString))
      {
        localObject1 = new b(paramMagicBrushView);
        knN.put(paramString, localObject1);
      }
      paramMagicBrushView = (MagicBrushView)localObject1;
      if (localObject1 == null) {
        paramMagicBrushView = (b)knN.get(paramString);
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
    AppMethodBeat.i(188239);
    this.knP.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45322);
        try
        {
          ad.i("MicroMsg.GameRecorderMgr", "hy: requestAnalyze %s", new Object[] { paramString });
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
                ad.i("MicroMsg.GameRecorderMgr", "hy: duration is %d, size is %d", new Object[] { Long.valueOf(locala.duration), Long.valueOf(locala.fileSize) });
                b.2.this.knM.a(0, 0, "ok", locala);
                AppMethodBeat.o(174731);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.2.this.knM.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(174731);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.2.this.knM.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
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
    AppMethodBeat.o(188239);
  }
  
  public final void a(final JSONObject paramJSONObject, final d<JSONObject> paramd)
  {
    AppMethodBeat.i(188240);
    this.knP.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45324);
        try
        {
          ad.i("MicroMsg.GameRecorderMgr", "hy: trigger remux " + paramJSONObject.toString());
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
                  b.3.this.knM.a(0, 0, "ok", paramAnonymous2ArrayOfByte);
                  AppMethodBeat.o(174732);
                  return;
                }
                b.3.this.knM.a(1, i, String.format("remux failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymous2ArrayOfByte);
                AppMethodBeat.o(174732);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.3.this.knM.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
                AppMethodBeat.o(174732);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.3.this.knM.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
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
    AppMethodBeat.o(188240);
  }
  
  public final void e(final d<String> paramd)
  {
    AppMethodBeat.i(45368);
    ad.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
    this.knP.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45352);
        if (!b.f(b.this))
        {
          ad.w("MicroMsg.GameRecorderMgr", "hy: pause failed: not started");
          paramd.a(2, 201, "not start yet!", null);
          AppMethodBeat.o(45352);
          return;
        }
        if (b.b(b.this) == b.e.kow)
        {
          ad.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
          paramd.a(2, 202, "already paused!", null);
          AppMethodBeat.o(45352);
          return;
        }
        b.a(b.this, b.e.kow);
        b.d(b.this).b(new d() {});
        AppMethodBeat.o(45352);
      }
    });
    AppMethodBeat.o(45368);
  }
  
  public final void f(final d<String> paramd)
  {
    AppMethodBeat.i(45369);
    ad.i("MicroMsg.GameRecorderMgr", "hy: trigger resume");
    this.knP.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45354);
        if (!b.f(b.this))
        {
          ad.w("MicroMsg.GameRecorderMgr", "hy: resume failed: not started");
          paramd.a(2, 301, "not start yet!", null);
          AppMethodBeat.o(45354);
          return;
        }
        if (b.b(b.this) == b.e.kov)
        {
          ad.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
          paramd.a(2, 302, "already running!", null);
          AppMethodBeat.o(45354);
          return;
        }
        b.a(b.this, b.e.kov);
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
    public abstract void sK(long paramLong);
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
      kot = new e("NotInit", 0);
      kou = new e("Inited", 1);
      kov = new e("Running", 2);
      kow = new e("Paused", 3);
      kox = new e[] { kot, kou, kov, kow };
      AppMethodBeat.o(45365);
    }
    
    private e() {}
  }
  
  public final class f
  {
    public c.a koy;
    public c.a koz;
    
    public f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b
 * JD-Core Version:    0.7.0.1
 */