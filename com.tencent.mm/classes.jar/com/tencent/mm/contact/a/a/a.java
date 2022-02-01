package com.tencent.mm.contact.a.a;

import com.tencent.mm.model.ar;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements ar
{
  protected List<t> jxw = new ArrayList();
  protected List<t> jxx = new ArrayList();
  protected List<t> jxy = new ArrayList();
  protected boolean jxz = true;
  protected s tipDialog;
  
  public static b ayw()
  {
    return new b(false);
  }
  
  public final ar a(t paramt)
  {
    this.jxw.add(paramt);
    return this;
  }
  
  public final ar b(t paramt)
  {
    this.jxy.add(paramt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.a.a.a
 * JD-Core Version:    0.7.0.1
 */