package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Timer;

public class FaceNumberView
  extends LinearLayout
{
  private String qEE;
  private int qEF;
  private ViewGroup qEG;
  public FaceNumberItemView[] qEH;
  private int qEI;
  private Animation qEJ;
  private FaceNumberView.a qEK;
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104176);
    this.qEE = null;
    this.qEH = null;
    this.qEI = 0;
    this.qEJ = null;
    this.qEK = FaceNumberView.a.qEM;
    this.qEG = ((ViewGroup)inflate(getContext(), 2131493915, null));
    addView(this.qEG);
    this.qEJ = AnimationUtils.loadAnimation(getContext(), 2130772095);
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
      paramFaceNumberItemView.setImageResource(2131232141);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("1"))
    {
      paramFaceNumberItemView.setImageResource(2131232142);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("2"))
    {
      paramFaceNumberItemView.setImageResource(2131232143);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("3"))
    {
      paramFaceNumberItemView.setImageResource(2131232144);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("4"))
    {
      paramFaceNumberItemView.setImageResource(2131232145);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("5"))
    {
      paramFaceNumberItemView.setImageResource(2131232146);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("6"))
    {
      paramFaceNumberItemView.setImageResource(2131232147);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("7"))
    {
      paramFaceNumberItemView.setImageResource(2131232148);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("8"))
    {
      paramFaceNumberItemView.setImageResource(2131232149);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("9"))
    {
      paramFaceNumberItemView.setImageResource(2131232150);
      AppMethodBeat.o(104178);
      return;
    }
    paramFaceNumberItemView.setImageResource(2131232151);
    AppMethodBeat.o(104178);
  }
  
  private void coE()
  {
    int i = 0;
    AppMethodBeat.i(104177);
    if ((this.qEH != null) && (this.qEH.length > 0))
    {
      if (!bs.isNullOrNil(this.qEE))
      {
        i = 0;
        if (i < this.qEH.length)
        {
          String str;
          FaceNumberItemView localFaceNumberItemView;
          if (this.qEF > i)
          {
            str = this.qEE.charAt(i);
            if (this.qEF == i + 1)
            {
              localFaceNumberItemView = this.qEH[i];
              if (localFaceNumberItemView.qEt != null) {
                localFaceNumberItemView.coD();
              }
              localFaceNumberItemView.qEt = new Timer("FaceNumberItemView_karaoke", true);
              FaceNumberItemView.a locala = new FaceNumberItemView.a(localFaceNumberItemView, localFaceNumberItemView.qEB, (byte)0);
              localFaceNumberItemView.qEt.scheduleAtFixedRate(locala, 0L, FaceNumberItemView.qEu);
            }
          }
          for (;;)
          {
            a(this.qEH[i], str);
            i += 1;
            break;
            this.qEH[i].coD();
            localFaceNumberItemView = this.qEH[i];
            localFaceNumberItemView.qEA = 30;
            localFaceNumberItemView.invalidate();
            continue;
            str = "";
          }
        }
        AppMethodBeat.o(104177);
        return;
      }
      while (i < this.qEH.length)
      {
        a(this.qEH[i], "point");
        i += 1;
      }
    }
    AppMethodBeat.o(104177);
  }
  
  private void coF()
  {
    AppMethodBeat.i(104179);
    if (this.qEE != null)
    {
      this.qEF = this.qEE.length();
      AppMethodBeat.o(104179);
      return;
    }
    this.qEF = 0;
    AppMethodBeat.o(104179);
  }
  
  public final void acl(String paramString)
  {
    AppMethodBeat.i(104180);
    this.qEE = paramString;
    coF();
    coE();
    AppMethodBeat.o(104180);
  }
  
  public void setNumberLengthAndInflate(int paramInt)
  {
    AppMethodBeat.i(104175);
    if (paramInt > 12)
    {
      ac.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(104175);
      return;
    }
    if (paramInt <= 0)
    {
      ac.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(104175);
      return;
    }
    if (paramInt == this.qEI)
    {
      ac.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
      acl(null);
      AppMethodBeat.o(104175);
      return;
    }
    this.qEG.removeAllViews();
    this.qEI = paramInt;
    this.qEH = new FaceNumberItemView[this.qEI];
    int k = 0;
    if (k < paramInt)
    {
      FaceNumberItemView localFaceNumberItemView = (FaceNumberItemView)inflate(getContext(), 2131493916, null);
      localFaceNumberItemView.setImageResource(2131232151);
      int j;
      int i;
      if (k == 0)
      {
        j = 3;
        i = (getResources().getDimensionPixelSize(2131166279) + a.fromDPToPix(getContext(), 48)) / 2;
      }
      for (;;)
      {
        localFaceNumberItemView.setGravity(j);
        this.qEH[k] = localFaceNumberItemView;
        this.qEG.addView(localFaceNumberItemView, new ViewGroup.LayoutParams(i, getResources().getDimensionPixelSize(2131166277)));
        k += 1;
        break;
        if (k == paramInt - 1)
        {
          j = 5;
          i = (getResources().getDimensionPixelSize(2131166279) + a.fromDPToPix(getContext(), 48)) / 2;
        }
        else
        {
          j = 17;
          i = getResources().getDimensionPixelSize(2131166279);
        }
      }
    }
    AppMethodBeat.o(104175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */