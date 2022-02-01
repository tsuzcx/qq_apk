package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.b.a<cr, cs>
{
  List<String> naJ;
  public ArrayList<api> pBi;
  private final WeakReference<b<g>> pwK;
  
  public g(List<String> paramList, b<g> paramb)
  {
    AppMethodBeat.i(23513);
    this.naJ = paramList;
    this.pwK = new WeakReference(paramb);
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
    ac.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      cs localcs = (cs)bEq();
      this.pBi = new ArrayList();
      if (localcs.DPP != null)
      {
        Iterator localIterator = localcs.DPP.iterator();
        while (localIterator.hasNext())
        {
          api localapi = (api)localIterator.next();
          ac.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localapi.index), Integer.valueOf(localapi.kar), localapi.username });
          this.pBi.add(localapi);
        }
        ac.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.pBi.toString(), Integer.valueOf(localcs.DPP.size()) });
      }
      ad.cgR().a(this.pBi, "hardcode_rank_id", "hardcode_app_name");
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.pwK.get();
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