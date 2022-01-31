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
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.sdk.platformtools.bk;

public class f$a
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public f$a(f paramf)
  {
    super(paramf);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_conv_talker_header_item, paramViewGroup, false);
    paramViewGroup = (f.b)this.kCW.kCV;
    paramViewGroup.kCX = ((TextView)paramContext.findViewById(n.d.header_1_tv));
    paramViewGroup.kCY = ((ImageView)paramContext.findViewById(n.d.avatar_1_iv));
    paramViewGroup.kCZ = ((TextView)paramContext.findViewById(n.d.header_2_tv));
    paramViewGroup.kDa = ((ImageView)paramContext.findViewById(n.d.avatar_2_iv));
    paramViewGroup.kDb = ((TextView)paramContext.findViewById(n.d.info_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramViewGroup.kCO = paramContext.findViewById(n.d.padding_view);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (f.b)parama;
    m.a(this.kCW.kCP, paramContext.kCX);
    com.tencent.mm.pluginsdk.ui.a.b.a(paramContext.kCY, this.kCW.kCQ);
    m.a(this.kCW.kCR, paramContext.kCZ);
    if (!bk.bl(this.kCW.kCS))
    {
      paramContext.kDa.setVisibility(0);
      com.tencent.mm.pluginsdk.ui.a.b.a(paramContext.kDa, this.kCW.kCS);
      m.l(paramContext.contentView, this.kCW.kxT);
      if (this.kCW.position != 0) {
        break label138;
      }
      paramContext.kCO.setVisibility(8);
    }
    for (;;)
    {
      paramContext.kDb.setVisibility(0);
      return;
      paramContext.kDa.setVisibility(8);
      break;
      label138:
      paramContext.kCO.setVisibility(0);
    }
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f.a
 * JD-Core Version:    0.7.0.1
 */