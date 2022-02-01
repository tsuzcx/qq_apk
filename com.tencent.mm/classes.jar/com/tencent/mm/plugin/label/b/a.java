package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.label.d;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends p
  implements m
{
  private LinkedList<dgk> JUi;
  private h callback;
  private final c rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(26142);
    this.JUi = new LinkedList();
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dd();
    ((c.a)localObject).otF = new de();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((c.a)localObject).funcId = 635;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    if (!Util.isNullOrNil(paramString))
    {
      localObject = new dgk();
      ((dgk)localObject).aaLA = paramString;
      this.JUi.add(localObject);
    }
    AppMethodBeat.o(26142);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(26143);
    this.JUi = new LinkedList();
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dd();
    ((c.a)localObject).otF = new de();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((c.a)localObject).funcId = 635;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new dgk();
        ((dgk)localObject).aaLA = ((String)paramList.get(i));
        this.JUi.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(26143);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26144);
    Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = paramh;
    dd localdd = (dd)c.b.b(this.rr.otB);
    if ((this.JUi != null) && (this.JUi.size() > 0))
    {
      localdd.YFs = this.JUi;
      localdd.YFr = this.JUi.size();
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26144);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    paramh.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
    AppMethodBeat.o(26144);
    return 0;
  }
  
  public final de fTc()
  {
    AppMethodBeat.i(268635);
    de localde = (de)c.c.b(this.rr.otC);
    AppMethodBeat.o(268635);
    return localde;
  }
  
  public final int getType()
  {
    return 635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26145);
    Log.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = fTc();
    if (params != null)
    {
      params = params.YFs;
      paramArrayOfByte = new ArrayList();
      int i = params.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        dgk localdgk = (dgk)params.get(paramInt1);
        aw localaw = new aw();
        localaw.field_labelID = localdgk.aaLB;
        localaw.field_labelName = localdgk.aaLA;
        localaw.field_labelPYFull = f.RZ(localdgk.aaLA);
        localaw.field_labelPYShort = f.Sa(localdgk.aaLA);
        localaw.field_isTemporary = false;
        paramArrayOfByte.add(localaw);
        paramInt1 += 1;
      }
      d.fTa().mJ(paramArrayOfByte);
      d.fTa().mK(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */