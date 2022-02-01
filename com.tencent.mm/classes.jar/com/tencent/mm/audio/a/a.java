package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.ak.i.c;
import com.tencent.mm.ak.i.d;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bc.b;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.i
{
  private static String cUG = null;
  private boolean cQr;
  private boolean cQs;
  private boolean cQt;
  private d cQw;
  private boolean cUA;
  private int cUB;
  private boolean cUC;
  private i.c cUD;
  private i.d cUE;
  private String cUF;
  private com.tencent.mm.audio.a cUH;
  public i.b cUI;
  public i.a cUJ;
  private boolean cUz;
  private Context context;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.cQw = null;
    this.context = null;
    this.cUz = false;
    this.cUA = false;
    this.cUB = 0;
    this.cUC = true;
    this.cUF = null;
    this.cQr = true;
    this.cQs = true;
    this.cQt = false;
    this.cUI = null;
    if ((paramContext instanceof Activity)) {}
    for (Context localContext = ai.getContext();; localContext = paramContext)
    {
      this.context = localContext;
      this.cUB = paramInt;
      this.cUH = new com.tencent.mm.audio.a(paramContext, new a.1(this));
      new g.b();
      AppMethodBeat.o(148290);
      return;
    }
  }
  
  private void NV()
  {
    AppMethodBeat.i(148302);
    d.a local3 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(209452);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148284);
            try
            {
              if (ae.fJe.fDc == 1) {
                Thread.sleep(300L);
              }
              ac.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.f(a.this), Boolean.valueOf(a.g(a.this)) });
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(209451);
                  a.b(a.this).cm(a.b(a.this).cQv);
                  bc.b localb;
                  if (a.g(a.this))
                  {
                    Context localContext = a.h(a.this);
                    boolean bool = a.b(a.this).cQv;
                    bc.a local1 = new bc.a()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(209450);
                        ac.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          ac.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                          a.b(a.this).cn(a.i(a.this));
                          a.j(a.this);
                          ac.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                          ac.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        AppMethodBeat.o(209450);
                      }
                    };
                    if (bool)
                    {
                      localb = bc.b.Gtz;
                      bc.a(localContext, 2131761938, localb, local1);
                    }
                  }
                  for (;;)
                  {
                    if (a.f(a.this) == null) {
                      break label321;
                    }
                    ac.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                    a.f(a.this).onCompletion();
                    AppMethodBeat.o(209451);
                    return;
                    localb = bc.b.GtA;
                    break;
                    ac.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      ac.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                      ac.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                      a.b(a.this).cn(a.i(a.this));
                      a.j(a.this);
                      ac.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                  }
                  label321:
                  ac.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                  AppMethodBeat.o(209451);
                }
              });
              AppMethodBeat.o(148284);
              return;
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bs.m(localException) });
              AppMethodBeat.o(148284);
            }
          }
        }, "SceneVoice_onCompletion");
        AppMethodBeat.o(209452);
      }
    };
    if (this.cQw != null) {
      this.cQw.a(local3);
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
        AppMethodBeat.i(209449);
        com.tencent.mm.audio.a locala = a.b(a.this);
        locala.bCr();
        if (locala.cQt)
        {
          com.tencent.mm.compatible.util.b localb = locala.cQq;
          if (localb != null) {
            localb.YC();
          }
          locala.cQt = false;
        }
        ac.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        if (a.e(a.this) != null) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209448);
              a.e(a.this).onError();
              AppMethodBeat.o(209448);
            }
          });
        }
        AppMethodBeat.o(209449);
      }
    };
    if (this.cQw != null) {
      this.cQw.a(local2);
    }
    AppMethodBeat.o(148301);
  }
  
  public final boolean MZ()
  {
    AppMethodBeat.i(148305);
    if (this.cQw == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.cQw.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final boolean NU()
  {
    return this.cUz;
  }
  
  public final double NW()
  {
    AppMethodBeat.i(148303);
    if (this.cQw == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.cQw.NW();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final void a(i.a parama)
  {
    this.cUJ = parama;
  }
  
  public final void a(i.b paramb)
  {
    this.cUI = paramb;
  }
  
  public final void a(i.c paramc)
  {
    this.cUD = paramc;
  }
  
  public final void a(i.d paramd)
  {
    this.cUE = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    ac.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.cUB) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (com.tencent.mm.vfs.i.eA(paramString)) {
        break;
      }
      ac.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.f(paramString, this.cUB, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.cQw = new u(this.context);
        if (this.cQw == null) {
          break label369;
        }
        ac.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.cUH.cQw = this.cQw;
      }
    }
    for (;;)
    {
      this.cUH.Ms();
      this.cUH.cl(paramBoolean);
      this.cUH.ih(this.cUH.cQv);
      NV();
      setError();
      this.cUH.t(paramString, paramInt2);
      ac.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.cQr) });
      AppMethodBeat.o(148293);
      return true;
      this.cQw = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.cQw = new l(this.context);
          break;
        }
        this.cQw = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.cQw = new k(this.context);
        break;
      }
      this.cQw = new k();
      break;
      label369:
      ac.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    ac.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.cUB) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      cUG = this.cUF;
      this.cUF = paramString;
      if (!paramBoolean2) {
        break label136;
      }
      str = paramString;
      label87:
      if (com.tencent.mm.vfs.i.eA(str)) {
        break label154;
      }
      if (!paramBoolean2) {
        break label145;
      }
    }
    label136:
    label145:
    for (String str = paramString;; str = s.getFullPath(paramString))
    {
      ac.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      AppMethodBeat.o(148292);
      return false;
      bool = false;
      break;
      str = s.getFullPath(paramString);
      break label87;
    }
    label154:
    int i = paramInt;
    if (paramInt == -1) {
      i = q.f(paramString, this.cUB, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.cQw = new u(this.context);
        if (this.cQw == null) {
          break label475;
        }
        ac.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.cUH.cQw = this.cQw;
        label241:
        this.cUH.Ms();
        this.cUH.cl(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.bCs()) || (com.tencent.mm.plugin.audio.c.a.bCy()))
        {
          ac.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bCs()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bCy()) });
          this.cUH.cl(false);
        }
        this.cUH.ih(this.cUH.cQv);
        NV();
        setError();
        if (!paramBoolean2) {
          break label500;
        }
      }
    }
    for (;;)
    {
      this.cUH.t(paramString, 0);
      ac.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.cQr) });
      AppMethodBeat.o(148292);
      return true;
      this.cQw = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.cQw = new l(this.context);
          break;
        }
        this.cQw = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.cQw = new k(this.context);
        break;
      }
      this.cQw = new k();
      break;
      label475:
      ac.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label241;
      label500:
      if (this.cUB == 0) {
        paramString = s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final boolean bF(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.cQw == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    ac.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.cUH.co(paramBoolean);
    if ((bool) && (this.cUD != null)) {
      this.cUD.eA(paramBoolean);
    }
    ac.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.cQr), Boolean.valueOf(this.cQt) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.cUH.cm(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void cp(boolean paramBoolean)
  {
    this.cQr = paramBoolean;
  }
  
  public final void cq(boolean paramBoolean)
  {
    this.cQs = paramBoolean;
  }
  
  public final void cr(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    ac.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cUA = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.cQw == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.cQw.isPlaying();
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
    AppMethodBeat.i(210499);
    boolean bool = bF(true);
    AppMethodBeat.o(210499);
    return bool;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.cQw == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    ac.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.cUH.Mt();
    ac.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.cQr), Boolean.valueOf(this.cQt) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(210500);
    stop(false);
    AppMethodBeat.o(210500);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.cQw == null)
    {
      ac.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.cQw.Fb();
    this.cQw.a(null);
    ac.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.cQr), Boolean.valueOf(this.cQt), Boolean.valueOf(this.cQs) });
    this.cUH.Mu();
    if ((!paramBoolean) && (this.cUE != null)) {
      this.cUE.onStop();
    }
    AppMethodBeat.o(148299);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(209453);
    this.cUH.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    a.a.So("music");
    AppMethodBeat.o(209453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */