package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g
  implements Serializable
{
  public int MZ;
  public int atr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181779);
    this.atr = paramInt1;
    this.MZ = paramInt2;
    if (this.atr > this.MZ)
    {
      paramInt1 = this.MZ;
      this.MZ = this.atr;
      this.atr = paramInt1;
    }
    AppMethodBeat.o(181779);
  }
  
  public g(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(181780);
    AppMethodBeat.o(181780);
  }
  
  public final g fd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181781);
    this.atr = Math.max(0, this.atr - paramInt1);
    this.MZ += paramInt2;
    AppMethodBeat.o(181781);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.atr == this.MZ;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181782);
    String str = "[" + this.atr + ", " + this.MZ + "]";
    AppMethodBeat.o(181782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */