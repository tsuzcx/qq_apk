package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

final class u$d
  extends InputStream
{
  private u.b Csi;
  private p Csj;
  private int Csk;
  private int Csl;
  private int Csm;
  private int mark;
  
  public u$d(u paramu)
  {
    AppMethodBeat.i(121596);
    initialize();
    AppMethodBeat.o(121596);
  }
  
  private int C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121599);
    int i = paramInt2;
    int j = paramInt1;
    paramInt1 = i;
    for (i = j; paramInt1 > 0; i = j)
    {
      enb();
      if (this.Csj == null)
      {
        if (paramInt1 != paramInt2) {
          break;
        }
        AppMethodBeat.o(121599);
        return -1;
      }
      int k = Math.min(this.Csk - this.Csl, paramInt1);
      j = i;
      if (paramArrayOfByte != null)
      {
        this.Csj.h(paramArrayOfByte, this.Csl, i, k);
        j = i + k;
      }
      this.Csl += k;
      paramInt1 -= k;
    }
    AppMethodBeat.o(121599);
    return paramInt2 - paramInt1;
  }
  
  private void enb()
  {
    AppMethodBeat.i(121604);
    if ((this.Csj != null) && (this.Csl == this.Csk))
    {
      this.Csm += this.Csk;
      this.Csl = 0;
      if (this.Csi.hasNext())
      {
        this.Csj = this.Csi.ena();
        this.Csk = this.Csj.size();
        AppMethodBeat.o(121604);
        return;
      }
      this.Csj = null;
      this.Csk = 0;
    }
    AppMethodBeat.o(121604);
  }
  
  private void initialize()
  {
    AppMethodBeat.i(121603);
    this.Csi = new u.b(this.Csh, (byte)0);
    this.Csj = this.Csi.ena();
    this.Csk = this.Csj.size();
    this.Csl = 0;
    this.Csm = 0;
    AppMethodBeat.o(121603);
  }
  
  public final int available()
  {
    AppMethodBeat.i(121601);
    int i = this.Csm;
    int j = this.Csl;
    int k = this.Csh.size();
    AppMethodBeat.o(121601);
    return k - (i + j);
  }
  
  public final void mark(int paramInt)
  {
    this.mark = (this.Csm + this.Csl);
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
  {
    AppMethodBeat.i(121600);
    enb();
    if (this.Csj == null)
    {
      AppMethodBeat.o(121600);
      return -1;
    }
    p localp = this.Csj;
    int i = this.Csl;
    this.Csl = (i + 1);
    i = localp.VA(i);
    AppMethodBeat.o(121600);
    return i & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121597);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException();
      AppMethodBeat.o(121597);
      throw paramArrayOfByte;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1))
    {
      paramArrayOfByte = new IndexOutOfBoundsException();
      AppMethodBeat.o(121597);
      throw paramArrayOfByte;
    }
    paramInt1 = C(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(121597);
    return paramInt1;
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(121602);
      initialize();
      C(null, 0, this.mark);
      AppMethodBeat.o(121602);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(121598);
    if (paramLong < 0L)
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException();
      AppMethodBeat.o(121598);
      throw localIndexOutOfBoundsException;
    }
    long l = paramLong;
    if (paramLong > 2147483647L) {
      l = 2147483647L;
    }
    paramLong = C(null, 0, (int)l);
    AppMethodBeat.o(121598);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.g.u.d
 * JD-Core Version:    0.7.0.1
 */