package com.tencent.tencentmap.mapsdk.map;

import com.tencent.tencentmap.mapsdk.a.a;
import com.tencent.tencentmap.mapsdk.a.e;
import java.io.IOException;
import org.json.JSONException;

abstract class c<T, V>
{
  protected T a;
  protected String b = null;
  protected String c = "";
  
  public c(T paramT)
  {
    this.a = paramT;
  }
  
  protected abstract V a(byte[] paramArrayOfByte)
    throws IOException, JSONException;
  
  protected abstract String a();
  
  public V b()
  {
    if (this.a == null) {
      return null;
    }
    Object localObject1 = null;
    this.c = a();
    Object localObject3;
    try
    {
      localObject3 = a.a(this.c, "androidsdk");
      if ((localObject3 == null) || (((e)localObject3).a == null)) {
        return null;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      return null;
    }
    this.b = ((e)localObject3).b;
    try
    {
      localObject3 = a(((e)localObject3).a);
      localObject2 = localObject3;
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      return null;
    }
    catch (JSONException localJSONException)
    {
      label67:
      break label67;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.c
 * JD-Core Version:    0.7.0.1
 */