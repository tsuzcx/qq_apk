package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<bgv, bgw>
{
  public List<String> pBL;
  public List<String> pBM;
  public List<String> pBN;
  private final WeakReference<b<k>> pwK;
  
  public k(b<k> paramb)
  {
    AppMethodBeat.i(23530);
    this.pwK = new WeakReference(paramb);
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
    ac.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject1 = (bgw)bEq();
      this.pBN = new ArrayList();
      Object localObject2 = ((bgw)localObject1).EWb.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        az.ayM();
        if (c.awB().aNo(str)) {
          this.pBN.add(str);
        }
      }
      this.pBL = new ArrayList();
      this.pBM = new ArrayList();
      if (((bgw)localObject1).EEx != null)
      {
        localObject1 = ((bgw)localObject1).EEx.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (apm)((Iterator)localObject1).next();
          if (((apm)localObject2).EIu) {
            this.pBM.add(((apm)localObject2).username);
          }
          az.ayM();
          if (c.awB().aNo(((apm)localObject2).username)) {
            this.pBL.add(((apm)localObject2).username);
          }
        }
      }
      ac.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.pBM.size()), this.pBM.toString() });
      ac.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.pBL.size()), this.pBL });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.pwK.get();
    if (paramq != null)
    {
      ac.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
      paramq.a(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23531);
      return;
    }
    ac.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    AppMethodBeat.o(23531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */