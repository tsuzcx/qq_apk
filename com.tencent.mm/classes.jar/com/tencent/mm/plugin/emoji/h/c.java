package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  private final String TAG = "MicroMsg.emoji.UseSmileyTool";
  public int hcT;
  public String jjP;
  
  public c(int paramInt)
  {
    this.hcT = paramInt;
  }
  
  public static void a(Intent paramIntent, String paramString, Activity paramActivity)
  {
    if (paramIntent == null) {
      return;
    }
    a(paramIntent.getStringExtra("Select_Conv_User"), paramString, paramActivity);
  }
  
  public static void a(String paramString1, String paramString2, Activity paramActivity)
  {
    if (bk.bl(paramString1))
    {
      y.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString1);
    localIntent.putExtra("smiley_product_id", paramString2);
    b.eUR.e(localIntent, paramActivity);
  }
  
  public final void x(Activity paramActivity)
  {
    y.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", f.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", f.a.push_down_out);
    d.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, this.hcT);
    paramActivity.overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.c
 * JD-Core Version:    0.7.0.1
 */