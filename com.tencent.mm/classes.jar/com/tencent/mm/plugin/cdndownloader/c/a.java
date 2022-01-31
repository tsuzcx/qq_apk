package com.tencent.mm.plugin.cdndownloader.c;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.b.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements b.a
{
  private static a kDx = null;
  private al eIo;
  Queue<String> fyK;
  public Map<String, g> fyL;
  public Map<String, g> fyM;
  public Map<String, Integer> fyN;
  private String fyO;
  private long fyP;
  public HashSet<String> fyQ;
  private com.tencent.mm.al.a kDy;
  
  public a()
  {
    AppMethodBeat.i(879);
    this.fyK = new LinkedList();
    this.fyL = new ConcurrentHashMap();
    this.fyM = new ConcurrentHashMap();
    this.fyN = new ConcurrentHashMap();
    this.eIo = new al();
    this.kDy = null;
    this.fyO = "";
    this.fyP = 0L;
    this.fyQ = new HashSet();
    AppMethodBeat.o(879);
  }
  
  public static boolean IR(String paramString)
  {
    AppMethodBeat.i(883);
    int i = CdnLogic.pauseHttpMultiSocketDownloadTask(paramString);
    ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(883);
      return true;
    }
    AppMethodBeat.o(883);
    return false;
  }
  
  public static a bfS()
  {
    try
    {
      AppMethodBeat.i(880);
      if (kDx == null) {
        kDx = new a();
      }
      a locala = kDx;
      AppMethodBeat.o(880);
      return locala;
    }
    finally {}
  }
  
  public final int a(final String paramString, final c paramc, final d paramd)
  {
    AppMethodBeat.i(884);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
      AppMethodBeat.o(884);
      return -1;
    }
    if ((paramc == null) && (paramd == null))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
      AppMethodBeat.o(884);
      return -2;
    }
    if (paramc != null) {
      ab.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", new Object[] { Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(paramc.field_isUploadTask) });
    }
    if (paramc != null) {}
    for (final boolean bool = paramc.field_isUploadTask;; bool = false)
    {
      this.fyP = bo.aoy();
      this.fyO = paramString;
      this.eIo.ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(876);
          g localg = (g)a.d(a.this).get(paramString);
          if (localg == null)
          {
            ab.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { paramString });
            AppMethodBeat.o(876);
            return;
          }
          if (paramc != null)
          {
            paramc.cBO = paramString;
            ab.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", new Object[] { Integer.valueOf(paramc.field_toltalLength), Integer.valueOf(paramc.field_finishedLength), Boolean.valueOf(paramc.field_mtlnotify), Boolean.valueOf(localg.cMU), Boolean.valueOf(paramc.field_isUploadTask), Boolean.valueOf(bool) });
            if (bool != localg.cMU)
            {
              AppMethodBeat.o(876);
              return;
            }
          }
          if (paramd != null) {
            paramd.cBO = paramString;
          }
          if (localg.edp != null)
          {
            long l = bo.aoy();
            if ((paramd == null) && (paramc != null) && (!paramc.field_mtlnotify) && (at.getNetWorkType(ah.getContext()) == -1))
            {
              AppMethodBeat.o(876);
              return;
            }
            localg.field_lastProgressCallbackTime = l;
            localg.edp.a(paramString, 0, paramc, paramd, localg.field_onlycheckexist);
          }
          if (a.a(paramc)) {
            a.a(a.this).remove(paramString);
          }
          if (paramd != null)
          {
            a.d(a.this).remove(paramString);
            if (paramd.field_retCode == -5103011)
            {
              ab.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
              h.qsU.idkeyStat(546L, 4L, 1L, true);
              a.e(a.this).keep_OnRequestDoGetCdnDnsInfo(999);
            }
          }
          AppMethodBeat.o(876);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(877);
          String str = super.toString() + "|callback";
          AppMethodBeat.o(877);
          return str;
        }
      });
      AppMethodBeat.o(884);
      return 0;
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(887);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(887);
      return;
    }
    this.eIo.ac(new a.3(this, paramString, paramd));
    AppMethodBeat.o(887);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(885);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
      AppMethodBeat.o(885);
      return;
    }
    g localg = (g)this.fyM.get(paramString);
    if (localg == null)
    {
      ab.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(885);
      return;
    }
    if (localg.edp != null)
    {
      localg.edp.a(paramString, paramByteArrayOutputStream);
      AppMethodBeat.o(885);
      return;
    }
    ab.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
    AppMethodBeat.o(885);
  }
  
  public final com.tencent.mm.al.a afP()
  {
    AppMethodBeat.i(881);
    if (this.kDy == null)
    {
      if (!ah.brt()) {
        break label46;
      }
      ab.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
    }
    for (this.kDy = f.afP();; this.kDy = new com.tencent.mm.al.a(ah.getContext().getFilesDir() + "/NativeCDNInfo", this))
    {
      com.tencent.mm.al.a locala = this.kDy;
      AppMethodBeat.o(881);
      return locala;
      label46:
      ab.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
    }
  }
  
  public final int f(g paramg)
  {
    AppMethodBeat.i(882);
    if (bo.isNullOrNil(paramg.field_mediaId))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
      AppMethodBeat.o(882);
      return -1;
    }
    if (paramg.field_fileId == null) {
      paramg.field_fileId = "";
    }
    if (paramg.field_aesKey == null) {
      paramg.field_aesKey = "";
    }
    if (this.fyK.contains(paramg.field_fileId))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
      AppMethodBeat.o(882);
      return -2;
    }
    if (this.fyL.containsKey(paramg.field_fileId))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
      AppMethodBeat.o(882);
      return -2;
    }
    if (this.fyM.containsKey(paramg.field_fileId))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
      AppMethodBeat.o(882);
      return -2;
    }
    paramg.cMU = false;
    this.eIo.ac(new a.1(this, paramg));
    AppMethodBeat.o(882);
    return 0;
  }
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(886);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
      AppMethodBeat.o(886);
      return null;
    }
    g localg = (g)this.fyM.get(paramString);
    if (localg == null)
    {
      ab.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[] { paramString });
      AppMethodBeat.o(886);
      return null;
    }
    if (localg.edp != null)
    {
      paramString = localg.edp.l(paramString, paramArrayOfByte);
      AppMethodBeat.o(886);
      return paramString;
    }
    ab.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
    AppMethodBeat.o(886);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a
 * JD-Core Version:    0.7.0.1
 */