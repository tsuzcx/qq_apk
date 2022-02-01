package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<bdd, bde>
{
  private final WeakReference<b<k>> oTz;
  public List<String> oYA;
  public List<String> oYB;
  public List<String> oYC;
  
  public k(b<k> paramb)
  {
    AppMethodBeat.i(23530);
    this.oTz = new WeakReference(paramb);
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
      Object localObject1 = (bde)bxu();
      this.oYC = new ArrayList();
      Object localObject2 = ((bde)localObject1).DAF.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        az.arV();
        if (c.apM().aHT(str)) {
          this.oYC.add(str);
        }
      }
      this.oYA = new ArrayList();
      this.oYB = new ArrayList();
      if (((bde)localObject1).Dli != null)
      {
        localObject1 = ((bde)localObject1).Dli.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (amj)((Iterator)localObject1).next();
          if (((amj)localObject2).Dnu) {
            this.oYB.add(((amj)localObject2).username);
          }
          az.arV();
          if (c.apM().aHT(((amj)localObject2).username)) {
            this.oYA.add(((amj)localObject2).username);
          }
        }
      }
      ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.oYB.size()), this.oYB.toString() });
      ad.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.oYA.size()), this.oYA });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.oTz.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */