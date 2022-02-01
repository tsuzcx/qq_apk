package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderSelfUI
  extends MMFinderUI
{
  private static final int AuU = 1;
  private static final int AuV = 2;
  private static final String AuW = "INNER_ITEM_COUNT";
  private static final String AuX = "RED_DOT_EXIST_ON_ENTER";
  private static final String AuY = "key_from_sns_post";
  private static final String AuZ = "key_auto_show_post_bottom_sheet";
  private static final String Ava = "key_is_from_discovery";
  public static final a Avb;
  private final String TAG = "Finder.FinderSelfUI";
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(249635);
    Avb = new a((byte)0);
    AuU = 1;
    AuV = 2;
    AuW = "INNER_ITEM_COUNT";
    AuX = "RED_DOT_EXIST_ON_ENTER";
    AuY = "key_from_sns_post";
    AuZ = "key_auto_show_post_bottom_sheet";
    Ava = "key_is_from_discovery";
    AppMethodBeat.o(249635);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249640);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249640);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(249639);
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
    AppMethodBeat.o(249639);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249634);
    Set localSet = kotlin.a.ak.setOf(new Class[] { com.tencent.mm.plugin.finder.viewmodel.component.ak.class, com.tencent.mm.plugin.finder.live.viewmodel.component.d.class, com.tencent.mm.plugin.finder.live.ui.post.d.class });
    AppMethodBeat.o(249634);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfUI$Companion;", "", "()V", "ENTER_FAV_UI_REQ_CODE", "", "getENTER_FAV_UI_REQ_CODE", "()I", "ENTER_LIKE_UI_REQ_CODE", "getENTER_LIKE_UI_REQ_CODE", "INNER_ITEM_COUNT", "", "getINNER_ITEM_COUNT", "()Ljava/lang/String;", "KEY_AUTO_SHOW_POST_BOTTOM_SHEET", "getKEY_AUTO_SHOW_POST_BOTTOM_SHEET", "KEY_FROM_SNS_POST", "getKEY_FROM_SNS_POST", "KEY_IS_FROM_DISCOVERY", "getKEY_IS_FROM_DISCOVERY", "RED_DOT_EXIST_ON_ENTER", "getRED_DOT_EXIST_ON_ENTER", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelfUI paramFinderSelfUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167585);
      this.Avc.onBackPressed();
      AppMethodBeat.o(167585);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfUI
 * JD-Core Version:    0.7.0.1
 */