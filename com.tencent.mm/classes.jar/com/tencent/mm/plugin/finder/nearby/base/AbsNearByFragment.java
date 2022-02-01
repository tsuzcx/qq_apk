package com.tencent.mm.plugin.finder.nearby.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "tabType", "", "(I)V", "titleId", "(II)V", "title", "", "(Ljava/lang/String;I)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "clickSubTabContextId", "clickTabId", "getTabType", "()I", "setTabType", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitleId", "setTitleId", "getClickSubTabContextId", "getClickSubTabId", "getClickTabId", "getCommentScene", "getPageName", "getReportType", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onMenuClick", "onResume", "onUserVisibleUnFocused", "onViewCreated", "view", "setClickSubTabContextId", "setClickTabId", "plugin-finder-nearby_release"})
public abstract class AbsNearByFragment
  extends MMFinderFragment
{
  private HashMap _$_findViewCache;
  public int fEH;
  public String title = "";
  public String yAU = "";
  public int zDq;
  public Bundle zDr;
  private String zDs = "";
  
  public AbsNearByFragment()
  {
    this.title = "";
    this.fEH = -1;
  }
  
  public AbsNearByFragment(int paramInt1, int paramInt2)
  {
    this.zDq = paramInt1;
    this.fEH = paramInt2;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final void aDy(String paramString)
  {
    p.k(paramString, "clickTabId");
    this.zDs = paramString;
  }
  
  public final String aiS()
  {
    if ((TextUtils.isEmpty((CharSequence)this.yAU)) && (!TextUtils.isEmpty((CharSequence)dLw()))) {
      this.yAU = (dLw() + "-" + cm.bfE());
    }
    return this.yAU;
  }
  
  public String akA()
  {
    return "1001";
  }
  
  public void dLs() {}
  
  public void dLt() {}
  
  public void dLu() {}
  
  public String dLv()
  {
    return this.zDs;
  }
  
  public String dLw()
  {
    return "";
  }
  
  public int duR()
  {
    return 3;
  }
  
  public int getCommentScene()
  {
    return 0;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    p.k(paramLayoutInflater, "inflater");
    if (getRootView() == null)
    {
      paramLayoutInflater = ad.kS(getContext()).inflate(getLayoutId(), paramViewGroup, false);
      Log.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
      paramViewGroup = ((Iterable)this.uiComponents).iterator();
      while (paramViewGroup.hasNext())
      {
        paramBundle = (UIComponent)paramViewGroup.next();
        p.j(paramLayoutInflater, "view");
        paramBundle.setRootView(paramLayoutInflater);
      }
      setRootView(paramLayoutInflater);
      hUd();
    }
    return getRootView();
  }
  
  public void onResume()
  {
    e locale = e.zJs;
    e.d(this);
    super.onResume();
  }
  
  public void onUserVisibleUnFocused()
  {
    super.onUserVisibleUnFocused();
    this.zDr = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = ((Iterable)this.uiComponents).iterator();
    while (paramView.hasNext()) {
      ((UIComponent)paramView.next()).onCreateBefore(paramBundle);
    }
  }
  
  public final void setTitle(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
 * JD-Core Version:    0.7.0.1
 */