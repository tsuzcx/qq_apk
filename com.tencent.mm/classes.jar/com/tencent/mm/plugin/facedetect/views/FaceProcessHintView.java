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
import com.tencent.mm.sdk.platformtools.ae;

public class FaceProcessHintView
  extends LinearLayout
{
  private int abZ;
  private h rwJ;
  private Animation rwK;
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104182);
    this.rwJ = null;
    this.abZ = 0;
    this.rwK = null;
    setOrientation(0);
    setMinimumHeight(BackwardSupportUtil.b.h(getContext(), 36.0F));
    this.rwK = AnimationUtils.loadAnimation(paramContext, 2130772037);
    this.rwK.setInterpolator(new AccelerateDecelerateInterpolator());
    AppMethodBeat.o(104182);
  }
  
  private void setCurrentProcessing(int paramInt)
  {
    AppMethodBeat.i(104184);
    TextView localTextView = (TextView)getChildAt(paramInt).findViewById(2131298898);
    localTextView.setTextColor(getResources().getColor(2131101179));
    localTextView.setBackgroundResource(2131232152);
    AppMethodBeat.o(104184);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setDataAndInvalidate(h paramh)
  {
    AppMethodBeat.i(104183);
    this.rwJ = paramh;
    if ((this.rwJ == null) || (this.rwJ.rpu <= 0))
    {
      ae.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
      AppMethodBeat.o(104183);
      return;
    }
    removeAllViews();
    int i = 0;
    while (i < this.rwJ.rpu)
    {
      paramh = LayoutInflater.from(getContext()).inflate(2131493919, null, false);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      ((TextView)paramh.findViewById(2131298898)).setText(String.valueOf(i + 1));
      addView(paramh, localLayoutParams);
      i += 1;
    }
    getChildAt(getChildCount() - 1).findViewById(2131299702).setVisibility(8);
    setCurrentProcessing(0);
    invalidate();
    AppMethodBeat.o(104183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceProcessHintView
 * JD-Core Version:    0.7.0.1
 */