package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public final class x$a
{
  public PendingIntent actionIntent;
  public int icon;
  final Bundle mExtras;
  public CharSequence title;
  final ac[] xs;
  final ac[] xt;
  boolean xu;
  
  public x$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private x$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.icon = paramInt;
    this.title = x.c.f(paramCharSequence);
    this.actionIntent = paramPendingIntent;
    this.mExtras = paramBundle;
    this.xs = null;
    this.xt = null;
    this.xu = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.app.x.a
 * JD-Core Version:    0.7.0.1
 */