package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import java.util.Collection;
import java.util.LinkedList;

final class aj$a$1
  extends ak
{
  aj$a$1(aj.a parama, String paramString)
  {
    super(paramString);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(102734);
    if ((this.mut.mcO == null) || (this.mut.mcO.isEmpty()))
    {
      aj localaj = this.mut.mus;
      paramMessage = (acx)localaj.rr.fsV.fta;
      localObject = (acy)localaj.rr.fsW.fta;
      byte[] arrayOfByte = ((acy)localObject).wFR.getBuffer().toByteArray();
      arrayOfByte = com.tencent.mm.protocal.ab.j(paramMessage.wFR.getBuffer().toByteArray(), arrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavConfigStorage().aW(arrayOfByte);
      }
      paramMessage.wFR = aa.ac(arrayOfByte);
      i = ((acy)localObject).wBX;
      if ((paramMessage.wFQ & i) == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[] { Long.valueOf(localaj.mup) });
        com.tencent.mm.kernel.g.RL().Ru().set(8217, Integer.valueOf(1));
        if (localaj.mup > 0L)
        {
          localObject = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().x(localaj.mup, -1);
          if (((LinkedList)localObject).size() > 0)
          {
            paramMessage = (Message)localObject;
            if (((LinkedList)localObject).size() > 40)
            {
              localObject = ((LinkedList)localObject).subList(0, 40);
              paramMessage = new LinkedList();
              paramMessage.addAll((Collection)localObject);
            }
            localaj.muq = true;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[] { Integer.valueOf(paramMessage.size()) });
            paramMessage = new ah(paramMessage);
            if (!com.tencent.mm.kernel.g.Rc().a(paramMessage, 0))
            {
              com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
              ah.bwV();
            }
          }
        }
        localaj.callback.onSceneEnd(0, 0, "", localaj);
        AppMethodBeat.o(102734);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[] { Integer.valueOf(((acy)localObject).wBX) });
      localaj.doScene(localaj.dispatcher(), localaj.callback);
      AppMethodBeat.o(102734);
      return;
    }
    paramMessage = (ud)this.mut.mcO.getFirst();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + paramMessage.wMC);
    this.mut.mcO.removeFirst();
    switch (paramMessage.wMC)
    {
    default: 
      AppMethodBeat.o(102734);
      return;
    }
    Object localObject = aa.a(paramMessage.wMD);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
      sendEmptyMessage(0);
      AppMethodBeat.o(102734);
      return;
    }
    paramMessage = this.mut.mus;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        i = localObject.length;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "processAddItem bufSize=%d", new Object[] { Integer.valueOf(i) });
        localObject = (cg)new cg().parseFrom((byte[])localObject);
        if (localObject != null) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
      }
      catch (Exception paramMessage)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", paramMessage, "", new Object[0]);
        continue;
        if ((paramMessage.mup >= 0L) && (((cg)localObject).woF >= paramMessage.mup)) {
          continue;
        }
        paramMessage.mup = ((cg)localObject).woF;
        paramMessage = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(((cg)localObject).woD);
        if (paramMessage != null) {
          break label883;
        }
      }
      sendEmptyMessage(0);
      break;
      i = 0;
      continue;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[] { Integer.valueOf(((cg)localObject).woD), Integer.valueOf(((cg)localObject).woE), Integer.valueOf(((cg)localObject).woG), Integer.valueOf(((cg)localObject).woF) });
      if ((((cg)localObject).woE & 0x1) != 0)
      {
        b.a(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(((cg)localObject).woD), false, null);
      }
      else
      {
        paramMessage = new g();
        paramMessage.field_updateTime = (((cg)localObject).woF * 1000L);
      }
    }
    label883:
    for (int i = 1;; i = 0)
    {
      paramMessage.field_id = ((cg)localObject).woD;
      paramMessage.field_updateSeq = ((cg)localObject).woG;
      if (paramMessage.field_localSeq == ((cg)localObject).woG) {
        paramMessage.field_updateTime = (((cg)localObject).woF * 1000L);
      }
      paramMessage.field_flag = ((cg)localObject).woE;
      paramMessage.field_type = ((cg)localObject).jKs;
      if (i != 0)
      {
        paramMessage.field_localId = System.currentTimeMillis();
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().y(paramMessage);
        break;
      }
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(paramMessage, new String[] { "localId" });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj.a.1
 * JD-Core Version:    0.7.0.1
 */