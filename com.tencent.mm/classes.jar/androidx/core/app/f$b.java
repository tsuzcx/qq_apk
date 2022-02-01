package androidx.core.app;

import android.app.Notification.BigTextStyle;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$b
  extends f.g
{
  private CharSequence bol;
  
  public f$b() {}
  
  public f$b(f.d paramd)
  {
    AppMethodBeat.i(196439);
    b(paramd);
    AppMethodBeat.o(196439);
  }
  
  protected final String Dy()
  {
    return "androidx.core.app.NotificationCompat$BigTextStyle";
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(196455);
    if (Build.VERSION.SDK_INT >= 16)
    {
      parame = new Notification.BigTextStyle(parame.Dv()).setBigContentTitle(this.bpl).bigText(this.bol);
      if (this.bpn) {
        parame.setSummaryText(this.bpm);
      }
    }
    AppMethodBeat.o(196455);
  }
  
  public final b k(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196441);
    this.bol = f.d.p(paramCharSequence);
    AppMethodBeat.o(196441);
    return this;
  }
  
  public final void k(Bundle paramBundle)
  {
    AppMethodBeat.i(196461);
    super.k(paramBundle);
    if (Build.VERSION.SDK_INT < 21) {
      paramBundle.putCharSequence("android.bigText", this.bol);
    }
    AppMethodBeat.o(196461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.app.f.b
 * JD-Core Version:    0.7.0.1
 */