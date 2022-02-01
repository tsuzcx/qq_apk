package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a
  extends com.tencent.mm.ui.base.sortview.a
{
  protected c.b odn;
  protected List<String> ofq;
  protected int ofr;
  protected int position;
  
  public a(int paramInt, Object paramObject)
  {
    super(paramInt, paramObject);
  }
  
  public final c.b bPd()
  {
    return this.odn;
  }
  
  public final int bPe()
  {
    return this.ofr;
  }
  
  public final int getPosition()
  {
    return this.position;
  }
  
  public final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public final void setReporter(c.b paramb)
  {
    this.odn = paramb;
  }
  
  public final void zy(int paramInt)
  {
    this.ofr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.a
 * JD-Core Version:    0.7.0.1
 */