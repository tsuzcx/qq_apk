package com.tencent.apkupdate.a;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class g
{
  LinkedHashMap a = new LinkedHashMap();
  LinkedHashMap b = new LinkedHashMap();
  private ArrayList c = new ArrayList();
  private c d = new c();
  private long e = 0L;
  private String f = null;
  
  private void a()
  {
    DataInputStream localDataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(this.f)));
    localDataInputStream.skip(this.d.f);
    int i = 0;
    while ((localDataInputStream.available() >= 4) && (i == 0)) {
      switch (localDataInputStream.readInt())
      {
      default: 
        break;
      case 1347092738: 
        b localb = new b();
        int j = localDataInputStream.readShort();
        localb.a = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.b = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.c = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.d = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.e = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.f = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        localb.g = a.a(localDataInputStream.readInt());
        localb.h = a.a(localDataInputStream.readInt());
        localb.i = a.a(localDataInputStream.readInt());
        j = localDataInputStream.readShort();
        localb.j = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.l = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.m = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.n = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localb.o = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        localb.p = a.a(localDataInputStream.readInt());
        localb.q = a.a(localDataInputStream.readInt());
        localb.r = false;
        localb.s = new byte[localb.j];
        localb.u = new byte[localb.l];
        localb.v = new byte[localb.m];
        localDataInputStream.read(localb.s, 0, localb.j);
        localDataInputStream.read(localb.u, 0, localb.l);
        localDataInputStream.read(localb.v, 0, localb.m);
        String str = new String(localb.s, Charset.defaultCharset().name());
        if (str.startsWith("META-INF/")) {
          this.c.add(str);
        }
        this.b.put(str, localb);
        break;
      case 1347093766: 
        i = 1;
      }
    }
    localDataInputStream.close();
  }
  
  private void a(RandomAccessFile paramRandomAccessFile)
  {
    long l = 1024L;
    if (1024L > this.e) {
      l = this.e;
    }
    byte[] arrayOfByte = new byte[1024];
    paramRandomAccessFile.skipBytes((int)(this.e - l));
    paramRandomAccessFile.read(arrayOfByte, 0, (int)l);
    int i = 0;
    for (;;)
    {
      if (i < l - 4L)
      {
        if ((arrayOfByte[i] << 24) + (arrayOfByte[(i + 1)] << 16) + (arrayOfByte[(i + 2)] << 8) + arrayOfByte[(i + 3)] == 1347093766) {}
        try
        {
          paramRandomAccessFile = new DataInputStream(new ByteArrayInputStream(arrayOfByte, i + 4, (int)(l - (i + 4))));
          this.d.a(paramRandomAccessFile);
          paramRandomAccessFile.close();
          i += 1;
        }
        catch (IOException paramRandomAccessFile)
        {
          for (;;)
          {
            paramRandomAccessFile.printStackTrace();
          }
        }
      }
    }
  }
  
  private void b()
  {
    DataInputStream localDataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(this.f)));
    int i = 0;
    if ((localDataInputStream.available() >= 4) && (i == 0))
    {
      switch (localDataInputStream.readInt())
      {
      }
      for (;;)
      {
        break;
        f localf = new f();
        localDataInputStream.readShort();
        localDataInputStream.readShort();
        localDataInputStream.readShort();
        localDataInputStream.readShort();
        localDataInputStream.readShort();
        localDataInputStream.readInt();
        localf.a = a.a(localDataInputStream.readInt());
        localDataInputStream.readInt();
        int j = localDataInputStream.readShort();
        localf.b = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        j = localDataInputStream.readShort();
        localf.c = ((short)(j >> 8 & 0xFF | (j & 0xFF) << 8));
        localf.d = new byte[localf.b];
        localf.e = new byte[localf.c];
        localDataInputStream.read(localf.d, 0, localf.b);
        localDataInputStream.read(localf.e, 0, localf.c);
        String str = new String(localf.d, Charset.defaultCharset().name());
        b localb = (b)this.b.get(str);
        localb.k = localf.c;
        if (localb.k > 0) {
          localb.t = ((byte[])localf.e.clone());
        }
        localf.a = localb.h;
        j = localb.i;
        j = localb.g;
        localDataInputStream.skipBytes(localf.a);
        this.a.put(str, localf);
        break;
        localDataInputStream.skipBytes(12);
        break;
        i = 1;
        break;
        i = 1;
      }
    }
    localDataInputStream.close();
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
    paramString = new RandomAccessFile(paramString, "r");
    this.e = paramString.length();
    a(paramString);
    paramString.close();
    Log.i("ZipFileParser", "readEndOfCentralDirRecord finished.");
    a();
    Log.i("ZipFileParser", "readCentralDirFileHeaderList finished.");
    b();
    Log.i("ZipFileParser", "readLocalFileHeader finished.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.a.g
 * JD-Core Version:    0.7.0.1
 */