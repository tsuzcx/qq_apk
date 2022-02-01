package com.tencent.mm.plugin.appbrand.game.g;

import android.content.Context;
import com.hilive.mediasdk.LoadDelegate.ILoadLibrary;
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
  private static volatile Map<String, b> rts;
  private static b.c rtu;
  private c.a rtA;
  private final Runnable rtB;
  public MMHandler rtv;
  public a.a rtw;
  private MediaSdk rtx;
  private e rty;
  private c.a rtz;
  
  static
  {
    AppMethodBeat.i(45375);
    rts = new HashMap(1);
    rtu = b.c.rtW;
    AppMethodBeat.o(45375);
  }
  
  private b(MagicBrushView paramMagicBrushView, final Context paramContext)
  {
    AppMethodBeat.i(318426);
    this.rtx = new MediaSdk();
    this.rty = e.rtY;
    this.rtz = null;
    this.rtA = null;
    this.rtB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45337);
        if (b.a(b.this) == b.e.rtZ)
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
          b.i(b.this).uint();
          b.h(b.this);
          b.a(b.this, b.e.rtY);
          AppMethodBeat.o(45337);
          return;
        }
        Log.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
        AppMethodBeat.o(45337);
      }
    };
    this.rtv = new MMHandler("wegame_screen_recorder_worker");
    if (rtu != b.c.rtV) {
      this.rtw = new a.b(paramMagicBrushView);
    }
    this.rtv.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45320);
        com.tencent.mm.plugin.appbrand.app.k.ceQ();
        b.a(b.this, paramContext);
        AppMethodBeat.o(45320);
      }
    });
    AppMethodBeat.o(318426);
  }
  
  public static b ZB(String paramString)
  {
    AppMethodBeat.i(318429);
    if (!rts.containsKey(paramString))
    {
      AppMethodBeat.o(318429);
      return null;
    }
    paramString = (b)rts.get(paramString);
    if ((paramString == null) || ((paramString.rty != e.rua) && (paramString.rty != e.rub)))
    {
      AppMethodBeat.o(318429);
      return null;
    }
    AppMethodBeat.o(318429);
    return paramString;
  }
  
  public static b a(String paramString, MagicBrushView paramMagicBrushView, Context paramContext)
  {
    AppMethodBeat.i(318428);
    if (Util.isNullOrNil(paramString))
    {
      paramString = new RuntimeException("Null or nil appid");
      AppMethodBeat.o(318428);
      throw paramString;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!rts.containsKey(paramString)) {
      localObject1 = localObject2;
    }
    try
    {
      if (!rts.containsKey(paramString))
      {
        localObject1 = new b(paramMagicBrushView, paramContext);
        rts.put(paramString, localObject1);
      }
      paramMagicBrushView = (MagicBrushView)localObject1;
      if (localObject1 == null) {
        paramMagicBrushView = (b)rts.get(paramString);
      }
      AppMethodBeat.o(318428);
      return paramMagicBrushView;
    }
    finally
    {
      AppMethodBeat.o(318428);
    }
  }
  
  public final void a(final String paramString, final d<a> paramd)
  {
    AppMethodBeat.i(318460);
    this.rtv.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45358);
        try
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: requestAnalyze %s", new Object[] { paramString });
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("filePath", paramString);
          b.i(b.this).analysis(localJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
          {
            public final void onResult(byte[] paramAnonymous2ArrayOfByte)
            {
              AppMethodBeat.i(318423);
              try
              {
                paramAnonymous2ArrayOfByte = new JSONObject(new String(paramAnonymous2ArrayOfByte));
                b.a locala = new b.a(b.this);
                locala.duration = paramAnonymous2ArrayOfByte.optLong("duration", 0L);
                locala.fileSize = paramAnonymous2ArrayOfByte.optLong("size", 0L);
                Log.i("MicroMsg.GameRecorderMgr", "hy: duration is %d, size is %d", new Object[] { Long.valueOf(locala.duration), Long.valueOf(locala.fileSize) });
                b.18.this.rtr.a(0, 0, "ok", locala);
                AppMethodBeat.o(318423);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.18.this.rtr.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(318423);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.18.this.rtr.a(1, -1, "analysis error: " + paramAnonymous2ArrayOfByte.getMessage(), null);
                AppMethodBeat.o(318423);
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
    AppMethodBeat.o(318460);
  }
  
  public final void a(final JSONObject paramJSONObject, final d<JSONObject> paramd)
  {
    AppMethodBeat.i(318462);
    this.rtv.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45322);
        try
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: trigger remux " + paramJSONObject.toString());
          b.i(b.this).remux(paramJSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker()
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
                  b.2.this.rtr.a(0, 0, "ok", paramAnonymous2ArrayOfByte);
                  AppMethodBeat.o(174731);
                  return;
                }
                b.2.this.rtr.a(1, i, String.format("remux failed!: errCode: %d", new Object[] { Integer.valueOf(i) }), paramAnonymous2ArrayOfByte);
                AppMethodBeat.o(174731);
                return;
              }
              catch (JSONException paramAnonymous2ArrayOfByte)
              {
                b.2.this.rtr.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
                AppMethodBeat.o(174731);
                return;
              }
              catch (Exception paramAnonymous2ArrayOfByte)
              {
                b.2.this.rtr.a(1, -1, "remux error: " + paramAnonymous2ArrayOfByte.getMessage(), new JSONObject());
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
    AppMethodBeat.o(318462);
  }
  
  public final void e(final d<String> paramd)
  {
    AppMethodBeat.i(45368);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
    this.rtv.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45350);
        if (!b.e(b.this))
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: not started");
          paramd.a(2, 201, "not start yet!", null);
          AppMethodBeat.o(45350);
          return;
        }
        if (b.a(b.this) == b.e.rub)
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
          paramd.a(2, 202, "already paused!", null);
          AppMethodBeat.o(45350);
          return;
        }
        b.a(b.this, b.e.rub);
        b.c(b.this).b(new d() {});
        AppMethodBeat.o(45350);
      }
    });
    AppMethodBeat.o(45368);
  }
  
  public final void f(final d<String> paramd)
  {
    AppMethodBeat.i(45369);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger resume");
    this.rtv.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45352);
        if (!b.e(b.this))
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: not started");
          paramd.a(2, 301, "not start yet!", null);
          AppMethodBeat.o(45352);
          return;
        }
        if (b.a(b.this) == b.e.rua)
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
          paramd.a(2, 302, "already running!", null);
          AppMethodBeat.o(45352);
          return;
        }
        b.a(b.this, b.e.rua);
        b.c(b.this).c(new d() {});
        AppMethodBeat.o(45352);
      }
    });
    AppMethodBeat.o(45369);
  }
  
  public final void g(final d<f> paramd)
  {
    AppMethodBeat.i(318457);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger stop");
    this.rtv.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45354);
        if (!b.e(b.this))
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: stop failed: not started");
          paramd.a(0, 501, "not start yet!", null);
          AppMethodBeat.o(45354);
          return;
        }
        b.c(b.this).a(new d() {});
        AppMethodBeat.o(45354);
      }
    });
    AppMethodBeat.o(318457);
  }
  
  public final class a
  {
    public long duration;
    public long fileSize;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void jE(long paramLong);
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
      rtY = new e("NotInit", 0);
      rtZ = new e("Inited", 1);
      rua = new e("Running", 2);
      rub = new e("Paused", 3);
      ruc = new e[] { rtY, rtZ, rua, rub };
      AppMethodBeat.o(45365);
    }
    
    private e() {}
  }
  
  public final class f
  {
    public c.a rud;
    public c.a rue;
    
    public f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b
 * JD-Core Version:    0.7.0.1
 */