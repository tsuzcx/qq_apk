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
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] hFs = { 2131230925, 2131230926, 2131230927, 2131230928, 2131230929, 2131230930, 2131230931 };
  private static final int[] qeI = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private long duration;
  private final av hFy;
  boolean isFinishing;
  private int kvo;
  private boolean omf;
  private long omg;
  private boolean omh;
  private long omi;
  private Toast omj;
  private j omk;
  private final ap oms;
  private final av omt;
  private String path;
  private Button qeA;
  private View qeB;
  private View qeC;
  private ImageView qeD;
  private View qeE;
  private View qeF;
  private TextView qeG;
  private View qeH;
  
  public FavPostVoiceUI()
  {
    AppMethodBeat.i(106798);
    this.omi = -1L;
    this.hFy = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        int j = 0;
        AppMethodBeat.i(106789);
        j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
        int i;
        if (localj.status == 1)
        {
          i = localj.cZP.getMaxAmplitude();
          if (i > j.cZR) {
            j.cZR = i;
          }
          i = i * 100 / j.cZR;
        }
        for (;;)
        {
          if (j < FavPostVoiceUI.hFs.length)
          {
            if ((i >= FavPostVoiceUI.cjd()[j]) && (i < FavPostVoiceUI.cjd()[(j + 1)])) {
              FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.hFs[j]);
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
    this.oms = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106794);
        super.handleMessage(paramAnonymousMessage);
        FavPostVoiceUI.this.cjb();
        FavPostVoiceUI.g(FavPostVoiceUI.this).setBackgroundResource(2131233811);
        FavPostVoiceUI.g(FavPostVoiceUI.this).setEnabled(true);
        AppMethodBeat.o(106794);
      }
    };
    this.omt = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(106795);
        if (FavPostVoiceUI.q(FavPostVoiceUI.this) == -1L) {
          FavPostVoiceUI.a(FavPostVoiceUI.this, bt.GC());
        }
        long l = bt.aS(FavPostVoiceUI.q(FavPostVoiceUI.this));
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
          ad.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
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
  
  private void bSe()
  {
    long l = 0L;
    AppMethodBeat.i(106801);
    if (!this.omf)
    {
      AppMethodBeat.o(106801);
      return;
    }
    this.qeA.setKeepScreenOn(true);
    this.qeA.setBackgroundResource(2131233810);
    this.qeA.setText(2131758953);
    this.omk.Ob();
    int i;
    label81:
    String str;
    if (this.omg == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label163;
      }
      i = 1;
      this.hFy.stopTimer();
      this.omt.stopTimer();
      if (i != 0) {
        break label294;
      }
      str = this.path;
      i = (int)this.duration;
      if (!bt.isNullOrNil(str)) {
        break label168;
      }
      ad.e("MicroMsg.FavPostLogic", "postVoice path null");
      label126:
      setResult(-1);
      finish();
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      this.omf = false;
      AppMethodBeat.o(106801);
      return;
      l = bt.aS(this.omg);
      break;
      label163:
      i = 0;
      break label81;
      label168:
      g localg = new g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      k.G(localg);
      afy localafy = new afy();
      localafy.aDz(str);
      localafy.VC(i);
      localafy.ux(true);
      localafy.VD(localg.field_type);
      localafy.aDv("amr");
      localg.field_favProto.mVb.add(localafy);
      b.C(localg);
      h.vKh.f(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label126;
      label294:
      bSg();
      this.qeA.setEnabled(false);
      this.qeA.setBackgroundResource(2131233809);
      this.qeC.setVisibility(0);
      this.qeB.setVisibility(8);
      this.oms.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void bSg()
  {
    AppMethodBeat.i(106803);
    e locale = new e(this.path);
    if (locale.exists()) {
      locale.delete();
    }
    AppMethodBeat.o(106803);
  }
  
  private j cja()
  {
    AppMethodBeat.i(106800);
    Object localObject = c.a.fyG;
    localObject = new j();
    ((j)localObject).cZQ = new j.a()
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
  
  private void cjc()
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
    this.qeH.setVisibility(8);
    this.qeH.startAnimation(localAlphaAnimation);
    findViewById(2131306517).startAnimation(localAlphaAnimation);
    findViewById(2131299817).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(106808);
  }
  
  public final void cjb()
  {
    AppMethodBeat.i(106802);
    this.qeB.setVisibility(0);
    this.qeC.setVisibility(8);
    this.qeF.setVisibility(8);
    this.qeE.setVisibility(0);
    this.qeG.setText(2131758841);
    this.qeA.setBackgroundResource(2131233811);
    this.qeA.setText(2131758953);
    this.qeD.setVisibility(4);
    this.omf = false;
    AppMethodBeat.o(106802);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106799);
    super.onCreate(paramBundle);
    setContentView(y.js(this).inflate(2131493974, null));
    this.qeD = ((ImageView)findViewById(2131306518));
    this.qeE = findViewById(2131306519);
    this.qeF = findViewById(2131306521);
    this.qeB = findViewById(2131306525);
    this.qeC = findViewById(2131306526);
    this.qeG = ((TextView)findViewById(2131306527));
    this.qeH = findViewById(2131306520);
    findViewById(2131306517).setVisibility(8);
    this.qeH.setVisibility(8);
    findViewById(2131306517).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106790);
        FavPostVoiceUI.c(FavPostVoiceUI.this);
        AppMethodBeat.o(106790);
        return false;
      }
    });
    findViewById(2131299817).setVisibility(8);
    this.omk = cja();
    this.qeA = ((Button)findViewById(2131299816));
    this.qeA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106793);
        if (paramAnonymousView != FavPostVoiceUI.g(FavPostVoiceUI.this))
        {
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
          AppMethodBeat.o(106793);
          return false;
          if (!FavPostVoiceUI.h(FavPostVoiceUI.this))
          {
            FavPostVoiceUI.i(FavPostVoiceUI.this);
            FavPostVoiceUI.j(FavPostVoiceUI.this);
            continue;
            int k = BackwardSupportUtil.b.g(FavPostVoiceUI.this, 60.0F);
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
                AppMethodBeat.o(106793);
                return false;
              }
              if (FavPostVoiceUI.m(FavPostVoiceUI.this).getVisibility() == 0)
              {
                ad.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                FavPostVoiceUI.n(FavPostVoiceUI.this);
              }
              else if (!FavPostVoiceUI.o(FavPostVoiceUI.this))
              {
                FavPostVoiceUI.p(FavPostVoiceUI.this);
                continue;
                ad.w("MicroMsg.FavPostVoiceUI", "action cancel");
                FavPostVoiceUI.n(FavPostVoiceUI.this);
              }
            }
          }
        }
      }
    });
    cjb();
    paramBundle = com.tencent.mm.plugin.fav.a.b.chx();
    Object localObject = new e(paramBundle);
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new e((String)localObject).exists());
    this.path = ((String)localObject);
    this.qeG.post(new Runnable()
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
      cjc();
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
    bSe();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI
 * JD-Core Version:    0.7.0.1
 */