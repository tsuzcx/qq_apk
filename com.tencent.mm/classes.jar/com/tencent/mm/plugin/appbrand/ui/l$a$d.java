package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileRelievedBuyHalfScreenComponent$Companion$SubInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "descTextView", "Landroid/widget/TextView;", "getDescTextView", "()Landroid/widget/TextView;", "iconImageView", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "titleTextView", "getTitleTextView", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class l$a$d
  extends RecyclerView.v
{
  final TextView lzN;
  final ImageView tuy;
  final TextView uck;
  
  public l$a$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(322575);
    paramView = this.caK.findViewById(ba.f.sub_info_image);
    s.s(paramView, "itemView.findViewById(R.id.sub_info_image)");
    this.tuy = ((ImageView)paramView);
    paramView = this.caK.findViewById(ba.f.sub_info_title);
    s.s(paramView, "itemView.findViewById(R.id.sub_info_title)");
    this.lzN = ((TextView)paramView);
    paramView = this.caK.findViewById(ba.f.sub_info_desc);
    s.s(paramView, "itemView.findViewById(R.id.sub_info_desc)");
    this.uck = ((TextView)paramView);
    AppMethodBeat.o(322575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l.a.d
 * JD-Core Version:    0.7.0.1
 */