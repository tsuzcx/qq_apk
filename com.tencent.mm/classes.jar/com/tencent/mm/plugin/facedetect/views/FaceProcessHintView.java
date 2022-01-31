package com.tencent.mm.plugin.facedetect.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public class FaceProcessHintView
  extends LinearLayout
{
  private int Sl;
  private h mpA;
  private Animation mpB;
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(659);
    this.mpA = null;
    this.Sl = 0;
    this.mpB = null;
    setOrientation(0);
    setMinimumHeight(BackwardSupportUtil.b.b(getContext(), 36.0F));
    this.mpB = AnimationUtils.loadAnimation(paramContext, 2131034171);
    this.mpB.setInterpolator(new AccelerateDecelerateInterpolator());
    AppMethodBeat.o(659);
  }
  
  private void setCurrentProcessing(int paramInt)
  {
    AppMethodBeat.i(661);
    TextView localTextView = (TextView)getChildAt(paramInt).findViewById(2131823910);
    localTextView.setTextColor(getResources().getColor(2131690709));
    localTextView.setBackgroundResource(2130838711);
    AppMethodBeat.o(661);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setDataAndInvalidate(h paramh)
  {
    AppMethodBeat.i(660);
    this.mpA = paramh;
    if ((this.mpA == null) || (this.mpA.mie <= 0))
    {
      ab.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
      AppMethodBeat.o(660);
      return;
    }
    removeAllViews();
    int i = 0;
    while (i < this.mpA.mie)
    {
      paramh = LayoutInflater.from(getContext()).inflate(2130969506, null, false);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      ((TextView)paramh.findViewById(2131823910)).setText(String.valueOf(i + 1));
      addView(paramh, localLayoutParams);
      i += 1;
    }
    getChildAt(getChildCount() - 1).findViewById(2131823911).setVisibility(8);
    setCurrentProcessing(0);
    invalidate();
    AppMethodBeat.o(660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceProcessHintView
 * JD-Core Version:    0.7.0.1
 */