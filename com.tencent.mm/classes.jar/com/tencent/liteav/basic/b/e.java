package com.tencent.liteav.basic.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private static e d;
  private Context a;
  private String b;
  private String c;
  private a e;
  private a f;
  
  private e()
  {
    AppMethodBeat.i(14648);
    this.b = "YTFaceSDK.licence";
    this.c = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
    this.e = new a("TXUgcSDK.licence");
    this.f = new a("TXLiveSDK.licence");
    AppMethodBeat.o(14648);
  }
  
  private int a(a parama, Context paramContext)
  {
    AppMethodBeat.i(14656);
    if (parama.g)
    {
      AppMethodBeat.o(14656);
      return 0;
    }
    if (this.a == null) {
      this.a = paramContext;
    }
    if (d(parama) == 0)
    {
      parama.g = true;
      AppMethodBeat.o(14656);
      return 0;
    }
    int i = c(parama);
    if (i == 0)
    {
      parama.g = true;
      AppMethodBeat.o(14656);
      return 0;
    }
    AppMethodBeat.o(14656);
    return i;
  }
  
  private int a(a parama, g paramg, Context paramContext)
  {
    AppMethodBeat.i(14655);
    int i = a(parama, paramContext);
    if (i != 0) {
      a(parama);
    }
    if (paramg != null) {
      paramg.a = parama.i;
    }
    AppMethodBeat.o(14655);
    return i;
  }
  
  private int a(a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14668);
    Object localObject;
    boolean bool1;
    try
    {
      localObject = a(this.c);
      bool1 = a(Base64.decode(paramString1, 0), Base64.decode(paramString2, 0), (PublicKey)localObject);
      if (!bool1)
      {
        a(-2);
        TXCLog.e("LicenceCheck", "verifyLicence, signature not pass!");
        AppMethodBeat.o(14668);
        return -2;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        TXCLog.e("LicenceCheck", "verifyLicence, exception is : ".concat(String.valueOf(paramString2)));
        bool1 = false;
      }
      paramString1 = c(parama, paramString1);
      if (TextUtils.isEmpty(paramString1))
      {
        a(-3);
        TXCLog.e("LicenceCheck", "verifyLicence, decodeValue is empty!");
        AppMethodBeat.o(14668);
        return -3;
      }
      parama.i = paramString1;
    }
    for (;;)
    {
      int k;
      try
      {
        paramString2 = new JSONObject(paramString1);
        paramString1 = paramString2.getString("pituLicense");
        paramString2 = paramString2.optJSONArray("appData");
        if (paramString2 == null)
        {
          TXCLog.e("LicenceCheck", "verifyLicence, appDataArray is null!");
          a(-1);
          AppMethodBeat.o(14668);
          return -1;
        }
        int j = 0;
        int i = 0;
        bool1 = false;
        k = 0;
        boolean bool2 = bool1;
        int n = i;
        int m = j;
        if (k < paramString2.length())
        {
          localObject = paramString2.getJSONObject(k);
          String str = ((JSONObject)localObject).optString("packageName");
          TXCLog.i("LicenceCheck", "verifyLicence, packageName:".concat(String.valueOf(str)));
          if (!str.equals(this.a.getPackageName()))
          {
            TXCLog.e("LicenceCheck", "verifyLicence, packageName not match!");
          }
          else
          {
            int i1 = 1;
            m = 1;
            j = i1;
            if (!d(((JSONObject)localObject).optString("endDate")))
            {
              i = 1;
              n = 1;
              bool2 = a(parama, (JSONObject)localObject, paramString1);
              bool1 = bool2;
              j = i1;
              if (bool2) {
                bool2 = true;
              }
            }
          }
        }
        else
        {
          if (m == 0)
          {
            a(-4);
            AppMethodBeat.o(14668);
            return -4;
          }
          if (n == 0)
          {
            a(-5);
            AppMethodBeat.o(14668);
            return -5;
          }
          if (!bool2)
          {
            a(-11);
            AppMethodBeat.o(14668);
            return -11;
          }
          bool1 = TextUtils.isEmpty(paramString1);
          if (!bool1) {}
          try
          {
            parama = Base64.decode(paramString1, 0);
            paramString1 = this.a.getExternalFilesDir(null);
            if (paramString1 == null)
            {
              AppMethodBeat.o(14668);
              return -10;
            }
            paramString1 = paramString1.getAbsolutePath();
            paramString1 = new File(paramString1 + File.separator + this.b);
            com.tencent.liteav.basic.util.c.a(paramString1.getAbsolutePath(), parama);
            TXCCommonUtil.setPituLicencePath(paramString1.getAbsolutePath());
          }
          catch (Exception parama)
          {
            TXCLog.e("LicenceCheck", "decode pitu license error:".concat(String.valueOf(parama)));
            continue;
          }
          TXCDRApi.txReportDAU(this.a, a.aI);
          AppMethodBeat.o(14668);
          return 0;
        }
      }
      catch (JSONException parama)
      {
        TXCLog.e("LicenceCheck", "verifyLicence, json format error ! exception = ".concat(String.valueOf(parama)));
        a(-1);
        AppMethodBeat.o(14668);
        return -1;
      }
      k += 1;
    }
  }
  
  public static e a()
  {
    AppMethodBeat.i(14647);
    if (d == null) {
      d = new e();
    }
    e locale = d;
    AppMethodBeat.o(14647);
    return locale;
  }
  
  private static String a(Context paramContext)
  {
    AppMethodBeat.i(14673);
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i)
      {
        paramContext = localRunningAppProcessInfo.processName;
        AppMethodBeat.o(14673);
        return paramContext;
      }
    }
    AppMethodBeat.o(14673);
    return "";
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(14670);
    TXCDRApi.txReportDAU(this.a, a.aJ, paramInt, "");
    AppMethodBeat.o(14670);
  }
  
  private void a(a parama, Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14650);
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
    parama.d = paramString2;
    parama.e = paramString1;
    if ((this.a != null) && (b()))
    {
      paramContext = this.a.getExternalFilesDir(null);
      if (paramContext != null) {
        parama.c = paramContext.getAbsolutePath();
      }
      if (!b(parama.c + File.separator + parama.a))
      {
        TXCLog.i("LicenceCheck", "setLicense, sdcard file not exist, to download");
        b(parama, "");
      }
      a(parama);
    }
    AppMethodBeat.o(14650);
  }
  
  private boolean a(a parama, JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(14669);
    int i = paramJSONObject.optInt("feature");
    if (parama == this.f)
    {
      i = i >> 4 & 0xF;
      if (i <= 0) {
        break label196;
      }
      parama.h = i;
    }
    for (;;)
    {
      TXCLog.i("LicenceCheck", "live parseVersionType, mLicenceVersionType = " + parama.h);
      for (;;)
      {
        AppMethodBeat.o(14669);
        return bool1;
        if (parama == this.e)
        {
          int j = i & 0xF;
          if (j <= 1)
          {
            if ((j != 1) && (i != 0)) {
              break label184;
            }
            if (!TextUtils.isEmpty(paramString))
            {
              parama.h = 5;
              bool1 = bool2;
            }
          }
          for (;;)
          {
            TXCLog.i("LicenceCheck", "ugc parseVersionType, mLicenceVersionType = " + parama.h);
            break;
            parama.h = 3;
            bool1 = bool2;
            continue;
            parama.h = j;
            bool1 = bool2;
            continue;
            label184:
            bool1 = false;
          }
        }
        bool1 = false;
      }
      label196:
      bool1 = false;
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    AppMethodBeat.i(14676);
    Signature localSignature = Signature.getInstance("SHA256WithRSA");
    localSignature.initVerify(paramPublicKey);
    localSignature.update(paramArrayOfByte1);
    boolean bool = localSignature.verify(paramArrayOfByte2);
    AppMethodBeat.o(14676);
    return bool;
  }
  
  private String b(a parama)
  {
    AppMethodBeat.i(14653);
    if (this.a == null)
    {
      AppMethodBeat.o(14653);
      return null;
    }
    parama = this.a.getSharedPreferences("LicenceCheck.lastModified", 0).getString(parama.a + ".lastModified", null);
    AppMethodBeat.o(14653);
    return parama;
  }
  
  private void b(a parama, String paramString)
  {
    AppMethodBeat.i(14654);
    if (this.a == null)
    {
      AppMethodBeat.o(14654);
      return;
    }
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("LicenceCheck.lastModified", 0).edit();
    localEditor.putString(parama.a + ".lastModified", paramString);
    localEditor.commit();
    AppMethodBeat.o(14654);
  }
  
  private boolean b()
  {
    AppMethodBeat.i(14660);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      AppMethodBeat.o(14660);
      return false;
    }
    if (this.a.getExternalFilesDir(null) == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      AppMethodBeat.o(14660);
      return false;
    }
    AppMethodBeat.o(14660);
    return true;
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(14662);
    boolean bool = com.tencent.liteav.basic.util.c.a(paramString);
    AppMethodBeat.o(14662);
    return bool;
  }
  
  private int c(a parama)
  {
    AppMethodBeat.i(14657);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      AppMethodBeat.o(14657);
      return -10;
    }
    Object localObject = this.a.getExternalFilesDir(null);
    if (localObject == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      AppMethodBeat.o(14657);
      return -10;
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + parama.a;
    if (!b((String)localObject))
    {
      AppMethodBeat.o(14657);
      return -7;
    }
    localObject = com.tencent.liteav.basic.util.c.b((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
      AppMethodBeat.o(14657);
      return -8;
    }
    int i = a(parama, (String)localObject);
    AppMethodBeat.o(14657);
    return i;
  }
  
  private static long c(String paramString)
  {
    AppMethodBeat.i(14664);
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      AppMethodBeat.o(14664);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(14664);
    }
    return -1L;
  }
  
  private String c(a parama, String paramString)
  {
    AppMethodBeat.i(14666);
    if (TextUtils.isEmpty(parama.d))
    {
      TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
      AppMethodBeat.o(14666);
      return "";
    }
    Object localObject1 = parama.d.getBytes();
    parama = new SecretKeySpec((byte[])localObject1, "AES");
    Object localObject2 = new byte[16];
    int i = 0;
    while ((i < localObject1.length) && (i < 16))
    {
      localObject2[i] = localObject1[i];
      i += 1;
    }
    localObject1 = new IvParameterSpec((byte[])localObject2);
    paramString = Base64.decode(paramString, 0);
    try
    {
      localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject2).init(2, parama, (AlgorithmParameterSpec)localObject1);
      parama = new String(((Cipher)localObject2).doFinal(paramString), "UTF-8");
      TXCLog.i("LicenceCheck", "decodeLicence : ".concat(String.valueOf(parama)));
      AppMethodBeat.o(14666);
      return parama;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        parama = null;
      }
    }
  }
  
  private int d(a parama)
  {
    AppMethodBeat.i(14658);
    if (!e(parama))
    {
      AppMethodBeat.o(14658);
      return -6;
    }
    String str = com.tencent.liteav.basic.util.c.b(this.a, parama.a);
    if (TextUtils.isEmpty(str))
    {
      TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
      AppMethodBeat.o(14658);
      return -8;
    }
    int i = a(parama, str);
    AppMethodBeat.o(14658);
    return i;
  }
  
  private int d(a parama, String paramString)
  {
    AppMethodBeat.i(14667);
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt("appId");
      paramString = ((JSONObject)localObject).getString("encryptedLicense");
      localObject = ((JSONObject)localObject).getString("signature");
      TXCLog.i("LicenceCheck", "appid:".concat(String.valueOf(i)));
      TXCLog.i("LicenceCheck", "encryptedLicense:".concat(String.valueOf(paramString)));
      TXCLog.i("LicenceCheck", "signature:".concat(String.valueOf(localObject)));
      i = a(parama, paramString, (String)localObject);
      AppMethodBeat.o(14667);
      return i;
    }
    catch (JSONException parama)
    {
      a(-1);
      AppMethodBeat.o(14667);
    }
    return -1;
  }
  
  private boolean d(String paramString)
  {
    AppMethodBeat.i(14671);
    long l = c(paramString);
    if (l < 0L)
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
      AppMethodBeat.o(14671);
      return true;
    }
    if (l < System.currentTimeMillis())
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
      AppMethodBeat.o(14671);
      return true;
    }
    AppMethodBeat.o(14671);
    return false;
  }
  
  private int e(a parama, String paramString)
  {
    AppMethodBeat.i(14672);
    paramString = e(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
      AppMethodBeat.o(14672);
      return -3;
    }
    parama.i = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.getString("packagename").equals(a(this.a)))
      {
        TXCLog.e("LicenceCheck", "packagename not match!");
        a(-4);
        AppMethodBeat.o(14672);
        return -4;
      }
      boolean bool = d(paramString.getString("enddate"));
      if (bool)
      {
        AppMethodBeat.o(14672);
        return -5;
      }
    }
    catch (JSONException parama)
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
      a(-1);
      AppMethodBeat.o(14672);
      return -1;
    }
    parama.h = 5;
    TXCDRApi.txReportDAU(this.a, a.aI);
    AppMethodBeat.o(14672);
    return 0;
  }
  
  private String e(String paramString)
  {
    AppMethodBeat.i(14674);
    try
    {
      byte[] arrayOfByte = Base64.decode("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv", 0);
      paramString = new String(i.b(Base64.decode(paramString, 0), arrayOfByte));
      AppMethodBeat.o(14674);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        TXCLog.e("LicenceCheck", "decryptLicenceStr, exception is : ".concat(String.valueOf(paramString)));
        paramString = null;
      }
    }
  }
  
  private boolean e(a parama)
  {
    AppMethodBeat.i(14661);
    boolean bool = com.tencent.liteav.basic.util.c.a(this.a, parama.a);
    AppMethodBeat.o(14661);
    return bool;
  }
  
  private void f(a parama)
  {
    AppMethodBeat.i(14663);
    File localFile1 = this.a.getExternalFilesDir(null);
    if (localFile1 == null)
    {
      TXCLog.i("LicenceCheck", "saveTempLocal sdcardDir is null");
      AppMethodBeat.o(14663);
      return;
    }
    localFile1 = new File(localFile1.getAbsolutePath() + File.separator + parama.a);
    if (localFile1.exists()) {
      TXCLog.i("LicenceCheck", "delete dst file:".concat(String.valueOf(localFile1.delete())));
    }
    File localFile2 = new File(parama.c + File.separator + parama.b);
    if (localFile2.exists()) {
      TXCLog.i("LicenceCheck", "rename file:".concat(String.valueOf(localFile2.renameTo(localFile1))));
    }
    parama.g = true;
    AppMethodBeat.o(14663);
  }
  
  private String g(a parama)
  {
    AppMethodBeat.i(14675);
    parama = com.tencent.liteav.basic.util.c.b(new File(parama.c + File.separator + parama.b).getAbsolutePath());
    AppMethodBeat.o(14675);
    return parama;
  }
  
  public int a(a parama, String paramString)
  {
    AppMethodBeat.i(14659);
    int i;
    try
    {
      new JSONObject(paramString);
      i = d(parama, paramString);
      AppMethodBeat.o(14659);
      return i;
    }
    catch (JSONException localJSONException)
    {
      if (parama == this.f)
      {
        AppMethodBeat.o(14659);
        return -1;
      }
      i = e(parama, paramString);
      AppMethodBeat.o(14659);
    }
    return i;
  }
  
  public int a(g paramg, Context paramContext)
  {
    AppMethodBeat.i(14652);
    int i = a(this.f, paramg, paramContext);
    AppMethodBeat.o(14652);
    return i;
  }
  
  public PublicKey a(String paramString)
  {
    AppMethodBeat.i(14665);
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    AppMethodBeat.o(14665);
    return paramString;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14649);
    a(this.f, paramContext, paramString1, paramString2);
    AppMethodBeat.o(14649);
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(14651);
    if (TextUtils.isEmpty(parama.e))
    {
      TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
      AppMethodBeat.o(14651);
      return;
    }
    if (parama.f)
    {
      TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
      AppMethodBeat.o(14651);
      return;
    }
    b local1 = new b()
    {
      public void a()
      {
        AppMethodBeat.i(14640);
        TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
        parama.f = false;
        AppMethodBeat.o(14640);
      }
      
      public void a(int paramAnonymousInt)
      {
        AppMethodBeat.i(14639);
        TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
        AppMethodBeat.o(14639);
      }
      
      public void a(File paramAnonymousFile, Exception paramAnonymousException)
      {
        AppMethodBeat.i(14638);
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
        AppMethodBeat.o(14638);
      }
      
      public void a(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(14637);
        if (paramAnonymousFile == null)
        {
          TXCLog.i("LicenceCheck", "downloadLicense, license not modified");
          AppMethodBeat.o(14637);
          return;
        }
        e.a(e.this, parama, paramAnonymousString);
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
        paramAnonymousFile = e.a(e.this, parama);
        if (TextUtils.isEmpty(paramAnonymousFile))
        {
          TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
          parama.f = false;
          AppMethodBeat.o(14637);
          return;
        }
        if (e.b(e.this, parama, paramAnonymousFile) == 0) {
          e.b(e.this, parama);
        }
        AppMethodBeat.o(14637);
      }
    };
    if (this.a == null)
    {
      TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
      AppMethodBeat.o(14651);
      return;
    }
    File localFile = this.a.getExternalFilesDir(null);
    if (localFile == null)
    {
      TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
      AppMethodBeat.o(14651);
      return;
    }
    String str = b(parama);
    parama.c = localFile.getAbsolutePath();
    new Thread(new c(this.a, parama.e, parama.c, parama.b, local1, false, str)).start();
    parama.f = true;
    AppMethodBeat.o(14651);
  }
  
  class a
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    boolean f;
    boolean g;
    int h;
    String i;
    
    public a(String paramString)
    {
      AppMethodBeat.i(14641);
      this.a = paramString;
      this.b = (paramString + ".tmp");
      this.c = "";
      this.d = "";
      this.e = "";
      this.f = false;
      this.g = false;
      this.h = -1;
      this.i = "";
      AppMethodBeat.o(14641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.b.e
 * JD-Core Version:    0.7.0.1
 */