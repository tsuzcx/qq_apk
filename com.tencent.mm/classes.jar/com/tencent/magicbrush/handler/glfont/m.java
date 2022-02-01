package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public static int VERSION = 5;
  public static int cOF = 0;
  public static int cOG = 1;
  public static int cOH = 2;
  public static int cOI = 3;
  public static int cOJ = 4;
  public static int cOK = 6;
  Map<Integer, String> cOL;
  
  public m()
  {
    AppMethodBeat.i(140061);
    this.cOL = new HashMap();
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
      localc.cOV = paramRandomAccessFile.readInt();
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
      ((b)localObject1).cOS = paramRandomAccessFile.readShort();
      ((b)localObject1).cOT = paramRandomAccessFile.readShort();
      ((b)localObject1).cOU = paramRandomAccessFile.readShort();
      a locala = new a((byte)0);
      i = j;
      while (i < ((b)localObject1).cOT)
      {
        locala.cOM = paramRandomAccessFile.readShort();
        locala.cON = paramRandomAccessFile.readShort();
        locala.cOO = paramRandomAccessFile.readShort();
        locala.cOP = paramRandomAccessFile.readShort();
        locala.cOQ = paramRandomAccessFile.readShort();
        locala.cOR = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        if ((locala.cOQ <= 0) || (locala.cOQ >= 32767))
        {
          AppMethodBeat.o(140062);
          return;
        }
        Object localObject2 = new byte[locala.cOQ];
        paramRandomAccessFile.seek(localc.offset + locala.cOR + ((b)localObject1).cOU);
        paramRandomAccessFile.read((byte[])localObject2);
        localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
        this.cOL.put(Integer.valueOf(locala.cOP), localObject2);
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
    String str = this.cOL.toString();
    AppMethodBeat.o(140063);
    return str;
  }
  
  static final class a
  {
    int cOM;
    int cON;
    int cOO;
    int cOP;
    int cOQ;
    int cOR;
  }
  
  static final class b
  {
    int cOS;
    int cOT;
    int cOU;
  }
  
  static final class c
  {
    int cOV;
    int length;
    String name;
    int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.m
 * JD-Core Version:    0.7.0.1
 */