package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.c;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.pluginsdk.ui.span.l;

public final class e
  extends k
{
  private a BOD;
  b BOE;
  public int count;
  public CharSequence mMY;
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112064);
    this.BOD = new a();
    this.BOE = new b();
    AppMethodBeat.o(112064);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112065);
    parama = (b)parama;
    this.header = paramContext.getString(o.g.search_message_count, new Object[] { Integer.valueOf(this.count) });
    this.mMY = l.d(paramContext, d.azM(this.talker), parama.iZH.getTextSize());
    AppMethodBeat.o(112065);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BOD;
  }
  
  public final a.a erV()
  {
    return this.BOE;
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_conv_message_header_item, paramViewGroup, false);
      paramViewGroup = (e.b)e.this.BOE;
      paramViewGroup.BOH = paramContext.findViewById(o.d.header_view_1);
      paramViewGroup.tOY = ((TextView)paramContext.findViewById(o.d.header_tv));
      paramViewGroup.BOI = paramContext.findViewById(o.d.padding_view);
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(o.d.avatar_iv));
      paramViewGroup.iZH = ((TextView)paramContext.findViewById(o.d.nickname_tv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112062);
      return paramContext;
    }
    
    public final void a(final Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112063);
      parama = (e.b)parama;
      n.a(e.this.header, parama.tOY);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, e.this.talker);
      n.a(e.this.mMY, parama.iZH);
      parama.BOH.setBackgroundResource(o.c.comm_list_item_selector);
      parama.BOH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194466);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (ab.QU(e.this.talker))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", e.this.talker);
            paramAnonymousView.putExtra("app_brand_conversation_from_scene", 1);
            paramAnonymousView.addFlags(67108864);
            c.f(paramContext, ".ui.conversation.AppBrandServiceConversationUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194466);
            return;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", e.this.talker);
            paramAnonymousView.putExtra("finish_direct", true);
            c.f(paramContext, ".ui.chatting.ChattingUI", paramAnonymousView);
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
    public View BOH;
    public View BOI;
    public ImageView iZG;
    public TextView iZH;
    public TextView tOY;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e
 * JD-Core Version:    0.7.0.1
 */