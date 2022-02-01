package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g
  implements Serializable
{
  public int Mc;
  public int asw;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181779);
    this.asw = paramInt1;
    this.Mc = paramInt2;
    if (this.asw > this.Mc)
    {
      paramInt1 = this.Mc;
      this.Mc = this.asw;
      this.asw = paramInt1;
    }
    AppMethodBeat.o(181779);
  }
  
  public g(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(181780);
    AppMethodBeat.o(181780);
  }
  
  public final g fa(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181781);
    this.asw = Math.max(0, this.asw - paramInt1);
    this.Mc += paramInt2;
    AppMethodBeat.o(181781);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.asw == this.Mc;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181782);
    String str = "[" + this.asw + ", " + this.Mc + "]";
    AppMethodBeat.o(181782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */