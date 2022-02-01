package com.tencent.tencentmap.mapsdk.map;

import org.json.JSONException;
import org.json.JSONObject;

class f
  extends c<String, Boolean>
{
  public f(String paramString)
  {
    super(paramString);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      JSONObject localJSONObject = null;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("cfg");
        localJSONObject = paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        label16:
        break label16;
      }
      if (localJSONObject == null) {
        continue;
      }
      paramJSONObject = null;
      try
      {
        localObject2 = localJSONObject.getJSONObject("satellite_map");
        paramJSONObject = (JSONObject)localObject2;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject2;
        label31:
        label48:
        break label31;
      }
      if (paramJSONObject == null) {
        continue;
      }
      localObject2 = null;
      try
      {
        String str = paramJSONObject.getString("ver");
        localObject2 = str;
      }
      catch (JSONException localJSONException3)
      {
        break label48;
      }
      if (localObject2 != null) {
        q.a("map_satellite", (String)localObject2);
      }
      localObject2 = null;
      try
      {
        localJSONObject = localJSONObject.getJSONObject("raster_base_map");
        if (localJSONObject == null) {
          continue;
        }
        localJSONObject = null;
        try
        {
          paramJSONObject = paramJSONObject.getString("ver");
          if (paramJSONObject == null) {
            continue;
          }
          q.a("map_raster", paramJSONObject);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject = localJSONObject;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
        }
      }
    }
  }
  
  protected String a()
  {
    return (String)this.a;
  }
  
  /* Error */
  protected Boolean b(byte[] paramArrayOfByte)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: new 56	java/lang/String
    //   12: dup
    //   13: aload_1
    //   14: aload_0
    //   15: getfield 65	com/tencent/tencentmap/mapsdk/map/f:b	Ljava/lang/String;
    //   18: invokespecial 68	java/lang/String:<init>	([BLjava/lang/String;)V
    //   21: astore_1
    //   22: new 19	org/json/JSONObject
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 70	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 72
    //   34: invokevirtual 23	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 74
    //   41: invokevirtual 78	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +50 -> 96
    //   49: getstatic 83	com/tencent/tencentmap/mapsdk/map/q$a:a	Lcom/tencent/tencentmap/mapsdk/map/q$a;
    //   52: putstatic 84	com/tencent/tencentmap/mapsdk/map/q:a	Lcom/tencent/tencentmap/mapsdk/map/q$a;
    //   55: invokestatic 87	com/tencent/tencentmap/mapsdk/map/q:b	()Ljava/util/Date;
    //   58: putstatic 90	com/tencent/tencentmap/mapsdk/map/q:b	Ljava/util/Date;
    //   61: aload_1
    //   62: ldc 92
    //   64: invokevirtual 23	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   67: astore_1
    //   68: aload_0
    //   69: aload_1
    //   70: invokespecial 94	com/tencent/tencentmap/mapsdk/map/f:a	(Lorg/json/JSONObject;)V
    //   73: iconst_1
    //   74: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: areturn
    //   78: astore_1
    //   79: iconst_0
    //   80: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   83: areturn
    //   84: astore_1
    //   85: iconst_0
    //   86: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   89: areturn
    //   90: astore_1
    //   91: iconst_0
    //   92: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   95: areturn
    //   96: getstatic 96	com/tencent/tencentmap/mapsdk/map/q$a:b	Lcom/tencent/tencentmap/mapsdk/map/q$a;
    //   99: putstatic 84	com/tencent/tencentmap/mapsdk/map/q:a	Lcom/tencent/tencentmap/mapsdk/map/q$a;
    //   102: goto -47 -> 55
    //   105: astore_1
    //   106: iconst_0
    //   107: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   110: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	f
    //   0	111	1	paramArrayOfByte	byte[]
    //   44	2	2	i	int
    //   37	2	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   22	31	78	org/json/JSONException
    //   31	38	84	org/json/JSONException
    //   38	45	90	org/json/JSONException
    //   61	68	105	org/json/JSONException
  }
  
  public Boolean c()
  {
    return (Boolean)b();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.f
 * JD-Core Version:    0.7.0.1
 */