package com.tencent.mm.plugin.fav.ui.gallery;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.ui.n.e;

public final class f$d
  extends RecyclerView.v
{
  View.OnLongClickListener kfL = new f.d.4(this);
  ImageView khQ;
  View khR;
  TextView khS;
  ImageView khT;
  View khU;
  CheckBox khV;
  View khW;
  
  public f$d(f paramf, View paramView)
  {
    super(paramView);
    this.khQ = ((ImageView)paramView.findViewById(n.e.grid_header_item));
    this.khR = paramView.findViewById(n.e.video_tips_root);
    this.khU = paramView.findViewById(n.e.sight_tips_root);
    this.khS = ((TextView)paramView.findViewById(n.e.video_time_tv));
    this.khT = ((ImageView)paramView.findViewById(n.e.grid_selected_item_mask));
    this.khV = ((CheckBox)paramView.findViewById(n.e.media_cbx));
    this.khW = paramView.findViewById(n.e.media_cbx_clickarea);
    this.khW.setVisibility(8);
    this.khV.setVisibility(8);
    this.khR.setVisibility(8);
    this.khS.setVisibility(8);
    this.khU.setVisibility(8);
    this.khQ.setOnTouchListener(new f.d.1(this, paramf));
    this.khQ.setOnClickListener(new f.d.2(this, paramf));
    this.khQ.setOnLongClickListener(this.kfL);
    this.khW.setOnClickListener(new f.d.3(this, paramf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.f.d
 * JD-Core Version:    0.7.0.1
 */