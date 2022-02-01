package com.tencent.mm.plugin.fts.ui.a;

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
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends a
{
  public String BIN;
  public boolean BPd;
  public CharSequence BPe;
  private b BPf;
  private a BPg;
  
  public i(int paramInt)
  {
    super(12, paramInt);
    AppMethodBeat.i(112082);
    this.BPf = new b();
    this.BPg = new a();
    this.BJG = false;
    AppMethodBeat.o(112082);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112083);
    parama = TextUtils.ellipsize(this.BHY.BIz[0], b.c.BLX, 200.0F, TextUtils.TruncateAt.MIDDLE);
    paramVarArgs = TextUtils.ellipsize(this.BHY.BIz[1], b.c.BLX, 400.0F, TextUtils.TruncateAt.MIDDLE);
    if (Util.isNullOrNil(this.BIN))
    {
      str1 = paramContext.getString(o.g.search_talker_message_info_1);
      str2 = paramContext.getString(o.g.search_talker_message_info_2);
      paramContext = paramContext.getString(o.g.search_talker_message_info_3);
      i = str1.length();
      j = str1.length() + parama.length() + str2.length();
      this.BPe = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
      AppMethodBeat.o(112083);
      return;
    }
    String str1 = paramContext.getString(o.g.search_talker_message_info_4);
    String str2 = paramContext.getString(o.g.search_talker_message_info_2);
    paramContext = paramContext.getString(o.g.search_talker_message_info_3);
    int i = str1.length();
    int j = str1.length() + parama.length() + str2.length();
    this.BPe = f.f(f.f(str1 + parama + str2 + paramVarArgs + paramContext, i, parama.length() + i), j, paramVarArgs.length() + j);
    AppMethodBeat.o(112083);
  }
  
  public final a.b aEw()
  {
    return this.BPf;
  }
  
  public final class a
    extends a.a
  {
    public View BOI;
    public View contentView;
    public ImageView qps;
    public TextView yZg;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_create_talker_message_item, paramViewGroup, false);
      paramViewGroup = new i.a(i.this);
      paramViewGroup.yZg = ((TextView)paramContext.findViewById(o.d.tip_tv));
      paramViewGroup.qps = ((ImageView)paramContext.findViewById(o.d.icon_iv));
      paramViewGroup.BOI = paramContext.findViewById(o.d.padding_view);
      paramViewGroup.contentView = paramContext.findViewById(o.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112079);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112080);
      paramContext = (i.a)parama;
      parama = (i)parama1;
      n.r(paramContext.contentView, i.this.BJG);
      paramContext.yZg.setText(parama.BPe);
      paramContext.qps.setImageResource(o.f.fts_more_button_icon);
      if ((i.this.position != 0) && (i.this.BPd))
      {
        paramContext.BOI.setVisibility(0);
        AppMethodBeat.o(112080);
        return;
      }
      paramContext.BOI.setVisibility(8);
      AppMethodBeat.o(112080);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(190599);
      paramView = new Intent();
      paramView.putExtra("key_talker_query", i.this.BHY.BIz[0]);
      paramView.putExtra("key_query", i.this.BHY.BIz[1]);
      paramView.putExtra("Search_Scene", i.this.ptD);
      if (!Util.isNullOrNil(i.this.BIN))
      {
        paramView.putExtra("key_conv", i.this.BIN);
        paramView.putExtra("detail_type", 1);
        d.d(paramContext, ".ui.FTSConvTalkerMessageUI", paramView);
      }
      for (;;)
      {
        AppMethodBeat.o(190599);
        return true;
        d.d(paramContext, ".ui.FTSTalkerMessageUI", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.i
 * JD-Core Version:    0.7.0.1
 */