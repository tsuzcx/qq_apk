package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  extends p
{
  final int Crb;
  private final int Crc;
  
  c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    AppMethodBeat.i(121415);
    if (paramInt1 < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(29 + "Offset too small: " + paramInt1);
      AppMethodBeat.o(121415);
      throw paramArrayOfByte;
    }
    if (paramInt2 < 0)
    {
      paramArrayOfByte = new IllegalArgumentException(29 + "Length too small: " + paramInt1);
      AppMethodBeat.o(121415);
      throw paramArrayOfByte;
    }
    if (paramInt1 + paramInt2 > paramArrayOfByte.length)
    {
      paramArrayOfByte = new IllegalArgumentException(48 + "Offset+Length too large: " + paramInt1 + "+" + paramInt2);
      AppMethodBeat.o(121415);
      throw paramArrayOfByte;
    }
    this.Crb = paramInt1;
    this.Crc = paramInt2;
    AppMethodBeat.o(121415);
  }
  
  public final byte VA(int paramInt)
  {
    AppMethodBeat.i(121416);
    ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException;
    if (paramInt < 0)
    {
      localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(28 + "Index too small: " + paramInt);
      AppMethodBeat.o(121416);
      throw localArrayIndexOutOfBoundsException;
    }
    if (paramInt >= this.Crc)
    {
      int i = this.Crc;
      localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(41 + "Index too large: " + paramInt + ", " + i);
      AppMethodBeat.o(121416);
      throw localArrayIndexOutOfBoundsException;
    }
    byte b = this.pW[(this.Crb + paramInt)];
    AppMethodBeat.o(121416);
    return b;
  }
  
  protected final int eml()
  {
    return this.Crb;
  }
  
  public final d.a emm()
  {
    AppMethodBeat.i(121418);
    c.a locala = new c.a(this, (byte)0);
    AppMethodBeat.o(121418);
    return locala;
  }
  
  protected final void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121417);
    System.arraycopy(this.pW, this.Crb + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(121417);
  }
  
  public final int size()
  {
    return this.Crc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.g.c
 * JD-Core Version:    0.7.0.1
 */