package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.cse;>;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TAG_VERSION", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "VERSION", "getVERSION", "version", "", "getVersion", "()I", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "appendStyleAt", "atIndexs", "appendTopicValue", "appendVersionValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "handleAt", "desc", "Landroid/text/SpannableString;", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onAtClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "username", "handleTopic", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "onTopicClick", "Lkotlin/Function2;", "topic", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "clickExtra", "parseDefatultDesc", "defaultDesc", "parseXml", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "plugin-finder_release"})
public final class ad
{
  public static final String AFa = "finder";
  public static final String AFb = "style";
  public static final String AFc = "valuecount";
  public static final String AFd = "topic";
  public static final String AFe = "at";
  private static final String AFf = "<finder>";
  private static final String AFg = "</finder>";
  private static final String AFh = "<style>";
  private static final String AFi = "</style>";
  private static final String AFj = "<at>";
  private static final String AFk = "</at>";
  private static final String AFl = "<![CDATA[%s]]>";
  private static final String AFm = "<valuecount>%d</valuecount>";
  private static final String AFn = "<value%d>";
  private static final String AFo = "</value%d>";
  private static final String AFp = "<topic>%s</topic>";
  private static final String AFq = "<version>%d</version>";
  public static final ad AFr;
  public static final String TAG = "Finder.FinderStyleUtil";
  public static final String VALUE = "value";
  public static final String VERSION = "version";
  private static final int version = 1;
  
