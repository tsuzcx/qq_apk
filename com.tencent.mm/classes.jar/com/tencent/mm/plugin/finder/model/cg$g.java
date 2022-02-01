package com.tencent.mm.plugin.finder.model;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/model/SyncGetImageModel$getImage$2$3", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "onImageDownload", "", "success", "", "extraObj", "", "", "(Z[Ljava/lang/Object;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cg$g
  implements a
{
  cg$g(p<? super Drawable> paramp) {}
  
  public final void onImageDownload(boolean paramBoolean, Object... paramVarArgs)
  {
    AppMethodBeat.i(332100);
    s.u(paramVarArgs, "extraObj");
    if (!paramBoolean)
    {
      paramVarArgs = (d)this.EDL;
      Result.Companion localCompanion = Result.Companion;
      paramVarArgs.resumeWith(Result.constructor-impl(null));
    }
    AppMethodBeat.o(332100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.cg.g
 * JD-Core Version:    0.7.0.1
 */