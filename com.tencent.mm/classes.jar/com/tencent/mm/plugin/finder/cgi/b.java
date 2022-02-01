package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class b
  extends an<apk>
{
  public static final a tsG;
  private long commentId;
  private long feedId;
  
  static
  {
    AppMethodBeat.i(165160);
    tsG = new a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public b(long paramLong1, long paramLong2, String paramString, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242199);
    Object localObject2 = new apj();
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((a)localObject2);
    localObject2 = new apk();
    ((apk)localObject2).setBaseResponse(new BaseResponse());
    ((d.a)localObject1).d((a)localObject2);
    ((d.a)localObject1).sH(2000);
    ((d.a)localObject1).MB("/cgi-bin/micromsg-bin/findercomment");
    ((d.a)localObject1).sG(3906);
    c(((d.a)localObject1).aXF());
    Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.feedId = paramLong2;
    Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new apj();
    ((apj)localObject1).commentId = paramLong1;
    ((apj)localObject1).opType = 1;
    ((apj)localObject1).hFK = paramLong2;
    ((apj)localObject1).objectNonceId = paramString;
    ((apj)localObject1).scene = paramInt;
    paramString = am.tuw;
    ((apj)localObject1).uli = am.a(parambbn);
    paramString = k.vfA;
    if (parambbn != null) {}
    for (paramInt = parambbn.tCE;; paramInt = 0)
    {
      ((apj)localObject1).sessionBuffer = k.G(paramLong2, paramInt);
      paramString = new d.a();
      paramString.c((a)localObject1);
      parambbn = new apk();
      parambbn.setBaseResponse(new BaseResponse());
      paramString.d((a)parambbn);
      paramString.sH(2000);
      paramString.MB("/cgi-bin/micromsg-bin/findercomment");
      paramString.sG(3906);
      c(paramString.aXF());
      Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(242199);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */