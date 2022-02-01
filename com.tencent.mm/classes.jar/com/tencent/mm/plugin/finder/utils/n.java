package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import d.g.a.m;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.bvx;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "", "appendStyleAt", "atIndexs", "appendTopicValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "parseXml", "Landroid/text/SpannableString;", "defaultDesc", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "onTopicClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "topic", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "clickExtra", "onAtClick", "Lkotlin/Function1;", "username", "plugin-finder_release"})
public final class n
{
  private static final String TAG = "Finder.FinderStyleUtil";
  private static final String VALUE = "value";
  private static final String sWX = "finder";
  private static final String sWY = "style";
  private static final String sWZ = "valuecount";
  private static final String sXa = "topic";
  private static final String sXb = "at";
  private static final String sXc = "<finder>";
  private static final String sXd = "</finder>";
  private static final String sXe = "<style>";
  private static final String sXf = "</style>";
  private static final String sXg = "<at>";
  private static final String sXh = "</at>";
  private static final String sXi = "<![CDATA[%s]]>";
  private static final String sXj = "<valuecount>%d</valuecount>";
  private static final String sXk = "<value%d>";
  private static final String sXl = "</value%d>";
  private static final String sXm = "<topic>%s</topic>";
  public static final n sXn;
  
  static
  {
    AppMethodBeat.i(205129);
    sXn = new n();
    TAG = "Finder.FinderStyleUtil";
    sWX = "finder";
    sWY = "style";
    sWZ = "valuecount";
    VALUE = "value";
    sXa = "topic";
    sXb = "at";
    sXc = "<" + sWX + '>';
    sXd = "</" + sWX + '>';
    sXe = "<" + sWY + '>';
    sXf = "</" + sWY + '>';
    sXg = "<" + sXb + '>';
    sXh = "</" + sXb + '>';
    sXi = "<![CDATA[%s]]>";
    sXj = "<" + sWZ + ">%d</" + sWZ + '>';
    sXk = "<" + VALUE + "%d>";
    sXl = "</" + VALUE + "%d>";
    sXm = "<" + sXa + ">%s</" + sXa + '>';
    AppMethodBeat.o(205129);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<o.c> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<apv> paramLinkedList1, m<? super String, ? super o.a, z> paramm, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(205128);
    p.h(paramSpannableString, "defaultDesc");
    p.h(paramList, "topicInfoList");
    p.h(paramLinkedList, "atFinderContactList");
    p.h(paramLinkedList1, "mentionedUserList");
    p.h(paramm, "onTopicClick");
    p.h(paramb, "onAtClick");
    if (!bu.isNullOrNil(paramString))
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cIc())
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (com.tencent.mm.plugin.finder.storage.b.cId()) {}
      }
    }
    else
    {
      AppMethodBeat.o(205128);
      return paramSpannableString;
    }
    Map localMap = bx.M(paramString, "finder");
    if (localMap == null)
    {
      AppMethodBeat.o(205128);
      return paramSpannableString;
    }
    int m = bu.getInt((String)localMap.get("." + sWX + '.' + sWZ), -1);
    if (m < 0)
    {
      AppMethodBeat.o(205128);
      return paramSpannableString;
    }
    String str = bu.bI((String)localMap.get("." + sWX + '.' + sWY + '.' + sXb), "");
    p.g(str, "atIndexs");
    List localList = d.n.n.b((CharSequence)str, new String[] { "," });
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramLinkedList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderContact)((Iterator)localObject2).next();
      if (!((Map)localHashMap).containsKey(((FinderContact)localObject3).username))
      {
        localObject1 = ((FinderContact)localObject3).username;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        localHashMap.put(paramString, localObject3);
      }
    }
    localObject2 = new StringBuilder("");
    Object localObject1 = new ArrayList();
    int i = 0;
    int j = 0;
    int n;
    if (j < m)
    {
      paramString = (String)localMap.get("." + sWX + '.' + VALUE + j + '.' + sXa);
      if (paramString == null)
      {
        n = ((StringBuilder)localObject2).toString().length();
        paramString = (String)localMap.get("." + sWX + '.' + VALUE + j);
        if (paramString != null) {
          break label1127;
        }
        paramString = "";
      }
    }
    label1127:
    for (;;)
    {
      ((StringBuilder)localObject2).append(paramString);
      int k;
      if (localList.contains(String.valueOf(j))) {
        if (paramLinkedList1.size() > i)
        {
          k = i + 1;
          localObject3 = ((apv)paramLinkedList1.get(i)).username;
          localObject3 = (FinderContact)((Map)localHashMap).get(localObject3);
          if (localObject3 != null)
          {
            ((ArrayList)localObject1).add(new b.a(n, ((StringBuilder)localObject2).toString().length(), paramString, (FinderContact)localObject3));
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
        ae.e(TAG, "parseXml atFinderContactList.size:%s atIndexs:%s curAtIndex:%s", new Object[] { Integer.valueOf(paramLinkedList.size()), str, Integer.valueOf(i) });
        continue;
        paramList.add(new o.c(((StringBuilder)localObject2).toString().length(), paramString.length(), paramString));
        ((StringBuilder)localObject2).append(paramString);
      }
      ae.i(TAG, "parseXml, result:".concat(String.valueOf(localObject2)));
      if ((bu.isNullOrNil(((StringBuilder)localObject2).toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
      {
        AppMethodBeat.o(205128);
        return paramSpannableString;
      }
      paramLinkedList = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)k.c(ak.getContext(), (CharSequence)((StringBuilder)localObject2).toString())));
      paramString = ((Iterable)paramList).iterator();
      while (paramString.hasNext())
      {
        paramSpannableString = (o.c)paramString.next();
        paramList = paramSpannableString.dBe;
        i = paramSpannableString.dBe.length();
        if (paramList == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(205128);
          throw paramString;
        }
        paramList = paramList.substring(1, i - 1);
        p.g(paramList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramLinkedList1 = ak.getContext();
        p.g(paramLinkedList1, "MMApplicationContext.getContext()");
        i = paramLinkedList1.getResources().getColor(2131099773);
        paramLinkedList1 = ak.getContext();
        p.g(paramLinkedList1, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new j(paramList, i, paramLinkedList1.getResources().getColor(2131099658), false, (d.g.a.b)new n.a(paramLinkedList, paramm, paramLong)), paramSpannableString.start, paramSpannableString.start + paramSpannableString.count, 17);
      }
      paramList = ((Iterable)localObject1).iterator();
      while (paramList.hasNext())
      {
        paramLinkedList1 = (b.a)paramList.next();
        paramString = paramLinkedList1.sWc;
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
        paramSpannableString = ak.getContext();
        p.g(paramSpannableString, "MMApplicationContext.getContext()");
        i = paramSpannableString.getResources().getColor(2131099773);
        paramSpannableString = ak.getContext();
        p.g(paramSpannableString, "MMApplicationContext.getContext()");
        paramLinkedList.setSpan(new j(paramString, i, paramSpannableString.getResources().getColor(2131099658), false, (d.g.a.b)new n.b(paramLinkedList, paramb)), paramLinkedList1.start, paramLinkedList1.end, 17);
      }
      p.g(paramLinkedList, "ret");
      AppMethodBeat.o(205128);
      return paramLinkedList;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(205127);
    Object localObject = ad.Njc;
    localObject = String.format(sXk, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = ad.Njc;
    paramString = String.format(sXi, Arrays.copyOf(new Object[] { paramString }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = ad.Njc;
    paramString = String.format(sXl, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(205127);
  }
  
  public static String c(String paramString, HashMap<String, bvx> paramHashMap)
  {
    AppMethodBeat.i(205126);
    p.h(paramString, "curDesc");
    p.h(paramHashMap, "atContactMap");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(205126);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cId())
    {
      localObject1 = b.sWa;
      localObject1 = (ArrayList)b.a(paramString, paramHashMap, null).second;
    }
    paramHashMap = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIc()) {
      paramHashMap = o.sXt;
    }
    for (paramHashMap = o.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, bvx>)localObject2)
    {
      localStringBuilder.append(sXc);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = ad.Njc;
        paramHashMap = String.format(sXj, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        p.g(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        localStringBuilder.append(sXd);
        ae.d(TAG, "xml:".concat(String.valueOf(localStringBuilder)));
        paramString = localStringBuilder.toString();
        p.g(paramString, "xml.toString()");
        AppMethodBeat.o(205126);
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
            Object localObject4 = ad.Njc;
            localObject4 = String.format(sXk, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4);
            localObject4 = ad.Njc;
            localObject4 = sXm;
            ad localad = ad.Njc;
            localObject3 = String.format(sXi, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            localObject3 = ad.Njc;
            localObject3 = String.format(sXl, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
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
          ae.e(TAG, "topicStart:" + n + ", startIndex:" + k);
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
            ae.e(TAG, "topicStart:" + n + ", startIndex:" + k);
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
            if (!bu.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(sXe);
              localStringBuilder.append(sXg);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(205126);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(sXh);
              localStringBuilder.append(sXf);
            }
            paramString = ad.Njc;
            paramString = String.format(sXj, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
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
  
  public static String cNZ()
  {
    return sWX;
  }
  
  public static String cOa()
  {
    return sWZ;
  }
  
  public static String cOb()
  {
    return VALUE;
  }
  
  public static String cOc()
  {
    return sXa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n
 * JD-Core Version:    0.7.0.1
 */