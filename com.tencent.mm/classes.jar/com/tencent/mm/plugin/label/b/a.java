package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private final b rr;
  private LinkedList<bts> vhP;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.vhP = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cl();
    ((b.a)localObject).hQG = new cm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    if (!bu.isNullOrNil(paramString))
    {
      localObject = new bts();
      ((bts)localObject).HgO = paramString;
      this.vhP.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.vhP = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cl();
    ((b.a)localObject).hQG = new cm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new bts();
        ((bts)localObject).HgO = ((String)paramList.get(i));
        this.vhP.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(26143);
  }
  
  public final cm dih()
  {
    return (cm)this.rr.hQE.hQJ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(26144);
    ae.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = paramf;
    cl localcl = (cl)this.rr.hQD.hQJ;
    if ((this.vhP != null) && (this.vhP.size() > 0))
    {
      localcl.FNr = this.vhP;
      localcl.FNq = this.vhP.size();
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    ae.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
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
    ae.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = dih();
    if (paramq != null)
    {
      paramq = paramq.FNr;
      paramArrayOfByte = new ArrayList();
      int i = paramq.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        bts localbts = (bts)paramq.get(paramInt1);
        ap localap = new ap();
        localap.field_labelID = localbts.HgP;
        localap.field_labelName = localbts.HgO;
        localap.field_labelPYFull = com.tencent.mm.platformtools.f.Jk(localbts.HgO);
        localap.field_labelPYShort = com.tencent.mm.platformtools.f.Jl(localbts.HgO);
        localap.field_isTemporary = false;
        paramArrayOfByte.add(localap);
        paramInt1 += 1;
      }
      com.tencent.mm.plugin.label.e.dif().hB(paramArrayOfByte);
      com.tencent.mm.plugin.label.e.dif().hC(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */