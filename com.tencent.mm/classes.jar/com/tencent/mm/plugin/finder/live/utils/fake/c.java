package com.tencent.mm.plugin.finder.live.utils.fake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.util.s.b;
import com.tencent.mm.plugin.finder.live.util.s.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil;", "", "()V", "GIFT_COMMAND", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "Lkotlin/collections/HashMap;", "getGIFT_COMMAND", "()Ljava/util/HashMap;", "GIFT_ID", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "getGIFT_ID", "IS_PRECIOUS", "", "getIS_PRECIOUS", "()[Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "[Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "TAG", "", "executeBatchMockCommand", "", "commandList", "", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "forceAddAll", "", "executeSingleMockCommand", "index", "", "command", "GiftInfo", "IGiftFactory", "MockCommand", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c DKj;
  private static final e[] DKk;
  private static final HashMap<e, c.b> DKl;
  private static final HashMap<e, c> DKm;
  
  static
  {
    AppMethodBeat.i(351118);
    DKj = new c();
    DKk = new e[] { e.DKA, e.DKB, e.DKC, e.DKD, e.DKz, e.DKE, e.DKF };
    Object localObject = new HashMap();
    ((Map)localObject).put(e.DKw, new c.b(e.DKw.id, s.X("test_", e.DKw.DKv)));
    ((Map)localObject).put(e.DKx, new c.b(e.DKx.id, s.X("test_", e.DKx.DKv)));
    ((Map)localObject).put(e.DKy, new c.b(e.DKy.id, s.X("test_", e.DKy.DKv)));
    ((Map)localObject).put(e.DKz, new c.b(e.DKz.id, s.X("test_", e.DKz.DKv)));
    ((Map)localObject).put(e.DKA, new c.b(e.DKA.id, s.X("test_", e.DKA.DKv)));
    ((Map)localObject).put(e.DKB, new c.b(e.DKB.id, s.X("test_", e.DKB.DKv)));
    ((Map)localObject).put(e.DKC, new c.b(e.DKC.id, s.X("test_", e.DKC.DKv)));
    ((Map)localObject).put(e.DKD, new c.b(e.DKD.id, s.X("test_", e.DKD.DKv)));
    ((Map)localObject).put(e.DKE, new c.b(e.DKE.id, s.X("test_", e.DKE.DKv)));
    ((Map)localObject).put(e.DKF, new c.b(e.DKF.id, s.X("test_", e.DKF.DKv)));
    DKl = (HashMap)localObject;
    DKm = new HashMap();
    localObject = ((Map)DKl).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      ((Map)DKm).put(localEntry.getKey(), new a(localEntry));
    }
    AppMethodBeat.o(351118);
  }
  
  public static e[] euU()
  {
    return DKk;
  }
  
  public static HashMap<e, c.b> euV()
  {
    return DKl;
  }
  
  public static HashMap<e, c> euW()
  {
    return DKm;
  }
  
  public static void k(List<d> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(351098);
    s.u(paramList, "commandList");
    Log.i("Finder.FinderLiveGiftMockUtil", s.X("executeBatchMockCommand: ", paramList));
    Object localObject1;
    if (paramBoolean)
    {
      Object localObject2 = (Iterable)paramList;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((d)((Iterator)localObject2).next()).euY());
      }
      localObject1 = p.J((Collection)localObject1);
      paramList = (d)paramList.get(0);
      if (paramList.DKq)
      {
        com.tencent.mm.ae.d.a(paramList.DKr, (kotlin.g.a.a)new e((List)localObject1));
        AppMethodBeat.o(351098);
        return;
      }
      localObject2 = kotlin.j.c.aixl;
      com.tencent.mm.ae.d.a(s.X("FinderLiveGiftMockUtil", Integer.valueOf(kotlin.j.c.klI().Zo() % 4)), false, (kotlin.g.a.a)new f((List)localObject1), paramList.DKr, 2);
      AppMethodBeat.o(351098);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject1 = paramList.next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      localObject1 = (d)localObject1;
      if (((d)localObject1).DKq)
      {
        com.tencent.mm.ae.d.a(((d)localObject1).DKr, (kotlin.g.a.a)new g((d)localObject1));
        i = j;
      }
      else
      {
        com.tencent.mm.ae.d.a(s.X("FinderLiveGiftMockUtil", Integer.valueOf(i % 4)), false, (kotlin.g.a.a)new h((d)localObject1), ((d)localObject1).DKr, 2);
        i = j;
      }
    }
    AppMethodBeat.o(351098);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$1$1", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "create", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c.c
  {
    a(Map.Entry<? extends e, c.b> paramEntry) {}
    
    public final c.d Pv(int paramInt)
    {
      AppMethodBeat.i(351067);
      c.d locald = new c.d(paramInt);
      Object localObject = ((c.b)this.DKn.getValue()).name;
      s.u(localObject, "_nickName");
      locald.nickname = ((String)localObject);
      localObject = (e)this.DKn.getKey();
      s.u(localObject, "<set-?>");
      locald.DKo = ((e)localObject);
      AppMethodBeat.o(351067);
      return locald;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "", "create", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract c.d Pv(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "", "count", "", "(I)V", "clientMsgId", "", "getCount", "()I", "setCount", "executeDelayMs", "", "executeInMainThread", "", "getExecuteInMainThread", "()Z", "setExecuteInMainThread", "(Z)V", "gift", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "getGift", "()Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "setGift", "(Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;)V", "giftComboId", "isSelfSend", "nickname", "targetUsername", "build", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "_clientMsgId", "comboId", "_comboId", "delay", "_executeDelayMs", "getDelayTime", "name", "_nickName", "self", "_targetUsername", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    private String ACm;
    e DKo;
    private String DKp;
    boolean DKq;
    long DKr;
    private boolean Dbw;
    private int count;
    private String kLn;
    String nickname;
    
    public d(int paramInt)
    {
      this.count = paramInt;
      this.DKo = e.DKw;
      this.DKp = "";
      this.ACm = "";
      this.kLn = "";
    }
    
    public final d axS(String paramString)
    {
      AppMethodBeat.i(351079);
      s.u(paramString, "_comboId");
      this.DKp = paramString;
      AppMethodBeat.o(351079);
      return this;
    }
    
    public final d axT(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.ACm = str;
      return this;
    }
    
    public final d axU(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.kLn = str;
      return this;
    }
    
    public final d euX()
    {
      AppMethodBeat.i(351075);
      this.Dbw = true;
      this.nickname = z.bAO();
      AppMethodBeat.o(351075);
      return this;
    }
    
    public final s.b euY()
    {
      Object localObject4 = null;
      AppMethodBeat.i(351099);
      bek localbek = new bek();
      s.c localc = s.c.DJx;
      Object localObject2;
      Object localObject1;
      label84:
      Object localObject3;
      label138:
      label210:
      label249:
      int i;
      if (Util.isNullOrNil(this.DKp))
      {
        localObject2 = new StringBuilder();
        localObject1 = c.DKj;
        localObject1 = (c.b)c.euV().get(this.DKo);
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject2 = localObject1 + '_' + UUID.randomUUID();
          bdm localbdm = new bdm();
          localbdm.ZOb = new bgh();
          localObject1 = localbdm.ZOb;
          if (localObject1 != null) {
            ((bgh)localObject1).contact = new FinderContact();
          }
          localObject1 = localbdm.ZOb;
          if (localObject1 != null) {
            break label449;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            String str = this.nickname;
            localObject3 = str;
            if (str == null)
            {
              localObject3 = kotlin.j.c.aixl;
              localObject3 = s.X("测试", Integer.valueOf(kotlin.j.c.klI().Zo()));
            }
            ((FinderContact)localObject1).nickname = ((String)localObject3);
          }
          localObject3 = localbdm.ZOb;
          if (localObject3 != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
            localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
            if (localObject1 != null) {
              break label457;
            }
            localObject1 = null;
            ((bgh)localObject3).ZKa = ((LinkedList)localObject1);
          }
          localbdm.Tro = this.kLn;
          localObject1 = c.DKj;
          localObject1 = (c.b)c.euV().get(this.DKo);
          if (localObject1 != null) {
            break label485;
          }
          localObject1 = null;
          localbek.ZOC = ((String)localObject1);
          localObject3 = new s.b(localbdm);
          ((s.b)localObject3).c(localc);
          ((s.b)localObject3).a(localbek);
          ((s.b)localObject3).Dbx = ((String)localObject2);
          ((s.b)localObject3).Dby = 0;
          ((s.b)localObject3).DJo = this.count;
          localObject1 = c.DKj;
          ((s.b)localObject3).DJp = k.contains(c.euU(), this.DKo);
          ((s.b)localObject3).Dbw = this.Dbw;
          localObject1 = c.DKj;
          localObject1 = (c.b)c.euV().get(this.DKo);
          if (localObject1 != null) {
            break label493;
          }
          localObject1 = localObject4;
          label354:
          ((s.b)localObject3).DbF = ((String)localObject1);
          ((s.b)localObject3).awW(this.ACm);
          if ((Util.isNullOrNil((String)localObject2)) || ((((s.b)localObject3).Dby <= 1) && (((s.b)localObject3).DJo <= 1))) {
            break label501;
          }
          i = 1;
          label396:
          if (!this.Dbw) {
            break label531;
          }
          if (!((s.b)localObject3).DJp) {
            break label513;
          }
          if (i == 0) {
            break label506;
          }
          localObject1 = s.c.DJq;
        }
      }
      for (;;)
      {
        ((s.b)localObject3).c((s.c)localObject1);
        AppMethodBeat.o(351099);
        return localObject3;
        localObject1 = ((c.b)localObject1).name;
        break;
        localObject2 = this.DKp;
        break label84;
        label449:
        localObject1 = ((bgh)localObject1).contact;
        break label138;
        label457:
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label210;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Ecm;
        break label210;
        label485:
        localObject1 = ((c.b)localObject1).DbF;
        break label249;
        label493:
        localObject1 = ((c.b)localObject1).DbF;
        break label354;
        label501:
        i = 0;
        break label396;
        label506:
        localObject1 = s.c.DJr;
        continue;
        label513:
        if (i != 0)
        {
          localObject1 = s.c.DJs;
        }
        else
        {
          localObject1 = s.c.DJt;
          continue;
          label531:
          if (((s.b)localObject3).DJp)
          {
            if (i != 0) {
              localObject1 = s.c.DJu;
            } else {
              localObject1 = s.c.DJv;
            }
          }
          else if (i != 0) {
            localObject1 = s.c.DJw;
          } else {
            localObject1 = s.c.DJx;
          }
        }
      }
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(351111);
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = q.CFU;
      Object localObject3 = q.ekL();
      localObject1 = c.DKj;
      localObject1 = (c.b)c.euV().get(this.DKo);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject1 = (com.tencent.d.a.a.a.d.a.d)((Map)localObject3).get(localObject1);
        if (localObject1 != null) {
          break label329;
        }
        localObject1 = null;
        label67:
        localStringBuilder = localStringBuilder.append(s.X("giftName = ", localObject1)).append(", ").append(s.X("comboId = ", this.DKp)).append(", ").append(s.X("count = ", Integer.valueOf(this.count))).append(", ").append(s.X("executeInMainThread = ", Boolean.valueOf(this.DKq))).append(", ").append("nickname = " + this.nickname + " ,").append("isSelfSend = " + this.Dbw + " ,");
        localObject3 = new StringBuilder("giftLocalName = ");
        localObject1 = c.DKj;
        localObject1 = (c.b)c.euV().get(this.DKo);
        if (localObject1 != null) {
          break label337;
        }
      }
      label329:
      label337:
      for (localObject1 = localObject2;; localObject1 = ((c.b)localObject1).name)
      {
        localObject1 = ((StringBuilder)localObject3).append(localObject1).append(", ").toString() + s.X("executeDelayMs = ", Long.valueOf(this.DKr)) + ", " + s.X("targetUserName = ", this.ACm) + "\n";
        s.s(localObject1, "StringBuilder()\n        …              .toString()");
        AppMethodBeat.o(351111);
        return localObject1;
        localObject1 = ((c.b)localObject1).DbF;
        break;
        localObject1 = ((com.tencent.d.a.a.a.d.a.d)localObject1).field_name;
        break label67;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(List<s.b> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(List<s.b> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(c.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(c.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.c
 * JD-Core Version:    0.7.0.1
 */