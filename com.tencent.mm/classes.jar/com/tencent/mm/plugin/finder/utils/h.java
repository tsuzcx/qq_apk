package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.ak;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.djg;>;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.k.e;
import kotlin.n.i;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil;", "", "()V", "AT_SOME_ONE_NO_COUNT_LIMIT", "", "AT_SOME_ONE_PREFIX_CHAR", "", "AT_SOME_ONE_SUFFIX_CHAR", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "FINDER_AT_MMKV", "", "FINDER_AT_MMKV_RECENT_AT", "SIGNATURE_AT_SOME_ONE_SUFFIX_CHAR", "TAG", "nicknameToContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Lkotlin/collections/HashMap;", "getNicknameToContactMap", "()Ljava/util/HashMap;", "_readRecentAt", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "_writeRecentAt", "", "atContacts", "findEndIndex", "content", "startIndex", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getReportAtContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpAtProfileUI", "context", "Landroid/content/Context;", "nickname", "feedObject", "jumpAtProfileUIOfSignature", "fromProfileUsername", "jumpContinue", "username", "it", "jumpContinueOfSignature", "parseDesc", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "sendContent", "atContactMap", "onSetAtSpan", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "start", "end", "parseDescOfSignature", "transformToFinderContact", "lcontact", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "contact", "transformToLocalFinderAtContact", "contactParcel", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "transformToLocalFinderAtContactParcel", "AtStringInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h Gga;
  private static ArrayList<k> Ggb;
  private static final HashMap<String, FinderContact> Ggc;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333975);
    Gga = new h();
    TAG = "Finder.FinderAtUtil";
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.FAy;
    localObject = ((Iterable)d.eUD()).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new k((String)((Iterator)localObject).next()));
    }
    Ggb = localArrayList;
    Ggc = new HashMap();
    AppMethodBeat.o(333975);
  }
  
  public static String B(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(333908);
    s.u(paramFinderItem, "finderItem");
    paramFinderItem = paramFinderItem.field_postinfo.aaPA;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramFinderItem.iterator();
    while (localIterator.hasNext())
    {
      djg localdjg = (djg)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("index", localdjg.index);
      localJSONObject2.put("type", localdjg.type);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("atcontent", localJSONArray);
    localJSONObject1.put("num", paramFinderItem.size());
    paramFinderItem = localJSONObject1.toString();
    s.s(paramFinderItem, "report.toString()");
    AppMethodBeat.o(333908);
    return paramFinderItem;
  }
  
  public static void E(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(333932);
    s.u(paramString1, "nickname");
    if (paramContext != null)
    {
      if (Ggc.containsKey(paramString1))
      {
        Object localObject = (FinderContact)Ggc.get(paramString1);
        if (localObject == null) {}
        for (localObject = null; (!Util.isNullOrNil((String)localObject)) && (localObject != null); localObject = ((FinderContact)localObject).username)
        {
          f((String)localObject, paramContext);
          localObject = com.tencent.mm.plugin.report.service.h.OAn;
          paramString1 = new StringBuilder("0,2,").append(paramString1).append(",1,");
          paramContext = paramString2;
          if (paramString2 == null) {
            paramContext = "";
          }
          ((com.tencent.mm.plugin.report.service.h)localObject).kvStat(21172, paramContext);
          AppMethodBeat.o(333932);
          return;
        }
        Log.i(TAG, "username nil");
        com.tencent.mm.ui.base.aa.makeText(paramContext, e.h.finder_at_user_not_exist, 0).show();
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        paramString1 = new StringBuilder("0,2,").append(paramString1).append(",2,");
        paramContext = paramString2;
        if (paramString2 == null) {
          paramContext = "";
        }
        ((com.tencent.mm.plugin.report.service.h)localObject).kvStat(21172, paramContext);
        AppMethodBeat.o(333932);
        return;
      }
      new com.tencent.mm.plugin.finder.cgi.aa(p.listOf(paramString1)).bFJ().g(new h..ExternalSyntheticLambda1(paramString1, paramContext, paramString2));
    }
    AppMethodBeat.o(333932);
  }
  
  public static m a(djg paramdjg)
  {
    AppMethodBeat.i(333845);
    s.u(paramdjg, "contact");
    m localm = new m();
    localm.field_username = paramdjg.username;
    localm.field_nickname = paramdjg.nickname;
    String str2 = paramdjg.nVM;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localm.auZ(str1);
    localm.field_authInfo = paramdjg.authInfo;
    AppMethodBeat.o(333845);
    return localm;
  }
  
  public static djg a(LocalFinderAtContactParcel paramLocalFinderAtContactParcel)
  {
    AppMethodBeat.i(333886);
    s.u(paramLocalFinderAtContactParcel, "contactParcel");
    djg localdjg = new djg();
    localdjg.username = paramLocalFinderAtContactParcel.username;
    localdjg.nVM = paramLocalFinderAtContactParcel.nVM;
    localdjg.nickname = paramLocalFinderAtContactParcel.nickname;
    byte[] arrayOfByte = paramLocalFinderAtContactParcel.GlA;
    if (arrayOfByte != null) {}
    try
    {
      FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
      localFinderAuthInfo.parseFrom(arrayOfByte);
      localdjg.authInfo = localFinderAuthInfo;
      localdjg.GlB = paramLocalFinderAtContactParcel.GlB;
      AppMethodBeat.o(333886);
      return localdjg;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localdjg.authInfo = null;
        Log.e(TAG, "transformToLocalFinderAtContact FinderAuthInfo parseFrom:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  private static final ah a(String paramString, Context paramContext, FinderItem paramFinderItem, b.a parama)
  {
    AppMethodBeat.i(333958);
    s.u(paramString, "$nickname");
    s.u(paramFinderItem, "$feedObject");
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject = ((bbi)parama.ott).ZIt;
      s.s(localObject, "it.resp.contactList");
      localObject = (FinderContact)p.oL((List)localObject);
      if (localObject == null)
      {
        localObject = "";
        Map localMap = (Map)Ggc;
        parama = ((bbi)parama.ott).ZIt;
        s.s(parama, "it.resp.contactList");
        localMap.put(paramString, p.oL((List)parama));
        if (Util.isNullOrNil((String)localObject)) {
          break label170;
        }
        a((String)localObject, paramContext, paramFinderItem, paramContext);
      }
    }
    for (;;)
    {
      paramString = ah.aiuX;
      AppMethodBeat.o(333958);
      return paramString;
      localObject = ((FinderContact)localObject).username;
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      break;
      label170:
      Log.i(TAG, "username nil");
      com.tencent.mm.ui.base.aa.makeText(paramContext, e.h.finder_at_user_not_exist, 0).show();
      continue;
      Log.i(TAG, "cgi failed.");
    }
  }
  
  private static final ah a(String paramString1, Context paramContext, String paramString2, b.a parama)
  {
    AppMethodBeat.i(333965);
    s.u(paramString1, "$nickname");
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject = ((bbi)parama.ott).ZIt;
      s.s(localObject, "it.resp.contactList");
      localObject = (FinderContact)p.oL((List)localObject);
      if (localObject == null)
      {
        localObject = "";
        Map localMap = (Map)Ggc;
        parama = ((bbi)parama.ott).ZIt;
        s.s(parama, "it.resp.contactList");
        localMap.put(paramString1, p.oL((List)parama));
        if (Util.isNullOrNil((String)localObject)) {
          break label211;
        }
        f((String)localObject, paramContext);
        paramContext = com.tencent.mm.plugin.report.service.h.OAn;
        parama = new StringBuilder("0,2,").append(paramString1).append(",1,");
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        paramContext.kvStat(21172, paramString1);
      }
    }
    for (;;)
    {
      paramString1 = ah.aiuX;
      AppMethodBeat.o(333965);
      return paramString1;
      localObject = ((FinderContact)localObject).username;
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      break;
      label211:
      Log.i(TAG, "username nil");
      com.tencent.mm.ui.base.aa.makeText(paramContext, e.h.finder_at_user_not_exist, 0).show();
      paramContext = com.tencent.mm.plugin.report.service.h.OAn;
      parama = new StringBuilder("0,2,").append(paramString1).append(",2,");
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramContext.kvStat(21172, paramString1);
      continue;
      Log.i(TAG, "cgi failed.");
    }
  }
  
  public static r<ArrayList<djg>, ArrayList<a>> a(String paramString, HashMap<String, djg> paramHashMap, q<? super Integer, ? super Integer, ? super String, ah> paramq)
  {
    AppMethodBeat.i(333801);
    s.u(paramString, "sendContent");
    s.u(paramHashMap, "atContactMap");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      paramString = new r(localArrayList1, localArrayList2);
      AppMethodBeat.o(333801);
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
        j = eU(paramString, k + 1);
        i = j;
        if (j == -1) {
          i = paramString.length();
        }
        if (i - k > 1)
        {
          localObject2 = paramString.substring(k + 1, i);
          s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          ((List)localObject1).add(localObject2);
          if (paramq != null) {
            paramq.invoke(Integer.valueOf(k), Integer.valueOf(i), localObject2);
          }
          localArrayList2.add(new a(k, i, (String)localObject2));
        }
        localObject2 = d.FAy;
        j = i;
      } while (((Number)d.eSF().bmg()).intValue() == 1000);
      k = localArrayList2.size();
      Object localObject2 = d.FAy;
      j = i;
    } while (k < ((Number)d.eSF().bmg()).intValue());
    Log.i(TAG, "after split @ :%s", new Object[] { localObject1 });
    if (((List)localObject1).size() <= 0)
    {
      paramString = new r(localArrayList1, localArrayList2);
      AppMethodBeat.o(333801);
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
          paramq = (djg)paramHashMap.get(paramq);
          if (paramq != null)
          {
            localObject1 = new djg();
            ((djg)localObject1).username = paramq.username;
            ((djg)localObject1).nVM = paramq.nVM;
            ((djg)localObject1).nickname = paramq.nickname;
            ((djg)localObject1).authInfo = paramq.authInfo;
            ((djg)localObject1).GlB = paramq.GlB;
            ((djg)localObject1).type = paramq.type;
            ((djg)localObject1).index = i;
            localArrayList1.add(localObject1);
            i += 1;
          }
        }
        else
        {
          localObject1 = new djg();
          ((djg)localObject1).username = "";
          ((djg)localObject1).nVM = "";
          ((djg)localObject1).nickname = paramq;
          ((djg)localObject1).authInfo = null;
          ((djg)localObject1).GlB = cn.bDu();
          ((djg)localObject1).type = 5;
          ((djg)localObject1).index = i;
          localArrayList1.add(localObject1);
          i += 1;
        }
      }
      Log.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new r(localArrayList1, localArrayList2);
      AppMethodBeat.o(333801);
      return paramString;
    }
    Log.w(TAG, "list is null or size 0");
    paramString = new r(localArrayList1, localArrayList2);
    AppMethodBeat.o(333801);
    return paramString;
  }
  
  public static r<ArrayList<djg>, ArrayList<a>> a(String paramString, q<? super Integer, ? super Integer, ? super String, ah> paramq)
  {
    AppMethodBeat.i(333812);
    s.u(paramString, "sendContent");
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      paramString = new r(localArrayList1, localArrayList2);
      AppMethodBeat.o(333812);
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
      int j = eU(paramString, k + 1);
      i = j;
      if (j == -1) {
        i = paramString.length();
      }
      if (i - k > 1)
      {
        String str = paramString.substring(k + 1, i);
        s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ((List)localObject).add(str);
        paramq.invoke(Integer.valueOf(k), Integer.valueOf(i), str);
        localArrayList2.add(new a(k, i, str));
      }
    }
    Log.i(TAG, "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      paramString = new r(localArrayList1, localArrayList2);
      AppMethodBeat.o(333812);
      return paramString;
    }
    if (((List)localObject).size() > 0)
    {
      paramString = ((List)localObject).iterator();
      i = 0;
      while (paramString.hasNext())
      {
        paramq = (String)paramString.next();
        localObject = new djg();
        ((djg)localObject).username = "";
        ((djg)localObject).nVM = "";
        ((djg)localObject).nickname = paramq;
        ((djg)localObject).authInfo = null;
        ((djg)localObject).GlB = cn.bDu();
        ((djg)localObject).type = 5;
        ((djg)localObject).index = i;
        localArrayList1.add(localObject);
        i += 1;
      }
      Log.d(TAG, "[getAtContactList] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramString = new r(localArrayList1, localArrayList2);
      AppMethodBeat.o(333812);
      return paramString;
    }
    Log.w(TAG, "list is null or size 0");
    paramString = new r(localArrayList1, localArrayList2);
    AppMethodBeat.o(333812);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(333915);
    s.u(paramString, "nickname");
    s.u(paramFinderItem, "feedObject");
    Object localObject;
    if (paramContext != null)
    {
      if (!Ggc.containsKey(paramString)) {
        break label116;
      }
      localObject = (FinderContact)Ggc.get(paramString);
      if (localObject != null) {
        break label85;
      }
      localObject = null;
      if ((Util.isNullOrNil((String)localObject)) || (localObject == null)) {
        break label93;
      }
      a((String)localObject, paramContext, paramFinderItem, paramContext);
    }
    for (;;)
    {
      paramFinderItem = ak.FtG;
      ak.g(paramContext, 1, paramString);
      AppMethodBeat.o(333915);
      return;
      label85:
      localObject = ((FinderContact)localObject).username;
      break;
      label93:
      Log.i(TAG, "username nil");
      com.tencent.mm.ui.base.aa.makeText(paramContext, e.h.finder_at_user_not_exist, 0).show();
      continue;
      label116:
      new com.tencent.mm.plugin.finder.cgi.aa(p.listOf(paramString)).bFJ().g(new h..ExternalSyntheticLambda0(paramString, paramContext, paramFinderItem));
    }
  }
  
  private static void a(String paramString, Context paramContext1, FinderItem paramFinderItem, Context paramContext2)
  {
    AppMethodBeat.i(333922);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("finder_username", paramString);
    as.a locala = as.GSQ;
    if (paramFinderItem.field_id == 0L) {}
    for (long l = paramFinderItem.getLocalId();; l = paramFinderItem.field_id)
    {
      as.a.a(paramContext1, (Intent)localObject, l, 2, false, 64);
      ((Intent)localObject).putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
      ((Intent)localObject).putExtra("key_entrance_type", 4);
      a.GfO.enterFinderProfileUI(paramContext1, (Intent)localObject);
      localObject = as.GSQ;
      paramContext1 = as.a.hu(paramContext1);
      if (paramContext1 != null)
      {
        localObject = z.FrZ;
        z.a(paramContext1.fou(), paramFinderItem, paramString);
      }
      paramString = as.GSQ;
      paramString = as.a.hu(paramContext2);
      if (paramString != null)
      {
        paramString = ((bn)paramString).foy();
        if (paramString != null)
        {
          paramString = paramString.dYj();
          if (paramString != null) {
            paramString.nn(paramFinderItem.getId());
          }
        }
      }
      AppMethodBeat.o(333922);
      return;
    }
  }
  
  private static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(333898);
    com.tencent.mm.kernel.h.baC();
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X("_finder_at_mmkv", Integer.valueOf(com.tencent.mm.kernel.b.getUin())));
    s.s(localMultiProcessMMKV, "getMMKV(FINDER_AT_MMKV + MMKernel.account().uin)");
    AppMethodBeat.o(333898);
    return localMultiProcessMMKV;
  }
  
  private static final int b(djg paramdjg1, djg paramdjg2)
  {
    AppMethodBeat.i(333945);
    int i = Long.compare(paramdjg2.GlB, paramdjg1.GlB);
    AppMethodBeat.o(333945);
    return i;
  }
  
  public static FinderContact b(djg paramdjg)
  {
    AppMethodBeat.i(333866);
    s.u(paramdjg, "lcontact");
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = paramdjg.username;
    localFinderContact.headUrl = paramdjg.nVM;
    localFinderContact.nickname = paramdjg.nickname;
    localFinderContact.authInfo = paramdjg.authInfo;
    AppMethodBeat.o(333866);
    return localFinderContact;
  }
  
  public static void bh(LinkedList<djg> paramLinkedList)
  {
    AppMethodBeat.i(333833);
    s.u(paramLinkedList, "atContacts");
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(333833);
      return;
    }
    Object localObject2 = feK();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new LinkedList();
    }
    HashMap localHashMap = new HashMap(((LinkedList)localObject1).size());
    Object localObject4 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      djg localdjg = (djg)((Iterator)localObject4).next();
      localObject3 = localdjg.username;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localHashMap.put(localObject2, localdjg);
    }
    Object localObject3 = paramLinkedList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (djg)((Iterator)localObject3).next();
      if (!Util.isNullOrNil(((djg)localObject4).username))
      {
        paramLinkedList = (djg)((Map)localHashMap).get(((djg)localObject4).username);
        if ((paramLinkedList == null) || (paramLinkedList.GlB < ((djg)localObject4).GlB))
        {
          localObject2 = ((djg)localObject4).username;
          paramLinkedList = (LinkedList<djg>)localObject2;
          if (localObject2 == null) {
            paramLinkedList = "";
          }
          localHashMap.put(paramLinkedList, localObject4);
        }
      }
    }
    ((LinkedList)localObject1).clear();
    paramLinkedList = ((Map)localHashMap).entrySet().iterator();
    while (paramLinkedList.hasNext())
    {
      localObject2 = (Map.Entry)paramLinkedList.next();
      ((Map.Entry)localObject2).getKey();
      ((LinkedList)localObject1).add((djg)((Map.Entry)localObject2).getValue());
    }
    Collections.sort((List)localObject1, h..ExternalSyntheticLambda2.INSTANCE);
    int i;
    if (((LinkedList)localObject1).size() > 5)
    {
      i = ((LinkedList)localObject1).size() - 1;
      if (5 > i) {}
    }
    for (;;)
    {
      int j = i - 1;
      ((LinkedList)localObject1).remove(i);
      if (5 > j)
      {
        paramLinkedList = new djk();
        paramLinkedList.ZJH = ((LinkedList)localObject1);
        try
        {
          paramLinkedList = paramLinkedList.toByteArray();
          if (paramLinkedList == null)
          {
            AppMethodBeat.o(333833);
            return;
          }
        }
        catch (IOException paramLinkedList)
        {
          localObject1 = FinderPostAtUI.FSK;
          Log.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)paramLinkedList, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { paramLinkedList.getMessage() });
          AppMethodBeat.o(333833);
          return;
        }
        aBP().encode("_finder_at_mmkv_recent_at", paramLinkedList);
        AppMethodBeat.o(333833);
        return;
      }
      i = j;
    }
  }
  
  public static LocalFinderAtContactParcel c(djg paramdjg)
  {
    AppMethodBeat.i(333878);
    s.u(paramdjg, "contact");
    LocalFinderAtContactParcel localLocalFinderAtContactParcel = new LocalFinderAtContactParcel();
    localLocalFinderAtContactParcel.username = paramdjg.username;
    localLocalFinderAtContactParcel.nVM = paramdjg.nVM;
    localLocalFinderAtContactParcel.nickname = paramdjg.nickname;
    Object localObject = paramdjg.authInfo;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FinderAuthInfo)localObject).toByteArray())
    {
      localLocalFinderAtContactParcel.GlA = ((byte[])localObject);
      localLocalFinderAtContactParcel.GlB = paramdjg.GlB;
      AppMethodBeat.o(333878);
      return localLocalFinderAtContactParcel;
    }
  }
  
  private static int eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(333821);
    s.u(paramString, "content");
    Iterator localIterator = ((Iterable)Ggb).iterator();
    int i = -1;
    if (localIterator.hasNext())
    {
      i locali = ((k)localIterator.next()).n((CharSequence)paramString, paramInt);
      if ((locali == null) || ((i >= 0) && (locali.kBn().fIj >= i))) {
        break label100;
      }
      i = locali.kBn().fIj;
    }
    label100:
    for (;;)
    {
      break;
      AppMethodBeat.o(333821);
      return i;
    }
  }
  
  private static void f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(333939);
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    paramString = as.GSQ;
    as.a.a(paramContext, localIntent, 0L, 2, false, 64);
    a.GfO.enterFinderProfileUI(paramContext, localIntent);
    AppMethodBeat.o(333939);
  }
  
  public static LinkedList<djg> feK()
  {
    AppMethodBeat.i(333839);
    Object localObject1 = aBP().decodeBytes("_finder_at_mmkv_recent_at");
    if (localObject1 != null) {
      if (localObject1.length != 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(333839);
      return null;
    }
    Object localObject2 = new djk();
    try
    {
      ((djk)localObject2).parseFrom((byte[])localObject1);
      localObject1 = ((djk)localObject2).ZJH;
      AppMethodBeat.o(333839);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      localObject2 = FinderPostAtUI.FSK;
      Log.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_readRecentAt, LocalFinderRecentAtContactCache, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(333839);
    }
    return null;
  }
  
  public static djg i(FinderContact paramFinderContact)
  {
    AppMethodBeat.i(333857);
    if (paramFinderContact == null)
    {
      AppMethodBeat.o(333857);
      return null;
    }
    djg localdjg = new djg();
    localdjg.username = paramFinderContact.username;
    localdjg.nickname = paramFinderContact.nickname;
    localdjg.nVM = paramFinderContact.headUrl;
    localdjg.authInfo = paramFinderContact.authInfo;
    AppMethodBeat.o(333857);
    return localdjg;
  }
  
  public static djg m(m paramm)
  {
    AppMethodBeat.i(333851);
    s.u(paramm, "contact");
    djg localdjg = new djg();
    localdjg.username = paramm.getUsername();
    localdjg.nickname = paramm.getNickname();
    localdjg.nVM = paramm.amx();
    localdjg.authInfo = paramm.field_authInfo;
    AppMethodBeat.o(333851);
    return localdjg;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "", "start", "", "end", "atNickname", "", "finderContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getAtNickname", "()Ljava/lang/String;", "getEnd", "()I", "getFinderContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final FinderContact BhP;
    final String Ggd;
    final int end;
    final int start;
    
    public a(int paramInt1, int paramInt2, String paramString, FinderContact paramFinderContact)
    {
      AppMethodBeat.i(333475);
      this.start = paramInt1;
      this.end = paramInt2;
      this.Ggd = paramString;
      this.BhP = paramFinderContact;
      AppMethodBeat.o(333475);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(333513);
      if (this == paramObject)
      {
        AppMethodBeat.o(333513);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(333513);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.start != paramObject.start)
      {
        AppMethodBeat.o(333513);
        return false;
      }
      if (this.end != paramObject.end)
      {
        AppMethodBeat.o(333513);
        return false;
      }
      if (!s.p(this.Ggd, paramObject.Ggd))
      {
        AppMethodBeat.o(333513);
        return false;
      }
      if (!s.p(this.BhP, paramObject.BhP))
      {
        AppMethodBeat.o(333513);
        return false;
      }
      AppMethodBeat.o(333513);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(333499);
      int i = this.start;
      int j = this.end;
      int k = this.Ggd.hashCode();
      int m = this.BhP.hashCode();
      AppMethodBeat.o(333499);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(333487);
      String str = "AtStringInfo(start=" + this.start + ", end=" + this.end + ", atNickname=" + this.Ggd + ", finderContact=" + this.BhP + ')';
      AppMethodBeat.o(333487);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.h
 * JD-Core Version:    0.7.0.1
 */