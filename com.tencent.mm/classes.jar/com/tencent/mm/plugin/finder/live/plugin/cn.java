package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSubtitlePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "firstLog", "", "lastSubtitle", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveSubtitle;", "maxWidth", "", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "subtitle", "Landroid/widget/TextView;", "getSubtitle", "()Landroid/widget/TextView;", "subtitle$delegate", "Lkotlin/Lazy;", "tmpMsg", "tmpSubtitle", "addSubtitleInfo", "", "index", "duration", "msg", "calMaxWidth", "canClearScreen", "checkVisible", "getOnLineMaxSize", "isOneLineSubtitle", "partitionSubtitle", "printMsg", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "showSubtitleImpl", "showSubtitleInfo", "updateSubtitle", "plugin-finder_release"})
public final class cn
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private int maxWidth;
  private boolean yxF;
  private com.tencent.mm.plugin.finder.live.viewmodel.data.k yxG;
  private final f yxH;
  private String yxI;
  private com.tencent.mm.plugin.finder.live.viewmodel.data.k yxJ;
  
  public cn(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, bid parambid)
  {
    super(paramViewGroup, paramb, parambid);
    AppMethodBeat.i(274402);
    this.kCL = paramb;
    this.TAG = "FinderLiveSubtitlePlugin";
    this.yxF = true;
    this.yxH = g.ar((kotlin.g.a.a)new b(paramViewGroup));
    this.yxI = "";
    AppMethodBeat.o(274402);
  }
  
  private static String a(ConcurrentLinkedDeque<com.tencent.mm.plugin.finder.live.viewmodel.data.k> paramConcurrentLinkedDeque)
  {
    AppMethodBeat.i(274400);
    StringBuilder localStringBuilder = new StringBuilder();
    paramConcurrentLinkedDeque = paramConcurrentLinkedDeque.iterator();
    p.j(paramConcurrentLinkedDeque, "msg.iterator()");
    while (paramConcurrentLinkedDeque.hasNext()) {
      localStringBuilder.append(paramConcurrentLinkedDeque.next());
    }
    paramConcurrentLinkedDeque = localStringBuilder.toString();
    p.j(paramConcurrentLinkedDeque, "sb.toString()");
    AppMethodBeat.o(274400);
    return paramConcurrentLinkedDeque;
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.k paramk)
  {
    AppMethodBeat.i(274398);
    if (paramk != null) {}
    String str;
    int k;
    int m;
    for (;;)
    {
      try
      {
        str = paramk.subtitle;
        if (str == null)
        {
          AppMethodBeat.o(274398);
          return;
        }
        k = paramk.duration;
        m = str.length();
        localObject1 = (CharSequence)str;
        localObject2 = (Iterable)new kotlin.n.k("(?<=\\uff0c)|(?<=\\uff1f)|(?<=\\u3002)|(?<=\\uff1b)|(\n)|(\r)").u((CharSequence)localObject1, 0);
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        if (((CharSequence)localObject3).length() <= 0) {
          break label179;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        ((Collection)localObject1).add(localObject3);
        continue;
        AppMethodBeat.o(274398);
      }
      catch (Exception paramk)
      {
        localObject1 = aj.AGc;
        aj.a(paramk, this.TAG + ":repairSubtitle");
      }
      return;
      label179:
      i = 0;
    }
    Object localObject2 = (List)localObject1;
    int j = ((List)localObject2).size();
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.ha(this.TAG, "partitionSubtitle spitlChineseMsg:" + localObject2 + ",size:" + j);
    int i = j - 1;
    localObject1 = str;
    label245:
    boolean bool;
    if (i > 0)
    {
      localObject1 = j.a((Iterable)((List)localObject2).subList(0, i), (CharSequence)"", null, null, 0, (CharSequence)"", null, 46);
      if (!aCx((String)localObject1)) {
        break label674;
      }
      localObject2 = j.a((Iterable)((List)localObject2).subList(i, j), (CharSequence)"", null, null, 0, (CharSequence)"", null, 46);
      bool = true;
      label327:
      if (!bool)
      {
        i = new StaticLayout((CharSequence)str, 0, str.length(), dCJ().getPaint(), this.maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineEnd(0);
        j = i - 1;
        if (j <= 0) {
          break label681;
        }
        i = j;
      }
    }
    label659:
    label662:
    label674:
    label681:
    for (;;)
    {
      if (str == null)
      {
        paramk = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(274398);
        throw paramk;
      }
      localObject1 = str.substring(0, i);
      p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (str == null)
      {
        paramk = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(274398);
        throw paramk;
      }
      localObject2 = str.substring(i, m);
      p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (((CharSequence)localObject2).length() > 0)
      {
        i = 1;
        if (i != 0)
        {
          localObject2 = new com.tencent.mm.plugin.finder.live.viewmodel.data.k((String)localObject2, paramk.index, (int)(k * (((String)localObject2).length() / m)));
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.addFirst(localObject2);
          Log.i(this.TAG, "tailSubtitle:".concat(String.valueOf(localObject2)));
        }
        if (((CharSequence)localObject1).length() <= 0) {
          break label659;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label662;
        }
        paramk = new com.tencent.mm.plugin.finder.live.viewmodel.data.k((String)localObject1, paramk.index, (int)(k * (((String)localObject1).length() / m)));
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.addFirst(paramk);
        Log.i(this.TAG, "headSubtitle:" + paramk + ",findSingleLineWord:" + bool);
        AppMethodBeat.o(274398);
        return;
        i = 0;
        break;
      }
      break;
      bool = false;
      localObject2 = "";
      break label327;
      i -= 1;
      break label245;
    }
  }
  
  private final boolean aCx(String paramString)
  {
    AppMethodBeat.i(274395);
    if (new StaticLayout((CharSequence)paramString, 0, paramString.length(), dCJ().getPaint(), this.maxWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= 1)
    {
      AppMethodBeat.o(274395);
      return true;
    }
    AppMethodBeat.o(274395);
    return false;
  }
  
  private final TextView dCJ()
  {
    AppMethodBeat.i(274387);
    TextView localTextView = (TextView)this.yxH.getValue();
    AppMethodBeat.o(274387);
    return localTextView;
  }
  
  private final void dCK()
  {
    AppMethodBeat.i(274392);
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.isEmpty()) || (dAn().isDestroyed()))
    {
      dCJ().setText((CharSequence)"");
      AppMethodBeat.o(274392);
      return;
    }
    this.yxJ = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.pollFirst());
    Object localObject = this.yxJ;
    if (localObject != null)
    {
      String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject).subtitle;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    this.yxI = ((String)localObject);
    localObject = (CharSequence)this.yxI;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(274392);
      return;
    }
    if (aCx(this.yxI)) {}
    for (localObject = this.yxJ;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.k)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.pollFirst())
    {
      this.yxG = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject);
      dCL();
      AppMethodBeat.o(274392);
      return;
      a(this.yxJ);
    }
  }
  
  private final void dCL()
  {
    AppMethodBeat.i(274394);
    TextView localTextView = dCJ();
    Object localObject = this.yxG;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject).subtitle;
      if (localObject != null)
      {
        localObject = (CharSequence)localObject;
        localTextView.setText((CharSequence)localObject);
        localObject = this.yxG;
        if (localObject == null) {
          break label92;
        }
      }
    }
    label92:
    for (long l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject).duration;; l = 100L)
    {
      dCJ().postDelayed((Runnable)new a(this), l);
      AppMethodBeat.o(274394);
      return;
      localObject = (CharSequence)"";
      break;
    }
  }
  
  public final void aCw(String paramString)
  {
    AppMethodBeat.i(274390);
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgD) || (paramString == null))
    {
      if ((this.yxF) && (paramString != null))
      {
        Log.i(this.TAG, "updateSubtitle msg:" + paramString + ", disable subtitle!");
        this.yxF = false;
      }
      AppMethodBeat.o(274390);
      return;
    }
    try
    {
      localObject1 = new i(paramString);
      if (((i)localObject1).optInt("wxt") == e.o.kkO.value)
      {
        int i = ((i)localObject1).MK("subtitle").optInt("index");
        int j = ((i)localObject1).MK("subtitle").optInt("duration");
        localObject1 = ((i)localObject1).MK("subtitle").optString("chn");
        Object localObject2 = this.yxG;
        if ((localObject2 == null) || (i != ((com.tencent.mm.plugin.finder.live.viewmodel.data.k)localObject2).index))
        {
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          com.tencent.mm.plugin.finder.live.utils.a.ha(this.TAG, "msg:" + paramString + ",subtitleInfo:" + a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE));
          p.j(localObject1, "chn");
          dCJ().getHandler().removeCallbacksAndMessages(null);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.clear();
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgE.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.k((String)localObject1, i, j));
          dCK();
          AppMethodBeat.o(274390);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject1 = aj.AGc;
      aj.a(paramString, this.TAG + ",updateSubtitle");
      AppMethodBeat.o(274390);
    }
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(274388);
    Log.i(this.TAG, "checkVisible enableSubtitle:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgD);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgD)
    {
      AppMethodBeat.o(274388);
      return;
    }
    Object localObject;
    float f;
    boolean bool;
    if (isLandscape())
    {
      dCJ().setTextSize(1, 22.0F);
      tU(0);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.b((d)this);
      if (!isLandscape()) {
        break label247;
      }
      f = ax.au(this.kiF.getContext()).x;
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.k(getBuContext()))
      {
        locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (!com.tencent.mm.plugin.finder.live.utils.a.l(getBuContext())) {
          break label242;
        }
      }
      bool = true;
    }
    label176:
    for (int i = (int)(f - com.tencent.mm.plugin.finder.live.utils.a.E((Context)localObject, bool) * 2);; i = (int)(f - ((Context)localObject).getResources().getDimensionPixelOffset(b.d.Edge_2A) * 2))
    {
      this.maxWidth = i;
      Log.i(this.TAG, "calMaxWidth:" + this.maxWidth);
      AppMethodBeat.o(274388);
      return;
      dCJ().setTextSize(1, 15.0F);
      break;
      label242:
      bool = false;
      break label176;
      label247:
      f = ax.au(this.kiF.getContext()).x;
      localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
    }
  }
  
  public final boolean dAo()
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(cn paramcn) {}
    
    public final void run()
    {
      AppMethodBeat.i(291156);
      cn.a(this.yxK);
      AppMethodBeat.o(291156);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<TextView>
  {
    b(ViewGroup paramViewGroup)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cn
 * JD-Core Version:    0.7.0.1
 */