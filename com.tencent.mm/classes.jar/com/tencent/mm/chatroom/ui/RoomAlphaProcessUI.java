package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(3)
@Deprecated
public class RoomAlphaProcessUI
  extends MMActivity
  implements d.a
{
  private String chatroomName;
  
  private static void z(Runnable paramRunnable)
  {
    AppMethodBeat.i(12680);
    new MMHandler().postDelayed(paramRunnable, 200L);
    AppMethodBeat.o(12680);
  }
  
  public final void f(final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(12681);
    if (paramBoolean)
    {
      k.cZ(this, getString(a.i.lJn));
      z(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12674);
          Object localObject = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
          ((Intent)localObject).setFlags(603979776);
          ((Intent)localObject).putExtra("room_name", RoomAlphaProcessUI.a(RoomAlphaProcessUI.this));
          ((Intent)localObject).putExtra("upgrade_success", paramBoolean);
          ((Intent)localObject).putExtra("left_quota", paramInt);
          RoomAlphaProcessUI localRoomAlphaProcessUI = RoomAlphaProcessUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localRoomAlphaProcessUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localRoomAlphaProcessUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localRoomAlphaProcessUI, "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(12674);
        }
      });
      AppMethodBeat.o(12681);
      return;
    }
    k.d(this, getString(a.i.lJm), "", null);
    z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(12675);
        Object localObject = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
        ((Intent)localObject).setFlags(603979776);
        ((Intent)localObject).putExtra("room_name", RoomAlphaProcessUI.a(RoomAlphaProcessUI.this));
        ((Intent)localObject).putExtra("upgrade_success", paramBoolean);
        RoomAlphaProcessUI localRoomAlphaProcessUI = RoomAlphaProcessUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localRoomAlphaProcessUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localRoomAlphaProcessUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localRoomAlphaProcessUI, "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(12675);
      }
    });
    AppMethodBeat.o(12681);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initView() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12676);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    paramBundle = new aa(this.chatroomName);
    d.2 local2 = new d.2(k.a(this, getString(a.i.loading_tips), false, new d.1()), this, this);
    h.baD().mCm.a(482, local2);
    h.baD().mCm.a(paramBundle, 0);
    AppMethodBeat.o(12676);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12679);
    super.onDestroy();
    AppMethodBeat.o(12679);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12678);
    super.onPause();
    AppMethodBeat.o(12678);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12677);
    super.onResume();
    AppMethodBeat.o(12677);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomAlphaProcessUI
 * JD-Core Version:    0.7.0.1
 */