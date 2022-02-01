package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.s;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class j
  implements i
{
  public j()
  {
    AppMethodBeat.i(150802);
    g.aAg().hqi.a(159, this);
    g.aAg().hqi.a(160, this);
    n localn = new n(5);
    g.aAg().hqi.a(localn, 0);
    AppMethodBeat.o(150802);
  }
  
  private static void bep()
  {
    AppMethodBeat.i(150805);
    g.aAh().azQ().set(81939, Long.valueOf(Util.nowMilliSecond()));
    AppMethodBeat.o(150805);
  }
  
  private void release()
  {
    AppMethodBeat.i(150803);
    g.aAg().hqi.b(159, this);
    g.aAg().hqi.b(160, this);
    AppMethodBeat.o(150803);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(150804);
    if ((!(paramq instanceof s)) || (((s)paramq).aYR() != 5))
    {
      Log.d("MicroMsg.LangPackageUpdater", "another scene");
      AppMethodBeat.o(150804);
      return;
    }
    int i = paramq.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bep();
        paramString = v.bev().tJ(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          Log.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = paramString[0];
        Log.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.dMe);
        if (5 != paramString.status)
        {
          release();
          AppMethodBeat.o(150804);
          return;
        }
        paramString = new m(paramString.id, 5);
        g.aAg().hqi.a(paramString, 0);
        AppMethodBeat.o(150804);
        return;
      }
      release();
      AppMethodBeat.o(150804);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        bep();
      }
      release();
    }
    AppMethodBeat.o(150804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.j
 * JD-Core Version:    0.7.0.1
 */