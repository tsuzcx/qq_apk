package com.tencent.mm.plugin.appbrand.openmaterial.ui;

import android.app.Dialog;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "titleView", "Landroid/view/View;", "getTitleView", "()Landroid/view/View;", "setTitleView", "(Landroid/view/View;)V", "hide", "", "show", "IListener", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends com.tencent.mm.vending.e.a
{
  public abstract Dialog getDialog();
  
  public abstract void hide();
  
  public abstract void setTitleView(View paramView);
  
  public abstract void show();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "", "onContentVisibleHeightChange", "", "height", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void CB(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.a
 * JD-Core Version:    0.7.0.1
 */