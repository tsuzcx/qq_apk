package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.bd;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.k.j;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "globalLayoutCallbackCount", "", "globalLayoutCallbackFrequency", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "plugin-finder_release"})
public final class r
{
  private final String TAG;
  final com.tencent.mm.live.c.b hOp;
  public final ViewGroup hwr;
  public final d uFw;
  int uHO;
  final int uHP;
  
  public r(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(248188);
    this.hwr = paramViewGroup;
    this.hOp = paramb;
    this.uFw = paramd;
    this.TAG = "Finder.FinderLiveVisitorShoppingEntranceWidget";
    paramViewGroup = c.vCb;
    this.uHP = ((Number)c.duY().value()).intValue();
    this.hwr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248184);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new Bundle();
        localObject = this.uHQ.uFw.getLiveData();
        if (localObject != null)
        {
          localObject = ((g)localObject).uEm;
          if (localObject == null) {}
        }
        for (long l = ((axg)localObject).uko;; l = 0L)
        {
          paramAnonymousView.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", l);
          this.uHQ.hOp.statusChange(b.c.hMZ, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(248184);
          return;
        }
      }
    });
    this.hwr.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        Object localObject2 = null;
        AppMethodBeat.i(248185);
        Object localObject1 = this.uHQ;
        int i = ((r)localObject1).uHO;
        ((r)localObject1).uHO = (i + 1);
        if (i >= 2147483647) {
          this.uHQ.uHO = 0;
        }
        if (this.uHQ.uHO % this.uHQ.uHP == 0)
        {
          Object localObject3 = this.uHQ.hOp;
          localObject1 = localObject3;
          if (!(localObject3 instanceof FinderLiveVisitorPluginLayout)) {
            localObject1 = null;
          }
          localObject1 = (FinderLiveVisitorPluginLayout)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((FinderLiveVisitorPluginLayout)localObject1).getShoppingBubblePlugin();
            if (localObject1 != null)
            {
              localObject3 = m.vVH;
              Object localObject4;
              View localView;
              Object localObject5;
              Object localObject6;
              if ((!m.dBP()) && (((com.tencent.mm.live.c.a)localObject1).hwr.getVisibility() == 0))
              {
                localObject3 = ((bd)localObject1).utB;
                localObject4 = new int[2];
                ((l)localObject3).uHq.getLocationInWindow((int[])localObject4);
                localObject1 = y.vXH;
                localView = ((l)localObject3).uHi;
                localObject1 = ((l)localObject3).ulG;
                if ((localView != null) && (localObject1 != null))
                {
                  localObject5 = new int[2];
                  ((ViewGroup)localObject1).getLocationInWindow((int[])localObject5);
                  i = localObject5[0];
                  localObject1 = ((l)localObject3).ulG;
                  if (localObject1 == null) {
                    p.hyc();
                  }
                  int j = ((ViewGroup)localObject1).getWidth();
                  int k = localObject4[0];
                  localObject1 = ((l)localObject3).uHi;
                  if (localObject1 == null) {
                    p.hyc();
                  }
                  i = j.mZ(i + j - k - ((View)localObject1).getWidth() / 2 - ((l)localObject3).uHq.getWidth() / 2, 0);
                  float f = -i;
                  localObject1 = ((l)localObject3).uHi;
                  if (localObject1 == null) {
                    p.hyc();
                  }
                  if (f != ((View)localObject1).getTranslationX())
                  {
                    localObject5 = ((l)localObject3).TAG;
                    localObject6 = new StringBuilder("[visitor add shopping bubble] arrow:").append(((l)localObject3).uHi).append(" container:").append(((l)localObject3).ulG).append(" container.right:");
                    localObject1 = ((l)localObject3).ulG;
                    if (localObject1 == null) {
                      break label483;
                    }
                  }
                }
              }
              label483:
              for (localObject1 = Integer.valueOf(((ViewGroup)localObject1).getRight());; localObject1 = null)
              {
                localObject4 = ((StringBuilder)localObject6).append(localObject1).append(" loc:").append(localObject4[0]).append(',').append(localObject4[1]).append(" arrow.width:");
                localObject6 = ((l)localObject3).uHi;
                localObject1 = localObject2;
                if (localObject6 != null) {
                  localObject1 = Integer.valueOf(((View)localObject6).getWidth());
                }
                Log.i((String)localObject5, localObject1 + " entranceRoot.width:" + ((l)localObject3).uHq.getWidth() + ",arrowMarginEnd:" + i);
                localView.setTranslationX(-i);
                AppMethodBeat.o(248185);
                return;
              }
            }
          }
        }
        AppMethodBeat.o(248185);
      }
    });
    Log.i(this.TAG, "init globalLayoutCallbackFrequency:" + this.uHP);
    AppMethodBeat.o(248188);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(248187);
    if (this.hwr.getVisibility() == 0)
    {
      AppMethodBeat.o(248187);
      return true;
    }
    AppMethodBeat.o(248187);
    return false;
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(248186);
    if ((!this.uFw.getLiveData().isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = o.ujN;
      localObject = o.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((s)localObject).ag((View)this.hwr, paramInt);
        AppMethodBeat.o(248186);
        return;
      }
      AppMethodBeat.o(248186);
      return;
    }
    this.hwr.setVisibility(paramInt);
    AppMethodBeat.o(248186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.r
 * JD-Core Version:    0.7.0.1
 */