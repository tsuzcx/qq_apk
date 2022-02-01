package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends f
{
  private static final long k = 1L;
  
  public d()
  {
    AppMethodBeat.i(223921);
    this.g.a = 2;
    this.g.b = 0;
    this.g.c = 0;
    this.g.h = 0;
    this.g.g = new byte[0];
    this.g.i = new HashMap();
    this.g.j = new HashMap();
    AppMethodBeat.o(223921);
  }
  
  private void a(byte paramByte)
  {
    this.g.b = paramByte;
  }
  
  private void a(int paramInt)
  {
    this.g.c = paramInt;
  }
  
  private void a(Map<String, String> paramMap)
  {
    this.g.i = paramMap;
  }
  
  private void a(short paramShort)
  {
    AppMethodBeat.i(223934);
    this.g.a = paramShort;
    if (paramShort == 3) {
      g();
    }
    AppMethodBeat.o(223934);
  }
  
  private void b(int paramInt)
  {
    this.g.h = paramInt;
  }
  
  private void b(Map<String, String> paramMap)
  {
    this.g.j = paramMap;
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    this.g.g = paramArrayOfByte;
  }
  
  private short h()
  {
    return this.g.a;
  }
  
  private byte i()
  {
    return this.g.b;
  }
  
  private int j()
  {
    return this.g.c;
  }
  
  private int k()
  {
    return this.g.h;
  }
  
  private byte[] l()
  {
    return this.g.g;
  }
  
  private Map<String, String> m()
  {
    return this.g.i;
  }
  
  private Map<String, String> n()
  {
    return this.g.j;
  }
  
  private int o()
  {
    AppMethodBeat.i(224031);
    String str = (String)this.g.j.get("STATUS_RESULT_CODE");
    if (str != null)
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(224031);
      return i;
    }
    AppMethodBeat.o(224031);
    return 0;
  }
  
  private String p()
  {
    AppMethodBeat.i(224039);
    String str = (String)this.g.j.get("STATUS_RESULT_DESC");
    if (str != null)
    {
      AppMethodBeat.o(224039);
      return str;
    }
    AppMethodBeat.o(224039);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.d
 * JD-Core Version:    0.7.0.1
 */