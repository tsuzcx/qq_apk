package com.tencent.mm.plugin.fav.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.rv.a;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class r
{
  MMActivity activity;
  private com.tencent.mm.sdk.b.c<rv> qgA;
  private n qgB;
  private a.a qgr;
  private com.tencent.mm.plugin.scanner.word.a<String, Integer> qgs;
  volatile int qgt;
  public int qgu;
  a qgv;
  ImageView qgw;
  private ImageView qgx;
  private ImageView qgy;
  private ValueAnimator qgz;
  
  public r(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.qgu = 0;
    this.qgA = new com.tencent.mm.sdk.b.c() {};
    this.qgB = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((g.aeS().auR() != 6) && (g.aeS().auR() != 4) && (r.this.qgu == 1))
            {
              h.c(r.this.activity, r.this.activity.getString(2131755828), "", true);
              r.this.cjl();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.qgr = parama1;
    this.activity = paramMMActivity;
    this.qgv = parama;
    this.qgx = ((ImageView)this.activity.findViewById(2131304342));
    this.qgy = ((ImageView)this.activity.findViewById(2131304340));
    this.qgw = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.qgy.getLayoutParams();
    paramMMActivity.bottomMargin += ai.eb(this.activity);
    this.qgy.setLayoutParams(paramMMActivity);
    this.qgy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        paramAnonymousView = new at();
        paramAnonymousView.dcR.scene = 1;
        paramAnonymousView.dcR.dcS = r.this.qgt;
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
        r.this.cjl();
        r.this.qgt = 0;
        AppMethodBeat.o(107069);
      }
    });
    this.qgz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qgz.setDuration(5000L);
    this.qgz.addListener(new r.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.qgz.addUpdateListener(new r.5(this, i));
    this.qgA.alive();
    AppMethodBeat.o(107073);
  }
  
  private void cjk()
  {
    AppMethodBeat.i(107077);
    if ((g.aeS().auR() != 6) && (g.aeS().auR() != 4))
    {
      h.c(this.activity, this.activity.getString(2131755828), "", true);
      cjl();
      AppMethodBeat.o(107077);
      return;
    }
    this.qgu = 1;
    this.qgw.setVisibility(0);
    this.qgx.setVisibility(0);
    this.qgy.setVisibility(0);
    cjm();
    AppMethodBeat.o(107077);
  }
  
  private void cjm()
  {
    AppMethodBeat.i(107079);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(-1);
    this.qgz.start();
    AppMethodBeat.o(107079);
  }
  
  private void cjn()
  {
    AppMethodBeat.i(107080);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(0);
    this.qgz.end();
    AppMethodBeat.o(107080);
  }
  
  public final void cjj()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.qgv.ciZ();
    if (((this.qgu == 0) || (this.qgu == 2)) && (!bt.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new ao();
      ((ao)localObject2).dMB = 5L;
      if (this.qgu == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((ao)localObject2).dKe = l;
        ((ao)localObject2).dFd = 3L;
        ((ao)localObject2).aBj();
        this.qgt = ((int)(u.aqG().hashCode() + System.currentTimeMillis()));
        localObject2 = ((com.tencent.mm.plugin.scanner.c)g.ad(com.tencent.mm.plugin.scanner.c.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!i.eK(((fb)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        this.activity.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(107075);
        return;
      }
      cjk();
      ad.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.qgt) });
      localObject2 = new ru();
      ((ru)localObject2).dxr.scene = 2;
      ((ru)localObject2).dxr.filePath = ((String)localObject1);
      ((ru)localObject2).dxr.dcS = this.qgt;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    }
    AppMethodBeat.o(107075);
  }
  
  public final void cjl()
  {
    AppMethodBeat.i(107078);
    this.qgu = 0;
    this.qgw.setVisibility(8);
    this.qgx.setVisibility(8);
    this.qgy.setVisibility(8);
    cjn();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    cjn();
    this.qgz.removeAllUpdateListeners();
    this.qgA.dead();
    g.afA().b(this.qgB);
    this.qgr = null;
    this.activity = null;
    this.qgv = null;
    AppMethodBeat.o(107074);
  }
  
  public final void scan(String paramString)
  {
    AppMethodBeat.i(107076);
    if ((this.activity == null) || (this.activity.isFinishing()))
    {
      AppMethodBeat.o(107076);
      return;
    }
    if (this.qgs == null) {
      this.qgs = new ImageWordScanEngineImpl(this.activity);
    }
    this.qgs.a(paramString, this.qgr);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String ciZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r
 * JD-Core Version:    0.7.0.1
 */