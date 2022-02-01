package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eix;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Date;

public final class x
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private Object cpt;
  public c rr;
  
  public x(d paramd, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eiw();
    ((c.a)localObject).otF = new eix();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((c.a)localObject).funcId = 2805;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (eiw)c.b.b(this.rr.otB);
    ((eiw)localObject).abnH = 1;
    ((eiw)localObject).abnI = paramd.field_wwCorpId;
    ((eiw)localObject).YSo = paramd.field_wwUserVid;
    com.tencent.mm.kernel.h.baC();
    ((eiw)localObject).abnJ = b.getUin();
    ((eiw)localObject).scene = paramInt2;
    ((eiw)localObject).hAf = paramInt1;
    ((eiw)localObject).NlD = 0L;
    ((eiw)localObject).abnK = new Date().getTime();
    ((eiw)localObject).platform = 1;
    ((eiw)localObject).abhz = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.Yxh);
    this.cpt = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124125);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124125);
    return i;
  }
  
  public final int getType()
  {
    return 2805;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124124);
    Log.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.x
 * JD-Core Version:    0.7.0.1
 */