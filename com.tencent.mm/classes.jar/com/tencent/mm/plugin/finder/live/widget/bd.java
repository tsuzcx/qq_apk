package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.j;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.view.adapter.l;
import com.tencent.mm.plugin.finder.live.view.adapter.l.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVideoDefinitionWidget;", "", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getContext", "()Landroid/content/Context;", "modifyVideoDefinition", "", "showLevel", "Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "getShowLevel", "()Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;", "setShowLevel", "(Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;)V", "getDefinitionList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveDefinitionAdapter$DefinitionInfo;", "release", "", "resolutionChange", "result", "showCustomerVideoLevel", "isLandscape", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  public static final bd.a EuM;
  public j EuN;
  public boolean EuO;
  public com.tencent.mm.plugin.finder.live.model.context.a buContext;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(361416);
    EuM = new bd.a((byte)0);
    AppMethodBeat.o(361416);
  }
  
  public bd(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(361376);
    this.context = paramContext;
    this.buContext = parama;
    AppMethodBeat.o(361376);
  }
  
  private static final void c(com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(361385);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVideoDefinitionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "$this_apply");
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVideoDefinitionWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361385);
  }
  
  public final void sH(boolean paramBoolean)
  {
    AppMethodBeat.i(361441);
    Log.i("FinderLiveVideoDefinitionWidget", s.X("getDefinitionList cur:", this.EuN));
    Object localObject2 = new LinkedList();
    Object localObject1 = this.EuN;
    if (localObject1 == null)
    {
      i = 0;
      localObject1 = aj.CGT;
      localObject1 = aj.elL();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.f.d)localObject1).mUn;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.live.core.core.d)localObject1).mJH;
          if (localObject1 != null)
          {
            localObject1 = ((g)localObject1).mNt.values();
            s.s(localObject1, "liveInfo.cdnUrlMap.values");
            localObject3 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject3 = ((Iterable)localObject3).iterator();
          }
        }
      }
    }
    else
    {
      label125:
      Object localObject5;
      int j;
      label186:
      label223:
      label226:
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label228;
        }
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (j)localObject4;
        if (((j)localObject5).level != 0)
        {
          localObject5 = (CharSequence)((j)localObject5).desc;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            j = 1;
            if (j != 0) {
              break label223;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label226;
          }
          ((Collection)localObject1).add(localObject4);
          break label125;
          i = ((j)localObject1).level;
          break;
          j = 0;
          break label186;
        }
      }
      label228:
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (j)((Iterator)localObject3).next();
        localObject5 = ((Iterable)localObject2).iterator();
        label277:
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = ((Iterator)localObject5).next();
          if (((l.b)localObject1).DQv.level == ((j)localObject4).level)
          {
            j = 1;
            label317:
            if (j == 0) {
              break label368;
            }
            label321:
            if (localObject1 != null) {
              break label382;
            }
            s.s(localObject4, "info");
            if (i != ((j)localObject4).level) {
              break label376;
            }
          }
        }
        label368:
        label376:
        for (boolean bool = true;; bool = false)
        {
          ((LinkedList)localObject2).add(new l.b((j)localObject4, bool));
          break;
          j = 0;
          break label317;
          break label277;
          localObject1 = null;
          break label321;
        }
        label382:
        Log.i("FinderLiveVideoDefinitionWidget", "getDefinitionList " + localObject4 + " repeat!");
      }
    }
    localObject1 = (List)localObject2;
    if (((List)localObject1).size() > 1) {
      p.a((List)localObject1, (Comparator)new b());
    }
    if (((LinkedList)localObject2).isEmpty())
    {
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      com.tencent.mm.plugin.finder.live.utils.a.aD((Context)localObject1, "可选分辨率为空");
      Log.i("FinderLiveVideoDefinitionWidget", "showCustomerVideoLevel definitionList is empty!");
      AppMethodBeat.o(361441);
      return;
    }
    localObject1 = new com.tencent.mm.ui.widget.a.h(this.context);
    ((com.tencent.mm.ui.widget.a.h)localObject1).jHQ();
    ((com.tencent.mm.ui.widget.a.h)localObject1).aFa(p.f.CfW);
    ((com.tencent.mm.ui.widget.a.h)localObject1).rootView.findViewById(p.e.BCC).setOnClickListener(new bd..ExternalSyntheticLambda0((com.tencent.mm.ui.widget.a.h)localObject1));
    Object localObject3 = (RecyclerView)((com.tencent.mm.ui.widget.a.h)localObject1).rootView.findViewById(p.e.BCD);
    ((RecyclerView)localObject3).getContext();
    ((RecyclerView)localObject3).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    Object localObject4 = new l();
    s.u(localObject2, "<set-?>");
    ((l)localObject4).vEn = ((LinkedList)localObject2);
    ((l)localObject4).nod = ((kotlin.g.a.b)new c(this, (com.tencent.mm.ui.widget.a.h)localObject1, (RecyclerView)localObject3));
    localObject2 = ah.aiuX;
    ((RecyclerView)localObject3).setAdapter((RecyclerView.a)localObject4);
    localObject2 = ((RecyclerView)localObject3).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(361441);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
    if (paramBoolean) {}
    for (int i = ((RecyclerView)localObject3).getContext().getResources().getDimensionPixelOffset(p.c.Edge_3A);; i = bf.bk(((RecyclerView)localObject3).getContext()) + i)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = i;
      ((com.tencent.mm.ui.widget.a.h)localObject1).dDn();
      AppMethodBeat.o(361441);
      return;
      i = ((RecyclerView)localObject3).getContext().getResources().getDimensionPixelOffset(p.c.Edge_7A);
    }
  }
  
  public final void sI(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(361448);
    Object localObject2 = new StringBuilder("resolutionChange result:").append(paramBoolean).append(",modifyVideoDefinition:").append(this.EuO).append(",showLevel:");
    Object localObject1 = this.EuN;
    int i;
    label107:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("FinderLiveVideoDefinitionWidget", localObject1);
      if (this.EuO)
      {
        this.EuO = false;
        if (paramBoolean)
        {
          localObject1 = k.Doi;
          localObject2 = this.EuN;
          if (localObject2 != null) {
            break label148;
          }
          i = 0;
          localObject2 = this.buContext;
          if (localObject2 != null) {
            break label157;
          }
          j = k;
        }
      }
    }
    for (;;)
    {
      ((k)localObject1).hL(i, j);
      AppMethodBeat.o(361448);
      return;
      localObject1 = Integer.valueOf(((j)localObject1).level);
      break;
      label148:
      i = ((j)localObject2).level;
      break label107;
      label157:
      localObject2 = (f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(f.class);
      j = k;
      if (localObject2 != null)
      {
        localObject2 = ((f)localObject2).mZu;
        j = k;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
          j = k;
          if (localObject2 != null) {
            j = ((g)localObject2).bem();
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(362254);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((l.b)paramT2).DQv.level), (Comparable)Integer.valueOf(((l.b)paramT1).DQv.level));
      AppMethodBeat.o(362254);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/live/core/core/model/LiveUrlInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<j, ah>
  {
    c(bd parambd, com.tencent.mm.ui.widget.a.h paramh, RecyclerView paramRecyclerView)
    {
      super();
    }
    
    private static final void invoke$lambda-0(View paramView)
    {
      AppMethodBeat.i(362173);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(p.e.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
        if (paramView != null) {
          paramView.setImageResource(p.g.finder_icons_video_definition);
        }
      }
      AppMethodBeat.o(362173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bd
 * JD-Core Version:    0.7.0.1
 */