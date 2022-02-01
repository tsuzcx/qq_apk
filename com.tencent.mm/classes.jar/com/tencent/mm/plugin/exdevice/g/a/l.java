package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends a<cwd, cwe>
{
  private final WeakReference<b<l>> ypi;
  public List<String> yuA;
  public List<String> yuB;
  public List<String> yuC;
  
  public l()
  {
    AppMethodBeat.i(274562);
    this.ypi = new WeakReference(null);
    AppMethodBeat.o(274562);
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
      Object localObject1 = (cwe)cWm();
      this.yuC = new ArrayList();
      Object localObject2 = ((cwe)localObject1).aaBz.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        bh.bCz();
        if (c.bzA().bxr(str)) {
          this.yuC.add(str);
        }
      }
      this.yuA = new ArrayList();
      this.yuB = new ArrayList();
      if (((cwe)localObject1).ZIU != null)
      {
        localObject1 = ((cwe)localObject1).ZIU.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bzs)((Iterator)localObject1).next();
          if (((bzs)localObject2).AXf) {
            this.yuB.add(((bzs)localObject2).username);
          }
          bh.bCz();
          if (c.bzA().bxr(((bzs)localObject2).username)) {
            this.yuA.add(((bzs)localObject2).username);
          }
        }
      }
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.yuB.size()), this.yuB.toString() });
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.yuA.size()), this.yuA });
    }
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, params, paramArrayOfByte);
    if (this.ypi != null)
    {
      params = (b)this.ypi.get();
      if (params != null)
      {
        Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
        params.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(23531);
        return;
      }
      Log.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }
    AppMethodBeat.o(23531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.l
 * JD-Core Version:    0.7.0.1
 */