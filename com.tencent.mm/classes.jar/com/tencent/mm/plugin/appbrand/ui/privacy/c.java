package com.tencent.mm.plugin.appbrand.ui.privacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/AppBrandPrivacyFooterController;", "", "parent", "Landroid/view/ViewGroup;", "footerContentResId", "", "(Landroid/view/ViewGroup;I)V", "footer", "Landroid/view/View;", "getFooter", "()Landroid/view/View;", "footerContainerView", "footerView", "value", "", "isLoading", "()Z", "setLoading", "(Z)V", "loadingView", "Lcom/tencent/mm/ui/widget/ThreeDotsLoadingView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public boolean isLoading;
  private final View uiC;
  private final ThreeDotsLoadingView uiD;
  private final View uiE;
  public final View uiF;
  
  public c(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(322732);
    this.uiC = LayoutInflater.from(paramViewGroup.getContext()).inflate(ba.g.app_brand_privacy_manage_footer_layout, paramViewGroup, false);
    paramViewGroup = this.uiC;
    if (paramViewGroup == null)
    {
      paramViewGroup = null;
      this.uiD = paramViewGroup;
      paramViewGroup = this.uiC;
      if (paramViewGroup != null) {
        break label135;
      }
    }
    label135:
    for (paramViewGroup = localObject;; paramViewGroup = paramViewGroup.findViewById(ba.f.footer_view))
    {
      this.uiE = paramViewGroup;
      this.uiF = this.uiC;
      this.isLoading = true;
      paramViewGroup = this.uiC;
      if (paramViewGroup != null)
      {
        paramViewGroup = (TextView)paramViewGroup.findViewById(ba.f.footer_content_view);
        if (paramViewGroup != null) {
          paramViewGroup.setText(paramInt);
        }
      }
      setLoading(true);
      AppMethodBeat.o(322732);
      return;
      paramViewGroup = (ThreeDotsLoadingView)paramViewGroup.findViewById(ba.f.loading_view);
      break;
    }
  }
  
  public final void setLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(322738);
    this.isLoading = paramBoolean;
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.uiD;
      if (localObject != null)
      {
        ((ThreeDotsLoadingView)localObject).setVisibility(0);
        ((ThreeDotsLoadingView)localObject).jFe();
      }
      localObject = this.uiE;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        AppMethodBeat.o(322738);
      }
    }
    else
    {
      localObject = this.uiD;
      if (localObject != null)
      {
        ((ThreeDotsLoadingView)localObject).jFf();
        ((ThreeDotsLoadingView)localObject).setVisibility(8);
      }
      localObject = this.uiE;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    AppMethodBeat.o(322738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.c
 * JD-Core Version:    0.7.0.1
 */