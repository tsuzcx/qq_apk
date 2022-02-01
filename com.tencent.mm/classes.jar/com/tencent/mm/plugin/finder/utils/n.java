package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.o;
import d.y;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "TAG", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "username", "feedObject", "parseDesc", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "Ljava/util/HashMap;", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "nickname", "transformToFinderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class n
{
  public static final n LaC;
  private static final String TAG = "Finder.FinderAtUtil";
  
  static
  {
    AppMethodBeat.i(199623);
    LaC = new n();
    TAG = "Finder.FinderAtUtil";
    AppMethodBeat.o(199623);
  }
  
  public static ax Km()
  {
    AppMethodBeat.i(199620);
    Object localObject = new StringBuilder("_finder_at_mmkv");
    k.g(g.afz(), "MMKernel.account()");
    localObject = ax.aFC(com.tencent.mm.kernel.a.getUin());
    k.g(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(199620);
    return localObject;
  }
  
  public static f a(ebc paramebc)
  {
    AppMethodBeat.i(199614);
    k.h(paramebc, "contact");
    f localf = new f();
    localf.field_username = paramebc.username;
    localf.field_nickname = paramebc.nickname;
    String str = paramebc.itN;
    k.g(str, "contact.avatarUrl");
    localf.YQ(str);
    localf.field_authInfo = paramebc.authInfo;
    AppMethodBeat.o(199614);
    return localf;
  }
  
  public static ebc a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(199619);
    k.h(paramLocalFinderAtContactParcel, "contactParcel");
    ebc localebc = new ebc();
    localebc.username = paramLocalFinderAtContactParcel.username;
    localebc.itN = paramLocalFinderAtContactParcel.itN;
    localebc.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.Lby;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localebc.authInfo = localFinderAuthInfo;
      localebc.Lbz = paramLocalFinderAtContactParcel.Lbz;
      AppMethodBeat.o(199619);
      return localebc;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localebc.authInfo = null;
        ad.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static o<ArrayList<ebc>, ArrayList<a>> a(String paramString, HashMap<String, ebc> paramHashMap, q<? super Integer, ? super Integer, ? super String, y> paramq)
  {
    AppMethodBeat.i(199612);
    k.h(paramString, "sendContent");
    k.h(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (bt.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(199612);
      return paramString;
    }
    if (paramHashMap.size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(199612);
      return paramString;
    }
    Object localObject1 = (List)new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      int j = d.n.n.a((CharSequence)paramString, '@', i, 4);
      if (j == -1) {
        break;
      }
      i = d.n.n.a((CharSequence)paramString, ' ', j, 4);
      if (i == -1) {
        break;
      }
      Object localObject2 = paramString.substring(j + 1, i);
      k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (((Map)paramHashMap).containsKey(localObject2))
      {
        ((List)localObject1).add(localObject2);
        if (paramq != null) {
          paramq.d(Integer.valueOf(j), Integer.valueOf(i), localObject2);
        }
        localArrayList2.add(new a(j, i, (String)localObject2));
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUj() != 1000)
      {
        j = localArrayList2.size();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (j >= com.tencent.mm.plugin.finder.storage.b.fUj()) {
          break;
        }
      }
      i += 1;
    }
    ad.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(199612);
      return paramString;
    }
    if (((List)localObject1).size() > 0)
    {
      i = 0;
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        paramq = (ebc)paramHashMap.get((String)paramString.next());
        if (paramq != null)
        {
          localObject1 = new ebc();
          ((ebc)localObject1).username = paramq.username;
          ((ebc)localObject1).itN = paramq.itN;
          ((ebc)localObject1).nickname = paramq.nickname;
          ((ebc)localObject1).authInfo = paramq.authInfo;
          ((ebc)localObject1).Lbz = paramq.Lbz;
          ((ebc)localObject1).type = paramq.type;
          ((ebc)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      ad.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(199612);
      return paramString;
    }
    ad.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(199612);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(199622);
    k.h(paramString, "username");
    k.h(paramFinderItem, "feedObject");
    if ((((j)g.ad(j.class)).showFinderEntry()) && (paramContext != null))
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramString);
      Object localObject2 = FinderReporterUIC.Ljl;
      if (paramFinderItem.field_id == 0L) {}
      for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
      {
        FinderReporterUIC.a.a(paramContext, (Intent)localObject1, l, 2, false, 64);
        localObject2 = a.qSb;
        a.enterFinderProfileUI(paramContext, (Intent)localObject1);
        localObject1 = FinderReporterUIC.Ljl;
        paramContext = FinderReporterUIC.a.lB(paramContext);
        if (paramContext == null) {
          break;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
        paramContext = paramContext.fXs();
        k.h(paramContext, "contextObj");
        k.h(paramFinderItem, "finderItem");
        k.h(paramString, "clickUsername");
        localObject1 = new hg();
        ((hg)localObject1).EL(com.tencent.mm.plugin.finder.report.b.qi(paramFinderItem.getId()));
        ((hg)localObject1).NC(((c)g.ab(c.class)).cbk());
        ((hg)localObject1).ND(paramFinderItem.getFeedObject().username);
        ((hg)localObject1).NE(u.aqO());
        ((hg)localObject1).NF(paramString);
        ((hg)localObject1).qd(paramContext.qqE);
        ((hg)localObject1).qJ(paramFinderItem.getFeedObject().orgRecommendType);
        ((hg)localObject1).uj(paramFinderItem.getFeedObject().likeCount);
        ((hg)localObject1).uk(paramFinderItem.getFeedObject().commentCount);
        ((hg)localObject1).aBj();
        com.tencent.mm.plugin.finder.report.b.a((com.tencent.mm.plugin.report.a)localObject1);
        AppMethodBeat.o(199622);
        return;
      }
      AppMethodBeat.o(199622);
      return;
    }
    AppMethodBeat.o(199622);
  }
  
  public static FinderContact b(ebc paramebc)
  {
    AppMethodBeat.i(199617);
    k.h(paramebc, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = paramebc.username;
    localFinderContact.headUrl = paramebc.itN;
    localFinderContact.nickname = paramebc.nickname;
    localFinderContact.authInfo = paramebc.authInfo;
    AppMethodBeat.o(199617);
    return localFinderContact;
  }
  
  public static LocalFinderAtContactParcel c(ebc paramebc)
  {
    AppMethodBeat.i(199618);
    k.h(paramebc, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = paramebc.username;
    localLocalFinderAtContactParcel.itN = paramebc.itN;
    localLocalFinderAtContactParcel.nickname = paramebc.nickname;
    Object localObject = paramebc.authInfo;
    if (localObject != null) {}
    for (localObject = ((FinderAuthInfo)localObject).toByteArray();; localObject = null)
    {
      localLocalFinderAtContactParcel.Lby = ((byte[])localObject);
      localLocalFinderAtContactParcel.Lbz = paramebc.Lbz;
      AppMethodBeat.o(199618);
      return localLocalFinderAtContactParcel;
    }
  }
  
  public static ebc d(f paramf)
  {
    AppMethodBeat.i(199615);
    k.h(paramf, "contact");
    ebc localebc = new ebc();
    localebc.username = paramf.getUsername();
    localebc.nickname = paramf.Su();
    localebc.itN = paramf.cks();
    localebc.authInfo = paramf.field_authInfo;
    AppMethodBeat.o(199615);
    return localebc;
  }
  
  public static ebc d(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(199616);
    k.h(paramFinderContact, "contact");
    ebc localebc = new ebc();
    localebc.username = paramFinderContact.username;
    localebc.nickname = paramFinderContact.nickname;
    localebc.itN = paramFinderContact.headUrl;
    localebc.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(199616);
    return localebc;
  }
  
  public static LinkedList<ebc> fVO()
  {
    AppMethodBeat.i(199613);
    Object localObject1 = Km().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199613);
      return null;
    }
    Object localObject2 = new ebd();
    try
    {
      ((ebd)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((ebd)localObject2).DmI;
      AppMethodBeat.o(199613);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.KYJ;
      ad.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(199613);
    }
    return null;
  }
  
  public static String o(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(199621);
    k.h(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.LzN;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      ebc localebc = (ebc)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localebc.index);
      localJSONObject2.put("type", localebc.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    k.g(paramFinderItem, "report.toString()");
    AppMethodBeat.o(199621);
    return paramFinderItem;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    private final String LaD;
    final FinderContact LaE;
    public final int end;
    public final int start;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(199605);
      this.start = paramInt1;
      this.end = paramInt2;
      this.LaD = paramString;
      this.LaE = paramFinderContact;
      AppMethodBeat.o(199605);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199609);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!k.g(this.LaD, paramObject.LaD)) || (!k.g(this.LaE, paramObject.LaE))) {}
        }
      }
      else
      {
        AppMethodBeat.o(199609);
        return true;
      }
      AppMethodBeat.o(199609);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(199608);
      int k = this.start;
      int m = this.end;
      Object localObject = this.LaD;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.LaE;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(199608);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199607);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.LaD + ", finderContact=" + this.LaE + ")";
      AppMethodBeat.o(199607);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  public static final class b<T>
    implements Comparator<ebc>
  {
    public static final b LaF;
    
    static
    {
      AppMethodBeat.i(199611);
      LaF = new b();
      AppMethodBeat.o(199611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n
 * JD-Core Version:    0.7.0.1
 */