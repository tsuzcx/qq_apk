package com.tencent.mm.audio.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.al.h.c;
import com.tencent.mm.al.h.d;
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
import com.tencent.mm.vfs.i;
import junit.framework.Assert;

public final class a
  implements h
{
  private static String dfW = null;
  private Context context;
  private boolean dbH;
  private boolean dbI;
  private boolean dbJ;
  private d dbM;
  private boolean dfP;
  private boolean dfQ;
  private int dfR;
  private boolean dfS;
  private h.c dfT;
  private h.d dfU;
  private String dfV;
  private com.tencent.mm.audio.a dfX;
  public h.b dfY;
  public h.a dfZ;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(148290);
    this.dbM = null;
    this.context = null;
    this.dfP = false;
    this.dfQ = false;
    this.dfR = 0;
    this.dfS = true;
    this.dfV = null;
    this.dbH = true;
    this.dbI = true;
    this.dbJ = false;
    this.dfY = null;
    if ((paramContext instanceof Activity)) {}
    for (Context localContext = aj.getContext();; localContext = paramContext)
    {
      this.context = localContext;
      this.dfR = paramInt;
      this.dfX = new com.tencent.mm.audio.a(paramContext, new a.1(this));
      new g.b();
      AppMethodBeat.o(148290);
      return;
    }
  }
  
  private void PE()
  {
    AppMethodBeat.i(148302);
    d.a local3 = new d.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(205861);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148284);
            try
            {
              if (ae.gcF.fWq == 1) {
                Thread.sleep(300L);
              }
              ad.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.f(a.this), Boolean.valueOf(a.g(a.this)) });
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(205860);
                  a.b(a.this).cn(a.b(a.this).dbL);
                  bd.b localb;
                  if (a.g(a.this))
                  {
                    Context localContext = a.h(a.this);
                    boolean bool = a.b(a.this).dbL;
                    bd.a local1 = new bd.a()
                    {
                      public final void onCompletion()
                      {
                        AppMethodBeat.i(205859);
                        ad.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                          a.b(a.this).co(a.i(a.this));
                          a.j(a.this);
                          ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                          ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        AppMethodBeat.o(205859);
                      }
                    };
                    if (bool)
                    {
                      localb = bd.b.Ifo;
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
                    AppMethodBeat.o(205860);
                    return;
                    localb = bd.b.Ifp;
                    break;
                    ad.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
                      ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.i(a.this)) });
                      a.b(a.this).co(a.i(a.this));
                      a.j(a.this);
                      ad.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                  }
                  label321:
                  ad.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                  AppMethodBeat.o(205860);
                }
              });
              AppMethodBeat.o(148284);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bt.n(localException) });
              AppMethodBeat.o(148284);
            }
          }
        }, "SceneVoice_onCompletion");
        AppMethodBeat.o(205861);
      }
    };
    if (this.dbM != null) {
      this.dbM.a(local3);
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
        AppMethodBeat.i(205858);
        com.tencent.mm.audio.a locala = a.b(a.this);
        locala.bGw();
        if (locala.dbJ)
        {
          com.tencent.mm.compatible.util.b localb = locala.dbG;
          if (localb != null) {
            localb.abe();
          }
          locala.dbJ = false;
        }
        ad.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(a.c(a.this)), Boolean.valueOf(a.d(a.this)) });
        if (a.e(a.this) != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205857);
              a.e(a.this).onError();
              AppMethodBeat.o(205857);
            }
          });
        }
        AppMethodBeat.o(205858);
      }
    };
    if (this.dbM != null) {
      this.dbM.a(local2);
    }
    AppMethodBeat.o(148301);
  }
  
  public final boolean OI()
  {
    AppMethodBeat.i(148305);
    if (this.dbM == null)
    {
      AppMethodBeat.o(148305);
      return false;
    }
    if (this.dbM.getStatus() == 2)
    {
      AppMethodBeat.o(148305);
      return true;
    }
    AppMethodBeat.o(148305);
    return false;
  }
  
  public final boolean PD()
  {
    return this.dfP;
  }
  
  public final double PF()
  {
    AppMethodBeat.i(148303);
    if (this.dbM == null)
    {
      AppMethodBeat.o(148303);
      return 0.0D;
    }
    double d = this.dbM.PF();
    AppMethodBeat.o(148303);
    return d;
  }
  
  public final void a(h.a parama)
  {
    this.dfZ = parama;
  }
  
  public final void a(h.b paramb)
  {
    this.dfY = paramb;
  }
  
  public final void a(h.c paramc)
  {
    this.dfT = paramc;
  }
  
  public final void a(h.d paramd)
  {
    this.dfU = paramd;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148293);
    ad.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.TRUE, Integer.valueOf(paramInt1), Integer.valueOf(this.dfR) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (i.fv(paramString)) {
        break;
      }
      ad.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      AppMethodBeat.o(148293);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = q.f(paramString, this.dfR, true);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.dbM = new u(this.context);
        if (this.dbM == null) {
          break label369;
        }
        ad.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.dfX.dbM = this.dbM;
      }
    }
    for (;;)
    {
      this.dfX.Ob();
      this.dfX.cm(paramBoolean);
      this.dfX.iq(this.dfX.dbL);
      PE();
      setError();
      this.dfX.v(paramString, paramInt2);
      ad.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.dbH) });
      AppMethodBeat.o(148293);
      return true;
      this.dbM = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.dbM = new l(this.context);
          break;
        }
        this.dbM = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.dbM = new k(this.context);
        break;
      }
      this.dbM = new k();
      break;
      label369:
      ad.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(148292);
    ad.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.dfR) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      dfW = this.dfV;
      this.dfV = paramString;
      if (!paramBoolean2) {
        break label136;
      }
      str = paramString;
      label87:
      if (i.fv(str)) {
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
      i = q.f(paramString, this.dfR, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.dbM = new u(this.context);
        if (this.dbM == null) {
          break label475;
        }
        ad.i("MicroMsg.SceneVoicePlayer", "init player success %s", new Object[] { Integer.valueOf(hashCode()) });
        this.dfX.dbM = this.dbM;
        label241:
        this.dfX.Ob();
        this.dfX.cm(paramBoolean1);
        if ((com.tencent.mm.plugin.audio.c.a.bGx()) || (com.tencent.mm.plugin.audio.c.a.bGD()))
        {
          ad.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bGx()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.bGD()) });
          this.dfX.cm(false);
        }
        this.dfX.iq(this.dfX.dbL);
        PE();
        setError();
        if (!paramBoolean2) {
          break label500;
        }
      }
    }
    for (;;)
    {
      this.dfX.v(paramString, 0);
      ad.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", new Object[] { Boolean.valueOf(this.dbH) });
      AppMethodBeat.o(148292);
      return true;
      this.dbM = new u();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.dbM = new l(this.context);
          break;
        }
        this.dbM = new l();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.dbM = new k(this.context);
        break;
      }
      this.dbM = new k();
      break;
      label475:
      ad.e("MicroMsg.SceneVoicePlayer", "init player failed %s", new Object[] { Integer.valueOf(hashCode()) });
      break label241;
      label500:
      if (this.dfR == 0) {
        paramString = s.getFullPath(paramString);
      } else {
        paramString = null;
      }
    }
  }
  
  public final void cm(boolean paramBoolean)
  {
    AppMethodBeat.i(148300);
    this.dfX.cn(paramBoolean);
    AppMethodBeat.o(148300);
  }
  
  public final void cq(boolean paramBoolean)
  {
    this.dbH = paramBoolean;
  }
  
  public final void cr(boolean paramBoolean)
  {
    this.dbI = paramBoolean;
  }
  
  public final boolean cs(boolean paramBoolean)
  {
    AppMethodBeat.i(148295);
    if (this.dbM == null)
    {
      AppMethodBeat.o(148295);
      return false;
    }
    ad.i("MicroMsg.SceneVoicePlayer", "pause");
    boolean bool = this.dfX.cp(paramBoolean);
    if ((bool) && (this.dfT != null)) {
      this.dfT.eC(paramBoolean);
    }
    ad.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.dbH), Boolean.valueOf(this.dbJ) });
    AppMethodBeat.o(148295);
    return bool;
  }
  
  public final void ct(boolean paramBoolean)
  {
    AppMethodBeat.i(148304);
    ad.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.dfQ = paramBoolean;
    AppMethodBeat.o(148304);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(148291);
    if (this.dbM == null)
    {
      AppMethodBeat.o(148291);
      return false;
    }
    boolean bool = this.dbM.isPlaying();
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
    AppMethodBeat.i(221419);
    boolean bool = cs(true);
    AppMethodBeat.o(221419);
    return bool;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(148296);
    if (this.dbM == null)
    {
      AppMethodBeat.o(148296);
      return false;
    }
    ad.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.dfX.Oc();
    ad.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", new Object[] { Boolean.valueOf(this.dbH), Boolean.valueOf(this.dbJ) });
    AppMethodBeat.o(148296);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(221420);
    stop(false);
    AppMethodBeat.o(221420);
  }
  
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(148299);
    if (this.dbM == null)
    {
      ad.e("MicroMsg.SceneVoicePlayer", "stop player failed cause player is null %s", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(148299);
      return;
    }
    this.dbM.Gv();
    this.dbM.a(null);
    ad.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", new Object[] { Boolean.valueOf(this.dbH), Boolean.valueOf(this.dbJ), Boolean.valueOf(this.dbI) });
    this.dfX.Od();
    if ((!paramBoolean) && (this.dfU != null)) {
      this.dfU.onStop();
    }
    AppMethodBeat.o(148299);
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(205862);
    this.dfX.context = null;
    a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    a.a.VM("music");
    AppMethodBeat.o(205862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.a.a
 * JD-Core Version:    0.7.0.1
 */