package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.b.a;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "activity", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "onHelloClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "", "(Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;Lkotlin/jvm/functions/Function1;)V", "onItemClick", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Companion", "plugin-finder_release"})
public final class e
  implements d.a
{
  public static final a rTK;
  private final ReadyChattingCompatUI rTI;
  private final d.g.a.b<b, z> rTJ;
  
  static
  {
    AppMethodBeat.i(201705);
    rTK = new a((byte)0);
    AppMethodBeat.o(201705);
  }
  
  public e(ReadyChattingCompatUI paramReadyChattingCompatUI, d.g.a.b<? super b, z> paramb)
  {
    AppMethodBeat.i(201704);
    this.rTI = paramReadyChattingCompatUI;
    this.rTJ = paramb;
    AppMethodBeat.o(201704);
  }
  
  public final void a(final View paramView, c paramc)
  {
    AppMethodBeat.i(201703);
    p.h(paramView, "view");
    p.h(paramc, "conv");
    paramView.setSelected(true);
    if (p.i(paramc.field_sessionId, "findersayhisessionholder"))
    {
      localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
      localObject = paramView.getContext();
      p.g(localObject, "view.context");
      com.tencent.mm.plugin.finder.utils.a.fb((Context)localObject);
      localObject = this.rTJ;
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(new b(paramView, paramc));
      }
      paramView = ((PluginFinder)g.ad(PluginFinder.class)).getConversationStorage();
      localObject = paramc.field_sessionId;
      p.g(localObject, "conv.field_sessionId");
      paramView.ajp((String)localObject);
      paramView = com.tencent.mm.plugin.finder.report.b.sxb;
      paramView = paramc.field_sessionId;
      p.g(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.b.aiH(paramView);
      paramView = com.tencent.mm.plugin.finder.report.b.sxb;
      paramView = com.tencent.mm.plugin.finder.report.b.cFb().sCI;
      paramc = com.tencent.mm.plugin.finder.report.b.sxb;
      com.tencent.mm.plugin.finder.report.b.cFc().M(paramView.sxc, 1L);
      paramc = com.tencent.mm.plugin.finder.report.b.sxb;
      paramc = com.tencent.mm.plugin.finder.report.b.cFe();
      long l = paramView.sxc;
      paramc.sxj = String.valueOf(ch.aDc());
      paramc.sxk = l;
      AppMethodBeat.o(201703);
      return;
    }
    com.tencent.mm.j.a locala = this.rTI.sTw;
    String str;
    if (locala != null)
    {
      str = paramc.field_sessionId;
      if (!an.aUu(paramc.field_talker)) {
        break label294;
      }
    }
    label294:
    for (Object localObject = v.aAC();; localObject = v.aAK())
    {
      locala.a(str, (String)localObject, (a.b)new b(paramc, paramView));
      paramView = com.tencent.mm.plugin.finder.report.b.sxb;
      paramView = paramc.field_sessionId;
      p.g(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.b.aiH(paramView);
      paramView = com.tencent.mm.plugin.finder.report.b.sxb;
      com.tencent.mm.plugin.finder.report.b.cFf().sxr = paramc.field_unReadCount;
      AppMethodBeat.o(201703);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/conv/FinderConversationClickListener$onItemClick$1", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-finder_release"})
  public static final class b
    implements a.b
  {
    b(c paramc, View paramView) {}
    
    public final void ZK()
    {
      AppMethodBeat.i(201701);
      ae.i("Finder.ConversationOnClickListener", "onChattingUIEnter");
      f localf = (f)g.ab(f.class);
      Object localObject = this.rTL.contact;
      if (localObject != null) {}
      for (localObject = ((an)localObject).getUsername();; localObject = null)
      {
        localf.a((String)localObject, Boolean.TRUE);
        AppMethodBeat.o(201701);
        return;
      }
    }
    
    public final boolean ZL()
    {
      AppMethodBeat.i(201702);
      ae.i("Finder.ConversationOnClickListener", "onChattingUIExit");
      com.tencent.mm.ac.c.a(0L, (Runnable)new b(paramView, this.rTL));
      AppMethodBeat.o(201702);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.e
 * JD-Core Version:    0.7.0.1
 */