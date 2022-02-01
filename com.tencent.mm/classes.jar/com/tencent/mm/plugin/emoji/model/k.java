package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.ui.v3.a.aa;
import com.tencent.mm.plugin.emoji.ui.v3.a.ac;
import com.tencent.mm.plugin.emoji.ui.v3.a.h;
import com.tencent.mm.plugin.emoji.ui.v3.a.q;
import com.tencent.mm.plugin.emoji.ui.v3.a.r;
import com.tencent.mm.plugin.emoji.ui.v3.a.t;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/model/EmojiStoreTypeRecModel;", "Lcom/tencent/mm/plugin/emoji/model/IEmojiStoreTypeRecModel;", "response", "Lcom/tencent/mm/protocal/protobuf/GetStoreRecListResponse;", "(Lcom/tencent/mm/protocal/protobuf/GetStoreRecListResponse;)V", "()V", "TAG", "", "googleMarketInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/storage/EmojiDownLoadInfo;", "originRecTypeListCount", "", "recTypeList", "", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "addHeaderTextItem", "", "headerTitle", "list", "id", "index", "getGoogleMarketInfo", "productId", "getPureGoogleMarketInfo", "getRecTypeList", "", "updateGoogleMarketStatus", "", "status", "Companion", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements p
{
  public static final a xML;
  private static HashMap<String, bj> xMP;
  private static Boolean xMQ;
  private final String TAG;
  private int xMM;
  private List<t> xMN;
  private final HashMap<String, bj> xMO;
  
  static
  {
    AppMethodBeat.i(269884);
    xML = new a((byte)0);
    xMP = new HashMap();
    AppMethodBeat.o(269884);
  }
  
  private k()
  {
    AppMethodBeat.i(269855);
    this.xMN = ((List)new ArrayList());
    this.xMO = new HashMap();
    this.TAG = "MicroMsg.EmojiStoreTypeRecModel";
    AppMethodBeat.o(269855);
  }
  
  public k(csy paramcsy)
  {
    this();
    AppMethodBeat.i(269863);
    if (paramcsy == null)
    {
      AppMethodBeat.o(269863);
      return;
    }
    this.xMM = paramcsy.aayO;
    this.xMN.clear();
    a.dzR();
    paramcsy = paramcsy.aayP;
    kotlin.g.b.s.s(paramcsy, "response.EmotionStoreRecList");
    paramcsy = ((Iterable)paramcsy).iterator();
    while (paramcsy.hasNext())
    {
      ano localano = (ano)paramcsy.next();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      label293:
      Object localObject4;
      label332:
      Object localObject5;
      switch (localano.vhJ)
      {
      default: 
        break;
      case 1: 
        if (localano.hjP != 1) {
          b(localano.Zva, this.xMN, localano.hjP);
        }
        localObject1 = new com.tencent.mm.plugin.emoji.ui.v3.a.a();
        ((com.tencent.mm.plugin.emoji.ui.v3.a.a)localObject1).ybA = ((List)new ArrayList());
        ((com.tencent.mm.plugin.emoji.ui.v3.a.a)localObject1).ybB = ((List)localano.Zvd);
        this.xMN.add(localObject1);
        break;
      case 2: 
        b(localano.Zva, this.xMN, localano.hjP);
        localObject1 = localano.Zvf;
        kotlin.g.b.s.s(localObject1, "listEntry.EmotionList");
        localObject1 = (Iterable)localObject1;
        int i = 0;
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject2 = (cjb)localObject2;
          localObject3 = new com.tencent.mm.plugin.emoji.ui.v3.a.s();
          boolean bool;
          if (i == 0)
          {
            bool = true;
            ((com.tencent.mm.plugin.emoji.ui.v3.a.s)localObject3).isFirst = bool;
            localObject4 = new f((cjb)localObject2);
            if (com.tencent.mm.plugin.emoji.g.c.i((cjb)localObject2))
            {
              if (!com.tencent.mm.plugin.emoji.g.c.dBJ()) {
                break label488;
              }
              ((f)localObject4).setStatus(7);
            }
            if (xMQ == null) {
              xMQ = Boolean.valueOf(h.dDc());
            }
            ((f)localObject4).a(kotlin.g.b.s.p(xMQ, Boolean.TRUE), anR(((cjb)localObject2).ProductID), a.anP(((cjb)localObject2).ProductID));
            localObject5 = s.dAq().xMS;
            if (localObject5 != null) {
              if (((Map)localObject5).isEmpty()) {
                break label497;
              }
            }
          }
          for (int j = 1;; j = 0)
          {
            if (j != 0)
            {
              j = s.dAq().aoI(((cjb)localObject2).ProductID);
              if (j >= 0)
              {
                ((f)localObject4).setStatus(6);
                ((f)localObject4).boE = j;
              }
              if ((j < 0) && (((f)localObject4).mStatus == 6)) {
                ((f)localObject4).setStatus(3);
              }
            }
            ((com.tencent.mm.plugin.emoji.ui.v3.a.s)localObject3).ycP = ((f)localObject4);
            this.xMN.add(localObject3);
            i += 1;
            break;
            bool = false;
            break label293;
            ((f)localObject4).setStatus(3);
            break label332;
          }
        }
        localObject1 = new q();
        ((q)localObject1).yaS = w.a(localano.Zvb);
        localObject2 = com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), h.h.emoji_store_find_more);
        kotlin.g.b.s.s(localObject2, "getString(MMApplicationC…ng.emoji_store_find_more)");
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((q)localObject1).text = ((String)localObject2);
        localObject2 = localano.Zva;
        kotlin.g.b.s.s(localObject2, "listEntry.ListName");
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((q)localObject1).xUk = ((String)localObject2);
        ((q)localObject1).id = localano.hjP;
        this.xMN.add(localObject1);
        break;
      case 3: 
        label488:
        label497:
        localObject1 = localano.Zvh;
        kotlin.g.b.s.s(localObject1, "listEntry.EmojiRecommendList");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (amp)((Iterator)localObject1).next();
          localObject3 = new aa();
          ((aa)localObject3).id = localano.hjP;
          localObject4 = ((amp)localObject2).ZtD;
          kotlin.g.b.s.s(localObject4, "recommandInfo.Emojis");
          localObject5 = (Iterable)localObject4;
          localObject4 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            amn localamn = (amn)((Iterator)localObject5).next();
            ac localac = new ac();
            localac.ycT = localamn;
            localac.id = localano.hjP;
            ((Collection)localObject4).add(localac);
          }
          localObject4 = (List)localObject4;
          kotlin.g.b.s.u(localObject4, "<set-?>");
          ((aa)localObject3).bMf = ((List)localObject4);
          ((aa)localObject3).ycR = ((amp)localObject2).ZtB;
          this.xMN.add(localObject3);
        }
      }
    }
    AppMethodBeat.o(269863);
  }
  
  private bj anR(String paramString)
  {
    AppMethodBeat.i(269873);
    if (paramString == null)
    {
      AppMethodBeat.o(269873);
      return null;
    }
    paramString = (bj)this.xMO.get(paramString);
    AppMethodBeat.o(269873);
    return paramString;
  }
  
  private static boolean b(String paramString, List<t> paramList, int paramInt)
  {
    AppMethodBeat.i(269868);
    kotlin.g.b.s.u(paramList, "list");
    if ((paramString == null) || (kotlin.g.b.s.p(paramString, "")))
    {
      AppMethodBeat.o(269868);
      return false;
    }
    r localr = new r();
    kotlin.g.b.s.u(paramString, "<set-?>");
    localr.title = paramString;
    localr.id = paramInt;
    paramList.add(localr);
    AppMethodBeat.o(269868);
    return true;
  }
  
  public final bj anQ(String paramString)
  {
    AppMethodBeat.i(269892);
    bj localbj2 = anR(paramString);
    bj localbj1 = localbj2;
    if (localbj2 == null)
    {
      localbj1 = new bj(paramString);
      if (paramString != null) {
        ((Map)this.xMO).put(paramString, localbj1);
      }
    }
    AppMethodBeat.o(269892);
    return localbj1;
  }
  
  public final void dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(269895);
    paramString = (bj)((Map)this.xMO).get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(269895);
      return;
    }
    paramString.ayW(paramInt);
    AppMethodBeat.o(269895);
  }
  
  public final List<t> dzP()
  {
    AppMethodBeat.i(269888);
    List localList = kotlin.a.p.p((Iterable)this.xMN);
    AppMethodBeat.o(269888);
    return localList;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/model/EmojiStoreTypeRecModel$Companion;", "", "()V", "emojiDownloadedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storage/EmojiDownLoadInfo;", "enableGoogleMarket", "", "Ljava/lang/Boolean;", "isDownloaded", "productId", "isEnableGoogleMarket", "refreshDownloadMap", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean anP(String paramString)
    {
      AppMethodBeat.i(269847);
      Map localMap = (Map)k.dzQ();
      if (localMap == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        AppMethodBeat.o(269847);
        throw paramString;
      }
      boolean bool = localMap.containsKey(paramString);
      AppMethodBeat.o(269847);
      return bool;
    }
    
    public static void dzR()
    {
      AppMethodBeat.i(269849);
      HashMap localHashMap = s.getEmojiStorageMgr().adjv.jcZ();
      kotlin.g.b.s.s(localHashMap, "getEmojiStorageMgr().emo…oStorage.downloadGroupMap");
      k.m(localHashMap);
      AppMethodBeat.o(269849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.k
 * JD-Core Version:    0.7.0.1
 */