package com.tencent.mm.az;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class i
  implements f
{
  public i()
  {
    g.DO().dJT.a(159, this);
    g.DO().dJT.a(160, this);
    k localk = new k(5);
    g.DO().dJT.a(localk, 0);
  }
  
  private static void PF()
  {
    g.DP().Dz().o(81939, Long.valueOf(bk.UY()));
  }
  
  private void release()
  {
    g.DO().dJT.b(159, this);
    g.DO().dJT.b(160, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((!(paramm instanceof o)) || (((o)paramm).KF() != 5)) {
      y.d("MicroMsg.LangPackageUpdater", "another scene");
    }
    int i;
    do
    {
      return;
      i = paramm.getType();
      if (i == 159)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          PF();
          paramString = r.PK().ja(5);
          if ((paramString == null) || (paramString.length == 0))
          {
            y.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
            release();
            return;
          }
          paramString = paramString[0];
          y.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.bOa);
          if (5 != paramString.status)
          {
            release();
            return;
          }
          paramString = new j(paramString.id, 5);
          g.DO().dJT.a(paramString, 0);
          return;
        }
        release();
        return;
      }
    } while (i != 160);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      PF();
    }
    release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.az.i
 * JD-Core Version:    0.7.0.1
 */