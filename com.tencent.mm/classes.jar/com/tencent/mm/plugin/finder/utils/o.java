package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.tools.f;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil;", "", "()V", "TAG", "", "TOPIC_CHAR", "", "getTOPIC_CHAR", "()C", "checkHasUncompleteTopic", "", "desc", "curSelPos", "", "enableSpan", "", "Landroid/text/SpannableString;", "enable", "extractSmileyInfo", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "curDesc", "getKvReportTopicContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "topic", "topicType", "feedCount", "", "getReportTopicContent", "isSplitChar", "curChar", "isTopicStartChar", "jumpTopicUI", "refObjectId", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "parseDesc", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atStringInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "Lkotlin/collections/ArrayList;", "onSetTopicSpan", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "start", "end", "setSpanTouch", "descTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "text", "Landroid/text/Spannable;", "ClickExtra", "SmileySpanInfo", "TopicStringInfo", "plugin-finder_release"})
public final class o
{
  private static final String TAG = "Finder.FinderTopicUtil";
  private static final char sXs = '#';
  public static final o sXt;
  
  static
  {
    AppMethodBeat.i(167932);
    sXt = new o();
    TAG = "Finder.FinderTopicUtil";
    sXs = '#';
    AppMethodBeat.o(167932);
  }
  
