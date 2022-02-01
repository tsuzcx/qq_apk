package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"})
public final class b
  implements g.a, g.b, h.a
{
  private final String TAG;
  private String wKP;
  private String wKQ;
  private HashMap<String, a> wKR;
  private String wKS;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(241132);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    this.wKR = new HashMap();
    this.wKP = (paramContext.getCacheDir() + "/flutter/FTVideo/");
    AppMethodBeat.o(241132);
  }
  
  public final void Ds(String paramString)
  {
    AppMethodBeat.i(241123);
    p.h(paramString, "mediaId");
    AppMethodBeat.o(241123);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(241129);
    Log.d(this.TAG, "FVPlayer callback mediaId:" + paramString + ' ');
    AppMethodBeat.o(241129);
    return 0;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(241128);
    Object localObject;
    if ((paramString != null) && (paramd != null)) {
      if (this.wKR.get(paramString) == null)
      {
        localObject = new a();
        Log.d(this.TAG, "cdntask end id:" + paramString + ", isplaymode:" + ((a)localObject).wKV);
        ((a)localObject).cacheSize = paramd.field_fileLength;
        ((a)localObject).oJj = paramd.field_fileLength;
        ((a)localObject).brr = true;
        ((Map)this.wKR).put(paramString, localObject);
        this.wKQ = null;
      }
    }
    for (;;)
    {
      paramString = (a)((Map)this.wKR).get(paramString);
      if (paramString == null) {
        break label207;
      }
      paramString.wKU = false;
      AppMethodBeat.o(241128);
      return;
      localObject = this.wKR.get(paramString);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(241128);
        throw paramString;
      }
      localObject = (a)localObject;
      break;
      Log.e(this.TAG, "onfinish but id not found:".concat(String.valueOf(paramString)));
    }
    label207:
    AppMethodBeat.o(241128);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(241124);
    p.h(paramString2, "svrFlag");
    AppMethodBeat.o(241124);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(241130);
    Log.d(this.TAG, "FVPlayer getCdnAuthInfo mediaId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(241130);
  }
  
  public final void a(String paramString, Long paramLong)
  {
    AppMethodBeat.i(241118);
    this.wKS = paramString;
    if (this.wKS == null)
    {
      Log.d(this.TAG, "FVPlayer preLoadTask empty preload task");
      AppMethodBeat.o(241118);
      return;
    }
    paramString = this.wKS;
    Object localObject;
    String str;
    if (paramString != null)
    {
      localObject = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(241118);
        throw paramString;
      }
      paramString = paramString.getBytes((Charset)localObject);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
      localObject = g.getMessageDigest(paramString);
      paramString = new StringBuilder().append(this.wKP).append('-');
      str = this.wKS;
      if (str == null) {
        break label210;
      }
    }
    label210:
    for (int i = str.hashCode();; i = 0)
    {
      str = new o(i + ".mp4").getAbsolutePath();
      p.g(str, "VFSFile(\"${root}-${preLo…ode()}.mp4\").absolutePath");
      if (!n.I((String)localObject, this.wKQ, true)) {
        break label215;
      }
      Log.d(this.TAG, "FVPlayer preLoadTask can not preload playing task lastPlayMediaId:" + this.wKQ);
      AppMethodBeat.o(241118);
      return;
      paramString = null;
      break;
    }
    label215:
    Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " url:" + this.wKS + " path:" + str);
    if (this.wKR.get(localObject) == null)
    {
      paramString = new a();
      if ((paramString.wKW) && (paramLong != null) && (paramLong.longValue() != 0L) && (paramString.cacheSize < paramLong.longValue())) {
        paramString.wKW = false;
      }
      if ((paramString.brr) || (paramString.wKW) || (paramString.wKU)) {
        break label656;
      }
      h localh = new h();
      localh.taskName = "task_FlutterCdnDownloadMgr_1";
      localh.field_mediaId = ((String)localObject);
      localh.url = this.wKS;
      localh.gqC = 60;
      localh.gqD = 60;
      localh.gqO = 2;
      localh.gqU = 2;
      localh.gqP = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str;
      localh.concurrentCount = 8;
      localh.connectionCount = 1;
      localh.gre = ((h.a)this);
      localh.gqy = ((g.a)this);
      localh.gqQ = ((g.b)this);
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        localh.preloadMinSize = paramLong.longValue();
      }
      if (CdnLogic.taskExist((String)localObject)) {
        break label622;
      }
      e.wLs.dMk().wLq.g(localh);
      paramString.wKU = true;
      paramString.wKV = false;
      Log.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + (String)localObject + " .");
    }
    for (;;)
    {
      paramString.setPath(str);
      paramLong = (Map)this.wKR;
      p.g(localObject, "mediaId");
      paramLong.put(localObject, paramString);
      AppMethodBeat.o(241118);
      return;
      paramString = this.wKR.get(localObject);
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(241118);
        throw paramString;
      }
      paramString = (a)paramString;
      break;
      label622:
      Log.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + (String)localObject + " .");
      continue;
      label656:
      Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " has downloaded or isDoing:" + paramString.brr + ", " + paramString.wKW + ", " + paramString.wKU + '.');
    }
  }
  
  public final void a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(241120);
    Log.d(this.TAG, "FVPlayer retryStartTask mediaId:" + paramString2 + " url:" + paramString1);
    a locala = axy(paramString2);
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.wKU);; paramString2 = null)
    {
      if (paramString2 == null) {
        p.hyc();
      }
      if (!paramString2.booleanValue()) {
        break;
      }
      paramString2 = this.TAG;
      paramLong = new StringBuilder("is already downloading, isPlayMode:false, curMode:");
      paramString1 = localObject2;
      if (locala != null) {
        paramString1 = Boolean.valueOf(locala.wKV);
      }
      Log.d(paramString2, paramString1.booleanValue());
      AppMethodBeat.o(241120);
      return;
    }
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.wKW); paramString2.booleanValue(); paramString2 = null)
    {
      if ((paramLong != null) && (paramLong.longValue() != 0L))
      {
        paramString2 = localObject1;
        if (locala != null) {
          paramString2 = Long.valueOf(locala.wKT);
        }
        if (paramString2.longValue() < paramLong.longValue()) {
          break;
        }
      }
      Log.d(this.TAG, "preload already done");
      AppMethodBeat.o(241120);
      return;
    }
    a(paramString1, paramLong);
    AppMethodBeat.o(241120);
  }
  
  public final int axx(String paramString)
  {
    AppMethodBeat.i(241121);
    Log.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + paramString + ' ');
    int i = e.wLs.dMk().wLq.axz(paramString);
    a locala = (a)((Map)this.wKR).get(paramString);
    if (locala != null) {
      locala.wKU = false;
    }
    if (n.I(this.wKQ, paramString, true)) {
      this.wKQ = null;
    }
    AppMethodBeat.o(241121);
    return i;
  }
  
  public final a axy(String paramString)
  {
    AppMethodBeat.i(241122);
    if (((Map)this.wKR).get(paramString) == null)
    {
      paramString = new a();
      AppMethodBeat.o(241122);
      return paramString;
    }
    paramString = ((Map)this.wKR).get(paramString);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
      AppMethodBeat.o(241122);
      throw paramString;
    }
    paramString = (a)paramString;
    AppMethodBeat.o(241122);
    return paramString;
  }
  
  public final void b(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(241127);
    if ((paramString != null) && (paramd != null))
    {
      if (this.wKR.get(paramString) == null)
      {
        Log.e(this.TAG, "preload completed, but task not found, mediaId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(241127);
        return;
      }
      Object localObject = this.wKR.get(paramString);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(241127);
        throw paramString;
      }
      localObject = (a)localObject;
      Log.d(this.TAG, "cdntask end preload id:" + paramString + ", isplaymode:" + ((a)localObject).wKV);
      ((a)localObject).oJj = paramd.field_fileLength;
      ((a)localObject).wKT = paramd.field_recvedBytes;
      ((a)localObject).wKW = true;
      ((a)localObject).wKU = false;
      ((Map)this.wKR).put(paramString, localObject);
      Log.i(this.TAG, "preload completed mediaId:".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(241127);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(241131);
    Log.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + paramString + ' ');
    AppMethodBeat.o(241131);
    return new byte[0];
  }
  
  public final void hp(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(241119);
    Log.d(this.TAG, "FVPlayer startTask mediaId:" + paramString2 + " url:" + paramString1);
    boolean bool;
    if (!CdnLogic.taskExist(paramString2))
    {
      if (((Map)this.wKR).get(paramString2) != null) {
        break label164;
      }
      bool = true;
      paramString2 = (a)((Map)this.wKR).get(paramString2);
      if (paramString2 == null) {
        break label170;
      }
    }
    label164:
    label170:
    for (paramString2 = Boolean.valueOf(paramString2.brr);; paramString2 = null)
    {
      Log.e(this.TAG, "testtest task not in preload, in info cache:" + bool + ", completed:" + paramString2);
      if (paramString1 == null) {
        break label329;
      }
      paramString2 = kotlin.n.d.UTF_8;
      if (paramString1 != null) {
        break label175;
      }
      paramString1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(241119);
      throw paramString1;
      bool = false;
      break;
    }
    label175:
    paramString2 = paramString1.getBytes(paramString2);
    p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
    String str1 = g.getMessageDigest(paramString2);
    paramString2 = new StringBuilder().append(this.wKP).append('-');
    int i;
    label223:
    String str2;
    if (paramString1 != null)
    {
      i = paramString1.hashCode();
      str2 = new o(i + ".mp4").getAbsolutePath();
      p.g(str2, "VFSFile(\"${root}-${url.h…ode()}.mp4\").absolutePath");
      if (this.wKR.get(str1) != null) {
        break label339;
      }
    }
    for (paramString2 = new a();; paramString2 = (a)paramString2)
    {
      if ((!n.I(this.wKQ, str1, false)) || (!paramString2.wKU) || (!paramString2.wKV)) {
        break label379;
      }
      Log.i(this.TAG, "playmode is downloading:".concat(String.valueOf(str1)));
      AppMethodBeat.o(241119);
      return;
      label329:
      paramString2 = null;
      break;
      i = 0;
      break label223;
      label339:
      paramString2 = this.wKR.get(str1);
      if (paramString2 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(241119);
        throw paramString1;
      }
    }
    label379:
    if (!paramString2.brr)
    {
      h localh = new h();
      localh.taskName = "task_FlutterCdnDownloadMgr_2";
      localh.field_mediaId = str1;
      localh.url = paramString1;
      localh.gqC = 60;
      localh.gqD = 60;
      localh.gqO = 1;
      localh.gqU = 1;
      localh.gqP = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.gre = ((h.a)this);
      if ((this.wKQ != null) && (!n.I(this.wKQ, str1, false)) && (CdnLogic.taskExist(this.wKQ)))
      {
        i = e.wLs.dMk().wLq.axz(this.wKQ);
        if (paramString2 != null) {
          paramString2.wKU = false;
        }
        Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.wKQ + ' ' + i);
      }
      if (CdnLogic.taskExist(str1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = Boolean.valueOf(paramString2.wKV);
        }
        if (!paramString1.booleanValue())
        {
          i = e.wLs.dMk().wLq.axz(str1);
          if (paramString2 != null) {
            paramString2.wKU = false;
          }
          Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.wKQ + " mediaId:" + str1 + ' ' + i);
        }
      }
      i = e.wLs.dMk().wLq.g(localh);
      if (paramString2 != null) {
        paramString2.wKU = true;
      }
      if (paramString2 != null) {
        paramString2.wKV = true;
      }
      Log.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + str1 + ' ' + i + " playmode:true path: " + str2);
    }
    for (;;)
    {
      this.wKQ = str1;
      paramString2.setPath(str2);
      paramString1 = (Map)this.wKR;
      p.g(str1, "mediaId");
      paramString1.put(str1, paramString2);
      AppMethodBeat.o(241119);
      return;
      Log.d(this.TAG, "FVPlayer startTask mediaId:" + str1 + " has downloaded.");
    }
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241126);
    Log.d(this.TAG, "onProgress mediaId:" + paramString + ", finish:" + paramLong1 + ", length:" + paramLong2);
    if (paramString != null) {
      if (this.wKR.get(paramString) != null) {
        break label141;
      }
    }
    for (Object localObject = new a();; localObject = (a)localObject)
    {
      ((a)localObject).cacheSize = paramLong1;
      ((a)localObject).oJj = paramLong2;
      ((Map)this.wKR).put(paramString, localObject);
      if (paramLong1 == paramLong2)
      {
        Log.i(this.TAG, "onprogress cdntask end id:".concat(String.valueOf(paramString)));
        ((a)localObject).brr = true;
      }
      AppMethodBeat.o(241126);
      return;
      label141:
      localObject = this.wKR.get(paramString);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(241126);
        throw paramString;
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241125);
    Log.d(this.TAG, "onDataAvailable mediaId:" + paramString + ", offset:" + paramLong1 + ", length:" + paramLong2);
    AppMethodBeat.o(241125);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"})
  public static final class a
  {
    boolean brr;
    long cacheSize;
    long oJj;
    String path = "";
    long wKT;
    boolean wKU;
    boolean wKV;
    boolean wKW;
    
    public final void setPath(String paramString)
    {
      AppMethodBeat.i(241117);
      p.h(paramString, "<set-?>");
      this.path = paramString;
      AppMethodBeat.o(241117);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.f.b
 * JD-Core Version:    0.7.0.1
 */