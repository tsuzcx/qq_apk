package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.i;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "SIGNATURE_AT_SOME_ONE_SUFFIX_CHAR", "TAG", "nicknameToContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Lkotlin/collections/HashMap;", "getNicknameToContactMap", "()Ljava/util/HashMap;", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "findEndIndex", "content", "startIndex", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "nickname", "feedObject", "jumpAtProfileUIOfSignature", "fromProfileUsername", "jumpContinue", "username", "it", "jumpContinueOfSignature", "parseDesc", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "parseDescOfSignature", "transformToFinderContact", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class d
{
  public static final String TAG = "Finder.FinderAtUtil";
  private static ArrayList<kotlin.n.k> vVe;
  public static final HashMap<String, FinderContact> vVf;
  public static final d vVg;
  
  static
  {
    AppMethodBeat.i(253383);
    vVg = new d();
    TAG = "Finder.FinderAtUtil";
    ArrayList localArrayList = new ArrayList();
    Object localObject = c.vCb;
    localObject = ((Iterable)c.dvu()).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new kotlin.n.k((String)((Iterator)localObject).next()));
    }
    vVe = localArrayList;
    vVf = new HashMap();
    AppMethodBeat.o(253383);
  }
  
  public static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(253378);
    Object localObject = new StringBuilder("_finder_at_mmkv");
    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    localObject = MultiProcessMMKV.getMMKV(com.tencent.mm.kernel.a.getUin());
    p.g(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(253378);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.finder.api.g a(cjj paramcjj)
  {
    AppMethodBeat.i(253372);
    p.h(paramcjj, "contact");
    com.tencent.mm.plugin.finder.api.g localg = new com.tencent.mm.plugin.finder.api.g();
    localg.field_username = paramcjj.username;
    localg.field_nickname = paramcjj.nickname;
    String str2 = paramcjj.kog;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localg.asL(str1);
    localg.field_authInfo = paramcjj.authInfo;
    AppMethodBeat.o(253372);
    return localg;
  }
  
  public static cjj a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(253377);
    p.h(paramLocalFinderAtContactParcel, "contactParcel");
    cjj localcjj = new cjj();
    localcjj.username = paramLocalFinderAtContactParcel.username;
    localcjj.kog = paramLocalFinderAtContactParcel.kog;
    localcjj.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.wak;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localcjj.authInfo = localFinderAuthInfo;
      localcjj.wal = paramLocalFinderAtContactParcel.wal;
      AppMethodBeat.o(253377);
      return localcjj;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localcjj.authInfo = null;
        Log.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static o<ArrayList<cjj>, ArrayList<a>> a(String paramString, HashMap<String, cjj> paramHashMap, q<? super Integer, ? super Integer, ? super String, x> paramq)
  {
    AppMethodBeat.i(253368);
    p.h(paramString, "sendContent");
    p.h(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(253368);
      return paramString;
    }
    Object localObject1 = (List)new LinkedList();
    int j = 0;
    int k;
    int i;
    do
    {
      do
      {
        if (j >= paramString.length()) {
          break;
        }
        k = n.a((CharSequence)paramString, '@', j, false, 4);
        if ((k == -1) || (k >= paramString.length() - 1)) {
          break;
        }
        j = dL(paramString, k + 1);
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
        if (i - k > 1)
        {
          localObject2 = paramString.substring(k + 1, i);
          p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((List)localObject1).add(localObject2);
          if (paramq != null) {
            paramq.d(Integer.valueOf(k), Integer.valueOf(i), localObject2);
          }
          localArrayList2.add(new a(k, i, (String)localObject2));
        }
        localObject2 = c.vCb;
        j = i;
      } while (((Number)c.dsT().value()).intValue() == 1000);
      k = localArrayList2.size();
      Object localObject2 = c.vCb;
      j = i;
    } while (k < ((Number)c.dsT().value()).intValue());
    Log.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(253368);
      return paramString;
    }
    if (((List)localObject1).size() > 0)
    {
      i = 0;
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        paramq = (String)paramString.next();
        if (paramHashMap.containsKey(paramq))
        {
          paramq = (cjj)paramHashMap.get(paramq);
          if (paramq != null)
          {
            localObject1 = new cjj();
            ((cjj)localObject1).username = paramq.username;
            ((cjj)localObject1).kog = paramq.kog;
            ((cjj)localObject1).nickname = paramq.nickname;
            ((cjj)localObject1).authInfo = paramq.authInfo;
            ((cjj)localObject1).wal = paramq.wal;
            ((cjj)localObject1).type = paramq.type;
            ((cjj)localObject1).index = i;
            localArrayList1.add(localObject1);
            i += 1;
          }
        }
        else
        {
          localObject1 = new cjj();
          ((cjj)localObject1).username = "";
          ((cjj)localObject1).kog = "";
          ((cjj)localObject1).nickname = paramq;
          ((cjj)localObject1).authInfo = null;
          ((cjj)localObject1).wal = cl.aWy();
          ((cjj)localObject1).type = 5;
          ((cjj)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      Log.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(253368);
      return paramString;
    }
    Log.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(253368);
    return paramString;
  }
  
  public static o<ArrayList<cjj>, ArrayList<a>> a(String paramString, q<? super Integer, ? super Integer, ? super String, x> paramq)
  {
    AppMethodBeat.i(253369);
    p.h(paramString, "sendContent");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(253369);
      return paramString;
    }
    Object localObject = (List)new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      int k = n.a((CharSequence)paramString, '@', i, false, 4);
      if ((k == -1) || (k >= paramString.length() - 1)) {
        break;
      }
      int j = dL(paramString, k + 1);
      i = j;
      if (j == -1) {
        i = paramString.length();
      }
      if (i - k > 1)
      {
        String str = paramString.substring(k + 1, i);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((List)localObject).add(str);
        paramq.d(Integer.valueOf(k), Integer.valueOf(i), str);
        localArrayList2.add(new a(k, i, str));
      }
    }
    Log.i(TAG, "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(253369);
      return paramString;
    }
    if (((List)localObject).size() > 0)
    {
      paramString = ((List)localObject).iterator();
      i = 0;
      while (paramString.hasNext())
      {
        paramq = (String)paramString.next();
        localObject = new cjj();
        ((cjj)localObject).username = "";
        ((cjj)localObject).kog = "";
        ((cjj)localObject).nickname = paramq;
        ((cjj)localObject).authInfo = null;
        ((cjj)localObject).wal = cl.aWy();
        ((cjj)localObject).type = 5;
        ((cjj)localObject).index = i;
        localArrayList1.add(localObject);
        i += 1;
      }
      Log.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(253369);
      return paramString;
    }
    Log.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(253369);
    return paramString;
  }
  
  public static void a(final Context paramContext, String paramString, final FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253380);
    p.h(paramString, "nickname");
    p.h(paramFinderItem, "feedObject");
    if (paramContext != null)
    {
      if (vVf.containsKey(paramString))
      {
        paramString = (FinderContact)vVf.get(paramString);
        if (paramString != null) {}
        for (paramString = paramString.username; (!Util.isNullOrNil(paramString)) && (paramString != null); paramString = null)
        {
          a(paramString, paramContext, paramFinderItem, paramContext);
          AppMethodBeat.o(253380);
          return;
        }
        Log.i(TAG, "username nil");
        u.makeText(paramContext, 2131759543, 0).show();
        AppMethodBeat.o(253380);
        return;
      }
      new com.tencent.mm.plugin.i.a.j(kotlin.a.j.listOf(paramString)).aYI().g((com.tencent.mm.vending.c.a)new c(paramString, paramContext, paramFinderItem));
    }
    AppMethodBeat.o(253380);
  }
  
  private static void a(String paramString, Context paramContext1, FinderItem paramFinderItem, Context paramContext2)
  {
    AppMethodBeat.i(253381);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramString);
    Object localObject2 = FinderReporterUIC.wzC;
    if (paramFinderItem.field_id == 0L) {}
    for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
    {
      FinderReporterUIC.a.a(paramContext1, (Intent)localObject1, l, 2, false, 64);
      localObject2 = a.vUU;
      a.enterFinderProfileUI(paramContext1, (Intent)localObject1);
      localObject1 = FinderReporterUIC.wzC;
      paramContext1 = FinderReporterUIC.a.fH(paramContext1);
      if (paramContext1 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(paramContext1.dIx(), paramFinderItem, paramString);
      }
      paramString = FinderReporterUIC.wzC;
      paramString = FinderReporterUIC.a.fH(paramContext2);
      if (paramString == null) {
        break;
      }
      paramString = FinderReporterUIC.b(paramString);
      if (paramString == null) {
        break;
      }
      paramString.cZR().EA(paramFinderItem.getId());
      AppMethodBeat.o(253381);
      return;
    }
    AppMethodBeat.o(253381);
  }
  
  public static FinderContact b(cjj paramcjj)
  {
    AppMethodBeat.i(253375);
    p.h(paramcjj, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = paramcjj.username;
    localFinderContact.headUrl = paramcjj.kog;
    localFinderContact.nickname = paramcjj.nickname;
    localFinderContact.authInfo = paramcjj.authInfo;
    AppMethodBeat.o(253375);
    return localFinderContact;
  }
  
  public static LocalFinderAtContactParcel c(cjj paramcjj)
  {
    AppMethodBeat.i(253376);
    p.h(paramcjj, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = paramcjj.username;
    localLocalFinderAtContactParcel.kog = paramcjj.kog;
    localLocalFinderAtContactParcel.nickname = paramcjj.nickname;
    Object localObject = paramcjj.authInfo;
    if (localObject != null) {}
    for (localObject = ((FinderAuthInfo)localObject).toByteArray();; localObject = null)
    {
      localLocalFinderAtContactParcel.wak = ((byte[])localObject);
      localLocalFinderAtContactParcel.wal = paramcjj.wal;
      AppMethodBeat.o(253376);
      return localLocalFinderAtContactParcel;
    }
  }
  
  public static LinkedList<cjj> dBy()
  {
    AppMethodBeat.i(253371);
    Object localObject1 = VQ().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(253371);
      return null;
    }
    Object localObject2 = new cjn();
    try
    {
      ((cjn)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((cjn)localObject2).LDz;
      AppMethodBeat.o(253371);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.vME;
      Log.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(253371);
    }
    return null;
  }
  
  public static HashMap<String, FinderContact> dBz()
  {
    return vVf;
  }
  
  private static int dL(String paramString, int paramInt)
  {
    AppMethodBeat.i(253370);
    p.h(paramString, "content");
    Iterator localIterator = ((Iterable)vVe).iterator();
    int i = -1;
    if (localIterator.hasNext())
    {
      i locali = ((kotlin.n.k)localIterator.next()).p((CharSequence)paramString, paramInt);
      if ((locali == null) || ((i >= 0) && (locali.hMg().SYU >= i))) {
        break label100;
      }
      i = locali.hMg().SYU;
    }
    label100:
    for (;;)
    {
      break;
      AppMethodBeat.o(253370);
      return i;
    }
  }
  
  public static cjj e(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(253374);
    p.h(paramFinderContact, "contact");
    cjj localcjj = new cjj();
    localcjj.username = paramFinderContact.username;
    localcjj.nickname = paramFinderContact.nickname;
    localcjj.kog = paramFinderContact.headUrl;
    localcjj.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(253374);
    return localcjj;
  }
  
  public static void e(String paramString, Context paramContext)
  {
    AppMethodBeat.i(253382);
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    paramString = FinderReporterUIC.wzC;
    FinderReporterUIC.a.a(paramContext, localIntent, 0L, 2, false, 64);
    paramString = a.vUU;
    a.enterFinderProfileUI(paramContext, localIntent);
    AppMethodBeat.o(253382);
  }
  
  public static cjj h(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(253373);
    p.h(paramg, "contact");
    cjj localcjj = new cjj();
    localcjj.username = paramg.getUsername();
    localcjj.nickname = paramg.getNickname();
    localcjj.kog = paramg.cXH();
    localcjj.authInfo = paramg.field_authInfo;
    AppMethodBeat.o(253373);
    return localcjj;
  }
  
  public static String w(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253379);
    p.h(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.Mpg;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      cjj localcjj = (cjj)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localcjj.index);
      localJSONObject2.put("type", localcjj.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    p.g(paramFinderItem, "report.toString()");
    AppMethodBeat.o(253379);
    return paramFinderItem;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    final int end;
    final int start;
    final String vVh;
    private final FinderContact vVi;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(253359);
      this.start = paramInt1;
      this.end = paramInt2;
      this.vVh = paramString;
      this.vVi = paramFinderContact;
      AppMethodBeat.o(253359);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(253363);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!p.j(this.vVh, paramObject.vVh)) || (!p.j(this.vVi, paramObject.vVi))) {}
        }
      }
      else
      {
        AppMethodBeat.o(253363);
        return true;
      }
      AppMethodBeat.o(253363);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(253362);
      int k = this.start;
      int m = this.end;
      Object localObject = this.vVh;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.vVi;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(253362);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(253361);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.vVh + ", finderContact=" + this.vVi + ")";
      AppMethodBeat.o(253361);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  public static final class b<T>
    implements Comparator<cjj>
  {
    public static final b vVj;
    
    static
    {
      AppMethodBeat.i(253365);
      vVj = new b();
      AppMethodBeat.o(253365);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(String paramString, Context paramContext, FinderItem paramFinderItem) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public d(String paramString1, Context paramContext, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.d
 * JD-Core Version:    0.7.0.1
 */