package com.tencent.mm.plugin.finder.live.plugin;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicPlayerFrameSetPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicFrameSetPlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getFrameSetParentId", "", "requestLayout", "", "preview", "Landroid/view/View;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends an
{
  private final ViewGroup CZa;
  private final b nfT;
  
  public ap(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355809);
    this.CZa = paramViewGroup;
    this.nfT = paramb;
    AppMethodBeat.o(355809);
  }
  
  public final String eqi()
  {
    return "game_player_frame_set_container";
  }
  
  public final void fY(View paramView)
  {
    AppMethodBeat.i(355821);
    s.u(paramView, "preview");
    Object localObject1 = new int[2];
    paramView.getLocationOnScreen((int[])localObject1);
    Object localObject2 = this.mJe.getResources();
    if (localObject2 != null)
    {
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      if (localObject2 != null) {
        int i = ((DisplayMetrics)localObject2).widthPixels;
      }
    }
    bf.getStatusBarHeight(this.mJe.getContext());
    localObject2 = this.CZa.getLayoutParams();
    if (!isLandscape())
    {
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(355821);
        throw paramView;
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject2).width = paramView.getWidth();
      ((RelativeLayout.LayoutParams)localObject2).height = paramView.getHeight();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = localObject1[1];
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = localObject1[0];
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      this.CZa.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if ((((RelativeLayout.LayoutParams)localObject2).width == 0) || (((RelativeLayout.LayoutParams)localObject2).height == 0)) {
        Log.i("FinderLiveGameDynamicPlayerFrameSetPlugin", "width or height is invalid");
      }
      if (((RelativeLayout.LayoutParams)localObject2).topMargin == 0)
      {
        Log.i("FinderLiveGameDynamicPlayerFrameSetPlugin", "topMargin is invalid");
        AppMethodBeat.o(355821);
      }
    }
    else
    {
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(355821);
        throw paramView;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject1).width = paramView.getWidth();
      ((RelativeLayout.LayoutParams)localObject1).height = paramView.getHeight();
      this.CZa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(355821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ap
 * JD-Core Version:    0.7.0.1
 */