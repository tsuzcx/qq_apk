package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class f
  extends e
{
  public static final int h = 4;
  static HashMap<String, byte[]> i = null;
  static HashMap<String, HashMap<String, byte[]>> j = null;
  protected h g;
  private int k;
  private int l;
  
  public f()
  {
    AppMethodBeat.i(224907);
    this.g = new h();
    this.k = 0;
    this.l = 0;
    this.g.a = 2;
    AppMethodBeat.o(224907);
  }
  
  private f(boolean paramBoolean)
  {
    AppMethodBeat.i(224920);
    this.g = new h();
    this.k = 0;
    this.l = 0;
    if (paramBoolean)
    {
      g();
      AppMethodBeat.o(224920);
      return;
    }
    this.g.a = 2;
    AppMethodBeat.o(224920);
  }
  
  private void a(int paramInt)
  {
    this.g.d = paramInt;
  }
  
  private void a(m paramm)
  {
    AppMethodBeat.i(224997);
    this.g.readFrom(paramm);
    AppMethodBeat.o(224997);
  }
  
  private void a(n paramn)
  {
    AppMethodBeat.i(224986);
    this.g.writeTo(paramn);
    AppMethodBeat.o(224986);
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(225008);
    this.g.display(paramStringBuilder, paramInt);
    AppMethodBeat.o(225008);
  }
  
  private void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  private int h()
  {
    return this.g.a;
  }
  
  private int i()
  {
    return this.k;
  }
  
  private void j()
  {
    AppMethodBeat.i(224939);
    m localm = new m(this.g.g);
    localm.a(this.c);
    if (i == null)
    {
      HashMap localHashMap = new HashMap();
      i = localHashMap;
      localHashMap.put("", new byte[0]);
    }
    this.e = localm.a(i, 0, false);
    AppMethodBeat.o(224939);
  }
  
  private void k()
  {
    AppMethodBeat.i(224948);
    m localm = new m(this.g.g);
    localm.a(this.c);
    if (j == null)
    {
      j = new HashMap();
      HashMap localHashMap = new HashMap();
      localHashMap.put("", new byte[0]);
      j.put("", localHashMap);
    }
    this.a = localm.a(j, 0, false);
    this.b = new HashMap();
    AppMethodBeat.o(224948);
  }
  
  private String l()
  {
    return this.g.e;
  }
  
  private String m()
  {
    return this.g.f;
  }
  
  private int n()
  {
    return this.g.d;
  }
  
  private f o()
  {
    AppMethodBeat.i(225019);
    f localf = new f();
    int m = this.g.d;
    localf.g.d = m;
    localf.c(this.g.e);
    localf.d(this.g.f);
    localf.a(this.c);
    localf.g.a = this.g.a;
    AppMethodBeat.o(225019);
    return localf;
  }
  
  private byte[] p()
  {
    AppMethodBeat.i(225032);
    Object localObject = new n(0);
    ((n)localObject).a(this.c);
    ((n)localObject).a(this.a, 0);
    localObject = q.a(((n)localObject).a);
    n localn = new n(0);
    localn.a(this.c);
    localn.a(this.g.a, 1);
    localn.a(this.g.b, 2);
    localn.a(this.g.d, 3);
    localn.a(this.g.c, 4);
    localn.a(this.l, 5);
    localn.a((byte[])localObject, 6);
    localn.a(this.g.j, 7);
    localObject = q.a(localn.a);
    AppMethodBeat.o(225032);
    return localObject;
  }
  
  private int q()
  {
    return this.l;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(225072);
    if (paramString.startsWith("."))
    {
      paramString = new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(225072);
      throw paramString;
    }
    super.a(paramString, paramT);
    AppMethodBeat.o(225072);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225129);
    if (paramArrayOfByte.length < 4)
    {
      paramArrayOfByte = new IllegalArgumentException("decode package must include size head");
      AppMethodBeat.o(225129);
      throw paramArrayOfByte;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    localByteBuffer.put(arrayOfByte).flip();
    this.k = localByteBuffer.getInt();
    try
    {
      paramArrayOfByte = new m(paramArrayOfByte, (byte)0);
      paramArrayOfByte.a(this.c);
      this.g.readFrom(paramArrayOfByte);
      if (this.g.a == 3)
      {
        j();
        AppMethodBeat.o(225129);
        return;
      }
      this.e = null;
      k();
      AppMethodBeat.o(225129);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = new RuntimeException(paramArrayOfByte);
      AppMethodBeat.o(225129);
      throw paramArrayOfByte;
    }
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225102);
    if (paramArrayOfByte.length < 4)
    {
      paramArrayOfByte = new IllegalArgumentException("decode package must include size head");
      AppMethodBeat.o(225102);
      throw paramArrayOfByte;
    }
    try
    {
      paramArrayOfByte = new m(paramArrayOfByte, (byte)0);
      paramArrayOfByte.a(this.c);
      this.g.readFrom(paramArrayOfByte);
      j();
      AppMethodBeat.o(225102);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = new RuntimeException(paramArrayOfByte);
      AppMethodBeat.o(225102);
      throw paramArrayOfByte;
    }
  }
  
  public final void c(String paramString)
  {
    this.g.e = paramString;
  }
  
  public final void c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225116);
    if (paramArrayOfByte.length < 4)
    {
      paramArrayOfByte = new IllegalArgumentException("decode package must include size head");
      AppMethodBeat.o(225116);
      throw paramArrayOfByte;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    localByteBuffer.put(arrayOfByte).flip();
    this.k = localByteBuffer.getInt();
    try
    {
      paramArrayOfByte = new m(paramArrayOfByte, (byte)0);
      paramArrayOfByte.a(this.c);
      this.g.readFrom(paramArrayOfByte);
      k();
      AppMethodBeat.o(225116);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = new RuntimeException(paramArrayOfByte);
      AppMethodBeat.o(225116);
      throw paramArrayOfByte;
    }
  }
  
  public final void d(String paramString)
  {
    this.g.f = paramString;
  }
  
  public final byte[] f()
  {
    AppMethodBeat.i(225094);
    if (this.g.a == 2)
    {
      if ((this.g.e == null) || (this.g.e.equals("")))
      {
        localObject = new IllegalArgumentException("servantName can not is null");
        AppMethodBeat.o(225094);
        throw ((Throwable)localObject);
      }
      if ((this.g.f == null) || (this.g.f.equals("")))
      {
        localObject = new IllegalArgumentException("funcName can not is null");
        AppMethodBeat.o(225094);
        throw ((Throwable)localObject);
      }
    }
    else
    {
      if (this.g.e == null) {
        this.g.e = "";
      }
      if (this.g.f == null) {
        this.g.f = "";
      }
    }
    Object localObject = new n(0);
    ((n)localObject).a(this.c);
    if ((this.g.a == 2) || (this.g.a == 1)) {
      ((n)localObject).a(this.a, 0);
    }
    for (;;)
    {
      this.g.g = q.a(((n)localObject).a);
      localObject = new n(0);
      ((n)localObject).a(this.c);
      this.g.writeTo((n)localObject);
      localObject = q.a(((n)localObject).a);
      int m = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(m + 4);
      localByteBuffer.putInt(m + 4).put((byte[])localObject).flip();
      localObject = localByteBuffer.array();
      AppMethodBeat.o(225094);
      return localObject;
      ((n)localObject).a(this.e, 0);
    }
  }
  
  public final void g()
  {
    AppMethodBeat.i(225081);
    super.g();
    this.g.a = 3;
    AppMethodBeat.o(225081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.f
 * JD-Core Version:    0.7.0.1
 */