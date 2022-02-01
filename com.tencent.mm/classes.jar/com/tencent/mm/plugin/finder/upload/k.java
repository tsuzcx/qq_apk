package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "(Ljava/lang/String;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1;", "coverUrl", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "getPath", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.loader.f.c
{
  public static final k.a Gcd;
  private final k.b Gce;
  public String coverUrl;
  private final String path;
  
  static
  {
    AppMethodBeat.i(343459);
    Gcd = new k.a((byte)0);
    AppMethodBeat.o(343459);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(343453);
    this.path = paramString;
    this.coverUrl = "";
    this.Gce = new k.b(this);
    AppMethodBeat.o(343453);
  }
  
  public final String aUE()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(343467);
    this.coverUrl = "";
    if (!y.ZC(this.path))
    {
      Log.d("Finder.UploadActivityCoverTask", "path " + this.path + " is not file");
      a(i.nrH);
      AppMethodBeat.o(343467);
      return;
    }
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_FinderUploadCoverImageTask";
    localg.lwL = ((g.a)this.Gce);
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
    com.tencent.mm.modelcdntran.k.bHW().g(localg);
    AppMethodBeat.o(343467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.k
 * JD-Core Version:    0.7.0.1
 */