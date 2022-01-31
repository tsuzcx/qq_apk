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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Timer;

public class FaceNumberView
  extends LinearLayout
{
  private String mpq;
  private int mpr;
  private ViewGroup mps;
  public FaceNumberItemView[] mpt;
  private int mpu;
  private Animation mpv;
  private FaceNumberView.a mpw;
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(654);
    this.mpq = null;
    this.mpt = null;
    this.mpu = 0;
    this.mpv = null;
    this.mpw = FaceNumberView.a.mpy;
    this.mps = ((ViewGroup)inflate(getContext(), 2130969502, null));
    addView(this.mps);
    this.mpv = AnimationUtils.loadAnimation(getContext(), 2131034217);
    AppMethodBeat.o(654);
  }
  
  private static void a(FaceNumberItemView paramFaceNumberItemView, String paramString)
  {
    AppMethodBeat.i(656);
    if (paramFaceNumberItemView == null)
    {
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("0"))
    {
      paramFaceNumberItemView.setImageResource(2130838700);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("1"))
    {
      paramFaceNumberItemView.setImageResource(2130838701);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("2"))
    {
      paramFaceNumberItemView.setImageResource(2130838702);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("3"))
    {
      paramFaceNumberItemView.setImageResource(2130838703);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("4"))
    {
      paramFaceNumberItemView.setImageResource(2130838704);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("5"))
    {
      paramFaceNumberItemView.setImageResource(2130838705);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("6"))
    {
      paramFaceNumberItemView.setImageResource(2130838706);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("7"))
    {
      paramFaceNumberItemView.setImageResource(2130838707);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("8"))
    {
      paramFaceNumberItemView.setImageResource(2130838708);
      AppMethodBeat.o(656);
      return;
    }
    if (paramString.equals("9"))
    {
      paramFaceNumberItemView.setImageResource(2130838709);
      AppMethodBeat.o(656);
      return;
    }
    paramFaceNumberItemView.setImageResource(2130838710);
    AppMethodBeat.o(656);
  }
  
  private void bvC()
  {
    int i = 0;
    AppMethodBeat.i(655);
    if ((this.mpt != null) && (this.mpt.length > 0))
    {
      if (!bo.isNullOrNil(this.mpq))
      {
        i = 0;
        if (i < this.mpt.length)
        {
          String str;
          FaceNumberItemView localFaceNumberItemView;
          if (this.mpr > i)
          {
            str = this.mpq.charAt(i);
            if (this.mpr == i + 1)
            {
              localFaceNumberItemView = this.mpt[i];
              if (localFaceNumberItemView.mpf != null) {
                localFaceNumberItemView.bvB();
              }
              localFaceNumberItemView.mpf = new Timer("FaceNumberItemView_karaoke", true);
              FaceNumberItemView.a locala = new FaceNumberItemView.a(localFaceNumberItemView, localFaceNumberItemView.mpn, (byte)0);
              localFaceNumberItemView.mpf.scheduleAtFixedRate(locala, 0L, FaceNumberItemView.mpg);
            }
          }
          for (;;)
          {
            a(this.mpt[i], str);
            i += 1;
            break;
            this.mpt[i].bvB();
            localFaceNumberItemView = this.mpt[i];
            localFaceNumberItemView.mpm = 30;
            localFaceNumberItemView.invalidate();
            continue;
            str = "";
          }
        }
        AppMethodBeat.o(655);
        return;
      }
      while (i < this.mpt.length)
      {
        a(this.mpt[i], "point");
        i += 1;
      }
    }
    AppMethodBeat.o(655);
  }
  
  private void bvD()
  {
    AppMethodBeat.i(657);
    if (this.mpq != null)
    {
      this.mpr = this.mpq.length();
      AppMethodBeat.o(657);
      return;
    }
    this.mpr = 0;
    AppMethodBeat.o(657);
  }
  
  public final void Nu(String paramString)
  {
    AppMethodBeat.i(658);
    this.mpq = paramString;
    bvD();
    bvC();
    AppMethodBeat.o(658);
  }
  
  public void setNumberLengthAndInflate(int paramInt)
  {
    AppMethodBeat.i(653);
    if (paramInt > 12)
    {
      ab.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(653);
      return;
    }
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(653);
      return;
    }
    if (paramInt == this.mpu)
    {
      ab.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
      Nu(null);
      AppMethodBeat.o(653);
      return;
    }
    this.mps.removeAllViews();
    this.mpu = paramInt;
    this.mpt = new FaceNumberItemView[this.mpu];
    int k = 0;
    if (k < paramInt)
    {
      FaceNumberItemView localFaceNumberItemView = (FaceNumberItemView)inflate(getContext(), 2130969503, null);
      localFaceNumberItemView.setImageResource(2130838710);
      int j;
      int i;
      if (k == 0)
      {
        j = 3;
        i = (getResources().getDimensionPixelSize(2131428413) + a.fromDPToPix(getContext(), 48)) / 2;
      }
      for (;;)
      {
        localFaceNumberItemView.setGravity(j);
        this.mpt[k] = localFaceNumberItemView;
        this.mps.addView(localFaceNumberItemView, new ViewGroup.LayoutParams(i, getResources().getDimensionPixelSize(2131428411)));
        k += 1;
        break;
        if (k == paramInt - 1)
        {
          j = 5;
          i = (getResources().getDimensionPixelSize(2131428413) + a.fromDPToPix(getContext(), 48)) / 2;
        }
        else
        {
          j = 17;
          i = getResources().getDimensionPixelSize(2131428413);
        }
      }
    }
    AppMethodBeat.o(653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberView
 * JD-Core Version:    0.7.0.1
 */