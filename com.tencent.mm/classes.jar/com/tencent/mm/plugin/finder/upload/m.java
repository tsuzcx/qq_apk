package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "resultThumbUrl", "getResultThumbUrl", "setResultThumbUrl", "(Ljava/lang/String;)V", "resultUrl", "getResultUrl", "setResultUrl", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "plugin-finder_release"})
public final class m
  extends com.tencent.mm.loader.g.c
{
  public String AAI;
  private final a AAJ;
  final String TAG;
  public d jYa;
  private final String path;
  public String resultUrl;
  private final String userName;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(282637);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadLiveCoverImageTask";
    this.resultUrl = "";
    this.AAI = "";
    this.AAJ = new a(this);
    AppMethodBeat.o(282637);
  }
  
  public final String aBG()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(282636);
    if (!u.agG(this.path))
    {
      Log.d(this.TAG, "path " + this.path + " is not file");
      a(j.kQe);
      AppMethodBeat.o(282636);
      return;
    }
    g localg = new g();
    localg.iUG = ((g.a)this.AAJ);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    f localf = f.AzZ;
    localg.field_thumbpath = f.aFk(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = 20304;
    localg.field_appType = 251;
    localg.field_bzScene = 2;
    localg.iUK = 60;
    localg.iUL = 300;
    localg.field_priority = a.iTU;
    com.tencent.mm.aq.f.bkg().f(localg);
    AppMethodBeat.o(282636);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class a
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(272807);
      String str2 = this.AAK.TAG;
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
        Log.e(this.AAK.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005) {
          this.AAK.a(j.kQe);
        }
        AppMethodBeat.o(272807);
        return 0;
      }
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.AAK.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode == 0) {
          break label198;
        }
        this.AAK.a(j.kQe);
      }
      for (;;)
      {
        AppMethodBeat.o(272807);
        return 0;
        label198:
        paramString = this.AAK;
        paramc = paramd.field_fileUrl;
        p.j(paramc, "sceneResult.field_fileUrl");
        p.k(paramc, "<set-?>");
        paramString.resultUrl = paramc;
        paramString = this.AAK;
        paramc = paramd.field_thumbUrl;
        p.j(paramc, "sceneResult.field_thumbUrl");
        p.k(paramc, "<set-?>");
        paramString.AAI = paramc;
        this.AAK.jYa = paramd;
        this.AAK.a(j.kQd);
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.m
 * JD-Core Version:    0.7.0.1
 */