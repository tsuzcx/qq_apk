package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d
  implements j
{
  private Context context;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(26512);
    Toast.makeText(this.context, this.context.getString(2131761174), 0).show();
    AppMethodBeat.o(26512);
  }
  
  public final void dlA() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.d
 * JD-Core Version:    0.7.0.1
 */