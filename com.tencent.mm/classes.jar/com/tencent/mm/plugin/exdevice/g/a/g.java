package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.b.a<di, dj>
{
  List<String> veN;
  private final WeakReference<b<g>> ypi;
  public ArrayList<bzo> ytW;
  
  public g(List<String> paramList, b<g> paramb)
  {
    AppMethodBeat.i(23513);
    this.veN = paramList;
    this.ypi = new WeakReference(paramb);
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
      dj localdj = (dj)cWm();
      this.ytW = new ArrayList();
      if (localdj.YFB != null)
      {
        Iterator localIterator = localdj.YFB.iterator();
        while (localIterator.hasNext())
        {
          bzo localbzo = (bzo)localIterator.next();
          Log.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localbzo.index), Integer.valueOf(localbzo.rBp), localbzo.username });
          this.ytW.add(localbzo);
        }
        Log.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.ytW.toString(), Integer.valueOf(localdj.YFB.size()) });
      }
      ah.dFT().a(this.ytW, "hardcode_rank_id", "hardcode_app_name");
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if (this.ypi != null)
    {
      params = (b)this.ypi.get();
      if (params != null) {
        params.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
      }
    }
    AppMethodBeat.o(23514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.g
 * JD-Core Version:    0.7.0.1
 */