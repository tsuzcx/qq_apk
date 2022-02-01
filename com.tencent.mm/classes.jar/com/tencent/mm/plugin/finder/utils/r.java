package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.g.a.m;
import d.g.b.z;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.ebc;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "", "appendStyleAt", "atIndexs", "appendTopicValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "parseXml", "Landroid/text/SpannableString;", "defaultDesc", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "topic", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "clickExtra", "onAtClick", "Lkotlin/Function1;", "username", "plugin-finder_release"})
public final class r
{
  private static final String LaO = "finder";
  private static final String LaP = "style";
  private static final String LaQ = "valuecount";
  private static final String LaR = "topic";
  private static final String LaS = "at";
  private static final String LaT = "<finder>";
  private static final String LaU = "</finder>";
  private static final String LaV = "<style>";
  private static final String LaW = "</style>";
  private static final String LaX = "<at>";
  private static final String LaY = "</at>";
  private static final String LaZ = "<![CDATA[%s]]>";
  private static final String Lba = "<valuecount>%d</valuecount>";
  private static final String Lbb = "<value%d>";
  private static final String Lbc = "</value%d>";
  private static final String Lbd = "<topic>%s</topic>";
  public static final r Lbe;
  private static final String TAG = "Finder.FinderStyleUtil";
  private static final String VALUE = "value";
  
