package com.tencent.mm.plugin.finder.publish;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.plugin.finder.cgi.v;
import com.tencent.mm.plugin.finder.record.config.a;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.protocal.protobuf.baj;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/PublishPostApi;", "Lcom/tencent/mm/plugin/finder/publish/IPublishPostApi;", "()V", "cameraCheck", "", "context", "Landroid/content/Context;", "clearMarkFiles", "", "enableRecordTemplate", "getMiaojianCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetMiaoJianVideoMetaResp;", "md5", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements d
{
  public static final h FhQ;
  
  static
  {
    AppMethodBeat.i(330564);
    FhQ = new h();
    AppMethodBeat.o(330564);
  }
  
  public static boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(330559);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.upload.d locald = com.tencent.mm.plugin.finder.upload.d.GbA;
    boolean bool = com.tencent.mm.plugin.finder.upload.d.cameraCheck(paramContext);
    AppMethodBeat.o(330559);
    return bool;
  }
  
  public final b<baj> azA(String paramString)
  {
    AppMethodBeat.i(330582);
    s.u(paramString, "md5");
    paramString = (b)new v(paramString);
    AppMethodBeat.o(330582);
    return paramString;
  }
  
  public final boolean eKZ()
  {
    AppMethodBeat.i(330569);
    a locala = a.Fix;
    boolean bool = a.eLj();
    AppMethodBeat.o(330569);
    return bool;
  }
  
  public final void eLa()
  {
    AppMethodBeat.i(330574);
    f localf = f.GbE;
    f.eLa();
    AppMethodBeat.o(330574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.h
 * JD-Core Version:    0.7.0.1
 */