package com.tencent.mm.plugin.finder.live.gala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.ui.widget.a.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet;", "", "context", "Landroid/content/Context;", "block", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "actionSheet", "Lcom/tencent/mm/plugin/finder/live/actionsheet/FinderLiveBottomSheet;", "btnTextView", "Landroid/widget/TextView;", "getContext", "()Landroid/content/Context;", "customView", "Landroid/view/View;", "groupName", "", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "mainTextView", "hide", "show", "mode", "Lcom/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet$Mode;", "Mode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final TextView abfe;
  private final TextView abff;
  private final com.tencent.mm.plugin.finder.live.a.a abwK;
  public String abwL;
  private final Context context;
  private final View dyK;
  
  public a(Context paramContext, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(371138);
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(p.f.VIw, null);
    s.s(paramContext, "from(context).inflate(R.…ala_content_layout, null)");
    this.dyK = paramContext;
    paramContext = this.dyK.findViewById(p.e.VIv);
    s.s(paramContext, "customView.findViewById(R.id.main_text)");
    this.abfe = ((TextView)paramContext);
    paramContext = this.dyK.findViewById(p.e.KQS);
    Button localButton = (Button)paramContext;
    localButton.setOnClickListener(new a..ExternalSyntheticLambda0(localButton, parama, this));
    parama = ah.aiuX;
    s.s(paramContext, "customView.findViewById<…}\n            }\n        }");
    this.abff = ((TextView)paramContext);
    paramContext = new com.tencent.mm.plugin.finder.live.a.a(this.context);
    parama = this.dyK;
    s.u(parama, "view");
    paramContext.Zum.addView(parama);
    parama = ah.aiuX;
    this.abwK = paramContext;
    this.abwL = "";
    AppMethodBeat.o(371138);
  }
  
  private static final void a(Button paramButton, kotlin.g.a.a parama, a parama1, View paramView)
  {
    AppMethodBeat.i(371145);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramButton);
    localb.cH(parama);
    localb.cH(parama1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$block");
    s.u(parama1, "this$0");
    if (s.p(paramButton.getText(), paramButton.getContext().getString(p.h.XMy)))
    {
      paramButton = com.tencent.mm.plugin.finder.live.gala.d.a.adlZ;
      com.tencent.mm.plugin.finder.live.gala.d.a.a(q.s.akfk);
      parama.invoke();
    }
    parama1.abwK.Zuj.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371145);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(371162);
    s.u(parama, "mode");
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.abwK.Zuj.dDn();
      AppMethodBeat.o(371162);
      return;
      this.abfe.setText((CharSequence)this.context.getString(p.h.XMB));
      this.abff.setBackgroundResource(p.d.btn_solid_live_small);
      this.abff.setText((CharSequence)this.context.getString(p.h.XMy));
      this.abwK.aqj(0);
      parama = com.tencent.mm.plugin.finder.live.gala.d.a.adlZ;
      com.tencent.mm.plugin.finder.live.gala.d.a.a(q.t.akfo);
      continue;
      this.abfe.setText((CharSequence)this.context.getString(p.h.XMC, new Object[] { this.abwL }));
      this.abff.setText((CharSequence)this.context.getString(p.h.XMz));
      this.abff.setBackgroundResource(p.d.GGX);
      this.abwK.aqj(4);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/FinderLiveGalaHintBottomSheet$Mode;", "", "(Ljava/lang/String;I)V", "TRANSPORT", "ENTER_HINT", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(371131);
      adly = new a("TRANSPORT", 0);
      adlz = new a("ENTER_HINT", 1);
      adlA = new a[] { adly, adlz };
      AppMethodBeat.o(371131);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.a
 * JD-Core Version:    0.7.0.1
 */