package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g
  implements Serializable
{
  public int tH;
  public int tI;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181779);
    this.tH = paramInt1;
    this.tI = paramInt2;
    if (this.tH > this.tI)
    {
      paramInt1 = this.tI;
      this.tI = this.tH;
      this.tH = paramInt1;
    }
    AppMethodBeat.o(181779);
  }
  
  public g(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(181780);
    AppMethodBeat.o(181780);
  }
  
  public final g fV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181781);
    this.tH = Math.max(0, this.tH - paramInt1);
    this.tI += paramInt2;
    AppMethodBeat.o(181781);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.tH == this.tI;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181782);
    String str = "[" + this.tH + ", " + this.tI + "]";
    AppMethodBeat.o(181782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */