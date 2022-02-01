package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  public static Bundle a(Notification paramNotification)
  {
    AppMethodBeat.i(196343);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramNotification = paramNotification.extras;
      AppMethodBeat.o(196343);
      return paramNotification;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramNotification = h.a(paramNotification);
      AppMethodBeat.o(196343);
      return paramNotification;
    }
    AppMethodBeat.o(196343);
    return null;
  }
  
  @Deprecated
  public static final class e$a
  {
    final String[] bpc;
    final j bpd;
    final PendingIntent bpe;
    final PendingIntent bpf;
    final String[] bpg;
    final long bph;
    
    public e$a(String[] paramArrayOfString1, j paramj, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString2, long paramLong)
    {
      this.bpc = paramArrayOfString1;
      this.bpd = paramj;
      this.bpf = paramPendingIntent2;
      this.bpe = paramPendingIntent1;
      this.bpg = paramArrayOfString2;
      this.bph = paramLong;
    }
    
    public static final class a
    {
      public j bpd;
      public PendingIntent bpe;
      public PendingIntent bpf;
      public long bph;
      public final List<String> bpi;
      public final String bpj;
      
      public a(String paramString)
      {
        AppMethodBeat.i(196446);
        this.bpi = new ArrayList();
        this.bpj = paramString;
        AppMethodBeat.o(196446);
      }
    }
  }
  
  public static final class e$a$a
  {
    public j bpd;
    public PendingIntent bpe;
    public PendingIntent bpf;
    public long bph;
    public final List<String> bpi;
    public final String bpj;
    
    public e$a$a(String paramString)
    {
      AppMethodBeat.i(196446);
      this.bpi = new ArrayList();
      this.bpj = paramString;
      AppMethodBeat.o(196446);
    }
  }
  
  public static abstract interface f
  {
    public abstract f.d a(f.d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.core.app.f
 * JD-Core Version:    0.7.0.1
 */