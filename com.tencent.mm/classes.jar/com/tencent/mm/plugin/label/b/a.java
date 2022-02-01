package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cv;
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
  private i callback;
  private final d rr;
  private LinkedList<cgu> yBT;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.yBT = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cu();
    ((d.a)localObject).iLO = new cv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((d.a)localObject).funcId = 635;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new cgu();
      ((cgu)localObject).Mmb = paramString;
      this.yBT.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.yBT = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cu();
    ((d.a)localObject).iLO = new cv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((d.a)localObject).funcId = 635;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new cgu();
        ((cgu)localObject).Mmb = ((String)paramList.get(i));
        this.yBT.add(localObject);
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
    cu localcu = (cu)this.rr.iLK.iLR;
    if ((this.yBT != null) && (this.yBT.size() > 0))
    {
      localcu.KGW = this.yBT;
      localcu.KGV = this.yBT.size();
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    parami.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
    AppMethodBeat.o(26144);
    return 0;
  }
  
  public final cv ech()
  {
    return (cv)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26145);
    Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = ech();
    if (params != null)
    {
      params = params.KGW;
      paramArrayOfByte = new ArrayList();
      int i = params.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        cgu localcgu = (cgu)params.get(paramInt1);
        au localau = new au();
        localau.field_labelID = localcgu.Mmc;
        localau.field_labelName = localcgu.Mmb;
        localau.field_labelPYFull = f.Sh(localcgu.Mmb);
        localau.field_labelPYShort = f.Si(localcgu.Mmb);
        localau.field_isTemporary = false;
        paramArrayOfByte.add(localau);
        paramInt1 += 1;
      }
      e.ecf().iF(paramArrayOfByte);
      e.ecf().iG(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */