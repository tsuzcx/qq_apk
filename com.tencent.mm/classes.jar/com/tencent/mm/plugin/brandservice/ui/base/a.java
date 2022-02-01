package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a
  extends com.tencent.mm.ui.base.sortview.a
{
  protected c.b mTO;
  protected List<String> mVI;
  protected int mVJ;
  protected int position;
  
  public a(int paramInt, Object paramObject)
  {
    super(paramInt, paramObject);
  }
  
  public final c.b bCF()
  {
    return this.mTO;
  }
  
  public final int bCG()
  {
    return this.mVJ;
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
    this.mTO = paramb;
  }
  
  public final void xO(int paramInt)
  {
    this.mVJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.a
 * JD-Core Version:    0.7.0.1
 */