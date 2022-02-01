package com.tencent.liteav.basic.license;

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
import com.tencent.liteav.basic.util.d;
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

public class LicenceCheck
{
  private static LicenceCheck d;
  private Context a;
  private String b;
  private String c;
  private a e;
  private a f;
  
  private LicenceCheck()
  {
    AppMethodBeat.i(230003);
    this.b = "YTFaceSDK.licence";
    this.c = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
    this.e = new a("TXUgcSDK.licence");
    this.f = new a("TXLiveSDK.licence");
    AppMethodBeat.o(230003);
  }
  
  private int a(a parama, Context paramContext)
  {
    AppMethodBeat.i(230035);
    if (parama.g)
    {
      AppMethodBeat.o(230035);
      return 0;
    }
    if (this.a == null) {
      this.a = paramContext;
    }
    if (d(parama) == 0)
    {
      parama.g = true;
      AppMethodBeat.o(230035);
      return 0;
    }
    int i = c(parama);
    if (i == 0)
    {
      parama.g = true;
      AppMethodBeat.o(230035);
      return 0;
    }
    AppMethodBeat.o(230035);
    return i;
  }
  
  private int a(a parama, f paramf, Context paramContext)
  {
    AppMethodBeat.i(230030);
    int i = a(parama, paramContext);
    if (i != 0) {
      a(parama);
    }
    if (paramf != null) {
      paramf.a = parama.i;
    }
    AppMethodBeat.o(230030);
    return i;
  }
  
