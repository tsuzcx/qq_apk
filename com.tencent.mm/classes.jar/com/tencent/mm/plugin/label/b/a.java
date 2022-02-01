package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends q
  implements m
{
  private LinkedList<cpq> Edj;
  private i callback;
  private final d rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.Edj = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ct();
    ((d.a)localObject).lBV = new cu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((d.a)localObject).funcId = 635;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new cpq();
      ((cpq)localObject).TwV = paramString;
      this.Edj.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.Edj = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ct();
    ((d.a)localObject).lBV = new cu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((d.a)localObject).funcId = 635;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new cpq();
        ((cpq)localObject).TwV = ((String)paramList.get(i));
        this.Edj.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(26143);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26144);
    Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = parami;
    ct localct = (ct)d.b.b(this.rr.lBR);
    if ((this.Edj != null) && (this.Edj.size() > 0))
    {
      localct.RIq = this.Edj;
      localct.RIp = this.Edj.size();
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    parami.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
    AppMethodBeat.o(26144);
    return 0;
  }
  
  public final cu eLf()
  {
    AppMethodBeat.i(291045);
    cu localcu = (cu)d.c.b(this.rr.lBS);
    AppMethodBeat.o(291045);
    return localcu;
  }
  
  public final int getType()
  {
    return 635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26145);
    Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = eLf();
    if (params != null)
    {
      params = params.RIq;
      paramArrayOfByte = new ArrayList();
      int i = params.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        cpq localcpq = (cpq)params.get(paramInt1);
        au localau = new au();
        localau.field_labelID = localcpq.TwW;
        localau.field_labelName = localcpq.TwV;
        localau.field_labelPYFull = f.ZJ(localcpq.TwV);
        localau.field_labelPYShort = f.ZK(localcpq.TwV);
        localau.field_isTemporary = false;
        paramArrayOfByte.add(localau);
        paramInt1 += 1;
      }
      e.eLd().jx(paramArrayOfByte);
      e.eLd().jy(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */