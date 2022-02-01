package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;

public class f
  extends k
{
  public String BIN;
  protected CharSequence BOJ;
  protected String BOK;
  protected CharSequence BOL;
  protected String BOM;
  public m BON;
  private a BOO;
  b BOP;
  public int fwp;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.BOO = new a();
    this.BOP = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.BON.BHS;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.BON.BHR)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.fwp == 2)
      {
        this.BOK = str;
        if (!Util.isNullOrNil(paramVarArgs))
        {
          this.BOJ = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BON.BHY, bool3, bool1, b.c.BLT, paramVarArgs + "(", ")")).BIp;
          this.BOJ = TextUtils.concat(new CharSequence[] { "\"", this.BOJ, "\"" });
          this.BOL = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.azM(this.BIN), b.c.BLV, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(o.g.search_talker_message_info_3) });
          this.BOM = this.BIN;
          AppMethodBeat.o(112069);
          return;
        }
      }
      break;
    case 3: 
      label159:
      bool1 = true;
    }
    label251:
    for (bool3 = true;; bool3 = bool5)
    {
      parama = d.azM(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(str).field_nickname;
      paramVarArgs = d.azM(str);
      bool1 = bool2;
      break;
      this.BOJ = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BON.BHY, bool3, bool1, 400.0F, b.c.BLT)).BIp;
      break label159;
      this.BOJ = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.azM(this.BIN), b.c.BLV, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.BOK = this.BIN;
      this.BOM = str;
      if (!Util.isNullOrNil(paramVarArgs)) {}
      for (this.BOL = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BON.BHY, bool3, bool1, b.c.BLT, paramVarArgs + "(", ")")).BIp;; this.BOL = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BON.BHY, bool3, bool1, 400.0F, b.c.BLT)).BIp)
      {
        this.BOL = TextUtils.concat(new CharSequence[] { "\"", this.BOL, paramContext.getString(o.g.search_talker_message_info_3) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label251;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BOO;
  }
  
  public final a.a erV()
  {
    return this.BOP;
  }
  
  public class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112066);
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_conv_talker_header_item, paramViewGroup, false);
      paramViewGroup = (f.b)f.this.BOP;
      paramViewGroup.BOR = ((TextView)paramContext.findViewById(o.d.header_1_tv));
      paramViewGroup.BOS = ((ImageView)paramContext.findViewById(o.d.avatar_1_iv));
      paramViewGroup.BOT = ((TextView)paramContext.findViewById(o.d.header_2_tv));
      paramViewGroup.BOU = ((ImageView)paramContext.findViewById(o.d.avatar_2_iv));
      paramViewGroup.BOV = ((TextView)paramContext.findViewById(o.d.info_tv));
      paramViewGroup.contentView = paramContext.findViewById(o.d.search_item_content_layout);
      paramViewGroup.BOI = paramContext.findViewById(o.d.padding_view);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      com.tencent.mm.plugin.fts.ui.n.a(f.this.BOJ, paramContext.BOR);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.BOS, f.this.BOK);
      com.tencent.mm.plugin.fts.ui.n.a(f.this.BOL, paramContext.BOT);
      if (!Util.isNullOrNil(f.this.BOM))
      {
        paramContext.BOU.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.BOU, f.this.BOM);
        com.tencent.mm.plugin.fts.ui.n.s(paramContext.contentView, f.this.BJG);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.BOI.setVisibility(8);
      }
      for (;;)
      {
        paramContext.BOV.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.BOU.setVisibility(8);
        break;
        label148:
        paramContext.BOI.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public View BOI;
    public TextView BOR;
    public ImageView BOS;
    public TextView BOT;
    public ImageView BOU;
    public TextView BOV;
    public View contentView;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f
 * JD-Core Version:    0.7.0.1
 */