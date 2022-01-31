package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.ck.a;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;

public final class h
  extends g
{
  public ApplicationLike dMU;
  public a<ApplicationLifeCycle> dMV = new a();
  public c diu;
  public e mProfileCompat;
  
  public h(String paramString, Application paramApplication, ApplicationLike paramApplicationLike)
  {
    super(paramString, paramApplication);
    ae.bw(paramString);
    this.dMU = paramApplicationLike;
  }
  
  public final String getPackageName()
  {
    return ae.getPackageName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.h
 * JD-Core Version:    0.7.0.1
 */