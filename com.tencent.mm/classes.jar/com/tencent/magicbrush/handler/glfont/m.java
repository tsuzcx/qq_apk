package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public static int VERSION = 5;
  public static int cNR = 0;
  public static int cNS = 1;
  public static int cNT = 2;
  public static int cNU = 3;
  public static int cNV = 4;
  public static int cNW = 6;
  Map<Integer, String> cNX;
  
  public m()
  {
    AppMethodBeat.i(140061);
    this.cNX = new HashMap();
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
      localc.cOh = paramRandomAccessFile.readInt();
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
      ((b)localObject1).cOe = paramRandomAccessFile.readShort();
      ((b)localObject1).cOf = paramRandomAccessFile.readShort();
      ((b)localObject1).cOg = paramRandomAccessFile.readShort();
      a locala = new a((byte)0);
      i = j;
      while (i < ((b)localObject1).cOf)
      {
        locala.cNY = paramRandomAccessFile.readShort();
        locala.cNZ = paramRandomAccessFile.readShort();
        locala.cOa = paramRandomAccessFile.readShort();
        locala.cOb = paramRandomAccessFile.readShort();
        locala.cOc = paramRandomAccessFile.readShort();
        locala.cOd = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        if ((locala.cOc <= 0) || (locala.cOc >= 32767))
        {
          AppMethodBeat.o(140062);
          return;
        }
        Object localObject2 = new byte[locala.cOc];
        paramRandomAccessFile.seek(localc.offset + locala.cOd + ((b)localObject1).cOg);
        paramRandomAccessFile.read((byte[])localObject2);
        localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
        this.cNX.put(Integer.valueOf(locala.cOb), localObject2);
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
    String str = this.cNX.toString();
    AppMethodBeat.o(140063);
    return str;
  }
  
  static final class a
  {
    int cNY;
    int cNZ;
    int cOa;
    int cOb;
    int cOc;
    int cOd;
  }
  
  static final class b
  {
    int cOe;
    int cOf;
    int cOg;
  }
  
  static final class c
  {
    int cOh;
    int length;
    String name;
    int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.m
 * JD-Core Version:    0.7.0.1
 */