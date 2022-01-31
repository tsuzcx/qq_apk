package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String eaX;
  protected ArrayList<com.tencent.mm.plugin.choosemsgfile.b.b.a> iVH = new ArrayList();
  protected com.tencent.mm.plugin.choosemsgfile.ui.a kFr;
  
  public b(com.tencent.mm.plugin.choosemsgfile.ui.a parama)
  {
    this.kFr = parama;
    this.eaX = parama.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b bgy()
  {
    if ((this.kFr.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.kFr.getContext();
    }
    return null;
  }
  
  public void dA(String paramString1, String paramString2)
  {
    ab.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    b(true, paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    ab.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
  }
  
  public void onPause()
  {
    ab.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
  }
  
  public void onResume()
  {
    ab.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.b
 * JD-Core Version:    0.7.0.1
 */