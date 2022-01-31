package com.tencent.magicbrush.handler.a;

import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public static int VERSION = 5;
  public static int blF = 0;
  public static int blG = 1;
  public static int blH = 2;
  public static int blI = 3;
  public static int blJ = 4;
  public static int blK = 6;
  Map<Integer, String> blL = new HashMap();
  
  final void b(RandomAccessFile paramRandomAccessFile)
  {
    int k = 1;
    int j = 0;
    int i = paramRandomAccessFile.readShort();
    int n = paramRandomAccessFile.readShort();
    int m = paramRandomAccessFile.readShort();
    if ((i != 1) || (n != 0)) {}
    label57:
    label375:
    for (;;)
    {
      return;
      paramRandomAccessFile.seek(12L);
      Object localObject1 = new byte[4];
      m.c localc = new m.c((byte)0);
      i = 0;
      if (i < m)
      {
        paramRandomAccessFile.read((byte[])localObject1);
        localc.name = new String((byte[])localObject1);
        localc.blV = paramRandomAccessFile.readInt();
        localc.offset = paramRandomAccessFile.readInt();
        localc.length = paramRandomAccessFile.readInt();
        if (!"name".equalsIgnoreCase(localc.name)) {}
      }
      for (i = k;; i = 0)
      {
        if (i == 0) {
          break label375;
        }
        paramRandomAccessFile.seek(localc.offset);
        localObject1 = new m.b((byte)0);
        ((m.b)localObject1).blS = paramRandomAccessFile.readShort();
        ((m.b)localObject1).blT = paramRandomAccessFile.readShort();
        ((m.b)localObject1).blU = paramRandomAccessFile.readShort();
        m.a locala = new m.a((byte)0);
        i = j;
        while (i < ((m.b)localObject1).blT)
        {
          locala.blM = paramRandomAccessFile.readShort();
          locala.blN = paramRandomAccessFile.readShort();
          locala.blO = paramRandomAccessFile.readShort();
          locala.blP = paramRandomAccessFile.readShort();
          locala.blQ = paramRandomAccessFile.readShort();
          locala.blR = paramRandomAccessFile.readShort();
          long l = paramRandomAccessFile.getFilePointer();
          Object localObject2 = new byte[locala.blQ];
          paramRandomAccessFile.seek(localc.offset + locala.blR + ((m.b)localObject1).blU);
          paramRandomAccessFile.read((byte[])localObject2);
          localObject2 = new String((byte[])localObject2, Charset.forName("utf-16"));
          this.blL.put(Integer.valueOf(locala.blP), localObject2);
          paramRandomAccessFile.seek(l);
          i += 1;
        }
        break;
        if ((localc.name != null) && (localc.name.length() != 0))
        {
          i += 1;
          break label57;
        }
      }
    }
  }
  
  public final String toString()
  {
    return this.blL.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.m
 * JD-Core Version:    0.7.0.1
 */