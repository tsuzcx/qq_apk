package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "resultThumbUrl", "getResultThumbUrl", "setResultThumbUrl", "(Ljava/lang/String;)V", "resultUrl", "getResultUrl", "setResultUrl", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.loader.f.c
{
  public String Gcj;
  private final a Gck;
  final String TAG;
  public d mxU;
  private final String path;
  public String resultUrl;
  private final String userName;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(343273);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadLiveCoverImageTask";
    this.resultUrl = "";
    this.Gcj = "";
    this.Gck = new a(this);
    AppMethodBeat.o(343273);
  }
  
  public final String aUE()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(343282);
    if (!y.ZC(this.path))
    {
      Log.d(this.TAG, "path " + this.path + " is not file");
      a(i.nrH);
      AppMethodBeat.o(343282);
      return;
    }
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.lwL = ((g.a)this.Gck);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    localg.field_thumbpath = ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostFileManager().azz(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = 20304;
    localg.field_appType = 251;
    localg.field_bzScene = 2;
    localg.lwP = 60;
    localg.lwQ = 300;
    localg.field_priority = com.tencent.mm.g.a.lvZ;
    k.bHW().g(localg);
    AppMethodBeat.o(343282);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    a(m paramm) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(342843);
      String str2 = this.Gcl.TAG;
      if (paramd == null) {
        paramc = "null";
      }
      for (;;)
      {
        Log.i(str2, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
        if (paramInt == 0) {
          break;
        }
        Log.e(this.Gcl.TAG, "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005) {
          this.Gcl.a(i.nrH);
        }
        AppMethodBeat.o(342843);
        return 0;
        String str1 = paramd.toString();
        paramc = str1;
        if (str1 == null) {
          paramc = "null";
        }
      }
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i(this.Gcl.TAG, "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode == 0) {
          break label204;
        }
        this.Gcl.a(i.nrH);
      }
      for (;;)
      {
        AppMethodBeat.o(342843);
        return 0;
        label204:
        paramString = this.Gcl;
        paramc = paramd.field_fileUrl;
        s.s(paramc, "sceneResult.field_fileUrl");
        s.u(paramc, "<set-?>");
        paramString.resultUrl = paramc;
        paramString = this.Gcl;
        paramc = paramd.field_thumbUrl;
        s.s(paramc, "sceneResult.field_thumbUrl");
        s.u(paramc, "<set-?>");
        paramString.Gcj = paramc;
        this.Gcl.mxU = paramd;
        this.Gcl.a(i.nrG);
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.m
 * JD-Core Version:    0.7.0.1
 */