  private int a(a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230097);
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
        AppMethodBeat.o(230097);
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
        AppMethodBeat.o(230097);
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
          AppMethodBeat.o(230097);
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
            AppMethodBeat.o(230097);
            return -4;
          }
          if (n == 0)
          {
            a(-5);
            AppMethodBeat.o(230097);
            return -5;
          }
          if (!bool2)
          {
            a(-11);
            AppMethodBeat.o(230097);
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
              AppMethodBeat.o(230097);
              return -10;
            }
            paramString1 = paramString1.getAbsolutePath();
            paramString1 = new File(paramString1 + File.separator + this.b);
            d.a(paramString1.getAbsolutePath(), parama);
            TXCCommonUtil.setPituLicencePath(paramString1.getAbsolutePath());
          }
          catch (Exception parama)
          {
            TXCLog.e("LicenceCheck", "decode pitu license error:".concat(String.valueOf(parama)));
            continue;
          }
          TXCDRApi.txReportDAU(this.a, a.aJ);
          AppMethodBeat.o(230097);
          return 0;
        }
      }
      catch (JSONException parama)
      {
        TXCLog.e("LicenceCheck", "verifyLicence, json format error ! exception = ".concat(String.valueOf(parama)));
        a(-1);
        AppMethodBeat.o(230097);
        return -1;
      }
      k += 1;
    }
  }
  
  public static LicenceCheck a()
  {
    AppMethodBeat.i(229999);
    if (d == null) {
      d = new LicenceCheck();
    }
    LicenceCheck localLicenceCheck = d;
    AppMethodBeat.o(229999);
    return localLicenceCheck;
  }
  
  private static String a(Context paramContext)
  {
    AppMethodBeat.i(230124);
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i)
      {
        paramContext = localRunningAppProcessInfo.processName;
        AppMethodBeat.o(230124);
        return paramContext;
      }
    }
    AppMethodBeat.o(230124);
    return "";
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(230109);
    TXCDRApi.txReportDAU(this.a, a.aK, paramInt, "");
    AppMethodBeat.o(230109);
  }
  
  private void a(a parama, Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230012);
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      TXCCommonUtil.setAppContext(paramContext);
    }
    parama.d = paramString2;
    parama.e = paramString1;
    if ((this.a != null) && (c()))
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
    AppMethodBeat.o(230012);
  }
  
  private boolean a(a parama, JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(230103);
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
        AppMethodBeat.o(230103);
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
    AppMethodBeat.i(230139);
    Signature localSignature = Signature.getInstance("SHA256WithRSA");
    localSignature.initVerify(paramPublicKey);
    localSignature.update(paramArrayOfByte1);
    boolean bool = localSignature.verify(paramArrayOfByte2);
    AppMethodBeat.o(230139);
    return bool;
  }
  
  private String b(a parama)
  {
    AppMethodBeat.i(230017);
    if (this.a == null)
    {
      AppMethodBeat.o(230017);
      return null;
    }
    parama = this.a.getSharedPreferences("LicenceCheck.lastModified", 0).getString(parama.a + ".lastModified", null);
    AppMethodBeat.o(230017);
    return parama;
  }
  
  private void b(a parama, String paramString)
  {
    AppMethodBeat.i(230024);
    if (this.a == null)
    {
      AppMethodBeat.o(230024);
      return;
    }
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("LicenceCheck.lastModified", 0).edit();
    localEditor.putString(parama.a + ".lastModified", paramString);
    localEditor.commit();
    AppMethodBeat.o(230024);
  }
  
  private boolean b(String paramString)
  {
    AppMethodBeat.i(230059);
    boolean bool = d.a(paramString);
    AppMethodBeat.o(230059);
    return bool;
  }
  
  private int c(a parama)
  {
    AppMethodBeat.i(230041);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      AppMethodBeat.o(230041);
      return -10;
    }
    localObject = this.a.getExternalFilesDir(null);
    if (localObject == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      AppMethodBeat.o(230041);
      return -10;
    }
    String str = ((File)localObject).getAbsolutePath() + File.separator + parama.a;
    if (!b(str))
    {
      AppMethodBeat.o(230041);
      return -7;
    }
    localObject = "";
    try
    {
      str = d.b(str);
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("LicenceCheck", "read licence file error: ", localException);
      }
      int i = a(parama, (String)localObject);
      AppMethodBeat.o(230041);
      return i;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
      AppMethodBeat.o(230041);
      return -8;
    }
  }
  
  private static long c(String paramString)
  {
    AppMethodBeat.i(230067);
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      AppMethodBeat.o(230067);
      return l;
    }
    catch (Exception paramString)
    {
      TXCLog.e("LicenceCheck", "time str to millsecond failed.", paramString);
      AppMethodBeat.o(230067);
    }
    return -1L;
  }
  
  private String c(a parama, String paramString)
  {
    AppMethodBeat.i(230073);
    if (TextUtils.isEmpty(parama.d))
    {
      TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
      AppMethodBeat.o(230073);
      return "";
    }
    Object localObject = parama.d.getBytes();
    parama = new SecretKeySpec((byte[])localObject, "AES");
    localObject = new IvParameterSpec(nativeIvParameterSpec((byte[])localObject));
    paramString = Base64.decode(paramString, 0);
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, parama, (AlgorithmParameterSpec)localObject);
      parama = new String(localCipher.doFinal(paramString), "UTF-8");
      TXCLog.i("LicenceCheck", "decodeLicence : ".concat(String.valueOf(parama)));
      AppMethodBeat.o(230073);
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
  
  private boolean c()
  {
    AppMethodBeat.i(230049);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      AppMethodBeat.o(230049);
      return false;
    }
    if (this.a.getExternalFilesDir(null) == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      AppMethodBeat.o(230049);
      return false;
    }
    AppMethodBeat.o(230049);
    return true;
  }
  
  private int d(a parama)
  {
    AppMethodBeat.i(230047);
    if (!e(parama))
    {
      AppMethodBeat.o(230047);
      return -6;
    }
    String str = d.b(this.a, parama.a);
    if (TextUtils.isEmpty(str))
    {
      TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
      AppMethodBeat.o(230047);
      return -8;
    }
    int i = a(parama, str);
    AppMethodBeat.o(230047);
    return i;
  }
  
  private int d(a parama, String paramString)
  {
    AppMethodBeat.i(230087);
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
      AppMethodBeat.o(230087);
      return i;
    }
    catch (JSONException parama)
    {
      a(-1);
      AppMethodBeat.o(230087);
    }
    return -1;
  }
  
  private boolean d(String paramString)
  {
    AppMethodBeat.i(230113);
    long l = c(paramString);
    if (l < 0L)
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
      AppMethodBeat.o(230113);
      return true;
    }
    if (l < System.currentTimeMillis())
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
      AppMethodBeat.o(230113);
      return true;
    }
    AppMethodBeat.o(230113);
    return false;
  }
  
  private int e(a parama, String paramString)
  {
    AppMethodBeat.i(230118);
    paramString = e(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
      AppMethodBeat.o(230118);
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
        AppMethodBeat.o(230118);
        return -4;
      }
      boolean bool = d(paramString.getString("enddate"));
      if (bool)
      {
        AppMethodBeat.o(230118);
        return -5;
      }
    }
    catch (JSONException parama)
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
      a(-1);
      AppMethodBeat.o(230118);
      return -1;
    }
    parama.h = 5;
    TXCDRApi.txReportDAU(this.a, a.aJ);
    AppMethodBeat.o(230118);
    return 0;
  }
  
  private String e(String paramString)
  {
    AppMethodBeat.i(230129);
    try
    {
      byte[] arrayOfByte = Base64.decode(nativeRSAKey(), 0);
      paramString = new String(h.b(Base64.decode(paramString, 0), arrayOfByte));
      AppMethodBeat.o(230129);
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
    AppMethodBeat.i(230052);
    boolean bool = d.a(this.a, parama.a);
    AppMethodBeat.o(230052);
    return bool;
  }
  
  private void f(a parama)
  {
    AppMethodBeat.i(230064);
    File localFile1 = this.a.getExternalFilesDir(null);
    if (localFile1 == null)
    {
      TXCLog.i("LicenceCheck", "saveTempLocal sdcardDir is null");
      AppMethodBeat.o(230064);
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
    AppMethodBeat.o(230064);
  }
  
  private int g(a parama)
  {
    return parama.h;
  }
  
  private String h(a parama)
  {
    AppMethodBeat.i(230135);
    parama = d.b(new File(parama.c + File.separator + parama.b).getAbsolutePath());
    AppMethodBeat.o(230135);
    return parama;
  }
  
  private native byte[] nativeIvParameterSpec(byte[] paramArrayOfByte);
  
  private native String nativeRSAKey();
  
  public int a(a parama, String paramString)
  {
    AppMethodBeat.i(230178);
    int i;
    try
    {
      new JSONObject(paramString);
      i = d(parama, paramString);
      AppMethodBeat.o(230178);
      return i;
    }
    catch (JSONException localJSONException)
    {
      if (parama == this.f)
      {
        AppMethodBeat.o(230178);
        return -1;
      }
      i = e(parama, paramString);
      AppMethodBeat.o(230178);
    }
    return i;
  }
  
  public int a(f paramf, Context paramContext)
  {
    AppMethodBeat.i(230175);
    int i = a(this.f, paramf, paramContext);
    AppMethodBeat.o(230175);
    return i;
  }
  
  public PublicKey a(String paramString)
  {
    AppMethodBeat.i(230184);
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    AppMethodBeat.o(230184);
    return paramString;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230165);
    a(this.f, paramContext, paramString1, paramString2);
    AppMethodBeat.o(230165);
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(230169);
    if (TextUtils.isEmpty(parama.e))
    {
      TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
      AppMethodBeat.o(230169);
      return;
    }
    if (parama.f)
    {
      TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
      AppMethodBeat.o(230169);
      return;
    }
    b local1 = new b()
    {
      public void a()
      {
        AppMethodBeat.i(230040);
        TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
        parama.f = false;
        AppMethodBeat.o(230040);
      }
      
      public void a(int paramAnonymousInt)
      {
        AppMethodBeat.i(230036);
        TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
        AppMethodBeat.o(230036);
      }
      
      public void a(File paramAnonymousFile, Exception paramAnonymousException)
      {
        AppMethodBeat.i(230031);
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
        AppMethodBeat.o(230031);
      }
      
      public void a(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(230026);
        if (paramAnonymousFile == null)
        {
          TXCLog.i("LicenceCheck", "downloadLicense, license not modified");
          AppMethodBeat.o(230026);
          return;
        }
        LicenceCheck.a(LicenceCheck.this, parama, paramAnonymousString);
        TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
        paramAnonymousFile = LicenceCheck.a(LicenceCheck.this, parama);
        if (TextUtils.isEmpty(paramAnonymousFile))
        {
          TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
          parama.f = false;
          AppMethodBeat.o(230026);
          return;
        }
        if (LicenceCheck.b(LicenceCheck.this, parama, paramAnonymousFile) == 0) {
          LicenceCheck.b(LicenceCheck.this, parama);
        }
        AppMethodBeat.o(230026);
      }
    };
    if (this.a == null)
    {
      TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
      AppMethodBeat.o(230169);
      return;
    }
    File localFile = this.a.getExternalFilesDir(null);
    if (localFile == null)
    {
      TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
      AppMethodBeat.o(230169);
      return;
    }
    String str = b(parama);
    parama.c = localFile.getAbsolutePath();
    new Thread(new c(this.a, parama.e, parama.c, parama.b, local1, false, str)).start();
    parama.f = true;
    AppMethodBeat.o(230169);
  }
  
  public int b()
  {
    AppMethodBeat.i(230188);
    int i = g(this.f);
    AppMethodBeat.o(230188);
    return i;
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
      AppMethodBeat.i(229989);
      this.a = paramString;
      this.b = (paramString + ".tmp");
      this.c = "";
      this.d = "";
      this.e = "";
      this.f = false;
      this.g = false;
      this.h = -1;
      this.i = "";
      AppMethodBeat.o(229989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.license.LicenceCheck
 * JD-Core Version:    0.7.0.1
 */