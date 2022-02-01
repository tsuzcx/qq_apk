package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends p
  implements m
{
  private h callback;
  private int lXD;
  private final com.tencent.mm.am.c rr;
  
  public r(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112808);
    this.lXD = 0;
    c.a locala = new c.a();
    locala.otE = new kg();
    locala.otF = new kh();
    locala.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
    locala.funcId = 1077;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((kg)c.b.b(this.rr.otB)).YMu = paramLinkedList;
    AppMethodBeat.o(112808);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112809);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112809);
    return i;
  }
  
  public final int getType()
  {
    return 1077;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112810);
    Log.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = ((kh)c.c.b(this.rr.otC)).YMv;
      if (params != null) {
        break label121;
      }
      paramInt1 = 0;
      Log.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, resp list count = %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((params != null) && (params.size() != 0)) {
        break label130;
      }
      Log.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112810);
      return;
      label121:
      paramInt1 = params.size();
      break;
      label130:
      this.lXD = 0;
      params = params.iterator();
      label250:
      while (params.hasNext())
      {
        paramArrayOfByte = (String)params.next();
        boolean bool;
        if (TextUtils.isEmpty(paramArrayOfByte))
        {
          Log.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
          bool = false;
        }
        for (;;)
        {
          if (bool) {
            break label250;
          }
          this.lXD += 1;
          break;
          CardInfo localCardInfo = new CardInfo();
          localCardInfo.field_card_id = paramArrayOfByte;
          bool = am.dkJ().delete(localCardInfo, new String[0]);
          Log.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
      Log.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[] { Integer.valueOf(this.lXD) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.r
 * JD-Core Version:    0.7.0.1
 */