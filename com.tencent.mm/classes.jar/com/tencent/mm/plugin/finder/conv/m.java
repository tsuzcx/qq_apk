package com.tencent.mm.plugin.finder.conv;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.af.b;
import com.tencent.mm.plugin.byp.c.e;
import com.tencent.mm.plugin.byp.c.e.a;
import com.tencent.mm.plugin.finder.loader.c;
import com.tencent.mm.plugin.finder.service.f;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.storage.bx.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig;", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig;", "()V", "conversationUpdater", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "getConversationUpdater", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "conversationUpdater$delegate", "Lkotlin/Lazy;", "getContactInterceptor", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "getContactInterceptor$delegate", "sendMsgInterceptor", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig$FinderCreateSendMsgInterceptor;", "getSendMsgInterceptor", "()Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig$FinderCreateSendMsgInterceptor;", "sendMsgInterceptor$delegate", "getAvatarInterceptors", "Landroid/util/Pair;", "", "", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getContactExtension", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "getConversationUpdateCallback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IConversationUpdateCallback;", "getICreateSendMsgInterceptor", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig$ICreateSendMsgInterceptor;", "getSyncHandler", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "name", "FinderCreateSendMsgInterceptor", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements e
{
  private final j AGW;
  private final j AGX;
  private final j AGY;
  
  public m()
  {
    AppMethodBeat.i(335998);
    this.AGW = k.cm((kotlin.g.a.a)b.AGZ);
    this.AGX = k.cm((kotlin.g.a.a)d.AHb);
    this.AGY = k.cm((kotlin.g.a.a)c.AHa);
    AppMethodBeat.o(335998);
  }
  
  public final i dit()
  {
    AppMethodBeat.i(336008);
    i locali = (i)this.AGW.getValue();
    AppMethodBeat.o(336008);
    return locali;
  }
  
  public final bx.a diu()
  {
    AppMethodBeat.i(336015);
    bx.a locala = ((y)com.tencent.mm.kernel.h.ax(y.class)).ePt();
    s.s(locala, "service(IFinderContactSe…s.java).iContactExtension");
    AppMethodBeat.o(336015);
    return locala;
  }
  
  public final List<com.tencent.mm.plugin.byp.a.a> div()
  {
    AppMethodBeat.i(336022);
    List localList = p.listOf(new com.tencent.mm.plugin.finder.message.a[] { new com.tencent.mm.plugin.finder.message.a(1), new com.tencent.mm.plugin.finder.message.a(5) });
    AppMethodBeat.o(336022);
    return localList;
  }
  
  public final e.a diw()
  {
    AppMethodBeat.i(336028);
    e.a locala = (e.a)this.AGX.getValue();
    AppMethodBeat.o(336028);
    return locala;
  }
  
  public final af.b dix()
  {
    AppMethodBeat.i(336036);
    af.b localb = (af.b)this.AGY.getValue();
    AppMethodBeat.o(336036);
    return localb;
  }
  
  public final Pair<List<String>, j.a> diy()
  {
    AppMethodBeat.i(336049);
    Object localObject = p.listOf(new String[] { "@findermsg", "@finder", "@findermsgstranger", "@findermsgalias" });
    j.a locala = a.b.iKa();
    if ((locala instanceof b))
    {
      localObject = new Pair(localObject, new c(((b)locala).XXP));
      AppMethodBeat.o(336049);
      return localObject;
    }
    AppMethodBeat.o(336049);
    return null;
  }
  
  public final String name()
  {
    return "FinderPrivateMsgConfig";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<h>
  {
    public static final b AGZ;
    
    static
    {
      AppMethodBeat.i(335975);
      AGZ = new b();
      AppMethodBeat.o(335975);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<f>
  {
    public static final c AHa;
    
    static
    {
      AppMethodBeat.i(335980);
      AHa = new c();
      AppMethodBeat.o(335980);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig$FinderCreateSendMsgInterceptor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<m.a>
  {
    public static final d AHb;
    
    static
    {
      AppMethodBeat.i(335994);
      AHb = new d();
      AppMethodBeat.o(335994);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.m
 * JD-Core Version:    0.7.0.1
 */