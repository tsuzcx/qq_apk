package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends e<Boolean, BoldSpan>
{
  public final int bTu()
  {
    return 0;
  }
  
  public final boolean cT(Object paramObject)
  {
    AppMethodBeat.i(181926);
    if (((paramObject instanceof BoldSpan)) || (((paramObject instanceof StyleSpan)) && (((StyleSpan)paramObject).getStyle() == 1)))
    {
      AppMethodBeat.o(181926);
      return true;
    }
    AppMethodBeat.o(181926);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.b
 * JD-Core Version:    0.7.0.1
 */