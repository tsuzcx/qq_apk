package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.bk;

public final class d$b
  extends a.b
{
  public d$b(d paramd)
  {
    super(paramd);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(y.h.app_brand_fts_weapp_item, paramViewGroup, false);
    paramViewGroup = (d.a)this.fYD.fYA;
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(y.g.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(y.g.title_tv));
    paramViewGroup.contentView = paramContext.findViewById(y.g.search_item_content_layout);
    paramViewGroup.fYB = ((TextView)paramContext.findViewById(y.g.secondary_text));
    paramViewGroup.fYC = ((TextView)paramContext.findViewById(y.g.tag_text));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    paramContext = (d)parama1;
    parama = (d.a)parama;
    if (paramContext.fYy == null)
    {
      parama.contentView.setVisibility(8);
      return;
    }
    parama.contentView.setVisibility(0);
    parama.eXO.setText(this.fYD.dtD);
    parama1 = com.tencent.mm.plugin.appbrand.appcache.a.kp(this.fYD.fYy.fEL);
    if (bk.bl(parama1)) {
      parama.fYC.setVisibility(8);
    }
    for (;;)
    {
      b.JD().a(parama.doU, paramContext.fYy.fJk, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
      return;
      parama.fYC.setText(parama1);
      parama.fYC.setVisibility(0);
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    paramContext = (d)paramVarArgs;
    paramVarArgs = new rc();
    paramVarArgs.caq.userName = paramContext.fYy.bFn;
    paramVarArgs.caq.cat = paramContext.fYy.fEL;
    paramVarArgs.caq.cax = true;
    paramVarArgs.caq.scene = 1027;
    com.tencent.mm.sdk.b.a.udP.m(paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.d.b
 * JD-Core Version:    0.7.0.1
 */