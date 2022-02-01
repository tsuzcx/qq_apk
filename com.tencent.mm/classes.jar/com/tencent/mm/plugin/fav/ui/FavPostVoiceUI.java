package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.audio.b.j.a;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] iCh = { 2131230925, 2131230926, 2131230927, 2131230928, 2131230929, 2131230930, 2131230931 };
  private static final int[] rFy = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private View cpn;
  private long duration;
  private final aw iCn;
  boolean isFinishing;
  private int lya;
  private final aq pAg;
  private final aw pAh;
  private String path;
  private boolean pzT;
  private long pzU;
  private boolean pzV;
  private long pzW;
  private Toast pzX;
  private j pzY;
  private Button rFr;
  private View rFs;
  private View rFt;
  private ImageView rFu;
  private View rFv;
  private View rFw;
  private TextView rFx;
  
  public FavPostVoiceUI()
  {
    AppMethodBeat.i(106798);
    this.pzW = -1L;
    this.iCn = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        int j = 0;
        AppMethodBeat.i(106789);
        j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
        int i;
        if (localj.status == 1)
        {
          i = localj.djF.getMaxAmplitude();
          if (i > j.djH) {
            j.djH = i;
          }
          i = i * 100 / j.djH;
        }
        for (;;)
        {
          if (j < FavPostVoiceUI.iCh.length)
          {
            if ((i >= FavPostVoiceUI.cxV()[j]) && (i < FavPostVoiceUI.cxV()[(j + 1)])) {
              FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.iCh[j]);
            }
          }
          else
          {
            AppMethodBeat.o(106789);
            return true;
            i = 0;
            continue;
          }
          j += 1;
        }
      }
    }, true);
    this.pAg = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106794);
        super.handleMessage(paramAnonymousMessage);
        FavPostVoiceUI.this.cxT();
        FavPostVoiceUI.g(FavPostVoiceUI.this).setBackgroundResource(2131233811);
        FavPostVoiceUI.g(FavPostVoiceUI.this).setEnabled(true);
        AppMethodBeat.o(106794);
      }
    };
    this.pAh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(106795);
        if (FavPostVoiceUI.q(FavPostVoiceUI.this) == -1L) {
          FavPostVoiceUI.a(FavPostVoiceUI.this, bu.HQ());
        }
        long l = bu.aO(FavPostVoiceUI.q(FavPostVoiceUI.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (FavPostVoiceUI.r(FavPostVoiceUI.this) != null) {
            break label159;
          }
          FavPostVoiceUI.a(FavPostVoiceUI.this, Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          FavPostVoiceUI.r(FavPostVoiceUI.this).show();
          if (l < 3600000L) {
            break;
          }
          ae.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
          FavPostVoiceUI.s(FavPostVoiceUI.this);
          FavPostVoiceUI.p(FavPostVoiceUI.this);
          AppMethodBeat.o(106795);
          return false;
          label159:
          FavPostVoiceUI.r(FavPostVoiceUI.this).setText(FavPostVoiceUI.this.getString(2131758842, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(106795);
        return true;
      }
    }, true);
    this.isFinishing = false;
    AppMethodBeat.o(106798);
  }
  
  private void cfm()
  {
    long l = 0L;
    AppMethodBeat.i(106801);
    if (!this.pzT)
    {
      AppMethodBeat.o(106801);
      return;
    }
    this.rFr.setKeepScreenOn(true);
    this.rFr.setBackgroundResource(2131233810);
    this.rFr.setText(2131758953);
    this.pzY.PF();
    int i;
    label81:
    String str;
    if (this.pzU == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label163;
      }
      i = 1;
      this.iCn.stopTimer();
      this.pAh.stopTimer();
      if (i != 0) {
        break label294;
      }
      str = this.path;
      i = (int)this.duration;
      if (!bu.isNullOrNil(str)) {
        break label168;
      }
      ae.e("MicroMsg.FavPostLogic", "postVoice path null");
      label126:
      setResult(-1);
      finish();
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      this.pzT = false;
      AppMethodBeat.o(106801);
      return;
      l = bu.aO(this.pzU);
      break;
      label163:
      i = 0;
      break label81;
      label168:
      com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      k.G(localg);
      ajx localajx = new ajx();
      localajx.aPQ(str);
      localajx.aan(i);
      localajx.wt(true);
      localajx.aao(localg.field_type);
      localajx.aPM("amr");
      localg.field_favProto.oeJ.add(localajx);
      b.C(localg);
      com.tencent.mm.plugin.report.service.g.yxI.f(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label126;
      label294:
      cfo();
      this.rFr.setEnabled(false);
      this.rFr.setBackgroundResource(2131233809);
      this.rFt.setVisibility(0);
      this.rFs.setVisibility(8);
      this.pAg.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void cfo()
  {
    AppMethodBeat.i(106803);
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(this.path);
    if (localk.exists()) {
      localk.delete();
    }
    AppMethodBeat.o(106803);
  }
  
  private j cxS()
  {
    AppMethodBeat.i(106800);
    Object localObject = c.a.fXH;
    localObject = new j();
    ((j)localObject).djG = new j.a()
    {
      public final void onError()
      {
        AppMethodBeat.i(106792);
        FavPostVoiceUI.e(FavPostVoiceUI.this).stopTimer();
        FavPostVoiceUI.f(FavPostVoiceUI.this).stopTimer();
        AppMethodBeat.o(106792);
      }
    };
    AppMethodBeat.o(106800);
    return localObject;
  }
  
  private void cxU()
  {
    AppMethodBeat.i(106808);
    if (this.isFinishing)
    {
      AppMethodBeat.o(106808);
      return;
    }
    this.isFinishing = true;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(300L);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(106797);
        FavPostVoiceUI.l(FavPostVoiceUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106796);
            FavPostVoiceUI.this.setResult(0);
            FavPostVoiceUI.this.finish();
            FavPostVoiceUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(106796);
          }
        });
        AppMethodBeat.o(106797);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    findViewById(2131306517).setVisibility(8);
    findViewById(2131299817).setVisibility(8);
    this.cpn.setVisibility(8);
    this.cpn.startAnimation(localAlphaAnimation);
    findViewById(2131306517).startAnimation(localAlphaAnimation);
    findViewById(2131299817).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(106808);
  }
  
  public final void cxT()
  {
    AppMethodBeat.i(106802);
    this.rFs.setVisibility(0);
    this.rFt.setVisibility(8);
    this.rFw.setVisibility(8);
    this.rFv.setVisibility(0);
    this.rFx.setText(2131758841);
    this.rFr.setBackgroundResource(2131233811);
    this.rFr.setText(2131758953);
    this.rFu.setVisibility(4);
    this.pzT = false;
    AppMethodBeat.o(106802);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106799);
    super.onCreate(paramBundle);
    setContentView(z.jV(this).inflate(2131493974, null));
    this.rFu = ((ImageView)findViewById(2131306518));
    this.rFv = findViewById(2131306519);
    this.rFw = findViewById(2131306521);
    this.rFs = findViewById(2131306525);
    this.rFt = findViewById(2131306526);
    this.rFx = ((TextView)findViewById(2131306527));
    this.cpn = findViewById(2131306520);
    findViewById(2131306517).setVisibility(8);
    this.cpn.setVisibility(8);
    findViewById(2131306517).setOnTouchListener(new FavPostVoiceUI.2(this));
    findViewById(2131299817).setVisibility(8);
    this.pzY = cxS();
    this.rFr = ((Button)findViewById(2131299816));
    this.rFr.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106793);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/fav/ui/FavPostVoiceUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (paramAnonymousView != FavPostVoiceUI.g(FavPostVoiceUI.this))
        {
          a.a(false, this, "com/tencent/mm/plugin/fav/ui/FavPostVoiceUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(106793);
          return false;
        }
        int i = (int)paramAnonymousMotionEvent.getRawY();
        paramAnonymousView = new int[2];
        FavPostVoiceUI.a(FavPostVoiceUI.this, FavPostVoiceUI.this.getResources().getDisplayMetrics().heightPixels);
        FavPostVoiceUI.g(FavPostVoiceUI.this).getLocationOnScreen(paramAnonymousView);
        int j = paramAnonymousView[1];
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/plugin/fav/ui/FavPostVoiceUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(106793);
          return false;
          if (!FavPostVoiceUI.h(FavPostVoiceUI.this))
          {
            FavPostVoiceUI.i(FavPostVoiceUI.this);
            FavPostVoiceUI.j(FavPostVoiceUI.this);
            continue;
            int k = BackwardSupportUtil.b.h(FavPostVoiceUI.this, 60.0F);
            if ((i <= FavPostVoiceUI.k(FavPostVoiceUI.this) - k) && (i < j))
            {
              FavPostVoiceUI.l(FavPostVoiceUI.this).setVisibility(8);
              FavPostVoiceUI.m(FavPostVoiceUI.this).setVisibility(0);
            }
            else
            {
              FavPostVoiceUI.l(FavPostVoiceUI.this).setVisibility(0);
              FavPostVoiceUI.m(FavPostVoiceUI.this).setVisibility(8);
              continue;
              if (!FavPostVoiceUI.h(FavPostVoiceUI.this))
              {
                a.a(false, this, "com/tencent/mm/plugin/fav/ui/FavPostVoiceUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(106793);
                return false;
              }
              if (FavPostVoiceUI.m(FavPostVoiceUI.this).getVisibility() == 0)
              {
                ae.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                FavPostVoiceUI.n(FavPostVoiceUI.this);
              }
              else if (!FavPostVoiceUI.o(FavPostVoiceUI.this))
              {
                FavPostVoiceUI.p(FavPostVoiceUI.this);
                continue;
                ae.w("MicroMsg.FavPostVoiceUI", "action cancel");
                FavPostVoiceUI.n(FavPostVoiceUI.this);
              }
            }
          }
        }
      }
    });
    cxT();
    paramBundle = com.tencent.mm.plugin.fav.a.b.cwk();
    Object localObject = new com.tencent.mm.vfs.k(paramBundle);
    if (!((com.tencent.mm.vfs.k)localObject).exists()) {
      ((com.tencent.mm.vfs.k)localObject).mkdirs();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new com.tencent.mm.vfs.k((String)localObject).exists());
    this.path = ((String)localObject);
    this.rFx.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106791);
        FavPostVoiceUI.this.findViewById(2131306517).setVisibility(0);
        FavPostVoiceUI.d(FavPostVoiceUI.this).setVisibility(0);
        FavPostVoiceUI.this.findViewById(2131299817).setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(300L);
        FavPostVoiceUI.d(FavPostVoiceUI.this).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(2131306517).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(2131299817).startAnimation(localTranslateAnimation);
        AppMethodBeat.o(106791);
      }
    });
    AppMethodBeat.o(106799);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106804);
    super.onDestroy();
    AppMethodBeat.o(106804);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106807);
    if (4 == paramInt)
    {
      cxU();
      AppMethodBeat.o(106807);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(106807);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(106806);
    super.onPause();
    cfm();
    AppMethodBeat.o(106806);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106805);
    super.onResume();
    AppMethodBeat.o(106805);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI
 * JD-Core Version:    0.7.0.1
 */