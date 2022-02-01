package com.tencent.mm.plugin.facedetect.views;

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
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceProcessHintView
  extends LinearLayout
{
  private int jP;
  private h zYP;
  private Animation zYQ;
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceProcessHintView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104182);
    this.zYP = null;
    this.jP = 0;
    this.zYQ = null;
    setOrientation(0);
    setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 36.0F));
    this.zYQ = AnimationUtils.loadAnimation(paramContext, a.a.face_zoom_out_from_left);
    this.zYQ.setInterpolator(new AccelerateDecelerateInterpolator());
    AppMethodBeat.o(104182);
  }
  
  private void setCurrentProcessing(int paramInt)
  {
    AppMethodBeat.i(104184);
    TextView localTextView = (TextView)getChildAt(paramInt).findViewById(a.e.current_process_number);
    localTextView.setTextColor(getResources().getColor(a.b.white));
    localTextView.setBackgroundResource(a.d.face_prefix_number_bg);
    AppMethodBeat.o(104184);
  }
  
  public void setDataAndInvalidate(h paramh)
  {
    AppMethodBeat.i(104183);
    this.zYP = paramh;
    if ((this.zYP == null) || (this.zYP.zSU <= 0))
    {
      Log.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
      AppMethodBeat.o(104183);
      return;
    }
    removeAllViews();
    int i = 0;
    while (i < this.zYP.zSU)
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
    AppMethodBeat.o(104183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceProcessHintView
 * JD-Core Version:    0.7.0.1
 */