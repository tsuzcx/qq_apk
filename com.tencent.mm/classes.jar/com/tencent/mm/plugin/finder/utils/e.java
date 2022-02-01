package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.k.c;
import kotlin.l;
import kotlin.n.k;
import kotlin.o;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "SIGNATURE_AT_SOME_ONE_SUFFIX_CHAR", "TAG", "nicknameToContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Lkotlin/collections/HashMap;", "getNicknameToContactMap", "()Ljava/util/HashMap;", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "findEndIndex", "content", "startIndex", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "nickname", "feedObject", "jumpAtProfileUIOfSignature", "fromProfileUsername", "jumpContinue", "username", "it", "jumpContinueOfSignature", "parseDesc", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "parseDescOfSignature", "transformToFinderContact", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"})
public final class e
{
  private static ArrayList<k> ACT;
  public static final HashMap<String, FinderContact> ACU;
  public static final e ACV;
  public static final String TAG = "Finder.FinderAtUtil";
  
  static
  {
    AppMethodBeat.i(289858);
    ACV = new e();
    TAG = "Finder.FinderAtUtil";
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.AjH;
    localObject = ((Iterable)d.dVU()).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new k((String)((Iterator)localObject).next()));
    }
    ACT = localArrayList;
    ACU = new HashMap();
    AppMethodBeat.o(289858);
  }
  
  public static com.tencent.mm.plugin.finder.api.i a(cse paramcse)
  {
    AppMethodBeat.i(289846);
    p.k(paramcse, "contact");
    com.tencent.mm.plugin.finder.api.i locali = new com.tencent.mm.plugin.finder.api.i();
    locali.field_username = paramcse.username;
    locali.field_nickname = paramcse.nickname;
    String str2 = paramcse.nfY;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    locali.aAS(str1);
    locali.field_authInfo = paramcse.authInfo;
    AppMethodBeat.o(289846);
    return locali;
  }
  
  public static cse a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(289852);
    p.k(paramLocalFinderAtContactParcel, "contactParcel");
    cse localcse = new cse();
    localcse.username = paramLocalFinderAtContactParcel.username;
    localcse.nfY = paramLocalFinderAtContactParcel.nfY;
    localcse.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.AJd;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localcse.authInfo = localFinderAuthInfo;
      localcse.AJe = paramLocalFinderAtContactParcel.AJe;
      AppMethodBeat.o(289852);
      return localcse;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localcse.authInfo = null;
        Log.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static o<ArrayList<cse>, ArrayList<a>> a(String paramString, HashMap<String, cse> paramHashMap, q<? super Integer, ? super Integer, ? super String, x> paramq)
  {
    AppMethodBeat.i(289842);
    p.k(paramString, "sendContent");
    p.k(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(289842);
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
        k = kotlin.n.n.a((CharSequence)paramString, '@', j, false, 4);
        if ((k == -1) || (k >= paramString.length() - 1)) {
          break;
        }
        j = ei(paramString, k + 1);
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
        if (i - k > 1)
        {
          localObject2 = paramString.substring(k + 1, i);
          p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((List)localObject1).add(localObject2);
          if (paramq != null) {
            paramq.c(Integer.valueOf(k), Integer.valueOf(i), localObject2);
          }
          localArrayList2.add(new a(k, i, (String)localObject2));
        }
        localObject2 = d.AjH;
        j = i;
      } while (((Number)d.dUm().aSr()).intValue() == 1000);
      k = localArrayList2.size();
      Object localObject2 = d.AjH;
      j = i;
    } while (k < ((Number)d.dUm().aSr()).intValue());
    Log.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(289842);
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
          paramq = (cse)paramHashMap.get(paramq);
          if (paramq != null)
          {
            localObject1 = new cse();
            ((cse)localObject1).username = paramq.username;
            ((cse)localObject1).nfY = paramq.nfY;
            ((cse)localObject1).nickname = paramq.nickname;
            ((cse)localObject1).authInfo = paramq.authInfo;
            ((cse)localObject1).AJe = paramq.AJe;
            ((cse)localObject1).type = paramq.type;
            ((cse)localObject1).index = i;
            localArrayList1.add(localObject1);
            i += 1;
          }
        }
        else
        {
          localObject1 = new cse();
          ((cse)localObject1).username = "";
          ((cse)localObject1).nfY = "";
          ((cse)localObject1).nickname = paramq;
          ((cse)localObject1).authInfo = null;
          ((cse)localObject1).AJe = cm.bfC();
          ((cse)localObject1).type = 5;
          ((cse)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      Log.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(289842);
      return paramString;
    }
    Log.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(289842);
    return paramString;
  }
  
  public static o<ArrayList<cse>, ArrayList<a>> a(String paramString, q<? super Integer, ? super Integer, ? super String, x> paramq)
  {
    AppMethodBeat.i(289843);
    p.k(paramString, "sendContent");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(289843);
      return paramString;
    }
    Object localObject = (List)new LinkedList();
    int i = 0;
    while (i < paramString.length())
    {
      int k = kotlin.n.n.a((CharSequence)paramString, '@', i, false, 4);
      if ((k == -1) || (k >= paramString.length() - 1)) {
        break;
      }
      int j = ei(paramString, k + 1);
      i = j;
      if (j == -1) {
        i = paramString.length();
      }
      if (i - k > 1)
      {
        String str = paramString.substring(k + 1, i);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((List)localObject).add(str);
        paramq.c(Integer.valueOf(k), Integer.valueOf(i), str);
        localArrayList2.add(new a(k, i, str));
      }
    }
    Log.i(TAG, "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(289843);
      return paramString;
    }
    if (((List)localObject).size() > 0)
    {
      paramString = ((List)localObject).iterator();
      i = 0;
      while (paramString.hasNext())
      {
        paramq = (String)paramString.next();
        localObject = new cse();
        ((cse)localObject).username = "";
        ((cse)localObject).nfY = "";
        ((cse)localObject).nickname = paramq;
        ((cse)localObject).authInfo = null;
        ((cse)localObject).AJe = cm.bfC();
        ((cse)localObject).type = 5;
        ((cse)localObject).index = i;
        localArrayList1.add(localObject);
        i += 1;
      }
      Log.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new o(localArrayList1, localArrayList2);
      AppMethodBeat.o(289843);
      return paramString;
    }
    Log.w(TAG, "list is null or size 0");
    paramString = new o(localArrayList1, localArrayList2);
    AppMethodBeat.o(289843);
    return paramString;
  }
  
  public static void a(String paramString, Context paramContext1, FinderItem paramFinderItem, Context paramContext2)
  {
    AppMethodBeat.i(289855);
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("finder_username", paramString);
    Object localObject2 = aj.Bnu;
    if (paramFinderItem.field_id == 0L) {}
    for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
    {
      aj.a.a(paramContext1, (Intent)localObject1, l, 2, false, 64);
      localObject2 = a.ACH;
      a.enterFinderProfileUI(paramContext1, (Intent)localObject1);
      localObject1 = aj.Bnu;
      paramContext1 = aj.a.fZ(paramContext1);
      if (paramContext1 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.a(paramContext1.ekY(), paramFinderItem, paramString);
      }
      paramString = aj.Bnu;
      paramString = aj.a.fZ(paramContext2);
      if (paramString == null) {
        break;
      }
      paramString = aj.b(paramString);
      if (paramString == null) {
        break;
      }
      paramString.dpO().KP(paramFinderItem.getId());
      AppMethodBeat.o(289855);
      return;
    }
    AppMethodBeat.o(289855);
  }
  
  public static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(289853);
    Object localObject = new StringBuilder("_finder_at_mmkv");
    p.j(h.aHE(), "MMKernel.account()");
    localObject = MultiProcessMMKV.getMMKV(com.tencent.mm.kernel.b.getUin());
    p.j(localObject, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
    AppMethodBeat.o(289853);
    return localObject;
  }
  
  public static FinderContact b(cse paramcse)
  {
    AppMethodBeat.i(289850);
    p.k(paramcse, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = paramcse.username;
    localFinderContact.headUrl = paramcse.nfY;
    localFinderContact.nickname = paramcse.nickname;
    localFinderContact.authInfo = paramcse.authInfo;
    AppMethodBeat.o(289850);
    return localFinderContact;
  }
  
  public static LocalFinderAtContactParcel c(cse paramcse)
  {
    AppMethodBeat.i(289851);
    p.k(paramcse, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = paramcse.username;
    localLocalFinderAtContactParcel.nfY = paramcse.nfY;
    localLocalFinderAtContactParcel.nickname = paramcse.nickname;
    Object localObject = paramcse.authInfo;
    if (localObject != null) {}
    for (localObject = ((FinderAuthInfo)localObject).toByteArray();; localObject = null)
    {
      localLocalFinderAtContactParcel.AJd = ((byte[])localObject);
      localLocalFinderAtContactParcel.AJe = paramcse.AJe;
      AppMethodBeat.o(289851);
      return localLocalFinderAtContactParcel;
    }
  }
  
  public static LinkedList<cse> ecL()
  {
    AppMethodBeat.i(289845);
    Object localObject1 = aal().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289845);
      return null;
    }
    Object localObject2 = new csi();
    try
    {
      ((csi)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((csi)localObject2).SGP;
      AppMethodBeat.o(289845);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.Atv;
      Log.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(289845);
    }
    return null;
  }
  
  public static HashMap<String, FinderContact> ecM()
  {
    return ACU;
  }
  
  private static int ei(String paramString, int paramInt)
  {
    AppMethodBeat.i(289844);
    p.k(paramString, "content");
    Iterator localIterator = ((Iterable)ACT).iterator();
    int i = -1;
    if (localIterator.hasNext())
    {
      kotlin.n.i locali = ((k)localIterator.next()).t((CharSequence)paramString, paramInt);
      if ((locali == null) || ((i >= 0) && (locali.iQy().dHa >= i))) {
        break label100;
      }
      i = locali.iQy().dHa;
    }
    label100:
    for (;;)
    {
      break;
      AppMethodBeat.o(289844);
      return i;
    }
  }
  
  public static cse f(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(289849);
    p.k(paramFinderContact, "contact");
    cse localcse = new cse();
    localcse.username = paramFinderContact.username;
    localcse.nickname = paramFinderContact.nickname;
    localcse.nfY = paramFinderContact.headUrl;
    localcse.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(289849);
    return localcse;
  }
  
  public static void f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(289856);
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    paramString = aj.Bnu;
    aj.a.a(paramContext, localIntent, 0L, 2, false, 64);
    paramString = a.ACH;
    a.enterFinderProfileUI(paramContext, localIntent);
    AppMethodBeat.o(289856);
  }
  
  public static cse i(com.tencent.mm.plugin.finder.api.i parami)
  {
    AppMethodBeat.i(289848);
    p.k(parami, "contact");
    cse localcse = new cse();
    localcse.username = parami.getUsername();
    localcse.nickname = parami.getNickname();
    localcse.nfY = parami.Mm();
    localcse.authInfo = parami.field_authInfo;
    AppMethodBeat.o(289848);
    return localcse;
  }
  
  public static String y(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(289854);
    p.k(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.TAm;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      cse localcse = (cse)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localcse.index);
      localJSONObject2.put("type", localcse.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    p.j(paramFinderItem, "report.toString()");
    AppMethodBeat.o(289854);
    return paramFinderItem;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    final String ACW;
    private final FinderContact ACX;
    final int end;
    final int start;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(229022);
      this.start = paramInt1;
      this.end = paramInt2;
      this.ACW = paramString;
      this.ACX = paramFinderContact;
      AppMethodBeat.o(229022);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(229032);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.start != paramObject.start) || (this.end != paramObject.end) || (!p.h(this.ACW, paramObject.ACW)) || (!p.h(this.ACX, paramObject.ACX))) {}
        }
      }
      else
      {
        AppMethodBeat.o(229032);
        return true;
      }
      AppMethodBeat.o(229032);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(229030);
      int k = this.start;
      int m = this.end;
      Object localObject = this.ACW;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.ACX;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(229030);
        return (i + (k * 31 + m) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(229027);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.ACW + ", finderContact=" + this.ACX + ")";
      AppMethodBeat.o(229027);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
  public static final class b<T>
    implements Comparator<cse>
  {
    public static final b ACY;
    
    static
    {
      AppMethodBeat.i(237380);
      ACY = new b();
      AppMethodBeat.o(237380);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public c(String paramString, Context paramContext, FinderItem paramFinderItem) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public d(String paramString1, Context paramContext, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.e
 * JD-Core Version:    0.7.0.1
 */