package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private final b rr;
  private LinkedList<bsy> uWc;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.uWc = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cl();
    ((b.a)localObject).hNN = new cm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    if (!bt.isNullOrNil(paramString))
    {
      localObject = new bsy();
      ((bsy)localObject).GNo = paramString;
      this.uWc.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.uWc = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cl();
    ((b.a)localObject).hNN = new cm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new bsy();
        ((bsy)localObject).GNo = ((String)paramList.get(i));
        this.uWc.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(26143);
  }
  
  public final cm dfp()
  {
    return (cm)this.rr.hNL.hNQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(26144);
    ad.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = paramf;
    cl localcl = (cl)this.rr.hNK.hNQ;
    if ((this.uWc != null) && (this.uWc.size() > 0))
    {
      localcl.FuT = this.uWc;
      localcl.FuS = this.uWc.size();
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    ad.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
    AppMethodBeat.o(26144);
    return 0;
  }
  
  public final int getType()
  {
    return 635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26145);
    ad.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = dfp();
    if (paramq != null)
    {
      paramq = paramq.FuT;
      paramArrayOfByte = new ArrayList();
      int i = paramq.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bsy localbsy = (bsy)paramq.get(paramInt1);
        ao localao = new ao();
        localao.field_labelID = localbsy.GNp;
        localao.field_labelName = localbsy.GNo;
        localao.field_labelPYFull = com.tencent.mm.platformtools.f.IL(localbsy.GNo);
        localao.field_labelPYShort = com.tencent.mm.platformtools.f.IM(localbsy.GNo);
        localao.field_isTemporary = false;
        paramArrayOfByte.add(localao);
        paramInt1 += 1;
      }
      com.tencent.mm.plugin.label.e.dfn().hr(paramArrayOfByte);
      com.tencent.mm.plugin.label.e.dfn().hs(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */