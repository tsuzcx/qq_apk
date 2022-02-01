package com.tencent.mm.chatroom.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;

final class ModRemarkRoomNameUI$5
  implements Runnable
{
  ModRemarkRoomNameUI$5(ModRemarkRoomNameUI paramModRemarkRoomNameUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(187438);
    Log.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(this.jbR).getHeight()), Integer.valueOf(this.jbS) });
    if (ModRemarkRoomNameUI.e(this.jbR).getHeight() > this.jbS) {
      ModRemarkRoomNameUI.f(this.jbR).scrollBy(0, ModRemarkRoomNameUI.e(this.jbR).getHeight() - this.jbS);
    }
    AppMethodBeat.o(187438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.5
 * JD-Core Version:    0.7.0.1
 */