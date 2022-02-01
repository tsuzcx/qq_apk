package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderSelfUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderSelfUI
  extends MMFinderUI
{
  private static final int vOc = 1;
  private static final int vOd = 2;
  private static final String vOe = "INNER_ITEM_COUNT";
  private static final String vOf = "RED_DOT_EXIST_ON_ENTER";
  private static final String vOg = "key_from_sns_post";
  public static final a vOh;
  private final String TAG = "Finder.FinderSelfUI";
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(252662);
    vOh = new a((byte)0);
    vOc = 1;
    vOd = 2;
    vOe = "INNER_ITEM_COUNT";
    vOf = "RED_DOT_EXIST_ON_ENTER";
    vOg = "key_from_sns_post";
    AppMethodBeat.o(252662);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252664);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252664);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252663);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(252663);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252661);
    Set localSet = ak.setOf(new Class[] { FinderSelfUIC.class, FinderLivePostBtnUIC.class });
    AppMethodBeat.o(252661);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167589);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(167589);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI$Companion;", "", "()V", "ENTER_FAV_UI_REQ_CODE", "", "getENTER_FAV_UI_REQ_CODE", "()I", "ENTER_LIKE_UI_REQ_CODE", "getENTER_LIKE_UI_REQ_CODE", "INNER_ITEM_COUNT", "", "getINNER_ITEM_COUNT", "()Ljava/lang/String;", "KEY_FROM_SNS_POST", "getKEY_FROM_SNS_POST", "RED_DOT_EXIST_ON_ENTER", "getRED_DOT_EXIST_ON_ENTER", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelfUI paramFinderSelfUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167585);
      this.vOi.onBackPressed();
      AppMethodBeat.o(167585);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */