package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<asi, asj>
{
  private final WeakReference<b<k>> lCN;
  public List<String> lHQ;
  public List<String> lHR;
  public List<String> lHS;
  
  public k(b<k> paramb)
  {
    AppMethodBeat.i(19462);
    this.lCN = new WeakReference(paramb);
    AppMethodBeat.o(19462);
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
    AppMethodBeat.i(19463);
    ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject1 = (asj)aUl();
      this.lHS = new ArrayList();
      Object localObject2 = ((asj)localObject1).xhB.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        aw.aaz();
        if (c.YA().arr(str)) {
          this.lHS.add(str);
        }
      }
      this.lHQ = new ArrayList();
      this.lHR = new ArrayList();
      if (((asj)localObject1).xhC != null)
      {
        localObject1 = ((asj)localObject1).xhC.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ady)((Iterator)localObject1).next();
          if (((ady)localObject2).wWQ) {
            this.lHR.add(((ady)localObject2).username);
          }
          aw.aaz();
          if (c.YA().arr(((ady)localObject2).username)) {
            this.lHQ.add(((ady)localObject2).username);
          }
        }
      }
      ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.lHR.size()), this.lHR.toString() });
      ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.lHQ.size()), this.lHQ });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.lCN.get();
    if (paramq != null)
    {
      ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
      paramq.a(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(19463);
      return;
    }
    ab.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    AppMethodBeat.o(19463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.k
 * JD-Core Version:    0.7.0.1
 */