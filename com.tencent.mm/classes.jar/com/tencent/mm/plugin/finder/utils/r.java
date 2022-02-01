package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.al;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.f;
import com.tencent.mm.plugin.finder.live.model.r.a;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.model.u;
import com.tencent.mm.plugin.finder.live.model.u.a;
import com.tencent.mm.plugin.finder.live.model.u.b;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.c;
import kotlin.k.e;
import kotlin.k.i;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderLiveSpanUtils;", "", "()V", "SPAN_LOCATION_CENTER", "", "SPAN_LOCATION_LEFT", "SPAN_LOCATION_RIGHT", "SPAN_TAKE_PLACE", "", "allSpanList", "", "Landroid/text/style/ImageSpan;", "getAllSpanList", "()Ljava/util/List;", "setAllSpanList", "(Ljava/util/List;)V", "getAllBadgeSpannableString", "Lkotlin/Pair;", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "context", "Landroid/content/Context;", "msg", "badgeInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBadgeInfo;", "locationType", "getAllGlobalSpan", "getDebugSpan", "pos", "getGlobalRewardSpan", "spanMode", "sizeType", "mergeSpanString", "spans", "parseAllBadgeInfos", "parseGlobalRewardInfo", "praseBadgeInfos", "plugin-finder_release"})
public final class r
{
  public static List<? extends ImageSpan> ADJ;
  public static final r ADK;
  
  static
  {
    AppMethodBeat.i(243662);
    ADK = new r();
    AppMethodBeat.o(243662);
  }
  
