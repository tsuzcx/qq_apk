package com.bumptech.glide.c.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public final int aHr;
  public final int aHs;
  public final int aHt;
  private final Context context;
  
  public i(a parama)
  {
    AppMethodBeat.i(77162);
    this.context = parama.context;
    int i;
    Object localObject;
    float f1;
    label91:
    int m;
    if (a(parama.aHv))
    {
      i = parama.aHB / 2;
      this.aHt = i;
      localObject = parama.aHv;
      f1 = parama.aHz;
      float f2 = parama.aHA;
      i = ((ActivityManager)localObject).getMemoryClass();
      bool = a((ActivityManager)localObject);
      float f3 = i * 1024 * 1024;
      if (!bool) {
        break label328;
      }
      f1 = f2;
      i = Math.round(f1 * f3);
      int k = parama.aHw.oM() * parama.aHw.oN() * 4;
      int j = Math.round(k * parama.aHy);
      k = Math.round(k * parama.aHx);
      m = i - this.aHt;
      if (k + j > m) {
        break label331;
      }
      this.aHs = k;
      this.aHr = j;
      label180:
      if (Log.isLoggable("MemorySizeCalculator", 3))
      {
        localObject = new StringBuilder("Calculation complete, Calculated memory cache size: ").append(dp(this.aHs)).append(", pool size: ").append(dp(this.aHr)).append(", byte array size: ").append(dp(this.aHt)).append(", memory class limited? ");
        if (k + j <= i) {
          break label374;
        }
      }
    }
    label328:
    label331:
    label374:
    for (boolean bool = true;; bool = false)
    {
      ((StringBuilder)localObject).append(bool).append(", max size: ").append(dp(i)).append(", memoryClass: ").append(parama.aHv.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(parama.aHv));
      AppMethodBeat.o(77162);
      return;
      i = parama.aHB;
      break;
      break label91;
      f1 = m / (parama.aHy + parama.aHx);
      this.aHs = Math.round(parama.aHx * f1);
      this.aHr = Math.round(f1 * parama.aHy);
      break label180;
    }
  }
  
  @TargetApi(19)
  static boolean a(ActivityManager paramActivityManager)
  {
    AppMethodBeat.i(77164);
    if (Build.VERSION.SDK_INT >= 19)
    {
      boolean bool = paramActivityManager.isLowRamDevice();
      AppMethodBeat.o(77164);
      return bool;
    }
    AppMethodBeat.o(77164);
    return true;
  }
  
  private String dp(int paramInt)
  {
    AppMethodBeat.i(77163);
    String str = Formatter.formatFileSize(this.context, paramInt);
    AppMethodBeat.o(77163);
    return str;
  }
  
  public static final class a
  {
    static final int aHu;
    float aHA;
    int aHB;
    ActivityManager aHv;
    i.c aHw;
    float aHx;
    float aHy;
    float aHz;
    final Context context;
    
    static
    {
      if (Build.VERSION.SDK_INT < 26) {}
      for (int i = 4;; i = 1)
      {
        aHu = i;
        return;
      }
    }
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(77161);
      this.aHx = 2.0F;
      this.aHy = aHu;
      this.aHz = 0.4F;
      this.aHA = 0.33F;
      this.aHB = 4194304;
      this.context = paramContext;
      this.aHv = ((ActivityManager)paramContext.getSystemService("activity"));
      this.aHw = new i.b(paramContext.getResources().getDisplayMetrics());
      if ((Build.VERSION.SDK_INT >= 26) && (i.a(this.aHv))) {
        this.aHy = 0.0F;
      }
      AppMethodBeat.o(77161);
    }
  }
  
  static final class b
    implements i.c
  {
    private final DisplayMetrics aHC;
    
    b(DisplayMetrics paramDisplayMetrics)
    {
      this.aHC = paramDisplayMetrics;
    }
    
    public final int oM()
    {
      return this.aHC.widthPixels;
    }
    
    public final int oN()
    {
      return this.aHC.heightPixels;
    }
  }
  
  static abstract interface c
  {
    public abstract int oM();
    
    public abstract int oN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.i
 * JD-Core Version:    0.7.0.1
 */