package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.c;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;

public final class e
  extends k
{
  private a HAt;
  b HAu;
  public int count;
  public CharSequence pJG;
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112064);
    this.HAt = new a();
    this.HAu = new b();
    AppMethodBeat.o(112064);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112065);
    parama = (b)parama;
    this.header = paramContext.getString(p.g.search_message_count, new Object[] { Integer.valueOf(this.count) });
    this.pJG = p.d(paramContext, d.atS(this.talker), parama.lBD.getTextSize());
    AppMethodBeat.o(112065);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HAt;
  }
  
  public final a.a fyW()
  {
    return this.HAu;
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
      AppMethodBeat.i(112062);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_conv_message_header_item, paramViewGroup, false);
      paramViewGroup = (e.b)e.this.HAu;
      paramViewGroup.HAx = paramContext.findViewById(p.d.header_view_1);
      paramViewGroup.wSo = ((TextView)paramContext.findViewById(p.d.header_tv));
      paramViewGroup.HAy = paramContext.findViewById(p.d.padding_view);
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.lBD = ((TextView)paramContext.findViewById(p.d.nickname_tv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112062);
      return paramContext;
    }
    
    public final void a(final Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112063);
      parama = (e.b)parama;
      o.b(e.this.header, parama.wSo);
      com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, e.this.talker);
      o.a(e.this.pJG, parama.lBD);
      parama.HAx.setBackgroundResource(p.c.comm_list_item_selector);
      parama.HAx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(265723);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (au.bwy(e.this.talker))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", e.this.talker);
            paramAnonymousView.putExtra("app_brand_conversation_from_scene", 1);
            paramAnonymousView.addFlags(67108864);
            c.g(paramContext, ".ui.conversation.AppBrandServiceConversationUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(265723);
            return;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", e.this.talker);
            paramAnonymousView.putExtra("finish_direct", true);
            c.g(paramContext, ".ui.chatting.ChattingUI", paramAnonymousView);
          }
        }
      });
      AppMethodBeat.o(112063);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public View HAx;
    public View HAy;
    public ImageView lBC;
    public TextView lBD;
    public TextView wSo;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.e
 * JD-Core Version:    0.7.0.1
 */