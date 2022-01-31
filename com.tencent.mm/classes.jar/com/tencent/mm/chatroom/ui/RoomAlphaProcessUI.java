package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.chatroom.c.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
@Deprecated
public class RoomAlphaProcessUI
  extends MMActivity
  implements b.a
{
  private String chatroomName;
  
  private static void l(Runnable paramRunnable)
  {
    new ah().postDelayed(paramRunnable, 200L);
  }
  
  public final void c(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      h.bC(this, getString(a.i.room_upgrade_success));
      l(new RoomAlphaProcessUI.1(this, paramBoolean, paramInt));
      return;
    }
    h.a(this, getString(a.i.room_upgrade_result_failed), "", null);
    l(new RoomAlphaProcessUI.2(this, paramBoolean));
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initView() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    paramBundle = new q(this.chatroomName);
    b.2 local2 = new b.2(h.b(this, getString(a.i.loading_tips), false, new b.1()), this, this);
    g.DO().dJT.a(482, local2);
    g.DO().dJT.a(paramBundle, 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI
 * JD-Core Version:    0.7.0.1
 */