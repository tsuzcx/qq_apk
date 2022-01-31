package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.chatroom.c.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
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
  
  private static void p(Runnable paramRunnable)
  {
    AppMethodBeat.i(104134);
    new ak().postDelayed(paramRunnable, 200L);
    AppMethodBeat.o(104134);
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(104135);
    if (paramBoolean)
    {
      h.bO(this, getString(2131302815));
      p(new RoomAlphaProcessUI.1(this, paramBoolean, paramInt));
      AppMethodBeat.o(104135);
      return;
    }
    h.a(this, getString(2131302814), "", null);
    p(new RoomAlphaProcessUI.2(this, paramBoolean));
    AppMethodBeat.o(104135);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104130);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    paramBundle = new q(this.chatroomName);
    b.2 local2 = new b.2(h.b(this, getString(2131301086), false, new b.1()), this, this);
    g.RK().eHt.a(482, local2);
    g.RK().eHt.a(paramBundle, 0);
    AppMethodBeat.o(104130);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104133);
    super.onDestroy();
    AppMethodBeat.o(104133);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104132);
    super.onPause();
    AppMethodBeat.o(104132);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104131);
    super.onResume();
    AppMethodBeat.o(104131);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI
 * JD-Core Version:    0.7.0.1
 */