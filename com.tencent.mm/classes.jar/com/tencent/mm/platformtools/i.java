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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
{
  private static String H(Context paramContext, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(124529);
    ab.i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", new Object[] { paramString });
    if (paramContext == null)
    {
      ab.e("MicroMsg.ContactsUtil", "context is null.");
      AppMethodBeat.o(124529);
      return null;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.ContactsUtil", "email is null.");
      AppMethodBeat.o(124529);
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
        ab.printErrStackTrace("MicroMsg.ContactsUtil", paramString, "getContactIdByEmail error", new Object[0]);
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
        if (!bo.isNullOrNil(paramContext))
        {
          paramString = paramContext;
          ab.i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", new Object[] { paramContext });
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
        AppMethodBeat.o(124529);
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
  public static String cp(Context paramContext)
  {
    AppMethodBeat.i(124530);
    ab.i("MicroMsg.ContactsUtil", "Get name of a contacts record or profile.");
    if (paramContext == null)
    {
      ab.e("MicroMsg.ContactsUtil", "context is null.");
      AppMethodBeat.o(124530);
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.ContactsUtil", "no contact permission");
      AppMethodBeat.o(124530);
      return null;
    }
    if (d.fv(14)) {
      ab.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
    }
    for (;;)
    {
      try
      {
        localObject = localContentResolver.query(ContactsContract.Profile.CONTENT_URI, new String[] { "display_name" }, null, null, null);
        if (localObject == null) {
          break label299;
        }
        if (((Cursor)localObject).moveToFirst())
        {
          String str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("display_name"));
          ab.i("MicroMsg.ContactsUtil", "Have got name from profile, name is %s", new Object[] { str1 });
          ((Cursor)localObject).close();
          localObject = str1;
          if (bo.isNullOrNil(str1))
          {
            paramContext = H(paramContext, w.cz(paramContext));
            if (bo.isNullOrNil(paramContext))
            {
              ab.i("MicroMsg.ContactsUtil", "contactId is null.");
              AppMethodBeat.o(124530);
              return null;
            }
          }
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.ContactsUtil", localException, "", new Object[0]);
        ab.d("MicroMsg.ContactsUtil", "query crashed");
        Object localObject = null;
        continue;
        paramContext = localContentResolver.query(ContactsContract.Data.CONTENT_URI, new String[] { "display_name" }, "contact_id=?", new String[] { paramContext }, null);
        localObject = localException;
        if (paramContext != null)
        {
          if (paramContext.moveToFirst())
          {
            str2 = paramContext.getString(paramContext.getColumnIndex("display_name"));
            ab.i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", new Object[] { str2 });
          }
          paramContext.close();
          localObject = str2;
        }
        AppMethodBeat.o(124530);
        return localObject;
      }
      String str2 = null;
      continue;
      label299:
      str2 = null;
    }
  }
  
  @TargetApi(14)
  public static Bitmap cq(Context paramContext)
  {
    AppMethodBeat.i(124531);
    ab.i("MicroMsg.ContactsUtil", "Get bitmap of a contacts record or profile.");
    if (paramContext == null)
    {
      ab.e("MicroMsg.ContactsUtil", "context is null.");
      AppMethodBeat.o(124531);
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Object localObject5 = null;
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.ContactsUtil", "no contact permission");
      AppMethodBeat.o(124531);
      return null;
    }
    Object localObject3 = null;
    Object localObject1 = localObject5;
    if (d.fv(14))
    {
      ab.i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
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
            break label508;
          }
          if (!((Cursor)localObject4).moveToFirst()) {
            break label1024;
          }
          if ((!at.isWifi(paramContext)) && (!at.is3G(paramContext)) && (!at.is4G(paramContext))) {
            break label417;
          }
          ab.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
          localObject1 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("data_sync1"));
          ab.i("MicroMsg.ContactsUtil", "get sync avatar url : [%s]", new Object[] { localObject1 });
          if (bo.isNullOrNil((String)localObject1)) {
            break label417;
          }
          i = ((String)localObject1).lastIndexOf("https:");
          ab.i("MicroMsg.ContactsUtil", "check is exist https download url :[%d]", new Object[] { Integer.valueOf(i) });
          if (i < 0) {
            break label417;
          }
          localObject3 = ((String)localObject1).substring(i);
          localObject1 = wu((String)localObject3);
          ab.i("MicroMsg.ContactsUtil", "Get image from google sync account in profile,url:[%s]", new Object[] { localObject3 });
          localObject3 = localObject1;
          if (localObject1 == null) {
            break label420;
          }
          localObject3 = localObject1;
          if (((Bitmap)localObject1).isRecycled()) {
            break label420;
          }
          ((Cursor)localObject4).close();
          AppMethodBeat.o(124531);
          return localObject1;
          localException1 = localException1;
          ab.printErrStackTrace("MicroMsg.ContactsUtil", localException1, "", new Object[0]);
          ab.d("MicroMsg.ContactsUtil", "query crashed");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.ContactsUtil", localException2, "", new Object[0]);
            ab.d("MicroMsg.ContactsUtil", "query crashed");
            localObject4 = localObject3;
          }
          localObject3 = null;
          i = ((Cursor)localObject4).getColumnIndex("data15");
          localObject2 = localObject3;
          if (i == -1) {
            break label501;
          }
          localObject5 = ((Cursor)localObject4).getBlob(i);
          ab.i("MicroMsg.ContactsUtil", "get bitmap data is null : [%b]", new Object[] { Boolean.valueOf(bo.ce((byte[])localObject5)) });
          localObject2 = localObject3;
          if (bo.ce((byte[])localObject5)) {
            break label501;
          }
          ab.i("MicroMsg.ContactsUtil", "Get image from profile personal icon.");
          localObject2 = BitmapFactory.decodeByteArray((byte[])localObject5, 0, localObject5.length);
        }
      }
      localObject1 = localObject5;
      if (localObject3 != null)
      {
        if (((Cursor)localObject3).getCount() <= 0) {
          break label557;
        }
        ((Cursor)localObject3).close();
      }
    }
    for (;;)
    {
      label417:
      label420:
      label501:
      ((Cursor)localObject4).close();
      for (;;)
      {
        label508:
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {
            break label873;
          }
        }
        localObject5 = H(paramContext, w.cz(paramContext));
        if (!bo.isNullOrNil((String)localObject5)) {
          break;
        }
        ab.i("MicroMsg.ContactsUtil", "contactId is null.");
        AppMethodBeat.o(124531);
        return null;
        label557:
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
          if ((!at.isWifi(paramContext)) && (!at.is3G(paramContext)))
          {
            localObject3 = localObject2;
            if (!at.is4G(paramContext)) {
              break label888;
            }
          }
          ab.i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
          localObject3 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("raw_contact_id"));
          localCursor = localContentResolver.query(ContactsContract.Data.CONTENT_URI, new String[] { "data15", "data_sync1" }, "mimetype=? AND raw_contact_id=?", new String[] { "vnd.android.cursor.item/photo", localObject3 }, null);
          localObject3 = localObject2;
          if (localCursor == null) {
            break label888;
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
              if (!bo.isNullOrNil(str))
              {
                i = str.lastIndexOf("https:");
                localObject3 = localObject2;
                if (i >= 0)
                {
                  str = str.substring(i);
                  localObject2 = wu(str);
                  localObject3 = localObject2;
                  if (localObject2 != null)
                  {
                    localObject3 = localObject2;
                    if (!((Bitmap)localObject2).isRecycled())
                    {
                      ab.i("MicroMsg.ContactsUtil", "Get image from google sync account in contacts,url:[%s]", new Object[] { str });
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
          label866:
          ((Cursor)localObject4).close();
        }
      }
      else
      {
        label873:
        AppMethodBeat.o(124531);
        return localObject3;
      }
      localCursor.close();
      label888:
      ab.i("MicroMsg.ContactsUtil", "Get bitmap from contacts icon.");
      int i = ((Cursor)localObject4).getColumnIndex("photo_id");
      long l;
      if (i != -1)
      {
        l = ((Cursor)localObject4).getLong(i);
        ab.i("MicroMsg.ContactsUtil", "Have got photoId,photoId is ".concat(String.valueOf(l)));
      }
      for (;;)
      {
        if (l > 0L)
        {
          localObject3 = BitmapFactory.decodeStream(ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, bo.getLong((String)localObject5, 0L))));
          localObject2 = localObject3;
          if (localObject3 == null) {
            break label999;
          }
          localObject2 = localObject3;
          if (((Bitmap)localObject3).isRecycled()) {
            break label999;
          }
          ab.i("MicroMsg.ContactsUtil", "Get image from contacts through google account.");
          break label866;
        }
        localObject2 = localObject3;
        label999:
        if (!((Cursor)localObject4).moveToNext())
        {
          localObject3 = localObject2;
          break label866;
        }
        break;
        l = 0L;
      }
      label1024:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  @TargetApi(14)
  public static String getPhoneNum(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 298
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 17
    //   8: ldc_w 300
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: ifnonnull +19 -> 42
    //   26: ldc 17
    //   28: ldc_w 302
    //   31: invokestatic 30	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: ldc_w 298
    //   37: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aconst_null
    //   41: areturn
    //   42: aload_0
    //   43: ldc_w 304
    //   46: invokevirtual 308	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   49: checkcast 310	android/telephony/TelephonyManager
    //   52: astore 7
    //   54: aconst_null
    //   55: astore_1
    //   56: aload 7
    //   58: invokevirtual 314	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: astore_1
    //   66: aload 7
    //   68: invokevirtual 317	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   71: astore 6
    //   73: aload 6
    //   75: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   78: ifeq +1455 -> 1533
    //   81: aload 7
    //   83: invokevirtual 320	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
    //   86: astore_1
    //   87: aload_1
    //   88: astore 6
    //   90: aload_1
    //   91: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   94: ifeq +11 -> 105
    //   97: invokestatic 326	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   100: invokevirtual 329	java/util/Locale:getCountry	()Ljava/lang/String;
    //   103: astore 6
    //   105: aload 6
    //   107: astore 9
    //   109: aload 5
    //   111: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   114: ifne +148 -> 262
    //   117: aload 5
    //   119: invokevirtual 332	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore_0
    //   123: aload_0
    //   124: aload 9
    //   126: invokestatic 338	com/tencent/mm/sdk/platformtools/av:if	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_1
    //   130: ldc 17
    //   132: ldc_w 340
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: aload_1
    //   146: aastore
    //   147: dup
    //   148: iconst_2
    //   149: aload 9
    //   151: aastore
    //   152: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_1
    //   156: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   159: ifne +1371 -> 1530
    //   162: aload_1
    //   163: invokevirtual 343	java/lang/String:length	()I
    //   166: istore_3
    //   167: aload_0
    //   168: ldc_w 345
    //   171: invokevirtual 348	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   174: ifeq +83 -> 257
    //   177: iconst_1
    //   178: istore_2
    //   179: aload_0
    //   180: iload_2
    //   181: iload_3
    //   182: iadd
    //   183: invokevirtual 214	java/lang/String:substring	(I)Ljava/lang/String;
    //   186: astore_0
    //   187: ldc 17
    //   189: ldc_w 350
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_0
    //   199: aastore
    //   200: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: ldc 17
    //   205: ldc_w 352
    //   208: invokestatic 43	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: ldc_w 298
    //   214: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_0
    //   218: areturn
    //   219: astore 6
    //   221: aconst_null
    //   222: astore 7
    //   224: aload_1
    //   225: astore 5
    //   227: aload 7
    //   229: astore_1
    //   230: ldc 17
    //   232: aload 6
    //   234: ldc 142
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: ldc 17
    //   245: ldc_w 354
    //   248: invokestatic 30	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_1
    //   252: astore 9
    //   254: goto -145 -> 109
    //   257: iconst_0
    //   258: istore_2
    //   259: goto -80 -> 179
    //   262: aload_0
    //   263: ldc 109
    //   265: invokestatic 114	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   268: ifne +18 -> 286
    //   271: ldc 17
    //   273: ldc 116
    //   275: invokestatic 30	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: ldc_w 298
    //   281: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: aconst_null
    //   285: areturn
    //   286: aload_0
    //   287: invokevirtual 49	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   290: astore 11
    //   292: aconst_null
    //   293: astore 6
    //   295: aconst_null
    //   296: astore 10
    //   298: aconst_null
    //   299: astore 5
    //   301: aconst_null
    //   302: astore 8
    //   304: aconst_null
    //   305: astore 7
    //   307: aload 8
    //   309: astore_1
    //   310: bipush 14
    //   312: invokestatic 357	com/tencent/mm/compatible/util/d:fw	(I)Z
    //   315: ifne +323 -> 638
    //   318: ldc 17
    //   320: ldc_w 359
    //   323: invokestatic 43	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 10
    //   328: astore 5
    //   330: aload 11
    //   332: getstatic 127	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   335: iconst_1
    //   336: anewarray 57	java/lang/String
    //   339: dup
    //   340: iconst_0
    //   341: ldc_w 361
    //   344: aastore
    //   345: aconst_null
    //   346: aconst_null
    //   347: aconst_null
    //   348: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   351: astore_1
    //   352: aload_1
    //   353: ifnull +1172 -> 1525
    //   356: aload_1
    //   357: astore 6
    //   359: aload_1
    //   360: astore 5
    //   362: aload_1
    //   363: invokeinterface 75 1 0
    //   368: ifeq +1157 -> 1525
    //   371: aload_1
    //   372: astore 6
    //   374: aload_1
    //   375: astore 5
    //   377: aload_1
    //   378: ldc_w 361
    //   381: invokeinterface 79 2 0
    //   386: istore_2
    //   387: iload_2
    //   388: iconst_m1
    //   389: if_icmpeq +1136 -> 1525
    //   392: aload_1
    //   393: astore 6
    //   395: aload_1
    //   396: astore 5
    //   398: aload_1
    //   399: iload_2
    //   400: invokeinterface 365 2 0
    //   405: istore_2
    //   406: aload_1
    //   407: astore 5
    //   409: ldc 17
    //   411: ldc_w 367
    //   414: iload_2
    //   415: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   418: invokevirtual 274	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   421: invokestatic 43	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: iload_2
    //   425: istore_3
    //   426: aload_1
    //   427: astore 6
    //   429: aload_1
    //   430: ifnull +28 -> 458
    //   433: iload_2
    //   434: istore_3
    //   435: aload_1
    //   436: astore 6
    //   438: aload_1
    //   439: invokeinterface 372 1 0
    //   444: ifne +14 -> 458
    //   447: aload_1
    //   448: invokeinterface 89 1 0
    //   453: aload_1
    //   454: astore 6
    //   456: iload_2
    //   457: istore_3
    //   458: aload 8
    //   460: astore_1
    //   461: aload 6
    //   463: astore 5
    //   465: iload_3
    //   466: ifle +172 -> 638
    //   469: aload 11
    //   471: getstatic 127	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   474: ldc 168
    //   476: invokestatic 174	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   479: iconst_1
    //   480: anewarray 57	java/lang/String
    //   483: dup
    //   484: iconst_0
    //   485: ldc 61
    //   487: aastore
    //   488: ldc 180
    //   490: iconst_1
    //   491: anewarray 57	java/lang/String
    //   494: dup
    //   495: iconst_0
    //   496: ldc_w 374
    //   499: aastore
    //   500: aconst_null
    //   501: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   504: astore_1
    //   505: aload_1
    //   506: ifnull +1013 -> 1519
    //   509: aload 7
    //   511: astore 5
    //   513: aload_1
    //   514: astore 6
    //   516: aload_1
    //   517: invokeinterface 75 1 0
    //   522: ifeq +60 -> 582
    //   525: aload_1
    //   526: astore 6
    //   528: aload_1
    //   529: ldc 61
    //   531: invokeinterface 79 2 0
    //   536: istore_2
    //   537: aload 7
    //   539: astore 5
    //   541: iload_2
    //   542: iconst_m1
    //   543: if_icmpeq +39 -> 582
    //   546: aload_1
    //   547: astore 6
    //   549: aload_1
    //   550: iload_2
    //   551: invokeinterface 83 2 0
    //   556: astore 5
    //   558: aload_1
    //   559: astore 6
    //   561: aload 5
    //   563: astore 7
    //   565: ldc 17
    //   567: ldc_w 376
    //   570: iconst_1
    //   571: anewarray 4	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: aload 5
    //   578: aastore
    //   579: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: aload_1
    //   583: astore 6
    //   585: aload 5
    //   587: astore 7
    //   589: aload_1
    //   590: invokeinterface 89 1 0
    //   595: aload 5
    //   597: astore 7
    //   599: aload_1
    //   600: astore 6
    //   602: aload_1
    //   603: ifnull +906 -> 1509
    //   606: aload 5
    //   608: astore 7
    //   610: aload_1
    //   611: astore 6
    //   613: aload_1
    //   614: invokeinterface 372 1 0
    //   619: ifne +890 -> 1509
    //   622: aload_1
    //   623: invokeinterface 89 1 0
    //   628: aload 5
    //   630: astore 6
    //   632: aload_1
    //   633: astore 5
    //   635: aload 6
    //   637: astore_1
    //   638: aload_1
    //   639: astore 6
    //   641: aload_1
    //   642: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   645: ifeq +293 -> 938
    //   648: aload_0
    //   649: aload_0
    //   650: invokestatic 136	com/tencent/mm/platformtools/w:cz	(Landroid/content/Context;)Ljava/lang/String;
    //   653: invokestatic 138	com/tencent/mm/platformtools/i:H	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   656: astore 8
    //   658: aload_1
    //   659: astore 6
    //   661: aload 8
    //   663: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   666: ifne +272 -> 938
    //   669: aload 11
    //   671: getstatic 277	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   674: iconst_1
    //   675: anewarray 57	java/lang/String
    //   678: dup
    //   679: iconst_0
    //   680: ldc_w 361
    //   683: aastore
    //   684: ldc_w 378
    //   687: iconst_1
    //   688: anewarray 57	java/lang/String
    //   691: dup
    //   692: iconst_0
    //   693: aload 8
    //   695: aastore
    //   696: aconst_null
    //   697: invokevirtual 69	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   700: astore_0
    //   701: aload_0
    //   702: ifnull +802 -> 1504
    //   705: aload_0
    //   706: astore 5
    //   708: aload_0
    //   709: invokeinterface 75 1 0
    //   714: ifeq +790 -> 1504
    //   717: aload_0
    //   718: astore 5
    //   720: aload_0
    //   721: aload_0
    //   722: ldc_w 361
    //   725: invokeinterface 79 2 0
    //   730: invokeinterface 365 2 0
    //   735: istore_2
    //   736: aload_0
    //   737: ifnull +764 -> 1501
    //   740: aload_0
    //   741: invokeinterface 89 1 0
    //   746: ldc 17
    //   748: ldc_w 367
    //   751: iload_2
    //   752: invokestatic 369	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   755: invokevirtual 274	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   758: invokestatic 43	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   761: aload_1
    //   762: astore 6
    //   764: iload_2
    //   765: ifle +173 -> 938
    //   768: aload_1
    //   769: astore 5
    //   771: aload_0
    //   772: astore 7
    //   774: aload 11
    //   776: getstatic 251	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   779: iconst_2
    //   780: anewarray 57	java/lang/String
    //   783: dup
    //   784: iconst_0
    //   785: ldc 61
    //   787: aastore
    //   788: dup
    //   789: iconst_1
    //   790: ldc_w 380
    //   793: aastore
    //   794: ldc_w 382
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
    //   817: ifnull +101 -> 918
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
    //   840: ifeq +78 -> 918
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
    //   884: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   887: ifne +446 -> 1333
    //   890: aload 8
    //   892: astore 5
    //   894: aload 10
    //   896: astore 7
    //   898: aload 10
    //   900: astore_0
    //   901: ldc 17
    //   903: ldc_w 384
    //   906: iconst_1
    //   907: anewarray 4	java/lang/Object
    //   910: dup
    //   911: iconst_0
    //   912: aload 8
    //   914: aastore
    //   915: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   918: aload 8
    //   920: astore 6
    //   922: aload 10
    //   924: ifnull +14 -> 938
    //   927: aload 10
    //   929: invokeinterface 89 1 0
    //   934: aload 8
    //   936: astore 6
    //   938: aload 6
    //   940: astore_1
    //   941: aload 6
    //   943: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   946: ifne +106 -> 1052
    //   949: aload 6
    //   951: aload 9
    //   953: invokestatic 338	com/tencent/mm/sdk/platformtools/av:if	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   956: astore 5
    //   958: ldc 17
    //   960: ldc_w 386
    //   963: iconst_3
    //   964: anewarray 4	java/lang/Object
    //   967: dup
    //   968: iconst_0
    //   969: aload 6
    //   971: aastore
    //   972: dup
    //   973: iconst_1
    //   974: aload 5
    //   976: aastore
    //   977: dup
    //   978: iconst_2
    //   979: aload 9
    //   981: aastore
    //   982: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   985: aload 6
    //   987: astore_1
    //   988: aload 5
    //   990: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   993: ifne +43 -> 1036
    //   996: aload 6
    //   998: ldc_w 345
    //   1001: invokevirtual 348	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1004: ifeq +418 -> 1422
    //   1007: ldc_w 345
    //   1010: aload 5
    //   1012: invokestatic 389	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1015: invokevirtual 274	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: astore_0
    //   1019: aload 6
    //   1021: astore_1
    //   1022: aload_0
    //   1023: ifnull +13 -> 1036
    //   1026: aload 6
    //   1028: aload_0
    //   1029: invokevirtual 343	java/lang/String:length	()I
    //   1032: invokevirtual 214	java/lang/String:substring	(I)Ljava/lang/String;
    //   1035: astore_1
    //   1036: ldc 17
    //   1038: ldc_w 391
    //   1041: iconst_1
    //   1042: anewarray 4	java/lang/Object
    //   1045: dup
    //   1046: iconst_0
    //   1047: aload_1
    //   1048: aastore
    //   1049: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1052: ldc_w 298
    //   1055: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1058: aload_1
    //   1059: areturn
    //   1060: astore 5
    //   1062: iconst_0
    //   1063: istore_2
    //   1064: aload 6
    //   1066: astore_1
    //   1067: aload 5
    //   1069: astore 6
    //   1071: aload_1
    //   1072: astore 5
    //   1074: ldc 17
    //   1076: aload 6
    //   1078: ldc 142
    //   1080: iconst_0
    //   1081: anewarray 4	java/lang/Object
    //   1084: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1087: aload_1
    //   1088: astore 5
    //   1090: ldc 17
    //   1092: ldc 144
    //   1094: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1097: iload_2
    //   1098: istore_3
    //   1099: aload_1
    //   1100: astore 6
    //   1102: aload_1
    //   1103: ifnull -645 -> 458
    //   1106: iload_2
    //   1107: istore_3
    //   1108: aload_1
    //   1109: astore 6
    //   1111: aload_1
    //   1112: invokeinterface 372 1 0
    //   1117: ifne -659 -> 458
    //   1120: aload_1
    //   1121: invokeinterface 89 1 0
    //   1126: iload_2
    //   1127: istore_3
    //   1128: aload_1
    //   1129: astore 6
    //   1131: goto -673 -> 458
    //   1134: astore_0
    //   1135: aload 5
    //   1137: ifnull +20 -> 1157
    //   1140: aload 5
    //   1142: invokeinterface 372 1 0
    //   1147: ifne +10 -> 1157
    //   1150: aload 5
    //   1152: invokeinterface 89 1 0
    //   1157: ldc_w 298
    //   1160: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: aload_0
    //   1164: athrow
    //   1165: astore 7
    //   1167: aconst_null
    //   1168: astore 5
    //   1170: aload 6
    //   1172: astore_1
    //   1173: aload_1
    //   1174: astore 6
    //   1176: ldc 17
    //   1178: aload 7
    //   1180: ldc 142
    //   1182: iconst_0
    //   1183: anewarray 4	java/lang/Object
    //   1186: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1189: aload_1
    //   1190: astore 6
    //   1192: ldc 17
    //   1194: ldc 144
    //   1196: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1199: aload 5
    //   1201: astore 7
    //   1203: aload_1
    //   1204: astore 6
    //   1206: aload_1
    //   1207: ifnull +302 -> 1509
    //   1210: aload 5
    //   1212: astore 7
    //   1214: aload_1
    //   1215: astore 6
    //   1217: aload_1
    //   1218: invokeinterface 372 1 0
    //   1223: ifne +286 -> 1509
    //   1226: aload_1
    //   1227: invokeinterface 89 1 0
    //   1232: aload_1
    //   1233: astore 6
    //   1235: aload 5
    //   1237: astore_1
    //   1238: aload 6
    //   1240: astore 5
    //   1242: goto -604 -> 638
    //   1245: astore_0
    //   1246: aload 6
    //   1248: ifnull +20 -> 1268
    //   1251: aload 6
    //   1253: invokeinterface 372 1 0
    //   1258: ifne +10 -> 1268
    //   1261: aload 6
    //   1263: invokeinterface 89 1 0
    //   1268: ldc_w 298
    //   1271: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1274: aload_0
    //   1275: athrow
    //   1276: astore 6
    //   1278: aload 5
    //   1280: astore_0
    //   1281: aload_0
    //   1282: astore 5
    //   1284: ldc 17
    //   1286: aload 6
    //   1288: ldc 142
    //   1290: iconst_0
    //   1291: anewarray 4	java/lang/Object
    //   1294: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1297: aload_0
    //   1298: ifnull +198 -> 1496
    //   1301: aload_0
    //   1302: invokeinterface 89 1 0
    //   1307: iconst_0
    //   1308: istore_2
    //   1309: goto -563 -> 746
    //   1312: astore_0
    //   1313: aload 5
    //   1315: ifnull +10 -> 1325
    //   1318: aload 5
    //   1320: invokeinterface 89 1 0
    //   1325: ldc_w 298
    //   1328: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1331: aload_0
    //   1332: athrow
    //   1333: aload 8
    //   1335: astore 5
    //   1337: aload 10
    //   1339: astore 7
    //   1341: aload 10
    //   1343: astore_0
    //   1344: aload 10
    //   1346: invokeinterface 92 1 0
    //   1351: istore 4
    //   1353: aload 8
    //   1355: astore_1
    //   1356: iload 4
    //   1358: ifne -515 -> 843
    //   1361: goto -443 -> 918
    //   1364: astore_1
    //   1365: aload 7
    //   1367: astore_0
    //   1368: ldc 17
    //   1370: aload_1
    //   1371: ldc 142
    //   1373: iconst_0
    //   1374: anewarray 4	java/lang/Object
    //   1377: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1380: aload 5
    //   1382: astore 6
    //   1384: aload 7
    //   1386: ifnull -448 -> 938
    //   1389: aload 7
    //   1391: invokeinterface 89 1 0
    //   1396: aload 5
    //   1398: astore 6
    //   1400: goto -462 -> 938
    //   1403: astore_1
    //   1404: aload_0
    //   1405: ifnull +9 -> 1414
    //   1408: aload_0
    //   1409: invokeinterface 89 1 0
    //   1414: ldc_w 298
    //   1417: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1420: aload_1
    //   1421: athrow
    //   1422: aload 5
    //   1424: astore_0
    //   1425: aload 6
    //   1427: aload 5
    //   1429: invokevirtual 348	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1432: ifne -413 -> 1019
    //   1435: aconst_null
    //   1436: astore_0
    //   1437: goto -418 -> 1019
    //   1440: astore_0
    //   1441: goto -128 -> 1313
    //   1444: astore 6
    //   1446: goto -165 -> 1281
    //   1449: astore_0
    //   1450: goto -204 -> 1246
    //   1453: astore 7
    //   1455: aconst_null
    //   1456: astore 5
    //   1458: goto -285 -> 1173
    //   1461: astore 6
    //   1463: aload 7
    //   1465: astore 5
    //   1467: aload 6
    //   1469: astore 7
    //   1471: goto -298 -> 1173
    //   1474: astore 6
    //   1476: goto -405 -> 1071
    //   1479: astore 7
    //   1481: aload 6
    //   1483: astore_1
    //   1484: aload 7
    //   1486: astore 6
    //   1488: goto -1258 -> 230
    //   1491: astore 6
    //   1493: goto -1263 -> 230
    //   1496: iconst_0
    //   1497: istore_2
    //   1498: goto -752 -> 746
    //   1501: goto -755 -> 746
    //   1504: iconst_0
    //   1505: istore_2
    //   1506: goto -770 -> 736
    //   1509: aload 7
    //   1511: astore_1
    //   1512: aload 6
    //   1514: astore 5
    //   1516: goto -878 -> 638
    //   1519: aconst_null
    //   1520: astore 5
    //   1522: goto -927 -> 595
    //   1525: iconst_0
    //   1526: istore_2
    //   1527: goto -1121 -> 406
    //   1530: goto -1327 -> 203
    //   1533: aload 6
    //   1535: astore_1
    //   1536: goto -1449 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1539	0	paramContext	Context
    //   0	1539	1	paramString	String
    //   178	1349	2	i	int
    //   166	962	3	j	int
    //   1351	6	4	bool	boolean
    //   61	950	5	localObject1	Object
    //   1060	8	5	localException1	Exception
    //   1072	449	5	localObject2	Object
    //   71	35	6	str1	String
    //   219	14	6	localException2	Exception
    //   293	969	6	localObject3	Object
    //   1276	11	6	localException3	Exception
    //   1382	44	6	localObject4	Object
    //   1444	1	6	localException4	Exception
    //   1461	7	6	localException5	Exception
    //   1474	8	6	localException6	Exception
    //   1486	1	6	localException7	Exception
    //   1491	43	6	localException8	Exception
    //   52	845	7	localObject5	Object
    //   1165	14	7	localException9	Exception
    //   1201	189	7	localObject6	Object
    //   1453	11	7	localException10	Exception
    //   1469	1	7	localObject7	Object
    //   1479	31	7	localException11	Exception
    //   302	1052	8	str2	String
    //   107	873	9	str3	String
    //   296	1049	10	localCursor	Cursor
    //   290	485	11	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   56	63	219	java/lang/Exception
    //   66	73	219	java/lang/Exception
    //   330	352	1060	java/lang/Exception
    //   362	371	1060	java/lang/Exception
    //   377	387	1060	java/lang/Exception
    //   398	406	1060	java/lang/Exception
    //   330	352	1134	finally
    //   362	371	1134	finally
    //   377	387	1134	finally
    //   398	406	1134	finally
    //   409	424	1134	finally
    //   1074	1087	1134	finally
    //   1090	1097	1134	finally
    //   469	505	1165	java/lang/Exception
    //   469	505	1245	finally
    //   669	701	1276	java/lang/Exception
    //   669	701	1312	finally
    //   774	812	1364	java/lang/Exception
    //   833	843	1364	java/lang/Exception
    //   853	871	1364	java/lang/Exception
    //   882	890	1364	java/lang/Exception
    //   901	918	1364	java/lang/Exception
    //   1344	1353	1364	java/lang/Exception
    //   774	812	1403	finally
    //   833	843	1403	finally
    //   853	871	1403	finally
    //   882	890	1403	finally
    //   901	918	1403	finally
    //   1344	1353	1403	finally
    //   1368	1380	1403	finally
    //   708	717	1440	finally
    //   720	736	1440	finally
    //   1284	1297	1440	finally
    //   708	717	1444	java/lang/Exception
    //   720	736	1444	java/lang/Exception
    //   516	525	1449	finally
    //   528	537	1449	finally
    //   549	558	1449	finally
    //   565	582	1449	finally
    //   589	595	1449	finally
    //   1176	1189	1449	finally
    //   1192	1199	1449	finally
    //   516	525	1453	java/lang/Exception
    //   528	537	1453	java/lang/Exception
    //   549	558	1453	java/lang/Exception
    //   565	582	1461	java/lang/Exception
    //   589	595	1461	java/lang/Exception
    //   409	424	1474	java/lang/Exception
    //   73	87	1479	java/lang/Exception
    //   90	105	1491	java/lang/Exception
  }
  
  /* Error */
  private static Bitmap wu(String paramString)
  {
    // Byte code:
    //   0: ldc_w 394
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 17
    //   8: ldc_w 396
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 24	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: invokestatic 39	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   26: ifeq +19 -> 45
    //   29: ldc 17
    //   31: ldc_w 398
    //   34: invokestatic 30	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc_w 394
    //   40: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aconst_null
    //   44: areturn
    //   45: aload_0
    //   46: invokevirtual 332	java/lang/String:trim	()Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ldc 200
    //   53: invokevirtual 348	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   56: ifne +19 -> 75
    //   59: ldc 17
    //   61: ldc_w 400
    //   64: invokestatic 30	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc_w 394
    //   70: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: new 402	java/io/ByteArrayOutputStream
    //   78: dup
    //   79: invokespecial 405	java/io/ByteArrayOutputStream:<init>	()V
    //   82: astore 7
    //   84: aload_2
    //   85: invokestatic 411	com/tencent/mm/network/b:wb	(Ljava/lang/String;)Lcom/tencent/mm/network/w;
    //   88: astore_0
    //   89: aload_0
    //   90: getfield 417	com/tencent/mm/network/w:gel	Ljavax/net/ssl/HttpsURLConnection;
    //   93: invokevirtual 423	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   96: astore_3
    //   97: aload_3
    //   98: ifnonnull +85 -> 183
    //   101: aload_0
    //   102: astore 5
    //   104: aload_3
    //   105: astore 4
    //   107: ldc 17
    //   109: ldc_w 425
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload_2
    //   119: aastore
    //   120: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_0
    //   124: invokevirtual 430	com/tencent/mm/network/w:disconnect	()V
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 433	java/io/InputStream:close	()V
    //   135: aload 7
    //   137: invokevirtual 434	java/io/ByteArrayOutputStream:close	()V
    //   140: ldc_w 394
    //   143: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: ldc 17
    //   151: ldc_w 436
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: ldc 17
    //   170: aload_0
    //   171: ldc 142
    //   173: iconst_0
    //   174: anewarray 4	java/lang/Object
    //   177: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: goto -40 -> 140
    //   183: aload_0
    //   184: astore 5
    //   186: aload_3
    //   187: astore 4
    //   189: sipush 1024
    //   192: newarray byte
    //   194: astore_2
    //   195: aload_0
    //   196: astore 5
    //   198: aload_3
    //   199: astore 4
    //   201: aload_3
    //   202: aload_2
    //   203: invokevirtual 443	java/io/InputStream:read	([B)I
    //   206: istore_1
    //   207: iload_1
    //   208: iconst_m1
    //   209: if_icmpeq +100 -> 309
    //   212: aload_0
    //   213: astore 5
    //   215: aload_3
    //   216: astore 4
    //   218: aload 7
    //   220: aload_2
    //   221: iconst_0
    //   222: iload_1
    //   223: invokevirtual 447	java/io/ByteArrayOutputStream:write	([BII)V
    //   226: goto -31 -> 195
    //   229: astore 6
    //   231: aconst_null
    //   232: astore_2
    //   233: aload_0
    //   234: astore 5
    //   236: aload_3
    //   237: astore 4
    //   239: ldc 17
    //   241: ldc_w 449
    //   244: iconst_1
    //   245: anewarray 4	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload 6
    //   252: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   255: aastore
    //   256: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   259: aload_0
    //   260: astore 5
    //   262: aload_3
    //   263: astore 4
    //   265: ldc 17
    //   267: aload 6
    //   269: ldc 142
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 430	com/tencent/mm/network/w:disconnect	()V
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 433	java/io/InputStream:close	()V
    //   294: aload 7
    //   296: invokevirtual 434	java/io/ByteArrayOutputStream:close	()V
    //   299: aload_2
    //   300: astore_0
    //   301: ldc_w 394
    //   304: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_0
    //   308: areturn
    //   309: aload_0
    //   310: astore 5
    //   312: aload_3
    //   313: astore 4
    //   315: aload 7
    //   317: invokevirtual 453	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   320: invokestatic 459	com/tencent/mm/sdk/platformtools/d:bT	([B)Landroid/graphics/Bitmap;
    //   323: astore_2
    //   324: aload_0
    //   325: astore 5
    //   327: aload_3
    //   328: astore 4
    //   330: aload 7
    //   332: invokevirtual 434	java/io/ByteArrayOutputStream:close	()V
    //   335: aload_0
    //   336: invokevirtual 430	com/tencent/mm/network/w:disconnect	()V
    //   339: aload_2
    //   340: astore_0
    //   341: aload_3
    //   342: ifnull -41 -> 301
    //   345: aload_3
    //   346: invokevirtual 433	java/io/InputStream:close	()V
    //   349: aload_2
    //   350: astore_0
    //   351: goto -50 -> 301
    //   354: astore_0
    //   355: ldc 17
    //   357: ldc_w 436
    //   360: iconst_1
    //   361: anewarray 4	java/lang/Object
    //   364: dup
    //   365: iconst_0
    //   366: aload_0
    //   367: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   370: aastore
    //   371: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: ldc 17
    //   376: aload_0
    //   377: ldc 142
    //   379: iconst_0
    //   380: anewarray 4	java/lang/Object
    //   383: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: aload_2
    //   387: astore_0
    //   388: goto -87 -> 301
    //   391: astore_0
    //   392: ldc 17
    //   394: ldc_w 436
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload_0
    //   404: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   407: aastore
    //   408: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: ldc 17
    //   413: aload_0
    //   414: ldc 142
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: aload_2
    //   424: astore_0
    //   425: goto -124 -> 301
    //   428: astore 6
    //   430: aconst_null
    //   431: astore_0
    //   432: aconst_null
    //   433: astore_3
    //   434: aconst_null
    //   435: astore_2
    //   436: aload_0
    //   437: astore 5
    //   439: aload_3
    //   440: astore 4
    //   442: ldc 17
    //   444: ldc_w 461
    //   447: iconst_1
    //   448: anewarray 4	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: aload 6
    //   455: invokevirtual 462	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   458: aastore
    //   459: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: aload_0
    //   463: astore 5
    //   465: aload_3
    //   466: astore 4
    //   468: ldc 17
    //   470: aload 6
    //   472: ldc 142
    //   474: iconst_0
    //   475: anewarray 4	java/lang/Object
    //   478: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: aload_0
    //   482: ifnull +7 -> 489
    //   485: aload_0
    //   486: invokevirtual 430	com/tencent/mm/network/w:disconnect	()V
    //   489: aload_3
    //   490: ifnull +7 -> 497
    //   493: aload_3
    //   494: invokevirtual 433	java/io/InputStream:close	()V
    //   497: aload 7
    //   499: invokevirtual 434	java/io/ByteArrayOutputStream:close	()V
    //   502: aload_2
    //   503: astore_0
    //   504: goto -203 -> 301
    //   507: astore_0
    //   508: ldc 17
    //   510: ldc_w 436
    //   513: iconst_1
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: aload_0
    //   520: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   523: aastore
    //   524: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   527: ldc 17
    //   529: aload_0
    //   530: ldc 142
    //   532: iconst_0
    //   533: anewarray 4	java/lang/Object
    //   536: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   539: aload_2
    //   540: astore_0
    //   541: goto -240 -> 301
    //   544: astore_2
    //   545: aconst_null
    //   546: astore_0
    //   547: aconst_null
    //   548: astore 4
    //   550: aload_0
    //   551: ifnull +7 -> 558
    //   554: aload_0
    //   555: invokevirtual 430	com/tencent/mm/network/w:disconnect	()V
    //   558: aload 4
    //   560: ifnull +8 -> 568
    //   563: aload 4
    //   565: invokevirtual 433	java/io/InputStream:close	()V
    //   568: aload 7
    //   570: invokevirtual 434	java/io/ByteArrayOutputStream:close	()V
    //   573: ldc_w 394
    //   576: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   579: aload_2
    //   580: athrow
    //   581: astore_0
    //   582: ldc 17
    //   584: ldc_w 436
    //   587: iconst_1
    //   588: anewarray 4	java/lang/Object
    //   591: dup
    //   592: iconst_0
    //   593: aload_0
    //   594: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   597: aastore
    //   598: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   601: ldc 17
    //   603: aload_0
    //   604: ldc 142
    //   606: iconst_0
    //   607: anewarray 4	java/lang/Object
    //   610: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   613: goto -40 -> 573
    //   616: astore_2
    //   617: aconst_null
    //   618: astore 4
    //   620: goto -70 -> 550
    //   623: astore_2
    //   624: aload 5
    //   626: astore_0
    //   627: goto -77 -> 550
    //   630: astore 6
    //   632: aconst_null
    //   633: astore_3
    //   634: aconst_null
    //   635: astore_2
    //   636: goto -200 -> 436
    //   639: astore 6
    //   641: aconst_null
    //   642: astore_2
    //   643: goto -207 -> 436
    //   646: astore 6
    //   648: goto -212 -> 436
    //   651: astore 6
    //   653: aconst_null
    //   654: astore_0
    //   655: aconst_null
    //   656: astore_3
    //   657: aconst_null
    //   658: astore_2
    //   659: goto -426 -> 233
    //   662: astore 6
    //   664: aconst_null
    //   665: astore_3
    //   666: aconst_null
    //   667: astore_2
    //   668: goto -435 -> 233
    //   671: astore 6
    //   673: goto -440 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	676	0	paramString	String
    //   206	17	1	i	int
    //   49	491	2	localObject1	Object
    //   544	36	2	localObject2	Object
    //   616	1	2	localObject3	Object
    //   623	1	2	localObject4	Object
    //   635	33	2	localObject5	Object
    //   96	570	3	localInputStream1	java.io.InputStream
    //   105	514	4	localInputStream2	java.io.InputStream
    //   102	523	5	str	String
    //   229	39	6	localIOException1	java.io.IOException
    //   428	43	6	localException1	Exception
    //   630	1	6	localException2	Exception
    //   639	1	6	localException3	Exception
    //   646	1	6	localException4	Exception
    //   651	1	6	localIOException2	java.io.IOException
    //   662	1	6	localIOException3	java.io.IOException
    //   671	1	6	localIOException4	java.io.IOException
    //   82	487	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   123	127	148	java/io/IOException
    //   131	135	148	java/io/IOException
    //   135	140	148	java/io/IOException
    //   107	123	229	java/io/IOException
    //   189	195	229	java/io/IOException
    //   201	207	229	java/io/IOException
    //   218	226	229	java/io/IOException
    //   315	324	229	java/io/IOException
    //   335	339	354	java/io/IOException
    //   345	349	354	java/io/IOException
    //   282	286	391	java/io/IOException
    //   290	294	391	java/io/IOException
    //   294	299	391	java/io/IOException
    //   84	89	428	java/lang/Exception
    //   485	489	507	java/io/IOException
    //   493	497	507	java/io/IOException
    //   497	502	507	java/io/IOException
    //   84	89	544	finally
    //   554	558	581	java/io/IOException
    //   563	568	581	java/io/IOException
    //   568	573	581	java/io/IOException
    //   89	97	616	finally
    //   107	123	623	finally
    //   189	195	623	finally
    //   201	207	623	finally
    //   218	226	623	finally
    //   239	259	623	finally
    //   265	278	623	finally
    //   315	324	623	finally
    //   330	335	623	finally
    //   442	462	623	finally
    //   468	481	623	finally
    //   89	97	630	java/lang/Exception
    //   107	123	639	java/lang/Exception
    //   189	195	639	java/lang/Exception
    //   201	207	639	java/lang/Exception
    //   218	226	639	java/lang/Exception
    //   315	324	639	java/lang/Exception
    //   330	335	646	java/lang/Exception
    //   84	89	651	java/io/IOException
    //   89	97	662	java/io/IOException
    //   330	335	671	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.i
 * JD-Core Version:    0.7.0.1
 */