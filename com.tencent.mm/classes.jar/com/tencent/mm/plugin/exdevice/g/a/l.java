package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends a<cga, cgb>
{
  private final WeakReference<b<l>> vdw;
  public List<String> viB;
  public List<String> viC;
  public List<String> viD;
  
  public l()
  {
    AppMethodBeat.i(237520);
    this.vdw = new WeakReference(null);
    AppMethodBeat.o(237520);
  }
  
  public final int getType()
  {
    return 1758;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23531);
    Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject1 = (cgb)ctC();
      this.viD = new ArrayList();
      Object localObject2 = ((cgb)localObject1).Tnt.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        bh.beI();
        if (c.bbL().bwd(str)) {
          this.viD.add(str);
        }
      }
      this.viB = new ArrayList();
      this.viC = new ArrayList();
      if (((cgb)localObject1).SGk != null)
      {
        localObject1 = ((cgb)localObject1).SGk.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bma)((Iterator)localObject1).next();
          if (((bma)localObject2).xzE) {
            this.viC.add(((bma)localObject2).username);
          }
          bh.beI();
          if (c.bbL().bwd(((bma)localObject2).username)) {
            this.viB.add(((bma)localObject2).username);
          }
        }
      }
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.viC.size()), this.viC.toString() });
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.viB.size()), this.viB });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if (this.vdw != null)
    {
      params = (b)this.vdw.get();
      if (params != null)
      {
        Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
        params.a(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23531);
        return;
      }
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }
    AppMethodBeat.o(23531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.l
 * JD-Core Version:    0.7.0.1
 */