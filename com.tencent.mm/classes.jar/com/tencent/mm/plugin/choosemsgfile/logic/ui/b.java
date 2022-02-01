package com.tencent.mm.plugin.choosemsgfile.logic.ui;

import com.tencent.mm.plugin.choosemsgfile.logic.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String luk;
  protected ArrayList<a> mDataList = new ArrayList();
  protected e wQl;
  
  public b(e parame)
  {
    this.wQl = parame;
    this.luk = parame.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b dqF()
  {
    if ((this.wQl.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.wQl.getContext();
    }
    return null;
  }
  
  public void gp(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.ui.b
 * JD-Core Version:    0.7.0.1
 */