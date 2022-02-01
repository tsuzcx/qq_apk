package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ui.contact.t;
import org.xwalk.core.Log;

public class SeeMemberRecordUI
  extends SelectMemberUI
{
  private void Dj(String paramString)
  {
    AppMethodBeat.i(241714);
    hideVKB();
    Intent localIntent = new Intent(this, SelectedMemberChattingRecordUI.class);
    localIntent.putExtra("RoomInfo_Id", this.lyn);
    localIntent.putExtra("room_member", paramString);
    localIntent.putExtra("title", getString(a.i.lJq));
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/chatroom/ui/SeeMemberRecordUI", "doSeeMemberRecord", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/SeeMemberRecordUI", "doSeeMemberRecord", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(241714);
  }
  
  public final boolean aNl()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12824);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(a.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    AppMethodBeat.o(12824);
  }
  
  protected final void onItemClick(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(12823);
    super.onItemClick(paramView, paramInt, paramLong);
    if (getContentLV().getAdapter() == this.lNi)
    {
      paramView = this.lNi.qF(paramInt);
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
      Dj(paramView.contact.field_username);
      AppMethodBeat.o(12823);
      return;
    }
    if (getContentLV().getAdapter() == this.lNh) {
      Dj(this.lNh.aDt(paramInt).contact.field_username);
    }
    AppMethodBeat.o(12823);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeMemberRecordUI
 * JD-Core Version:    0.7.0.1
 */