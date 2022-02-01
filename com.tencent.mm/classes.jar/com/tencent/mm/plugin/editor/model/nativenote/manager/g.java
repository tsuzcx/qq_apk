package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g
  implements Serializable
{
  public int uG;
  public int uH;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181779);
    this.uG = paramInt1;
    this.uH = paramInt2;
    if (this.uG > this.uH)
    {
      paramInt1 = this.uH;
      this.uH = this.uG;
      this.uG = paramInt1;
    }
    AppMethodBeat.o(181779);
  }
  
  public g(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(181780);
    AppMethodBeat.o(181780);
  }
  
  public final g gM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181781);
    this.uG = Math.max(0, this.uG - paramInt1);
    this.uH += paramInt2;
    AppMethodBeat.o(181781);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.uG == this.uH;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181782);
    String str = "[" + this.uG + ", " + this.uH + "]";
    AppMethodBeat.o(181782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */