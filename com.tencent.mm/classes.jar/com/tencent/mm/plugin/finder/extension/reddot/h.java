package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.j;
import com.tencent.mm.plugin.finder.cgi.do;
import com.tencent.mm.plugin.finder.preload.tabPreload.c;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mainUiIndexChangeListener", "com/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$mainUiIndexChangeListener$1;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "checkDiscovery", "", "source", "", "delayed", "", "checkDoSync", "checkExpired", "clearCheckDoSync", "getExpiredInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "innerCheckDoSync", "onAppBackground", "activity", "onAppForeground", "setup", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements q
{
  public static final a AQn;
  final FinderRedDotExpiredHandler.mainUiIndexChangeListener.1 AQo;
  final i Asl;
  private final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(366831);
    AQn = new a((byte)0);
    AppMethodBeat.o(366831);
  }
  
  public h(i parami)
  {
    AppMethodBeat.i(366766);
    this.Asl = parami;
    this.handler = new MMHandler("FinderRedDotExpired");
    this.AQo = new FinderRedDotExpiredHandler.mainUiIndexChangeListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(366766);
  }
  
  private static final void a(h paramh)
  {
    AppMethodBeat.i(371859);
    s.u(paramh, "this$0");
    aun localaun = new aun();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().b(at.a.addh, "");
    s.s(localObject, "value");
    int i;
    if (((CharSequence)localObject).length() > 0)
    {
      i = 1;
      if (i != 0) {
        localaun.parseFrom(Util.decodeHexString((String)localObject));
      }
      paramh = paramh.Asl.Su("FinderEntrance");
      localObject = new StringBuilder("[checkDoSync] hasEntranceRedDot=");
      if (paramh == null) {
        break label350;
      }
    }
    label350:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.RedDotExpiredHandler", bool + " checkInfo=" + do.a(localaun));
      if ((paramh != null) && (localaun.ZES == 1))
      {
        i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.addj, 0);
        long l2 = com.tencent.mm.kernel.h.baE().ban().a(at.a.addi, 0L);
        long l1 = l2;
        if (l2 <= 0L)
        {
          l2 = paramh.field_time;
          l1 = l2;
          if (l2 <= 0L) {
            l1 = cn.bDw();
          }
        }
        l1 = cn.bDw() - l1;
        Log.i("Finder.RedDotExpiredHandler", "[checkDoSync] diffTime=" + l1 + "ms checkCount=" + i + ", checkInfo=" + do.a(localaun));
        if ((i < localaun.ZEU) && (l1 >= localaun.ZET * 1000))
        {
          Log.i("Finder.RedDotExpiredHandler", "innerCheckDoSync...");
          ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().ho(113149, 8);
          com.tencent.mm.kernel.h.baE().ban().set(at.a.addj, Integer.valueOf(i + 1));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.addi, Long.valueOf(cn.bDw()));
        }
      }
      AppMethodBeat.o(371859);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(String paramString, long paramLong, h paramh)
  {
    AppMethodBeat.i(371855);
    s.u(paramString, "$source");
    s.u(paramh, "this$0");
    Log.i("Finder.RedDotExpiredHandler", "[checkDiscovery] source=" + paramString + " delayed=" + paramLong);
    Object localObject = paramh.Asl.Su("Discovery");
    if (localObject != null)
    {
      if ((((p)localObject).field_expiredTime > 0L) && (((p)localObject).field_expiredTime * 1000L + ((p)localObject).field_time <= cn.bDw())) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.RedDotExpiredHandler", "[checkDiscovery] source=" + paramString + " expired result=" + bool);
        if (!bool) {
          break;
        }
        paramString = ((p)localObject).field_ctrInfo.aabA;
        s.s(paramString, "ctrlInfo.field_ctrInfo.show_infos");
        Iterator localIterator = ((Iterable)paramString).iterator();
        while (localIterator.hasNext())
        {
          paramString = (bxq)localIterator.next();
          if (!Util.isNullOrNil(paramString.path))
          {
            i locali = paramh.Asl;
            localObject = paramString.path;
            paramString = (String)localObject;
            if (localObject == null) {
              paramString = "";
            }
            locali.TL(paramString);
          }
        }
      }
    }
    AppMethodBeat.o(371855);
  }
  
  private final void akm(String paramString)
  {
    AppMethodBeat.i(371853);
    this.handler.post(new h..ExternalSyntheticLambda2(paramString, 0L, this));
    AppMethodBeat.o(371853);
  }
  
  private static final void b(final String paramString, long paramLong, final h paramh)
  {
    AppMethodBeat.i(371856);
    s.u(paramString, "$source");
    s.u(paramh, "this$0");
    Log.i("Finder.RedDotExpiredHandler", "[checkExpired] source=" + paramString + " delayed=" + paramLong);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)paramh.Asl.dZr()).iterator();
    Object localObject1;
    label258:
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((localp.field_expiredTime > 0L) && (localp.field_expiredTime * 1000L + localp.field_time <= cn.bDw())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label258;
        }
        localHashSet.add(localp);
        localObject1 = z.FrZ;
        i = localp.field_ctrInfo.type;
        Object localObject2 = localp.field_tipsId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str = localp.field_revokeId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        z.e(i, (String)localObject1, (String)localObject2, 2);
        Log.w("Finder.RedDotExpiredHandler", "[checkExpired] source=" + paramString + " ctrlInfo has expired! " + localp.field_ctrInfo.type);
        break;
      }
    }
    if (!((Collection)localHashSet).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new LinkedList();
      paramh.Asl.b(-2147483648, (b)new b(localHashSet, paramh, paramString));
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        paramh = (p)paramString.next();
        Log.w("Finder.RedDotExpiredHandler", s.X("[checkExpired] onRedDotRevoke ", paramh));
        localObject1 = k.aeZF;
        localObject1 = k.cn(PluginFinder.class).q(c.class);
        s.s(localObject1, "UICProvider.of(PluginFin…bPreloadCore::class.java)");
        c.a((c)localObject1, paramh);
      }
    }
    AppMethodBeat.o(371856);
  }
  
  private static final void etp()
  {
    AppMethodBeat.i(371861);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addj, Integer.valueOf(0));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addi, Long.valueOf(0L));
    AppMethodBeat.o(371861);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(366867);
    akm("onAppBackground");
    AppMethodBeat.o(366867);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotExpiredHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<p, Boolean>
  {
    b(HashSet<p> paramHashSet, h paramh, LinkedList<p> paramLinkedList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(h paramh)
    {
      super();
    }
    
    private static final void a(h paramh, l.a parama)
    {
      AppMethodBeat.i(366700);
      s.u(paramh, "this$0");
      if ((parama != null) && (!parama.hBY)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          h.b(paramh);
        }
        AppMethodBeat.o(366700);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */