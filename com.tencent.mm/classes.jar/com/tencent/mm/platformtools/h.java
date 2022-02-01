package com.tencent.mm.platformtools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  private static String I(Context paramContext, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(127687);
    Log.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", new Object[] { paramString });
    if (paramContext == null)
    {
      Log.e("MicroMsg.ContactsUtil", "context is null.");
      AppMethodBeat.o(127687);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.ContactsUtil", "email is null.");
      AppMethodBeat.o(127687);
      return null;
    }
    for (;;)
    {
      try
      {
        localCursor = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] { "contact_id", "data1" }, "data1=?", new String[] { paramString }, null);
        if (localCursor == null) {
          continue;
        }
        bool = localCursor.moveToFirst();
        if (!bool) {
          continue;
        }
        paramString = localObject;
      }
      catch (Exception paramString)
      {
        Cursor localCursor;
        boolean bool;
        paramContext = null;
        Log.printErrStackTrace("MicroMsg.ContactsUtil", paramString, "getContactIdByEmail error", new Object[0]);
        continue;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
      }
      try
      {
        paramContext = localCursor.getString(localCursor.getColumnIndex("contact_id"));
        paramString = paramContext;
        if (!Util.isNullOrNil(paramContext))
        {
          paramString = paramContext;
          Log.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", new Object[] { paramContext });
        }
      }
      catch (Exception localException)
      {
        paramContext = paramString;
        paramString = localException;
        continue;
      }
      try
      {
        localCursor.close();
        AppMethodBeat.o(127687);
        return paramContext;
      }
      catch (Exception paramString)
      {
        continue;
      }
      paramString = paramContext;
      bool = localCursor.moveToNext();
      paramString = paramContext;
      if (bool) {}
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(14)
  public static String getPhoneNum(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 17
    //   7: ldc 106
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: ifnonnull +17 -> 38
    //   24: ldc 17
    //   26: ldc 108
    //   28: invokestatic 30	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 104
    //   33: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aconst_null
    //   37: areturn
    //   38: aload_0
    //   39: ldc 110
    //   41: invokevirtual 114	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   44: checkcast 116	android/telephony/TelephonyManager
    //   47: astore 7
    //   49: aconst_null
    //   50: astore 5
    //   52: aload 5
    //   54: astore_1
    //   55: ldc 17
    //   57: ldc 118
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: invokestatic 122	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   68: aastore
    //   69: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload 5
    //   74: astore_1
    //   75: aload 7
    //   77: invokevirtual 129	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: astore_1
    //   85: aload 7
    //   87: invokevirtual 132	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   90: astore 6
    //   92: aload 6
    //   94: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   97: ifeq +1429 -> 1526
    //   100: aload 7
    //   102: invokevirtual 135	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   105: astore_1
    //   106: aload_1
    //   107: astore 6
    //   109: aload_1
    //   110: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   113: ifeq +11 -> 124
    //   116: invokestatic 141	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   119: invokevirtual 144	java/util/Locale:getCountry	()Ljava/lang/String;
    //   122: astore 6
    //   124: aload 6
    //   126: astore 9
    //   128: aload 5
    //   130: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   133: ifne +142 -> 275
    //   136: aload 5
    //   138: invokevirtual 147	java/lang/String:trim	()Ljava/lang/String;
    //   141: astore_0
    //   142: aload_0
    //   143: aload 9
    //   145: invokestatic 153	com/tencent/mm/sdk/platformtools/PhoneFormater:extractCountryCode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_1
    //   149: ldc 17
    //   151: ldc 155
    //   153: iconst_3
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_0
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload_1
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: aload 9
    //   169: aastore
    //   170: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_1
    //   174: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   177: ifne +1346 -> 1523
    //   180: aload_1
    //   181: invokevirtual 159	java/lang/String:length	()I
    //   184: istore_3
    //   185: aload_0
    //   186: ldc 161
    //   188: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   191: ifeq +79 -> 270
    //   194: iconst_1
    //   195: istore_2
    //   196: aload_0
    //   197: iload_2
    //   198: iload_3
    //   199: iadd
    //   200: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   203: astore_0
    //   204: ldc 17
    //   206: ldc 169
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_0
    //   215: aastore
    //   216: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: ldc 17
    //   221: ldc 171
    //   223: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: ldc 104
    //   228: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_0
    //   232: areturn
    //   233: astore 6
    //   235: aconst_null
    //   236: astore 7
    //   238: aload_1
    //   239: astore 5
    //   241: aload 7
    //   243: astore_1
    //   244: ldc 17
    //   246: aload 6
    //   248: ldc 173
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: ldc 17
    //   259: ldc 175
    //   261: invokestatic 30	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: astore 9
    //   267: goto -139 -> 128
    //   270: iconst_0
    //   271: istore_2
    //   272: goto -76 -> 196
    //   275: aload_0
    //   276: ldc 177
    //   278: invokestatic 182	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   281: ifne +17 -> 298
    //   284: ldc 17
    //   286: ldc 184
    //   288: invokestatic 30	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: ldc 104
    //   293: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aconst_null
    //   297: areturn
    //   298: aload_0
    //   299: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   302: astore 11
    //   304: aconst_null
    //   305: astore 6
    //   307: aconst_null
    //   308: astore 10
    //   310: aconst_null
    //   311: astore 5
    //   313: aconst_null
    //   314: astore 8
    //   316: aconst_null
    //   317: astore 7
    //   319: aload 8
    //   321: astore_1
    //   322: bipush 14
    //   324: invokestatic 190	com/tencent/mm/compatible/util/d:qW	(I)Z
    //   327: ifne +317 -> 644
    //   330: ldc 17
    //   332: ldc 192
    //   334: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload 10
    //   339: astore 5
    //   341: aload 11
    //   343: getstatic 195	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   346: iconst_1
    //   347: anewarray 57	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: ldc 197
    //   354: aastore
    //   355: aconst_null
    //   356: aconst_null
    //   357: aconst_null
    //   358: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   361: astore_1
    //   362: aload_1
    //   363: ifnull +1155 -> 1518
    //   366: aload_1
    //   367: astore 6
    //   369: aload_1
    //   370: astore 5
    //   372: aload_1
    //   373: invokeinterface 75 1 0
    //   378: ifeq +1140 -> 1518
    //   381: aload_1
    //   382: astore 6
    //   384: aload_1
    //   385: astore 5
    //   387: aload_1
    //   388: ldc 197
    //   390: invokeinterface 79 2 0
    //   395: istore_2
    //   396: iload_2
    //   397: iconst_m1
    //   398: if_icmpeq +1120 -> 1518
    //   401: aload_1
    //   402: astore 6
    //   404: aload_1
    //   405: astore 5
    //   407: aload_1
    //   408: iload_2
    //   409: invokeinterface 201 2 0
    //   414: istore_2
    //   415: aload_1
    //   416: astore 5
    //   418: ldc 17
    //   420: ldc 203
    //   422: iload_2
    //   423: invokestatic 206	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   426: invokevirtual 210	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   429: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: iload_2
    //   433: istore_3
    //   434: aload_1
    //   435: astore 6
    //   437: aload_1
    //   438: ifnull +28 -> 466
    //   441: iload_2
    //   442: istore_3
    //   443: aload_1
    //   444: astore 6
    //   446: aload_1
    //   447: invokeinterface 213 1 0
    //   452: ifne +14 -> 466
    //   455: aload_1
    //   456: invokeinterface 89 1 0
    //   461: aload_1
    //   462: astore 6
    //   464: iload_2
    //   465: istore_3
    //   466: aload 8
    //   468: astore_1
    //   469: aload 6
    //   471: astore 5
    //   473: iload_3
    //   474: ifle +170 -> 644
    //   477: aload 11
    //   479: getstatic 195	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   482: ldc 215
    //   484: invokestatic 221	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   487: iconst_1
    //   488: anewarray 57	java/lang/String
    //   491: dup
    //   492: iconst_0
    //   493: ldc 61
    //   495: aastore
    //   496: ldc 223
    //   498: iconst_1
    //   499: anewarray 57	java/lang/String
    //   502: dup
    //   503: iconst_0
    //   504: ldc 225
    //   506: aastore
    //   507: aconst_null
    //   508: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   511: astore_1
    //   512: aload_1
    //   513: ifnull +999 -> 1512
    //   516: aload 7
    //   518: astore 5
    //   520: aload_1
    //   521: astore 6
    //   523: aload_1
    //   524: invokeinterface 75 1 0
    //   529: ifeq +59 -> 588
    //   532: aload_1
    //   533: astore 6
    //   535: aload_1
    //   536: ldc 61
    //   538: invokeinterface 79 2 0
    //   543: istore_2
    //   544: aload 7
    //   546: astore 5
    //   548: iload_2
    //   549: iconst_m1
    //   550: if_icmpeq +38 -> 588
    //   553: aload_1
    //   554: astore 6
    //   556: aload_1
    //   557: iload_2
    //   558: invokeinterface 83 2 0
    //   563: astore 5
    //   565: aload_1
    //   566: astore 6
    //   568: aload 5
    //   570: astore 7
    //   572: ldc 17
    //   574: ldc 227
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload 5
    //   584: aastore
    //   585: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   588: aload_1
    //   589: astore 6
    //   591: aload 5
    //   593: astore 7
    //   595: aload_1
    //   596: invokeinterface 89 1 0
    //   601: aload 5
    //   603: astore 7
    //   605: aload_1
    //   606: astore 6
    //   608: aload_1
    //   609: ifnull +893 -> 1502
    //   612: aload 5
    //   614: astore 7
    //   616: aload_1
    //   617: astore 6
    //   619: aload_1
    //   620: invokeinterface 213 1 0
    //   625: ifne +877 -> 1502
    //   628: aload_1
    //   629: invokeinterface 89 1 0
    //   634: aload 5
    //   636: astore 6
    //   638: aload_1
    //   639: astore 5
    //   641: aload 6
    //   643: astore_1
    //   644: aload_1
    //   645: astore 6
    //   647: aload_1
    //   648: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   651: ifeq +286 -> 937
    //   654: aload_0
    //   655: aload_0
    //   656: invokestatic 233	com/tencent/mm/platformtools/t:dv	(Landroid/content/Context;)Ljava/lang/String;
    //   659: invokestatic 235	com/tencent/mm/platformtools/h:I	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   662: astore 8
    //   664: aload_1
    //   665: astore 6
    //   667: aload 8
    //   669: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   672: ifne +265 -> 937
    //   675: aload 11
    //   677: getstatic 238	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   680: iconst_1
    //   681: anewarray 57	java/lang/String
    //   684: dup
    //   685: iconst_0
    //   686: ldc 197
    //   688: aastore
    //   689: ldc 240
    //   691: iconst_1
    //   692: anewarray 57	java/lang/String
    //   695: dup
    //   696: iconst_0
    //   697: aload 8
    //   699: aastore
    //   700: aconst_null
    //   701: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   704: astore_0
    //   705: aload_0
    //   706: ifnull +791 -> 1497
    //   709: aload_0
    //   710: astore 5
    //   712: aload_0
    //   713: invokeinterface 75 1 0
    //   718: ifeq +779 -> 1497
    //   721: aload_0
    //   722: astore 5
    //   724: aload_0
    //   725: aload_0
    //   726: ldc 197
    //   728: invokeinterface 79 2 0
    //   733: invokeinterface 201 2 0
    //   738: istore_2
    //   739: aload_0
    //   740: ifnull +754 -> 1494
    //   743: aload_0
    //   744: invokeinterface 89 1 0
    //   749: ldc 17
    //   751: ldc 203
    //   753: iload_2
    //   754: invokestatic 206	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   757: invokevirtual 210	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   760: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: aload_1
    //   764: astore 6
    //   766: iload_2
    //   767: ifle +170 -> 937
    //   770: aload_1
    //   771: astore 5
    //   773: aload_0
    //   774: astore 7
    //   776: aload 11
    //   778: getstatic 243	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   781: iconst_2
    //   782: anewarray 57	java/lang/String
    //   785: dup
    //   786: iconst_0
    //   787: ldc 61
    //   789: aastore
    //   790: dup
    //   791: iconst_1
    //   792: ldc 245
    //   794: aastore
    //   795: ldc 247
    //   797: iconst_1
    //   798: anewarray 57	java/lang/String
    //   801: dup
    //   802: iconst_0
    //   803: aload 8
    //   805: aastore
    //   806: aconst_null
    //   807: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   810: astore 10
    //   812: aload_1
    //   813: astore 8
    //   815: aload 10
    //   817: ifnull +100 -> 917
    //   820: aload_1
    //   821: astore 8
    //   823: aload_1
    //   824: astore 5
    //   826: aload 10
    //   828: astore 7
    //   830: aload 10
    //   832: astore_0
    //   833: aload 10
    //   835: invokeinterface 75 1 0
    //   840: ifeq +77 -> 917
    //   843: aload_1
    //   844: astore 5
    //   846: aload 10
    //   848: astore 7
    //   850: aload 10
    //   852: astore_0
    //   853: aload 10
    //   855: aload 10
    //   857: ldc 61
    //   859: invokeinterface 79 2 0
    //   864: invokeinterface 83 2 0
    //   869: astore 8
    //   871: aload 8
    //   873: astore 5
    //   875: aload 10
    //   877: astore 7
    //   879: aload 10
    //   881: astore_0
    //   882: aload 8
    //   884: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   887: ifne +440 -> 1327
    //   890: aload 8
    //   892: astore 5
    //   894: aload 10
    //   896: astore 7
    //   898: aload 10
    //   900: astore_0
    //   901: ldc 17
    //   903: ldc 249
    //   905: iconst_1
    //   906: anewarray 4	java/lang/Object
    //   909: dup
    //   910: iconst_0
    //   911: aload 8
    //   913: aastore
    //   914: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   917: aload 8
    //   919: astore 6
    //   921: aload 10
    //   923: ifnull +14 -> 937
    //   926: aload 10
    //   928: invokeinterface 89 1 0
    //   933: aload 8
    //   935: astore 6
    //   937: aload 6
    //   939: astore_1
    //   940: aload 6
    //   942: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   945: ifne +103 -> 1048
    //   948: aload 6
    //   950: aload 9
    //   952: invokestatic 153	com/tencent/mm/sdk/platformtools/PhoneFormater:extractCountryCode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   955: astore 5
    //   957: ldc 17
    //   959: ldc 251
    //   961: iconst_3
    //   962: anewarray 4	java/lang/Object
    //   965: dup
    //   966: iconst_0
    //   967: aload 6
    //   969: aastore
    //   970: dup
    //   971: iconst_1
    //   972: aload 5
    //   974: aastore
    //   975: dup
    //   976: iconst_2
    //   977: aload 9
    //   979: aastore
    //   980: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   983: aload 6
    //   985: astore_1
    //   986: aload 5
    //   988: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   991: ifne +41 -> 1032
    //   994: aload 6
    //   996: ldc 161
    //   998: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1001: ifeq +414 -> 1415
    //   1004: ldc 161
    //   1006: aload 5
    //   1008: invokestatic 254	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1011: invokevirtual 210	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1014: astore_0
    //   1015: aload 6
    //   1017: astore_1
    //   1018: aload_0
    //   1019: ifnull +13 -> 1032
    //   1022: aload 6
    //   1024: aload_0
    //   1025: invokevirtual 159	java/lang/String:length	()I
    //   1028: invokevirtual 167	java/lang/String:substring	(I)Ljava/lang/String;
    //   1031: astore_1
    //   1032: ldc 17
    //   1034: ldc_w 256
    //   1037: iconst_1
    //   1038: anewarray 4	java/lang/Object
    //   1041: dup
    //   1042: iconst_0
    //   1043: aload_1
    //   1044: aastore
    //   1045: invokestatic 24	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1048: ldc 104
    //   1050: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1053: aload_1
    //   1054: areturn
    //   1055: astore 5
    //   1057: iconst_0
    //   1058: istore_2
    //   1059: aload 6
    //   1061: astore_1
    //   1062: aload 5
    //   1064: astore 6
    //   1066: aload_1
    //   1067: astore 5
    //   1069: ldc 17
    //   1071: aload 6
    //   1073: ldc 173
    //   1075: iconst_0
    //   1076: anewarray 4	java/lang/Object
    //   1079: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1082: aload_1
    //   1083: astore 5
    //   1085: ldc 17
    //   1087: ldc_w 258
    //   1090: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1093: iload_2
    //   1094: istore_3
    //   1095: aload_1
    //   1096: astore 6
    //   1098: aload_1
    //   1099: ifnull -633 -> 466
    //   1102: iload_2
    //   1103: istore_3
    //   1104: aload_1
    //   1105: astore 6
    //   1107: aload_1
    //   1108: invokeinterface 213 1 0
    //   1113: ifne -647 -> 466
    //   1116: aload_1
    //   1117: invokeinterface 89 1 0
    //   1122: iload_2
    //   1123: istore_3
    //   1124: aload_1
    //   1125: astore 6
    //   1127: goto -661 -> 466
    //   1130: astore_0
    //   1131: aload 5
    //   1133: ifnull +20 -> 1153
    //   1136: aload 5
    //   1138: invokeinterface 213 1 0
    //   1143: ifne +10 -> 1153
    //   1146: aload 5
    //   1148: invokeinterface 89 1 0
    //   1153: ldc 104
    //   1155: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1158: aload_0
    //   1159: athrow
    //   1160: astore 7
    //   1162: aconst_null
    //   1163: astore 5
    //   1165: aload 6
    //   1167: astore_1
    //   1168: aload_1
    //   1169: astore 6
    //   1171: ldc 17
    //   1173: aload 7
    //   1175: ldc 173
    //   1177: iconst_0
    //   1178: anewarray 4	java/lang/Object
    //   1181: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1184: aload_1
    //   1185: astore 6
    //   1187: ldc 17
    //   1189: ldc_w 258
    //   1192: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1195: aload 5
    //   1197: astore 7
    //   1199: aload_1
    //   1200: astore 6
    //   1202: aload_1
    //   1203: ifnull +299 -> 1502
    //   1206: aload 5
    //   1208: astore 7
    //   1210: aload_1
    //   1211: astore 6
    //   1213: aload_1
    //   1214: invokeinterface 213 1 0
    //   1219: ifne +283 -> 1502
    //   1222: aload_1
    //   1223: invokeinterface 89 1 0
    //   1228: aload_1
    //   1229: astore 6
    //   1231: aload 5
    //   1233: astore_1
    //   1234: aload 6
    //   1236: astore 5
    //   1238: goto -594 -> 644
    //   1241: astore_0
    //   1242: aload 6
    //   1244: ifnull +20 -> 1264
    //   1247: aload 6
    //   1249: invokeinterface 213 1 0
    //   1254: ifne +10 -> 1264
    //   1257: aload 6
    //   1259: invokeinterface 89 1 0
    //   1264: ldc 104
    //   1266: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1269: aload_0
    //   1270: athrow
    //   1271: astore 6
    //   1273: aload 5
    //   1275: astore_0
    //   1276: aload_0
    //   1277: astore 5
    //   1279: ldc 17
    //   1281: aload 6
    //   1283: ldc 173
    //   1285: iconst_0
    //   1286: anewarray 4	java/lang/Object
    //   1289: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1292: aload_0
    //   1293: ifnull +196 -> 1489
    //   1296: aload_0
    //   1297: invokeinterface 89 1 0
    //   1302: iconst_0
    //   1303: istore_2
    //   1304: goto -555 -> 749
    //   1307: astore_0
    //   1308: aload 5
    //   1310: ifnull +10 -> 1320
    //   1313: aload 5
    //   1315: invokeinterface 89 1 0
    //   1320: ldc 104
    //   1322: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1325: aload_0
    //   1326: athrow
    //   1327: aload 8
    //   1329: astore 5
    //   1331: aload 10
    //   1333: astore 7
    //   1335: aload 10
    //   1337: astore_0
    //   1338: aload 10
    //   1340: invokeinterface 92 1 0
    //   1345: istore 4
    //   1347: aload 8
    //   1349: astore_1
    //   1350: iload 4
    //   1352: ifne -509 -> 843
    //   1355: goto -438 -> 917
    //   1358: astore_1
    //   1359: aload 7
    //   1361: astore_0
    //   1362: ldc 17
    //   1364: aload_1
    //   1365: ldc 173
    //   1367: iconst_0
    //   1368: anewarray 4	java/lang/Object
    //   1371: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1374: aload 5
    //   1376: astore 6
    //   1378: aload 7
    //   1380: ifnull -443 -> 937
    //   1383: aload 7
    //   1385: invokeinterface 89 1 0
    //   1390: aload 5
    //   1392: astore 6
    //   1394: goto -457 -> 937
    //   1397: astore_1
    //   1398: aload_0
    //   1399: ifnull +9 -> 1408
    //   1402: aload_0
    //   1403: invokeinterface 89 1 0
    //   1408: ldc 104
    //   1410: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1413: aload_1
    //   1414: athrow
    //   1415: aload 5
    //   1417: astore_0
    //   1418: aload 6
    //   1420: aload 5
    //   1422: invokevirtual 164	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1425: ifne -410 -> 1015
    //   1428: aconst_null
    //   1429: astore_0
    //   1430: goto -415 -> 1015
    //   1433: astore_0
    //   1434: goto -126 -> 1308
    //   1437: astore 6
    //   1439: goto -163 -> 1276
    //   1442: astore_0
    //   1443: goto -201 -> 1242
    //   1446: astore 7
    //   1448: aconst_null
    //   1449: astore 5
    //   1451: goto -283 -> 1168
    //   1454: astore 6
    //   1456: aload 7
    //   1458: astore 5
    //   1460: aload 6
    //   1462: astore 7
    //   1464: goto -296 -> 1168
    //   1467: astore 6
    //   1469: goto -403 -> 1066
    //   1472: astore 7
    //   1474: aload 6
    //   1476: astore_1
    //   1477: aload 7
    //   1479: astore 6
    //   1481: goto -1237 -> 244
    //   1484: astore 6
    //   1486: goto -1242 -> 244
    //   1489: iconst_0
    //   1490: istore_2
    //   1491: goto -742 -> 749
    //   1494: goto -745 -> 749
    //   1497: iconst_0
    //   1498: istore_2
    //   1499: goto -760 -> 739
    //   1502: aload 7
    //   1504: astore_1
    //   1505: aload 6
    //   1507: astore 5
    //   1509: goto -865 -> 644
    //   1512: aconst_null
    //   1513: astore 5
    //   1515: goto -914 -> 601
    //   1518: iconst_0
    //   1519: istore_2
    //   1520: goto -1105 -> 415
    //   1523: goto -1304 -> 219
    //   1526: aload 6
    //   1528: astore_1
    //   1529: goto -1423 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1532	0	paramContext	Context
    //   0	1532	1	paramString	String
    //   195	1325	2	i	int
    //   184	940	3	j	int
    //   1345	6	4	bool	boolean
    //   50	957	5	localObject1	Object
    //   1055	8	5	localException1	Exception
    //   1067	447	5	localObject2	Object
    //   90	35	6	str1	String
    //   233	14	6	localException2	Exception
    //   305	953	6	localObject3	Object
    //   1271	11	6	localException3	Exception
    //   1376	43	6	localObject4	Object
    //   1437	1	6	localException4	Exception
    //   1454	7	6	localException5	Exception
    //   1467	8	6	localException6	Exception
    //   1479	1	6	localException7	Exception
    //   1484	43	6	localException8	Exception
    //   47	850	7	localObject5	Object
    //   1160	14	7	localException9	Exception
    //   1197	187	7	localObject6	Object
    //   1446	11	7	localException10	Exception
    //   1462	1	7	localObject7	Object
    //   1472	31	7	localException11	Exception
    //   314	1034	8	str2	String
    //   126	852	9	str3	String
    //   308	1031	10	localCursor	Cursor
    //   302	475	11	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   55	72	233	java/lang/Exception
    //   75	82	233	java/lang/Exception
    //   85	92	233	java/lang/Exception
    //   341	362	1055	java/lang/Exception
    //   372	381	1055	java/lang/Exception
    //   387	396	1055	java/lang/Exception
    //   407	415	1055	java/lang/Exception
    //   341	362	1130	finally
    //   372	381	1130	finally
    //   387	396	1130	finally
    //   407	415	1130	finally
    //   418	432	1130	finally
    //   1069	1082	1130	finally
    //   1085	1093	1130	finally
    //   477	512	1160	java/lang/Exception
    //   477	512	1241	finally
    //   675	705	1271	java/lang/Exception
    //   675	705	1307	finally
    //   776	812	1358	java/lang/Exception
    //   833	843	1358	java/lang/Exception
    //   853	871	1358	java/lang/Exception
    //   882	890	1358	java/lang/Exception
    //   901	917	1358	java/lang/Exception
    //   1338	1347	1358	java/lang/Exception
    //   776	812	1397	finally
    //   833	843	1397	finally
    //   853	871	1397	finally
    //   882	890	1397	finally
    //   901	917	1397	finally
    //   1338	1347	1397	finally
    //   1362	1374	1397	finally
    //   712	721	1433	finally
    //   724	739	1433	finally
    //   1279	1292	1433	finally
    //   712	721	1437	java/lang/Exception
    //   724	739	1437	java/lang/Exception
    //   523	532	1442	finally
    //   535	544	1442	finally
    //   556	565	1442	finally
    //   572	588	1442	finally
    //   595	601	1442	finally
    //   1171	1184	1442	finally
    //   1187	1195	1442	finally
    //   523	532	1446	java/lang/Exception
    //   535	544	1446	java/lang/Exception
    //   556	565	1446	java/lang/Exception
    //   572	588	1454	java/lang/Exception
    //   595	601	1454	java/lang/Exception
    //   418	432	1467	java/lang/Exception
    //   92	106	1472	java/lang/Exception
    //   109	124	1484	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.h
 * JD-Core Version:    0.7.0.1
 */