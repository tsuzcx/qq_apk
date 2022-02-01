package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public class FavPostVoiceUI
  extends MMBaseActivity
{
  private static final int[] AhQ = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private static final int[] pgL = { q.d.amp1, q.d.amp2, q.d.amp3, q.d.amp4, q.d.amp5, q.d.amp6, q.d.amp7 };
  private Button AhI;
  private View AhJ;
  private View AhK;
  private ImageView AhL;
  private View AhM;
  private View AhN;
  private TextView AhO;
  private View AhP;
  private long duration;
  boolean isFinishing;
  private String path;
  private final MTimerHandler pgR;
  private int pvg;
  private boolean xxL;
  private long xxM;
  private boolean xxN;
  private long xxO;
  private Toast xxP;
  private j xxQ;
  private final MMHandler xxY;
  private final MTimerHandler xxZ;
  
  public FavPostVoiceUI()
  {
    AppMethodBeat.i(106798);
    this.xxO = -1L;
    this.pgR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        int j = 0;
        AppMethodBeat.i(106789);
        j localj = FavPostVoiceUI.a(FavPostVoiceUI.this);
        int i;
        if (localj.status == 1)
        {
          i = localj.hxT.aGI();
          if (i > j.hxV) {
            j.hxV = i;
          }
          i = i * 100 / j.hxV;
        }
        for (;;)
        {
          if (j < FavPostVoiceUI.pgL.length)
          {
            if ((i >= FavPostVoiceUI.dRV()[j]) && (i < FavPostVoiceUI.dRV()[(j + 1)])) {
              FavPostVoiceUI.b(FavPostVoiceUI.this).setBackgroundResource(FavPostVoiceUI.pgL[j]);
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
    this.xxY = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106794);
        super.handleMessage(paramAnonymousMessage);
        FavPostVoiceUI.this.dRT();
        FavPostVoiceUI.g(FavPostVoiceUI.this).setBackgroundResource(q.d.record_shape_press);
        FavPostVoiceUI.g(FavPostVoiceUI.this).setEnabled(true);
        AppMethodBeat.o(106794);
      }
    };
    this.xxZ = new MTimerHandler(new MTimerHandler.CallBack()
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
          FavPostVoiceUI.a(FavPostVoiceUI.this, Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(q.i.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
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
          FavPostVoiceUI.r(FavPostVoiceUI.this).setText(FavPostVoiceUI.this.getString(q.i.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
        }
        AppMethodBeat.o(106795);
        return true;
      }
    }, true);
    this.isFinishing = false;
    AppMethodBeat.o(106798);
  }
  
  private j dRS()
  {
    AppMethodBeat.i(106800);
    Object localObject = c.a.lQe;
    localObject = new j();
    ((j)localObject).hxU = new j.a()
    {
      public final void atR()
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
  
  private void dRU()
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
    findViewById(q.e.voice_rcd_hint).setVisibility(8);
    findViewById(q.e.fav_post_voice_footer).setVisibility(8);
    this.AhP.setVisibility(8);
    this.AhP.startAnimation(localAlphaAnimation);
    findViewById(q.e.voice_rcd_hint).startAnimation(localAlphaAnimation);
    findViewById(q.e.fav_post_voice_footer).startAnimation(localTranslateAnimation);
    AppMethodBeat.o(106808);
  }
  
  private void dwa()
  {
    long l = 0L;
    AppMethodBeat.i(106801);
    if (!this.xxL)
    {
      AppMethodBeat.o(106801);
      return;
    }
    this.AhI.setKeepScreenOn(true);
    this.AhI.setBackgroundResource(q.d.record_shape_normal);
    this.AhI.setText(q.i.favorite_press_talk_to_fav);
    this.xxQ.aGH();
    int i;
    label83:
    String str;
    if (this.xxM == 0L)
    {
      this.duration = l;
      if (this.duration >= 800L) {
        break label167;
      }
      i = 1;
      this.pgR.stopTimer();
      this.xxZ.stopTimer();
      if (i != 0) {
        break label299;
      }
      str = this.path;
      i = (int)this.duration;
      if (!Util.isNullOrNil(str)) {
        break label172;
      }
      Log.e("MicroMsg.FavPostLogic", "postVoice path null");
      label130:
      setResult(-1);
      finish();
      BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
    }
    for (;;)
    {
      this.xxL = false;
      AppMethodBeat.o(106801);
      return;
      l = Util.ticksToNow(this.xxM);
      break;
      label167:
      i = 0;
      break label83;
      label172:
      g localg = new g();
      localg.field_type = 3;
      localg.field_sourceType = 6;
      k.G(localg);
      arf localarf = new arf();
      localarf.bsC(str);
      localarf.axx(i);
      localarf.Kk(true);
      localarf.axy(localg.field_type);
      localarf.bsy("amr");
      localg.field_favProto.vEn.add(localarf);
      a.C(localg);
      h.OAn.b(10648, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
      break label130;
      label299:
      dwc();
      this.AhI.setEnabled(false);
      this.AhI.setBackgroundResource(q.d.record_shape_disable);
      this.AhK.setVisibility(0);
      this.AhJ.setVisibility(8);
      this.xxY.sendEmptyMessageDelayed(0, 500L);
    }
  }
  
  private void dwc()
  {
    AppMethodBeat.i(106803);
    u localu = new u(this.path);
    if (localu.jKS()) {
      localu.diJ();
    }
    AppMethodBeat.o(106803);
  }
  
  public final void dRT()
  {
    AppMethodBeat.i(106802);
    this.AhJ.setVisibility(0);
    this.AhK.setVisibility(8);
    this.AhN.setVisibility(8);
    this.AhM.setVisibility(0);
    this.AhO.setText(q.i.fav_press_talk_start_record);
    this.AhI.setBackgroundResource(q.d.record_shape_press);
    this.AhI.setText(q.i.favorite_press_talk_to_fav);
    this.AhL.setVisibility(4);
    this.xxL = false;
    AppMethodBeat.o(106802);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106799);
    super.onCreate(paramBundle);
    setContentView(af.mU(this).inflate(q.f.fav_post_voice, null));
    this.AhL = ((ImageView)findViewById(q.e.voice_rcd_hint_anim));
    this.AhM = findViewById(q.e.voice_rcd_hint_anim_area);
    this.AhN = findViewById(q.e.voice_rcd_hint_cancel_area);
    this.AhJ = findViewById(q.e.voice_rcd_hint_rcding);
    this.AhK = findViewById(q.e.voice_rcd_hint_tooshort);
    this.AhO = ((TextView)findViewById(q.e.voice_rcd_hint_word));
    this.AhP = findViewById(q.e.voice_rcd_hint_bg);
    findViewById(q.e.voice_rcd_hint).setVisibility(8);
    this.AhP.setVisibility(8);
    findViewById(q.e.voice_rcd_hint).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106790);
        FavPostVoiceUI.c(FavPostVoiceUI.this);
        AppMethodBeat.o(106790);
        return false;
      }
    });
    findViewById(q.e.fav_post_voice_footer).setVisibility(8);
    this.xxQ = dRS();
    this.AhI = ((Button)findViewById(q.e.fav_post_voice_btn));
    this.AhI.setOnTouchListener(new View.OnTouchListener()
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
    dRT();
    paramBundle = com.tencent.mm.plugin.fav.a.b.dQe();
    Object localObject = new u(paramBundle);
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    do
    {
      localObject = paramBundle + "/" + System.currentTimeMillis();
    } while (new u((String)localObject).jKS());
    this.path = ((String)localObject);
    this.AhO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106791);
        FavPostVoiceUI.this.findViewById(q.e.voice_rcd_hint).setVisibility(0);
        FavPostVoiceUI.d(FavPostVoiceUI.this).setVisibility(0);
        FavPostVoiceUI.this.findViewById(q.e.fav_post_voice_footer).setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(300L);
        FavPostVoiceUI.d(FavPostVoiceUI.this).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(q.e.voice_rcd_hint).startAnimation(localAlphaAnimation);
        FavPostVoiceUI.this.findViewById(q.e.fav_post_voice_footer).startAnimation(localTranslateAnimation);
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
      dRU();
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
    dwa();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI
 * JD-Core Version:    0.7.0.1
 */