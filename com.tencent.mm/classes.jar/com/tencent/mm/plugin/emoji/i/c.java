package com.tencent.mm.plugin.emoji.i;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private final String TAG = "MicroMsg.emoji.UseSmileyTool";
  public int qVk;
  public String uQY;
  public boolean uQZ;
  
  public c(int paramInt)
  {
    this.qVk = paramInt;
  }
  
  public final void O(Activity paramActivity)
  {
    AppMethodBeat.i(109445);
    Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", i.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", i.a.push_down_out);
    com.tencent.mm.by.c.d(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, this.qVk);
    paramActivity.overridePendingTransition(i.a.push_up_in, i.a.fast_faded_out);
    AppMethodBeat.o(109445);
  }
  
  public final void a(Intent paramIntent, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(109443);
    if (paramIntent == null)
    {
      AppMethodBeat.o(109443);
      return;
    }
    a(paramIntent.getStringExtra("Select_Conv_User"), paramString, paramActivity);
    AppMethodBeat.o(109443);
  }
  
  public final void a(String paramString1, String paramString2, Activity paramActivity)
  {
    AppMethodBeat.i(109444);
    if (Util.isNullOrNil(paramString1))
    {
      Log.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
      AppMethodBeat.o(109444);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("smiley_product_id", paramString2);
    if (this.uQZ) {
      localIntent.addFlags(268435456);
    }
    com.tencent.mm.plugin.emoji.c.mIG.d(localIntent, paramActivity);
    AppMethodBeat.o(109444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.i.c
 * JD-Core Version:    0.7.0.1
 */