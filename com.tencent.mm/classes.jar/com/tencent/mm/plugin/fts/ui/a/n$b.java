package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;

public final class n$b
  extends a.b
{
  public n$b(n paramn)
  {
    super(paramn);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_more_item, paramViewGroup, false);
    paramViewGroup = new n.a(this.kDK);
    paramViewGroup.kCv = ((TextView)paramContext.findViewById(n.d.tip_tv));
    paramViewGroup.gSx = ((ImageView)paramContext.findViewById(n.d.icon_iv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (n.a)parama;
    parama = (n)parama1;
    m.k(paramContext.contentView, this.kDK.kxT);
    paramContext.kCv.setText(parama.kDH);
    paramContext.gSx.setImageResource(n.f.fts_more_button_icon);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("detail_query", this.kDK.kwi.kwG);
    paramVarArgs.putExtra("detail_type", this.kDK.kxU);
    paramVarArgs.putExtra("Search_Scene", this.kDK.kxJ);
    d.b(paramContext, ".ui.FTSDetailUI", paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n.b
 * JD-Core Version:    0.7.0.1
 */