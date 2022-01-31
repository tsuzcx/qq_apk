package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements f
{
  e$2(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = (b)paramm;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    if (paramm.getType() == 3)
    {
      paramString = (ac)paramString.auJ();
      if (paramString.hPE == 2)
      {
        Object localObject = paramString.hRl;
        paramm = new Runnable()
        {
          public final void run()
          {
            e.2.this.hOl.a(this.hOm);
          }
        };
        e.2.2 local2 = new e.2.2(this);
        paramString = this.hOl;
        localObject = ((r)localObject).ID;
        y.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", new Object[] { localObject });
        paramm = new e.3(paramString, paramm, local2);
        au.Dk().a(596, paramm);
        if (paramString.hOd != null) {
          paramString.hOd.cancel();
        }
        paramString.hOd = new com.tencent.mm.plugin.backup.bakoldlogic.c.e((String)localObject);
        au.Dk().a(paramString.hOd, 0);
      }
    }
    b.b(3, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.2
 * JD-Core Version:    0.7.0.1
 */