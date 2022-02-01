package com.tencent.commonsdk.soload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public class MyZipEntry
  implements MyZipConstants, Cloneable
{
  public static final int DEFLATED = 8;
  public static final int STORED = 0;
  String comment;
  long compressedSize = -1L;
  int compressionMethod = -1;
  long crc = -1L;
  byte[] extra;
  long mLocalHeaderRelOffset = -1L;
  int modDate = -1;
  String name;
  int nameLength = -1;
  long size = -1L;
  int time = -1;
  
  MyZipEntry(byte[] paramArrayOfByte, InputStream paramInputStream)
    throws IOException
  {
    Streams.readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = HeapBufferIterator.iterator(paramArrayOfByte, 0, paramArrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
    if (paramArrayOfByte.readInt() != 33639248L) {}
    paramArrayOfByte.seek(10);
    this.compressionMethod = paramArrayOfByte.readShort();
    this.time = paramArrayOfByte.readShort();
    this.modDate = paramArrayOfByte.readShort();
    this.crc = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.compressedSize = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.nameLength = paramArrayOfByte.readShort();
    int i = paramArrayOfByte.readShort();
    int j = paramArrayOfByte.readShort();
    paramArrayOfByte.seek(42);
    this.mLocalHeaderRelOffset = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    paramArrayOfByte = new byte[this.nameLength];
    Streams.readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, "UTF_8");
    if (j > 0)
    {
      paramArrayOfByte = new byte[j];
      Streams.readFully(paramInputStream, paramArrayOfByte, 0, j);
      this.comment = new String(paramArrayOfByte, 0, paramArrayOfByte.length, "UTF_8");
    }
    if (i > 0)
    {
      this.extra = new byte[i];
      Streams.readFully(paramInputStream, this.extra, 0, i);
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipEntry
 * JD-Core Version:    0.7.0.1
 */