package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asg;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class g
  extends m
  implements k
{
  private f callback;
  private asg nOX;
  public ash nOY;
  private b rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(21854);
    this.rr = null;
    this.nOX = null;
    this.nOY = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new asg();
    ((b.a)localObject).fsY = new ash();
    ((b.a)localObject).funcId = 257;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.nOX = ((asg)this.rr.fsV.fta);
    this.nOX.Scene = paramInt;
    localObject = this.nOX;
    aw.aaz();
    ((asg)localObject).xhn = ((Integer)c.Ru().get(ac.a.yAw, Integer.valueOf(0))).intValue();
    localObject = this.nOX;
    aw.aaz();
    ((asg)localObject).xho = ((Integer)c.Ru().get(ac.a.yAk, Integer.valueOf(0))).intValue();
    ab.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.nOX.Scene), Integer.valueOf(this.nOX.xhn), Integer.valueOf(this.nOX.xho) });
    AppMethodBeat.o(21854);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21855);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21855);
    return i;
  }
  
  public final int getType()
  {
    return 257;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21856);
    ab.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nOY = ((ash)((b)paramq).fsW.fta);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.nOY;
      if (paramq != null) {
        ab.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { paramq.xhs, paramq.xht, paramq.xhp, paramq.nQe, paramq.Title, paramq.Desc, paramq.xhq, paramq.xhr, paramq.xhu, paramq.xhA });
      }
    }
    try
    {
      aw.aaz();
      c.Ru().set(ac.a.yBr, bo.cg(paramq.toByteArray()));
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(21856);
      return;
    }
    catch (IOException paramq)
    {
      for (;;)
      {
        ab.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[] { paramq.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.g
 * JD-Core Version:    0.7.0.1
 */