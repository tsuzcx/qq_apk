package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "setWindowStyle", "", "Companion", "plugin-finder_release"})
public abstract class FinderLiveTagBaseUIC
  extends UIComponent
{
  public static final a wyA = new a((byte)0);
  
  public FinderLiveTagBaseUIC(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  protected final void dIl()
  {
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null) {
        throw new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      }
      ((MMActivity)localObject).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      localObject = ((Window)localObject).getDecorView();
      p.g(localObject, "context.window.decorView");
      ((View)localObject).setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC$Companion;", "", "()V", "KEY_HAS_NEXT_ACTION", "", "KEY_START_LIVE", "KEY_TAG_INFO", "REQUEST_CODE_SUB_TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveTagBaseUIC
 * JD-Core Version:    0.7.0.1
 */