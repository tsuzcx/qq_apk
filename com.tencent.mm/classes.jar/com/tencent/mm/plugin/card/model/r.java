package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends n
  implements k
{
  private f callback;
  private int gex;
  private final b rr;
  
  public r(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112808);
    this.gex = 0;
    b.a locala = new b.a();
    locala.hQF = new jf();
    locala.hQG = new jg();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
    locala.funcId = 1077;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((jf)this.rr.hQD.hQJ).FUC = paramLinkedList;
    AppMethodBeat.o(112808);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112809);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112809);
    return i;
  }
  
  public final int getType()
  {
    return 1077;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112810);
    ae.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((jg)this.rr.hQE.hQJ).FUD;
      if (paramq != null) {
        break label121;
      }
      paramInt1 = 0;
      ae.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, resp list count = %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramq != null) && (paramq.size() != 0)) {
        break label130;
      }
      ae.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112810);
      return;
      label121:
      paramInt1 = paramq.size();
      break;
      label130:
      this.gex = 0;
      paramq = paramq.iterator();
      label250:
      while (paramq.hasNext())
      {
        paramArrayOfByte = (String)paramq.next();
        boolean bool;
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          ae.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
          bool = false;
        }
        for (;;)
        {
          if (bool) {
            break label250;
          }
          this.gex += 1;
          break;
          CardInfo localCardInfo = new CardInfo();
          localCardInfo.field_card_id = paramArrayOfByte;
          bool = am.bWc().delete(localCardInfo, new String[0]);
          ae.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
      ae.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[] { Integer.valueOf(this.gex) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.r
 * JD-Core Version:    0.7.0.1
 */