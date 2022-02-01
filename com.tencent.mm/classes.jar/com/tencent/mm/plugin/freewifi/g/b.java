package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  public static Map<String, String> ssi;
  
  static
  {
    AppMethodBeat.i(24948);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "FreeWifiConfig"), "CREATE INDEX IF NOT EXISTS idx_freewificonfig_key  on FreeWifiConfig  (  key )" };
    ssi = new ConcurrentHashMap();
    AppMethodBeat.o(24948);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "FreeWifiConfig", null);
  }
  
  public final void aZf()
  {
    AppMethodBeat.i(24947);
    if (ssi != null) {
      ssi.clear();
    }
    super.execSQL("FreeWifiConfig", "delete from FreeWifiConfig");
    AppMethodBeat.o(24947);
  }
  
  public final String afy(String paramString)
  {
    AppMethodBeat.i(24945);
    if (m.cX(paramString))
    {
      AppMethodBeat.o(24945);
      return "";
    }
    try
    {
      if (ssi != null)
      {
        String str = (String)ssi.get(paramString);
        if (str != null)
        {
          AppMethodBeat.o(24945);
          return str;
        }
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map get error!");
      paramString = rawQuery("select * from FreeWifiConfig where key = '" + paramString + "'", new String[0]);
      if (paramString == null)
      {
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(24945);
        return "";
      }
      try
      {
        if (paramString.moveToFirst())
        {
          Object localObject1 = new a();
          ((a)localObject1).convertFrom(paramString);
          localObject1 = ((a)localObject1).field_value;
          return localObject1;
        }
        return "";
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(24945);
      }
    }
  }
  
  /* Error */
  public final String cJJ()
  {
    // Byte code:
    //   0: sipush 24944
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 91	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 132
    //   17: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_0
    //   22: ldc 134
    //   24: iconst_0
    //   25: anewarray 20	java/lang/String
    //   28: invokevirtual 110	com/tencent/mm/plugin/freewifi/g/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface 137 1 0
    //   38: ifeq +97 -> 135
    //   41: aload_2
    //   42: aload_1
    //   43: iconst_0
    //   44: invokeinterface 141 2 0
    //   49: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 143
    //   54: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: iconst_1
    //   59: invokeinterface 141 2 0
    //   64: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 143
    //   69: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: iconst_2
    //   74: invokeinterface 147 2 0
    //   79: invokevirtual 150	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc 152
    //   84: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: goto -56 -> 32
    //   91: astore_2
    //   92: ldc 81
    //   94: new 91	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 154
    //   100: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_2
    //   104: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 159	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokevirtual 157	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: astore_2
    //   121: aload_1
    //   122: invokeinterface 115 1 0
    //   127: sipush 24944
    //   130: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_2
    //   134: areturn
    //   135: ldc 81
    //   137: new 91	java/lang/StringBuilder
    //   140: dup
    //   141: ldc 154
    //   143: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_2
    //   147: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 159	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_2
    //   160: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore_2
    //   164: aload_1
    //   165: invokeinterface 115 1 0
    //   170: sipush 24944
    //   173: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_2
    //   177: areturn
    //   178: astore_2
    //   179: aload_1
    //   180: invokeinterface 115 1 0
    //   185: sipush 24944
    //   188: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_2
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	b
    //   31	149	1	localCursor	Cursor
    //   13	29	2	localStringBuilder	java.lang.StringBuilder
    //   91	26	2	localException	Exception
    //   120	57	2	str	String
    //   178	14	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	88	91	java/lang/Exception
    //   135	164	91	java/lang/Exception
    //   32	88	178	finally
    //   92	121	178	finally
    //   135	164	178	finally
  }
  
  /* Error */
  public final void gz(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 24946
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 73	com/tencent/mm/plugin/freewifi/m:cX	(Ljava/lang/String;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 73	com/tencent/mm/plugin/freewifi/m:cX	(Ljava/lang/String;)Z
    //   17: ifeq +10 -> 27
    //   20: sipush 24946
    //   23: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: getstatic 43	com/tencent/mm/plugin/freewifi/g/b:ssi	Ljava/util/Map;
    //   30: ifnull +28 -> 58
    //   33: getstatic 43	com/tencent/mm/plugin/freewifi/g/b:ssi	Ljava/util/Map;
    //   36: invokeinterface 164 1 0
    //   41: sipush 1000
    //   44: if_icmpge +102 -> 146
    //   47: getstatic 43	com/tencent/mm/plugin/freewifi/g/b:ssi	Ljava/util/Map;
    //   50: aload_1
    //   51: aload_2
    //   52: invokeinterface 168 3 0
    //   57: pop
    //   58: aload_0
    //   59: new 91	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 93
    //   65: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 102
    //   74: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: iconst_0
    //   81: anewarray 20	java/lang/String
    //   84: invokevirtual 110	com/tencent/mm/plugin/freewifi/g/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_3
    //   88: new 22	com/tencent/mm/plugin/freewifi/g/a
    //   91: dup
    //   92: invokespecial 120	com/tencent/mm/plugin/freewifi/g/a:<init>	()V
    //   95: astore 4
    //   97: aload 4
    //   99: aload_1
    //   100: putfield 171	com/tencent/mm/plugin/freewifi/g/a:field_key	Ljava/lang/String;
    //   103: aload 4
    //   105: aload_2
    //   106: putfield 128	com/tencent/mm/plugin/freewifi/g/a:field_value	Ljava/lang/String;
    //   109: aload 4
    //   111: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   114: putfield 181	com/tencent/mm/plugin/freewifi/g/a:field_modifyTime	J
    //   117: aload_3
    //   118: invokeinterface 184 1 0
    //   123: ifne +56 -> 179
    //   126: aload_0
    //   127: aload 4
    //   129: invokevirtual 188	com/tencent/mm/plugin/freewifi/g/b:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   132: pop
    //   133: aload_3
    //   134: invokeinterface 115 1 0
    //   139: sipush 24946
    //   142: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: return
    //   146: getstatic 43	com/tencent/mm/plugin/freewifi/g/b:ssi	Ljava/util/Map;
    //   149: invokeinterface 57 1 0
    //   154: getstatic 43	com/tencent/mm/plugin/freewifi/g/b:ssi	Ljava/util/Map;
    //   157: aload_1
    //   158: aload_2
    //   159: invokeinterface 168 3 0
    //   164: pop
    //   165: goto -107 -> 58
    //   168: astore_3
    //   169: ldc 81
    //   171: ldc 190
    //   173: invokestatic 89	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: goto -118 -> 58
    //   179: aload_0
    //   180: aload 4
    //   182: iconst_0
    //   183: anewarray 20	java/lang/String
    //   186: invokevirtual 194	com/tencent/mm/plugin/freewifi/g/b:update	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   189: pop
    //   190: goto -57 -> 133
    //   193: astore_1
    //   194: aload_3
    //   195: invokeinterface 115 1 0
    //   200: sipush 24946
    //   203: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	b
    //   0	208	1	paramString1	String
    //   0	208	2	paramString2	String
    //   87	47	3	localCursor	Cursor
    //   168	27	3	localException	Exception
    //   95	86	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   27	58	168	java/lang/Exception
    //   146	165	168	java/lang/Exception
    //   88	133	193	finally
    //   179	190	193	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.b
 * JD-Core Version:    0.7.0.1
 */