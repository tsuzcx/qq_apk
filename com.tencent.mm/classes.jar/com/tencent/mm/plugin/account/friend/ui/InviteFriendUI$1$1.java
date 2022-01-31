package com.tencent.mm.plugin.account.friend.ui;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.ui.base.n.a;
import java.util.HashMap;

final class InviteFriendUI$1$1
  implements n.a
{
  InviteFriendUI$1$1(InviteFriendUI.1 param1, HashMap paramHashMap, PackageManager paramPackageManager) {}
  
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    paramMenuItem = paramMenuItem.getTitle();
    paramImageView.setImageDrawable(((ResolveInfo)this.fhU.get(paramMenuItem)).loadIcon(this.fhV));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1.1
 * JD-Core Version:    0.7.0.1
 */