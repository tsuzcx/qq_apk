package com.tencent.mm.platformtools;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Profile;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  private static String D(Context paramContext, String paramString)
  {
    Object localObject = null;
    y.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", new Object[] { paramString });
    if (paramContext == null)
    {
      y.e("MicroMsg.ContactsUtil", "context is null.");
      return null;
    }
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.ContactsUtil", "email is null.");
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
        y.printErrStackTrace("MicroMsg.ContactsUtil", paramString, "getContactIdByEmail error", new Object[0]);
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
        if (!bk.bl(paramContext))
        {
          paramString = paramContext;
          y.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", new Object[] { paramContext });
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
  
  @TargetApi(14)
  public static String bI(Context paramContext)
  {
    y.i("MicroMsg.ContactsUtil", "Get name of a contacts record or profile.");
    if (paramContext == null)
    {
      y.e("MicroMsg.ContactsUtil", "context is null.");
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    if (!a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.ContactsUtil", "no contact permission");
      return null;
    }
    if (d.gF(14)) {
      y.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = localContentResolver.query(ContactsContract.Profile.CONTENT_URI, new String[] { "display_name" }, null, null, null);
        if (localObject == null) {
          break label274;
        }
        if (!((Cursor)localObject).moveToFirst()) {
          break label269;
        }
        String str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("display_name"));
        y.i("MicroMsg.ContactsUtil", "Have got name from profile, name is %s", new Object[] { str1 });
        ((Cursor)localObject).close();
        localObject = str1;
        if (bk.bl(str1))
        {
          paramContext = D(paramContext, w.bS(paramContext));
          if (bk.bl(paramContext))
          {
            y.i("MicroMsg.ContactsUtil", "contactId is null.");
            return null;
          }
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.ContactsUtil", localException, "", new Object[0]);
        y.d("MicroMsg.ContactsUtil", "query crashed");
        localObject = null;
        continue;
        paramContext = localContentResolver.query(ContactsContract.Data.CONTENT_URI, new String[] { "display_name" }, "contact_id=?", new String[] { paramContext }, null);
        localObject = localException;
        if (paramContext != null)
        {
          if (paramContext.moveToFirst())
          {
            str2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            y.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", new Object[] { str2 });
          }
          paramContext.close();
          localObject = str2;
        }
      }
      return localObject;
      label269:
      String str2 = null;
      continue;
      label274:
      str2 = null;
    }
  }
  
  @TargetApi(14)
  public static Bitmap bJ(Context paramContext)
  {
    y.i("MicroMsg.ContactsUtil", "Get bitmap of a contacts record or profile.");
    if (paramContext == null)
    {
      y.e("MicroMsg.ContactsUtil", "context is null.");
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject5 = null;
    if (!a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.ContactsUtil", "no contact permission");
      return null;
    }
    Object localObject3 = null;
    Object localObject1 = localObject5;
    if (d.gF(14))
    {
      y.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
      try
      {
        localObject1 = localContentResolver.query(ContactsContract.Profile.CONTENT_URI, new String[] { "_id" }, null, null, null);
        localObject3 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject4 = localContentResolver.query(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), new String[] { "data15", "data_sync1" }, "mimetype=?", new String[] { "vnd.android.cursor.item/photo" }, null);
          localObject1 = localObject5;
          if (localObject4 == null) {
            break label488;
          }
          if (!((Cursor)localObject4).moveToFirst()) {
            break label998;
          }
          if ((!aq.isWifi(paramContext)) && (!aq.is3G(paramContext)) && (!aq.is4G(paramContext))) {
            break label397;
          }
          y.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
          localObject1 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("data_sync1"));
          y.i("MicroMsg.ContactsUtil", "get sync avatar url : [%s]", new Object[] { localObject1 });
          if (bk.bl((String)localObject1)) {
            break label397;
          }
          i = ((String)localObject1).lastIndexOf("https:");
          y.i("MicroMsg.ContactsUtil", "check is exist https download url :[%d]", new Object[] { Integer.valueOf(i) });
          if (i < 0) {
            break label397;
          }
          localObject3 = ((String)localObject1).substring(i);
          localObject1 = pc((String)localObject3);
          y.i("MicroMsg.ContactsUtil", "Get image from google sync account in profile,url:[%s]", new Object[] { localObject3 });
          localObject3 = localObject1;
          if (localObject1 == null) {
            break label400;
          }
          localObject3 = localObject1;
          if (((Bitmap)localObject1).isRecycled()) {
            break label400;
          }
          ((Cursor)localObject4).close();
          return localObject1;
          localException1 = localException1;
          y.printErrStackTrace("MicroMsg.ContactsUtil", localException1, "", new Object[0]);
          y.d("MicroMsg.ContactsUtil", "query crashed");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.ContactsUtil", localException2, "", new Object[0]);
            y.d("MicroMsg.ContactsUtil", "query crashed");
            localObject4 = localObject3;
          }
          localObject3 = null;
          i = ((Cursor)localObject4).getColumnIndex("data15");
          localObject2 = localObject3;
          if (i == -1) {
            break label481;
          }
          localObject5 = ((Cursor)localObject4).getBlob(i);
          y.i("MicroMsg.ContactsUtil", "get bitmap data is null : [%b]", new Object[] { Boolean.valueOf(bk.bE((byte[])localObject5)) });
          localObject2 = localObject3;
          if (bk.bE((byte[])localObject5)) {
            break label481;
          }
          y.i("MicroMsg.ContactsUtil", "Get image from profile personal icon.");
          localObject2 = BitmapFactory.decodeByteArray((byte[])localObject5, 0, localObject5.length);
        }
      }
      localObject1 = localObject5;
      if (localObject3 != null)
      {
        if (((Cursor)localObject3).getCount() <= 0) {
          break label532;
        }
        ((Cursor)localObject3).close();
      }
    }
    for (;;)
    {
      label397:
      label400:
      label481:
      ((Cursor)localObject4).close();
      for (;;)
      {
        label488:
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {
            break label846;
          }
        }
        localObject5 = D(paramContext, w.bS(paramContext));
        if (!bk.bl((String)localObject5)) {
          break;
        }
        y.i("MicroMsg.ContactsUtil", "contactId is null.");
        return null;
        label532:
        ((Cursor)localObject3).close();
        localObject2 = localObject5;
      }
      Object localObject4 = localContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "photo_id", "raw_contact_id" }, "contact_id=?", new String[] { localObject5 }, null);
      localObject3 = localObject2;
      Cursor localCursor;
      if (localObject4 != null)
      {
        localObject3 = localObject2;
        if (((Cursor)localObject4).moveToFirst())
        {
          if ((!aq.isWifi(paramContext)) && (!aq.is3G(paramContext)))
          {
            localObject3 = localObject2;
            if (!aq.is4G(paramContext)) {
              break label856;
            }
          }
          y.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
          localObject3 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("raw_contact_id"));
          localCursor = localContentResolver.query(ContactsContract.Data.CONTENT_URI, new String[] { "data15", "data_sync1" }, "mimetype=? AND raw_contact_id=?", new String[] { "vnd.android.cursor.item/photo", localObject3 }, null);
          localObject3 = localObject2;
          if (localCursor == null) {
            break label856;
          }
          localObject3 = localObject2;
          if (localCursor.moveToFirst())
          {
            i = localCursor.getColumnIndex("data_sync1");
            localObject3 = localObject2;
            if (i != -1)
            {
              String str = localCursor.getString(i);
              localObject3 = localObject2;
              if (!bk.bl(str))
              {
                i = str.lastIndexOf("https:");
                localObject3 = localObject2;
                if (i >= 0)
                {
                  str = str.substring(i);
                  localObject2 = pc(str);
                  localObject3 = localObject2;
                  if (localObject2 != null)
                  {
                    localObject3 = localObject2;
                    if (!((Bitmap)localObject2).isRecycled())
                    {
                      y.i("MicroMsg.ContactsUtil", "Get image from google sync account in contacts,url:[%s]", new Object[] { str });
                      localCursor.close();
                      localObject3 = localObject2;
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          label839:
          ((Cursor)localObject4).close();
        }
      }
      else
      {
        label846:
        return localObject3;
      }
      localCursor.close();
      label856:
      y.i("MicroMsg.ContactsUtil", "Get bitmap from contacts icon.");
      int i = ((Cursor)localObject4).getColumnIndex("photo_id");
      long l;
      if (i != -1)
      {
        l = ((Cursor)localObject4).getLong(i);
        y.i("MicroMsg.ContactsUtil", "Have got photoId,photoId is " + l);
      }
      for (;;)
      {
        if (l > 0L)
        {
          localObject3 = BitmapFactory.decodeStream(ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, bk.getLong((String)localObject5, 0L))));
          localObject2 = localObject3;
          if (localObject3 == null) {
            break label973;
          }
          localObject2 = localObject3;
          if (((Bitmap)localObject3).isRecycled()) {
            break label973;
          }
          y.i("MicroMsg.ContactsUtil", "Get image from contacts through google account.");
          break label839;
        }
        localObject2 = localObject3;
        label973:
        if (!((Cursor)localObject4).moveToNext())
        {
          localObject3 = localObject2;
          break label839;
        }
        break;
        l = 0L;
      }
      label998:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  @TargetApi(14)
  public static String getPhoneNum(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: ldc 10
    //   5: ldc_w 296
    //   8: iconst_1
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_1
    //   15: aastore
    //   16: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: ifnonnull +13 -> 33
    //   23: ldc 10
    //   25: ldc_w 298
    //   28: invokestatic 24	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc_w 300
    //   37: invokevirtual 304	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   40: checkcast 306	android/telephony/TelephonyManager
    //   43: astore 6
    //   45: aload 6
    //   47: invokevirtual 309	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   50: astore 5
    //   52: aload 6
    //   54: invokevirtual 312	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload_1
    //   59: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   62: ifeq +1454 -> 1516
    //   65: aload 6
    //   67: invokevirtual 315	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   70: astore 6
    //   72: aload 6
    //   74: astore_1
    //   75: aload_1
    //   76: astore 6
    //   78: aload_1
    //   79: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   82: ifeq +11 -> 93
    //   85: invokestatic 321	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   88: invokevirtual 324	java/util/Locale:getCountry	()Ljava/lang/String;
    //   91: astore 6
    //   93: aload 6
    //   95: astore 9
    //   97: aload 5
    //   99: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   102: ifne +142 -> 244
    //   105: aload 5
    //   107: invokevirtual 327	java/lang/String:trim	()Ljava/lang/String;
    //   110: astore_0
    //   111: aload_0
    //   112: aload 9
    //   114: invokestatic 333	com/tencent/mm/sdk/platformtools/ar:ge	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: astore_1
    //   118: ldc 10
    //   120: ldc_w 335
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload_1
    //   134: aastore
    //   135: dup
    //   136: iconst_2
    //   137: aload 9
    //   139: aastore
    //   140: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_1
    //   144: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   147: ifne +1366 -> 1513
    //   150: aload_1
    //   151: invokevirtual 338	java/lang/String:length	()I
    //   154: istore_3
    //   155: aload_0
    //   156: ldc_w 340
    //   159: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   162: ifeq +77 -> 239
    //   165: iconst_1
    //   166: istore_2
    //   167: aload_0
    //   168: iload_2
    //   169: iload_3
    //   170: iadd
    //   171: invokevirtual 204	java/lang/String:substring	(I)Ljava/lang/String;
    //   174: astore_0
    //   175: ldc 10
    //   177: ldc_w 345
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_0
    //   187: aastore
    //   188: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: ldc 10
    //   193: ldc_w 347
    //   196: invokestatic 34	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: areturn
    //   201: astore 5
    //   203: aconst_null
    //   204: astore_1
    //   205: aconst_null
    //   206: astore 6
    //   208: ldc 10
    //   210: aload 5
    //   212: ldc 133
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: ldc 10
    //   223: ldc_w 349
    //   226: invokestatic 24	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 6
    //   231: astore 5
    //   233: aload_1
    //   234: astore 9
    //   236: goto -139 -> 97
    //   239: iconst_0
    //   240: istore_2
    //   241: goto -74 -> 167
    //   244: aload_0
    //   245: ldc 99
    //   247: invokestatic 105	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   250: ifne +12 -> 262
    //   253: ldc 10
    //   255: ldc 107
    //   257: invokestatic 24	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload_0
    //   263: invokevirtual 40	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   266: astore 8
    //   268: bipush 14
    //   270: invokestatic 352	com/tencent/mm/compatible/util/d:gG	(I)Z
    //   273: ifne +1232 -> 1505
    //   276: ldc 10
    //   278: ldc_w 354
    //   281: invokestatic 34	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 8
    //   286: getstatic 118	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   289: iconst_1
    //   290: anewarray 48	java/lang/String
    //   293: dup
    //   294: iconst_0
    //   295: ldc_w 356
    //   298: aastore
    //   299: aconst_null
    //   300: aconst_null
    //   301: aconst_null
    //   302: invokevirtual 60	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   305: astore_1
    //   306: aload_1
    //   307: ifnull +1193 -> 1500
    //   310: aload_1
    //   311: astore 5
    //   313: aload_1
    //   314: invokeinterface 66 1 0
    //   319: ifeq +1181 -> 1500
    //   322: aload_1
    //   323: astore 5
    //   325: aload_1
    //   326: ldc_w 356
    //   329: invokeinterface 70 2 0
    //   334: istore_2
    //   335: iload_2
    //   336: iconst_m1
    //   337: if_icmpeq +1163 -> 1500
    //   340: aload_1
    //   341: astore 5
    //   343: aload_1
    //   344: iload_2
    //   345: invokeinterface 360 2 0
    //   350: istore_2
    //   351: aload_1
    //   352: astore 5
    //   354: ldc 10
    //   356: new 257	java/lang/StringBuilder
    //   359: dup
    //   360: ldc_w 362
    //   363: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: iload_2
    //   367: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 34	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: iload_2
    //   377: istore_3
    //   378: aload_1
    //   379: astore 5
    //   381: aload_1
    //   382: ifnull +1113 -> 1495
    //   385: iload_2
    //   386: istore_3
    //   387: aload_1
    //   388: astore 5
    //   390: aload_1
    //   391: invokeinterface 368 1 0
    //   396: ifne +1099 -> 1495
    //   399: aload_1
    //   400: invokeinterface 80 1 0
    //   405: aload_1
    //   406: astore 5
    //   408: iload_2
    //   409: ifle +1081 -> 1490
    //   412: aload 8
    //   414: getstatic 118	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   417: ldc 158
    //   419: invokestatic 164	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   422: iconst_1
    //   423: anewarray 48	java/lang/String
    //   426: dup
    //   427: iconst_0
    //   428: ldc 52
    //   430: aastore
    //   431: ldc 170
    //   433: iconst_1
    //   434: anewarray 48	java/lang/String
    //   437: dup
    //   438: iconst_0
    //   439: ldc_w 370
    //   442: aastore
    //   443: aconst_null
    //   444: invokevirtual 60	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   447: astore_1
    //   448: aload_1
    //   449: ifnull +1035 -> 1484
    //   452: aload_1
    //   453: astore 6
    //   455: aload_1
    //   456: invokeinterface 66 1 0
    //   461: ifeq +1017 -> 1478
    //   464: aload_1
    //   465: astore 6
    //   467: aload_1
    //   468: ldc 52
    //   470: invokeinterface 70 2 0
    //   475: istore_2
    //   476: iload_2
    //   477: iconst_m1
    //   478: if_icmpeq +1000 -> 1478
    //   481: aload_1
    //   482: astore 6
    //   484: aload_1
    //   485: iload_2
    //   486: invokeinterface 74 2 0
    //   491: astore 5
    //   493: aload_1
    //   494: astore 6
    //   496: aload 5
    //   498: astore 7
    //   500: ldc 10
    //   502: ldc_w 372
    //   505: iconst_1
    //   506: anewarray 4	java/lang/Object
    //   509: dup
    //   510: iconst_0
    //   511: aload 5
    //   513: aastore
    //   514: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   517: aload_1
    //   518: astore 6
    //   520: aload 5
    //   522: astore 7
    //   524: aload_1
    //   525: invokeinterface 80 1 0
    //   530: aload 5
    //   532: astore 7
    //   534: aload_1
    //   535: astore 6
    //   537: aload_1
    //   538: ifnull +930 -> 1468
    //   541: aload 5
    //   543: astore 7
    //   545: aload_1
    //   546: astore 6
    //   548: aload_1
    //   549: invokeinterface 368 1 0
    //   554: ifne +914 -> 1468
    //   557: aload_1
    //   558: invokeinterface 80 1 0
    //   563: aload 5
    //   565: astore 6
    //   567: aload_1
    //   568: astore 5
    //   570: aload 6
    //   572: astore_1
    //   573: aload_1
    //   574: astore 6
    //   576: aload_1
    //   577: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   580: ifeq +300 -> 880
    //   583: aload_0
    //   584: aload_0
    //   585: invokestatic 127	com/tencent/mm/platformtools/w:bS	(Landroid/content/Context;)Ljava/lang/String;
    //   588: invokestatic 129	com/tencent/mm/platformtools/i:D	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   591: astore 10
    //   593: aload_1
    //   594: astore 6
    //   596: aload 10
    //   598: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   601: ifne +279 -> 880
    //   604: aload 8
    //   606: getstatic 274	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   609: iconst_1
    //   610: anewarray 48	java/lang/String
    //   613: dup
    //   614: iconst_0
    //   615: ldc_w 356
    //   618: aastore
    //   619: ldc_w 374
    //   622: iconst_1
    //   623: anewarray 48	java/lang/String
    //   626: dup
    //   627: iconst_0
    //   628: aload 10
    //   630: aastore
    //   631: aconst_null
    //   632: invokevirtual 60	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   635: astore_0
    //   636: aload_0
    //   637: ifnull +826 -> 1463
    //   640: aload_0
    //   641: astore 5
    //   643: aload_0
    //   644: invokeinterface 66 1 0
    //   649: ifeq +814 -> 1463
    //   652: aload_0
    //   653: astore 5
    //   655: aload_0
    //   656: aload_0
    //   657: ldc_w 356
    //   660: invokeinterface 70 2 0
    //   665: invokeinterface 360 2 0
    //   670: istore_2
    //   671: aload_0
    //   672: ifnull +788 -> 1460
    //   675: aload_0
    //   676: invokeinterface 80 1 0
    //   681: ldc 10
    //   683: new 257	java/lang/StringBuilder
    //   686: dup
    //   687: ldc_w 362
    //   690: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   693: iload_2
    //   694: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   697: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 34	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   703: aload_1
    //   704: astore 6
    //   706: iload_2
    //   707: ifle +173 -> 880
    //   710: aload_1
    //   711: astore 5
    //   713: aload_0
    //   714: astore 7
    //   716: aload 8
    //   718: getstatic 241	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   721: iconst_2
    //   722: anewarray 48	java/lang/String
    //   725: dup
    //   726: iconst_0
    //   727: ldc 52
    //   729: aastore
    //   730: dup
    //   731: iconst_1
    //   732: ldc_w 376
    //   735: aastore
    //   736: ldc_w 378
    //   739: iconst_1
    //   740: anewarray 48	java/lang/String
    //   743: dup
    //   744: iconst_0
    //   745: aload 10
    //   747: aastore
    //   748: aconst_null
    //   749: invokevirtual 60	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   752: astore 10
    //   754: aload_1
    //   755: astore 8
    //   757: aload 10
    //   759: ifnull +101 -> 860
    //   762: aload_1
    //   763: astore 8
    //   765: aload_1
    //   766: astore 5
    //   768: aload 10
    //   770: astore 7
    //   772: aload 10
    //   774: astore_0
    //   775: aload 10
    //   777: invokeinterface 66 1 0
    //   782: ifeq +78 -> 860
    //   785: aload_1
    //   786: astore 5
    //   788: aload 10
    //   790: astore 7
    //   792: aload 10
    //   794: astore_0
    //   795: aload 10
    //   797: aload 10
    //   799: ldc 52
    //   801: invokeinterface 70 2 0
    //   806: invokeinterface 74 2 0
    //   811: astore 8
    //   813: aload 8
    //   815: astore 5
    //   817: aload 10
    //   819: astore 7
    //   821: aload 10
    //   823: astore_0
    //   824: aload 8
    //   826: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   829: ifne +433 -> 1262
    //   832: aload 8
    //   834: astore 5
    //   836: aload 10
    //   838: astore 7
    //   840: aload 10
    //   842: astore_0
    //   843: ldc 10
    //   845: ldc_w 380
    //   848: iconst_1
    //   849: anewarray 4	java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: aload 8
    //   856: aastore
    //   857: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   860: aload 8
    //   862: astore 6
    //   864: aload 10
    //   866: ifnull +14 -> 880
    //   869: aload 10
    //   871: invokeinterface 80 1 0
    //   876: aload 8
    //   878: astore 6
    //   880: aload 6
    //   882: astore_0
    //   883: aload 6
    //   885: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   888: ifne +113 -> 1001
    //   891: aload 6
    //   893: aload 9
    //   895: invokestatic 333	com/tencent/mm/sdk/platformtools/ar:ge	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   898: astore 5
    //   900: ldc 10
    //   902: ldc_w 382
    //   905: iconst_3
    //   906: anewarray 4	java/lang/Object
    //   909: dup
    //   910: iconst_0
    //   911: aload 6
    //   913: aastore
    //   914: dup
    //   915: iconst_1
    //   916: aload 5
    //   918: aastore
    //   919: dup
    //   920: iconst_2
    //   921: aload 9
    //   923: aastore
    //   924: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   927: aload 6
    //   929: astore_0
    //   930: aload 5
    //   932: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   935: ifne +50 -> 985
    //   938: aload 6
    //   940: ldc_w 340
    //   943: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   946: ifeq +399 -> 1345
    //   949: new 257	java/lang/StringBuilder
    //   952: dup
    //   953: ldc_w 340
    //   956: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   959: aload 5
    //   961: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   967: astore_1
    //   968: aload 6
    //   970: astore_0
    //   971: aload_1
    //   972: ifnull +13 -> 985
    //   975: aload 6
    //   977: aload_1
    //   978: invokevirtual 338	java/lang/String:length	()I
    //   981: invokevirtual 204	java/lang/String:substring	(I)Ljava/lang/String;
    //   984: astore_0
    //   985: ldc 10
    //   987: ldc_w 387
    //   990: iconst_1
    //   991: anewarray 4	java/lang/Object
    //   994: dup
    //   995: iconst_0
    //   996: aload_0
    //   997: aastore
    //   998: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1001: aload_0
    //   1002: areturn
    //   1003: astore 6
    //   1005: iconst_0
    //   1006: istore_2
    //   1007: aconst_null
    //   1008: astore_1
    //   1009: aload_1
    //   1010: astore 5
    //   1012: ldc 10
    //   1014: aload 6
    //   1016: ldc 133
    //   1018: iconst_0
    //   1019: anewarray 4	java/lang/Object
    //   1022: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: aload_1
    //   1026: astore 5
    //   1028: ldc 10
    //   1030: ldc 135
    //   1032: invokestatic 138	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1035: iload_2
    //   1036: istore_3
    //   1037: aload_1
    //   1038: astore 5
    //   1040: aload_1
    //   1041: ifnull +454 -> 1495
    //   1044: iload_2
    //   1045: istore_3
    //   1046: aload_1
    //   1047: astore 5
    //   1049: aload_1
    //   1050: invokeinterface 368 1 0
    //   1055: ifne +440 -> 1495
    //   1058: aload_1
    //   1059: invokeinterface 80 1 0
    //   1064: aload_1
    //   1065: astore 5
    //   1067: goto -659 -> 408
    //   1070: astore_0
    //   1071: aconst_null
    //   1072: astore 5
    //   1074: aload 5
    //   1076: ifnull +20 -> 1096
    //   1079: aload 5
    //   1081: invokeinterface 368 1 0
    //   1086: ifne +10 -> 1096
    //   1089: aload 5
    //   1091: invokeinterface 80 1 0
    //   1096: aload_0
    //   1097: athrow
    //   1098: astore 7
    //   1100: aconst_null
    //   1101: astore 6
    //   1103: aload 5
    //   1105: astore_1
    //   1106: aload 6
    //   1108: astore 5
    //   1110: aload_1
    //   1111: astore 6
    //   1113: ldc 10
    //   1115: aload 7
    //   1117: ldc 133
    //   1119: iconst_0
    //   1120: anewarray 4	java/lang/Object
    //   1123: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1126: aload_1
    //   1127: astore 6
    //   1129: ldc 10
    //   1131: ldc 135
    //   1133: invokestatic 138	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1136: aload 5
    //   1138: astore 7
    //   1140: aload_1
    //   1141: astore 6
    //   1143: aload_1
    //   1144: ifnull +324 -> 1468
    //   1147: aload 5
    //   1149: astore 7
    //   1151: aload_1
    //   1152: astore 6
    //   1154: aload_1
    //   1155: invokeinterface 368 1 0
    //   1160: ifne +308 -> 1468
    //   1163: aload_1
    //   1164: invokeinterface 80 1 0
    //   1169: aload_1
    //   1170: astore 6
    //   1172: aload 5
    //   1174: astore_1
    //   1175: aload 6
    //   1177: astore 5
    //   1179: goto -606 -> 573
    //   1182: astore_0
    //   1183: aload 5
    //   1185: astore 6
    //   1187: aload 6
    //   1189: ifnull +20 -> 1209
    //   1192: aload 6
    //   1194: invokeinterface 368 1 0
    //   1199: ifne +10 -> 1209
    //   1202: aload 6
    //   1204: invokeinterface 80 1 0
    //   1209: aload_0
    //   1210: athrow
    //   1211: astore 6
    //   1213: aload 5
    //   1215: astore_0
    //   1216: aload_0
    //   1217: astore 5
    //   1219: ldc 10
    //   1221: aload 6
    //   1223: ldc 133
    //   1225: iconst_0
    //   1226: anewarray 4	java/lang/Object
    //   1229: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1232: aload_0
    //   1233: ifnull +222 -> 1455
    //   1236: aload_0
    //   1237: invokeinterface 80 1 0
    //   1242: iconst_0
    //   1243: istore_2
    //   1244: goto -563 -> 681
    //   1247: astore_0
    //   1248: aload 5
    //   1250: ifnull +10 -> 1260
    //   1253: aload 5
    //   1255: invokeinterface 80 1 0
    //   1260: aload_0
    //   1261: athrow
    //   1262: aload 8
    //   1264: astore 5
    //   1266: aload 10
    //   1268: astore 7
    //   1270: aload 10
    //   1272: astore_0
    //   1273: aload 10
    //   1275: invokeinterface 83 1 0
    //   1280: istore 4
    //   1282: aload 8
    //   1284: astore_1
    //   1285: iload 4
    //   1287: ifne -502 -> 785
    //   1290: goto -430 -> 860
    //   1293: astore_1
    //   1294: aload 7
    //   1296: astore_0
    //   1297: ldc 10
    //   1299: aload_1
    //   1300: ldc 133
    //   1302: iconst_0
    //   1303: anewarray 4	java/lang/Object
    //   1306: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1309: aload 5
    //   1311: astore 6
    //   1313: aload 7
    //   1315: ifnull -435 -> 880
    //   1318: aload 7
    //   1320: invokeinterface 80 1 0
    //   1325: aload 5
    //   1327: astore 6
    //   1329: goto -449 -> 880
    //   1332: astore_1
    //   1333: aload_0
    //   1334: ifnull +9 -> 1343
    //   1337: aload_0
    //   1338: invokeinterface 80 1 0
    //   1343: aload_1
    //   1344: athrow
    //   1345: aload 11
    //   1347: astore_1
    //   1348: aload 6
    //   1350: aload 5
    //   1352: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1355: ifeq -387 -> 968
    //   1358: aload 5
    //   1360: astore_1
    //   1361: goto -393 -> 968
    //   1364: astore_0
    //   1365: goto -117 -> 1248
    //   1368: astore 6
    //   1370: goto -154 -> 1216
    //   1373: astore_0
    //   1374: goto -187 -> 1187
    //   1377: astore 7
    //   1379: aconst_null
    //   1380: astore 5
    //   1382: goto -272 -> 1110
    //   1385: astore 6
    //   1387: aload 7
    //   1389: astore 5
    //   1391: aload 6
    //   1393: astore 7
    //   1395: goto -285 -> 1110
    //   1398: astore_0
    //   1399: goto -325 -> 1074
    //   1402: astore 6
    //   1404: iconst_0
    //   1405: istore_2
    //   1406: goto -397 -> 1009
    //   1409: astore 6
    //   1411: goto -402 -> 1009
    //   1414: astore 7
    //   1416: aconst_null
    //   1417: astore_1
    //   1418: aload 5
    //   1420: astore 6
    //   1422: aload 7
    //   1424: astore 5
    //   1426: goto -1218 -> 208
    //   1429: astore 7
    //   1431: aload 5
    //   1433: astore 6
    //   1435: aload 7
    //   1437: astore 5
    //   1439: goto -1231 -> 208
    //   1442: astore 7
    //   1444: aload 5
    //   1446: astore 6
    //   1448: aload 7
    //   1450: astore 5
    //   1452: goto -1244 -> 208
    //   1455: iconst_0
    //   1456: istore_2
    //   1457: goto -776 -> 681
    //   1460: goto -779 -> 681
    //   1463: iconst_0
    //   1464: istore_2
    //   1465: goto -794 -> 671
    //   1468: aload 7
    //   1470: astore_1
    //   1471: aload 6
    //   1473: astore 5
    //   1475: goto -902 -> 573
    //   1478: aconst_null
    //   1479: astore 5
    //   1481: goto -964 -> 517
    //   1484: aconst_null
    //   1485: astore 5
    //   1487: goto -957 -> 530
    //   1490: aconst_null
    //   1491: astore_1
    //   1492: goto -919 -> 573
    //   1495: iload_3
    //   1496: istore_2
    //   1497: goto -1089 -> 408
    //   1500: iconst_0
    //   1501: istore_2
    //   1502: goto -1151 -> 351
    //   1505: aconst_null
    //   1506: astore_1
    //   1507: aconst_null
    //   1508: astore 5
    //   1510: goto -937 -> 573
    //   1513: goto -1322 -> 191
    //   1516: goto -1441 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1519	0	paramContext	Context
    //   0	1519	1	paramString	String
    //   166	1336	2	i	int
    //   154	1342	3	j	int
    //   1280	6	4	bool	boolean
    //   50	56	5	str	String
    //   201	10	5	localException1	Exception
    //   231	1278	5	localObject1	Object
    //   43	933	6	localObject2	Object
    //   1003	12	6	localException2	Exception
    //   1101	102	6	localObject3	Object
    //   1211	11	6	localException3	Exception
    //   1311	38	6	localObject4	Object
    //   1368	1	6	localException4	Exception
    //   1385	7	6	localException5	Exception
    //   1402	1	6	localException6	Exception
    //   1409	1	6	localException7	Exception
    //   1420	52	6	localObject5	Object
    //   498	341	7	localObject6	Object
    //   1098	18	7	localException8	Exception
    //   1138	181	7	localObject7	Object
    //   1377	11	7	localException9	Exception
    //   1393	1	7	localException10	Exception
    //   1414	9	7	localException11	Exception
    //   1429	7	7	localException12	Exception
    //   1442	27	7	localException13	Exception
    //   266	1017	8	localObject8	Object
    //   95	827	9	localObject9	Object
    //   591	683	10	localObject10	Object
    //   1	1345	11	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	201	java/lang/Exception
    //   284	306	1003	java/lang/Exception
    //   284	306	1070	finally
    //   412	448	1098	java/lang/Exception
    //   412	448	1182	finally
    //   604	636	1211	java/lang/Exception
    //   604	636	1247	finally
    //   716	754	1293	java/lang/Exception
    //   775	785	1293	java/lang/Exception
    //   795	813	1293	java/lang/Exception
    //   824	832	1293	java/lang/Exception
    //   843	860	1293	java/lang/Exception
    //   1273	1282	1293	java/lang/Exception
    //   716	754	1332	finally
    //   775	785	1332	finally
    //   795	813	1332	finally
    //   824	832	1332	finally
    //   843	860	1332	finally
    //   1273	1282	1332	finally
    //   1297	1309	1332	finally
    //   643	652	1364	finally
    //   655	671	1364	finally
    //   1219	1232	1364	finally
    //   643	652	1368	java/lang/Exception
    //   655	671	1368	java/lang/Exception
    //   455	464	1373	finally
    //   467	476	1373	finally
    //   484	493	1373	finally
    //   500	517	1373	finally
    //   524	530	1373	finally
    //   1113	1126	1373	finally
    //   1129	1136	1373	finally
    //   455	464	1377	java/lang/Exception
    //   467	476	1377	java/lang/Exception
    //   484	493	1377	java/lang/Exception
    //   500	517	1385	java/lang/Exception
    //   524	530	1385	java/lang/Exception
    //   313	322	1398	finally
    //   325	335	1398	finally
    //   343	351	1398	finally
    //   354	376	1398	finally
    //   1012	1025	1398	finally
    //   1028	1035	1398	finally
    //   313	322	1402	java/lang/Exception
    //   325	335	1402	java/lang/Exception
    //   343	351	1402	java/lang/Exception
    //   354	376	1409	java/lang/Exception
    //   52	58	1414	java/lang/Exception
    //   58	72	1429	java/lang/Exception
    //   78	93	1442	java/lang/Exception
  }
  
  /* Error */
  private static Bitmap pc(String paramString)
  {
    // Byte code:
    //   0: ldc 10
    //   2: ldc_w 391
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: aastore
    //   13: invokestatic 18	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: invokestatic 30	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   20: ifeq +15 -> 35
    //   23: ldc 10
    //   25: ldc_w 393
    //   28: invokestatic 24	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aconst_null
    //   32: astore_0
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 327	java/lang/String:trim	()Ljava/lang/String;
    //   39: astore 5
    //   41: aload 5
    //   43: ldc 190
    //   45: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   48: ifne +13 -> 61
    //   51: ldc 10
    //   53: ldc_w 395
    //   56: invokestatic 24	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aconst_null
    //   60: areturn
    //   61: new 397	java/io/ByteArrayOutputStream
    //   64: dup
    //   65: invokespecial 399	java/io/ByteArrayOutputStream:<init>	()V
    //   68: astore 7
    //   70: aload 5
    //   72: invokestatic 405	com/tencent/mm/network/b:oL	(Ljava/lang/String;)Lcom/tencent/mm/network/v;
    //   75: astore_0
    //   76: aload_0
    //   77: getfield 411	com/tencent/mm/network/v:eOx	Ljavax/net/ssl/HttpsURLConnection;
    //   80: invokevirtual 417	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   83: astore_2
    //   84: aload_2
    //   85: ifnonnull +82 -> 167
    //   88: aload_0
    //   89: astore 4
    //   91: aload_2
    //   92: astore_3
    //   93: ldc 10
    //   95: ldc_w 419
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload 5
    //   106: aastore
    //   107: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: getfield 411	com/tencent/mm/network/v:eOx	Ljavax/net/ssl/HttpsURLConnection;
    //   114: invokevirtual 424	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 427	java/io/InputStream:close	()V
    //   125: aload 7
    //   127: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_0
    //   133: ldc 10
    //   135: ldc_w 430
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: invokevirtual 433	java/io/IOException:getMessage	()Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: ldc 10
    //   154: aload_0
    //   155: ldc 133
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -34 -> 130
    //   167: aload_0
    //   168: astore 4
    //   170: aload_2
    //   171: astore_3
    //   172: sipush 1024
    //   175: newarray byte
    //   177: astore 5
    //   179: aload_0
    //   180: astore 4
    //   182: aload_2
    //   183: astore_3
    //   184: aload_2
    //   185: aload 5
    //   187: invokevirtual 437	java/io/InputStream:read	([B)I
    //   190: istore_1
    //   191: iload_1
    //   192: iconst_m1
    //   193: if_icmpeq +130 -> 323
    //   196: aload_0
    //   197: astore 4
    //   199: aload_2
    //   200: astore_3
    //   201: aload 7
    //   203: aload 5
    //   205: iconst_0
    //   206: iload_1
    //   207: invokevirtual 441	java/io/ByteArrayOutputStream:write	([BII)V
    //   210: goto -31 -> 179
    //   213: astore 6
    //   215: aconst_null
    //   216: astore 5
    //   218: aload_0
    //   219: astore 4
    //   221: aload_2
    //   222: astore_3
    //   223: ldc 10
    //   225: ldc_w 443
    //   228: iconst_1
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload 6
    //   236: invokevirtual 433	java/io/IOException:getMessage	()Ljava/lang/String;
    //   239: aastore
    //   240: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload_0
    //   244: astore 4
    //   246: aload_2
    //   247: astore_3
    //   248: ldc 10
    //   250: aload 6
    //   252: ldc 133
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_0
    //   262: ifnull +10 -> 272
    //   265: aload_0
    //   266: getfield 411	com/tencent/mm/network/v:eOx	Ljavax/net/ssl/HttpsURLConnection;
    //   269: invokevirtual 424	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   272: aload_2
    //   273: ifnull +7 -> 280
    //   276: aload_2
    //   277: invokevirtual 427	java/io/InputStream:close	()V
    //   280: aload 7
    //   282: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   285: aload 5
    //   287: areturn
    //   288: astore_0
    //   289: ldc 10
    //   291: ldc_w 430
    //   294: iconst_1
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_0
    //   301: invokevirtual 433	java/io/IOException:getMessage	()Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: ldc 10
    //   310: aload_0
    //   311: ldc 133
    //   313: iconst_0
    //   314: anewarray 4	java/lang/Object
    //   317: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: aload 5
    //   322: areturn
    //   323: aload_0
    //   324: astore 4
    //   326: aload_2
    //   327: astore_3
    //   328: aload 7
    //   330: invokevirtual 447	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   333: invokestatic 453	com/tencent/mm/sdk/platformtools/c:bu	([B)Landroid/graphics/Bitmap;
    //   336: astore 5
    //   338: aload_0
    //   339: astore 4
    //   341: aload_2
    //   342: astore_3
    //   343: aload 7
    //   345: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   348: aload_0
    //   349: getfield 411	com/tencent/mm/network/v:eOx	Ljavax/net/ssl/HttpsURLConnection;
    //   352: invokevirtual 424	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   355: aload 5
    //   357: astore_0
    //   358: aload_2
    //   359: ifnull -326 -> 33
    //   362: aload_2
    //   363: invokevirtual 427	java/io/InputStream:close	()V
    //   366: aload 5
    //   368: areturn
    //   369: astore_0
    //   370: ldc 10
    //   372: ldc_w 430
    //   375: iconst_1
    //   376: anewarray 4	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload_0
    //   382: invokevirtual 433	java/io/IOException:getMessage	()Ljava/lang/String;
    //   385: aastore
    //   386: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: ldc 10
    //   391: aload_0
    //   392: ldc 133
    //   394: iconst_0
    //   395: anewarray 4	java/lang/Object
    //   398: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: aload 5
    //   403: areturn
    //   404: astore 6
    //   406: aconst_null
    //   407: astore_0
    //   408: aconst_null
    //   409: astore_2
    //   410: aconst_null
    //   411: astore 5
    //   413: aload_0
    //   414: astore 4
    //   416: aload_2
    //   417: astore_3
    //   418: ldc 10
    //   420: ldc_w 455
    //   423: iconst_1
    //   424: anewarray 4	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: aload 6
    //   431: invokevirtual 456	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   434: aastore
    //   435: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: aload_0
    //   439: astore 4
    //   441: aload_2
    //   442: astore_3
    //   443: ldc 10
    //   445: aload 6
    //   447: ldc 133
    //   449: iconst_0
    //   450: anewarray 4	java/lang/Object
    //   453: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: aload_0
    //   457: ifnull +10 -> 467
    //   460: aload_0
    //   461: getfield 411	com/tencent/mm/network/v:eOx	Ljavax/net/ssl/HttpsURLConnection;
    //   464: invokevirtual 424	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   467: aload_2
    //   468: ifnull +7 -> 475
    //   471: aload_2
    //   472: invokevirtual 427	java/io/InputStream:close	()V
    //   475: aload 7
    //   477: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   480: aload 5
    //   482: areturn
    //   483: astore_0
    //   484: ldc 10
    //   486: ldc_w 430
    //   489: iconst_1
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: aload_0
    //   496: invokevirtual 433	java/io/IOException:getMessage	()Ljava/lang/String;
    //   499: aastore
    //   500: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   503: ldc 10
    //   505: aload_0
    //   506: ldc 133
    //   508: iconst_0
    //   509: anewarray 4	java/lang/Object
    //   512: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: aload 5
    //   517: areturn
    //   518: astore_2
    //   519: aconst_null
    //   520: astore_0
    //   521: aconst_null
    //   522: astore_3
    //   523: aload_0
    //   524: ifnull +10 -> 534
    //   527: aload_0
    //   528: getfield 411	com/tencent/mm/network/v:eOx	Ljavax/net/ssl/HttpsURLConnection;
    //   531: invokevirtual 424	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   534: aload_3
    //   535: ifnull +7 -> 542
    //   538: aload_3
    //   539: invokevirtual 427	java/io/InputStream:close	()V
    //   542: aload 7
    //   544: invokevirtual 428	java/io/ByteArrayOutputStream:close	()V
    //   547: aload_2
    //   548: athrow
    //   549: astore_0
    //   550: ldc 10
    //   552: ldc_w 430
    //   555: iconst_1
    //   556: anewarray 4	java/lang/Object
    //   559: dup
    //   560: iconst_0
    //   561: aload_0
    //   562: invokevirtual 433	java/io/IOException:getMessage	()Ljava/lang/String;
    //   565: aastore
    //   566: invokestatic 421	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   569: ldc 10
    //   571: aload_0
    //   572: ldc 133
    //   574: iconst_0
    //   575: anewarray 4	java/lang/Object
    //   578: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   581: goto -34 -> 547
    //   584: astore_2
    //   585: aconst_null
    //   586: astore_3
    //   587: goto -64 -> 523
    //   590: astore_2
    //   591: aload 4
    //   593: astore_0
    //   594: goto -71 -> 523
    //   597: astore 6
    //   599: aconst_null
    //   600: astore_2
    //   601: aconst_null
    //   602: astore 5
    //   604: goto -191 -> 413
    //   607: astore 6
    //   609: aconst_null
    //   610: astore 5
    //   612: goto -199 -> 413
    //   615: astore 6
    //   617: goto -204 -> 413
    //   620: astore 6
    //   622: aconst_null
    //   623: astore_0
    //   624: aconst_null
    //   625: astore_2
    //   626: aconst_null
    //   627: astore 5
    //   629: goto -411 -> 218
    //   632: astore 6
    //   634: aconst_null
    //   635: astore_2
    //   636: aconst_null
    //   637: astore 5
    //   639: goto -421 -> 218
    //   642: astore 6
    //   644: goto -426 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	paramString	String
    //   190	17	1	i	int
    //   83	389	2	localInputStream1	java.io.InputStream
    //   518	30	2	localObject1	Object
    //   584	1	2	localObject2	Object
    //   590	1	2	localObject3	Object
    //   600	36	2	localObject4	Object
    //   92	495	3	localInputStream2	java.io.InputStream
    //   89	503	4	str	String
    //   39	599	5	localObject5	Object
    //   213	38	6	localIOException1	java.io.IOException
    //   404	42	6	localException1	Exception
    //   597	1	6	localException2	Exception
    //   607	1	6	localException3	Exception
    //   615	1	6	localException4	Exception
    //   620	1	6	localIOException2	java.io.IOException
    //   632	1	6	localIOException3	java.io.IOException
    //   642	1	6	localIOException4	java.io.IOException
    //   68	475	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   110	117	132	java/io/IOException
    //   121	125	132	java/io/IOException
    //   125	130	132	java/io/IOException
    //   93	110	213	java/io/IOException
    //   172	179	213	java/io/IOException
    //   184	191	213	java/io/IOException
    //   201	210	213	java/io/IOException
    //   328	338	213	java/io/IOException
    //   265	272	288	java/io/IOException
    //   276	280	288	java/io/IOException
    //   280	285	288	java/io/IOException
    //   348	355	369	java/io/IOException
    //   362	366	369	java/io/IOException
    //   70	76	404	java/lang/Exception
    //   460	467	483	java/io/IOException
    //   471	475	483	java/io/IOException
    //   475	480	483	java/io/IOException
    //   70	76	518	finally
    //   527	534	549	java/io/IOException
    //   538	542	549	java/io/IOException
    //   542	547	549	java/io/IOException
    //   76	84	584	finally
    //   93	110	590	finally
    //   172	179	590	finally
    //   184	191	590	finally
    //   201	210	590	finally
    //   223	243	590	finally
    //   248	261	590	finally
    //   328	338	590	finally
    //   343	348	590	finally
    //   418	438	590	finally
    //   443	456	590	finally
    //   76	84	597	java/lang/Exception
    //   93	110	607	java/lang/Exception
    //   172	179	607	java/lang/Exception
    //   184	191	607	java/lang/Exception
    //   201	210	607	java/lang/Exception
    //   328	338	607	java/lang/Exception
    //   343	348	615	java/lang/Exception
    //   70	76	620	java/io/IOException
    //   76	84	632	java/io/IOException
    //   343	348	642	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.i
 * JD-Core Version:    0.7.0.1
 */