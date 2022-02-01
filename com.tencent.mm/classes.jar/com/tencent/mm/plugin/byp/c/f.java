package com.tencent.mm.plugin.byp.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af.a;
import com.tencent.mm.modelmulti.t.a;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.byp.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/config/PrivateMsgConfigManager;", "", "()V", "configList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig;", "createSendMsgInterceptors", "", "Lcom/tencent/mm/plugin/byp/config/IPrivateMsgConfig$ICreateSendMsgInterceptor;", "kotlin.jvm.PlatformType", "", "defaultSendMsgInterceptor", "Lcom/tencent/mm/plugin/byp/config/DefaultSendMsgInterceptors;", "add", "", "config", "dead", "interceptSendMsgResult", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$BuildResult;", "params", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$SendMsgParams;", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static LinkedList<e> obH;
  public static final f waY;
  private static List<e.a> waZ;
  private static final d wba;
  
  static
  {
    AppMethodBeat.i(271977);
    waY = new f();
    obH = new LinkedList();
    waZ = Collections.synchronizedList((List)new LinkedList());
    wba = new d();
    AppMethodBeat.o(271977);
  }
  
  public static t.a i(t.e parame)
  {
    AppMethodBeat.i(271972);
    s.u(parame, "params");
    List localList = waZ;
    s.s(localList, "createSendMsgInterceptors");
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = waZ;
        s.s(localObject1, "createSendMsgInterceptors");
        Iterator localIterator = ((Iterable)localObject1).iterator();
        localObject1 = null;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (e.a)localIterator.next();
          if (((e.a)localObject2).g(parame)) {
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject2 = ah.aiuX;
          if (localObject1 == null)
          {
            localObject1 = (e.a)wba;
            if (parame.oNu != t.d.oNc) {
              break;
            }
            s.checkNotNull(localObject1);
            parame = ((e.a)localObject1).c(parame);
            AppMethodBeat.o(271972);
            return parame;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(271972);
      }
    }
    if (parame.oNu == t.d.oNd)
    {
      s.checkNotNull(localObject1);
      parame = ((e.a)localObject1).h(parame);
      AppMethodBeat.o(271972);
      return parame;
    }
    if (parame.oNu == t.d.oNe)
    {
      s.checkNotNull(localObject1);
      parame = ((e.a)localObject1).d(parame);
      AppMethodBeat.o(271972);
      return parame;
    }
    if (parame.oNu == t.d.oNf)
    {
      s.checkNotNull(localObject1);
      parame = ((e.a)localObject1).e(parame);
      AppMethodBeat.o(271972);
      return parame;
    }
    if (parame.oNu == t.d.oNg)
    {
      s.checkNotNull(localObject1);
      parame = ((e.a)localObject1).f(parame);
      AppMethodBeat.o(271972);
      return parame;
    }
    AppMethodBeat.o(271972);
    return null;
  }
  
  public final void a(e parame)
  {
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(271982);
        s.u(parame, "config");
        localObject2 = ((Iterable)obH).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          localObject3 = (e)localObject1;
          if (s.p(parame.name(), ((e)localObject3).name()))
          {
            if ((e)localObject1 != null) {
              break label314;
            }
            obH.add(parame);
            localObject1 = parame.div();
            s.s(localObject1, "config.syncHandler");
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (a)((Iterator)localObject1).next();
            ((c)h.az(c.class)).addBypSyncHandler(((a)localObject2).dik(), (com.tencent.mm.plugin.byp.a.b)localObject2);
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      finally {}
    }
    waZ.add(parame.diw());
    ((n)h.ax(n.class)).bzG().a(parame.dit());
    ((n)h.ax(n.class)).bzA().a(parame.diu());
    af.a.a(parame.dix());
    Object localObject1 = parame.diy().first;
    s.s(localObject1, "config.avatarInterceptors.first");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = a.b.iKa();
      if ((localObject3 instanceof com.tencent.mm.pluginsdk.ui.b)) {
        ((com.tencent.mm.pluginsdk.ui.b)localObject3).a((String)localObject2, (j.a)parame.diy().second);
      }
    }
    label314:
    AppMethodBeat.o(271982);
  }
  
  public final void dead()
  {
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      try
      {
        AppMethodBeat.i(271985);
        Iterator localIterator = ((Iterable)obH).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (e)localIterator.next();
        localObject3 = ((e)localObject2).div();
        s.s(localObject3, "it.syncHandler");
        localObject3 = ((Iterable)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (a)((Iterator)localObject3).next();
          ((c)h.az(c.class)).removeBypSyncHandler(((a)localObject4).dik());
          continue;
        }
        waZ.remove(((e)localObject2).diw());
      }
      finally {}
      ((n)h.ax(n.class)).bzG().b(((e)localObject2).dit());
      ((n)h.ax(n.class)).bzA().b(((e)localObject2).diu());
      af.a.b(((e)localObject2).dix());
      Object localObject2 = ((e)localObject2).diy().first;
      s.s(localObject2, "it.avatarInterceptors.first");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = a.b.iKa();
        if ((localObject4 instanceof com.tencent.mm.pluginsdk.ui.b)) {
          ((com.tencent.mm.pluginsdk.ui.b)localObject4).bqB((String)localObject3);
        }
      }
    }
    AppMethodBeat.o(271985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c.f
 * JD-Core Version:    0.7.0.1
 */