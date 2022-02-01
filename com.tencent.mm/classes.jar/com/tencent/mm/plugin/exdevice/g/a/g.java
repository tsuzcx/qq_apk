package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.b.a<db, dc>
{
  List<String> oRy;
  public ArrayList<bes> rCn;
  private final WeakReference<b<g>> rxQ;
  
  public g(List<String> paramList, b<g> paramb)
  {
    AppMethodBeat.i(23513);
    this.oRy = paramList;
    this.rxQ = new WeakReference(paramb);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23514);
    Log.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      dc localdc = (dc)cgq();
      this.rCn = new ArrayList();
      if (localdc.KHh != null)
      {
        Iterator localIterator = localdc.KHh.iterator();
        while (localIterator.hasNext())
        {
          bes localbes = (bes)localIterator.next();
          Log.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localbes.index), Integer.valueOf(localbes.lCq), localbes.username });
          this.rCn.add(localbes);
        }
        Log.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.rCn.toString(), Integer.valueOf(localdc.KHh.size()) });
      }
      ad.cKN().a(this.rCn, "hardcode_rank_id", "hardcode_app_name");
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if (this.rxQ != null)
    {
      params = (b)this.rxQ.get();
      if (params != null) {
        params.a(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(23514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.g
 * JD-Core Version:    0.7.0.1
 */