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
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bf.a;
import com.tencent.mm.model.bv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static HashMap<String, b> vhA;
  private static HashMap<String, String> vhB;
  private static HashMap<String, String> vhC;
  private static HashMap<String, String> vhD;
  private static HashMap<String, String> vhE;
  public static int vhv;
  public static String vhw;
  public static String vhx;
  public static String vhy;
  private static bb vhz;
  
  static
  {
    AppMethodBeat.i(26089);
    vhv = 3;
    vhw = "+";
    vhx = "00";
    vhy = null;
    vhz = new bb();
    vhA = new HashMap();
    vhB = new HashMap();
    vhC = new HashMap();
    vhD = new HashMap();
    vhE = new HashMap();
    AppMethodBeat.o(26089);
  }
  
  public static String Jn(int paramInt)
  {
    AppMethodBeat.i(26071);
    Object localObject = ak.getContext();
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      localObject = ((Context)localObject).getString(2131761895);
      AppMethodBeat.o(26071);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(2131761892);
      AppMethodBeat.o(26071);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(2131761894);
      AppMethodBeat.o(26071);
      return localObject;
    case 10: 
      localObject = ((Context)localObject).getString(2131761890);
      AppMethodBeat.o(26071);
      return localObject;
    case 4: 
      localObject = ((Context)localObject).getString(2131761891);
      AppMethodBeat.o(26071);
      return localObject;
    }
    localObject = ((Context)localObject).getString(2131761893);
    AppMethodBeat.o(26071);
    return localObject;
  }
  
  public static String aN(Context paramContext, String paramString)
  {
    localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(26063);
    if (!com.tencent.mm.pluginsdk.permission.b.n(paramContext, "android.permission.READ_CONTACTS"))
    {
      ae.e("MicroMsg.IPCallAddressUtil", "no contact permission");
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
            if (!PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.b.Ku(paramString), localCursor.getString(1))) {
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
        ae.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[] { paramContext.getMessage() });
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
  
  public static String aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26064);
    paramString = aN(paramContext, paramString);
    if (!bu.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.i(paramString, paramContext);
      AppMethodBeat.o(26064);
      return paramContext;
    }
    AppMethodBeat.o(26064);
    return null;
  }
  
  public static String aP(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26065);
    if (!bu.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.i(paramString, paramContext);
      AppMethodBeat.o(26065);
      return paramContext;
    }
    AppMethodBeat.o(26065);
    return null;
  }
  
  public static Bitmap aQ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26066);
    paramContext = g(paramContext, paramString, false);
    AppMethodBeat.o(26066);
    return paramContext;
  }
  
  public static Bitmap aR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(26068);
    String str = aN(paramContext, paramString);
    Bitmap localBitmap = null;
    if (!bu.isNullOrNil(str)) {
      localBitmap = g(paramContext, str, true);
    }
    paramContext = localBitmap;
    if (localBitmap == null)
    {
      paramContext = localBitmap;
      if (aTq())
      {
        paramString = aoY(paramString);
        ae.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[] { paramString });
        paramContext = localBitmap;
        if (!bu.isNullOrNil(paramString)) {
          paramContext = com.tencent.mm.aj.c.e(paramString, 320, 320, 4);
        }
      }
    }
    AppMethodBeat.o(26068);
    return paramContext;
  }
  
  public static boolean aTq()
  {
    AppMethodBeat.i(26087);
    bf localbf = new bf();
    com.tencent.mm.sdk.b.a.IvT.l(localbf);
    ae.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[] { Boolean.valueOf(localbf.dnh.result) });
    boolean bool = localbf.dnh.result;
    AppMethodBeat.o(26087);
    return bool;
  }
  
  public static String aoY(String paramString)
  {
    AppMethodBeat.i(26069);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26069);
      return null;
    }
    paramString = g.getMessageDigest(c.apl(paramString).getBytes());
    paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().JY(paramString);
    AppMethodBeat.o(26069);
    return paramString;
  }
  
  public static String aoZ(String paramString)
  {
    AppMethodBeat.i(26070);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().JZ(paramString);
      AppMethodBeat.o(26070);
      return paramString;
    }
    AppMethodBeat.o(26070);
    return null;
  }
  
  public static String apa(String paramString)
  {
    AppMethodBeat.i(26074);
    if (vhA.size() == 0) {
      dhR();
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26074);
      return null;
    }
    paramString = (b)vhA.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.vhH;
      AppMethodBeat.o(26074);
      return paramString;
    }
    AppMethodBeat.o(26074);
    return null;
  }
  
  public static String apb(String paramString)
  {
    AppMethodBeat.i(26075);
    if (vhB.size() == 0) {
      dhR();
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26075);
      return null;
    }
    paramString = (String)vhB.get(paramString);
    AppMethodBeat.o(26075);
    return paramString;
  }
  
  public static String apc(String paramString)
  {
    AppMethodBeat.i(26076);
    if (vhD.size() == 0) {
      dhR();
    }
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26076);
      return null;
    }
    paramString = (String)vhD.get(paramString);
    AppMethodBeat.o(26076);
    return paramString;
  }
  
  public static String apd(String paramString)
  {
    AppMethodBeat.i(26079);
    if (vhB.size() == 0) {
      dhR();
    }
    if (apf(paramString))
    {
      paramString = c.apl(apg(paramString));
      Object localObject = new ArrayList(vhB.keySet());
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
  
  public static boolean ape(String paramString)
  {
    AppMethodBeat.i(26080);
    if (vhB.size() == 0) {
      dhR();
    }
    if (vhB.containsKey(paramString))
    {
      AppMethodBeat.o(26080);
      return true;
    }
    AppMethodBeat.o(26080);
    return false;
  }
  
  public static boolean apf(String paramString)
  {
    AppMethodBeat.i(26081);
    if ((!bu.isNullOrNil(paramString)) && ((paramString.startsWith(vhw)) || (paramString.startsWith(vhx))))
    {
      AppMethodBeat.o(26081);
      return true;
    }
    AppMethodBeat.o(26081);
    return false;
  }
  
  public static String apg(String paramString)
  {
    AppMethodBeat.i(26082);
    if (!bu.isNullOrNil(paramString))
    {
      if (paramString.startsWith(vhw))
      {
        paramString = paramString.substring(vhw.length());
        AppMethodBeat.o(26082);
        return paramString;
      }
      if (paramString.startsWith(vhx))
      {
        paramString = paramString.substring(vhx.length());
        AppMethodBeat.o(26082);
        return paramString;
      }
    }
    AppMethodBeat.o(26082);
    return paramString;
  }
  
  public static String aph(String paramString)
  {
    AppMethodBeat.i(26083);
    Object localObject = c.apl(paramString);
    String str = c.apl((String)localObject);
    paramString = null;
    if (apf(str)) {
      paramString = apd(str);
    }
    if (!bu.isNullOrNil(paramString))
    {
      localObject = apg(str).substring(paramString.length());
      str = bb.formatNumber(paramString, (String)localObject);
      if (!bu.isNullOrNil(str)) {
        break label190;
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
        paramString = bb.aSe((String)localObject);
      }
      label190:
      localObject = str;
    }
  }
  
  public static String api(String paramString)
  {
    AppMethodBeat.i(26086);
    if (vhB.size() == 0) {
      dhR();
    }
    Object localObject = paramString;
    if (apf(paramString))
    {
      paramString = c.apl(apg(paramString));
      localObject = new ArrayList(vhB.keySet());
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
  public static ArrayList<String> apj(String paramString)
  {
    // Byte code:
    //   0: sipush 26088
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 289	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 378	java/util/ArrayList:<init>	()V
    //   13: astore_1
    //   14: invokestatic 74	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   17: ldc 91
    //   19: invokestatic 97	com/tencent/mm/pluginsdk/permission/b:n	(Landroid/content/Context;Ljava/lang/String;)Z
    //   22: ifne +18 -> 40
    //   25: ldc 99
    //   27: ldc 101
    //   29: invokestatic 107	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: sipush 26088
    //   35: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: invokestatic 74	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   43: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: getstatic 117	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   49: aconst_null
    //   50: ldc_w 380
    //   53: iconst_1
    //   54: anewarray 119	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: new 347	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 382
    //   66: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 382
    //   76: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 359	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: aastore
    //   83: aconst_null
    //   84: invokevirtual 129	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_0
    //   88: aload_0
    //   89: invokeinterface 135 1 0
    //   94: ifeq +79 -> 173
    //   97: aload_0
    //   98: invokeinterface 138 1 0
    //   103: ifne +70 -> 173
    //   106: aload_1
    //   107: aload_0
    //   108: aload_0
    //   109: ldc 121
    //   111: invokeinterface 386 2 0
    //   116: invokeinterface 145 2 0
    //   121: invokevirtual 389	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_0
    //   126: invokeinterface 157 1 0
    //   131: pop
    //   132: goto -35 -> 97
    //   135: astore_2
    //   136: ldc 99
    //   138: ldc_w 391
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_2
    //   148: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 393	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: ifnull +9 -> 165
    //   159: aload_0
    //   160: invokeinterface 154 1 0
    //   165: sipush 26088
    //   168: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_1
    //   172: areturn
    //   173: aload_0
    //   174: ifnull -9 -> 165
    //   177: aload_0
    //   178: invokeinterface 154 1 0
    //   183: goto -18 -> 165
    //   186: astore_1
    //   187: aload_0
    //   188: ifnull +9 -> 197
    //   191: aload_0
    //   192: invokeinterface 154 1 0
    //   197: sipush 26088
    //   200: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString	String
    //   13	159	1	localArrayList	ArrayList
    //   186	18	1	localObject	Object
    //   135	13	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   88	97	135	java/lang/Exception
    //   97	132	135	java/lang/Exception
    //   88	97	186	finally
    //   97	132	186	finally
    //   136	155	186	finally
  }
  
  private static void dhR()
  {
    AppMethodBeat.i(26072);
    vhB.clear();
    vhC.clear();
    vhD.clear();
    vhE.clear();
    vhA.clear();
    Object localObject4 = null;
    label105:
    String str2;
    for (Object localObject1 = null;; str2 = "")
    {
      try
      {
        localObject5 = ak.getContext().getAssets().open("ipcall_country_code.txt");
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
          ae.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bu.o(localIOException4) });
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
            ae.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bu.o(localIOException2) });
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
              ae.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bu.o(localIOException3) });
            }
          }
          Object localObject6 = new b();
          ((b)localObject6).vhF = arrayOfString[0];
          ((b)localObject6).vhG = arrayOfString[1];
          RegionCodeDecoder.fwA();
          String str3 = RegionCodeDecoder.getLocName(arrayOfString[0]);
          str2 = str3;
          if (bu.isNullOrNil(str3)) {
            str2 = new Locale("", arrayOfString[0]).getDisplayCountry(ak.getResources().getConfiguration().locale);
          }
          ((b)localObject6).vhH = str2;
          vhD.put(((b)localObject6).vhG, ((b)localObject6).vhF);
          vhE.put(((b)localObject6).vhF, ((b)localObject6).vhG);
          vhB.put(((b)localObject6).vhG, ((b)localObject6).vhH);
          vhC.put(((b)localObject6).vhH, ((b)localObject6).vhG);
          vhA.put(((b)localObject6).vhF, localObject6);
        }
        label466:
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
        ae.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bu.o(localIOException1) });
        localObject2 = localObject6;
        break label105;
      }
      localObject5 = localObject1.trim().split("\n");
      i = 0;
      for (;;)
      {
        if (i >= localObject5.length) {
          break label466;
        }
        arrayOfString = localObject5[i].trim().split(" ");
        if (arrayOfString.length >= 2) {
          break;
        }
        ae.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[] { localObject5[i] });
        i += 1;
      }
    }
  }
  
  public static HashMap<String, b> dhS()
  {
    AppMethodBeat.i(26073);
    if (vhA.size() == 0) {
      dhR();
    }
    HashMap localHashMap = vhA;
    AppMethodBeat.o(26073);
    return localHashMap;
  }
  
  public static String dhT()
  {
    AppMethodBeat.i(26084);
    if (vhC.size() == 0) {
      dhR();
    }
    String str = bu.jm(ak.getContext());
    if (!bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[] { str });
      str = str.toUpperCase();
      str = (String)vhE.get(str);
      if (!bu.isNullOrNil(str)) {
        ae.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
      }
    }
    while (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(26084);
      return str;
      str = "";
    }
    str = bv.aCL().countryCode;
    ae.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[] { str });
    if (!bu.isNullOrNil(str))
    {
      str = (String)vhE.get(str);
      if (!bu.isNullOrNil(str))
      {
        ae.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
        AppMethodBeat.o(26084);
        return str;
      }
    }
    str = ak.getContext().getString(2131757951);
    ae.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[] { str });
    str = str.replace("+", "");
    AppMethodBeat.o(26084);
    return str;
  }
  
  public static void dhU()
  {
    AppMethodBeat.i(26085);
    dhR();
    AppMethodBeat.o(26085);
  }
  
  public static Bitmap g(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26067);
    if (!bu.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.b.a(paramString, paramContext, paramBoolean);
      AppMethodBeat.o(26067);
      return paramContext;
    }
    AppMethodBeat.o(26067);
    return null;
  }
  
  public static int hH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(26077);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(26077);
      return -1;
    }
    int j = hI(paramString1, paramString2);
    int i = j;
    if (j == -1)
    {
      i = j;
      if (paramString2.startsWith("+"))
      {
        String str2 = apd(paramString2);
        String str1 = paramString2;
        if (!bu.isNullOrNil(str2)) {
          str1 = paramString2.substring("+".concat(String.valueOf(str2)).length());
        }
        i = hI(paramString1, str1);
      }
    }
    AppMethodBeat.o(26077);
    return i;
  }
  
  /* Error */
  private static int hI(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 26078
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 74	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   9: ldc 91
    //   11: invokestatic 97	com/tencent/mm/pluginsdk/permission/b:n	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +18 -> 32
    //   17: ldc 99
    //   19: ldc 101
    //   21: invokestatic 107	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 26078
    //   27: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_m1
    //   31: ireturn
    //   32: invokestatic 74	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   35: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 117	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   41: aconst_null
    //   42: ldc_w 534
    //   45: iconst_1
    //   46: anewarray 119	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: aastore
    //   53: aconst_null
    //   54: invokevirtual 129	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore_0
    //   58: aload_1
    //   59: invokestatic 236	com/tencent/mm/plugin/ipcall/a/c:apl	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokeinterface 135 1 0
    //   69: ifeq +112 -> 181
    //   72: aload_0
    //   73: invokeinterface 138 1 0
    //   78: ifne +103 -> 181
    //   81: aload_0
    //   82: aload_0
    //   83: ldc_w 536
    //   86: invokeinterface 386 2 0
    //   91: invokeinterface 540 2 0
    //   96: istore_2
    //   97: aload_0
    //   98: aload_0
    //   99: ldc 123
    //   101: invokeinterface 386 2 0
    //   106: invokeinterface 145 2 0
    //   111: invokestatic 236	com/tencent/mm/plugin/ipcall/a/c:apl	(Ljava/lang/String;)Ljava/lang/String;
    //   114: aload_1
    //   115: invokevirtual 543	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: istore_3
    //   119: iload_3
    //   120: ifeq +17 -> 137
    //   123: aload_0
    //   124: invokeinterface 154 1 0
    //   129: sipush 26078
    //   132: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: ireturn
    //   137: aload_0
    //   138: invokeinterface 157 1 0
    //   143: pop
    //   144: goto -72 -> 72
    //   147: astore_1
    //   148: ldc 99
    //   150: ldc_w 545
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_1
    //   160: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 393	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_0
    //   168: invokeinterface 154 1 0
    //   173: sipush 26078
    //   176: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_m1
    //   180: ireturn
    //   181: aload_0
    //   182: invokeinterface 154 1 0
    //   187: goto -14 -> 173
    //   190: astore_1
    //   191: aload_0
    //   192: invokeinterface 154 1 0
    //   197: sipush 26078
    //   200: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramString1	String
    //   0	205	1	paramString2	String
    //   96	40	2	i	int
    //   118	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   63	72	147	java/lang/Exception
    //   72	119	147	java/lang/Exception
    //   137	144	147	java/lang/Exception
    //   63	72	190	finally
    //   72	119	190	finally
    //   137	144	190	finally
    //   148	167	190	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a
 * JD-Core Version:    0.7.0.1
 */