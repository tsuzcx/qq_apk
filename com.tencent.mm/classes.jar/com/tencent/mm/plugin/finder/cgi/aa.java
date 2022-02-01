package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetUser;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "nicknameList", "", "", "(Ljava/util/List;)V", "TAG", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends b<bbi>
{
  private final String TAG;
  
  public aa(List<String> paramList)
  {
    AppMethodBeat.i(336261);
    this.TAG = "Finder.CgiFinderGetUser";
    Object localObject2 = new bbh();
    ((bbh)localObject2).ZLZ.addAll((Collection)paramList);
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)localObject2);
    localObject2 = new bbi();
    ((bbi)localObject2).setBaseResponse(new kd());
    ((bbi)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/findergetuser";
    ((c.a)localObject1).funcId = 3512;
    c(((c.a)localObject1).bEF());
    localObject2 = this.TAG;
    localObject1 = (String)p.oL(paramList);
    paramList = (List<String>)localObject1;
    if (localObject1 == null) {
      paramList = "";
    }
    Log.i((String)localObject2, s.X("init nickname:", paramList));
    AppMethodBeat.o(336261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aa
 * JD-Core Version:    0.7.0.1
 */