package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.tools.f;
import d.g.a.m;
import d.l;
import d.n.n;
import d.y;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil;", "", "()V", "TAG", "", "TOPIC_CHAR", "", "getTOPIC_CHAR", "()C", "checkHasUncompleteTopic", "", "desc", "curSelPos", "", "enableSpan", "", "Landroid/text/SpannableString;", "enable", "extractSmileyInfo", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "curDesc", "getKvReportTopicContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "topic", "topicType", "feedCount", "", "getReportTopicContent", "isSplitChar", "curChar", "isTopicStartChar", "jumpTopicUI", "refObjectId", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "parseDesc", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atStringInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "Lkotlin/collections/ArrayList;", "onSetTopicSpan", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "start", "end", "setSpanTouch", "descTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "text", "Landroid/text/Spannable;", "ClickExtra", "SmileySpanInfo", "TopicStringInfo", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "Finder.FinderTopicUtil";
  private static final char qSG = '#';
  public static final h qSR;
  
  static
  {
    AppMethodBeat.i(167932);
    qSR = new h();
    TAG = "Finder.FinderTopicUtil";
    qSG = '#';
    AppMethodBeat.o(167932);
  }
  
  private static List<b> ZN(String paramString)
  {
    AppMethodBeat.i(167919);
    d.g.b.k.h(paramString, "curDesc");
    paramString = com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), (CharSequence)paramString);
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramString.getSpans(0, paramString.length(), ImageSpan.class);
    List localList = (List)new ArrayList();
    d.g.b.k.g(arrayOfImageSpan, "smileySpanList");
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
        localList.add(new b(j, i));
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
  
  public static List<c> a(String paramString, ArrayList<n.a> paramArrayList, m<? super Integer, ? super Integer, y> paramm)
  {
    AppMethodBeat.i(199654);
    d.g.b.k.h(paramString, "curDesc");
    d.g.b.k.h(paramArrayList, "atStringInfoList");
    List localList1 = (List)new ArrayList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(199654);
      return localList1;
    }
    List localList2 = ZN(paramString);
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
        b localb = (b)((Iterator)localObject).next();
        if (j != localb.start) {
          break label441;
        }
        k = localb.count;
      }
    }
    label153:
    label176:
    label438:
    label441:
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
          if (n == qSG)
          {
            m = 1;
            label193:
            if (m == 0) {
              break label438;
            }
            if (i < 0) {
              break label418;
            }
            if (j - i <= 1) {
              break label407;
            }
            localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
            m = com.tencent.mm.plugin.finder.storage.b.cpN();
            localObject = paramString.substring(i + 1, j);
            d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            m = f.cJ(m * 2, (String)localObject);
            label249:
            if (m < 0) {
              break label418;
            }
            n = i + 1;
            localObject = paramArrayList.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              m = ((n.a)((Iterator)localObject).next()).start;
            } while ((n > m) || (j < m));
          }
          for (m = 1;; m = 0)
          {
            if (m == 0)
            {
              localObject = paramString.substring(n, j);
              d.g.b.k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localList1.add(new c(n, j - n, (String)localObject));
              if (paramm != null) {
                paramm.n(Integer.valueOf(i), Integer.valueOf(j));
              }
              i = localList1.size();
              localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
              if (i >= com.tencent.mm.plugin.finder.storage.b.cpL())
              {
                AppMethodBeat.o(199654);
                return localList1;
                m = 0;
                break label193;
                m = -1;
                break label249;
              }
              i = -1;
              break;
            }
            i = j;
            break;
            AppMethodBeat.o(199654);
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
    d.g.b.k.h(paramSpannableString, "desc");
    if (bt.ai((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(167930);
      return;
    }
    paramSpannableString = (e[])paramSpannableString.getSpans(0, paramSpannableString.length(), e.class);
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
          localObject.qXU = true;
          localContext = aj.getContext();
          d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
          int k = localContext.getResources().getColor(2131100547);
          localContext = aj.getContext();
          d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
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
        localObject.qXU = false;
        localContext = aj.getContext();
        d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
        localObject.setColor(localContext.getResources().getColor(2131100711), 0);
        i += 1;
      }
    }
    AppMethodBeat.o(167930);
  }
  
  public static void a(String paramString, Long paramLong, a parama)
  {
    AppMethodBeat.i(167928);
    d.g.b.k.h(paramString, "topic");
    d.g.b.k.h(parama, "clickExtra");
    if (((j)g.ad(j.class)).showFinderEntry())
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_topic_type", 1);
      ((Intent)localObject).putExtra("key_topic_title", paramString);
      ((Intent)localObject).putExtra("key_ref_object_id", (Serializable)paramLong);
      paramLong = parama.aLG;
      if (paramLong != null)
      {
        paramLong = (Context)paramLong.get();
        if (paramLong != null)
        {
          FinderReporterUIC.a locala = FinderReporterUIC.Ljl;
          d.g.b.k.g(paramLong, "it");
          FinderReporterUIC.a.a(paramLong, (Intent)localObject, 0L, 0, false, 124);
        }
      }
      paramLong = a.qSb;
      paramLong = aj.getContext();
      d.g.b.k.g(paramLong, "MMApplicationContext.getContext()");
      a.F(paramLong, (Intent)localObject);
      ad.i(TAG, "onclick topic:".concat(String.valueOf(paramString)));
      paramLong = parama.aLG;
      if (paramLong != null)
      {
        paramLong = (Context)paramLong.get();
        if (paramLong != null)
        {
          localObject = FinderReporterUIC.Ljl;
          d.g.b.k.g(paramLong, "context");
          paramLong = FinderReporterUIC.a.lB(paramLong);
          if (paramLong != null)
          {
            localObject = com.tencent.mm.plugin.finder.report.b.qFq;
            com.tencent.mm.plugin.finder.report.b.a(parama.feedId, paramString, parama.qSS, paramLong.qqE);
            AppMethodBeat.o(167928);
            return;
          }
          AppMethodBeat.o(167928);
          return;
        }
      }
    }
    AppMethodBeat.o(167928);
  }
  
  private static String cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(167923);
    d.g.b.k.h(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject = new JSONObject();
      if (paramInt != 2) {
        break label160;
      }
      localObject = n.b((CharSequence)paramString, new String[] { "·" });
      if (localObject == null) {
        break label177;
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
      paramString = n.h(f(paramString, paramInt, 0L), ",", ";", false) + ",,,";
      AppMethodBeat.o(167923);
      return paramString;
      label160:
      localJSONObject.put("topic", paramString);
    }
  }
  
  public static char crR()
  {
    return qSG;
  }
  
  public static String f(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(167925);
    d.g.b.k.h(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject = new JSONObject();
      if (paramInt != 2) {
        break label140;
      }
      paramString = n.b((CharSequence)paramString, new String[] { "·" });
      if (paramString == null) {
        break label157;
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
      d.g.b.k.g(paramString, "reportArray.toString()");
      AppMethodBeat.o(167925);
      return paramString;
      label140:
      localJSONObject.put("topic", paramString);
    }
  }
  
  public static String l(FinderItem paramFinderItem)
  {
    int i = 0;
    AppMethodBeat.i(167926);
    d.g.b.k.h(paramFinderItem, "finderItem");
    Object localObject1 = paramFinderItem.getFeedObject().objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 != null)
      {
        localObject2 = ((alo)localObject1).DmM;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label54;
        }
      }
    }
    localObject1 = "";
    label54:
    Object localObject2 = bw.K((String)localObject1, "finder");
    if (localObject2 == null)
    {
      AppMethodBeat.o(167926);
      return "[]";
    }
    localObject1 = new StringBuilder(".");
    Object localObject3 = r.Lbe;
    localObject1 = ((StringBuilder)localObject1).append(r.fWa()).append('.');
    localObject3 = r.Lbe;
    int j = bt.getInt((String)((Map)localObject2).get(r.fWb()), -1);
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
        localObject4 = r.Lbe;
        localObject3 = ((StringBuilder)localObject3).append(r.fWa()).append('.');
        localObject4 = r.Lbe;
        localObject3 = ((StringBuilder)localObject3).append(r.fWc()).append(i).append('.');
        localObject4 = r.Lbe;
        localObject3 = (String)((Map)localObject2).get(r.fWd());
        if (bt.isNullOrNil((String)localObject3)) {}
      }
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("topic", localObject3);
        ((JSONObject)localObject4).put("type", 1);
        ((JSONObject)localObject4).put("count", 0);
        ((JSONArray)localObject1).put(localObject4);
        label303:
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
              paramFinderItem = paramFinderItem.evA;
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
          d.g.b.k.g(paramFinderItem, "reportArray.toString()");
          AppMethodBeat.o(167926);
          return paramFinderItem;
        }
        catch (Exception paramFinderItem)
        {
          for (;;)
          {
            paramFinderItem = y.JfV;
          }
        }
      }
      catch (Exception localException)
      {
        break label303;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "", "feedId", "", "topicType", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(JILjava/lang/ref/WeakReference;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getFeedId", "()J", "getTopicType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public WeakReference<Context> aLG;
    final long feedId;
    final int qSS;
    
    private a(long paramLong)
    {
      this.feedId = paramLong;
      this.qSS = 1;
      this.aLG = null;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199653);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.feedId != paramObject.feedId) || (this.qSS != paramObject.qSS) || (!d.g.b.k.g(this.aLG, paramObject.aLG))) {}
        }
      }
      else
      {
        AppMethodBeat.o(199653);
        return true;
      }
      AppMethodBeat.o(199653);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(199652);
      long l = this.feedId;
      int j = (int)(l ^ l >>> 32);
      int k = this.qSS;
      WeakReference localWeakReference = this.aLG;
      if (localWeakReference != null) {}
      for (int i = localWeakReference.hashCode();; i = 0)
      {
        AppMethodBeat.o(199652);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167910);
      String str = "ClickExtra(feedId=" + this.feedId + ", topicType=" + this.qSS + ", contextRef=" + this.aLG + ")";
      AppMethodBeat.o(167910);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "", "start", "", "count", "(II)V", "getCount", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    final int count;
    final int start;
    
    public b(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.count = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.start != paramObject.start) || (this.count != paramObject.count)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.start * 31 + this.count;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167911);
      String str = "SmileySpanInfo(start=" + this.start + ", count=" + this.count + ")";
      AppMethodBeat.o(167911);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "", "start", "", "count", "topic", "", "(IILjava/lang/String;)V", "getCount", "()I", "getStart", "getTopic", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class c
  {
    public final int count;
    public final String dqA;
    public final int start;
    
    public c(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(167912);
      this.start = paramInt1;
      this.count = paramInt2;
      this.dqA = paramString;
      AppMethodBeat.o(167912);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(167915);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.start != paramObject.start) || (this.count != paramObject.count) || (!d.g.b.k.g(this.dqA, paramObject.dqA))) {}
        }
      }
      else
      {
        AppMethodBeat.o(167915);
        return true;
      }
      AppMethodBeat.o(167915);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(167914);
      int j = this.start;
      int k = this.count;
      String str = this.dqA;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(167914);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167913);
      String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.dqA + ")";
      AppMethodBeat.o(167913);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.h
 * JD-Core Version:    0.7.0.1
 */