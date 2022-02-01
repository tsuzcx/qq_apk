package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class dr
  extends dq
{
  private String a;
  private String b;
  
  public dr(String paramString)
  {
    this.a = paramString;
  }
  
  private a b(NetResponse paramNetResponse)
  {
    AppMethodBeat.i(222987);
    paramNetResponse = new a(paramNetResponse, this.b, this.a);
    AppMethodBeat.o(222987);
    return paramNetResponse;
  }
  
  public final Object[] a(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(222992);
    if ((paramArrayOfObject != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length == 1) && (paramArrayOfObject.length > 0))
    {
      Object localObject = paramArrayOfObject[paramArrayOfInt[0]];
      if ((localObject instanceof String)) {
        this.b = String.valueOf(localObject);
      }
    }
    paramArrayOfInt = super.a(paramArrayOfInt, paramArrayOfObject);
    AppMethodBeat.o(222992);
    return paramArrayOfInt;
  }
  
  public static final class a
    extends NetResponse
  {
    private File a;
    
    public a(NetResponse paramNetResponse, String paramString1, String paramString2)
    {
      AppMethodBeat.i(222394);
      clone(paramNetResponse);
      if (paramNetResponse.available())
      {
        this.a = new File(paramString1, paramString2);
        paramString1 = new File(paramString1, paramString2 + ".tmp");
        ka.b(paramString1);
        if ((ka.a(paramString1)) && (ka.a(paramString1, paramNetResponse.data)) && (ka.a(paramString1, this.a))) {
          ka.b(paramString1);
        }
      }
      AppMethodBeat.o(222394);
    }
    
    private File a()
    {
      return this.a;
    }
    
    public final boolean available()
    {
      AppMethodBeat.i(222410);
      if ((super.available()) && (this.a != null) && (this.a.exists()))
      {
        AppMethodBeat.o(222410);
        return true;
      }
      AppMethodBeat.o(222410);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dr
 * JD-Core Version:    0.7.0.1
 */