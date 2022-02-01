package com.bumptech.glide.load.b.b;

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
  public final int aJb;
  public final int aJc;
  public final int aJd;
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
    if (a(parama.aJf))
    {
      i = parama.aJl / 2;
      this.aJd = i;
      localObject = parama.aJf;
      f1 = parama.aJj;
      float f2 = parama.aJk;
      i = ((ActivityManager)localObject).getMemoryClass();
      bool = a((ActivityManager)localObject);
      float f3 = i * 1024 * 1024;
      if (!bool) {
        break label328;
      }
      f1 = f2;
      i = Math.round(f1 * f3);
      int k = parama.aJg.pj() * parama.aJg.pk() * 4;
      int j = Math.round(k * parama.aJi);
      k = Math.round(k * parama.aJh);
      m = i - this.aJd;
      if (k + j > m) {
        break label331;
      }
      this.aJc = k;
      this.aJb = j;
      label180:
      if (Log.isLoggable("MemorySizeCalculator", 3))
      {
        localObject = new StringBuilder("Calculation complete, Calculated memory cache size: ").append(dk(this.aJc)).append(", pool size: ").append(dk(this.aJb)).append(", byte array size: ").append(dk(this.aJd)).append(", memory class limited? ");
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
      ((StringBuilder)localObject).append(bool).append(", max size: ").append(dk(i)).append(", memoryClass: ").append(parama.aJf.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(parama.aJf));
      AppMethodBeat.o(77162);
      return;
      i = parama.aJl;
      break;
      break label91;
      f1 = m / (parama.aJi + parama.aJh);
      this.aJc = Math.round(parama.aJh * f1);
      this.aJb = Math.round(f1 * parama.aJi);
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
  
  private String dk(int paramInt)
  {
    AppMethodBeat.i(77163);
    String str = Formatter.formatFileSize(this.context, paramInt);
    AppMethodBeat.o(77163);
    return str;
  }
  
  public static final class a
  {
    static final int aJe;
    ActivityManager aJf;
    i.c aJg;
    float aJh;
    float aJi;
    float aJj;
    float aJk;
    int aJl;
    final Context context;
    
    static
    {
      if (Build.VERSION.SDK_INT < 26) {}
      for (int i = 4;; i = 1)
      {
        aJe = i;
        return;
      }
    }
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(77161);
      this.aJh = 2.0F;
      this.aJi = aJe;
      this.aJj = 0.4F;
      this.aJk = 0.33F;
      this.aJl = 4194304;
      this.context = paramContext;
      this.aJf = ((ActivityManager)paramContext.getSystemService("activity"));
      this.aJg = new i.b(paramContext.getResources().getDisplayMetrics());
      if ((Build.VERSION.SDK_INT >= 26) && (i.a(this.aJf))) {
        this.aJi = 0.0F;
      }
      AppMethodBeat.o(77161);
    }
  }
  
  static final class b
    implements i.c
  {
    private final DisplayMetrics aJm;
    
    b(DisplayMetrics paramDisplayMetrics)
    {
      this.aJm = paramDisplayMetrics;
    }
    
    public final int pj()
    {
      return this.aJm.widthPixels;
    }
    
    public final int pk()
    {
      return this.aJm.heightPixels;
    }
  }
  
  static abstract interface c
  {
    public abstract int pj();
    
    public abstract int pk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.b.i
 * JD-Core Version:    0.7.0.1
 */