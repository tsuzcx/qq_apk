package android.support.v4.app;

import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;

public final class x$d
  implements x.e
{
  private int mColor = 0;
  private Bitmap xC;
  public a yd;
  
  private static Bundle a(a parama)
  {
    int i = 0;
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (parama.yi != null)
    {
      localObject = arrayOfParcelable;
      if (parama.yi.length > 1) {
        localObject = parama.yi[0];
      }
    }
    arrayOfParcelable = new Parcelable[parama.ye.length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", parama.ye[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = parama.yf;
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((ac)localObject).yL).setLabel(((ac)localObject).yM).setChoices(((ac)localObject).yN).setAllowFreeFormInput(((ac)localObject).yO).addExtras(((ac)localObject).mExtras).build());
    }
    localBundle1.putParcelable("on_reply", parama.yg);
    localBundle1.putParcelable("on_read", parama.yh);
    localBundle1.putStringArray("participants", parama.yi);
    localBundle1.putLong("timestamp", parama.yj);
    return localBundle1;
  }
  
  public final x.c a(x.c paramc)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramc;
    }
    Bundle localBundle = new Bundle();
    if (this.xC != null) {
      localBundle.putParcelable("large_icon", this.xC);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.yd != null) {
      localBundle.putBundle("car_conversation", a(this.yd));
    }
    if (paramc.mExtras == null) {
      paramc.mExtras = new Bundle();
    }
    paramc.mExtras.putBundle("android.car.EXTENSIONS", localBundle);
    return paramc;
  }
  
  public static final class a
  {
    final String[] ye;
    final ac yf;
    final PendingIntent yg;
    final PendingIntent yh;
    final String[] yi;
    final long yj;
    
    public a(String[] paramArrayOfString1, ac paramac, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
    {
      this.ye = paramArrayOfString1;
      this.yf = paramac;
      this.yh = paramPendingIntent2;
      this.yg = paramPendingIntent1;
      this.yi = paramArrayOfString2;
      this.yj = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.x.d
 * JD-Core Version:    0.7.0.1
 */