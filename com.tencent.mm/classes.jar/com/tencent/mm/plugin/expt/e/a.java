package com.tencent.mm.plugin.expt.e;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
{
  public HashMap<String, String> cache = null;
  public long endTime;
  public int kW;
  public long startTime;
  public int subType;
  public int zNd;
  public int zNe;
  public String zNf;
  public int zNg;
  public int zNh;
  public String zNi;
  
  private void a(HashMap<String, String> paramHashMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(299497);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(299497);
      return;
    }
    String str = paramJSONObject.optString("Key");
    paramJSONObject = paramJSONObject.optString("Val");
    Object localObject;
    if ((!Util.isNullOrNil(str)) && (!Util.isNullOrNil(paramJSONObject)))
    {
      localObject = Base64.decode(paramJSONObject, 0);
      if ((localObject == null) || (localObject.length <= 0)) {
        break label164;
      }
      if (localObject.length > 1048576) {
        break label142;
      }
    }
    label142:
    label164:
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
      if ((str != null) && (Util.isEqual(str, "ECSubType_" + this.zNd))) {
        this.subType = Integer.parseInt(paramJSONObject);
      }
      AppMethodBeat.o(299497);
      return;
      Log.e("MicroMsg.ExptAppItem", "data length more 1M don't parse, reset value. key[%s]", new Object[] { str });
      paramJSONObject = "";
    }
  }
  
  public final boolean TZ(String paramString)
  {
    AppMethodBeat.i(299502);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(299502);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.zNd = localJSONObject.optInt("ExptId");
      this.kW = localJSONObject.optInt("GroupId");
      this.zNe = localJSONObject.optInt("ExptSequence");
      this.zNf = paramString;
      this.startTime = localJSONObject.optLong("StartTime");
      this.endTime = localJSONObject.optLong("EndTime");
      this.zNg = localJSONObject.optInt("ExptType");
      this.zNh = localJSONObject.optInt("SvrType");
      this.zNi = localJSONObject.optString("ExptCheckSum");
      dNo();
      Log.v("MicroMsg.ExptAppItem", "convertFrom new [%s] args[%s]", new Object[] { toString(), paramString });
      AppMethodBeat.o(299502);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ExptAppItem", "%d convertFrom [%s] error [%s]", new Object[] { Integer.valueOf(hashCode()), paramString, localException.toString() });
      AppMethodBeat.o(299502);
    }
    return false;
  }
  
  /* Error */
  public final HashMap<String, String> dNo()
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 26	com/tencent/mm/plugin/expt/e/a:cache	Ljava/util/HashMap;
    //   9: ifnull +15 -> 24
    //   12: aload_0
    //   13: getfield 26	com/tencent/mm/plugin/expt/e/a:cache	Ljava/util/HashMap;
    //   16: astore_2
    //   17: ldc 186
    //   19: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_2
    //   23: areturn
    //   24: aload_0
    //   25: getfield 140	com/tencent/mm/plugin/expt/e/a:zNf	Ljava/lang/String;
    //   28: invokestatic 59	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   31: ifne +156 -> 187
    //   34: new 47	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 140	com/tencent/mm/plugin/expt/e/a:zNf	Ljava/lang/String;
    //   42: invokespecial 125	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: ldc 188
    //   47: invokevirtual 192	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +10 -> 62
    //   55: ldc 186
    //   57: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aconst_null
    //   61: areturn
    //   62: new 75	java/util/HashMap
    //   65: dup
    //   66: invokespecial 193	java/util/HashMap:<init>	()V
    //   69: astore_2
    //   70: aload_3
    //   71: instanceof 195
    //   74: ifeq +56 -> 130
    //   77: aload_3
    //   78: checkcast 195	org/json/JSONArray
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +30 -> 113
    //   86: iconst_0
    //   87: istore_1
    //   88: iload_1
    //   89: aload_3
    //   90: invokevirtual 198	org/json/JSONArray:length	()I
    //   93: if_icmpge +20 -> 113
    //   96: aload_0
    //   97: aload_2
    //   98: aload_3
    //   99: iload_1
    //   100: invokevirtual 202	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   103: invokespecial 204	com/tencent/mm/plugin/expt/e/a:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   106: iload_1
    //   107: iconst_1
    //   108: iadd
    //   109: istore_1
    //   110: goto -22 -> 88
    //   113: aload_0
    //   114: aload_2
    //   115: putfield 26	com/tencent/mm/plugin/expt/e/a:cache	Ljava/util/HashMap;
    //   118: aload_0
    //   119: getfield 26	com/tencent/mm/plugin/expt/e/a:cache	Ljava/util/HashMap;
    //   122: astore_2
    //   123: ldc 186
    //   125: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_2
    //   129: areturn
    //   130: aload_3
    //   131: instanceof 47
    //   134: ifeq +12 -> 146
    //   137: aload_0
    //   138: aload_2
    //   139: aload_3
    //   140: checkcast 47	org/json/JSONObject
    //   143: invokespecial 204	com/tencent/mm/plugin/expt/e/a:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   146: goto -33 -> 113
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_2
    //   152: ldc 110
    //   154: ldc 206
    //   156: iconst_2
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_3
    //   163: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload_0
    //   170: getfield 88	com/tencent/mm/plugin/expt/e/a:zNd	I
    //   173: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: goto -67 -> 113
    //   183: astore_3
    //   184: goto -32 -> 152
    //   187: aconst_null
    //   188: astore_2
    //   189: goto -76 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	a
    //   87	23	1	i	int
    //   16	173	2	localHashMap	HashMap
    //   50	90	3	localObject	Object
    //   149	14	3	localException1	Exception
    //   183	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   34	51	149	java/lang/Exception
    //   62	70	149	java/lang/Exception
    //   70	82	183	java/lang/Exception
    //   88	106	183	java/lang/Exception
    //   130	146	183	java/lang/Exception
  }
  
  public final boolean dNp()
  {
    return this.subType == 7;
  }
  
  public final boolean dNq()
  {
    return this.subType == 8;
  }
  
  public final boolean isReady()
  {
    boolean bool2 = false;
    AppMethodBeat.i(299518);
    boolean bool1;
    if (this.zNe < 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(299518);
      return bool1;
      long l = Util.nowSecond();
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
    AppMethodBeat.i(299513);
    String str = "ExptAppItem{exptId=" + this.zNd + ", groupId=" + this.kW + ", exptSeq=" + this.zNe + ", exptContent='" + this.zNf + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", exptType=" + this.zNg + ", svrType=" + this.zNh + ", exptCheckSum='" + this.zNi + '\'' + '}';
    AppMethodBeat.o(299513);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.a
 * JD-Core Version:    0.7.0.1
 */