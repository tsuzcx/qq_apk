package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama, PaddingImageView paramPaddingImageView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53840);
    if (a.a(this.lsn) != null) {
      a.a(this.lsn).uk(this.jwn);
    }
    AppMethodBeat.o(53840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.a.1
 * JD-Core Version:    0.7.0.1
 */