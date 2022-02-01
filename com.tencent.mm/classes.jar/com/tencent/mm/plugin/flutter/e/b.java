package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"})
public final class b
  implements g.a, g.b, h.a
{
  private final String TAG;
  private String tiJ;
  private String tiK;
  private HashMap<String, a> tiL;
  private String tiM;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(219145);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    this.tiL = new HashMap();
    this.tiJ = (paramContext.getCacheDir() + "/flutter/FTVideo/");
    AppMethodBeat.o(219145);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(219142);
    ad.d(this.TAG, "FVPlayer callback mediaId:" + paramString + ' ');
    AppMethodBeat.o(219142);
    return 0;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(219141);
    Object localObject;
    if ((paramString != null) && (paramd != null)) {
      if (this.tiL.get(paramString) == null)
      {
        localObject = new a();
        ad.d(this.TAG, "cdntask end id:" + paramString + ", isplaymode:" + ((a)localObject).tiP);
        ((a)localObject).cacheSize = paramd.field_fileLength;
        ((a)localObject).nsQ = paramd.field_fileLength;
        ((a)localObject).brw = true;
        ((Map)this.tiL).put(paramString, localObject);
        this.tiK = null;
      }
    }
    for (;;)
    {
      paramString = (a)((Map)this.tiL).get(paramString);
      if (paramString == null) {
        break label207;
      }
      paramString.tiO = false;
      AppMethodBeat.o(219141);
      return;
      localObject = this.tiL.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(219141);
        throw paramString;
      }
      localObject = (a)localObject;
      break;
      ad.e(this.TAG, "onfinish but id not found:".concat(String.valueOf(paramString)));
    }
    label207:
    AppMethodBeat.o(219141);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(219137);
    p.h(paramString2, "svrFlag");
    AppMethodBeat.o(219137);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(219143);
    ad.d(this.TAG, "FVPlayer getCdnAuthInfo mediaId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(219143);
  }
  
  public final void a(String paramString, Long paramLong)
  {
    AppMethodBeat.i(219132);
    this.tiM = paramString;
    if (this.tiM == null)
    {
      ad.d(this.TAG, "FVPlayer preLoadTask empty preload task");
      AppMethodBeat.o(219132);
      return;
    }
    paramString = this.tiM;
    Object localObject;
    String str;
    if (paramString != null)
    {
      localObject = d.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(219132);
        throw paramString;
      }
      paramString = paramString.getBytes((Charset)localObject);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
      localObject = g.getMessageDigest(paramString);
      paramString = new StringBuilder().append(this.tiJ).append('-');
      str = this.tiM;
      if (str == null) {
        break label201;
      }
    }
    label201:
    for (int i = str.hashCode();; i = 0)
    {
      str = new com.tencent.mm.vfs.e(i + ".mp4").getAbsolutePath();
      if (!n.H((String)localObject, this.tiK, true)) {
        break label206;
      }
      ad.d(this.TAG, "FVPlayer preLoadTask can not preload playing task lastPlayMediaId:" + this.tiK);
      AppMethodBeat.o(219132);
      return;
      paramString = null;
      break;
    }
    label206:
    ad.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " url:" + this.tiM + " path:" + str);
    if (this.tiL.get(localObject) == null)
    {
      paramString = new a();
      if ((paramString.tiQ) && (paramLong != null) && (paramLong.longValue() != 0L) && (paramString.cacheSize < paramLong.longValue())) {
        paramString.tiQ = false;
      }
      if ((paramString.brw) || (paramString.tiQ) || (paramString.tiO)) {
        break label656;
      }
      h localh = new h();
      localh.fJi = "task_FlutterCdnDownloadMgr_1";
      localh.field_mediaId = ((String)localObject);
      localh.url = this.tiM;
      localh.fJn = 60;
      localh.fJo = 60;
      localh.fJz = 2;
      localh.fJF = 2;
      localh.fJA = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str;
      localh.concurrentCount = 8;
      localh.connectionCount = 1;
      localh.fJN = ((h.a)this);
      localh.fJj = ((g.a)this);
      localh.fJB = ((g.b)this);
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        localh.preloadMinSize = paramLong.longValue();
      }
      if (CdnLogic.taskExist((String)localObject)) {
        break label622;
      }
      e.tjm.cQu().tjk.c(localh);
      paramString.tiO = true;
      paramString.tiP = false;
      ad.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + (String)localObject + " .");
    }
    for (;;)
    {
      p.g(str, "filePath");
      paramString.setPath(str);
      paramLong = (Map)this.tiL;
      p.g(localObject, "mediaId");
      paramLong.put(localObject, paramString);
      AppMethodBeat.o(219132);
      return;
      paramString = this.tiL.get(localObject);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(219132);
        throw paramString;
      }
      paramString = (a)paramString;
      break;
      label622:
      ad.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + (String)localObject + " .");
      continue;
      label656:
      ad.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " has downloaded or isDoing:" + paramString.brw + ", " + paramString.tiQ + ", " + paramString.tiO + '.');
    }
  }
  
  public final void a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(219134);
    ad.d(this.TAG, "FVPlayer retryStartTask mediaId:" + paramString2 + " url:" + paramString1);
    a locala = ajv(paramString2);
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.tiO);; paramString2 = null)
    {
      if (paramString2 == null) {
        p.gfZ();
      }
      if (!paramString2.booleanValue()) {
        break;
      }
      paramString2 = this.TAG;
      paramLong = new StringBuilder("is already downloading, isPlayMode:false, curMode:");
      paramString1 = localObject2;
      if (locala != null) {
        paramString1 = Boolean.valueOf(locala.tiP);
      }
      ad.d(paramString2, paramString1.booleanValue());
      AppMethodBeat.o(219134);
      return;
    }
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.tiQ); paramString2.booleanValue(); paramString2 = null)
    {
      if ((paramLong != null) && (paramLong.longValue() != 0L))
      {
        paramString2 = localObject1;
        if (locala != null) {
          paramString2 = Long.valueOf(locala.tiN);
        }
        if (paramString2.longValue() < paramLong.longValue()) {
          break;
        }
      }
      ad.d(this.TAG, "preload already done");
      AppMethodBeat.o(219134);
      return;
    }
    a(paramString1, paramLong);
    AppMethodBeat.o(219134);
  }
  
  public final int aju(String paramString)
  {
    AppMethodBeat.i(219135);
    ad.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + paramString + ' ');
    int i = e.tjm.cQu().tjk.ajw(paramString);
    a locala = (a)((Map)this.tiL).get(paramString);
    if (locala != null) {
      locala.tiO = false;
    }
    if (n.H(this.tiK, paramString, true)) {
      this.tiK = null;
    }
    AppMethodBeat.o(219135);
    return i;
  }
  
  public final a ajv(String paramString)
  {
    AppMethodBeat.i(219136);
    if (((Map)this.tiL).get(paramString) == null)
    {
      paramString = new a();
      AppMethodBeat.o(219136);
      return paramString;
    }
    paramString = ((Map)this.tiL).get(paramString);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
      AppMethodBeat.o(219136);
      throw paramString;
    }
    paramString = (a)paramString;
    AppMethodBeat.o(219136);
    return paramString;
  }
  
  public final void b(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(219140);
    if ((paramString != null) && (paramd != null))
    {
      if (this.tiL.get(paramString) == null)
      {
        ad.e(this.TAG, "preload completed, but task not found, mediaId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(219140);
        return;
      }
      Object localObject = this.tiL.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(219140);
        throw paramString;
      }
      localObject = (a)localObject;
      ad.d(this.TAG, "cdntask end preload id:" + paramString + ", isplaymode:" + ((a)localObject).tiP);
      ((a)localObject).nsQ = paramd.field_fileLength;
      ((a)localObject).tiN = paramd.field_recvedBytes;
      ((a)localObject).tiQ = true;
      ((a)localObject).tiO = false;
      ((Map)this.tiL).put(paramString, localObject);
      ad.i(this.TAG, "preload completed mediaId:".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(219140);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219144);
    ad.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + paramString + ' ');
    AppMethodBeat.o(219144);
    return new byte[0];
  }
  
  public final void gE(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(219133);
    ad.d(this.TAG, "FVPlayer startTask mediaId:" + paramString2 + " url:" + paramString1);
    boolean bool;
    if (!CdnLogic.taskExist(paramString2))
    {
      if (((Map)this.tiL).get(paramString2) != null) {
        break label163;
      }
      bool = true;
      paramString2 = (a)((Map)this.tiL).get(paramString2);
      if (paramString2 == null) {
        break label169;
      }
    }
    label163:
    label169:
    for (paramString2 = Boolean.valueOf(paramString2.brw);; paramString2 = null)
    {
      ad.e(this.TAG, "testtest task not in preload, in info cache:" + bool + ", completed:" + paramString2);
      if (paramString1 == null) {
        break label320;
      }
      paramString2 = d.n.d.UTF_8;
      if (paramString1 != null) {
        break label174;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(219133);
      throw paramString1;
      bool = false;
      break;
    }
    label174:
    paramString2 = paramString1.getBytes(paramString2);
    p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
    String str1 = g.getMessageDigest(paramString2);
    paramString2 = new StringBuilder().append(this.tiJ).append('-');
    int i;
    label222:
    String str2;
    if (paramString1 != null)
    {
      i = paramString1.hashCode();
      str2 = new com.tencent.mm.vfs.e(i + ".mp4").getAbsolutePath();
      if (this.tiL.get(str1) != null) {
        break label330;
      }
    }
    for (paramString2 = new a();; paramString2 = (a)paramString2)
    {
      if ((!n.H(this.tiK, str1, false)) || (!paramString2.tiO) || (!paramString2.tiP)) {
        break label370;
      }
      ad.i(this.TAG, "playmode is downloading:".concat(String.valueOf(str1)));
      AppMethodBeat.o(219133);
      return;
      label320:
      paramString2 = null;
      break;
      i = 0;
      break label222;
      label330:
      paramString2 = this.tiL.get(str1);
      if (paramString2 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(219133);
        throw paramString1;
      }
    }
    label370:
    if (!paramString2.brw)
    {
      h localh = new h();
      localh.fJi = "task_FlutterCdnDownloadMgr_2";
      localh.field_mediaId = str1;
      localh.url = paramString1;
      localh.fJn = 60;
      localh.fJo = 60;
      localh.fJz = 1;
      localh.fJF = 1;
      localh.fJA = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.fJN = ((h.a)this);
      if ((this.tiK != null) && (!n.H(this.tiK, str1, false)) && (CdnLogic.taskExist(this.tiK)))
      {
        i = e.tjm.cQu().tjk.ajw(this.tiK);
        if (paramString2 != null) {
          paramString2.tiO = false;
        }
        ad.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.tiK + ' ' + i);
      }
      if (CdnLogic.taskExist(str1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = Boolean.valueOf(paramString2.tiP);
        }
        if (!paramString1.booleanValue())
        {
          i = e.tjm.cQu().tjk.ajw(str1);
          if (paramString2 != null) {
            paramString2.tiO = false;
          }
          ad.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.tiK + " mediaId:" + str1 + ' ' + i);
        }
      }
      i = e.tjm.cQu().tjk.c(localh);
      if (paramString2 != null) {
        paramString2.tiO = true;
      }
      if (paramString2 != null) {
        paramString2.tiP = true;
      }
      ad.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + str1 + ' ' + i + " playmode:true path: " + str2);
    }
    for (;;)
    {
      this.tiK = str1;
      p.g(str2, "filePath");
      paramString2.setPath(str2);
      paramString1 = (Map)this.tiL;
      p.g(str1, "mediaId");
      paramString1.put(str1, paramString2);
      AppMethodBeat.o(219133);
      return;
      ad.d(this.TAG, "FVPlayer startTask mediaId:" + str1 + " has downloaded.");
    }
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219139);
    ad.d(this.TAG, "onProgress mediaId:" + paramString + ", finish:" + paramLong1 + ", length:" + paramLong2);
    if (paramString != null) {
      if (this.tiL.get(paramString) != null) {
        break label141;
      }
    }
    for (Object localObject = new a();; localObject = (a)localObject)
    {
      ((a)localObject).cacheSize = paramLong1;
      ((a)localObject).nsQ = paramLong2;
      ((Map)this.tiL).put(paramString, localObject);
      if (paramLong1 == paramLong2)
      {
        ad.i(this.TAG, "onprogress cdntask end id:".concat(String.valueOf(paramString)));
        ((a)localObject).brw = true;
      }
      AppMethodBeat.o(219139);
      return;
      label141:
      localObject = this.tiL.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(219139);
        throw paramString;
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219138);
    ad.d(this.TAG, "onDataAvailable mediaId:" + paramString + ", offset:" + paramLong1 + ", length:" + paramLong2);
    AppMethodBeat.o(219138);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"})
  public static final class a
  {
    boolean brw;
    long cacheSize;
    long nsQ;
    String path = "";
    long tiN;
    boolean tiO;
    boolean tiP;
    boolean tiQ;
    
    public final void setPath(String paramString)
    {
      AppMethodBeat.i(219131);
      p.h(paramString, "<set-?>");
      this.path = paramString;
      AppMethodBeat.o(219131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.b
 * JD-Core Version:    0.7.0.1
 */