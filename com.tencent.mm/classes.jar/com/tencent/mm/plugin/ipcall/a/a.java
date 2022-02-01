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
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.bh.a;
import com.tencent.mm.model.bz;
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
  private static HashMap<String, String> yAa;
  private static HashMap<String, String> yAb;
  private static HashMap<String, String> yAc;
  private static HashMap<String, String> yAd;
  public static int yzU;
  public static String yzV;
  public static String yzW;
  public static String yzX;
  private static PhoneFormater yzY;
  private static HashMap<String, b> yzZ;
  
  static
  {
    AppMethodBeat.i(26089);
    yzU = 3;
    yzV = "+";
    yzW = "00";
    yzX = null;
    yzY = new PhoneFormater();
    yzZ = new HashMap();
    yAa = new HashMap();
    yAb = new HashMap();
    yAc = new HashMap();
    yAd = new HashMap();
    AppMethodBeat.o(26089);
  }
  
  public static String Pq(int paramInt)
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
      localObject = ((Context)localObject).getString(2131763900);
      AppMethodBeat.o(26071);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(2131763897);
      AppMethodBeat.o(26071);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(2131763899);
      AppMethodBeat.o(26071);
      return localObject;
    case 10: 
      localObject = ((Context)localObject).getString(2131763895);
      AppMethodBeat.o(26071);
      return localObject;
    case 4: 
      localObject = ((Context)localObject).getString(2131763896);
      AppMethodBeat.o(26071);
      return localObject;
    }
    localObject = ((Context)localObject).getString(2131763898);
    AppMethodBeat.o(26071);
    return localObject;
  }
  
  public static String aCA(String paramString)
  {
    AppMethodBeat.i(26083);
    Object localObject = c.trimPhoneNumber(paramString);
    String str = c.trimPhoneNumber((String)localObject);
    paramString = null;
    if (aCy(str)) {
      paramString = extractCountryCode(str);
    }
    if (!Util.isNullOrNil(paramString))
    {
      localObject = aCz(str).substring(paramString.length());
      str = yzY.formatNumber(paramString, (String)localObject);
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
  
  public static String aCB(String paramString)
  {
    AppMethodBeat.i(26086);
    if (yAa.size() == 0) {
      ebI();
    }
    Object localObject = paramString;
    if (aCy(paramString))
    {
      paramString = c.trimPhoneNumber(aCz(paramString));
      localObject = new ArrayList(yAa.keySet());
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
  public static ArrayList<String> aCC(String paramString)
  {
    // Byte code:
    //   0: sipush 26088
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 162	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 203	java/util/ArrayList:<init>	()V
    //   13: astore_1
    //   14: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   17: ldc 205
    //   19: invokestatic 211	com/tencent/mm/pluginsdk/permission/b:n	(Landroid/content/Context;Ljava/lang/String;)Z
    //   22: ifne +18 -> 40
    //   25: ldc 213
    //   27: ldc 215
    //   29: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: sipush 26088
    //   35: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   43: invokevirtual 225	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: getstatic 231	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   49: aconst_null
    //   50: ldc 233
    //   52: iconst_1
    //   53: anewarray 109	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: new 125	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 235
    //   64: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 235
    //   73: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aastore
    //   80: aconst_null
    //   81: invokevirtual 241	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_0
    //   85: aload_0
    //   86: invokeinterface 246 1 0
    //   91: ifeq +79 -> 170
    //   94: aload_0
    //   95: invokeinterface 249 1 0
    //   100: ifne +70 -> 170
    //   103: aload_1
    //   104: aload_0
    //   105: aload_0
    //   106: ldc 251
    //   108: invokeinterface 255 2 0
    //   113: invokeinterface 256 2 0
    //   118: invokevirtual 260	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: invokeinterface 263 1 0
    //   128: pop
    //   129: goto -35 -> 94
    //   132: astore_2
    //   133: ldc 213
    //   135: ldc_w 265
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_2
    //   145: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: ifnull +9 -> 162
    //   156: aload_0
    //   157: invokeinterface 274 1 0
    //   162: sipush 26088
    //   165: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: areturn
    //   170: aload_0
    //   171: ifnull -9 -> 162
    //   174: aload_0
    //   175: invokeinterface 274 1 0
    //   180: goto -18 -> 162
    //   183: astore_1
    //   184: aload_0
    //   185: ifnull +9 -> 194
    //   188: aload_0
    //   189: invokeinterface 274 1 0
    //   194: sipush 26088
    //   197: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramString	String
    //   13	156	1	localArrayList	ArrayList
    //   183	18	1	localObject	Object
    //   132	13	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   85	94	132	java/lang/Exception
    //   94	129	132	java/lang/Exception
    //   85	94	183	finally
    //   94	129	183	finally
    //   133	152	183	finally
  }
  
  public static String aCs(String paramString)
  {
    AppMethodBeat.i(26069);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26069);
      return null;
    }
    paramString = g.getMessageDigest(c.trimPhoneNumber(paramString).getBytes());
    paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().SW(paramString);
    AppMethodBeat.o(26069);
    return paramString;
  }
  
  public static String aCt(String paramString)
  {
    AppMethodBeat.i(26070);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().SX(paramString);
      AppMethodBeat.o(26070);
      return paramString;
    }
    AppMethodBeat.o(26070);
    return null;
  }
  
  public static String aCu(String paramString)
  {
    AppMethodBeat.i(26074);
    if (yzZ.size() == 0) {
      ebI();
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26074);
      return null;
    }
    paramString = (b)yzZ.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.yAg;
      AppMethodBeat.o(26074);
      return paramString;
    }
    AppMethodBeat.o(26074);
    return null;
  }
  
  public static String aCv(String paramString)
  {
    AppMethodBeat.i(26075);
    if (yAa.size() == 0) {
      ebI();
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26075);
      return null;
    }
    paramString = (String)yAa.get(paramString);
    AppMethodBeat.o(26075);
    return paramString;
  }
  
  public static String aCw(String paramString)
  {
    AppMethodBeat.i(26076);
    if (yAc.size() == 0) {
      ebI();
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26076);
      return null;
    }
    paramString = (String)yAc.get(paramString);
    AppMethodBeat.o(26076);
    return paramString;
  }
  
  public static boolean aCx(String paramString)
  {
    AppMethodBeat.i(26080);
    if (yAa.size() == 0) {
      ebI();
    }
    if (yAa.containsKey(paramString))
    {
      AppMethodBeat.o(26080);
      return true;
    }
    AppMethodBeat.o(26080);
    return false;
  }
  
  public static boolean aCy(String paramString)
  {
    AppMethodBeat.i(26081);
    if ((!Util.isNullOrNil(paramString)) && ((paramString.startsWith(yzV)) || (paramString.startsWith(yzW))))
    {
      AppMethodBeat.o(26081);
      return true;
    }
    AppMethodBeat.o(26081);
    return false;
  }
  
  public static String aCz(String paramString)
  {
    AppMethodBeat.i(26082);
    if (!Util.isNullOrNil(paramString))
    {
      if (paramString.startsWith(yzV))
      {
        paramString = paramString.substring(yzV.length());
        AppMethodBeat.o(26082);
        return paramString;
      }
      if (paramString.startsWith(yzW))
      {
        paramString = paramString.substring(yzW.length());
        AppMethodBeat.o(26082);
        return paramString;
      }
    }
    AppMethodBeat.o(26082);
    return paramString;
  }
  
  public static String ba(Context paramContext, String paramString)
  {
    localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(26063);
    if (!com.tencent.mm.pluginsdk.permission.b.n(paramContext, "android.permission.READ_CONTACTS"))
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
            if (!PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.b.Ts(paramString), localCursor.getString(1))) {
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
  
  public static String bb(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26064);
    paramString = ba(paramContext, paramString);
    if (!Util.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.k(paramString, paramContext);
      AppMethodBeat.o(26064);
      return paramContext;
    }
    AppMethodBeat.o(26064);
    return null;
  }
  
  public static String bc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26065);
    if (!Util.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.k(paramString, paramContext);
      AppMethodBeat.o(26065);
      return paramContext;
    }
    AppMethodBeat.o(26065);
    return null;
  }
  
  public static Bitmap bd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26066);
    paramContext = g(paramContext, paramString, false);
    AppMethodBeat.o(26066);
    return paramContext;
  }
  
  public static Bitmap be(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26068);
    String str = ba(paramContext, paramString);
    Bitmap localBitmap = null;
    if (!Util.isNullOrNil(str)) {
      localBitmap = g(paramContext, str, true);
    }
    paramContext = localBitmap;
    if (localBitmap == null)
    {
      paramContext = localBitmap;
      if (boc())
      {
        paramString = aCs(paramString);
        Log.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[] { paramString });
        paramContext = localBitmap;
        if (!Util.isNullOrNil(paramString)) {
          paramContext = com.tencent.mm.aj.c.e(paramString, 320, 320, 4);
        }
      }
    }
    AppMethodBeat.o(26068);
    return paramContext;
  }
  
  public static boolean boc()
  {
    AppMethodBeat.i(26087);
    bh localbh = new bh();
    EventCenter.instance.publish(localbh);
    Log.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[] { Boolean.valueOf(localbh.dEw.result) });
    boolean bool = localbh.dEw.result;
    AppMethodBeat.o(26087);
    return bool;
  }
  
  private static void ebI()
  {
    AppMethodBeat.i(26072);
    yAa.clear();
    yAb.clear();
    yAc.clear();
    yAd.clear();
    yzZ.clear();
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
          ((b)localObject6).yAe = arrayOfString[0];
          ((b)localObject6).yAf = arrayOfString[1];
          RegionCodeDecoder.gEm();
          String str3 = RegionCodeDecoder.getLocName(arrayOfString[0]);
          str2 = str3;
          if (Util.isNullOrNil(str3)) {
            str2 = new Locale("", arrayOfString[0]).getDisplayCountry(MMApplicationContext.getResources().getConfiguration().locale);
          }
          ((b)localObject6).yAg = str2;
          yAc.put(((b)localObject6).yAf, ((b)localObject6).yAe);
          yAd.put(((b)localObject6).yAe, ((b)localObject6).yAf);
          yAa.put(((b)localObject6).yAf, ((b)localObject6).yAg);
          yAb.put(((b)localObject6).yAg, ((b)localObject6).yAf);
          yzZ.put(((b)localObject6).yAe, localObject6);
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
  
  public static HashMap<String, b> ebJ()
  {
    AppMethodBeat.i(26073);
    if (yzZ.size() == 0) {
      ebI();
    }
    HashMap localHashMap = yzZ;
    AppMethodBeat.o(26073);
    return localHashMap;
  }
  
  public static String ebK()
  {
    AppMethodBeat.i(26084);
    if (yAb.size() == 0) {
      ebI();
    }
    String str = Util.getSimCountryCode(MMApplicationContext.getContext());
    if (!Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[] { str });
      str = str.toUpperCase();
      str = (String)yAd.get(str);
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
    str = bz.aWj().countryCode;
    Log.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[] { str });
    if (!Util.isNullOrNil(str))
    {
      str = (String)yAd.get(str);
      if (!Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
        AppMethodBeat.o(26084);
        return str;
      }
    }
    str = MMApplicationContext.getContext().getString(2131758199);
    Log.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[] { str });
    str = str.replace("+", "");
    AppMethodBeat.o(26084);
    return str;
  }
  
  public static void ebL()
  {
    AppMethodBeat.i(26085);
    ebI();
    AppMethodBeat.o(26085);
  }
  
  public static String extractCountryCode(String paramString)
  {
    AppMethodBeat.i(26079);
    if (yAa.size() == 0) {
      ebI();
    }
    if (aCy(paramString))
    {
      paramString = c.trimPhoneNumber(aCz(paramString));
      Object localObject = new ArrayList(yAa.keySet());
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
  
  public static int ip(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26077);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(26077);
      return -1;
    }
    int j = iq(paramString1, paramString2);
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
        i = iq(paramString1, str1);
      }
    }
    AppMethodBeat.o(26077);
    return i;
  }
  
  /* Error */
  private static int iq(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 26078
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: ldc 205
    //   11: invokestatic 211	com/tencent/mm/pluginsdk/permission/b:n	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +18 -> 32
    //   17: ldc 213
    //   19: ldc 215
    //   21: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 26078
    //   27: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_m1
    //   31: ireturn
    //   32: invokestatic 74	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   35: invokevirtual 225	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 231	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   41: aconst_null
    //   42: ldc_w 536
    //   45: iconst_1
    //   46: anewarray 109	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: aastore
    //   53: aconst_null
    //   54: invokevirtual 241	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore_0
    //   58: aload_1
    //   59: invokestatic 92	com/tencent/mm/plugin/ipcall/a/c:trimPhoneNumber	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokeinterface 246 1 0
    //   69: ifeq +113 -> 182
    //   72: aload_0
    //   73: invokeinterface 249 1 0
    //   78: ifne +104 -> 182
    //   81: aload_0
    //   82: aload_0
    //   83: ldc_w 538
    //   86: invokeinterface 255 2 0
    //   91: invokeinterface 542 2 0
    //   96: istore_2
    //   97: aload_0
    //   98: aload_0
    //   99: ldc_w 322
    //   102: invokeinterface 255 2 0
    //   107: invokeinterface 256 2 0
    //   112: invokestatic 92	com/tencent/mm/plugin/ipcall/a/c:trimPhoneNumber	(Ljava/lang/String;)Ljava/lang/String;
    //   115: aload_1
    //   116: invokevirtual 545	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: istore_3
    //   120: iload_3
    //   121: ifeq +17 -> 138
    //   124: aload_0
    //   125: invokeinterface 274 1 0
    //   130: sipush 26078
    //   133: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iload_2
    //   137: ireturn
    //   138: aload_0
    //   139: invokeinterface 263 1 0
    //   144: pop
    //   145: goto -73 -> 72
    //   148: astore_1
    //   149: ldc 213
    //   151: ldc_w 547
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_1
    //   161: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 271	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_0
    //   169: invokeinterface 274 1 0
    //   174: sipush 26078
    //   177: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_m1
    //   181: ireturn
    //   182: aload_0
    //   183: invokeinterface 274 1 0
    //   188: goto -14 -> 174
    //   191: astore_1
    //   192: aload_0
    //   193: invokeinterface 274 1 0
    //   198: sipush 26078
    //   201: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramString1	String
    //   0	206	1	paramString2	String
    //   96	41	2	i	int
    //   119	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   63	72	148	java/lang/Exception
    //   72	120	148	java/lang/Exception
    //   138	145	148	java/lang/Exception
    //   63	72	191	finally
    //   72	120	191	finally
    //   138	145	191	finally
    //   149	168	191	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a
 * JD-Core Version:    0.7.0.1
 */