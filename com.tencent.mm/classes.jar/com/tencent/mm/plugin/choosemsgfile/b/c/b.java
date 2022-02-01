package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String iSn;
  protected ArrayList<a> mDataList = new ArrayList();
  protected e tMV;
  
  public b(e parame)
  {
    this.tMV = parame;
    this.iSn = parame.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b cMZ()
  {
    if ((this.tMV.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.tMV.getContext();
    }
    return null;
  }
  
  public void fQ(String paramString1, String paramString2)
  {
    Log.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    d(true, paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.b
 * JD-Core Version:    0.7.0.1
 */