package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends com.tencent.mm.loader.f.c
{
  private final l.a Gcg;
  final String TAG;
  private final String path;
  final String userName;
  
  public l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167789);
    this.path = paramString1;
    this.userName = paramString2;
    this.TAG = "Finder.FinderUploadCoverImageTask";
    this.Gcg = new l.a(this);
    AppMethodBeat.o(167789);
  }
  
  public final String aUE()
  {
    return this.path;
  }
  
  public final void call()
  {
    AppMethodBeat.i(167788);
    if (!y.ZC(this.path))
    {
      Log.d(this.TAG, "path " + this.path + " is not file");
      a(i.nrH);
      AppMethodBeat.o(167788);
      return;
    }
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.taskName = "task_FinderUploadCoverImageTask";
    localg.lwL = ((g.a)this.Gcg);
    localg.field_mediaId = MD5Util.getMD5String(this.path);
    localg.field_fullpath = this.path;
    localg.field_thumbpath = ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostFileManager().azz(this.path);
    localg.field_talker = "";
    localg.field_needStorage = true;
    localg.field_fileType = com.tencent.mm.g.a.MediaType_FRIENDS;
    localg.field_appType = 100;
    localg.field_bzScene = 1;
    localg.lwP = 60;
    localg.lwQ = 300;
    localg.field_priority = com.tencent.mm.g.a.lvZ;
    k.bHW().g(localg);
    AppMethodBeat.o(167788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.l
 * JD-Core Version:    0.7.0.1
 */