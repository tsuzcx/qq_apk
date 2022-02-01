package androidx.core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
{
  final e.b[] brN;
  final int mStatusCode;
  
  @Deprecated
  private e$a(int paramInt, e.b[] paramArrayOfb)
  {
    this.mStatusCode = paramInt;
    this.brN = paramArrayOfb;
  }
  
  static a a(int paramInt, e.b[] paramArrayOfb)
  {
    AppMethodBeat.i(196257);
    paramArrayOfb = new a(paramInt, paramArrayOfb);
    AppMethodBeat.o(196257);
    return paramArrayOfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.e.a
 * JD-Core Version:    0.7.0.1
 */