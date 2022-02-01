package androidx.fragment.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;

final class w
  extends Writer
{
  private StringBuilder mBuilder;
  private final String mTag;
  
  w(String paramString)
  {
    AppMethodBeat.i(193498);
    this.mBuilder = new StringBuilder(128);
    this.mTag = paramString;
    AppMethodBeat.o(193498);
  }
  
  private void GF()
  {
    AppMethodBeat.i(193507);
    if (this.mBuilder.length() > 0) {
      this.mBuilder.delete(0, this.mBuilder.length());
    }
    AppMethodBeat.o(193507);
  }
  
  public final void close()
  {
    AppMethodBeat.i(193513);
    GF();
    AppMethodBeat.o(193513);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(193519);
    GF();
    AppMethodBeat.o(193519);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193527);
    int i = 0;
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        GF();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
    AppMethodBeat.o(193527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.fragment.app.w
 * JD-Core Version:    0.7.0.1
 */