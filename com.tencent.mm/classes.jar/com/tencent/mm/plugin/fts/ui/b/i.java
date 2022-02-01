package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.f;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends a
{
  public boolean HAS;
  public CharSequence HAT;
  private b HAU;
  private a HAV;
  public String Htv;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.HAU = new b();
    this.HAV = new a();
    this.Hup = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.FWt.Hth[0], b.c.HwT, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.FWt.Hth[1], b.c.HwT, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (Util.isNullOrNil(this.Htv))
    {
      str1 = paramContext.getString(p.g.search_talker_message_info_1);
      str2 = paramContext.getString(p.g.search_talker_message_info_2);
      paramContext = paramContext.getString(p.g.search_talker_message_info_3);
      i = str1.length();
      j = str1.length() + parama.length() + str2.length();
      this.HAT = f.d(f.d(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
      AppMethodBeat.o(112083);
      return;
    }
    String str1 = paramContext.getString(p.g.search_talker_message_info_4);
    String str2 = paramContext.getString(p.g.search_talker_message_info_2);
    paramContext = paramContext.getString(p.g.search_talker_message_info_3);
    int i = str1.length();
    int j = str1.length() + parama.length() + str2.length();
    this.HAT = f.d(f.d(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
    AppMethodBeat.o(112083);
  }
  
  public final a.b aXA()
  {
    return this.HAU;
  }
  
  public final class a
    extends a.a
  {
    public TextView DSB;
    public View HAy;
    public View contentView;
    public ImageView ttT;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112079);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_create_talker_message_item, paramViewGroup, false);
      paramViewGroup = new i.a(i.this);
      paramViewGroup.DSB = ((TextView)paramContext.findViewById(p.d.tip_tv));
      paramViewGroup.ttT = ((ImageView)paramContext.findViewById(p.d.icon_iv));
      paramViewGroup.HAy = paramContext.findViewById(p.d.padding_view);
      paramViewGroup.contentView = paramContext.findViewById(p.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112079);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112080);
      paramContext = (i.a)parama;
      parama = (i)parama1;
      o.x(paramContext.contentView, i.this.Hup);
      paramContext.DSB.setText(parama.HAT);
      paramContext.ttT.setImageResource(p.f.fts_more_button_icon);
      if ((i.this.position != 0) && (i.this.HAS))
      {
        paramContext.HAy.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.HAy.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(265715);
      paramView = new Intent();
      paramView.putExtra("key_talker_query", i.this.FWt.Hth[0]);
      paramView.putExtra("key_query", i.this.FWt.Hth[1]);
      paramView.putExtra("Search_Scene", i.this.syO);
      if (!Util.isNullOrNil(i.this.Htv))
      {
        paramView.putExtra("key_conv", i.this.Htv);
        paramView.putExtra("detail_type", 1);
        d.d(paramContext, ".ui.FTSConvTalkerMessageUI", paramView);
      }
      for (;;)
      {
        AppMethodBeat.o(265715);
        return true;
        d.d(paramContext, ".ui.FTSTalkerMessageUI", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.i
 * JD-Core Version:    0.7.0.1
 */