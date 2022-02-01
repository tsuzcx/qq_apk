package com.tencent.mm.plugin.appbrand.game.g;

import android.content.Context;
import com.hilive.mediasdk.MediaSdk;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
{
  private static volatile Map<String, b> opJ;
  private static b.c opK;
  public MMHandler opL;
  public a.a opM;
  private MediaSdk opN;
  private e opO;
  private c.a opP;
  private c.a opQ;
  private final Runnable opR;
  
  static
  {
    AppMethodBeat.i(45375);
    opJ = new HashMap(1);
    opK = b.c.oqm;
    AppMethodBeat.o(45375);
  }
  
  private b(MagicBrushView paramMagicBrushView, final Context paramContext)
  {
    AppMethodBeat.i(283215);
    this.opN = new MediaSdk();
    this.opO = e.oqo;
    this.opP = null;
    this.opQ = null;
    this.opR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45337);
        if (b.a(b.this) == b.e.oqp)
        {
          Log.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
          b.i(b.this).uint();
          b.h(b.this);
          b.a(b.this, b.e.oqo);
          AppMethodBeat.o(45337);
          return;
        }
        Log.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
        AppMethodBeat.o(45337);
      }
    };
    this.opL = new MMHandler("wegame_screen_recorder_worker");
    if (opK != b.c.oql) {
      this.opM = new a.b(paramMagicBrushView);
    }
    this.opL.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45320);
        b.a(b.this, paramContext);
        AppMethodBeat.o(45320);
      }
    });
    AppMethodBeat.o(283215);
  }
  
  public static b a(String paramString, MagicBrushView paramMagicBrushView, Context paramContext)
  {
    AppMethodBeat.i(283217);
    if (Util.isNullOrNil(paramString))
    {
      paramString = new RuntimeException("Null or nil appid");
      AppMethodBeat.o(283217);
      throw paramString;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!opJ.containsKey(paramString)) {
      localObject1 = localObject2;
    }
    try
    {
      if (!opJ.containsKey(paramString))
      {
        localObject1 = new b(paramMagicBrushView, paramContext);
        opJ.put(paramString, localObject1);
      }
      paramMagicBrushView = (MagicBrushView)localObject1;
      if (localObject1 == null) {
        paramMagicBrushView = (b)opJ.get(paramString);
      }
      AppMethodBeat.o(283217);
      return paramMagicBrushView;
    }
    finally
    {
      AppMethodBeat.o(283217);
    }
  }
  
  public static b agF(String paramString)
  {
    AppMethodBeat.i(283219);
    if (!opJ.containsKey(paramString))
    {
      AppMethodBeat.o(283219);
      return null;
    }
    paramString = (b)opJ.get(paramString);
    if ((paramString == null) || ((paramString.opO != e.oqq) && (paramString.opO != e.oqr)))
    {
      AppMethodBeat.o(283219);
      return null;
    }
    AppMethodBeat.o(283219);
    return paramString;
  }
  
  public final void a(String paramString, d<b.a> paramd)
  {
    AppMethodBeat.i(283225);
    this.opL.postToWorker(new b.18(this, paramString, paramd));
    AppMethodBeat.o(283225);
  }
  
  public final void a(JSONObject paramJSONObject, d<JSONObject> paramd)
  {
    AppMethodBeat.i(283227);
    this.opL.postToWorker(new b.2(this, paramJSONObject, paramd));
    AppMethodBeat.o(283227);
  }
  
  public final void e(final d<String> paramd)
  {
    AppMethodBeat.i(45368);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
    this.opL.postToWorker(new Runnable()
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
        if (b.a(b.this) == b.e.oqr)
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
          paramd.a(2, 202, "already paused!", null);
          AppMethodBeat.o(45350);
          return;
        }
        b.a(b.this, b.e.oqr);
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
    this.opL.postToWorker(new Runnable()
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
        if (b.a(b.this) == b.e.oqq)
        {
          Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
          paramd.a(2, 302, "already running!", null);
          AppMethodBeat.o(45352);
          return;
        }
        b.a(b.this, b.e.oqq);
        b.c(b.this).c(new d() {});
        AppMethodBeat.o(45352);
      }
    });
    AppMethodBeat.o(45369);
  }
  
  public final void g(final d<f> paramd)
  {
    AppMethodBeat.i(283223);
    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger stop");
    this.opL.postToWorker(new Runnable()
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
    AppMethodBeat.o(283223);
  }
  
  public static abstract interface b
  {
    public abstract void Ho(long paramLong);
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(45365);
      oqo = new e("NotInit", 0);
      oqp = new e("Inited", 1);
      oqq = new e("Running", 2);
      oqr = new e("Paused", 3);
      oqs = new e[] { oqo, oqp, oqq, oqr };
      AppMethodBeat.o(45365);
    }
    
    private e() {}
  }
  
  public final class f
  {
    public c.a oqt;
    public c.a oqu;
    
    public f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b
 * JD-Core Version:    0.7.0.1
 */