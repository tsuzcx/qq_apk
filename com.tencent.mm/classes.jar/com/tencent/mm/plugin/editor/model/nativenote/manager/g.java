package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class g
  implements Serializable
{
  public int OQ;
  public int avj;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181779);
    this.avj = paramInt1;
    this.OQ = paramInt2;
    if (this.avj > this.OQ)
    {
      paramInt1 = this.OQ;
      this.OQ = this.avj;
      this.avj = paramInt1;
    }
    AppMethodBeat.o(181779);
  }
  
  public g(EditText paramEditText)
  {
    this(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    AppMethodBeat.i(181780);
    AppMethodBeat.o(181780);
  }
  
  public final g fh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181781);
    this.avj = Math.max(0, this.avj - paramInt1);
    this.OQ += paramInt2;
    AppMethodBeat.o(181781);
    return this;
  }
  
  public final boolean isEmpty()
  {
    return this.avj == this.OQ;
  }
  
  public String toString()
  {
    AppMethodBeat.i(181782);
    String str = "[" + this.avj + ", " + this.OQ + "]";
    AppMethodBeat.o(181782);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.g
 * JD-Core Version:    0.7.0.1
 */