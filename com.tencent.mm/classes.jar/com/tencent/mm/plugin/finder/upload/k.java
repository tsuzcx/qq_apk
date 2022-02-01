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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "(Ljava/lang/String;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1;", "coverUrl", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "getPath", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "Companion", "plugin-finder_release"})
public final class k
  extends com.tencent.mm.loader.g.c
{
  public static final a AAB;
  private final b AAA;
  public String coverUrl;
  private final String path;
  
  static
  {
    AppMethodBeat.i(291287);
    AAB = new a((byte)0);
    AppMethodBeat.o(291287);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(291286);
    this.path = paramString;
    this.coverUrl = "";
    this.AAA = new b(this);
    AppMethodBeat.o(291286);
  }
  
  public final String aBG()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(291285);
    this.coverUrl = "";
    if (!u.agG(this.path))
    {
      Log.d("Finder.UploadActivityCoverTask", "path " + this.path + " is not file");
      a(j.kQe);
      AppMethodBeat.o(291285);
      return;
    }
    g localg = new g();
    localg.taskName = "task_FinderUploadCoverImageTask";
    localg.iUG = ((g.a)this.AAA);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    f localf = f.AzZ;
    localg.field_thumbpath = f.aFk(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.iUK = 60;
    localg.iUL = 300;
    localg.field_priority = a.iTU;
    com.tencent.mm.aq.f.bkg().f(localg);
    AppMethodBeat.o(291285);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
  public static final class b
    implements g.a
  {
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(222819);
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
          k.a(this.AAD, j.kQe);
        }
        AppMethodBeat.o(222819);
        return 0;
      }
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Log.i("Finder.UploadActivityCoverTask", "retCode %d, fileId %s, url %s", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_fileId, paramd.field_fileUrl });
        if (paramd.field_retCode != 0)
        {
          k.a(this.AAD, j.kQe);
          AppMethodBeat.o(222819);
          return 0;
        }
        paramString = this.AAD;
        paramc = paramd.field_fileUrl;
        p.j(paramc, "sceneResult.field_fileUrl");
        p.k(paramc, "<set-?>");
        paramString.coverUrl = paramc;
        k.a(this.AAD, j.kQd);
      }
      AppMethodBeat.o(222819);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.k
 * JD-Core Version:    0.7.0.1
 */