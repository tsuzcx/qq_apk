package android.support.v4.app;

import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class s$d
  implements s.e
{
  public a HP;
  private Bitmap Ho;
  private int mColor = 0;
  
  private static Bundle a(a parama)
  {
    int i = 0;
    Bundle localBundle1 = new Bundle();
    Parcelable[] arrayOfParcelable = null;
    Object localObject = arrayOfParcelable;
    if (parama.HU != null)
    {
      localObject = arrayOfParcelable;
      if (parama.HU.length > 1) {
        localObject = parama.HU[0];
      }
    }
    arrayOfParcelable = new Parcelable[parama.HQ.length];
    while (i < arrayOfParcelable.length)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("text", parama.HQ[i]);
      localBundle2.putString("author", (String)localObject);
      arrayOfParcelable[i] = localBundle2;
      i += 1;
    }
    localBundle1.putParcelableArray("messages", arrayOfParcelable);
    localObject = parama.HR;
    if (localObject != null) {
      localBundle1.putParcelable("remote_input", new RemoteInput.Builder(((x)localObject).Ix).setLabel(((x)localObject).Iy).setChoices(((x)localObject).Iz).setAllowFreeFormInput(((x)localObject).IA).addExtras(((x)localObject).mExtras).build());
    }
    localBundle1.putParcelable("on_reply", parama.HS);
    localBundle1.putParcelable("on_read", parama.HT);
    localBundle1.putStringArray("participants", parama.HU);
    localBundle1.putLong("timestamp", parama.HV);
    return localBundle1;
  }
  
  public final s.c a(s.c paramc)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return paramc;
    }
    Bundle localBundle = new Bundle();
    if (this.Ho != null) {
      localBundle.putParcelable("large_icon", this.Ho);
    }
    if (this.mColor != 0) {
      localBundle.putInt("app_color", this.mColor);
    }
    if (this.HP != null) {
      localBundle.putBundle("car_conversation", a(this.HP));
    }
    paramc.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
    return paramc;
  }
  
  public static final class a
  {
    final String[] HQ;
    final x HR;
    final PendingIntent HS;
    final PendingIntent HT;
    final String[] HU;
    final long HV;
    
    public a(String[] paramArrayOfString1, x paramx, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
    {
      this.HQ = paramArrayOfString1;
      this.HR = paramx;
      this.HT = paramPendingIntent2;
      this.HS = paramPendingIntent1;
      this.HU = paramArrayOfString2;
      this.HV = paramLong;
    }
    
    public static final class a
    {
      public x HR;
      public PendingIntent HS;
      public PendingIntent HT;
      public long HV;
      public final List<String> HW = new ArrayList();
      public final String HX;
      
      public a(String paramString)
      {
        this.HX = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.s.d
 * JD-Core Version:    0.7.0.1
 */