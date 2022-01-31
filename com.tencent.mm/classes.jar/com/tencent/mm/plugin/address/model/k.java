package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.d;
import com.tencent.mm.h.a.mp;
import com.tencent.mm.h.a.mp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class k
  extends c<mp>
  implements com.tencent.mm.ah.f
{
  private mp fto;
  private d ftp;
  
  public k()
  {
    this.udX = mp.class.getName().hashCode();
  }
  
  private void B(int paramInt, boolean paramBoolean)
  {
    y.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.fto.bWa.errCode = paramInt;
    if (paramInt != 0) {
      this.fto.bWa.bWb = false;
    }
    for (;;)
    {
      if (this.fto.bFJ != null) {
        this.fto.bFJ.run();
      }
      au.Dk().b(417, this);
      return;
      Object localObject;
      if (!paramBoolean)
      {
        localObject = this.ftp;
        if (localObject != null)
        {
          ((d)localObject).field_brandFlag &= 0xFFFFFFF7;
          com.tencent.mm.ai.f.g((d)localObject);
        }
        this.fto.bWa.bWb = false;
      }
      else
      {
        localObject = this.ftp;
        if (localObject != null)
        {
          ((d)localObject).field_brandFlag |= 0x8;
          com.tencent.mm.ai.f.g((d)localObject);
        }
        this.fto.bWa.bWb = true;
        com.tencent.mm.plugin.address.a.a.YB();
        localObject = com.tencent.mm.plugin.address.a.a.YD().fts;
        if (((com.tencent.mm.plugin.address.d.a)localObject).ftA.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).ftA.getFirst();
          this.fto.bWa.bWc = ((b)localObject).ftJ;
          this.fto.bWa.userName = ((b)localObject).ftH;
          this.fto.bWa.bWd = ((b)localObject).ftI;
          this.fto.bWa.bWe = ((b)localObject).ftF;
          this.fto.bWa.bWf = ((b)localObject).ftC;
          this.fto.bWa.bWg = ((b)localObject).ftD;
          this.fto.bWa.bWh = ((b)localObject).ftE;
          this.fto.bWa.bWi = ((b)localObject).ftG;
        }
      }
    }
  }
  
  private boolean a(mp parammp)
  {
    if ((parammp instanceof mp))
    {
      this.fto = parammp;
      au.Dk().a(417, this);
      parammp = new e(this.fto.bVZ.url, this.fto.bVZ.appId, 1);
      au.Dk().a(parammp, 0);
    }
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof e))
    {
      if (paramInt2 == 0) {
        B(paramInt2, true);
      }
    }
    else {
      return;
    }
    B(paramInt2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */