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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.se.a;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.d;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class r
{
  MMActivity activity;
  private a.a qOT;
  private com.tencent.mm.plugin.scanner.word.a qOU;
  volatile int qOV;
  public int qOW;
  a qOX;
  ImageView qOY;
  private ImageView qOZ;
  private ImageView qPa;
  private ValueAnimator qPb;
  private c<se> qPc;
  private n qPd;
  
  public r(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.qOW = 0;
    this.qPc = new c() {};
    this.qPd = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((g.agi().aBK() != 6) && (g.agi().aBK() != 4) && (r.this.qOW == 1))
            {
              h.c(r.this.activity, r.this.activity.getString(2131755828), "", true);
              r.this.cqS();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.qOT = parama1;
    this.activity = paramMMActivity;
    this.qOX = parama;
    this.qOZ = ((ImageView)this.activity.findViewById(2131304342));
    this.qPa = ((ImageView)this.activity.findViewById(2131304340));
    this.qOY = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.qPa.getLayoutParams();
    paramMMActivity.bottomMargin += aj.ej(this.activity);
    this.qPa.setLayoutParams(paramMMActivity);
    this.qPa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        paramAnonymousView = new au();
        paramAnonymousView.dap.scene = 1;
        paramAnonymousView.dap.daq = r.this.qOV;
        com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
        r.this.cqS();
        r.this.qOV = 0;
        AppMethodBeat.o(107069);
      }
    });
    this.qPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qPb.setDuration(5000L);
    this.qPb.addListener(new r.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.qPb.addUpdateListener(new r.5(this, i));
    this.qPc.alive();
    AppMethodBeat.o(107073);
  }
  
  private void cqR()
  {
    AppMethodBeat.i(107077);
    if ((g.agi().aBK() != 6) && (g.agi().aBK() != 4))
    {
      h.c(this.activity, this.activity.getString(2131755828), "", true);
      cqS();
      AppMethodBeat.o(107077);
      return;
    }
    this.qOW = 1;
    this.qOY.setVisibility(0);
    this.qOZ.setVisibility(0);
    this.qPa.setVisibility(0);
    cqT();
    AppMethodBeat.o(107077);
  }
  
  private void cqT()
  {
    AppMethodBeat.i(107079);
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(-1);
    this.qPb.start();
    AppMethodBeat.o(107079);
  }
  
  private void cqU()
  {
    AppMethodBeat.i(107080);
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(0);
    this.qPb.end();
    AppMethodBeat.o(107080);
  }
  
  public final void cqQ()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.qOX.cqG();
    if (((this.qOW == 0) || (this.qOW == 2)) && (!bs.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new bo();
      ((bo)localObject2).dNc = 5L;
      if (this.qOW == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((bo)localObject2).dHY = l;
        ((bo)localObject2).dCQ = 3L;
        ((bo)localObject2).aHZ();
        this.qOV = ((int)(u.axw().hashCode() + System.currentTimeMillis()));
        localObject2 = ((d)g.ad(d.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!i.eA(((ff)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).putExtra("translate_source", 5);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        this.activity.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(107075);
        return;
      }
      cqR();
      ac.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.qOV) });
      localObject2 = new sd();
      ((sd)localObject2).dve.scene = 2;
      ((sd)localObject2).dve.filePath = ((String)localObject1);
      ((sd)localObject2).dve.daq = this.qOV;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    }
    AppMethodBeat.o(107075);
  }
  
  public final void cqS()
  {
    AppMethodBeat.i(107078);
    this.qOW = 0;
    this.qOY.setVisibility(8);
    this.qOZ.setVisibility(8);
    this.qPa.setVisibility(8);
    cqU();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    cqU();
    this.qPb.removeAllUpdateListeners();
    this.qPc.dead();
    g.agQ().b(this.qPd);
    this.qOT = null;
    this.activity = null;
    this.qOX = null;
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
    if (this.qOU == null) {
      this.qOU = new ImageWordScanDetailEngine(this.activity);
    }
    this.qOU.a(paramString, this.qOT);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String cqG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r
 * JD-Core Version:    0.7.0.1
 */