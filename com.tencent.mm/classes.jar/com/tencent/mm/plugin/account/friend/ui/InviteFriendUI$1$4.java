package com.tencent.mm.plugin.account.friend.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

final class InviteFriendUI$1$4
  implements n.d
{
  InviteFriendUI$1$4(InviteFriendUI.1 param1, HashMap paramHashMap, Uri paramUri, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = paramMenuItem.getTitle();
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(((ResolveInfo)this.fhU.get(paramMenuItem)).activityInfo.packageName, ((ResolveInfo)this.fhU.get(paramMenuItem)).activityInfo.name));
    localIntent.setAction("android.intent.action.SENDTO");
    localIntent.setData(this.fhX);
    localIntent.putExtra("sms_body", this.fhY);
    this.fhW.fhT.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1.4
 * JD-Core Version:    0.7.0.1
 */