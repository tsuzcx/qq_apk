package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;

public class f
  extends k
{
  protected String HAA;
  protected CharSequence HAB;
  protected String HAC;
  public com.tencent.mm.plugin.fts.a.a.o HAD;
  private a HAE;
  b HAF;
  protected CharSequence HAz;
  public String Htv;
  public int hAN;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.HAE = new a();
    this.HAF = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.HAD.Hsz;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.HAD.subtype)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.hAN == 2)
      {
        this.HAA = str;
        if (!Util.isNullOrNil(paramVarArgs))
        {
          this.HAz = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.HAD.FWt, bool3, bool1, b.c.HwP, paramVarArgs + "(", ")")).HsX;
          this.HAz = TextUtils.concat(new CharSequence[] { "\"", this.HAz, "\"" });
          this.HAB = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.atS(this.Htv), b.c.HwR, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(p.g.search_talker_message_info_3) });
          this.HAC = this.Htv;
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
      parama = d.atS(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str).field_nickname;
      paramVarArgs = d.atS(str);
      bool1 = bool2;
      break;
      this.HAz = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.HAD.FWt, bool3, bool1, 400.0F, b.c.HwP)).HsX;
      break label159;
      this.HAz = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.atS(this.Htv), b.c.HwR, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.HAA = this.Htv;
      this.HAC = str;
      if (!Util.isNullOrNil(paramVarArgs)) {}
      for (this.HAB = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.HAD.FWt, bool3, bool1, b.c.HwP, paramVarArgs + "(", ")")).HsX;; this.HAB = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.HAD.FWt, bool3, bool1, 400.0F, b.c.HwP)).HsX)
      {
        this.HAB = TextUtils.concat(new CharSequence[] { "\"", this.HAB, paramContext.getString(p.g.search_talker_message_info_3) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label251;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HAE;
  }
  
  public final a.a fyW()
  {
    return this.HAF;
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
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_conv_talker_header_item, paramViewGroup, false);
      paramViewGroup = (f.b)f.this.HAF;
      paramViewGroup.HAH = ((TextView)paramContext.findViewById(p.d.header_1_tv));
      paramViewGroup.HAI = ((ImageView)paramContext.findViewById(p.d.avatar_1_iv));
      paramViewGroup.HAJ = ((TextView)paramContext.findViewById(p.d.header_2_tv));
      paramViewGroup.HAK = ((ImageView)paramContext.findViewById(p.d.avatar_2_iv));
      paramViewGroup.HAL = ((TextView)paramContext.findViewById(p.d.info_tv));
      paramViewGroup.contentView = paramContext.findViewById(p.d.search_item_content_layout);
      paramViewGroup.HAy = paramContext.findViewById(p.d.padding_view);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      com.tencent.mm.plugin.fts.ui.o.a(f.this.HAz, paramContext.HAH);
      com.tencent.mm.pluginsdk.ui.a.b.g(paramContext.HAI, f.this.HAA);
      com.tencent.mm.plugin.fts.ui.o.a(f.this.HAB, paramContext.HAJ);
      if (!Util.isNullOrNil(f.this.HAC))
      {
        paramContext.HAK.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.g(paramContext.HAK, f.this.HAC);
        com.tencent.mm.plugin.fts.ui.o.y(paramContext.contentView, f.this.Hup);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.HAy.setVisibility(8);
      }
      for (;;)
      {
        paramContext.HAL.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.HAK.setVisibility(8);
        break;
        label148:
        paramContext.HAy.setVisibility(0);
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
    public TextView HAH;
    public ImageView HAI;
    public TextView HAJ;
    public ImageView HAK;
    public TextView HAL;
    public View HAy;
    public View contentView;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.f
 * JD-Core Version:    0.7.0.1
 */