  public static String A(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(167925);
    p.h(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject = new JSONObject();
      if (paramInt != 2) {
        break label132;
      }
      paramString = d.n.n.b((CharSequence)paramString, new String[] { "·" });
      if (paramString == null) {
        break label148;
      }
      String str = (String)paramString.get(0);
      paramString = str;
      if (str != null) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        continue;
        paramString = "";
      }
    }
    localJSONObject.put("topic", paramString);
    for (;;)
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("count", paramLong);
      localJSONArray.put(localJSONObject);
      paramString = localJSONArray.toString();
      p.g(paramString, "reportArray.toString()");
      AppMethodBeat.o(167925);
      return paramString;
      label132:
      localJSONObject.put("topic", paramString);
    }
  }
  
  public static List<o.c> a(String paramString, ArrayList<b.a> paramArrayList, m<? super Integer, ? super Integer, z> paramm)
  {
    AppMethodBeat.i(205132);
    p.h(paramString, "curDesc");
    p.h(paramArrayList, "atStringInfoList");
    List localList1 = (List)new ArrayList();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(205132);
      return localList1;
    }
    List localList2 = ajR(paramString);
    int i = -1;
    int j = 0;
    int k;
    Object localObject;
    if (j < paramString.length())
    {
      k = Character.charCount(paramString.codePointAt(j));
      localObject = ((Iterable)localList2).iterator();
      label87:
      if (((Iterator)localObject).hasNext())
      {
        o.b localb = (o.b)((Iterator)localObject).next();
        if (j != localb.start) {
          break label459;
        }
        k = localb.count;
      }
    }
    label153:
    label176:
    label193:
    label456:
    label459:
    for (;;)
    {
      break label87;
      int n = paramString.charAt(j);
      int m;
      if (k == 1) {
        if (n == 10)
        {
          m = 1;
          if (m == 0) {
            break label176;
          }
          i = -1;
        }
      }
      for (;;)
      {
        j += k;
        break;
        m = 0;
        break label153;
        if (k == 1)
        {
          if (n == sXs)
          {
            m = 1;
            if (m == 0) {
              break label456;
            }
            if (i < 0) {
              break label436;
            }
            if (j - i <= 1) {
              break label425;
            }
            localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
            m = ((Number)com.tencent.mm.plugin.finder.storage.b.cIY().value()).intValue();
            localObject = paramString.substring(i + 1, j);
            p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            m = f.cU(m * 2, (String)localObject);
            if (m < 0) {
              break label436;
            }
            n = i + 1;
            localObject = paramArrayList.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              m = ((b.a)((Iterator)localObject).next()).start;
            } while ((n > m) || (j < m));
          }
          for (m = 1;; m = 0)
          {
            if (m == 0)
            {
              localObject = paramString.substring(n, j);
              p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localList1.add(new o.c(n, j - n, (String)localObject));
              if (paramm != null) {
                paramm.p(Integer.valueOf(i), Integer.valueOf(j));
              }
              i = localList1.size();
              localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
              if (i >= ((Number)com.tencent.mm.plugin.finder.storage.b.cIW().value()).intValue())
              {
                AppMethodBeat.o(205132);
                return localList1;
                m = 0;
                break label193;
                m = -1;
                break label258;
              }
              i = -1;
              break;
            }
            i = j;
            break;
            AppMethodBeat.o(205132);
            return localList1;
          }
        }
      }
    }
  }
  
  public static void a(SpannableString paramSpannableString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(167930);
    p.h(paramSpannableString, "desc");
    if (bu.ah((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(167930);
      return;
    }
    paramSpannableString = (j[])paramSpannableString.getSpans(0, paramSpannableString.length(), j.class);
    if ((paramSpannableString != null) && (paramSpannableString.length > 0))
    {
      Object localObject;
      Context localContext;
      if (paramBoolean)
      {
        j = paramSpannableString.length;
        while (i < j)
        {
          localObject = paramSpannableString[i];
          localObject.ryP = true;
          localContext = ak.getContext();
          p.g(localContext, "MMApplicationContext.getContext()");
          int k = localContext.getResources().getColor(2131100547);
          localContext = ak.getContext();
          p.g(localContext, "MMApplicationContext.getContext()");
          localObject.setColor(k, localContext.getResources().getColor(2131099658));
          i += 1;
        }
        AppMethodBeat.o(167930);
        return;
      }
      int j = paramSpannableString.length;
      i = 0;
      while (i < j)
      {
        localObject = paramSpannableString[i];
        localObject.ryP = false;
        localContext = ak.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localObject.setColor(localContext.getResources().getColor(2131100711), 0);
        i += 1;
      }
    }
    AppMethodBeat.o(167930);
  }
  
  public static void a(String paramString, Long paramLong, o.a parama)
  {
    AppMethodBeat.i(167928);
    p.h(paramString, "topic");
    p.h(parama, "clickExtra");
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_topic_type", 1);
    ((Intent)localObject).putExtra("key_topic_title", paramString);
    ((Intent)localObject).putExtra("key_ref_object_id", (Serializable)paramLong);
    paramLong = parama.aWN;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        FinderReporterUIC.a locala = FinderReporterUIC.tnG;
        p.g(paramLong, "it");
        FinderReporterUIC.a.a(paramLong, (Intent)localObject, 0L, 0, false, 124);
      }
    }
    paramLong = a.sVQ;
    paramLong = ak.getContext();
    p.g(paramLong, "MMApplicationContext.getContext()");
    a.J(paramLong, (Intent)localObject);
    ae.i(TAG, "onclick topic:".concat(String.valueOf(paramString)));
    paramLong = parama.aWN;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        localObject = FinderReporterUIC.tnG;
        p.g(paramLong, "context");
        paramLong = FinderReporterUIC.a.fc(paramLong);
        if (paramLong != null)
        {
          localObject = i.syT;
          i.a(parama.duw, paramString, parama.sXu, paramLong.sch);
          paramString = FinderReporterUIC.b(paramLong);
          if (paramString != null)
          {
            paramString.cAI().ws(parama.duw);
            AppMethodBeat.o(167928);
            return;
          }
          AppMethodBeat.o(167928);
          return;
        }
        AppMethodBeat.o(167928);
        return;
      }
    }
    AppMethodBeat.o(167928);
  }
  
  private static List<o.b> ajR(String paramString)
  {
    AppMethodBeat.i(167919);
    p.h(paramString, "curDesc");
    paramString = k.c(ak.getContext(), (CharSequence)paramString);
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramString.getSpans(0, paramString.length(), ImageSpan.class);
    List localList = (List)new ArrayList();
    p.g(arrayOfImageSpan, "smileySpanList");
    int m = arrayOfImageSpan.length;
    int k = 0;
    int j;
    int i;
    int n;
    if (k < m)
    {
      ImageSpan localImageSpan = arrayOfImageSpan[k];
      j = paramString.getSpanStart(localImageSpan);
      i = paramString.getSpanEnd(localImageSpan);
      n = paramString.getSpanFlags(localImageSpan);
      if ((n & 0x12) != 0) {
        i = i - j + 1;
      }
    }
    for (;;)
    {
      if ((j >= 0) && (i > 0)) {
        localList.add(new o.b(j, i));
      }
      k += 1;
      break;
      if ((n & 0x11) != 0)
      {
        i -= j;
      }
      else if ((n & 0x22) != 0)
      {
        i -= j;
        j += 1;
      }
      else if ((n & 0x21) != 0)
      {
        i = i - j - 1;
        j += 1;
        continue;
        AppMethodBeat.o(167919);
        return localList;
      }
      else
      {
        i = 0;
        j = -1;
      }
    }
  }
  
  public static char cOd()
  {
    return sXs;
  }
  
  private static String dA(String paramString, int paramInt)
  {
    AppMethodBeat.i(167923);
    p.h(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject = new JSONObject();
      if (paramInt != 2) {
        break label155;
      }
      localObject = d.n.n.b((CharSequence)paramString, new String[] { "·" });
      if (localObject == null) {
        break label171;
      }
      String str2 = (String)((List)localObject).get(0);
      localObject = str2;
      if (str2 != null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Object localObject;
        continue;
        String str1 = "";
      }
    }
    localJSONObject.put("topic", localObject);
    for (;;)
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("count", 0L);
      localJSONArray.put(localJSONObject);
      paramString = d.n.n.h(A(paramString, paramInt, 0L), ",", ";", false) + ",,,";
      AppMethodBeat.o(167923);
      return paramString;
      label155:
      localJSONObject.put("topic", paramString);
    }
  }
  
  public static String p(FinderItem paramFinderItem)
  {
    int i = 0;
    AppMethodBeat.i(167926);
    p.h(paramFinderItem, "finderItem");
    Object localObject1 = paramFinderItem.getFeedObject().objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 != null)
      {
        localObject2 = ((asu)localObject1).GJP;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label53;
        }
      }
    }
    localObject1 = "";
    label53:
    Object localObject2 = bx.M((String)localObject1, "finder");
    if (localObject2 == null)
    {
      AppMethodBeat.o(167926);
      return "[]";
    }
    localObject1 = new StringBuilder(".");
    Object localObject3 = n.sXn;
    localObject1 = ((StringBuilder)localObject1).append(n.cNZ()).append('.');
    localObject3 = n.sXn;
    int j = bu.getInt((String)((Map)localObject2).get(n.cOa()), -1);
    if (j < 0)
    {
      AppMethodBeat.o(167926);
      return "[]";
    }
    localObject1 = new JSONArray();
    for (;;)
    {
      Object localObject4;
      if (i < j)
      {
        localObject3 = new StringBuilder(".");
        localObject4 = n.sXn;
        localObject3 = ((StringBuilder)localObject3).append(n.cNZ()).append('.');
        localObject4 = n.sXn;
        localObject3 = ((StringBuilder)localObject3).append(n.cOb()).append(i).append('.');
        localObject4 = n.sXn;
        localObject3 = (String)((Map)localObject2).get(n.cOc());
        if (bu.isNullOrNil((String)localObject3)) {}
      }
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("topic", localObject3);
        ((JSONObject)localObject4).put("type", 1);
        ((JSONObject)localObject4).put("count", 0);
        ((JSONArray)localObject1).put(localObject4);
        label299:
        i += 1;
        continue;
        paramFinderItem = paramFinderItem.getFeedObject();
        if (paramFinderItem != null)
        {
          paramFinderItem = paramFinderItem.objectDesc;
          if (paramFinderItem != null)
          {
            paramFinderItem = paramFinderItem.location;
            if (paramFinderItem != null)
            {
              paramFinderItem = paramFinderItem.eRg;
              if (paramFinderItem == null) {}
            }
          }
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("topic", paramFinderItem);
          ((JSONObject)localObject2).put("type", 2);
          ((JSONObject)localObject2).put("count", 0);
          ((JSONArray)localObject1).put(localObject2);
          paramFinderItem = ((JSONArray)localObject1).toString();
          p.g(paramFinderItem, "reportArray.toString()");
          AppMethodBeat.o(167926);
          return paramFinderItem;
        }
        catch (Exception paramFinderItem)
        {
          for (;;)
          {
            paramFinderItem = z.Nhr;
          }
        }
      }
      catch (Exception localException)
      {
        break label299;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.o
 * JD-Core Version:    0.7.0.1
 */