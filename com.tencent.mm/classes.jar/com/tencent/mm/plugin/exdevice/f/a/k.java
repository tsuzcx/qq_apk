package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.protocal.c.zj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends a<amt, amu>
{
  private final WeakReference<b<k>> jto;
  public List<String> jyr;
  public List<String> jys;
  public List<String> jyt;
  
  public k(b<k> paramb)
  {
    this.jto = new WeakReference(paramb);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Object localObject1 = (amu)auJ();
      this.jyt = new ArrayList();
      Object localObject2 = ((amu)localObject1).tiP.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        au.Hx();
        if (c.Fw().abg(str)) {
          this.jyt.add(str);
        }
      }
      this.jyr = new ArrayList();
      this.jys = new ArrayList();
      if (((amu)localObject1).tiQ != null)
      {
        localObject1 = ((amu)localObject1).tiQ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (zj)((Iterator)localObject1).next();
          if (((zj)localObject2).sYI) {
            this.jys.add(((zj)localObject2).username);
          }
          au.Hx();
          if (c.Fw().abg(((zj)localObject2).username)) {
            this.jyr.add(((zj)localObject2).username);
          }
        }
      }
      y.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[] { Integer.valueOf(this.jys.size()), this.jys.toString() });
      y.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[] { Integer.valueOf(this.jyr.size()), this.jyr });
    }
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.jto.get();
    if (paramq != null)
    {
      y.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
      paramq.a(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
  }
  
  public final int getType()
  {
    return 1758;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.k
 * JD-Core Version:    0.7.0.1
 */