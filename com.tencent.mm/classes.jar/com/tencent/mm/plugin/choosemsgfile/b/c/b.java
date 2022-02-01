package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String goe;
  protected ArrayList<a> mDataList = new ArrayList();
  protected c qon;
  
  public b(c paramc)
  {
    this.qon = paramc;
    this.goe = paramc.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b cyE()
  {
    if ((this.qon.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.qon.getContext();
    }
    return null;
  }
  
  public void fC(String paramString1, String paramString2)
  {
    Log.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    c(true, paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    Log.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
  }
  
  public void onPause()
  {
    Log.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
  }
  
  public void onResume()
  {
    Log.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.b
 * JD-Core Version:    0.7.0.1
 */