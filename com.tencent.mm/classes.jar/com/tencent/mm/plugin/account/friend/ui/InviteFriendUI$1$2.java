package com.tencent.mm.plugin.account.friend.ui;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.ui.base.n.b;
import java.util.HashMap;

final class InviteFriendUI$1$2
  implements n.b
{
  InviteFriendUI$1$2(InviteFriendUI.1 param1, HashMap paramHashMap, PackageManager paramPackageManager) {}
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    paramMenuItem = paramMenuItem.getTitle();
    paramMenuItem = ((ResolveInfo)this.fhU.get(paramMenuItem)).loadLabel(this.fhV);
    if (paramMenuItem != null)
    {
      paramTextView.setText(paramMenuItem.toString());
      return;
    }
    paramTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1.2
 * JD-Core Version:    0.7.0.1
 */