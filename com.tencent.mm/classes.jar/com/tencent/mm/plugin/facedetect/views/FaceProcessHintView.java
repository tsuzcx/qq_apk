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
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;

public class FaceProcessHintView
  extends LinearLayout
{
  private h jVh = null;
  private int jVi = 0;
  private Animation jVj = null;
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    setMinimumHeight(BackwardSupportUtil.b.b(getContext(), 36.0F));
    this.jVj = AnimationUtils.loadAnimation(paramContext, a.a.face_zoom_out_from_left);
    this.jVj.setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  private void setCurrentProcessing(int paramInt)
  {
    TextView localTextView = (TextView)getChildAt(paramInt).findViewById(a.e.current_process_number);
    localTextView.setTextColor(getResources().getColor(a.b.white));
    localTextView.setBackgroundResource(a.d.face_prefix_number_bg);
  }
  
  @SuppressLint({"SetTextI18n"})
  public void setDataAndInvalidate(h paramh)
  {
    this.jVh = paramh;
    if ((this.jVh == null) || (this.jVh.jNS <= 0))
    {
      y.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
      return;
    }
    removeAllViews();
    int i = 0;
    while (i < this.jVh.jNS)
    {
      paramh = LayoutInflater.from(getContext()).inflate(a.g.face_process_hint_item, null, false);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      ((TextView)paramh.findViewById(a.e.current_process_number)).setText(String.valueOf(i + 1));
      addView(paramh, localLayoutParams);
      i += 1;
    }
    getChildAt(getChildCount() - 1).findViewById(a.e.face_progress_area).setVisibility(8);
    setCurrentProcessing(0);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceProcessHintView
 * JD-Core Version:    0.7.0.1
 */