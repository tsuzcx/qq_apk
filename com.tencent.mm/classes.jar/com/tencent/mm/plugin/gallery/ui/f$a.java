package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;

public final class f$a
  extends RecyclerView.v
{
  public ImageView kHP;
  public ImageView kHQ;
  public RelativeLayout kHR;
  public TextView kHS;
  public ImageView kHU;
  public ImageView kHV;
  public ImageView kHW;
  public int kKA;
  public ImageView kKy;
  public View kKz;
  
  public f$a(View paramView)
  {
    super(paramView);
    this.kKz = paramView;
    this.kHV = ((ImageView)paramView.findViewById(R.h.gif_mask));
    this.kHW = ((ImageView)paramView.findViewById(R.h.edit_mark_iv));
    this.kKy = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
    this.kHP = ((ImageView)paramView.findViewById(R.h.media_placeholder));
    this.kHQ = ((ImageView)paramView.findViewById(R.h.media_thumb));
    this.kHR = ((RelativeLayout)paramView.findViewById(R.h.video_mask));
    this.kHS = ((TextView)paramView.findViewById(R.h.video_mask_tv));
    this.kHU = ((ImageView)paramView.findViewById(R.h.media_mask));
    this.kHU.setBackgroundResource(R.e.half_alpha_black);
    this.kHU.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.a
 * JD-Core Version:    0.7.0.1
 */