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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Timer;

public class FaceNumberView
  extends LinearLayout
{
  private int sWA;
  private Animation sWB;
  private FaceNumberView.a sWC;
  private String sWw;
  private int sWx;
  private ViewGroup sWy;
  public FaceNumberItemView[] sWz;
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public FaceNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(104176);
    this.sWw = null;
    this.sWz = null;
    this.sWA = 0;
    this.sWB = null;
    this.sWC = FaceNumberView.a.sWE;
    this.sWy = ((ViewGroup)inflate(getContext(), 2131494083, null));
    addView(this.sWy);
    this.sWB = AnimationUtils.loadAnimation(getContext(), 2130772119);
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
      paramFaceNumberItemView.setImageResource(2131232252);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("1"))
    {
      paramFaceNumberItemView.setImageResource(2131232253);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("2"))
    {
      paramFaceNumberItemView.setImageResource(2131232254);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("3"))
    {
      paramFaceNumberItemView.setImageResource(2131232255);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("4"))
    {
      paramFaceNumberItemView.setImageResource(2131232256);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("5"))
    {
      paramFaceNumberItemView.setImageResource(2131232257);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("6"))
    {
      paramFaceNumberItemView.setImageResource(2131232258);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("7"))
    {
      paramFaceNumberItemView.setImageResource(2131232259);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("8"))
    {
      paramFaceNumberItemView.setImageResource(2131232260);
      AppMethodBeat.o(104178);
      return;
    }
    if (paramString.equals("9"))
    {
      paramFaceNumberItemView.setImageResource(2131232261);
      AppMethodBeat.o(104178);
      return;
    }
    paramFaceNumberItemView.setImageResource(2131232262);
    AppMethodBeat.o(104178);
  }
  
  private void cTU()
  {
    int i = 0;
    AppMethodBeat.i(104177);
    if ((this.sWz != null) && (this.sWz.length > 0))
    {
      if (!Util.isNullOrNil(this.sWw))
      {
        i = 0;
        if (i < this.sWz.length)
        {
          String str;
          FaceNumberItemView localFaceNumberItemView;
          if (this.sWx > i)
          {
            str = this.sWw.charAt(i);
            if (this.sWx == i + 1)
            {
              localFaceNumberItemView = this.sWz[i];
              if (localFaceNumberItemView.sWl != null) {
                localFaceNumberItemView.cTT();
              }
              localFaceNumberItemView.sWl = new Timer("FaceNumberItemView_karaoke", true);
              FaceNumberItemView.a locala = new FaceNumberItemView.a(localFaceNumberItemView, localFaceNumberItemView.sWt, (byte)0);
              localFaceNumberItemView.sWl.scheduleAtFixedRate(locala, 0L, FaceNumberItemView.sWm);
            }
          }
          for (;;)
          {
            a(this.sWz[i], str);
            i += 1;
            break;
            this.sWz[i].cTT();
            localFaceNumberItemView = this.sWz[i];
            localFaceNumberItemView.sWs = 30;
            localFaceNumberItemView.invalidate();
            continue;
            str = "";
          }
        }
        AppMethodBeat.o(104177);
        return;
      }
      while (i < this.sWz.length)
      {
        a(this.sWz[i], "point");
        i += 1;
      }
    }
    AppMethodBeat.o(104177);
  }
  
  private void cTV()
  {
    AppMethodBeat.i(104179);
    if (this.sWw != null)
    {
      this.sWx = this.sWw.length();
      AppMethodBeat.o(104179);
      return;
    }
    this.sWx = 0;
    AppMethodBeat.o(104179);
  }
  
  public final void arF(String paramString)
  {
    AppMethodBeat.i(104180);
    this.sWw = paramString;
    cTV();
    cTU();
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
    if (paramInt == this.sWA)
    {
      Log.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
      arF(null);
      AppMethodBeat.o(104175);
      return;
    }
    this.sWy.removeAllViews();
    this.sWA = paramInt;
    this.sWz = new FaceNumberItemView[this.sWA];
    int k = 0;
    if (k < paramInt)
    {
      FaceNumberItemView localFaceNumberItemView = (FaceNumberItemView)inflate(getContext(), 2131494084, null);
      localFaceNumberItemView.setImageResource(2131232262);
      int j;
      int i;
      if (k == 0)
      {
        j = 3;
        i = (getResources().getDimensionPixelSize(2131166326) + a.fromDPToPix(getContext(), 48)) / 2;
      }
      for (;;)
      {
        localFaceNumberItemView.setGravity(j);
        this.sWz[k] = localFaceNumberItemView;
        this.sWy.addView(localFaceNumberItemView, new ViewGroup.LayoutParams(i, getResources().getDimensionPixelSize(2131166324)));
        k += 1;
        break;
        if (k == paramInt - 1)
        {
          j = 5;
          i = (getResources().getDimensionPixelSize(2131166326) + a.fromDPToPix(getContext(), 48)) / 2;
        }
        else
        {
          j = 17;
          i = getResources().getDimensionPixelSize(2131166326);
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