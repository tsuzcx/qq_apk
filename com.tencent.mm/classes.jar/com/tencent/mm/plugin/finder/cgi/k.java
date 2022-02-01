package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderDelDraft;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderDelDraftResponse;", "id", "", "(J)V", "TAG", "", "getId", "()J", "request", "Lcom/tencent/mm/protocal/protobuf/FinderDelDraftRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends c<awh>
{
  private awg AyJ;
  private final String TAG;
  private final long id;
  
  public k(long paramLong)
  {
    super(null);
    AppMethodBeat.i(336328);
    this.id = paramLong;
    this.TAG = "Finder.CgiFinderDelDraft";
    this.AyJ = new awg();
    this.AyJ.id = this.id;
    Object localObject1 = this.AyJ;
    Object localObject2 = bi.ABn;
    ((awg)localObject1).YIY = bi.a(this.Auc);
    this.AyJ.ZHe = z.bAW();
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)this.AyJ);
    localObject2 = new awh();
    ((awh)localObject2).setBaseResponse(new kd());
    ((awh)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderdeldraft";
    ((c.a)localObject1).funcId = 6662;
    c(((c.a)localObject1).bEF());
    Log.i(this.TAG, s.X("init id:", Long.valueOf(this.id)));
    AppMethodBeat.o(336328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */