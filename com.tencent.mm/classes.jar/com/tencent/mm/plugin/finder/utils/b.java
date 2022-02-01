package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aj;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "TAG", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "username", "feedObject", "parseDesc", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "Ljava/util/HashMap;", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "nickname", "transformToFinderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.FinderAtUtil";
  public static final b sWa;
  
  static
  {
    AppMethodBeat.i(205081);
    sWa = new b();
    TAG = "Finder.FinderAtUtil";
    AppMethodBeat.o(205081);
  }
  
  public static ay LD()
  {
    AppMethodBeat.i(205078);
    Object localObject = new StringBuilder("_finder_at_mmkv");
    p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    localObject = ay.aRW(com.tencent.mm.kernel.a.getUin());
    p.g(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(205078);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.finder.api.g a(bvx parambvx)
  {
    AppMethodBeat.i(205072);
    p.h(parambvx, "contact");
    com.tencent.mm.plugin.finder.api.g localg = new com.tencent.mm.plugin.finder.api.g();
    localg.field_username = parambvx.username;
    localg.field_nickname = parambvx.nickname;
    String str2 = parambvx.jpU;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.ahY(str1);
    localg.field_authInfo = parambvx.authInfo;
    AppMethodBeat.o(205072);
    return localg;
  }
  
  public static bvx a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(205077);
    p.h(paramLocalFinderAtContactParcel, "contactParcel");
    bvx localbvx = new bvx();
    localbvx.username = paramLocalFinderAtContactParcel.username;
    localbvx.jpU = paramLocalFinderAtContactParcel.jpU;
    localbvx.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.sXZ;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localbvx.authInfo = localFinderAuthInfo;
      localbvx.sYa = paramLocalFinderAtContactParcel.sYa;
      AppMethodBeat.o(205077);
      return localbvx;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localbvx.authInfo = null;
        ae.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static o<ArrayList<bvx>, ArrayList<a>> a(String paramString, HashMap<String, bvx> paramHashMap, q<? super Integer, ? super Integer, ? super String, z> paramq)
  {
    AppMethodBeat.i(205070);
    p.h(paramString, "sendContent");
    p.h(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (bu.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(205070);
      return paramString;
    }
    if (paramHashMap.size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(205070);
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
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJe().value()).intValue() != 1000)
      {
        j = localArrayList2.size();
        localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (j >= ((Number)com.tencent.mm.plugin.finder.storage.b.cJe().value()).intValue()) {
          break;
        }
      }
      i += 1;
    }
    ae.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(205070);
      return paramString;
    }
    if (((List)localObject1).size() > 0)
    {
      i = 0;
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        paramq = (bvx)paramHashMap.get((String)paramString.next());
        if (paramq != null)
        {
          localObject1 = new bvx();
          ((bvx)localObject1).username = paramq.username;
          ((bvx)localObject1).jpU = paramq.jpU;
          ((bvx)localObject1).nickname = paramq.nickname;
          ((bvx)localObject1).authInfo = paramq.authInfo;
          ((bvx)localObject1).sYa = paramq.sYa;
          ((bvx)localObject1).type = paramq.type;
          ((bvx)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      ae.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(205070);
      return paramString;
    }
    ae.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(205070);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205080);
    p.h(paramString, "username");
    p.h(paramFinderItem, "feedObject");
    if (paramContext != null)
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", paramString);
      Object localObject2 = FinderReporterUIC.tnG;
      if (paramFinderItem.field_id == 0L) {}
      for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
      {
        FinderReporterUIC.a.a(paramContext, (Intent)localObject1, l, 2, false, 64);
        localObject2 = a.sVQ;
        a.enterFinderProfileUI(paramContext, (Intent)localObject1);
        localObject1 = FinderReporterUIC.tnG;
        localObject1 = FinderReporterUIC.a.fc(paramContext);
        if (localObject1 != null)
        {
          localObject2 = i.syT;
          localObject1 = ((FinderReporterUIC)localObject1).cQZ();
          p.h(localObject1, "contextObj");
          p.h(paramFinderItem, "finderItem");
          p.h(paramString, "clickUsername");
          localObject2 = new aj();
          ((aj)localObject2).ht(i.wL(paramFinderItem.getId()));
          ((aj)localObject2).hu(((c)com.tencent.mm.kernel.g.ab(c.class)).cos());
          ((aj)localObject2).hv(paramFinderItem.getFeedObject().username);
          ((aj)localObject2).hw(v.aAK());
          ((aj)localObject2).hx(paramString);
          ((aj)localObject2).cJ(((arn)localObject1).sch);
          ((aj)localObject2).cK(paramFinderItem.getFeedObject().orgRecommendType);
          ((aj)localObject2).cL(paramFinderItem.getFeedObject().likeCount);
          ((aj)localObject2).cM(paramFinderItem.getFeedObject().commentCount);
          ((aj)localObject2).aLH();
          i.a((com.tencent.mm.plugin.report.a)localObject2);
        }
        paramString = FinderReporterUIC.tnG;
        paramContext = FinderReporterUIC.a.fc(paramContext);
        if (paramContext == null) {
          break;
        }
        paramContext = FinderReporterUIC.b(paramContext);
        if (paramContext == null) {
          break;
        }
        paramContext.cAI().wu(paramFinderItem.getId());
        AppMethodBeat.o(205080);
        return;
      }
      AppMethodBeat.o(205080);
      return;
    }
    AppMethodBeat.o(205080);
  }
  
  public static FinderContact b(bvx parambvx)
  {
    AppMethodBeat.i(205075);
    p.h(parambvx, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = parambvx.username;
    localFinderContact.headUrl = parambvx.jpU;
    localFinderContact.nickname = parambvx.nickname;
    localFinderContact.authInfo = parambvx.authInfo;
    AppMethodBeat.o(205075);
    return localFinderContact;
  }
  
  public static LocalFinderAtContactParcel c(bvx parambvx)
  {
    AppMethodBeat.i(205076);
    p.h(parambvx, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = parambvx.username;
    localLocalFinderAtContactParcel.jpU = parambvx.jpU;
    localLocalFinderAtContactParcel.nickname = parambvx.nickname;
    Object localObject = parambvx.authInfo;
    if (localObject != null) {}
    for (localObject = ((FinderAuthInfo)localObject).toByteArray();; localObject = null)
    {
      localLocalFinderAtContactParcel.sXZ = ((byte[])localObject);
      localLocalFinderAtContactParcel.sYa = parambvx.sYa;
      AppMethodBeat.o(205076);
      return localLocalFinderAtContactParcel;
    }
  }
  
  public static LinkedList<bvx> cND()
  {
    AppMethodBeat.i(205071);
    Object localObject1 = LD().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(205071);
      return null;
    }
    Object localObject2 = new bwb();
    try
    {
      ((bwb)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((bwb)localObject2).GGk;
      AppMethodBeat.o(205071);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.sPv;
      ae.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(205071);
    }
    return null;
  }
  
  public static bvx e(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(205074);
    p.h(paramFinderContact, "contact");
    bvx localbvx = new bvx();
    localbvx.username = paramFinderContact.username;
    localbvx.nickname = paramFinderContact.nickname;
    localbvx.jpU = paramFinderContact.headUrl;
    localbvx.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(205074);
    return localbvx;
  }
  
  public static bvx i(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(205073);
    p.h(paramg, "contact");
    bvx localbvx = new bvx();
    localbvx.username = paramg.getUsername();
    localbvx.nickname = paramg.VK();
    localbvx.jpU = paramg.czm();
    localbvx.authInfo = paramg.field_authInfo;
    AppMethodBeat.o(205073);
    return localbvx;
  }
  
  public static String n(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205079);
    p.h(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.Hjf;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      bvx localbvx = (bvx)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localbvx.index);
      localJSONObject2.put("type", localbvx.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    p.g(paramFinderItem, "report.toString()");
    AppMethodBeat.o(205079);
    return paramFinderItem;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    public final int end;
    private final String sWb;
    final FinderContact sWc;
    public final int start;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(205063);
      this.start = paramInt1;
      this.end = paramInt2;
      this.sWb = paramString;
      this.sWc = paramFinderContact;
      AppMethodBeat.o(205063);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205067);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!p.i(this.sWb, paramObject.sWb)) || (!p.i(this.sWc, paramObject.sWc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(205067);
        return true;
      }
      AppMethodBeat.o(205067);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(205066);
      int k = this.start;
      int m = this.end;
      Object localObject = this.sWb;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.sWc;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(205066);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205065);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.sWb + ", finderContact=" + this.sWc + ")";
      AppMethodBeat.o(205065);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  public static final class b<T>
    implements Comparator<bvx>
  {
    public static final b sWd;
    
    static
    {
      AppMethodBeat.i(205069);
      sWd = new b();
      AppMethodBeat.o(205069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.b
 * JD-Core Version:    0.7.0.1
 */