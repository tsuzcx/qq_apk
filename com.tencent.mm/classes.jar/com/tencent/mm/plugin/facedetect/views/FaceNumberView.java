package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class FaceNumberView
  extends LinearLayout
{
  private FaceNumberView.a wCA;
  private String wCu;
  private int wCv;
  private ViewGroup wCw;
  public FaceNumberItemView[] wCx;
  private int wCy;
  private Animation wCz;
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104176);
    this.wCu = null;
    this.wCx = null;
    this.wCy = 0;
    this.wCz = null;
    this.wCA = FaceNumberView.a.wCC;
    this.wCw = ((ViewGroup)inflate(getContext(), a.g.face_number_view, null));
    addView(this.wCw);
    this.wCz = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
    AppMethodBeat.o(104176);
  }
  
  private static void a(FaceNumberItemView paramFaceNumberItemView, String paramString)
  {
    AppMethodBeat.i(104178);
    if (paramFaceNumberItemView == null)
    {
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("0"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number0);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("1"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number1);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("2"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number2);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("3"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number3);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("4"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number4);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("5"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number5);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("6"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number6);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("7"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number7);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("8"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number8);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("9"))
    {
      paramFaceNumberItemView.setImageResource(a.d.face_number9);
      AppMethodBeat.o(104178);
      return;
    }
    paramFaceNumberItemView.setImageResource(a.d.face_point);
    AppMethodBeat.o(104178);
  }
  
  private void dja()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(104177);
    if ((this.wCx != null) && (this.wCx.length > 0))
    {
      if (!Util.isNullOrNil(this.wCu))
      {
        i = j;
        if (i < this.wCx.length)
        {
          String str;
          FaceNumberItemView localFaceNumberItemView;
          if (this.wCv > i)
          {
            str = this.wCu.charAt(i);
            if (this.wCv == i + 1)
            {
              localFaceNumberItemView = this.wCx[i];
              localFaceNumberItemView.diZ();
              FaceNumberItemView.a locala = new FaceNumberItemView.a(localFaceNumberItemView.wCr);
              localFaceNumberItemView.wCj = new MTimerHandler(Looper.getMainLooper(), locala, true);
              localFaceNumberItemView.wCj.startTimer(0L, FaceNumberItemView.wCk);
            }
          }
          for (;;)
          {
            a(this.wCx[i], str);
            i += 1;
            break;
            this.wCx[i].diZ();
            localFaceNumberItemView = this.wCx[i];
            localFaceNumberItemView.wCq = 30;
            localFaceNumberItemView.invalidate();
            continue;
            str = "";
          }
        }
        AppMethodBeat.o(104177);
        return;
      }
      while (i < this.wCx.length)
      {
        a(this.wCx[i], "point");
        i += 1;
      }
    }
    AppMethodBeat.o(104177);
  }
  
  private void djb()
  {
    AppMethodBeat.i(104179);
    if (this.wCu != null)
    {
      this.wCv = this.wCu.length();
      AppMethodBeat.o(104179);
      return;
    }
    this.wCv = 0;
    AppMethodBeat.o(104179);
  }
  
  public final void azG(String paramString)
  {
    AppMethodBeat.i(104180);
    this.wCu = paramString;
    djb();
    dja();
    AppMethodBeat.o(104180);
  }
  
  public void setNumberLengthAndInflate(int paramInt)
  {
    AppMethodBeat.i(104175);
    if (paramInt > 12)
    {
      Log.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(104175);
      return;
    }
    if (paramInt <= 0)
    {
      Log.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(104175);
      return;
    }
    if (paramInt == this.wCy)
    {
      Log.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
      azG(null);
      AppMethodBeat.o(104175);
      return;
    }
    this.wCw.removeAllViews();
    this.wCy = paramInt;
    this.wCx = new FaceNumberItemView[this.wCy];
    int k = 0;
    if (k < paramInt)
    {
      FaceNumberItemView localFaceNumberItemView = (FaceNumberItemView)inflate(getContext(), a.g.face_number_view_item, null);
      localFaceNumberItemView.setImageResource(a.d.face_point);
      int j;
      int i;
      if (k == 0)
      {
        j = 3;
        i = (getResources().getDimensionPixelSize(a.c.face_number_width) + a.fromDPToPix(getContext(), 48)) / 2;
      }
      for (;;)
      {
        localFaceNumberItemView.setGravity(j);
        this.wCx[k] = localFaceNumberItemView;
        this.wCw.addView(localFaceNumberItemView, new ViewGroup.LayoutParams(i, getResources().getDimensionPixelSize(a.c.face_number_height)));
        k += 1;
        break;
        if (k == paramInt - 1)
        {
          j = 5;
          i = (getResources().getDimensionPixelSize(a.c.face_number_width) + a.fromDPToPix(getContext(), 48)) / 2;
        }
        else
        {
          j = 17;
          i = getResources().getDimensionPixelSize(a.c.face_number_width);
        }
      }
    }
    AppMethodBeat.o(104175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */