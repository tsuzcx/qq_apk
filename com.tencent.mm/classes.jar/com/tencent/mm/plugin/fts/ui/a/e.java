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
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.span.l;

public final class e
  extends k
{
  public int count;
  public CharSequence jVL;
  public String talker;
  private a xcF;
  b xcG;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112064);
    this.xcF = new a();
    this.xcG = new b();
    AppMethodBeat.o(112064);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112065);
    parama = (b)parama;
    this.header = paramContext.getString(2131765092, new Object[] { Integer.valueOf(this.count) });
    this.jVL = l.d(paramContext, d.arL(this.talker), parama.gvw.getTextSize());
    AppMethodBeat.o(112065);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xcF;
  }
  
  public final a.a dPz()
  {
    return this.xcG;
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494746, paramViewGroup, false);
      paramViewGroup = (e.b)e.this.xcG;
      paramViewGroup.xcJ = paramContext.findViewById(2131302317);
      paramViewGroup.qqq = ((TextView)paramContext.findViewById(2131302315));
      paramViewGroup.xcK = paramContext.findViewById(2131305768);
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.gvw = ((TextView)paramContext.findViewById(2131305440));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112062);
      return paramContext;
    }
    
    public final void a(final Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112063);
      parama = (e.b)parama;
      n.b(e.this.header, parama.qqq);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, e.this.talker);
      n.a(e.this.jVL, parama.gvw);
      parama.xcJ.setBackgroundResource(2131231898);
      parama.xcJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(235398);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (ab.JB(e.this.talker))
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
            AppMethodBeat.o(235398);
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
    public ImageView gvv;
    public TextView gvw;
    public TextView qqq;
    public View xcJ;
    public View xcK;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e
 * JD-Core Version:    0.7.0.1
 */