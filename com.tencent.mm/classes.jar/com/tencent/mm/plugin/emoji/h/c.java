package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  private final String TAG = "MicroMsg.emoji.UseSmileyTool";
  public int iMG;
  public String lsI;
  
  public c(int paramInt)
  {
    this.iMG = paramInt;
  }
  
  public static void a(Intent paramIntent, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(53868);
    if (paramIntent == null)
    {
      AppMethodBeat.o(53868);
      return;
    }
    a(paramIntent.getStringExtra("Select_Conv_User"), paramString, paramActivity);
    AppMethodBeat.o(53868);
  }
  
  public static void a(String paramString1, String paramString2, Activity paramActivity)
  {
    AppMethodBeat.i(53869);
    if (bo.isNullOrNil(paramString1))
    {
      ab.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
      AppMethodBeat.o(53869);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("smiley_product_id", paramString2);
    b.gmO.d(localIntent, paramActivity);
    AppMethodBeat.o(53869);
  }
  
  public final void A(Activity paramActivity)
  {
    AppMethodBeat.i(53870);
    ab.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
    d.b(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, this.iMG);
    paramActivity.overridePendingTransition(2131034230, 2131034182);
    AppMethodBeat.o(53870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.c
 * JD-Core Version:    0.7.0.1
 */