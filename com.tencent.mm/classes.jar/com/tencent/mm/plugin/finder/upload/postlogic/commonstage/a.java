package com.tencent.mm.plugin.finder.upload.postlogic.commonstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.plugin.finder.upload.postlogic.base.i;
import com.tencent.mm.plugin.finder.upload.postlogic.base.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/commonstage/PostFileClearStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/TaskStage;", "()V", "TAG", "", "exec", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "getStageType", "", "onFailed", "", "nextStage", "onSuccess", "onWait", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends j
{
  public static final a.a GdX;
  private static final String GdY;
  private final String TAG = "LogPost.PostFileClearStage";
  
  static
  {
    AppMethodBeat.i(342994);
    GdX = new a.a((byte)0);
    GdY = "PostFileClearStage";
    AppMethodBeat.o(342994);
  }
  
  public a()
  {
    super(GdY);
  }
  
  public final void d(e parame)
  {
    AppMethodBeat.i(343003);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343003);
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(343007);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343007);
  }
  
  public final void f(e parame)
  {
    AppMethodBeat.i(343012);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343012);
  }
  
  public final e fen()
  {
    AppMethodBeat.i(342999);
    Log.i(this.TAG, "PostFileClearStage exec");
    Object localObject = f.GbE;
    f.fdU();
    localObject = (e)new b(GdY);
    AppMethodBeat.o(342999);
    return localObject;
  }
  
  public final int fer()
  {
    return 1;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/postlogic/commonstage/PostFileClearStage$exec$1", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/SuccStage;", "exec", "", "getStageType", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends i
  {
    b(String paramString)
    {
      super();
    }
    
    public final void cpv() {}
    
    public final int fer()
    {
      return 100;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.commonstage.a
 * JD-Core Version:    0.7.0.1
 */