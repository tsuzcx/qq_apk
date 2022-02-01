package com.tencent.mm.contact.a.a;

import com.tencent.mm.model.am;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements am
{
  protected List<com.tencent.mm.model.p> ghw = new ArrayList();
  protected List<com.tencent.mm.model.p> ghx = new ArrayList();
  protected List<com.tencent.mm.model.p> ghy = new ArrayList();
  protected boolean ghz = true;
  protected com.tencent.mm.ui.base.p tipDialog;
  
  public static b adK()
  {
    return new b(false);
  }
  
  public final am a(com.tencent.mm.model.p paramp)
  {
    this.ghw.add(paramp);
    return this;
  }
  
  public final am b(com.tencent.mm.model.p paramp)
  {
    this.ghy.add(paramp);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.a
 * JD-Core Version:    0.7.0.1
 */