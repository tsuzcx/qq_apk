package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.ak.k.c;
import com.tencent.mm.ak.k.d;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.k
{
  private static String dyh = null;
  private Context context;
  private boolean dtA;
  private boolean dtB;
  private boolean dtC;
  private d dtF;
  private boolean dya;
  private boolean dyb;
  private int dyc;
  private boolean dyd;
  private k.c dye;
  private k.d dyf;
  private String dyg;
  private com.tencent.mm.audio.a dyi;
  private boolean dyj;
  private HandlerThread dyk;
  private MMHandler dyl;
  public k.b dym;
  public k.a dyn;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.dtF = null;
    this.context = null;
    this.dya = false;
    this.dyb = false;
    this.dyc = 0;
    this.dyd = true;
    this.dyg = null;
    this.dtA = true;
    this.dtB = true;
    this.dtC = false;
    this.dyk = null;
    this.dyl = null;
    this.dym = null;
    Context localContext;
    if ((paramContext instanceof Activity))
    {
      localContext = MMApplicationContext.getContext();
      this.context = localContext;
      this.dyc = paramInt;
      this.dyi = new com.tencent.mm.audio.a(paramContext, new a.1(this));
      new g.b();
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sop, 0) != 1) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      this.dyj = bool;
      Log.i("MicroMsg.SceneVoicePlayer", "asyncDoVoiceCompleteAction:%s", new Object[] { Boolean.valueOf(this.dyj) });
      AppMethodBeat.o(148290);
      return;
      localContext = paramContext;
      break;
    }
  }
  
  private void ZX()
  {
    AppMethodBeat.i(148302);
    d.a local3 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(187318);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148284);
            try
            {
              if (ae.gKu.gDJ == 1) {
                Thread.sleep(300L);
              }
              Log.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.f(a.this), Boolean.valueOf(a.g(a.this)) });
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(187317);
                  a.b(a.this).cV(a.b(a.this).dtE);
                  if (a.g(a.this)) {
                    PlaySound.play(a.h(a.this), 2131763944, a.b(a.this).dtE, false, new PlaySound.OnPlayCompletionListener()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(187315);
                        Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                          a.b(a.this).cW(a.i(a.this));
                          a.j(a.this);
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        a.k(a.this);
                        AppMethodBeat.o(187315);
                      }
                    });
                  }
                  for (;;)
                  {
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(187316);
                        if (a.f(a.this) != null)
                        {
                          Log.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                          a.f(a.this).onCompletion();
                          AppMethodBeat.o(187316);
                          return;
                        }
                        Log.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                        AppMethodBeat.o(187316);
                      }
                    });
                    AppMethodBeat.o(187317);
                    return;
                    Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                      a.b(a.this).cW(a.i(a.this));
                      a.j(a.this);
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                    a.k(a.this);
                  }
                }
              };
              if (!a.l(a.this))
              {
                Log.i("MicroMsg.SceneVoicePlayer", "sync do voice complete action");
                MMHandlerThread.postToMainThread(local1);
                AppMethodBeat.o(148284);
                return;
              }
              Log.i("MicroMsg.SceneVoicePlayer", "async do voice complete action");
              a.m(a.this);
              a.n(a.this).post(local1);
              AppMethodBeat.o(148284);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
              AppMethodBeat.o(148284);
            }
          }
        }, "SceneVoice_onCompletion");
        AppMethodBeat.o(187318);
      }
    };
    if (this.dtF != null) {
      this.dtF.a(local3);
    }
    AppMethodBeat.o(148302);
  }
  
  private void setError()
  {
    AppMethodBeat.i(148301);
    d.b local2 = new d.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(187314);
        com.tencent.mm.audio.a locala = a.b(a.this);
        locala.cdV();
        if (locala.dtC)
        {
          com.tencent.mm.compatible.util.b localb = locala.dtz;
          if (localb != null) {
            localb.apm();
          }
          locala.dtC = false;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        if (a.e(a.this) != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187313);
              a.e(a.this).onError();
              AppMethodBeat.o(187313);
            }
          });
        }
        AppMethodBeat.o(187314);
      }
    };
    if (this.dtF != null) {
      this.dtF.a(local2);
    }
    AppMethodBeat.o(148301);
  }
  
  public final boolean YY()
  {
    AppMethodBeat.i(148305);
    if (this.dtF == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.dtF.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final double ZY()
  {
    AppMethodBeat.i(148303);
    if (this.dtF == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.dtF.ZY();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final void a(k.a parama)
  {
    this.dyn = parama;
  }
  
  public final void a(k.b paramb)
  {
    this.dym = paramb;
  }
  
  public final void a(k.c paramc)
  {
    this.dye = paramc;
  }
  
  public final void a(k.d paramd)
  {
    this.dyf = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.dyc) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (com.tencent.mm.vfs.s.YS(paramString)) {
        break;
      }
      Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.g(paramString, this.dyc, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.dtF = new u(this.context);
        if (this.dtF == null) {
          break label372;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.dyi.dtF = this.dtF;
      }
    }
    for (;;)
    {
      this.dyi.Yl();
      this.dyi.cU(paramBoolean);
      this.dyi.jp(this.dyi.dtE);
      ZX();
      setError();
      this.dyi.x(paramString, paramInt2);
      Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.dtA) });
      AppMethodBeat.o(148293);
      return true;
      this.dtF = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.dtF = new l(this.context);
          break;
        }
        this.dtF = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.dtF = new com.tencent.mm.modelvoice.k(this.context);
        break;
      }
      this.dtF = new com.tencent.mm.modelvoice.k();
      break;
      label372:
      Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.dyc) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      dyh = this.dyg;
      this.dyg = paramString;
      if (!paramBoolean2) {
        break label137;
      }
      str = paramString;
      label87:
      if (com.tencent.mm.vfs.s.YS(str)) {
        break label155;
      }
      if (!paramBoolean2) {
        break label146;
      }
    }
    label137:
    label146:
    for (String str = paramString;; str = com.tencent.mm.modelvoice.s.getFullPath(paramString))
    {
      Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      AppMethodBeat.o(148292);
      return false;
      bool = false;
      break;
      str = com.tencent.mm.modelvoice.s.getFullPath(paramString);
      break label87;
    }
    label155:
    int i = paramInt;
    if (paramInt == -1) {
      i = q.g(paramString, this.dyc, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.dtF = new u(this.context);
        if (this.dtF == null) {
          break label478;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.dyi.dtF = this.dtF;
        label243:
        this.dyi.Yl();
        this.dyi.cU(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.cdW()) || (com.tencent.mm.plugin.audio.c.a.ceb()))
        {
          Log.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cdW()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.ceb()) });
          this.dyi.cU(false);
        }
        this.dyi.jp(this.dyi.dtE);
        ZX();
        setError();
        if (!paramBoolean2) {
          break label503;
        }
      }
    }
    for (;;)
    {
      this.dyi.x(paramString, 0);
      Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.dtA) });
      AppMethodBeat.o(148292);
      return true;
      this.dtF = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.dtF = new l(this.context);
          break;
        }
        this.dtF = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.dtF = new com.tencent.mm.modelvoice.k(this.context);
        break;
      }
      this.dtF = new com.tencent.mm.modelvoice.k();
      break;
      label478:
      Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label243;
      label503:
      if (this.dyc == 0) {
        paramString = com.tencent.mm.modelvoice.s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.dyi.cV(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void cY(boolean paramBoolean)
  {
    this.dtA = paramBoolean;
  }
  
  public final void cZ(boolean paramBoolean)
  {
    this.dtB = paramBoolean;
  }
  
  public final boolean da(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.dtF == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    Log.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.dyi.cX(paramBoolean);
    if ((bool) && (this.dye != null)) {
      this.dye.fw(paramBoolean);
    }
    Log.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.dtA), Boolean.valueOf(this.dtC) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void db(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    Log.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.dyb = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final boolean isCalling()
  {
    return this.dya;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.dtF == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.dtF.isPlaying();
    AppMethodBeat.o(148291);
    return bool;
  }
  
  public final boolean n(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148297);
    paramBoolean = a(paramString, paramBoolean, false, -1);
    AppMethodBeat.o(148297);
    return paramBoolean;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(258701);
    boolean bool = da(true);
    AppMethodBeat.o(258701);
    return bool;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.dtF == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    Log.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.dyi.Ym();
    Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.dtA), Boolean.valueOf(this.dtC) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(258702);
    stop(false);
    AppMethodBeat.o(258702);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.dtF == null)
    {
      Log.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.dtF.Qt();
    this.dtF.a(null);
    Log.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.dtA), Boolean.valueOf(this.dtC), Boolean.valueOf(this.dtB) });
    this.dyi.Yn();
    if ((!paramBoolean) && (this.dyf != null)) {
      this.dyf.onStop();
    }
    AppMethodBeat.o(148299);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(187319);
    this.dyi.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    a.a.agt("music");
    AppMethodBeat.o(187319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */