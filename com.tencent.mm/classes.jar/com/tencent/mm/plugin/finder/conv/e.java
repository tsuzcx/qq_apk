package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.FinderConversationUI;
import com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "activity", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "onHelloClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "", "(Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;Lkotlin/jvm/functions/Function1;)V", "onItemClick", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Companion", "plugin-finder_release"})
public final class e
  implements d.a
{
  public static final a tyB;
  private final kotlin.g.a.b<b, x> tyA;
  private final ReadyChattingCompatUI tyz;
  
  static
  {
    AppMethodBeat.i(242727);
    tyB = new a((byte)0);
    AppMethodBeat.o(242727);
  }
  
  public e(ReadyChattingCompatUI paramReadyChattingCompatUI, kotlin.g.a.b<? super b, x> paramb)
  {
    AppMethodBeat.i(242726);
    this.tyz = paramReadyChattingCompatUI;
    this.tyA = paramb;
    AppMethodBeat.o(242726);
  }
  
  public final void a(final View paramView, final c paramc)
  {
    AppMethodBeat.i(242725);
    p.h(paramView, "view");
    p.h(paramc, "conv");
    paramView.setSelected(true);
    if (p.j(paramc.field_sessionId, "findersayhisessionholder"))
    {
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject = paramView.getContext();
      p.g(localObject, "view.context");
      com.tencent.mm.plugin.finder.utils.a.fC((Context)localObject);
      localObject = this.tyA;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(new b(paramView, paramc));
      }
      paramView = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage();
      localObject = paramc.field_sessionId;
      p.g(localObject, "conv.field_sessionId");
      paramView.avs((String)localObject);
      paramView = com.tencent.mm.plugin.finder.report.d.vdp;
      paramView = paramc.field_sessionId;
      p.g(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.d.auB(paramView);
      paramView = com.tencent.mm.plugin.finder.report.d.vdp;
      paramView = com.tencent.mm.plugin.finder.report.d.dnF().viN;
      paramc = com.tencent.mm.plugin.finder.report.d.vdp;
      com.tencent.mm.plugin.finder.report.d.dnG().R(paramView.vdq, 1L);
      paramc = com.tencent.mm.plugin.finder.report.d.vdp;
      paramc = com.tencent.mm.plugin.finder.report.d.dnI();
      long l = paramView.vdq;
      paramc.vdw = String.valueOf(cl.aWA());
      paramc.vdx = l;
      AppMethodBeat.o(242725);
      return;
    }
    com.tencent.mm.j.a locala;
    String str;
    if (p.j(paramc.field_sessionId, "finder_system_message"))
    {
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.Oms, 0);
      localObject = k.vfA;
      k.ai(i, 2L);
      localObject = this.tyA;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(new b(paramView, paramc));
      }
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.fy((Context)this.tyz);
      if (i > 0)
      {
        paramView = k.vfA;
        paramView = FinderReporterUIC.wzC;
        paramView = FinderReporterUIC.a.fH((Context)this.tyz);
        if (paramView != null) {}
        for (paramView = paramView.dIx();; paramView = null)
        {
          k.a("11", 4, 2, 5, 0, i, null, null, 0L, paramView, 0, 0, 3520);
          AppMethodBeat.o(242725);
          return;
        }
      }
    }
    else
    {
      locala = this.tyz.vQb;
      if (locala != null)
      {
        str = paramc.field_sessionId;
        if (!as.bjt(paramc.field_talker)) {
          break label451;
        }
      }
    }
    label451:
    for (Object localObject = z.aTY();; localObject = z.aUg())
    {
      locala.a(str, (String)localObject, (a.b)new b(this, paramc, paramView));
      paramView = com.tencent.mm.plugin.finder.report.d.vdp;
      paramView = paramc.field_sessionId;
      p.g(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.d.auB(paramView);
      paramView = com.tencent.mm.plugin.finder.report.d.vdp;
      com.tencent.mm.plugin.finder.report.d.dnJ().vdE = paramc.field_unReadCount;
      AppMethodBeat.o(242725);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener$Companion;", "", "()V", "FINDER_SYSTEM_MESSAGE", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/conv/FinderConversationClickListener$onItemClick$1", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-finder_release"})
  public static final class b
    implements a.b
  {
    b(c paramc, View paramView) {}
    
    public final void anx()
    {
      AppMethodBeat.i(242723);
      Log.i("Finder.ConversationOnClickListener", "onChattingUIEnter");
      m localm = (m)g.af(m.class);
      Object localObject = paramc.contact;
      if (localObject != null) {}
      for (localObject = ((as)localObject).getUsername();; localObject = null)
      {
        localm.a((String)localObject, Boolean.TRUE);
        AppMethodBeat.o(242723);
        return;
      }
    }
    
    public final boolean any()
    {
      AppMethodBeat.i(242724);
      Log.i("Finder.ConversationOnClickListener", "onChattingUIExit");
      com.tencent.mm.ac.d.a(0L, (Runnable)new b(paramView, paramc));
      if ((e.a(this.tyC) instanceof FinderConversationUI))
      {
        FinderConversationUI localFinderConversationUI = (FinderConversationUI)e.a(this.tyC);
        al localal = localFinderConversationUI.vHY;
        if ((localal != null) && (localal.doZ() == true)) {
          localFinderConversationUI.dzc();
        }
      }
      AppMethodBeat.o(242724);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.e
 * JD-Core Version:    0.7.0.1
 */