package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;

public enum e
{
  public final int code;
  public final int mDh;
  public final Class<? extends r> mDi;
  public final Class<? extends z> mDj;
  
  static
  {
    AppMethodBeat.i(48433);
    mDe = new e("WASERVICE", 0, 1, 2147483647, com.tencent.mm.plugin.appbrand.service.c.class, ad.class);
    mDf = new e("WAGAME", 1, 2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class);
    mDg = new e("NIL", 2, 0, 0, null, null);
    mDk = new e[] { mDe, mDf, mDg };
    AppMethodBeat.o(48433);
  }
  
  private e(int paramInt1, int paramInt2, Class<? extends r> paramClass, Class<? extends z> paramClass1)
  {
    this.code = paramInt1;
    this.mDh = paramInt2;
    this.mDi = paramClass;
    this.mDj = paramClass1;
  }
  
  public static e L(Intent paramIntent)
  {
    AppMethodBeat.i(48431);
    int j = paramIntent.getIntExtra("AppBrandServiceType", mDg.code);
    paramIntent = values();
    int k = paramIntent.length;
    int i = 0;
    while (i < k)
    {
      e locale = paramIntent[i];
      if (locale.code == j)
      {
        AppMethodBeat.o(48431);
        return locale;
      }
      i += 1;
    }
    paramIntent = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
    AppMethodBeat.o(48431);
    throw paramIntent;
  }
  
  public static e h(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(48432);
    if (paramAppBrandInitConfigWC.Ee())
    {
      paramAppBrandInitConfigWC = mDf;
      AppMethodBeat.o(48432);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = mDe;
    AppMethodBeat.o(48432);
    return paramAppBrandInitConfigWC;
  }
  
  public static e hB(boolean paramBoolean)
  {
    if (paramBoolean) {
      return mDf;
    }
    return mDe;
  }
  
  public static e vy(int paramInt)
  {
    AppMethodBeat.i(223001);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      e locale = localObject[i];
      if (locale.code == paramInt)
      {
        AppMethodBeat.o(223001);
        return locale;
      }
      i += 1;
    }
    localObject = new IllegalStateException("AppBrandServiceType DeserializeFrom[Int] Unreached Code");
    AppMethodBeat.o(223001);
    throw ((Throwable)localObject);
  }
  
  public final Intent K(Intent paramIntent)
  {
    AppMethodBeat.i(223000);
    paramIntent.putExtra("AppBrandServiceType", this.code);
    AppMethodBeat.o(223000);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e
 * JD-Core Version:    0.7.0.1
 */