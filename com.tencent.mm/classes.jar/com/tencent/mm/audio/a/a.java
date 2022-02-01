package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.i.a;
import com.tencent.mm.al.i.b;
import com.tencent.mm.al.i.c;
import com.tencent.mm.al.i.d;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bd.b;
import com.tencent.mm.sdk.platformtools.bt;
import d.y;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.al.i
{
  private static String cXk = null;
  private boolean cSU;
  private boolean cSV;
  private boolean cSW;
  private d cSZ;
  private boolean cXd;
  private boolean cXe;
  private int cXf;
  private boolean cXg;
  private i.c cXh;
  private i.d cXi;
  private String cXj;
  private com.tencent.mm.audio.a cXl;
  public i.b cXm;
  public i.a cXn;
  private Context context;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.cSZ = null;
    this.context = null;
    this.cXd = false;
    this.cXe = false;
    this.cXf = 0;
    this.cXg = true;
    this.cXj = null;
    this.cSU = true;
    this.cSV = true;
    this.cSW = false;
    this.cXm = null;
    if ((paramContext instanceof Activity)) {}
    for (Context localContext = aj.getContext();; localContext = paramContext)
    {
      this.context = localContext;
      this.cXf = paramInt;
      this.cXl = new com.tencent.mm.audio.a(paramContext, new d.g.a.b() {});
      new g.b();
      AppMethodBeat.o(148290);
      return;
    }
  }
  
  private void NZ()
  {
    AppMethodBeat.i(148302);
    d.a local3 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(189910);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148284);
            try
            {
              if (ae.fFx.fzv == 1) {
                Thread.sleep(300L);
              }
              ad.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.f(a.this), Boolean.valueOf(a.g(a.this)) });
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(189909);
                  a.b(a.this).ck(a.b(a.this).cSY);
                  bd.b localb;
                  if (a.g(a.this))
                  {
                    Context localContext = a.h(a.this);
                    boolean bool = a.b(a.this).cSY;
                    bd.a local1 = new bd.a()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(189908);
                        ad.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                          a.b(a.this).cl(a.i(a.this));
                          a.j(a.this);
                          ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                          ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        AppMethodBeat.o(189908);
                      }
                    };
                    if (bool)
                    {
                      localb = bd.b.EWn;
                      bd.a(localContext, 2131761938, localb, local1);
                    }
                  }
                  for (;;)
                  {
                    if (a.f(a.this) == null) {
                      break label321;
                    }
                    ad.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                    a.f(a.this).onCompletion();
                    AppMethodBeat.o(189909);
                    return;
                    localb = bd.b.EWo;
                    break;
                    ad.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                      ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                      a.b(a.this).cl(a.i(a.this));
                      a.j(a.this);
                      ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                  }
                  label321:
                  ad.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                  AppMethodBeat.o(189909);
                }
              });
              AppMethodBeat.o(148284);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bt.m(localException) });
              AppMethodBeat.o(148284);
            }
          }
        }, "SceneVoice_onCompletion");
        AppMethodBeat.o(189910);
      }
    };
    if (this.cSZ != null) {
      this.cSZ.a(local3);
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
        AppMethodBeat.i(189907);
        com.tencent.mm.audio.a locala = a.b(a.this);
        locala.bvv();
        if (locala.cSW)
        {
          com.tencent.mm.compatible.util.b localb = locala.cST;
          if (localb != null) {
            localb.XF();
          }
          locala.cSW = false;
        }
        ad.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        if (a.e(a.this) != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(189906);
              a.e(a.this).onError();
              AppMethodBeat.o(189906);
            }
          });
        }
        AppMethodBeat.o(189907);
      }
    };
    if (this.cSZ != null) {
      this.cSZ.a(local2);
    }
    AppMethodBeat.o(148301);
  }
  
  public final void NX()
  {
    AppMethodBeat.i(189911);
    this.cXl.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    a.a.Oe("music");
    AppMethodBeat.o(189911);
  }
  
  public final boolean NY()
  {
    return this.cXd;
  }
  
  public final boolean Nb()
  {
    AppMethodBeat.i(148305);
    if (this.cSZ == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.cSZ.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final double Oa()
  {
    AppMethodBeat.i(148303);
    if (this.cSZ == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.cSZ.Oa();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final void a(i.a parama)
  {
    this.cXn = parama;
  }
  
  public final void a(i.b paramb)
  {
    this.cXm = paramb;
  }
  
  public final void a(i.c paramc)
  {
    this.cXh = paramc;
  }
  
  public final void a(i.d paramd)
  {
    this.cXi = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    ad.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.cXf) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (com.tencent.mm.vfs.i.eK(paramString)) {
        break;
      }
      ad.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.f(paramString, this.cXf, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.cSZ = new u(this.context);
        if (this.cSZ == null) {
          break label370;
        }
        ad.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.cXl.cSZ = this.cSZ;
      }
    }
    for (;;)
    {
      this.cXl.Mu();
      this.cXl.cj(paramBoolean);
      this.cXl.hJ(this.cXl.cSY);
      NZ();
      setError();
      this.cXl.t(paramString, paramInt2);
      ad.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.cSU) });
      AppMethodBeat.o(148293);
      return true;
      this.cSZ = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.cSZ = new l(this.context);
          break;
        }
        this.cSZ = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.cSZ = new k(this.context);
        break;
      }
      this.cSZ = new k();
      break;
      label370:
      ad.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    ad.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.cXf) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      cXk = this.cXj;
      this.cXj = paramString;
      if (!paramBoolean2) {
        break label136;
      }
      str = paramString;
      label87:
      if (com.tencent.mm.vfs.i.eK(str)) {
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
      ad.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
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
      i = q.f(paramString, this.cXf, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.cSZ = new u(this.context);
        if (this.cSZ == null) {
          break label476;
        }
        ad.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.cXl.cSZ = this.cSZ;
        label241:
        this.cXl.Mu();
        this.cXl.cj(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.bvw()) || (com.tencent.mm.plugin.audio.c.a.bvC()))
        {
          ad.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bvw()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bvC()) });
          this.cXl.cj(false);
        }
        this.cXl.hJ(this.cXl.cSY);
        NZ();
        setError();
        if (!paramBoolean2) {
          break label501;
        }
      }
    }
    for (;;)
    {
      this.cXl.t(paramString, 0);
      ad.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.cSU) });
      AppMethodBeat.o(148292);
      return true;
      this.cSZ = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.cSZ = new l(this.context);
          break;
        }
        this.cSZ = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.cSZ = new k(this.context);
        break;
      }
      this.cSZ = new k();
      break;
      label476:
      ad.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label241;
      label501:
      if (this.cXf == 0) {
        paramString = s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final void cj(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.cXl.ck(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void cn(boolean paramBoolean)
  {
    this.cSU = paramBoolean;
  }
  
  public final void co(boolean paramBoolean)
  {
    this.cSV = paramBoolean;
  }
  
  public final boolean cp(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.cSZ == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    ad.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.cXl.cm(paramBoolean);
    if ((bool) && (this.cXh != null)) {
      this.cXh.ef(paramBoolean);
    }
    ad.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.cSU), Boolean.valueOf(this.cSW) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void cq(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    ad.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cXe = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.cSZ == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.cSZ.isPlaying();
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
    AppMethodBeat.i(205920);
    boolean bool = cp(true);
    AppMethodBeat.o(205920);
    return bool;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.cSZ == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    ad.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.cXl.Mv();
    ad.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.cSU), Boolean.valueOf(this.cSW) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(205921);
    stop(false);
    AppMethodBeat.o(205921);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.cSZ == null)
    {
      ad.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.cSZ.Ft();
    this.cSZ.a(null);
    ad.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.cSU), Boolean.valueOf(this.cSW), Boolean.valueOf(this.cSV) });
    this.cXl.Mw();
    if ((!paramBoolean) && (this.cXi != null)) {
      this.cXi.onStop();
    }
    AppMethodBeat.o(148299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */