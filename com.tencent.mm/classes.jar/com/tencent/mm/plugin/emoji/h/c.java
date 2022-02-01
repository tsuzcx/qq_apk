package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  private final String TAG = "MicroMsg.emoji.UseSmileyTool";
  public int lzE;
  public String oJb;
  
  public c(int paramInt)
  {
    this.lzE = paramInt;
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
    if (bt.isNullOrNil(paramString1))
    {
      ad.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
      AppMethodBeat.o(109444);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("smiley_product_id", paramString2);
    b.hYt.d(localIntent, paramActivity);
    AppMethodBeat.o(109444);
  }
  
  public final void O(Activity paramActivity)
  {
    AppMethodBeat.i(109445);
    ad.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    d.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, this.lzE);
    paramActivity.overridePendingTransition(2130772108, 2130772048);
    AppMethodBeat.o(109445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.c
 * JD-Core Version:    0.7.0.1
 */