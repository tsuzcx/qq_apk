package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import com.tencent.mm.h.c.ao;

public class SeeMemberRecordUI
  extends SelectMemberUI
{
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    super.a(paramView, paramInt, paramLong);
    paramView = this.drW.go(paramInt).dnp.field_username;
    XM();
    Intent localIntent = new Intent(this, SelectedMemberChattingRecordUI.class);
    localIntent.putExtra("RoomInfo_Id", this.dpj);
    localIntent.putExtra("room_member", paramView);
    localIntent.putExtra("title", getString(a.i.select_by_member_title));
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = TransitionInflater.from(this).inflateTransition(17760258);
      paramBundle.excludeTarget(getWindow().getDecorView().findViewById(a.e.action_bar_container), true);
      paramBundle.excludeTarget(16908335, true);
      getWindow().setEnterTransition(paramBundle);
    }
  }
  
  public final boolean xN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeMemberRecordUI
 * JD-Core Version:    0.7.0.1
 */