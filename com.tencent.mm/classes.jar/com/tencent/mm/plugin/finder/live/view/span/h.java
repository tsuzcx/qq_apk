package com.tencent.mm.plugin.finder.live.view.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.bfl;>;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveSpanUtil;", "", "()V", "DEFAULT_SPAN_TYPE_ARRAY", "", "getDEFAULT_SPAN_TYPE_ARRAY", "()[I", "DP_10", "", "getDP_10", "()I", "DP_12", "getDP_12", "DP_13", "getDP_13", "DP_15", "getDP_15", "DP_16", "getDP_16", "DP_17", "getDP_17", "DP_18", "getDP_18", "DP_1_5_A", "getDP_1_5_A", "DP_22", "getDP_22", "DP_28", "getDP_28", "DP_7", "getDP_7", "DP_8", "getDP_8", "DP_9", "getDP_9", "D_0_2_5_A", "getD_0_2_5_A", "D_0_5_A", "getD_0_5_A", "D_A", "getD_A", "SPAN_LOCATION_CENTER", "SPAN_LOCATION_LEFT", "SPAN_LOCATION_RIGHT", "SPAN_TAKE_PLACE", "", "TAG", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "getAllBadgeSpannableString", "Lkotlin/Pair;", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "", "Landroid/text/style/ImageSpan;", "context", "Landroid/content/Context;", "msg", "badgeInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "filterSpan", "spanMode", "sizeType", "getBadgePriority", "badgeType", "getFansSpan", "fansConfig", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansConfig;", "getGlobalRewardSpan", "locationType", "getTakePlaceStr", "spanList", "getTextWidth", "", "text", "textSize", "mergeSpanString", "spans", "parseAllBadgeInfos", "spanFilter", "limit", "attachView", "Landroid/view/View;", "parseGlobalRewardInfo", "praseBadgeInfos", "sortBadgeInfoList", "list", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h DWP;
  private static final int DWQ;
  private static final int DWT;
  private static final int DWU;
  private static final int DWV;
  private static final int DWW;
  private static final int DWX;
  private static final int DWY;
  private static final int DWZ;
  private static final int DXa;
  private static final int DXb;
  private static final int DXc;
  private static final int DXd;
  private static final int DXe;
  private static final int DXf;
  private static final int[] DXg;
  private static final String TAG;
  private static final int akfL;
  private static final int wFJ;
  
  static
  {
    AppMethodBeat.i(358636);
    DWP = new h();
    DWQ = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    akfL = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_1_5_A);
    int i = DWQ / 2;
    DWT = i;
    DWU = i / 2;
    DWV = d.e(MMApplicationContext.getContext(), 7.0F);
    DWW = d.e(MMApplicationContext.getContext(), 8.0F);
    DWX = d.e(MMApplicationContext.getContext(), 9.0F);
    DWY = d.e(MMApplicationContext.getContext(), 10.0F);
    DWZ = d.e(MMApplicationContext.getContext(), 12.0F);
    DXa = d.e(MMApplicationContext.getContext(), 13.0F);
    DXb = d.e(MMApplicationContext.getContext(), 15.0F);
    wFJ = d.e(MMApplicationContext.getContext(), 16.0F);
    DXc = d.e(MMApplicationContext.getContext(), 17.0F);
    DXd = d.e(MMApplicationContext.getContext(), 18.0F);
    DXe = d.e(MMApplicationContext.getContext(), 22.0F);
    DXf = d.e(MMApplicationContext.getContext(), 28.0F);
    TAG = "Finder.FinderLiveSpanUtil";
    DXg = new int[] { 1, 2, 4, 5 };
    AppMethodBeat.o(358636);
  }
  
  private static List<ImageSpan> H(List<? extends bfl> paramList, int paramInt)
  {
    AppMethodBeat.i(358517);
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        bfl localbfl = (bfl)paramList.next();
        if ((localbfl.ZPp == 2) && (localbfl.ZPr > 0))
        {
          e.b localb = e.DWw;
          localLinkedList.add(new e.a().a(localbfl.ZPr, String.valueOf(localbfl.ZPr), (l)new j(0, paramInt)).PL(0).ayf(localbfl.background_color).ews());
        }
      }
    }
    paramList = (List)localLinkedList;
    AppMethodBeat.o(358517);
    return paramList;
  }
  
  public static List<ImageSpan> a(List<? extends bfl> paramList, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, View paramView)
  {
    AppMethodBeat.i(358566);
    s.u(paramArrayOfInt, "spanFilter");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator;
    label662:
    label922:
    label927:
    if (paramList == null)
    {
      if (paramList != null) {
        localIterator = ((Iterable)paramList).iterator();
      }
    }
    else {
      label678:
      for (;;)
      {
        label41:
        if (localIterator.hasNext())
        {
          bfl localbfl = (bfl)localIterator.next();
          if ((k.contains(paramArrayOfInt, localbfl.ZPp)) && ((paramInt3 == -1) || (localLinkedList.size() < paramInt3)))
          {
            int i;
            Object localObject1;
            Object localObject2;
            int j;
            int k;
            label694:
            e.a locala;
            int m;
            switch (localbfl.ZPp)
            {
            default: 
              break;
            case 1: 
              i = localbfl.ZPr;
              if (i > 0)
              {
                paramList = i.DXh;
                paramList = new i.a();
                localObject1 = (l)new a();
                s.u(localObject1, "config");
                paramList.DXi.bgColor = ((l)localObject1).fk(Integer.valueOf(i));
                paramList.DXi.pQi = ((l)localObject1).fl(Integer.valueOf(i));
                paramList.DXi.textColor = ((l)localObject1).fm(Integer.valueOf(i));
                localObject2 = paramList.DXi;
                if (((l)localObject1).fo(Integer.valueOf(i)) == 1) {}
                for (boolean bool = true;; bool = false)
                {
                  ((i.c)localObject2).DWD = bool;
                  localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_msg_badge_level_prefix);
                  s.s(localObject1, "getContext().resources.g…e_msg_badge_level_prefix)");
                  paramList = paramList.ad((CharSequence)localObject1);
                  localObject1 = (CharSequence)String.valueOf(i);
                  s.u(localObject1, "number");
                  localObject2 = paramList.DXi;
                  s.u(localObject1, "<set-?>");
                  ((i.c)localObject2).DXk = ((CharSequence)localObject1);
                  paramList.DXi.bmt = 0;
                  i = DWT;
                  paramList.DXi.DXl = i;
                  localLinkedList.add(paramList.ayh(localbfl.background_color).ewM());
                  break label41;
                  paramList = kotlin.a.p.a((Iterable)paramList, (Comparator)new a());
                  break;
                }
              }
              break;
            case 2: 
              if (localbfl.ZPr > 0)
              {
                paramList = e.DWw;
                localLinkedList.add(new e.a().a(localbfl.ZPr, String.valueOf(localbfl.ZPr), (l)new j(paramInt1, paramInt2)).PL(0).ayf(localbfl.background_color).ews());
              }
              break;
            case 3: 
              if (paramView != null)
              {
                paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                com.tencent.mm.plugin.finder.live.utils.a.hQ(TAG, "getIconDrawable viewRef:" + paramView.hashCode() + ", name:" + localbfl.ZPs + ", bgcolor:" + localbfl.background_color + ", url:" + localbfl.ZPq);
                localObject2 = Integer.toString((int)(255.0F * (localbfl.ZPt / 100.0F)), kotlin.n.a.aMy(16));
                s.s(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                localObject1 = localbfl.background_color;
                paramList = (List<? extends bfl>)localObject1;
                if (localObject1 == null) {
                  paramList = "#FFFFFF";
                }
                localObject1 = s.X((String)localObject2, n.bV(paramList, "#", ""));
                localObject2 = new an(paramView, paramInt2, p.e.url_bitmap_drawable_game_rank_tag_key);
                if (paramInt2 == 0)
                {
                  i = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_0_5_A);
                  if (paramInt2 != 0) {
                    break label830;
                  }
                  j = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_A);
                  if (paramInt2 != 0) {
                    break label845;
                  }
                  k = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_0_25A);
                  paramList = e.DWw;
                  locala = new e.a();
                  m = localbfl.ZPr;
                  paramList = localbfl.ZPs;
                  if (paramList != null) {
                    break label862;
                  }
                  paramList = "";
                }
                for (;;)
                {
                  locala = locala.a(m, paramList, (l)localObject2).PL(0).PM(i).PN(j).PO(k).ayf(s.X("#", localObject1));
                  localObject1 = localbfl.ZPq;
                  paramList = (List<? extends bfl>)localObject1;
                  if (localObject1 == null) {
                    paramList = "";
                  }
                  localLinkedList.add(locala.O(((an)localObject2).awB(paramList)).ews());
                  break;
                  i = (int)MMApplicationContext.getResources().getDimension(p.c.finder_0_75_A);
                  break label662;
                  j = (int)MMApplicationContext.getResources().getDimension(p.c.finder_1_25_A);
                  break label678;
                  k = (int)MMApplicationContext.getResources().getDimension(p.c.finder_0_75_A) / 2;
                  break label694;
                }
              }
              Log.i(TAG, "GameRank attachView null");
              break;
            case 4: 
              if (localbfl.ZPr > 0)
              {
                localObject1 = localbfl.ZPs;
                paramList = (CharSequence)localObject1;
                if ((paramList == null) || (paramList.length() == 0))
                {
                  i = 1;
                  if (i != 0) {
                    break label1024;
                  }
                  i = 1;
                  if (i == 0) {
                    break label1030;
                  }
                  paramList = (List<? extends bfl>)localObject1;
                  if (localObject1 == null)
                  {
                    paramList = aj.CGT;
                    paramList = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
                    if (paramList != null) {
                      break label1036;
                    }
                    paramList = null;
                  }
                }
                for (;;)
                {
                  localObject1 = c.DWh;
                  paramList = new c.a().a(localbfl.ZPr, new b(paramInt1, paramInt2)).ayd(paramList);
                  paramList.DWi.bmt = 0;
                  localLinkedList.add(paramList.aye(localbfl.background_color).ewp());
                  break;
                  i = 0;
                  break label914;
                  i = 0;
                  break label922;
                  localObject1 = null;
                  break label927;
                  paramList = paramList.Efg;
                  if (paramList == null) {
                    paramList = null;
                  } else {
                    paramList = paramList.ZQn;
                  }
                }
              }
              break;
            case 6: 
              if (paramView != null)
              {
                localObject2 = Integer.toString((int)(255.0F * (localbfl.ZPt / 100.0F)), kotlin.n.a.aMy(16));
                s.s(localObject2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                localObject1 = localbfl.background_color;
                paramList = (List<? extends bfl>)localObject1;
                if (localObject1 == null) {
                  paramList = "#FFFFFF";
                }
                localObject1 = s.X((String)localObject2, n.bV(paramList, "#", ""));
                localObject2 = new an(paramView, paramInt2, p.e.url_bitmap_drawable_game_esport_tag_key);
                if (paramInt2 == 0)
                {
                  i = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_0_5_A);
                  if (paramInt2 != 0) {
                    break label1331;
                  }
                  j = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_A);
                  if (paramInt2 != 0) {
                    break label1346;
                  }
                  k = (int)MMApplicationContext.getResources().getDimension(p.c.Edge_0_25A);
                  paramList = e.DWw;
                  locala = new e.a();
                  m = localbfl.ZPr;
                  paramList = localbfl.ZPs;
                  if (paramList != null) {
                    break label1363;
                  }
                  paramList = "";
                }
                for (;;)
                {
                  locala = locala.a(m, paramList, (l)localObject2).PL(0).PM(i).PN(j).PO(k).ayf(s.X("#", localObject1));
                  localObject1 = localbfl.ZPq;
                  paramList = (List<? extends bfl>)localObject1;
                  if (localObject1 == null) {
                    paramList = "";
                  }
                  localLinkedList.add(locala.O(((an)localObject2).awB(paramList)).ews());
                  break;
                  i = (int)MMApplicationContext.getResources().getDimension(p.c.finder_0_75_A);
                  break label1163;
                  j = (int)MMApplicationContext.getResources().getDimension(p.c.finder_1_25_A);
                  break label1179;
                  k = (int)MMApplicationContext.getResources().getDimension(p.c.finder_0_75_A) / 2;
                  break label1195;
                }
              }
              break;
            case 5: 
              label830:
              label845:
              label862:
              paramList = MMApplicationContext.getContext();
              label1195:
              label1331:
              label1346:
              label1363:
              localObject1 = i.DXh;
              localObject2 = new i.a().PR(paramList.getResources().getColor(p.b.BW_100_Alpha_0_3)).PS(paramList.getResources().getColor(p.b.White)).PT((int)paramList.getResources().getDimension(p.c.FootnoteextSize)).PU((int)paramList.getResources().getDimension(p.c.Edge_0_5_A));
              localObject1 = localbfl.ZPs;
              paramList = (List<? extends bfl>)localObject1;
              if (localObject1 == null) {
                paramList = "";
              }
              localLinkedList.add(((i.a)localObject2).ad((CharSequence)paramList).ewM());
              if (s.p(localbfl.ZPs, MMApplicationContext.getContext().getResources().getString(p.h.Cix)))
              {
                paramList = (List)localLinkedList;
                AppMethodBeat.o(358566);
                return paramList;
              }
              break;
            }
          }
        }
      }
    }
    label914:
    label1179:
    paramList = (List)localLinkedList;
    label1024:
    label1030:
    label1036:
    AppMethodBeat.o(358566);
    label1163:
    return paramList;
  }
  
  private static String aA(LinkedList<bfl> paramLinkedList)
  {
    AppMethodBeat.i(358612);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      int i = 0;
      while (paramLinkedList.hasNext())
      {
        Object localObject = paramLinkedList.next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject = (bfl)localObject;
        localStringBuilder.append("[" + i + "],type:" + ((bfl)localObject).ZPp + ",level:" + ((bfl)localObject).ZPr + ';');
        i += 1;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    s.s(paramLinkedList, "sb.toString()");
    AppMethodBeat.o(358612);
    return paramLinkedList;
  }
  
  private static q c(Context paramContext, String paramString, List<? extends ImageSpan> paramList)
  {
    int j = 0;
    AppMethodBeat.i(358591);
    int m = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder("");
    if (m > 0)
    {
      i = 0;
      int k;
      do
      {
        k = i + 1;
        localStringBuilder.append(" ");
        i = k;
      } while (k < m);
    }
    localStringBuilder.append(paramString);
    paramContext = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)String.valueOf(localStringBuilder)));
    if (m > 0) {}
    for (int i = j;; i = j)
    {
      j = i + 1;
      paramContext.setSpan(paramList.get(i), i, i + 1, 33);
      if (j >= m)
      {
        AppMethodBeat.o(358591);
        return paramContext;
      }
    }
  }
  
  public static int ewA()
  {
    return DWV;
  }
  
  public static int ewB()
  {
    return DWW;
  }
  
  public static int ewC()
  {
    return DWX;
  }
  
  public static int ewD()
  {
    return DWY;
  }
  
  public static int ewE()
  {
    return DWZ;
  }
  
  public static int ewF()
  {
    return DXa;
  }
  
  public static int ewG()
  {
    return DXb;
  }
  
  public static int ewH()
  {
    return wFJ;
  }
  
  public static int ewI()
  {
    return DXd;
  }
  
  public static int ewJ()
  {
    return DXe;
  }
  
  public static int ewK()
  {
    return DXf;
  }
  
  public static int[] ewL()
  {
    return DXg;
  }
  
  public static int ewx()
  {
    return DWQ;
  }
  
  public static int ewy()
  {
    return DWT;
  }
  
  public static int ewz()
  {
    return DWU;
  }
  
  public static float f(String paramString, float paramFloat)
  {
    AppMethodBeat.i(358489);
    s.u(paramString, "text");
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    paramFloat = localPaint.measureText(paramString, 0, paramString.length());
    AppMethodBeat.o(358489);
    return paramFloat;
  }
  
  public static String gQ(List<? extends ImageSpan> paramList)
  {
    AppMethodBeat.i(358496);
    s.u(paramList, "spanList");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramList.next();
      localStringBuilder.append(" ");
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(358496);
    return paramList;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(358429);
      paramT2 = (bfl)paramT2;
      h localh = h.DWP;
      paramT2 = (Comparable)Integer.valueOf(h.PQ(paramT2.ZPp));
      paramT1 = (bfl)paramT1;
      localh = h.DWP;
      int i = kotlin.b.a.b(paramT2, (Comparable)Integer.valueOf(h.PQ(paramT1.ZPp)));
      AppMethodBeat.o(358429);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.h
 * JD-Core Version:    0.7.0.1
 */