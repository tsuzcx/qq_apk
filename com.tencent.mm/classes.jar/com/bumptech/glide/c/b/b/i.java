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
  public final int aGB;
  public final int aGC;
  public final int aGD;
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
    if (a(parama.aGF))
    {
      i = parama.aGL / 2;
      this.aGD = i;
      localObject = parama.aGF;
      f1 = parama.aGJ;
      float f2 = parama.aGK;
      i = ((ActivityManager)localObject).getMemoryClass();
      bool = a((ActivityManager)localObject);
      float f3 = i * 1024 * 1024;
      if (!bool) {
        break label328;
      }
      f1 = f2;
      i = Math.round(f1 * f3);
      int k = parama.aGG.oC() * parama.aGG.oD() * 4;
      int j = Math.round(k * parama.aGI);
      k = Math.round(k * parama.aGH);
      m = i - this.aGD;
      if (k + j > m) {
        break label331;
      }
      this.aGC = k;
      this.aGB = j;
      label180:
      if (Log.isLoggable("MemorySizeCalculator", 3))
      {
        localObject = new StringBuilder("Calculation complete, Calculated memory cache size: ").append(dq(this.aGC)).append(", pool size: ").append(dq(this.aGB)).append(", byte array size: ").append(dq(this.aGD)).append(", memory class limited? ");
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
      ((StringBuilder)localObject).append(bool).append(", max size: ").append(dq(i)).append(", memoryClass: ").append(parama.aGF.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(parama.aGF));
      AppMethodBeat.o(77162);
      return;
      i = parama.aGL;
      break;
      break label91;
      f1 = m / (parama.aGI + parama.aGH);
      this.aGC = Math.round(parama.aGH * f1);
      this.aGB = Math.round(f1 * parama.aGI);
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
  
  private String dq(int paramInt)
  {
    AppMethodBeat.i(77163);
    String str = Formatter.formatFileSize(this.context, paramInt);
    AppMethodBeat.o(77163);
    return str;
  }
  
  public static final class a
  {
    static final int aGE;
    ActivityManager aGF;
    i.c aGG;
    float aGH;
    float aGI;
    float aGJ;
    float aGK;
    int aGL;
    final Context context;
    
    static
    {
      if (Build.VERSION.SDK_INT < 26) {}
      for (int i = 4;; i = 1)
      {
        aGE = i;
        return;
      }
    }
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(77161);
      this.aGH = 2.0F;
      this.aGI = aGE;
      this.aGJ = 0.4F;
      this.aGK = 0.33F;
      this.aGL = 4194304;
      this.context = paramContext;
      this.aGF = ((ActivityManager)paramContext.getSystemService("activity"));
      this.aGG = new i.b(paramContext.getResources().getDisplayMetrics());
      if ((Build.VERSION.SDK_INT >= 26) && (i.a(this.aGF))) {
        this.aGI = 0.0F;
      }
      AppMethodBeat.o(77161);
    }
  }
  
  static final class b
    implements i.c
  {
    private final DisplayMetrics aGM;
    
    b(DisplayMetrics paramDisplayMetrics)
    {
      this.aGM = paramDisplayMetrics;
    }
    
    public final int oC()
    {
      return this.aGM.widthPixels;
    }
    
    public final int oD()
    {
      return this.aGM.heightPixels;
    }
  }
  
  static abstract interface c
  {
    public abstract int oC();
    
    public abstract int oD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.i
 * JD-Core Version:    0.7.0.1
 */