package com.tencent.mm.plugin.game.chatroom.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.e;
import com.tencent.mm.sdk.platformtools.Log;

final class GameChatRoomUI$9$1
  implements Runnable
{
  GameChatRoomUI$9$1(GameChatRoomUI.9 param9, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(292794);
    final Bitmap localBitmap = e.c(this.val$bitmap, GameChatRoomUI.g(this.NTa.Cwp).getHeight(), GameChatRoomUI.g(this.NTa.Cwp).getWidth());
    if (localBitmap != null)
    {
      Log.i("GameChatRoom.GameChatRoomUI", "resultBitmap height:%d, width:%d", new Object[] { Integer.valueOf(localBitmap.getHeight()), Integer.valueOf(localBitmap.getWidth()) });
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292824);
          GameChatRoomUI.g(GameChatRoomUI.9.1.this.NTa.Cwp).setImageBitmap(localBitmap);
          AppMethodBeat.o(292824);
        }
      });
    }
    AppMethodBeat.o(292794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI.9.1
 * JD-Core Version:    0.7.0.1
 */