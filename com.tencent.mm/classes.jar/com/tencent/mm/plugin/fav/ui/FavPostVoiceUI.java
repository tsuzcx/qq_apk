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
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.vfs.q;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] mmY = { s.d.amp1, s.d.amp2, s.d.amp3, s.d.amp4, s.d.amp5, s.d.amp6, s.d.amp7 };
  private static final int[] wLs = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private View cCj;
  private long duration;
  boolean isFinishing;
  private final MTimerHandler mnf;
  private int pEk;
  private String path;
  private final MMHandler urD;
  private final MTimerHandler urE;
  private boolean urq;
  private long urr;
  private boolean urs;
  private long urt;
  private Toast uru;
  private j urv;
  private Button wLl;
  private View wLm;
  private View wLn;
  private ImageView wLo;
  private View wLp;
  private View wLq;
  private TextView wLr;
  
  public FavPostVoiceUI()
  {
    AppMethodBeat.i(106798);
    this.urt = -1L;
    this.mnf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        int j = 0;
        AppMethodBeat.i(106789);
        j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
        int i;
        if (localj.status == 1)
        {
          i = localj.ftE.aeK();
          if (i > j.ftG) {
            j.ftG = i;
          }
          i = i * 100 / j.ftG;
        }
        for (;;)
        {
          if (j < FavPostVoiceUI.mmY.length)
          {
            if ((i >= FavPostVoiceUI.dlf()[j]) && (i < FavPostVoiceUI.dlf()[(j + 1)])) {
              FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.mmY[j]);
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
    this.urD = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106794);
        super.handleMessage(paramAnonymousMessage);
        FavPostVoiceUI.this.dld();
        FavPostVoiceUI.g(FavPostVoiceUI.this).setBackgroundResource(s.d.record_shape_press);
        FavPostVoiceUI.g(FavPostVoiceUI.this).setEnabled(true);
        AppMethodBeat.o(106794);
      }
    };
    this.urE = new MTimerHandler(new MTimerHandler.CallBack()
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
            break label160;
          }
          FavPostVoiceUI.a(FavPostVoiceUI.this, Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(s.i.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
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
          label160:
          FavPostVoiceUI.r(FavPostVoiceUI.this).setText(FavPostVoiceUI.this.getString(s.i.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(106795);
        return true;
      }
    }, true);
    this.isFinishing = false;
    AppMethodBeat.o(106798);
  }
  
  private void cRH()
  {
    long l = 0L;
    AppMethodBeat.i(106801);
    if (!this.urq)
    {
      AppMethodBeat.o(106801);
      return;
    }
    this.wLl.setKeepScreenOn(true);
    this.wLl.setBackgroundResource(s.d.record_shape_normal);
    this.wLl.setText(s.i.favorite_press_talk_to_fav);
    this.urv.aeJ();
    int i;
    label83:
    String str;
    if (this.urr == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label165;
      }
      i = 1;
      this.mnf.stopTimer();
      this.urE.stopTimer();
      if (i != 0) {
        break label296;
      }
      str = this.path;
      i = (int)this.duration;
      if (!Util.isNullOrNil(str)) {
        break label170;
      }
      Log.e("MicroMsg.FavPostLogic", "postVoice path null");
      label128:
      setResult(-1);
      finish();
      BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
    }
    for (;;)
    {
      this.urq = false;
      AppMethodBeat.o(106801);
      return;
      l = Util.ticksToNow(this.urr);
      break;
      label165:
      i = 0;
      break label83;
      label170:
      g localg = new g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      k.G(localg);
      anm localanm = new anm();
      localanm.bsL(str);
      localanm.arp(i);
      localanm.Ey(true);
      localanm.arq(localg.field_type);
      localanm.bsH("amr");
      localg.field_favProto.syG.add(localanm);
      b.C(localg);
      h.IzE.a(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label128;
      label296:
      cRJ();
      this.wLl.setEnabled(false);
      this.wLl.setBackgroundResource(s.d.record_shape_disable);
      this.wLn.setVisibility(0);
      this.wLm.setVisibility(8);
      this.urD.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void cRJ()
  {
    AppMethodBeat.i(106803);
    q localq = new q(this.path);
    if (localq.ifE()) {
      localq.cFq();
    }
    AppMethodBeat.o(106803);
  }
  
  private j dlc()
  {
    AppMethodBeat.i(106800);
    Object localObject = c.a.jmT;
    localObject = new j();
    ((j)localObject).ftF = new j.a()
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
  
  private void dle()
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
    findViewById(s.e.voice_rcd_hint).setVisibility(8);
    findViewById(s.e.fav_post_voice_footer).setVisibility(8);
    this.cCj.setVisibility(8);
    this.cCj.startAnimation(localAlphaAnimation);
    findViewById(s.e.voice_rcd_hint).startAnimation(localAlphaAnimation);
    findViewById(s.e.fav_post_voice_footer).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(106808);
  }
  
  public final void dld()
  {
    AppMethodBeat.i(106802);
    this.wLm.setVisibility(0);
    this.wLn.setVisibility(8);
    this.wLq.setVisibility(8);
    this.wLp.setVisibility(0);
    this.wLr.setText(s.i.fav_press_talk_start_record);
    this.wLl.setBackgroundResource(s.d.record_shape_press);
    this.wLl.setText(s.i.favorite_press_talk_to_fav);
    this.wLo.setVisibility(4);
    this.urq = false;
    AppMethodBeat.o(106802);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106799);
    super.onCreate(paramBundle);
    setContentView(ad.kS(this).inflate(s.f.fav_post_voice, null));
    this.wLo = ((ImageView)findViewById(s.e.voice_rcd_hint_anim));
    this.wLp = findViewById(s.e.voice_rcd_hint_anim_area);
    this.wLq = findViewById(s.e.voice_rcd_hint_cancel_area);
    this.wLm = findViewById(s.e.voice_rcd_hint_rcding);
    this.wLn = findViewById(s.e.voice_rcd_hint_tooshort);
    this.wLr = ((TextView)findViewById(s.e.voice_rcd_hint_word));
    this.cCj = findViewById(s.e.voice_rcd_hint_bg);
    findViewById(s.e.voice_rcd_hint).setVisibility(8);
    this.cCj.setVisibility(8);
    findViewById(s.e.voice_rcd_hint).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106790);
        FavPostVoiceUI.c(FavPostVoiceUI.this);
        AppMethodBeat.o(106790);
        return false;
      }
    });
    findViewById(s.e.fav_post_voice_footer).setVisibility(8);
    this.urv = dlc();
    this.wLl = ((Button)findViewById(s.e.fav_post_voice_btn));
    this.wLl.setOnTouchListener(new View.OnTouchListener()
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
    dld();
    paramBundle = com.tencent.mm.plugin.fav.a.b.djt();
    Object localObject = new q(paramBundle);
    if (!((q)localObject).ifE()) {
      ((q)localObject).ifL();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new q((String)localObject).ifE());
    this.path = ((String)localObject);
    this.wLr.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106791);
        FavPostVoiceUI.this.findViewById(s.e.voice_rcd_hint).setVisibility(0);
        FavPostVoiceUI.d(FavPostVoiceUI.this).setVisibility(0);
        FavPostVoiceUI.this.findViewById(s.e.fav_post_voice_footer).setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(300L);
        FavPostVoiceUI.d(FavPostVoiceUI.this).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(s.e.voice_rcd_hint).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(s.e.fav_post_voice_footer).startAnimation(localTranslateAnimation);
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
      dle();
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
    cRH();
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