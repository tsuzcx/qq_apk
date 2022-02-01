package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"})
public final class b
  implements g.a, g.b, h.a
{
  private final String TAG;
  private String ttB;
  private String ttC;
  private HashMap<String, a> ttD;
  private String ttE;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(213474);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    this.ttD = new HashMap();
    this.ttB = (paramContext.getCacheDir() + "/flutter/FTVideo/");
    AppMethodBeat.o(213474);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(213471);
    ae.d(this.TAG, "FVPlayer callback mediaId:" + paramString + ' ');
    AppMethodBeat.o(213471);
    return 0;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(213470);
    Object localObject;
    if ((paramString != null) && (paramd != null)) {
      if (this.ttD.get(paramString) == null)
      {
        localObject = new a();
        ae.d(this.TAG, "cdntask end id:" + paramString + ", isplaymode:" + ((a)localObject).ttH);
        ((a)localObject).cacheSize = paramd.field_fileLength;
        ((a)localObject).nyl = paramd.field_fileLength;
        ((a)localObject).brw = true;
        ((Map)this.ttD).put(paramString, localObject);
        this.ttC = null;
      }
    }
    for (;;)
    {
      paramString = (a)((Map)this.ttD).get(paramString);
      if (paramString == null) {
        break label207;
      }
      paramString.ttG = false;
      AppMethodBeat.o(213470);
      return;
      localObject = this.ttD.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(213470);
        throw paramString;
      }
      localObject = (a)localObject;
      break;
      ae.e(this.TAG, "onfinish but id not found:".concat(String.valueOf(paramString)));
    }
    label207:
    AppMethodBeat.o(213470);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(213466);
    p.h(paramString2, "svrFlag");
    AppMethodBeat.o(213466);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(213472);
    ae.d(this.TAG, "FVPlayer getCdnAuthInfo mediaId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(213472);
  }
  
  public final void a(String paramString, Long paramLong)
  {
    AppMethodBeat.i(213461);
    this.ttE = paramString;
    if (this.ttE == null)
    {
      ae.d(this.TAG, "FVPlayer preLoadTask empty preload task");
      AppMethodBeat.o(213461);
      return;
    }
    paramString = this.ttE;
    Object localObject;
    String str;
    if (paramString != null)
    {
      localObject = d.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(213461);
        throw paramString;
      }
      paramString = paramString.getBytes((Charset)localObject);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
      localObject = g.getMessageDigest(paramString);
      paramString = new StringBuilder().append(this.ttB).append('-');
      str = this.ttE;
      if (str == null) {
        break label201;
      }
    }
    label201:
    for (int i = str.hashCode();; i = 0)
    {
      str = new k(i + ".mp4").getAbsolutePath();
      if (!n.H((String)localObject, this.ttC, true)) {
        break label206;
      }
      ae.d(this.TAG, "FVPlayer preLoadTask can not preload playing task lastPlayMediaId:" + this.ttC);
      AppMethodBeat.o(213461);
      return;
      paramString = null;
      break;
    }
    label206:
    ae.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " url:" + this.ttE + " path:" + str);
    if (this.ttD.get(localObject) == null)
    {
      paramString = new a();
      if ((paramString.ttI) && (paramLong != null) && (paramLong.longValue() != 0L) && (paramString.cacheSize < paramLong.longValue())) {
        paramString.ttI = false;
      }
      if ((paramString.brw) || (paramString.ttI) || (paramString.ttG)) {
        break label656;
      }
      h localh = new h();
      localh.fLl = "task_FlutterCdnDownloadMgr_1";
      localh.field_mediaId = ((String)localObject);
      localh.url = this.ttE;
      localh.fLq = 60;
      localh.fLr = 60;
      localh.fLC = 2;
      localh.fLI = 2;
      localh.fLD = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str;
      localh.concurrentCount = 8;
      localh.connectionCount = 1;
      localh.fLQ = ((h.a)this);
      localh.fLm = ((g.a)this);
      localh.fLE = ((g.b)this);
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        localh.preloadMinSize = paramLong.longValue();
      }
      if (CdnLogic.taskExist((String)localObject)) {
        break label622;
      }
      e.tue.cSZ().tuc.c(localh);
      paramString.ttG = true;
      paramString.ttH = false;
      ae.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + (String)localObject + " .");
    }
    for (;;)
    {
      p.g(str, "filePath");
      paramString.setPath(str);
      paramLong = (Map)this.ttD;
      p.g(localObject, "mediaId");
      paramLong.put(localObject, paramString);
      AppMethodBeat.o(213461);
      return;
      paramString = this.ttD.get(localObject);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(213461);
        throw paramString;
      }
      paramString = (a)paramString;
      break;
      label622:
      ae.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + (String)localObject + " .");
      continue;
      label656:
      ae.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " has downloaded or isDoing:" + paramString.brw + ", " + paramString.ttI + ", " + paramString.ttG + '.');
    }
  }
  
  public final void a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(213463);
    ae.d(this.TAG, "FVPlayer retryStartTask mediaId:" + paramString2 + " url:" + paramString1);
    a locala = akt(paramString2);
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.ttG);; paramString2 = null)
    {
      if (paramString2 == null) {
        p.gkB();
      }
      if (!paramString2.booleanValue()) {
        break;
      }
      paramString2 = this.TAG;
      paramLong = new StringBuilder("is already downloading, isPlayMode:false, curMode:");
      paramString1 = localObject2;
      if (locala != null) {
        paramString1 = Boolean.valueOf(locala.ttH);
      }
      ae.d(paramString2, paramString1.booleanValue());
      AppMethodBeat.o(213463);
      return;
    }
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.ttI); paramString2.booleanValue(); paramString2 = null)
    {
      if ((paramLong != null) && (paramLong.longValue() != 0L))
      {
        paramString2 = localObject1;
        if (locala != null) {
          paramString2 = Long.valueOf(locala.ttF);
        }
        if (paramString2.longValue() < paramLong.longValue()) {
          break;
        }
      }
      ae.d(this.TAG, "preload already done");
      AppMethodBeat.o(213463);
      return;
    }
    a(paramString1, paramLong);
    AppMethodBeat.o(213463);
  }
  
  public final int aks(String paramString)
  {
    AppMethodBeat.i(213464);
    ae.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + paramString + ' ');
    int i = e.tue.cSZ().tuc.aku(paramString);
    a locala = (a)((Map)this.ttD).get(paramString);
    if (locala != null) {
      locala.ttG = false;
    }
    if (n.H(this.ttC, paramString, true)) {
      this.ttC = null;
    }
    AppMethodBeat.o(213464);
    return i;
  }
  
  public final a akt(String paramString)
  {
    AppMethodBeat.i(213465);
    if (((Map)this.ttD).get(paramString) == null)
    {
      paramString = new a();
      AppMethodBeat.o(213465);
      return paramString;
    }
    paramString = ((Map)this.ttD).get(paramString);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
      AppMethodBeat.o(213465);
      throw paramString;
    }
    paramString = (a)paramString;
    AppMethodBeat.o(213465);
    return paramString;
  }
  
  public final void b(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(213469);
    if ((paramString != null) && (paramd != null))
    {
      if (this.ttD.get(paramString) == null)
      {
        ae.e(this.TAG, "preload completed, but task not found, mediaId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213469);
        return;
      }
      Object localObject = this.ttD.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(213469);
        throw paramString;
      }
      localObject = (a)localObject;
      ae.d(this.TAG, "cdntask end preload id:" + paramString + ", isplaymode:" + ((a)localObject).ttH);
      ((a)localObject).nyl = paramd.field_fileLength;
      ((a)localObject).ttF = paramd.field_recvedBytes;
      ((a)localObject).ttI = true;
      ((a)localObject).ttG = false;
      ((Map)this.ttD).put(paramString, localObject);
      ae.i(this.TAG, "preload completed mediaId:".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(213469);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213473);
    ae.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + paramString + ' ');
    AppMethodBeat.o(213473);
    return new byte[0];
  }
  
  public final void gJ(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(213462);
    ae.d(this.TAG, "FVPlayer startTask mediaId:" + paramString2 + " url:" + paramString1);
    boolean bool;
    if (!CdnLogic.taskExist(paramString2))
    {
      if (((Map)this.ttD).get(paramString2) != null) {
        break label163;
      }
      bool = true;
      paramString2 = (a)((Map)this.ttD).get(paramString2);
      if (paramString2 == null) {
        break label169;
      }
    }
    label163:
    label169:
    for (paramString2 = Boolean.valueOf(paramString2.brw);; paramString2 = null)
    {
      ae.e(this.TAG, "testtest task not in preload, in info cache:" + bool + ", completed:" + paramString2);
      if (paramString1 == null) {
        break label320;
      }
      paramString2 = d.n.d.UTF_8;
      if (paramString1 != null) {
        break label174;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(213462);
      throw paramString1;
      bool = false;
      break;
    }
    label174:
    paramString2 = paramString1.getBytes(paramString2);
    p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
    String str1 = g.getMessageDigest(paramString2);
    paramString2 = new StringBuilder().append(this.ttB).append('-');
    int i;
    label222:
    String str2;
    if (paramString1 != null)
    {
      i = paramString1.hashCode();
      str2 = new k(i + ".mp4").getAbsolutePath();
      if (this.ttD.get(str1) != null) {
        break label330;
      }
    }
    for (paramString2 = new a();; paramString2 = (a)paramString2)
    {
      if ((!n.H(this.ttC, str1, false)) || (!paramString2.ttG) || (!paramString2.ttH)) {
        break label370;
      }
      ae.i(this.TAG, "playmode is downloading:".concat(String.valueOf(str1)));
      AppMethodBeat.o(213462);
      return;
      label320:
      paramString2 = null;
      break;
      i = 0;
      break label222;
      label330:
      paramString2 = this.ttD.get(str1);
      if (paramString2 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(213462);
        throw paramString1;
      }
    }
    label370:
    if (!paramString2.brw)
    {
      h localh = new h();
      localh.fLl = "task_FlutterCdnDownloadMgr_2";
      localh.field_mediaId = str1;
      localh.url = paramString1;
      localh.fLq = 60;
      localh.fLr = 60;
      localh.fLC = 1;
      localh.fLI = 1;
      localh.fLD = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.fLQ = ((h.a)this);
      if ((this.ttC != null) && (!n.H(this.ttC, str1, false)) && (CdnLogic.taskExist(this.ttC)))
      {
        i = e.tue.cSZ().tuc.aku(this.ttC);
        if (paramString2 != null) {
          paramString2.ttG = false;
        }
        ae.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.ttC + ' ' + i);
      }
      if (CdnLogic.taskExist(str1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = Boolean.valueOf(paramString2.ttH);
        }
        if (!paramString1.booleanValue())
        {
          i = e.tue.cSZ().tuc.aku(str1);
          if (paramString2 != null) {
            paramString2.ttG = false;
          }
          ae.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.ttC + " mediaId:" + str1 + ' ' + i);
        }
      }
      i = e.tue.cSZ().tuc.c(localh);
      if (paramString2 != null) {
        paramString2.ttG = true;
      }
      if (paramString2 != null) {
        paramString2.ttH = true;
      }
      ae.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + str1 + ' ' + i + " playmode:true path: " + str2);
    }
    for (;;)
    {
      this.ttC = str1;
      p.g(str2, "filePath");
      paramString2.setPath(str2);
      paramString1 = (Map)this.ttD;
      p.g(str1, "mediaId");
      paramString1.put(str1, paramString2);
      AppMethodBeat.o(213462);
      return;
      ae.d(this.TAG, "FVPlayer startTask mediaId:" + str1 + " has downloaded.");
    }
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213468);
    ae.d(this.TAG, "onProgress mediaId:" + paramString + ", finish:" + paramLong1 + ", length:" + paramLong2);
    if (paramString != null) {
      if (this.ttD.get(paramString) != null) {
        break label141;
      }
    }
    for (Object localObject = new a();; localObject = (a)localObject)
    {
      ((a)localObject).cacheSize = paramLong1;
      ((a)localObject).nyl = paramLong2;
      ((Map)this.ttD).put(paramString, localObject);
      if (paramLong1 == paramLong2)
      {
        ae.i(this.TAG, "onprogress cdntask end id:".concat(String.valueOf(paramString)));
        ((a)localObject).brw = true;
      }
      AppMethodBeat.o(213468);
      return;
      label141:
      localObject = this.ttD.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(213468);
        throw paramString;
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213467);
    ae.d(this.TAG, "onDataAvailable mediaId:" + paramString + ", offset:" + paramLong1 + ", length:" + paramLong2);
    AppMethodBeat.o(213467);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"})
  public static final class a
  {
    boolean brw;
    long cacheSize;
    long nyl;
    String path = "";
    long ttF;
    boolean ttG;
    boolean ttH;
    boolean ttI;
    
    public final void setPath(String paramString)
    {
      AppMethodBeat.i(213460);
      p.h(paramString, "<set-?>");
      this.path = paramString;
      AppMethodBeat.o(213460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.b
 * JD-Core Version:    0.7.0.1
 */