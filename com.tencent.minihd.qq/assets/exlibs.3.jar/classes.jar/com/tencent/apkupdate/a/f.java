package com.tencent.apkupdate.a;

import java.io.DataOutputStream;

public final class f
{
  int a;
  short b;
  short c;
  byte[] d;
  byte[] e;
  
  public static void a(b paramb, DataOutputStream paramDataOutputStream)
  {
    paramb.q = paramDataOutputStream.size();
    paramDataOutputStream.writeInt(1347093252);
    int i = paramb.b;
    paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramb.c;
    paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramb.d;
    paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramb.e;
    paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    i = paramb.f;
    paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
    if ((paramb.c & 0x8) == 8)
    {
      paramDataOutputStream.writeInt(a.a(0));
      paramDataOutputStream.writeInt(a.a(0));
      paramDataOutputStream.writeInt(a.a(0));
    }
    for (;;)
    {
      i = paramb.j;
      paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
      i = paramb.k;
      paramDataOutputStream.writeShort((short)(i >> 8 & 0xFF | (i & 0xFF) << 8));
      if (paramb.j > 0) {
        paramDataOutputStream.write(paramb.s);
      }
      if (paramb.k > 0) {
        paramDataOutputStream.write(paramb.t);
      }
      return;
      paramDataOutputStream.writeInt(a.a(paramb.g));
      paramDataOutputStream.writeInt(a.a(paramb.h));
      paramDataOutputStream.writeInt(a.a(paramb.i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.a.f
 * JD-Core Version:    0.7.0.1
 */