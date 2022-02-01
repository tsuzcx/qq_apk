package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/findersdk/api/CgiFinderGetUser;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetUserResponse;", "nicknameList", "", "", "(Ljava/util/List;)V", "TAG", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "finder-sdk_release"})
public final class j
  extends c<atx>
{
  private final String TAG;
  
  public j(List<String> paramList)
  {
    AppMethodBeat.i(208789);
    this.TAG = "Finder.CgiFinderGetUser";
    Object localObject2 = new atw();
    ((atw)localObject2).LEK.addAll((Collection)paramList);
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((a)localObject2);
    localObject2 = new atx();
    ((atx)localObject2).setBaseResponse(new BaseResponse());
    ((atx)localObject2).getBaseResponse().ErrMsg = new dqi();
    ((d.a)localObject1).d((a)localObject2);
    ((d.a)localObject1).MB("/cgi-bin/micromsg-bin/findergetuser");
    ((d.a)localObject1).sG(3512);
    c(((d.a)localObject1).aXF());
    localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init nickname:");
    localObject1 = (String)kotlin.a.j.kt(paramList);
    paramList = (List<String>)localObject1;
    if (localObject1 == null) {
      paramList = "";
    }
    Log.i((String)localObject2, paramList);
    AppMethodBeat.o(208789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.j
 * JD-Core Version:    0.7.0.1
 */