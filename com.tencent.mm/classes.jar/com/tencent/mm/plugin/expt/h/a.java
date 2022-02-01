package com.tencent.mm.plugin.expt.h;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
{
  public int adG;
  public HashMap<String, String> cache = null;
  public long endTime;
  public int rbA;
  public int rbB;
  public String rbC;
  public int rbx;
  public int rby;
  public String rbz;
  public long startTime;
  
  private static void a(HashMap<String, String> paramHashMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195152);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(195152);
      return;
    }
    String str = paramJSONObject.optString("Key");
    paramJSONObject = paramJSONObject.optString("Val");
    Object localObject;
    if ((!bt.isNullOrNil(str)) && (!bt.isNullOrNil(paramJSONObject)))
    {
      localObject = Base64.decode(paramJSONObject, 0);
      if ((localObject == null) || (localObject.length <= 0)) {
        break label120;
      }
      if (localObject.length > 1048576) {
        break label99;
      }
    }
    label99:
    label120:
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramJSONObject = (JSONObject)localObject;
      }
      catch (Exception localException)
      {
        continue;
      }
      catch (Error localError)
      {
        continue;
      }
      paramHashMap.put(str, paramJSONObject);
      AppMethodBeat.o(195152);
      return;
      ad.e("MicroMsg.ExptAppItem", "data length more 1M don't parse, reset value. key[%s]", new Object[] { str });
      paramJSONObject = "";
    }
  }
  
  public final boolean afB(String paramString)
  {
    AppMethodBeat.i(195150);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195150);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.rbx = localJSONObject.optInt("ExptId");
      this.adG = localJSONObject.optInt("GroupId");
      this.rby = localJSONObject.optInt("ExptSequence");
      this.rbz = paramString;
      this.startTime = localJSONObject.optLong("StartTime");
      this.endTime = localJSONObject.optLong("EndTime");
      this.rbA = localJSONObject.optInt("ExptType");
      this.rbB = localJSONObject.optInt("SvrType");
      this.rbC = localJSONObject.optString("ExptCheckSum");
      cry();
      ad.v("MicroMsg.ExptAppItem", "convertFrom new [%s] args[%s]", new Object[] { toString(), paramString });
      AppMethodBeat.o(195150);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ExptAppItem", "%d convertFrom [%s] error [%s]", new Object[] { Integer.valueOf(hashCode()), paramString, localException.toString() });
      AppMethodBeat.o(195150);
    }
    return false;
  }
  
  /* Error */
  public final HashMap<String, String> cry()
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 25	com/tencent/mm/plugin/expt/h/a:cache	Ljava/util/HashMap;
    //   9: ifnull +15 -> 24
    //   12: aload_0
    //   13: getfield 25	com/tencent/mm/plugin/expt/h/a:cache	Ljava/util/HashMap;
    //   16: astore_2
    //   17: ldc 166
    //   19: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_2
    //   23: areturn
    //   24: aload_0
    //   25: getfield 115	com/tencent/mm/plugin/expt/h/a:rbz	Ljava/lang/String;
    //   28: invokestatic 58	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   31: ifne +154 -> 185
    //   34: new 46	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 115	com/tencent/mm/plugin/expt/h/a:rbz	Ljava/lang/String;
    //   42: invokespecial 97	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: ldc 168
    //   47: invokevirtual 172	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +10 -> 62
    //   55: ldc 166
    //   57: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aconst_null
    //   61: areturn
    //   62: new 74	java/util/HashMap
    //   65: dup
    //   66: invokespecial 173	java/util/HashMap:<init>	()V
    //   69: astore_2
    //   70: aload_3
    //   71: instanceof 175
    //   74: ifeq +55 -> 129
    //   77: aload_3
    //   78: checkcast 175	org/json/JSONArray
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +29 -> 112
    //   86: iconst_0
    //   87: istore_1
    //   88: iload_1
    //   89: aload_3
    //   90: invokevirtual 178	org/json/JSONArray:length	()I
    //   93: if_icmpge +19 -> 112
    //   96: aload_2
    //   97: aload_3
    //   98: iload_1
    //   99: invokevirtual 182	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   102: invokestatic 184	com/tencent/mm/plugin/expt/h/a:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: goto -21 -> 88
    //   112: aload_0
    //   113: aload_2
    //   114: putfield 25	com/tencent/mm/plugin/expt/h/a:cache	Ljava/util/HashMap;
    //   117: aload_0
    //   118: getfield 25	com/tencent/mm/plugin/expt/h/a:cache	Ljava/util/HashMap;
    //   121: astore_2
    //   122: ldc 166
    //   124: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_2
    //   128: areturn
    //   129: aload_3
    //   130: instanceof 46
    //   133: ifeq +11 -> 144
    //   136: aload_2
    //   137: aload_3
    //   138: checkcast 46	org/json/JSONObject
    //   141: invokestatic 184	com/tencent/mm/plugin/expt/h/a:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   144: goto -32 -> 112
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_2
    //   150: ldc 80
    //   152: ldc 186
    //   154: iconst_2
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_3
    //   161: invokevirtual 165	java/lang/Exception:toString	()Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_0
    //   168: getfield 105	com/tencent/mm/plugin/expt/h/a:rbx	I
    //   171: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: invokestatic 88	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -66 -> 112
    //   181: astore_3
    //   182: goto -32 -> 150
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -75 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	a
    //   87	22	1	i	int
    //   16	171	2	localHashMap	HashMap
    //   50	88	3	localObject	Object
    //   147	14	3	localException1	Exception
    //   181	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   34	51	147	java/lang/Exception
    //   62	70	147	java/lang/Exception
    //   70	82	181	java/lang/Exception
    //   88	105	181	java/lang/Exception
    //   129	144	181	java/lang/Exception
  }
  
  public final boolean isReady()
  {
    boolean bool2 = false;
    AppMethodBeat.i(195154);
    boolean bool1;
    if (this.rby < 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(195154);
      return bool1;
      long l = bt.aQJ();
      bool1 = bool2;
      if (l >= this.startTime) {
        if (this.endTime > 0L)
        {
          bool1 = bool2;
          if (l > this.endTime) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195153);
    String str = "ExptAppItem{exptId=" + this.rbx + ", groupId=" + this.adG + ", exptSeq=" + this.rby + ", exptContent='" + this.rbz + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", exptType=" + this.rbA + ", svrType=" + this.rbB + ", exptCheckSum='" + this.rbC + '\'' + '}';
    AppMethodBeat.o(195153);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.h.a
 * JD-Core Version:    0.7.0.1
 */