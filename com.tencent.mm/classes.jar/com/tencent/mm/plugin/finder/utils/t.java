package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.cjj;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TAG_VERSION", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "VERSION", "getVERSION", "version", "", "getVersion", "()I", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "appendStyleAt", "atIndexs", "appendTopicValue", "appendVersionValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "handleAt", "desc", "Landroid/text/SpannableString;", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onAtClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "username", "handleTopic", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "onTopicClick", "Lkotlin/Function2;", "topic", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "clickExtra", "parseDefatultDesc", "defaultDesc", "parseXml", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "plugin-finder_release"})
public final class t
{
  private static final String TAG = "Finder.FinderStyleUtil";
  private static final String VALUE = "value";
  private static final String VERSION = "version";
  private static final String vWI = "finder";
  private static final String vWJ = "style";
  private static final String vWK = "valuecount";
  private static final String vWL = "topic";
  private static final String vWM = "at";
  private static final String vWN = "<finder>";
  private static final String vWO = "</finder>";
  private static final String vWP = "<style>";
  private static final String vWQ = "</style>";
  private static final String vWR = "<at>";
  private static final String vWS = "</at>";
  private static final String vWT = "<![CDATA[%s]]>";
  private static final String vWU = "<valuecount>%d</valuecount>";
  private static final String vWV = "<value%d>";
  private static final String vWW = "</value%d>";
  private static final String vWX = "<topic>%s</topic>";
  private static final String vWY = "<version>%d</version>";
  public static final t vWZ;
  private static final int version = 1;
  
