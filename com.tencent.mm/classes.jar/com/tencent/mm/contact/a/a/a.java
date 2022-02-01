package com.tencent.mm.contact.a.a;

import com.tencent.mm.model.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements aq
{
  protected List<t> gNc = new ArrayList();
  protected List<t> gNd = new ArrayList();
  protected List<t> gNe = new ArrayList();
  protected boolean gNf = true;
  protected q tipDialog;
  
  public static b arN()
  {
    return new b(false);
  }
  
  public final aq a(t paramt)
  {
    this.gNc.add(paramt);
    return this;
  }
  
  public final aq b(t paramt)
  {
    this.gNe.add(paramt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.a
 * JD-Core Version:    0.7.0.1
 */