package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public static int VERSION = 5;
  public static int cot = 0;
  public static int cou = 1;
  public static int cov = 2;
  public static int cow = 3;
  public static int cox = 4;
  public static int coy = 6;
  Map<Integer, String> coz;
  
  public l()
  {
    AppMethodBeat.i(140061);
    this.coz = new HashMap();
    AppMethodBeat.o(140061);
  }
  
  final void c(RandomAccessFile paramRandomAccessFile)
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(140062);
    int i = paramRandomAccessFile.readShort();
    int n = paramRandomAccessFile.readShort();
    int m = paramRandomAccessFile.readShort();
    if ((i != 1) || (n != 0))
    {
      AppMethodBeat.o(140062);
      return;
    }
    paramRandomAccessFile.seek(12L);
    Object localObject1 = new byte[4];
    c localc = new c((byte)0);
    i = 0;
    if (i < m)
    {
      paramRandomAccessFile.read((byte[])localObject1);
      localc.name = new String((byte[])localObject1);
      localc.coJ = paramRandomAccessFile.readInt();
      localc.offset = paramRandomAccessFile.readInt();
      localc.length = paramRandomAccessFile.readInt();
      if (!"name".equalsIgnoreCase(localc.name)) {}
    }
    for (i = k;; i = 0)
    {
      if (i == 0)
      {
        AppMethodBeat.o(140062);
        return;
        if ((localc.name == null) || (localc.name.length() == 0)) {
          continue;
        }
        i += 1;
        break;
      }
      paramRandomAccessFile.seek(localc.offset);
      localObject1 = new b((byte)0);
      ((b)localObject1).coG = paramRandomAccessFile.readShort();
      ((b)localObject1).coH = paramRandomAccessFile.readShort();
      ((b)localObject1).coI = paramRandomAccessFile.readShort();
      a locala = new a((byte)0);
      i = j;
      while (i < ((b)localObject1).coH)
      {
        locala.coA = paramRandomAccessFile.readShort();
        locala.coB = paramRandomAccessFile.readShort();
        locala.coC = paramRandomAccessFile.readShort();
        locala.coD = paramRandomAccessFile.readShort();
        locala.coE = paramRandomAccessFile.readShort();
        locala.coF = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        if ((locala.coE <= 0) || (locala.coE >= 32767))
        {
          AppMethodBeat.o(140062);
          return;
        }
        Object localObject2 = new byte[locala.coE];
        paramRandomAccessFile.seek(localc.offset + locala.coF + ((b)localObject1).coI);
        paramRandomAccessFile.read((byte[])localObject2);
        localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
        this.coz.put(Integer.valueOf(locala.coD), localObject2);
        paramRandomAccessFile.seek(l);
        i += 1;
      }
      AppMethodBeat.o(140062);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140063);
    String str = this.coz.toString();
    AppMethodBeat.o(140063);
    return str;
  }
  
  static final class a
  {
    int coA;
    int coB;
    int coC;
    int coD;
    int coE;
    int coF;
  }
  
  static final class b
  {
    int coG;
    int coH;
    int coI;
  }
  
  static final class c
  {
    int coJ;
    int length;
    String name;
    int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.l
 * JD-Core Version:    0.7.0.1
 */