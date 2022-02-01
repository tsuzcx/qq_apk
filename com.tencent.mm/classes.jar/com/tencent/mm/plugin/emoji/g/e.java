package com.tencent.mm.plugin.emoji.g;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  private final String TAG = "MicroMsg.emoji.UseSmileyTool";
  public int uaQ;
  public String ydM;
  public boolean ydN;
  
  public e(int paramInt)
  {
    this.uaQ = paramInt;
  }
  
  public final void X(Activity paramActivity)
  {
    AppMethodBeat.i(109445);
    Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", h.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", h.a.push_down_out);
    com.tencent.mm.br.c.d(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, this.uaQ);
    paramActivity.overridePendingTransition(h.a.push_up_in, h.a.fast_faded_out);
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
    if (this.ydN) {
      localIntent.addFlags(268435456);
    }
    com.tencent.mm.plugin.emoji.c.pFn.d(localIntent, paramActivity);
    AppMethodBeat.o(109444);
  }
  
  public final void u(Fragment paramFragment)
  {
    AppMethodBeat.i(269763);
    Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", h.a.fast_faded_in);
    localIntent.putExtra("MMActivity.OverrideExitAnimation", h.a.push_down_out);
    com.tencent.mm.br.c.a(paramFragment, ".ui.transmit.SelectConversationUI", localIntent, this.uaQ);
    paramFragment.getActivity().overridePendingTransition(h.a.push_up_in, h.a.fast_faded_out);
    AppMethodBeat.o(269763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.g.e
 * JD-Core Version:    0.7.0.1
 */