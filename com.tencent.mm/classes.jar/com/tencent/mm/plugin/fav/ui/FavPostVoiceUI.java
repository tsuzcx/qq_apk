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
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] jxw = { 2131230948, 2131230949, 2131230950, 2131230951, 2131230952, 2131230953, 2131230954 };
  private static final int[] tfe = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private View cBH;
  private long duration;
  boolean isFinishing;
  private final MTimerHandler jxC;
  private int mEY;
  private String path;
  private boolean qPk;
  private long qPl;
  private boolean qPm;
  private long qPn;
  private Toast qPo;
  private j qPp;
  private final MMHandler qPx;
  private final MTimerHandler qPy;
  private Button teX;
  private View teY;
  private View teZ;
  private ImageView tfa;
  private View tfb;
  private View tfc;
  private TextView tfd;
  
  public FavPostVoiceUI()
  {
    AppMethodBeat.i(106798);
    this.qPn = -1L;
    this.jxC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        int j = 0;
        AppMethodBeat.i(106789);
        j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
        int i;
        if (localj.status == 1)
        {
          i = localj.dAP.getMaxAmplitude();
          if (i > j.dAR) {
            j.dAR = i;
          }
          i = i * 100 / j.dAR;
        }
        for (;;)
        {
          if (j < FavPostVoiceUI.jxw.length)
          {
            if ((i >= FavPostVoiceUI.cVZ()[j]) && (i < FavPostVoiceUI.cVZ()[(j + 1)])) {
              FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.jxw[j]);
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
    this.qPx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106794);
        super.handleMessage(paramAnonymousMessage);
        FavPostVoiceUI.this.cVX();
        FavPostVoiceUI.g(FavPostVoiceUI.this).setBackgroundResource(2131234634);
        FavPostVoiceUI.g(FavPostVoiceUI.this).setEnabled(true);
        AppMethodBeat.o(106794);
      }
    };
    this.qPy = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(106795);
        if (FavPostVoiceUI.q(FavPostVoiceUI.this) == -1L) {
          FavPostVoiceUI.a(FavPostVoiceUI.this, Util.currentTicks());
        }
        long l = Util.ticksToNow(FavPostVoiceUI.q(FavPostVoiceUI.this));
        if ((l >= 3590000L) && (l <= 3600000L))
        {
          if (FavPostVoiceUI.r(FavPostVoiceUI.this) != null) {
            break label159;
          }
          FavPostVoiceUI.a(FavPostVoiceUI.this, Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(2131759165, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
        }
        for (;;)
        {
          FavPostVoiceUI.r(FavPostVoiceUI.this).show();
          if (l < 3600000L) {
            break;
          }
          Log.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
          FavPostVoiceUI.s(FavPostVoiceUI.this);
          FavPostVoiceUI.p(FavPostVoiceUI.this);
          AppMethodBeat.o(106795);
          return false;
          label159:
          FavPostVoiceUI.r(FavPostVoiceUI.this).setText(FavPostVoiceUI.this.getString(2131759165, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(106795);
        return true;
      }
    }, true);
    this.isFinishing = false;
    AppMethodBeat.o(106798);
  }
  
  private void cDc()
  {
    long l = 0L;
    AppMethodBeat.i(106801);
    if (!this.qPk)
    {
      AppMethodBeat.o(106801);
      return;
    }
    this.teX.setKeepScreenOn(true);
    this.teX.setBackgroundResource(2131234633);
    this.teX.setText(2131759277);
    this.qPp.ZZ();
    int i;
    label81:
    String str;
    if (this.qPl == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label163;
      }
      i = 1;
      this.jxC.stopTimer();
      this.qPy.stopTimer();
      if (i != 0) {
        break label294;
      }
      str = this.path;
      i = (int)this.duration;
      if (!Util.isNullOrNil(str)) {
        break label168;
      }
      Log.e("MicroMsg.FavPostLogic", "postVoice path null");
      label126:
      setResult(-1);
      finish();
      BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
    }
    for (;;)
    {
      this.qPk = false;
      AppMethodBeat.o(106801);
      return;
      l = Util.ticksToNow(this.qPl);
      break;
      label163:
      i = 0;
      break label81;
      label168:
      g localg = new g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      k.G(localg);
      aml localaml = new aml();
      localaml.bgt(str);
      localaml.ajc(i);
      localaml.At(true);
      localaml.ajd(localg.field_type);
      localaml.bgp("amr");
      localg.field_favProto.ppH.add(localaml);
      b.C(localg);
      h.CyF.a(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label126;
      label294:
      cDe();
      this.teX.setEnabled(false);
      this.teX.setBackgroundResource(2131234632);
      this.teZ.setVisibility(0);
      this.teY.setVisibility(8);
      this.qPx.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void cDe()
  {
    AppMethodBeat.i(106803);
    o localo = new o(this.path);
    if (localo.exists()) {
      localo.delete();
    }
    AppMethodBeat.o(106803);
  }
  
  private j cVW()
  {
    AppMethodBeat.i(106800);
    Object localObject = c.a.gCN;
    localObject = new j();
    ((j)localObject).dAQ = new j.a()
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
  
  private void cVY()
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
            BackwardSupportUtil.AnimationHelper.overridePendingTransition(FavPostVoiceUI.this, 0, 0);
            AppMethodBeat.o(106796);
          }
        });
        AppMethodBeat.o(106797);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    findViewById(2131309977).setVisibility(8);
    findViewById(2131300493).setVisibility(8);
    this.cBH.setVisibility(8);
    this.cBH.startAnimation(localAlphaAnimation);
    findViewById(2131309977).startAnimation(localAlphaAnimation);
    findViewById(2131300493).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(106808);
  }
  
  public final void cVX()
  {
    AppMethodBeat.i(106802);
    this.teY.setVisibility(0);
    this.teZ.setVisibility(8);
    this.tfc.setVisibility(8);
    this.tfb.setVisibility(0);
    this.tfd.setText(2131759164);
    this.teX.setBackgroundResource(2131234634);
    this.teX.setText(2131759277);
    this.tfa.setVisibility(4);
    this.qPk = false;
    AppMethodBeat.o(106802);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106799);
    super.onCreate(paramBundle);
    setContentView(aa.jQ(this).inflate(2131494144, null));
    this.tfa = ((ImageView)findViewById(2131309978));
    this.tfb = findViewById(2131309979);
    this.tfc = findViewById(2131309981);
    this.teY = findViewById(2131309985);
    this.teZ = findViewById(2131309986);
    this.tfd = ((TextView)findViewById(2131309987));
    this.cBH = findViewById(2131309980);
    findViewById(2131309977).setVisibility(8);
    this.cBH.setVisibility(8);
    findViewById(2131309977).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106790);
        FavPostVoiceUI.c(FavPostVoiceUI.this);
        AppMethodBeat.o(106790);
        return false;
      }
    });
    findViewById(2131300493).setVisibility(8);
    this.qPp = cVW();
    this.teX = ((Button)findViewById(2131300492));
    this.teX.setOnTouchListener(new View.OnTouchListener()
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
            int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(FavPostVoiceUI.this, 60.0F);
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
                Log.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                FavPostVoiceUI.n(FavPostVoiceUI.this);
              }
              else if (!FavPostVoiceUI.o(FavPostVoiceUI.this))
              {
                FavPostVoiceUI.p(FavPostVoiceUI.this);
                continue;
                Log.w("MicroMsg.FavPostVoiceUI", "action cancel");
                FavPostVoiceUI.n(FavPostVoiceUI.this);
              }
            }
          }
        }
      }
    });
    cVX();
    paramBundle = com.tencent.mm.plugin.fav.a.b.cUn();
    Object localObject = new o(paramBundle);
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new o((String)localObject).exists());
    this.path = ((String)localObject);
    this.tfd.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106791);
        FavPostVoiceUI.this.findViewById(2131309977).setVisibility(0);
        FavPostVoiceUI.d(FavPostVoiceUI.this).setVisibility(0);
        FavPostVoiceUI.this.findViewById(2131300493).setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(300L);
        FavPostVoiceUI.d(FavPostVoiceUI.this).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(2131309977).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(2131300493).startAnimation(localTranslateAnimation);
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
      cVY();
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
    cDc();
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