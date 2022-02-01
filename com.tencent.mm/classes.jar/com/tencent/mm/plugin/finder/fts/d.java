package com.tencent.mm.plugin.finder.fts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  m Bui;
  private a Buj;
  public String Buk;
  b Bul;
  public au contact;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  public CharSequence vFf;
  public CharSequence vFg;
  
  public d(int paramInt)
  {
    super(17, paramInt);
    AppMethodBeat.i(330960);
    this.Buj = new a();
    this.Bul = new b();
    AppMethodBeat.o(330960);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(330972);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.rpp.Hsz;
    this.Bui = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).So(this.username);
    if (this.Bui != null) {
      this.contact = this.Bui.ad(new au());
    }
    parama = com.tencent.mm.plugin.fts.a.d.atS(this.username);
    boolean bool2;
    switch (this.rpp.subtype)
    {
    default: 
      bool2 = false;
      bool1 = false;
      i = 0;
      if (i != 0)
      {
        this.vFf = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, i.a.NormalTextSize));
        this.vFf = f.a(g.a(this.vFf, this.FWt, bool1, bool2, b.a.HwK, b.c.HwR)).HsX;
        this.Buk = "";
        AppMethodBeat.o(330972);
        return;
      }
      break;
    case 3: 
      label175:
      bool2 = true;
    }
    label190:
    for (boolean bool1 = true;; bool1 = false)
    {
      break;
      this.vFf = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, i.a.NormalTextSize));
      break label175;
      bool2 = false;
      break label190;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.Buj;
  }
  
  public final String coB()
  {
    if (this.contact != null) {
      return this.contact.field_nickname;
    }
    return "";
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final String egv()
  {
    return this.username;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(330957);
      paramContext = LayoutInflater.from(paramContext).inflate(i.c.fts_finder_follow_contact_item, paramViewGroup, false);
      paramViewGroup = (d.b)d.this.Bul;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(i.b.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(i.b.title_tv));
      paramViewGroup.plr = ((TextView)paramContext.findViewById(i.b.desc_tv));
      paramViewGroup.Bun = ((TextView)paramContext.findViewById(i.b.item_desc_tv));
      paramViewGroup.rpv = paramContext.findViewById(i.b.divider);
      paramViewGroup.Buo = ((ImageView)paramContext.findViewById(i.b.verifyIV_finder_follower));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(330957);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(330982);
      paramContext = (d.b)parama;
      parama = (d)parama1;
      com.tencent.mm.plugin.fts.ui.o.w(paramContext.rpv, d.this.Hup);
      com.tencent.mm.pluginsdk.ui.a.b.g(paramContext.lBC, parama.username);
      com.tencent.mm.plugin.fts.ui.o.a(parama.vFf, paramContext.pJJ);
      com.tencent.mm.plugin.fts.ui.o.a(parama.vFg, paramContext.plr);
      com.tencent.mm.plugin.fts.ui.o.b(parama.Buk, paramContext.Bun);
      if (paramContext.Buo != null)
      {
        if ((d.this.Bui != null) && (d.this.Bui.field_authInfo != null))
        {
          ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(paramContext.Buo, d.this.Bui.field_authInfo, 1, null);
          paramContext.Buo.setVisibility(0);
          AppMethodBeat.o(330982);
          return;
        }
        paramContext.Buo.setVisibility(8);
        AppMethodBeat.o(330982);
        return;
      }
      Log.i("MicroMsg.FTS.FTSFinderFollowerDataItem", "viewHolder.verifyIV = null.");
      AppMethodBeat.o(330982);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(330967);
      paramVarArgs = (d)paramVarArgs;
      paramView = paramVarArgs.username;
      if (!Util.isNullOrNil(paramView))
      {
        a(d.this.FWt.Hte, paramVarArgs.rpp);
        paramVarArgs = new Intent();
        boolean bool = paramView.equals(z.bAW());
        paramVarArgs.putExtra("finder_username", paramView);
        if (!bool) {
          break label95;
        }
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderSelfProfile(paramContext, paramVarArgs, 30, 20);
      }
      for (;;)
      {
        AppMethodBeat.o(330967);
        return true;
        label95:
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(30, 20, 32, paramVarArgs);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramContext, paramVarArgs);
      }
    }
  }
  
  public final class b
    extends a.a
  {
    public TextView Bun;
    public ImageView Buo;
    public ImageView lBC;
    public TextView pJJ;
    public TextView plr;
    public View rpv;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.d
 * JD-Core Version:    0.7.0.1
 */