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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceProcessHintView
  extends LinearLayout
{
  private int acm;
  private h sWG;
  private Animation sWH;
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104182);
    this.sWG = null;
    this.acm = 0;
    this.sWH = null;
    setOrientation(0);
    setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 36.0F));
    this.sWH = AnimationUtils.loadAnimation(paramContext, 2130772047);
    this.sWH.setInterpolator(new AccelerateDecelerateInterpolator());
    AppMethodBeat.o(104182);
  }
  
  private void setCurrentProcessing(int paramInt)
  {
    AppMethodBeat.i(104184);
    TextView localTextView = (TextView)getChildAt(paramInt).findViewById(2131299374);
    localTextView.setTextColor(getResources().getColor(2131101424));
    localTextView.setBackgroundResource(2131232263);
    AppMethodBeat.o(104184);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setDataAndInvalidate(h paramh)
  {
    AppMethodBeat.i(104183);
    this.sWG = paramh;
    if ((this.sWG == null) || (this.sWG.sQS <= 0))
    {
      Log.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
      AppMethodBeat.o(104183);
      return;
    }
    removeAllViews();
    int i = 0;
    while (i < this.sWG.sQS)
    {
      paramh = LayoutInflater.from(getContext()).inflate(2131494087, null, false);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      ((TextView)paramh.findViewById(2131299374)).setText(String.valueOf(i + 1));
      addView(paramh, localLayoutParams);
      i += 1;
    }
    getChildAt(getChildCount() - 1).findViewById(2131300367).setVisibility(8);
    setCurrentProcessing(0);
    invalidate();
    AppMethodBeat.o(104183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceProcessHintView
 * JD-Core Version:    0.7.0.1
 */