package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.q;

public enum e
{
  public final int code;
  public final int myj;
  public final Class<? extends q> myk;
  public final Class<? extends aa> myl;
  
  static
  {
    AppMethodBeat.i(48433);
    myg = new e("WASERVICE", 0, 1, 2147483647, com.tencent.mm.plugin.appbrand.service.c.class, ae.class);
    myh = new e("WAGAME", 1, 2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class);
    myi = new e("NIL", 2, 0, 0, null, null);
    mym = new e[] { myg, myh, myi };
    AppMethodBeat.o(48433);
  }
  
  private e(int paramInt1, int paramInt2, Class<? extends q> paramClass, Class<? extends aa> paramClass1)
  {
    this.code = paramInt1;
    this.myj = paramInt2;
    this.myk = paramClass;
    this.myl = paramClass1;
  }
  
  public static e L(Intent paramIntent)
  {
    AppMethodBeat.i(48431);
    int j = paramIntent.getIntExtra("AppBrandServiceType", myi.code);
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
    if (paramAppBrandInitConfigWC.Eb())
    {
      paramAppBrandInitConfigWC = myh;
      AppMethodBeat.o(48432);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = myg;
    AppMethodBeat.o(48432);
    return paramAppBrandInitConfigWC;
  }
  
  public static e hA(boolean paramBoolean)
  {
    if (paramBoolean) {
      return myh;
    }
    return myg;
  }
  
  public static e vt(int paramInt)
  {
    AppMethodBeat.i(188781);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      e locale = localObject[i];
      if (locale.code == paramInt)
      {
        AppMethodBeat.o(188781);
        return locale;
      }
      i += 1;
    }
    localObject = new IllegalStateException("AppBrandServiceType DeserializeFrom[Int] Unreached Code");
    AppMethodBeat.o(188781);
    throw ((Throwable)localObject);
  }
  
  public final Intent K(Intent paramIntent)
  {
    AppMethodBeat.i(188780);
    paramIntent.putExtra("AppBrandServiceType", this.code);
    AppMethodBeat.o(188780);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e
 * JD-Core Version:    0.7.0.1
 */