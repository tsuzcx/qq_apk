package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.chatting.a.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.ba;
import com.tencent.mm.plugin.finder.report.f.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.finder.ui.FinderBaseConversationFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;", "onHelloClick", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;", "", "(Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;Lkotlin/jvm/functions/Function1;)V", "onItemClick", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c.a
{
  public static final a AFE;
  private final FinderBaseConversationFragment AFF;
  private final kotlin.g.a.b<com.tencent.mm.ui.anim.c.a, ah> AFG;
  
  static
  {
    AppMethodBeat.i(336035);
    AFE = new a((byte)0);
    AppMethodBeat.o(336035);
  }
  
  public d(FinderBaseConversationFragment paramFinderBaseConversationFragment, kotlin.g.a.b<? super com.tencent.mm.ui.anim.c.a, ah> paramb)
  {
    AppMethodBeat.i(336019);
    this.AFF = paramFinderBaseConversationFragment;
    this.AFG = paramb;
    AppMethodBeat.o(336019);
  }
  
  public final void a(final View paramView, b paramb)
  {
    AppMethodBeat.i(336059);
    s.u(paramView, "view");
    s.u(paramb, "conv");
    paramView.setSelected(true);
    Object localObject1;
    if (s.p(paramb.field_sessionId, "findersayhisessionholder"))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = paramView.getContext();
      s.s(localObject1, "view.context");
      com.tencent.mm.plugin.finder.utils.a.hi((Context)localObject1);
      localObject1 = this.AFG;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(new com.tencent.mm.ui.anim.c.a(paramView));
      }
      paramView = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage();
      localObject1 = paramb.field_sessionId;
      s.s(localObject1, "conv.field_sessionId");
      paramView.aAB((String)localObject1);
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      paramView = paramb.field_sessionId;
      s.s(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.f.azG(paramView);
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      paramView = com.tencent.mm.plugin.finder.report.f.eMi().FuD;
      paramb = com.tencent.mm.plugin.finder.report.f.FnM;
      com.tencent.mm.plugin.finder.report.f.eMj().at(paramView.FnT, 1L);
      paramb = com.tencent.mm.plugin.finder.report.f.FnM;
      paramb = com.tencent.mm.plugin.finder.report.f.eMl();
      long l = paramView.FnT;
      paramb.FnZ = String.valueOf(cn.bDw());
      paramb.Foa = l;
      AppMethodBeat.o(336059);
      return;
    }
    if (s.p(paramb.field_sessionId, "finderaliassessionholder"))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject1 = paramView.getContext();
      s.s(localObject1, "view.context");
      com.tencent.mm.plugin.finder.utils.a.hj((Context)localObject1);
      localObject1 = this.AFG;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(new com.tencent.mm.ui.anim.c.a(paramView));
      }
      paramView = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage();
      paramb = paramb.field_sessionId;
      s.s(paramb, "conv.field_sessionId");
      paramView.aAB(paramb);
      AppMethodBeat.o(336059);
      return;
    }
    int i;
    Object localObject2;
    if (s.p(paramb.field_sessionId, "finder_system_message"))
    {
      i = h.baE().ban().getInt(at.a.addL, 0);
      paramb = z.FrZ;
      z.ar(i, 2L);
      paramb = this.AFG;
      if (paramb != null) {
        paramb.invoke(new com.tencent.mm.ui.anim.c.a(paramView));
      }
      paramView = this.AFF.getActivity();
      if (paramView != null)
      {
        paramb = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.he((Context)paramView);
      }
      if (i > 0)
      {
        paramView = z.FrZ;
        paramView = this.AFF.getActivity();
        if (paramView == null)
        {
          paramView = null;
          z.a("11", 4, 2, 5, 0, i, null, null, 0L, paramView, 0, 0, 3520);
          AppMethodBeat.o(336059);
          return;
        }
        paramb = as.GSQ;
        paramView = as.a.hu((Context)paramView);
        if (paramView == null) {}
        for (paramView = null;; paramView = paramView.fou()) {
          break;
        }
      }
    }
    else
    {
      localObject1 = paramb.field_senderUserName;
      localObject2 = (e)com.tencent.mm.plugin.findersdk.b.HbT;
      String str = paramb.field_senderUserName;
      if (str == null) {
        break label611;
      }
      if (((CharSequence)str).length() <= 0) {
        break label606;
      }
      i = 1;
      if (i != 1) {
        break label611;
      }
    }
    label606:
    label611:
    for (boolean bool = true;; bool = false)
    {
      e.a.a((e)localObject2, "FinderConversationClickListener", bool, null, false, (kotlin.g.a.a)b.AFH, 28);
      localObject2 = this.AFF.aNH().lPI;
      if (localObject2 != null) {
        ((com.tencent.mm.chatting.a)localObject2).a(paramb.field_sessionId, (String)localObject1, (a.b)new c(paramb, paramView, this));
      }
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      paramView = paramb.field_sessionId;
      s.s(paramView, "conv.field_sessionId");
      com.tencent.mm.plugin.finder.report.f.azG(paramView);
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      com.tencent.mm.plugin.finder.report.f.eMm().Foh = paramb.field_unReadCount;
      AppMethodBeat.o(336059);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationClickListener$Companion;", "", "()V", "FINDER_SYSTEM_MESSAGE", "", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final b AFH;
    
    static
    {
      AppMethodBeat.i(336162);
      AFH = new b();
      AppMethodBeat.o(336162);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/conv/FinderConversationClickListener$onItemClick$4", "Lcom/tencent/mm/chatting/IChattingCompat$IChattingActionListener;", "onChattingUIEnter", "", "onChattingUIExit", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.b
  {
    c(b paramb, View paramView, d paramd) {}
    
    public final void aNV()
    {
      AppMethodBeat.i(336146);
      Log.i("Finder.ConversationOnClickListener", "onChattingUIEnter");
      h.baE().ban().getInt(at.a.adaO, 1);
      y localy = (y)h.ax(y.class);
      Object localObject = this.AFI.contact;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((az)localObject).field_username)
      {
        localy.a((String)localObject, Boolean.TRUE);
        AppMethodBeat.o(336146);
        return;
      }
    }
    
    public final boolean aNW()
    {
      AppMethodBeat.i(336152);
      Log.i("Finder.ConversationOnClickListener", "onChattingUIExit");
      com.tencent.mm.ae.d.a(0L, (Runnable)new com.tencent.mm.ui.anim.c.a(paramView));
      if ((d.a(jdField_this) instanceof FinderBaseConversationFragment)) {
        d.a(jdField_this).faI();
      }
      AppMethodBeat.o(336152);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.d
 * JD-Core Version:    0.7.0.1
 */