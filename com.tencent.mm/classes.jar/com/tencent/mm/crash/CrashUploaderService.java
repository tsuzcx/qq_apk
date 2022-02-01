package com.tencent.mm.crash;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import junit.framework.Assert;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class CrashUploaderService
  extends MMIntentService
{
  static final HashMap<String, Integer> gNk;
  
  static
  {
    AppMethodBeat.i(145677);
    HashMap localHashMap = new HashMap(16);
    gNk = localHashMap;
    localHashMap.put("exception", Integer.valueOf(10001));
    gNk.put("anr", Integer.valueOf(10002));
    gNk.put("handler", Integer.valueOf(10003));
    gNk.put("sql", Integer.valueOf(10004));
    gNk.put("permission", Integer.valueOf(10005));
    AppMethodBeat.o(145677);
  }
  
  public CrashUploaderService()
  {
    super("CrashUploaderService");
    AppMethodBeat.i(145673);
    if (BuildInfo.DEBUG)
    {
      Log.e("MicroMsg.CrashUploaderService", "CrashUploaderService Name : %s", new Object[] { CrashUploaderService.class.getName() });
      Assert.assertTrue("CrashUploaderService name mismatch!!!", CrashUploaderService.class.getName().endsWith(".crash.CrashUploaderService"));
    }
    AppMethodBeat.o(145673);
  }
  
  public static void a(o paramo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(196101);
    paramo = paramo.het();
    int j = paramo.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramo[i];
      String[] arrayOfString;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        arrayOfString = localObject.getName().split("__");
        if ((arrayOfString != null) && (arrayOfString.length >= 2))
        {
          arrayOfByte = com.tencent.mm.vfs.s.aW(aa.z(localObject.mUri), 0, -1);
          if (!Util.isNullOrNil(arrayOfByte)) {
            break label97;
          }
          localObject.delete();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        if (a(paramString1, arrayOfByte, Integer.parseInt(arrayOfString[1]), paramString2, paramString3, paramString4)) {
          localObject.delete();
        }
      }
    }
    AppMethodBeat.o(196101);
  }
  
  private static boolean a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(145676);
    int i = paramArrayOfByte.length;
    String str = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }).getBytes()).toLowerCase();
    byte[] arrayOfByte = com.tencent.mm.b.s.compress(paramArrayOfByte);
    paramArrayOfByte = new PByteArray();
    c.a(paramArrayOfByte, arrayOfByte, str.getBytes());
    paramString2 = new StringBuilder().append(paramString3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(paramInt)).append("&devicetype=").append(paramString2).append("&filelength=").append(i).append("&sum=").append(str).append("&reporttype=1&NewReportType=").append(Util.nullAsNil((Integer)gNk.get(paramString4)));
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      paramString2.append("&username=").append(paramString1);
    }
    try
    {
      paramString1 = new DefaultHttpClient();
      paramString2 = new HttpPost(paramString2.toString());
      paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte.value);
      paramArrayOfByte.setContentType("binary/octet-stream");
      paramString2.setEntity(paramArrayOfByte);
      Log.i("MicroMsg.CrashUploaderService", Util.convertStreamToString(paramString1.execute(paramString2).getEntity().getContent()));
      AppMethodBeat.o(145676);
      return true;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.CrashUploaderService", paramString1, "", new Object[0]);
      AppMethodBeat.o(145676);
    }
    return false;
  }
  
  private static void i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(145675);
    StringBuilder localStringBuilder;
    if (!new o(paramString1).exists())
    {
      localStringBuilder = new StringBuilder();
      if ((!Util.isNullOrNil(paramString3)) && (!paramString3.equals("0"))) {
        break label215;
      }
      paramString3 = Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL;
      localStringBuilder.append("uin[" + Integer.toString(paramString3.hashCode()) + "] ");
    }
    for (;;)
    {
      localStringBuilder.append(Log.getSysInfo());
      localStringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
      localStringBuilder.append("\n");
      paramString3 = localStringBuilder.toString().getBytes();
      com.tencent.mm.vfs.s.e(paramString1, paramString3, paramString3.length);
      paramString2 = (paramString2 + "\n").getBytes();
      com.tencent.mm.vfs.s.e(paramString1, paramString2, paramString2.length);
      AppMethodBeat.o(145675);
      return;
      label215:
      localStringBuilder.append("uin[" + paramString3 + "] ");
    }
  }
  
  public final String getTag()
  {
    return "MicroMsg.CrashUploaderService";
  }
  
  public final void onHandleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(145674);
    if (paramIntent == null)
    {
      AppMethodBeat.o(145674);
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("INTENT_EXTRA_EXCEPTION_MSG");
    String str2 = paramIntent.getStringExtra("INTENT_EXTRA_USER_NAME");
    Object localObject1 = paramIntent.getStringExtra("INTENT_EXTRA_SDCARD_PATH");
    String str6 = paramIntent.getStringExtra("INTENT_EXTRA_DATA_PATH");
    String str3 = paramIntent.getStringExtra("INTENT_EXTRA_UIN");
    int i = 0;
    try
    {
      j = Integer.decode(paramIntent.getStringExtra("INTENT_EXTRA_CLIENT_VERSION")).intValue();
      i = j;
    }
    catch (Error localError)
    {
      int j;
      label80:
      String str4;
      String str5;
      String str1;
      break label80;
    }
    str4 = paramIntent.getStringExtra("INTENT_EXTRA_DEVICE_TYPE");
    str5 = paramIntent.getStringExtra("INTENT_EXTRA_HOST");
    str1 = paramIntent.getStringExtra("INTENT_EXTRA_TAG");
    if (str1 != null)
    {
      paramIntent = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      paramIntent = "exception";
    }
    str1 = str2 + "," + str4 + "_" + i + "_" + Build.CPU_ABI + ",";
    str1 = str1 + "exception,time_" + Util.nowSecond() + ",error_" + (String)localObject2;
    for (;;)
    {
      try
      {
        localObject2 = new o((String)localObject1);
        if (((o)localObject2).exists()) {
          continue;
        }
        ((o)localObject2).mkdirs();
        localObject2 = new Date();
        localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        i((String)localObject1 + "crash_" + localSimpleDateFormat.format((Date)localObject2) + ".txt", str1, str3);
      }
      catch (Exception localException)
      {
        SimpleDateFormat localSimpleDateFormat;
        int k;
        continue;
      }
      localObject1 = new o(str6);
      if (!((o)localObject1).exists()) {
        ((o)localObject1).mkdirs();
      }
      localObject2 = str6 + str3;
      localObject1 = new o((String)localObject2);
      if (!((o)localObject1).exists()) {
        continue;
      }
      if (((o)localObject1).length() > 262144L) {
        ((o)localObject1).delete();
      }
      localObject2 = com.tencent.mm.vfs.s.aW((String)localObject2, 0, -1);
      if (!Util.isNullOrNil((byte[])localObject2)) {
        continue;
      }
      ((o)localObject1).delete();
      AppMethodBeat.o(145674);
      return;
      localObject2 = ((o)localObject2).het();
      if (localObject2 != null)
      {
        k = localObject2.length;
        j = 0;
        if (j < k)
        {
          localSimpleDateFormat = localObject2[j];
          if (Util.milliSecondsToNow(localSimpleDateFormat.lastModified()) > 2592000000L) {
            localSimpleDateFormat.delete();
          }
          j += 1;
        }
      }
    }
    if (a(str2, (byte[])localObject2, i, str4, str5, paramIntent)) {
      ((o)localObject1).delete();
    }
    str6 = str6 + str3 + "_nf/";
    localObject1 = new o(str6);
    if (!((o)localObject1).exists()) {
      ((o)localObject1).mkdirs();
    }
    i(str6 + "__" + i + "__" + System.currentTimeMillis(), str1, str3);
    a((o)localObject1, str2, str4, str5, paramIntent);
    AppMethodBeat.o(145674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.crash.CrashUploaderService
 * JD-Core Version:    0.7.0.1
 */