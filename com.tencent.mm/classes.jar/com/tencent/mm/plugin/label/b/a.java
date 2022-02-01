package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.an;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private g callback;
  private final b rr;
  private LinkedList<bol> tTA;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.tTA = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ck();
    ((b.a)localObject).hvu = new cl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    if (!bs.isNullOrNil(paramString))
    {
      localObject = new bol();
      ((bol)localObject).FdK = paramString;
      this.tTA.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.tTA = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ck();
    ((b.a)localObject).hvu = new cl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new bol();
        ((bol)localObject).FdK = ((String)paramList.get(i));
        this.tTA.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(26143);
  }
  
  public final cl cWe()
  {
    return (cl)this.rr.hvs.hvw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(26144);
    ac.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = paramg;
    ck localck = (ck)this.rr.hvr.hvw;
    if ((this.tTA != null) && (this.tTA.size() > 0))
    {
      localck.DPE = this.tTA;
      localck.DPD = this.tTA.size();
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    ac.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
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
    ac.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = cWe();
    if (paramq != null)
    {
      paramq = paramq.DPE;
      paramArrayOfByte = new ArrayList();
      int i = paramq.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bol localbol = (bol)paramq.get(paramInt1);
        ak localak = new ak();
        localak.field_labelID = localbol.FdL;
        localak.field_labelName = localbol.FdK;
        localak.field_labelPYFull = f.Fv(localbol.FdK);
        localak.field_labelPYShort = f.Fw(localbol.FdK);
        localak.field_isTemporary = false;
        paramArrayOfByte.add(localak);
        paramInt1 += 1;
      }
      com.tencent.mm.plugin.label.e.cWc().hf(paramArrayOfByte);
      com.tencent.mm.plugin.label.e.cWc().hg(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */