package com.tencent.mm.plugin.finder.nearby.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "tabType", "", "(I)V", "titleId", "(II)V", "title", "", "(Ljava/lang/String;I)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "getTabType", "()I", "setTabType", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitleId", "setTitleId", "getClickTabContextId", "getCommentScene", "getPageName", "getReportType", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onMenuClick", "onResume", "onUserVisibleUnFocused", "onViewCreated", "view", "plugin-finder_release"})
public abstract class AbsNearByFragment
  extends UIComponentFragment
{
  public Bundle Ew;
  private HashMap _$_findViewCache;
  public int dLS;
  public String title = "";
  public int uQk;
  
  public AbsNearByFragment()
  {
    this.title = "";
    this.dLS = -1;
  }
  
  public AbsNearByFragment(int paramInt1, int paramInt2)
  {
    this.uQk = paramInt1;
    this.dLS = paramInt2;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public String ack()
  {
    return "1001";
  }
  
  public String afB()
  {
    return "1001";
  }
  
  public int ddN()
  {
    return 3;
  }
  
  public void dlk() {}
  
  public void dll() {}
  
  public void dlm() {}
  
  public int getCommentScene()
  {
    return 76;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    p.h(paramLayoutInflater, "inflater");
    if (this.lJI == null)
    {
      paramLayoutInflater = aa.jQ(getContext()).inflate(getLayoutId(), paramViewGroup, false);
      Log.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
      paramViewGroup = ((Iterable)this.uiComponents).iterator();
      while (paramViewGroup.hasNext())
      {
        paramBundle = (UIComponent)paramViewGroup.next();
        p.g(paramLayoutInflater, "view");
        paramBundle.setRootView(paramLayoutInflater);
      }
      this.lJI = paramLayoutInflater;
      this.PRX = true;
    }
    return this.lJI;
  }
  
  public void onResume()
  {
    d locald = d.uTq;
    d.b(this);
    super.onResume();
  }
  
  public void onUserVisibleUnFocused()
  {
    super.onUserVisibleUnFocused();
    this.Ew = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    p.h(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = ((Iterable)this.uiComponents).iterator();
    while (paramView.hasNext()) {
      ((UIComponent)paramView.next()).onCreateBefore(paramBundle);
    }
  }
  
  public final void setTitle(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
 * JD-Core Version:    0.7.0.1
 */