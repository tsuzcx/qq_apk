package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"})
public final class b
  implements g.a, g.b, h.a
{
  private final String TAG;
  private String smf;
  private String smg;
  private HashMap<String, a> smh;
  private String smi;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(209715);
    this.TAG = "MicroMsg.FlutterVideoPlayerMgr";
    this.smh = new HashMap();
    this.smf = (paramContext.getCacheDir() + "/flutter/FTVideo/");
    AppMethodBeat.o(209715);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(209712);
    ac.d(this.TAG, "FVPlayer callback mediaId:" + paramString + ' ');
    AppMethodBeat.o(209712);
    return 0;
  }
  
  public final void a(String paramString, int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(209711);
    Object localObject;
    if ((paramString != null) && (paramd != null)) {
      if (this.smh.get(paramString) == null)
      {
        localObject = new a();
        ac.d(this.TAG, "cdntask end id:" + paramString + ", isplaymode:" + ((a)localObject).sml);
        ((a)localObject).cacheSize = paramd.field_fileLength;
        ((a)localObject).mSs = paramd.field_fileLength;
        ((a)localObject).bhc = true;
        ((Map)this.smh).put(paramString, localObject);
        this.smg = null;
      }
    }
    for (;;)
    {
      paramString = (a)((Map)this.smh).get(paramString);
      if (paramString == null) {
        break label207;
      }
      paramString.smk = false;
      AppMethodBeat.o(209711);
      return;
      localObject = this.smh.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(209711);
        throw paramString;
      }
      localObject = (a)localObject;
      break;
      ac.e(this.TAG, "onfinish but id not found:".concat(String.valueOf(paramString)));
    }
    label207:
    AppMethodBeat.o(209711);
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(209707);
    k.h(paramString2, "svrFlag");
    AppMethodBeat.o(209707);
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(209713);
    ac.d(this.TAG, "FVPlayer getCdnAuthInfo mediaId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(209713);
  }
  
  public final void a(String paramString, Long paramLong)
  {
    AppMethodBeat.i(209702);
    this.smi = paramString;
    if (this.smi == null)
    {
      ac.d(this.TAG, "FVPlayer preLoadTask empty preload task");
      AppMethodBeat.o(209702);
      return;
    }
    paramString = this.smi;
    Object localObject;
    String str;
    if (paramString != null)
    {
      localObject = d.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209702);
        throw paramString;
      }
      paramString = paramString.getBytes((Charset)localObject);
      k.g(paramString, "(this as java.lang.String).getBytes(charset)");
      localObject = g.getMessageDigest(paramString);
      paramString = new StringBuilder().append(this.smf).append('-');
      str = this.smi;
      if (str == null) {
        break label201;
      }
    }
    label201:
    for (int i = str.hashCode();; i = 0)
    {
      str = new com.tencent.mm.vfs.e(i + ".mp4").getAbsolutePath();
      if (!n.I((String)localObject, this.smg, true)) {
        break label206;
      }
      ac.d(this.TAG, "FVPlayer preLoadTask can not preload playing task lastPlayMediaId:" + this.smg);
      AppMethodBeat.o(209702);
      return;
      paramString = null;
      break;
    }
    label206:
    ac.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " url:" + this.smi + " path:" + str);
    if (this.smh.get(localObject) == null)
    {
      paramString = new a();
      if ((paramString.smm) && (paramLong != null) && (paramLong.longValue() != 0L) && (paramString.cacheSize < paramLong.longValue())) {
        paramString.smm = false;
      }
      if ((paramString.bhc) || (paramString.smm) || (paramString.smk)) {
        break label648;
      }
      h localh = new h();
      localh.field_mediaId = ((String)localObject);
      localh.url = this.smi;
      localh.frf = 60;
      localh.frg = 60;
      localh.frq = 2;
      localh.frw = 2;
      localh.frr = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str;
      localh.concurrentCount = 8;
      localh.connectionCount = 1;
      localh.frE = ((h.a)this);
      localh.frb = ((g.a)this);
      localh.frs = ((g.b)this);
      if ((paramLong != null) && (paramLong.longValue() != 0L)) {
        localh.preloadMinSize = paramLong.longValue();
      }
      if (CdnLogic.taskExist((String)localObject)) {
        break label614;
      }
      e.smI.cIf().smG.c(localh);
      paramString.smk = true;
      paramString.sml = false;
      ac.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + (String)localObject + " .");
    }
    for (;;)
    {
      k.g(str, "filePath");
      paramString.setPath(str);
      paramLong = (Map)this.smh;
      k.g(localObject, "mediaId");
      paramLong.put(localObject, paramString);
      AppMethodBeat.o(209702);
      return;
      paramString = this.smh.get(localObject);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(209702);
        throw paramString;
      }
      paramString = (a)paramString;
      break;
      label614:
      ac.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + (String)localObject + " .");
      continue;
      label648:
      ac.d(this.TAG, "FVPlayer preLoadTask mediaId:" + (String)localObject + " has downloaded or isDoing:" + paramString.bhc + ", " + paramString.smm + ", " + paramString.smk + '.');
    }
  }
  
  public final void a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(209704);
    ac.d(this.TAG, "FVPlayer retryStartTask mediaId:" + paramString2 + " url:" + paramString1);
    a locala = aeX(paramString2);
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.smk);; paramString2 = null)
    {
      if (paramString2 == null) {
        k.fOy();
      }
      if (!paramString2.booleanValue()) {
        break;
      }
      paramString2 = this.TAG;
      paramLong = new StringBuilder("is already downloading, isPlayMode:false, curMode:");
      paramString1 = localObject2;
      if (locala != null) {
        paramString1 = Boolean.valueOf(locala.sml);
      }
      ac.d(paramString2, paramString1.booleanValue());
      AppMethodBeat.o(209704);
      return;
    }
    if (locala != null) {}
    for (paramString2 = Boolean.valueOf(locala.smm); paramString2.booleanValue(); paramString2 = null)
    {
      if ((paramLong != null) && (paramLong.longValue() != 0L))
      {
        paramString2 = localObject1;
        if (locala != null) {
          paramString2 = Long.valueOf(locala.smj);
        }
        if (paramString2.longValue() < paramLong.longValue()) {
          break;
        }
      }
      ac.d(this.TAG, "preload already done");
      AppMethodBeat.o(209704);
      return;
    }
    a(paramString1, paramLong);
    AppMethodBeat.o(209704);
  }
  
  public final int aeW(String paramString)
  {
    AppMethodBeat.i(209705);
    ac.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + paramString + ' ');
    int i = e.smI.cIf().smG.aeY(paramString);
    a locala = (a)((Map)this.smh).get(paramString);
    if (locala != null) {
      locala.smk = false;
    }
    if (n.I(this.smg, paramString, true)) {
      this.smg = null;
    }
    AppMethodBeat.o(209705);
    return i;
  }
  
  public final a aeX(String paramString)
  {
    AppMethodBeat.i(209706);
    if (((Map)this.smh).get(paramString) == null)
    {
      paramString = new a();
      AppMethodBeat.o(209706);
      return paramString;
    }
    paramString = ((Map)this.smh).get(paramString);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
      AppMethodBeat.o(209706);
      throw paramString;
    }
    paramString = (a)paramString;
    AppMethodBeat.o(209706);
    return paramString;
  }
  
  public final void b(String paramString, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(209710);
    if ((paramString != null) && (paramd != null))
    {
      if (this.smh.get(paramString) == null)
      {
        ac.e(this.TAG, "preload completed, but task not found, mediaId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(209710);
        return;
      }
      Object localObject = this.smh.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(209710);
        throw paramString;
      }
      localObject = (a)localObject;
      ac.d(this.TAG, "cdntask end preload id:" + paramString + ", isplaymode:" + ((a)localObject).sml);
      ((a)localObject).mSs = paramd.field_fileLength;
      ((a)localObject).smj = paramd.field_recvedBytes;
      ((a)localObject).smm = true;
      ((a)localObject).smk = false;
      ((Map)this.smh).put(paramString, localObject);
      ac.i(this.TAG, "preload completed mediaId:".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(209710);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209714);
    ac.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + paramString + ' ');
    AppMethodBeat.o(209714);
    return new byte[0];
  }
  
  public final void gt(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(209703);
    ac.d(this.TAG, "FVPlayer startTask mediaId:" + paramString2 + " url:" + paramString1);
    boolean bool;
    if (!CdnLogic.taskExist(paramString2))
    {
      if (((Map)this.smh).get(paramString2) != null) {
        break label163;
      }
      bool = true;
      paramString2 = (a)((Map)this.smh).get(paramString2);
      if (paramString2 == null) {
        break label169;
      }
    }
    label163:
    label169:
    for (paramString2 = Boolean.valueOf(paramString2.bhc);; paramString2 = null)
    {
      ac.e(this.TAG, "testtest task not in preload, in info cache:" + bool + ", completed:" + paramString2);
      if (paramString1 == null) {
        break label320;
      }
      paramString2 = d.n.d.UTF_8;
      if (paramString1 != null) {
        break label174;
      }
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(209703);
      throw paramString1;
      bool = false;
      break;
    }
    label174:
    paramString2 = paramString1.getBytes(paramString2);
    k.g(paramString2, "(this as java.lang.String).getBytes(charset)");
    String str1 = g.getMessageDigest(paramString2);
    paramString2 = new StringBuilder().append(this.smf).append('-');
    int i;
    label222:
    String str2;
    if (paramString1 != null)
    {
      i = paramString1.hashCode();
      str2 = new com.tencent.mm.vfs.e(i + ".mp4").getAbsolutePath();
      if (this.smh.get(str1) != null) {
        break label330;
      }
    }
    for (paramString2 = new a();; paramString2 = (a)paramString2)
    {
      if ((!n.I(this.smg, str1, false)) || (!paramString2.smk) || (!paramString2.sml)) {
        break label370;
      }
      ac.i(this.TAG, "playmode is downloading:".concat(String.valueOf(str1)));
      AppMethodBeat.o(209703);
      return;
      label320:
      paramString2 = null;
      break;
      i = 0;
      break label222;
      label330:
      paramString2 = this.smh.get(str1);
      if (paramString2 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(209703);
        throw paramString1;
      }
    }
    label370:
    if (!paramString2.bhc)
    {
      h localh = new h();
      localh.field_mediaId = str1;
      localh.url = paramString1;
      localh.frf = 60;
      localh.frg = 60;
      localh.frq = 1;
      localh.frw = 1;
      localh.frr = 3;
      localh.field_requestVideoFormat = 0;
      localh.field_fullpath = str2;
      localh.concurrentCount = 8;
      localh.frE = ((h.a)this);
      if ((this.smg != null) && (!n.I(this.smg, str1, false)) && (CdnLogic.taskExist(this.smg)))
      {
        i = e.smI.cIf().smG.aeY(this.smg);
        if (paramString2 != null) {
          paramString2.smk = false;
        }
        ac.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.smg + ' ' + i);
      }
      if (CdnLogic.taskExist(str1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = Boolean.valueOf(paramString2.sml);
        }
        if (!paramString1.booleanValue())
        {
          i = e.smI.cIf().smG.aeY(str1);
          if (paramString2 != null) {
            paramString2.smk = false;
          }
          ac.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.smg + " mediaId:" + str1 + ' ' + i);
        }
      }
      i = e.smI.cIf().smG.c(localh);
      if (paramString2 != null) {
        paramString2.smk = true;
      }
      if (paramString2 != null) {
        paramString2.sml = true;
      }
      ac.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + str1 + ' ' + i + " playmode:true path: " + str2);
    }
    for (;;)
    {
      this.smg = str1;
      k.g(str2, "filePath");
      paramString2.setPath(str2);
      paramString1 = (Map)this.smh;
      k.g(str1, "mediaId");
      paramString1.put(str1, paramString2);
      AppMethodBeat.o(209703);
      return;
      ac.d(this.TAG, "FVPlayer startTask mediaId:" + str1 + " has downloaded.");
    }
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209709);
    ac.d(this.TAG, "onProgress mediaId:" + paramString + ", finish:" + paramLong1 + ", length:" + paramLong2);
    if (paramString != null) {
      if (this.smh.get(paramString) != null) {
        break label141;
      }
    }
    for (Object localObject = new a();; localObject = (a)localObject)
    {
      ((a)localObject).cacheSize = paramLong1;
      ((a)localObject).mSs = paramLong2;
      ((Map)this.smh).put(paramString, localObject);
      if (paramLong1 == paramLong2)
      {
        ac.i(this.TAG, "onprogress cdntask end id:".concat(String.valueOf(paramString)));
        ((a)localObject).bhc = true;
      }
      AppMethodBeat.o(209709);
      return;
      label141:
      localObject = this.smh.get(paramString);
      if (localObject == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
        AppMethodBeat.o(209709);
        throw paramString;
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209708);
    ac.d(this.TAG, "onDataAvailable mediaId:" + paramString + ", offset:" + paramLong1 + ", length:" + paramLong2);
    AppMethodBeat.o(209708);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"})
  public static final class a
  {
    boolean bhc;
    long cacheSize;
    long mSs;
    String path = "";
    long smj;
    boolean smk;
    boolean sml;
    boolean smm;
    
    public final void setPath(String paramString)
    {
      AppMethodBeat.i(209701);
      k.h(paramString, "<set-?>");
      this.path = paramString;
      AppMethodBeat.o(209701);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.b
 * JD-Core Version:    0.7.0.1
 */