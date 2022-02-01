package com.tencent.mm.plugin.choosemsgfile.b.c;

import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public abstract class b
  implements h
{
  protected String foE;
  protected ArrayList<a> ijj = new ArrayList();
  protected c ops;
  
  public b(c paramc)
  {
    this.ops = paramc;
    this.foE = paramc.getUserName();
  }
  
  protected final com.tencent.mm.vending.e.b bUU()
  {
    if ((this.ops.getContext() instanceof com.tencent.mm.vending.e.b)) {
      return (com.tencent.mm.vending.e.b)this.ops.getContext();
    }
    return null;
  }
  
  public void eX(String paramString1, String paramString2)
  {
    ac.i("MicroMsg.BaseChooseMsgFileUIController", "onCreate type:%s extension:%s", new Object[] { paramString1, paramString2 });
    b(true, paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    ac.i("MicroMsg.BaseChooseMsgFileUIController", "onDestroy");
  }
  
  public void onPause()
  {
    ac.i("MicroMsg.BaseChooseMsgFileUIController", "onPause");
  }
  
  public void onResume()
  {
    ac.i("MicroMsg.BaseChooseMsgFileUIController", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.b
 * JD-Core Version:    0.7.0.1
 */