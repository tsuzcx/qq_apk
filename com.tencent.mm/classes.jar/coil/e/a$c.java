package coil.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/decode/BitmapFactoryDecoder$ExifInterfaceInputStream;", "Ljava/io/InputStream;", "delegate", "(Ljava/io/InputStream;)V", "availableBytes", "", "available", "close", "", "interceptBytesRead", "bytesRead", "read", "b", "", "off", "len", "skip", "", "n", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a$c
  extends InputStream
{
  private final InputStream cmS;
  private volatile int cmT;
  
  public a$c(InputStream paramInputStream)
  {
    AppMethodBeat.i(187846);
    this.cmS = paramInputStream;
    this.cmT = 1073741824;
    AppMethodBeat.o(187846);
  }
  
  private final int gP(int paramInt)
  {
    if (paramInt == -1) {
      this.cmT = 0;
    }
    return paramInt;
  }
  
  public final int available()
  {
    return this.cmT;
  }
  
  public final void close()
  {
    AppMethodBeat.i(187898);
    this.cmS.close();
    AppMethodBeat.o(187898);
  }
  
  public final int read()
  {
    AppMethodBeat.i(187861);
    int i = gP(this.cmS.read());
    AppMethodBeat.o(187861);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187869);
    s.u(paramArrayOfByte, "b");
    int i = gP(this.cmS.read(paramArrayOfByte));
    AppMethodBeat.o(187869);
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187875);
    s.u(paramArrayOfByte, "b");
    paramInt1 = gP(this.cmS.read(paramArrayOfByte, paramInt1, paramInt2));
    AppMethodBeat.o(187875);
    return paramInt1;
  }
  
  public final long skip(long paramLong)
  {
    AppMethodBeat.i(187885);
    paramLong = this.cmS.skip(paramLong);
    AppMethodBeat.o(187885);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.e.a.c
 * JD-Core Version:    0.7.0.1
 */