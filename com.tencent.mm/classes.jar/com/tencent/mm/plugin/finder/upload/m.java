package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "resultThumbUrl", "getResultThumbUrl", "setResultThumbUrl", "(Ljava/lang/String;)V", "resultUrl", "getResultUrl", "setResultUrl", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "plugin-finder_release"})
public final class m
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  public d hmq;
  private final String path;
  public String resultUrl;
  private final String userName;
  public String vTf;
  private final a vTg;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253118);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadLiveCoverImageTask";
    this.resultUrl = "";
    this.vTf = "";
    this.vTg = new a(this);
    AppMethodBeat.o(253118);
  }
  
  public final String auK()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(253117);
    if (!s.YS(this.path))
    {
      Log.d(this.TAG, "path " + this.path + " is not file");
      a(j.ibx);
      AppMethodBeat.o(253117);
      return;
    }
    g localg = new g();
    localg.gqy = ((g.a)this.vTg);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    f localf = f.vSz;
    localg.field_thumbpath = f.avU(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = 20304;
    localg.field_appType = 251;
    localg.field_bzScene = 2;
    localg.gqC = 60;
    localg.gqD = 300;
    localg.field_priority = a.gpM;
    com.tencent.mm.an.f.baQ().f(localg);
    AppMethodBeat.o(253117);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(253116);
      String str2 = this.vTh.TAG;
      if (paramd != null)
      {
        String str1 = paramd.toString();
        paramc = str1;
        if (str1 != null) {}
      }
      else
      {
        paramc = "null";
      }
      Log.i(str2, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt != 0)
      {
        Log.e(this.vTh.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005) {
          this.vTh.a(j.ibx);
        }
        AppMethodBeat.o(253116);
        return 0;
      }
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.vTh.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode == 0) {
          break label198;
        }
        this.vTh.a(j.ibx);
      }
      for (;;)
      {
        AppMethodBeat.o(253116);
        return 0;
        label198:
        paramString = this.vTh;
        paramc = paramd.field_fileUrl;
        p.g(paramc, "sceneResult.field_fileUrl");
        p.h(paramc, "<set-?>");
        paramString.resultUrl = paramc;
        paramString = this.vTh;
        paramc = paramd.field_thumbUrl;
        p.g(paramc, "sceneResult.field_thumbUrl");
        p.h(paramc, "<set-?>");
        paramString.vTf = paramc;
        this.vTh.hmq = paramd;
        this.vTh.a(j.ibw);
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.m
 * JD-Core Version:    0.7.0.1
 */