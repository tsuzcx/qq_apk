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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "(Ljava/lang/String;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1;", "coverUrl", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "getPath", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.loader.g.c
{
  public static final a vSZ;
  public String coverUrl;
  private final String path;
  private final b vSY;
  
  static
  {
    AppMethodBeat.i(253114);
    vSZ = new a((byte)0);
    AppMethodBeat.o(253114);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(253113);
    this.path = paramString;
    this.coverUrl = "";
    this.vSY = new b(this);
    AppMethodBeat.o(253113);
  }
  
  public final String auK()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(253112);
    this.coverUrl = "";
    if (!s.YS(this.path))
    {
      Log.d("Finder.UploadActivityCoverTask", "path " + this.path + " is not file");
      a(j.ibx);
      AppMethodBeat.o(253112);
      return;
    }
    g localg = new g();
    localg.taskName = "task_FinderUploadCoverImageTask";
    localg.gqy = ((g.a)this.vSY);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    f localf = f.vSz;
    localg.field_thumbpath = f.avU(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.gqC = 60;
    localg.gqD = 300;
    localg.field_priority = a.gpM;
    com.tencent.mm.an.f.baQ().f(localg);
    AppMethodBeat.o(253112);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(253111);
      if (paramd != null)
      {
        String str = paramd.toString();
        paramc = str;
        if (str != null) {}
      }
      else
      {
        paramc = "null";
      }
      Log.i("Finder.UploadActivityCoverTask", "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", new Object[] { paramString, Integer.valueOf(paramInt), paramc });
      if (paramInt != 0)
      {
        Log.e("Finder.UploadActivityCoverTask", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        if (paramInt != -21005) {
          k.a(this.vTa, j.ibx);
        }
        AppMethodBeat.o(253111);
        return 0;
      }
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i("Finder.UploadActivityCoverTask", "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          k.a(this.vTa, j.ibx);
          AppMethodBeat.o(253111);
          return 0;
        }
        paramString = this.vTa;
        paramc = paramd.field_fileUrl;
        p.g(paramc, "sceneResult.field_fileUrl");
        p.h(paramc, "<set-?>");
        paramString.coverUrl = paramc;
        k.a(this.vTa, j.ibw);
      }
      AppMethodBeat.o(253111);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.k
 * JD-Core Version:    0.7.0.1
 */