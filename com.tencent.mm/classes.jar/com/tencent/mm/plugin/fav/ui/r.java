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
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sr.a;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public final class r
{
  MMActivity activity;
  private a.a rHd;
  private com.tencent.mm.plugin.scanner.word.a rHe;
  volatile int rHf;
  public int rHg;
  a rHh;
  ImageView rHi;
  private ImageView rHj;
  private ImageView rHk;
  private ValueAnimator rHl;
  private c<sr> rHm;
  private n rHn;
  
  public r(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.rHg = 0;
    this.rHm = new c() {};
    this.rHn = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((g.ajj().aFd() != 6) && (g.ajj().aFd() != 4) && (r.this.rHg == 1))
            {
              h.c(r.this.activity, r.this.activity.getString(2131755828), "", true);
              r.this.cyd();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.rHd = parama1;
    this.activity = paramMMActivity;
    this.rHh = parama;
    this.rHj = ((ImageView)this.activity.findViewById(2131304342));
    this.rHk = ((ImageView)this.activity.findViewById(2131304340));
    this.rHi = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.rHk.getLayoutParams();
    paramMMActivity.bottomMargin += al.en(this.activity);
    this.rHk.setLayoutParams(paramMMActivity);
    this.rHk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new aw();
        paramAnonymousView.dmL.scene = 1;
        paramAnonymousView.dmL.dmM = r.this.rHf;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
        r.this.cyd();
        r.this.rHf = 0;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107069);
      }
    });
    this.rHl = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rHl.setDuration(5000L);
    this.rHl.addListener(new r.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.rHl.addUpdateListener(new r.5(this, i));
    this.rHm.alive();
    AppMethodBeat.o(107073);
  }
  
  private void cyc()
  {
    AppMethodBeat.i(107077);
    if ((g.ajj().aFd() != 6) && (g.ajj().aFd() != 4))
    {
      h.c(this.activity, this.activity.getString(2131755828), "", true);
      cyd();
      AppMethodBeat.o(107077);
      return;
    }
    this.rHg = 1;
    this.rHi.setVisibility(0);
    this.rHj.setVisibility(0);
    this.rHk.setVisibility(0);
    cye();
    AppMethodBeat.o(107077);
  }
  
  private void cye()
  {
    AppMethodBeat.i(107079);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(-1);
    this.rHl.start();
    AppMethodBeat.o(107079);
  }
  
  private void cyf()
  {
    AppMethodBeat.i(107080);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(0);
    this.rHl.end();
    AppMethodBeat.o(107080);
  }
  
  public final void cyb()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.rHh.cxR();
    if (((this.rHg == 0) || (this.rHg == 2)) && (!bu.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new ce();
      ((ce)localObject2).edv = 5L;
      if (this.rHg == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((ce)localObject2).dWt = l;
        ((ce)localObject2).dQB = 3L;
        ((ce)localObject2).aLH();
        this.rHf = ((int)(v.aAC().hashCode() + System.currentTimeMillis()));
        localObject2 = ((e)g.ad(e.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!o.fB(((fp)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).putExtra("translate_source", 5);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        this.activity.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(107075);
        return;
      }
      cyc();
      ae.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.rHf) });
      localObject2 = new sq();
      ((sq)localObject2).dIl.scene = 2;
      ((sq)localObject2).dIl.filePath = ((String)localObject1);
      ((sq)localObject2).dIl.dmM = this.rHf;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    }
    AppMethodBeat.o(107075);
  }
  
  public final void cyd()
  {
    AppMethodBeat.i(107078);
    this.rHg = 0;
    this.rHi.setVisibility(8);
    this.rHj.setVisibility(8);
    this.rHk.setVisibility(8);
    cyf();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    cyf();
    this.rHl.removeAllUpdateListeners();
    this.rHm.dead();
    g.ajQ().b(this.rHn);
    this.rHd = null;
    this.activity = null;
    this.rHh = null;
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
    if (this.rHe == null) {
      this.rHe = new ImageWordScanDetailEngine(this.activity);
    }
    this.rHe.a(paramString, this.rHd);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String cxR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r
 * JD-Core Version:    0.7.0.1
 */