package com.tencent.mm.plugin.finder.live.gala.viewpager;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/LiveViewPagerPluginAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "plugins", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/gala/data/ViewPagerItemSelect;", "Lkotlin/collections/ArrayList;", "maxHeight", "", "(Ljava/util/ArrayList;I)V", "getMaxHeight", "()I", "getPlugins", "()Ljava/util/ArrayList;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "object", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends androidx.viewpager.widget.a
{
  public static final a admd;
  private final ArrayList<com.tencent.mm.plugin.finder.live.gala.a.a> aitO;
  private final int maxHeight;
  
  static
  {
    AppMethodBeat.i(371150);
    admd = new a((byte)0);
    AppMethodBeat.o(371150);
  }
  
  public c(ArrayList<com.tencent.mm.plugin.finder.live.gala.a.a> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(371144);
    this.aitO = paramArrayList;
    this.maxHeight = paramInt;
    AppMethodBeat.o(371144);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(371179);
    s.u(paramViewGroup, "container");
    s.u(paramObject, "object");
    Log.i("LiveViewPagerPluginAdap", s.X("destroyItem pos:", Integer.valueOf(paramInt)));
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(371179);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(371166);
    int i = this.aitO.size();
    AppMethodBeat.o(371166);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(371158);
    s.u(paramObject, "object");
    AppMethodBeat.o(371158);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(371177);
    s.u(paramViewGroup, "container");
    Log.i("LiveViewPagerPluginAdap", s.X("instantiateItem pos:", Integer.valueOf(paramInt)));
    View localView = ((com.tencent.mm.plugin.finder.live.gala.a.a)this.aitO.get(paramInt)).ivt();
    ((com.tencent.mm.plugin.finder.live.gala.a.a)this.aitO.get(paramInt)).aql(this.maxHeight);
    Object localObject = localView.getParent();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        break label239;
      }
      localObject = null;
      label83:
      if (s.p(localObject, "LiveViewPagerPluginAdap")) {
        break label265;
      }
      RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
      localRelativeLayout.setTag("LiveViewPagerPluginAdap");
      localObject = Integer.valueOf(localView.getWidth());
      if (((Number)localObject).intValue() == 0) {
        break label247;
      }
      paramInt = 1;
      label133:
      if (paramInt == 0) {
        break label252;
      }
      label137:
      if (localObject != null) {
        break label257;
      }
      paramInt = -1;
      label143:
      localObject = new RelativeLayout.LayoutParams(paramInt, this.maxHeight);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ah localah = ah.aiuX;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localRelativeLayout.addView(localView);
      paramViewGroup.addView((View)localRelativeLayout, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(paramInt, this.maxHeight));
    }
    for (;;)
    {
      paramViewGroup = localView.getParent();
      if (paramViewGroup != null) {
        break label306;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(371177);
      throw paramViewGroup;
      localObject = null;
      break;
      label239:
      localObject = ((ViewGroup)localObject).getTag();
      break label83;
      label247:
      paramInt = 0;
      break label133;
      label252:
      localObject = null;
      break label137;
      label257:
      paramInt = ((Integer)localObject).intValue();
      break label143;
      label265:
      localObject = localView.getParent();
      if (localObject == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(371177);
        throw paramViewGroup;
      }
      paramViewGroup.addView((View)localObject);
    }
    label306:
    paramViewGroup = (ViewGroup)paramViewGroup;
    AppMethodBeat.o(371177);
    return paramViewGroup;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    AppMethodBeat.i(371173);
    s.u(paramView, "view");
    s.u(paramObject, "object");
    boolean bool = s.p(paramView, paramObject);
    AppMethodBeat.o(371173);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/LiveViewPagerPluginAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.viewpager.c
 * JD-Core Version:    0.7.0.1
 */