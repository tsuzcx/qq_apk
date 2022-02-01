package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

public class e
  implements Closeable
{
  static final char[] a = { 127, 69, 76, 70, 0 };
  final char[] b = new char[16];
  boolean c;
  j[] d;
  l[] e;
  byte[] f;
  private final c g;
  private final a h;
  private final k[] i;
  private byte[] j;
  
  public e(File paramFile)
    throws IOException, UnknownFormatConversionException
  {
    c localc = new c(paramFile);
    this.g = localc;
    localc.a(this.b);
    if (!a()) {
      throw new UnknownFormatConversionException("Invalid elf magic: " + paramFile);
    }
    localc.a(e());
    boolean bool = d();
    int k;
    label238:
    Object localObject;
    if (bool)
    {
      paramFile = new f();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.c();
      paramFile.l = localc.c();
      paramFile.m = localc.c();
      this.h = paramFile;
      paramFile = this.h;
      paramFile.d = localc.b();
      paramFile.e = localc.a();
      paramFile.f = localc.a();
      paramFile.g = localc.a();
      paramFile.h = localc.a();
      paramFile.i = localc.a();
      paramFile.j = localc.a();
      this.i = new k[paramFile.i];
      k = 0;
      if (k >= paramFile.i) {
        break label581;
      }
      localc.a(paramFile.a() + paramFile.h * k);
      if (!bool) {
        break label461;
      }
      localObject = new h();
      ((h)localObject).g = localc.b();
      ((h)localObject).h = localc.b();
      ((h)localObject).a = localc.c();
      ((h)localObject).b = localc.c();
      ((h)localObject).c = localc.c();
      ((h)localObject).d = localc.c();
      ((h)localObject).i = localc.b();
      ((h)localObject).j = localc.b();
      ((h)localObject).e = localc.c();
      ((h)localObject).f = localc.c();
      this.i[k] = localObject;
    }
    for (;;)
    {
      k += 1;
      break label238;
      paramFile = new b();
      paramFile.a = localc.a();
      paramFile.b = localc.a();
      paramFile.c = localc.b();
      paramFile.k = localc.b();
      paramFile.l = localc.b();
      paramFile.m = localc.b();
      this.h = paramFile;
      break;
      label461:
      localObject = new d();
      ((d)localObject).g = localc.b();
      ((d)localObject).h = localc.b();
      ((d)localObject).a = localc.b();
      ((d)localObject).b = localc.b();
      ((d)localObject).c = localc.b();
      ((d)localObject).d = localc.b();
      ((d)localObject).i = localc.b();
      ((d)localObject).j = localc.b();
      ((d)localObject).e = localc.b();
      ((d)localObject).f = localc.b();
      this.i[k] = localObject;
    }
    label581:
    if ((paramFile.j > -1) && (paramFile.j < this.i.length))
    {
      localObject = this.i[paramFile.j];
      if (((k)localObject).h == 3)
      {
        this.j = new byte[((k)localObject).a()];
        localc.a(((k)localObject).b());
        localc.a(this.j);
        if (this.c) {
          f();
        }
        return;
      }
      throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + paramFile.j);
    }
    throw new UnknownFormatConversionException("Invalid e_shstrndx=" + paramFile.j);
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool = false;
    try
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      long l = paramFile.readInt();
      paramFile.close();
      if (l == 2135247942L) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(File paramFile)
  {
    if ((g()) && (a(paramFile))) {}
    try
    {
      new e(paramFile);
      return true;
    }
    catch (IOException paramFile)
    {
      Log.e("ELF", "checkElfFile IOException: " + paramFile);
      return false;
    }
    catch (UnknownFormatConversionException paramFile)
    {
      for (;;)
      {
        Log.e("ELF", "checkElfFile UnknownFormatConversionException: " + paramFile);
      }
    }
    catch (Throwable paramFile)
    {
      for (;;)
      {
        Log.e("ELF", "checkElfFile Throwable: " + paramFile);
      }
    }
  }
  
  private void f()
    throws IOException
  {
    a locala = this.h;
    c localc = this.g;
    boolean bool = d();
    Object localObject1 = a(".dynsym");
    if (localObject1 != null)
    {
      localc.a(((k)localObject1).b());
      int m = ((k)localObject1).a();
      char[] arrayOfChar;
      label73:
      Object localObject2;
      if (bool)
      {
        k = 24;
        m /= k;
        this.e = new l[m];
        arrayOfChar = new char[1];
        k = 0;
        if (k >= m) {
          break label280;
        }
        if (!bool) {
          break label186;
        }
        localObject2 = new i();
        ((i)localObject2).c = localc.b();
        localc.a(arrayOfChar);
        ((i)localObject2).d = arrayOfChar[0];
        localc.a(arrayOfChar);
        ((i)localObject2).e = arrayOfChar[0];
        ((i)localObject2).a = localc.c();
        ((i)localObject2).b = localc.c();
        ((i)localObject2).f = localc.a();
        this.e[k] = localObject2;
      }
      for (;;)
      {
        k += 1;
        break label73;
        k = 16;
        break;
        label186:
        localObject2 = new e();
        ((e)localObject2).c = localc.b();
        ((e)localObject2).a = localc.b();
        ((e)localObject2).b = localc.b();
        localc.a(arrayOfChar);
        ((e)localObject2).d = arrayOfChar[0];
        localc.a(arrayOfChar);
        ((e)localObject2).e = arrayOfChar[0];
        ((e)localObject2).f = localc.a();
        this.e[k] = localObject2;
      }
      label280:
      localObject1 = this.i[localObject1.i];
      localc.a(((k)localObject1).b());
      this.f = new byte[((k)localObject1).a()];
      localc.a(this.f);
    }
    this.d = new j[locala.g];
    int k = 0;
    if (k < locala.g)
    {
      localc.a(locala.b() + locala.f * k);
      if (bool)
      {
        localObject1 = new g();
        ((g)localObject1).g = localc.b();
        ((g)localObject1).h = localc.b();
        ((g)localObject1).a = localc.c();
        ((g)localObject1).b = localc.c();
        ((g)localObject1).c = localc.c();
        ((g)localObject1).d = localc.c();
        ((g)localObject1).e = localc.c();
        ((g)localObject1).f = localc.c();
        this.d[k] = localObject1;
      }
      for (;;)
      {
        k += 1;
        break;
        localObject1 = new c();
        ((c)localObject1).g = localc.b();
        ((c)localObject1).h = localc.b();
        ((c)localObject1).a = localc.b();
        ((c)localObject1).b = localc.b();
        ((c)localObject1).c = localc.b();
        ((c)localObject1).d = localc.b();
        ((c)localObject1).e = localc.b();
        ((c)localObject1).f = localc.b();
        this.d[k] = localObject1;
      }
    }
  }
  
  private static boolean g()
  {
    String str = System.getProperty("java.vm.version");
    return (str != null) && (str.startsWith("2"));
  }
  
  public final k a(String paramString)
  {
    k[] arrayOfk = this.i;
    int m = arrayOfk.length;
    int k = 0;
    while (k < m)
    {
      k localk = arrayOfk[k];
      if (paramString.equals(a(localk.g))) {
        return localk;
      }
      k += 1;
    }
    return null;
  }
  
  public final String a(int paramInt)
  {
    if (paramInt == 0) {
      return "SHN_UNDEF";
    }
    int k = paramInt;
    while (this.j[k] != 0) {
      k += 1;
    }
    return new String(this.j, paramInt, k - paramInt);
  }
  
  final boolean a()
  {
    boolean bool = false;
    if (this.b[0] == a[0]) {
      bool = true;
    }
    return bool;
  }
  
  final char b()
  {
    return this.b[4];
  }
  
  final char c()
  {
    return this.b[5];
  }
  
  public void close()
  {
    this.g.close();
  }
  
  public final boolean d()
  {
    return b() == '\002';
  }
  
  public final boolean e()
  {
    return c() == '\001';
  }
  
  public static abstract class a
  {
    short a;
    short b;
    int c;
    int d;
    short e;
    short f;
    short g;
    short h;
    short i;
    short j;
    
    abstract long a();
    
    abstract long b();
  }
  
  static class b
    extends e.a
  {
    int k;
    int l;
    int m;
    
    long a()
    {
      return this.m;
    }
    
    long b()
    {
      return this.l;
    }
  }
  
  static class c
    extends e.j
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
  }
  
  static class d
    extends e.k
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    
    public int a()
    {
      return this.d;
    }
    
    public long b()
    {
      return this.c;
    }
  }
  
  static class e
    extends e.l
  {
    int a;
    int b;
  }
  
  static class f
    extends e.a
  {
    long k;
    long l;
    long m;
    
    long a()
    {
      return this.m;
    }
    
    long b()
    {
      return this.l;
    }
  }
  
  static class g
    extends e.j
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
  }
  
  static class h
    extends e.k
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    
    public int a()
    {
      return (int)this.d;
    }
    
    public long b()
    {
      return this.c;
    }
  }
  
  static class i
    extends e.l
  {
    long a;
    long b;
  }
  
  static abstract class j
  {
    int g;
    int h;
  }
  
  public static abstract class k
  {
    int g;
    int h;
    int i;
    int j;
    
    public abstract int a();
    
    public abstract long b();
  }
  
  static abstract class l
  {
    int c;
    char d;
    char e;
    short f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.e
 * JD-Core Version:    0.7.0.1
 */