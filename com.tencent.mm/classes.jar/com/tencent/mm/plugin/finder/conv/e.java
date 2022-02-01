package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.b.a;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "activity", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "onHelloClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "", "(Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;Lkotlin/jvm/functions/Function1;)V", "onItemClick", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Companion", "plugin-finder_release"})
public final class e
  implements d.a
{
  public static final a rLw;
  private final ReadyChattingCompatUI rLu;
  private final d.g.a.b<b, z> rLv;
  
  static
  {
    AppMethodBeat.i(201278);
    rLw = new a((byte)0);
    AppMethodBeat.o(201278);
  }
  
  public e(ReadyChattingCompatUI paramReadyChattingCompatUI, d.g.a.b<? super b, z> paramb)
  {
    AppMethodBeat.i(201277);
    this.rLu = paramReadyChattingCompatUI;
    this.rLv = paramb;
    AppMethodBeat.o(201277);
  }
  
  public final void a(final View paramView, c paramc)
  {
    AppMethodBeat.i(201276);
    p.h(paramView, "view");
    p.h(paramc, "conv");
    paramView.setSelected(true);
    if (p.i(paramc.field_sessionId, "findersayhisessionholder"))
    {
      localObject = com.tencent.mm.plugin.finder.utils.a.sKD;
      localObject = paramView.getContext();
      p.g(localObject, "view.context");
      com.tencent.mm.plugin.finder.utils.a.eX((Context)localObject);
      localObject = this.rLv;
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(new b(paramView, paramc));
      }
      paramView = ((PluginFinder)g.ad(PluginFinder.class)).getConversationStorage();
      localObject = paramc.field_sessionId;
      p.g(localObject, "conv.field_sessionId");
      paramView.ais((String)localObject);
      paramView = com.tencent.mm.plugin.finder.report.b.snk;
      paramView = paramc.field_sessionId;
      p.g(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.b.ahJ(paramView);
      paramView = com.tencent.mm.plugin.finder.report.b.snk;
      paramView = com.tencent.mm.plugin.finder.report.b.cDj().ssy;
      paramc = com.tencent.mm.plugin.finder.report.b.snk;
      com.tencent.mm.plugin.finder.report.b.cDk().N(paramView.snl, 1L);
      paramc = com.tencent.mm.plugin.finder.report.b.snk;
      paramc = com.tencent.mm.plugin.finder.report.b.cDm();
      long l = paramView.snl;
      paramc.sns = String.valueOf(cf.aCM());
      paramc.snt = l;
      AppMethodBeat.o(201276);
      return;
    }
    com.tencent.mm.j.a locala = this.rLu.sIk;
    String str;
    if (locala != null)
    {
      str = paramc.field_sessionId;
      if (!am.aSU(paramc.field_talker)) {
        break label294;
      }
    }
    label294:
    for (Object localObject = u.aAm();; localObject = u.aAu())
    {
      locala.a(str, (String)localObject, (a.b)new b(paramc, paramView));
      paramView = com.tencent.mm.plugin.finder.report.b.snk;
      paramView = paramc.field_sessionId;
      p.g(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.b.ahJ(paramView);
      paramView = com.tencent.mm.plugin.finder.report.b.snk;
      com.tencent.mm.plugin.finder.report.b.cDn().snA = paramc.field_unReadCount;
      AppMethodBeat.o(201276);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/conv/FinderConversationClickListener$onItemClick$1", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-finder_release"})
  public static final class b
    implements a.b
  {
    b(c paramc, View paramView) {}
    
    public final void ZB()
    {
      AppMethodBeat.i(201274);
      ad.i("Finder.ConversationOnClickListener", "onChattingUIEnter");
      f localf = (f)g.ab(f.class);
      Object localObject = this.rLx.contact;
      if (localObject != null) {}
      for (localObject = ((am)localObject).getUsername();; localObject = null)
      {
        localf.b((String)localObject, Boolean.TRUE);
        AppMethodBeat.o(201274);
        return;
      }
    }
    
    public final boolean ZC()
    {
      AppMethodBeat.i(201275);
      ad.i("Finder.ConversationOnClickListener", "onChattingUIExit");
      com.tencent.mm.ad.c.a(0L, (Runnable)new b(paramView, this.rLx));
      AppMethodBeat.o(201275);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.e
 * JD-Core Version:    0.7.0.1
 */