package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends p
{
  static byte[] k;
  static Map<String, String> l;
  public short a = 0;
  public byte b = 0;
  public int c = 0;
  public int d = 0;
  public String e = null;
  public String f = null;
  public byte[] g;
  public int h = 0;
  public Map<String, String> i;
  public Map<String, String> j;
  
  static
  {
    AppMethodBeat.i(224810);
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      m = bool;
      k = null;
      l = null;
      AppMethodBeat.o(224810);
      return;
    }
  }
  
  public h() {}
  
  private h(short paramShort, byte paramByte, int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt3, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    this.a = paramShort;
    this.b = paramByte;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramArrayOfByte;
    this.h = paramInt3;
    this.i = paramMap1;
    this.j = paramMap2;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(224830);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (m) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(224830);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(224830);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(224867);
    paramStringBuilder = new k(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.b, "cPacketType");
    paramStringBuilder.a(this.c, "iMessageType");
    paramStringBuilder.a(this.d, "iRequestId");
    paramStringBuilder.a(this.e, "sServantName");
    paramStringBuilder.a(this.f, "sFuncName");
    paramStringBuilder.a(this.g, "sBuffer");
    paramStringBuilder.a(this.h, "iTimeout");
    paramStringBuilder.a(this.i, "context");
    paramStringBuilder.a(this.j, "status");
    AppMethodBeat.o(224867);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224819);
    paramObject = (h)paramObject;
    if ((q.a(1, paramObject.a)) && (q.a(1, paramObject.b)) && (q.a(1, paramObject.c)) && (q.a(1, paramObject.d)) && (q.a(Integer.valueOf(1), paramObject.e)) && (q.a(Integer.valueOf(1), paramObject.f)) && (q.a(Integer.valueOf(1), paramObject.g)) && (q.a(1, paramObject.h)) && (q.a(Integer.valueOf(1), paramObject.i)) && (q.a(Integer.valueOf(1), paramObject.j)))
    {
      AppMethodBeat.o(224819);
      return true;
    }
    AppMethodBeat.o(224819);
    return false;
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(224850);
    try
    {
      this.a = paramm.a(this.a, 1, true);
      this.b = paramm.a(this.b, 2, true);
      this.c = paramm.a(this.c, 3, true);
      this.d = paramm.a(this.d, 4, true);
      this.e = paramm.b(5, true);
      this.f = paramm.b(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.g = ((byte[])paramm.c(7, true));
      this.h = paramm.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramm.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramm.a(l, 10, true));
      AppMethodBeat.o(224850);
      return;
    }
    catch (Exception paramm)
    {
      System.out.println("RequestPacket decode error " + i.a(this.g));
      paramm = new RuntimeException(paramm);
      AppMethodBeat.o(224850);
      throw paramm;
    }
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(224838);
    paramn.a(this.a, 1);
    paramn.a(this.b, 2);
    paramn.a(this.c, 3);
    paramn.a(this.d, 4);
    paramn.a(this.e, 5);
    paramn.a(this.f, 6);
    paramn.a(this.g, 7);
    paramn.a(this.h, 8);
    paramn.a(this.i, 9);
    paramn.a(this.j, 10);
    AppMethodBeat.o(224838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.h
 * JD-Core Version:    0.7.0.1
 */