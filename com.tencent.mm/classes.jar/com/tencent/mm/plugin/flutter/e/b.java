package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.g.b;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements g.a, g.b, h.a
{
  private String Hlu;
  private String Hlv;
  private HashMap<String, a> Hlw;
  private String Hlx;
  private final String TAG;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(263070);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    this.Hlw = new HashMap();
    this.Hlu = (paramContext.getCacheDir() + "/flutter/FTVideo/");
    AppMethodBeat.o(263070);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(263181);
    Log.d(this.TAG, "FVPlayer callback mediaId:" + paramString + ' ');
    AppMethodBeat.o(263181);
    return 0;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(263174);
    Object localObject;
    if ((paramString != null) && (paramd != null)) {
      if (this.Hlw.get(paramString) == null)
      {
        localObject = new a();
        Log.d(this.TAG, "cdntask end id:" + paramString + ", isplaymode:" + ((a)localObject).HlA);
        ((a)localObject).wbD = paramd.field_fileLength;
        ((a)localObject).uWn = paramd.field_fileLength;
        ((a)localObject).cUO = true;
        ((Map)this.Hlw).put(paramString, localObject);
        this.Hlv = null;
      }
    }
    for (;;)
    {
      paramString = (a)((Map)this.Hlw).get(paramString);
      if (paramString != null) {
        paramString.Hlz = false;
      }
      AppMethodBeat.o(263174);
      return;
      localObject = this.Hlw.get(paramString);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(263174);
        throw paramString;
      }
      localObject = (a)localObject;
      break;
      Log.e(this.TAG, s.X("onfinish but id not found:", paramString));
    }
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(263149);
    s.u(paramString2, "svrFlag");
    AppMethodBeat.o(263149);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(263185);
    Log.d(this.TAG, s.X("FVPlayer getCdnAuthInfo mediaId:", paramString));
    AppMethodBeat.o(263185);
  }
  
  public final void a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(263115);
    Log.d(this.TAG, "FVPlayer retryStartTask mediaId:" + paramString2 + " url:" + paramString1);
    a locala = aDD(paramString2);
    if (locala == null)
    {
      paramString2 = null;
      s.checkNotNull(paramString2);
      if (!paramString2.booleanValue()) {
        break label134;
      }
      paramString2 = this.TAG;
      paramLong = new StringBuilder("is already downloading, isPlayMode:false, curMode:");
      if (locala != null) {
        break label122;
      }
    }
    label122:
    for (paramString1 = localObject2;; paramString1 = Boolean.valueOf(locala.HlA))
    {
      Log.d(paramString2, paramString1);
      AppMethodBeat.o(263115);
      return;
      paramString2 = Boolean.valueOf(locala.Hlz);
      break;
    }
    label134:
    if (locala == null)
    {
      paramString2 = null;
      if (!paramString2.booleanValue()) {
        break label221;
      }
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        if (locala != null) {
          break label209;
        }
      }
    }
    label209:
    for (paramString2 = localObject1;; paramString2 = Long.valueOf(locala.Hly))
    {
      if (paramString2.longValue() < paramLong.longValue()) {
        break label221;
      }
      Log.d(this.TAG, "preload already done");
      AppMethodBeat.o(263115);
      return;
      paramString2 = Boolean.valueOf(locala.HlB);
      break;
    }
    label221:
    b(paramString1, paramLong);
    AppMethodBeat.o(263115);
  }
  
  public final int aDC(String paramString)
  {
    AppMethodBeat.i(263123);
    Log.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + paramString + ' ');
    int i = e.HlR.fvk().HlU.agO(paramString);
    a locala = (a)((Map)this.Hlw).get(paramString);
    if (locala != null) {
      locala.Hlz = false;
    }
    if (n.T(this.Hlv, paramString, true)) {
      this.Hlv = null;
    }
    AppMethodBeat.o(263123);
    return i;
  }
  
  public final a aDD(String paramString)
  {
    AppMethodBeat.i(263130);
    if (((Map)this.Hlw).get(paramString) == null)
    {
      paramString = new a();
      AppMethodBeat.o(263130);
      return paramString;
    }
    paramString = ((Map)this.Hlw).get(paramString);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
      AppMethodBeat.o(263130);
      throw paramString;
    }
    paramString = (a)paramString;
    AppMethodBeat.o(263130);
    return paramString;
  }
  
  public final void b(String paramString, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(263166);
    if ((paramString != null) && (paramd != null))
    {
      if (this.Hlw.get(paramString) == null)
      {
        Log.e(this.TAG, s.X("preload completed, but task not found, mediaId:", paramString));
        AppMethodBeat.o(263166);
        return;
      }
      Object localObject = this.Hlw.get(paramString);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(263166);
        throw paramString;
      }
      localObject = (a)localObject;
      Log.d(this.TAG, "cdntask end preload id:" + paramString + ", isplaymode:" + ((a)localObject).HlA);
      ((a)localObject).uWn = paramd.field_fileLength;
      ((a)localObject).Hly = paramd.field_recvedBytes;
      ((a)localObject).HlB = true;
      ((a)localObject).Hlz = false;
      ((Map)this.Hlw).put(paramString, localObject);
      Log.i(this.TAG, s.X("preload completed mediaId:", paramString));
    }
    AppMethodBeat.o(263166);
  }
  
  public final void b(String paramString, Long paramLong)
  {
    AppMethodBeat.i(263084);
    this.Hlx = paramString;
    if (this.Hlx == null)
    {
      Log.d(this.TAG, "FVPlayer preLoadTask empty preload task");
      AppMethodBeat.o(263084);
      return;
    }
    paramString = this.Hlx;
    String str1;
    String str2;
    if (paramString == null)
    {
      paramString = null;
      str1 = g.getMessageDigest(paramString);
      paramString = new StringBuilder().append(this.Hlu).append('-');
      str2 = this.Hlx;
      if (str2 == null) {
        break label181;
      }
    }
    label181:
    for (int i = str2.hashCode();; i = 0)
    {
      str2 = ah.v(new u(i + ".mp4").jKT());
      s.s(str2, "VFSFile(\"${root}-${preLo…ode()}.mp4\").absolutePath");
      if (!n.T(str1, this.Hlv, true)) {
        break label186;
      }
      Log.d(this.TAG, s.X("FVPlayer preLoadTask can not preload playing task lastPlayMediaId:", this.Hlv));
      AppMethodBeat.o(263084);
      return;
      paramString = paramString.getBytes(kotlin.n.d.UTF_8);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
      break;
    }
    label186:
    Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + str1 + " url:" + this.Hlx + " path:" + str2);
    if (this.Hlw.get(str1) == null)
    {
      paramString = new a();
      if ((paramString.HlB) && (paramLong != null) && (paramLong.longValue() != 0L) && (paramString.wbD < paramLong.longValue())) {
        paramString.HlB = false;
      }
      if ((paramString.cUO) || (paramString.HlB) || (paramString.Hlz)) {
        break label629;
      }
      h localh = new h();
      localh.taskName = "task_FlutterCdnDownloadMgr_1";
      localh.field_mediaId = str1;
      localh.url = this.Hlx;
      localh.lwP = 60;
      localh.lwQ = 60;
      localh.lxb = 2;
      localh.lxi = 2;
      localh.lxc = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.connectionCount = 1;
      localh.lxs = ((h.a)this);
      localh.lwL = ((g.a)this);
      localh.lxd = ((g.b)this);
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        localh.preloadMinSize = paramLong.longValue();
      }
      if (CdnLogic.taskExist(str1)) {
        break label595;
      }
      e.HlR.fvk().HlU.g(localh);
      paramString.Hlz = true;
      paramString.HlA = false;
      Log.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + str1 + " .");
    }
    for (;;)
    {
      paramString.setPath(str2);
      paramLong = (Map)this.Hlw;
      s.s(str1, "mediaId");
      paramLong.put(str1, paramString);
      AppMethodBeat.o(263084);
      return;
      paramString = this.Hlw.get(str1);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(263084);
        throw paramString;
      }
      paramString = (a)paramString;
      break;
      label595:
      Log.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + str1 + " .");
      continue;
      label629:
      Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + str1 + " has downloaded or isDoing:" + paramString.cUO + ", " + paramString.HlB + ", " + paramString.Hlz + '.');
    }
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263159);
    Log.d(this.TAG, "onProgress mediaId:" + paramString + ", finish:" + paramLong1 + ", length:" + paramLong2);
    if (paramString != null) {
      if (this.Hlw.get(paramString) != null) {
        break label138;
      }
    }
    for (Object localObject = new a();; localObject = (a)localObject)
    {
      ((a)localObject).wbD = paramLong1;
      ((a)localObject).uWn = paramLong2;
      ((Map)this.Hlw).put(paramString, localObject);
      if (paramLong1 == paramLong2)
      {
        Log.i(this.TAG, s.X("onprogress cdntask end id:", paramString));
        ((a)localObject).cUO = true;
      }
      AppMethodBeat.o(263159);
      return;
      label138:
      localObject = this.Hlw.get(paramString);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(263159);
        throw paramString;
      }
    }
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(263191);
    Log.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + paramString + ' ');
    AppMethodBeat.o(263191);
    return new byte[0];
  }
  
  public final void iB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263105);
    Log.d(this.TAG, "FVPlayer startTask mediaId:" + paramString2 + " url:" + paramString1);
    boolean bool;
    label88:
    String str1;
    label129:
    int i;
    label164:
    String str2;
    if (!CdnLogic.taskExist(paramString2))
    {
      if (((Map)this.Hlw).get(paramString2) == null)
      {
        bool = true;
        paramString2 = (a)((Map)this.Hlw).get(paramString2);
        if (paramString2 != null) {
          break label276;
        }
        paramString2 = null;
        Log.e(this.TAG, "testtest task not in preload, in info cache:" + bool + ", completed:" + paramString2);
      }
    }
    else
    {
      if (paramString1 != null) {
        break label287;
      }
      paramString2 = null;
      str1 = g.getMessageDigest(paramString2);
      paramString2 = new StringBuilder().append(this.Hlu).append('-');
      if (paramString1 == null) {
        break label305;
      }
      i = paramString1.hashCode();
      str2 = ah.v(new u(i + ".mp4").jKT());
      s.s(str2, "VFSFile(\"${root}-${url.h…ode()}.mp4\").absolutePath");
      if (this.Hlw.get(str1) != null) {
        break label310;
      }
    }
    for (paramString2 = new a();; paramString2 = (a)paramString2)
    {
      if ((!n.T(this.Hlv, str1, false)) || (!paramString2.Hlz) || (!paramString2.HlA)) {
        break label350;
      }
      Log.i(this.TAG, s.X("playmode is downloading:", str1));
      AppMethodBeat.o(263105);
      return;
      bool = false;
      break;
      label276:
      paramString2 = Boolean.valueOf(paramString2.cUO);
      break label88;
      label287:
      paramString2 = paramString1.getBytes(kotlin.n.d.UTF_8);
      s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
      break label129;
      label305:
      i = 0;
      break label164;
      label310:
      paramString2 = this.Hlw.get(str1);
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(263105);
        throw paramString1;
      }
    }
    label350:
    if (!paramString2.cUO)
    {
      h localh = new h();
      localh.taskName = "task_FlutterCdnDownloadMgr_2";
      localh.field_mediaId = str1;
      localh.url = paramString1;
      localh.lwP = 60;
      localh.lwQ = 60;
      localh.lxb = 1;
      localh.lxi = 1;
      localh.lxc = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.lxs = ((h.a)this);
      if ((this.Hlv != null) && (!n.T(this.Hlv, str1, false)) && (CdnLogic.taskExist(this.Hlv)))
      {
        i = e.HlR.fvk().HlU.agO(this.Hlv);
        paramString2.Hlz = false;
        Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.Hlv + ' ' + i);
      }
      if ((CdnLogic.taskExist(str1)) && (!paramString2.HlA))
      {
        i = e.HlR.fvk().HlU.agO(str1);
        paramString2.Hlz = false;
        Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.Hlv + " mediaId:" + str1 + ' ' + i);
      }
      i = e.HlR.fvk().HlU.g(localh);
      paramString2.Hlz = true;
      paramString2.HlA = true;
      Log.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + str1 + ' ' + i + " playmode:true path: " + str2);
    }
    for (;;)
    {
      this.Hlv = str1;
      paramString2.setPath(str2);
      paramString1 = (Map)this.Hlw;
      s.s(str1, "mediaId");
      paramString1.put(str1, paramString2);
      AppMethodBeat.o(263105);
      return;
      Log.d(this.TAG, "FVPlayer startTask mediaId:" + str1 + " has downloaded.");
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263155);
    Log.d(this.TAG, "onDataAvailable mediaId:" + paramString + ", offset:" + paramLong1 + ", length:" + paramLong2);
    AppMethodBeat.o(263155);
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263138);
    s.u(paramString1, "mediaId");
    AppMethodBeat.o(263138);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean HlA;
    boolean HlB;
    long Hly;
    boolean Hlz;
    boolean cUO;
    String path = "";
    long uWn;
    long wbD;
    
    public final void setPath(String paramString)
    {
      AppMethodBeat.i(263083);
      s.u(paramString, "<set-?>");
      this.path = paramString;
      AppMethodBeat.o(263083);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.b
 * JD-Core Version:    0.7.0.1
 */