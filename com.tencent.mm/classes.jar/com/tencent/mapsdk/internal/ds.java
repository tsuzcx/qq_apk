package com.tencent.mapsdk.internal;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ds<IN extends MapJceStruct, OUT extends MapJceStruct>
  extends dq
{
  private Class<IN> a;
  private Class<OUT> b;
  private MapJceStruct c;
  
  public ds(Class<IN> paramClass, Class<OUT> paramClass1)
  {
    this.a = paramClass;
    this.b = paramClass1;
  }
  
  private a<OUT> b(NetResponse paramNetResponse)
  {
    AppMethodBeat.i(222975);
    paramNetResponse = new a(paramNetResponse, this.b);
    AppMethodBeat.o(222975);
    return paramNetResponse;
  }
  
  public final Object[] a(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    int j = 0;
    AppMethodBeat.i(222986);
    if ((paramArrayOfObject != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfObject.length > 0))
    {
      List localList = Arrays.asList(paramArrayOfObject);
      int k = paramArrayOfInt[0];
      int i;
      if (paramArrayOfInt.length == 1)
      {
        i = paramArrayOfInt[0];
        if ((paramArrayOfObject.length - 1 < i) || (k < 0)) {
          break label200;
        }
        paramArrayOfInt = Arrays.copyOfRange(paramArrayOfObject, k, i + 1);
        this.c = ((MapJceStruct)gy.a(this.a, paramArrayOfInt));
        paramArrayOfInt = new byte[0];
        if (this.c != null) {
          paramArrayOfInt = this.c.toByteArray();
        }
        paramArrayOfObject = new ArrayList();
        label112:
        if (j >= localList.size()) {
          break label186;
        }
        if ((j < k) || (j > i)) {
          break label167;
        }
        if (j == i) {
          paramArrayOfObject.add(paramArrayOfInt);
        }
      }
      for (;;)
      {
        j += 1;
        break label112;
        i = paramArrayOfInt[1];
        break;
        label167:
        paramArrayOfObject.add(localList.get(j));
      }
      label186:
      paramArrayOfInt = paramArrayOfObject.toArray();
      AppMethodBeat.o(222986);
      return paramArrayOfInt;
    }
    label200:
    paramArrayOfInt = super.a(paramArrayOfInt, paramArrayOfObject);
    AppMethodBeat.o(222986);
    return paramArrayOfInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(222991);
    Object localObject = new StringBuffer("JceResolver{");
    ((StringBuffer)localObject).append("inJce=").append(this.c);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(222991);
    return localObject;
  }
  
  public static final class a<OUT extends MapJceStruct>
    extends NetResponse
  {
    public OUT a;
    
    public a(NetResponse paramNetResponse, Class<OUT> paramClass)
    {
      AppMethodBeat.i(225626);
      clone(paramNetResponse);
      if (paramNetResponse.data != null)
      {
        paramNetResponse = new m(paramNetResponse.data);
        this.a = ((MapJceStruct)gy.a(paramClass, new Object[0]));
        if (this.a != null) {
          this.a.readFrom(paramNetResponse);
        }
      }
      kh.c("TS", "[JCE-RESP]:" + this.a);
      AppMethodBeat.o(225626);
    }
    
    private OUT a()
    {
      return this.a;
    }
    
    public final boolean available()
    {
      AppMethodBeat.i(225638);
      if ((super.available()) && (this.a != null))
      {
        AppMethodBeat.o(225638);
        return true;
      }
      AppMethodBeat.o(225638);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ds
 * JD-Core Version:    0.7.0.1
 */