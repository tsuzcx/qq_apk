package com.tencent.mm.plugin.fav.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.bg;
import com.tencent.mm.autogen.a.wg;
import com.tencent.mm.autogen.a.wh;
import com.tencent.mm.autogen.b.gy;
import com.tencent.mm.autogen.mmdata.rpt.hj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;

public final class p
{
  public int AjA;
  a AjB;
  ImageView AjC;
  private ImageView AjD;
  private ImageView AjE;
  private ValueAnimator AjF;
  private IListener<wh> AjG;
  private com.tencent.mm.network.p AjH;
  private a.a Ajx;
  private com.tencent.mm.plugin.scanner.word.a Ajy;
  volatile int Ajz;
  MMActivity activity;
  
  public p(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.AjA = 0;
    this.AjG = new PhotoTransControl.1(this, com.tencent.mm.app.f.hfK);
    this.AjH = new com.tencent.mm.network.p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((h.aZW().bFQ() != 6) && (h.aZW().bFQ() != 4) && (p.this.AjA == 1))
            {
              k.c(p.this.activity, p.this.activity.getString(q.i.app_network_unavailable), "", true);
              p.this.dSe();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.Ajx = parama1;
    this.activity = paramMMActivity;
    this.AjB = parama;
    this.AjD = ((ImageView)this.activity.findViewById(q.e.scan_translate_layer));
    this.AjE = ((ImageView)this.activity.findViewById(q.e.scan_translate_close_btn));
    this.AjC = ((ImageView)this.activity.findViewById(q.e.scan_translate_line));
    paramMMActivity = (FrameLayout.LayoutParams)this.AjE.getLayoutParams();
    paramMMActivity.bottomMargin += aw.bk(this.activity);
    this.AjE.setLayoutParams(paramMMActivity);
    this.AjE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new bg();
        paramAnonymousView.hBl.scene = 1;
        paramAnonymousView.hBl.hBm = p.this.Ajz;
        paramAnonymousView.publish();
        p.this.dSe();
        p.this.Ajz = 0;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107069);
      }
    });
    this.AjF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AjF.setDuration(5000L);
    this.AjF.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(107071);
        p.this.AjC.setAlpha(0.0F);
        AppMethodBeat.o(107071);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(107070);
        p.this.AjC.setAlpha(0.0F);
        AppMethodBeat.o(107070);
      }
    });
    final int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.AjF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(107072);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          p.this.AjC.setAlpha(f * 10.0F);
        }
        for (;;)
        {
          p.this.AjC.setTranslationY(f * (i - p.this.AjC.getHeight()));
          AppMethodBeat.o(107072);
          return;
          if (f >= 0.9F) {
            p.this.AjC.setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.AjG.alive();
    AppMethodBeat.o(107073);
  }
  
  private void dSd()
  {
    AppMethodBeat.i(107077);
    if ((h.aZW().bFQ() != 6) && (h.aZW().bFQ() != 4))
    {
      k.c(this.activity, this.activity.getString(q.i.app_network_unavailable), "", true);
      dSe();
      AppMethodBeat.o(107077);
      return;
    }
    this.AjA = 1;
    this.AjC.setVisibility(0);
    this.AjD.setVisibility(0);
    this.AjE.setVisibility(0);
    dSf();
    AppMethodBeat.o(107077);
  }
  
  private void dSf()
  {
    AppMethodBeat.i(107079);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    this.AjF.start();
    AppMethodBeat.o(107079);
  }
  
  private void dSg()
  {
    AppMethodBeat.i(107080);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(0);
    this.AjF.end();
    AppMethodBeat.o(107080);
  }
  
  public final void dSc()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.AjB.dRR();
    if (((this.AjA == 0) || (this.AjA == 2)) && (!Util.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new hj();
      ((hj)localObject2).iOd = 5L;
      if (this.AjA == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((hj)localObject2).iqr = l;
        ((hj)localObject2).ikE = 3L;
        ((hj)localObject2).rq(this.AjB.getFileId());
        ((hj)localObject2).rr(this.AjB.getAesKey());
        ((hj)localObject2).bMH();
        this.Ajz = ((int)(z.bAM().hashCode() + System.currentTimeMillis()));
        localObject2 = ((com.tencent.mm.plugin.scanner.f)h.az(com.tencent.mm.plugin.scanner.f.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!y.ZC(((gy)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).putExtra("translate_source", 5);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        ((Intent)localObject2).putExtra("fileid", this.AjB.getFileId());
        ((Intent)localObject2).putExtra("aeskey", this.AjB.getAesKey());
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        localObject1 = this.activity;
        int i = q.a.anim_not_change;
        ((MMActivity)localObject1).overridePendingTransition(i, i);
        AppMethodBeat.o(107075);
        return;
      }
      dSd();
      Log.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.Ajz) });
      localObject2 = new wg();
      ((wg)localObject2).hZR.scene = 2;
      ((wg)localObject2).hZR.filePath = ((String)localObject1);
      ((wg)localObject2).hZR.hBm = this.Ajz;
      ((wg)localObject2).publish();
    }
    AppMethodBeat.o(107075);
  }
  
  public final void dSe()
  {
    AppMethodBeat.i(107078);
    this.AjA = 0;
    this.AjC.setVisibility(8);
    this.AjD.setVisibility(8);
    this.AjE.setVisibility(8);
    dSg();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    dSg();
    this.AjF.removeAllUpdateListeners();
    this.AjG.dead();
    h.baD().b(this.AjH);
    this.Ajx = null;
    this.activity = null;
    this.AjB = null;
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
    if (this.Ajy == null) {
      this.Ajy = new ImageWordScanDetailEngine(this.activity, (byte)0);
    }
    this.Ajy.a(paramString, this.Ajx);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String dRR();
    
    public abstract String getAesKey();
    
    public abstract String getFileId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.p
 * JD-Core Version:    0.7.0.1
 */