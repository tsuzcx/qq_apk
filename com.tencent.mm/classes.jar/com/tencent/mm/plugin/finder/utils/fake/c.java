package com.tencent.mm.plugin.finder.utils.fake;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.util.p.b;
import com.tencent.mm.plugin.finder.live.util.p.c;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil;", "", "()V", "GIFT_COMMAND", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "Lkotlin/collections/HashMap;", "getGIFT_COMMAND", "()Ljava/util/HashMap;", "GIFT_ID", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "getGIFT_ID", "IS_PRECIOUS", "", "getIS_PRECIOUS", "()[Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "[Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "TAG", "", "executeBatchMockCommand", "", "commandList", "", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "executeSingleMockCommand", "index", "", "command", "GiftInfo", "IGiftFactory", "MockCommand", "plugin-finder_release"})
public final class c
{
  private static final e[] waM;
  private static final HashMap<e, b> waN;
  private static final HashMap<e, c> waO;
  public static final c waP;
  
  static
  {
    AppMethodBeat.i(253846);
    waP = new c();
    waM = new e[] { e.wbd, e.wbe, e.wbf };
    Object localObject = new HashMap();
    ((Map)localObject).put(e.waZ, new b("MMFinderLiveGift100001", "test_爱心"));
    ((Map)localObject).put(e.wba, new b("MMFinderLiveGift100002", "test_鼓掌"));
    ((Map)localObject).put(e.wbb, new b("MMFinderLiveGift100003", "test_小花"));
    ((Map)localObject).put(e.wbc, new b("MMFinderLiveGift100004", "test_奶茶"));
    ((Map)localObject).put(e.wbd, new b("MMFinderLiveGift100005", "test_打call"));
    ((Map)localObject).put(e.wbe, new b("MMFinderLiveGift100006", "test_火箭"));
    ((Map)localObject).put(e.wbf, new b("MMFinderLiveGift100007", "test_桃花岛"));
    waN = (HashMap)localObject;
    waO = new HashMap();
    localObject = ((Map)waN).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      ((Map)waO).put(localEntry.getKey(), new a(localEntry));
    }
    AppMethodBeat.o(253846);
  }
  
  public static e[] dEI()
  {
    return waM;
  }
  
  public static HashMap<e, b> dEJ()
  {
    return waN;
  }
  
  public static HashMap<e, c> dEK()
  {
    return waO;
  }
  
  public static void eD(List<d> paramList)
  {
    AppMethodBeat.i(253845);
    p.h(paramList, "commandList");
    Log.i("Finder.FinderLiveGiftMockUtil", "executeBatchMockCommand: ".concat(String.valueOf(paramList)));
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      localObject = (d)localObject;
      if (((d)localObject).waT)
      {
        d.a(((d)localObject).waU, (a)new e((d)localObject));
        i = j;
      }
      else
      {
        String str = "FinderLiveGiftMockUtil" + i % 4;
        a locala = (a)new f((d)localObject);
        long l = ((d)localObject).waU;
        p.h(str, "tag");
        p.h(locala, "block");
        h.RTc.a((Runnable)new d.f(str, locala), l, str);
        i = j;
      }
    }
    AppMethodBeat.o(253845);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$1$1", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "create", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder_release"})
  public static final class a
    implements c.c
  {
    a(Map.Entry paramEntry) {}
    
    public final c.d Ma(int paramInt)
    {
      AppMethodBeat.i(253834);
      c.d locald = new c.d(paramInt);
      Object localObject = ((c.b)this.waQ.getValue()).name;
      p.h(localObject, "_nickName");
      locald.nickname = ((String)localObject);
      localObject = (e)this.waQ.getKey();
      p.h(localObject, "<set-?>");
      locald.waR = ((e)localObject);
      AppMethodBeat.o(253834);
      return locald;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "", "giftId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getGiftId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"})
  public static final class b
  {
    final String name;
    final String upZ;
    
    public b(String paramString1, String paramString2)
    {
      AppMethodBeat.i(253835);
      this.upZ = paramString1;
      this.name = paramString2;
      AppMethodBeat.o(253835);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(253838);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.upZ, paramObject.upZ)) || (!p.j(this.name, paramObject.name))) {}
        }
      }
      else
      {
        AppMethodBeat.o(253838);
        return true;
      }
      AppMethodBeat.o(253838);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(253837);
      String str = this.upZ;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.name;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(253837);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(253836);
      String str = "GiftInfo(giftId=" + this.upZ + ", name=" + this.name + ")";
      AppMethodBeat.o(253836);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$IGiftFactory;", "", "create", "Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "count", "", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract c.d Ma(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "", "count", "", "(I)V", "getCount", "()I", "setCount", "executeDelayMs", "", "executeInMainThread", "", "getExecuteInMainThread", "()Z", "setExecuteInMainThread", "(Z)V", "gift", "Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "getGift", "()Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;", "setGift", "(Lcom/tencent/mm/plugin/finder/utils/fake/GiftType;)V", "giftComboId", "", "isSelfSend", "nickname", "build", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "comboId", "_comboId", "delay", "_executeDelayMs", "getDelayTime", "name", "_nickName", "self", "toString", "plugin-finder_release"})
  public static final class d
  {
    private int count;
    String nickname;
    private boolean upQ;
    e waR;
    private String waS;
    boolean waT;
    long waU;
    
    public d(int paramInt)
    {
      this.count = paramInt;
      this.waR = e.waZ;
      this.waS = "";
    }
    
    public final d awF(String paramString)
    {
      AppMethodBeat.i(253840);
      p.h(paramString, "_comboId");
      this.waS = paramString;
      AppMethodBeat.o(253840);
      return this;
    }
    
    public final d dEL()
    {
      AppMethodBeat.i(253839);
      this.upQ = true;
      this.nickname = z.aUa();
      AppMethodBeat.o(253839);
      return this;
    }
    
    public final p.b dEM()
    {
      Object localObject3 = null;
      AppMethodBeat.i(253841);
      Object localObject5 = new auz();
      p.c localc = p.c.uxf;
      Object localObject2;
      Object localObject1;
      label87:
      Object localObject4;
      label226:
      int i;
      if (Util.isNullOrNil(this.waS))
      {
        localObject2 = new StringBuilder();
        localObject1 = c.waP;
        localObject1 = (c.b)c.dEJ().get(this.waR);
        if (localObject1 != null)
        {
          localObject1 = ((c.b)localObject1).name;
          localObject1 = (String)localObject1 + '_' + UUID.randomUUID();
          aut localaut = new aut();
          localaut.LFE = new avn();
          localObject2 = localaut.LFE;
          if (localObject2 != null) {
            ((avn)localObject2).contact = new FinderContact();
          }
          localObject2 = localaut.LFE;
          if (localObject2 != null)
          {
            FinderContact localFinderContact = ((avn)localObject2).contact;
            if (localFinderContact != null)
            {
              localObject4 = this.nickname;
              localObject2 = localObject4;
              if (localObject4 == null)
              {
                localObject2 = new StringBuilder("测试");
                localObject4 = kotlin.j.c.SYP;
                localObject2 = kotlin.j.c.hyi().nextInt();
              }
              localFinderContact.nickname = ((String)localObject2);
            }
          }
          localObject2 = c.waP;
          localObject2 = (c.b)c.dEJ().get(this.waR);
          if (localObject2 == null) {
            break label429;
          }
          localObject2 = ((c.b)localObject2).upZ;
          ((auz)localObject5).LFM = ((String)localObject2);
          localObject4 = new p.b(localaut);
          ((p.b)localObject4).c(localc);
          p.h(localObject5, "<set-?>");
          ((p.b)localObject4).uwU = ((auz)localObject5);
          ((p.b)localObject4).upR = ((String)localObject1);
          ((p.b)localObject4).upS = 0;
          ((p.b)localObject4).uwV = this.count;
          localObject2 = c.waP;
          ((p.b)localObject4).uwW = kotlin.a.e.contains(c.dEI(), this.waR);
          ((p.b)localObject4).upQ = this.upQ;
          localObject2 = c.waP;
          localObject5 = (c.b)c.dEJ().get(this.waR);
          localObject2 = localObject3;
          if (localObject5 != null) {
            localObject2 = ((c.b)localObject5).upZ;
          }
          ((p.b)localObject4).upZ = ((String)localObject2);
          if ((Util.isNullOrNil((String)localObject1)) || ((((p.b)localObject4).upS <= 1) && (((p.b)localObject4).uwV <= 1))) {
            break label434;
          }
          i = 1;
          label379:
          if (!this.upQ) {
            break label464;
          }
          if (!((p.b)localObject4).uwW) {
            break label446;
          }
          if (i == 0) {
            break label439;
          }
          localObject1 = p.c.uwY;
        }
      }
      for (;;)
      {
        ((p.b)localObject4).c((p.c)localObject1);
        AppMethodBeat.o(253841);
        return localObject4;
        localObject1 = null;
        break;
        localObject1 = this.waS;
        break label87;
        label429:
        localObject2 = null;
        break label226;
        label434:
        i = 0;
        break label379;
        label439:
        localObject1 = p.c.uwZ;
        continue;
        label446:
        if (i != 0)
        {
          localObject1 = p.c.uxa;
        }
        else
        {
          localObject1 = p.c.uxb;
          continue;
          label464:
          if (((p.b)localObject4).uwW)
          {
            if (i != 0) {
              localObject1 = p.c.uxc;
            } else {
              localObject1 = p.c.uxd;
            }
          }
          else if (i != 0) {
            localObject1 = p.c.uxe;
          } else {
            localObject1 = p.c.uxf;
          }
        }
      }
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(253842);
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder("giftName = ");
      Object localObject1 = com.tencent.mm.plugin.finder.live.model.e.uiD;
      Object localObject3 = com.tencent.mm.plugin.finder.live.model.e.dfw();
      localObject1 = c.waP;
      localObject1 = (c.b)c.dEJ().get(this.waR);
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).upZ;
        localObject1 = (s)((Map)localObject3).get(localObject1);
        if (localObject1 == null) {
          break label366;
        }
      }
      label366:
      for (localObject1 = ((s)localObject1).field_name;; localObject1 = null)
      {
        localStringBuilder1 = localStringBuilder1.append((String)localObject1).append(", ").append("comboId = " + this.waS).append(", ").append("count = " + this.count).append(", ").append("executeInMainThread = " + this.waT).append(", ").append("nickname = " + this.nickname + " ,").append("isSelfSend = " + this.upQ + " ,");
        localStringBuilder2 = new StringBuilder("giftLocalName = ");
        localObject1 = c.waP;
        localObject3 = (c.b)c.dEJ().get(this.waR);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((c.b)localObject3).name;
        }
        localObject1 = localStringBuilder2.append((String)localObject1).append(", ").toString() + new StringBuilder("executeDelayMs = ").append(this.waU).toString() + "\n";
        p.g(localObject1, "StringBuilder()\n        …              .toString()");
        AppMethodBeat.o(253842);
        return localObject1;
        localObject1 = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(c.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(c.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.fake.c
 * JD-Core Version:    0.7.0.1
 */