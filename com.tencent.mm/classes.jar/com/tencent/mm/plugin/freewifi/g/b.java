package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "FreeWifiConfig"), "CREATE INDEX IF NOT EXISTS idx_freewificonfig_key  on FreeWifiConfig  (  key )" };
  public static Map<String, String> kqz = new ConcurrentHashMap();
  
  public b(e parame)
  {
    super(parame, a.buS, "FreeWifiConfig", null);
  }
  
  public final String DA(String paramString)
  {
    Object localObject1;
    if (m.isEmpty(paramString)) {
      localObject1 = "";
    }
    for (;;)
    {
      return localObject1;
      try
      {
        if (kqz != null)
        {
          localObject2 = (String)kqz.get(paramString);
          localObject1 = localObject2;
          if (localObject2 != null) {
            continue;
          }
        }
        localObject2 = rawQuery("select * from FreeWifiConfig where key = '" + paramString + "'", new String[0]);
        if (localObject2 == null)
        {
          localObject1 = "";
          if (localObject2 == null) {
            continue;
          }
          ((Cursor)localObject2).close();
          return "";
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        for (;;)
        {
          y.e("MicroMsg.FreeWifi.FreeWifiConfigStorage", "Map get error!");
        }
        try
        {
          if (((Cursor)localObject2).moveToFirst())
          {
            paramString = new a();
            paramString.d((Cursor)localObject2);
            paramString = paramString.field_value;
            str = paramString;
            return paramString;
          }
          String str = "";
          return "";
        }
        finally
        {
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
        }
      }
    }
  }
  
  /* Error */
  public final String aUJ()
  {
    // Byte code:
    //   0: new 62	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 113
    //   11: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_0
    //   16: ldc 115
    //   18: iconst_0
    //   19: anewarray 14	java/lang/String
    //   22: invokevirtual 81	com/tencent/mm/plugin/freewifi/g/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_1
    //   26: aload_1
    //   27: invokeinterface 118 1 0
    //   32: ifeq +91 -> 123
    //   35: aload_2
    //   36: aload_1
    //   37: iconst_0
    //   38: invokeinterface 122 2 0
    //   43: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 124
    //   48: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: iconst_1
    //   53: invokeinterface 122 2 0
    //   58: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 124
    //   63: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: iconst_2
    //   68: invokeinterface 128 2 0
    //   73: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: ldc 133
    //   78: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto -56 -> 26
    //   85: astore_2
    //   86: ldc 88
    //   88: new 62	java/lang/StringBuilder
    //   91: dup
    //   92: ldc 135
    //   94: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 141	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_2
    //   111: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: astore_2
    //   115: aload_1
    //   116: invokeinterface 86 1 0
    //   121: aload_2
    //   122: areturn
    //   123: ldc 88
    //   125: new 62	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 135
    //   131: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: aload_2
    //   135: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 141	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_2
    //   148: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_2
    //   152: aload_1
    //   153: invokeinterface 86 1 0
    //   158: aload_2
    //   159: areturn
    //   160: astore_2
    //   161: aload_1
    //   162: invokeinterface 86 1 0
    //   167: aload_2
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	b
    //   25	137	1	localCursor	Cursor
    //   7	29	2	localStringBuilder	java.lang.StringBuilder
    //   85	26	2	localException	Exception
    //   114	45	2	str	String
    //   160	8	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	82	85	java/lang/Exception
    //   123	152	85	java/lang/Exception
    //   26	82	160	finally
    //   86	115	160	finally
    //   123	152	160	finally
  }
  
  public final void aUK()
  {
    if (kqz != null) {
      kqz.clear();
    }
    super.gk("FreeWifiConfig", "delete from FreeWifiConfig");
  }
  
  /* Error */
  public final void dj(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 52	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: getstatic 37	com/tencent/mm/plugin/freewifi/g/b:kqz	Ljava/util/Map;
    //   18: ifnull +28 -> 46
    //   21: getstatic 37	com/tencent/mm/plugin/freewifi/g/b:kqz	Ljava/util/Map;
    //   24: invokeinterface 156 1 0
    //   29: sipush 1000
    //   32: if_icmpge +96 -> 128
    //   35: getstatic 37	com/tencent/mm/plugin/freewifi/g/b:kqz	Ljava/util/Map;
    //   38: aload_1
    //   39: aload_2
    //   40: invokeinterface 160 3 0
    //   45: pop
    //   46: aload_0
    //   47: new 62	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 64
    //   53: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 73
    //   62: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: iconst_0
    //   69: anewarray 14	java/lang/String
    //   72: invokevirtual 81	com/tencent/mm/plugin/freewifi/g/b:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_3
    //   76: new 16	com/tencent/mm/plugin/freewifi/g/a
    //   79: dup
    //   80: invokespecial 101	com/tencent/mm/plugin/freewifi/g/a:<init>	()V
    //   83: astore 4
    //   85: aload 4
    //   87: aload_1
    //   88: putfield 163	com/tencent/mm/plugin/freewifi/g/a:field_key	Ljava/lang/String;
    //   91: aload 4
    //   93: aload_2
    //   94: putfield 109	com/tencent/mm/plugin/freewifi/g/a:field_value	Ljava/lang/String;
    //   97: aload 4
    //   99: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   102: putfield 173	com/tencent/mm/plugin/freewifi/g/a:field_modifyTime	J
    //   105: aload_3
    //   106: invokeinterface 176 1 0
    //   111: ifne +50 -> 161
    //   114: aload_0
    //   115: aload 4
    //   117: invokevirtual 180	com/tencent/mm/plugin/freewifi/g/b:b	(Lcom/tencent/mm/sdk/e/c;)Z
    //   120: pop
    //   121: aload_3
    //   122: invokeinterface 86 1 0
    //   127: return
    //   128: getstatic 37	com/tencent/mm/plugin/freewifi/g/b:kqz	Ljava/util/Map;
    //   131: invokeinterface 145 1 0
    //   136: getstatic 37	com/tencent/mm/plugin/freewifi/g/b:kqz	Ljava/util/Map;
    //   139: aload_1
    //   140: aload_2
    //   141: invokeinterface 160 3 0
    //   146: pop
    //   147: goto -101 -> 46
    //   150: astore_3
    //   151: ldc 88
    //   153: ldc 182
    //   155: invokestatic 96	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -112 -> 46
    //   161: aload_0
    //   162: aload 4
    //   164: iconst_0
    //   165: anewarray 14	java/lang/String
    //   168: invokevirtual 186	com/tencent/mm/plugin/freewifi/g/b:c	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   171: pop
    //   172: goto -51 -> 121
    //   175: astore_1
    //   176: aload_3
    //   177: invokeinterface 86 1 0
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	b
    //   0	184	1	paramString1	String
    //   0	184	2	paramString2	String
    //   75	47	3	localCursor	Cursor
    //   150	27	3	localException	Exception
    //   83	80	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   15	46	150	java/lang/Exception
    //   128	147	150	java/lang/Exception
    //   76	121	175	finally
    //   161	172	175	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.g.b
 * JD-Core Version:    0.7.0.1
 */