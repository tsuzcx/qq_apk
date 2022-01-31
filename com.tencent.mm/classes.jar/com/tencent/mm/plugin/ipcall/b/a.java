package com.tencent.mm.plugin.ipcall.b;

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
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.ax.a;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static HashMap<String, String> nXA;
  private static HashMap<String, String> nXB;
  private static HashMap<String, String> nXC;
  public static int nXt;
  public static String nXu;
  public static String nXv;
  public static String nXw;
  private static av nXx;
  private static HashMap<String, b> nXy;
  private static HashMap<String, String> nXz;
  
  static
  {
    AppMethodBeat.i(22466);
    nXt = 3;
    nXu = "+";
    nXv = "00";
    nXw = null;
    nXx = new av();
    nXy = new HashMap();
    nXz = new HashMap();
    nXA = new HashMap();
    nXB = new HashMap();
    nXC = new HashMap();
    AppMethodBeat.o(22466);
  }
  
  public static String RA(String paramString)
  {
    AppMethodBeat.i(22452);
    if (nXz.size() == 0) {
      bKG();
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22452);
      return null;
    }
    paramString = (String)nXz.get(paramString);
    AppMethodBeat.o(22452);
    return paramString;
  }
  
  public static String RB(String paramString)
  {
    AppMethodBeat.i(22453);
    if (nXB.size() == 0) {
      bKG();
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22453);
      return null;
    }
    paramString = (String)nXB.get(paramString);
    AppMethodBeat.o(22453);
    return paramString;
  }
  
  public static String RC(String paramString)
  {
    AppMethodBeat.i(22456);
    if (nXz.size() == 0) {
      bKG();
    }
    if (RE(paramString))
    {
      paramString = c.RK(RF(paramString));
      Object localObject = new ArrayList(nXz.keySet());
      Collections.sort((List)localObject, Collections.reverseOrder(new a.a((byte)0)));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (paramString.startsWith(str))
        {
          AppMethodBeat.o(22456);
          return str;
        }
      }
    }
    AppMethodBeat.o(22456);
    return null;
  }
  
  public static boolean RD(String paramString)
  {
    AppMethodBeat.i(22457);
    if (nXz.size() == 0) {
      bKG();
    }
    if (nXz.containsKey(paramString))
    {
      AppMethodBeat.o(22457);
      return true;
    }
    AppMethodBeat.o(22457);
    return false;
  }
  
  public static boolean RE(String paramString)
  {
    AppMethodBeat.i(22458);
    if ((!bo.isNullOrNil(paramString)) && ((paramString.startsWith(nXu)) || (paramString.startsWith(nXv))))
    {
      AppMethodBeat.o(22458);
      return true;
    }
    AppMethodBeat.o(22458);
    return false;
  }
  
  public static String RF(String paramString)
  {
    AppMethodBeat.i(22459);
    if (!bo.isNullOrNil(paramString))
    {
      if (paramString.startsWith(nXu))
      {
        paramString = paramString.substring(nXu.length());
        AppMethodBeat.o(22459);
        return paramString;
      }
      if (paramString.startsWith(nXv))
      {
        paramString = paramString.substring(nXv.length());
        AppMethodBeat.o(22459);
        return paramString;
      }
    }
    AppMethodBeat.o(22459);
    return paramString;
  }
  
  public static String RG(String paramString)
  {
    AppMethodBeat.i(22460);
    Object localObject = c.RK(paramString);
    String str = c.RK((String)localObject);
    paramString = null;
    if (RE(str)) {
      paramString = RC(str);
    }
    if (!bo.isNullOrNil(paramString))
    {
      localObject = RF(str).substring(paramString.length());
      str = av.formatNumber(paramString, (String)localObject);
      if (!bo.isNullOrNil(str)) {
        break label186;
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
        AppMethodBeat.o(22460);
        return localObject;
        paramString = "+" + paramString + " " + ((String)localObject).replace("+", "");
        continue;
        paramString = av.apx((String)localObject);
      }
      label186:
      localObject = str;
    }
  }
  
  public static String RH(String paramString)
  {
    AppMethodBeat.i(22463);
    if (nXz.size() == 0) {
      bKG();
    }
    Object localObject = paramString;
    if (RE(paramString))
    {
      paramString = c.RK(RF(paramString));
      localObject = new ArrayList(nXz.keySet());
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
      AppMethodBeat.o(22463);
      return paramString;
    }
    AppMethodBeat.o(22463);
    return localObject;
  }
  
  /* Error */
  public static ArrayList<String> RI(String paramString)
  {
    // Byte code:
    //   0: sipush 22465
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 102	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 196	java/util/ArrayList:<init>	()V
    //   13: astore_1
    //   14: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   17: ldc 204
    //   19: invokestatic 209	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   22: ifne +18 -> 40
    //   25: ldc 211
    //   27: ldc 213
    //   29: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: sipush 22465
    //   35: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   43: invokevirtual 225	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: getstatic 231	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   49: aconst_null
    //   50: ldc 233
    //   52: iconst_1
    //   53: anewarray 87	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: new 162	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 235
    //   64: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 235
    //   73: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   113: invokeinterface 258 2 0
    //   118: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: invokeinterface 264 1 0
    //   128: pop
    //   129: goto -35 -> 94
    //   132: astore_2
    //   133: ldc 211
    //   135: ldc_w 266
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_2
    //   145: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_0
    //   153: ifnull +9 -> 162
    //   156: aload_0
    //   157: invokeinterface 275 1 0
    //   162: sipush 22465
    //   165: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: areturn
    //   170: aload_0
    //   171: ifnull -9 -> 162
    //   174: aload_0
    //   175: invokeinterface 275 1 0
    //   180: goto -18 -> 162
    //   183: astore_1
    //   184: aload_0
    //   185: ifnull +9 -> 194
    //   188: aload_0
    //   189: invokeinterface 275 1 0
    //   194: sipush 22465
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
  
  public static String Rx(String paramString)
  {
    AppMethodBeat.i(22446);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22446);
      return null;
    }
    paramString = g.w(c.RK(paramString).getBytes());
    paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().xc(paramString);
    AppMethodBeat.o(22446);
    return paramString;
  }
  
  public static String Ry(String paramString)
  {
    AppMethodBeat.i(22447);
    if (!bo.isNullOrNil(paramString))
    {
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().xd(paramString);
      AppMethodBeat.o(22447);
      return paramString;
    }
    AppMethodBeat.o(22447);
    return null;
  }
  
  public static String Rz(String paramString)
  {
    AppMethodBeat.i(22451);
    if (nXy.size() == 0) {
      bKG();
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22451);
      return null;
    }
    paramString = (b)nXy.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.nXF;
      AppMethodBeat.o(22451);
      return paramString;
    }
    AppMethodBeat.o(22451);
    return null;
  }
  
  public static String aE(Context paramContext, String paramString)
  {
    localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(22440);
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.IPCallAddressUtil", "no contact permission");
      AppMethodBeat.o(22440);
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
            if (!PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.xw(paramString), localCursor.getString(1))) {
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
        ab.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[] { paramContext.getMessage() });
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
        AppMethodBeat.o(22440);
      }
      AppMethodBeat.o(22440);
      return paramString;
      localCursor.moveToNext();
    }
  }
  
  public static String aF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(22441);
    paramString = aE(paramContext, paramString);
    if (!bo.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.a.j(paramString, paramContext);
      AppMethodBeat.o(22441);
      return paramContext;
    }
    AppMethodBeat.o(22441);
    return null;
  }
  
  public static String aG(Context paramContext, String paramString)
  {
    AppMethodBeat.i(22442);
    if (!bo.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.a.j(paramString, paramContext);
      AppMethodBeat.o(22442);
      return paramContext;
    }
    AppMethodBeat.o(22442);
    return null;
  }
  
  public static Bitmap aH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(22443);
    paramContext = f(paramContext, paramString, false);
    AppMethodBeat.o(22443);
    return paramContext;
  }
  
  public static Bitmap aI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(22445);
    String str = aE(paramContext, paramString);
    Bitmap localBitmap = null;
    if (!bo.isNullOrNil(str)) {
      localBitmap = f(paramContext, str, true);
    }
    paramContext = localBitmap;
    if (localBitmap == null)
    {
      paramContext = localBitmap;
      if (aqt())
      {
        paramString = Rx(paramString);
        ab.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[] { paramString });
        paramContext = localBitmap;
        if (!bo.isNullOrNil(paramString)) {
          paramContext = com.tencent.mm.ah.b.d(paramString, 320, 320, 4);
        }
      }
    }
    AppMethodBeat.o(22445);
    return paramContext;
  }
  
  public static boolean aqt()
  {
    AppMethodBeat.i(22464);
    ax localax = new ax();
    com.tencent.mm.sdk.b.a.ymk.l(localax);
    ab.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[] { Boolean.valueOf(localax.cop.cmX) });
    boolean bool = localax.cop.cmX;
    AppMethodBeat.o(22464);
    return bool;
  }
  
  private static void bKG()
  {
    AppMethodBeat.i(22449);
    nXz.clear();
    nXA.clear();
    nXB.clear();
    nXC.clear();
    nXy.clear();
    Object localObject4 = null;
    label105:
    String str2;
    for (Object localObject1 = null;; str2 = "")
    {
      try
      {
        localObject5 = ah.getContext().getAssets().open("ipcall_country_code.txt");
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
          ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bo.l(localIOException4) });
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
            ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bo.l(localIOException2) });
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
            AppMethodBeat.o(22449);
            throw localObject3;
          }
          catch (IOException localIOException3)
          {
            for (;;)
            {
              ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bo.l(localIOException3) });
            }
          }
          Object localObject6 = new b();
          ((b)localObject6).nXD = arrayOfString[0];
          ((b)localObject6).nXE = arrayOfString[1];
          RegionCodeDecoder.dyE();
          String str3 = RegionCodeDecoder.getLocName(arrayOfString[0]);
          str2 = str3;
          if (bo.isNullOrNil(str3)) {
            str2 = new Locale("", arrayOfString[0]).getDisplayCountry(ah.getResources().getConfiguration().locale);
          }
          ((b)localObject6).nXF = str2;
          nXB.put(((b)localObject6).nXE, ((b)localObject6).nXD);
          nXC.put(((b)localObject6).nXD, ((b)localObject6).nXE);
          nXz.put(((b)localObject6).nXE, ((b)localObject6).nXF);
          nXA.put(((b)localObject6).nXF, ((b)localObject6).nXE);
          nXy.put(((b)localObject6).nXD, localObject6);
        }
        label462:
        AppMethodBeat.o(22449);
        return;
      }
      try
      {
        ((InputStream)localObject5).close();
        localObject1 = localObject6;
      }
      catch (IOException localIOException1)
      {
        ab.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bo.l(localIOException1) });
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
        ab.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[] { localObject5[i] });
        i += 1;
      }
    }
  }
  
  public static HashMap<String, b> bKH()
  {
    AppMethodBeat.i(22450);
    if (nXy.size() == 0) {
      bKG();
    }
    HashMap localHashMap = nXy;
    AppMethodBeat.o(22450);
    return localHashMap;
  }
  
  public static String bKI()
  {
    AppMethodBeat.i(22461);
    if (nXA.size() == 0) {
      bKG();
    }
    String str = bo.hi(ah.getContext());
    if (!bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[] { str });
      str = str.toUpperCase();
      str = (String)nXC.get(str);
      if (!bo.isNullOrNil(str)) {
        ab.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
      }
    }
    while (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(22461);
      return str;
      str = "";
    }
    str = bp.aba().countryCode;
    ab.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[] { str });
    if (!bo.isNullOrNil(str))
    {
      str = (String)nXC.get(str);
      if (!bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
        AppMethodBeat.o(22461);
        return str;
      }
    }
    str = ah.getContext().getString(2131298872);
    ab.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[] { str });
    str = str.replace("+", "");
    AppMethodBeat.o(22461);
    return str;
  }
  
  public static void bKJ()
  {
    AppMethodBeat.i(22462);
    bKG();
    AppMethodBeat.o(22462);
  }
  
  public static int eW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(22454);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(22454);
      return -1;
    }
    int j = eX(paramString1, paramString2);
    int i = j;
    if (j == -1)
    {
      i = j;
      if (paramString2.startsWith("+"))
      {
        String str2 = RC(paramString2);
        String str1 = paramString2;
        if (!bo.isNullOrNil(str2)) {
          str1 = paramString2.substring("+".concat(String.valueOf(str2)).length());
        }
        i = eX(paramString1, str1);
      }
    }
    AppMethodBeat.o(22454);
    return i;
  }
  
  /* Error */
  private static int eX(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 22455
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   9: ldc 204
    //   11: invokestatic 209	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +18 -> 32
    //   17: ldc 211
    //   19: ldc 213
    //   21: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 22455
    //   27: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_m1
    //   31: ireturn
    //   32: invokestatic 202	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   35: invokevirtual 225	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 231	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   41: aconst_null
    //   42: ldc_w 523
    //   45: iconst_1
    //   46: anewarray 87	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_0
    //   52: aastore
    //   53: aconst_null
    //   54: invokevirtual 241	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore_0
    //   58: aload_1
    //   59: invokestatic 100	com/tencent/mm/plugin/ipcall/b/c:RK	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokeinterface 246 1 0
    //   69: ifeq +113 -> 182
    //   72: aload_0
    //   73: invokeinterface 249 1 0
    //   78: ifne +104 -> 182
    //   81: aload_0
    //   82: aload_0
    //   83: ldc_w 525
    //   86: invokeinterface 255 2 0
    //   91: invokeinterface 529 2 0
    //   96: istore_2
    //   97: aload_0
    //   98: aload_0
    //   99: ldc_w 313
    //   102: invokeinterface 255 2 0
    //   107: invokeinterface 258 2 0
    //   112: invokestatic 100	com/tencent/mm/plugin/ipcall/b/c:RK	(Ljava/lang/String;)Ljava/lang/String;
    //   115: aload_1
    //   116: invokevirtual 532	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: istore_3
    //   120: iload_3
    //   121: ifeq +17 -> 138
    //   124: aload_0
    //   125: invokeinterface 275 1 0
    //   130: sipush 22455
    //   133: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iload_2
    //   137: ireturn
    //   138: aload_0
    //   139: invokeinterface 264 1 0
    //   144: pop
    //   145: goto -73 -> 72
    //   148: astore_1
    //   149: ldc 211
    //   151: ldc_w 534
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_1
    //   161: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_0
    //   169: invokeinterface 275 1 0
    //   174: sipush 22455
    //   177: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_m1
    //   181: ireturn
    //   182: aload_0
    //   183: invokeinterface 275 1 0
    //   188: goto -14 -> 174
    //   191: astore_1
    //   192: aload_0
    //   193: invokeinterface 275 1 0
    //   198: sipush 22455
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
  
  public static Bitmap f(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(22444);
    if (!bo.isNullOrNil(paramString))
    {
      paramContext = com.tencent.mm.pluginsdk.a.a(paramString, paramContext, paramBoolean);
      AppMethodBeat.o(22444);
      return paramContext;
    }
    AppMethodBeat.o(22444);
    return null;
  }
  
  public static String xW(int paramInt)
  {
    AppMethodBeat.i(22448);
    Object localObject = ah.getContext();
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      localObject = ((Context)localObject).getString(2131302093);
      AppMethodBeat.o(22448);
      return localObject;
    case 1: 
      localObject = ((Context)localObject).getString(2131302090);
      AppMethodBeat.o(22448);
      return localObject;
    case 2: 
      localObject = ((Context)localObject).getString(2131302092);
      AppMethodBeat.o(22448);
      return localObject;
    case 10: 
      localObject = ((Context)localObject).getString(2131302088);
      AppMethodBeat.o(22448);
      return localObject;
    case 4: 
      localObject = ((Context)localObject).getString(2131302089);
      AppMethodBeat.o(22448);
      return localObject;
    }
    localObject = ((Context)localObject).getString(2131302091);
    AppMethodBeat.o(22448);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.b.a
 * JD-Core Version:    0.7.0.1
 */