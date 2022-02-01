package com.tencent.mm.plugin.an.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

final class b
  extends a.a
{
  private final Map<String, a.b> PEX;
  
  b()
  {
    AppMethodBeat.i(151590);
    this.PEX = new HashMap();
    this.PEX.put("xiaomi", new a.b()
    {
      protected final Intent gYk()
      {
        AppMethodBeat.i(151587);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        localIntent.putExtra("extra_pkgname", MMApplicationContext.getPackageName());
        AppMethodBeat.o(151587);
        return localIntent;
      }
    });
    this.PEX.put("oppo", new a.b()
    {
      protected final Intent gYk()
      {
        AppMethodBeat.i(151588);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
        localIntent.setAction("coloros.intent.action.launcher.SHORTCUT_SETTINGS");
        AppMethodBeat.o(151588);
        return localIntent;
      }
    });
    this.PEX.put("vivo", new a.b()
    {
      protected final Intent gYk()
      {
        AppMethodBeat.i(151589);
        Intent localIntent = new Intent();
        localIntent.setComponent(new ComponentName("com.bbk.launcher2", "com.bbk.launcher2.installshortcut.PurviewActivity"));
        AppMethodBeat.o(151589);
        return localIntent;
      }
    });
    AppMethodBeat.o(151590);
  }
  
  private static String gYl()
  {
    AppMethodBeat.i(151594);
    String str = af.de(MMApplicationContext.getContext()).toLowerCase();
    AppMethodBeat.o(151594);
    return str;
  }
  
  /* Error */
  public final int gYh()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc 75
    //   7: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 59	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   13: astore 5
    //   15: invokestatic 77	com/tencent/mm/plugin/an/a/b:gYl	()Ljava/lang/String;
    //   18: astore 6
    //   20: ldc 79
    //   22: ldc 81
    //   24: iconst_1
    //   25: anewarray 83	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload 6
    //   32: aastore
    //   33: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aload 6
    //   38: invokevirtual 91	java/lang/String:hashCode	()I
    //   41: lookupswitch	default:+51->92, -1206476313:+109->150, -759499589:+124->165, 3418016:+139->180, 3620012:+154->195, 99462250:+94->135
    //   93: istore_1
    //   94: iload_1
    //   95: tableswitch	default:+33 -> 128, 0:+115->210, 1:+115->210, 2:+122->217, 3:+129->224, 4:+299->394
    //   129: astore_0
    //   130: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_m1
    //   134: ireturn
    //   135: aload 6
    //   137: ldc 93
    //   139: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq -50 -> 92
    //   145: iconst_0
    //   146: istore_1
    //   147: goto -53 -> 94
    //   150: aload 6
    //   152: ldc 99
    //   154: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifeq -65 -> 92
    //   160: iconst_1
    //   161: istore_1
    //   162: goto -68 -> 94
    //   165: aload 6
    //   167: ldc 31
    //   169: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq -80 -> 92
    //   175: iconst_2
    //   176: istore_1
    //   177: goto -83 -> 94
    //   180: aload 6
    //   182: ldc 42
    //   184: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq -95 -> 92
    //   190: iconst_3
    //   191: istore_1
    //   192: goto -98 -> 94
    //   195: aload 6
    //   197: ldc 45
    //   199: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq -110 -> 92
    //   205: iconst_4
    //   206: istore_1
    //   207: goto -113 -> 94
    //   210: ldc 75
    //   212: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: iconst_m1
    //   216: ireturn
    //   217: ldc 75
    //   219: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iconst_m1
    //   223: ireturn
    //   224: aload 5
    //   226: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   229: astore_3
    //   230: new 107	com/tencent/mm/hellhoundlib/b/a
    //   233: dup
    //   234: invokespecial 108	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   237: ldc 110
    //   239: invokevirtual 114	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   242: aload_3
    //   243: invokevirtual 114	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   246: astore_3
    //   247: new 83	java/lang/Object
    //   250: dup
    //   251: invokespecial 115	java/lang/Object:<init>	()V
    //   254: aload_3
    //   255: invokevirtual 119	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   258: ldc 121
    //   260: ldc 123
    //   262: ldc 124
    //   264: ldc 126
    //   266: ldc 128
    //   268: ldc 130
    //   270: invokestatic 136	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   273: checkcast 67	java/lang/String
    //   276: astore_3
    //   277: aload_3
    //   278: iconst_1
    //   279: aload_3
    //   280: invokevirtual 139	java/lang/String:length	()I
    //   283: iconst_1
    //   284: isub
    //   285: invokevirtual 143	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   288: invokestatic 147	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   291: ldc 149
    //   293: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   296: astore 6
    //   298: aload 6
    //   300: arraylength
    //   301: istore_2
    //   302: iconst_0
    //   303: istore_1
    //   304: aload 4
    //   306: astore_3
    //   307: iload_1
    //   308: iload_2
    //   309: if_icmpge +27 -> 336
    //   312: aload 6
    //   314: iload_1
    //   315: aaload
    //   316: astore_3
    //   317: aload_3
    //   318: aload 5
    //   320: invokevirtual 156	android/content/Context:getPackageName	()Ljava/lang/String;
    //   323: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   326: ifeq +21 -> 347
    //   329: aload_3
    //   330: ldc 162
    //   332: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   335: astore_3
    //   336: aload_3
    //   337: ifnonnull +17 -> 354
    //   340: ldc 75
    //   342: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: iconst_m1
    //   346: ireturn
    //   347: iload_1
    //   348: iconst_1
    //   349: iadd
    //   350: istore_1
    //   351: goto -47 -> 304
    //   354: aload_3
    //   355: iconst_1
    //   356: aaload
    //   357: invokevirtual 165	java/lang/String:trim	()Ljava/lang/String;
    //   360: invokestatic 170	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   363: invokevirtual 173	java/lang/Integer:intValue	()I
    //   366: istore_1
    //   367: iload_1
    //   368: iconst_1
    //   369: if_icmpne +10 -> 379
    //   372: ldc 75
    //   374: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: iconst_0
    //   378: ireturn
    //   379: ldc 75
    //   381: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: iconst_1
    //   385: ireturn
    //   386: astore_3
    //   387: ldc 75
    //   389: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iconst_m1
    //   393: ireturn
    //   394: ldc 175
    //   396: invokestatic 181	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   399: astore 4
    //   401: aload 5
    //   403: invokevirtual 105	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   406: astore 5
    //   408: new 183	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   415: ldc 186
    //   417: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 192
    //   422: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: new 194	android/content/ComponentName
    //   428: dup
    //   429: invokestatic 59	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   432: ldc 196
    //   434: invokespecial 199	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   437: invokevirtual 202	android/content/ComponentName:flattenToString	()Ljava/lang/String;
    //   440: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc 204
    //   445: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 6
    //   453: aload 5
    //   455: aload 4
    //   457: iconst_2
    //   458: anewarray 67	java/lang/String
    //   461: dup
    //   462: iconst_0
    //   463: ldc 186
    //   465: aastore
    //   466: dup
    //   467: iconst_1
    //   468: ldc 209
    //   470: aastore
    //   471: aload 6
    //   473: aconst_null
    //   474: aconst_null
    //   475: invokevirtual 215	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   478: astore 4
    //   480: aload 4
    //   482: ifnonnull +22 -> 504
    //   485: aload 4
    //   487: ifnull +10 -> 497
    //   490: aload 4
    //   492: invokeinterface 220 1 0
    //   497: ldc 75
    //   499: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   502: iconst_m1
    //   503: ireturn
    //   504: aload 4
    //   506: astore_3
    //   507: aload 4
    //   509: ldc 209
    //   511: invokeinterface 224 2 0
    //   516: istore_1
    //   517: aload 4
    //   519: astore_3
    //   520: aload 4
    //   522: invokeinterface 228 1 0
    //   527: pop
    //   528: aload 4
    //   530: astore_3
    //   531: aload 4
    //   533: iload_1
    //   534: invokeinterface 232 2 0
    //   539: istore_1
    //   540: aload 4
    //   542: astore_3
    //   543: ldc 79
    //   545: ldc 234
    //   547: iload_1
    //   548: invokestatic 237	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   551: invokevirtual 241	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   554: invokestatic 244	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: iload_1
    //   558: bipush 16
    //   560: if_icmpne +22 -> 582
    //   563: aload 4
    //   565: ifnull +10 -> 575
    //   568: aload 4
    //   570: invokeinterface 220 1 0
    //   575: ldc 75
    //   577: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   580: iconst_0
    //   581: ireturn
    //   582: aload 4
    //   584: ifnull +10 -> 594
    //   587: aload 4
    //   589: invokeinterface 220 1 0
    //   594: ldc 75
    //   596: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: iconst_1
    //   600: ireturn
    //   601: astore 5
    //   603: aconst_null
    //   604: astore 4
    //   606: aload 4
    //   608: astore_3
    //   609: ldc 79
    //   611: new 183	java/lang/StringBuilder
    //   614: dup
    //   615: ldc 246
    //   617: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   620: aload 5
    //   622: invokevirtual 252	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   625: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload 4
    //   636: ifnull +10 -> 646
    //   639: aload 4
    //   641: invokeinterface 220 1 0
    //   646: ldc 75
    //   648: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   651: iconst_m1
    //   652: ireturn
    //   653: astore 5
    //   655: aload_3
    //   656: astore 4
    //   658: aload 5
    //   660: astore_3
    //   661: aload 4
    //   663: ifnull +10 -> 673
    //   666: aload 4
    //   668: invokeinterface 220 1 0
    //   673: ldc 75
    //   675: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   678: aload_3
    //   679: athrow
    //   680: astore 5
    //   682: aload_3
    //   683: astore 4
    //   685: aload 5
    //   687: astore_3
    //   688: goto -27 -> 661
    //   691: astore 5
    //   693: goto -87 -> 606
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	b
    //   93	468	1	i	int
    //   301	9	2	j	int
    //   1	354	3	localObject1	Object
    //   386	1	3	localException1	java.lang.Exception
    //   506	182	3	localObject2	Object
    //   3	681	4	localObject3	Object
    //   13	441	5	localObject4	Object
    //   601	20	5	localException2	java.lang.Exception
    //   653	6	5	localObject5	Object
    //   680	6	5	localObject6	Object
    //   691	1	5	localException3	java.lang.Exception
    //   18	454	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   224	302	386	java/lang/Exception
    //   317	336	386	java/lang/Exception
    //   354	367	386	java/lang/Exception
    //   394	480	601	java/lang/Exception
    //   394	480	653	finally
    //   507	517	680	finally
    //   520	528	680	finally
    //   531	540	680	finally
    //   543	557	680	finally
    //   609	634	680	finally
    //   507	517	691	java/lang/Exception
    //   520	528	691	java/lang/Exception
    //   531	540	691	java/lang/Exception
    //   543	557	691	java/lang/Exception
  }
  
  public final boolean gYi()
  {
    AppMethodBeat.i(151593);
    String str = gYl();
    Log.i("MicroMsg.AppPermissionSettingAdapterFactory", "[canJumpSettingPage] manufacturer = %s", new Object[] { str });
    a.b localb = (a.b)this.PEX.get(str);
    if ((this.PEX.containsKey(str)) && (localb.gYj()))
    {
      AppMethodBeat.o(151593);
      return true;
    }
    AppMethodBeat.o(151593);
    return false;
  }
  
  public final void jJ(Context paramContext)
  {
    AppMethodBeat.i(151592);
    Object localObject = af.de(paramContext).toLowerCase();
    Log.i("MicroMsg.AppPermissionSettingAdapterFactory", "[jumpPermissionSettingPage] manufacturer = %s", new Object[] { localObject });
    localObject = (a.b)this.PEX.get(localObject);
    if (localObject != null) {
      ((a.b)localObject).jK(paramContext);
    }
    AppMethodBeat.o(151592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.an.a.b
 * JD-Core Version:    0.7.0.1
 */