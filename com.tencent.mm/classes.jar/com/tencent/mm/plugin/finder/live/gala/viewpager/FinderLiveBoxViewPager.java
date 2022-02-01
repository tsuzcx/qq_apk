package com.tencent.mm.plugin.finder.live.gala.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.view.sidebar.DraggableConstraintLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/FinderLiveBoxViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveBoxViewPager
  extends ViewPager
{
  public static final a Companion;
  public static final String TAG = "FinderLiveBoxViewPager";
  
  static
  {
    AppMethodBeat.i(371174);
    Companion = new a((byte)0);
    AppMethodBeat.o(371174);
  }
  
  public FinderLiveBoxViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(371159);
    AppMethodBeat.o(371159);
  }
  
  public FinderLiveBoxViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(371167);
    AppMethodBeat.o(371167);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(371176);
    Object localObject;
    label17:
    label22:
    label27:
    int i;
    if (paramMotionEvent == null)
    {
      localObject = null;
      if (localObject != null) {
        break label84;
      }
      if (localObject != null) {
        break label121;
      }
      if (localObject != null) {
        break label135;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (DraggableConstraintLayout)getRootView().findViewById(p.e.sidebar_body_left);
        if (localObject != null) {
          ((DraggableConstraintLayout)localObject).setNeedIntercept(true);
        }
      }
      for (;;)
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(371176);
        return bool;
        localObject = Integer.valueOf(paramMotionEvent.getAction());
        break;
        label84:
        if (((Integer)localObject).intValue() != 0) {
          break label17;
        }
        localObject = (DraggableConstraintLayout)getRootView().findViewById(p.e.sidebar_body_left);
        if (localObject != null) {
          ((DraggableConstraintLayout)localObject).setNeedIntercept(false);
        }
      }
      label121:
      if (((Integer)localObject).intValue() != 1) {
        break label22;
      }
      i = 1;
      continue;
      label135:
      if (((Integer)localObject).intValue() != 3) {
        break label27;
      }
      i = 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/viewpager/FinderLiveBoxViewPager$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.viewpager.FinderLiveBoxViewPager
 * JD-Core Version:    0.7.0.1
 */