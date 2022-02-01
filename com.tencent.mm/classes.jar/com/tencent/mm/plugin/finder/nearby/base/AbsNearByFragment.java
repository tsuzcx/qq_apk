package com.tencent.mm.plugin.finder.nearby.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "tabType", "", "(I)V", "titleId", "(II)V", "title", "", "(Ljava/lang/String;I)V", "args", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "clickSubTabContextId", "clickTabId", "getTabType", "()I", "setTabType", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitleId", "setTitleId", "getClickSubTabContextId", "getClickSubTabId", "getClickTabId", "getCommentScene", "getPageName", "getReportType", "isNeedSwitchTabOnResume", "", "onActionbarClick", "", "onActionbarDoubleClick", "onBackPressed", "onMenuClick", "onResume", "onUserVisibleUnFocused", "setClickSubTabContextId", "setClickTabId", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AbsNearByFragment
  extends MMFinderFragment
{
  private String DnS = "";
  public int EHx;
  public Bundle EHy;
  private String EHz = "";
  public int hJx;
  public String title = "";
  
  public AbsNearByFragment()
  {
    this.title = "";
    this.hJx = -1;
  }
  
  public AbsNearByFragment(int paramInt1, int paramInt2)
  {
    this.EHx = paramInt1;
    this.hJx = paramInt2;
  }
  
  public final void ayW(String paramString)
  {
    s.u(paramString, "clickTabId");
    this.EHz = paramString;
  }
  
  public final void ayX(String paramString)
  {
    s.u(paramString, "clickSubTabContextId");
    this.DnS = paramString;
  }
  
  public void eEp() {}
  
  public void eEq() {}
  
  public void eEr() {}
  
  public boolean eEs()
  {
    return true;
  }
  
  public String eEt()
  {
    return this.EHz;
  }
  
  public String eEu()
  {
    return "";
  }
  
  public final String eEv()
  {
    if ((TextUtils.isEmpty((CharSequence)this.DnS)) && (!TextUtils.isEmpty((CharSequence)eEu()))) {
      this.DnS = (eEu() + '-' + cn.bDw());
    }
    return this.DnS;
  }
  
  public String eEw()
  {
    return "1001";
  }
  
  public int edC()
  {
    return 3;
  }
  
  public int getCommentScene()
  {
    return 0;
  }
  
  public void onResume()
  {
    if (eEs())
    {
      g localg = g.ERj;
      g.d(this);
    }
    super.onResume();
  }
  
  public void onUserVisibleUnFocused()
  {
    super.onUserVisibleUnFocused();
    this.EHy = null;
  }
  
  public final void setTitle(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment
 * JD-Core Version:    0.7.0.1
 */