  static
  {
    AppMethodBeat.i(199651);
    Lbe = new r();
    TAG = "Finder.FinderStyleUtil";
    LaO = "finder";
    LaP = "style";
    LaQ = "valuecount";
    VALUE = "value";
    LaR = "topic";
    LaS = "at";
    LaT = "<" + LaO + '>';
    LaU = "</" + LaO + '>';
    LaV = "<" + LaP + '>';
    LaW = "</" + LaP + '>';
    LaX = "<" + LaS + '>';
    LaY = "</" + LaS + '>';
    LaZ = "<![CDATA[%s]]>";
    Lba = "<" + LaQ + ">%d</" + LaQ + '>';
    Lbb = "<" + VALUE + "%d>";
    Lbc = "</" + VALUE + "%d>";
    Lbd = "<" + LaR + ">%s</" + LaR + '>';
    AppMethodBeat.o(199651);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, final long paramLong, List<h.c> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<dzi> paramLinkedList1, final m<? super String, ? super h.a, y> paramm, final d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(199650);
    d.g.b.k.h(paramSpannableString, "defaultDesc");
    d.g.b.k.h(paramList, "topicInfoList");
    d.g.b.k.h(paramLinkedList, "atFinderContactList");
    d.g.b.k.h(paramLinkedList1, "mentionedUserList");
    d.g.b.k.h(paramm, "onTopicClick");
    d.g.b.k.h(paramb, "onAtClick");
    if (!bt.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpO())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUh()) {}
      }
    }
    else
    {
      AppMethodBeat.o(199650);
      return paramSpannableString;
    }
    Map localMap = bw.K(paramString, "finder");
    if (localMap == null)
    {
      AppMethodBeat.o(199650);
      return paramSpannableString;
    }
    int m = bt.getInt((String)localMap.get("." + LaO + '.' + LaQ), -1);
    if (m < 0)
    {
      AppMethodBeat.o(199650);
      return paramSpannableString;
    }
    String str = bt.by((String)localMap.get("." + LaO + '.' + LaP + '.' + LaS), "");
    d.g.b.k.g(str, "atIndexs");
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
      paramString = (String)localMap.get("." + LaO + '.' + VALUE + j + '.' + LaR);
      if (paramString == null)
      {
        n = localStringBuilder.toString().length();
        paramString = (String)localMap.get("." + LaO + '.' + VALUE + j);
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
          FinderContact localFinderContact = (FinderContact)localHashMap.get(((dzi)paramLinkedList1.get(i)).username);
          if (localFinderContact != null)
          {
            i = localStringBuilder.toString().length();
            d.g.b.k.g(localFinderContact, "it");
            ((ArrayList)localObject).add(new n.a(n, i, paramString, localFinderContact));
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
        ad.e(TAG, "parseXml atFinderContactList.size:%s atIndexs:%s curAtIndex:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), str, Integer.valueOf(i) });
        continue;
        paramList.add(new h.c(localStringBuilder.toString().length(), paramString.length(), paramString));
        localStringBuilder.append(paramString);
      }
      ad.i(TAG, "parseXml, result:".concat(String.valueOf(localStringBuilder)));
      if ((bt.isNullOrNil(localStringBuilder.toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
      {
        AppMethodBeat.o(199650);
        return paramSpannableString;
      }
      paramLinkedList = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)localStringBuilder.toString())));
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramSpannableString = (h.c)paramString.next();
        paramList = paramSpannableString.dqA;
        i = paramSpannableString.dqA.length();
        if (paramList == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199650);
          throw paramString;
        }
        paramList = paramList.substring(1, i - 1);
        d.g.b.k.g(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramLinkedList1 = aj.getContext();
        d.g.b.k.g(paramLinkedList1, "MMApplicationContext.getContext()");
        i = paramLinkedList1.getResources().getColor(2131099773);
        paramLinkedList1 = aj.getContext();
        d.g.b.k.g(paramLinkedList1, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new e(paramList, i, paramLinkedList1.getResources().getColor(2131099658), false, (d.g.a.b)new a(paramLinkedList, paramm, paramLong)), paramSpannableString.start, paramSpannableString.start + paramSpannableString.count, 17);
      }
      paramList = ((Iterable)localObject).iterator();
      while (paramList.hasNext())
      {
        paramLinkedList1 = (n.a)paramList.next();
        paramString = paramLinkedList1.LaE;
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
        d.g.b.k.g(paramSpannableString, "MMApplicationContext.getContext()");
        i = paramSpannableString.getResources().getColor(2131099773);
        paramSpannableString = aj.getContext();
        d.g.b.k.g(paramSpannableString, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new e(paramString, i, paramSpannableString.getResources().getColor(2131099658), false, (d.g.a.b)new b(paramLinkedList, paramb)), paramLinkedList1.start, paramLinkedList1.end, 17);
      }
      d.g.b.k.g(paramLinkedList, "ret");
      AppMethodBeat.o(199650);
      return paramLinkedList;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(199649);
    Object localObject = z.Jhz;
    localObject = String.format(Lbb, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    d.g.b.k.g(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = z.Jhz;
    paramString = String.format(LaZ, Arrays.copyOf(new Object[] { paramString }, 1));
    d.g.b.k.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = z.Jhz;
    paramString = String.format(Lbc, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    d.g.b.k.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(199649);
  }
  
  public static String f(String paramString, HashMap<String, ebc> paramHashMap)
  {
    AppMethodBeat.i(199648);
    d.g.b.k.h(paramString, "curDesc");
    d.g.b.k.h(paramHashMap, "atContactMap");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(199648);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUh())
    {
      localObject1 = n.LaC;
      localObject1 = (ArrayList)n.a(paramString, paramHashMap, null).second;
    }
    paramHashMap = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpO()) {
      paramHashMap = h.qSR;
    }
    for (paramHashMap = h.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, ebc>)localObject2)
    {
      localStringBuilder.append(LaT);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = z.Jhz;
        paramHashMap = String.format(Lba, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        d.g.b.k.g(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        localStringBuilder.append(LaU);
        ad.d(TAG, "xml:".concat(String.valueOf(localStringBuilder)));
        paramString = localStringBuilder.toString();
        d.g.b.k.g(paramString, "xml.toString()");
        AppMethodBeat.o(199648);
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
          localObject3 = (h.c)paramHashMap.get(m);
          i1 = ((h.c)localObject3).start - 1;
          if (i1 != j) {}
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          paramHashMap.remove(localObject3);
          n = ((h.c)localObject3).start - 1;
          m = ((h.c)localObject3).count + n + 2;
          if (n >= k)
          {
            j = i;
            if (n > k)
            {
              localObject3 = paramString.substring(k, n);
              d.g.b.k.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, (String)localObject3, i);
              j = i + 1;
            }
            localObject3 = paramString.substring(n, m);
            d.g.b.k.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Object localObject4 = z.Jhz;
            localObject4 = String.format(Lbb, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            d.g.b.k.g(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4);
            localObject4 = z.Jhz;
            localObject4 = Lbd;
            z localz = z.Jhz;
            localObject3 = String.format(LaZ, Arrays.copyOf(new Object[] { localObject3 }, 1));
            d.g.b.k.g(localObject3, "java.lang.String.format(format, *args)");
            localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
            d.g.b.k.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            localObject3 = z.Jhz;
            localObject3 = String.format(Lbc, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            d.g.b.k.g(localObject3, "java.lang.String.format(format, *args)");
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
          ad.e(TAG, "topicStart:" + n + ", startIndex:" + k);
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
          d.g.b.k.g(localObject3, "atContactList[atIndex]");
          localObject3 = (n.a)localObject3;
          i1 = ((n.a)localObject3).start;
          if (i1 != j) {}
        }
        for (;;)
        {
          if (localObject3 != null)
          {
            ((ArrayList)localObject1).remove(localObject3);
            n = ((n.a)localObject3).start;
            m = ((n.a)localObject3).end + 1;
            if (n >= k)
            {
              if (n <= k) {
                break label1114;
              }
              localObject3 = paramString.substring(k, n);
              d.g.b.k.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              j = i + 1;
              a(localStringBuilder, (String)localObject3, i);
              i = j;
            }
          }
          label1114:
          for (;;)
          {
            localObject3 = paramString.substring(n, m);
            d.g.b.k.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
            ad.e(TAG, "topicStart:" + n + ", startIndex:" + k);
            j += 1;
            break label254;
            j = i;
            if (k < paramString.length())
            {
              paramString = paramString.substring(k, paramString.length());
              d.g.b.k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, paramString, i);
              j = i + 1;
            }
            if (!bt.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(LaV);
              localStringBuilder.append(LaX);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(199648);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              d.g.b.k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(LaY);
              localStringBuilder.append(LaW);
            }
            paramString = z.Jhz;
            paramString = String.format(Lba, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            d.g.b.k.g(paramString, "java.lang.String.format(format, *args)");
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
  
  public static String fWa()
  {
    return LaO;
  }
  
  public static String fWb()
  {
    return LaQ;
  }
  
  public static String fWc()
  {
    return VALUE;
  }
  
  public static String fWd()
  {
    return LaR;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "topic", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseXml$2$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    a(SpannableString paramSpannableString, m paramm, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseXml$3$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    b(SpannableString paramSpannableString, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */