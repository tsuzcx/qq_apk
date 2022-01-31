package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Timer;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long jPa = 500L;
  private boolean jPb = false;
  private boolean jPc = false;
  private View jPd = null;
  private View jPe = null;
  private String jPf;
  private long jPg;
  private final Object jPh = new Object();
  private Timer jPi = null;
  private volatile boolean jPj = false;
  private Animation jPk;
  private volatile boolean jPl = false;
  private volatile boolean jPm = false;
  
  public c(String paramString, long paramLong)
  {
    this.jPf = paramString;
    this.jPg = paramLong;
    this.jPk = AnimationUtils.loadAnimation(ae.getContext(), a.a.slide_right_in);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.jPd = LayoutInflater.from(paramContext).inflate(a.g.face_hint_normal, paramViewGroup1);
    this.jPe = LayoutInflater.from(paramContext).inflate(a.g.face_hint_normal_center, paramViewGroup2);
    this.jPe.setVisibility(4);
    if (aOO() != null) {
      aOO().setText(this.jPf);
    }
    long l = this.jPg;
    y.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.jPi != null) {
      this.jPi.cancel();
    }
    this.jPi = new Timer("FaceDetect_hint", true);
    this.jPj = true;
    this.jPi.scheduleAtFixedRate(new c.2(this), 0L, l);
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    if ((this.jPb) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      y.d(TAG, "hy: ignore too active");
      return true;
    }
    return false;
  }
  
  public final boolean aOJ()
  {
    return (this.jPb) && (this.jPc);
  }
  
  public final boolean aOK()
  {
    return false;
  }
  
  public final void aOL()
  {
    this.jPj = false;
    if (this.jPi != null) {
      this.jPi.cancel();
    }
    this.jPb = false;
    this.jPl = false;
    this.jPm = false;
    this.jPc = false;
  }
  
  public final b.b aOM()
  {
    if (this.jPb) {
      return new b.b(90025, "user cancelled in intermediate page");
    }
    return new b.b(90004, "user cancelled in processing");
  }
  
  public final b.a aON()
  {
    if ((this.jPb) && (!this.jPm))
    {
      this.jPm = true;
      return new b.a();
    }
    return null;
  }
  
  public final TextView aOO()
  {
    if ((!this.jPb) && (this.jPd != null)) {
      return (TextView)this.jPd.findViewById(a.e.hint_msg_tv);
    }
    if ((this.jPb) && (this.jPe != null)) {
      return (TextView)this.jPe.findViewById(a.e.hint_msg_tv);
    }
    return null;
  }
  
  public final boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    if (paramFaceCharacteristicsResult.errCode == -1)
    {
      this.jPb = true;
      if (!this.jPl)
      {
        au.G(ae.getContext(), a.i.qrcode_completed);
        paramFaceCharacteristicsResult = (TextView)this.jPd.findViewById(a.e.hint_msg_tv);
        Animation localAnimation1 = AnimationUtils.loadAnimation(ae.getContext(), a.a.faded_out);
        Animation localAnimation2 = AnimationUtils.loadAnimation(ae.getContext(), a.a.fast_faded_in);
        localAnimation1.setDuration(jPa);
        localAnimation2.setDuration(jPa);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.jPe.setVisibility(0);
        this.jPe.startAnimation(localAnimation2);
        this.jPe.findViewById(a.e.face_normal_confirm_btn).setOnClickListener(new c.1(this));
        this.jPl = true;
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */