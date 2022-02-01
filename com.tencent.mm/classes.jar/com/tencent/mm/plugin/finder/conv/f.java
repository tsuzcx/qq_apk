package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.ap;
import com.tencent.mm.plugin.finder.report.d.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.FinderConversationUI;
import com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "activity", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "onHelloClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "", "(Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;Lkotlin/jvm/functions/Function1;)V", "onItemClick", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Companion", "plugin-finder_release"})
public final class f
  implements e.a
{
  public static final a xgm;
  private final ReadyChattingCompatUI xgk;
  private final kotlin.g.a.b<b, x> xgl;
  
  static
  {
    AppMethodBeat.i(269824);
    xgm = new a((byte)0);
    AppMethodBeat.o(269824);
  }
  
  public f(ReadyChattingCompatUI paramReadyChattingCompatUI, kotlin.g.a.b<? super b, x> paramb)
  {
    AppMethodBeat.i(269823);
    this.xgk = paramReadyChattingCompatUI;
    this.xgl = paramb;
    AppMethodBeat.o(269823);
  }
  
  public final void a(final View paramView, final d paramd)
  {
    AppMethodBeat.i(269822);
    p.k(paramView, "view");
    p.k(paramd, "conv");
    paramView.setSelected(true);
    Object localObject1;
    if (p.h(paramd.field_sessionId, "findersayhisessionholder"))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = paramView.getContext();
      p.j(localObject1, "view.context");
      com.tencent.mm.plugin.finder.utils.a.fO((Context)localObject1);
      localObject1 = this.xgl;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(new b(paramView, paramd));
      }
      paramView = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
      localObject1 = paramd.field_sessionId;
      p.j(localObject1, "conv.field_sessionId");
      paramView.aEI((String)localObject1);
      paramView = com.tencent.mm.plugin.finder.report.d.zUg;
      paramView = paramd.field_sessionId;
      p.j(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.d.aDT(paramView);
      paramView = com.tencent.mm.plugin.finder.report.d.zUg;
      paramView = com.tencent.mm.plugin.finder.report.d.dPc().zZG;
      paramd = com.tencent.mm.plugin.finder.report.d.zUg;
      com.tencent.mm.plugin.finder.report.d.dPd().W(paramView.zUh, 1L);
      paramd = com.tencent.mm.plugin.finder.report.d.zUg;
      paramd = com.tencent.mm.plugin.finder.report.d.dPf();
      long l = paramView.zUh;
      paramd.zUn = String.valueOf(cm.bfE());
      paramd.zUo = l;
      AppMethodBeat.o(269822);
      return;
    }
    if (p.h(paramd.field_sessionId, "finderaliassessionholder"))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      localObject1 = paramView.getContext();
      p.j(localObject1, "view.context");
      com.tencent.mm.plugin.finder.utils.a.fP((Context)localObject1);
      localObject1 = this.xgl;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(new b(paramView, paramd));
      }
      paramView = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
      paramd = paramd.field_sessionId;
      p.j(paramd, "conv.field_sessionId");
      paramView.aEI(paramd);
      AppMethodBeat.o(269822);
      return;
    }
    int i;
    Object localObject2;
    if (p.h(paramd.field_sessionId, "finder_system_message"))
    {
      localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      i = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VBp, 0);
      localObject1 = n.zWF;
      n.al(i, 2L);
      localObject1 = this.xgl;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(new b(paramView, paramd));
      }
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.fK((Context)this.xgk);
      if (i > 0)
      {
        paramView = n.zWF;
        paramView = aj.Bnu;
        paramView = aj.a.fZ((Context)this.xgk);
        if (paramView != null) {}
        for (paramView = paramView.ekY();; paramView = null)
        {
          n.a("11", 4, 2, 5, 0, i, null, null, 0L, paramView, 0, 0, 3520);
          AppMethodBeat.o(269822);
          return;
        }
      }
    }
    else
    {
      localObject1 = paramd.field_senderUserName;
      localObject2 = com.tencent.mm.plugin.findersdk.b.BuZ;
      String str = paramd.field_senderUserName;
      if (str == null) {
        break label599;
      }
      if (((CharSequence)str).length() <= 0) {
        break label594;
      }
      i = 1;
      if (i != 1) {
        break label599;
      }
    }
    label594:
    label599:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ae.f.a.a((com.tencent.mm.ae.f)localObject2, "FinderConversationClickListener", bool, false, (kotlin.g.a.a)b.xgn, 12);
      localObject2 = this.xgk.AwZ;
      if (localObject2 != null) {
        ((com.tencent.mm.j.a)localObject2).a(paramd.field_sessionId, (String)localObject1, (a.b)new c(this, paramd, paramView));
      }
      paramView = com.tencent.mm.plugin.finder.report.d.zUg;
      paramView = paramd.field_sessionId;
      p.j(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.d.aDT(paramView);
      paramView = com.tencent.mm.plugin.finder.report.d.zUg;
      com.tencent.mm.plugin.finder.report.d.dPg().zUv = paramd.field_unReadCount;
      AppMethodBeat.o(269822);
      return;
      i = 0;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener$Companion;", "", "()V", "FINDER_SYSTEM_MESSAGE", "", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<String>
  {
    public static final b xgn;
    
    static
    {
      AppMethodBeat.i(227306);
      xgn = new b();
      AppMethodBeat.o(227306);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/conv/FinderConversationClickListener$onItemClick$2", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-finder_release"})
  public static final class c
    implements a.b
  {
    c(d paramd, View paramView) {}
    
    public final void aty()
    {
      AppMethodBeat.i(266733);
      Log.i("Finder.ConversationOnClickListener", "onChattingUIEnter");
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VyS, 1);
      m localm = (m)h.ae(m.class);
      localObject = paramd.contact;
      if (localObject != null) {}
      for (localObject = ((as)localObject).getUsername();; localObject = null)
      {
        localm.a((String)localObject, Boolean.TRUE);
        AppMethodBeat.o(266733);
        return;
      }
    }
    
    public final boolean atz()
    {
      AppMethodBeat.i(266734);
      Log.i("Finder.ConversationOnClickListener", "onChattingUIExit");
      com.tencent.mm.ae.d.a(0L, (Runnable)new b(paramView, paramd));
      if ((f.a(this.xgo) instanceof FinderConversationUI))
      {
        FinderConversationUI localFinderConversationUI = (FinderConversationUI)f.a(this.xgo);
        ap localap = localFinderConversationUI.AoV;
        if ((localap != null) && (localap.dQC() == true)) {
          localFinderConversationUI.dZT();
        }
      }
      AppMethodBeat.o(266734);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.f
 * JD-Core Version:    0.7.0.1
 */