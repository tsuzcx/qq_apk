package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends com.tencent.mm.plugin.exdevice.a.a<cb, cc>
{
  List<String> hNO;
  private final WeakReference<b<g>> jto;
  public ArrayList<zh> jxN;
  
  public g(List<String> paramList, b<g> paramb)
  {
    this.hNO = paramList;
    this.jto = new WeakReference(paramb);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      cc localcc = (cc)auJ();
      this.jxN = new ArrayList();
      if (localcc.svE != null)
      {
        Iterator localIterator = localcc.svE.iterator();
        while (localIterator.hasNext())
        {
          zh localzh = (zh)localIterator.next();
          y.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[] { Integer.valueOf(localzh.index), Integer.valueOf(localzh.ghE), localzh.username });
          this.jxN.add(localzh);
        }
        y.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[] { this.jxN.toString(), Integer.valueOf(localcc.svE.size()) });
      }
      ad.aLN().a(this.jxN, "hardcode_rank_id", "hardcode_app_name");
    }
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.jto.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1777;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/addfollow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.g
 * JD-Core Version:    0.7.0.1
 */