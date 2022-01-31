package com.tencent.liteav.basic.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.Key;
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
  private static e l;
  private Context a;
  private String b;
  private String c;
  private String d = "TXUgcSDK.licence";
  private String e = "tmp.licence";
  private String f = "YTFaceSDK.licence";
  private String g = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
  private String h;
  private String i;
  private String j;
  private boolean k = false;
  private boolean m = false;
  private int n = -1;
  
  private int a(f paramf)
  {
    AppMethodBeat.i(146711);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      AppMethodBeat.o(146711);
      return -10;
    }
    Object localObject = this.a.getExternalFilesDir(null);
    if (localObject == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      AppMethodBeat.o(146711);
      return -10;
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + this.d;
    if (!b((String)localObject))
    {
      AppMethodBeat.o(146711);
      return -7;
    }
    localObject = com.tencent.liteav.basic.util.a.b((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
      AppMethodBeat.o(146711);
      return -8;
    }
    int i1 = a((String)localObject, paramf);
    AppMethodBeat.o(146711);
    return i1;
  }
  
  public static e a()
  {
    AppMethodBeat.i(146706);
    if (l == null) {
      l = new e();
    }
    e locale = l;
    AppMethodBeat.o(146706);
    return locale;
  }
  
  private static String a(Context paramContext)
  {
    AppMethodBeat.i(146727);
    int i1 = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i1)
      {
        paramContext = localRunningAppProcessInfo.processName;
        AppMethodBeat.o(146727);
        return paramContext;
      }
    }
    AppMethodBeat.o(146727);
    return "";
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(146724);
    TXCDRApi.txReportDAU(this.a, com.tencent.liteav.basic.datareport.a.aJ, paramInt, "");
    AppMethodBeat.o(146724);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(146723);
    int i1 = paramJSONObject.optInt("feature");
    if (i1 <= 1)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (this.n = 5;; this.n = 3)
      {
        TXCLog.i("LicenceCheck", "parseVersionType, licence is old, mLicenceVersionType = " + this.n);
        AppMethodBeat.o(146723);
        return;
      }
    }
    this.n = (i1 & 0xF);
    TXCLog.i("LicenceCheck", "parseVersionType, mLicenceVersionType = " + this.n);
    AppMethodBeat.o(146723);
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    AppMethodBeat.i(146730);
    Signature localSignature = Signature.getInstance("SHA256WithRSA");
    localSignature.initVerify(paramPublicKey);
    localSignature.update(paramArrayOfByte1);
    boolean bool = localSignature.verify(paramArrayOfByte2);
    AppMethodBeat.o(146730);
    return bool;
  }
  
  private int b(f paramf)
  {
    AppMethodBeat.i(146712);
    if (!d())
    {
      AppMethodBeat.o(146712);
      return -6;
    }
    String str = com.tencent.liteav.basic.util.a.b(this.a, this.d);
    if (TextUtils.isEmpty(str))
    {
      TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
      AppMethodBeat.o(146712);
      return -8;
    }
    int i1 = a(str, paramf);
    AppMethodBeat.o(146712);
    return i1;
  }
  
  private int b(f paramf, Context paramContext)
  {
    AppMethodBeat.i(146710);
    if (this.m)
    {
      AppMethodBeat.o(146710);
      return 0;
    }
    if (this.a == null) {
      this.a = paramContext;
    }
    if (b(paramf) == 0)
    {
      this.m = true;
      AppMethodBeat.o(146710);
      return 0;
    }
    int i1 = a(paramf);
    if (i1 == 0)
    {
      this.m = true;
      AppMethodBeat.o(146710);
      return 0;
    }
    AppMethodBeat.o(146710);
    return i1;
  }
  
  private int b(String paramString, f paramf)
  {
    AppMethodBeat.i(146721);
    try
    {
      paramString = new JSONObject(paramString);
      int i1 = paramString.optInt("appId");
      this.i = paramString.getString("encryptedLicense");
      this.j = paramString.getString("signature");
      TXCLog.i("LicenceCheck", "appid:".concat(String.valueOf(i1)));
      TXCLog.i("LicenceCheck", "encryptedLicense:" + this.i);
      TXCLog.i("LicenceCheck", "signature:" + this.j);
      i1 = c(paramf);
      AppMethodBeat.o(146721);
      return i1;
    }
    catch (JSONException paramString)
    {
      this.i = null;
      this.j = null;
      a(-1);
      AppMethodBeat.o(146721);
    }
    return -1;
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(146716);
    boolean bool = com.tencent.liteav.basic.util.a.a(paramString);
    AppMethodBeat.o(146716);
    return bool;
  }
  
  private int c(f paramf)
  {
    AppMethodBeat.i(146722);
    Object localObject;
    try
    {
      PublicKey localPublicKey = a(this.g);
      bool = a(Base64.decode(this.i, 0), Base64.decode(this.j, 0), localPublicKey);
      if (!bool)
      {
        a(-2);
        TXCLog.e("LicenceCheck", "verifyLicence, signature not pass!");
        AppMethodBeat.o(146722);
        return -2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("LicenceCheck", "verifyLicence, exception is : ".concat(String.valueOf(localException)));
        boolean bool = false;
      }
      localObject = f();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(-3);
        TXCLog.e("LicenceCheck", "verifyLicence, decodeValue is empty!");
        AppMethodBeat.o(146722);
        return -3;
      }
      if (paramf != null) {
        paramf.a = ((String)localObject);
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        paramf = ((JSONObject)localObject).getString("pituLicense");
        localObject = ((JSONObject)localObject).optJSONArray("appData");
        if (localObject == null)
        {
          TXCLog.e("LicenceCheck", "verifyLicence, appDataArray is null!");
          a(-1);
          AppMethodBeat.o(146722);
          return -1;
        }
        i2 = 0;
        int i1 = 0;
        if (i2 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i2);
          String str = localJSONObject.optString("packageName");
          TXCLog.i("LicenceCheck", "verifyLicence, packageName:".concat(String.valueOf(str)));
          if (!str.equals(this.a.getPackageName()))
          {
            TXCLog.e("LicenceCheck", "verifyLicence, packageName not match!");
            i1 = 0;
            break label471;
          }
          i1 = 1;
          int i3 = 1;
          if (d(localJSONObject.optString("endDate"))) {
            break label471;
          }
          i2 = 1;
          a(localJSONObject, paramf);
          i1 = i3;
          if (i1 == 0)
          {
            a(-4);
            AppMethodBeat.o(146722);
            return -4;
          }
          if (i2 == 0)
          {
            a(-5);
            AppMethodBeat.o(146722);
            return -5;
          }
          if (!TextUtils.isEmpty(paramf))
          {
            paramf = Base64.decode(paramf, 0);
            localObject = this.a.getExternalFilesDir(null).getAbsolutePath();
            localObject = new File((String)localObject + File.separator + this.f);
            com.tencent.liteav.basic.util.a.a(((File)localObject).getAbsolutePath(), paramf);
            TXCCommonUtil.setPituLicencePath(((File)localObject).getAbsolutePath());
          }
          TXCDRApi.txReportDAU(this.a, com.tencent.liteav.basic.datareport.a.aI);
          AppMethodBeat.o(146722);
          return 0;
        }
      }
      catch (JSONException paramf)
      {
        TXCLog.e("LicenceCheck", "verifyLicence, json format error ! exception = ".concat(String.valueOf(paramf)));
        a(-1);
        AppMethodBeat.o(146722);
        return -1;
      }
      int i2 = 0;
      continue;
      label471:
      i2 += 1;
    }
  }
  
  private int c(String paramString, f paramf)
  {
    AppMethodBeat.i(146726);
    paramString = e(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
      AppMethodBeat.o(146726);
      return -3;
    }
    if (paramf != null) {
      paramf.a = paramString;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.getString("packagename").equals(a(this.a)))
      {
        TXCLog.e("LicenceCheck", "packagename not match!");
        a(-4);
        AppMethodBeat.o(146726);
        return -4;
      }
      boolean bool = d(paramString.getString("enddate"));
      if (bool)
      {
        AppMethodBeat.o(146726);
        return -5;
      }
    }
    catch (JSONException paramString)
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
      a(-1);
      AppMethodBeat.o(146726);
      return -1;
    }
    this.n = 5;
    TXCDRApi.txReportDAU(this.a, com.tencent.liteav.basic.datareport.a.aI);
    AppMethodBeat.o(146726);
    return 0;
  }
  
  private static long c(String paramString)
  {
    AppMethodBeat.i(146718);
    try
    {
      long l1 = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      AppMethodBeat.o(146718);
      return l1;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(146718);
    }
    return -1L;
  }
  
  private boolean c()
  {
    AppMethodBeat.i(146714);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      AppMethodBeat.o(146714);
      return false;
    }
    if (this.a.getExternalFilesDir(null) == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      AppMethodBeat.o(146714);
      return false;
    }
    AppMethodBeat.o(146714);
    return true;
  }
  
  private boolean d()
  {
    AppMethodBeat.i(146715);
    boolean bool = com.tencent.liteav.basic.util.a.a(this.a, this.d);
    AppMethodBeat.o(146715);
    return bool;
  }
  
  private boolean d(String paramString)
  {
    AppMethodBeat.i(146725);
    long l1 = c(paramString);
    if (l1 < 0L)
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
      AppMethodBeat.o(146725);
      return true;
    }
    if (l1 < System.currentTimeMillis())
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
      AppMethodBeat.o(146725);
      return true;
    }
    AppMethodBeat.o(146725);
    return false;
  }
  
  private String e(String paramString)
  {
    AppMethodBeat.i(146728);
    try
    {
      byte[] arrayOfByte = Base64.decode("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv", 0);
      paramString = new String(g.b(Base64.decode(paramString, 0), arrayOfByte));
      AppMethodBeat.o(146728);
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
  
  private void e()
  {
    AppMethodBeat.i(146717);
    File localFile1 = new File(this.a.getExternalFilesDir(null).getAbsolutePath() + File.separator + this.d);
    if (localFile1.exists()) {
      TXCLog.i("LicenceCheck", "delete dst file:".concat(String.valueOf(localFile1.delete())));
    }
    File localFile2 = new File(this.h + File.separator + this.e);
    if (localFile2.exists()) {
      TXCLog.i("LicenceCheck", "rename file:".concat(String.valueOf(localFile2.renameTo(localFile1))));
    }
    this.m = true;
    AppMethodBeat.o(146717);
  }
  
  private String f()
  {
    AppMethodBeat.i(146720);
    if (TextUtils.isEmpty(this.c))
    {
      TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
      AppMethodBeat.o(146720);
      return "";
    }
    Object localObject3 = this.c.getBytes();
    Object localObject1 = new SecretKeySpec((byte[])localObject3, "AES");
    byte[] arrayOfByte = new byte[16];
    int i1 = 0;
    while ((i1 < localObject3.length) && (i1 < 16))
    {
      arrayOfByte[i1] = localObject3[i1];
      i1 += 1;
    }
    localObject3 = new IvParameterSpec(arrayOfByte);
    arrayOfByte = Base64.decode(this.i, 0);
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, (Key)localObject1, (AlgorithmParameterSpec)localObject3);
      localObject1 = new String(localCipher.doFinal(arrayOfByte), "UTF-8");
      TXCLog.i("LicenceCheck", "decodeLicence : ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(146720);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private String g()
  {
    AppMethodBeat.i(146729);
    String str = com.tencent.liteav.basic.util.a.b(new File(this.h + File.separator + this.e).getAbsolutePath());
    AppMethodBeat.o(146729);
    return str;
  }
  
  public int a(f paramf, Context paramContext)
  {
    AppMethodBeat.i(146709);
    int i1 = b(paramf, paramContext);
    if (i1 != 0) {
      b();
    }
    AppMethodBeat.o(146709);
    return i1;
  }
  
  public int a(String paramString, f paramf)
  {
    AppMethodBeat.i(146713);
    int i1;
    try
    {
      new JSONObject(paramString);
      i1 = b(paramString, paramf);
      AppMethodBeat.o(146713);
      return i1;
    }
    catch (JSONException localJSONException)
    {
      i1 = c(paramString, paramf);
      AppMethodBeat.o(146713);
    }
    return i1;
  }
  
  public PublicKey a(String paramString)
  {
    AppMethodBeat.i(146719);
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    AppMethodBeat.o(146719);
    return paramString;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146707);
    this.a = paramContext.getApplicationContext();
    this.b = paramString1;
    this.c = paramString2;
    if ((this.a != null) && (c()))
    {
      this.h = this.a.getExternalFilesDir(null).getAbsolutePath();
      if (!b(this.h + File.separator + this.d))
      {
        TXCLog.d("LicenceCheck", "setLicense, sdcard file not exist, to download");
        b();
      }
    }
    AppMethodBeat.o(146707);
  }
  
  public void b()
  {
    AppMethodBeat.i(146708);
    if (TextUtils.isEmpty(this.b))
    {
      TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
      AppMethodBeat.o(146708);
      return;
    }
    if (this.k)
    {
      TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
      AppMethodBeat.o(146708);
      return;
    }
    b local1 = new b()
    {
      public void a()
      {
        AppMethodBeat.i(146703);
        TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
        e.a(e.this, false);
        AppMethodBeat.o(146703);
      }
      
      public void a(int paramAnonymousInt)
      {
        AppMethodBeat.i(146702);
        TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
        AppMethodBeat.o(146702);
      }
      
      public void a(File paramAnonymousFile)
      {
        AppMethodBeat.i(146700);
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
        paramAnonymousFile = e.a(e.this);
        if (TextUtils.isEmpty(paramAnonymousFile))
        {
          TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
          e.a(e.this, false);
          AppMethodBeat.o(146700);
          return;
        }
        if (e.a(e.this, paramAnonymousFile, null) == 0) {
          e.b(e.this);
        }
        AppMethodBeat.o(146700);
      }
      
      public void a(File paramAnonymousFile, Exception paramAnonymousException)
      {
        AppMethodBeat.i(146701);
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
        AppMethodBeat.o(146701);
      }
    };
    if (this.a == null)
    {
      TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
      AppMethodBeat.o(146708);
      return;
    }
    File localFile = this.a.getExternalFilesDir(null);
    if (localFile == null)
    {
      TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
      AppMethodBeat.o(146708);
      return;
    }
    this.h = localFile.getAbsolutePath();
    new Thread(new c(this.a, this.b, this.h, this.e, local1, false)).start();
    this.k = true;
    AppMethodBeat.o(146708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.b.e
 * JD-Core Version:    0.7.0.1
 */