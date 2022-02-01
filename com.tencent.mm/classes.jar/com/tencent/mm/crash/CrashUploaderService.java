package com.tencent.mm.crash;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.b.s;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
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
  static final HashMap<String, Integer> fIg;
  
  static
  {
    AppMethodBeat.i(145677);
    HashMap localHashMap = new HashMap(16);
    fIg = localHashMap;
    localHashMap.put("exception", Integer.valueOf(10001));
    fIg.put("anr", Integer.valueOf(10002));
    fIg.put("handler", Integer.valueOf(10003));
    fIg.put("sql", Integer.valueOf(10004));
    fIg.put("permission", Integer.valueOf(10005));
    AppMethodBeat.o(145677);
  }
  
  public CrashUploaderService()
  {
    super("CrashUploaderService");
    AppMethodBeat.i(145673);
    if (h.DEBUG)
    {
      ad.e("MicroMsg.CrashUploaderService", "CrashUploaderService Name : %s", new Object[] { CrashUploaderService.class.getName() });
      Assert.assertTrue("CrashUploaderService name mismatch!!!", ".crash.CrashUploaderService".equals(CrashUploaderService.class.getName()));
    }
    AppMethodBeat.o(145673);
  }
  
  private static boolean a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(145676);
    int i = paramArrayOfByte.length;
    String str = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }).getBytes()).toLowerCase();
    byte[] arrayOfByte = s.compress(paramArrayOfByte);
    paramArrayOfByte = new PByteArray();
    c.a(paramArrayOfByte, arrayOfByte, str.getBytes());
    paramString2 = new StringBuilder().append(paramString3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(paramInt)).append("&devicetype=").append(paramString2).append("&filelength=").append(i).append("&sum=").append(str).append("&reporttype=1&NewReportType=").append(bt.l((Integer)fIg.get(paramString4)));
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
      ad.i("MicroMsg.CrashUploaderService", bt.convertStreamToString(paramString1.execute(paramString2).getEntity().getContent()));
      AppMethodBeat.o(145676);
      return true;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.CrashUploaderService", paramString1, "", new Object[0]);
      AppMethodBeat.o(145676);
    }
    return false;
  }
  
  private static void i(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(145675);
    StringBuilder localStringBuilder;
    if (!new e(paramString1).exists())
    {
      localStringBuilder = new StringBuilder();
      if ((!bt.isNullOrNil(paramString3)) && (!paramString3.equals("0"))) {
        break label212;
      }
      paramString3 = Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL;
      localStringBuilder.append("uin[" + Integer.toString(paramString3.hashCode()) + "] ");
    }
    for (;;)
    {
      localStringBuilder.append(ad.getSysInfo());
      localStringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
      localStringBuilder.append("\n");
      paramString3 = localStringBuilder.toString().getBytes();
      i.e(paramString1, paramString3, paramString3.length);
      paramString2 = (paramString2 + "\n").getBytes();
      i.e(paramString1, paramString2, paramString2.length);
      AppMethodBeat.o(145675);
      return;
      label212:
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
    Object localObject4 = paramIntent.getStringExtra("INTENT_EXTRA_EXCEPTION_MSG");
    String str1 = paramIntent.getStringExtra("INTENT_EXTRA_USER_NAME");
    Object localObject3 = paramIntent.getStringExtra("INTENT_EXTRA_SDCARD_PATH");
    Object localObject2 = paramIntent.getStringExtra("INTENT_EXTRA_DATA_PATH");
    String str2 = paramIntent.getStringExtra("INTENT_EXTRA_UIN");
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
      String str3;
      String str4;
      Object localObject1;
      break label80;
    }
    str3 = paramIntent.getStringExtra("INTENT_EXTRA_DEVICE_TYPE");
    str4 = paramIntent.getStringExtra("INTENT_EXTRA_HOST");
    localObject1 = paramIntent.getStringExtra("INTENT_EXTRA_TAG");
    if (localObject1 != null)
    {
      paramIntent = (Intent)localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      paramIntent = "exception";
    }
    localObject1 = str1 + "," + str3 + "_" + i + "_" + Build.CPU_ABI + ",";
    localObject1 = (String)localObject1 + "exception,time_" + bt.aGK() + ",error_" + (String)localObject4;
    for (;;)
    {
      try
      {
        localObject4 = new e((String)localObject3);
        if (((e)localObject4).exists()) {
          continue;
        }
        ((e)localObject4).mkdirs();
        localObject4 = new Date();
        localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        i((String)localObject3 + "crash_" + localSimpleDateFormat.format((Date)localObject4) + ".txt", (String)localObject1, str2);
      }
      catch (Exception localException)
      {
        SimpleDateFormat localSimpleDateFormat;
        int k;
        continue;
      }
      localObject3 = new e((String)localObject2);
      if (!((e)localObject3).exists()) {
        ((e)localObject3).mkdirs();
      }
      localObject3 = (String)localObject2 + str2;
      localObject2 = new e((String)localObject3);
      if (((e)localObject2).length() > 262144L) {
        ((e)localObject2).delete();
      }
      i((String)localObject3, (String)localObject1, str2);
      localObject1 = i.aR((String)localObject3, 0, -1);
      if (!bt.cw((byte[])localObject1)) {
        continue;
      }
      AppMethodBeat.o(145674);
      return;
      localObject4 = ((e)localObject4).fhW();
      if (localObject4 != null)
      {
        k = localObject4.length;
        j = 0;
        if (j < k)
        {
          localSimpleDateFormat = localObject4[j];
          if (bt.vM(localSimpleDateFormat.lastModified()) > 2592000000L) {
            localSimpleDateFormat.delete();
          }
          j += 1;
        }
      }
    }
    if (a(str1, (byte[])localObject1, i, str3, str4, paramIntent)) {
      ((e)localObject2).delete();
    }
    AppMethodBeat.o(145674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.crash.CrashUploaderService
 * JD-Core Version:    0.7.0.1
 */