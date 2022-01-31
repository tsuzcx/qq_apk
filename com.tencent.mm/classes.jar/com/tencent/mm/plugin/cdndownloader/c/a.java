package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.j.b.a;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a iAr = null;
  private ai dKQ = new ai();
  Queue<String> eiG = new LinkedList();
  public Map<String, com.tencent.mm.j.f> eiH = new ConcurrentHashMap();
  public Map<String, com.tencent.mm.j.f> eiI = new ConcurrentHashMap();
  public Map<String, Integer> eiJ = new ConcurrentHashMap();
  private String eiK = "";
  private long eiL = 0L;
  public HashSet<String> eiM = new HashSet();
  private com.tencent.mm.ak.a iAs = null;
  
  public static a aDv()
  {
    try
    {
      if (iAr == null) {
        iAr = new a();
      }
      a locala = iAr;
      return locala;
    }
    finally {}
  }
  
  public static boolean zi(String paramString)
  {
    int i = CdnLogic.pauseHttpMultiSocketDownloadTask(paramString);
    y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    return i == 0;
  }
  
  public final com.tencent.mm.ak.a Ne()
  {
    if (this.iAs == null)
    {
      if (!ae.cqV()) {
        break label32;
      }
      y.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.iAs = com.tencent.mm.ak.f.Ne();; this.iAs = new com.tencent.mm.ak.a(ae.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      return this.iAs;
      label32:
      y.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final int a(final String paramString, final c paramc, final d paramd)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
      return -2;
    }
    if (paramc != null) {
      y.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[] { Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(paramc.field_isUploadTask) });
    }
    if (paramc != null) {}
    for (final boolean bool = paramc.field_isUploadTask;; bool = false)
    {
      this.eiL = bk.UY();
      this.eiK = paramString;
      this.dKQ.O(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.j.f localf = (com.tencent.mm.j.f)a.d(a.this).get(paramString);
          if (localf == null) {
            y.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
          }
          do
          {
            do
            {
              long l;
              do
              {
                do
                {
                  return;
                  if (paramc == null) {
                    break;
                  }
                  paramc.bUi = paramString;
                  y.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localf.ceg), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
                } while (bool != localf.ceg);
                if (paramd != null) {
                  paramd.bUi = paramString;
                }
                if (localf.dlP == null) {
                  break;
                }
                l = bk.UY();
              } while ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (aq.getNetWorkType(ae.getContext()) == -1));
              localf.field_lastProgressCallbackTime = l;
              localf.dlP.a(paramString, 0, paramc, paramd, localf.field_onlycheckexist);
              if (a.a(paramc)) {
                a.a(a.this).remove(paramString);
              }
            } while (paramd == null);
            a.d(a.this).remove(paramString);
          } while (paramd.field_retCode != -5103011);
          y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
          h.nFQ.a(546L, 4L, 1L, true);
          a.e(a.this).keep_OnRequestDoGetCdnDnsInfo(999);
        }
        
        public final String toString()
        {
          return super.toString() + "|callback";
        }
      });
      return 0;
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.dKQ.O(new a.3(this, paramString, paramd));
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
      return;
    }
    com.tencent.mm.j.f localf = (com.tencent.mm.j.f)this.eiI.get(paramString);
    if (localf == null)
    {
      y.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      return;
    }
    if (localf.dlP != null)
    {
      localf.dlP.a(paramString, paramByteArrayOutputStream);
      return;
    }
    y.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
  }
  
  public final int d(com.tencent.mm.j.f paramf)
  {
    if (bk.bl(paramf.field_mediaId))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
      return -1;
    }
    if (paramf.field_fileId == null) {
      paramf.field_fileId = "";
    }
    if (paramf.field_aesKey == null) {
      paramf.field_aesKey = "";
    }
    if (this.eiG.contains(paramf.field_fileId))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      return -2;
    }
    if (this.eiH.containsKey(paramf.field_fileId))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      return -2;
    }
    if (this.eiI.containsKey(paramf.field_fileId))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      return -2;
    }
    paramf.ceg = false;
    this.dKQ.O(new a.1(this, paramf));
    return 0;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      return null;
    }
    com.tencent.mm.j.f localf = (com.tencent.mm.j.f)this.eiI.get(paramString);
    if (localf == null)
    {
      y.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      return null;
    }
    if (localf.dlP != null) {
      return localf.dlP.f(paramString, paramArrayOfByte);
    }
    y.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */