package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

@Deprecated
public final class c
  extends Writer
{
  private StringBuilder mBuilder;
  private final String mTag;
  
  public c(String paramString)
  {
    AppMethodBeat.i(251309);
    this.mBuilder = new StringBuilder(128);
    this.mTag = paramString;
    AppMethodBeat.o(251309);
  }
  
  private void gU()
  {
    AppMethodBeat.i(251313);
    if (this.mBuilder.length() > 0) {
      this.mBuilder.delete(0, this.mBuilder.length());
    }
    AppMethodBeat.o(251313);
  }
  
  public final void close()
  {
    AppMethodBeat.i(251310);
    gU();
    AppMethodBeat.o(251310);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(251311);
    gU();
    AppMethodBeat.o(251311);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251312);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        gU();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
    AppMethodBeat.o(251312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.f.c
 * JD-Core Version:    0.7.0.1
 */