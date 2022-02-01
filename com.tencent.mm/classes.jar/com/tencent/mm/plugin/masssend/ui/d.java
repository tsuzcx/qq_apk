package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
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
  
  public final void A(boolean paramBoolean, int paramInt) {}
  
  public final void cpE() {}
  
  public final void cpF() {}
  
  public final void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(26512);
    Toast.makeText(this.context, this.context.getString(R.l.eLy), 0).show();
    AppMethodBeat.o(26512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.d
 * JD-Core Version:    0.7.0.1
 */