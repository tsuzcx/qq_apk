package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g
  implements Serializable
{
  public int Pc;
  public int avh;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181779);
    this.avh = paramInt1;
    this.Pc = paramInt2;
    if (this.avh > this.Pc)
    {
      paramInt1 = this.Pc;
      this.Pc = this.avh;
      this.avh = paramInt1;
    }
    AppMethodBeat.o(181779);
  }
  
  public g(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(181780);
    AppMethodBeat.o(181780);
  }
  
  public final g fy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181781);
    this.avh = Math.max(0, this.avh - paramInt1);
    this.Pc += paramInt2;
    AppMethodBeat.o(181781);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.avh == this.Pc;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181782);
    String str = "[" + this.avh + ", " + this.Pc + "]";
    AppMethodBeat.o(181782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */