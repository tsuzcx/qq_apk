package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.q;
import d.g.b.p;
import d.l;
import d.n.n;
import d.o;
import d.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "TAG", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "username", "feedObject", "parseDesc", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "Ljava/util/HashMap;", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "nickname", "transformToFinderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.FinderAtUtil";
  public static final b sKO;
  
  static
  {
    AppMethodBeat.i(204463);
    sKO = new b();
    TAG = "Finder.FinderAtUtil";
    AppMethodBeat.o(204463);
  }
  
  public static ax Lv()
  {
    AppMethodBeat.i(204460);
    Object localObject = new StringBuilder("_finder_at_mmkv");
    p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
    localObject = ax.aQz(com.tencent.mm.kernel.a.getUin());
    p.g(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(204460);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.finder.api.g a(bvd parambvd)
  {
    AppMethodBeat.i(204454);
    p.h(parambvd, "contact");
    com.tencent.mm.plugin.finder.api.g localg = new com.tencent.mm.plugin.finder.api.g();
    localg.field_username = parambvd.username;
    localg.field_nickname = parambvd.nickname;
    String str = parambvd.jna;
    p.g(str, "contact.avatarUrl");
    localg.ahb(str);
    localg.field_authInfo = parambvd.authInfo;
    AppMethodBeat.o(204454);
    return localg;
  }
  
  public static bvd a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(204459);
    p.h(paramLocalFinderAtContactParcel, "contactParcel");
    bvd localbvd = new bvd();
    localbvd.username = paramLocalFinderAtContactParcel.username;
    localbvd.jna = paramLocalFinderAtContactParcel.jna;
    localbvd.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.sMO;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localbvd.authInfo = localFinderAuthInfo;
      localbvd.sMP = paramLocalFinderAtContactParcel.sMP;
      AppMethodBeat.o(204459);
      return localbvd;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localbvd.authInfo = null;
        ad.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static o<ArrayList<bvd>, ArrayList<a>> a(String paramString, HashMap<String, bvd> paramHashMap, q<? super Integer, ? super Integer, ? super String, z> paramq)
  {
    AppMethodBeat.i(204452);
    p.h(paramString, "sendContent");
    p.h(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (bt.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(204452);
      return paramString;
    }
    if (paramHashMap.size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(204452);
      return paramString;
    }
    Object localObject1 = (List)new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      int j = n.a((CharSequence)paramString, '@', i, 4);
      if (j == -1) {
        break;
      }
      i = n.a((CharSequence)paramString, ' ', j, 4);
      if (i == -1) {
        break;
      }
      Object localObject2 = paramString.substring(j + 1, i);
      p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (((Map)paramHashMap).containsKey(localObject2))
      {
        ((List)localObject1).add(localObject2);
        if (paramq != null) {
          paramq.d(Integer.valueOf(j), Integer.valueOf(i), localObject2);
        }
        localArrayList2.add(new a(j, i, (String)localObject2));
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHf().value()).intValue() != 1000)
      {
        j = localArrayList2.size();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (j >= ((Number)com.tencent.mm.plugin.finder.storage.b.cHf().value()).intValue()) {
          break;
        }
      }
      i += 1;
    }
    ad.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(204452);
      return paramString;
    }
    if (((List)localObject1).size() > 0)
    {
      i = 0;
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        paramq = (bvd)paramHashMap.get((String)paramString.next());
        if (paramq != null)
        {
          localObject1 = new bvd();
          ((bvd)localObject1).username = paramq.username;
          ((bvd)localObject1).jna = paramq.jna;
          ((bvd)localObject1).nickname = paramq.nickname;
          ((bvd)localObject1).authInfo = paramq.authInfo;
          ((bvd)localObject1).sMP = paramq.sMP;
          ((bvd)localObject1).type = paramq.type;
          ((bvd)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      ad.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(204452);
      return paramString;
    }
    ad.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(204452);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204462);
    p.h(paramString, "username");
    p.h(paramFinderItem, "feedObject");
    if (paramContext != null)
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramString);
      Object localObject2 = FinderReporterUIC.tcM;
      if (paramFinderItem.field_id == 0L) {}
      for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
      {
        FinderReporterUIC.a.a(paramContext, (Intent)localObject1, l, 2, false, 64);
        localObject2 = a.sKD;
        a.enterFinderProfileUI(paramContext, (Intent)localObject1);
        localObject1 = FinderReporterUIC.tcM;
        localObject1 = FinderReporterUIC.a.eY(paramContext);
        if (localObject1 != null)
        {
          localObject2 = h.soM;
          localObject1 = ((FinderReporterUIC)localObject1).cOu();
          p.h(localObject1, "contextObj");
          p.h(paramFinderItem, "finderItem");
          p.h(paramString, "clickUsername");
          localObject2 = new aj();
          ((aj)localObject2).hn(h.wu(paramFinderItem.getId()));
          ((aj)localObject2).ho(((c)com.tencent.mm.kernel.g.ab(c.class)).cnc());
          ((aj)localObject2).hp(paramFinderItem.getFeedObject().username);
          ((aj)localObject2).hq(u.aAu());
          ((aj)localObject2).hr(paramString);
          ((aj)localObject2).cJ(((aqy)localObject1).rTD);
          ((aj)localObject2).cK(paramFinderItem.getFeedObject().orgRecommendType);
          ((aj)localObject2).cL(paramFinderItem.getFeedObject().likeCount);
          ((aj)localObject2).cM(paramFinderItem.getFeedObject().commentCount);
          ((aj)localObject2).aLk();
          h.a((com.tencent.mm.plugin.report.a)localObject2);
        }
        paramString = FinderReporterUIC.tcM;
        paramContext = FinderReporterUIC.a.eY(paramContext);
        if (paramContext == null) {
          break;
        }
        paramContext = FinderReporterUIC.b(paramContext);
        if (paramContext == null) {
          break;
        }
        paramContext.cze().we(paramFinderItem.getId());
        AppMethodBeat.o(204462);
        return;
      }
      AppMethodBeat.o(204462);
      return;
    }
    AppMethodBeat.o(204462);
  }
  
  public static FinderContact b(bvd parambvd)
  {
    AppMethodBeat.i(204457);
    p.h(parambvd, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = parambvd.username;
    localFinderContact.headUrl = parambvd.jna;
    localFinderContact.nickname = parambvd.nickname;
    localFinderContact.authInfo = parambvd.authInfo;
    AppMethodBeat.o(204457);
    return localFinderContact;
  }
  
  public static LocalFinderAtContactParcel c(bvd parambvd)
  {
    AppMethodBeat.i(204458);
    p.h(parambvd, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = parambvd.username;
    localLocalFinderAtContactParcel.jna = parambvd.jna;
    localLocalFinderAtContactParcel.nickname = parambvd.nickname;
    Object localObject = parambvd.authInfo;
    if (localObject != null) {}
    for (localObject = ((FinderAuthInfo)localObject).toByteArray();; localObject = null)
    {
      localLocalFinderAtContactParcel.sMO = ((byte[])localObject);
      localLocalFinderAtContactParcel.sMP = parambvd.sMP;
      AppMethodBeat.o(204458);
      return localLocalFinderAtContactParcel;
    }
  }
  
  public static bvd c(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(204456);
    p.h(paramFinderContact, "contact");
    bvd localbvd = new bvd();
    localbvd.username = paramFinderContact.username;
    localbvd.nickname = paramFinderContact.nickname;
    localbvd.jna = paramFinderContact.headUrl;
    localbvd.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(204456);
    return localbvd;
  }
  
  public static LinkedList<bvd> cKZ()
  {
    AppMethodBeat.i(204453);
    Object localObject1 = Lv().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204453);
      return null;
    }
    Object localObject2 = new bvh();
    try
    {
      ((bvh)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((bvh)localObject2).Gne;
      AppMethodBeat.o(204453);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.sEw;
      ad.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(204453);
    }
    return null;
  }
  
  public static bvd i(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(204455);
    p.h(paramg, "contact");
    bvd localbvd = new bvd();
    localbvd.username = paramg.getUsername();
    localbvd.nickname = paramg.VC();
    localbvd.jna = paramg.cxL();
    localbvd.authInfo = paramg.field_authInfo;
    AppMethodBeat.o(204455);
    return localbvd;
  }
  
  public static String n(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204461);
    p.h(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.GPD;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      bvd localbvd = (bvd)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localbvd.index);
      localJSONObject2.put("type", localbvd.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    p.g(paramFinderItem, "report.toString()");
    AppMethodBeat.o(204461);
    return paramFinderItem;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public final int end;
    private final String sKP;
    final FinderContact sKQ;
    public final int start;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(204445);
      this.start = paramInt1;
      this.end = paramInt2;
      this.sKP = paramString;
      this.sKQ = paramFinderContact;
      AppMethodBeat.o(204445);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(204449);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!p.i(this.sKP, paramObject.sKP)) || (!p.i(this.sKQ, paramObject.sKQ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(204449);
        return true;
      }
      AppMethodBeat.o(204449);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(204448);
      int k = this.start;
      int m = this.end;
      Object localObject = this.sKP;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.sKQ;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(204448);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(204447);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.sKP + ", finderContact=" + this.sKQ + ")";
      AppMethodBeat.o(204447);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  public static final class b<T>
    implements Comparator<bvd>
  {
    public static final b sKR;
    
    static
    {
      AppMethodBeat.i(204451);
      sKR = new b();
      AppMethodBeat.o(204451);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.b
 * JD-Core Version:    0.7.0.1
 */