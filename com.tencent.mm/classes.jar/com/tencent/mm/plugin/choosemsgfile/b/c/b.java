package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String fIQ;
  protected ArrayList<a> mDataList = new ArrayList();
  protected c oZp;
  
  public b(c paramc)
  {
    this.oZp = paramc;
    this.fIQ = paramc.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b caO()
  {
    if ((this.oZp.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.oZp.getContext();
    }
    return null;
  }
  
  public void fl(String paramString1, String paramString2)
  {
    ae.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    c(true, paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    ae.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
  }
  
  public void onPause()
  {
    ae.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
  }
  
  public void onResume()
  {
    ae.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.b
 * JD-Core Version:    0.7.0.1
 */