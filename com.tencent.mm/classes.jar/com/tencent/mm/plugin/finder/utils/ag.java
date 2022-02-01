package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.tools.g;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.n.k;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil;", "", "()V", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "Lkotlin/collections/ArrayList;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "TAG", "", "TOPIC_CHAR", "", "getTOPIC_CHAR", "()C", "checkHasUncompleteTopic", "", "desc", "curSelPos", "", "enableSpan", "", "Landroid/text/SpannableString;", "enable", "enableColor", "enableBgColor", "disableColor", "disableBgColor", "extractSmileyInfo", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "curDesc", "getKvReportTopicContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "topic", "topicType", "feedCount", "", "getReportTopicContent", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isEndChar", "curChar", "(Ljava/lang/Character;)Z", "isFinishChar", "curIndex", "codePointSize", "totalLength", "isSplitChar", "isTopicStartChar", "jumpTopicUI", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;", "refObjectId", "tabType", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;Ljava/lang/Long;I)V", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "parseDesc", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onSetTopicSpan", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "start", "end", "setSpanTouch", "descTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "text", "Landroid/text/Spannable;", "SmileySpanInfo", "plugin-finder_release"})
public final class ag
{
  private static ArrayList<k> ACT;
  private static final char AFG = '#';
  public static final ag AFH;
  private static final String TAG = "Finder.FinderTopicUtil";
  
