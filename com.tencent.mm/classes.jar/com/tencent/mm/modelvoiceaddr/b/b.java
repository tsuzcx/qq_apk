package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.am.h
{
  public final void a(final List<String> paramList, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(148649);
    paramList = new ArrayList(paramList);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148648);
        Object localObject1 = new LinkedList();
        Object localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((LinkedList)localObject1).add(new etl().btH((String)localObject3));
          Log.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", new Object[] { localObject3 });
        }
        localObject2 = new etl().btH(paramString1);
        Object localObject3 = new etl().btH(paramString2);
        com.tencent.mm.kernel.h.aZW().a(228, b.this);
        localObject1 = new a(((LinkedList)localObject1).size(), (LinkedList)localObject1, (etl)localObject2, (etl)localObject3);
        int i = this.lyQ;
        if (((a)localObject1).phb != null) {
          ((a)localObject1).phb.IJG = i;
        }
        com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
        AppMethodBeat.o(148648);
      }
    });
    AppMethodBeat.o(148649);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(148650);
    com.tencent.mm.kernel.h.aZW().b(228, this);
    if ((paramp instanceof a)) {
      Log.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(148650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.b
 * JD-Core Version:    0.7.0.1
 */