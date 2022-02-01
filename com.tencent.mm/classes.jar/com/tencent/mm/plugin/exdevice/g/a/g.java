package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.b.a<cy, cz>
{
  List<String> rTx;
  private final WeakReference<b<g>> vdw;
  public ArrayList<blw> vhV;
  
  public g(List<String> paramList, b<g> paramb)
  {
    AppMethodBeat.i(23513);
    this.rTx = paramList;
    this.vdw = new WeakReference(paramb);
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
      cz localcz = (cz)ctC();
      this.vhV = new ArrayList();
      if (localcz.RIz != null)
      {
        Iterator localIterator = localcz.RIz.iterator();
        while (localIterator.hasNext())
        {
          blw localblw = (blw)localIterator.next();
          Log.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localblw.index), Integer.valueOf(localblw.oxQ), localblw.username });
          this.vhV.add(localblw);
        }
        Log.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.vhV.toString(), Integer.valueOf(localcz.RIz.size()) });
      }
      ae.cZA().a(this.vhV, "hardcode_rank_id", "hardcode_app_name");
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if (this.vdw != null)
    {
      params = (b)this.vdw.get();
      if (params != null) {
        params.a(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(23514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.g
 * JD-Core Version:    0.7.0.1
 */