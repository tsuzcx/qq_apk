package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.tools.f;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil;", "", "()V", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "Lkotlin/collections/ArrayList;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "TAG", "", "TOPIC_CHAR", "", "getTOPIC_CHAR", "()C", "checkHasUncompleteTopic", "", "desc", "curSelPos", "", "enableSpan", "", "Landroid/text/SpannableString;", "enable", "enableColor", "enableBgColor", "disableColor", "disableBgColor", "extractSmileyInfo", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "curDesc", "getKvReportTopicContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "topic", "topicType", "feedCount", "", "getReportTopicContent", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isEndChar", "curChar", "(Ljava/lang/Character;)Z", "isFinishChar", "curIndex", "codePointSize", "totalLength", "isSplitChar", "isTopicStartChar", "jumpTopicUI", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;", "refObjectId", "tabType", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;Ljava/lang/Long;I)V", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;)V", "parseDesc", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onSetTopicSpan", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "start", "end", "setSpanTouch", "descTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "text", "Landroid/text/Spannable;", "ClickExtra", "SmileySpanInfo", "TopicStringInfo", "plugin-finder_release"})
public final class w
{
  private static final String TAG = "Finder.FinderTopicUtil";
  private static ArrayList<kotlin.n.k> vVe;
  private static final char vXo = '#';
  public static final w vXp;
  
