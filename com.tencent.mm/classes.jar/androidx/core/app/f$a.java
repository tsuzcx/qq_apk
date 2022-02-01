package androidx.core.app;

import android.app.PendingIntent;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
{
  private IconCompat bob;
  final j[] boc;
  final j[] bod;
  boolean boe;
  boolean bof;
  final int bog;
  final boolean boh;
  public PendingIntent boi;
  @Deprecated
  public int icon;
  final Bundle mExtras;
  public CharSequence title;
  
  public f$a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent) {}
  
  private f$a(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true, false);
    AppMethodBeat.i(196305);
    AppMethodBeat.o(196305);
  }
  
  f$a(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, j[] paramArrayOfj1, j[] paramArrayOfj2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(196315);
    this.bof = true;
    this.bob = paramIconCompat;
    int i;
    if (paramIconCompat != null)
    {
      if ((paramIconCompat.mType != -1) || (Build.VERSION.SDK_INT < 23)) {
        break label131;
      }
      i = IconCompat.a((Icon)paramIconCompat.bqU);
      if (i == 2) {
        this.icon = paramIconCompat.getResId();
      }
    }
    this.title = f.d.p(paramCharSequence);
    this.boi = paramPendingIntent;
    if (paramBundle != null) {}
    for (;;)
    {
      this.mExtras = paramBundle;
      this.boc = paramArrayOfj1;
      this.bod = paramArrayOfj2;
      this.boe = paramBoolean1;
      this.bog = paramInt;
      this.bof = paramBoolean2;
      this.boh = paramBoolean3;
      AppMethodBeat.o(196315);
      return;
      label131:
      i = paramIconCompat.mType;
      break;
      paramBundle = new Bundle();
    }
  }
  
  public final IconCompat Dw()
  {
    AppMethodBeat.i(196325);
    if ((this.bob == null) && (this.icon != 0)) {
      this.bob = IconCompat.j("", this.icon);
    }
    IconCompat localIconCompat = this.bob;
    AppMethodBeat.o(196325);
    return localIconCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.app.f.a
 * JD-Core Version:    0.7.0.1
 */