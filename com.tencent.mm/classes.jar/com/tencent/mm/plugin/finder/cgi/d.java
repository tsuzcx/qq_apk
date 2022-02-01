package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c<ave>
{
  public static final a Ays;
  private long commentId;
  private long feedId;
  
  static
  {
    AppMethodBeat.i(165160);
    Ays = new a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public d(long paramLong1, long paramLong2, String paramString, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336283);
    Object localObject2 = new avd();
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)localObject2);
    localObject2 = new ave();
    ((ave)localObject2).setBaseResponse(new kd());
    ((c.a)localObject1).otF = ((a)localObject2);
    ((c.a)localObject1).timeout = 2000;
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/findercomment";
    ((c.a)localObject1).funcId = 3906;
    c(((c.a)localObject1).bEF());
    Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.feedId = paramLong2;
    Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new avd();
    ((avd)localObject1).commentId = paramLong1;
    ((avd)localObject1).opType = 1;
    ((avd)localObject1).hKN = paramLong2;
    ((avd)localObject1).objectNonceId = paramString;
    ((avd)localObject1).scene = paramInt;
    paramString = bi.ABn;
    ((avd)localObject1).CJv = bi.a(parambui);
    paramString = z.FrZ;
    if (parambui == null)
    {
      paramInt = 0;
      ((avd)localObject1).sessionBuffer = z.p(paramLong2, paramInt);
      paramString = new c.a();
      paramString.otE = ((a)localObject1);
      localObject2 = new ave();
      ((ave)localObject2).setBaseResponse(new kd());
      paramString.otF = ((a)localObject2);
      paramString.timeout = 2000;
      localObject2 = bi.ABn;
      localObject1 = ((avd)localObject1).CJv;
      if (parambui != null) {
        break label387;
      }
    }
    label387:
    for (paramInt = i;; paramInt = parambui.hLK)
    {
      bi.a((atz)localObject1, p.listOf(new r(Integer.valueOf(paramInt), Long.valueOf(paramLong2))));
      paramString.uri = "/cgi-bin/micromsg-bin/findercomment";
      paramString.funcId = 3906;
      c(paramString.bEF());
      Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(336283);
      return;
      paramInt = parambui.AJo;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */