package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.be.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import junit.framework.Assert;

public final class a
  implements h
{
  private static String dgY = null;
  private Context context;
  private boolean dcJ;
  private boolean dcK;
  private boolean dcL;
  private d dcO;
  private boolean dgR;
  private boolean dgS;
  private int dgT;
  private boolean dgU;
  private h.c dgV;
  private h.d dgW;
  private String dgX;
  private com.tencent.mm.audio.a dgZ;
  public h.b dha;
  public h.a dhb;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.dcO = null;
    this.context = null;
    this.dgR = false;
    this.dgS = false;
    this.dgT = 0;
    this.dgU = true;
    this.dgX = null;
    this.dcJ = true;
    this.dcK = true;
    this.dcL = false;
    this.dha = null;
    if ((paramContext instanceof Activity)) {}
    for (Context localContext = ak.getContext();; localContext = paramContext)
    {
      this.context = localContext;
      this.dgT = paramInt;
      this.dgZ = new com.tencent.mm.audio.a(paramContext, new a.1(this));
      new g.b();
      AppMethodBeat.o(148290);
      return;
    }
  }
  
  private void PD()
  {
    AppMethodBeat.i(148302);
    d.a local3 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(200147);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148284);
            try
            {
              if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYw == 1) {
                Thread.sleep(300L);
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.f(a.this), Boolean.valueOf(a.g(a.this)) });
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(200146);
                  a.b(a.this).cn(a.b(a.this).dcN);
                  be.b localb;
                  if (a.g(a.this))
                  {
                    Context localContext = a.h(a.this);
                    boolean bool = a.b(a.this).dcN;
                    be.a local1 = new be.a()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(200145);
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                          a.b(a.this).co(a.i(a.this));
                          a.j(a.this);
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        AppMethodBeat.o(200145);
                      }
                    };
                    if (bool)
                    {
                      localb = be.b.Izz;
                      be.a(localContext, 2131761938, localb, local1);
                    }
                  }
                  for (;;)
                  {
                    if (a.f(a.this) == null) {
                      break label321;
                    }
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                    a.f(a.this).onCompletion();
                    AppMethodBeat.o(200146);
                    return;
                    localb = be.b.IzA;
                    break;
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                      a.b(a.this).co(a.i(a.this));
                      a.j(a.this);
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                  }
                  label321:
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                  AppMethodBeat.o(200146);
                }
              });
              AppMethodBeat.o(148284);
              return;
            }
            catch (Exception localException)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bu.o(localException) });
              AppMethodBeat.o(148284);
            }
          }
        }, "SceneVoice_onCompletion");
        AppMethodBeat.o(200147);
      }
    };
    if (this.dcO != null) {
      this.dcO.a(local3);
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
        AppMethodBeat.i(200144);
        com.tencent.mm.audio.a locala = a.b(a.this);
        locala.bHs();
        if (locala.dcL)
        {
          com.tencent.mm.compatible.util.b localb = locala.dcI;
          if (localb != null) {
            localb.abn();
          }
          locala.dcL = false;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        if (a.e(a.this) != null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200143);
              a.e(a.this).onError();
              AppMethodBeat.o(200143);
            }
          });
        }
        AppMethodBeat.o(200144);
      }
    };
    if (this.dcO != null) {
      this.dcO.a(local2);
    }
    AppMethodBeat.o(148301);
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(148305);
    if (this.dcO == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.dcO.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final boolean PC()
  {
    return this.dgR;
  }
  
  public final double PE()
  {
    AppMethodBeat.i(148303);
    if (this.dcO == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.dcO.PE();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final void a(h.a parama)
  {
    this.dhb = parama;
  }
  
  public final void a(h.b paramb)
  {
    this.dha = paramb;
  }
  
  public final void a(h.c paramc)
  {
    this.dgV = paramc;
  }
  
  public final void a(h.d paramd)
  {
    this.dgW = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.dgT) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (o.fB(paramString)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.f(paramString, this.dgT, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.dcO = new u(this.context);
        if (this.dcO == null) {
          break label369;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.dgZ.dcO = this.dcO;
      }
    }
    for (;;)
    {
      this.dgZ.NZ();
      this.dgZ.cm(paramBoolean);
      this.dgZ.io(this.dgZ.dcN);
      PD();
      setError();
      this.dgZ.w(paramString, paramInt2);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.dcJ) });
      AppMethodBeat.o(148293);
      return true;
      this.dcO = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.dcO = new l(this.context);
          break;
        }
        this.dcO = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.dcO = new k(this.context);
        break;
      }
      this.dcO = new k();
      break;
      label369:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.dgT) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      dgY = this.dgX;
      this.dgX = paramString;
      if (!paramBoolean2) {
        break label136;
      }
      str = paramString;
      label87:
      if (o.fB(str)) {
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
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
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
      i = q.f(paramString, this.dgT, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.dcO = new u(this.context);
        if (this.dcO == null) {
          break label475;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.dgZ.dcO = this.dcO;
        label241:
        this.dgZ.NZ();
        this.dgZ.cm(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.bHt()) || (com.tencent.mm.plugin.audio.c.a.bHz()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bHt()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bHz()) });
          this.dgZ.cm(false);
        }
        this.dgZ.io(this.dgZ.dcN);
        PD();
        setError();
        if (!paramBoolean2) {
          break label500;
        }
      }
    }
    for (;;)
    {
      this.dgZ.w(paramString, 0);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.dcJ) });
      AppMethodBeat.o(148292);
      return true;
      this.dcO = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.dcO = new l(this.context);
          break;
        }
        this.dcO = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.dcO = new k(this.context);
        break;
      }
      this.dcO = new k();
      break;
      label475:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label241;
      label500:
      if (this.dgT == 0) {
        paramString = s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.dgZ.cn(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void cq(boolean paramBoolean)
  {
    this.dcJ = paramBoolean;
  }
  
  public final void cr(boolean paramBoolean)
  {
    this.dcK = paramBoolean;
  }
  
  public final boolean cs(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.dcO == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.dgZ.cp(paramBoolean);
    if ((bool) && (this.dgV != null)) {
      this.dgV.eE(paramBoolean);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.dcJ), Boolean.valueOf(this.dcL) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void ct(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.dgS = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.dcO == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.dcO.isPlaying();
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
    AppMethodBeat.i(224397);
    boolean bool = cs(true);
    AppMethodBeat.o(224397);
    return bool;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.dcO == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.dgZ.Oa();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.dcJ), Boolean.valueOf(this.dcL) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(224398);
    stop(false);
    AppMethodBeat.o(224398);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.dcO == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.dcO.GB();
    this.dcO.a(null);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.dcJ), Boolean.valueOf(this.dcL), Boolean.valueOf(this.dcK) });
    this.dgZ.Ob();
    if ((!paramBoolean) && (this.dgW != null)) {
      this.dgW.onStop();
    }
    AppMethodBeat.o(148299);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(200148);
    this.dgZ.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    a.a.Wy("music");
    AppMethodBeat.o(200148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */