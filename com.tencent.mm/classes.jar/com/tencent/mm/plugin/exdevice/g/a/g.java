package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.cq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.b.a<cp, cq>
{
  List<String> myI;
  private final WeakReference<b<g>> oTz;
  public ArrayList<amf> oXX;
  
  public g(List<String> paramList, b<g> paramb)
  {
    AppMethodBeat.i(23513);
    this.myI = paramList;
    this.oTz = new WeakReference(paramb);
    AppMethodBeat.o(23513);
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
    AppMethodBeat.i(23514);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      cq localcq = (cq)bxu();
      this.oXX = new ArrayList();
      if (localcq.Cxt != null)
      {
        Iterator localIterator = localcq.Cxt.iterator();
        while (localIterator.hasNext())
        {
          amf localamf = (amf)localIterator.next();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localamf.index), Integer.valueOf(localamf.jzV), localamf.username });
          this.oXX.add(localamf);
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.oXX.toString(), Integer.valueOf(localcq.Cxt.size()) });
      }
      com.tencent.mm.plugin.exdevice.model.ad.bZI().a(this.oXX, "hardcode_rank_id", "hardcode_app_name");
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.oTz.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.g
 * JD-Core Version:    0.7.0.1
 */