package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.a.a<cj, ck>
{
  List<String> jHq;
  private final WeakReference<b<g>> lCN;
  public ArrayList<adu> lHm;
  
  public g(List<String> paramList, b<g> paramb)
  {
    AppMethodBeat.i(19445);
    this.jHq = paramList;
    this.lCN = new WeakReference(paramb);
    AppMethodBeat.o(19445);
  }
  
  public final int getType()
  {
    return 1777;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/addfollow";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19446);
    ab.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ck localck = (ck)aUl();
      this.lHm = new ArrayList();
      if (localck.woL != null)
      {
        Iterator localIterator = localck.woL.iterator();
        while (localIterator.hasNext())
        {
          adu localadu = (adu)localIterator.next();
          ab.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localadu.index), Integer.valueOf(localadu.hAu), localadu.username });
          this.lHm.add(localadu);
        }
        ab.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.lHm.toString(), Integer.valueOf(localck.woL.size()) });
      }
      ad.bqa().a(this.lHm, "hardcode_rank_id", "hardcode_app_name");
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.lCN.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(19446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.g
 * JD-Core Version:    0.7.0.1
 */