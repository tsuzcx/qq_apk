package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import org.xwalk.core.Log;

public class SeeMemberRecordUI
  extends SelectMemberUI
{
  public final boolean Zg()
  {
    return true;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12823);
    super.a(paramView, paramInt, paramLong);
    paramView = this.fTn.lj(paramInt);
    if (paramView == null)
    {
      Log.e("MicroMsg.SeeMemberRecordUI", "item is null!");
      AppMethodBeat.o(12823);
      return;
    }
    if (paramView.contact == null)
    {
      Log.e("MicroMsg.SeeMemberRecordUI", "contact is null!");
      AppMethodBeat.o(12823);
      return;
    }
    paramView = paramView.contact.field_username;
    hideVKB();
    Intent localIntent = new Intent(this, SelectedMemberChattingRecordUI.class);
    localIntent.putExtra("RoomInfo_Id", this.fPi);
    localIntent.putExtra("room_member", paramView);
    localIntent.putExtra("title", getString(2131762976));
    paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahp(), "com/tencent/mm/chatroom/ui/SeeMemberRecordUI", "doSeeMemberRecord", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramView.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeMemberRecordUI", "doSeeMemberRecord", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12823);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12824);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131296345), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    AppMethodBeat.o(12824);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeMemberRecordUI
 * JD-Core Version:    0.7.0.1
 */