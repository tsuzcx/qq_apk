package com.tencent.mm.plugin.appbrand.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.appbrand.z;
import com.tencent.mm.ui.base.n.d;

final class d$2
  implements n.d
{
  d$2(d paramd, com.tencent.mm.plugin.appbrand.page.q paramq, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      z.h(this.gjp.getRuntime());
      return;
    case 2: 
      paramMenuItem = ((com.tencent.mm.plugin.appbrand.appstorage.q)((n)this.gjp.getRuntime()).fzC.H(com.tencent.mm.plugin.appbrand.appstorage.q.class)).mRootPath;
      Toast.makeText(this.val$context, this.val$context.getString(y.j.app_brand_actionsheet_debug_entrance_nfs_path_clipborad_tip, new Object[] { paramMenuItem }), 0).show();
      paramMenuItem = ClipData.newPlainText("text", paramMenuItem);
      ((ClipboardManager)this.val$context.getSystemService("clipboard")).setPrimaryClip(paramMenuItem);
      return;
    case 3: 
      paramMenuItem = ClipData.newPlainText("text", this.gjp.mAppId);
      ((ClipboardManager)this.val$context.getSystemService("clipboard")).setPrimaryClip(paramMenuItem);
      Toast.makeText(this.val$context, this.val$context.getString(y.j.app_brand_actionsheet_debug_entrance_appid_clipboard_tip, new Object[] { this.gjp.mAppId }), 1).show();
      return;
    }
    this.gjp.getContentView().postDelayed(new d.2.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d.2
 * JD-Core Version:    0.7.0.1
 */