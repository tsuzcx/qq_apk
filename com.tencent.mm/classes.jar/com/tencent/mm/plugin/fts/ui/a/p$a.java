package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public final class p$a
  extends m.b
{
  public p$a(p paramp)
  {
    super(paramp);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(n.e.fts_message_item, paramViewGroup, false);
    m.a locala = (m.a)this.kDO.kDF;
    locala.doU = ((ImageView)paramViewGroup.findViewById(n.d.avatar_iv));
    locala.doV = ((TextView)paramViewGroup.findViewById(n.d.nickname_tv));
    locala.dsy = ((TextView)paramViewGroup.findViewById(n.d.msg_tv));
    locala.contentView = paramViewGroup.findViewById(n.d.search_item_content_layout);
    locala.dsz = ((TextView)paramViewGroup.findViewById(n.d.time_tv));
    locala.doU.getLayoutParams().width = com.tencent.mm.cb.a.aa(paramContext, n.b.SettingCatalogPadding);
    locala.doU.getLayoutParams().height = com.tencent.mm.cb.a.aa(paramContext, n.b.SettingCatalogPadding);
    paramViewGroup.setTag(locala);
    return paramViewGroup;
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    return ((n)g.t(n.class)).getItemClickHandler(this.kDO.ivk).a(paramContext, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.p.a
 * JD-Core Version:    0.7.0.1
 */