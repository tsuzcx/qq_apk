package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"})
public final class b
  implements g.a, g.b, h.a
{
  private String BCM;
  private String BCN;
  private HashMap<String, a> BCO;
  private String BCP;
  private final String TAG;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(220806);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    this.BCO = new HashMap();
    this.BCM = (paramContext.getCacheDir() + "/flutter/FTVideo/");
    AppMethodBeat.o(220806);
  }
  
  public final void Kj(String paramString)
  {
    AppMethodBeat.i(220777);
    p.k(paramString, "mediaId");
    AppMethodBeat.o(220777);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(220799);
    Log.d(this.TAG, "FVPlayer callback mediaId:" + paramString + ' ');
    AppMethodBeat.o(220799);
    return 0;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(220796);
    Object localObject;
    if ((paramString != null) && (paramd != null)) {
      if (this.BCO.get(paramString) == null)
      {
        localObject = new a();
        Log.d(this.TAG, "cdntask end id:" + paramString + ", isplaymode:" + ((a)localObject).BCS);
        ((a)localObject).sXm = paramd.field_fileLength;
        ((a)localObject).rKZ = paramd.field_fileLength;
        ((a)localObject).baT = true;
        ((Map)this.BCO).put(paramString, localObject);
        this.BCN = null;
      }
    }
    for (;;)
    {
      paramString = (a)((Map)this.BCO).get(paramString);
      if (paramString == null) {
        break label207;
      }
      paramString.BCR = false;
      AppMethodBeat.o(220796);
      return;
      localObject = this.BCO.get(paramString);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(220796);
        throw paramString;
      }
      localObject = (a)localObject;
      break;
      Log.e(this.TAG, "onfinish but id not found:".concat(String.valueOf(paramString)));
    }
    label207:
    AppMethodBeat.o(220796);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(220778);
    p.k(paramString2, "svrFlag");
    AppMethodBeat.o(220778);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(220800);
    Log.d(this.TAG, "FVPlayer getCdnAuthInfo mediaId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(220800);
  }
  
  public final void a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(220767);
    Log.d(this.TAG, "FVPlayer retryStartTask mediaId:" + paramString2 + " url:" + paramString1);
    a locala = aHl(paramString2);
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.BCR);; paramString2 = null)
    {
      if (paramString2 == null) {
        p.iCn();
      }
      if (!paramString2.booleanValue()) {
        break;
      }
      paramString2 = this.TAG;
      paramLong = new StringBuilder("is already downloading, isPlayMode:false, curMode:");
      paramString1 = localObject2;
      if (locala != null) {
        paramString1 = Boolean.valueOf(locala.BCS);
      }
      Log.d(paramString2, paramString1.booleanValue());
      AppMethodBeat.o(220767);
      return;
    }
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.BCT); paramString2.booleanValue(); paramString2 = null)
    {
      if ((paramLong != null) && (paramLong.longValue() != 0L))
      {
        paramString2 = localObject1;
        if (locala != null) {
          paramString2 = Long.valueOf(locala.BCQ);
        }
        if (paramString2.longValue() < paramLong.longValue()) {
          break;
        }
      }
      Log.d(this.TAG, "preload already done");
      AppMethodBeat.o(220767);
      return;
    }
    b(paramString1, paramLong);
    AppMethodBeat.o(220767);
  }
  
  public final int aHk(String paramString)
  {
    AppMethodBeat.i(220772);
    Log.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + paramString + ' ');
    int i = e.BDo.eqd().BDm.aHm(paramString);
    a locala = (a)((Map)this.BCO).get(paramString);
    if (locala != null) {
      locala.BCR = false;
    }
    if (n.L(this.BCN, paramString, true)) {
      this.BCN = null;
    }
    AppMethodBeat.o(220772);
    return i;
  }
  
  public final a aHl(String paramString)
  {
    AppMethodBeat.i(220776);
    if (((Map)this.BCO).get(paramString) == null)
    {
      paramString = new a();
      AppMethodBeat.o(220776);
      return paramString;
    }
    paramString = ((Map)this.BCO).get(paramString);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
      AppMethodBeat.o(220776);
      throw paramString;
    }
    paramString = (a)paramString;
    AppMethodBeat.o(220776);
    return paramString;
  }
  
  public final void b(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(220789);
    if ((paramString != null) && (paramd != null))
    {
      if (this.BCO.get(paramString) == null)
      {
        Log.e(this.TAG, "preload completed, but task not found, mediaId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(220789);
        return;
      }
      Object localObject = this.BCO.get(paramString);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(220789);
        throw paramString;
      }
      localObject = (a)localObject;
      Log.d(this.TAG, "cdntask end preload id:" + paramString + ", isplaymode:" + ((a)localObject).BCS);
      ((a)localObject).rKZ = paramd.field_fileLength;
      ((a)localObject).BCQ = paramd.field_recvedBytes;
      ((a)localObject).BCT = true;
      ((a)localObject).BCR = false;
      ((Map)this.BCO).put(paramString, localObject);
      Log.i(this.TAG, "preload completed mediaId:".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(220789);
  }
  
  public final void b(String paramString, Long paramLong)
  {
    AppMethodBeat.i(220716);
    this.BCP = paramString;
    if (this.BCP == null)
    {
      Log.d(this.TAG, "FVPlayer preLoadTask empty preload task");
      AppMethodBeat.o(220716);
      return;
    }
    paramString = this.BCP;
    Object localObject;
    String str;
    if (paramString != null)
    {
      localObject = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(220716);
        throw paramString;
      }
      paramString = paramString.getBytes((Charset)localObject);
      p.j(paramString, "(this as java.lang.String).getBytes(charset)");
      localObject = g.getMessageDigest(paramString);
      paramString = new StringBuilder().append(this.BCM).append('-');
      str = this.BCP;
      if (str == null) {
        break label215;
      }
    }
    label215:
    for (int i = str.hashCode();; i = 0)
    {
      str = new q(i + ".mp4").bOF();
      p.j(str, "VFSFile(\"${root}-${preLo…ode()}.mp4\").absolutePath");
      if (!n.L((String)localObject, this.BCN, true)) {
        break label220;
      }
      Log.d(this.TAG, "FVPlayer preLoadTask can not preload playing task lastPlayMediaId:" + this.BCN);
      AppMethodBeat.o(220716);
      return;
      paramString = null;
      break;
    }
    label220:
    Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " url:" + this.BCP + " path:" + str);
    if (this.BCO.get(localObject) == null)
    {
      paramString = new a();
      if ((paramString.BCT) && (paramLong != null) && (paramLong.longValue() != 0L) && (paramString.sXm < paramLong.longValue())) {
        paramString.BCT = false;
      }
      if ((paramString.baT) || (paramString.BCT) || (paramString.BCR)) {
        break label662;
      }
      h localh = new h();
      localh.taskName = "task_FlutterCdnDownloadMgr_1";
      localh.field_mediaId = ((String)localObject);
      localh.url = this.BCP;
      localh.iUK = 60;
      localh.iUL = 60;
      localh.iUW = 2;
      localh.iVd = 2;
      localh.iUX = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str;
      localh.concurrentCount = 8;
      localh.connectionCount = 1;
      localh.iVn = ((h.a)this);
      localh.iUG = ((g.a)this);
      localh.iUY = ((g.b)this);
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        localh.preloadMinSize = paramLong.longValue();
      }
      if (CdnLogic.taskExist((String)localObject)) {
        break label628;
      }
      e.BDo.eqd().BDm.g(localh);
      paramString.BCR = true;
      paramString.BCS = false;
      Log.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + (String)localObject + " .");
    }
    for (;;)
    {
      paramString.setPath(str);
      paramLong = (Map)this.BCO;
      p.j(localObject, "mediaId");
      paramLong.put(localObject, paramString);
      AppMethodBeat.o(220716);
      return;
      paramString = this.BCO.get(localObject);
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(220716);
        throw paramString;
      }
      paramString = (a)paramString;
      break;
      label628:
      Log.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + (String)localObject + " .");
      continue;
      label662:
      Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " has downloaded or isDoing:" + paramString.baT + ", " + paramString.BCT + ", " + paramString.BCR + '.');
    }
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220805);
    Log.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + paramString + ' ');
    AppMethodBeat.o(220805);
    return new byte[0];
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220784);
    Log.d(this.TAG, "onProgress mediaId:" + paramString + ", finish:" + paramLong1 + ", length:" + paramLong2);
    if (paramString != null) {
      if (this.BCO.get(paramString) != null) {
        break label141;
      }
    }
    for (Object localObject = new a();; localObject = (a)localObject)
    {
      ((a)localObject).sXm = paramLong1;
      ((a)localObject).rKZ = paramLong2;
      ((Map)this.BCO).put(paramString, localObject);
      if (paramLong1 == paramLong2)
      {
        Log.i(this.TAG, "onprogress cdntask end id:".concat(String.valueOf(paramString)));
        ((a)localObject).baT = true;
      }
      AppMethodBeat.o(220784);
      return;
      label141:
      localObject = this.BCO.get(paramString);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(220784);
        throw paramString;
      }
    }
  }
  
  public final void hC(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(220760);
    Log.d(this.TAG, "FVPlayer startTask mediaId:" + paramString2 + " url:" + paramString1);
    boolean bool;
    if (!CdnLogic.taskExist(paramString2))
    {
      if (((Map)this.BCO).get(paramString2) != null) {
        break label163;
      }
      bool = true;
      paramString2 = (a)((Map)this.BCO).get(paramString2);
      if (paramString2 == null) {
        break label169;
      }
    }
    label163:
    label169:
    for (paramString2 = Boolean.valueOf(paramString2.baT);; paramString2 = null)
    {
      Log.e(this.TAG, "testtest task not in preload, in info cache:" + bool + ", completed:" + paramString2);
      if (paramString1 == null) {
        break label328;
      }
      paramString2 = kotlin.n.d.UTF_8;
      if (paramString1 != null) {
        break label174;
      }
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(220760);
      throw paramString1;
      bool = false;
      break;
    }
    label174:
    paramString2 = paramString1.getBytes(paramString2);
    p.j(paramString2, "(this as java.lang.String).getBytes(charset)");
    String str1 = g.getMessageDigest(paramString2);
    paramString2 = new StringBuilder().append(this.BCM).append('-');
    int i;
    label222:
    String str2;
    if (paramString1 != null)
    {
      i = paramString1.hashCode();
      str2 = new q(i + ".mp4").bOF();
      p.j(str2, "VFSFile(\"${root}-${url.h…ode()}.mp4\").absolutePath");
      if (this.BCO.get(str1) != null) {
        break label338;
      }
    }
    for (paramString2 = new a();; paramString2 = (a)paramString2)
    {
      if ((!n.L(this.BCN, str1, false)) || (!paramString2.BCR) || (!paramString2.BCS)) {
        break label378;
      }
      Log.i(this.TAG, "playmode is downloading:".concat(String.valueOf(str1)));
      AppMethodBeat.o(220760);
      return;
      label328:
      paramString2 = null;
      break;
      i = 0;
      break label222;
      label338:
      paramString2 = this.BCO.get(str1);
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(220760);
        throw paramString1;
      }
    }
    label378:
    if (!paramString2.baT)
    {
      h localh = new h();
      localh.taskName = "task_FlutterCdnDownloadMgr_2";
      localh.field_mediaId = str1;
      localh.url = paramString1;
      localh.iUK = 60;
      localh.iUL = 60;
      localh.iUW = 1;
      localh.iVd = 1;
      localh.iUX = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.iVn = ((h.a)this);
      if ((this.BCN != null) && (!n.L(this.BCN, str1, false)) && (CdnLogic.taskExist(this.BCN)))
      {
        i = e.BDo.eqd().BDm.aHm(this.BCN);
        if (paramString2 != null) {
          paramString2.BCR = false;
        }
        Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.BCN + ' ' + i);
      }
      if (CdnLogic.taskExist(str1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = Boolean.valueOf(paramString2.BCS);
        }
        if (!paramString1.booleanValue())
        {
          i = e.BDo.eqd().BDm.aHm(str1);
          if (paramString2 != null) {
            paramString2.BCR = false;
          }
          Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.BCN + " mediaId:" + str1 + ' ' + i);
        }
      }
      i = e.BDo.eqd().BDm.g(localh);
      if (paramString2 != null) {
        paramString2.BCR = true;
      }
      if (paramString2 != null) {
        paramString2.BCS = true;
      }
      Log.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + str1 + ' ' + i + " playmode:true path: " + str2);
    }
    for (;;)
    {
      this.BCN = str1;
      paramString2.setPath(str2);
      paramString1 = (Map)this.BCO;
      p.j(str1, "mediaId");
      paramString1.put(str1, paramString2);
      AppMethodBeat.o(220760);
      return;
      Log.d(this.TAG, "FVPlayer startTask mediaId:" + str1 + " has downloaded.");
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220780);
    Log.d(this.TAG, "onDataAvailable mediaId:" + paramString + ", offset:" + paramLong1 + ", length:" + paramLong2);
    AppMethodBeat.o(220780);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"})
  public static final class a
  {
    long BCQ;
    boolean BCR;
    boolean BCS;
    boolean BCT;
    boolean baT;
    String path = "";
    long rKZ;
    long sXm;
    
    public final void setPath(String paramString)
    {
      AppMethodBeat.i(221102);
      p.k(paramString, "<set-?>");
      this.path = paramString;
      AppMethodBeat.o(221102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.b
 * JD-Core Version:    0.7.0.1
 */