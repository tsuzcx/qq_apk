package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.n.n;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "TAG", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "username", "feedObject", "parseDesc", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "Ljava/util/HashMap;", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "nickname", "transformToFinderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.FinderAtUtil";
  public static final b rOw;
  
  static
  {
    AppMethodBeat.i(203599);
    rOw = new b();
    TAG = "Finder.FinderAtUtil";
    AppMethodBeat.o(203599);
  }
  
  public static aw JW()
  {
    AppMethodBeat.i(203596);
    Object localObject = new StringBuilder("_finder_at_mmkv");
    k.g(g.agP(), "MMKernel.account()");
    localObject = aw.aKT(com.tencent.mm.kernel.a.getUin());
    k.g(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(203596);
    return localObject;
  }
  
  public static f a(bqq parambqq)
  {
    AppMethodBeat.i(203590);
    k.h(parambqq, "contact");
    f localf = new f();
    localf.field_username = parambqq.username;
    localf.field_nickname = parambqq.nickname;
    String str = parambqq.iTS;
    k.g(str, "contact.avatarUrl");
    localf.adl(str);
    localf.field_authInfo = parambqq.authInfo;
    AppMethodBeat.o(203590);
    return localf;
  }
  
  public static bqq a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(203595);
    k.h(paramLocalFinderAtContactParcel, "contactParcel");
    bqq localbqq = new bqq();
    localbqq.username = paramLocalFinderAtContactParcel.username;
    localbqq.iTS = paramLocalFinderAtContactParcel.iTS;
    localbqq.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.rQi;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localbqq.authInfo = localFinderAuthInfo;
      localbqq.rQj = paramLocalFinderAtContactParcel.rQj;
      AppMethodBeat.o(203595);
      return localbqq;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localbqq.authInfo = null;
        ac.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static o<ArrayList<bqq>, ArrayList<a>> a(String paramString, HashMap<String, bqq> paramHashMap, q<? super Integer, ? super Integer, ? super String, y> paramq)
  {
    AppMethodBeat.i(203588);
    k.h(paramString, "sendContent");
    k.h(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (bs.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(203588);
      return paramString;
    }
    if (paramHashMap.size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(203588);
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
      k.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (((Map)paramHashMap).containsKey(localObject2))
      {
        ((List)localObject1).add(localObject2);
        if (paramq != null) {
          paramq.d(Integer.valueOf(j), Integer.valueOf(i), localObject2);
        }
        localArrayList2.add(new a(j, i, (String)localObject2));
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czr() != 1000)
      {
        j = localArrayList2.size();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (j >= com.tencent.mm.plugin.finder.storage.b.czr()) {
          break;
        }
      }
      i += 1;
    }
    ac.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(203588);
      return paramString;
    }
    if (((List)localObject1).size() > 0)
    {
      i = 0;
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        paramq = (bqq)paramHashMap.get((String)paramString.next());
        if (paramq != null)
        {
          localObject1 = new bqq();
          ((bqq)localObject1).username = paramq.username;
          ((bqq)localObject1).iTS = paramq.iTS;
          ((bqq)localObject1).nickname = paramq.nickname;
          ((bqq)localObject1).authInfo = paramq.authInfo;
          ((bqq)localObject1).rQj = paramq.rQj;
          ((bqq)localObject1).type = paramq.type;
          ((bqq)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      ac.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(203588);
      return paramString;
    }
    ac.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(203588);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203598);
    k.h(paramString, "username");
    k.h(paramFinderItem, "feedObject");
    if (paramContext != null)
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramString);
      Object localObject2 = FinderReporterUIC.seQ;
      if (paramFinderItem.field_id == 0L) {}
      for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
      {
        FinderReporterUIC.a.a(paramContext, (Intent)localObject1, l, 2, false, 64);
        localObject2 = a.rOv;
        a.enterFinderProfileUI(paramContext, (Intent)localObject1);
        localObject1 = FinderReporterUIC.seQ;
        paramContext = FinderReporterUIC.a.eV(paramContext);
        if (paramContext == null) {
          break;
        }
        localObject1 = d.rxr;
        paramContext = paramContext.cGb();
        k.h(paramContext, "contextObj");
        k.h(paramFinderItem, "finderItem");
        k.h(paramString, "clickUsername");
        localObject1 = new ab();
        ((ab)localObject1).gd(d.ut(paramFinderItem.getId()));
        ((ab)localObject1).ge(((c)g.ab(c.class)).cit());
        ((ab)localObject1).gf(paramFinderItem.getFeedObject().username);
        ((ab)localObject1).gg(u.axE());
        ((ab)localObject1).gh(paramString);
        ((ab)localObject1).cp(paramContext.rfR);
        ((ab)localObject1).cq(paramFinderItem.getFeedObject().orgRecommendType);
        ((ab)localObject1).cr(paramFinderItem.getFeedObject().likeCount);
        ((ab)localObject1).cs(paramFinderItem.getFeedObject().commentCount);
        ((ab)localObject1).aHZ();
        d.a((com.tencent.mm.plugin.report.a)localObject1);
        AppMethodBeat.o(203598);
        return;
      }
      AppMethodBeat.o(203598);
      return;
    }
    AppMethodBeat.o(203598);
  }
  
  public static FinderContact b(bqq parambqq)
  {
    AppMethodBeat.i(203593);
    k.h(parambqq, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = parambqq.username;
    localFinderContact.headUrl = parambqq.iTS;
    localFinderContact.nickname = parambqq.nickname;
    localFinderContact.authInfo = parambqq.authInfo;
    AppMethodBeat.o(203593);
    return localFinderContact;
  }
  
  public static LocalFinderAtContactParcel c(bqq parambqq)
  {
    AppMethodBeat.i(203594);
    k.h(parambqq, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = parambqq.username;
    localLocalFinderAtContactParcel.iTS = parambqq.iTS;
    localLocalFinderAtContactParcel.nickname = parambqq.nickname;
    Object localObject = parambqq.authInfo;
    if (localObject != null) {}
    for (localObject = ((FinderAuthInfo)localObject).toByteArray();; localObject = null)
    {
      localLocalFinderAtContactParcel.rQi = ((byte[])localObject);
      localLocalFinderAtContactParcel.rQj = parambqq.rQj;
      AppMethodBeat.o(203594);
      return localLocalFinderAtContactParcel;
    }
  }
  
  public static LinkedList<bqq> cCL()
  {
    AppMethodBeat.i(203589);
    Object localObject1 = JW().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203589);
      return null;
    }
    Object localObject2 = new bqu();
    try
    {
      ((bqu)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((bqu)localObject2).EEY;
      AppMethodBeat.o(203589);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.rJx;
      ac.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(203589);
    }
    return null;
  }
  
  public static bqq d(f paramf)
  {
    AppMethodBeat.i(203591);
    k.h(paramf, "contact");
    bqq localbqq = new bqq();
    localbqq.username = paramf.getUsername();
    localbqq.nickname = paramf.Tn();
    localbqq.iTS = paramf.crZ();
    localbqq.authInfo = paramf.field_authInfo;
    AppMethodBeat.o(203591);
    return localbqq;
  }
  
  public static bqq d(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(203592);
    k.h(paramFinderContact, "contact");
    bqq localbqq = new bqq();
    localbqq.username = paramFinderContact.username;
    localbqq.nickname = paramFinderContact.nickname;
    localbqq.iTS = paramFinderContact.headUrl;
    localbqq.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(203592);
    return localbqq;
  }
  
  public static String l(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203597);
    k.h(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.Fgb;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      bqq localbqq = (bqq)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localbqq.index);
      localJSONObject2.put("type", localbqq.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    k.g(paramFinderItem, "report.toString()");
    AppMethodBeat.o(203597);
    return paramFinderItem;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public final int end;
    private final String rOx;
    final FinderContact rOy;
    public final int start;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(203581);
      this.start = paramInt1;
      this.end = paramInt2;
      this.rOx = paramString;
      this.rOy = paramFinderContact;
      AppMethodBeat.o(203581);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203585);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!k.g(this.rOx, paramObject.rOx)) || (!k.g(this.rOy, paramObject.rOy))) {}
        }
      }
      else
      {
        AppMethodBeat.o(203585);
        return true;
      }
      AppMethodBeat.o(203585);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(203584);
      int k = this.start;
      int m = this.end;
      Object localObject = this.rOx;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.rOy;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(203584);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203583);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.rOx + ", finderContact=" + this.rOy + ")";
      AppMethodBeat.o(203583);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  public static final class b<T>
    implements Comparator<bqq>
  {
    public static final b rOz;
    
    static
    {
      AppMethodBeat.i(203587);
      rOz = new b();
      AppMethodBeat.o(203587);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.b
 * JD-Core Version:    0.7.0.1
 */