  static
  {
    AppMethodBeat.i(284221);
    AFr = new ad();
    TAG = "Finder.FinderStyleUtil";
    version = 1;
    AFa = "finder";
    AFb = "style";
    AFc = "valuecount";
    VALUE = "value";
    AFd = "topic";
    AFe = "at";
    VERSION = "version";
    AFf = "<" + AFa + '>';
    AFg = "</" + AFa + '>';
    AFh = "<" + AFb + '>';
    AFi = "</" + AFb + '>';
    AFj = "<" + AFe + '>';
    AFk = "</" + AFe + '>';
    AFl = "<![CDATA[%s]]>";
    AFm = "<" + AFc + ">%d</" + AFc + '>';
    AFn = "<" + VALUE + "%d>";
    AFo = "</" + VALUE + "%d>";
    AFp = "<" + AFd + ">%s</" + AFd + '>';
    AFq = "<" + VERSION + ">%d</" + VERSION + '>';
    AppMethodBeat.o(284221);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, List<ax> paramList, final m<? super String, ? super c, x> paramm, final long paramLong)
  {
    AppMethodBeat.i(284220);
    if (Util.isNullOrNil(paramString))
    {
      paramString = ag.AFH;
      paramString = paramSpannableString.toString();
      p.j(paramString, "defaultDesc.toString()");
      paramString = ((Iterable)ag.a(paramString, new ArrayList(), null)).iterator();
      Object localObject;
      int i;
      while (paramString.hasNext())
      {
        localObject = (ax)paramString.next();
        int j = ((ax)localObject).start - 1;
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramList.add(new ax(i, ((ax)localObject).count + 1, "#" + ((ax)localObject).topic));
      }
      paramString = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramSpannableString.toString())));
      paramSpannableString = ((Iterable)paramList).iterator();
      while (paramSpannableString.hasNext())
      {
        paramList = (ax)paramSpannableString.next();
        localObject = paramList.topic;
        if (localObject == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(284220);
          throw paramString;
        }
        localObject = ((String)localObject).substring(1);
        p.j(localObject, "(this as java.lang.String).substring(startIndex)");
        Context localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        i = localContext.getResources().getColor(b.c.Link_80);
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        paramString.setSpan(new com.tencent.mm.plugin.finder.view.o((String)localObject, i, localContext.getResources().getColor(b.c.BW_0_Alpha_0_2), false, true, (b)new c(paramString, paramm, paramLong)), paramList.start, paramList.start + paramList.count, 17);
      }
      p.j(paramString, "ret");
      AppMethodBeat.o(284220);
      return paramString;
    }
    AppMethodBeat.o(284220);
    return paramSpannableString;
  }
  
  public static void a(final long paramLong, SpannableString paramSpannableString, List<ax> paramList, final m<? super String, ? super c, x> paramm)
  {
    AppMethodBeat.i(284217);
    final aa.d locald = new aa.d();
    Object localObject1 = h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    int i;
    Object localObject2;
    if (((ae)localObject1).dYT())
    {
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      i = ((Context)localObject1).getResources().getColor(b.c.FG_0);
      locald.aaBA = i;
      localObject1 = new aa.d();
      localObject2 = h.ae(ae.class);
      p.j(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)localObject2).dYT()) {
        break label238;
      }
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      i = ((Context)localObject2).getResources().getColor(b.c.transparent);
      label141:
      ((aa.d)localObject1).aaBA = i;
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label357;
      }
      localObject2 = (ax)paramList.next();
      Object localObject3 = ((ax)localObject2).topic;
      if (localObject3 == null)
      {
        paramSpannableString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(284217);
        throw paramSpannableString;
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        i = ((Context)localObject1).getResources().getColor(b.c.Link_80);
        break;
        label238:
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        i = ((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_2);
        break label141;
      }
      localObject3 = ((String)localObject3).substring(1);
      p.j(localObject3, "(this as java.lang.String).substring(startIndex)");
      localObject3 = new com.tencent.mm.plugin.finder.view.o((String)localObject3, locald.aaBA, ((aa.d)localObject1).aaBA, (b)new b(paramSpannableString, locald, (aa.d)localObject1, paramm, paramLong));
      i = ((ax)localObject2).start;
      int j = ((ax)localObject2).start;
      paramSpannableString.setSpan(localObject3, i, ((ax)localObject2).count + j, 17);
    }
    label357:
    AppMethodBeat.o(284217);
  }
  
  public static void a(SpannableString paramSpannableString, ArrayList<e.a> paramArrayList, final b<? super String, x> paramb)
  {
    AppMethodBeat.i(284219);
    final aa.d locald = new aa.d();
    Object localObject1 = h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    int i;
    Object localObject2;
    label138:
    label155:
    e.a locala;
    if (((ae)localObject1).dYT())
    {
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      i = ((Context)localObject1).getResources().getColor(b.c.FG_0);
      locald.aaBA = i;
      localObject1 = new aa.d();
      localObject2 = h.ae(ae.class);
      p.j(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (!((ae)localObject2).dYT()) {
        break label272;
      }
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      i = ((Context)localObject2).getResources().getColor(b.c.transparent);
      ((aa.d)localObject1).aaBA = i;
      localObject2 = ((Iterable)paramArrayList).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label300;
      }
      locala = (e.a)((Iterator)localObject2).next();
      paramArrayList = locala.ACW;
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
      paramSpannableString.setSpan(new com.tencent.mm.plugin.finder.view.o(paramArrayList, locald.aaBA, ((aa.d)localObject1).aaBA, (b)new a(paramSpannableString, locald, (aa.d)localObject1, paramb)), locala.start, locala.end, 17);
      break label155;
      localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      i = ((Context)localObject1).getResources().getColor(b.c.Link_80);
      break;
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      i = ((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_2);
      break label138;
      AppMethodBeat.o(284219);
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(284216);
    Object localObject = af.aaBG;
    localObject = String.format(AFn, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.j(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = af.aaBG;
    paramString = String.format(AFl, Arrays.copyOf(new Object[] { paramString }, 1));
    p.j(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = af.aaBG;
    paramString = String.format(AFo, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    p.j(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(284216);
  }
  
  public static String d(String paramString, HashMap<String, cse> paramHashMap)
  {
    AppMethodBeat.i(284215);
    p.k(paramString, "curDesc");
    p.k(paramHashMap, "atContactMap");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(284215);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = d.AjH;
    if (d.dTe())
    {
      localObject1 = e.ACV;
      localObject1 = (ArrayList)e.a(paramString, paramHashMap, null).My;
    }
    paramHashMap = d.AjH;
    if (d.dTd()) {
      paramHashMap = ag.AFH;
    }
    for (paramHashMap = ag.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, cse>)localObject2)
    {
      localStringBuilder.append(AFf);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = af.aaBG;
        paramHashMap = String.format(AFm, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        p.j(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        paramString = af.aaBG;
        paramString = String.format(AFq, Arrays.copyOf(new Object[] { Integer.valueOf(version) }, 1));
        p.j(paramString, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramString);
        localStringBuilder.append(AFg);
        Log.d(TAG, "xml:".concat(String.valueOf(localStringBuilder)));
        paramString = localStringBuilder.toString();
        p.j(paramString, "xml.toString()");
        AppMethodBeat.o(284215);
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
          localObject3 = (ax)paramHashMap.get(m);
          i1 = ((ax)localObject3).start - 1;
          if (i1 != j) {}
        }
      }
      for (;;)
      {
        Object localObject4;
        if (localObject3 != null)
        {
          paramHashMap.remove(localObject3);
          n = ((ax)localObject3).start - 1;
          m = ((ax)localObject3).count + n + 1;
          if (n >= k)
          {
            j = i;
            if (n > k)
            {
              localObject3 = paramString.substring(k, n);
              p.j(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, (String)localObject3, i);
              j = i + 1;
            }
            localObject3 = new StringBuilder();
            localObject4 = paramString.substring(n, m);
            p.j(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject3 = (String)localObject4 + "#";
            localObject4 = af.aaBG;
            localObject4 = String.format(AFn, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.j(localObject4, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject4);
            localObject4 = af.aaBG;
            localObject4 = AFp;
            af localaf = af.aaBG;
            localObject3 = String.format(AFl, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.j(localObject3, "java.lang.String.format(format, *args)");
            localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
            p.j(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            localObject3 = af.aaBG;
            localObject3 = String.format(AFo, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.j(localObject3, "java.lang.String.format(format, *args)");
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
          p.j(localObject3, "atContactList[atIndex]");
          localObject3 = (e.a)localObject3;
          i1 = ((e.a)localObject3).start;
          if (i1 != j) {}
        }
        for (;;)
        {
          if (localObject3 != null)
          {
            ((ArrayList)localObject1).remove(localObject3);
            n = ((e.a)localObject3).start;
            m = ((e.a)localObject3).end;
            if (n >= k)
            {
              if (n <= k) {
                break label1213;
              }
              localObject3 = paramString.substring(k, n);
              p.j(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
            p.j(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
              p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, paramString, i);
              j = i + 1;
            }
            if (!Util.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(AFh);
              localStringBuilder.append(AFj);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(284215);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(AFk);
              localStringBuilder.append(AFi);
            }
            paramString = af.aaBG;
            paramString = String.format(AFm, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            p.j(paramString, "java.lang.String.format(format, *args)");
            p.j(localStringBuilder.append(paramString), "xml.append(String.format(TAG_VALUE_COUNT, count))");
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
  
  public static String edH()
  {
    return AFa;
  }
  
  public static String edI()
  {
    return AFc;
  }
  
  public static String edJ()
  {
    return VALUE;
  }
  
  public static String edK()
  {
    return AFd;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$handleAt$1$1"})
  static final class a
    extends q
    implements b<String, x>
  {
    a(SpannableString paramSpannableString, aa.d paramd1, aa.d paramd2, b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "topic", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$handleTopic$1$1"})
  static final class b
    extends q
    implements b<String, x>
  {
    b(SpannableString paramSpannableString, aa.d paramd1, aa.d paramd2, m paramm, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "topic", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderStyleUtil$parseDefatultDesc$2$1"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ad
 * JD-Core Version:    0.7.0.1
 */