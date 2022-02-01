package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class ak$c
  implements View.OnClickListener
{
  public ak$c(ak paramak, bcq parambcq) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(275416);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget$showShoppingBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    Object localObject2 = this.zri.zaJ;
    int i;
    if (localObject2 != null)
    {
      paramView = d.AjH;
      if (((Boolean)d.dXY().aSr()).booleanValue())
      {
        paramView = this.zrh.getLiveData();
        if (paramView != null)
        {
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramView != null) {
            paramView.zgJ = null;
          }
        }
        paramView = this.zrh.getLiveData();
        if (paramView != null)
        {
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramView != null)
          {
            paramView = paramView.zgK;
            if (paramView != null) {
              paramView.clear();
            }
          }
        }
      }
      localObject1 = this.zrh.getLiveData();
      if (localObject1 != null)
      {
        paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ;
        if (paramView == null) {
          break label392;
        }
        if (((CharSequence)paramView).length() <= 0) {
          break label387;
        }
        i = 1;
        if (i != 1) {
          break label392;
        }
        Log.i(ak.c(this.zrh), "get uxInfo from outsize:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ);
        paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgJ;
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject3 = ak.c(this.zrh);
        localStringBuilder = new StringBuilder("get uxInfo from promotingProduct,adid:").append(this.zri.zaI).append(",uxinfo:");
        localObject1 = this.zri.jDL;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        Log.i((String)localObject3, paramView);
        paramView = this.zri.jDL;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = "";
        }
      }
      paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      Object localObject3 = this.zrh.getContext();
      p.j(localObject3, "context");
      localObject2 = ((ch)localObject2).RHW;
      paramView = (View)localObject2;
      if (localObject2 == null) {
        paramView = "";
      }
      com.tencent.mm.plugin.finder.live.utils.a.B((Context)localObject3, paramView, (String)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingBubbleWidget$showShoppingBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(275416);
      return;
      label387:
      i = 0;
      break;
      label392:
      paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK;
      if (paramView != null)
      {
        paramView = Boolean.valueOf(paramView.containsKey(Long.valueOf(this.zri.zaI)));
        label427:
        if (!paramView.booleanValue()) {
          break label614;
        }
        paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK;
        if (paramView == null) {
          p.iCn();
        }
        paramView = (String)paramView.get(Long.valueOf(this.zri.zaI));
        if (paramView == null) {
          break label614;
        }
        if (((CharSequence)paramView).length() <= 0) {
          break label609;
        }
      }
      label609:
      for (i = 1;; i = 0)
      {
        if (i != 1) {
          break label614;
        }
        Log.i(ak.c(this.zrh), "get uxInfo from cgi-getShowShopSelf,adid:" + this.zri.zaI + ",uxinfo:" + (String)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.get(Long.valueOf(this.zri.zaI)));
        localObject1 = (String)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgK.get(Long.valueOf(this.zri.zaI));
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramView = "";
        break;
        paramView = null;
        break label427;
      }
      label614:
      localObject3 = ak.c(this.zrh);
      StringBuilder localStringBuilder = new StringBuilder("get uxInfo from promotingProduct,adid:").append(this.zri.zaI).append(",uxinfo:");
      localObject1 = this.zri.jDL;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      Log.i((String)localObject3, paramView);
      localObject1 = this.zri.jDL;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ak.c
 * JD-Core Version:    0.7.0.1
 */