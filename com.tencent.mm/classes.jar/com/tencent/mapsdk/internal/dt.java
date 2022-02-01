package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class dt<OUT extends JsonComposer>
  extends dq
{
  private Class<OUT> a;
  
  public dt(Class<OUT> paramClass)
  {
    this.a = paramClass;
  }
  
  private a<OUT> b(NetResponse paramNetResponse)
  {
    AppMethodBeat.i(222962);
    paramNetResponse = new a(paramNetResponse, this.a);
    AppMethodBeat.o(222962);
    return paramNetResponse;
  }
  
  public static final class a<OUT extends JsonComposer>
    extends NetResponse
  {
    public String a;
    public OUT b;
    
    public a(NetResponse paramNetResponse)
    {
      AppMethodBeat.i(222646);
      clone(paramNetResponse);
      if (paramNetResponse.available()) {
        try
        {
          this.a = new String(paramNetResponse.data, paramNetResponse.charset);
          AppMethodBeat.o(222646);
          return;
        }
        catch (UnsupportedEncodingException paramNetResponse) {}
      }
      AppMethodBeat.o(222646);
    }
    
    public a(NetResponse paramNetResponse, Class<OUT> paramClass)
    {
      AppMethodBeat.i(222653);
      clone(paramNetResponse);
      if (paramNetResponse.available()) {
        try
        {
          this.a = new String(paramNetResponse.data, paramNetResponse.charset);
          this.b = ((JsonComposer)JsonUtils.parseToModel(this.a, paramClass, new Object[0]));
          AppMethodBeat.o(222653);
          return;
        }
        catch (UnsupportedEncodingException paramNetResponse) {}
      }
      AppMethodBeat.o(222653);
    }
    
    private String a()
    {
      return this.a;
    }
    
    private OUT b()
    {
      return this.b;
    }
    
    public final boolean available()
    {
      AppMethodBeat.i(222676);
      if ((super.available()) && (this.a != null) && (!TextUtils.isEmpty(this.a)))
      {
        AppMethodBeat.o(222676);
        return true;
      }
      AppMethodBeat.o(222676);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dt
 * JD-Core Version:    0.7.0.1
 */