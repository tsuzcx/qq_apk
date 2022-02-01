package com.tencent.mm.contact.a.a;

import com.tencent.mm.model.as;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements as
{
  protected List<t> maQ = new ArrayList();
  protected List<t> maR = new ArrayList();
  protected List<t> maS = new ArrayList();
  protected boolean maT = true;
  protected w tipDialog;
  
  public static b aSZ()
  {
    return new b(false);
  }
  
  public final as a(t paramt)
  {
    this.maQ.add(paramt);
    return this;
  }
  
  public final as b(t paramt)
  {
    this.maS.add(paramt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.a
 * JD-Core Version:    0.7.0.1
 */