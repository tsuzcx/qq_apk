package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String flk;
  protected ArrayList<a> hIH = new ArrayList();
  protected c nMs;
  
  public b(c paramc)
  {
    this.nMs = paramc;
    this.flk = paramc.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b bNJ()
  {
    if ((this.nMs.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.nMs.getContext();
    }
    return null;
  }
  
  public void eK(String paramString1, String paramString2)
  {
    ad.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    b(true, paramString1, paramString2);
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