  static
  {
    AppMethodBeat.i(167932);
    vXp = new w();
    TAG = "Finder.FinderTopicUtil";
    vXo = '#';
    ArrayList localArrayList = new ArrayList();
    Object localObject = c.vCb;
    localObject = ((Iterable)c.dvt()).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new kotlin.n.k((String)((Iterator)localObject).next()));
    }
    vVe = localArrayList;
    AppMethodBeat.o(167932);
  }
  
  private static boolean A(char paramChar)
  {
    return paramChar == vXo;
  }
  
  public static String a(cng paramcng)
  {
    int i = 0;
    AppMethodBeat.i(253552);
    p.h(paramcng, "megaVideo");
    Object localObject1 = paramcng.MtG;
    if (localObject1 != null)
    {
      localObject2 = ((cnl)localObject1).MtR;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = XmlParser.parseXml((String)localObject1, "finder", null);
    if (localObject2 == null)
    {
      AppMethodBeat.o(253552);
      return "[]";
    }
    localObject1 = new StringBuilder(".");
    Object localObject3 = t.vWZ;
    localObject1 = ((StringBuilder)localObject1).append(t.dCl()).append('.');
    localObject3 = t.vWZ;
    int j = Util.getInt((String)((Map)localObject2).get(t.dCm()), -1);
    if (j < 0)
    {
      AppMethodBeat.o(253552);
      return "[]";
    }
    localObject1 = new JSONArray();
    for (;;)
    {
      Object localObject4;
      if (i < j)
      {
        localObject3 = new StringBuilder(".");
        localObject4 = t.vWZ;
        localObject3 = ((StringBuilder)localObject3).append(t.dCl()).append('.');
        localObject4 = t.vWZ;
        localObject3 = ((StringBuilder)localObject3).append(t.dCn()).append(i).append('.');
        localObject4 = t.vWZ;
        localObject3 = (String)((Map)localObject2).get(t.dCo());
        if (Util.isNullOrNil((String)localObject3)) {}
      }
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("topic", localObject3);
        ((JSONObject)localObject4).put("type", 1);
        ((JSONObject)localObject4).put("count", 0);
        ((JSONArray)localObject1).put(localObject4);
        label282:
        i += 1;
        continue;
        paramcng = paramcng.MtG;
        if (paramcng != null)
        {
          paramcng = paramcng.MtS;
          if (paramcng != null)
          {
            paramcng = paramcng.fuK;
            if (paramcng == null) {}
          }
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("topic", paramcng);
          ((JSONObject)localObject2).put("type", 2);
          ((JSONObject)localObject2).put("count", 0);
          ((JSONArray)localObject1).put(localObject2);
          paramcng = ((JSONArray)localObject1).toString();
          p.g(paramcng, "reportArray.toString()");
          AppMethodBeat.o(253552);
          return paramcng;
        }
        catch (Exception paramcng)
        {
          for (;;)
          {
            paramcng = x.SXb;
          }
        }
      }
      catch (Exception localException)
      {
        break label282;
      }
    }
  }
  
  public static List<c> a(String paramString, ArrayList<d.a> paramArrayList, m<? super Integer, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(253550);
    p.h(paramString, "curDesc");
    p.h(paramArrayList, "atStringInfoList");
    List localList1 = (List)new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(253550);
      return localList1;
    }
    int j = 0;
    List localList2 = awk(paramString);
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
        w.b localb = (w.b)((Iterator)localObject).next();
        if (j != localb.start) {
          break label676;
        }
        k = localb.count;
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
      if ((k == 1) && (A(c)) && (i < 0))
      {
        i = j;
        j += k;
        break;
      }
      int n;
      if ((k == 1) && (a(Character.valueOf(c))) && (i >= 0)) {
        if (j - i > 1)
        {
          localObject = c.vCb;
          m = ((Number)c.dsN().value()).intValue();
          localObject = paramString.substring(i + 1, j);
          p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          m = f.dp(m * 2, (String)localObject);
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
            m = ((d.a)((Iterator)localObject).next()).start;
          } while ((n > m) || (j <= m));
        }
      }
      for (m = 1;; m = 0)
      {
        if (m == 0)
        {
          localObject = paramString.substring(n, j);
          p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localList1.add(new c(n, j - n, (String)localObject));
          if (paramm != null) {
            paramm.invoke(Integer.valueOf(i), Integer.valueOf(j));
          }
          i = localList1.size();
          localObject = c.vCb;
          if (i >= ((Number)c.dsC().value()).intValue())
          {
            AppMethodBeat.o(253550);
            return localList1;
            m = -1;
            break label259;
          }
        }
        label432:
        if (A(c))
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
            m = ((d.a)((Iterator)localObject).next()).start;
          } while ((n > m) || (j <= m));
        }
        for (m = 1;; m = 0)
        {
          if (m == 0)
          {
            localObject = paramString.substring(n, j + k);
            p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localList1.add(new c(n, j - n + k, (String)localObject));
            if (paramm != null) {
              paramm.invoke(Integer.valueOf(i), Integer.valueOf(j + k));
            }
            m = localList1.size();
            localObject = c.vCb;
            if (m >= ((Number)c.dsC().value()).intValue())
            {
              AppMethodBeat.o(253550);
              return localList1;
              m = 0;
              break label465;
              AppMethodBeat.o(253550);
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
    p.h(paramSpannableString, "desc");
    if (Util.isNullOrNil((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(167930);
      return;
    }
    paramSpannableString = (com.tencent.mm.plugin.finder.view.l[])paramSpannableString.getSpans(0, paramSpannableString.length(), com.tencent.mm.plugin.finder.view.l.class);
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
          localObject.sYU = true;
          localContext = MMApplicationContext.getContext();
          p.g(localContext, "MMApplicationContext.getContext()");
          int k = localContext.getResources().getColor(2131100685);
          localContext = MMApplicationContext.getContext();
          p.g(localContext, "MMApplicationContext.getContext()");
          localObject.setColor(k, localContext.getResources().getColor(2131099660));
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
        localObject.sYU = false;
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localObject.setColor(localContext.getResources().getColor(2131100904), 0);
        i += 1;
      }
    }
    AppMethodBeat.o(167930);
  }
  
  public static void a(SpannableString paramSpannableString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    AppMethodBeat.i(253554);
    p.h(paramSpannableString, "desc");
    if (Util.isNullOrNil((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(253554);
      return;
    }
    paramSpannableString = (com.tencent.mm.plugin.finder.view.l[])paramSpannableString.getSpans(0, paramSpannableString.length(), com.tencent.mm.plugin.finder.view.l.class);
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
                localObject.sYU = true;
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
            AppMethodBeat.o(253554);
            return;
          }
          paramInt2 = paramSpannableString.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localObject = paramSpannableString[paramInt1];
            localObject.sYU = false;
            localObject.setColor(paramInt3, paramInt4);
            paramInt1 += 1;
          }
        }
      }
    }
    AppMethodBeat.o(253554);
  }
  
  public static void a(azr paramazr, Long paramLong, int paramInt)
  {
    azk localazk = null;
    FinderItem localFinderItem = null;
    AppMethodBeat.i(253553);
    Intent localIntent = new Intent();
    Object localObject = paramazr;
    if (paramazr == null)
    {
      localObject = new azr();
      ((azr)localObject).LJw = 1;
    }
    localIntent.putExtra("key_topic_type", 4);
    int i;
    label93:
    long l;
    if (localObject != null)
    {
      paramazr = ((azr)localObject).musicInfo;
      if (paramazr != null)
      {
        paramazr = paramazr.name;
        paramazr = (CharSequence)paramazr;
        if ((paramazr != null) && (paramazr.length() != 0)) {
          break label251;
        }
        i = 1;
        if (i != 0) {
          break label256;
        }
        paramazr = localFinderItem;
        if (localObject != null)
        {
          localazk = ((azr)localObject).musicInfo;
          paramazr = localFinderItem;
          if (localazk != null) {
            paramazr = localazk.name;
          }
        }
        localIntent.putExtra("key_topic_title", paramazr);
        if (localObject != null)
        {
          paramazr = (CharSequence)((azr)localObject).groupId;
          if ((paramazr != null) && (paramazr.length() != 0)) {
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
        paramazr = d.zs(l);
      }
    }
    for (;;)
    {
      localIntent.putExtra("KEY_FOLLOW_ID", paramazr);
      localIntent.putExtra("key_ref_object_id", (Serializable)paramLong);
      localIntent.putExtra("KEY_TAB_TYPE", paramInt);
      paramazr = a.vUU;
      paramazr = MMApplicationContext.getContext();
      p.g(paramazr, "MMApplicationContext.getContext()");
      a.O(paramazr, localIntent);
      AppMethodBeat.o(253553);
      return;
      paramazr = null;
      break;
      label251:
      i = 0;
      break label93;
      label256:
      paramazr = e.vFX;
      if (paramLong != null) {}
      for (l = paramLong.longValue();; l = 0L)
      {
        localFinderItem = e.a.Fy(l);
        paramazr = localazk;
        if (localFinderItem != null) {
          paramazr = localFinderItem.getNickName();
        }
        localIntent.putExtra("key_topic_title", MMApplicationContext.getContext().getString(2131759788, new Object[] { paramazr }));
        break;
      }
      label326:
      i = 0;
      break label165;
      label331:
      l = -1L;
      break label179;
      label339:
      localObject = ((azr)localObject).groupId;
      paramazr = (azr)localObject;
      if (localObject == null) {
        paramazr = "";
      }
    }
  }
  
  public static void a(String paramString, Long paramLong, a parama)
  {
    AppMethodBeat.i(167928);
    p.h(paramString, "topic");
    p.h(parama, "clickExtra");
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_topic_type", 1);
    ((Intent)localObject).putExtra("key_topic_title", paramString);
    ((Intent)localObject).putExtra("key_ref_object_id", (Serializable)paramLong);
    paramLong = parama.aWF;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        FinderReporterUIC.a locala = FinderReporterUIC.wzC;
        p.g(paramLong, "it");
        FinderReporterUIC.a.a(paramLong, (Intent)localObject, 0L, 0, false, 124);
      }
    }
    paramLong = a.vUU;
    paramLong = MMApplicationContext.getContext();
    p.g(paramLong, "MMApplicationContext.getContext()");
    a.O(paramLong, (Intent)localObject);
    Log.i(TAG, "onclick topic:".concat(String.valueOf(paramString)));
    paramLong = parama.aWF;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        localObject = FinderReporterUIC.wzC;
        p.g(paramLong, "context");
        paramLong = FinderReporterUIC.a.fH(paramLong);
        if (paramLong != null)
        {
          localObject = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a(parama.feedId, paramString, parama.tvC, paramLong.tCE);
          paramString = FinderReporterUIC.b(paramLong);
          if (paramString != null)
          {
            paramString.cZR().Ey(parama.feedId);
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
  
  private static boolean a(Character paramCharacter)
  {
    AppMethodBeat.i(253551);
    if (paramCharacter == null)
    {
      AppMethodBeat.o(253551);
      return false;
    }
    char c = paramCharacter.charValue();
    paramCharacter = ((Iterable)vVe).iterator();
    while (paramCharacter.hasNext()) {
      if (((kotlin.n.k)paramCharacter.next()).aJ((CharSequence)String.valueOf(c)))
      {
        AppMethodBeat.o(253551);
        return true;
      }
    }
    AppMethodBeat.o(253551);
    return false;
  }
  
  private static List<w.b> awk(String paramString)
  {
    AppMethodBeat.i(167919);
    p.h(paramString, "curDesc");
    paramString = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)paramString);
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
        localList.add(new w.b(j, i));
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
  
  public static char dCx()
  {
    return vXo;
  }
  
  private static String dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(167923);
    p.h(paramString, "topic");
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
      paramString = n.j(z(paramString, paramInt, 0L), ",", ";", false) + ",,,";
      AppMethodBeat.o(167923);
      return paramString;
      label160:
      localJSONObject.put("topic", paramString);
    }
  }
  
  public static String z(FinderItem paramFinderItem)
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
        localObject2 = ((bdq)localObject1).LNs;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label53;
        }
      }
    }
    localObject1 = "";
    label53:
    Object localObject2 = XmlParser.parseXml((String)localObject1, "finder", null);
    if (localObject2 == null)
    {
      AppMethodBeat.o(167926);
      return "[]";
    }
    localObject1 = new StringBuilder(".");
    Object localObject3 = t.vWZ;
    localObject1 = ((StringBuilder)localObject1).append(t.dCl()).append('.');
    localObject3 = t.vWZ;
    int j = Util.getInt((String)((Map)localObject2).get(t.dCm()), -1);
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
        localObject4 = t.vWZ;
        localObject3 = ((StringBuilder)localObject3).append(t.dCl()).append('.');
        localObject4 = t.vWZ;
        localObject3 = ((StringBuilder)localObject3).append(t.dCn()).append(i).append('.');
        localObject4 = t.vWZ;
        localObject3 = (String)((Map)localObject2).get(t.dCo());
        if (Util.isNullOrNil((String)localObject3)) {}
      }
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("topic", localObject3);
        ((JSONObject)localObject4).put("type", 1);
        ((JSONObject)localObject4).put("count", 0);
        ((JSONArray)localObject1).put(localObject4);
        label298:
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
              paramFinderItem = paramFinderItem.fuK;
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
            paramFinderItem = x.SXb;
          }
        }
      }
      catch (Exception localException)
      {
        break label298;
      }
    }
  }
  
  public static String z(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(167925);
    p.h(paramString, "topic");
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
      p.g(paramString, "reportArray.toString()");
      AppMethodBeat.o(167925);
      return paramString;
      label140:
      localJSONObject.put("topic", paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$ClickExtra;", "", "feedId", "", "topicType", "", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(JILjava/lang/ref/WeakReference;)V", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getFeedId", "()J", "getTopicType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public WeakReference<Context> aWF;
    final long feedId;
    final int tvC;
    
    public a(long paramLong, int paramInt, WeakReference<Context> paramWeakReference)
    {
      this.feedId = paramLong;
      this.tvC = paramInt;
      this.aWF = paramWeakReference;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(253549);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.feedId != paramObject.feedId) || (this.tvC != paramObject.tvC) || (!p.j(this.aWF, paramObject.aWF))) {}
        }
      }
      else
      {
        AppMethodBeat.o(253549);
        return true;
      }
      AppMethodBeat.o(253549);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(253548);
      long l = this.feedId;
      int j = (int)(l ^ l >>> 32);
      int k = this.tvC;
      WeakReference localWeakReference = this.aWF;
      if (localWeakReference != null) {}
      for (int i = localWeakReference.hashCode();; i = 0)
      {
        AppMethodBeat.o(253548);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167910);
      String str = "ClickExtra(feedId=" + this.feedId + ", topicType=" + this.tvC + ", contextRef=" + this.aWF + ")";
      AppMethodBeat.o(167910);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "", "start", "", "count", "topic", "", "(IILjava/lang/String;)V", "getCount", "()I", "getStart", "getTopic", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class c
  {
    final int count;
    public final String dST;
    final int start;
    
    public c(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(167912);
      this.start = paramInt1;
      this.count = paramInt2;
      this.dST = paramString;
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
          if ((this.start != paramObject.start) || (this.count != paramObject.count) || (!p.j(this.dST, paramObject.dST))) {}
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
      String str = this.dST;
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
      String str = "TopicStringInfo(start=" + this.start + ", count=" + this.count + ", topic=" + this.dST + ")";
      AppMethodBeat.o(167913);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.w
 * JD-Core Version:    0.7.0.1
 */