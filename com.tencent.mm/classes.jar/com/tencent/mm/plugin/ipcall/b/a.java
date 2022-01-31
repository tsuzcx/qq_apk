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
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.h.a.au;
import com.tencent.mm.h.a.au.a;
import com.tencent.mm.model.bn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static int lAh = 3;
  public static String lAi = "+";
  public static String lAj = "00";
  public static String lAk = null;
  private static ar lAl = new ar();
  private static HashMap<String, b> lAm = new HashMap();
  private static HashMap<String, String> lAn = new HashMap();
  private static HashMap<String, String> lAo = new HashMap();
  private static HashMap<String, String> lAp = new HashMap();
  private static HashMap<String, String> lAq = new HashMap();
  
  public static String FV(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = g.o(c.Gi(paramString).getBytes());
      paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(paramString);
    } while (paramString == null);
    return paramString.getUsername();
  }
  
  public static String FW(String paramString)
  {
    if (!bk.bl(paramString)) {
      return com.tencent.mm.plugin.account.b.getAddrUploadStg().pK(paramString);
    }
    return null;
  }
  
  public static String FX(String paramString)
  {
    if (lAm.size() == 0) {
      bdm();
    }
    if (bk.bl(paramString)) {
      return null;
    }
    paramString = (b)lAm.get(paramString);
    if (paramString != null) {
      return paramString.lAt;
    }
    return null;
  }
  
  public static String FY(String paramString)
  {
    if (lAn.size() == 0) {
      bdm();
    }
    if (bk.bl(paramString)) {
      return null;
    }
    return (String)lAn.get(paramString);
  }
  
  public static String FZ(String paramString)
  {
    if (lAp.size() == 0) {
      bdm();
    }
    if (bk.bl(paramString)) {
      return null;
    }
    return (String)lAp.get(paramString);
  }
  
  public static String Ga(String paramString)
  {
    if (lAn.size() == 0) {
      bdm();
    }
    if (Gc(paramString))
    {
      paramString = c.Gi(Gd(paramString));
      Object localObject = new ArrayList(lAn.keySet());
      Collections.sort((List)localObject, Collections.reverseOrder(new a.a((byte)0)));
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (paramString.startsWith(str)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public static boolean Gb(String paramString)
  {
    if (lAn.size() == 0) {
      bdm();
    }
    return lAn.containsKey(paramString);
  }
  
  public static boolean Gc(String paramString)
  {
    return (!bk.bl(paramString)) && ((paramString.startsWith(lAi)) || (paramString.startsWith(lAj)));
  }
  
  public static String Gd(String paramString)
  {
    String str = paramString;
    if (!bk.bl(paramString))
    {
      if (!paramString.startsWith(lAi)) {
        break label32;
      }
      str = paramString.substring(lAi.length());
    }
    label32:
    do
    {
      return str;
      str = paramString;
    } while (!paramString.startsWith(lAj));
    return paramString.substring(lAj.length());
  }
  
  public static String Ge(String paramString)
  {
    Object localObject = c.Gi(paramString);
    String str = c.Gi((String)localObject);
    paramString = null;
    if (Gc(str)) {
      paramString = Ga(str);
    }
    if (!bk.bl(paramString))
    {
      localObject = Gd(str).substring(paramString.length());
      str = ar.formatNumber(paramString, (String)localObject);
      if (!bk.bl(str)) {
        break label174;
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
        return localObject;
        paramString = "+" + paramString + " " + ((String)localObject).replace("+", "");
        continue;
        paramString = ar.Zs((String)localObject);
      }
      label174:
      localObject = str;
    }
  }
  
  public static String Gf(String paramString)
  {
    if (lAn.size() == 0) {
      bdm();
    }
    Object localObject = paramString;
    if (Gc(paramString))
    {
      paramString = c.Gi(Gd(paramString));
      localObject = new ArrayList(lAn.keySet());
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
      localObject = paramString.substring(((String)localObject).length());
    }
    return localObject;
  }
  
  /* Error */
  public static ArrayList<String> Gg(String paramString)
  {
    // Byte code:
    //   0: new 132	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 225	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   11: ldc 233
    //   13: invokestatic 239	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   16: ifne +12 -> 28
    //   19: ldc 241
    //   21: ldc 243
    //   23: invokestatic 249	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_1
    //   27: areturn
    //   28: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   31: invokevirtual 255	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: getstatic 261	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   37: aconst_null
    //   38: ldc_w 263
    //   41: iconst_1
    //   42: anewarray 72	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: new 192	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 265
    //   54: invokespecial 195	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 265
    //   64: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: invokevirtual 271	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_0
    //   76: aload_0
    //   77: invokeinterface 276 1 0
    //   82: ifeq +74 -> 156
    //   85: aload_0
    //   86: invokeinterface 279 1 0
    //   91: ifne +65 -> 156
    //   94: aload_1
    //   95: aload_0
    //   96: aload_0
    //   97: ldc_w 281
    //   100: invokeinterface 285 2 0
    //   105: invokeinterface 288 2 0
    //   110: invokevirtual 291	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload_0
    //   115: invokeinterface 294 1 0
    //   120: pop
    //   121: goto -36 -> 85
    //   124: astore_2
    //   125: ldc 241
    //   127: ldc_w 296
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 302	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_0
    //   145: ifnull +9 -> 154
    //   148: aload_0
    //   149: invokeinterface 305 1 0
    //   154: aload_1
    //   155: areturn
    //   156: aload_0
    //   157: ifnull -3 -> 154
    //   160: aload_0
    //   161: invokeinterface 305 1 0
    //   166: goto -12 -> 154
    //   169: astore_1
    //   170: aload_0
    //   171: ifnull +9 -> 180
    //   174: aload_0
    //   175: invokeinterface 305 1 0
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   7	148	1	localArrayList	ArrayList
    //   169	12	1	localObject	Object
    //   124	13	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   76	85	124	java/lang/Exception
    //   85	121	124	java/lang/Exception
    //   76	85	169	finally
    //   85	121	169	finally
    //   125	144	169	finally
  }
  
  public static boolean WS()
  {
    au localau = new au();
    com.tencent.mm.sdk.b.a.udP.m(localau);
    y.d("MicroMsg.IPCallAddressUtil", "canSyncAddrBook: %b", new Object[] { Boolean.valueOf(localau.bHa.bFQ) });
    return localau.bHa.bFQ;
  }
  
  public static String av(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.IPCallAddressUtil", "no contact permission");
      paramString = localObject1;
    }
    for (;;)
    {
      return paramString;
      Cursor localCursor = paramContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "contact_id", "data1" }, null, null, null);
      paramContext = localObject2;
      if (localCursor != null) {
        paramContext = localObject2;
      }
      try
      {
        if (localCursor.moveToFirst()) {}
        for (;;)
        {
          paramContext = localObject2;
          if (!localCursor.isAfterLast())
          {
            if (PhoneNumberUtils.compare(com.tencent.mm.pluginsdk.a.qa(paramString), localCursor.getString(1))) {
              paramContext = localCursor.getString(0);
            }
          }
          else
          {
            paramString = paramContext;
            return paramContext;
          }
          localCursor.moveToNext();
        }
      }
      catch (Exception paramContext)
      {
        y.d("MicroMsg.IPCallAddressUtil", "getNicknameByPhonenumber, error: %s", new Object[] { paramContext.getMessage() });
        paramString = localObject1;
        return null;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  public static String aw(Context paramContext, String paramString)
  {
    paramString = av(paramContext, paramString);
    if (!bk.bl(paramString)) {
      return com.tencent.mm.pluginsdk.a.h(paramString, paramContext);
    }
    return null;
  }
  
  public static String ax(Context paramContext, String paramString)
  {
    if (!bk.bl(paramString)) {
      return com.tencent.mm.pluginsdk.a.h(paramString, paramContext);
    }
    return null;
  }
  
  public static Bitmap ay(Context paramContext, String paramString)
  {
    return f(paramContext, paramString, false);
  }
  
  public static Bitmap az(Context paramContext, String paramString)
  {
    String str = av(paramContext, paramString);
    Bitmap localBitmap = null;
    if (!bk.bl(str)) {
      localBitmap = f(paramContext, str, true);
    }
    paramContext = localBitmap;
    if (localBitmap == null)
    {
      paramContext = localBitmap;
      if (WS())
      {
        paramString = FV(paramString);
        y.d("MicroMsg.IPCallAddressUtil", "getAvatarByPhoneNumber, username: %s", new Object[] { paramString });
        paramContext = localBitmap;
        if (!bk.bl(paramString)) {
          paramContext = com.tencent.mm.ag.b.c(paramString, 320, 320, 4);
        }
      }
    }
    return paramContext;
  }
  
  private static void bdm()
  {
    lAn.clear();
    lAo.clear();
    lAp.clear();
    lAq.clear();
    lAm.clear();
    Object localObject4 = null;
    String str2;
    label451:
    for (Object localObject1 = null;; str2 = "")
    {
      for (;;)
      {
        try
        {
          localObject5 = ae.getContext().getAssets().open("ipcall_country_code.txt");
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
          Object localObject5;
          int i;
          localObject4 = localObject2;
          y.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bk.j(localIOException4) });
          if (localObject2 == null) {
            break label451;
          }
          try
          {
            ((InputStream)localObject2).close();
            localObject2 = "";
          }
          catch (IOException localIOException2)
          {
            y.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bk.j(localIOException2) });
            str1 = "";
          }
          continue;
        }
        finally
        {
          if (localObject4 == null) {
            continue;
          }
          try
          {
            localObject4.close();
            throw localObject3;
          }
          catch (IOException localIOException3)
          {
            y.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bk.j(localIOException3) });
            continue;
          }
          Object localObject6 = new b();
          ((b)localObject6).lAr = arrayOfString[0];
          ((b)localObject6).lAs = arrayOfString[1];
          RegionCodeDecoder.cvV();
          str3 = RegionCodeDecoder.getLocName(arrayOfString[0]);
          str2 = str3;
          if (!bk.bl(str3)) {
            continue;
          }
          str2 = new Locale("", arrayOfString[0]).getDisplayCountry(ae.getResources().getConfiguration().locale);
          ((b)localObject6).lAt = str2;
          lAp.put(((b)localObject6).lAs, ((b)localObject6).lAr);
          lAq.put(((b)localObject6).lAr, ((b)localObject6).lAs);
          lAn.put(((b)localObject6).lAs, ((b)localObject6).lAt);
          lAo.put(((b)localObject6).lAt, ((b)localObject6).lAs);
          lAm.put(((b)localObject6).lAr, localObject6);
          continue;
        }
        try
        {
          ((InputStream)localObject5).close();
          localObject1 = localObject6;
        }
        catch (IOException localIOException1)
        {
          y.e("MicroMsg.IPCallAddressUtil", "exception:%s", new Object[] { bk.j(localIOException1) });
          localObject2 = localObject6;
        }
      }
      localObject5 = localObject1.trim().split("\n");
      i = 0;
      for (;;)
      {
        String[] arrayOfString;
        if (i < localObject5.length)
        {
          arrayOfString = localObject5[i].trim().split(" ");
          if (arrayOfString.length < 2)
          {
            y.e("MicroMsg.IPCallAddressUtil", "this country item has problem %s", new Object[] { localObject5[i] });
            i += 1;
            continue;
          }
        }
        Object localObject2;
        String str1;
        String str3;
        return;
      }
    }
  }
  
  public static HashMap<String, b> bdn()
  {
    if (lAm.size() == 0) {
      bdm();
    }
    return lAm;
  }
  
  public static String bdo()
  {
    if (lAo.size() == 0) {
      bdm();
    }
    String str = bk.fS(ae.getContext());
    if (!bk.bl(str))
    {
      y.i("MicroMsg.IPCallAddressUtil", "simCountryCode: %s", new Object[] { str });
      str = str.toUpperCase();
      str = (String)lAq.get(str);
      if (!bk.bl(str)) {
        y.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
      }
    }
    while (!bk.bl(str))
    {
      return str;
      str = "";
    }
    str = bn.Id().countryCode;
    y.i("MicroMsg.IPCallAddressUtil", "personalInfoCountryCode: %s", new Object[] { str });
    if (!bk.bl(str))
    {
      str = (String)lAq.get(str);
      if (!bk.bl(str))
      {
        y.i("MicroMsg.IPCallAddressUtil", "final sim countryCode: %s", new Object[] { str });
        return str;
      }
    }
    str = ae.getContext().getString(R.l.country_normal_code);
    y.i("MicroMsg.IPCallAddressUtil", "fallbackCountryCode: %s", new Object[] { str });
    return str.replace("+", "");
  }
  
  public static void bdp() {}
  
  public static int dE(String paramString1, String paramString2)
  {
    int i;
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      i = -1;
    }
    do
    {
      int j;
      do
      {
        return i;
        j = dF(paramString1, paramString2);
        i = j;
      } while (j != -1);
      i = j;
    } while (!paramString2.startsWith("+"));
    String str2 = Ga(paramString2);
    String str1 = paramString2;
    if (!bk.bl(str2)) {
      str1 = paramString2.substring(("+" + str2).length());
    }
    return dF(paramString1, str1);
  }
  
  /* Error */
  private static int dF(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: ldc 233
    //   5: invokestatic 239	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   8: ifne +12 -> 20
    //   11: ldc 241
    //   13: ldc 243
    //   15: invokestatic 249	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: invokestatic 231	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   23: invokevirtual 255	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: getstatic 261	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   29: aconst_null
    //   30: ldc_w 521
    //   33: iconst_1
    //   34: anewarray 72	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: aconst_null
    //   42: invokevirtual 271	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_0
    //   46: aload_1
    //   47: invokestatic 70	com/tencent/mm/plugin/ipcall/b/c:Gi	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: aload_0
    //   52: invokeinterface 276 1 0
    //   57: ifeq +101 -> 158
    //   60: aload_0
    //   61: invokeinterface 279 1 0
    //   66: ifne +92 -> 158
    //   69: aload_0
    //   70: aload_0
    //   71: ldc_w 523
    //   74: invokeinterface 285 2 0
    //   79: invokeinterface 527 2 0
    //   84: istore_2
    //   85: aload_0
    //   86: aload_0
    //   87: ldc_w 346
    //   90: invokeinterface 285 2 0
    //   95: invokeinterface 288 2 0
    //   100: invokestatic 70	com/tencent/mm/plugin/ipcall/b/c:Gi	(Ljava/lang/String;)Ljava/lang/String;
    //   103: aload_1
    //   104: invokevirtual 530	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: istore_3
    //   108: iload_3
    //   109: ifeq +11 -> 120
    //   112: aload_0
    //   113: invokeinterface 305 1 0
    //   118: iload_2
    //   119: ireturn
    //   120: aload_0
    //   121: invokeinterface 294 1 0
    //   126: pop
    //   127: goto -67 -> 60
    //   130: astore_1
    //   131: ldc 241
    //   133: ldc_w 532
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_1
    //   143: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic 302	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_0
    //   151: invokeinterface 305 1 0
    //   156: iconst_m1
    //   157: ireturn
    //   158: aload_0
    //   159: invokeinterface 305 1 0
    //   164: goto -8 -> 156
    //   167: astore_1
    //   168: aload_0
    //   169: invokeinterface 305 1 0
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    //   84	35	2	i	int
    //   107	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   51	60	130	java/lang/Exception
    //   60	108	130	java/lang/Exception
    //   120	127	130	java/lang/Exception
    //   51	60	167	finally
    //   60	108	167	finally
    //   120	127	167	finally
    //   131	150	167	finally
  }
  
  public static Bitmap f(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (!bk.bl(paramString)) {
      return com.tencent.mm.pluginsdk.a.a(paramString, paramContext, paramBoolean);
    }
    return null;
  }
  
  public static String sU(int paramInt)
  {
    Context localContext = ae.getContext();
    switch (paramInt)
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return localContext.getString(R.l.phone_type_other);
    case 1: 
      return localContext.getString(R.l.phone_type_home);
    case 2: 
      return localContext.getString(R.l.phone_type_mobile);
    case 10: 
      return localContext.getString(R.l.phone_type_company);
    case 4: 
      return localContext.getString(R.l.phone_type_company_fax);
    }
    return localContext.getString(R.l.phone_type_home_fax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.b.a
 * JD-Core Version:    0.7.0.1
 */