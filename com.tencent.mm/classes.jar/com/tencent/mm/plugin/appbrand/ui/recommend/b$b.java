package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.g;

public final class b$b
  extends RecyclerView.v
{
  private View eYp;
  private TextView fdt;
  private ImageView heN;
  private TextView hki;
  private LinearLayout hkj;
  private LinearLayout hkk;
  private TextView hkl;
  private RatingBar hkm;
  private TextView hkn;
  
  public b$b(b paramb, View paramView)
  {
    super(paramView);
    this.heN = ((ImageView)paramView.findViewById(y.g.icon_iv));
    this.fdt = ((TextView)paramView.findViewById(y.g.name_tv));
    this.hki = ((TextView)paramView.findViewById(y.g.desc_info_tv));
    this.hkj = ((LinearLayout)paramView.findViewById(y.g.app_category_layout));
    this.hkk = ((LinearLayout)paramView.findViewById(y.g.score_layout));
    this.hkn = ((TextView)paramView.findViewById(y.g.score_tv));
    this.hkl = ((TextView)paramView.findViewById(y.g.words_tv));
    this.eYp = paramView.findViewById(y.g.divider);
    this.hkm = ((RatingBar)paramView.findViewById(y.g.score_rating_bar));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b.b
 * JD-Core Version:    0.7.0.1
 */