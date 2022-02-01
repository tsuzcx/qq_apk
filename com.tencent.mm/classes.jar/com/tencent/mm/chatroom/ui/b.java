package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

public final class b
{
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(12767);
    if (paramBoolean)
    {
      localIntent = new Intent(paramActivity, RoomUpgradeUI.class);
      localIntent.setFlags(603979776);
      localIntent.putExtra("room_name", paramString);
      paramString = new Intent();
      paramString.setClassName(paramActivity, "com.tencent.mm.plugin.account.ui.bind.BindMobileUI");
      paramString.putExtra("is_bind_for_chatroom_upgrade", true);
      MMWizardActivity.b(paramActivity, paramString, localIntent);
      AppMethodBeat.o(12767);
      return;
    }
    Intent localIntent = new Intent(paramActivity, RoomUpgradeUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("room_name", paramString);
    localIntent.putExtra("announce_ok", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramString.ahp(), "com/tencent/mm/chatroom/ui/RoomUpgradeHelper", "goUpgrade", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/chatroom/ui/RoomUpgradeHelper", "goUpgrade", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.b
 * JD-Core Version:    0.7.0.1
 */