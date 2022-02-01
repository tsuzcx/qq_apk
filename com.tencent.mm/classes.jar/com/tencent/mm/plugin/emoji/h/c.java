package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private final String TAG = "MicroMsg.emoji.UseSmileyTool";
  public int nTL;
  public String rnF;
  
  public c(int paramInt)
  {
    this.nTL = paramInt;
  }
  
  public static void a(Intent paramIntent, String paramString, Activity paramActivity)
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
  
  public static void a(String paramString1, String paramString2, Activity paramActivity)
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
    com.tencent.mm.plugin.emoji.c.jRt.d(localIntent, paramActivity);
    AppMethodBeat.o(109444);
  }
  
  public final void N(Activity paramActivity)
  {
    AppMethodBeat.i(109445);
    Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
    com.tencent.mm.br.c.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, this.nTL);
    paramActivity.overridePendingTransition(2130772132, 2130772060);
    AppMethodBeat.o(109445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.c
 * JD-Core Version:    0.7.0.1
 */