package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a
  extends com.tencent.mm.ui.base.sortview.a
{
  protected c.b pok;
  protected int position;
  protected List<String> pqn;
  protected int pqo;
  
  public a(int paramInt, Object paramObject)
  {
    super(paramInt, paramObject);
  }
  
  public final void Dd(int paramInt)
  {
    this.pqo = paramInt;
  }
  
  public final c.b cmj()
  {
    return this.pok;
  }
  
  public final int cmk()
  {
    return this.pqo;
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
    this.pok = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.a
 * JD-Core Version:    0.7.0.1
 */