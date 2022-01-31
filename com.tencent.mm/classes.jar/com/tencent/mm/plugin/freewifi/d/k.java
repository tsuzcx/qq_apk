package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.protocal.c.jo;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class k
  extends c
{
  public k(String paramString1, bmv parambmv, int paramInt, String paramString2)
  {
    aUp();
    if ((8 != paramInt) || (9 != paramInt)) {
      y.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[] { Integer.valueOf(paramInt) });
    }
    jo localjo = (jo)this.dmK.ecE.ecN;
    localjo.sCE = paramString1;
    localjo.sEo = parambmv;
    localjo.sss = paramInt;
    localjo.sst = paramString2;
  }
  
  public final String aUD()
  {
    LinkedList localLinkedList = ((jp)this.dmK.ecF.ecN).sEp;
    if ((localLinkedList != null) && (localLinkedList.size() == 1)) {
      return ((cz)localLinkedList.get(0)).swn;
    }
    return null;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new jo();
    locala.ecI = new jp();
    locala.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
    locala.ecG = 1705;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int getType()
  {
    return 1705;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.k
 * JD-Core Version:    0.7.0.1
 */