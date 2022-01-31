package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agi;
import com.tencent.mm.protocal.c.agj;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class z
  extends m
  implements k
{
  private f dIJ = null;
  b jvQ = null;
  private String jwc = "";
  
  public z(LinkedList<agj> paramLinkedList, String paramString1, String paramString2)
  {
    this.jwc = paramString2;
    paramString2 = new b.a();
    paramString2.ecH = new agk();
    paramString2.ecI = new agl();
    paramString2.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
    paramString2.ecG = 543;
    paramString2.ecJ = 0;
    paramString2.ecK = 0;
    this.jvQ = paramString2.Kt();
    paramString2 = (agk)this.jvQ.ecE.ecN;
    if (!bk.bl(paramString1))
    {
      agi localagi = new agi();
      localagi.sAD = paramString1;
      paramString2.ted = localagi;
    }
    paramString2.tec = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 543;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.z
 * JD-Core Version:    0.7.0.1
 */