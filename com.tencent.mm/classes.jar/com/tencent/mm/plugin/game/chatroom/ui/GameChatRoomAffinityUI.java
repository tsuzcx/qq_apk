package com.tencent.mm.plugin.game.chatroom.ui;

import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.plugin.game.chatroom.h.h;
import com.tencent.mm.plugin.game.protobuf.dh;
import com.tencent.mm.plugin.game.protobuf.r;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/ui/GameChatRoomAffinityUI;", "Lcom/tencent/mm/plugin/game/chatroom/ui/GameChatRoomUI;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameChatRoomAffinityUI
  extends GameChatRoomUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(276063);
    super.onCreate(paramBundle);
    Bitmap localBitmap = com.tencent.mm.svg.a.a.b(getContext().getResources(), h.g.game_chat_room_logo, 3.0F);
    paramBundle = com.tencent.mm.plugin.game.commlib.a.fDY();
    if (paramBundle == null) {
      paramBundle = (Bundle)localObject;
    }
    for (;;)
    {
      localObject = paramBundle;
      if (paramBundle == null)
      {
        localObject = getContext().getString(h.h.IiN);
        s.s(localObject, "context.getString(R.stri…game_chatroom_brand_name)");
      }
      setTaskDescription(new ActivityManager.TaskDescription((String)localObject, localBitmap, 0));
      AppMethodBeat.o(276063);
      return;
      dh localdh = paramBundle.IHS;
      paramBundle = (Bundle)localObject;
      if (localdh != null) {
        paramBundle = localdh.ILl;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomAffinityUI
 * JD-Core Version:    0.7.0.1
 */