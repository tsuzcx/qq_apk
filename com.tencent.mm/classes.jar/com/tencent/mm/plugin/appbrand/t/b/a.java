package com.tencent.mm.plugin.appbrand.t.b;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.ChunkedData;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetHttpsCreateResult;
import com.tencent.mars.cdn.CronetLogic.CronetRequestParams;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.mars.cdn.CronetLogic.UploadParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements Runnable
{
  public volatile boolean Uz;
  f eqB;
  String mFileName;
  String mMimeType;
  private String mName;
  String mUrl;
  public String ppa;
  public Map<String, String> ppb;
  private boolean ppj;
  private boolean ppk;
  private final String sKB;
  private boolean skm;
  long startTime;
  public int timeout;
  public ArrayList<String> tnQ;
  int tnR;
  private HttpURLConnection tnT;
  public String tnV;
  volatile boolean tnW;
  private boolean tnX;
  boolean tnY;
  public SSLContext tnm;
  String toR;
  final b toX;
  private String toY;
  public Map<String, String> toZ;
  long tpa;
  
  public a(f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, b paramb)
  {
    AppMethodBeat.i(319158);
    this.tnR = 15;
    this.Uz = false;
    this.tnW = false;
    this.timeout = 60000;
    this.tnT = null;
    this.toR = null;
    this.skm = false;
    this.ppj = false;
    this.ppk = false;
    this.tnX = false;
    this.tnY = true;
    this.eqB = paramf;
    this.mUrl = paramString1;
    this.toY = paramString2;
    this.mName = paramString3;
    this.mFileName = paramString4;
    paramf = paramString5;
    if (Util.isNullOrNil(paramString5)) {
      paramf = "application/octet-stream";
    }
    this.mMimeType = paramf;
    this.toX = paramb;
    this.startTime = System.currentTimeMillis();
    this.sKB = paramString6;
    this.skm = paramBoolean1;
    this.ppj = paramBoolean2;
    this.ppk = paramBoolean3;
    this.tnX = paramBoolean4;
    this.tnY = paramBoolean5;
    AppMethodBeat.o(319158);
  }
  
  private void cCy()
  {
    AppMethodBeat.i(319168);
    if (!this.Uz)
    {
      this.toX.O(this.mFileName, this.mUrl, "force stop");
      ((n)e.U(n.class)).a(this.eqB.getAppId(), this.tnV, "POST", this.mUrl, 0L, 0L, 0, 2, cCj(), null, this.mMimeType);
      Log.e("MicroMsg.AppBrandNetworkUploadWorker", "force stop!");
      AppMethodBeat.o(319168);
      return;
    }
    Object localObject5 = new a();
    this.tpa = System.currentTimeMillis();
    this.toX.fd(this.mFileName, this.mUrl);
    Log.v("MicroMsg.AppBrandNetworkUploadWorker", "uploadFile filename %s", new Object[] { this.mFileName });
    ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 0L, 1L, false);
    Log.i("MicroMsg.AppBrandNetworkUploadWorker", "uploadCronetFile prepare to start upload taskid is %s, url is %s, filename is %s", new Object[] { this.ppa, this.mUrl, this.mFileName });
    Object localObject1 = new u(this.toY);
    final com.tencent.threadpool.i.b local1;
    CronetLogic.CronetRequestParams localCronetRequestParams;
    Map localMap;
    for (;;)
    {
      try
      {
        l = ((u)localObject1).length();
        localObject3 = new StringBuilder();
        localObject1 = new StringBuilder();
        local1 = new com.tencent.threadpool.i.b()
        {
          public final String getKey()
          {
            return "AppBrandNetworkUploadWorker#TimerTask";
          }
          
          public final void run()
          {
            AppMethodBeat.i(319156);
            Log.e("MicroMsg.AppBrandNetworkUploadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", new Object[] { a.this.ppa, Integer.valueOf(a.this.timeout), a.this.mUrl });
            if (!a.this.tnW)
            {
              a.this.tnW = true;
              a.this.toX.O(a.this.mFileName, a.this.mUrl, "socket timeout");
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 6L, 1L, false);
              if (!Util.isNullOrNil(a.this.toR)) {
                CronetLogic.cancelCronetTask(a.this.toR);
              }
              AppMethodBeat.o(319156);
              return;
              Log.e("MicroMsg.AppBrandNetworkUploadWorker", "call cronet time out already callback");
            }
          }
        };
        localObject4 = Long.toString(System.currentTimeMillis());
        localObject5 = new CronetLogic.CronetTaskCallback()
        {
          public final void onCronetReceiveChunkedData(CronetLogic.ChunkedData paramAnonymousChunkedData, long paramAnonymousLong) {}
          
          public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramAnonymousResponseHeader, int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(319159);
            Log.i("MicroMsg.AppBrandNetworkUploadWorker", "cronet file upload onCronetReceiveHeader status %d,protocol %s,taskid:%s,CronetRequestId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, a.h(a.this), a.g(a.this) });
            paramAnonymousResponseHeader = com.tencent.mm.plugin.appbrand.t.i.d(CronetLogic.getHeaderList(paramAnonymousResponseHeader), 2);
            try
            {
              if (!Util.isNullOrNil(paramAnonymousString)) {
                paramAnonymousResponseHeader.put("protocol", paramAnonymousString);
              }
              a.f(a.this).X(paramAnonymousResponseHeader);
              AppMethodBeat.o(319159);
              return 0;
            }
            catch (JSONException paramAnonymousString)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkUploadWorker", paramAnonymousString, "JSONException: upload onCronetReceiveHeader put protocol error", new Object[0]);
              }
            }
          }
          
          public final void onCronetReceiveUploadProgress(long paramAnonymousLong1, long paramAnonymousLong2)
          {
            AppMethodBeat.i(319167);
            if (com.tencent.mm.plugin.appbrand.t.i.N(a.this.eqB))
            {
              Log.w("MicroMsg.AppBrandNetworkUploadWorker", "onCronetReceiveUploadProgress shouldStopTask taskid %s,CronetRequestId:%s", new Object[] { a.h(a.this), a.g(a.this) });
              if (!a.b(a.this))
              {
                a.c(a.this);
                CronetLogic.cancelCronetTask(a.g(a.this));
                a.f(a.this).O(a.d(a.this), a.e(a.this), "interrupted");
              }
              for (;;)
              {
                if (local1 != null)
                {
                  local1.cancel();
                  Log.i("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetReceiveUploadProgress shouldStopTask TimerTask cancel");
                }
                AppMethodBeat.o(319167);
                return;
                Log.e("MicroMsg.AppBrandNetworkUploadWorker", "onCronetReceiveUploadProgress already callback");
              }
            }
            b localb;
            if ((paramAnonymousLong2 > 0L) && (a.this.Uz))
            {
              if (paramAnonymousLong2 <= 0L) {
                break label326;
              }
              if (paramAnonymousLong1 <= paramAnonymousLong2) {
                break label308;
              }
              this.tpc.percent = 100;
              if (this.tpc.pnX != this.tpc.percent)
              {
                localb = a.f(a.this);
                a.d(a.this);
                a.e(a.this);
                localb.k(this.tpc.percent, paramAnonymousLong1, paramAnonymousLong2);
                this.tpc.pnX = this.tpc.percent;
              }
            }
            for (;;)
            {
              if (this.tpc.percent == 100) {
                Log.i("MicroMsg.AppBrandNetworkUploadWorker", "cronet upload size %d, totalSize %d, percent = %d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2), Integer.valueOf(this.tpc.percent) });
              }
              AppMethodBeat.o(319167);
              return;
              label308:
              this.tpc.percent = ((int)(100L * paramAnonymousLong1 / paramAnonymousLong2));
              break;
              label326:
              localb = a.f(a.this);
              a.d(a.this);
              a.e(a.this);
              localb.k(this.tpc.percent, paramAnonymousLong1, 0L);
            }
          }
          
          public final void onCronetTaskCompleted(String paramAnonymousString1, final CronetLogic.CronetTaskResult paramAnonymousCronetTaskResult, String paramAnonymousString2)
          {
            AppMethodBeat.i(319162);
            Log.i("MicroMsg.AppBrandNetworkUploadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", new Object[] { Integer.valueOf(paramAnonymousCronetTaskResult.errorCode), paramAnonymousCronetTaskResult.errorMsg, Integer.valueOf(paramAnonymousCronetTaskResult.statusCode), Long.valueOf(paramAnonymousCronetTaskResult.totalReceiveByte), a.h(a.this), a.g(a.this), paramAnonymousString1 });
            if (local1 != null) {
              local1.cancel();
            }
            h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(319166);
                int j = paramAnonymousCronetTaskResult.statusCode;
                Log.i("MicroMsg.AppBrandNetworkUploadWorker", "appbrand_cronetupload_callback_thread run taskid:%s,CronetRequestId:%s", new Object[] { a.this.ppa, a.this.toR });
                int i;
                if (paramAnonymousCronetTaskResult.errorCode == 0)
                {
                  i = 28;
                  Object localObject1;
                  Object localObject2;
                  String str1;
                  if ((j >= 100) && (j < 200))
                  {
                    i = 20;
                    ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, i, 1L, false);
                    Log.i("MicroMsg.AppBrandNetworkUploadWorker", "reportCronetStatusCode:%d, key:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
                    if (j == 200) {
                      break label750;
                    }
                    Log.e("MicroMsg.AppBrandNetworkUploadWorker", "failed code: %d,url is %s,filename is %s ", new Object[] { Integer.valueOf(j), a.this.mUrl, a.this.mFileName });
                    if (!com.tencent.mm.plugin.appbrand.t.i.uZ(j)) {
                      break label750;
                    }
                    localObject1 = paramAnonymousCronetTaskResult.newLocation;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label750;
                    }
                    localObject2 = a.this;
                    i = ((a)localObject2).tnR;
                    ((a)localObject2).tnR = (i - 1);
                    if (i > 0) {
                      break label677;
                    }
                    Log.w("MicroMsg.AppBrandNetworkUploadWorker", "reach the max redirect count(%d)", new Object[] { Integer.valueOf(15) });
                    if (a.this.tnW) {
                      break label664;
                    }
                    a.this.tnW = true;
                    if (!a.this.tnY) {
                      break label622;
                    }
                    localObject1 = a.this.toX;
                    localObject2 = a.this.mFileName;
                    str1 = a.this.mUrl;
                    com.tencent.mm.plugin.appbrand.t.i.a(paramAnonymousCronetTaskResult.webPageProfile);
                    ((b)localObject1).e((String)localObject2, str1, "reach the max redirect count 15", j);
                  }
                  for (;;)
                  {
                    ((n)e.U(n.class)).a(a.this.eqB.getAppId(), a.this.tnV, "POST", a.this.mUrl, paramAnonymousCronetTaskResult.totalSendByte, paramAnonymousCronetTaskResult.totalReceiveByte, j, 1, a.this.cCj(), null, a.this.mMimeType);
                    ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 10L, 1L, false);
                    ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 12L, System.currentTimeMillis() - a.this.tpa, false);
                    AppMethodBeat.o(319166);
                    return;
                    if (200 == j)
                    {
                      i = 21;
                      break;
                    }
                    if ((j > 200) && (j < 300))
                    {
                      i = 22;
                      break;
                    }
                    if (302 == j)
                    {
                      i = 23;
                      break;
                    }
                    if ((j >= 300) && (j < 400))
                    {
                      i = 24;
                      break;
                    }
                    if (404 == j)
                    {
                      i = 25;
                      break;
                    }
                    if ((j >= 400) && (j < 500))
                    {
                      i = 26;
                      break;
                    }
                    if (j < 500) {
                      break;
                    }
                    i = 27;
                    break;
                    label622:
                    a.this.toX.e(a.this.mFileName, a.this.mUrl, "reach the max redirect count 15", j);
                  }
                  label664:
                  Log.e("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetTaskCompleted max redirect already callback");
                  AppMethodBeat.o(319166);
                  return;
                  label677:
                  Log.i("MicroMsg.AppBrandNetworkUploadWorker", "redirect(%d) URL(%s) to URL(%s)", new Object[] { Integer.valueOf(a.this.tnR), a.this.mUrl, localObject1 });
                  a.this.mUrl = ((String)localObject1);
                  a.this.run();
                  AppMethodBeat.o(319166);
                  return;
                  label750:
                  if (!a.this.tnW)
                  {
                    a.this.tnW = true;
                    long l1;
                    long l2;
                    if (a.this.Uz) {
                      if (a.this.tnY)
                      {
                        localObject1 = a.this.toX;
                        localObject2 = a.this.mFileName;
                        str1 = a.this.mUrl;
                        String str2 = paramAnonymousCronetTaskResult.getDataString();
                        com.tencent.mm.plugin.appbrand.t.i.a(paramAnonymousCronetTaskResult.webPageProfile);
                        ((b)localObject1).e((String)localObject2, str1, str2, j);
                        l1 = paramAnonymousCronetTaskResult.totalSendByte;
                        l2 = System.currentTimeMillis() - a.this.tpa;
                        if ((l1 > 0L) && (l2 > 0L)) {
                          break label1304;
                        }
                        Log.i("MicroMsg.AppBrandNetworkUploadWorker", "reportCronetSpeed len:%d, time:%d return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                        a.2.this.tpc.success = true;
                      }
                    }
                    for (;;)
                    {
                      Log.i("MicroMsg.AppBrandNetworkUploadWorker", "cronet upload file finished taskid:%s,CronetRequestId:%s,filename: %s, url:%s ", new Object[] { a.this.ppa, a.this.toR, a.this.mFileName, a.this.mUrl });
                      a.this.toX.adV(a.this.ppa);
                      ((n)e.U(n.class)).a(a.this.eqB.getAppId(), a.this.tnV, "POST", a.this.mUrl, paramAnonymousCronetTaskResult.totalSendByte, paramAnonymousCronetTaskResult.totalReceiveByte, j, 1, a.this.cCj(), null, a.this.mMimeType);
                      ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 10L, 1L, false);
                      ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 12L, System.currentTimeMillis() - a.this.tpa, false);
                      l1 = System.currentTimeMillis() - a.this.startTime;
                      Log.i("cronet upload time", "request time is ".concat(String.valueOf(l1)));
                      ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1800L, 3L, l1, false);
                      ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1800L, 1L, 1L, false);
                      AppMethodBeat.o(319166);
                      return;
                      a.this.toX.e(a.this.mFileName, a.this.mUrl, paramAnonymousCronetTaskResult.getDataString(), j);
                      break;
                      i = 34;
                      double d = l1 / l2 * 0.9765625D;
                      if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                        i = 30;
                      }
                      for (;;)
                      {
                        ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, i, d, false);
                        Log.i("MicroMsg.AppBrandNetworkUploadWorker", "reportCronetSpeed len:%d, time:%d, speed:%f, key:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Double.valueOf(d), Integer.valueOf(i) });
                        break;
                        if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                          i = 31;
                        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                          i = 32;
                        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                          i = 33;
                        }
                      }
                      a.this.toX.O(a.this.mFileName, a.this.mUrl, "force stop");
                    }
                  }
                  label1304:
                  Log.e("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetTaskCompleted already callback");
                  AppMethodBeat.o(319166);
                  return;
                }
                if (!a.this.tnW)
                {
                  a.this.tnW = true;
                  a.this.toX.O(a.this.mFileName, a.this.mUrl, "upload fail:" + paramAnonymousCronetTaskResult.errorCode + ":" + paramAnonymousCronetTaskResult.errorMsg);
                  ((n)e.U(n.class)).a(a.this.eqB.getAppId(), a.this.tnV, "POST", a.this.mUrl, paramAnonymousCronetTaskResult.totalSendByte, paramAnonymousCronetTaskResult.totalReceiveByte, j, 2, a.this.cCj(), null, a.this.mMimeType);
                  ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 11L, 1L, false);
                  ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 13L, System.currentTimeMillis() - a.this.tpa, false);
                  i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                  if (i == -1) {
                    ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 7L, 1L, false);
                  }
                  Log.i("MicroMsg.AppBrandNetworkUploadWorker", "cronet uploadFile fail ret:%d", new Object[] { Integer.valueOf(i) });
                  AppMethodBeat.o(319166);
                  return;
                }
                Log.e("MicroMsg.AppBrandNetworkUploadWorker", "cronet onCronetTaskCompleted uploadFile fail already callback");
                AppMethodBeat.o(319166);
              }
            });
            AppMethodBeat.o(319162);
          }
          
          public final void onDownloadProgressChanged(String paramAnonymousString, CronetLogic.CronetDownloadProgress paramAnonymousCronetDownloadProgress) {}
        };
        localCronetRequestParams = new CronetLogic.CronetRequestParams();
        localCronetRequestParams.url = this.mUrl;
        localCronetRequestParams.taskId = this.ppa;
        localCronetRequestParams.followRedirect = false;
        localCronetRequestParams.method = "POST";
        localCronetRequestParams.useHttp2 = this.ppj;
        localCronetRequestParams.useQuic = this.ppk;
        localCronetRequestParams.useMemoryCache = this.tnX;
        localMap = this.ppb;
        if (!localMap.containsKey("Accept-Encoding"))
        {
          localMap.put("Accept-Encoding", "gzip,compress,br,deflate");
          localMap.put("Connection", "Keep-Alive");
          localMap.put("User-Agent", this.sKB);
          if (!localMap.containsKey("content-length")) {
            break label760;
          }
          Log.e("MicroMsg.AppBrandNetworkUploadWorker", "not allow to set content-length");
          localMap.remove("content-length");
          if (this.toZ == null) {
            break label967;
          }
          localMap.put("Content-Type", "multipart/form-data; boundary=".concat(String.valueOf(localObject4)));
          Iterator localIterator = this.toZ.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          String str1 = (String)localIterator.next();
          String str2 = (String)this.toZ.get(str1);
          Log.i("MicroMsg.AppBrandNetworkUploadWorker", "append form data: key = %s, value = %s", new Object[] { str1, str2 });
          ((StringBuilder)localObject3).append("--" + (String)localObject4 + "\r\n");
          ((StringBuilder)localObject3).append("Content-Disposition: form-data; name=\"" + str1 + "\"");
          ((StringBuilder)localObject3).append("\r\n");
          ((StringBuilder)localObject3).append("\r\n");
          ((StringBuilder)localObject3).append(str2);
          ((StringBuilder)localObject3).append("\r\n");
          continue;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkUploadWorker", localUnsupportedEncodingException, "UnsupportedEncodingException: url is %s filepath %s ", new Object[] { this.mUrl, this.toY });
        ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 4L, 1L, false);
        AppMethodBeat.o(319168);
        return;
        Log.i("MicroMsg.AppBrandNetworkUploadWorker", "uploadCronetFile Accept-Encoding:%s", new Object[] { localMap.get("Accept-Encoding") });
        continue;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkUploadWorker", localIOException, "IOException: url is %s filepath %s ", new Object[] { this.mUrl, this.toY });
        ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 5L, 1L, false);
        AppMethodBeat.o(319168);
        return;
      }
      label760:
      if (localMap.containsKey("Content-Length"))
      {
        Log.e("MicroMsg.AppBrandNetworkUploadWorker", "not allow to set Content-Length");
        localMap.remove("Content-Length");
      }
    }
    ((StringBuilder)localObject3).append("--" + (String)localObject4 + "\r\n");
    ((StringBuilder)localObject3).append("Content-Disposition: form-data; name=\"" + this.mName + "\"; filename=\"" + this.mFileName + "\"" + "\r\n");
    ((StringBuilder)localObject3).append("Content-Type: " + this.mMimeType);
    ((StringBuilder)localObject3).append("\r\n");
    ((StringBuilder)localObject3).append("\r\n");
    localIOException.append("\r\n" + "--" + (String)localObject4 + "--" + "\r\n");
    label967:
    Object localObject3 = ((StringBuilder)localObject3).toString().getBytes("UTF-8");
    Object localObject4 = localIOException.toString().getBytes("UTF-8");
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new byte[0];
    }
    localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = new byte[0];
    }
    long l = l + localObject2.length + localObject3.length;
    Log.i("MicroMsg.AppBrandNetworkUploadWorker", "contentLenght = %d", new Object[] { Long.valueOf(l) });
    localMap.put("Content-Length", String.valueOf(l));
    localCronetRequestParams.makeRequestHeader(localMap);
    localObject4 = com.tencent.mm.plugin.appbrand.t.i.d(com.tencent.mm.plugin.appbrand.t.i.X(localMap), 1);
    this.toX.X((JSONObject)localObject4);
    localObject4 = new CronetLogic.UploadParams();
    ((CronetLogic.UploadParams)localObject4).filePath = this.toY;
    ((CronetLogic.UploadParams)localObject4).vfsPath = true;
    ((CronetLogic.UploadParams)localObject4).uploadOffset = 0L;
    ((CronetLogic.UploadParams)localObject4).uploadRange = l;
    ((CronetLogic.UploadParams)localObject4).formData = ((byte[])localObject2);
    ((CronetLogic.UploadParams)localObject4).endData = ((byte[])localObject3);
    localCronetRequestParams.uploadParams = ((CronetLogic.UploadParams)localObject4);
    ((CronetLogic.UploadParams)localObject4).reportId = 1800;
    localCronetRequestParams.taskType = 7;
    h.ahAA.p(local1, this.timeout);
    Log.i("MicroMsg.AppBrandNetworkUploadWorker", "startCronetHttpsRequest taskId:%s", new Object[] { localCronetRequestParams.taskId });
    localObject2 = CronetLogic.startCronetUploadTask(localCronetRequestParams, (CronetLogic.CronetTaskCallback)localObject5);
    Log.i("MicroMsg.AppBrandNetworkUploadWorker", "startCronetHttpsRequest createRet is %d, taskId %s,CronetRequestId:%s", new Object[] { Integer.valueOf(((CronetLogic.CronetHttpsCreateResult)localObject2).createRet), this.ppa, ((CronetLogic.CronetHttpsCreateResult)localObject2).taskId });
    if ((localObject2 != null) && (((CronetLogic.CronetHttpsCreateResult)localObject2).createRet != 0))
    {
      ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 1L, 1L, false);
      AppMethodBeat.o(319168);
      return;
    }
    this.toR = ((CronetLogic.CronetHttpsCreateResult)localObject2).taskId;
    ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 2L, 1L, false);
    if (l > 0L) {
      ((com.tencent.mm.plugin.appbrand.x.a)e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(1791L, 16L, l, false);
    }
    AppMethodBeat.o(319168);
  }
  
  /* Error */
  private void cCz()
  {
    // Byte code:
    //   0: ldc_w 469
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   10: astore 31
    //   12: aload_0
    //   13: getfield 95	com/tencent/mm/plugin/appbrand/t/b/a:toY	Ljava/lang/String;
    //   16: astore 32
    //   18: aload_0
    //   19: getfield 97	com/tencent/mm/plugin/appbrand/t/b/a:mName	Ljava/lang/String;
    //   22: astore 22
    //   24: aload_0
    //   25: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   28: astore 24
    //   30: ldc 169
    //   32: ldc 187
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload 24
    //   42: aastore
    //   43: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 282	com/tencent/mm/plugin/appbrand/t/b/a:toZ	Ljava/util/Map;
    //   50: astore 25
    //   52: aload_0
    //   53: getfield 252	com/tencent/mm/plugin/appbrand/t/b/a:ppb	Ljava/util/Map;
    //   56: astore 36
    //   58: iconst_0
    //   59: istore 12
    //   61: iconst_0
    //   62: istore 13
    //   64: iconst_0
    //   65: istore 14
    //   67: iconst_0
    //   68: istore 15
    //   70: iconst_0
    //   71: istore 11
    //   73: iconst_0
    //   74: istore 6
    //   76: iconst_0
    //   77: istore 9
    //   79: iconst_0
    //   80: istore 10
    //   82: iconst_0
    //   83: istore 7
    //   85: iconst_0
    //   86: istore 8
    //   88: lconst_0
    //   89: lstore 16
    //   91: aload_0
    //   92: getfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   95: ifne +81 -> 176
    //   98: aload_0
    //   99: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   102: aload_0
    //   103: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   106: aload_0
    //   107: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   110: ldc 136
    //   112: invokeinterface 142 4 0
    //   117: ldc 144
    //   119: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   122: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   125: aload_0
    //   126: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   129: invokeinterface 156 1 0
    //   134: aload_0
    //   135: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   138: ldc 160
    //   140: aload_0
    //   141: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   144: lconst_0
    //   145: lconst_0
    //   146: iconst_0
    //   147: iconst_2
    //   148: aload_0
    //   149: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   152: aconst_null
    //   153: aload_0
    //   154: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   157: invokeinterface 167 14 0
    //   162: ldc 169
    //   164: ldc 171
    //   166: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: ldc_w 469
    //   172: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: aload_0
    //   177: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   180: putfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   183: aload_0
    //   184: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   187: aload_0
    //   188: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   191: aload_0
    //   192: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   195: invokeinterface 185 3 0
    //   200: aconst_null
    //   201: astore 27
    //   203: aconst_null
    //   204: astore 29
    //   206: aconst_null
    //   207: astore 30
    //   209: aconst_null
    //   210: astore 28
    //   212: aconst_null
    //   213: astore 26
    //   215: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   218: invokestatic 223	java/lang/Long:toString	(J)Ljava/lang/String;
    //   221: astore 35
    //   223: ldc 193
    //   225: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   228: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   231: ldc2_w 470
    //   234: lconst_0
    //   235: lconst_1
    //   236: iconst_0
    //   237: invokeinterface 199 8 0
    //   242: new 207	com/tencent/mm/vfs/u
    //   245: dup
    //   246: aload 32
    //   248: invokespecial 210	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   251: astore 34
    //   253: aload 34
    //   255: invokestatic 477	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   258: astore 23
    //   260: new 479	java/net/URL
    //   263: dup
    //   264: aload 31
    //   266: invokespecial 480	java/net/URL:<init>	(Ljava/lang/String;)V
    //   269: astore 33
    //   271: aload_0
    //   272: aload 33
    //   274: invokevirtual 484	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   277: checkcast 486	java/net/HttpURLConnection
    //   280: putfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   283: aload_0
    //   284: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   287: instanceof 488
    //   290: ifeq +38 -> 328
    //   293: aload_0
    //   294: getfield 490	com/tencent/mm/plugin/appbrand/t/b/a:tnm	Ljavax/net/ssl/SSLContext;
    //   297: ifnull +31 -> 328
    //   300: aload_0
    //   301: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   304: checkcast 488	javax/net/ssl/HttpsURLConnection
    //   307: aload_0
    //   308: getfield 490	com/tencent/mm/plugin/appbrand/t/b/a:tnm	Ljavax/net/ssl/SSLContext;
    //   311: invokevirtual 496	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   314: invokevirtual 500	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   317: aload_0
    //   318: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   321: aload_0
    //   322: getfield 502	com/tencent/mm/plugin/appbrand/t/b/a:tnQ	Ljava/util/ArrayList;
    //   325: invokestatic 505	com/tencent/mm/plugin/appbrand/t/i:a	(Ljava/net/HttpURLConnection;Ljava/util/ArrayList;)V
    //   328: aload_0
    //   329: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   332: iconst_1
    //   333: invokevirtual 509	java/net/HttpURLConnection:setDoInput	(Z)V
    //   336: aload_0
    //   337: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   340: iconst_1
    //   341: invokevirtual 512	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   344: aload_0
    //   345: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   348: iconst_0
    //   349: invokevirtual 515	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   352: aload_0
    //   353: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   356: aload_0
    //   357: getfield 75	com/tencent/mm/plugin/appbrand/t/b/a:timeout	I
    //   360: invokevirtual 518	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   363: aload_0
    //   364: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   367: aload_0
    //   368: getfield 75	com/tencent/mm/plugin/appbrand/t/b/a:timeout	I
    //   371: invokevirtual 521	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   374: aload_0
    //   375: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   378: ldc 160
    //   380: invokevirtual 524	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   383: aload_0
    //   384: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   387: ldc_w 268
    //   390: ldc_w 270
    //   393: invokevirtual 527	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_0
    //   397: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   400: ldc 254
    //   402: ldc_w 529
    //   405: invokevirtual 527	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: ldc 169
    //   410: ldc_w 531
    //   413: iconst_2
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: aload 34
    //   421: invokevirtual 535	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   424: invokestatic 540	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: aload 34
    //   432: invokevirtual 213	com/tencent/mm/vfs/u:length	()J
    //   435: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: aastore
    //   439: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: aload_0
    //   443: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   446: iconst_0
    //   447: invokevirtual 543	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   450: aload 36
    //   452: ifnull +752 -> 1204
    //   455: ldc 169
    //   457: ldc_w 545
    //   460: iconst_1
    //   461: anewarray 4	java/lang/Object
    //   464: dup
    //   465: iconst_0
    //   466: aload 31
    //   468: aastore
    //   469: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   472: aload 36
    //   474: invokeinterface 548 1 0
    //   479: invokeinterface 306 1 0
    //   484: astore 36
    //   486: aload 36
    //   488: invokeinterface 312 1 0
    //   493: ifeq +711 -> 1204
    //   496: aload 36
    //   498: invokeinterface 316 1 0
    //   503: checkcast 550	java/util/Map$Entry
    //   506: astore 37
    //   508: ldc 169
    //   510: ldc_w 552
    //   513: iconst_3
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: aload 31
    //   521: aastore
    //   522: dup
    //   523: iconst_1
    //   524: aload 37
    //   526: invokeinterface 555 1 0
    //   531: aastore
    //   532: dup
    //   533: iconst_2
    //   534: aload 37
    //   536: invokeinterface 558 1 0
    //   541: aastore
    //   542: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: aload 37
    //   547: invokeinterface 555 1 0
    //   552: checkcast 288	java/lang/String
    //   555: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   558: ifne -72 -> 486
    //   561: aload 37
    //   563: invokeinterface 558 1 0
    //   568: checkcast 288	java/lang/String
    //   571: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   574: ifne -88 -> 486
    //   577: aload 37
    //   579: invokeinterface 555 1 0
    //   584: checkcast 288	java/lang/String
    //   587: invokevirtual 561	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   590: ldc_w 274
    //   593: invokevirtual 565	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   596: ifeq +254 -> 850
    //   599: ldc 169
    //   601: ldc_w 354
    //   604: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: goto -121 -> 486
    //   610: astore 24
    //   612: aconst_null
    //   613: astore 25
    //   615: aconst_null
    //   616: astore 22
    //   618: iconst_0
    //   619: istore 5
    //   621: iconst_0
    //   622: istore_3
    //   623: iconst_0
    //   624: istore 4
    //   626: ldc 193
    //   628: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   631: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   634: ldc2_w 470
    //   637: lconst_1
    //   638: lconst_1
    //   639: iconst_0
    //   640: invokeinterface 199 8 0
    //   645: ldc 169
    //   647: aload 24
    //   649: ldc_w 338
    //   652: iconst_2
    //   653: anewarray 4	java/lang/Object
    //   656: dup
    //   657: iconst_0
    //   658: aload 31
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: aload 32
    //   665: aastore
    //   666: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   669: aload_0
    //   670: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   673: aload_0
    //   674: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   677: aload_0
    //   678: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   681: ldc_w 567
    //   684: invokeinterface 142 4 0
    //   689: iload_3
    //   690: ifeq +3806 -> 4496
    //   693: ldc 144
    //   695: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   698: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   701: aload_0
    //   702: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   705: invokeinterface 156 1 0
    //   710: aload_0
    //   711: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   714: ldc 160
    //   716: aload_0
    //   717: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   720: lload 16
    //   722: iload 4
    //   724: i2l
    //   725: iload 5
    //   727: iconst_1
    //   728: aload_0
    //   729: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   732: aconst_null
    //   733: aload_0
    //   734: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   737: invokeinterface 167 14 0
    //   742: ldc 193
    //   744: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   747: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   750: ldc2_w 470
    //   753: ldc2_w 568
    //   756: lconst_1
    //   757: iconst_0
    //   758: invokeinterface 199 8 0
    //   763: ldc 193
    //   765: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   768: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   771: ldc2_w 470
    //   774: ldc2_w 570
    //   777: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   780: aload_0
    //   781: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   784: lsub
    //   785: iconst_0
    //   786: invokeinterface 199 8 0
    //   791: aload_0
    //   792: iconst_0
    //   793: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   796: aload 23
    //   798: ifnull +8 -> 806
    //   801: aload 23
    //   803: invokevirtual 576	java/io/InputStream:close	()V
    //   806: aload 25
    //   808: ifnull +8 -> 816
    //   811: aload 25
    //   813: invokevirtual 576	java/io/InputStream:close	()V
    //   816: aload 22
    //   818: ifnull +8 -> 826
    //   821: aload 22
    //   823: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   826: aload_0
    //   827: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   830: aload_0
    //   831: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   834: aload_0
    //   835: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   838: invokeinterface 585 2 0
    //   843: ldc_w 469
    //   846: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   849: return
    //   850: aload_0
    //   851: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   854: aload 37
    //   856: invokeinterface 555 1 0
    //   861: checkcast 288	java/lang/String
    //   864: aload 37
    //   866: invokeinterface 558 1 0
    //   871: checkcast 288	java/lang/String
    //   874: invokevirtual 527	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: goto -391 -> 486
    //   880: astore 22
    //   882: aconst_null
    //   883: astore 28
    //   885: iconst_0
    //   886: istore 5
    //   888: iload 11
    //   890: istore 7
    //   892: aload 26
    //   894: astore 25
    //   896: iload 5
    //   898: istore_3
    //   899: lload 16
    //   901: lstore 18
    //   903: aload 23
    //   905: astore 27
    //   907: aload 25
    //   909: astore 26
    //   911: aload 28
    //   913: astore 24
    //   915: iload 8
    //   917: istore 6
    //   919: iload 7
    //   921: istore 4
    //   923: ldc 193
    //   925: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   928: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   931: ldc2_w 470
    //   934: ldc2_w 586
    //   937: lconst_1
    //   938: iconst_0
    //   939: invokeinterface 199 8 0
    //   944: iload 5
    //   946: istore_3
    //   947: lload 16
    //   949: lstore 18
    //   951: aload 23
    //   953: astore 27
    //   955: aload 25
    //   957: astore 26
    //   959: aload 28
    //   961: astore 24
    //   963: iload 8
    //   965: istore 6
    //   967: iload 7
    //   969: istore 4
    //   971: ldc 169
    //   973: aload 22
    //   975: ldc_w 589
    //   978: iconst_2
    //   979: anewarray 4	java/lang/Object
    //   982: dup
    //   983: iconst_0
    //   984: aload 31
    //   986: aastore
    //   987: dup
    //   988: iconst_1
    //   989: aload 32
    //   991: aastore
    //   992: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   995: iload 5
    //   997: istore_3
    //   998: lload 16
    //   1000: lstore 18
    //   1002: aload 23
    //   1004: astore 27
    //   1006: aload 25
    //   1008: astore 26
    //   1010: aload 28
    //   1012: astore 24
    //   1014: iload 8
    //   1016: istore 6
    //   1018: iload 7
    //   1020: istore 4
    //   1022: aload_0
    //   1023: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   1026: aload_0
    //   1027: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   1030: aload_0
    //   1031: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   1034: ldc_w 591
    //   1037: invokeinterface 142 4 0
    //   1042: iload 8
    //   1044: ifeq +3750 -> 4794
    //   1047: ldc 144
    //   1049: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1052: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   1055: aload_0
    //   1056: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   1059: invokeinterface 156 1 0
    //   1064: aload_0
    //   1065: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   1068: ldc 160
    //   1070: aload_0
    //   1071: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   1074: lload 16
    //   1076: iload 7
    //   1078: i2l
    //   1079: iload 5
    //   1081: iconst_1
    //   1082: aload_0
    //   1083: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   1086: aconst_null
    //   1087: aload_0
    //   1088: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   1091: invokeinterface 167 14 0
    //   1096: ldc 193
    //   1098: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1101: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   1104: ldc2_w 470
    //   1107: ldc2_w 568
    //   1110: lconst_1
    //   1111: iconst_0
    //   1112: invokeinterface 199 8 0
    //   1117: ldc 193
    //   1119: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1122: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   1125: ldc2_w 470
    //   1128: ldc2_w 570
    //   1131: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   1134: aload_0
    //   1135: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   1138: lsub
    //   1139: iconst_0
    //   1140: invokeinterface 199 8 0
    //   1145: aload_0
    //   1146: iconst_0
    //   1147: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   1150: aload 23
    //   1152: ifnull +8 -> 1160
    //   1155: aload 23
    //   1157: invokevirtual 576	java/io/InputStream:close	()V
    //   1160: aload 25
    //   1162: ifnull +8 -> 1170
    //   1165: aload 25
    //   1167: invokevirtual 576	java/io/InputStream:close	()V
    //   1170: aload 28
    //   1172: ifnull +8 -> 1180
    //   1175: aload 28
    //   1177: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   1180: aload_0
    //   1181: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   1184: aload_0
    //   1185: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   1188: aload_0
    //   1189: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   1192: invokeinterface 585 2 0
    //   1197: ldc_w 469
    //   1200: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1203: return
    //   1204: aload_0
    //   1205: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   1208: ldc_w 272
    //   1211: aload_0
    //   1212: getfield 121	com/tencent/mm/plugin/appbrand/t/b/a:sKB	Ljava/lang/String;
    //   1215: invokevirtual 527	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1218: aload 34
    //   1220: invokevirtual 213	com/tencent/mm/vfs/u:length	()J
    //   1223: lstore 18
    //   1225: new 215	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1232: astore 37
    //   1234: new 215	java/lang/StringBuilder
    //   1237: dup
    //   1238: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1241: astore 36
    //   1243: aload 25
    //   1245: ifnull +694 -> 1939
    //   1248: aload_0
    //   1249: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   1252: ldc_w 284
    //   1255: ldc_w 286
    //   1258: aload 35
    //   1260: invokestatic 292	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1263: invokevirtual 296	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1266: invokevirtual 527	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1269: aload 25
    //   1271: invokeinterface 300 1 0
    //   1276: invokeinterface 306 1 0
    //   1281: astore 38
    //   1283: aload 38
    //   1285: invokeinterface 312 1 0
    //   1290: ifeq +480 -> 1770
    //   1293: aload 38
    //   1295: invokeinterface 316 1 0
    //   1300: checkcast 288	java/lang/String
    //   1303: astore 39
    //   1305: aload 25
    //   1307: aload 39
    //   1309: invokeinterface 319 2 0
    //   1314: checkcast 288	java/lang/String
    //   1317: astore 40
    //   1319: ldc 169
    //   1321: ldc_w 321
    //   1324: iconst_2
    //   1325: anewarray 4	java/lang/Object
    //   1328: dup
    //   1329: iconst_0
    //   1330: aload 39
    //   1332: aastore
    //   1333: dup
    //   1334: iconst_1
    //   1335: aload 40
    //   1337: aastore
    //   1338: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1341: aload 37
    //   1343: new 215	java/lang/StringBuilder
    //   1346: dup
    //   1347: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1350: ldc_w 323
    //   1353: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: aload 35
    //   1358: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: ldc_w 329
    //   1364: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: aload 37
    //   1376: new 215	java/lang/StringBuilder
    //   1379: dup
    //   1380: ldc_w 333
    //   1383: invokespecial 334	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1386: aload 39
    //   1388: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: ldc_w 336
    //   1394: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1400: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload 37
    //   1406: ldc_w 329
    //   1409: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: pop
    //   1413: aload 37
    //   1415: ldc_w 329
    //   1418: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: pop
    //   1422: aload 37
    //   1424: aload 40
    //   1426: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: pop
    //   1430: aload 37
    //   1432: ldc_w 329
    //   1435: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: pop
    //   1439: goto -156 -> 1283
    //   1442: astore 22
    //   1444: aconst_null
    //   1445: astore 28
    //   1447: iconst_0
    //   1448: istore 5
    //   1450: iload 12
    //   1452: istore 7
    //   1454: iload 6
    //   1456: istore 8
    //   1458: aload 27
    //   1460: astore 25
    //   1462: iload 5
    //   1464: istore_3
    //   1465: lload 16
    //   1467: lstore 18
    //   1469: aload 23
    //   1471: astore 27
    //   1473: aload 25
    //   1475: astore 26
    //   1477: aload 28
    //   1479: astore 24
    //   1481: iload 8
    //   1483: istore 6
    //   1485: iload 7
    //   1487: istore 4
    //   1489: ldc 193
    //   1491: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1494: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   1497: ldc2_w 470
    //   1500: ldc2_w 454
    //   1503: lconst_1
    //   1504: iconst_0
    //   1505: invokeinterface 199 8 0
    //   1510: iload 5
    //   1512: istore_3
    //   1513: lload 16
    //   1515: lstore 18
    //   1517: aload 23
    //   1519: astore 27
    //   1521: aload 25
    //   1523: astore 26
    //   1525: aload 28
    //   1527: astore 24
    //   1529: iload 8
    //   1531: istore 6
    //   1533: iload 7
    //   1535: istore 4
    //   1537: ldc 169
    //   1539: aload 22
    //   1541: ldc_w 593
    //   1544: iconst_2
    //   1545: anewarray 4	java/lang/Object
    //   1548: dup
    //   1549: iconst_0
    //   1550: aload 31
    //   1552: aastore
    //   1553: dup
    //   1554: iconst_1
    //   1555: aload 32
    //   1557: aastore
    //   1558: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1561: iload 5
    //   1563: istore_3
    //   1564: lload 16
    //   1566: lstore 18
    //   1568: aload 23
    //   1570: astore 27
    //   1572: aload 25
    //   1574: astore 26
    //   1576: aload 28
    //   1578: astore 24
    //   1580: iload 8
    //   1582: istore 6
    //   1584: iload 7
    //   1586: istore 4
    //   1588: aload_0
    //   1589: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   1592: aload_0
    //   1593: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   1596: aload_0
    //   1597: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   1600: ldc_w 595
    //   1603: invokeinterface 142 4 0
    //   1608: iload 8
    //   1610: ifeq +3482 -> 5092
    //   1613: ldc 144
    //   1615: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1618: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   1621: aload_0
    //   1622: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   1625: invokeinterface 156 1 0
    //   1630: aload_0
    //   1631: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   1634: ldc 160
    //   1636: aload_0
    //   1637: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   1640: lload 16
    //   1642: iload 7
    //   1644: i2l
    //   1645: iload 5
    //   1647: iconst_1
    //   1648: aload_0
    //   1649: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   1652: aconst_null
    //   1653: aload_0
    //   1654: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   1657: invokeinterface 167 14 0
    //   1662: ldc 193
    //   1664: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1667: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   1670: ldc2_w 470
    //   1673: ldc2_w 568
    //   1676: lconst_1
    //   1677: iconst_0
    //   1678: invokeinterface 199 8 0
    //   1683: ldc 193
    //   1685: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1688: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   1691: ldc2_w 470
    //   1694: ldc2_w 570
    //   1697: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   1700: aload_0
    //   1701: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   1704: lsub
    //   1705: iconst_0
    //   1706: invokeinterface 199 8 0
    //   1711: aload_0
    //   1712: iconst_0
    //   1713: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   1716: aload 23
    //   1718: ifnull +8 -> 1726
    //   1721: aload 23
    //   1723: invokevirtual 576	java/io/InputStream:close	()V
    //   1726: aload 25
    //   1728: ifnull +8 -> 1736
    //   1731: aload 25
    //   1733: invokevirtual 576	java/io/InputStream:close	()V
    //   1736: aload 28
    //   1738: ifnull +8 -> 1746
    //   1741: aload 28
    //   1743: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   1746: aload_0
    //   1747: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   1750: aload_0
    //   1751: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   1754: aload_0
    //   1755: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   1758: invokeinterface 585 2 0
    //   1763: ldc_w 469
    //   1766: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1769: return
    //   1770: aload 37
    //   1772: new 215	java/lang/StringBuilder
    //   1775: dup
    //   1776: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1779: ldc_w 323
    //   1782: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: aload 35
    //   1787: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: ldc_w 329
    //   1793: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1799: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: pop
    //   1803: aload 37
    //   1805: new 215	java/lang/StringBuilder
    //   1808: dup
    //   1809: ldc_w 333
    //   1812: invokespecial 334	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1815: aload 22
    //   1817: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1820: ldc_w 356
    //   1823: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: aload 24
    //   1828: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: ldc_w 336
    //   1834: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: ldc_w 329
    //   1840: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1846: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: pop
    //   1850: aload 37
    //   1852: new 215	java/lang/StringBuilder
    //   1855: dup
    //   1856: ldc_w 358
    //   1859: invokespecial 334	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1862: aload_0
    //   1863: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   1866: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1872: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: pop
    //   1876: aload 37
    //   1878: ldc_w 329
    //   1881: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: pop
    //   1885: aload 37
    //   1887: ldc_w 329
    //   1890: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1893: pop
    //   1894: aload 36
    //   1896: new 215	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1903: ldc_w 329
    //   1906: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: ldc_w 323
    //   1912: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: aload 35
    //   1917: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: ldc_w 323
    //   1923: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: ldc_w 329
    //   1929: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: pop
    //   1939: aload 37
    //   1941: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1944: ldc_w 360
    //   1947: invokevirtual 364	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1950: astore 24
    //   1952: aload 36
    //   1954: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1957: ldc_w 360
    //   1960: invokevirtual 364	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1963: astore 25
    //   1965: aload 24
    //   1967: astore 22
    //   1969: aload 24
    //   1971: ifnonnull +8 -> 1979
    //   1974: iconst_0
    //   1975: newarray byte
    //   1977: astore 22
    //   1979: aload 25
    //   1981: ifnonnull +6580 -> 8561
    //   1984: iconst_0
    //   1985: newarray byte
    //   1987: astore 25
    //   1989: lload 18
    //   1991: aload 22
    //   1993: arraylength
    //   1994: i2l
    //   1995: ladd
    //   1996: aload 25
    //   1998: arraylength
    //   1999: i2l
    //   2000: ladd
    //   2001: lstore 18
    //   2003: ldc 169
    //   2005: ldc_w 366
    //   2008: iconst_1
    //   2009: anewarray 4	java/lang/Object
    //   2012: dup
    //   2013: iconst_0
    //   2014: lload 18
    //   2016: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2019: aastore
    //   2020: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2023: aload_0
    //   2024: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   2027: ldc_w 352
    //   2030: lload 18
    //   2032: invokestatic 371	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2035: invokevirtual 527	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2038: aload_0
    //   2039: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   2042: invokestatic 598	com/tencent/mm/plugin/appbrand/t/i:d	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
    //   2045: astore 24
    //   2047: aload_0
    //   2048: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2051: aload 24
    //   2053: invokeinterface 388 2 0
    //   2058: new 578	java/io/DataOutputStream
    //   2061: dup
    //   2062: aload_0
    //   2063: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   2066: invokevirtual 602	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   2069: invokespecial 605	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   2072: astore 24
    //   2074: aload 24
    //   2076: aload 22
    //   2078: invokevirtual 609	java/io/DataOutputStream:write	([B)V
    //   2081: lload 18
    //   2083: invokestatic 613	com/tencent/mm/plugin/appbrand/t/i:jQ	(J)I
    //   2086: newarray byte
    //   2088: astore 22
    //   2090: aload 34
    //   2092: invokevirtual 213	com/tencent/mm/vfs/u:length	()J
    //   2095: lstore 20
    //   2097: iconst_m1
    //   2098: istore_3
    //   2099: lconst_0
    //   2100: lstore 16
    //   2102: aload 23
    //   2104: aload 22
    //   2106: invokevirtual 617	java/io/InputStream:read	([B)I
    //   2109: istore 4
    //   2111: iload 4
    //   2113: iconst_m1
    //   2114: if_icmpeq +403 -> 2517
    //   2117: aload_0
    //   2118: getfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   2121: ifeq +396 -> 2517
    //   2124: aload_0
    //   2125: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   2128: invokestatic 621	com/tencent/mm/plugin/appbrand/t/i:N	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;)Z
    //   2131: ifeq +272 -> 2403
    //   2134: aload_0
    //   2135: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2138: aload_0
    //   2139: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   2142: aload_0
    //   2143: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   2146: ldc_w 623
    //   2149: invokeinterface 142 4 0
    //   2154: ldc 193
    //   2156: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2159: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2162: ldc2_w 470
    //   2165: ldc2_w 624
    //   2168: lconst_1
    //   2169: iconst_0
    //   2170: invokeinterface 199 8 0
    //   2175: ldc 193
    //   2177: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2180: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2183: ldc2_w 470
    //   2186: ldc2_w 626
    //   2189: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   2192: aload_0
    //   2193: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   2196: lsub
    //   2197: iconst_0
    //   2198: invokeinterface 199 8 0
    //   2203: ldc 144
    //   2205: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2208: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   2211: aload_0
    //   2212: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   2215: invokeinterface 156 1 0
    //   2220: aload_0
    //   2221: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   2224: ldc 160
    //   2226: aload_0
    //   2227: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   2230: lload 16
    //   2232: lconst_0
    //   2233: iconst_0
    //   2234: iconst_2
    //   2235: aload_0
    //   2236: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   2239: aconst_null
    //   2240: aload_0
    //   2241: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   2244: invokeinterface 167 14 0
    //   2249: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2252: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   2255: istore_3
    //   2256: iload_3
    //   2257: iconst_m1
    //   2258: if_icmpne +24 -> 2282
    //   2261: ldc 193
    //   2263: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2266: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2269: ldc2_w 470
    //   2272: ldc2_w 640
    //   2275: lconst_1
    //   2276: iconst_0
    //   2277: invokeinterface 199 8 0
    //   2282: ldc 169
    //   2284: ldc_w 643
    //   2287: iconst_1
    //   2288: anewarray 4	java/lang/Object
    //   2291: dup
    //   2292: iconst_0
    //   2293: iload_3
    //   2294: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2297: aastore
    //   2298: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2301: aload_0
    //   2302: iconst_0
    //   2303: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   2306: aload 23
    //   2308: ifnull +8 -> 2316
    //   2311: aload 23
    //   2313: invokevirtual 576	java/io/InputStream:close	()V
    //   2316: aload 24
    //   2318: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   2321: aload_0
    //   2322: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   2325: aload_0
    //   2326: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2329: aload_0
    //   2330: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   2333: invokeinterface 585 2 0
    //   2338: ldc_w 469
    //   2341: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2344: return
    //   2345: astore 22
    //   2347: ldc 169
    //   2349: aload 22
    //   2351: ldc_w 645
    //   2354: iconst_2
    //   2355: anewarray 4	java/lang/Object
    //   2358: dup
    //   2359: iconst_0
    //   2360: aload 31
    //   2362: aastore
    //   2363: dup
    //   2364: iconst_1
    //   2365: aload 32
    //   2367: aastore
    //   2368: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2371: goto -55 -> 2316
    //   2374: astore 22
    //   2376: ldc 169
    //   2378: aload 22
    //   2380: ldc_w 348
    //   2383: iconst_2
    //   2384: anewarray 4	java/lang/Object
    //   2387: dup
    //   2388: iconst_0
    //   2389: aload 31
    //   2391: aastore
    //   2392: dup
    //   2393: iconst_1
    //   2394: aload 32
    //   2396: aastore
    //   2397: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2400: goto -79 -> 2321
    //   2403: aload 24
    //   2405: aload 22
    //   2407: iconst_0
    //   2408: iload 4
    //   2410: invokevirtual 648	java/io/DataOutputStream:write	([BII)V
    //   2413: iload 4
    //   2415: i2l
    //   2416: lload 16
    //   2418: ladd
    //   2419: lstore 16
    //   2421: lload 20
    //   2423: lconst_0
    //   2424: lcmp
    //   2425: ifle +6133 -> 8558
    //   2428: aload_0
    //   2429: getfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   2432: ifeq +6126 -> 8558
    //   2435: ldc2_w 649
    //   2438: lload 16
    //   2440: lmul
    //   2441: lload 20
    //   2443: ldiv
    //   2444: l2i
    //   2445: istore 5
    //   2447: iload_3
    //   2448: istore 4
    //   2450: iload_3
    //   2451: iload 5
    //   2453: if_icmpeq +22 -> 2475
    //   2456: aload_0
    //   2457: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2460: iload 5
    //   2462: lload 16
    //   2464: lload 20
    //   2466: invokeinterface 654 6 0
    //   2471: iload 5
    //   2473: istore 4
    //   2475: ldc 169
    //   2477: ldc_w 656
    //   2480: iconst_3
    //   2481: anewarray 4	java/lang/Object
    //   2484: dup
    //   2485: iconst_0
    //   2486: lload 16
    //   2488: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2491: aastore
    //   2492: dup
    //   2493: iconst_1
    //   2494: lload 20
    //   2496: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2499: aastore
    //   2500: dup
    //   2501: iconst_2
    //   2502: iload 5
    //   2504: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2507: aastore
    //   2508: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2511: iload 4
    //   2513: istore_3
    //   2514: goto -412 -> 2102
    //   2517: aload 24
    //   2519: aload 25
    //   2521: invokevirtual 609	java/io/DataOutputStream:write	([B)V
    //   2524: aload 24
    //   2526: invokevirtual 659	java/io/DataOutputStream:flush	()V
    //   2529: lload 18
    //   2531: lconst_0
    //   2532: lcmp
    //   2533: ifle +25 -> 2558
    //   2536: ldc 193
    //   2538: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2541: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2544: ldc2_w 470
    //   2547: ldc2_w 456
    //   2550: lload 18
    //   2552: iconst_0
    //   2553: invokeinterface 199 8 0
    //   2558: aload_0
    //   2559: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   2562: invokevirtual 662	java/net/HttpURLConnection:getResponseCode	()I
    //   2565: istore 5
    //   2567: aload_0
    //   2568: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   2571: invokestatic 664	com/tencent/mm/plugin/appbrand/t/i:c	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
    //   2574: astore 22
    //   2576: aload_0
    //   2577: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2580: aload 22
    //   2582: invokeinterface 388 2 0
    //   2587: bipush 28
    //   2589: istore_3
    //   2590: iload 5
    //   2592: bipush 100
    //   2594: if_icmplt +313 -> 2907
    //   2597: iload 5
    //   2599: sipush 200
    //   2602: if_icmpge +305 -> 2907
    //   2605: bipush 20
    //   2607: istore_3
    //   2608: ldc 193
    //   2610: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2613: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2616: ldc2_w 470
    //   2619: iload_3
    //   2620: i2l
    //   2621: lconst_1
    //   2622: iconst_0
    //   2623: invokeinterface 199 8 0
    //   2628: ldc 169
    //   2630: ldc_w 666
    //   2633: iconst_2
    //   2634: anewarray 4	java/lang/Object
    //   2637: dup
    //   2638: iconst_0
    //   2639: iload 5
    //   2641: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2644: aastore
    //   2645: dup
    //   2646: iconst_1
    //   2647: iload_3
    //   2648: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2651: aastore
    //   2652: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2655: sipush 200
    //   2658: iload 5
    //   2660: if_icmpeq +731 -> 3391
    //   2663: ldc 169
    //   2665: ldc_w 668
    //   2668: iconst_3
    //   2669: anewarray 4	java/lang/Object
    //   2672: dup
    //   2673: iconst_0
    //   2674: iload 5
    //   2676: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2679: aastore
    //   2680: dup
    //   2681: iconst_1
    //   2682: aload 31
    //   2684: aastore
    //   2685: dup
    //   2686: iconst_2
    //   2687: aload 32
    //   2689: aastore
    //   2690: invokestatic 670	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2693: iload 5
    //   2695: invokestatic 674	com/tencent/mm/plugin/appbrand/t/i:uZ	(I)Z
    //   2698: ifeq +693 -> 3391
    //   2701: aload_0
    //   2702: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   2705: invokestatic 677	com/tencent/mm/plugin/appbrand/t/i:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   2708: astore 22
    //   2710: aload 22
    //   2712: invokestatic 682	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2715: ifne +676 -> 3391
    //   2718: aload_0
    //   2719: getfield 68	com/tencent/mm/plugin/appbrand/t/b/a:tnR	I
    //   2722: ifgt +365 -> 3087
    //   2725: ldc 169
    //   2727: ldc_w 684
    //   2730: iconst_1
    //   2731: anewarray 4	java/lang/Object
    //   2734: dup
    //   2735: iconst_0
    //   2736: bipush 15
    //   2738: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2741: aastore
    //   2742: invokestatic 687	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2745: aload_0
    //   2746: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2749: aload_0
    //   2750: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   2753: aload_0
    //   2754: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   2757: ldc_w 689
    //   2760: iload 5
    //   2762: invokeinterface 692 5 0
    //   2767: ldc 144
    //   2769: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2772: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   2775: aload_0
    //   2776: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   2779: invokeinterface 156 1 0
    //   2784: aload_0
    //   2785: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   2788: ldc 160
    //   2790: aload_0
    //   2791: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   2794: lload 16
    //   2796: lconst_0
    //   2797: iload 5
    //   2799: iconst_1
    //   2800: aload_0
    //   2801: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   2804: aconst_null
    //   2805: aload_0
    //   2806: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   2809: invokeinterface 167 14 0
    //   2814: ldc 193
    //   2816: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2819: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2822: ldc2_w 470
    //   2825: ldc2_w 568
    //   2828: lconst_1
    //   2829: iconst_0
    //   2830: invokeinterface 199 8 0
    //   2835: ldc 193
    //   2837: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2840: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   2843: ldc2_w 470
    //   2846: ldc2_w 570
    //   2849: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   2852: aload_0
    //   2853: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   2856: lsub
    //   2857: iconst_0
    //   2858: invokeinterface 199 8 0
    //   2863: aload_0
    //   2864: iconst_0
    //   2865: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   2868: aload 23
    //   2870: ifnull +8 -> 2878
    //   2873: aload 23
    //   2875: invokevirtual 576	java/io/InputStream:close	()V
    //   2878: aload 24
    //   2880: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   2883: aload_0
    //   2884: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   2887: aload_0
    //   2888: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   2891: aload_0
    //   2892: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   2895: invokeinterface 585 2 0
    //   2900: ldc_w 469
    //   2903: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2906: return
    //   2907: sipush 200
    //   2910: iload 5
    //   2912: if_icmpne +9 -> 2921
    //   2915: bipush 21
    //   2917: istore_3
    //   2918: goto -310 -> 2608
    //   2921: iload 5
    //   2923: sipush 200
    //   2926: if_icmple +17 -> 2943
    //   2929: iload 5
    //   2931: sipush 300
    //   2934: if_icmpge +9 -> 2943
    //   2937: bipush 22
    //   2939: istore_3
    //   2940: goto -332 -> 2608
    //   2943: sipush 302
    //   2946: iload 5
    //   2948: if_icmpne +9 -> 2957
    //   2951: bipush 23
    //   2953: istore_3
    //   2954: goto -346 -> 2608
    //   2957: iload 5
    //   2959: sipush 300
    //   2962: if_icmplt +17 -> 2979
    //   2965: iload 5
    //   2967: sipush 400
    //   2970: if_icmpge +9 -> 2979
    //   2973: bipush 24
    //   2975: istore_3
    //   2976: goto -368 -> 2608
    //   2979: sipush 404
    //   2982: iload 5
    //   2984: if_icmpne +9 -> 2993
    //   2987: bipush 25
    //   2989: istore_3
    //   2990: goto -382 -> 2608
    //   2993: iload 5
    //   2995: sipush 400
    //   2998: if_icmplt +17 -> 3015
    //   3001: iload 5
    //   3003: sipush 500
    //   3006: if_icmpge +9 -> 3015
    //   3009: bipush 26
    //   3011: istore_3
    //   3012: goto -404 -> 2608
    //   3015: iload 5
    //   3017: sipush 500
    //   3020: if_icmplt -412 -> 2608
    //   3023: bipush 27
    //   3025: istore_3
    //   3026: goto -418 -> 2608
    //   3029: astore 22
    //   3031: ldc 169
    //   3033: aload 22
    //   3035: ldc_w 645
    //   3038: iconst_2
    //   3039: anewarray 4	java/lang/Object
    //   3042: dup
    //   3043: iconst_0
    //   3044: aload 31
    //   3046: aastore
    //   3047: dup
    //   3048: iconst_1
    //   3049: aload 32
    //   3051: aastore
    //   3052: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3055: goto -177 -> 2878
    //   3058: astore 22
    //   3060: ldc 169
    //   3062: aload 22
    //   3064: ldc_w 348
    //   3067: iconst_2
    //   3068: anewarray 4	java/lang/Object
    //   3071: dup
    //   3072: iconst_0
    //   3073: aload 31
    //   3075: aastore
    //   3076: dup
    //   3077: iconst_1
    //   3078: aload 32
    //   3080: aastore
    //   3081: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3084: goto -201 -> 2883
    //   3087: ldc 169
    //   3089: ldc_w 694
    //   3092: iconst_3
    //   3093: anewarray 4	java/lang/Object
    //   3096: dup
    //   3097: iconst_0
    //   3098: aload_0
    //   3099: getfield 68	com/tencent/mm/plugin/appbrand/t/b/a:tnR	I
    //   3102: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3105: aastore
    //   3106: dup
    //   3107: iconst_1
    //   3108: aload_0
    //   3109: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   3112: aastore
    //   3113: dup
    //   3114: iconst_2
    //   3115: aload 22
    //   3117: aastore
    //   3118: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3121: aload_0
    //   3122: aload 22
    //   3124: putfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   3127: aload_0
    //   3128: aload_0
    //   3129: getfield 68	com/tencent/mm/plugin/appbrand/t/b/a:tnR	I
    //   3132: iconst_1
    //   3133: isub
    //   3134: putfield 68	com/tencent/mm/plugin/appbrand/t/b/a:tnR	I
    //   3137: aload_0
    //   3138: invokevirtual 697	com/tencent/mm/plugin/appbrand/t/b/a:run	()V
    //   3141: ldc 193
    //   3143: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3146: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3149: ldc2_w 470
    //   3152: ldc2_w 624
    //   3155: lconst_1
    //   3156: iconst_0
    //   3157: invokeinterface 199 8 0
    //   3162: ldc 193
    //   3164: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3167: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3170: ldc2_w 470
    //   3173: ldc2_w 626
    //   3176: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   3179: aload_0
    //   3180: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   3183: lsub
    //   3184: iconst_0
    //   3185: invokeinterface 199 8 0
    //   3190: ldc 144
    //   3192: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3195: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   3198: aload_0
    //   3199: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   3202: invokeinterface 156 1 0
    //   3207: aload_0
    //   3208: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   3211: ldc 160
    //   3213: aload_0
    //   3214: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   3217: lload 16
    //   3219: lconst_0
    //   3220: iload 5
    //   3222: iconst_2
    //   3223: aload_0
    //   3224: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   3227: aconst_null
    //   3228: aload_0
    //   3229: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   3232: invokeinterface 167 14 0
    //   3237: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3240: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   3243: istore_3
    //   3244: iload_3
    //   3245: iconst_m1
    //   3246: if_icmpne +24 -> 3270
    //   3249: ldc 193
    //   3251: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3254: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3257: ldc2_w 470
    //   3260: ldc2_w 640
    //   3263: lconst_1
    //   3264: iconst_0
    //   3265: invokeinterface 199 8 0
    //   3270: ldc 169
    //   3272: ldc_w 643
    //   3275: iconst_1
    //   3276: anewarray 4	java/lang/Object
    //   3279: dup
    //   3280: iconst_0
    //   3281: iload_3
    //   3282: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3285: aastore
    //   3286: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3289: aload_0
    //   3290: iconst_0
    //   3291: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   3294: aload 23
    //   3296: ifnull +8 -> 3304
    //   3299: aload 23
    //   3301: invokevirtual 576	java/io/InputStream:close	()V
    //   3304: aload 24
    //   3306: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   3309: aload_0
    //   3310: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   3313: aload_0
    //   3314: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   3317: aload_0
    //   3318: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   3321: invokeinterface 585 2 0
    //   3326: ldc_w 469
    //   3329: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3332: return
    //   3333: astore 22
    //   3335: ldc 169
    //   3337: aload 22
    //   3339: ldc_w 645
    //   3342: iconst_2
    //   3343: anewarray 4	java/lang/Object
    //   3346: dup
    //   3347: iconst_0
    //   3348: aload 31
    //   3350: aastore
    //   3351: dup
    //   3352: iconst_1
    //   3353: aload 32
    //   3355: aastore
    //   3356: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3359: goto -55 -> 3304
    //   3362: astore 22
    //   3364: ldc 169
    //   3366: aload 22
    //   3368: ldc_w 348
    //   3371: iconst_2
    //   3372: anewarray 4	java/lang/Object
    //   3375: dup
    //   3376: iconst_0
    //   3377: aload 31
    //   3379: aastore
    //   3380: dup
    //   3381: iconst_1
    //   3382: aload 32
    //   3384: aastore
    //   3385: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3388: goto -79 -> 3309
    //   3391: ldc 169
    //   3393: ldc_w 699
    //   3396: iconst_1
    //   3397: anewarray 4	java/lang/Object
    //   3400: dup
    //   3401: iconst_0
    //   3402: aload 31
    //   3404: aastore
    //   3405: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3408: ldc_w 529
    //   3411: aload_0
    //   3412: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   3415: invokevirtual 702	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3418: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3421: ifeq +107 -> 3528
    //   3424: new 707	java/util/zip/GZIPInputStream
    //   3427: dup
    //   3428: aload_0
    //   3429: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   3432: invokevirtual 711	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3435: invokespecial 714	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3438: astore 22
    //   3440: aload 22
    //   3442: ifnull +5106 -> 8548
    //   3445: new 716	java/io/BufferedReader
    //   3448: dup
    //   3449: new 718	java/io/InputStreamReader
    //   3452: dup
    //   3453: aload 22
    //   3455: invokespecial 719	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   3458: invokespecial 722	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   3461: astore 25
    //   3463: new 215	java/lang/StringBuilder
    //   3466: dup
    //   3467: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   3470: astore 26
    //   3472: aload 25
    //   3474: invokevirtual 725	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   3477: astore 27
    //   3479: aload 27
    //   3481: ifnull +144 -> 3625
    //   3484: aload_0
    //   3485: getfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   3488: ifeq +137 -> 3625
    //   3491: aload 26
    //   3493: aload 27
    //   3495: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3498: pop
    //   3499: goto -27 -> 3472
    //   3502: astore 25
    //   3504: aload 24
    //   3506: astore 26
    //   3508: iconst_0
    //   3509: istore_3
    //   3510: iconst_0
    //   3511: istore 4
    //   3513: aload 25
    //   3515: astore 24
    //   3517: aload 22
    //   3519: astore 25
    //   3521: aload 26
    //   3523: astore 22
    //   3525: goto -2899 -> 626
    //   3528: aload_0
    //   3529: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   3532: invokevirtual 711	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3535: astore 22
    //   3537: goto -97 -> 3440
    //   3540: astore 25
    //   3542: ldc 169
    //   3544: aload 25
    //   3546: ldc_w 727
    //   3549: iconst_0
    //   3550: anewarray 4	java/lang/Object
    //   3553: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3556: ldc_w 529
    //   3559: aload_0
    //   3560: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   3563: invokevirtual 702	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3566: invokevirtual 705	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3569: ifeq +44 -> 3613
    //   3572: new 707	java/util/zip/GZIPInputStream
    //   3575: dup
    //   3576: aload_0
    //   3577: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   3580: invokevirtual 730	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   3583: invokespecial 714	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3586: astore 22
    //   3588: goto -148 -> 3440
    //   3591: astore 22
    //   3593: ldc 169
    //   3595: aload 25
    //   3597: ldc_w 732
    //   3600: iconst_0
    //   3601: anewarray 4	java/lang/Object
    //   3604: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3607: aconst_null
    //   3608: astore 22
    //   3610: goto -170 -> 3440
    //   3613: aload_0
    //   3614: getfield 77	com/tencent/mm/plugin/appbrand/t/b/a:tnT	Ljava/net/HttpURLConnection;
    //   3617: invokevirtual 730	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   3620: astore 22
    //   3622: goto -182 -> 3440
    //   3625: aload 26
    //   3627: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3630: astore 25
    //   3632: aload 25
    //   3634: ldc_w 360
    //   3637: invokestatic 738	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   3640: invokevirtual 741	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   3643: arraylength
    //   3644: istore_3
    //   3645: ldc 169
    //   3647: ldc_w 743
    //   3650: iconst_3
    //   3651: anewarray 4	java/lang/Object
    //   3654: dup
    //   3655: iconst_0
    //   3656: aload 33
    //   3658: aastore
    //   3659: dup
    //   3660: iconst_1
    //   3661: aload 25
    //   3663: aastore
    //   3664: dup
    //   3665: iconst_2
    //   3666: iload 5
    //   3668: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3671: aastore
    //   3672: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3675: aload_0
    //   3676: getfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   3679: ifeq +487 -> 4166
    //   3682: aload_0
    //   3683: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   3686: aload_0
    //   3687: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   3690: aload_0
    //   3691: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   3694: aload 25
    //   3696: iload 5
    //   3698: invokeinterface 692 5 0
    //   3703: ldc 169
    //   3705: ldc_w 745
    //   3708: iconst_4
    //   3709: anewarray 4	java/lang/Object
    //   3712: dup
    //   3713: iconst_0
    //   3714: aload 31
    //   3716: aastore
    //   3717: dup
    //   3718: iconst_1
    //   3719: aload 32
    //   3721: aastore
    //   3722: dup
    //   3723: iconst_2
    //   3724: iload_3
    //   3725: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3728: aastore
    //   3729: dup
    //   3730: iconst_3
    //   3731: lload 20
    //   3733: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3736: aastore
    //   3737: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3740: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   3743: aload_0
    //   3744: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   3747: lsub
    //   3748: lstore 20
    //   3750: lload 18
    //   3752: lconst_0
    //   3753: lcmp
    //   3754: ifle +10 -> 3764
    //   3757: lload 20
    //   3759: lconst_0
    //   3760: lcmp
    //   3761: ifgt +260 -> 4021
    //   3764: ldc 169
    //   3766: ldc_w 747
    //   3769: iconst_2
    //   3770: anewarray 4	java/lang/Object
    //   3773: dup
    //   3774: iconst_0
    //   3775: lload 18
    //   3777: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3780: aastore
    //   3781: dup
    //   3782: iconst_1
    //   3783: lload 20
    //   3785: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3788: aastore
    //   3789: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3792: iconst_1
    //   3793: istore 4
    //   3795: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   3798: aload_0
    //   3799: getfield 119	com/tencent/mm/plugin/appbrand/t/b/a:startTime	J
    //   3802: lsub
    //   3803: lstore 18
    //   3805: ldc_w 749
    //   3808: ldc_w 751
    //   3811: lload 18
    //   3813: invokestatic 371	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3816: invokevirtual 296	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3819: invokestatic 753	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3822: ldc 193
    //   3824: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3827: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3830: ldc2_w 754
    //   3833: ldc2_w 454
    //   3836: lload 18
    //   3838: iconst_0
    //   3839: invokeinterface 199 8 0
    //   3844: ldc 193
    //   3846: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3849: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3852: ldc2_w 754
    //   3855: ldc2_w 343
    //   3858: lconst_1
    //   3859: iconst_0
    //   3860: invokeinterface 199 8 0
    //   3865: iload 4
    //   3867: ifeq +332 -> 4199
    //   3870: ldc 144
    //   3872: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3875: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   3878: aload_0
    //   3879: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   3882: invokeinterface 156 1 0
    //   3887: aload_0
    //   3888: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   3891: ldc 160
    //   3893: aload_0
    //   3894: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   3897: lload 16
    //   3899: iload_3
    //   3900: i2l
    //   3901: iload 5
    //   3903: iconst_1
    //   3904: aload_0
    //   3905: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   3908: aconst_null
    //   3909: aload_0
    //   3910: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   3913: invokeinterface 167 14 0
    //   3918: ldc 193
    //   3920: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3923: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3926: ldc2_w 470
    //   3929: ldc2_w 568
    //   3932: lconst_1
    //   3933: iconst_0
    //   3934: invokeinterface 199 8 0
    //   3939: ldc 193
    //   3941: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3944: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   3947: ldc2_w 470
    //   3950: ldc2_w 570
    //   3953: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   3956: aload_0
    //   3957: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   3960: lsub
    //   3961: iconst_0
    //   3962: invokeinterface 199 8 0
    //   3967: aload_0
    //   3968: iconst_0
    //   3969: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   3972: aload 23
    //   3974: ifnull +8 -> 3982
    //   3977: aload 23
    //   3979: invokevirtual 576	java/io/InputStream:close	()V
    //   3982: aload 22
    //   3984: ifnull +8 -> 3992
    //   3987: aload 22
    //   3989: invokevirtual 576	java/io/InputStream:close	()V
    //   3992: aload 24
    //   3994: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   3997: aload_0
    //   3998: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   4001: aload_0
    //   4002: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   4005: aload_0
    //   4006: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   4009: invokeinterface 585 2 0
    //   4014: ldc_w 469
    //   4017: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4020: return
    //   4021: bipush 34
    //   4023: istore 4
    //   4025: lload 18
    //   4027: l2d
    //   4028: lload 20
    //   4030: l2d
    //   4031: ddiv
    //   4032: ldc2_w 756
    //   4035: dmul
    //   4036: dstore_1
    //   4037: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4040: invokestatic 761	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   4043: ifeq +75 -> 4118
    //   4046: bipush 30
    //   4048: istore 4
    //   4050: ldc 193
    //   4052: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4055: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4058: ldc2_w 470
    //   4061: iload 4
    //   4063: i2l
    //   4064: dload_1
    //   4065: d2l
    //   4066: iconst_0
    //   4067: invokeinterface 199 8 0
    //   4072: ldc 169
    //   4074: ldc_w 763
    //   4077: iconst_4
    //   4078: anewarray 4	java/lang/Object
    //   4081: dup
    //   4082: iconst_0
    //   4083: lload 18
    //   4085: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4088: aastore
    //   4089: dup
    //   4090: iconst_1
    //   4091: lload 20
    //   4093: invokestatic 369	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4096: aastore
    //   4097: dup
    //   4098: iconst_2
    //   4099: dload_1
    //   4100: invokestatic 768	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4103: aastore
    //   4104: dup
    //   4105: iconst_3
    //   4106: iload 4
    //   4108: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4111: aastore
    //   4112: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4115: goto -323 -> 3792
    //   4118: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4121: invokestatic 771	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   4124: ifeq +10 -> 4134
    //   4127: bipush 31
    //   4129: istore 4
    //   4131: goto -81 -> 4050
    //   4134: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4137: invokestatic 774	com/tencent/mm/sdk/platformtools/NetStatusUtil:is4G	(Landroid/content/Context;)Z
    //   4140: ifeq +10 -> 4150
    //   4143: bipush 32
    //   4145: istore 4
    //   4147: goto -97 -> 4050
    //   4150: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4153: invokestatic 777	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   4156: ifeq -106 -> 4050
    //   4159: bipush 33
    //   4161: istore 4
    //   4163: goto -113 -> 4050
    //   4166: aload_0
    //   4167: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   4170: aload_0
    //   4171: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   4174: aload_0
    //   4175: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   4178: ldc_w 779
    //   4181: invokeinterface 142 4 0
    //   4186: ldc 169
    //   4188: ldc 171
    //   4190: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4193: iconst_0
    //   4194: istore 4
    //   4196: goto -401 -> 3795
    //   4199: ldc 193
    //   4201: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4204: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4207: ldc2_w 470
    //   4210: ldc2_w 624
    //   4213: lconst_1
    //   4214: iconst_0
    //   4215: invokeinterface 199 8 0
    //   4220: ldc 193
    //   4222: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4225: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4228: ldc2_w 470
    //   4231: ldc2_w 626
    //   4234: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4237: aload_0
    //   4238: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   4241: lsub
    //   4242: iconst_0
    //   4243: invokeinterface 199 8 0
    //   4248: ldc 144
    //   4250: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4253: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   4256: aload_0
    //   4257: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   4260: invokeinterface 156 1 0
    //   4265: aload_0
    //   4266: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   4269: ldc 160
    //   4271: aload_0
    //   4272: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   4275: lload 16
    //   4277: iload_3
    //   4278: i2l
    //   4279: iload 5
    //   4281: iconst_2
    //   4282: aload_0
    //   4283: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   4286: aconst_null
    //   4287: aload_0
    //   4288: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   4291: invokeinterface 167 14 0
    //   4296: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4299: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   4302: istore_3
    //   4303: iload_3
    //   4304: iconst_m1
    //   4305: if_icmpne +24 -> 4329
    //   4308: ldc 193
    //   4310: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4313: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4316: ldc2_w 470
    //   4319: ldc2_w 640
    //   4322: lconst_1
    //   4323: iconst_0
    //   4324: invokeinterface 199 8 0
    //   4329: ldc 169
    //   4331: ldc_w 643
    //   4334: iconst_1
    //   4335: anewarray 4	java/lang/Object
    //   4338: dup
    //   4339: iconst_0
    //   4340: iload_3
    //   4341: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4344: aastore
    //   4345: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4348: goto -381 -> 3967
    //   4351: astore 23
    //   4353: ldc 169
    //   4355: aload 23
    //   4357: ldc_w 645
    //   4360: iconst_2
    //   4361: anewarray 4	java/lang/Object
    //   4364: dup
    //   4365: iconst_0
    //   4366: aload 31
    //   4368: aastore
    //   4369: dup
    //   4370: iconst_1
    //   4371: aload 32
    //   4373: aastore
    //   4374: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4377: goto -395 -> 3982
    //   4380: astore 22
    //   4382: ldc 169
    //   4384: aload 22
    //   4386: ldc_w 348
    //   4389: iconst_2
    //   4390: anewarray 4	java/lang/Object
    //   4393: dup
    //   4394: iconst_0
    //   4395: aload 31
    //   4397: aastore
    //   4398: dup
    //   4399: iconst_1
    //   4400: aload 32
    //   4402: aastore
    //   4403: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4406: goto -414 -> 3992
    //   4409: astore 22
    //   4411: ldc 169
    //   4413: aload 22
    //   4415: ldc_w 781
    //   4418: iconst_2
    //   4419: anewarray 4	java/lang/Object
    //   4422: dup
    //   4423: iconst_0
    //   4424: aload 31
    //   4426: aastore
    //   4427: dup
    //   4428: iconst_1
    //   4429: aload 32
    //   4431: aastore
    //   4432: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4435: goto -443 -> 3992
    //   4438: astore 22
    //   4440: ldc 169
    //   4442: aload 22
    //   4444: ldc_w 783
    //   4447: iconst_2
    //   4448: anewarray 4	java/lang/Object
    //   4451: dup
    //   4452: iconst_0
    //   4453: aload 31
    //   4455: aastore
    //   4456: dup
    //   4457: iconst_1
    //   4458: aload 32
    //   4460: aastore
    //   4461: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4464: goto -472 -> 3992
    //   4467: astore 22
    //   4469: ldc 169
    //   4471: aload 22
    //   4473: ldc_w 348
    //   4476: iconst_2
    //   4477: anewarray 4	java/lang/Object
    //   4480: dup
    //   4481: iconst_0
    //   4482: aload 31
    //   4484: aastore
    //   4485: dup
    //   4486: iconst_1
    //   4487: aload 32
    //   4489: aastore
    //   4490: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4493: goto -496 -> 3997
    //   4496: ldc 193
    //   4498: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4501: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4504: ldc2_w 470
    //   4507: ldc2_w 624
    //   4510: lconst_1
    //   4511: iconst_0
    //   4512: invokeinterface 199 8 0
    //   4517: ldc 193
    //   4519: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4522: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4525: ldc2_w 470
    //   4528: ldc2_w 626
    //   4531: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4534: aload_0
    //   4535: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   4538: lsub
    //   4539: iconst_0
    //   4540: invokeinterface 199 8 0
    //   4545: ldc 144
    //   4547: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4550: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   4553: aload_0
    //   4554: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   4557: invokeinterface 156 1 0
    //   4562: aload_0
    //   4563: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   4566: ldc 160
    //   4568: aload_0
    //   4569: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   4572: lload 16
    //   4574: iload 4
    //   4576: i2l
    //   4577: iload 5
    //   4579: iconst_2
    //   4580: aload_0
    //   4581: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   4584: aconst_null
    //   4585: aload_0
    //   4586: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   4589: invokeinterface 167 14 0
    //   4594: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4597: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   4600: istore_3
    //   4601: iload_3
    //   4602: iconst_m1
    //   4603: if_icmpne +24 -> 4627
    //   4606: ldc 193
    //   4608: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4611: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4614: ldc2_w 470
    //   4617: ldc2_w 640
    //   4620: lconst_1
    //   4621: iconst_0
    //   4622: invokeinterface 199 8 0
    //   4627: ldc 169
    //   4629: ldc_w 643
    //   4632: iconst_1
    //   4633: anewarray 4	java/lang/Object
    //   4636: dup
    //   4637: iconst_0
    //   4638: iload_3
    //   4639: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4642: aastore
    //   4643: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4646: goto -3855 -> 791
    //   4649: astore 23
    //   4651: ldc 169
    //   4653: aload 23
    //   4655: ldc_w 645
    //   4658: iconst_2
    //   4659: anewarray 4	java/lang/Object
    //   4662: dup
    //   4663: iconst_0
    //   4664: aload 31
    //   4666: aastore
    //   4667: dup
    //   4668: iconst_1
    //   4669: aload 32
    //   4671: aastore
    //   4672: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4675: goto -3869 -> 806
    //   4678: astore 23
    //   4680: ldc 169
    //   4682: aload 23
    //   4684: ldc_w 348
    //   4687: iconst_2
    //   4688: anewarray 4	java/lang/Object
    //   4691: dup
    //   4692: iconst_0
    //   4693: aload 31
    //   4695: aastore
    //   4696: dup
    //   4697: iconst_1
    //   4698: aload 32
    //   4700: aastore
    //   4701: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4704: goto -3888 -> 816
    //   4707: astore 23
    //   4709: ldc 169
    //   4711: aload 23
    //   4713: ldc_w 781
    //   4716: iconst_2
    //   4717: anewarray 4	java/lang/Object
    //   4720: dup
    //   4721: iconst_0
    //   4722: aload 31
    //   4724: aastore
    //   4725: dup
    //   4726: iconst_1
    //   4727: aload 32
    //   4729: aastore
    //   4730: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4733: goto -3917 -> 816
    //   4736: astore 23
    //   4738: ldc 169
    //   4740: aload 23
    //   4742: ldc_w 783
    //   4745: iconst_2
    //   4746: anewarray 4	java/lang/Object
    //   4749: dup
    //   4750: iconst_0
    //   4751: aload 31
    //   4753: aastore
    //   4754: dup
    //   4755: iconst_1
    //   4756: aload 32
    //   4758: aastore
    //   4759: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4762: goto -3946 -> 816
    //   4765: astore 22
    //   4767: ldc 169
    //   4769: aload 22
    //   4771: ldc_w 348
    //   4774: iconst_2
    //   4775: anewarray 4	java/lang/Object
    //   4778: dup
    //   4779: iconst_0
    //   4780: aload 31
    //   4782: aastore
    //   4783: dup
    //   4784: iconst_1
    //   4785: aload 32
    //   4787: aastore
    //   4788: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4791: goto -3965 -> 826
    //   4794: ldc 193
    //   4796: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4799: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4802: ldc2_w 470
    //   4805: ldc2_w 624
    //   4808: lconst_1
    //   4809: iconst_0
    //   4810: invokeinterface 199 8 0
    //   4815: ldc 193
    //   4817: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4820: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4823: ldc2_w 470
    //   4826: ldc2_w 626
    //   4829: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   4832: aload_0
    //   4833: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   4836: lsub
    //   4837: iconst_0
    //   4838: invokeinterface 199 8 0
    //   4843: ldc 144
    //   4845: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4848: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   4851: aload_0
    //   4852: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   4855: invokeinterface 156 1 0
    //   4860: aload_0
    //   4861: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   4864: ldc 160
    //   4866: aload_0
    //   4867: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   4870: lload 16
    //   4872: iload 7
    //   4874: i2l
    //   4875: iload 5
    //   4877: iconst_2
    //   4878: aload_0
    //   4879: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   4882: aconst_null
    //   4883: aload_0
    //   4884: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   4887: invokeinterface 167 14 0
    //   4892: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4895: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   4898: istore_3
    //   4899: iload_3
    //   4900: iconst_m1
    //   4901: if_icmpne +24 -> 4925
    //   4904: ldc 193
    //   4906: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4909: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   4912: ldc2_w 470
    //   4915: ldc2_w 640
    //   4918: lconst_1
    //   4919: iconst_0
    //   4920: invokeinterface 199 8 0
    //   4925: ldc 169
    //   4927: ldc_w 643
    //   4930: iconst_1
    //   4931: anewarray 4	java/lang/Object
    //   4934: dup
    //   4935: iconst_0
    //   4936: iload_3
    //   4937: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4940: aastore
    //   4941: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4944: goto -3799 -> 1145
    //   4947: astore 22
    //   4949: ldc 169
    //   4951: aload 22
    //   4953: ldc_w 645
    //   4956: iconst_2
    //   4957: anewarray 4	java/lang/Object
    //   4960: dup
    //   4961: iconst_0
    //   4962: aload 31
    //   4964: aastore
    //   4965: dup
    //   4966: iconst_1
    //   4967: aload 32
    //   4969: aastore
    //   4970: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4973: goto -3813 -> 1160
    //   4976: astore 22
    //   4978: ldc 169
    //   4980: aload 22
    //   4982: ldc_w 348
    //   4985: iconst_2
    //   4986: anewarray 4	java/lang/Object
    //   4989: dup
    //   4990: iconst_0
    //   4991: aload 31
    //   4993: aastore
    //   4994: dup
    //   4995: iconst_1
    //   4996: aload 32
    //   4998: aastore
    //   4999: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5002: goto -3832 -> 1170
    //   5005: astore 22
    //   5007: ldc 169
    //   5009: aload 22
    //   5011: ldc_w 781
    //   5014: iconst_2
    //   5015: anewarray 4	java/lang/Object
    //   5018: dup
    //   5019: iconst_0
    //   5020: aload 31
    //   5022: aastore
    //   5023: dup
    //   5024: iconst_1
    //   5025: aload 32
    //   5027: aastore
    //   5028: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5031: goto -3861 -> 1170
    //   5034: astore 22
    //   5036: ldc 169
    //   5038: aload 22
    //   5040: ldc_w 783
    //   5043: iconst_2
    //   5044: anewarray 4	java/lang/Object
    //   5047: dup
    //   5048: iconst_0
    //   5049: aload 31
    //   5051: aastore
    //   5052: dup
    //   5053: iconst_1
    //   5054: aload 32
    //   5056: aastore
    //   5057: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5060: goto -3890 -> 1170
    //   5063: astore 22
    //   5065: ldc 169
    //   5067: aload 22
    //   5069: ldc_w 348
    //   5072: iconst_2
    //   5073: anewarray 4	java/lang/Object
    //   5076: dup
    //   5077: iconst_0
    //   5078: aload 31
    //   5080: aastore
    //   5081: dup
    //   5082: iconst_1
    //   5083: aload 32
    //   5085: aastore
    //   5086: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5089: goto -3909 -> 1180
    //   5092: ldc 193
    //   5094: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5097: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5100: ldc2_w 470
    //   5103: ldc2_w 624
    //   5106: lconst_1
    //   5107: iconst_0
    //   5108: invokeinterface 199 8 0
    //   5113: ldc 193
    //   5115: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5118: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5121: ldc2_w 470
    //   5124: ldc2_w 626
    //   5127: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   5130: aload_0
    //   5131: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   5134: lsub
    //   5135: iconst_0
    //   5136: invokeinterface 199 8 0
    //   5141: ldc 144
    //   5143: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5146: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   5149: aload_0
    //   5150: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   5153: invokeinterface 156 1 0
    //   5158: aload_0
    //   5159: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   5162: ldc 160
    //   5164: aload_0
    //   5165: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   5168: lload 16
    //   5170: iload 7
    //   5172: i2l
    //   5173: iload 5
    //   5175: iconst_2
    //   5176: aload_0
    //   5177: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   5180: aconst_null
    //   5181: aload_0
    //   5182: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   5185: invokeinterface 167 14 0
    //   5190: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5193: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   5196: istore_3
    //   5197: iload_3
    //   5198: iconst_m1
    //   5199: if_icmpne +24 -> 5223
    //   5202: ldc 193
    //   5204: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5207: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5210: ldc2_w 470
    //   5213: ldc2_w 640
    //   5216: lconst_1
    //   5217: iconst_0
    //   5218: invokeinterface 199 8 0
    //   5223: ldc 169
    //   5225: ldc_w 643
    //   5228: iconst_1
    //   5229: anewarray 4	java/lang/Object
    //   5232: dup
    //   5233: iconst_0
    //   5234: iload_3
    //   5235: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5238: aastore
    //   5239: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5242: goto -3531 -> 1711
    //   5245: astore 22
    //   5247: ldc 169
    //   5249: aload 22
    //   5251: ldc_w 645
    //   5254: iconst_2
    //   5255: anewarray 4	java/lang/Object
    //   5258: dup
    //   5259: iconst_0
    //   5260: aload 31
    //   5262: aastore
    //   5263: dup
    //   5264: iconst_1
    //   5265: aload 32
    //   5267: aastore
    //   5268: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5271: goto -3545 -> 1726
    //   5274: astore 22
    //   5276: ldc 169
    //   5278: aload 22
    //   5280: ldc_w 348
    //   5283: iconst_2
    //   5284: anewarray 4	java/lang/Object
    //   5287: dup
    //   5288: iconst_0
    //   5289: aload 31
    //   5291: aastore
    //   5292: dup
    //   5293: iconst_1
    //   5294: aload 32
    //   5296: aastore
    //   5297: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5300: goto -3564 -> 1736
    //   5303: astore 22
    //   5305: ldc 169
    //   5307: aload 22
    //   5309: ldc_w 781
    //   5312: iconst_2
    //   5313: anewarray 4	java/lang/Object
    //   5316: dup
    //   5317: iconst_0
    //   5318: aload 31
    //   5320: aastore
    //   5321: dup
    //   5322: iconst_1
    //   5323: aload 32
    //   5325: aastore
    //   5326: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5329: goto -3593 -> 1736
    //   5332: astore 22
    //   5334: ldc 169
    //   5336: aload 22
    //   5338: ldc_w 783
    //   5341: iconst_2
    //   5342: anewarray 4	java/lang/Object
    //   5345: dup
    //   5346: iconst_0
    //   5347: aload 31
    //   5349: aastore
    //   5350: dup
    //   5351: iconst_1
    //   5352: aload 32
    //   5354: aastore
    //   5355: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5358: goto -3622 -> 1736
    //   5361: astore 22
    //   5363: ldc 169
    //   5365: aload 22
    //   5367: ldc_w 348
    //   5370: iconst_2
    //   5371: anewarray 4	java/lang/Object
    //   5374: dup
    //   5375: iconst_0
    //   5376: aload 31
    //   5378: aastore
    //   5379: dup
    //   5380: iconst_1
    //   5381: aload 32
    //   5383: aastore
    //   5384: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5387: goto -3641 -> 1746
    //   5390: astore 22
    //   5392: aconst_null
    //   5393: astore 28
    //   5395: aconst_null
    //   5396: astore 25
    //   5398: iconst_0
    //   5399: istore 5
    //   5401: iload 13
    //   5403: istore 7
    //   5405: iload 9
    //   5407: istore 8
    //   5409: aload 29
    //   5411: astore 23
    //   5413: iload 5
    //   5415: istore_3
    //   5416: lload 16
    //   5418: lstore 18
    //   5420: aload 28
    //   5422: astore 27
    //   5424: aload 23
    //   5426: astore 26
    //   5428: aload 25
    //   5430: astore 24
    //   5432: iload 8
    //   5434: istore 6
    //   5436: iload 7
    //   5438: istore 4
    //   5440: ldc 193
    //   5442: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5445: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5448: ldc2_w 470
    //   5451: ldc2_w 343
    //   5454: lconst_1
    //   5455: iconst_0
    //   5456: invokeinterface 199 8 0
    //   5461: iload 5
    //   5463: istore_3
    //   5464: lload 16
    //   5466: lstore 18
    //   5468: aload 28
    //   5470: astore 27
    //   5472: aload 23
    //   5474: astore 26
    //   5476: aload 25
    //   5478: astore 24
    //   5480: iload 8
    //   5482: istore 6
    //   5484: iload 7
    //   5486: istore 4
    //   5488: ldc 169
    //   5490: aload 22
    //   5492: ldc_w 785
    //   5495: iconst_2
    //   5496: anewarray 4	java/lang/Object
    //   5499: dup
    //   5500: iconst_0
    //   5501: aload 31
    //   5503: aastore
    //   5504: dup
    //   5505: iconst_1
    //   5506: aload 32
    //   5508: aastore
    //   5509: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5512: iload 5
    //   5514: istore_3
    //   5515: lload 16
    //   5517: lstore 18
    //   5519: aload 28
    //   5521: astore 27
    //   5523: aload 23
    //   5525: astore 26
    //   5527: aload 25
    //   5529: astore 24
    //   5531: iload 8
    //   5533: istore 6
    //   5535: iload 7
    //   5537: istore 4
    //   5539: aload_0
    //   5540: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   5543: aload_0
    //   5544: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   5547: aload_0
    //   5548: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   5551: ldc_w 787
    //   5554: invokeinterface 142 4 0
    //   5559: iload 8
    //   5561: ifeq +160 -> 5721
    //   5564: ldc 144
    //   5566: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5569: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   5572: aload_0
    //   5573: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   5576: invokeinterface 156 1 0
    //   5581: aload_0
    //   5582: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   5585: ldc 160
    //   5587: aload_0
    //   5588: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   5591: lload 16
    //   5593: iload 7
    //   5595: i2l
    //   5596: iload 5
    //   5598: iconst_1
    //   5599: aload_0
    //   5600: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   5603: aconst_null
    //   5604: aload_0
    //   5605: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   5608: invokeinterface 167 14 0
    //   5613: ldc 193
    //   5615: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5618: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5621: ldc2_w 470
    //   5624: ldc2_w 568
    //   5627: lconst_1
    //   5628: iconst_0
    //   5629: invokeinterface 199 8 0
    //   5634: ldc 193
    //   5636: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5639: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5642: ldc2_w 470
    //   5645: ldc2_w 570
    //   5648: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   5651: aload_0
    //   5652: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   5655: lsub
    //   5656: iconst_0
    //   5657: invokeinterface 199 8 0
    //   5662: aload_0
    //   5663: iconst_0
    //   5664: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   5667: aload 28
    //   5669: ifnull +8 -> 5677
    //   5672: aload 28
    //   5674: invokevirtual 576	java/io/InputStream:close	()V
    //   5677: aload 23
    //   5679: ifnull +8 -> 5687
    //   5682: aload 23
    //   5684: invokevirtual 576	java/io/InputStream:close	()V
    //   5687: aload 25
    //   5689: ifnull +8 -> 5697
    //   5692: aload 25
    //   5694: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   5697: aload_0
    //   5698: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   5701: aload_0
    //   5702: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   5705: aload_0
    //   5706: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   5709: invokeinterface 585 2 0
    //   5714: ldc_w 469
    //   5717: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5720: return
    //   5721: ldc 193
    //   5723: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5726: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5729: ldc2_w 470
    //   5732: ldc2_w 624
    //   5735: lconst_1
    //   5736: iconst_0
    //   5737: invokeinterface 199 8 0
    //   5742: ldc 193
    //   5744: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5747: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5750: ldc2_w 470
    //   5753: ldc2_w 626
    //   5756: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   5759: aload_0
    //   5760: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   5763: lsub
    //   5764: iconst_0
    //   5765: invokeinterface 199 8 0
    //   5770: ldc 144
    //   5772: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5775: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   5778: aload_0
    //   5779: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   5782: invokeinterface 156 1 0
    //   5787: aload_0
    //   5788: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   5791: ldc 160
    //   5793: aload_0
    //   5794: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   5797: lload 16
    //   5799: iload 7
    //   5801: i2l
    //   5802: iload 5
    //   5804: iconst_2
    //   5805: aload_0
    //   5806: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   5809: aconst_null
    //   5810: aload_0
    //   5811: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   5814: invokeinterface 167 14 0
    //   5819: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5822: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   5825: istore_3
    //   5826: iload_3
    //   5827: iconst_m1
    //   5828: if_icmpne +24 -> 5852
    //   5831: ldc 193
    //   5833: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5836: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   5839: ldc2_w 470
    //   5842: ldc2_w 640
    //   5845: lconst_1
    //   5846: iconst_0
    //   5847: invokeinterface 199 8 0
    //   5852: ldc 169
    //   5854: ldc_w 643
    //   5857: iconst_1
    //   5858: anewarray 4	java/lang/Object
    //   5861: dup
    //   5862: iconst_0
    //   5863: iload_3
    //   5864: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5867: aastore
    //   5868: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5871: goto -209 -> 5662
    //   5874: astore 22
    //   5876: ldc 169
    //   5878: aload 22
    //   5880: ldc_w 645
    //   5883: iconst_2
    //   5884: anewarray 4	java/lang/Object
    //   5887: dup
    //   5888: iconst_0
    //   5889: aload 31
    //   5891: aastore
    //   5892: dup
    //   5893: iconst_1
    //   5894: aload 32
    //   5896: aastore
    //   5897: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5900: goto -223 -> 5677
    //   5903: astore 22
    //   5905: ldc 169
    //   5907: aload 22
    //   5909: ldc_w 348
    //   5912: iconst_2
    //   5913: anewarray 4	java/lang/Object
    //   5916: dup
    //   5917: iconst_0
    //   5918: aload 31
    //   5920: aastore
    //   5921: dup
    //   5922: iconst_1
    //   5923: aload 32
    //   5925: aastore
    //   5926: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5929: goto -242 -> 5687
    //   5932: astore 22
    //   5934: ldc 169
    //   5936: aload 22
    //   5938: ldc_w 781
    //   5941: iconst_2
    //   5942: anewarray 4	java/lang/Object
    //   5945: dup
    //   5946: iconst_0
    //   5947: aload 31
    //   5949: aastore
    //   5950: dup
    //   5951: iconst_1
    //   5952: aload 32
    //   5954: aastore
    //   5955: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5958: goto -271 -> 5687
    //   5961: astore 22
    //   5963: ldc 169
    //   5965: aload 22
    //   5967: ldc_w 783
    //   5970: iconst_2
    //   5971: anewarray 4	java/lang/Object
    //   5974: dup
    //   5975: iconst_0
    //   5976: aload 31
    //   5978: aastore
    //   5979: dup
    //   5980: iconst_1
    //   5981: aload 32
    //   5983: aastore
    //   5984: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5987: goto -300 -> 5687
    //   5990: astore 22
    //   5992: ldc 169
    //   5994: aload 22
    //   5996: ldc_w 348
    //   5999: iconst_2
    //   6000: anewarray 4	java/lang/Object
    //   6003: dup
    //   6004: iconst_0
    //   6005: aload 31
    //   6007: aastore
    //   6008: dup
    //   6009: iconst_1
    //   6010: aload 32
    //   6012: aastore
    //   6013: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6016: goto -319 -> 5697
    //   6019: astore 22
    //   6021: aconst_null
    //   6022: astore 28
    //   6024: aconst_null
    //   6025: astore 25
    //   6027: iconst_0
    //   6028: istore 5
    //   6030: iload 14
    //   6032: istore 7
    //   6034: iload 10
    //   6036: istore 8
    //   6038: aload 30
    //   6040: astore 23
    //   6042: iload 5
    //   6044: istore_3
    //   6045: lload 16
    //   6047: lstore 18
    //   6049: aload 28
    //   6051: astore 27
    //   6053: aload 23
    //   6055: astore 26
    //   6057: aload 25
    //   6059: astore 24
    //   6061: iload 8
    //   6063: istore 6
    //   6065: iload 7
    //   6067: istore 4
    //   6069: ldc 193
    //   6071: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6074: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6077: ldc2_w 470
    //   6080: ldc2_w 349
    //   6083: lconst_1
    //   6084: iconst_0
    //   6085: invokeinterface 199 8 0
    //   6090: iload 5
    //   6092: istore_3
    //   6093: lload 16
    //   6095: lstore 18
    //   6097: aload 28
    //   6099: astore 27
    //   6101: aload 23
    //   6103: astore 26
    //   6105: aload 25
    //   6107: astore 24
    //   6109: iload 8
    //   6111: istore 6
    //   6113: iload 7
    //   6115: istore 4
    //   6117: ldc 169
    //   6119: aload 22
    //   6121: ldc_w 645
    //   6124: iconst_2
    //   6125: anewarray 4	java/lang/Object
    //   6128: dup
    //   6129: iconst_0
    //   6130: aload 31
    //   6132: aastore
    //   6133: dup
    //   6134: iconst_1
    //   6135: aload 32
    //   6137: aastore
    //   6138: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6141: iload 5
    //   6143: istore_3
    //   6144: lload 16
    //   6146: lstore 18
    //   6148: aload 28
    //   6150: astore 27
    //   6152: aload 23
    //   6154: astore 26
    //   6156: aload 25
    //   6158: astore 24
    //   6160: iload 8
    //   6162: istore 6
    //   6164: iload 7
    //   6166: istore 4
    //   6168: aload_0
    //   6169: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   6172: aload_0
    //   6173: getfield 99	com/tencent/mm/plugin/appbrand/t/b/a:mFileName	Ljava/lang/String;
    //   6176: aload_0
    //   6177: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   6180: new 215	java/lang/StringBuilder
    //   6183: dup
    //   6184: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   6187: aload 22
    //   6189: invokevirtual 790	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6192: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6195: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6198: invokeinterface 142 4 0
    //   6203: iload 8
    //   6205: ifeq +160 -> 6365
    //   6208: ldc 144
    //   6210: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6213: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   6216: aload_0
    //   6217: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   6220: invokeinterface 156 1 0
    //   6225: aload_0
    //   6226: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   6229: ldc 160
    //   6231: aload_0
    //   6232: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   6235: lload 16
    //   6237: iload 7
    //   6239: i2l
    //   6240: iload 5
    //   6242: iconst_1
    //   6243: aload_0
    //   6244: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   6247: aconst_null
    //   6248: aload_0
    //   6249: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   6252: invokeinterface 167 14 0
    //   6257: ldc 193
    //   6259: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6262: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6265: ldc2_w 470
    //   6268: ldc2_w 568
    //   6271: lconst_1
    //   6272: iconst_0
    //   6273: invokeinterface 199 8 0
    //   6278: ldc 193
    //   6280: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6283: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6286: ldc2_w 470
    //   6289: ldc2_w 570
    //   6292: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   6295: aload_0
    //   6296: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   6299: lsub
    //   6300: iconst_0
    //   6301: invokeinterface 199 8 0
    //   6306: aload_0
    //   6307: iconst_0
    //   6308: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   6311: aload 28
    //   6313: ifnull +8 -> 6321
    //   6316: aload 28
    //   6318: invokevirtual 576	java/io/InputStream:close	()V
    //   6321: aload 23
    //   6323: ifnull +8 -> 6331
    //   6326: aload 23
    //   6328: invokevirtual 576	java/io/InputStream:close	()V
    //   6331: aload 25
    //   6333: ifnull +8 -> 6341
    //   6336: aload 25
    //   6338: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   6341: aload_0
    //   6342: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   6345: aload_0
    //   6346: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   6349: aload_0
    //   6350: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   6353: invokeinterface 585 2 0
    //   6358: ldc_w 469
    //   6361: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6364: return
    //   6365: ldc 193
    //   6367: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6370: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6373: ldc2_w 470
    //   6376: ldc2_w 624
    //   6379: lconst_1
    //   6380: iconst_0
    //   6381: invokeinterface 199 8 0
    //   6386: ldc 193
    //   6388: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6391: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6394: ldc2_w 470
    //   6397: ldc2_w 626
    //   6400: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   6403: aload_0
    //   6404: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   6407: lsub
    //   6408: iconst_0
    //   6409: invokeinterface 199 8 0
    //   6414: ldc 144
    //   6416: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6419: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   6422: aload_0
    //   6423: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   6426: invokeinterface 156 1 0
    //   6431: aload_0
    //   6432: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   6435: ldc 160
    //   6437: aload_0
    //   6438: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   6441: lload 16
    //   6443: iload 7
    //   6445: i2l
    //   6446: iload 5
    //   6448: iconst_2
    //   6449: aload_0
    //   6450: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   6453: aconst_null
    //   6454: aload_0
    //   6455: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   6458: invokeinterface 167 14 0
    //   6463: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6466: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   6469: istore_3
    //   6470: iload_3
    //   6471: iconst_m1
    //   6472: if_icmpne +24 -> 6496
    //   6475: ldc 193
    //   6477: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6480: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6483: ldc2_w 470
    //   6486: ldc2_w 640
    //   6489: lconst_1
    //   6490: iconst_0
    //   6491: invokeinterface 199 8 0
    //   6496: ldc 169
    //   6498: ldc_w 643
    //   6501: iconst_1
    //   6502: anewarray 4	java/lang/Object
    //   6505: dup
    //   6506: iconst_0
    //   6507: iload_3
    //   6508: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6511: aastore
    //   6512: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6515: goto -209 -> 6306
    //   6518: astore 22
    //   6520: ldc 169
    //   6522: aload 22
    //   6524: ldc_w 645
    //   6527: iconst_2
    //   6528: anewarray 4	java/lang/Object
    //   6531: dup
    //   6532: iconst_0
    //   6533: aload 31
    //   6535: aastore
    //   6536: dup
    //   6537: iconst_1
    //   6538: aload 32
    //   6540: aastore
    //   6541: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6544: goto -223 -> 6321
    //   6547: astore 22
    //   6549: ldc 169
    //   6551: aload 22
    //   6553: ldc_w 348
    //   6556: iconst_2
    //   6557: anewarray 4	java/lang/Object
    //   6560: dup
    //   6561: iconst_0
    //   6562: aload 31
    //   6564: aastore
    //   6565: dup
    //   6566: iconst_1
    //   6567: aload 32
    //   6569: aastore
    //   6570: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6573: goto -242 -> 6331
    //   6576: astore 22
    //   6578: ldc 169
    //   6580: aload 22
    //   6582: ldc_w 781
    //   6585: iconst_2
    //   6586: anewarray 4	java/lang/Object
    //   6589: dup
    //   6590: iconst_0
    //   6591: aload 31
    //   6593: aastore
    //   6594: dup
    //   6595: iconst_1
    //   6596: aload 32
    //   6598: aastore
    //   6599: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6602: goto -271 -> 6331
    //   6605: astore 22
    //   6607: ldc 169
    //   6609: aload 22
    //   6611: ldc_w 783
    //   6614: iconst_2
    //   6615: anewarray 4	java/lang/Object
    //   6618: dup
    //   6619: iconst_0
    //   6620: aload 31
    //   6622: aastore
    //   6623: dup
    //   6624: iconst_1
    //   6625: aload 32
    //   6627: aastore
    //   6628: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6631: goto -300 -> 6331
    //   6634: astore 22
    //   6636: ldc 169
    //   6638: aload 22
    //   6640: ldc_w 348
    //   6643: iconst_2
    //   6644: anewarray 4	java/lang/Object
    //   6647: dup
    //   6648: iconst_0
    //   6649: aload 31
    //   6651: aastore
    //   6652: dup
    //   6653: iconst_1
    //   6654: aload 32
    //   6656: aastore
    //   6657: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6660: goto -319 -> 6341
    //   6663: astore 22
    //   6665: aconst_null
    //   6666: astore 27
    //   6668: aconst_null
    //   6669: astore 24
    //   6671: lconst_0
    //   6672: lstore 16
    //   6674: iconst_0
    //   6675: istore_3
    //   6676: iload 15
    //   6678: istore 4
    //   6680: iload 7
    //   6682: istore 6
    //   6684: aload 28
    //   6686: astore 23
    //   6688: iload 6
    //   6690: ifeq +161 -> 6851
    //   6693: ldc 144
    //   6695: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6698: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   6701: aload_0
    //   6702: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   6705: invokeinterface 156 1 0
    //   6710: aload_0
    //   6711: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   6714: ldc 160
    //   6716: aload_0
    //   6717: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   6720: lload 16
    //   6722: iload 4
    //   6724: i2l
    //   6725: iload_3
    //   6726: iconst_1
    //   6727: aload_0
    //   6728: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   6731: aconst_null
    //   6732: aload_0
    //   6733: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   6736: invokeinterface 167 14 0
    //   6741: ldc 193
    //   6743: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6746: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6749: ldc2_w 470
    //   6752: ldc2_w 568
    //   6755: lconst_1
    //   6756: iconst_0
    //   6757: invokeinterface 199 8 0
    //   6762: ldc 193
    //   6764: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6767: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6770: ldc2_w 470
    //   6773: ldc2_w 570
    //   6776: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   6779: aload_0
    //   6780: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   6783: lsub
    //   6784: iconst_0
    //   6785: invokeinterface 199 8 0
    //   6790: aload_0
    //   6791: iconst_0
    //   6792: putfield 70	com/tencent/mm/plugin/appbrand/t/b/a:Uz	Z
    //   6795: aload 27
    //   6797: ifnull +8 -> 6805
    //   6800: aload 27
    //   6802: invokevirtual 576	java/io/InputStream:close	()V
    //   6805: aload 23
    //   6807: ifnull +8 -> 6815
    //   6810: aload 23
    //   6812: invokevirtual 576	java/io/InputStream:close	()V
    //   6815: aload 24
    //   6817: ifnull +8 -> 6825
    //   6820: aload 24
    //   6822: invokevirtual 579	java/io/DataOutputStream:close	()V
    //   6825: aload_0
    //   6826: invokevirtual 582	com/tencent/mm/plugin/appbrand/t/b/a:cCx	()V
    //   6829: aload_0
    //   6830: getfield 111	com/tencent/mm/plugin/appbrand/t/b/a:toX	Lcom/tencent/mm/plugin/appbrand/t/b/b;
    //   6833: aload_0
    //   6834: getfield 203	com/tencent/mm/plugin/appbrand/t/b/a:ppa	Ljava/lang/String;
    //   6837: invokeinterface 585 2 0
    //   6842: ldc_w 469
    //   6845: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6848: aload 22
    //   6850: athrow
    //   6851: ldc 193
    //   6853: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6856: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6859: ldc2_w 470
    //   6862: ldc2_w 624
    //   6865: lconst_1
    //   6866: iconst_0
    //   6867: invokeinterface 199 8 0
    //   6872: ldc 193
    //   6874: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6877: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6880: ldc2_w 470
    //   6883: ldc2_w 626
    //   6886: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   6889: aload_0
    //   6890: getfield 182	com/tencent/mm/plugin/appbrand/t/b/a:tpa	J
    //   6893: lsub
    //   6894: iconst_0
    //   6895: invokeinterface 199 8 0
    //   6900: ldc 144
    //   6902: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6905: checkcast 144	com/tencent/mm/plugin/appbrand/t/n
    //   6908: aload_0
    //   6909: getfield 91	com/tencent/mm/plugin/appbrand/t/b/a:eqB	Lcom/tencent/mm/plugin/appbrand/jsapi/f;
    //   6912: invokeinterface 156 1 0
    //   6917: aload_0
    //   6918: getfield 158	com/tencent/mm/plugin/appbrand/t/b/a:tnV	Ljava/lang/String;
    //   6921: ldc 160
    //   6923: aload_0
    //   6924: getfield 93	com/tencent/mm/plugin/appbrand/t/b/a:mUrl	Ljava/lang/String;
    //   6927: lload 16
    //   6929: iload 4
    //   6931: i2l
    //   6932: iload_3
    //   6933: iconst_2
    //   6934: aload_0
    //   6935: invokevirtual 164	com/tencent/mm/plugin/appbrand/t/b/a:cCj	()I
    //   6938: aconst_null
    //   6939: aload_0
    //   6940: getfield 109	com/tencent/mm/plugin/appbrand/t/b/a:mMimeType	Ljava/lang/String;
    //   6943: invokeinterface 167 14 0
    //   6948: invokestatic 633	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6951: invokestatic 639	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   6954: istore_3
    //   6955: iload_3
    //   6956: iconst_m1
    //   6957: if_icmpne +24 -> 6981
    //   6960: ldc 193
    //   6962: invokestatic 150	com/tencent/luggage/a/e:U	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6965: checkcast 193	com/tencent/mm/plugin/appbrand/x/a
    //   6968: ldc2_w 470
    //   6971: ldc2_w 640
    //   6974: lconst_1
    //   6975: iconst_0
    //   6976: invokeinterface 199 8 0
    //   6981: ldc 169
    //   6983: ldc_w 643
    //   6986: iconst_1
    //   6987: anewarray 4	java/lang/Object
    //   6990: dup
    //   6991: iconst_0
    //   6992: iload_3
    //   6993: invokestatic 452	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6996: aastore
    //   6997: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7000: goto -210 -> 6790
    //   7003: astore 25
    //   7005: ldc 169
    //   7007: aload 25
    //   7009: ldc_w 645
    //   7012: iconst_2
    //   7013: anewarray 4	java/lang/Object
    //   7016: dup
    //   7017: iconst_0
    //   7018: aload 31
    //   7020: aastore
    //   7021: dup
    //   7022: iconst_1
    //   7023: aload 32
    //   7025: aastore
    //   7026: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7029: goto -224 -> 6805
    //   7032: astore 23
    //   7034: ldc 169
    //   7036: aload 23
    //   7038: ldc_w 348
    //   7041: iconst_2
    //   7042: anewarray 4	java/lang/Object
    //   7045: dup
    //   7046: iconst_0
    //   7047: aload 31
    //   7049: aastore
    //   7050: dup
    //   7051: iconst_1
    //   7052: aload 32
    //   7054: aastore
    //   7055: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7058: goto -243 -> 6815
    //   7061: astore 23
    //   7063: ldc 169
    //   7065: aload 23
    //   7067: ldc_w 781
    //   7070: iconst_2
    //   7071: anewarray 4	java/lang/Object
    //   7074: dup
    //   7075: iconst_0
    //   7076: aload 31
    //   7078: aastore
    //   7079: dup
    //   7080: iconst_1
    //   7081: aload 32
    //   7083: aastore
    //   7084: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7087: goto -272 -> 6815
    //   7090: astore 23
    //   7092: ldc 169
    //   7094: aload 23
    //   7096: ldc_w 783
    //   7099: iconst_2
    //   7100: anewarray 4	java/lang/Object
    //   7103: dup
    //   7104: iconst_0
    //   7105: aload 31
    //   7107: aastore
    //   7108: dup
    //   7109: iconst_1
    //   7110: aload 32
    //   7112: aastore
    //   7113: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7116: goto -301 -> 6815
    //   7119: astore 23
    //   7121: ldc 169
    //   7123: aload 23
    //   7125: ldc_w 348
    //   7128: iconst_2
    //   7129: anewarray 4	java/lang/Object
    //   7132: dup
    //   7133: iconst_0
    //   7134: aload 31
    //   7136: aastore
    //   7137: dup
    //   7138: iconst_1
    //   7139: aload 32
    //   7141: aastore
    //   7142: invokestatic 342	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7145: goto -320 -> 6825
    //   7148: astore 22
    //   7150: aconst_null
    //   7151: astore 24
    //   7153: lconst_0
    //   7154: lstore 16
    //   7156: iconst_0
    //   7157: istore_3
    //   7158: aload 23
    //   7160: astore 27
    //   7162: aload 28
    //   7164: astore 23
    //   7166: iload 7
    //   7168: istore 6
    //   7170: iload 15
    //   7172: istore 4
    //   7174: goto -486 -> 6688
    //   7177: astore 22
    //   7179: lconst_0
    //   7180: lstore 16
    //   7182: iconst_0
    //   7183: istore_3
    //   7184: aload 23
    //   7186: astore 27
    //   7188: aload 28
    //   7190: astore 23
    //   7192: iload 7
    //   7194: istore 6
    //   7196: iload 15
    //   7198: istore 4
    //   7200: goto -512 -> 6688
    //   7203: astore 22
    //   7205: iconst_0
    //   7206: istore_3
    //   7207: aload 23
    //   7209: astore 27
    //   7211: aload 28
    //   7213: astore 23
    //   7215: iload 7
    //   7217: istore 6
    //   7219: iload 15
    //   7221: istore 4
    //   7223: goto -535 -> 6688
    //   7226: astore 22
    //   7228: iconst_0
    //   7229: istore_3
    //   7230: aload 23
    //   7232: astore 27
    //   7234: aload 28
    //   7236: astore 23
    //   7238: iload 7
    //   7240: istore 6
    //   7242: iload 15
    //   7244: istore 4
    //   7246: goto -558 -> 6688
    //   7249: astore 22
    //   7251: iload 5
    //   7253: istore_3
    //   7254: aload 23
    //   7256: astore 27
    //   7258: aload 28
    //   7260: astore 23
    //   7262: iload 7
    //   7264: istore 6
    //   7266: iload 15
    //   7268: istore 4
    //   7270: goto -582 -> 6688
    //   7273: astore 26
    //   7275: aload 22
    //   7277: astore 25
    //   7279: aload 26
    //   7281: astore 22
    //   7283: iload 5
    //   7285: istore_3
    //   7286: aload 23
    //   7288: astore 27
    //   7290: aload 25
    //   7292: astore 23
    //   7294: iload 7
    //   7296: istore 6
    //   7298: iload 15
    //   7300: istore 4
    //   7302: goto -614 -> 6688
    //   7305: astore 26
    //   7307: aload 22
    //   7309: astore 25
    //   7311: iload_3
    //   7312: istore 4
    //   7314: aload 26
    //   7316: astore 22
    //   7318: iload 5
    //   7320: istore_3
    //   7321: aload 23
    //   7323: astore 27
    //   7325: aload 25
    //   7327: astore 23
    //   7329: iload 7
    //   7331: istore 6
    //   7333: goto -645 -> 6688
    //   7336: astore 26
    //   7338: aload 22
    //   7340: astore 25
    //   7342: iload_3
    //   7343: istore 4
    //   7345: aload 26
    //   7347: astore 22
    //   7349: iload 5
    //   7351: istore_3
    //   7352: aload 23
    //   7354: astore 27
    //   7356: aload 25
    //   7358: astore 23
    //   7360: iload 7
    //   7362: istore 6
    //   7364: goto -676 -> 6688
    //   7367: astore 26
    //   7369: aload 22
    //   7371: astore 25
    //   7373: iload_3
    //   7374: istore 7
    //   7376: aload 26
    //   7378: astore 22
    //   7380: iload 5
    //   7382: istore_3
    //   7383: aload 23
    //   7385: astore 27
    //   7387: aload 25
    //   7389: astore 23
    //   7391: iload 4
    //   7393: istore 6
    //   7395: iload 7
    //   7397: istore 4
    //   7399: goto -711 -> 6688
    //   7402: astore 26
    //   7404: aload 22
    //   7406: astore 24
    //   7408: iload_3
    //   7409: istore 6
    //   7411: aload 26
    //   7413: astore 22
    //   7415: iload 5
    //   7417: istore_3
    //   7418: aload 23
    //   7420: astore 27
    //   7422: aload 25
    //   7424: astore 23
    //   7426: goto -738 -> 6688
    //   7429: astore 22
    //   7431: lload 18
    //   7433: lstore 16
    //   7435: aload 26
    //   7437: astore 23
    //   7439: goto -751 -> 6688
    //   7442: astore 22
    //   7444: aconst_null
    //   7445: astore 25
    //   7447: iconst_0
    //   7448: istore 5
    //   7450: aload 23
    //   7452: astore 28
    //   7454: aload 30
    //   7456: astore 23
    //   7458: iload 10
    //   7460: istore 8
    //   7462: iload 14
    //   7464: istore 7
    //   7466: goto -1424 -> 6042
    //   7469: astore 22
    //   7471: iconst_0
    //   7472: istore 5
    //   7474: aload 23
    //   7476: astore 28
    //   7478: aload 30
    //   7480: astore 23
    //   7482: aload 24
    //   7484: astore 25
    //   7486: iload 10
    //   7488: istore 8
    //   7490: iload 14
    //   7492: istore 7
    //   7494: goto -1452 -> 6042
    //   7497: astore 22
    //   7499: iconst_0
    //   7500: istore 5
    //   7502: aload 23
    //   7504: astore 28
    //   7506: aload 30
    //   7508: astore 23
    //   7510: aload 24
    //   7512: astore 25
    //   7514: iload 10
    //   7516: istore 8
    //   7518: iload 14
    //   7520: istore 7
    //   7522: goto -1480 -> 6042
    //   7525: astore 22
    //   7527: iconst_0
    //   7528: istore 5
    //   7530: aload 23
    //   7532: astore 28
    //   7534: aload 30
    //   7536: astore 23
    //   7538: aload 24
    //   7540: astore 25
    //   7542: iload 10
    //   7544: istore 8
    //   7546: iload 14
    //   7548: istore 7
    //   7550: goto -1508 -> 6042
    //   7553: astore 22
    //   7555: aload 23
    //   7557: astore 28
    //   7559: aload 30
    //   7561: astore 23
    //   7563: aload 24
    //   7565: astore 25
    //   7567: iload 10
    //   7569: istore 8
    //   7571: iload 14
    //   7573: istore 7
    //   7575: goto -1533 -> 6042
    //   7578: astore 26
    //   7580: aload 22
    //   7582: astore 25
    //   7584: aload 26
    //   7586: astore 22
    //   7588: aload 23
    //   7590: astore 28
    //   7592: aload 25
    //   7594: astore 23
    //   7596: aload 24
    //   7598: astore 25
    //   7600: iload 10
    //   7602: istore 8
    //   7604: iload 14
    //   7606: istore 7
    //   7608: goto -1566 -> 6042
    //   7611: astore 26
    //   7613: aload 22
    //   7615: astore 25
    //   7617: aload 26
    //   7619: astore 22
    //   7621: aload 23
    //   7623: astore 28
    //   7625: aload 25
    //   7627: astore 23
    //   7629: aload 24
    //   7631: astore 25
    //   7633: iload 10
    //   7635: istore 8
    //   7637: iload_3
    //   7638: istore 7
    //   7640: goto -1598 -> 6042
    //   7643: astore 26
    //   7645: aload 22
    //   7647: astore 25
    //   7649: aload 26
    //   7651: astore 22
    //   7653: aload 23
    //   7655: astore 28
    //   7657: aload 25
    //   7659: astore 23
    //   7661: aload 24
    //   7663: astore 25
    //   7665: iload 10
    //   7667: istore 8
    //   7669: iload_3
    //   7670: istore 7
    //   7672: goto -1630 -> 6042
    //   7675: astore 26
    //   7677: aload 22
    //   7679: astore 25
    //   7681: aload 26
    //   7683: astore 22
    //   7685: aload 23
    //   7687: astore 28
    //   7689: aload 25
    //   7691: astore 23
    //   7693: aload 24
    //   7695: astore 25
    //   7697: iload 4
    //   7699: istore 8
    //   7701: iload_3
    //   7702: istore 7
    //   7704: goto -1662 -> 6042
    //   7707: astore 22
    //   7709: aconst_null
    //   7710: astore 25
    //   7712: iconst_0
    //   7713: istore 5
    //   7715: aload 23
    //   7717: astore 28
    //   7719: aload 29
    //   7721: astore 23
    //   7723: iload 9
    //   7725: istore 8
    //   7727: iload 13
    //   7729: istore 7
    //   7731: goto -2318 -> 5413
    //   7734: astore 22
    //   7736: iconst_0
    //   7737: istore 5
    //   7739: aload 23
    //   7741: astore 28
    //   7743: aload 29
    //   7745: astore 23
    //   7747: aload 24
    //   7749: astore 25
    //   7751: iload 9
    //   7753: istore 8
    //   7755: iload 13
    //   7757: istore 7
    //   7759: goto -2346 -> 5413
    //   7762: astore 22
    //   7764: iconst_0
    //   7765: istore 5
    //   7767: aload 23
    //   7769: astore 28
    //   7771: aload 29
    //   7773: astore 23
    //   7775: aload 24
    //   7777: astore 25
    //   7779: iload 9
    //   7781: istore 8
    //   7783: iload 13
    //   7785: istore 7
    //   7787: goto -2374 -> 5413
    //   7790: astore 22
    //   7792: iconst_0
    //   7793: istore 5
    //   7795: aload 23
    //   7797: astore 28
    //   7799: aload 29
    //   7801: astore 23
    //   7803: aload 24
    //   7805: astore 25
    //   7807: iload 9
    //   7809: istore 8
    //   7811: iload 13
    //   7813: istore 7
    //   7815: goto -2402 -> 5413
    //   7818: astore 22
    //   7820: aload 23
    //   7822: astore 28
    //   7824: aload 29
    //   7826: astore 23
    //   7828: aload 24
    //   7830: astore 25
    //   7832: iload 9
    //   7834: istore 8
    //   7836: iload 13
    //   7838: istore 7
    //   7840: goto -2427 -> 5413
    //   7843: astore 26
    //   7845: aload 22
    //   7847: astore 25
    //   7849: aload 26
    //   7851: astore 22
    //   7853: aload 23
    //   7855: astore 28
    //   7857: aload 25
    //   7859: astore 23
    //   7861: aload 24
    //   7863: astore 25
    //   7865: iload 9
    //   7867: istore 8
    //   7869: iload 13
    //   7871: istore 7
    //   7873: goto -2460 -> 5413
    //   7876: astore 26
    //   7878: aload 22
    //   7880: astore 25
    //   7882: aload 26
    //   7884: astore 22
    //   7886: aload 23
    //   7888: astore 28
    //   7890: aload 25
    //   7892: astore 23
    //   7894: aload 24
    //   7896: astore 25
    //   7898: iload 9
    //   7900: istore 8
    //   7902: iload_3
    //   7903: istore 7
    //   7905: goto -2492 -> 5413
    //   7908: astore 26
    //   7910: aload 22
    //   7912: astore 25
    //   7914: aload 26
    //   7916: astore 22
    //   7918: aload 23
    //   7920: astore 28
    //   7922: aload 25
    //   7924: astore 23
    //   7926: aload 24
    //   7928: astore 25
    //   7930: iload 9
    //   7932: istore 8
    //   7934: iload_3
    //   7935: istore 7
    //   7937: goto -2524 -> 5413
    //   7940: astore 26
    //   7942: aload 22
    //   7944: astore 25
    //   7946: aload 26
    //   7948: astore 22
    //   7950: aload 23
    //   7952: astore 28
    //   7954: aload 25
    //   7956: astore 23
    //   7958: aload 24
    //   7960: astore 25
    //   7962: iload 4
    //   7964: istore 8
    //   7966: iload_3
    //   7967: istore 7
    //   7969: goto -2556 -> 5413
    //   7972: astore 22
    //   7974: aconst_null
    //   7975: astore 23
    //   7977: aconst_null
    //   7978: astore 28
    //   7980: iconst_0
    //   7981: istore 5
    //   7983: aload 27
    //   7985: astore 25
    //   7987: iload 6
    //   7989: istore 8
    //   7991: iload 12
    //   7993: istore 7
    //   7995: goto -6533 -> 1462
    //   7998: astore 22
    //   8000: iconst_0
    //   8001: istore 5
    //   8003: aload 27
    //   8005: astore 25
    //   8007: aload 24
    //   8009: astore 28
    //   8011: iload 6
    //   8013: istore 8
    //   8015: iload 12
    //   8017: istore 7
    //   8019: goto -6557 -> 1462
    //   8022: astore 22
    //   8024: iconst_0
    //   8025: istore 5
    //   8027: aload 27
    //   8029: astore 25
    //   8031: aload 24
    //   8033: astore 28
    //   8035: iload 6
    //   8037: istore 8
    //   8039: iload 12
    //   8041: istore 7
    //   8043: goto -6581 -> 1462
    //   8046: astore 22
    //   8048: iconst_0
    //   8049: istore 5
    //   8051: aload 27
    //   8053: astore 25
    //   8055: aload 24
    //   8057: astore 28
    //   8059: iload 6
    //   8061: istore 8
    //   8063: iload 12
    //   8065: istore 7
    //   8067: goto -6605 -> 1462
    //   8070: astore 22
    //   8072: aload 27
    //   8074: astore 25
    //   8076: aload 24
    //   8078: astore 28
    //   8080: iload 6
    //   8082: istore 8
    //   8084: iload 12
    //   8086: istore 7
    //   8088: goto -6626 -> 1462
    //   8091: astore 26
    //   8093: aload 22
    //   8095: astore 25
    //   8097: aload 26
    //   8099: astore 22
    //   8101: aload 24
    //   8103: astore 28
    //   8105: iload 6
    //   8107: istore 8
    //   8109: iload 12
    //   8111: istore 7
    //   8113: goto -6651 -> 1462
    //   8116: astore 26
    //   8118: aload 22
    //   8120: astore 25
    //   8122: aload 26
    //   8124: astore 22
    //   8126: aload 24
    //   8128: astore 28
    //   8130: iload 6
    //   8132: istore 8
    //   8134: iload_3
    //   8135: istore 7
    //   8137: goto -6675 -> 1462
    //   8140: astore 26
    //   8142: aload 22
    //   8144: astore 25
    //   8146: aload 26
    //   8148: astore 22
    //   8150: aload 24
    //   8152: astore 28
    //   8154: iload 6
    //   8156: istore 8
    //   8158: iload_3
    //   8159: istore 7
    //   8161: goto -6699 -> 1462
    //   8164: astore 26
    //   8166: aload 22
    //   8168: astore 25
    //   8170: aload 26
    //   8172: astore 22
    //   8174: aload 24
    //   8176: astore 28
    //   8178: iload 4
    //   8180: istore 8
    //   8182: iload_3
    //   8183: istore 7
    //   8185: goto -6723 -> 1462
    //   8188: astore 22
    //   8190: aconst_null
    //   8191: astore 23
    //   8193: aconst_null
    //   8194: astore 28
    //   8196: iconst_0
    //   8197: istore 5
    //   8199: aload 26
    //   8201: astore 25
    //   8203: iload 11
    //   8205: istore 7
    //   8207: goto -7311 -> 896
    //   8210: astore 22
    //   8212: iconst_0
    //   8213: istore 5
    //   8215: aload 26
    //   8217: astore 25
    //   8219: aload 24
    //   8221: astore 28
    //   8223: iload 11
    //   8225: istore 7
    //   8227: goto -7331 -> 896
    //   8230: astore 22
    //   8232: iconst_0
    //   8233: istore 5
    //   8235: aload 26
    //   8237: astore 25
    //   8239: aload 24
    //   8241: astore 28
    //   8243: iload 11
    //   8245: istore 7
    //   8247: goto -7351 -> 896
    //   8250: astore 22
    //   8252: iconst_0
    //   8253: istore 5
    //   8255: aload 26
    //   8257: astore 25
    //   8259: aload 24
    //   8261: astore 28
    //   8263: iload 11
    //   8265: istore 7
    //   8267: goto -7371 -> 896
    //   8270: astore 22
    //   8272: aload 26
    //   8274: astore 25
    //   8276: aload 24
    //   8278: astore 28
    //   8280: iload 11
    //   8282: istore 7
    //   8284: goto -7388 -> 896
    //   8287: astore 26
    //   8289: aload 22
    //   8291: astore 25
    //   8293: aload 26
    //   8295: astore 22
    //   8297: aload 24
    //   8299: astore 28
    //   8301: iload 11
    //   8303: istore 7
    //   8305: goto -7409 -> 896
    //   8308: astore 26
    //   8310: aload 22
    //   8312: astore 25
    //   8314: aload 26
    //   8316: astore 22
    //   8318: aload 24
    //   8320: astore 28
    //   8322: iload_3
    //   8323: istore 7
    //   8325: goto -7429 -> 896
    //   8328: astore 26
    //   8330: aload 22
    //   8332: astore 25
    //   8334: aload 26
    //   8336: astore 22
    //   8338: aload 24
    //   8340: astore 28
    //   8342: iload_3
    //   8343: istore 7
    //   8345: goto -7449 -> 896
    //   8348: astore 26
    //   8350: aload 22
    //   8352: astore 25
    //   8354: aload 26
    //   8356: astore 22
    //   8358: aload 24
    //   8360: astore 28
    //   8362: iload 4
    //   8364: istore 8
    //   8366: iload_3
    //   8367: istore 7
    //   8369: goto -7473 -> 896
    //   8372: astore 24
    //   8374: aconst_null
    //   8375: astore 23
    //   8377: aconst_null
    //   8378: astore 25
    //   8380: aconst_null
    //   8381: astore 22
    //   8383: iconst_0
    //   8384: istore 5
    //   8386: iconst_0
    //   8387: istore_3
    //   8388: iconst_0
    //   8389: istore 4
    //   8391: goto -7765 -> 626
    //   8394: astore 26
    //   8396: aconst_null
    //   8397: astore 25
    //   8399: aload 24
    //   8401: astore 22
    //   8403: iconst_0
    //   8404: istore 5
    //   8406: iconst_0
    //   8407: istore_3
    //   8408: iconst_0
    //   8409: istore 4
    //   8411: aload 26
    //   8413: astore 24
    //   8415: goto -7789 -> 626
    //   8418: astore 26
    //   8420: aconst_null
    //   8421: astore 25
    //   8423: aload 24
    //   8425: astore 22
    //   8427: iconst_0
    //   8428: istore 5
    //   8430: iconst_0
    //   8431: istore_3
    //   8432: iconst_0
    //   8433: istore 4
    //   8435: aload 26
    //   8437: astore 24
    //   8439: goto -7813 -> 626
    //   8442: astore 26
    //   8444: aconst_null
    //   8445: astore 25
    //   8447: aload 24
    //   8449: astore 22
    //   8451: iconst_0
    //   8452: istore 5
    //   8454: iconst_0
    //   8455: istore_3
    //   8456: iconst_0
    //   8457: istore 4
    //   8459: aload 26
    //   8461: astore 24
    //   8463: goto -7837 -> 626
    //   8466: astore 26
    //   8468: aconst_null
    //   8469: astore 25
    //   8471: aload 24
    //   8473: astore 22
    //   8475: iconst_0
    //   8476: istore_3
    //   8477: iconst_0
    //   8478: istore 4
    //   8480: aload 26
    //   8482: astore 24
    //   8484: goto -7858 -> 626
    //   8487: astore 25
    //   8489: aload 24
    //   8491: astore 26
    //   8493: iconst_0
    //   8494: istore 6
    //   8496: iload_3
    //   8497: istore 4
    //   8499: aload 25
    //   8501: astore 24
    //   8503: iload 6
    //   8505: istore_3
    //   8506: aload 22
    //   8508: astore 25
    //   8510: aload 26
    //   8512: astore 22
    //   8514: goto -7888 -> 626
    //   8517: astore 25
    //   8519: aload 24
    //   8521: astore 26
    //   8523: iload_3
    //   8524: istore 6
    //   8526: aload 25
    //   8528: astore 24
    //   8530: iload 4
    //   8532: istore_3
    //   8533: iload 6
    //   8535: istore 4
    //   8537: aload 22
    //   8539: astore 25
    //   8541: aload 26
    //   8543: astore 22
    //   8545: goto -7919 -> 626
    //   8548: ldc_w 792
    //   8551: astore 25
    //   8553: iconst_0
    //   8554: istore_3
    //   8555: goto -4880 -> 3675
    //   8558: goto -6456 -> 2102
    //   8561: goto -6572 -> 1989
    //   8564: astore 25
    //   8566: aload 24
    //   8568: astore 26
    //   8570: iconst_0
    //   8571: istore 6
    //   8573: iload_3
    //   8574: istore 4
    //   8576: aload 25
    //   8578: astore 24
    //   8580: iload 6
    //   8582: istore_3
    //   8583: aload 22
    //   8585: astore 25
    //   8587: aload 26
    //   8589: astore 22
    //   8591: goto -7965 -> 626
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8594	0	this	a
    //   4036	64	1	d	double
    //   622	7961	3	i	int
    //   624	7951	4	j	int
    //   619	7834	5	k	int
    //   74	8507	6	m	int
    //   83	8285	7	n	int
    //   86	8279	8	i1	int
    //   77	7854	9	i2	int
    //   80	7586	10	i3	int
    //   71	8231	11	i4	int
    //   59	8051	12	i5	int
    //   62	7808	13	i6	int
    //   65	7540	14	i7	int
    //   68	7231	15	i8	int
    //   89	7345	16	l1	long
    //   901	6531	18	l2	long
    //   2095	1997	20	l3	long
    //   22	800	22	str1	String
    //   880	94	22	localFileNotFoundException1	java.io.FileNotFoundException
    //   1442	374	22	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   1967	138	22	localObject1	Object
    //   2345	5	22	localException1	Exception
    //   2374	32	22	localIOException1	IOException
    //   2574	137	22	localObject2	Object
    //   3029	5	22	localException2	Exception
    //   3058	65	22	localIOException2	IOException
    //   3333	5	22	localException3	Exception
    //   3362	5	22	localIOException3	IOException
    //   3438	149	22	localObject3	Object
    //   3591	1	22	localException4	Exception
    //   3608	380	22	localInputStream1	InputStream
    //   4380	5	22	localIOException4	IOException
    //   4409	5	22	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
    //   4438	5	22	localThrowable1	java.lang.Throwable
    //   4467	5	22	localIOException5	IOException
    //   4765	5	22	localIOException6	IOException
    //   4947	5	22	localException5	Exception
    //   4976	5	22	localIOException7	IOException
    //   5005	5	22	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
    //   5034	5	22	localThrowable2	java.lang.Throwable
    //   5063	5	22	localIOException8	IOException
    //   5245	5	22	localException6	Exception
    //   5274	5	22	localIOException9	IOException
    //   5303	5	22	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
    //   5332	5	22	localThrowable3	java.lang.Throwable
    //   5361	5	22	localIOException10	IOException
    //   5390	101	22	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   5874	5	22	localException7	Exception
    //   5903	5	22	localIOException11	IOException
    //   5932	5	22	localArrayIndexOutOfBoundsException4	java.lang.ArrayIndexOutOfBoundsException
    //   5961	5	22	localThrowable4	java.lang.Throwable
    //   5990	5	22	localIOException12	IOException
    //   6019	169	22	localException8	Exception
    //   6518	5	22	localException9	Exception
    //   6547	5	22	localIOException13	IOException
    //   6576	5	22	localArrayIndexOutOfBoundsException5	java.lang.ArrayIndexOutOfBoundsException
    //   6605	5	22	localThrowable5	java.lang.Throwable
    //   6634	5	22	localIOException14	IOException
    //   6663	186	22	localObject4	Object
    //   7148	1	22	localObject5	Object
    //   7177	1	22	localObject6	Object
    //   7203	1	22	localObject7	Object
    //   7226	1	22	localObject8	Object
    //   7249	27	22	localObject9	Object
    //   7281	133	22	localObject10	Object
    //   7429	1	22	localObject11	Object
    //   7442	1	22	localException10	Exception
    //   7469	1	22	localException11	Exception
    //   7497	1	22	localException12	Exception
    //   7525	1	22	localException13	Exception
    //   7553	28	22	localException14	Exception
    //   7586	98	22	localObject12	Object
    //   7707	1	22	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   7734	1	22	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   7762	1	22	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   7790	1	22	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   7818	28	22	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   7851	98	22	localObject13	Object
    //   7972	1	22	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   7998	1	22	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   8022	1	22	localSSLHandshakeException4	javax.net.ssl.SSLHandshakeException
    //   8046	1	22	localSSLHandshakeException5	javax.net.ssl.SSLHandshakeException
    //   8070	24	22	localSSLHandshakeException6	javax.net.ssl.SSLHandshakeException
    //   8099	74	22	localObject14	Object
    //   8188	1	22	localFileNotFoundException2	java.io.FileNotFoundException
    //   8210	1	22	localFileNotFoundException3	java.io.FileNotFoundException
    //   8230	1	22	localFileNotFoundException4	java.io.FileNotFoundException
    //   8250	1	22	localFileNotFoundException5	java.io.FileNotFoundException
    //   8270	20	22	localFileNotFoundException6	java.io.FileNotFoundException
    //   8295	295	22	localObject15	Object
    //   258	3720	23	localInputStream2	InputStream
    //   4351	5	23	localException15	Exception
    //   4649	5	23	localException16	Exception
    //   4678	5	23	localIOException15	IOException
    //   4707	5	23	localArrayIndexOutOfBoundsException6	java.lang.ArrayIndexOutOfBoundsException
    //   4736	5	23	localThrowable6	java.lang.Throwable
    //   5411	1400	23	localObject16	Object
    //   7032	5	23	localIOException16	IOException
    //   7061	5	23	localArrayIndexOutOfBoundsException7	java.lang.ArrayIndexOutOfBoundsException
    //   7090	5	23	localThrowable7	java.lang.Throwable
    //   7119	40	23	localIOException17	IOException
    //   7164	1212	23	localObject17	Object
    //   28	13	24	str2	String
    //   610	38	24	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   913	7446	24	localObject18	Object
    //   8372	28	24	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   8413	166	24	localObject19	Object
    //   50	3423	25	localObject20	Object
    //   3502	12	25	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   3519	1	25	localObject21	Object
    //   3540	56	25	localException17	Exception
    //   3630	2707	25	str3	String
    //   7003	5	25	localException18	Exception
    //   7277	1193	25	localObject22	Object
    //   8487	13	25	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   8508	1	25	localObject23	Object
    //   8517	10	25	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   8539	13	25	localObject24	Object
    //   8564	13	25	localUnsupportedEncodingException6	UnsupportedEncodingException
    //   8585	1	25	localObject25	Object
    //   213	5942	26	localObject26	Object
    //   7273	7	26	localObject27	Object
    //   7305	10	26	localObject28	Object
    //   7336	10	26	localObject29	Object
    //   7367	10	26	localObject30	Object
    //   7402	34	26	localObject31	Object
    //   7578	7	26	localException19	Exception
    //   7611	7	26	localException20	Exception
    //   7643	7	26	localException21	Exception
    //   7675	7	26	localException22	Exception
    //   7843	7	26	localSocketTimeoutException7	java.net.SocketTimeoutException
    //   7876	7	26	localSocketTimeoutException8	java.net.SocketTimeoutException
    //   7908	7	26	localSocketTimeoutException9	java.net.SocketTimeoutException
    //   7940	7	26	localSocketTimeoutException10	java.net.SocketTimeoutException
    //   8091	7	26	localSSLHandshakeException7	javax.net.ssl.SSLHandshakeException
    //   8116	7	26	localSSLHandshakeException8	javax.net.ssl.SSLHandshakeException
    //   8140	7	26	localSSLHandshakeException9	javax.net.ssl.SSLHandshakeException
    //   8164	109	26	localSSLHandshakeException10	javax.net.ssl.SSLHandshakeException
    //   8287	7	26	localFileNotFoundException7	java.io.FileNotFoundException
    //   8308	7	26	localFileNotFoundException8	java.io.FileNotFoundException
    //   8328	7	26	localFileNotFoundException9	java.io.FileNotFoundException
    //   8348	7	26	localFileNotFoundException10	java.io.FileNotFoundException
    //   8394	18	26	localUnsupportedEncodingException7	UnsupportedEncodingException
    //   8418	18	26	localUnsupportedEncodingException8	UnsupportedEncodingException
    //   8442	18	26	localUnsupportedEncodingException9	UnsupportedEncodingException
    //   8466	15	26	localUnsupportedEncodingException10	UnsupportedEncodingException
    //   8491	97	26	localObject32	Object
    //   201	7872	27	localObject33	Object
    //   210	8151	28	localObject34	Object
    //   204	7621	29	localObject35	Object
    //   207	7353	30	localObject36	Object
    //   10	7125	31	str4	String
    //   16	7124	32	str5	String
    //   269	3388	33	localURL	URL
    //   251	1840	34	localu	u
    //   221	1695	35	str6	String
    //   56	1897	36	localObject37	Object
    //   506	1434	37	localObject38	Object
    //   1281	13	38	localIterator	Iterator
    //   1303	84	39	str7	String
    //   1317	108	40	str8	String
    // Exception table:
    //   from	to	target	type
    //   260	328	610	java/io/UnsupportedEncodingException
    //   328	450	610	java/io/UnsupportedEncodingException
    //   455	486	610	java/io/UnsupportedEncodingException
    //   486	607	610	java/io/UnsupportedEncodingException
    //   850	877	610	java/io/UnsupportedEncodingException
    //   1204	1243	610	java/io/UnsupportedEncodingException
    //   1248	1283	610	java/io/UnsupportedEncodingException
    //   1283	1439	610	java/io/UnsupportedEncodingException
    //   1770	1939	610	java/io/UnsupportedEncodingException
    //   1939	1965	610	java/io/UnsupportedEncodingException
    //   1974	1979	610	java/io/UnsupportedEncodingException
    //   1984	1989	610	java/io/UnsupportedEncodingException
    //   1989	2074	610	java/io/UnsupportedEncodingException
    //   260	328	880	java/io/FileNotFoundException
    //   328	450	880	java/io/FileNotFoundException
    //   455	486	880	java/io/FileNotFoundException
    //   486	607	880	java/io/FileNotFoundException
    //   850	877	880	java/io/FileNotFoundException
    //   1204	1243	880	java/io/FileNotFoundException
    //   1248	1283	880	java/io/FileNotFoundException
    //   1283	1439	880	java/io/FileNotFoundException
    //   1770	1939	880	java/io/FileNotFoundException
    //   1939	1965	880	java/io/FileNotFoundException
    //   1974	1979	880	java/io/FileNotFoundException
    //   1984	1989	880	java/io/FileNotFoundException
    //   1989	2074	880	java/io/FileNotFoundException
    //   260	328	1442	javax/net/ssl/SSLHandshakeException
    //   328	450	1442	javax/net/ssl/SSLHandshakeException
    //   455	486	1442	javax/net/ssl/SSLHandshakeException
    //   486	607	1442	javax/net/ssl/SSLHandshakeException
    //   850	877	1442	javax/net/ssl/SSLHandshakeException
    //   1204	1243	1442	javax/net/ssl/SSLHandshakeException
    //   1248	1283	1442	javax/net/ssl/SSLHandshakeException
    //   1283	1439	1442	javax/net/ssl/SSLHandshakeException
    //   1770	1939	1442	javax/net/ssl/SSLHandshakeException
    //   1939	1965	1442	javax/net/ssl/SSLHandshakeException
    //   1974	1979	1442	javax/net/ssl/SSLHandshakeException
    //   1984	1989	1442	javax/net/ssl/SSLHandshakeException
    //   1989	2074	1442	javax/net/ssl/SSLHandshakeException
    //   2311	2316	2345	java/lang/Exception
    //   2316	2321	2374	java/io/IOException
    //   2873	2878	3029	java/lang/Exception
    //   2878	2883	3058	java/io/IOException
    //   3299	3304	3333	java/lang/Exception
    //   3304	3309	3362	java/io/IOException
    //   3445	3472	3502	java/io/UnsupportedEncodingException
    //   3472	3479	3502	java/io/UnsupportedEncodingException
    //   3484	3499	3502	java/io/UnsupportedEncodingException
    //   3625	3645	3502	java/io/UnsupportedEncodingException
    //   3408	3440	3540	java/lang/Exception
    //   3528	3537	3540	java/lang/Exception
    //   3556	3588	3591	java/lang/Exception
    //   3613	3622	3591	java/lang/Exception
    //   3977	3982	4351	java/lang/Exception
    //   3987	3992	4380	java/io/IOException
    //   3987	3992	4409	java/lang/ArrayIndexOutOfBoundsException
    //   3987	3992	4438	finally
    //   3992	3997	4467	java/io/IOException
    //   801	806	4649	java/lang/Exception
    //   811	816	4678	java/io/IOException
    //   811	816	4707	java/lang/ArrayIndexOutOfBoundsException
    //   811	816	4736	finally
    //   821	826	4765	java/io/IOException
    //   1155	1160	4947	java/lang/Exception
    //   1165	1170	4976	java/io/IOException
    //   1165	1170	5005	java/lang/ArrayIndexOutOfBoundsException
    //   1165	1170	5034	finally
    //   1175	1180	5063	java/io/IOException
    //   1721	1726	5245	java/lang/Exception
    //   1731	1736	5274	java/io/IOException
    //   1731	1736	5303	java/lang/ArrayIndexOutOfBoundsException
    //   1731	1736	5332	finally
    //   1741	1746	5361	java/io/IOException
    //   223	260	5390	java/net/SocketTimeoutException
    //   5672	5677	5874	java/lang/Exception
    //   5682	5687	5903	java/io/IOException
    //   5682	5687	5932	java/lang/ArrayIndexOutOfBoundsException
    //   5682	5687	5961	finally
    //   5692	5697	5990	java/io/IOException
    //   223	260	6019	java/lang/Exception
    //   6316	6321	6518	java/lang/Exception
    //   6326	6331	6547	java/io/IOException
    //   6326	6331	6576	java/lang/ArrayIndexOutOfBoundsException
    //   6326	6331	6605	finally
    //   6336	6341	6634	java/io/IOException
    //   223	260	6663	finally
    //   6800	6805	7003	java/lang/Exception
    //   6810	6815	7032	java/io/IOException
    //   6810	6815	7061	java/lang/ArrayIndexOutOfBoundsException
    //   6810	6815	7090	finally
    //   6820	6825	7119	java/io/IOException
    //   260	328	7148	finally
    //   328	450	7148	finally
    //   455	486	7148	finally
    //   486	607	7148	finally
    //   850	877	7148	finally
    //   1204	1243	7148	finally
    //   1248	1283	7148	finally
    //   1283	1439	7148	finally
    //   1770	1939	7148	finally
    //   1939	1965	7148	finally
    //   1974	1979	7148	finally
    //   1984	1989	7148	finally
    //   1989	2074	7148	finally
    //   2074	2097	7177	finally
    //   2102	2111	7203	finally
    //   2117	2154	7203	finally
    //   2403	2413	7203	finally
    //   2517	2529	7203	finally
    //   2536	2558	7203	finally
    //   2558	2567	7203	finally
    //   2428	2447	7226	finally
    //   2456	2471	7226	finally
    //   2475	2511	7226	finally
    //   2567	2587	7249	finally
    //   2608	2655	7249	finally
    //   2663	2767	7249	finally
    //   3087	3141	7249	finally
    //   3391	3408	7249	finally
    //   3408	3440	7249	finally
    //   3528	3537	7249	finally
    //   3542	3556	7249	finally
    //   3556	3588	7249	finally
    //   3593	3607	7249	finally
    //   3613	3622	7249	finally
    //   3445	3472	7273	finally
    //   3472	3479	7273	finally
    //   3484	3499	7273	finally
    //   3625	3645	7273	finally
    //   3645	3675	7305	finally
    //   3675	3750	7336	finally
    //   3764	3792	7336	finally
    //   4037	4046	7336	finally
    //   4050	4115	7336	finally
    //   4118	4127	7336	finally
    //   4134	4143	7336	finally
    //   4150	4159	7336	finally
    //   4166	4193	7336	finally
    //   3795	3865	7367	finally
    //   626	689	7402	finally
    //   923	944	7429	finally
    //   971	995	7429	finally
    //   1022	1042	7429	finally
    //   1489	1510	7429	finally
    //   1537	1561	7429	finally
    //   1588	1608	7429	finally
    //   5440	5461	7429	finally
    //   5488	5512	7429	finally
    //   5539	5559	7429	finally
    //   6069	6090	7429	finally
    //   6117	6141	7429	finally
    //   6168	6203	7429	finally
    //   260	328	7442	java/lang/Exception
    //   328	450	7442	java/lang/Exception
    //   455	486	7442	java/lang/Exception
    //   486	607	7442	java/lang/Exception
    //   850	877	7442	java/lang/Exception
    //   1204	1243	7442	java/lang/Exception
    //   1248	1283	7442	java/lang/Exception
    //   1283	1439	7442	java/lang/Exception
    //   1770	1939	7442	java/lang/Exception
    //   1939	1965	7442	java/lang/Exception
    //   1974	1979	7442	java/lang/Exception
    //   1984	1989	7442	java/lang/Exception
    //   1989	2074	7442	java/lang/Exception
    //   2074	2097	7469	java/lang/Exception
    //   2102	2111	7497	java/lang/Exception
    //   2117	2154	7497	java/lang/Exception
    //   2403	2413	7497	java/lang/Exception
    //   2517	2529	7497	java/lang/Exception
    //   2536	2558	7497	java/lang/Exception
    //   2558	2567	7497	java/lang/Exception
    //   2428	2447	7525	java/lang/Exception
    //   2456	2471	7525	java/lang/Exception
    //   2475	2511	7525	java/lang/Exception
    //   2567	2587	7553	java/lang/Exception
    //   2608	2655	7553	java/lang/Exception
    //   2663	2767	7553	java/lang/Exception
    //   3087	3141	7553	java/lang/Exception
    //   3391	3408	7553	java/lang/Exception
    //   3542	3556	7553	java/lang/Exception
    //   3593	3607	7553	java/lang/Exception
    //   3445	3472	7578	java/lang/Exception
    //   3472	3479	7578	java/lang/Exception
    //   3484	3499	7578	java/lang/Exception
    //   3625	3645	7578	java/lang/Exception
    //   3645	3675	7611	java/lang/Exception
    //   3675	3750	7643	java/lang/Exception
    //   3764	3792	7643	java/lang/Exception
    //   4037	4046	7643	java/lang/Exception
    //   4050	4115	7643	java/lang/Exception
    //   4118	4127	7643	java/lang/Exception
    //   4134	4143	7643	java/lang/Exception
    //   4150	4159	7643	java/lang/Exception
    //   4166	4193	7643	java/lang/Exception
    //   3795	3865	7675	java/lang/Exception
    //   260	328	7707	java/net/SocketTimeoutException
    //   328	450	7707	java/net/SocketTimeoutException
    //   455	486	7707	java/net/SocketTimeoutException
    //   486	607	7707	java/net/SocketTimeoutException
    //   850	877	7707	java/net/SocketTimeoutException
    //   1204	1243	7707	java/net/SocketTimeoutException
    //   1248	1283	7707	java/net/SocketTimeoutException
    //   1283	1439	7707	java/net/SocketTimeoutException
    //   1770	1939	7707	java/net/SocketTimeoutException
    //   1939	1965	7707	java/net/SocketTimeoutException
    //   1974	1979	7707	java/net/SocketTimeoutException
    //   1984	1989	7707	java/net/SocketTimeoutException
    //   1989	2074	7707	java/net/SocketTimeoutException
    //   2074	2097	7734	java/net/SocketTimeoutException
    //   2102	2111	7762	java/net/SocketTimeoutException
    //   2117	2154	7762	java/net/SocketTimeoutException
    //   2403	2413	7762	java/net/SocketTimeoutException
    //   2517	2529	7762	java/net/SocketTimeoutException
    //   2536	2558	7762	java/net/SocketTimeoutException
    //   2558	2567	7762	java/net/SocketTimeoutException
    //   2428	2447	7790	java/net/SocketTimeoutException
    //   2456	2471	7790	java/net/SocketTimeoutException
    //   2475	2511	7790	java/net/SocketTimeoutException
    //   2567	2587	7818	java/net/SocketTimeoutException
    //   2608	2655	7818	java/net/SocketTimeoutException
    //   2663	2767	7818	java/net/SocketTimeoutException
    //   3087	3141	7818	java/net/SocketTimeoutException
    //   3391	3408	7818	java/net/SocketTimeoutException
    //   3408	3440	7818	java/net/SocketTimeoutException
    //   3528	3537	7818	java/net/SocketTimeoutException
    //   3542	3556	7818	java/net/SocketTimeoutException
    //   3556	3588	7818	java/net/SocketTimeoutException
    //   3593	3607	7818	java/net/SocketTimeoutException
    //   3613	3622	7818	java/net/SocketTimeoutException
    //   3445	3472	7843	java/net/SocketTimeoutException
    //   3472	3479	7843	java/net/SocketTimeoutException
    //   3484	3499	7843	java/net/SocketTimeoutException
    //   3625	3645	7843	java/net/SocketTimeoutException
    //   3645	3675	7876	java/net/SocketTimeoutException
    //   3675	3750	7908	java/net/SocketTimeoutException
    //   3764	3792	7908	java/net/SocketTimeoutException
    //   4037	4046	7908	java/net/SocketTimeoutException
    //   4050	4115	7908	java/net/SocketTimeoutException
    //   4118	4127	7908	java/net/SocketTimeoutException
    //   4134	4143	7908	java/net/SocketTimeoutException
    //   4150	4159	7908	java/net/SocketTimeoutException
    //   4166	4193	7908	java/net/SocketTimeoutException
    //   3795	3865	7940	java/net/SocketTimeoutException
    //   223	260	7972	javax/net/ssl/SSLHandshakeException
    //   2074	2097	7998	javax/net/ssl/SSLHandshakeException
    //   2102	2111	8022	javax/net/ssl/SSLHandshakeException
    //   2117	2154	8022	javax/net/ssl/SSLHandshakeException
    //   2403	2413	8022	javax/net/ssl/SSLHandshakeException
    //   2517	2529	8022	javax/net/ssl/SSLHandshakeException
    //   2536	2558	8022	javax/net/ssl/SSLHandshakeException
    //   2558	2567	8022	javax/net/ssl/SSLHandshakeException
    //   2428	2447	8046	javax/net/ssl/SSLHandshakeException
    //   2456	2471	8046	javax/net/ssl/SSLHandshakeException
    //   2475	2511	8046	javax/net/ssl/SSLHandshakeException
    //   2567	2587	8070	javax/net/ssl/SSLHandshakeException
    //   2608	2655	8070	javax/net/ssl/SSLHandshakeException
    //   2663	2767	8070	javax/net/ssl/SSLHandshakeException
    //   3087	3141	8070	javax/net/ssl/SSLHandshakeException
    //   3391	3408	8070	javax/net/ssl/SSLHandshakeException
    //   3408	3440	8070	javax/net/ssl/SSLHandshakeException
    //   3528	3537	8070	javax/net/ssl/SSLHandshakeException
    //   3542	3556	8070	javax/net/ssl/SSLHandshakeException
    //   3556	3588	8070	javax/net/ssl/SSLHandshakeException
    //   3593	3607	8070	javax/net/ssl/SSLHandshakeException
    //   3613	3622	8070	javax/net/ssl/SSLHandshakeException
    //   3445	3472	8091	javax/net/ssl/SSLHandshakeException
    //   3472	3479	8091	javax/net/ssl/SSLHandshakeException
    //   3484	3499	8091	javax/net/ssl/SSLHandshakeException
    //   3625	3645	8091	javax/net/ssl/SSLHandshakeException
    //   3645	3675	8116	javax/net/ssl/SSLHandshakeException
    //   3675	3750	8140	javax/net/ssl/SSLHandshakeException
    //   3764	3792	8140	javax/net/ssl/SSLHandshakeException
    //   4037	4046	8140	javax/net/ssl/SSLHandshakeException
    //   4050	4115	8140	javax/net/ssl/SSLHandshakeException
    //   4118	4127	8140	javax/net/ssl/SSLHandshakeException
    //   4134	4143	8140	javax/net/ssl/SSLHandshakeException
    //   4150	4159	8140	javax/net/ssl/SSLHandshakeException
    //   4166	4193	8140	javax/net/ssl/SSLHandshakeException
    //   3795	3865	8164	javax/net/ssl/SSLHandshakeException
    //   223	260	8188	java/io/FileNotFoundException
    //   2074	2097	8210	java/io/FileNotFoundException
    //   2102	2111	8230	java/io/FileNotFoundException
    //   2117	2154	8230	java/io/FileNotFoundException
    //   2403	2413	8230	java/io/FileNotFoundException
    //   2517	2529	8230	java/io/FileNotFoundException
    //   2536	2558	8230	java/io/FileNotFoundException
    //   2558	2567	8230	java/io/FileNotFoundException
    //   2428	2447	8250	java/io/FileNotFoundException
    //   2456	2471	8250	java/io/FileNotFoundException
    //   2475	2511	8250	java/io/FileNotFoundException
    //   2567	2587	8270	java/io/FileNotFoundException
    //   2608	2655	8270	java/io/FileNotFoundException
    //   2663	2767	8270	java/io/FileNotFoundException
    //   3087	3141	8270	java/io/FileNotFoundException
    //   3391	3408	8270	java/io/FileNotFoundException
    //   3408	3440	8270	java/io/FileNotFoundException
    //   3528	3537	8270	java/io/FileNotFoundException
    //   3542	3556	8270	java/io/FileNotFoundException
    //   3556	3588	8270	java/io/FileNotFoundException
    //   3593	3607	8270	java/io/FileNotFoundException
    //   3613	3622	8270	java/io/FileNotFoundException
    //   3445	3472	8287	java/io/FileNotFoundException
    //   3472	3479	8287	java/io/FileNotFoundException
    //   3484	3499	8287	java/io/FileNotFoundException
    //   3625	3645	8287	java/io/FileNotFoundException
    //   3645	3675	8308	java/io/FileNotFoundException
    //   3675	3750	8328	java/io/FileNotFoundException
    //   3764	3792	8328	java/io/FileNotFoundException
    //   4037	4046	8328	java/io/FileNotFoundException
    //   4050	4115	8328	java/io/FileNotFoundException
    //   4118	4127	8328	java/io/FileNotFoundException
    //   4134	4143	8328	java/io/FileNotFoundException
    //   4150	4159	8328	java/io/FileNotFoundException
    //   4166	4193	8328	java/io/FileNotFoundException
    //   3795	3865	8348	java/io/FileNotFoundException
    //   223	260	8372	java/io/UnsupportedEncodingException
    //   2074	2097	8394	java/io/UnsupportedEncodingException
    //   2102	2111	8418	java/io/UnsupportedEncodingException
    //   2117	2154	8418	java/io/UnsupportedEncodingException
    //   2403	2413	8418	java/io/UnsupportedEncodingException
    //   2517	2529	8418	java/io/UnsupportedEncodingException
    //   2536	2558	8418	java/io/UnsupportedEncodingException
    //   2558	2567	8418	java/io/UnsupportedEncodingException
    //   2428	2447	8442	java/io/UnsupportedEncodingException
    //   2456	2471	8442	java/io/UnsupportedEncodingException
    //   2475	2511	8442	java/io/UnsupportedEncodingException
    //   2567	2587	8466	java/io/UnsupportedEncodingException
    //   2608	2655	8466	java/io/UnsupportedEncodingException
    //   2663	2767	8466	java/io/UnsupportedEncodingException
    //   3087	3141	8466	java/io/UnsupportedEncodingException
    //   3391	3408	8466	java/io/UnsupportedEncodingException
    //   3408	3440	8466	java/io/UnsupportedEncodingException
    //   3528	3537	8466	java/io/UnsupportedEncodingException
    //   3542	3556	8466	java/io/UnsupportedEncodingException
    //   3556	3588	8466	java/io/UnsupportedEncodingException
    //   3593	3607	8466	java/io/UnsupportedEncodingException
    //   3613	3622	8466	java/io/UnsupportedEncodingException
    //   3645	3675	8487	java/io/UnsupportedEncodingException
    //   3795	3865	8517	java/io/UnsupportedEncodingException
    //   3675	3750	8564	java/io/UnsupportedEncodingException
    //   3764	3792	8564	java/io/UnsupportedEncodingException
    //   4037	4046	8564	java/io/UnsupportedEncodingException
    //   4050	4115	8564	java/io/UnsupportedEncodingException
    //   4118	4127	8564	java/io/UnsupportedEncodingException
    //   4134	4143	8564	java/io/UnsupportedEncodingException
    //   4150	4159	8564	java/io/UnsupportedEncodingException
    //   4166	4193	8564	java/io/UnsupportedEncodingException
  }
  
  public final int cCj()
  {
    AppMethodBeat.i(319242);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(319242);
    return i;
  }
  
  public final void cCx()
  {
    AppMethodBeat.i(319250);
    this.Uz = false;
    if (this.tnT != null) {}
    try
    {
      this.tnT.getInputStream().close();
      this.tnT.disconnect();
      if (!Util.isNullOrNil(this.toR)) {
        CronetLogic.cancelCronetTask(this.toR);
      }
      AppMethodBeat.o(319250);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkUploadWorker", localIOException, "abortTask IOException", new Object[0]);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkUploadWorker", localException, "abortTask Exception", new Object[0]);
      }
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(319247);
    if ((!URLUtil.isHttpsUrl(this.mUrl)) && (!URLUtil.isHttpUrl(this.mUrl)))
    {
      this.toX.O(this.mFileName, this.mUrl, "uploadFile protocol must be http or https");
      ((n)e.U(n.class)).a(this.eqB.getAppId(), this.tnV, "POST", this.mUrl, 0L, 0L, 0, 2, cCj(), null, this.mMimeType);
      AppMethodBeat.o(319247);
      return;
    }
    if ((this.tnQ != null) && (!com.tencent.mm.plugin.appbrand.t.i.c(this.tnQ, this.mUrl)))
    {
      Object localObject = null;
      try
      {
        String str = new URL(this.mUrl).getHost();
        localObject = str;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandNetworkUploadWorker", localMalformedURLException, "get redirect url host fail Exception", new Object[0]);
          continue;
          this.toX.O(this.mFileName, this.mUrl, "redirect url not in domain list");
        }
      }
      if (!Util.isNullOrNil(localObject))
      {
        this.toX.O(this.mFileName, this.mUrl, "redirect url not in domain list:".concat(String.valueOf(localObject)));
        this.toX.O(this.mFileName, this.mUrl, "redirect url not in domain list");
        ((n)e.U(n.class)).a(this.eqB.getAppId(), this.tnV, "POST", this.mUrl, 0L, 0L, 0, 2, cCj(), null, this.mMimeType);
        Log.i("MicroMsg.AppBrandNetworkUploadWorker", "not in domain url %s", new Object[] { this.mUrl });
        AppMethodBeat.o(319247);
        return;
      }
    }
    if (this.skm)
    {
      cCy();
      AppMethodBeat.o(319247);
      return;
    }
    cCz();
    AppMethodBeat.o(319247);
  }
  
  final class a
  {
    public int percent = 0;
    public int pnX = -1;
    public boolean success = false;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b.a
 * JD-Core Version:    0.7.0.1
 */