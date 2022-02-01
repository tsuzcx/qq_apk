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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.tp.a;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public final class r
{
  MMActivity activity;
  private a.a tgK;
  private com.tencent.mm.plugin.scanner.word.a tgL;
  volatile int tgM;
  public int tgN;
  a tgO;
  ImageView tgP;
  private ImageView tgQ;
  private ImageView tgR;
  private ValueAnimator tgS;
  private IListener<tp> tgT;
  private p tgU;
  
  public r(MMActivity paramMMActivity, a parama, a.a parama1)
  {
    AppMethodBeat.i(107073);
    this.tgN = 0;
    this.tgT = new IListener() {};
    this.tgU = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(107068);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107067);
            if ((g.azz().aYS() != 6) && (g.azz().aYS() != 4) && (r.this.tgN == 1))
            {
              h.c(r.this.activity, r.this.activity.getString(2131755914), "", true);
              r.this.cWh();
            }
            AppMethodBeat.o(107067);
          }
        });
        AppMethodBeat.o(107068);
      }
    };
    this.tgK = parama1;
    this.activity = paramMMActivity;
    this.tgO = parama;
    this.tgQ = ((ImageView)this.activity.findViewById(2131307274));
    this.tgR = ((ImageView)this.activity.findViewById(2131307272));
    this.tgP = ((ImageView)this.activity.findViewById(2131307275));
    paramMMActivity = (FrameLayout.LayoutParams)this.tgR.getLayoutParams();
    paramMMActivity.bottomMargin += ao.aD(this.activity);
    this.tgR.setLayoutParams(paramMMActivity);
    this.tgR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new ay();
        paramAnonymousView.dEa.scene = 1;
        paramAnonymousView.dEa.dEb = r.this.tgM;
        EventCenter.instance.publish(paramAnonymousView);
        r.this.cWh();
        r.this.tgM = 0;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107069);
      }
    });
    this.tgS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tgS.setDuration(5000L);
    this.tgS.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(107071);
        r.this.tgP.setAlpha(0.0F);
        AppMethodBeat.o(107071);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(107070);
        r.this.tgP.setAlpha(0.0F);
        AppMethodBeat.o(107070);
      }
    });
    final int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(107072);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          r.this.tgP.setAlpha(f * 10.0F);
        }
        for (;;)
        {
          r.this.tgP.setTranslationY(f * (i - r.this.tgP.getHeight()));
          AppMethodBeat.o(107072);
          return;
          if (f >= 0.9F) {
            r.this.tgP.setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.tgT.alive();
    AppMethodBeat.o(107073);
  }
  
  private void cWg()
  {
    AppMethodBeat.i(107077);
    if ((g.azz().aYS() != 6) && (g.azz().aYS() != 4))
    {
      h.c(this.activity, this.activity.getString(2131755914), "", true);
      cWh();
      AppMethodBeat.o(107077);
      return;
    }
    this.tgN = 1;
    this.tgP.setVisibility(0);
    this.tgQ.setVisibility(0);
    this.tgR.setVisibility(0);
    cWi();
    AppMethodBeat.o(107077);
  }
  
  private void cWi()
  {
    AppMethodBeat.i(107079);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(-1);
    this.tgS.start();
    AppMethodBeat.o(107079);
  }
  
  private void cWj()
  {
    AppMethodBeat.i(107080);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(0);
    this.tgS.end();
    AppMethodBeat.o(107080);
  }
  
  public final void cWf()
  {
    AppMethodBeat.i(107075);
    Object localObject1 = this.tgO.cVV();
    if (((this.tgN == 0) || (this.tgN == 2)) && (!Util.isNullOrNil((String)localObject1)))
    {
      Object localObject2 = new ep();
      ((ep)localObject2).eDV = 5L;
      if (this.tgN == 2) {}
      for (long l = 1L;; l = 0L)
      {
        ((ep)localObject2).erW = l;
        ((ep)localObject2).ejA = 3L;
        ((ep)localObject2).rK(this.tgO.getFileId());
        ((ep)localObject2).rL(this.tgO.getAesKey());
        ((ep)localObject2).bfK();
        this.tgM = ((int)(z.aTY().hashCode() + System.currentTimeMillis()));
        localObject2 = ((e)g.ah(e.class)).getTranslationResult((String)localObject1);
        if ((localObject2 == null) || (!s.YS(((fx)localObject2).field_resultFile))) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("original_file_path", (String)localObject1);
        ((Intent)localObject2).putExtra("translate_source", 5);
        ((Intent)localObject2).setClass(this.activity, TranslationResultUI.class);
        ((Intent)localObject2).putExtra("fileid", this.tgO.getFileId());
        ((Intent)localObject2).putExtra("aeskey", this.tgO.getAesKey());
        localObject1 = this.activity;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.activity.finish();
        this.activity.overridePendingTransition(2130771986, 2130771986);
        AppMethodBeat.o(107075);
        return;
      }
      cWg();
      Log.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", new Object[] { localObject1, Integer.valueOf(this.tgM) });
      localObject2 = new to();
      ((to)localObject2).dZY.scene = 2;
      ((to)localObject2).dZY.filePath = ((String)localObject1);
      ((to)localObject2).dZY.dEb = this.tgM;
      EventCenter.instance.publish((IEvent)localObject2);
    }
    AppMethodBeat.o(107075);
  }
  
  public final void cWh()
  {
    AppMethodBeat.i(107078);
    this.tgN = 0;
    this.tgP.setVisibility(8);
    this.tgQ.setVisibility(8);
    this.tgR.setVisibility(8);
    cWj();
    AppMethodBeat.o(107078);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(107074);
    cWj();
    this.tgS.removeAllUpdateListeners();
    this.tgT.dead();
    g.aAg().b(this.tgU);
    this.tgK = null;
    this.activity = null;
    this.tgO = null;
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
    if (this.tgL == null) {
      this.tgL = new ImageWordScanDetailEngine(this.activity);
    }
    this.tgL.a(paramString, this.tgK);
    AppMethodBeat.o(107076);
  }
  
  public static abstract interface a
  {
    public abstract String cVV();
    
    public abstract String getAesKey();
    
    public abstract String getFileId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.r
 * JD-Core Version:    0.7.0.1
 */