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
import com.tencent.mm.g.c.aq;

public class SeeMemberRecordUI
  extends SelectMemberUI
{
  public final boolean Kf()
  {
    return true;
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104281);
    super.a(paramView, paramInt, paramLong);
    paramView = this.ejE.iD(paramInt).contact.field_username;
    hideVKB();
    Intent localIntent = new Intent(this, SelectedMemberChattingRecordUI.class);
    localIntent.putExtra("RoomInfo_Id", this.egF);
    localIntent.putExtra("room_member", paramView);
    localIntent.putExtra("title", getString(2131303032));
    startActivity(localIntent);
    AppMethodBeat.o(104281);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104282);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(2131820956), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
    AppMethodBeat.o(104282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeMemberRecordUI
 * JD-Core Version:    0.7.0.1
 */