  public static ImageSpan QL(int paramInt)
  {
    AppMethodBeat.i(243660);
    Object localObject1 = ADJ;
    if (localObject1 == null) {
      p.bGy("allSpanList");
    }
    if (localObject1 == null)
    {
      localObject1 = new LinkedList();
      int j = 0;
      while (j < 2)
      {
        int k = new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }[j].intValue();
        localObject2 = i.a((c)new e(1, 70), 10);
        int i = ((c)localObject2).dHa;
        int m = ((c)localObject2).aaBQ;
        int n = ((c)localObject2).oxQ;
        if (n >= 0)
        {
          if (i > m) {}
        }
        else {
          while (i >= m) {
            for (;;)
            {
              localObject2 = u.ygq;
              ((LinkedList)localObject1).add(new u.a().a(i, (ap)new al(k)).dyT());
              if (i == m) {
                break;
              }
              i += n;
            }
          }
        }
        j += 1;
      }
      ADJ = (List)localObject1;
    }
    localObject1 = ADJ;
    if (localObject1 == null) {
      p.bGy("allSpanList");
    }
    Object localObject2 = ADJ;
    if (localObject2 == null) {
      p.bGy("allSpanList");
    }
    localObject1 = (ImageSpan)((List)localObject1).get(paramInt % ((List)localObject2).size());
    AppMethodBeat.o(243660);
    return localObject1;
  }
  
  private static String ba(LinkedList<ayl> paramLinkedList)
  {
    AppMethodBeat.i(243658);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLinkedList != null)
    {
      paramLinkedList = ((Iterable)paramLinkedList).iterator();
      int i = 0;
      while (paramLinkedList.hasNext())
      {
        Object localObject = paramLinkedList.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (ayl)localObject;
        localStringBuilder.append("[" + i + "],type:" + ((ayl)localObject).SKA + ",level:" + ((ayl)localObject).SKC + ';');
        i += 1;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    p.j(paramLinkedList, "sb.toString()");
    AppMethodBeat.o(243658);
    return paramLinkedList;
  }
  
  private static m c(Context paramContext, String paramString, List<? extends ImageSpan> paramList)
  {
    AppMethodBeat.i(243655);
    p.k(paramContext, "context");
    p.k(paramString, "msg");
    p.k(paramList, "spans");
    int j = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(" ");
      i += 1;
    }
    localStringBuilder.append(paramString);
    paramContext = new m(com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, (CharSequence)String.valueOf(localStringBuilder)));
    i = 0;
    while (i < j)
    {
      paramContext.setSpan(paramList.get(i), i, i + 1, 33);
      i += 1;
    }
    AppMethodBeat.o(243655);
    return paramContext;
  }
  
  public static List<ImageSpan> c(List<? extends ayl> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(243648);
    LinkedList localLinkedList = new LinkedList();
    label44:
    Object localObject2;
    if (paramInt1 == 1)
    {
      Object localObject1 = u.ygq;
      paramInt1 = u.dyP();
      if (paramList == null) {
        break label224;
      }
      localObject1 = ((Iterable)paramList).iterator();
      do
      {
        while (((Iterator)localObject1).hasNext())
        {
          paramList = (ayl)((Iterator)localObject1).next();
          switch (paramList.SKA)
          {
          }
        }
      } while (paramList.SKC <= 0);
      localObject2 = u.ygq;
      paramList = new u.a().a(paramList.SKC, (ap)new al(paramInt2)).Np(paramInt1).aCf(paramList.background_color);
      if (paramInt3 != 1) {
        break label216;
      }
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
    }
    label216:
    for (paramList = paramList.Nq(((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_3A)).Nr(d.e(MMApplicationContext.getContext(), 13.0F)).Ns(d.e(MMApplicationContext.getContext(), 20.0F)).dyT();; paramList = paramList.dyT())
    {
      localLinkedList.add(paramList);
      break label44;
      paramInt1 = 0;
      break;
    }
    label224:
    paramList = (List)localLinkedList;
    AppMethodBeat.o(243648);
    return paramList;
  }
  
  public static List<ImageSpan> eV(List<? extends ayl> paramList)
  {
    AppMethodBeat.i(243654);
    LinkedList localLinkedList = new LinkedList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (ayl)paramList.next();
        Object localObject2;
        switch (((ayl)localObject1).SKA)
        {
        default: 
          break;
        case 1: 
          int i = ((ayl)localObject1).SKC;
          if (i > 0)
          {
            localObject2 = com.tencent.mm.plugin.finder.live.model.r.yfV;
            localObject2 = new r.a();
            Object localObject3 = (ap)new f();
            p.k(localObject3, "config");
            ((r.a)localObject2).yfN.bgColor = ((Number)((ap)localObject3).di(Integer.valueOf(i))).intValue();
            ((r.a)localObject2).yfN.mTB = ((Number)((ap)localObject3).jdMethod_do(Integer.valueOf(i))).intValue();
            ((r.a)localObject2).yfN.textColor = ((Number)((ap)localObject3).dk(Integer.valueOf(i))).intValue();
            localObject3 = MMApplicationContext.getContext();
            p.j(localObject3, "MMApplicationContext.getContext()");
            localObject3 = ((Context)localObject3).getResources().getString(b.j.finder_live_msg_badge_level_prefix);
            p.j(localObject3, "MMApplicationContext.get…e_msg_badge_level_prefix)");
            localObject3 = (CharSequence)localObject3;
            p.k(localObject3, "normalText");
            s locals = ((r.a)localObject2).yfN;
            p.k(localObject3, "<set-?>");
            locals.yfW = ((CharSequence)localObject3);
            localObject3 = (CharSequence)String.valueOf(i);
            p.k(localObject3, "italicText");
            locals = ((r.a)localObject2).yfN;
            p.k(localObject3, "<set-?>");
            locals.yfX = ((CharSequence)localObject3);
            ((r.a)localObject2).yfN.Gp = 0;
            localObject1 = ((r.a)localObject2).aCe(((ayl)localObject1).background_color);
            float f1 = ((r.a)localObject1).yfN.yfY;
            localObject2 = u.ygq;
            float f2 = u.b.e(((r.a)localObject1).yfN.yfW + ((r.a)localObject1).yfN.yfX, ((r.a)localObject1).yfN.textSize);
            float f3 = ((r.a)localObject1).yfN.yfZ;
            localObject2 = com.tencent.mm.plugin.finder.live.model.r.yfV;
            float f4 = com.tencent.mm.plugin.finder.live.model.r.dyH();
            localObject2 = com.tencent.mm.plugin.finder.live.model.r.yfV;
            i = ((r.a)localObject1).yfN.Gp;
            int j = ((r.a)localObject1).yfN.Gq;
            int k = (int)(f1 + f2 + f3 + f4);
            localObject2 = new GradientDrawable();
            ((GradientDrawable)localObject2).setBounds(0, 0, i + k + j, 1);
            localObject2 = new com.tencent.mm.plugin.finder.live.model.r((Drawable)localObject2);
            localObject1 = ((r.a)localObject1).yfN;
            p.k(localObject1, "<set-?>");
            ((com.tencent.mm.plugin.finder.live.model.r)localObject2).yfN = ((s)localObject1);
            localLinkedList.add(localObject2);
          }
          break;
        case 2: 
          if (((ayl)localObject1).SKC > 0)
          {
            localObject2 = u.ygq;
            localLinkedList.add(new u.a().a(((ayl)localObject1).SKC, (ap)new al()).Np(0).aCf(((ayl)localObject1).background_color).dyT());
          }
          break;
        }
      }
    }
    paramList = (List)localLinkedList;
    AppMethodBeat.o(243654);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.r
 * JD-Core Version:    0.7.0.1
 */