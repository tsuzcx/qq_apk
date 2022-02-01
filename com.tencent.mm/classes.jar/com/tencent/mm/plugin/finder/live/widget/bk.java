package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.plugin.by;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/IFinderLiveShoppingEntranceWidget;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "onMount", "onUnmount", "setVisible", "visible", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bk
  implements bn
{
  private static int Emw;
  private static final int Emx;
  public static final bk.a Ewj;
  public static a.a Ewk;
  private static final String TAG;
  public final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  public final ViewGroup mJe;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(361325);
    Ewj = new bk.a((byte)0);
    TAG = "Finder.FinderLiveVisitorShoppingEntranceWidget";
    Emx = 3;
    Ewk = new a.a((byte)0);
    AppMethodBeat.o(361325);
  }
  
  public bk(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.plugin.b paramb1)
  {
    AppMethodBeat.i(361270);
    this.mJe = paramViewGroup;
    this.nfT = paramb;
    this.CwG = paramb1;
    this.mJe.setOnClickListener(new bk..ExternalSyntheticLambda0(this));
    Log.i(TAG, s.X("init globalLayoutCallbackFrequency:", Integer.valueOf(Emx)));
    AppMethodBeat.o(361270);
  }
  
  private static final void a(bk parambk, View paramView)
  {
    AppMethodBeat.i(361288);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambk);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambk, "this$0");
    paramView = ((q)parambk.CwG.business(q.class)).Eie;
    localObject = new Bundle();
    if ((paramView instanceof k)) {
      ((Bundle)localObject).putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((k)paramView).DVk);
    }
    for (;;)
    {
      parambk.nfT.statusChange(b.c.ndB, (Bundle)localObject);
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361288);
      return;
      if ((paramView instanceof i)) {
        ((Bundle)localObject).putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((i)paramView).DUP);
      }
    }
  }
  
  public static void ehB()
  {
    a.a locala = Ewk;
    if (locala != null) {
      locala.Ewl = null;
    }
    locala = Ewk;
    if (locala != null) {
      locala.Ewm = null;
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(361342);
    if (((q)this.CwG.business(q.class)).EhZ)
    {
      tO(0);
      AppMethodBeat.o(361342);
      return;
    }
    tO(8);
    AppMethodBeat.o(361342);
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(361363);
    if (this.mJe.getVisibility() == 0)
    {
      AppMethodBeat.o(361363);
      return true;
    }
    AppMethodBeat.o(361363);
    return false;
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(361356);
    if (((d)h.ax(d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(361356);
      return;
    }
    if ((!((e)this.CwG.business(e.class)).isLiveStarted()) && (paramInt == 0))
    {
      ap localap = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
      if (localap != null)
      {
        localap.at((View)this.mJe, paramInt);
        AppMethodBeat.o(361356);
      }
    }
    else
    {
      this.mJe.setVisibility(paramInt);
    }
    AppMethodBeat.o(361356);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget$Companion$LayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "basePluginRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "rootRef", "Landroid/view/ViewGroup;", "(Ljava/lang/ref/SoftReference;Ljava/lang/ref/SoftReference;)V", "getBasePluginRef", "()Ljava/lang/ref/SoftReference;", "setBasePluginRef", "(Ljava/lang/ref/SoftReference;)V", "getRootRef", "setRootRef", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public SoftReference<com.tencent.mm.plugin.finder.live.plugin.b> Ewl = null;
    public SoftReference<ViewGroup> Ewm = null;
    
    public final void onGlobalLayout()
    {
      Object localObject2 = null;
      AppMethodBeat.i(361685);
      Object localObject1 = this.Ewl;
      SoftReference localSoftReference;
      if (localObject1 == null)
      {
        localObject1 = null;
        localSoftReference = this.Ewm;
        if (localSoftReference != null) {
          break label84;
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (localObject2 != null))
        {
          if (((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).isFinished())
          {
            ((ViewGroup)localObject2).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
            Log.i(bk.access$getTAG$cp(), s.X("watchShoppingEntrancePosition removeOnGlobalLayoutListener:", this));
            AppMethodBeat.o(361685);
            return;
            localObject1 = (com.tencent.mm.plugin.finder.live.plugin.b)((SoftReference)localObject1).get();
            break;
            label84:
            localObject2 = (ViewGroup)localSoftReference.get();
            continue;
          }
          localObject2 = bk.Ewj;
          int i = bk.eBX();
          bk.Qq(i + 1);
          if (i >= 2147483647)
          {
            localObject2 = bk.Ewj;
            bk.Qq(0);
          }
          if (bk.eBX() % bk.eBY() == 0)
          {
            localObject1 = (by)((com.tencent.mm.plugin.finder.live.plugin.b)localObject1).getPlugin(by.class);
            if (localObject1 != null) {
              ((by)localObject1).erX();
            }
          }
        }
      }
      AppMethodBeat.o(361685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bk
 * JD-Core Version:    0.7.0.1
 */