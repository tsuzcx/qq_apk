package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.bvd;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "", "appendStyleAt", "atIndexs", "appendTopicValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "parseXml", "Landroid/text/SpannableString;", "defaultDesc", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "topic", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "clickExtra", "onAtClick", "Lkotlin/Function1;", "username", "plugin-finder_release"})
public final class n
{
  private static final String TAG = "Finder.FinderStyleUtil";
  private static final String VALUE = "value";
  private static final String sLM = "finder";
  private static final String sLN = "style";
  private static final String sLO = "valuecount";
  private static final String sLP = "topic";
  private static final String sLQ = "at";
  private static final String sLR = "<finder>";
  private static final String sLS = "</finder>";
  private static final String sLT = "<style>";
  private static final String sLU = "</style>";
  private static final String sLV = "<at>";
  private static final String sLW = "</at>";
  private static final String sLX = "<![CDATA[%s]]>";
  private static final String sLY = "<valuecount>%d</valuecount>";
  private static final String sLZ = "<value%d>";
  private static final String sMa = "</value%d>";
  private static final String sMb = "<topic>%s</topic>";
  public static final n sMc;
  
  static
  {
    AppMethodBeat.i(204509);
    sMc = new n();
    TAG = "Finder.FinderStyleUtil";
    sLM = "finder";
    sLN = "style";
    sLO = "valuecount";
    VALUE = "value";
    sLP = "topic";
    sLQ = "at";
    sLR = "<" + sLM + '>';
    sLS = "</" + sLM + '>';
    sLT = "<" + sLN + '>';
    sLU = "</" + sLN + '>';
    sLV = "<" + sLQ + '>';
    sLW = "</" + sLQ + '>';
    sLX = "<![CDATA[%s]]>";
    sLY = "<" + sLO + ">%d</" + sLO + '>';
    sLZ = "<" + VALUE + "%d>";
    sMa = "</" + VALUE + "%d>";
    sMb = "<" + sLP + ">%s</" + sLP + '>';
    AppMethodBeat.o(204509);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, final long paramLong, List<o.c> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<api> paramLinkedList1, final m<? super String, ? super o.a, z> paramm, final d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(204508);
    p.h(paramSpannableString, "defaultDesc");
    p.h(paramList, "topicInfoList");
    p.h(paramLinkedList, "atFinderContactList");
    p.h(paramLinkedList1, "mentionedUserList");
    p.h(paramm, "onTopicClick");
    p.h(paramb, "onAtClick");
    if (!bt.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cGf())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cGg()) {}
      }
    }
    else
    {
      AppMethodBeat.o(204508);
      return paramSpannableString;
    }
    Map localMap = bw.M(paramString, "finder");
    if (localMap == null)
    {
      AppMethodBeat.o(204508);
      return paramSpannableString;
    }
    int m = bt.getInt((String)localMap.get("." + sLM + '.' + sLO), -1);
    if (m < 0)
    {
      AppMethodBeat.o(204508);
      return paramSpannableString;
    }
    String str = bt.bI((String)localMap.get("." + sLM + '.' + sLN + '.' + sLQ), "");
    p.g(str, "atIndexs");
    List localList = d.n.n.b((CharSequence)str, new String[] { "," });
    HashMap localHashMap = new HashMap();
    paramString = paramLinkedList.iterator();
    while (paramString.hasNext())
    {
      localObject = (FinderContact)paramString.next();
      if (!localHashMap.containsKey(((FinderContact)localObject).username)) {
        localHashMap.put(((FinderContact)localObject).username, localObject);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject = new ArrayList();
    int i = 0;
    int j = 0;
    int n;
    if (j < m)
    {
      paramString = (String)localMap.get("." + sLM + '.' + VALUE + j + '.' + sLP);
      if (paramString == null)
      {
        n = localStringBuilder.toString().length();
        paramString = (String)localMap.get("." + sLM + '.' + VALUE + j);
        if (paramString != null) {
          break label1107;
        }
        paramString = "";
      }
    }
    label1107:
    for (;;)
    {
      localStringBuilder.append(paramString);
      int k;
      if (localList.contains(String.valueOf(j))) {
        if (paramLinkedList1.size() > i)
        {
          k = i + 1;
          FinderContact localFinderContact = (FinderContact)localHashMap.get(((api)paramLinkedList1.get(i)).username);
          if (localFinderContact != null)
          {
            i = localStringBuilder.toString().length();
            p.g(localFinderContact, "it");
            ((ArrayList)localObject).add(new b.a(n, i, paramString, localFinderContact));
            i = k;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = k;
        continue;
        com.tencent.mm.sdk.platformtools.ad.e(TAG, "parseXml atFinderContactList.size:%s atIndexs:%s curAtIndex:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), str, Integer.valueOf(i) });
        continue;
        paramList.add(new o.c(localStringBuilder.toString().length(), paramString.length(), paramString));
        localStringBuilder.append(paramString);
      }
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "parseXml, result:".concat(String.valueOf(localStringBuilder)));
      if ((bt.isNullOrNil(localStringBuilder.toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
      {
        AppMethodBeat.o(204508);
        return paramSpannableString;
      }
      paramLinkedList = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)k.c(aj.getContext(), (CharSequence)localStringBuilder.toString())));
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramSpannableString = (o.c)paramString.next();
        paramList = paramSpannableString.dzZ;
        i = paramSpannableString.dzZ.length();
        if (paramList == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204508);
          throw paramString;
        }
        paramList = paramList.substring(1, i - 1);
        p.g(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramLinkedList1 = aj.getContext();
        p.g(paramLinkedList1, "MMApplicationContext.getContext()");
        i = paramLinkedList1.getResources().getColor(2131099773);
        paramLinkedList1 = aj.getContext();
        p.g(paramLinkedList1, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new i(paramList, i, paramLinkedList1.getResources().getColor(2131099658), false, (d.g.a.b)new a(paramLinkedList, paramm, paramLong)), paramSpannableString.start, paramSpannableString.start + paramSpannableString.count, 17);
      }
      paramList = ((Iterable)localObject).iterator();
      while (paramList.hasNext())
      {
        paramLinkedList1 = (b.a)paramList.next();
        paramString = paramLinkedList1.sKQ;
        if (paramString != null)
        {
          paramSpannableString = paramString.username;
          paramString = paramSpannableString;
          if (paramSpannableString != null) {}
        }
        else
        {
          paramString = "";
        }
        paramSpannableString = aj.getContext();
        p.g(paramSpannableString, "MMApplicationContext.getContext()");
        i = paramSpannableString.getResources().getColor(2131099773);
        paramSpannableString = aj.getContext();
        p.g(paramSpannableString, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new i(paramString, i, paramSpannableString.getResources().getColor(2131099658), false, (d.g.a.b)new b(paramLinkedList, paramb)), paramLinkedList1.start, paramLinkedList1.end, 17);
      }
      p.g(paramLinkedList, "ret");
      AppMethodBeat.o(204508);
      return paramLinkedList;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(204507);
    Object localObject = d.g.b.ad.MLZ;
    localObject = String.format(sLZ, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = d.g.b.ad.MLZ;
    paramString = String.format(sLX, Arrays.copyOf(new Object[] { paramString }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = d.g.b.ad.MLZ;
    paramString = String.format(sMa, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(204507);
  }
  
  public static String c(String paramString, HashMap<String, bvd> paramHashMap)
  {
    AppMethodBeat.i(204506);
    p.h(paramString, "curDesc");
    p.h(paramHashMap, "atContactMap");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(204506);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGg())
    {
      localObject1 = b.sKO;
      localObject1 = (ArrayList)b.a(paramString, paramHashMap, null).second;
    }
    paramHashMap = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGf()) {
      paramHashMap = o.sMi;
    }
    for (paramHashMap = o.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, bvd>)localObject2)
    {
      localStringBuilder.append(sLR);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = d.g.b.ad.MLZ;
        paramHashMap = String.format(sLY, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        p.g(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        localStringBuilder.append(sLS);
        com.tencent.mm.sdk.platformtools.ad.d(TAG, "xml:".concat(String.valueOf(localStringBuilder)));
        paramString = localStringBuilder.toString();
        p.g(paramString, "xml.toString()");
        AppMethodBeat.o(204506);
        return paramString;
      }
      int i = 0;
      int j = 0;
      localObject2 = "";
      int k = 0;
      label254:
      int m;
      int n;
      label285:
      int i1;
      if (j < paramString.length()) {
        if (!paramHashMap.isEmpty())
        {
          m = 0;
          n = ((Collection)paramHashMap).size();
          if (m >= n) {
            break label1123;
          }
          localObject3 = (o.c)paramHashMap.get(m);
          i1 = ((o.c)localObject3).start - 1;
          if (i1 != j) {}
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          paramHashMap.remove(localObject3);
          n = ((o.c)localObject3).start - 1;
          m = ((o.c)localObject3).count + n + 2;
          if (n >= k)
          {
            j = i;
            if (n > k)
            {
              localObject3 = paramString.substring(k, n);
              p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, (String)localObject3, i);
              j = i + 1;
            }
            localObject3 = paramString.substring(n, m);
            p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Object localObject4 = d.g.b.ad.MLZ;
            localObject4 = String.format(sLZ, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4);
            localObject4 = d.g.b.ad.MLZ;
            localObject4 = sMb;
            d.g.b.ad localad = d.g.b.ad.MLZ;
            localObject3 = String.format(sLX, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            localObject3 = d.g.b.ad.MLZ;
            localObject3 = String.format(sMa, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            i = m;
            k = m;
            m = j + 1;
            j = i;
            i = m;
            break label254;
            if (i1 > j) {
              break label1123;
            }
            m += 1;
            break label285;
          }
          com.tencent.mm.sdk.platformtools.ad.e(TAG, "topicStart:" + n + ", startIndex:" + k);
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          m = 0;
          n = ((Collection)localObject1).size();
          label680:
          if (m >= n) {
            break label1117;
          }
          localObject3 = ((ArrayList)localObject1).get(m);
          p.g(localObject3, "atContactList[atIndex]");
          localObject3 = (b.a)localObject3;
          i1 = ((b.a)localObject3).start;
          if (i1 != j) {}
        }
        for (;;)
        {
          if (localObject3 != null)
          {
            ((ArrayList)localObject1).remove(localObject3);
            n = ((b.a)localObject3).start;
            m = ((b.a)localObject3).end + 1;
            if (n >= k)
            {
              if (n <= k) {
                break label1114;
              }
              localObject3 = paramString.substring(k, n);
              p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              j = i + 1;
              a(localStringBuilder, (String)localObject3, i);
              i = j;
            }
          }
          label1114:
          for (;;)
          {
            localObject3 = paramString.substring(n, m);
            p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            n = i + 1;
            a(localStringBuilder, (String)localObject3, i);
            localObject2 = (String)localObject2 + String.valueOf(n - 1) + ",";
            j = m;
            k = m;
            i = n;
            break label254;
            if (i1 > j) {
              break label1117;
            }
            m += 1;
            break label680;
            com.tencent.mm.sdk.platformtools.ad.e(TAG, "topicStart:" + n + ", startIndex:" + k);
            j += 1;
            break label254;
            j = i;
            if (k < paramString.length())
            {
              paramString = paramString.substring(k, paramString.length());
              p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, paramString, i);
              j = i + 1;
            }
            if (!bt.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(sLT);
              localStringBuilder.append(sLV);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(204506);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(sLW);
              localStringBuilder.append(sLU);
            }
            paramString = d.g.b.ad.MLZ;
            paramString = String.format(sLY, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(paramString, "java.lang.String.format(format, *args)");
            localStringBuilder.append(paramString);
            break;
          }
          label1117:
          localObject3 = null;
        }
        label1123:
        localObject3 = null;
      }
    }
  }
  
  public static String cLt()
  {
    return sLM;
  }
  
  public static String cLu()
  {
    return sLO;
  }
  
  public static String cLv()
  {
    return VALUE;
  }
  
  public static String cLw()
  {
    return sLP;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "topic", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseXml$2$1"})
  static final class a
    extends q
    implements d.g.a.b<String, z>
  {
    a(SpannableString paramSpannableString, m paramm, long paramLong)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseXml$3$1"})
  static final class b
    extends q
    implements d.g.a.b<String, z>
  {
    b(SpannableString paramSpannableString, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n
 * JD-Core Version:    0.7.0.1
 */