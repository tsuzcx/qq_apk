package com.tencent.mm.chatroom.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.chatroom.ui.SeeRoomManagerUI;
import java.lang.ref.WeakReference;

final class a$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  a$1(a parama, WeakReference paramWeakReference, Bundle paramBundle) {}
  
  public final void onClickImp(View paramView)
  {
    if ((this.dmG != null) && (this.dmG.get() != null))
    {
      paramView = this.dmH.getString("conv_talker_username");
      Context localContext = (Context)this.dmG.get();
      Intent localIntent = new Intent(localContext, SeeRoomManagerUI.class);
      localIntent.setFlags(32768);
      localIntent.putExtra("RoomInfo_Id", paramView);
      localContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a.1
 * JD-Core Version:    0.7.0.1
 */