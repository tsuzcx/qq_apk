package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements i
{
  public final void a(final List<String> paramList, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(148649);
    paramList = new ArrayList(paramList);
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148648);
        Object localObject1 = new LinkedList();
        Object localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((LinkedList)localObject1).add(new dqi().bhy((String)localObject3));
          Log.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", new Object[] { localObject3 });
        }
        localObject2 = new dqi().bhy(paramString1);
        Object localObject3 = new dqi().bhy(paramString2);
        g.azz().a(228, b.this);
        localObject1 = new a(((LinkedList)localObject1).size(), (LinkedList)localObject1, (dqi)localObject2, (dqi)localObject3);
        int i = this.gsA;
        if (((a)localObject1).jxM != null) {
          ((a)localObject1).jxM.Scene = i;
        }
        g.azz().a((q)localObject1, 0);
        AppMethodBeat.o(148648);
      }
    });
    AppMethodBeat.o(148649);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(148650);
    g.azz().b(228, this);
    if ((paramq instanceof a)) {
      Log.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(148650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.b
 * JD-Core Version:    0.7.0.1
 */