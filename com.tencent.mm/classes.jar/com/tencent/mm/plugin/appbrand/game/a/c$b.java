package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.bk;

public final class c$b
  extends a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(y.h.minigame_fts_item, paramViewGroup, false);
    paramViewGroup = (c.a)this.gaJ.gaH;
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(y.g.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(y.g.title_tv));
    paramViewGroup.contentView = paramContext.findViewById(y.g.search_item_content_layout);
    paramViewGroup.fYB = ((TextView)paramContext.findViewById(y.g.secondary_text));
    paramViewGroup.gaI = ((TextView)paramContext.findViewById(y.g.desc_tv));
    paramViewGroup.fYC = ((TextView)paramContext.findViewById(y.g.tag_text));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    paramContext = (c)parama1;
    parama = (c.a)parama;
    if (paramContext.gaF == null)
    {
      parama.contentView.setVisibility(8);
      return;
    }
    parama.contentView.setVisibility(0);
    parama.eXO.setText(this.gaJ.dtD);
    parama.fYC.setVisibility(8);
    parama.gaI.setVisibility(8);
    parama.fYB.setVisibility(8);
    if (paramContext.gaE != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.appcache.a.kp(paramContext.gaE.fEL);
      if (bk.bl(parama1)) {
        parama.fYC.setVisibility(8);
      }
    }
    for (;;)
    {
      com.tencent.mm.modelappbrand.a.b.JD().a(parama.doU, paramContext.gaF.field_IconUrl, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
      return;
      parama.fYC.setText(parama1);
      parama.fYC.setVisibility(0);
      continue;
      parama1 = paramContext.gaF.field_BriefIntro;
      if (bk.bl(parama1))
      {
        parama.gaI.setVisibility(8);
      }
      else
      {
        parama.gaI.setText(parama1);
        parama.gaI.setVisibility(0);
      }
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    paramContext = (c)paramVarArgs;
    paramVarArgs = new rc();
    paramVarArgs.caq.userName = paramContext.gaF.field_UserName;
    paramVarArgs.caq.cat = 0;
    if (paramContext.gaE != null) {
      paramVarArgs.caq.cat = paramContext.gaE.fEL;
    }
    paramVarArgs.caq.cax = true;
    paramVarArgs.caq.scene = 1027;
    com.tencent.mm.sdk.b.a.udP.m(paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.c.b
 * JD-Core Version:    0.7.0.1
 */