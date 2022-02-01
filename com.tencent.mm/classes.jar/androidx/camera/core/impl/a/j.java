package androidx.camera.core.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  final long OW;
  final long OX;
  
  j(double paramDouble)
  {
    this((10000.0D * paramDouble), 10000L);
    AppMethodBeat.i(198980);
    AppMethodBeat.o(198980);
  }
  
  public j(long paramLong1, long paramLong2)
  {
    this.OW = paramLong1;
    this.OX = paramLong2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198992);
    String str = this.OW + "/" + this.OX;
    AppMethodBeat.o(198992);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.j
 * JD-Core Version:    0.7.0.1
 */