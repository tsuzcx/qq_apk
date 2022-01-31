package com.tencent.mm.plugin.expt.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bi;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends bi
{
  public static c.a info;
  private HashMap<String, String> cache = null;
  
  static
  {
    AppMethodBeat.i(93273);
    c.a locala = new c.a();
    locala.yrK = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "exptId";
    locala.yrM.put("exptId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" exptId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "exptId";
    locala.columns[1] = "groupId";
    locala.yrM.put("groupId", "INTEGER");
    localStringBuilder.append(" groupId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "exptSeq";
    locala.yrM.put("exptSeq", "INTEGER");
    localStringBuilder.append(" exptSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "exptContent";
    locala.yrM.put("exptContent", "TEXT");
    localStringBuilder.append(" exptContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "startTime";
    locala.yrM.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "endTime";
    locala.yrM.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "exptType";
    locala.yrM.put("exptType", "INTEGER");
    localStringBuilder.append(" exptType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "subType";
    locala.yrM.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "exptCheckSum";
    locala.yrM.put("exptCheckSum", "TEXT");
    localStringBuilder.append(" exptCheckSum TEXT");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(93273);
  }
  
  private static String MY(String paramString)
  {
    AppMethodBeat.i(139724);
    String str1 = "";
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(139724);
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
        int k = ch(paramString.substring(i + 1, i + 3), 2);
        int j = ch(paramString.charAt(i + 3), 1) + 5;
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
    AppMethodBeat.o(139724);
    return str1;
  }
  
  private static void a(HashMap<String, String> paramHashMap, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93272);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(93272);
      return;
    }
    String str = paramJSONObject.optString("Key");
    paramJSONObject = paramJSONObject.optString("Val");
    if ((!bo.isNullOrNil(str)) && (!bo.isNullOrNil(paramJSONObject))) {
      paramHashMap.put(str, new String(Base64.decode(paramJSONObject, 0)));
    }
    AppMethodBeat.o(93272);
  }
  
  private static int ch(String paramString, int paramInt)
  {
    AppMethodBeat.i(139725);
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
    AppMethodBeat.o(139725);
    return k;
  }
  
  public final boolean MX(String paramString)
  {
    AppMethodBeat.i(93268);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(93268);
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
      bti();
      if ((this.cache != null) && (this.cache.containsKey("jsoncfg_param_" + this.field_exptId + "_subtype"))) {}
      for (this.field_subType = bo.getInt((String)this.cache.get("jsoncfg_param_" + this.field_exptId + "_subtype"), 0);; this.field_subType = 0)
      {
        ab.v("MicroMsg.ExptItem", "convertFrom new [%s] old[%s] args[%s]", new Object[] { toString(), str, paramString });
        AppMethodBeat.o(93268);
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      e.qrI.idkeyStat(863L, 5L, 1L, false);
      ab.e("MicroMsg.ExptItem", "%d convertFrom [%s] error [%s]", new Object[] { Integer.valueOf(hashCode()), paramString, localException.toString() });
      AppMethodBeat.o(93268);
    }
  }
  
  public final boolean btc()
  {
    return this.field_exptType == 10;
  }
  
  public final boolean btd()
  {
    return this.field_subType == 1;
  }
  
  public final boolean bte()
  {
    return this.field_subType == 2;
  }
  
  public final boolean btf()
  {
    return this.field_exptType == 2;
  }
  
  public final boolean btg()
  {
    AppMethodBeat.i(139722);
    if ((this.cache == null) || (this.cache.size() <= 0))
    {
      AppMethodBeat.o(139722);
      return false;
    }
    if (bo.getInt((String)this.cache.get("jsoncfg_param_" + this.field_exptId + "_report"), 0) > 0)
    {
      AppMethodBeat.o(139722);
      return true;
    }
    AppMethodBeat.o(139722);
    return false;
  }
  
  public final String bth()
  {
    AppMethodBeat.i(139723);
    if ((btd()) || (bte())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(139723);
      return "";
    }
    if ((this.cache == null) || (this.cache.size() <= 0)) {
      bti();
    }
    Object localObject2 = this.cache;
    if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0))
    {
      AppMethodBeat.o(139723);
      return "";
    }
    String str3 = "jsoncfg_param_" + this.field_exptId + "_";
    int j = bo.getInt((String)((HashMap)localObject2).get(str3 + "size"), 0);
    if (j <= 0)
    {
      AppMethodBeat.o(139723);
      return "";
    }
    Object localObject1 = new StringBuilder();
    i = 0;
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
        if (bo.getInt((String)((HashMap)localObject2).get(str3 + "decompress"), 0) <= 0) {
          continue;
        }
        localObject1 = MY(str2);
        String str4 = ag.cE((String)localObject1);
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
        ab.printErrStackTrace("MicroMsg.ExptItem", localException, "tosession config e[%s]", new Object[] { localException.toString() });
        String str1 = "";
        continue;
      }
      AppMethodBeat.o(139723);
      return localObject1;
      e.qrI.idkeyStat(863L, 12L, 1L, false);
      ab.e("MicroMsg.ExptItem", "to session config but md5 not right deJson[%s] json[%s]", new Object[] { localObject1, str2 });
      localObject1 = "";
      continue;
      localObject1 = ((StringBuilder)localObject1).toString();
    }
  }
  
  /* Error */
  public final HashMap<String, String> bti()
  {
    // Byte code:
    //   0: ldc_w 348
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 120	com/tencent/mm/plugin/expt/d/a:cache	Ljava/util/HashMap;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 120	com/tencent/mm/plugin/expt/d/a:cache	Ljava/util/HashMap;
    //   17: astore_2
    //   18: ldc_w 348
    //   21: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_2
    //   25: areturn
    //   26: aload_0
    //   27: getfield 190	com/tencent/mm/plugin/expt/d/a:field_exptContent	Ljava/lang/String;
    //   30: invokestatic 131	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   33: ifne +161 -> 194
    //   36: aload_0
    //   37: getfield 190	com/tencent/mm/plugin/expt/d/a:field_exptContent	Ljava/lang/String;
    //   40: astore_2
    //   41: new 159	org/json/JSONObject
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: ldc_w 350
    //   52: invokevirtual 353	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnonnull +11 -> 68
    //   60: ldc_w 348
    //   63: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: new 175	java/util/HashMap
    //   71: dup
    //   72: invokespecial 354	java/util/HashMap:<init>	()V
    //   75: astore_2
    //   76: aload_3
    //   77: instanceof 356
    //   80: ifeq +56 -> 136
    //   83: aload_3
    //   84: checkcast 356	org/json/JSONArray
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +29 -> 118
    //   92: iconst_0
    //   93: istore_1
    //   94: iload_1
    //   95: aload_3
    //   96: invokevirtual 357	org/json/JSONArray:length	()I
    //   99: if_icmpge +19 -> 118
    //   102: aload_2
    //   103: aload_3
    //   104: iload_1
    //   105: invokevirtual 361	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   108: invokestatic 363	com/tencent/mm/plugin/expt/d/a:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   111: iload_1
    //   112: iconst_1
    //   113: iadd
    //   114: istore_1
    //   115: goto -21 -> 94
    //   118: aload_0
    //   119: aload_2
    //   120: putfield 120	com/tencent/mm/plugin/expt/d/a:cache	Ljava/util/HashMap;
    //   123: aload_0
    //   124: getfield 120	com/tencent/mm/plugin/expt/d/a:cache	Ljava/util/HashMap;
    //   127: astore_2
    //   128: ldc_w 348
    //   131: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_2
    //   135: areturn
    //   136: aload_3
    //   137: instanceof 159
    //   140: ifeq +11 -> 151
    //   143: aload_2
    //   144: aload_3
    //   145: checkcast 159	org/json/JSONObject
    //   148: invokestatic 363	com/tencent/mm/plugin/expt/d/a:a	(Ljava/util/HashMap;Lorg/json/JSONObject;)V
    //   151: goto -33 -> 118
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: ldc_w 263
    //   160: ldc_w 365
    //   163: iconst_2
    //   164: anewarray 267	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_3
    //   170: invokevirtual 299	java/lang/Exception:toString	()Ljava/lang/String;
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: aload_0
    //   177: getfield 200	com/tencent/mm/plugin/expt/d/a:field_exptId	I
    //   180: invokestatic 298	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aastore
    //   184: invokestatic 302	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: goto -69 -> 118
    //   190: astore_3
    //   191: goto -34 -> 157
    //   194: aconst_null
    //   195: astore_2
    //   196: goto -78 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	a
    //   93	22	1	i	int
    //   17	179	2	localObject1	Object
    //   55	90	3	localObject2	Object
    //   154	16	3	localException1	Exception
    //   190	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   41	56	154	java/lang/Exception
    //   68	76	154	java/lang/Exception
    //   76	88	190	java/lang/Exception
    //   94	111	190	java/lang/Exception
    //   136	151	190	java/lang/Exception
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean isReady()
  {
    boolean bool2 = false;
    AppMethodBeat.i(93270);
    boolean bool1;
    if (this.field_exptSeq < 0) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(93270);
      return bool1;
      long l = bo.aox();
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
    AppMethodBeat.i(93269);
    String str = "{ Id: " + this.field_exptId + " group: " + this.field_groupId + " seq: " + this.field_exptSeq + " checksum: " + this.field_exptCheckSum + " startTime: " + this.field_startTime + " endTime: " + this.field_endTime + " content: " + this.field_exptContent + " type: " + this.field_exptType + " subtype: " + this.field_subType + " }";
    AppMethodBeat.o(93269);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.a
 * JD-Core Version:    0.7.0.1
 */