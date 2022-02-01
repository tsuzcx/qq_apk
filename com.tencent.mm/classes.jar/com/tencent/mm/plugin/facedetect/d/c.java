package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long wxV = 500L;
  private boolean wxW;
  private boolean wxX;
  private View wxY;
  private View wxZ;
  private String wya;
  private long wyb;
  private final Object wyc;
  private volatile boolean wyd;
  private Animation wye;
  private volatile boolean wyf;
  private volatile boolean wyg;
  private final MTimerHandler.CallBack wyh;
  private final MTimerHandler wyi;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.wxW = false;
    this.wxX = false;
    this.wxY = null;
    this.wxZ = null;
    this.wyc = new Object();
    this.wyd = false;
    this.wyf = false;
    this.wyg = false;
    this.wyh = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(191972);
        if (!c.a(c.this))
        {
          Log.w(c.TAG, "hy: already stopped");
          AppMethodBeat.o(191972);
          return false;
        }
        if (c.this.diA() != null) {
          c.this.diA().startAnimation(c.b(c.this));
        }
        AppMethodBeat.o(191972);
        return true;
      }
    };
    this.wyi = new MTimerHandler(Looper.getMainLooper(), this.wyh, true);
    this.wya = paramString;
    this.wyb = paramLong;
    this.wye = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.slide_right_in);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.wxY = LayoutInflater.from(paramContext).inflate(a.g.face_hint_normal, paramViewGroup1);
    this.wxZ = LayoutInflater.from(paramContext).inflate(a.g.face_hint_normal_center, paramViewGroup2);
    this.wxZ.setVisibility(4);
    if (diA() != null) {
      diA().setText(this.wya);
    }
    long l = this.wyb;
    Log.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    this.wyi.stopTimer();
    this.wyd = true;
    this.wyi.startTimer(0L, l);
    AppMethodBeat.o(103822);
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(103823);
    if ((this.wxW) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      Log.d(TAG, "hy: ignore too active");
      AppMethodBeat.o(103823);
      return true;
    }
    AppMethodBeat.o(103823);
    return false;
  }
  
  public final boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(103824);
    if (paramFaceCharacteristicsResult.errCode == -1)
    {
      this.wxW = true;
      if (!this.wyf)
      {
        PlaySound.play(MMApplicationContext.getContext(), a.i.qrcode_completed);
        paramFaceCharacteristicsResult = (TextView)this.wxY.findViewById(a.e.hint_msg_tv);
        Animation localAnimation1 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.faded_out);
        Animation localAnimation2 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.fast_faded_in);
        localAnimation1.setDuration(wxV);
        localAnimation2.setDuration(wxV);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.wxZ.setVisibility(0);
        this.wxZ.startAnimation(localAnimation2);
        this.wxZ.findViewById(a.e.face_normal_confirm_btn).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(190702);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/facedetect/motion/NormalFaceMotion$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            c.c(c.this);
            a.a(this, "com/tencent/mm/plugin/facedetect/motion/NormalFaceMotion$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(190702);
          }
        });
        this.wyf = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final TextView diA()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.wxW) && (this.wxY != null))
    {
      localTextView = (TextView)this.wxY.findViewById(a.e.hint_msg_tv);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.wxW) && (this.wxZ != null))
    {
      localTextView = (TextView)this.wxZ.findViewById(a.e.hint_msg_tv);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    AppMethodBeat.o(103820);
    return null;
  }
  
  public final boolean div()
  {
    return (this.wxW) && (this.wxX);
  }
  
  public final boolean diw()
  {
    return false;
  }
  
  public final void dix()
  {
    AppMethodBeat.i(103825);
    this.wyd = false;
    this.wyi.stopTimer();
    this.wxW = false;
    this.wyf = false;
    this.wyg = false;
    this.wxX = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b diy()
  {
    AppMethodBeat.i(103826);
    if (this.wxW)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a diz()
  {
    AppMethodBeat.i(103827);
    if ((this.wxW) && (!this.wyg))
    {
      this.wyg = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(103821);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getHintMsgTv() == null : ");
    if (diA() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(str, bool);
      if (diA() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    diA().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */