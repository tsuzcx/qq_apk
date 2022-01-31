package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public static int VERSION = 5;
  public static int bKC = 0;
  public static int bKD = 1;
  public static int bKE = 2;
  public static int bKF = 3;
  public static int bKG = 4;
  public static int bKH = 6;
  Map<Integer, String> bKI;
  
  public l()
  {
    AppMethodBeat.i(115960);
    this.bKI = new HashMap();
    AppMethodBeat.o(115960);
  }
  
  final void b(RandomAccessFile paramRandomAccessFile)
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(115961);
    int i = paramRandomAccessFile.readShort();
    int n = paramRandomAccessFile.readShort();
    int m = paramRandomAccessFile.readShort();
    if ((i != 1) || (n != 0))
    {
      AppMethodBeat.o(115961);
      return;
    }
    paramRandomAccessFile.seek(12L);
    Object localObject1 = new byte[4];
    l.c localc = new l.c((byte)0);
    i = 0;
    if (i < m)
    {
      paramRandomAccessFile.read((byte[])localObject1);
      localc.name = new String((byte[])localObject1);
      localc.bKS = paramRandomAccessFile.readInt();
      localc.offset = paramRandomAccessFile.readInt();
      localc.length = paramRandomAccessFile.readInt();
      if (!"name".equalsIgnoreCase(localc.name)) {}
    }
    for (i = k;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(115961);
        return;
        if ((localc.name == null) || (localc.name.length() == 0)) {
          continue;
        }
        i += 1;
        break;
      }
      paramRandomAccessFile.seek(localc.offset);
      localObject1 = new l.b((byte)0);
      ((l.b)localObject1).bKP = paramRandomAccessFile.readShort();
      ((l.b)localObject1).bKQ = paramRandomAccessFile.readShort();
      ((l.b)localObject1).bKR = paramRandomAccessFile.readShort();
      l.a locala = new l.a((byte)0);
      i = j;
      while (i < ((l.b)localObject1).bKQ)
      {
        locala.bKJ = paramRandomAccessFile.readShort();
        locala.bKK = paramRandomAccessFile.readShort();
        locala.bKL = paramRandomAccessFile.readShort();
        locala.bKM = paramRandomAccessFile.readShort();
        locala.bKN = paramRandomAccessFile.readShort();
        locala.bKO = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        Object localObject2 = new byte[locala.bKN];
        paramRandomAccessFile.seek(localc.offset + locala.bKO + ((l.b)localObject1).bKR);
        paramRandomAccessFile.read((byte[])localObject2);
        localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
        this.bKI.put(Integer.valueOf(locala.bKM), localObject2);
        paramRandomAccessFile.seek(l);
        i += 1;
      }
      AppMethodBeat.o(115961);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(115962);
    String str = this.bKI.toString();
    AppMethodBeat.o(115962);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.l
 * JD-Core Version:    0.7.0.1
 */