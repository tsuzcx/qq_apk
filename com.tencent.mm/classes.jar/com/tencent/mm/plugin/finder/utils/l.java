package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import d.g.b.z;
import d.n.n;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.bqq;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "", "appendStyleAt", "atIndexs", "appendTopicValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "parseXml", "Landroid/text/SpannableString;", "defaultDesc", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "topic", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "clickExtra", "onAtClick", "Lkotlin/Function1;", "username", "plugin-finder_release"})
public final class l
{
  private static final String TAG = "Finder.FinderStyleUtil";
  private static final String VALUE = "value";
  private static final String rPA = "<topic>%s</topic>";
  public static final l rPB;
  private static final String rPl = "finder";
  private static final String rPm = "style";
  private static final String rPn = "valuecount";
  private static final String rPo = "topic";
  private static final String rPp = "at";
  private static final String rPq = "<finder>";
  private static final String rPr = "</finder>";
  private static final String rPs = "<style>";
  private static final String rPt = "</style>";
  private static final String rPu = "<at>";
  private static final String rPv = "</at>";
  private static final String rPw = "<![CDATA[%s]]>";
  private static final String rPx = "<valuecount>%d</valuecount>";
  private static final String rPy = "<value%d>";
  private static final String rPz = "</value%d>";
  
