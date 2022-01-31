package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;
import com.tencent.mm.sdk.platformtools.bk;

public final class i$b
  extends a.b
{
  public i$b(i parami)
  {
    super(parami);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_create_talker_message_item, paramViewGroup, false);
    paramViewGroup = new i.a(this.kDn);
    paramViewGroup.kCv = ((TextView)paramContext.findViewById(n.d.tip_tv));
    paramViewGroup.gSx = ((ImageView)paramContext.findViewById(n.d.icon_iv));
    paramViewGroup.kCO = paramContext.findViewById(n.d.padding_view);
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (i.a)parama;
    parama = (i)parama1;
    m.k(paramContext.contentView, this.kDn.kxT);
    paramContext.kCv.setText(parama.kDk);
    paramContext.gSx.setImageResource(n.f.fts_more_button_icon);
    if ((this.kDn.position != 0) && (this.kDn.kDj))
    {
      paramContext.kCO.setVisibility(0);
      return;
    }
    paramContext.kCO.setVisibility(8);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("key_talker_query", this.kDn.kwi.kwJ[0]);
    paramVarArgs.putExtra("key_query", this.kDn.kwi.kwJ[1]);
    paramVarArgs.putExtra("Search_Scene", this.kDn.kxJ);
    if (!bk.bl(this.kDn.kwY))
    {
      paramVarArgs.putExtra("key_conv", this.kDn.kwY);
      paramVarArgs.putExtra("detail_type", 1);
      d.b(paramContext, ".ui.FTSConvTalkerMessageUI", paramVarArgs);
      return true;
    }
    d.b(paramContext, ".ui.FTSTalkerMessageUI", paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i.b
 * JD-Core Version:    0.7.0.1
 */