package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<blv, blw>
{
  private final WeakReference<b<k>> qgU;
  public List<String> qlV;
  public List<String> qlW;
  public List<String> qlX;
  
  public k(b<k> paramb)
  {
    AppMethodBeat.i(23530);
    this.qgU = new WeakReference(paramb);
    AppMethodBeat.o(23530);
  }
  
  public final int getType()
  {
    return 1758;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23531);
    ae.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject1 = (blw)bJx();
      this.qlX = new ArrayList();
      Object localObject2 = ((blw)localObject1).GZa.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        bc.aCg();
        if (c.azF().aUH(str)) {
          this.qlX.add(str);
        }
      }
      this.qlV = new ArrayList();
      this.qlW = new ArrayList();
      if (((blw)localObject1).GFw != null)
      {
        localObject1 = ((blw)localObject1).GFw.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (atw)((Iterator)localObject1).next();
          if (((atw)localObject2).GKJ) {
            this.qlW.add(((atw)localObject2).username);
          }
          bc.aCg();
          if (c.azF().aUH(((atw)localObject2).username)) {
            this.qlV.add(((atw)localObject2).username);
          }
        }
      }
      ae.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.qlW.size()), this.qlW.toString() });
      ae.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.qlV.size()), this.qlV });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.qgU.get();
    if (paramq != null)
    {
      ae.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
      paramq.a(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23531);
      return;
    }
    ae.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    AppMethodBeat.o(23531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */