package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;

public abstract class f$g
{
  protected f.d bpk;
  CharSequence bpl;
  CharSequence bpm;
  boolean bpn = false;
  
  public final Notification DA()
  {
    Notification localNotification = null;
    if (this.bpk != null) {
      localNotification = this.bpk.DA();
    }
    return localNotification;
  }
  
  protected String Dy()
  {
    return null;
  }
  
  public void a(e parame) {}
  
  public final void b(f.d paramd)
  {
    if (this.bpk != paramd)
    {
      this.bpk = paramd;
      if (this.bpk != null) {
        this.bpk.a(this);
      }
    }
  }
  
  public void k(Bundle paramBundle)
  {
    if (this.bpn) {
      paramBundle.putCharSequence("android.summaryText", this.bpm);
    }
    if (this.bpl != null) {
      paramBundle.putCharSequence("android.title.big", this.bpl);
    }
    String str = Dy();
    if (str != null) {
      paramBundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.app.f.g
 * JD-Core Version:    0.7.0.1
 */