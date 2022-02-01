package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends a<byg, byh>
{
  public List<String> rCR;
  public List<String> rCS;
  public List<String> rCT;
  private final WeakReference<b<l>> rxQ;
  
  public l()
  {
    AppMethodBeat.i(231696);
    this.rxQ = new WeakReference(null);
    AppMethodBeat.o(231696);
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
      Object localObject1 = (byh)cgq();
      this.rCT = new ArrayList();
      Object localObject2 = ((byh)localObject1).MdS.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        bg.aVF();
        if (c.aSN().bjG(str)) {
          this.rCT.add(str);
        }
      }
      this.rCR = new ArrayList();
      this.rCS = new ArrayList();
      if (((byh)localObject1).LCY != null)
      {
        localObject1 = ((byh)localObject1).LCY.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bew)((Iterator)localObject1).next();
          if (((bew)localObject2).tOS) {
            this.rCS.add(((bew)localObject2).username);
          }
          bg.aVF();
          if (c.aSN().bjG(((bew)localObject2).username)) {
            this.rCR.add(((bew)localObject2).username);
          }
        }
      }
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.rCS.size()), this.rCS.toString() });
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.rCR.size()), this.rCR });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if (this.rxQ != null)
    {
      params = (b)this.rxQ.get();
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