package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends a
{
  private b HBC;
  a HBD;
  public int lNL;
  public CharSequence pJG;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  
  public p(int paramInt)
  {
    super(15, paramInt);
    AppMethodBeat.i(265726);
    this.HBC = new b();
    this.HBD = new a();
    AppMethodBeat.o(265726);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(265730);
    super.a(paramContext, parama, paramVarArgs);
    parama = (a)parama;
    this.username = this.rpp.Hsz;
    this.pJG = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, this.rpp.content, parama.lBD.getTextSize());
    if ((this.rpp.HtQ instanceof Integer)) {
      this.lNL = ((Integer)this.rpp.HtQ).intValue();
    }
    AppMethodBeat.o(265730);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HBC;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final class a
    extends a.a
  {
    public ImageView lBC;
    public TextView lBD;
    public TextView lNN;
    public View rpv;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(265717);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_servicenotify_sender_item, paramViewGroup, false);
      paramViewGroup = (p.a)p.this.HBD;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.lBD = ((TextView)paramContext.findViewById(p.d.nickname_tv));
      paramViewGroup.lNN = ((TextView)paramContext.findViewById(p.d.msg_counter_tv));
      paramViewGroup.rpv = paramContext.findViewById(p.d.msg_divider);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(265717);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(265719);
      parama1 = (p)parama1;
      parama = (p.a)parama;
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, p.this.Hup);
      com.tencent.mm.pluginsdk.ui.a.b.h(parama.lBC, parama1.username);
      paramVarArgs = parama.lBD;
      g localg = g.a(parama1.pJG, p.this.FWt);
      localg.dso = paramVarArgs.getPaint();
      com.tencent.mm.plugin.fts.ui.o.a(f.a(localg).HsX, parama.lBD);
      com.tencent.mm.plugin.fts.ui.o.b(paramContext.getString(p.g.search_service_notify_msg_count_wording, new Object[] { Integer.valueOf(parama1.lNL) }), parama.lNN);
      AppMethodBeat.o(265719);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(265720);
      paramView = (p)paramVarArgs;
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("Chat_User", Util.nullAsNil("notifymessage"));
      paramVarArgs.putExtra("key_notify_message_real_username", paramView.username);
      paramVarArgs.putExtra("finish_direct", true);
      paramVarArgs.putExtra("chat_from_scene", 6);
      c.g(paramContext, ".ui.chatting.ChattingUI", paramVarArgs);
      AppMethodBeat.o(265720);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.p
 * JD-Core Version:    0.7.0.1
 */