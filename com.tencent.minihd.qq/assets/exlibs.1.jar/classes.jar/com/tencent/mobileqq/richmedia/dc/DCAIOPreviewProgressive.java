package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.SystemClock;
import jqq;
import jqs;

public class DCAIOPreviewProgressive
  extends DataCollector
  implements ReportEvent
{
  private jqq a;
  private boolean b;
  
  public DCAIOPreviewProgressive(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.b))
    {
      jqs localjqs = new jqs("Pic.AioPreview.Progressive", this.a.a("Pic.AioPreview.Progressive"));
      DataReport.a().a(localjqs);
      this.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.b))
    {
      jqq localjqq = new jqq(null);
      jqq.a(localjqq, paramBoolean);
      jqq.a(localjqq, SystemClock.uptimeMillis());
      this.a = localjqq;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      jqq.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      jqq.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      jqq.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive
 * JD-Core Version:    0.7.0.1
 */