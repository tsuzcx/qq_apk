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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n;

public final class e
  extends k
{
  public int count;
  public CharSequence iVn;
  private a tAN;
  b tAO;
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112064);
    this.tAN = new a();
    this.tAO = new b();
    AppMethodBeat.o(112064);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112065);
    parama = (b)parama;
    this.header = paramContext.getString(2131762956, new Object[] { Integer.valueOf(this.count) });
    this.iVn = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, com.tencent.mm.plugin.fts.a.d.agg(this.talker), parama.fOg.getTextSize());
    AppMethodBeat.o(112065);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.tAN;
  }
  
  public final a.a cTJ()
  {
    return this.tAO;
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494193, paramViewGroup, false);
      paramViewGroup = (e.b)e.this.tAO;
      paramViewGroup.tAR = paramContext.findViewById(2131308326);
      paramViewGroup.oUO = ((TextView)paramContext.findViewById(2131300734));
      paramViewGroup.tAS = paramContext.findViewById(2131303131);
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.fOg = ((TextView)paramContext.findViewById(2131302867));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112062);
      return paramContext;
    }
    
    public final void a(final Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112063);
      parama = (e.b)parama;
      n.a(e.this.header, parama.oUO);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, e.this.talker);
      n.a(e.this.iVn, parama.fOg);
      parama.tAR.setBackgroundResource(2131231818);
      parama.tAR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219348);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (w.Am(e.this.talker))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", e.this.talker);
            paramAnonymousView.putExtra("app_brand_conversation_from_scene", 1);
            paramAnonymousView.addFlags(67108864);
            com.tencent.mm.bs.d.f(paramContext, ".ui.conversation.AppBrandServiceConversationUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/item/FTSConvMessageHeaderDataItem$FTSSTalkerMessageHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(219348);
            return;
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", e.this.talker);
            paramAnonymousView.putExtra("finish_direct", true);
            com.tencent.mm.bs.d.f(paramContext, ".ui.chatting.ChattingUI", paramAnonymousView);
          }
        }
      });
      AppMethodBeat.o(112063);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public ImageView fOf;
    public TextView fOg;
    public TextView oUO;
    public View tAR;
    public View tAS;
    
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