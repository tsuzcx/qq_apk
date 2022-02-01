package com.tencent.mm.plugin.finder.live.utils.fake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.plugin.finder.live.util.p.b;
import com.tencent.mm.plugin.finder.live.util.p.c;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.aza;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil;", "", "()V", "GIFT_COMMAND", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "Lkotlin/collections/HashMap;", "getGIFT_COMMAND", "()Ljava/util/HashMap;", "GIFT_ID", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "getGIFT_ID", "IS_PRECIOUS", "", "getIS_PRECIOUS", "()[Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "[Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "TAG", "", "executeBatchMockCommand", "", "commandList", "", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "forceAddAll", "", "executeSingleMockCommand", "index", "", "command", "GiftInfo", "IGiftFactory", "MockCommand", "plugin-finder_release"})
public final class c
{
  private static final e[] yRS;
  private static final HashMap<e, b> yRT;
  private static final HashMap<e, c> yRU;
  public static final c yRV;
  
  static
  {
    AppMethodBeat.i(274784);
    yRV = new c();
    yRS = new e[] { e.ySk, e.ySl, e.ySm, e.ySn };
    Object localObject = new HashMap();
    ((Map)localObject).put(e.ySg, new b(e.ySg.id, "test_" + e.ySg.ySp));
    ((Map)localObject).put(e.ySh, new b(e.ySh.id, "test_" + e.ySh.ySp));
    ((Map)localObject).put(e.ySi, new b(e.ySi.id, "test_" + e.ySi.ySp));
    ((Map)localObject).put(e.ySj, new b(e.ySj.id, "test_" + e.ySj.ySp));
    ((Map)localObject).put(e.ySk, new b(e.ySk.id, "test_" + e.ySk.ySp));
    ((Map)localObject).put(e.ySl, new b(e.ySl.id, "test_" + e.ySl.ySp));
    ((Map)localObject).put(e.ySm, new b(e.ySm.id, "test_" + e.ySm.ySp));
    ((Map)localObject).put(e.ySn, new b(e.ySn.id, "test_" + e.ySn.ySp));
    yRT = (HashMap)localObject;
    yRU = new HashMap();
    localObject = ((Map)yRT).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      ((Map)yRU).put(localEntry.getKey(), new a(localEntry));
    }
    AppMethodBeat.o(274784);
  }
  
  public static void d(List<d> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(274782);
    p.k(paramList, "commandList");
    Log.i("Finder.FinderLiveGiftMockUtil", "executeBatchMockCommand: ".concat(String.valueOf(paramList)));
    Object localObject1;
    if (paramBoolean)
    {
      Object localObject2 = (Iterable)paramList;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((d)((Iterator)localObject2).next()).dEU());
      }
      localObject1 = j.t((Collection)localObject1);
      paramList = (d)paramList.get(0);
      if (paramList.yRZ)
      {
        d.a(paramList.ySa, (kotlin.g.a.a)new e((List)localObject1));
        AppMethodBeat.o(274782);
        return;
      }
      localObject2 = new StringBuilder("FinderLiveGiftMockUtil");
      kotlin.j.c.b localb = kotlin.j.c.aaBL;
      d.a(kotlin.j.c.iCt().zD() % 4, (kotlin.g.a.a)new f((List)localObject1), paramList.ySa);
      AppMethodBeat.o(274782);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject1 = paramList.next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (d)localObject1;
      if (((d)localObject1).yRZ)
      {
        d.a(((d)localObject1).ySa, (kotlin.g.a.a)new g((d)localObject1));
        i = j;
      }
      else
      {
        d.a("FinderLiveGiftMockUtil" + i % 4, (kotlin.g.a.a)new h((d)localObject1), ((d)localObject1).ySa);
        i = j;
      }
    }
    AppMethodBeat.o(274782);
  }
  
  public static e[] dEQ()
  {
    return yRS;
  }
  
  public static HashMap<e, b> dER()
  {
    return yRT;
  }
  
  public static HashMap<e, c> dES()
  {
    return yRU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$1$1", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "create", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder_release"})
  public static final class a
    implements c.c
  {
    a(Map.Entry paramEntry) {}
    
    public final c.d NL(int paramInt)
    {
      AppMethodBeat.i(269890);
      c.d locald = new c.d(paramInt);
      Object localObject = ((c.b)this.yRW.getValue()).name;
      p.k(localObject, "_nickName");
      locald.nickname = ((String)localObject);
      localObject = (e)this.yRW.getKey();
      p.k(localObject, "<set-?>");
      locald.yRX = ((e)localObject);
      AppMethodBeat.o(269890);
      return locald;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "", "giftId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getGiftId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    final String name;
    final String yrC;
    
    public b(String paramString1, String paramString2)
    {
      AppMethodBeat.i(277395);
      this.yrC = paramString1;
      this.name = paramString2;
      AppMethodBeat.o(277395);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(277399);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.yrC, paramObject.yrC)) || (!p.h(this.name, paramObject.name))) {}
        }
      }
      else
      {
        AppMethodBeat.o(277399);
        return true;
      }
      AppMethodBeat.o(277399);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(277397);
      String str = this.yrC;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.name;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(277397);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(277396);
      String str = "GiftInfo(giftId=" + this.yrC + ", name=" + this.name + ")";
      AppMethodBeat.o(277396);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "", "create", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract c.d NL(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "", "count", "", "(I)V", "clientMsgId", "", "getCount", "()I", "setCount", "executeDelayMs", "", "executeInMainThread", "", "getExecuteInMainThread", "()Z", "setExecuteInMainThread", "(Z)V", "gift", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "getGift", "()Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "setGift", "(Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;)V", "giftComboId", "isSelfSend", "nickname", "targetUsername", "build", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "_clientMsgId", "comboId", "_comboId", "delay", "_executeDelayMs", "getDelayTime", "name", "_nickName", "self", "_targetUsername", "toString", "plugin-finder_release"})
  public static final class d
  {
    private int count;
    private String ilo;
    String nickname;
    private String xcW;
    e yRX;
    private String yRY;
    boolean yRZ;
    long ySa;
    private boolean yrt;
    
    public d(int paramInt)
    {
      this.count = paramInt;
      this.yRX = e.ySg;
      this.yRY = "";
      this.xcW = "";
      this.ilo = "";
    }
    
    public final d aCR(String paramString)
    {
      AppMethodBeat.i(281835);
      p.k(paramString, "_comboId");
      this.yRY = paramString;
      AppMethodBeat.o(281835);
      return this;
    }
    
    public final d aCS(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.xcW = str;
      return this;
    }
    
    public final d aCT(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.ilo = str;
      return this;
    }
    
    public final d dET()
    {
      AppMethodBeat.i(281834);
      this.yrt = true;
      this.nickname = z.bdb();
      AppMethodBeat.o(281834);
      return this;
    }
    
    public final p.b dEU()
    {
      Object localObject3 = null;
      AppMethodBeat.i(281836);
      Object localObject5 = new axu();
      p.c localc = p.c.yQN;
      Object localObject2;
      Object localObject1;
      label87:
      Object localObject4;
      label242:
      int i;
      if (Util.isNullOrNil(this.yRY))
      {
        localObject2 = new StringBuilder();
        localObject1 = c.yRV;
        localObject1 = (c.b)c.dER().get(this.yRX);
        if (localObject1 != null)
        {
          localObject1 = ((c.b)localObject1).name;
          localObject1 = (String)localObject1 + '_' + UUID.randomUUID();
          axe localaxe = new axe();
          localaxe.SJH = new aza();
          localObject2 = localaxe.SJH;
          if (localObject2 != null) {
            ((aza)localObject2).contact = new FinderContact();
          }
          localObject2 = localaxe.SJH;
          if (localObject2 != null)
          {
            FinderContact localFinderContact = ((aza)localObject2).contact;
            if (localFinderContact != null)
            {
              localObject4 = this.nickname;
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = new StringBuilder("测试");
                localObject4 = kotlin.j.c.aaBL;
                localObject2 = kotlin.j.c.iCt().zD();
              }
              localFinderContact.nickname = ((String)localObject2);
            }
          }
          localObject4 = localaxe.SJH;
          if (localObject4 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
            localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
            if (localObject2 == null) {
              break label489;
            }
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
            if (localObject2 == null) {
              break label489;
            }
            localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).zeX;
            ((aza)localObject4).SHe = ((LinkedList)localObject2);
          }
          localaxe.SJs = this.ilo;
          localObject2 = c.yRV;
          localObject2 = (c.b)c.dER().get(this.yRX);
          if (localObject2 == null) {
            break label494;
          }
          localObject2 = ((c.b)localObject2).yrC;
          label284:
          ((axu)localObject5).SKd = ((String)localObject2);
          localObject4 = new p.b(localaxe);
          ((p.b)localObject4).c(localc);
          ((p.b)localObject4).a((axu)localObject5);
          ((p.b)localObject4).yru = ((String)localObject1);
          ((p.b)localObject4).yrv = 0;
          ((p.b)localObject4).yQD = this.count;
          localObject2 = c.yRV;
          ((p.b)localObject4).yQE = kotlin.a.e.contains(c.dEQ(), this.yRX);
          ((p.b)localObject4).yrt = this.yrt;
          localObject2 = c.yRV;
          localObject5 = (c.b)c.dER().get(this.yRX);
          localObject2 = localObject3;
          if (localObject5 != null) {
            localObject2 = ((c.b)localObject5).yrC;
          }
          ((p.b)localObject4).yrC = ((String)localObject2);
          ((p.b)localObject4).aCo(this.xcW);
          if ((Util.isNullOrNil((String)localObject1)) || ((((p.b)localObject4).yrv <= 1) && (((p.b)localObject4).yQD <= 1))) {
            break label499;
          }
          i = 1;
          label439:
          if (!this.yrt) {
            break label529;
          }
          if (!((p.b)localObject4).yQE) {
            break label511;
          }
          if (i == 0) {
            break label504;
          }
          localObject1 = p.c.yQG;
        }
      }
      label529:
      for (;;)
      {
        ((p.b)localObject4).c((p.c)localObject1);
        AppMethodBeat.o(281836);
        return localObject4;
        localObject1 = null;
        break;
        localObject1 = this.yRY;
        break label87;
        label489:
        localObject2 = null;
        break label242;
        label494:
        localObject2 = null;
        break label284;
        label499:
        i = 0;
        break label439;
        label504:
        localObject1 = p.c.yQH;
        continue;
        label511:
        if (i != 0)
        {
          localObject1 = p.c.yQI;
        }
        else
        {
          localObject1 = p.c.yQJ;
          continue;
          if (((p.b)localObject4).yQE)
          {
            if (i != 0) {
              localObject1 = p.c.yQK;
            } else {
              localObject1 = p.c.yQL;
            }
          }
          else if (i != 0) {
            localObject1 = p.c.yQM;
          } else {
            localObject1 = p.c.yQN;
          }
        }
      }
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(281837);
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder("giftName = ");
      Object localObject1 = m.yfw;
      Object localObject3 = m.dyu();
      localObject1 = c.yRV;
      localObject1 = (c.b)c.dER().get(this.yRX);
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).yrC;
        localObject1 = (com.tencent.c.a.a.a.d.a.b)((Map)localObject3).get(localObject1);
        if (localObject1 == null) {
          break label395;
        }
      }
      label395:
      for (localObject1 = ((com.tencent.c.a.a.a.d.a.b)localObject1).field_name;; localObject1 = null)
      {
        localStringBuilder1 = localStringBuilder1.append((String)localObject1).append(", ").append("comboId = " + this.yRY).append(", ").append("count = " + this.count).append(", ").append("executeInMainThread = " + this.yRZ).append(", ").append("nickname = " + this.nickname + " ,").append("isSelfSend = " + this.yrt + " ,");
        localStringBuilder2 = new StringBuilder("giftLocalName = ");
        localObject1 = c.yRV;
        localObject3 = (c.b)c.dER().get(this.yRX);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((c.b)localObject3).name;
        }
        localObject1 = localStringBuilder2.append((String)localObject1).append(", ").toString() + new StringBuilder("executeDelayMs = ").append(this.ySa).toString() + ", " + new StringBuilder("targetUserName = ").append(this.xcW).toString() + "\n";
        p.j(localObject1, "StringBuilder()\n        …              .toString()");
        AppMethodBeat.o(281837);
        return localObject1;
        localObject1 = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(c.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.c
 * JD-Core Version:    0.7.0.1
 */