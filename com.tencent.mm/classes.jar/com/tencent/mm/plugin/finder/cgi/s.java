package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetUser;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "nicknameList", "", "", "(Ljava/util/List;)V", "TAG", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class s
  extends c<awa>
{
  private final String TAG;
  
  public s(List<String> paramList)
  {
    AppMethodBeat.i(279248);
    this.TAG = "Finder.CgiFinderGetUser";
    Object localObject2 = new avz();
    ((avz)localObject2).SIs.addAll((Collection)paramList);
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((a)localObject2);
    localObject2 = new awa();
    ((awa)localObject2).setBaseResponse(new jh());
    ((awa)localObject2).getBaseResponse().Tef = new eaf();
    ((d.a)localObject1).d((a)localObject2);
    ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/findergetuser");
    ((d.a)localObject1).vD(3512);
    c(((d.a)localObject1).bgN());
    localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init nickname:");
    localObject1 = (String)j.lp(paramList);
    paramList = (List<String>)localObject1;
    if (localObject1 == null) {
      paramList = "";
    }
    Log.i((String)localObject2, paramList);
    AppMethodBeat.o(279248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.s
 * JD-Core Version:    0.7.0.1
 */