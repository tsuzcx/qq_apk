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
  public final int aJi;
  public final int aJj;
  public final int aJk;
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
    if (a(parama.aJm))
    {
      i = parama.aJs / 2;
      this.aJk = i;
      localObject = parama.aJm;
      f1 = parama.aJq;
      float f2 = parama.aJr;
      i = ((ActivityManager)localObject).getMemoryClass();
      bool = a((ActivityManager)localObject);
      float f3 = i * 1024 * 1024;
      if (!bool) {
        break label328;
      }
      f1 = f2;
      i = Math.round(f1 * f3);
      int k = parama.aJn.pe() * parama.aJn.pf() * 4;
      int j = Math.round(k * parama.aJp);
      k = Math.round(k * parama.aJo);
      m = i - this.aJk;
      if (k + j > m) {
        break label331;
      }
      this.aJj = k;
      this.aJi = j;
      label180:
      if (Log.isLoggable("MemorySizeCalculator", 3))
      {
        localObject = new StringBuilder("Calculation complete, Calculated memory cache size: ").append(dp(this.aJj)).append(", pool size: ").append(dp(this.aJi)).append(", byte array size: ").append(dp(this.aJk)).append(", memory class limited? ");
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
      ((StringBuilder)localObject).append(bool).append(", max size: ").append(dp(i)).append(", memoryClass: ").append(parama.aJm.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(parama.aJm));
      AppMethodBeat.o(77162);
      return;
      i = parama.aJs;
      break;
      break label91;
      f1 = m / (parama.aJp + parama.aJo);
      this.aJj = Math.round(parama.aJo * f1);
      this.aJi = Math.round(f1 * parama.aJp);
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
    static final int aJl;
    ActivityManager aJm;
    i.c aJn;
    float aJo;
    float aJp;
    float aJq;
    float aJr;
    int aJs;
    final Context context;
    
    static
    {
      if (Build.VERSION.SDK_INT < 26) {}
      for (int i = 4;; i = 1)
      {
        aJl = i;
        return;
      }
    }
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(77161);
      this.aJo = 2.0F;
      this.aJp = aJl;
      this.aJq = 0.4F;
      this.aJr = 0.33F;
      this.aJs = 4194304;
      this.context = paramContext;
      this.aJm = ((ActivityManager)paramContext.getSystemService("activity"));
      this.aJn = new i.b(paramContext.getResources().getDisplayMetrics());
      if ((Build.VERSION.SDK_INT >= 26) && (i.a(this.aJm))) {
        this.aJp = 0.0F;
      }
      AppMethodBeat.o(77161);
    }
  }
  
  static final class b
    implements i.c
  {
    private final DisplayMetrics aJt;
    
    b(DisplayMetrics paramDisplayMetrics)
    {
      this.aJt = paramDisplayMetrics;
    }
    
    public final int pe()
    {
      return this.aJt.widthPixels;
    }
    
    public final int pf()
    {
      return this.aJt.heightPixels;
    }
  }
  
  static abstract interface c
  {
    public abstract int pe();
    
    public abstract int pf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.i
 * JD-Core Version:    0.7.0.1
 */