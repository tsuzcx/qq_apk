package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Lcom.tencent.mm.protocal.protobuf.djg;>;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderStyleUtil;", "", "()V", "AT", "", "getAT", "()Ljava/lang/String;", "FINDER", "getFINDER", "STYLE", "getSTYLE", "TAG", "TAG_AT_END", "TAG_AT_START", "TAG_CDATA", "TAG_FINDER_END", "TAG_FINDER_START", "TAG_STYLE_END", "TAG_STYLE_START", "TAG_TOPIC", "TAG_VALUE_COUNT", "TAG_VALUE_END", "TAG_VALUE_START", "TAG_VERSION", "TOPIC", "getTOPIC", "VALUE", "getVALUE", "VALUE_COUNT", "getVALUE_COUNT", "VERSION", "getVERSION", "linkColor", "", "version", "getVersion", "()I", "appendNormalValue", "", "xml", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "count", "appendStyleAt", "atIndexs", "appendTopicValue", "appendVersionValue", "getDescXml", "curDesc", "atContactMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/HashMap;", "handleAt", "desc", "Landroid/text/SpannableString;", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "onAtClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "username", "handleTopic", "feedId", "", "topicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "onTopicClick", "Lkotlin/Function2;", "topic", "Lcom/tencent/mm/plugin/finder/utils/ClickExtra;", "clickExtra", "parseDefatultDesc", "defaultDesc", "parseXml", "atFinderContactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "mentionedUserList", "Lcom/tencent/mm/protocal/protobuf/FinderMentionedUser;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  public static final ao GhZ;
  public static final String Gia;
  public static final String Gib;
  public static final String Gic;
  public static final String Gid;
  public static final String Gie;
  private static final String Gif;
  private static final String Gig;
  private static final String Gih;
  private static final String Gii;
  private static final String Gij;
  private static final String Gik;
  private static final String Gil;
  private static final String Gim;
  private static final String Gin;
  private static final String Gio;
  private static final String Gip;
  private static final String Giq;
  public static final String TAG;
  public static final String VALUE;
  public static final String VERSION;
  private static final int linkColor;
  private static final int version;
  
  static
  {
    AppMethodBeat.i(333090);
    GhZ = new ao();
    TAG = "Finder.FinderStyleUtil";
    version = 1;
    Gia = "finder";
    Gib = "style";
    Gic = "valuecount";
    VALUE = "value";
    Gid = "topic";
    Gie = "at";
    VERSION = "version";
    Gif = "<" + Gia + '>';
    Gig = "</" + Gia + '>';
    Gih = "<" + Gib + '>';
    Gii = "</" + Gib + '>';
    Gij = "<" + Gie + '>';
    Gik = "</" + Gie + '>';
    Gil = "<![CDATA[%s]]>";
    Gim = "<" + Gic + ">%d</" + Gic + '>';
    Gin = "<" + VALUE + "%d>";
    Gio = "</" + VALUE + "%d>";
    Gip = "<" + Gid + ">%s</" + Gid + '>';
    Giq = "<" + VERSION + ">%d</" + VERSION + '>';
    linkColor = Color.parseColor("#DEE9FF");
    AppMethodBeat.o(333090);
  }
  
  public static SpannableString a(String paramString, SpannableString paramSpannableString, List<bo> paramList, m<? super String, ? super f, ah> paramm, final long paramLong)
  {
    AppMethodBeat.i(333077);
    if (Util.isNullOrNil(paramString))
    {
      paramString = as.GiG;
      paramString = paramSpannableString.toString();
      s.s(paramString, "defaultDesc.toString()");
      paramString = ((Iterable)as.a(paramString, new ArrayList(), null)).iterator();
      Object localObject;
      while (paramString.hasNext())
      {
        localObject = (bo)paramString.next();
        int j = ((bo)localObject).start - 1;
        int i = j;
        if (j < 0) {
          i = 0;
        }
        paramList.add(new bo(i, ((bo)localObject).count + 1, s.X("#", ((bo)localObject).topic)));
      }
      paramString = SpannableString.valueOf((CharSequence)new SpannableStringBuilder((CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)paramSpannableString.toString())));
      paramSpannableString = ((Iterable)paramList).iterator();
      while (paramSpannableString.hasNext())
      {
        paramList = (bo)paramSpannableString.next();
        localObject = paramList.topic;
        if (localObject == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(333077);
          throw paramString;
        }
        localObject = ((String)localObject).substring(1);
        s.s(localObject, "(this as java.lang.String).substring(startIndex)");
        paramString.setSpan(new q((String)localObject, linkColor, MMApplicationContext.getContext().getResources().getColor(e.b.BW_0_Alpha_0_2), true, (b)new c(paramm, paramLong)), paramList.start, paramList.start + paramList.count, 17);
      }
      s.s(paramString, "ret");
      AppMethodBeat.o(333077);
      return paramString;
    }
    AppMethodBeat.o(333077);
    return paramSpannableString;
  }
  
  public static void a(final long paramLong, SpannableString paramSpannableString, List<bo> paramList, m<? super String, ? super f, ah> paramm)
  {
    AppMethodBeat.i(333055);
    int i;
    int j;
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      i = MMApplicationContext.getContext().getResources().getColor(e.b.FG_0);
      if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
        break label137;
      }
      j = MMApplicationContext.getContext().getResources().getColor(e.b.transparent);
      label68:
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label222;
      }
      bo localbo = (bo)paramList.next();
      String str = localbo.topic;
      if (str == null)
      {
        paramSpannableString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(333055);
        throw paramSpannableString;
        i = linkColor;
        break;
        label137:
        j = MMApplicationContext.getContext().getResources().getColor(e.b.BW_0_Alpha_0_2);
        break label68;
      }
      str = str.substring(1);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
      paramSpannableString.setSpan(new q(str, i, j, true, (b)new b(paramm, paramLong)), localbo.start, localbo.start + localbo.count, 17);
    }
    label222:
    AppMethodBeat.o(333055);
  }
  
  public static void a(SpannableString paramSpannableString, ArrayList<h.a> paramArrayList, b<? super String, ah> paramb)
  {
    AppMethodBeat.i(333065);
    int i;
    int j;
    label67:
    label78:
    h.a locala;
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      i = MMApplicationContext.getContext().getResources().getColor(e.b.FG_0);
      if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
        break label174;
      }
      j = MMApplicationContext.getContext().getResources().getColor(e.b.transparent);
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      if (!localIterator.hasNext()) {
        break label194;
      }
      locala = (h.a)localIterator.next();
      paramArrayList = locala.Ggd;
      if (paramArrayList != null) {
        break label191;
      }
      paramArrayList = "";
    }
    label174:
    label191:
    for (;;)
    {
      paramArrayList = new q(paramArrayList, i, j, (b)new a(paramb));
      paramArrayList.GDh = true;
      ah localah = ah.aiuX;
      paramSpannableString.setSpan(paramArrayList, locala.start, locala.end, 17);
      break label78;
      i = linkColor;
      break;
      j = MMApplicationContext.getContext().getResources().getColor(e.b.BW_0_Alpha_0_2);
      break label67;
    }
    label194:
    AppMethodBeat.o(333065);
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(333047);
    Object localObject = am.aixg;
    localObject = String.format(Gin, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    paramStringBuilder.append((String)localObject);
    localObject = am.aixg;
    paramString = String.format(Gil, Arrays.copyOf(new Object[] { paramString }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    paramString = am.aixg;
    paramString = String.format(Gio, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
    s.s(paramString, "java.lang.String.format(format, *args)");
    paramStringBuilder.append(paramString);
    AppMethodBeat.o(333047);
  }
  
  public static String d(String paramString, HashMap<String, djg> paramHashMap)
  {
    AppMethodBeat.i(333042);
    s.u(paramString, "curDesc");
    s.u(paramHashMap, "atContactMap");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(333042);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject2 = (List)new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = d.FAy;
    if (d.eRt())
    {
      localObject1 = h.Gga;
      localObject1 = h.a(paramString, paramHashMap, null).bsD;
    }
    paramHashMap = d.FAy;
    if (d.eRs()) {
      paramHashMap = as.GiG;
    }
    for (paramHashMap = as.a(paramString, (ArrayList)localObject1, null);; paramHashMap = (HashMap<String, djg>)localObject2)
    {
      localStringBuilder.append(Gif);
      if ((paramHashMap.isEmpty()) && (((ArrayList)localObject1).isEmpty()))
      {
        paramHashMap = am.aixg;
        paramHashMap = String.format(Gim, Arrays.copyOf(new Object[] { Integer.valueOf(1) }, 1));
        s.s(paramHashMap, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramHashMap);
        a(localStringBuilder, paramString, 0);
        paramString = am.aixg;
        paramString = String.format(Giq, Arrays.copyOf(new Object[] { Integer.valueOf(version) }, 1));
        s.s(paramString, "java.lang.String.format(format, *args)");
        localStringBuilder.append(paramString);
        localStringBuilder.append(Gig);
        Log.d(TAG, s.X("xml:", localStringBuilder));
        paramString = localStringBuilder.toString();
        s.s(paramString, "xml.toString()");
        AppMethodBeat.o(333042);
        return paramString;
      }
      int i = 0;
      int j = 0;
      localObject2 = "";
      int k = 0;
      label296:
      int m;
      int i1;
      if (j < paramString.length()) {
        if (!paramHashMap.isEmpty())
        {
          m = 0;
          i1 = paramHashMap.size() - 1;
          if (i1 < 0) {}
        }
      }
      for (;;)
      {
        int n = m + 1;
        localObject3 = (bo)paramHashMap.get(m);
        m = ((bo)localObject3).start - 1;
        if (m == j) {}
        for (;;)
        {
          if (localObject3 != null)
          {
            paramHashMap.remove(localObject3);
            n = ((bo)localObject3).start - 1;
            m = ((bo)localObject3).count + n + 1;
            if (n >= k)
            {
              j = i;
              if (n > k)
              {
                localObject3 = paramString.substring(k, n);
                s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                a(localStringBuilder, (String)localObject3, i);
                j = i + 1;
              }
              localObject3 = paramString.substring(n, m);
              s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localObject3 = s.X((String)localObject3, "#");
              Object localObject4 = am.aixg;
              localObject4 = String.format(Gin, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
              s.s(localObject4, "java.lang.String.format(format, *args)");
              localStringBuilder.append((String)localObject4);
              localObject4 = am.aixg;
              localObject4 = Gip;
              am localam = am.aixg;
              localObject3 = String.format(Gil, Arrays.copyOf(new Object[] { localObject3 }, 1));
              s.s(localObject3, "java.lang.String.format(format, *args)");
              localObject3 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject3 }, 1));
              s.s(localObject3, "java.lang.String.format(format, *args)");
              localStringBuilder.append((String)localObject3);
              localObject3 = am.aixg;
              localObject3 = String.format(Gio, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
              s.s(localObject3, "java.lang.String.format(format, *args)");
              localStringBuilder.append((String)localObject3);
              i = m;
              k = m;
              m = j + 1;
              j = i;
              i = m;
              break;
              if ((m <= j) && (n <= i1)) {
                break label1204;
              }
              localObject3 = null;
              continue;
            }
            Log.e(TAG, "topicStart:" + n + ", startIndex:" + k);
          }
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          m = 0;
          i1 = ((ArrayList)localObject1).size() - 1;
          if (i1 < 0) {}
        }
        for (;;)
        {
          n = m + 1;
          localObject3 = ((ArrayList)localObject1).get(m);
          s.s(localObject3, "atContactList[atIndex]");
          localObject3 = (h.a)localObject3;
          m = ((h.a)localObject3).start;
          if (m == j)
          {
            label793:
            if (localObject3 == null) {
              break label1006;
            }
            ((ArrayList)localObject1).remove(localObject3);
            n = ((h.a)localObject3).start;
            m = ((h.a)localObject3).end;
            if (n < k) {
              break label971;
            }
            if (n <= k) {
              break label1194;
            }
            localObject3 = paramString.substring(k, n);
            s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            j = i + 1;
            a(localStringBuilder, (String)localObject3, i);
            i = j;
          }
          label1194:
          for (;;)
          {
            localObject3 = paramString.substring(n, m);
            s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject3 = s.X((String)localObject3, " ");
            n = i + 1;
            a(localStringBuilder, (String)localObject3, i);
            localObject2 = (String)localObject2 + (n - 1) + ',';
            j = m;
            k = m;
            i = n;
            break label296;
            if ((m <= j) && (n <= i1)) {
              break label1197;
            }
            localObject3 = null;
            break label793;
            label971:
            Log.e(TAG, "topicStart:" + n + ", startIndex:" + k);
            label1006:
            j += 1;
            break label296;
            j = i;
            if (k < paramString.length())
            {
              paramString = paramString.substring(k, paramString.length());
              s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              a(localStringBuilder, paramString, i);
              j = i + 1;
            }
            if (!Util.isNullOrNil((String)localObject2))
            {
              localStringBuilder.append(Gih);
              localStringBuilder.append(Gij);
              i = ((String)localObject2).length();
              if (localObject2 == null)
              {
                paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(333042);
                throw paramString;
              }
              paramString = ((String)localObject2).substring(0, i - 1);
              s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localStringBuilder.append(paramString);
              localStringBuilder.append(Gik);
              localStringBuilder.append(Gii);
            }
            paramString = am.aixg;
            paramString = String.format(Gim, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
            s.s(paramString, "java.lang.String.format(format, *args)");
            localStringBuilder.append(paramString);
            break;
          }
          label1197:
          m = n;
        }
        label1204:
        m = n;
      }
    }
  }
  
  public static String ffA()
  {
    return Gic;
  }
  
  public static String ffB()
  {
    return VALUE;
  }
  
  public static String ffC()
  {
    return Gid;
  }
  
  public static String ffz()
  {
    return Gia;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "username", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<String, ah>
  {
    a(b<? super String, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "topic", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<String, ah>
  {
    b(m<? super String, ? super f, ah> paramm, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "topic", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<String, ah>
  {
    c(m<? super String, ? super f, ah> paramm, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ao
 * JD-Core Version:    0.7.0.1
 */