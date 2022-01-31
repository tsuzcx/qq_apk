package com.tencent.mm.plugin.appbrand.v.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class b
  extends a.a
{
  private final Map<String, a.b> hlX = new HashMap();
  
  b()
  {
    this.hlX.put("xiaomi", new b.1(this));
    this.hlX.put("oppo", new b.2(this));
    this.hlX.put("vivo", new a.b()
    {
      protected final Intent aqC()
      {
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
        return localIntent;
      }
    });
  }
  
  private static String getManufacturer()
  {
    return q.bc(ae.getContext()).toLowerCase();
  }
  
  public final boolean aqA()
  {
    String str = getManufacturer();
    y.i("MicroMsg.AppPermissionSettingAdapterFactory", "[canJumpSettingPage] manufacturer = %s", new Object[] { str });
    a.b localb = (a.b)this.hlX.get(str);
    return (this.hlX.containsKey(str)) && (localb.aqB());
  }
  
  /* Error */
  public final int aqz()
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: invokestatic 48	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   11: astore 6
    //   13: invokestatic 63	com/tencent/mm/plugin/appbrand/v/c/b:getManufacturer	()Ljava/lang/String;
    //   16: astore_3
    //   17: ldc 65
    //   19: ldc 94
    //   21: iconst_1
    //   22: anewarray 69	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: aload_3
    //   28: aastore
    //   29: invokestatic 75	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_3
    //   33: invokevirtual 97	java/lang/String:hashCode	()I
    //   36: lookupswitch	default:+52->88, -1206476313:+104->140, -759499589:+118->154, 3418016:+130->166, 3620012:+144->180, 99462250:+90->126
    //   89: istore_1
    //   90: iload_1
    //   91: tableswitch	default:+33 -> 124, 0:+103->194, 1:+103->194, 2:+105->196, 3:+107->198, 4:+205->296
    //   125: ireturn
    //   126: aload_3
    //   127: ldc 99
    //   129: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq -44 -> 88
    //   135: iconst_0
    //   136: istore_1
    //   137: goto -47 -> 90
    //   140: aload_3
    //   141: ldc 104
    //   143: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq -58 -> 88
    //   149: iconst_1
    //   150: istore_1
    //   151: goto -61 -> 90
    //   154: aload_3
    //   155: ldc 20
    //   157: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq -72 -> 88
    //   163: goto -73 -> 90
    //   166: aload_3
    //   167: ldc 33
    //   169: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq -84 -> 88
    //   175: iconst_3
    //   176: istore_1
    //   177: goto -87 -> 90
    //   180: aload_3
    //   181: ldc 38
    //   183: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq -98 -> 88
    //   189: iconst_4
    //   190: istore_1
    //   191: goto -101 -> 90
    //   194: iconst_m1
    //   195: ireturn
    //   196: iconst_m1
    //   197: ireturn
    //   198: aload 6
    //   200: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   203: ldc 112
    //   205: invokestatic 118	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_3
    //   209: aload_3
    //   210: iconst_1
    //   211: aload_3
    //   212: invokevirtual 121	java/lang/String:length	()I
    //   215: iconst_1
    //   216: isub
    //   217: invokevirtual 125	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   220: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: ldc 131
    //   225: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   228: astore 4
    //   230: aload 4
    //   232: arraylength
    //   233: istore_2
    //   234: iconst_0
    //   235: istore_1
    //   236: aload 5
    //   238: astore_3
    //   239: iload_1
    //   240: iload_2
    //   241: if_icmpge +332 -> 573
    //   244: aload 4
    //   246: iload_1
    //   247: aaload
    //   248: astore_3
    //   249: aload_3
    //   250: aload 6
    //   252: invokevirtual 138	android/content/Context:getPackageName	()Ljava/lang/String;
    //   255: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   258: ifeq +321 -> 579
    //   261: aload_3
    //   262: ldc 144
    //   264: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   267: astore_3
    //   268: goto +305 -> 573
    //   271: aload_3
    //   272: iconst_1
    //   273: aaload
    //   274: invokevirtual 147	java/lang/String:trim	()Ljava/lang/String;
    //   277: invokestatic 152	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   280: invokevirtual 155	java/lang/Integer:intValue	()I
    //   283: istore_1
    //   284: iload_1
    //   285: iconst_1
    //   286: if_icmpne +5 -> 291
    //   289: iconst_0
    //   290: ireturn
    //   291: iconst_1
    //   292: ireturn
    //   293: astore_3
    //   294: iconst_m1
    //   295: ireturn
    //   296: ldc 157
    //   298: invokestatic 163	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   301: astore_3
    //   302: aload 6
    //   304: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   307: astore 5
    //   309: new 165	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   316: ldc 168
    //   318: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc 174
    //   323: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: new 176	android/content/ComponentName
    //   329: dup
    //   330: invokestatic 48	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   333: ldc 178
    //   335: invokespecial 181	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   338: invokevirtual 184	android/content/ComponentName:flattenToString	()Ljava/lang/String;
    //   341: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 186
    //   346: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 6
    //   354: aload 5
    //   356: aload_3
    //   357: iconst_2
    //   358: anewarray 56	java/lang/String
    //   361: dup
    //   362: iconst_0
    //   363: ldc 168
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: ldc 191
    //   370: aastore
    //   371: aload 6
    //   373: aconst_null
    //   374: aconst_null
    //   375: invokevirtual 197	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   378: astore_3
    //   379: aload_3
    //   380: astore 4
    //   382: aload 4
    //   384: ifnonnull +17 -> 401
    //   387: aload 4
    //   389: ifnull +10 -> 399
    //   392: aload 4
    //   394: invokeinterface 202 1 0
    //   399: iconst_m1
    //   400: ireturn
    //   401: aload 4
    //   403: astore_3
    //   404: aload 4
    //   406: ldc 191
    //   408: invokeinterface 206 2 0
    //   413: istore_1
    //   414: aload 4
    //   416: astore_3
    //   417: aload 4
    //   419: invokeinterface 209 1 0
    //   424: pop
    //   425: aload 4
    //   427: astore_3
    //   428: aload 4
    //   430: iload_1
    //   431: invokeinterface 213 2 0
    //   436: istore_1
    //   437: aload 4
    //   439: astore_3
    //   440: ldc 65
    //   442: new 165	java/lang/StringBuilder
    //   445: dup
    //   446: ldc 215
    //   448: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   451: iload_1
    //   452: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 224	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: iload_1
    //   462: bipush 16
    //   464: if_icmpne +17 -> 481
    //   467: aload 4
    //   469: ifnull +10 -> 479
    //   472: aload 4
    //   474: invokeinterface 202 1 0
    //   479: iconst_0
    //   480: ireturn
    //   481: aload 4
    //   483: ifnull +10 -> 493
    //   486: aload 4
    //   488: invokeinterface 202 1 0
    //   493: iconst_1
    //   494: ireturn
    //   495: astore 5
    //   497: aconst_null
    //   498: astore 4
    //   500: aload 4
    //   502: astore_3
    //   503: ldc 65
    //   505: new 165	java/lang/StringBuilder
    //   508: dup
    //   509: ldc 226
    //   511: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   514: aload 5
    //   516: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   519: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 232	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload 4
    //   530: ifnull +10 -> 540
    //   533: aload 4
    //   535: invokeinterface 202 1 0
    //   540: iconst_m1
    //   541: ireturn
    //   542: astore_3
    //   543: aload 4
    //   545: ifnull +10 -> 555
    //   548: aload 4
    //   550: invokeinterface 202 1 0
    //   555: aload_3
    //   556: athrow
    //   557: astore 5
    //   559: aload_3
    //   560: astore 4
    //   562: aload 5
    //   564: astore_3
    //   565: goto -22 -> 543
    //   568: astore 5
    //   570: goto -70 -> 500
    //   573: aload_3
    //   574: ifnonnull -303 -> 271
    //   577: iconst_m1
    //   578: ireturn
    //   579: iload_1
    //   580: iconst_1
    //   581: iadd
    //   582: istore_1
    //   583: goto -347 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	b
    //   1	582	1	i	int
    //   233	9	2	j	int
    //   16	256	3	localObject1	Object
    //   293	1	3	localException1	java.lang.Exception
    //   301	202	3	localObject2	Object
    //   542	18	3	localObject3	Object
    //   564	10	3	localObject4	Object
    //   6	555	4	localObject5	Object
    //   3	352	5	localContentResolver	android.content.ContentResolver
    //   495	20	5	localException2	java.lang.Exception
    //   557	6	5	localObject6	Object
    //   568	1	5	localException3	java.lang.Exception
    //   11	361	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   198	234	293	java/lang/Exception
    //   249	268	293	java/lang/Exception
    //   271	284	293	java/lang/Exception
    //   296	379	495	java/lang/Exception
    //   296	379	542	finally
    //   404	414	557	finally
    //   417	425	557	finally
    //   428	437	557	finally
    //   440	461	557	finally
    //   503	528	557	finally
    //   404	414	568	java/lang/Exception
    //   417	425	568	java/lang/Exception
    //   428	437	568	java/lang/Exception
    //   440	461	568	java/lang/Exception
  }
  
  public final void cB(Context paramContext)
  {
    Object localObject = q.bc(paramContext).toLowerCase();
    y.i("MicroMsg.AppPermissionSettingAdapterFactory", "[jumpPermissionSettingPage] manufacturer = %s", new Object[] { localObject });
    localObject = (a.b)this.hlX.get(localObject);
    if (localObject != null) {
      ((a.b)localObject).cC(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.b
 * JD-Core Version:    0.7.0.1
 */