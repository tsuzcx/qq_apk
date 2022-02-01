package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bxs;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil;", "", "()V", "END_CHARS_REG", "Ljava/util/ArrayList;", "Lkotlin/text/Regex;", "Lkotlin/collections/ArrayList;", "getEND_CHARS_REG", "()Ljava/util/ArrayList;", "setEND_CHARS_REG", "(Ljava/util/ArrayList;)V", "TAG", "", "TOPIC_CHAR", "", "getTOPIC_CHAR", "()C", "checkHasUncompleteTopic", "", "desc", "curSelPos", "", "enableSpan", "", "Landroid/text/SpannableString;", "enable", "enableColor", "enableBgColor", "disableColor", "disableBgColor", "shadowRadius", "", "extractSmileyInfo", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$SmileySpanInfo;", "curDesc", "getKvReportTopicContent", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "topic", "topicType", "feedCount", "", "getReportTopicContent", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isEndChar", "curChar", "(Ljava/lang/Character;)Z", "isFinishChar", "curIndex", "codePointSize", "totalLength", "isSplitChar", "isTopicStartChar", "jumpQQMusicFollowUI", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "refObjectId", "tabType", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;Ljava/lang/Long;I)V", "jumpTopicUI", "context", "Landroid/content/Context;", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderObjectBGMInfo;Ljava/lang/Long;I)V", "clickExtra", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/plugin/finder/utils/ClickExtra;)V", "parseDesc", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onSetTopicSpan", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "start", "end", "setSpanTouch", "descTv", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "text", "Landroid/text/Spannable;", "SmileySpanInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
{
  private static ArrayList<k> Ggb;
  public static final as GiG;
  private static final char GiH;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167932);
    GiG = new as();
    TAG = "Finder.FinderTopicUtil";
    GiH = '#';
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    localObject = ((Iterable)com.tencent.mm.plugin.finder.storage.d.eUC()).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new k((String)((Iterator)localObject).next()));
    }
    Ggb = localArrayList;
    AppMethodBeat.o(167932);
  }
  
  private static boolean B(char paramChar)
  {
    return paramChar == GiH;
  }
  
  public static String C(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(167925);
    s.u(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if (paramInt != 2) {
          continue;
        }
        paramString = n.b((CharSequence)paramString, new String[] { "·" });
        if (paramString != null) {
          continue;
        }
        paramString = "";
        localJSONObject.put("topic", paramString);
        localJSONObject.put("type", paramInt);
        localJSONObject.put("count", paramLong);
        localJSONArray.put(localJSONObject);
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        String str;
        continue;
      }
      paramString = localJSONArray.toString();
      s.s(paramString, "reportArray.toString()");
      AppMethodBeat.o(167925);
      return paramString;
      str = (String)paramString.get(0);
      paramString = str;
      if (str == null)
      {
        paramString = "";
        continue;
        localJSONObject.put("topic", paramString);
      }
    }
  }
  
  public static String F(FinderItem paramFinderItem)
  {
    int i = 0;
    AppMethodBeat.i(167926);
    s.u(paramFinderItem, "finderItem");
    Object localObject1 = paramFinderItem.getFeedObject().objectDesc;
    if (localObject1 == null) {
      localObject1 = "";
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = XmlParser.parseXml((String)localObject1, "finder", null);
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(167926);
      return "[]";
      localObject1 = ((FinderObjectDesc)localObject1).topic;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((bxs)localObject1).aagD;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    localObject1 = new StringBuilder(".");
    Object localObject3 = ao.GhZ;
    localObject1 = ((StringBuilder)localObject1).append(ao.ffz()).append('.');
    localObject3 = ao.GhZ;
    int k = Util.getInt((String)((Map)localObject2).get(ao.ffA()), -1);
    if (k < 0)
    {
      AppMethodBeat.o(167926);
      return "[]";
    }
    localObject1 = new JSONArray();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localObject3 = new StringBuilder(".");
      Object localObject4 = ao.GhZ;
      localObject3 = ((StringBuilder)localObject3).append(ao.ffz()).append('.');
      localObject4 = ao.GhZ;
      localObject3 = ((StringBuilder)localObject3).append(ao.ffB()).append(i).append('.');
      localObject4 = ao.GhZ;
      localObject3 = (String)((Map)localObject2).get(ao.ffC());
      if (!Util.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("topic", localObject3);
        ((JSONObject)localObject4).put("type", 1);
        ((JSONObject)localObject4).put("count", 0);
        ((JSONArray)localObject1).put(localObject4);
        label327:
        i = j;
        if (j < k) {
          continue;
        }
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
          s.s(paramFinderItem, "reportArray.toString()");
          AppMethodBeat.o(167926);
          return paramFinderItem;
        }
        catch (Exception paramFinderItem)
        {
          for (;;)
          {
            paramFinderItem = ah.aiuX;
          }
        }
      }
      catch (Exception localException)
      {
        break label327;
      }
    }
  }
  
  public static List<bo> a(String paramString, ArrayList<h.a> paramArrayList, m<? super Integer, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(332984);
    s.u(paramString, "curDesc");
    s.u(paramArrayList, "atStringInfoList");
    List localList1 = (List)new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(332984);
      return localList1;
    }
    int j = 0;
    List localList2 = aBG(paramString);
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
        as.a locala = (as.a)((Iterator)localObject).next();
        if (j != locala.start) {
          break label716;
        }
        k = locala.count;
      }
    }
    label259:
    label276:
    label318:
    label450:
    label452:
    label710:
    label716:
    for (;;)
    {
      break label92;
      char c = paramString.charAt(j);
      int m = paramString.length();
      if ((k == 1) && (B(c)) && (i < 0))
      {
        i = j;
        j += k;
        break;
      }
      int n;
      if ((k == 1) && (a(Character.valueOf(c))) && (i >= 0)) {
        if (j - i > 1)
        {
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          m = ((Number)com.tencent.mm.plugin.finder.storage.d.eSy().bmg()).intValue();
          localObject = paramString.substring(i + 1, j);
          s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          m = g.ej(m * 2, (String)localObject);
          if (m < 0) {
            break label452;
          }
          n = i + 1;
          localObject = paramArrayList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label710;
          }
          m = ((h.a)((Iterator)localObject).next()).start;
          if (n > m) {
            break label446;
          }
          if (m >= j) {
            break label440;
          }
          m = 1;
          if (m == 0) {
            break label450;
          }
        }
      }
      for (m = 1;; m = 0)
      {
        if (m == 0)
        {
          localObject = paramString.substring(n, j);
          s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          localList1.add(new bo(n, j - n, (String)localObject));
          if (paramm != null) {
            paramm.invoke(Integer.valueOf(i), Integer.valueOf(j));
          }
          i = localList1.size();
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (i >= ((Number)com.tencent.mm.plugin.finder.storage.d.eSo().bmg()).intValue())
          {
            AppMethodBeat.o(332984);
            return localList1;
            m = -1;
            break label259;
            m = 0;
            break label318;
            m = 0;
            break label318;
            break label276;
          }
        }
        if (B(c))
        {
          i = j;
          break;
        }
        i = -1;
        break;
        if (j + k == m)
        {
          m = 1;
          label485:
          if ((m == 0) || (i < 0)) {
            break label701;
          }
          n = i + 1;
          localObject = paramArrayList.iterator();
          label507:
          if (!((Iterator)localObject).hasNext()) {
            break label704;
          }
          m = ((h.a)((Iterator)localObject).next()).start;
          if (n > m) {
            break label686;
          }
          if (m >= j) {
            break label680;
          }
          m = 1;
          if (m == 0) {
            break label690;
          }
        }
        for (m = 1;; m = 0)
        {
          if (m == 0)
          {
            localObject = paramString.substring(n, j + k);
            s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localList1.add(new bo(n, j - n + k, (String)localObject));
            if (paramm != null) {
              paramm.invoke(Integer.valueOf(i), Integer.valueOf(j + k));
            }
            m = localList1.size();
            localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (m >= ((Number)com.tencent.mm.plugin.finder.storage.d.eSo().bmg()).intValue())
            {
              AppMethodBeat.o(332984);
              return localList1;
              m = 0;
              break label485;
              m = 0;
              break label549;
              m = 0;
              break label549;
              break label507;
              AppMethodBeat.o(332984);
              return localList1;
            }
          }
          break;
        }
      }
    }
  }
  
  public static void a(Context paramContext, bqz parambqz, Long paramLong, int paramInt)
  {
    bqj localbqj = null;
    Object localObject2 = null;
    AppMethodBeat.i(333049);
    s.u(paramContext, "context");
    Intent localIntent = new Intent();
    Object localObject1 = parambqz;
    if (parambqz == null)
    {
      localObject1 = new bqz();
      ((bqz)localObject1).ZZa = 1;
    }
    localIntent.putExtra("key_topic_type", 4);
    int i;
    label88:
    label101:
    long l;
    if (localObject1 == null)
    {
      parambqz = null;
      parambqz = (CharSequence)parambqz;
      if ((parambqz != null) && (parambqz.length() != 0)) {
        break label233;
      }
      i = 1;
      if (i != 0) {
        break label263;
      }
      if (localObject1 != null) {
        break label239;
      }
      parambqz = localObject2;
      localIntent.putExtra("key_topic_title", parambqz);
      if (localObject1 != null)
      {
        parambqz = (CharSequence)((bqz)localObject1).groupId;
        if ((parambqz != null) && (parambqz.length() != 0)) {
          break label333;
        }
        i = 1;
        label141:
        if (i == 0) {
          break label348;
        }
      }
      if (paramLong != null) {
        break label339;
      }
      l = -1L;
      label155:
      parambqz = com.tencent.mm.ae.d.hF(l);
    }
    for (;;)
    {
      localIntent.putExtra("KEY_FOLLOW_ID", parambqz);
      localIntent.putExtra("key_ref_object_id", (Serializable)paramLong);
      localIntent.putExtra("KEY_TAB_TYPE", paramInt);
      a.GfO.A(paramContext, localIntent);
      AppMethodBeat.o(333049);
      return;
      parambqz = ((bqz)localObject1).musicInfo;
      if (parambqz == null)
      {
        parambqz = null;
        break;
      }
      parambqz = parambqz.name;
      break;
      label233:
      i = 0;
      break label88;
      label239:
      localbqj = ((bqz)localObject1).musicInfo;
      parambqz = localObject2;
      if (localbqj == null) {
        break label101;
      }
      parambqz = localbqj.name;
      break label101;
      label263:
      parambqz = e.FMN;
      if (paramLong == null)
      {
        l = 0L;
        label274:
        parambqz = e.a.jn(l);
        if (parambqz != null) {
          break label325;
        }
      }
      label325:
      for (parambqz = localbqj;; parambqz = parambqz.getNickName())
      {
        localIntent.putExtra("key_topic_title", MMApplicationContext.getContext().getString(e.h.finder_follow_header_title, new Object[] { parambqz }));
        break;
        l = paramLong.longValue();
        break label274;
      }
      label333:
      i = 0;
      break label141;
      label339:
      l = paramLong.longValue();
      break label155;
      label348:
      localObject1 = ((bqz)localObject1).groupId;
      parambqz = (bqz)localObject1;
      if (localObject1 == null) {
        parambqz = "";
      }
    }
  }
  
  public static void a(SpannableString paramSpannableString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    int j = 0;
    AppMethodBeat.i(333053);
    s.u(paramSpannableString, "desc");
    if (Util.isNullOrNil((CharSequence)paramSpannableString))
    {
      AppMethodBeat.o(333053);
      return;
    }
    paramSpannableString = (q[])paramSpannableString.getSpans(0, paramSpannableString.length(), q.class);
    if (paramSpannableString != null)
    {
      int i;
      if (paramSpannableString.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label134;
        }
        i = 1;
      }
      label134:
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
                localObject.Abi = true;
                localObject.setColor(paramInt1, paramInt2);
                localObject.shadowRadius = paramFloat;
                paramInt3 += 1;
                continue;
                i = 0;
                break;
                i = 0;
                break label69;
              }
            }
            AppMethodBeat.o(333053);
            return;
          }
          paramInt2 = paramSpannableString.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            localObject = paramSpannableString[paramInt1];
            localObject.Abi = false;
            localObject.setColor(paramInt3, paramInt4);
            localObject.shadowRadius = 0.0F;
            paramInt1 += 1;
          }
        }
      }
    }
    AppMethodBeat.o(333053);
  }
  
  public static void a(String paramString, Long paramLong, f paramf)
  {
    AppMethodBeat.i(333040);
    s.u(paramString, "topic");
    s.u(paramf, "clickExtra");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("key_topic_type", 1);
    ((Intent)localObject1).putExtra("key_topic_title", paramString);
    ((Intent)localObject1).putExtra("key_ref_object_id", (Serializable)paramLong);
    ((Intent)localObject1).putExtra("key_entrance_type", 2);
    paramLong = paramf.contextRef;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        com.tencent.mm.plugin.finder.viewmodel.component.as.a.a(paramLong, (Intent)localObject1, 0L, 0, false, 124);
      }
    }
    paramLong = a.GfO;
    Object localObject2 = MMApplicationContext.getContext();
    s.s(localObject2, "getContext()");
    paramLong.A((Context)localObject2, (Intent)localObject1);
    Log.i(TAG, s.X("onclick topic:", paramString));
    paramLong = paramf.contextRef;
    if (paramLong != null)
    {
      paramLong = (Context)paramLong.get();
      if (paramLong != null)
      {
        if (s.p(paramf.GfY, Boolean.TRUE))
        {
          localObject1 = com.tencent.mm.plugin.finder.topic.a.FNS;
          com.tencent.mm.plugin.finder.topic.a.a(paramLong, "link_topic_tag", 1, paramf.feedId, 0L, paramString);
        }
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramLong = com.tencent.mm.plugin.finder.viewmodel.component.as.a.hu(paramLong);
        if (paramLong != null)
        {
          localObject1 = z.FrZ;
          z.a(paramf.feedId, paramString, paramf.Auy, paramLong.AJo);
          paramString = ((bn)paramLong).foy();
          if (paramString != null)
          {
            paramString = paramString.dYj();
            if (paramString != null) {
              paramString.nl(paramf.feedId);
            }
          }
        }
      }
    }
    AppMethodBeat.o(333040);
  }
  
  private static boolean a(Character paramCharacter)
  {
    AppMethodBeat.i(333001);
    if (paramCharacter == null)
    {
      AppMethodBeat.o(333001);
      return false;
    }
    paramCharacter = paramCharacter.toString();
    Iterator localIterator = ((Iterable)Ggb).iterator();
    while (localIterator.hasNext()) {
      if (((k)localIterator.next()).bm((CharSequence)paramCharacter))
      {
        AppMethodBeat.o(333001);
        return true;
      }
    }
    AppMethodBeat.o(333001);
    return false;
  }
  
  private static List<as.a> aBG(String paramString)
  {
    AppMethodBeat.i(167919);
    s.u(paramString, "curDesc");
    paramString = p.b(MMApplicationContext.getContext(), (CharSequence)paramString);
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramString.getSpans(0, paramString.length(), ImageSpan.class);
    List localList = (List)new ArrayList();
    s.s(arrayOfImageSpan, "smileySpanList");
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
        localList.add(new as.a(j, i));
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
  
  private static String eV(String paramString, int paramInt)
  {
    AppMethodBeat.i(167923);
    s.u(paramString, "topic");
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if (paramInt != 2) {
          continue;
        }
        localObject = n.b((CharSequence)paramString, new String[] { "·" });
        if (localObject != null) {
          continue;
        }
        localObject = "";
        localJSONObject.put("topic", localObject);
        localJSONObject.put("type", paramInt);
        localJSONObject.put("count", 0L);
        localJSONArray.put(localJSONObject);
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        Object localObject;
        String str;
        continue;
      }
      paramString = s.X(n.bV(C(paramString, paramInt, 0L), ",", ";"), ",,,");
      AppMethodBeat.o(167923);
      return paramString;
      str = (String)((List)localObject).get(0);
      localObject = str;
      if (str == null)
      {
        localObject = "";
        continue;
        localJSONObject.put("topic", paramString);
      }
    }
  }
  
  public static char ffM()
  {
    return GiH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.as
 * JD-Core Version:    0.7.0.1
 */