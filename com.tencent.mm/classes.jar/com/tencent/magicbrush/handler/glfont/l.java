package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public static int VERSION = 5;
  public static int crn = 0;
  public static int cro = 1;
  public static int crp = 2;
  public static int crq = 3;
  public static int crr = 4;
  public static int crs = 6;
  Map<Integer, String> crt;
  
  public l()
  {
    AppMethodBeat.i(140061);
    this.crt = new HashMap();
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
      localc.crD = paramRandomAccessFile.readInt();
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
      ((b)localObject1).crA = paramRandomAccessFile.readShort();
      ((b)localObject1).crB = paramRandomAccessFile.readShort();
      ((b)localObject1).crC = paramRandomAccessFile.readShort();
      a locala = new a((byte)0);
      i = j;
      while (i < ((b)localObject1).crB)
      {
        locala.cru = paramRandomAccessFile.readShort();
        locala.crv = paramRandomAccessFile.readShort();
        locala.crw = paramRandomAccessFile.readShort();
        locala.crx = paramRandomAccessFile.readShort();
        locala.cry = paramRandomAccessFile.readShort();
        locala.crz = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        if ((locala.cry <= 0) || (locala.cry >= 32767))
        {
          AppMethodBeat.o(140062);
          return;
        }
        Object localObject2 = new byte[locala.cry];
        paramRandomAccessFile.seek(localc.offset + locala.crz + ((b)localObject1).crC);
        paramRandomAccessFile.read((byte[])localObject2);
        localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
        this.crt.put(Integer.valueOf(locala.crx), localObject2);
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
    String str = this.crt.toString();
    AppMethodBeat.o(140063);
    return str;
  }
  
  static final class a
  {
    int cru;
    int crv;
    int crw;
    int crx;
    int cry;
    int crz;
  }
  
  static final class b
  {
    int crA;
    int crB;
    int crC;
  }
  
  static final class c
  {
    int crD;
    int length;
    String name;
    int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.l
 * JD-Core Version:    0.7.0.1
 */