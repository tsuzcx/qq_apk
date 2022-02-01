package com.tencent.mm.plugin.finder.live.cgi;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.bdf;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveModPromoteInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorModPromoteInfoListResponse;", "promoteInfoReq", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveModPromoteInfo$FinderLiveModPromoteInfoReq;", "(Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveModPromoteInfo$FinderLiveModPromoteInfoReq;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorModPromoteInfoListRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "FinderLiveModPromoteInfoReq", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends c<bdg>
{
  public static final a Cvz;
  private bdf CvA;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(351195);
    Cvz = new a((byte)0);
    AppMethodBeat.o(351195);
  }
  
  public q(b paramb)
  {
    super(null);
    AppMethodBeat.i(351186);
    this.TAG = "Finder.CgiFinderLiveModPromoteInfo";
    this.CvA = new bdf();
    Object localObject1 = this.CvA;
    Object localObject2 = bi.ABn;
    ((bdf)localObject1).YIY = bi.dVu();
    this.CvA.object_id = paramb.hKN;
    this.CvA.mMJ = paramb.liveId;
    this.CvA.YIZ = z.bAW();
    this.CvA.YAN = paramb.CvB;
    this.CvA.CvC = paramb.CvC;
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)this.CvA);
    localObject2 = new bdg();
    ((bdg)localObject2).setBaseResponse(new kd());
    ((bdg)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderliveanchormodpromoteinfolist";
    ((c.a)localObject1).funcId = 6254;
    c(((c.a)localObject1).bEF());
    Log.i(this.TAG, "init liveId:" + paramb.liveId + ", objectId:" + paramb.hKN + ", op_type" + paramb.CvB);
    AppMethodBeat.o(351186);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveModPromoteInfo$Companion;", "", "()V", "genAddPromoteInfoReq", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveModPromoteInfo$FinderLiveModPromoteInfoReq;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAvailableItem;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "genDelPromoteInfoReq", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAnchor;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static q.b a(bkw parambkw, com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      bkx localbkx = null;
      Object localObject = null;
      AppMethodBeat.i(351226);
      s.u(parambkw, "info");
      s.u(parama, "liveData");
      long l1 = ((f)parama.business(f.class)).hKN;
      long l2 = ((f)parama.business(f.class)).liveInfo.liveId;
      switch (parambkw.type)
      {
      case 4: 
      case 5: 
      case 6: 
      default: 
        parambkw = null;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          parambkw = new q.b(l1, l2, 1, parambkw);
          AppMethodBeat.o(351226);
          return parambkw;
          parama = new bdb();
          parama.ZNM = parambkw.type;
          localObject = new bkk();
          parambkw = parambkw.ZTX;
          if (parambkw == null) {}
          for (parambkw = null;; parambkw = parambkw.toByteArray())
          {
            ((bkk)localObject).parseFrom(parambkw);
            parambkw = ah.aiuX;
            parama.ZNN = ((bkk)localObject).hAR;
            parambkw = ah.aiuX;
            parambkw = new b(parama.toByteArray());
            break;
          }
          parama = new bdb();
          parama.ZNM = parambkw.type;
          localbkx = new bkx();
          parambkw = parambkw.ZTX;
          if (parambkw == null) {}
          for (parambkw = (bkw)localObject;; parambkw = parambkw.toByteArray())
          {
            localbkx.parseFrom(parambkw);
            parambkw = ah.aiuX;
            parama.ZNO = localbkx;
            parambkw = ah.aiuX;
            parambkw = new b(parama.toByteArray());
            break;
          }
          parama = new bdb();
          parama.ZNM = parambkw.type;
          parambkw = ah.aiuX;
          parambkw = new b(parama.toByteArray());
        }
      }
      parama = new bdb();
      parama.ZNM = parambkw.type;
      localObject = new bkz();
      parambkw = parambkw.ZTX;
      if (parambkw == null) {}
      for (parambkw = localbkx;; parambkw = parambkw.toByteArray())
      {
        ((bkz)localObject).parseFrom(parambkw);
        parambkw = ah.aiuX;
        parama.ZNP = ((bkz)localObject);
        parambkw = ah.aiuX;
        parambkw = new b(parama.toByteArray());
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveModPromoteInfo$FinderLiveModPromoteInfoReq;", "", "objectId", "", "liveId", "optType", "", "op_cmd_req_buf", "Lcom/tencent/mm/protobuf/ByteString;", "(JJILcom/tencent/mm/protobuf/ByteString;)V", "getLiveId", "()J", "getObjectId", "getOp_cmd_req_buf", "()Lcom/tencent/mm/protobuf/ByteString;", "getOptType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final int CvB;
    final b CvC;
    final long hKN;
    final long liveId;
    
    public b(long paramLong1, long paramLong2, int paramInt, b paramb)
    {
      this.hKN = paramLong1;
      this.liveId = paramLong2;
      this.CvB = paramInt;
      this.CvC = paramb;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(351240);
      if (this == paramObject)
      {
        AppMethodBeat.o(351240);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(351240);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.hKN != paramObject.hKN)
      {
        AppMethodBeat.o(351240);
        return false;
      }
      if (this.liveId != paramObject.liveId)
      {
        AppMethodBeat.o(351240);
        return false;
      }
      if (this.CvB != paramObject.CvB)
      {
        AppMethodBeat.o(351240);
        return false;
      }
      if (!s.p(this.CvC, paramObject.CvC))
      {
        AppMethodBeat.o(351240);
        return false;
      }
      AppMethodBeat.o(351240);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(351232);
      int j = q.a..ExternalSyntheticBackport0.m(this.hKN);
      int k = q.a..ExternalSyntheticBackport0.m(this.liveId);
      int m = this.CvB;
      if (this.CvC == null) {}
      for (int i = 0;; i = this.CvC.hashCode())
      {
        AppMethodBeat.o(351232);
        return i + ((j * 31 + k) * 31 + m) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(351221);
      String str = "FinderLiveModPromoteInfoReq(objectId=" + this.hKN + ", liveId=" + this.liveId + ", optType=" + this.CvB + ", op_cmd_req_buf=" + this.CvC + ')';
      AppMethodBeat.o(351221);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.q
 * JD-Core Version:    0.7.0.1
 */