  static
  {
    AppMethodBeat.i(253533);
    vWZ = new t();
    TAG = "Finder.FinderStyleUtil";
    version = 1;
    vWI = "finder";
    vWJ = "style";
    vWK = "valuecount";
    VALUE = "value";
    vWL = "topic";
    vWM = "at";
    VERSION = "version";
    vWN = "<" + vWI + '>';
    vWO = "</" + vWI + '>';
    vWP = "<" + vWJ + '>';
    vWQ = "</" + vWJ + '>';
    vWR = "<" + vWM + '>';
    vWS = "</" + vWM + '>';
    vWT = "<![CDATA[%s]]>";
    vWU = "<" + vWK + ">%d</" + vWK + '>';
    vWV = "<" + VALUE + "%d>";
    vWW = "</" + VALUE + "%d>";
    vWX = "<" + vWL + ">%s</" + vWL + '>';
    vWY = "<" + VERSION + ">%d</" + VERSION + '>';
    AppMethodBeat.o(253533);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, long paramLong, List<w.c> paramList, LinkedList<FinderContact> paramLinkedList, LinkedList<ayq> paramLinkedList1, m<? super String, ? super w.a, x> paramm, b<? super String, x> paramb)
  {
    AppMethodBeat.i(253529);
    p.h(paramSpannableString, "defaultDesc");
    p.h(paramList, "topicInfoList");
    p.h(paramLinkedList, "atFinderContactList");
    p.h(paramLinkedList1, "mentionedUserList");
    p.h(paramm, "onTopicClick");
    p.h(paramb, "onAtClick");
    if (!Util.isNullOrNil(paramString))
    {
      paramLinkedList1 = c.vCb;
      if (!c.drN())
      {
        paramLinkedList1 = c.vCb;
        if (c.drO()) {}
      }
    }
    else
    {
      paramString = a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(253529);
      return paramString;
    }
    Map localMap = XmlParser.parseXml(paramString, "finder", null);
    if (localMap == null)
    {
      paramString = a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(253529);
      return paramString;
    }
    int m = Util.getInt((String)localMap.get("." + vWI + '.' + vWK), -1);
    if (m < 0)
    {
      paramString = a(paramString, paramSpannableString, paramList, paramm, paramLong);
      AppMethodBeat.o(253529);
      return paramString;
    }
    int n = Util.getInt((String)localMap.get("." + vWI + '.' + VERSION), 0);
    paramString = Util.nullAs((String)localMap.get("." + vWI + '.' + vWJ + '.' + vWM), "");
    p.g(paramString, "atIndexs");
    List localList = n.b((CharSequence)paramString, new String[] { "," });
    paramLinkedList1 = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FinderContact)((Iterator)localObject1).next();
      if (!((Map)paramLinkedList1).containsKey(((FinderContact)localObject2).username))
      {
        paramLinkedList = ((FinderContact)localObject2).username;
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        paramLinkedList1.put(paramString, localObject2);
      }
    }
    Object localObject2 = new StringBuilder("");
    localObject1 = new ArrayList();
    int i = 0;
    int j;
    if (i < m)
    {
      paramString = (String)localMap.get("." + vWI + '.' + VALUE + i + '.' + vWL);
      if (paramString == null)
      {
        j = ((StringBuilder)localObject2).toString().length();
        paramString = (String)localMap.get("." + vWI + '.' + VALUE + i);
        if (paramString != null) {
          break label1348;
        }
        paramString = "";
      }
    }
    label770:
    label825:
    label1348:
    for (;;)
    {
      int k;
      if ((localList.contains(String.valueOf(i))) && (!Util.isNullOrNil(paramString)))
      {
        paramLinkedList = n.j(paramString, " ", "_", false);
        if (paramLinkedList.length() > 2)
        {
          k = paramLinkedList.length();
          if (paramLinkedList == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(253529);
            throw paramString;
          }
          paramString = paramLinkedList.substring(1, k - 1);
          p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        for (;;)
        {
          paramLinkedList1 = paramString;
          if (paramLinkedList.length() <= 1) {
            break label770;
          }
          if ((!n.a((CharSequence)paramLinkedList, ' ')) && (!n.a((CharSequence)paramLinkedList, ' '))) {
            break label825;
          }
          k = paramLinkedList.length();
          if (paramLinkedList != null) {
            break;
          }
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(253529);
          throw paramString;
          paramString = paramLinkedList;
        }
        paramLinkedList = paramLinkedList.substring(0, k - 1);
        p.g(paramLinkedList, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        p.g(((StringBuilder)localObject2).append(paramLinkedList), "sb.append(text.substring(0, text.length - 1))");
        paramLinkedList1 = paramString;
        if (n <= 0) {
          ((StringBuilder)localObject2).append(" ");
        }
        ((ArrayList)localObject1).add(new d.a(j, ((StringBuilder)localObject2).toString().length(), paramLinkedList1, new FinderContact()));
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject2).append(paramLinkedList);
        paramString = paramLinkedList;
        if (paramLinkedList.length() > 2)
        {
          if (paramLinkedList == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(253529);
            throw paramString;
          }
          paramString = paramLinkedList.substring(1);
          p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        }
        paramLinkedList1 = paramString;
        break label770;
        paramLinkedList = w.vXp;
        paramLinkedList = w.a(paramString, new ArrayList(), null);
        int i1 = ((StringBuilder)localObject2).toString().length();
        paramLinkedList = ((Iterable)paramLinkedList).iterator();
        while (paramLinkedList.hasNext())
        {
          paramLinkedList1 = (w.c)paramLinkedList.next();
          k = paramLinkedList1.start + i1 - 1;
          j = k;
          if (k < 0) {
            j = 0;
          }
          paramList.add(new w.c(j, paramLinkedList1.count + 1, "#" + paramLinkedList1.dST));
        }
        p.g(((StringBuilder)localObject2).append(paramString), "sb.append(text)");
        continue;
        if (((CharSequence)n.trim((CharSequence)paramString).toString()).length() > 0) {
          j = 1;
        }
        for (;;)
        {
          if (j != 0)
          {
            paramLinkedList = n.j(paramString, " ", "", false);
            paramString = paramLinkedList;
            if (paramLinkedList.length() > 1)
            {
              j = paramLinkedList.length();
              if (paramLinkedList == null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(253529);
                throw paramString;
                j = 0;
              }
              else
              {
                paramString = paramLinkedList.substring(0, j - 1);
                p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              }
            }
            else
            {
              paramList.add(new w.c(((StringBuilder)localObject2).toString().length(), paramString.length(), paramString));
              ((StringBuilder)localObject2).append(paramString);
              if (n > 0) {
                break;
              }
              ((StringBuilder)localObject2).append(" ");
              break;
            }
          }
        }
        p.g(((StringBuilder)localObject2).append(paramString), "sb.append(topic)");
      }
      Log.i(TAG, "parseXml, version:" + n + ", result:" + localObject2);
      if ((Util.isNullOrNil(((StringBuilder)localObject2).toString())) || ((paramList.isEmpty()) && (localList.isEmpty())))
      {
        AppMethodBeat.o(253529);
        return paramSpannableString;
      }
      paramString = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)((StringBuilder)localObject2).toString())));
      p.g(paramString, "desc");
      a(paramLong, paramString, paramList, paramm);
      a(paramString, (ArrayList)localObject1, paramb);
      AppMethodBeat.o(253529);
      return paramString;
    }
  }
  
  private static SpannableString a(String paramString, SpannableString paramSpannableString, List<w.c> paramList, final m<? super String, ? super w.a, x> paramm, final long paramLong)
  {
    AppMethodBeat.i(253532);
    if (Util.isNullOrNil(paramString))
    {
      paramString = w.vXp;
      paramString = paramSpannableString.toString();
      p.g(paramString, "defaultDesc.toString()");
      paramString = ((Iterable)w.a(paramString, new ArrayList(), null)).iterator();
      Object localObject;
      int i;
      while (paramString.hasNext())
      {
        localObject = (w.c)paramString.next();
        int j = ((w.c)localObject).start - 1;
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramList.add(new w.c(i, ((w.c)localObject).count + 1, "#" + ((w.c)localObject).dST));
      }
      paramString = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramSpannableString.toString())));
      paramSpannableString = ((Iterable)paramList).iterator();
      while (paramSpannableString.hasNext())
      {
        paramList = (w.c)paramSpannableString.next();
        localObject = paramList.dST;
        if (localObject == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(253532);
          throw paramString;
        }
        localObject = ((String)localObject).substring(1);
        p.g(localObject, "(this as java.lang.String).substring(startIndex)");
        Context localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        i = localContext.getResources().getColor(2131099787);
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        paramString.setSpan(new com.tencent.mm.plugin.finder.view.l((String)localObject, i, localContext.getResources().getColor(2131099660), false, true, (b)new c(paramString, paramm, paramLong)), paramList.start, paramList.start + paramList.count, 17);
      }
      p.g(paramString, "ret");
      AppMethodBeat.o(253532);
      return paramString;
    }
    AppMethodBeat.o(253532);
    return paramSpannableString;
  }
  
  private static void a(final long paramLong, SpannableString paramSpannableString, List<w.c> paramList, final m<? super String, ? super w.a, x> paramm)
  {
    AppMethodBeat.i(253530);
    final z.d locald = new z.d();
    Object localObject1 = g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    int i;
    Object localObject2;
    if (((ad)localObject1).dxX())
    {
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      i = ((Context)localObject1).getResources().getColor(2131099746);
      locald.SYE = i;
      localObject1 = new z.d();
      localObject2 = g.af(ad.class);
      p.g(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)localObject2).dxX()) {
        break label238;
      }
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      i = ((Context)localObject2).getResources().getColor(2131101287);
      label141:
      ((z.d)localObject1).SYE = i;
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label357;
      }
      localObject2 = (w.c)paramList.next();
      Object localObject3 = ((w.c)localObject2).dST;
      if (localObject3 == null)
      {
        paramSpannableString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(253530);
        throw paramSpannableString;
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        i = ((Context)localObject1).getResources().getColor(2131099787);
        break;
        label238:
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        i = ((Context)localObject2).getResources().getColor(2131099660);
        break label141;
      }
      localObject3 = ((String)localObject3).substring(1);
      p.g(localObject3, "(this as java.lang.String).substring(startIndex)");
      localObject3 = new com.tencent.mm.plugin.finder.view.l((String)localObject3, locald.SYE, ((z.d)localObject1).SYE, (b)new b(paramSpannableString, locald, (z.d)localObject1, paramm, paramLong));
      i = ((w.c)localObject2).start;
      int j = ((w.c)localObject2).start;
      paramSpannableString.setSpan(localObject3, i, ((w.c)localObject2).count + j, 17);
    }
    label357:
    AppMethodBeat.o(253530);
  }
  
  private static void a(SpannableString paramSpannableString, ArrayList<d.a> paramArrayList, final b<? super String, x> paramb)
  {
    AppMethodBeat.i(253531);
    final z.d locald = new z.d();
    Object localObject1 = g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    int i;
    Object localObject2;
    label138:
    label155:
    d.a locala;
    if (((ad)localObject1).dxX())
    {
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      i = ((Context)localObject1).getResources().getColor(2131099746);
      locald.SYE = i;
      localObject1 = new z.d();
      localObject2 = g.af(ad.class);
      p.g(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ad)localObject2).dxX()) {
        break label272;
      }
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      i = ((Context)localObject2).getResources().getColor(2131101287);
      ((z.d)localObject1).SYE = i;
      localObject2 = ((Iterable)paramArrayList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label300;
      }
      locala = (d.a)((Iterator)localObject2).next();
      paramArrayList = locala.vVh;
      if (paramArrayList != null) {
        break label307;
      }
      paramArrayList = "";
    }
    label272:
    label300:
    label307:
    for (;;)
    {
      paramSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(paramArrayList, locald.SYE, ((z.d)localObject1).SYE, (b)new a(paramSpannableString, locald, (z.d)localObject1, paramb)), locala.start, locala.end, 17);
      break label155;
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      i = ((Context)localObject1).getResources().getColor(2131099787);
      break;
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      i = ((Context)localObject2).getResources().getColor(2131099660);
      break label138;
      AppMethodBeat.o(253531);
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(253528);
    Object localObject = ae.SYK;
    localObject = String.format(vWV, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = ae.SYK;
    paramString = String.format(vWT, Arrays.copyOf(new Object[] { paramString }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = ae.SYK;
    paramString = String.format(vWW, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.g(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(253528);
  }
  
  public static String c(String paramString, HashMap<String, cjj> paramHashMap)
  {
    AppMethodBeat.i(253527);
    p.h(paramString, "curDesc");
    p.h(paramHashMap, "atContactMap");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(253527);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = c.vCb;
    if (c.drO())
    {
      localObject1 = d.vVg;
      localObject1 = (ArrayList)d.a(paramString, paramHashMap, null).second;
    }
    paramHashMap = c.vCb;
    if (c.drN()) {
      paramHashMap = w.vXp;
    }
    for (paramHashMap = w.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, cjj>)localObject2)
    {
      localStringBuilder.append(vWN);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = ae.SYK;
        paramHashMap = String.format(vWU, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        p.g(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        paramString = ae.SYK;
        paramString = String.format(vWY, Arrays.copyOf(new Object[] { Integer.valueOf(version) }, 1));
        p.g(paramString, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramString);
        localStringBuilder.append(vWO);
        Log.d(TAG, "xml:".concat(String.valueOf(localStringBuilder)));
        paramString = localStringBuilder.toString();
        p.g(paramString, "xml.toString()");
        AppMethodBeat.o(253527);
        return paramString;
      }
      int i = 0;
      int j = 0;
      localObject2 = "";
      int k = 0;
      label296:
      int m;
      int n;
      label327:
      int i1;
      if (j < paramString.length()) {
        if (!paramHashMap.isEmpty())
        {
          m = 0;
          n = ((Collection)paramHashMap).size();
          if (m >= n) {
            break label1222;
          }
          localObject3 = (w.c)paramHashMap.get(m);
          i1 = ((w.c)localObject3).start - 1;
          if (i1 != j) {}
        }
      }
      for (;;)
      {
        Object localObject4;
        if (localObject3 != null)
        {
          paramHashMap.remove(localObject3);
          n = ((w.c)localObject3).start - 1;
          m = ((w.c)localObject3).count + n + 1;
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
            localObject3 = new StringBuilder();
            localObject4 = paramString.substring(n, m);
            p.g(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject3 = (String)localObject4 + "#";
            localObject4 = ae.SYK;
            localObject4 = String.format(vWV, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4);
            localObject4 = ae.SYK;
            localObject4 = vWX;
            ae localae = ae.SYK;
            localObject3 = String.format(vWT, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            localObject3 = ae.SYK;
            localObject3 = String.format(vWW, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            i = m;
            k = m;
            m = j + 1;
            j = i;
            i = m;
            break label296;
            if (i1 > j) {
              break label1222;
            }
            m += 1;
            break label327;
          }
          Log.e(TAG, "topicStart:" + n + ", startIndex:" + k);
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          m = 0;
          n = ((Collection)localObject1).size();
          label749:
          if (m >= n) {
            break label1216;
          }
          localObject3 = ((ArrayList)localObject1).get(m);
          p.g(localObject3, "atContactList[atIndex]");
          localObject3 = (d.a)localObject3;
          i1 = ((d.a)localObject3).start;
          if (i1 != j) {}
        }
        for (;;)
        {
          if (localObject3 != null)
          {
            ((ArrayList)localObject1).remove(localObject3);
            n = ((d.a)localObject3).start;
            m = ((d.a)localObject3).end;
            if (n >= k)
            {
              if (n <= k) {
                break label1213;
              }
              localObject3 = paramString.substring(k, n);
              p.g(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              j = i + 1;
              a(localStringBuilder, (String)localObject3, i);
              i = j;
            }
          }
          label1213:
          for (;;)
          {
            localObject3 = new StringBuilder();
            localObject4 = paramString.substring(n, m);
            p.g(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject3 = (String)localObject4 + " ";
            n = i + 1;
            a(localStringBuilder, (String)localObject3, i);
            localObject2 = (String)localObject2 + String.valueOf(n - 1) + ",";
            j = m;
            k = m;
            i = n;
            break label296;
            if (i1 > j) {
              break label1216;
            }
            m += 1;
            break label749;
            Log.e(TAG, "topicStart:" + n + ", startIndex:" + k);
            j += 1;
            break label296;
            j = i;
            if (k < paramString.length())
            {
              paramString = paramString.substring(k, paramString.length());
              p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, paramString, i);
              j = i + 1;
            }
            if (!Util.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(vWP);
              localStringBuilder.append(vWR);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(253527);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(vWS);
              localStringBuilder.append(vWQ);
            }
            paramString = ae.SYK;
            paramString = String.format(vWU, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.g(paramString, "java.lang.String.format(format, *args)");
            p.g(localStringBuilder.append(paramString), "xml.append(String.format(TAG_VALUE_COUNT, count))");
            break;
          }
          label1216:
          localObject3 = null;
        }
        label1222:
        localObject3 = null;
      }
    }
  }
  
  public static String dCl()
  {
    return vWI;
  }
  
  public static String dCm()
  {
    return vWK;
  }
  
  public static String dCn()
  {
    return VALUE;
  }
  
  public static String dCo()
  {
    return vWL;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$handleAt$1$1"})
  static final class a
    extends q
    implements b<String, x>
  {
    a(SpannableString paramSpannableString, z.d paramd1, z.d paramd2, b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "topic", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$handleTopic$1$1"})
  static final class b
    extends q
    implements b<String, x>
  {
    b(SpannableString paramSpannableString, z.d paramd1, z.d paramd2, m paramm, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "topic", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseDefatultDesc$2$1"})
  static final class c
    extends q
    implements b<String, x>
  {
    c(SpannableString paramSpannableString, m paramm, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.t
 * JD-Core Version:    0.7.0.1
 */