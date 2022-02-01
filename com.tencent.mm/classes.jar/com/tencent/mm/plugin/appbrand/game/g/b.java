package com.tencent.mm.plugin.appbrand.game.g;

import android.annotation.SuppressLint;
import android.content.Context;
import com.hilive.mediasdk.MediaSdk;
import com.hilive.mediasdk.MediaSdk.MediaCallbacker;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static volatile Map<String, b> luM;
  private static b.c luN;
  public MMHandler luO;
  public a.a luP;
  private MediaSdk luQ;
  private e luR;
  private c.a luS;
  private c.a luT;
  private final Runnable luU;
  
  static
  {
    AppMethodBeat.i(45375);
    luM = new HashMap(1);
    luN = b.c.lvq;
    AppMethodBeat.o(45375);
  }
  
  private b(MagicBrushView paramMagicBrushView, final Context paramContext)
  {
    AppMethodBeat.i(226639);
    this.luQ = new MediaSdk();
    this.luR = e.lvs;
    this.luS = null;
    this.luT = null;
    this.luU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45337);
        if (b.b(b.this) == b.e.lvt)
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
          b.j(b.this).uint();
          b.i(b.this);
          b.a(b.this, b.e.lvs);
          AppMethodBeat.o(45337);
          return;
        }
        Log.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
        AppMethodBeat.o(45337);
      }
    };
    this.luO = new MMHandler("wegame_screen_recorder_worker");
    if (luN != b.c.lvp) {
      this.luP = new a.b(paramMagicBrushView);
    }
    this.luO.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45320);
        b.a(b.this);
        AppMethodBeat.o(45320);
      }
    });
    AppMethodBeat.o(226639);
  }
  
  public static b a(String paramString, MagicBrushView paramMagicBrushView, Context paramContext)
  {
    AppMethodBeat.i(226640);
    if (Util.isNullOrNil(paramString))
    {
      paramString = new RuntimeException("Null or nil appid");
      AppMethodBeat.o(226640);
      throw paramString;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!luM.containsKey(paramString)) {
      localObject1 = localObject2;
    }
    try
    {
      if (!luM.containsKey(paramString))
      {
        localObject1 = new b(paramMagicBrushView, paramContext);
        luM.put(paramString, localObject1);
      }
      paramMagicBrushView = (MagicBrushView)localObject1;
      if (localObject1 == null) {
        paramMagicBrushView = (b)luM.get(paramString);
      }
      AppMethodBeat.o(226640);
      return paramMagicBrushView;
    }
    finally
    {
      AppMethodBeat.o(226640);
    }
  }
  
  public final void a(final String paramString, final d<a> paramd)
  {
    AppMethodBeat.i(226641);
    this.luO.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45358);
        try
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: requestAnalyze %s", new Object[] { paramString });
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("filePath", paramString);
          b.j(b.this).analysis(localJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
          {
            public final void onResult(byte[] paramAnonymous2ArrayOfByte)
            {
              AppMethodBeat.i(226638);
              try
              {
                paramAnonymous2ArrayOfByte = new JSONObject(new String(paramAnonymous2ArrayOfByte));
                b.a locala = new b.a(b.this);
                locala.duration = paramAnonymous2ArrayOfByte.optLong("duration", 0L);
                locala.fileSize = paramAnonymous2ArrayOfByte.optLong("size", 0L);
                Log.i("MicroMsg.GameRecorderMgr", "hy: duration is %d, size is %d", new Object[] { Long.valueOf(locala.duration), Long.valueOf(locala.fileSize) });
                b.18.this.luL.a(0, 0, "ok", locala);
                AppMethodBeat.o(226638);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.18.this.luL.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(226638);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.18.this.luL.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(226638);
              }
            }
          });
          AppMethodBeat.o(45358);
          return;
        }
        catch (JSONException localJSONException)
        {
          paramd.a(1, -1, "analysis error: " + localJSONException.getMessage(), null);
          AppMethodBeat.o(45358);
          return;
        }
        catch (Exception localException)
        {
          paramd.a(1, -1, "analysis error: " + localException.getMessage(), null);
          AppMethodBeat.o(45358);
        }
      }
    });
    AppMethodBeat.o(226641);
  }
  
  public final void a(final JSONObject paramJSONObject, final d<JSONObject> paramd)
  {
    AppMethodBeat.i(226642);
    this.luO.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45322);
        try
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: trigger remux " + paramJSONObject.toString());
          b.j(b.this).remux(paramJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
          {
            public final void onResult(byte[] paramAnonymous2ArrayOfByte)
            {
              AppMethodBeat.i(174731);
              try
              {
                paramAnonymous2ArrayOfByte = new JSONObject(new String(paramAnonymous2ArrayOfByte));
                int i = paramAnonymous2ArrayOfByte.optInt("errCode", 601);
                if (i == 0)
                {
                  b.2.this.luL.a(0, 0, "ok", paramAnonymous2ArrayOfByte);
                  AppMethodBeat.o(174731);
                  return;
                }
                b.2.this.luL.a(1, i, String.format("remux failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymous2ArrayOfByte);
                AppMethodBeat.o(174731);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.2.this.luL.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
                AppMethodBeat.o(174731);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.2.this.luL.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
                AppMethodBeat.o(174731);
              }
            }
          });
          AppMethodBeat.o(45322);
          return;
        }
        catch (Exception localException)
        {
          paramd.a(1, -1, "remux error: " + localException.getMessage(), new JSONObject());
          AppMethodBeat.o(45322);
        }
      }
    });
    AppMethodBeat.o(226642);
  }
  
  public final void e(final d<String> paramd)
  {
    AppMethodBeat.i(45368);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
    this.luO.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45350);
        if (!b.f(b.this))
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: not started");
          paramd.a(2, 201, "not start yet!", null);
          AppMethodBeat.o(45350);
          return;
        }
        if (b.b(b.this) == b.e.lvv)
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
          paramd.a(2, 202, "already paused!", null);
          AppMethodBeat.o(45350);
          return;
        }
        b.a(b.this, b.e.lvv);
        b.d(b.this).b(new d() {});
        AppMethodBeat.o(45350);
      }
    });
    AppMethodBeat.o(45368);
  }
  
  public final void f(final d<String> paramd)
  {
    AppMethodBeat.i(45369);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger resume");
    this.luO.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45352);
        if (!b.f(b.this))
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: not started");
          paramd.a(2, 301, "not start yet!", null);
          AppMethodBeat.o(45352);
          return;
        }
        if (b.b(b.this) == b.e.lvu)
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
          paramd.a(2, 302, "already running!", null);
          AppMethodBeat.o(45352);
          return;
        }
        b.a(b.this, b.e.lvu);
        b.d(b.this).c(new d() {});
        AppMethodBeat.o(45352);
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
    public abstract void Bc(long paramLong);
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
      lvs = new e("NotInit", 0);
      lvt = new e("Inited", 1);
      lvu = new e("Running", 2);
      lvv = new e("Paused", 3);
      lvw = new e[] { lvs, lvt, lvu, lvv };
      AppMethodBeat.o(45365);
    }
    
    private e() {}
  }
  
  public final class f
  {
    public c.a lvx;
    public c.a lvy;
    
    public f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b
 * JD-Core Version:    0.7.0.1
 */