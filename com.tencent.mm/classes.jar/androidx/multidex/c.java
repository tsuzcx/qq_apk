package androidx.multidex;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class c
{
  private static long a(RandomAccessFile paramRandomAccessFile, a parama)
  {
    AppMethodBeat.i(201160);
    CRC32 localCRC32 = new CRC32();
    long l = parama.size;
    paramRandomAccessFile.seek(parama.offset);
    int i = (int)Math.min(16384L, l);
    parama = new byte[16384];
    for (i = paramRandomAccessFile.read(parama, 0, i); i != -1; i = paramRandomAccessFile.read(parama, 0, (int)Math.min(16384L, l)))
    {
      localCRC32.update(parama, 0, i);
      l -= i;
      if (l == 0L) {
        break;
      }
    }
    l = localCRC32.getValue();
    AppMethodBeat.o(201160);
    return l;
  }
  
  private static a b(RandomAccessFile paramRandomAccessFile)
  {
    long l1 = 0L;
    AppMethodBeat.i(201147);
    long l2 = paramRandomAccessFile.length() - 22L;
    if (l2 < 0L)
    {
      paramRandomAccessFile = new ZipException("File too short to be a zip file: " + paramRandomAccessFile.length());
      AppMethodBeat.o(201147);
      throw paramRandomAccessFile;
    }
    long l3 = l2 - 65536L;
    if (l3 < 0L) {}
    for (;;)
    {
      int i = Integer.reverseBytes(101010256);
      do
      {
        paramRandomAccessFile.seek(l2);
        if (paramRandomAccessFile.readInt() == i) {
          break;
        }
        l3 = l2 - 1L;
        l2 = l3;
      } while (l3 >= l1);
      paramRandomAccessFile = new ZipException("End Of Central Directory signature not found");
      AppMethodBeat.o(201147);
      throw paramRandomAccessFile;
      paramRandomAccessFile.skipBytes(2);
      paramRandomAccessFile.skipBytes(2);
      paramRandomAccessFile.skipBytes(2);
      paramRandomAccessFile.skipBytes(2);
      a locala = new a();
      locala.size = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
      locala.offset = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
      AppMethodBeat.o(201147);
      return locala;
      l1 = l3;
    }
  }
  
  static long p(File paramFile)
  {
    AppMethodBeat.i(201132);
    paramFile = new RandomAccessFile(paramFile, "r");
    try
    {
      long l = a(paramFile, b(paramFile));
      return l;
    }
    finally
    {
      paramFile.close();
      AppMethodBeat.o(201132);
    }
  }
  
  static final class a
  {
    long offset;
    long size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.multidex.c
 * JD-Core Version:    0.7.0.1
 */