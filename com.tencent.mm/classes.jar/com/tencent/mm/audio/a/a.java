package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.an.k.c;
import com.tencent.mm.an.k.d;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.e.a.f;
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
  implements com.tencent.mm.an.k
{
  private static String fqW = null;
  private Context context;
  private boolean fmi;
  private boolean fmj;
  private boolean fmk;
  private d fmn;
  private boolean fqP;
  private boolean fqQ;
  private int fqR;
  private boolean fqS;
  private k.c fqT;
  private k.d fqU;
  private String fqV;
  private com.tencent.mm.audio.a fqX;
  private boolean fqY;
  private HandlerThread fqZ;
  private MMHandler fra;
  public k.b frb;
  public k.a frc;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.fmn = null;
    this.context = null;
    this.fqP = false;
    this.fqQ = false;
    this.fqR = 0;
    this.fqS = true;
    this.fqV = null;
    this.fmi = true;
    this.fmj = true;
    this.fmk = false;
    this.fqZ = null;
    this.fra = null;
    this.frb = null;
    Context localContext;
    if ((paramContext instanceof Activity))
    {
      localContext = MMApplicationContext.getContext();
      this.context = localContext;
      this.fqR = paramInt;
      this.fqX = new com.tencent.mm.audio.a(paramContext, new a.1(this));
      new g.b();
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZO, 0) != 1) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      this.fqY = bool;
      Log.i("MicroMsg.SceneVoicePlayer", "asyncDoVoiceCompleteAction:%s", new Object[] { Boolean.valueOf(this.fqY) });
      AppMethodBeat.o(148290);
      return;
      localContext = paramContext;
      break;
    }
  }
  
  private void aeG()
  {
    AppMethodBeat.i(148301);
    d.b local2 = new d.b()
    {
      public final void onError()
      {
        AppMethodBeat.i(227719);
        com.tencent.mm.audio.a locala = a.b(a.this);
        locala.crg();
        if (locala.fmk)
        {
          com.tencent.mm.compatible.util.b localb = locala.fmh;
          if (localb != null) {
            localb.avz();
          }
          locala.fmk = false;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        if (a.e(a.this) != null) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(227569);
              a.e(a.this).onError();
              AppMethodBeat.o(227569);
            }
          });
        }
        AppMethodBeat.o(227719);
      }
    };
    if (this.fmn != null) {
      this.fmn.a(local2);
    }
    AppMethodBeat.o(148301);
  }
  
  private void aeH()
  {
    AppMethodBeat.i(148302);
    d.a local3 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(226398);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148284);
            try
            {
              if (af.juI.jnT == 1) {
                Thread.sleep(300L);
              }
              Log.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.f(a.this), Boolean.valueOf(a.g(a.this)) });
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(227249);
                  a.b(a.this).ds(a.b(a.this).fmm);
                  if (a.g(a.this)) {
                    PlaySound.play(a.h(a.this), a.f.play_completed, a.b(a.this).fmm, false, new PlaySound.OnPlayCompletionListener()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(229255);
                        Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                          a.b(a.this).dt(a.i(a.this));
                          a.j(a.this);
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                          Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        a.k(a.this);
                        AppMethodBeat.o(229255);
                      }
                    });
                  }
                  for (;;)
                  {
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(228176);
                        if (a.f(a.this) != null)
                        {
                          Log.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                          a.f(a.this).onCompletion();
                          AppMethodBeat.o(228176);
                          return;
                        }
                        Log.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                        AppMethodBeat.o(228176);
                      }
                    });
                    AppMethodBeat.o(227249);
                    return;
                    Log.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                      Log.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                      a.b(a.this).dt(a.i(a.this));
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
        AppMethodBeat.o(226398);
      }
    };
    if (this.fmn != null) {
      this.fmn.a(local3);
    }
    AppMethodBeat.o(148302);
  }
  
  public final void a(k.a parama)
  {
    this.frc = parama;
  }
  
  public final void a(k.b paramb)
  {
    this.frb = paramb;
  }
  
  public final void a(k.c paramc)
  {
    this.fqT = paramc;
  }
  
  public final void a(k.d paramd)
  {
    this.fqU = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.fqR) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (com.tencent.mm.vfs.u.agG(paramString)) {
        break;
      }
      Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.k(paramString, this.fqR, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.fmn = new com.tencent.mm.modelvoice.u(this.context);
        if (this.fmn == null) {
          break label372;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.fqX.fmn = this.fmn;
      }
    }
    for (;;)
    {
      this.fqX.acR();
      this.fqX.dr(paramBoolean);
      this.fqX.kA(this.fqX.fmm);
      aeH();
      aeG();
      this.fqX.P(paramString, paramInt2);
      Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.fmi) });
      AppMethodBeat.o(148293);
      return true;
      this.fmn = new com.tencent.mm.modelvoice.u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.fmn = new l(this.context);
          break;
        }
        this.fmn = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.fmn = new com.tencent.mm.modelvoice.k(this.context);
        break;
      }
      this.fmn = new com.tencent.mm.modelvoice.k();
      break;
      label372:
      Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    Log.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.fqR) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      fqW = this.fqV;
      this.fqV = paramString;
      if (!paramBoolean2) {
        break label137;
      }
      str = paramString;
      label87:
      if (com.tencent.mm.vfs.u.agG(str)) {
        break label155;
      }
      if (!paramBoolean2) {
        break label146;
      }
    }
    label137:
    label146:
    for (String str = paramString;; str = s.getFullPath(paramString))
    {
      Log.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      AppMethodBeat.o(148292);
      return false;
      bool = false;
      break;
      str = s.getFullPath(paramString);
      break label87;
    }
    label155:
    int i = paramInt;
    if (paramInt == -1) {
      i = q.k(paramString, this.fqR, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.fmn = new com.tencent.mm.modelvoice.u(this.context);
        if (this.fmn == null) {
          break label478;
        }
        Log.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.fqX.fmn = this.fmn;
        label243:
        this.fqX.acR();
        this.fqX.dr(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.crh()) || (com.tencent.mm.plugin.audio.c.a.cro()))
        {
          Log.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.crh()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cro()) });
          this.fqX.dr(false);
        }
        this.fqX.kA(this.fqX.fmm);
        aeH();
        aeG();
        if (!paramBoolean2) {
          break label503;
        }
      }
    }
    for (;;)
    {
      this.fqX.P(paramString, 0);
      Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.fmi) });
      AppMethodBeat.o(148292);
      return true;
      this.fmn = new com.tencent.mm.modelvoice.u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.fmn = new l(this.context);
          break;
        }
        this.fmn = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.fmn = new com.tencent.mm.modelvoice.k(this.context);
        break;
      }
      this.fmn = new com.tencent.mm.modelvoice.k();
      break;
      label478:
      Log.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label243;
      label503:
      if (this.fqR == 0) {
        paramString = s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final boolean adH()
  {
    AppMethodBeat.i(148305);
    if (this.fmn == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.fmn.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final double aeI()
  {
    AppMethodBeat.i(148303);
    if (this.fmn == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.fmn.aeI();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final boolean dA(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.fmn == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    Log.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.fqX.du(paramBoolean);
    if ((bool) && (this.fqT != null)) {
      this.fqT.gh(paramBoolean);
    }
    Log.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.fmi), Boolean.valueOf(this.fmk) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void dB(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    Log.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fqQ = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final void dr(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.fqX.ds(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void dy(boolean paramBoolean)
  {
    this.fmi = paramBoolean;
  }
  
  public final void dz(boolean paramBoolean)
  {
    this.fmj = paramBoolean;
  }
  
  public final boolean isCalling()
  {
    return this.fqP;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.fmn == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.fmn.isPlaying();
    AppMethodBeat.o(148291);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(292912);
    boolean bool = dA(true);
    AppMethodBeat.o(292912);
    return bool;
  }
  
  public final boolean q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(148297);
    paramBoolean = a(paramString, paramBoolean, false, -1);
    AppMethodBeat.o(148297);
    return paramBoolean;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.fmn == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    Log.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.fqX.acS();
    Log.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.fmi), Boolean.valueOf(this.fmk) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(292913);
    stop(false);
    AppMethodBeat.o(292913);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.fmn == null)
    {
      Log.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.fmn.TV();
    this.fmn.a(null);
    Log.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.fmi), Boolean.valueOf(this.fmk), Boolean.valueOf(this.fmj) });
    this.fqX.acT();
    if ((!paramBoolean) && (this.fqU != null)) {
      this.fqU.onStop();
    }
    AppMethodBeat.o(148299);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(228721);
    this.fqX.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.anX("music");
    AppMethodBeat.o(228721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */