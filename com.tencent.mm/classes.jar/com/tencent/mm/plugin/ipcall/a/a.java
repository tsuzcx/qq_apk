package com.tencent.mm.plugin.ipcall.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.d;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.bm;
import com.tencent.mm.f.a.bm.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class a
{
  public static int DZM;
  public static String DZN;
  public static String DZO;
  public static String DZP;
  private static PhoneFormater DZQ;
  private static HashMap<String, b> DZR;
  private static HashMap<String, String> DZS;
  private static HashMap<String, String> DZT;
  private static HashMap<String, String> DZU;
  private static HashMap<String, String> DZV;
  
  static
  {
    AppMethodBeat.i(26089);
    DZM = 3;
    DZN = "+";
    DZO = "00";
    DZP = null;
    DZQ = new PhoneFormater();
    DZR = new HashMap();
    DZS = new HashMap();
    DZT = new HashMap();
    DZU = new HashMap();
    DZV = new HashMap();
    AppMethodBeat.o(26089);
  }
  
  public static String Vz(int paramInt)
  {
    AppMethodBeat.i(26071);
    Object localObject = MMApplicationContext.getContext();
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      localObject = ((Context)localObject).getString(R.l.eOU);
      AppMethodBeat.o(26071);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(R.l.eOR);
      AppMethodBeat.o(26071);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(R.l.eOT);
      AppMethodBeat.o(26071);
      return localObject;
    case 10: 
      localObject = ((Context)localObject).getString(R.l.eOP);
      AppMethodBeat.o(26071);
      return localObject;
    case 4: 
      localObject = ((Context)localObject).getString(R.l.eOQ);
      AppMethodBeat.o(26071);
      return localObject;
    }
    localObject = ((Context)localObject).getString(R.l.eOS);
    AppMethodBeat.o(26071);
    return localObject;
  }
  
  public static String aMA(String paramString)
  {
    AppMethodBeat.i(26070);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaD(paramString);
      AppMethodBeat.o(26070);
      return paramString;
    }
    AppMethodBeat.o(26070);
    return null;
  }
  
  public static String aMB(String paramString)
  {
    AppMethodBeat.i(26074);
    if (DZR.size() == 0) {
      eKG();
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26074);
      return null;
    }
    paramString = (b)DZR.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.DZY;
      AppMethodBeat.o(26074);
      return paramString;
    }
    AppMethodBeat.o(26074);
    return null;
  }
  
  public static String aMC(String paramString)
  {
    AppMethodBeat.i(26075);
    if (DZS.size() == 0) {
      eKG();
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26075);
      return null;
    }
    paramString = (String)DZS.get(paramString);
    AppMethodBeat.o(26075);
    return paramString;
  }
  
  public static String aMD(String paramString)
  {
    AppMethodBeat.i(26076);
    if (DZU.size() == 0) {
      eKG();
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26076);
      return null;
    }
    paramString = (String)DZU.get(paramString);
    AppMethodBeat.o(26076);
    return paramString;
  }
  
  public static boolean aME(String paramString)
  {
    AppMethodBeat.i(26080);
    if (DZS.size() == 0) {
      eKG();
    }
    if (DZS.containsKey(paramString))
    {
      AppMethodBeat.o(26080);
      return true;
    }
    AppMethodBeat.o(26080);
    return false;
  }
  
  public static boolean aMF(String paramString)
  {
    AppMethodBeat.i(26081);
    if ((!Util.isNullOrNil(paramString)) && ((paramString.startsWith(DZN)) || (paramString.startsWith(DZO))))
    {
      AppMethodBeat.o(26081);
      return true;
    }
    AppMethodBeat.o(26081);
    return false;
  }
  
  public static String aMG(String paramString)
  {
    AppMethodBeat.i(26082);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramString.startsWith(DZN))
      {
        paramString = paramString.substring(DZN.length());
        AppMethodBeat.o(26082);
        return paramString;
      }
      if (paramString.startsWith(DZO))
      {
        paramString = paramString.substring(DZO.length());
        AppMethodBeat.o(26082);
        return paramString;
      }
    }
    AppMethodBeat.o(26082);
    return paramString;
  }
  
  public static String aMH(String paramString)
  {
    AppMethodBeat.i(26083);
    Object localObject = c.trimPhoneNumber(paramString);
    String str = c.trimPhoneNumber((String)localObject);
    paramString = null;
    if (aMF(str)) {
      paramString = extractCountryCode(str);
    }
    if (!Util.isNullOrNil(paramString))
    {
      localObject = aMG(str).substring(paramString.length());
      str = DZQ.formatNumber(paramString, (String)localObject);
      if (!Util.isNullOrNil(str)) {
        break label189;
      }
    }
    for (;;)
    {
      if (!((String)localObject).startsWith("+")) {
        paramString = "+" + paramString + " " + (String)localObject;
      }
      for (;;)
      {
        localObject = paramString;
        if (paramString.length() > 25) {
          localObject = paramString.substring(0, 25) + "...";
        }
        AppMethodBeat.o(26083);
        return localObject;
        paramString = "+" + paramString + " " + ((String)localObject).replace("+", "");
        continue;
        paramString = PhoneFormater.formatMobileString((String)localObject);
      }
      label189:
      localObject = str;
    }
  }
  
  public static String aMI(String paramString)
  {
    AppMethodBeat.i(26086);
    if (DZS.size() == 0) {
      eKG();
    }
    Object localObject = paramString;
    if (aMF(paramString))
    {
      paramString = c.trimPhoneNumber(aMG(paramString));
      localObject = new ArrayList(DZS.keySet());
      Collections.sort((List)localObject, Collections.reverseOrder(new a.a((byte)0)));
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        localObject = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
      } while (!paramString.startsWith((String)localObject));
      paramString = paramString.substring(((String)localObject).length());
      AppMethodBeat.o(26086);
      return paramString;
    }
    AppMethodBeat.o(26086);
    return localObject;
  }
  
  /* Error */
  public static ArrayList<String> aMJ(String paramString)
  {
    // Byte code:
    //   0: sipush 26088
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 205	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 246	java/util/ArrayList:<init>	()V
    //   13: astore_1
    //   14: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   17: ldc 248
    //   19: invokestatic 253	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   22: ifne +19 -> 41
    //   25: ldc 255
    //   27: ldc_w 257
    //   30: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: sipush 26088
    //   36: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   44: invokevirtual 267	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   47: getstatic 273	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   50: aconst_null
    //   51: ldc_w 275
    //   54: iconst_1
    //   55: anewarray 138	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: new 174	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 277
    //   67: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 277
    //   77: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aastore
    //   84: aconst_null
    //   85: invokevirtual 283	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore_0
    //   89: aload_0
    //   90: invokeinterface 288 1 0
    //   95: ifeq +80 -> 175
    //   98: aload_0
    //   99: invokeinterface 291 1 0
    //   104: ifne +71 -> 175
    //   107: aload_1
    //   108: aload_0
    //   109: aload_0
    //   110: ldc_w 293
    //   113: invokeinterface 297 2 0
    //   118: invokeinterface 298 2 0
    //   123: invokevirtual 301	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   126: pop
    //   127: aload_0
    //   128: invokeinterface 304 1 0
    //   133: pop
    //   134: goto -36 -> 98
    //   137: astore_2
    //   138: ldc 255
    //   140: ldc_w 306
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_2
    //   150: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: ifnull +9 -> 167
    //   161: aload_0
    //   162: invokeinterface 315 1 0
    //   167: sipush 26088
    //   170: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: areturn
    //   175: aload_0
    //   176: ifnull -9 -> 167
    //   179: aload_0
    //   180: invokeinterface 315 1 0
    //   185: goto -18 -> 167
    //   188: astore_1
    //   189: aload_0
    //   190: ifnull +9 -> 199
    //   193: aload_0
    //   194: invokeinterface 315 1 0
    //   199: sipush 26088
    //   202: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString	String
    //   13	161	1	localArrayList	ArrayList
    //   188	18	1	localObject	Object
    //   137	13	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   89	98	137	java/lang/Exception
    //   98	134	137	java/lang/Exception
    //   89	98	188	finally
    //   98	134	188	finally
    //   138	157	188	finally
  }
  
  public static String aMz(String paramString)
  {
    AppMethodBeat.i(26069);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26069);
      return null;
    }
    paramString = g.getMessageDigest(c.trimPhoneNumber(paramString).getBytes());
    paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaC(paramString);
    AppMethodBeat.o(26069);
    return paramString;
  }
  
  public static String bm(Context paramContext, String paramString)
  {
    localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(26063);
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      Log.e("MicroMsg.IPCallAddressUtil", "no contact permission");
      AppMethodBeat.o(26063);
      return null;
    }
    localCursor = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "contact_id", "data1" }, null, null, null);
    paramContext = localObject2;
    if (localCursor != null) {
      paramContext = localObject2;
    }
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          paramContext = localObject2;
          if (!localCursor.isAfterLast())
          {
            if (!PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.b.aaY(paramString), localCursor.getString(1))) {
              continue;
            }
            paramContext = localCursor.getString(0);
          }
        }
        paramString = paramContext;
        if (localCursor != null)
        {
          localCursor.close();
          paramString = paramContext;
        }
      }
      catch (Exception paramContext)
      {
        Log.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[] { paramContext.getMessage() });
        paramString = localObject1;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        paramString = localObject1;
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        AppMethodBeat.o(26063);
      }
      AppMethodBeat.o(26063);
      return paramString;
      localCursor.moveToNext();
    }
  }
  
  public static String bn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26064);
    paramString = bm(paramContext, paramString);
    if (!Util.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.m(paramString, paramContext);
      AppMethodBeat.o(26064);
      return paramContext;
    }
    AppMethodBeat.o(26064);
    return null;
  }
  
  public static String bo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26065);
    if (!Util.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.m(paramString, paramContext);
      AppMethodBeat.o(26065);
      return paramContext;
    }
    AppMethodBeat.o(26065);
    return null;
  }
  
  public static Bitmap bp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26066);
    paramContext = g(paramContext, paramString, false);
    AppMethodBeat.o(26066);
    return paramContext;
  }
  
  public static Bitmap bq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26068);
    String str = bm(paramContext, paramString);
    Bitmap localBitmap = null;
    if (!Util.isNullOrNil(str)) {
      localBitmap = g(paramContext, str, true);
    }
    paramContext = localBitmap;
    if (localBitmap == null)
    {
      paramContext = localBitmap;
      if (byl())
      {
        paramString = aMz(paramString);
        Log.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[] { paramString });
        paramContext = localBitmap;
        if (!Util.isNullOrNil(paramString)) {
          paramContext = d.f(paramString, 320, 320, 4);
        }
      }
    }
    AppMethodBeat.o(26068);
    return paramContext;
  }
  
  public static boolean byl()
  {
    AppMethodBeat.i(26087);
    bm localbm = new bm();
    EventCenter.instance.publish(localbm);
    Log.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[] { Boolean.valueOf(localbm.fxk.result) });
    boolean bool = localbm.fxk.result;
    AppMethodBeat.o(26087);
    return bool;
  }
  
  private static void eKG()
  {
    AppMethodBeat.i(26072);
    DZS.clear();
    DZT.clear();
    DZU.clear();
    DZV.clear();
    DZR.clear();
    Object localObject4 = null;
    label105:
    String str2;
    for (Object localObject1 = null;; str2 = "")
    {
      try
      {
        localObject5 = MMApplicationContext.getContext().getAssets().open("ipcall_country_code.txt");
        localObject1 = localObject5;
        localObject4 = localObject5;
        localObject6 = new byte[((InputStream)localObject5).available()];
        localObject1 = localObject5;
        localObject4 = localObject5;
        ((InputStream)localObject5).read((byte[])localObject6);
        localObject1 = localObject5;
        localObject4 = localObject5;
        localObject6 = new String((byte[])localObject6);
        localObject1 = localObject6;
        if (localObject5 == null) {}
      }
      catch (IOException localIOException4)
      {
        for (;;)
        {
          Object localObject5;
          int i;
          Object localObject2;
          localObject4 = localObject2;
          Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException4) });
          if (localObject2 == null) {
            break;
          }
          try
          {
            ((InputStream)localObject2).close();
            localObject2 = "";
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException2) });
            String str1 = "";
          }
        }
      }
      finally
      {
        for (;;)
        {
          String[] arrayOfString;
          if (localObject4 != null) {}
          try
          {
            localObject4.close();
            AppMethodBeat.o(26072);
            throw localObject3;
          }
          catch (IOException localIOException3)
          {
            for (;;)
            {
              Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException3) });
            }
          }
          Object localObject6 = new b();
          ((b)localObject6).DZW = arrayOfString[0];
          ((b)localObject6).DZX = arrayOfString[1];
          RegionCodeDecoder.hAC();
          String str3 = RegionCodeDecoder.getLocName(arrayOfString[0]);
          str2 = str3;
          if (Util.isNullOrNil(str3)) {
            str2 = new Locale("", arrayOfString[0]).getDisplayCountry(MMApplicationContext.getResources().getConfiguration().locale);
          }
          ((b)localObject6).DZY = str2;
          DZU.put(((b)localObject6).DZX, ((b)localObject6).DZW);
          DZV.put(((b)localObject6).DZW, ((b)localObject6).DZX);
          DZS.put(((b)localObject6).DZX, ((b)localObject6).DZY);
          DZT.put(((b)localObject6).DZY, ((b)localObject6).DZX);
          DZR.put(((b)localObject6).DZW, localObject6);
        }
        label462:
        AppMethodBeat.o(26072);
        return;
      }
      try
      {
        ((InputStream)localObject5).close();
        localObject1 = localObject6;
      }
      catch (IOException localIOException1)
      {
        Log.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException1) });
        localObject2 = localObject6;
        break label105;
      }
      localObject5 = localObject1.trim().split("\n");
      i = 0;
      for (;;)
      {
        if (i >= localObject5.length) {
          break label462;
        }
        arrayOfString = localObject5[i].trim().split(" ");
        if (arrayOfString.length >= 2) {
          break;
        }
        Log.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[] { localObject5[i] });
        i += 1;
      }
    }
  }
  
  public static HashMap<String, b> eKH()
  {
    AppMethodBeat.i(26073);
    if (DZR.size() == 0) {
      eKG();
    }
    HashMap localHashMap = DZR;
    AppMethodBeat.o(26073);
    return localHashMap;
  }
  
  public static String eKI()
  {
    AppMethodBeat.i(26084);
    if (DZT.size() == 0) {
      eKG();
    }
    String str = Util.getSimCountryCode(MMApplicationContext.getContext());
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[] { str });
      str = str.toUpperCase();
      str = (String)DZV.get(str);
      if (!Util.isNullOrNil(str)) {
        Log.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
      }
    }
    while (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(26084);
      return str;
      str = "";
    }
    str = ca.bfn().countryCode;
    Log.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[] { str });
    if (!Util.isNullOrNil(str))
    {
      str = (String)DZV.get(str);
      if (!Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
        AppMethodBeat.o(26084);
        return str;
      }
    }
    str = MMApplicationContext.getContext().getString(R.l.country_normal_code);
    Log.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[] { str });
    str = str.replace("+", "");
    AppMethodBeat.o(26084);
    return str;
  }
  
  public static void eKJ()
  {
    AppMethodBeat.i(26085);
    eKG();
    AppMethodBeat.o(26085);
  }
  
  public static String extractCountryCode(String paramString)
  {
    AppMethodBeat.i(26079);
    if (DZS.size() == 0) {
      eKG();
    }
    if (aMF(paramString))
    {
      paramString = c.trimPhoneNumber(aMG(paramString));
      Object localObject = new ArrayList(DZS.keySet());
      Collections.sort((List)localObject, Collections.reverseOrder(new a.a((byte)0)));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (paramString.startsWith(str))
        {
          AppMethodBeat.o(26079);
          return str;
        }
      }
    }
    AppMethodBeat.o(26079);
    return null;
  }
  
  public static Bitmap g(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26067);
    if (!Util.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.a(paramString, paramContext, paramBoolean);
      AppMethodBeat.o(26067);
      return paramContext;
    }
    AppMethodBeat.o(26067);
    return null;
  }
  
  public static int iC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26077);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(26077);
      return -1;
    }
    int j = iD(paramString1, paramString2);
    int i = j;
    if (j == -1)
    {
      i = j;
      if (paramString2.startsWith("+"))
      {
        String str2 = extractCountryCode(paramString2);
        String str1 = paramString2;
        if (!Util.isNullOrNil(str2)) {
          str1 = paramString2.substring("+".concat(String.valueOf(str2)).length());
        }
        i = iD(paramString1, str1);
      }
    }
    AppMethodBeat.o(26077);
    return i;
  }
  
  /* Error */
  private static int iD(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 26078
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: ldc 248
    //   11: invokestatic 253	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +19 -> 33
    //   17: ldc 255
    //   19: ldc_w 257
    //   22: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: sipush 26078
    //   28: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_m1
    //   32: ireturn
    //   33: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   36: invokevirtual 267	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   39: getstatic 273	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   42: aconst_null
    //   43: ldc_w 552
    //   46: iconst_1
    //   47: anewarray 138	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: aconst_null
    //   55: invokevirtual 283	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_0
    //   59: aload_1
    //   60: invokestatic 161	com/tencent/mm/plugin/ipcall/a/c:trimPhoneNumber	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: invokeinterface 288 1 0
    //   70: ifeq +113 -> 183
    //   73: aload_0
    //   74: invokeinterface 291 1 0
    //   79: ifne +104 -> 183
    //   82: aload_0
    //   83: aload_0
    //   84: ldc_w 554
    //   87: invokeinterface 297 2 0
    //   92: invokeinterface 558 2 0
    //   97: istore_2
    //   98: aload_0
    //   99: aload_0
    //   100: ldc_w 335
    //   103: invokeinterface 297 2 0
    //   108: invokeinterface 298 2 0
    //   113: invokestatic 161	com/tencent/mm/plugin/ipcall/a/c:trimPhoneNumber	(Ljava/lang/String;)Ljava/lang/String;
    //   116: aload_1
    //   117: invokevirtual 561	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq +17 -> 139
    //   125: aload_0
    //   126: invokeinterface 315 1 0
    //   131: sipush 26078
    //   134: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_2
    //   138: ireturn
    //   139: aload_0
    //   140: invokeinterface 304 1 0
    //   145: pop
    //   146: goto -73 -> 73
    //   149: astore_1
    //   150: ldc 255
    //   152: ldc_w 563
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_1
    //   162: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: invokeinterface 315 1 0
    //   175: sipush 26078
    //   178: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_m1
    //   182: ireturn
    //   183: aload_0
    //   184: invokeinterface 315 1 0
    //   189: goto -14 -> 175
    //   192: astore_1
    //   193: aload_0
    //   194: invokeinterface 315 1 0
    //   199: sipush 26078
    //   202: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramString1	String
    //   0	207	1	paramString2	String
    //   97	41	2	i	int
    //   120	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   64	73	149	java/lang/Exception
    //   73	121	149	java/lang/Exception
    //   139	146	149	java/lang/Exception
    //   64	73	192	finally
    //   73	121	192	finally
    //   139	146	192	finally
    //   150	169	192	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a
 * JD-Core Version:    0.7.0.1
 */