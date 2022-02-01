package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends n
  implements k
{
  private g callback;
  private int fIO;
  private final b rr;
  
  public r(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112808);
    this.fIO = 0;
    b.a locala = new b.a();
    locala.hvt = new iw();
    locala.hvu = new ix();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
    locala.funcId = 1077;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((iw)this.rr.hvr.hvw).DWL = paramLinkedList;
    AppMethodBeat.o(112808);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112809);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((ix)this.rr.hvs.hvw).DWM;
      if (paramq != null) {
        break label121;
      }
      paramInt1 = 0;
      ac.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, resp list count = %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramq != null) && (paramq.size() != 0)) {
        break label130;
      }
      ac.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
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
      this.fIO = 0;
      paramq = paramq.iterator();
      label250:
      while (paramq.hasNext())
      {
        paramArrayOfByte = (String)paramq.next();
        boolean bool;
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          ac.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
          bool = false;
        }
        for (;;)
        {
          if (bool) {
            break label250;
          }
          this.fIO += 1;
          break;
          CardInfo localCardInfo = new CardInfo();
          localCardInfo.field_card_id = paramArrayOfByte;
          bool = am.bQi().delete(localCardInfo, new String[0]);
          ac.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
      ac.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[] { Integer.valueOf(this.fIO) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.r
 * JD-Core Version:    0.7.0.1
 */