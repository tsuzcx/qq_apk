package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a
  extends com.tencent.mm.ui.base.sortview.a
{
  protected c.b nXE;
  protected List<String> nZG;
  protected int nZH;
  protected int position;
  
  public a(int paramInt, Object paramObject)
  {
    super(paramInt, paramObject);
  }
  
  public final c.b bOg()
  {
    return this.nXE;
  }
  
  public final int bOh()
  {
    return this.nZH;
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
    this.nXE = paramb;
  }
  
  public final void zp(int paramInt)
  {
    this.nZH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.a
 * JD-Core Version:    0.7.0.1
 */