package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FTSVoiceInputLayoutImpl$2
  implements View.OnLongClickListener
{
  FTSVoiceInputLayoutImpl$2(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(62182);
    ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(this.ncg.currentState) });
    FTSVoiceInputLayoutImpl.a(this.ncg, true);
    paramView = FTSVoiceInputLayoutImpl.b(this.ncg);
    ab.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramView.currentState) });
    paramView.currentState = 7;
    paramView.invalidateSelf();
    AppMethodBeat.o(62182);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.2
 * JD-Core Version:    0.7.0.1
 */