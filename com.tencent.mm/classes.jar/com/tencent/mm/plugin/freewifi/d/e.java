package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
  extends c
{
  public e(LinkedList<zk> paramLinkedList)
  {
    aUp();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      ((zl)this.dmK.ecE.ecN).sYL = paramLinkedList;
    }
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new zl();
    locala.ecI = new zm();
    locala.uri = "/cgi-bin/mmo2o-bin/freewifireport";
    locala.ecG = 1781;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final LinkedList<zk> aUy()
  {
    zm localzm = (zm)this.dmK.ecF.ecN;
    if (localzm == null) {
      return null;
    }
    return localzm.sYL;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    y.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (m.cR(paramInt2, paramInt3)) {
      j.aUm().aTT().post(new e.1(this));
    }
  }
  
  public final int getType()
  {
    return 1781;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.e
 * JD-Core Version:    0.7.0.1
 */