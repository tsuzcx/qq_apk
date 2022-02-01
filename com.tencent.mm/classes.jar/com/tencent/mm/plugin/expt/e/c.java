package com.tencent.mm.plugin.expt.e;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bu;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONObject;

public final class c
  extends bu
{
  public static IAutoDBItem.MAutoDBInfo info;
  private HashMap<String, String> cache = null;
  
  static
  {
    AppMethodBeat.i(156047);
    info = bu.aJm();
    AppMethodBeat.o(156047);
  }
  
  private static void a(HashMap<String, String> paramHashMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(156044);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(156044);
      return;
    }
    String str2 = paramJSONObject.optString("Key");
    String str1 = paramJSONObject.optString("Val");
    byte[] arrayOfByte;
    if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str1)))
    {
      arrayOfByte = Base64.decode(str1, 0);
      paramJSONObject = str1;
      if (arrayOfByte != null)
      {
        paramJSONObject = str1;
        if ((arrayOfByte.length > 0) && (arrayOfByte.length > 1048576)) {
          break label113;
        }
      }
    }
    try
    {
      paramJSONObject = Charset.forName("UTF-8").decode(ByteBuffer.wrap(arrayOfByte));
      paramJSONObject = String.valueOf(paramJSONObject.array(), 0, paramJSONObject.limit());
      for (;;)
      {
        paramHashMap.put(str2, paramJSONObject);
        AppMethodBeat.o(156044);
        return;
        label113:
        Log.e("MicroMsg.ExptItem", "data length more 1M don't parse, reset value. key[%s]", new Object[] { str2 });
        paramJSONObject = "";
        f.Ozc.idkeyStat(863L, 16L, 1L, false);
      }
    }
    catch (Error paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = str1;
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = str1;
      }
    }
  }
  
  private static String atr(String paramString)
  {
    AppMethodBeat.i(156045);
    String str1 = "";
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(156045);
      return "";
    }
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c != '^')
      {
        str1 = str1 + c;
        i += 1;
      }
      else if (paramString.charAt(i + 1) != '^')
      {
        int k = eo(paramString.substring(i + 1, i + 3), 2);
        int j = eo(paramString.charAt(i + 3), 1) + 5;
        k = str1.length() - k - j;
        String str2 = str1.substring(k, j + k);
        str1 = str1 + str2;
        i += 4;
      }
      else
      {
        str1 = str1 + "^";
        i += 2;
      }
    }
    AppMethodBeat.o(156045);
    return str1;
  }
  
  private static int eo(String paramString, int paramInt)
  {
    AppMethodBeat.i(156046);
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= paramInt) {
        break;
      }
      i *= 64;
      int m = paramString.charAt(j);
      k = i;
      if (m < 32) {
        break;
      }
      k = i;
      if (m > 95) {
        break;
      }
      i += m - 32;
      j += 1;
    }
    AppMethodBeat.o(156046);
    return k;
  }
  
  public final boolean TZ(String paramString)
  {
    AppMethodBeat.i(156037);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(156037);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str = toString();
      this.field_exptContent = paramString;
      this.field_exptId = localJSONObject.optInt("ExptId");
      this.field_groupId = localJSONObject.optInt("GroupId");
      this.field_exptSeq = localJSONObject.optInt("ExptSequence");
      this.field_startTime = localJSONObject.optLong("StartTime");
      this.field_endTime = localJSONObject.optLong("EndTime");
      this.field_exptType = localJSONObject.optInt("ExptType");
      this.field_exptCheckSum = localJSONObject.optString("ExptCheckSum");
      dNo();
      if ((this.cache != null) && (this.cache.containsKey("jsoncfg_param_" + this.field_exptId + "_subtype"))) {}
      for (this.field_subType = Util.getInt((String)this.cache.get("jsoncfg_param_" + this.field_exptId + "_subtype"), 0);; this.field_subType = 0)
      {
        Log.v("MicroMsg.ExptItem", "convertFrom new [%s] old[%s] args[%s]", new Object[] { toString(), str, paramString });
        AppMethodBeat.o(156037);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      f.Ozc.idkeyStat(863L, 5L, 1L, false);
      Log.e("MicroMsg.ExptItem", "%d convertFrom [%s] error [%s]", new Object[] { Integer.valueOf(hashCode()), paramString, localException.toString() });
      AppMethodBeat.o(156037);
    }
  }
  
  public final boolean dNA()
  {
    return this.field_subType == 4;
  }
  
  public final boolean dNB()
  {
    return this.field_subType == 5;
  }
  
  public final boolean dNC()
  {
    return this.field_subType == 6;
  }
  
  public final boolean dND()
  {
    AppMethodBeat.i(299567);
    if ((dNx()) || (dNy()) || (dNz()) || (dNA()) || (dNB()) || (dNC()))
    {
      AppMethodBeat.o(299567);
      return true;
    }
    AppMethodBeat.o(299567);
    return false;
  }
  
  public final boolean dNE()
  {
    return (this.field_exptType == 2) || (this.field_exptType == 130);
  }
  
  public final boolean dNF()
  {
    AppMethodBeat.i(156040);
    if ((this.cache == null) || (this.cache.size() <= 0))
    {
      AppMethodBeat.o(156040);
      return false;
    }
    if (Util.getInt((String)this.cache.get("jsoncfg_param_" + this.field_exptId + "_report"), 0) > 0)
    {
      AppMethodBeat.o(156040);
      return true;
    }
    AppMethodBeat.o(156040);
    return false;
  }
  
  public final long dNG()
  {
    AppMethodBeat.i(156041);
    if ((this.cache == null) || (this.cache.size() <= 0))
    {
      AppMethodBeat.o(156041);
      return 0L;
    }
    long l = Util.getLong((String)this.cache.get("jsoncfg_param_" + this.field_exptId + "_sessionpageid"), 0L);
    AppMethodBeat.o(156041);
    return l;
  }
  
  public final String dNH()
  {
    AppMethodBeat.i(156042);
    if (!dND())
    {
      AppMethodBeat.o(156042);
      return "";
    }
    if ((this.cache == null) || (this.cache.size() <= 0)) {
      dNo();
    }
    Object localObject2 = this.cache;
    if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0))
    {
      AppMethodBeat.o(156042);
      return "";
    }
    String str3 = "jsoncfg_param_" + this.field_exptId + "_";
    int j = Util.getInt((String)((HashMap)localObject2).get(str3 + "size"), 0);
    if (j <= 0)
    {
      AppMethodBeat.o(156042);
      return "";
    }
    Object localObject1 = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append((String)((HashMap)localObject2).get(str3 + i));
      i += 1;
    }
    String str2 = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      try
      {
        if (Util.getInt((String)((HashMap)localObject2).get(str3 + "decompress"), 0) <= 0) {
          continue;
        }
        localObject1 = atr(str2);
        String str4 = MD5Util.getMD5String((String)localObject1);
        localObject2 = (String)((HashMap)localObject2).get(str3 + "md5");
        if (str4 == null) {
          continue;
        }
        boolean bool = str4.equalsIgnoreCase((String)localObject2);
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ExptItem", localException, "tosession config e[%s]", new Object[] { localException.toString() });
        String str1 = "";
        continue;
      }
      AppMethodBeat.o(156042);
      return localObject1;
      f.Ozc.idkeyStat(863L, 12L, 1L, false);
      Log.e("MicroMsg.ExptItem", "to session config but md5 not right deJson[%s] json[%s]", new Object[] { localObject1, str2 });
      localObject1 = "";
      continue;
      localObject1 = ((StringBuilder)localObject1).toString();
    }
  }
  
  /* Error */
  public final HashMap<String, String> dNo()
  {
    // Byte code:
    //   0: ldc_w 335
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 33	com/tencent/mm/plugin/expt/e/c:cache	Ljava/util/HashMap;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 33	com/tencent/mm/plugin/expt/e/c:cache	Ljava/util/HashMap;
    //   17: astore_2
    //   18: ldc_w 335
    //   21: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: getfield 176	com/tencent/mm/plugin/expt/e/c:field_exptContent	Ljava/lang/String;
    //   30: invokestatic 56	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   33: ifne +160 -> 193
    //   36: aload_0
    //   37: getfield 176	com/tencent/mm/plugin/expt/e/c:field_exptContent	Ljava/lang/String;
    //   40: astore_2
    //   41: new 44	org/json/JSONObject
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: ldc_w 337
    //   52: invokevirtual 340	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +11 -> 68
    //   60: ldc_w 335
    //   63: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: new 98	java/util/HashMap
    //   71: dup
    //   72: invokespecial 341	java/util/HashMap:<init>	()V
    //   75: astore_2
    //   76: aload_3
    //   77: instanceof 343
    //   80: ifeq +56 -> 136
    //   83: aload_3
    //   84: checkcast 343	org/json/JSONArray
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +29 -> 118
    //   92: iconst_0
    //   93: istore_1
    //   94: iload_1
    //   95: aload_3
    //   96: invokevirtual 344	org/json/JSONArray:length	()I
    //   99: if_icmpge +19 -> 118
    //   102: aload_2
    //   103: aload_3
    //   104: iload_1
    //   105: invokevirtual 348	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   108: invokestatic 350	com/tencent/mm/plugin/expt/e/c:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   111: iload_1
    //   112: iconst_1
    //   113: iadd
    //   114: istore_1
    //   115: goto -21 -> 94
    //   118: aload_0
    //   119: aload_2
    //   120: putfield 33	com/tencent/mm/plugin/expt/e/c:cache	Ljava/util/HashMap;
    //   123: aload_0
    //   124: getfield 33	com/tencent/mm/plugin/expt/e/c:cache	Ljava/util/HashMap;
    //   127: astore_2
    //   128: ldc_w 335
    //   131: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_2
    //   135: areturn
    //   136: aload_3
    //   137: instanceof 44
    //   140: ifeq +11 -> 151
    //   143: aload_2
    //   144: aload_3
    //   145: checkcast 44	org/json/JSONObject
    //   148: invokestatic 350	com/tencent/mm/plugin/expt/e/c:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   151: goto -33 -> 118
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: ldc 104
    //   159: ldc_w 352
    //   162: iconst_2
    //   163: anewarray 108	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_3
    //   169: invokevirtual 265	java/lang/Exception:toString	()Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield 186	com/tencent/mm/plugin/expt/e/c:field_exptId	I
    //   179: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: goto -68 -> 118
    //   189: astore_3
    //   190: goto -33 -> 157
    //   193: aconst_null
    //   194: astore_2
    //   195: goto -77 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	c
    //   93	22	1	i	int
    //   17	178	2	localObject1	Object
    //   55	90	3	localObject2	Object
    //   154	15	3	localException1	Exception
    //   189	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   41	56	154	java/lang/Exception
    //   68	76	154	java/lang/Exception
    //   76	88	189	java/lang/Exception
    //   94	111	189	java/lang/Exception
    //   136	151	189	java/lang/Exception
  }
  
  public final boolean dNw()
  {
    return this.field_exptType == 10;
  }
  
  public final boolean dNx()
  {
    return this.field_subType == 1;
  }
  
  public final boolean dNy()
  {
    return this.field_subType == 2;
  }
  
  public final boolean dNz()
  {
    return this.field_subType == 3;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean isReady()
  {
    boolean bool2 = false;
    AppMethodBeat.i(156039);
    boolean bool1;
    if (this.field_exptSeq < 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(156039);
      return bool1;
      long l = Util.nowSecond();
      bool1 = bool2;
      if (l >= this.field_startTime) {
        if (this.field_endTime > 0L)
        {
          bool1 = bool2;
          if (l > this.field_endTime) {}
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
    AppMethodBeat.i(156038);
    String str = "{ Id: " + this.field_exptId + " group: " + this.field_groupId + " seq: " + this.field_exptSeq + " startTime: " + this.field_startTime + " endTime: " + this.field_endTime + " content: " + this.field_exptContent + " type: " + this.field_exptType + " subtype: " + this.field_subType + " }";
    AppMethodBeat.o(156038);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.c
 * JD-Core Version:    0.7.0.1
 */