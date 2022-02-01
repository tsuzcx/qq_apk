package com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.age;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/CgiFinderNavLiveStream$LiveEntranceRequest;", "", "pullType", "", "containerId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "fromScene", "containerContextList", "", "Lcom/tencent/mm/protocal/protobuf/ContainerContext;", "commentScene", "relatedObjectId", "", "(IILcom/tencent/mm/protobuf/ByteString;ILjava/util/List;IJ)V", "getCommentScene", "()I", "getContainerContextList", "()Ljava/util/List;", "getContainerId", "getFromScene", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getPullType", "getRelatedObjectId", "()J", "toString", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  final int AJo;
  final long EIG;
  final int EOG;
  final List<age> EOH;
  final int fromScene;
  b lastBuffer;
  final int pullType;
  
  private a$b(int paramInt1, int paramInt2, b paramb, List<? extends age> paramList, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(340278);
    this.pullType = paramInt1;
    this.EOG = paramInt2;
    this.lastBuffer = paramb;
    this.fromScene = 76;
    this.EOH = paramList;
    this.AJo = paramInt3;
    this.EIG = paramLong;
    AppMethodBeat.o(340278);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(340292);
    String str = "LiveEntranceRequest(pullType=" + this.pullType + ", containerId=" + this.EOG + ", lastBuffer=" + this.lastBuffer + ", fromScene=" + this.fromScene + ", containerContextList.size=" + this.EOH.size() + ", commentScene=" + this.AJo + ", relatedObjectId=" + this.EIG + ')';
    AppMethodBeat.o(340292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.a.b
 * JD-Core Version:    0.7.0.1
 */