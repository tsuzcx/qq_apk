package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.c;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public final class e$a
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public e$a(e parame)
  {
    super(parame);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_conv_message_header_item, paramViewGroup, false);
    paramViewGroup = (e.b)this.kCN.kCM;
    paramViewGroup.iCG = ((TextView)paramContext.findViewById(n.d.header_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramViewGroup.kCO = paramContext.findViewById(n.d.padding_view);
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(n.d.avatar_iv));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (e.b)parama;
    m.a(this.kCN.kDu, paramContext.iCG);
    paramContext.contentView.setBackgroundResource(n.c.list_thicklinecell_bg);
    com.tencent.mm.pluginsdk.ui.a.b.a(paramContext.doU, this.kCN.talker);
    if (this.kCN.position == 0)
    {
      paramContext.kCO.setVisibility(8);
      return;
    }
    paramContext.kCO.setVisibility(0);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e.a
 * JD-Core Version:    0.7.0.1
 */