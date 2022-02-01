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
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.d;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class r
{
  MMActivity activity;
  private a.a ryS;
  private com.tencent.mm.plugin.scanner.word.a ryT;
  volatile int ryU;
  public int ryV;
  a ryW;
  ImageView ryX;
  private ImageView ryY;
  private ImageView ryZ;
  private ValueAnimator rza;
  private c<sq> rzb;
  private n rzc;
  
  public r(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.ryV = 0;
    this.rzb = new c() {};
    this.rzc = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((g.aiU().aEN() != 6) && (g.aiU().aEN() != 4) && (r.this.ryV == 1))
            {
              h.c(r.this.activity, r.this.activity.getString(2131755828), "", true);
              r.this.cwC();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.ryS = parama1;
    this.activity = paramMMActivity;
    this.ryW = parama;
    this.ryY = ((ImageView)this.activity.findViewById(2131304342));
    this.ryZ = ((ImageView)this.activity.findViewById(2131304340));
    this.ryX = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.ryZ.getLayoutParams();
    paramMMActivity.bottomMargin += al.ej(this.activity);
    this.ryZ.setLayoutParams(paramMMActivity);
    this.ryZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new aw();
        paramAnonymousView.dlJ.scene = 1;
        paramAnonymousView.dlJ.dlK = r.this.ryU;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
        r.this.cwC();
        r.this.ryU = 0;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107069);
      }
    });
    this.rza = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rza.setDuration(5000L);
    this.rza.addListener(new r.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.rza.addUpdateListener(new r.5(this, i));
    this.rzb.alive();
    AppMethodBeat.o(107073);
  }
  
  private void cwB()
  {
    AppMethodBeat.i(107077);
    if ((g.aiU().aEN() != 6) && (g.aiU().aEN() != 4))
    {
      h.c(this.activity, this.activity.getString(2131755828), "", true);
      cwC();
      AppMethodBeat.o(107077);
      return;
    }
    this.ryV = 1;
    this.ryX.setVisibility(0);
    this.ryY.setVisibility(0);
    this.ryZ.setVisibility(0);
    cwD();
    AppMethodBeat.o(107077);
  }
  
  private void cwD()
  {
    AppMethodBeat.i(107079);
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(-1);
    this.rza.start();
    AppMethodBeat.o(107079);
  }
  
  private void cwE()
  {
    AppMethodBeat.i(107080);
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(0);
    this.rza.end();
    AppMethodBeat.o(107080);
  }
  
  public final void cwA()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.ryW.cwq();
    if (((this.ryV == 0) || (this.ryV == 2)) && (!bt.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new ce();
      ((ce)localObject2).eca = 5L;
      if (this.ryV == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((ce)localObject2).dVd = l;
        ((ce)localObject2).dPl = 3L;
        ((ce)localObject2).aLk();
        this.ryU = ((int)(u.aAm().hashCode() + System.currentTimeMillis()));
        localObject2 = ((d)g.ad(d.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!i.fv(((fp)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).putExtra("translate_source", 5);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        this.activity.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(107075);
        return;
      }
      cwB();
      ad.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.ryU) });
      localObject2 = new sp();
      ((sp)localObject2).dHf.scene = 2;
      ((sp)localObject2).dHf.filePath = ((String)localObject1);
      ((sp)localObject2).dHf.dlK = this.ryU;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    }
    AppMethodBeat.o(107075);
  }
  
  public final void cwC()
  {
    AppMethodBeat.i(107078);
    this.ryV = 0;
    this.ryX.setVisibility(8);
    this.ryY.setVisibility(8);
    this.ryZ.setVisibility(8);
    cwE();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    cwE();
    this.rza.removeAllUpdateListeners();
    this.rzb.dead();
    g.ajB().b(this.rzc);
    this.ryS = null;
    this.activity = null;
    this.ryW = null;
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
    if (this.ryT == null) {
      this.ryT = new ImageWordScanDetailEngine(this.activity);
    }
    this.ryT.a(paramString, this.ryS);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String cwq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r
 * JD-Core Version:    0.7.0.1
 */