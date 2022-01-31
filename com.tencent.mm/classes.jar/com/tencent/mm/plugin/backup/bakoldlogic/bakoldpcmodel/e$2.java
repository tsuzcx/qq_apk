package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  implements f
{
  e$2(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17841);
    paramString = (b)paramm;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(17841);
      return;
    }
    if (paramm.getType() == 3)
    {
      paramString = (ac)paramString.aUl();
      if (paramString.jJg == 2)
      {
        Object localObject = paramString.jKM;
        paramm = new e.2.1(this, (r)localObject);
        e.2.2 local2 = new e.2.2(this);
        paramString = this.jHN;
        localObject = ((r)localObject).ID;
        ab.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", new Object[] { localObject });
        paramm = new e.3(paramString, paramm, local2);
        aw.Rc().a(596, paramm);
        if (paramString.jHF != null) {
          paramString.jHF.cancel();
        }
        paramString.jHF = new com.tencent.mm.plugin.backup.bakoldlogic.c.e((String)localObject);
        aw.Rc().a(paramString.jHF, 0);
      }
    }
    b.b(3, this);
    AppMethodBeat.o(17841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.2
 * JD-Core Version:    0.7.0.1
 */