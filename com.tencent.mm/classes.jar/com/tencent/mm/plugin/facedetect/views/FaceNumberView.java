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
import com.tencent.mm.cd.a;
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
  private String zYF;
  private int zYG;
  private ViewGroup zYH;
  public FaceNumberItemView[] zYI;
  private int zYJ;
  private Animation zYK;
  private FaceNumberView.a zYL;
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104176);
    this.zYF = null;
    this.zYI = null;
    this.zYJ = 0;
    this.zYK = null;
    this.zYL = FaceNumberView.a.zYN;
    this.zYH = ((ViewGroup)inflate(getContext(), a.g.face_number_view, null));
    addView(this.zYH);
    this.zYK = AnimationUtils.loadAnimation(getContext(), a.a.pop_in);
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
  
  private void dPL()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(104177);
    if ((this.zYI != null) && (this.zYI.length > 0))
    {
      if (!Util.isNullOrNil(this.zYF))
      {
        i = j;
        if (i < this.zYI.length)
        {
          String str;
          FaceNumberItemView localFaceNumberItemView;
          if (this.zYG > i)
          {
            str = this.zYF.charAt(i);
            if (this.zYG == i + 1)
            {
              localFaceNumberItemView = this.zYI[i];
              localFaceNumberItemView.dPK();
              FaceNumberItemView.a locala = new FaceNumberItemView.a(localFaceNumberItemView.zYC);
              localFaceNumberItemView.zYu = new MTimerHandler(Looper.getMainLooper(), locala, true);
              localFaceNumberItemView.zYu.startTimer(0L, FaceNumberItemView.zYv);
            }
          }
          for (;;)
          {
            a(this.zYI[i], str);
            i += 1;
            break;
            this.zYI[i].dPK();
            localFaceNumberItemView = this.zYI[i];
            localFaceNumberItemView.zYB = 30;
            localFaceNumberItemView.invalidate();
            continue;
            str = "";
          }
        }
        AppMethodBeat.o(104177);
        return;
      }
      while (i < this.zYI.length)
      {
        a(this.zYI[i], "point");
        i += 1;
      }
    }
    AppMethodBeat.o(104177);
  }
  
  private void dPM()
  {
    AppMethodBeat.i(104179);
    if (this.zYF != null)
    {
      this.zYG = this.zYF.length();
      AppMethodBeat.o(104179);
      return;
    }
    this.zYG = 0;
    AppMethodBeat.o(104179);
  }
  
  public final void atN(String paramString)
  {
    AppMethodBeat.i(104180);
    this.zYF = paramString;
    dPM();
    dPL();
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
    if (paramInt == this.zYJ)
    {
      Log.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
      atN(null);
      AppMethodBeat.o(104175);
      return;
    }
    this.zYH.removeAllViews();
    this.zYJ = paramInt;
    this.zYI = new FaceNumberItemView[this.zYJ];
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
        this.zYI[k] = localFaceNumberItemView;
        this.zYH.addView(localFaceNumberItemView, new ViewGroup.LayoutParams(i, getResources().getDimensionPixelSize(a.c.face_number_height)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */