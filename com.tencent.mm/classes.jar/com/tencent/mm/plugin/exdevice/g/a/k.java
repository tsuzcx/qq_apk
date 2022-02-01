package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<bld, ble>
{
  private final WeakReference<b<k>> qap;
  public List<String> qfq;
  public List<String> qfr;
  public List<String> qfs;
  
  public k(b<k> paramb)
  {
    AppMethodBeat.i(23530);
    this.qap = new WeakReference(paramb);
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
    ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject1 = (ble)bIz();
      this.qfs = new ArrayList();
      Object localObject2 = ((ble)localObject1).GFy.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ba.aBQ();
        if (c.azp().aTg(str)) {
          this.qfs.add(str);
        }
      }
      this.qfq = new ArrayList();
      this.qfr = new ArrayList();
      if (((ble)localObject1).Gmo != null)
      {
        localObject1 = ((ble)localObject1).Gmo.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (atg)((Iterator)localObject1).next();
          if (((atg)localObject2).Grl) {
            this.qfr.add(((atg)localObject2).username);
          }
          ba.aBQ();
          if (c.azp().aTg(((atg)localObject2).username)) {
            this.qfq.add(((atg)localObject2).username);
          }
        }
      }
      ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.qfr.size()), this.qfr.toString() });
      ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.qfq.size()), this.qfq });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.qap.get();
    if (paramq != null)
    {
      ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
      paramq.a(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23531);
      return;
    }
    ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    AppMethodBeat.o(23531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */