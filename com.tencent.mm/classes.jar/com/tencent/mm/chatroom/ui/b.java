package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

public final class b
{
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localIntent = new Intent(paramActivity, RoomUpgradeUI.class);
      localIntent.setFlags(603979776);
      localIntent.putExtra("room_name", paramString);
      paramString = new Intent();
      paramString.setClassName(paramActivity, "com.tencent.mm.plugin.account.ui.bind.BindMobileUI");
      paramString.putExtra("is_bind_for_chatroom_upgrade", true);
      MMWizardActivity.b(paramActivity, paramString, localIntent);
      return;
    }
    Intent localIntent = new Intent(paramActivity, RoomUpgradeUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("room_name", paramString);
    localIntent.putExtra("announce_ok", true);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b
 * JD-Core Version:    0.7.0.1
 */