  static
  {
    AppMethodBeat.i(167932);
    AFH = new ag();
    TAG = "Finder.FinderTopicUtil";
    AFG = '#';
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    localObject = ((Iterable)com.tencent.mm.plugin.finder.storage.d.dVT()).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new k((String)((Iterator)localObject).next()));
    }
    ACT = localArrayList;
    AppMethodBeat.o(167932);
  }
  
  public static String A(FinderItem paramFinderItem)
  {
    int i = 0;
    AppMethodBeat.i(167926);
    p.k(paramFinderItem, "finderItem");
    Object localObject1 = paramFinderItem.getFeedObject().objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 != null)
      {
        localObject2 = ((bkp)localObject1).SVC;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label51;
        }
      }
    }
    localObject1 = "";
    label51:
    Object localObject2 = XmlParser.parseXml((String)localObject1, "finder", null);
    if (localObject2 == null)
    {
      AppMethodBeat.o(167926);
      return "[]";
    }
    localObject1 = new StringBuilder(".");
    Object localObject3 = ad.AFr;
    localObject1 = ((StringBuilder)localObject1).append(ad.edH()).append('.');
    localObject3 = ad.AFr;
    int j = Util.getInt((String)((Map)localObject2).get(ad.edI()), -1);
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
        localObject4 = ad.AFr;
        localObject3 = ((StringBuilder)localObject3).append(ad.edH()).append('.');
        localObject4 = ad.AFr;
        localObject3 = ((StringBuilder)localObject3).append(ad.edJ()).append(i).append('.');
        localObject4 = ad.AFr;
        localObject3 = (String)((Map)localObject2).get(ad.edK());
        if (Util.isNullOrNil((String)localObject3)) {}
      }
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("topic", localObject3);
        ((JSONObject)localObject4).put("type", 1);
        ((JSONObject)localObject4).put("count", 0);
        ((JSONArray)localObject1).put(localObject4);
        label294:
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
              paramFinderItem = paramFinderItem.city;
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
          p.j(paramFinderItem, "reportArray.toString()");
          AppMethodBeat.o(167926);
          return paramFinderItem;
        }
        catch (Exception paramFinderItem)
        {
          for (;;)
          {
            paramFinderItem = x.aazN;
          }
        }
      }
      catch (Exception localException)
      {
        break label294;
      }
    }
  }
  
  public static String B(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(167925);
    p.k(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject = new JSONObject();
      if (paramInt != 2) {
        break label140;
      }
      paramString = kotlin.n.n.b((CharSequence)paramString, new String[] { "·" });
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
      p.j(paramString, "reportArray.toString()");
      AppMethodBeat.o(167925);
      return paramString;
      label140:
      localJSONObject.put("topic", paramString);
    }
  }
  
  private static boolean I(char paramChar)
  {
    return paramChar == AFG;
  }
  
  public static List<ax> a(String paramString, ArrayList<e.a> paramArrayList, m<? super Integer, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(276107);
    p.k(paramString, "curDesc");
    p.k(paramArrayList, "atStringInfoList");
    List localList1 = (List)new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(276107);
      return localList1;
    }
    int j = 0;
    List localList2 = aFF(paramString);
    int i = -1;
    int k;
    Object localObject;
    if (j < paramString.length())
    {
      k = Character.charCount(paramString.codePointAt(j));
      localObject = ((Iterable)localList2).iterator();
      label92:
      if (((Iterator)localObject).hasNext())
      {
        ag.a locala = (ag.a)((Iterator)localObject).next();
        if (j != locala.start) {
          break label676;
        }
        k = locala.count;
      }
    }
    label259:
    label661:
    label676:
    for (;;)
    {
      break label92;
      char c = paramString.charAt(j);
      int m = paramString.length();
      if ((k == 1) && (I(c)) && (i < 0))
      {
        i = j;
        j += k;
        break;
      }
      int n;
      if ((k == 1) && (a(Character.valueOf(c))) && (i >= 0)) {
        if (j - i > 1)
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
          m = ((Number)com.tencent.mm.plugin.finder.storage.d.dUf().aSr()).intValue();
          localObject = paramString.substring(i + 1, j);
          p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          m = g.dq(m * 2, (String)localObject);
          if (m < 0) {
            break label432;
          }
          n = i + 1;
          localObject = paramArrayList.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            m = ((e.a)((Iterator)localObject).next()).start;
          } while ((n > m) || (j <= m));
        }
      }
      for (m = 1;; m = 0)
      {
        if (m == 0)
        {
          localObject = paramString.substring(n, j);
          p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localList1.add(new ax(n, j - n, (String)localObject));
          if (paramm != null) {
            paramm.invoke(Integer.valueOf(i), Integer.valueOf(j));
          }
          i = localList1.size();
          localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (i >= ((Number)com.tencent.mm.plugin.finder.storage.d.dTW().aSr()).intValue())
          {
            AppMethodBeat.o(276107);
            return localList1;
            m = -1;
            break label259;
          }
        }
        label432:
        if (I(c))
        {
          i = j;
          break;
        }
        i = -1;
        break;
        if (j + k == m)
        {
          m = 1;
          label465:
          if ((m == 0) || (i < 0)) {
            break label661;
          }
          n = i + 1;
          localObject = paramArrayList.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            m = ((e.a)((Iterator)localObject).next()).start;
          } while ((n > m) || (j <= m));
        }
        for (m = 1;; m = 0)
        {
          if (m == 0)
          {
            localObject = paramString.substring(n, j + k);
            p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localList1.add(new ax(n, j - n + k, (String)localObject));
            if (paramm != null) {
              paramm.invoke(Integer.valueOf(i), Integer.valueOf(j + k));
            }
            m = localList1.size();
            localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (m >= ((Number)com.tencent.mm.plugin.finder.storage.d.dTW().aSr()).intValue())
            {
              AppMethodBeat.o(276107);
              return localList1;
              m = 0;
              break label465;
              AppMethodBeat.o(276107);
              return localList1;
            }
          }
          break;
        }
      }
    }
  }
  
  public static void a(SpannableString paramSpannableString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(167930);
    p.k(paramSpannableString, "desc");
    if (Util.isNullOrNil((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(167930);
      return;
    }
    paramSpannableString = (o[])paramSpannableString.getSpans(0, paramSpannableString.length(), o.class);
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
          localObject.wEW = true;
          localContext = MMApplicationContext.getContext();
          p.j(localContext, "MMApplicationContext.getContext()");
          int k = localContext.getResources().getColor(b.c.link_color);
          localContext = MMApplicationContext.getContext();
          p.j(localContext, "MMApplicationContext.getContext()");
          localObject.setColor(k, localContext.getResources().getColor(b.c.BW_0_Alpha_0_2));
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
        localObject.wEW = false;
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localObject.setColor(localContext.getResources().getColor(b.c.normal_text_color), 0);
        i += 1;
      }
    }
    AppMethodBeat.o(167930);
  }
  
  public static void a(SpannableString paramSpannableString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    AppMethodBeat.i(276115);
    p.k(paramSpannableString, "desc");
    if (Util.isNullOrNil((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(276115);
      return;
    }
    paramSpannableString = (o[])paramSpannableString.getSpans(0, paramSpannableString.length(), o.class);
    if (paramSpannableString != null)
    {
      int i;
      if (paramSpannableString.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label127;
        }
        i = 1;
      }
      for (;;)
      {
        label69:
        if (i != 0)
        {
          Object localObject;
          if (paramBoolean)
          {
            paramInt4 = paramSpannableString.length;
            paramInt3 = j;
            for (;;)
            {
              if (paramInt3 < paramInt4)
              {
                localObject = paramSpannableString[paramInt3];
                localObject.wEW = true;
                localObject.setColor(paramInt1, paramInt2);
                paramInt3 += 1;
                continue;
                i = 0;
                break;
                label127:
                i = 0;
                break label69;
              }
            }
            AppMethodBeat.o(276115);
            return;
          }
          paramInt2 = paramSpannableString.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localObject = paramSpannableString[paramInt1];
            localObject.wEW = false;
            localObject.setColor(paramInt3, paramInt4);
            paramInt1 += 1;
          }
        }
      }
    }
    AppMethodBeat.o(276115);
  }
  
  public static void a(bfs parambfs, Long paramLong, int paramInt)
  {
    bfg localbfg = null;
    FinderItem localFinderItem = null;
    AppMethodBeat.i(276114);
    Intent localIntent = new Intent();
    Object localObject = parambfs;
    if (parambfs == null)
    {
      localObject = new bfs();
      ((bfs)localObject).SQv = 1;
    }
    localIntent.putExtra("key_topic_type", 4);
    int i;
    label93:
    long l;
    if (localObject != null)
    {
      parambfs = ((bfs)localObject).musicInfo;
      if (parambfs != null)
      {
        parambfs = parambfs.name;
        parambfs = (CharSequence)parambfs;
        if ((parambfs != null) && (parambfs.length() != 0)) {
          break label251;
        }
        i = 1;
        if (i != 0) {
          break label256;
        }
        parambfs = localFinderItem;
        if (localObject != null)
        {
          localbfg = ((bfs)localObject).musicInfo;
          parambfs = localFinderItem;
          if (localbfg != null) {
            parambfs = localbfg.name;
          }
        }
        localIntent.putExtra("key_topic_title", parambfs);
        if (localObject != null)
        {
          parambfs = (CharSequence)((bfs)localObject).groupId;
          if ((parambfs != null) && (parambfs.length() != 0)) {
            break label326;
          }
          i = 1;
          label165:
          if (i == 0) {
            break label339;
          }
        }
        if (paramLong == null) {
          break label331;
        }
        l = paramLong.longValue();
        label179:
        parambfs = com.tencent.mm.ae.d.Fw(l);
      }
    }
    for (;;)
    {
      localIntent.putExtra("KEY_FOLLOW_ID", parambfs);
      localIntent.putExtra("key_ref_object_id", (Serializable)paramLong);
      localIntent.putExtra("KEY_TAB_TYPE", paramInt);
      parambfs = a.ACH;
      parambfs = MMApplicationContext.getContext();
      p.j(parambfs, "MMApplicationContext.getContext()");
      a.O(parambfs, localIntent);
      AppMethodBeat.o(276114);
      return;
      parambfs = null;
      break;
      label251:
      i = 0;
      break label93;
      label256:
      parambfs = e.AmW;
      if (paramLong != null) {}
      for (l = paramLong.longValue();; l = 0L)
      {
        localFinderItem = com.tencent.mm.plugin.finder.storage.data.e.a.MH(l);
        parambfs = localbfg;
        if (localFinderItem != null) {
          parambfs = localFinderItem.getNickName();
        }
        localIntent.putExtra("key_topic_title", MMApplicationContext.getContext().getString(b.j.finder_follow_header_title, new Object[] { parambfs }));
        break;
      }
      label326:
      i = 0;
      break label165;
      label331:
      l = -1L;
      break label179;
      label339:
      localObject = ((bfs)localObject).groupId;
      parambfs = (bfs)localObject;
      if (localObject == null) {
        parambfs = "";
      }
    }
  }
  
  public static void a(String paramString, Long paramLong, c paramc)
  {
    AppMethodBeat.i(276112);
    p.k(paramString, "topic");
    p.k(paramc, "clickExtra");
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_topic_type", 1);
    ((Intent)localObject).putExtra("key_topic_title", paramString);
    ((Intent)localObject).putExtra("key_ref_object_id", (Serializable)paramLong);
    paramLong = paramc.aFX;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        aj.a locala = aj.Bnu;
        p.j(paramLong, "it");
        aj.a.a(paramLong, (Intent)localObject, 0L, 0, false, 124);
      }
    }
    paramLong = a.ACH;
    paramLong = MMApplicationContext.getContext();
    p.j(paramLong, "MMApplicationContext.getContext()");
    a.O(paramLong, (Intent)localObject);
    Log.i(TAG, "onclick topic:".concat(String.valueOf(paramString)));
    paramLong = paramc.aFX;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        localObject = aj.Bnu;
        p.j(paramLong, "context");
        paramLong = aj.a.fZ(paramLong);
        if (paramLong != null)
        {
          localObject = com.tencent.mm.plugin.finder.report.n.zWF;
          com.tencent.mm.plugin.finder.report.n.a(paramc.feedId, paramString, paramc.wXA, paramLong.xkX);
          paramString = aj.b(paramLong);
          if (paramString != null)
          {
            paramString.dpO().KN(paramc.feedId);
            AppMethodBeat.o(276112);
            return;
          }
          AppMethodBeat.o(276112);
          return;
        }
        AppMethodBeat.o(276112);
        return;
      }
    }
    AppMethodBeat.o(276112);
  }
  
  private static boolean a(Character paramCharacter)
  {
    AppMethodBeat.i(276108);
    if (paramCharacter == null)
    {
      AppMethodBeat.o(276108);
      return false;
    }
    char c = paramCharacter.charValue();
    paramCharacter = ((Iterable)ACT).iterator();
    while (paramCharacter.hasNext()) {
      if (((k)paramCharacter.next()).aY((CharSequence)String.valueOf(c)))
      {
        AppMethodBeat.o(276108);
        return true;
      }
    }
    AppMethodBeat.o(276108);
    return false;
  }
  
  private static List<ag.a> aFF(String paramString)
  {
    AppMethodBeat.i(167919);
    p.k(paramString, "curDesc");
    paramString = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString);
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramString.getSpans(0, paramString.length(), ImageSpan.class);
    List localList = (List)new ArrayList();
    p.j(arrayOfImageSpan, "smileySpanList");
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
        localList.add(new ag.a(j, i));
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
  
  public static char edT()
  {
    return AFG;
  }
  
  private static String ej(String paramString, int paramInt)
  {
    AppMethodBeat.i(167923);
    p.k(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject = new JSONObject();
      if (paramInt != 2) {
        break label160;
      }
      localObject = kotlin.n.n.b((CharSequence)paramString, new String[] { "·" });
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
      paramString = kotlin.n.n.l(B(paramString, paramInt, 0L), ",", ";", false) + ",,,";
      AppMethodBeat.o(167923);
      return paramString;
      label160:
      localJSONObject.put("topic", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ag
 * JD-Core Version:    0.7.0.1
 */