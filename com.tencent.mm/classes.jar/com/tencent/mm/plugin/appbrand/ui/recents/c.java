package com.tencent.mm.plugin.appbrand.ui.recents;

import a.d.b.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.y.j;
import java.util.List;

public final class c
  extends d<w>
{
  public c(Activity paramActivity, ViewGroup paramViewGroup)
  {
    super(w.class, paramActivity, paramViewGroup);
  }
  
  protected final List<? extends LocalUsageInfo> apM()
  {
    return (List)((w)e.G(w.class)).kB(this.hgQ);
  }
  
  protected final String getTitle()
  {
    String str = getActivity().getString(y.j.app_brand_recents_list_header_recent_tag_wording);
    g.j(str, "activity.getString(com.t…eader_recent_tag_wording)");
    return str;
  }
  
  public final void onClick(View paramView)
  {
    paramView = AppBrandLauncherFolderUI.hcQ;
    paramView = getActivity();
    g.j(paramView, "activity");
    Context localContext = (Context)paramView;
    paramView = new Intent();
    paramView.putExtra("extra_get_usage_reason", 3);
    g.k(localContext, "context");
    Intent localIntent = new Intent(localContext, AppBrandLauncherFolderUI.class);
    if (!(localContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    Bundle localBundle = paramView.getExtras();
    paramView = localBundle;
    if (localBundle == null) {
      paramView = Bundle.EMPTY;
    }
    localIntent.putExtras(paramView);
    localIntent.putExtra("KEY_MODE", 1);
    localContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.c
 * JD-Core Version:    0.7.0.1
 */