package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderUnOpenUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderUnOpenUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199473);
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
    AppMethodBeat.o(199473);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494123;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167681);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = g.Zd().getValue("FinderFunctionUnopenTip");
    Object localObject = findViewById(2131305880);
    k.g(localObject, "findViewById<TextView>(R.id.tip_tv)");
    localObject = (TextView)localObject;
    if (paramBundle != null) {}
    for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)getString(2131759386))
    {
      ((TextView)localObject).setText(paramBundle);
      AppMethodBeat.o(167681);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderUnOpenUI paramFinderUnOpenUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167680);
      this.qQo.finish();
      AppMethodBeat.o(167680);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderUnOpenUI
 * JD-Core Version:    0.7.0.1
 */