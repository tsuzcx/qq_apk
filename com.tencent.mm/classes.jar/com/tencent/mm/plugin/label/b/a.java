package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private g callback;
  private final b rr;
  private LinkedList<bkp> sLV;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.sLV = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ci();
    ((b.a)localObject).gUV = new cj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    if (!bt.isNullOrNil(paramString))
    {
      localObject = new bkp();
      ((bkp)localObject).DIp = paramString;
      this.sLV.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.sLV = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ci();
    ((b.a)localObject).gUV = new cj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new bkp();
        ((bkp)localObject).DIp = ((String)paramList.get(i));
        this.sLV.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(26143);
  }
  
  public final cj cIT()
  {
    return (cj)this.rr.gUT.gUX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(26144);
    ad.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = paramg;
    ci localci = (ci)this.rr.gUS.gUX;
    if ((this.sLV != null) && (this.sLV.size() > 0))
    {
      localci.Cxi = this.sLV;
      localci.Cxh = this.sLV.size();
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    ad.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    paramg.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
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
    paramq = cIT();
    if (paramq != null)
    {
      paramq = paramq.Cxi;
      paramArrayOfByte = new ArrayList();
      int i = paramq.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bkp localbkp = (bkp)paramq.get(paramInt1);
        ah localah = new ah();
        localah.field_labelID = localbkp.DIq;
        localah.field_labelName = localbkp.DIp;
        localah.field_labelPYFull = f.Br(localbkp.DIp);
        localah.field_labelPYShort = f.Bs(localbkp.DIp);
        localah.field_isTemporary = false;
        paramArrayOfByte.add(localah);
        paramInt1 += 1;
      }
      com.tencent.mm.plugin.label.e.cIR().gS(paramArrayOfByte);
      com.tencent.mm.plugin.label.e.cIR().gT(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */