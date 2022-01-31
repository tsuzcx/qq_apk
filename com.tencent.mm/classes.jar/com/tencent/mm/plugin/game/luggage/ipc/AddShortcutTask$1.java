package com.tencent.mm.plugin.game.luggage.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.av.a;

final class AddShortcutTask$1
  implements av.a
{
  AddShortcutTask$1(AddShortcutTask paramAddShortcutTask) {}
  
  public final void ia(boolean paramBoolean)
  {
    AppMethodBeat.i(135846);
    this.njA.success = paramBoolean;
    AddShortcutTask.a(this.njA);
    AppMethodBeat.o(135846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask.1
 * JD-Core Version:    0.7.0.1
 */