  static
  {
    AppMethodBeat.i(203629);
    rPB = new l();
    TAG = "Finder.FinderStyleUtil";
    rPl = "finder";
    rPm = "style";
    rPn = "valuecount";
    VALUE = "value";
    rPo = "topic";
    rPp = "at";
    rPq = "<" + rPl + '>';
    rPr = "</" + rPl + '>';
    rPs = "<" + rPm + '>';
    rPt = "</" + rPm + '>';
    rPu = "<" + rPp + '>';
    rPv = "</" + rPp + '>';
    rPw = "<![CDATA[%s]]>";
    rPx = "<" + rPn + ">%d</" + rPn + '>';
    rPy = "<" + VALUE + "%d>";
    rPz = "</" + VALUE + "%d>";
    rPA = "<" + rPo + ">%s</" + rPo + '>';
    AppMethodBeat.o(203629);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<m.c> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<amc> paramLinkedList1, d.g.a.m<? super String, ? super m.a, y> paramm, d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(203628);
    d.g.b.k.h(paramSpannableString, "defaultDesc");
    d.g.b.k.h(paramList, "topicInfoList");
    d.g.b.k.h(paramLinkedList, "atFinderContactList");
    d.g.b.k.h(paramLinkedList1, "mentionedUserList");
    d.g.b.k.h(paramm, "onTopicClick");
    d.g.b.k.h(paramb, "onAtClick");
    if (!bs.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czo())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czp()) {}
      }
    }
    else
    {
      AppMethodBeat.o(203628);
      return paramSpannableString;
    }
    Map localMap = bv.L(paramString, "finder");
    if (localMap == null)
    {
      AppMethodBeat.o(203628);
      return paramSpannableString;
    }
    int m = bs.getInt((String)localMap.get("." + rPl + '.' + rPn), -1);
    if (m < 0)
    {
      AppMethodBeat.o(203628);
      return paramSpannableString;
    }
    String str = bs.bG((String)localMap.get("." + rPl + '.' + rPm + '.' + rPp), "");
    d.g.b.k.g(str, "atIndexs");
    List localList = n.b((CharSequence)str, new String[] { "," });
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
      paramString = (String)localMap.get("." + rPl + '.' + VALUE + j + '.' + rPo);
      if (paramString == null)
      {
        n = localStringBuilder.toString().length();
        paramString = (String)localMap.get("." + rPl + '.' + VALUE + j);
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
          FinderContact localFinderContact = (FinderContact)localHashMap.get(((amc)paramLinkedList1.get(i)).username);
          if (localFinderContact != null)
          {
            i = localStringBuilder.toString().length();
            d.g.b.k.g(localFinderContact, "it");
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
        ac.e(TAG, "parseXml atFinderContactList.size:%s atIndexs:%s curAtIndex:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), str, Integer.valueOf(i) });
        continue;
        paramList.add(new m.c(localStringBuilder.toString().length(), paramString.length(), paramString));
        localStringBuilder.append(paramString);
      }
      ac.i(TAG, "parseXml, result:".concat(String.valueOf(localStringBuilder)));
      if ((bs.isNullOrNil(localStringBuilder.toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
      {
        AppMethodBeat.o(203628);
        return paramSpannableString;
      }
      paramLinkedList = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(ai.getContext(), (CharSequence)localStringBuilder.toString())));
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramSpannableString = (m.c)paramString.next();
        paramList = paramSpannableString.dol;
        i = paramSpannableString.dol.length();
        if (paramList == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(203628);
          throw paramString;
        }
        paramList = paramList.substring(1, i - 1);
        d.g.b.k.g(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramLinkedList1 = ai.getContext();
        d.g.b.k.g(paramLinkedList1, "MMApplicationContext.getContext()");
        i = paramLinkedList1.getResources().getColor(2131099773);
        paramLinkedList1 = ai.getContext();
        d.g.b.k.g(paramLinkedList1, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new g(paramList, i, paramLinkedList1.getResources().getColor(2131099658), false, (d.g.a.b)new l.a(paramLinkedList, paramm, paramLong)), paramSpannableString.start, paramSpannableString.start + paramSpannableString.count, 17);
      }
      paramList = ((Iterable)localObject).iterator();
      while (paramList.hasNext())
      {
        paramLinkedList1 = (b.a)paramList.next();
        paramString = paramLinkedList1.rOy;
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
        paramSpannableString = ai.getContext();
        d.g.b.k.g(paramSpannableString, "MMApplicationContext.getContext()");
        i = paramSpannableString.getResources().getColor(2131099773);
        paramSpannableString = ai.getContext();
        d.g.b.k.g(paramSpannableString, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new g(paramString, i, paramSpannableString.getResources().getColor(2131099658), false, (d.g.a.b)new l.b(paramLinkedList, paramb)), paramLinkedList1.start, paramLinkedList1.end, 17);
      }
      d.g.b.k.g(paramLinkedList, "ret");
      AppMethodBeat.o(203628);
      return paramLinkedList;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(203627);
    Object localObject = z.KUT;
    localObject = String.format(rPy, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    d.g.b.k.g(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = z.KUT;
    paramString = String.format(rPw, Arrays.copyOf(new Object[] { paramString }, 1));
    d.g.b.k.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = z.KUT;
    paramString = String.format(rPz, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    d.g.b.k.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(203627);
  }
  
  public static String c(String paramString, HashMap<String, bqq> paramHashMap)
  {
    AppMethodBeat.i(203626);
    d.g.b.k.h(paramString, "curDesc");
    d.g.b.k.h(paramHashMap, "atContactMap");
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203626);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czp())
    {
      localObject1 = b.rOw;
      localObject1 = (ArrayList)b.a(paramString, paramHashMap, null).second;
    }
    paramHashMap = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czo()) {
      paramHashMap = m.rPH;
    }
    for (paramHashMap = m.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, bqq>)localObject2)
    {
      localStringBuilder.append(rPq);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = z.KUT;
        paramHashMap = String.format(rPx, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        d.g.b.k.g(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        localStringBuilder.append(rPr);
        ac.d(TAG, "xml:".concat(String.valueOf(localStringBuilder)));
        paramString = localStringBuilder.toString();
        d.g.b.k.g(paramString, "xml.toString()");
        AppMethodBeat.o(203626);
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
          localObject3 = (m.c)paramHashMap.get(m);
          i1 = ((m.c)localObject3).start - 1;
          if (i1 != j) {}
        }
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          paramHashMap.remove(localObject3);
          n = ((m.c)localObject3).start - 1;
          m = ((m.c)localObject3).count + n + 2;
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
            Object localObject4 = z.KUT;
            localObject4 = String.format(rPy, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            d.g.b.k.g(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4);
            localObject4 = z.KUT;
            localObject4 = rPA;
            z localz = z.KUT;
            localObject3 = String.format(rPw, Arrays.copyOf(new Object[] { localObject3 }, 1));
            d.g.b.k.g(localObject3, "java.lang.String.format(format, *args)");
            localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
            d.g.b.k.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            localObject3 = z.KUT;
            localObject3 = String.format(rPz, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
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
          ac.e(TAG, "topicStart:" + n + ", startIndex:" + k);
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
            ac.e(TAG, "topicStart:" + n + ", startIndex:" + k);
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
            if (!bs.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(rPs);
              localStringBuilder.append(rPu);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(203626);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              d.g.b.k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(rPv);
              localStringBuilder.append(rPt);
            }
            paramString = z.KUT;
            paramString = String.format(rPx, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
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
  
  public static String cDc()
  {
    return rPl;
  }
  
  public static String cDd()
  {
    return rPn;
  }
  
  public static String cDe()
  {
    return VALUE;
  }
  
  public static String cDf()
  {
    return rPo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.l
 * JD-Core Version:    0.7.0.1
 */