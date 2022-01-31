package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.storage.z;
import java.util.LinkedList;

public final class aj
  extends m
  implements k
{
  f callback;
  private int fHY;
  private aj.a muo;
  long mup;
  public boolean muq;
  final com.tencent.mm.ai.b rr;
  
  public aj()
  {
    AppMethodBeat.i(102736);
    this.callback = null;
    this.fHY = 1;
    this.muo = new aj.a(this);
    this.mup = -1L;
    this.muq = false;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync");
    b.a locala = new b.a();
    locala.fsX = new acx();
    locala.fsY = new acy();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.reqCmdId = 195;
    locala.respCmdId = 1000000195;
    locala.fsZ = false;
    this.rr = locala.ado();
    AppMethodBeat.o(102736);
  }
  
  public aj(int paramInt)
  {
    AppMethodBeat.i(102737);
    this.callback = null;
    this.fHY = 1;
    this.muo = new aj.a(this);
    this.mup = -1L;
    this.muq = false;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "NetSceneFavSync %d", new Object[] { Integer.valueOf(paramInt) });
    b.a locala = new b.a();
    locala.fsX = new acx();
    locala.fsY = new acy();
    locala.uri = "/cgi-bin/micromsg-bin/favsync";
    locala.funcId = 400;
    locala.reqCmdId = 195;
    locala.respCmdId = 1000000195;
    locala.fsZ = false;
    this.rr = locala.ado();
    this.fHY = paramInt;
    AppMethodBeat.o(102737);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(102738);
    this.callback = paramf;
    acx localacx = (acx)this.rr.fsV.fta;
    localacx.wFQ = this.fHY;
    paramf = ((ae)g.G(ae.class)).getFavConfigStorage().bwG();
    if (this.fHY == 2) {
      paramf = new byte[0];
    }
    localacx.wFR = aa.ac(paramf);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(102738);
    return i;
  }
  
  public final int getType()
  {
    return 400;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102739);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if (((ae)g.G(ae.class)).getSendService().amw())
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.Fav.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102739);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102739);
      return;
    }
    acy localacy = (acy)((com.tencent.mm.ai.b)paramq).fsW.fta;
    paramArrayOfByte = localacy.wFU.jJv;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Fav.NetSceneFavSync", "cmdList size:" + paramArrayOfByte.size());
      if (this.fHY != 2)
      {
        paramString = this.muo;
        paramString.mcO = paramArrayOfByte;
        if ((paramString.mcO != null) && (paramString.mcO.size() > 0))
        {
          paramq = new ak();
          g.Rc().a(paramq, 0);
        }
        paramString.mur.sendEmptyMessage(0);
        AppMethodBeat.o(102739);
        return;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102739);
      return;
    }
    if (localacy.wFR.getBuffer() != null)
    {
      paramArrayOfByte = localacy.wFR.getBuffer().toByteArray();
      paramq = com.tencent.mm.protocal.ab.j(((acx)((com.tencent.mm.ai.b)paramq).fsV.fta).wFR.getBuffer().toByteArray(), paramArrayOfByte);
      if ((paramq != null) && (paramq.length > 0)) {
        ((ae)g.G(ae.class)).getFavConfigStorage().aW(paramq);
      }
    }
    for (;;)
    {
      g.RL().Ru().set(8217, Integer.valueOf(1));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102739);
      return;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Fav.NetSceneFavSync", "merge key should not be null");
    }
  }
  
  public final int securityLimitCount()
  {
    return 50;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */