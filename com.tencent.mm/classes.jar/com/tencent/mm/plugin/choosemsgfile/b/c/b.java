package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String fGM;
  protected ArrayList<a> mDataList = new ArrayList();
  protected c oSN;
  
  public b(c paramc)
  {
    this.oSN = paramc;
    this.fGM = paramc.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b bZz()
  {
    if ((this.oSN.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.oSN.getContext();
    }
    return null;
  }
  
  public void fh(String paramString1, String paramString2)
  {
    ad.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    c(true, paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    ad.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
  }
  
  public void onPause()
  {
    ad.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
  }
  
  public void onResume()
  {
    ad.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.b
 * JD-Core Version:    0.7.0.1
 */