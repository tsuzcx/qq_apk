package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.cgi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$ViewHolder;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
public final class FinderLiveTaskBannerView$c
  extends RecyclerView.a<FinderLiveTaskBannerView.a>
{
  FinderLiveTaskBannerView$c(Context paramContext) {}
  
  public final int getItemCount()
  {
    AppMethodBeat.i(268806);
    LinkedList localLinkedList = FinderLiveTaskBannerView.a(this.zrC);
    if (localLinkedList != null)
    {
      int i = localLinkedList.size();
      AppMethodBeat.o(268806);
      return i;
    }
    AppMethodBeat.o(268806);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderLiveTaskBannerView.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282608);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.j(paramView, "view");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(282608);
        throw paramView;
      }
      int i = ((Integer)paramView).intValue();
      paramView = FinderLiveTaskBannerView.a(this.zrF.zrC);
      if (paramView != null) {
        paramView = (bbt)paramView.get(i);
      }
      while (paramView != null)
      {
        Log.i(FinderLiveTaskBannerView.b(this.zrF.zrC), " click posttion = " + i + ", reset = " + paramView.SNz + " ，activityICon:" + paramView.ufC);
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.c(this.zrF.$context, 4, paramView.EyH);
        h.IzE.a(22748, new Object[] { Integer.valueOf(4), Integer.valueOf(2), Long.valueOf(cm.bfE()), z.bdh(), "", paramView.OIw });
        localObject = paramView.OIw;
        p.j(localObject, "it.activity_id");
        new c((String)localObject).bhW();
        if (paramView.SNz == -1)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(282608);
          return;
          paramView = null;
        }
        else
        {
          paramView.SNz = i.ov(paramView.SNz - 1, 0);
          if (paramView.SNz == 0)
          {
            paramView = FinderLiveTaskBannerView.a(this.zrF.zrC);
            if (paramView != null) {
              d.a(paramView, (kotlin.g.a.b)a.zrG);
            }
            paramView = FinderLiveTaskBannerView.a(this.zrF.zrC);
            if (paramView != null)
            {
              paramView = (bbt)paramView.getFirst();
              localObject = FinderLiveTaskBannerView.a(this.zrF.zrC);
              if (localObject == null) {
                break label483;
              }
            }
            label483:
            for (localObject = (bbt)((LinkedList)localObject).getLast();; localObject = null)
            {
              if ((p.h(paramView, localObject) ^ true)) {
                FinderLiveTaskBannerView.c(this.zrF.zrC);
              }
              Log.i(FinderLiveTaskBannerView.b(this.zrF.zrC), "datalist after del");
              paramView = FinderLiveTaskBannerView.a(this.zrF.zrC);
              if (paramView == null) {
                break label488;
              }
              paramView = ((Iterable)paramView).iterator();
              while (paramView.hasNext())
              {
                localObject = (bbt)paramView.next();
                Log.i(FinderLiveTaskBannerView.b(this.zrF.zrC), String.valueOf(((bbt)localObject).OIw));
              }
              paramView = null;
              break;
            }
            label488:
            Log.i(FinderLiveTaskBannerView.b(this.zrF.zrC), "datalist after del");
            this.zrF.notifyDataSetChanged();
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView$init$1$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282608);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<bbt, Boolean>
    {
      public static final a zrG;
      
      static
      {
        AppMethodBeat.i(264928);
        zrG = new a();
        AppMethodBeat.o(264928);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView.c
 * JD-Core Version:    0.7.0.1
 */