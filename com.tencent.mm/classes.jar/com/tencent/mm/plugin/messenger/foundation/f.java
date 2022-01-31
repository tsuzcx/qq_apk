package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ck.c;
import com.tencent.mm.modelmulti.o.c;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.r.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class f
  implements com.tencent.mm.plugin.zero.a.f
{
  private t mcY;
  
  public final void a(qv paramqv, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    r localr = r.a.tD(paramqv.sOA);
    if (localr != null) {
      try
      {
        localr.a(paramqv, paramArrayOfByte, paramBoolean, this.mcY);
        return;
      }
      catch (IOException paramqv)
      {
        y.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + paramqv.getMessage());
        throw new RuntimeException("docmd: parse protobuf error");
      }
    }
    y.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", new Object[] { Integer.valueOf(paramqv.sOA) });
  }
  
  public final void bp(Object paramObject)
  {
    c localc = u.bhQ();
    if (localc != null) {
      this.mcY = ((t)localc.get());
    }
    if (this.mcY == null) {
      this.mcY = new f.a((byte)0);
    }
    if ((paramObject instanceof com.tencent.mm.modelmulti.j))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hv(((com.tencent.mm.modelmulti.j)paramObject).TAG);
      ((h)com.tencent.mm.kernel.g.r(h.class)).Bw();
    }
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof String)) {
          break;
        }
      } while (!paramObject.equals("NetSceneInit"));
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hv((String)paramObject);
      ((h)com.tencent.mm.kernel.g.r(h.class)).Bw();
      return;
    } while (!(paramObject instanceof o.c));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hv(paramObject.toString());
    ((h)com.tencent.mm.kernel.g.r(h.class)).Bw();
  }
  
  public final void bq(Object paramObject)
  {
    if ((paramObject instanceof com.tencent.mm.modelmulti.j))
    {
      this.mcY.bhP();
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hw(((com.tencent.mm.modelmulti.j)paramObject).TAG);
      ai localai = com.tencent.mm.kernel.g.DS();
      String str = ((com.tencent.mm.modelmulti.j)paramObject).TAG;
      p localp = ((com.tencent.mm.modelmulti.j)paramObject).esZ;
      paramObject = (com.tencent.mm.modelmulti.j)paramObject;
      if ((paramObject.eth == null) || (paramObject.eth.sqj.sIl == null))
      {
        paramObject = null;
        localai.O(new f.b(str, localp, paramObject));
        ((h)com.tencent.mm.kernel.g.r(h.class)).Bx();
      }
    }
    do
    {
      return;
      paramObject = paramObject.eth.sqj.sIl.hPT;
      break;
      if (((paramObject instanceof String)) && (paramObject.equals("NetSceneInit")))
      {
        this.mcY.bhP();
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hw((String)paramObject);
        ((h)com.tencent.mm.kernel.g.r(h.class)).Bx();
        return;
      }
    } while (!(paramObject instanceof o.c));
    this.mcY.bhP();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hw(paramObject.toString());
    ((h)com.tencent.mm.kernel.g.r(h.class)).Bx();
  }
  
  public final void br(Object paramObject)
  {
    if ((paramObject instanceof com.tencent.mm.modelmulti.j)) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().Hw(((com.tencent.mm.modelmulti.j)paramObject).TAG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.f
 * JD-Core Version:    0.7.0.1
 */