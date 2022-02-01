package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.protocal.protobuf.bvl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "setShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderShareObject;)V", "cloneContent", "getAvatar", "", "getNickname", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.message.f
{
  public bvl oUc;
  
  public f()
  {
    AppMethodBeat.i(168870);
    this.oUc = new bvl();
    AppMethodBeat.o(168870);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168868);
    s.u(paramStringBuilder, "sb");
    paramStringBuilder.append(q.d(this.oUc));
    AppMethodBeat.o(168868);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(168869);
    s.u(paramMap, "values");
    s.u(paramb, "content");
    paramMap = q.C(".msg.appmsg", paramMap);
    s.s(paramMap, "parse(\".msg.appmsg\", values)");
    this.oUc = paramMap;
    AppMethodBeat.o(168869);
  }
  
  public final String bCr()
  {
    AppMethodBeat.i(274002);
    Object localObject = (CharSequence)this.oUc.aacV;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
      i = 1;
    }
    while ((i != 0) || (s.p("null", this.oUc.aacV)))
    {
      localObject = this.oUc.avatar;
      if (localObject == null)
      {
        AppMethodBeat.o(274002);
        return "";
        i = 0;
      }
      else
      {
        AppMethodBeat.o(274002);
        return localObject;
      }
    }
    localObject = this.oUc.aacV;
    if (localObject == null)
    {
      AppMethodBeat.o(274002);
      return "";
    }
    AppMethodBeat.o(274002);
    return localObject;
  }
  
  public final com.tencent.mm.message.f biW()
  {
    AppMethodBeat.i(168867);
    Object localObject = new f();
    ((f)localObject).oUc = this.oUc;
    localObject = (com.tencent.mm.message.f)localObject;
    AppMethodBeat.o(168867);
    return localObject;
  }
  
  public final void c(bvl parambvl)
  {
    AppMethodBeat.i(273994);
    s.u(parambvl, "<set-?>");
    this.oUc = parambvl;
    AppMethodBeat.o(273994);
  }
  
  public final bvl frt()
  {
    return this.oUc;
  }
  
  public final String getNickname()
  {
    AppMethodBeat.i(274008);
    Object localObject = (CharSequence)this.oUc.mIK;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
      i = 1;
    }
    while ((i != 0) || (s.p("null", this.oUc.mIK)))
    {
      localObject = this.oUc.nickname;
      if (localObject == null)
      {
        AppMethodBeat.o(274008);
        return "";
        i = 0;
      }
      else
      {
        AppMethodBeat.o(274008);
        return localObject;
      }
    }
    localObject = this.oUc.mIK;
    if (localObject == null)
    {
      AppMethodBeat.o(274008);
      return "";
    }
    AppMethodBeat.o(274008);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.f
 * JD-Core Version:    0.7.0.1
 */