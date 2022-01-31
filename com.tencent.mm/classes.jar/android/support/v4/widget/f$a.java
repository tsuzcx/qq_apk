package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

final class f$a
  extends ContentObserver
{
  f$a(f paramf)
  {
    super(new Handler());
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    this.Jy.onContentChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.f.a
 * JD-Core Version:    0.7.0.1
 */