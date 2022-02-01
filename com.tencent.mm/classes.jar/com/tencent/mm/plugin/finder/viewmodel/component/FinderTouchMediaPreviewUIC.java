package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "attach", "", "find", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setScaleListener", "listener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Companion", "plugin-finder_release"})
public final class FinderTouchMediaPreviewUIC
  extends UIComponent
{
  public static final a wAS;
  
  static
  {
    AppMethodBeat.i(256039);
    wAS = new a((byte)0);
    AppMethodBeat.o(256039);
  }
  
  public FinderTouchMediaPreviewUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(256038);
    AppMethodBeat.o(256038);
  }
  
  private TouchMediaPreviewLayout dIP()
  {
    AppMethodBeat.i(256036);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = (TouchMediaPreviewLayout)getActivity().findViewById(2131309369);
    AppMethodBeat.o(256036);
    return localTouchMediaPreviewLayout;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(256037);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = dIP();
    if ((localTouchMediaPreviewLayout != null) && (localTouchMediaPreviewLayout.QFs == true))
    {
      localTouchMediaPreviewLayout = dIP();
      if (localTouchMediaPreviewLayout != null) {
        localTouchMediaPreviewLayout.gZk();
      }
      AppMethodBeat.o(256037);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(256037);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC
 * JD-Core Version:    0.7.0.1
 */