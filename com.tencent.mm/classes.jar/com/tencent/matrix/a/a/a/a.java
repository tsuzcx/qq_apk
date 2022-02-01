package com.tencent.matrix.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.a.a.d;

public abstract class a
  implements m
{
  public d eNY;
  
  public void awI()
  {
    com.tencent.matrix.e.c.i(getTag(), "#onTurnOn", new Object[0]);
  }
  
  public void awJ()
  {
    com.tencent.matrix.e.c.i(getTag(), "#onTurnOff", new Object[0]);
  }
  
  protected final boolean awK()
  {
    if (this.eNY.ePD.ePu) {}
    while ((d.getContext().getApplicationInfo().flags & 0x2) != 0) {
      return true;
    }
    return false;
  }
  
  public void dE(long paramLong)
  {
    com.tencent.matrix.e.c.i(getTag(), "#onBackgroundCheck, since background started millis = ".concat(String.valueOf(paramLong)), new Object[0]);
  }
  
  public void g(d paramd)
  {
    com.tencent.matrix.e.c.i(getTag(), "#configure", new Object[0]);
    this.eNY = paramd;
  }
  
  protected String getTag()
  {
    return "Matrix.battery.MonitorFeature";
  }
  
  public void onForeground(boolean paramBoolean)
  {
    com.tencent.matrix.e.c.i(getTag(), "#onForeground, foreground = ".concat(String.valueOf(paramBoolean)), new Object[0]);
  }
  
  public String toString()
  {
    return getTag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */