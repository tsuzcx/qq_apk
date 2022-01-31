package android.support.v4.app;

import android.app.Notification.BigTextStyle;
import android.os.Build.VERSION;

public final class x$b
  extends x.f
{
  private CharSequence xv;
  
  public final void a(w paramw)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramw = new Notification.BigTextStyle(paramw.cg()).setBigContentTitle(this.yn).bigText(this.xv);
      if (this.yp) {
        paramw.setSummaryText(this.yo);
      }
    }
  }
  
  public final b b(CharSequence paramCharSequence)
  {
    this.xv = x.c.f(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.app.x.b
 * JD-Core Version:    0.7.0.1
 */