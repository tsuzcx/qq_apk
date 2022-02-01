package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static long zUc = 500L;
  private boolean zUd;
  private boolean zUe;
  private View zUf;
  private View zUg;
  private String zUh;
  private long zUi;
  private final Object zUj;
  private volatile boolean zUk;
  private Animation zUl;
  private volatile boolean zUm;
  private volatile boolean zUn;
  private final MTimerHandler.CallBack zUo;
  private final MTimerHandler zUp;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.zUd = false;
    this.zUe = false;
    this.zUf = null;
    this.zUg = null;
    this.zUj = new Object();
    this.zUk = false;
    this.zUm = false;
    this.zUn = false;
    this.zUo = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(271883);
        if (!c.a(c.this))
        {
          Log.w(c.TAG, "hy: already stopped");
          AppMethodBeat.o(271883);
          return false;
        }
        if (c.this.dPl() != null) {
          c.this.dPl().startAnimation(c.b(c.this));
        }
        AppMethodBeat.o(271883);
        return true;
      }
    };
    this.zUp = new MTimerHandler(Looper.getMainLooper(), this.zUo, true);
    this.zUh = paramString;
    this.zUi = paramLong;
    this.zUl = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.slide_right_in);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.zUf = LayoutInflater.from(paramContext).inflate(a.g.face_hint_normal, paramViewGroup1);
    this.zUg = LayoutInflater.from(paramContext).inflate(a.g.face_hint_normal_center, paramViewGroup2);
    this.zUg.setVisibility(4);
    if (dPl() != null) {
      dPl().setText(this.zUh);
    }
    long l = this.zUi;
    Log.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    this.zUp.stopTimer();
    this.zUk = true;
    this.zUp.startTimer(0L, l);
    AppMethodBeat.o(103822);
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(103823);
    if ((this.zUd) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
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
      this.zUd = true;
      if (!this.zUm)
      {
        PlaySound.play(MMApplicationContext.getContext(), a.i.qrcode_completed);
        paramFaceCharacteristicsResult = (TextView)this.zUf.findViewById(a.e.hint_msg_tv);
        Animation localAnimation1 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.faded_out);
        Animation localAnimation2 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), a.a.fast_faded_in);
        localAnimation1.setDuration(zUc);
        localAnimation2.setDuration(zUc);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.zUg.setVisibility(0);
        this.zUg.startAnimation(localAnimation2);
        this.zUg.findViewById(a.e.face_normal_confirm_btn).setOnClickListener(new c.2(this));
        this.zUm = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final boolean dPg()
  {
    return (this.zUd) && (this.zUe);
  }
  
  public final boolean dPh()
  {
    return false;
  }
  
  public final void dPi()
  {
    AppMethodBeat.i(103825);
    this.zUk = false;
    this.zUp.stopTimer();
    this.zUd = false;
    this.zUm = false;
    this.zUn = false;
    this.zUe = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b dPj()
  {
    AppMethodBeat.i(103826);
    if (this.zUd)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a dPk()
  {
    AppMethodBeat.i(103827);
    if ((this.zUd) && (!this.zUn))
    {
      this.zUn = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final TextView dPl()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.zUd) && (this.zUf != null))
    {
      localTextView = (TextView)this.zUf.findViewById(a.e.hint_msg_tv);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.zUd) && (this.zUg != null))
    {
      localTextView = (TextView)this.zUg.findViewById(a.e.hint_msg_tv);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    AppMethodBeat.o(103820);
    return null;
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(103821);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getHintMsgTv() == null : ");
    if (dPl() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(str, bool);
      if (dPl() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    dPl().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */