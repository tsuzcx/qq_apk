package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a
  extends com.tencent.mm.ui.base.sortview.a
{
  protected c.b nwg;
  protected List<String> nyi;
  protected int nyj;
  protected int position;
  
  public a(int paramInt, Object paramObject)
  {
    super(paramInt, paramObject);
  }
  
  public final c.b bJN()
  {
    return this.nwg;
  }
  
  public final int bJO()
  {
    return this.nyj;
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
    this.nwg = paramb;
  }
  
  public final void yF(int paramInt)
  {
    this.nyj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.a
 * JD-Core Version:    0.7.0.1
 */