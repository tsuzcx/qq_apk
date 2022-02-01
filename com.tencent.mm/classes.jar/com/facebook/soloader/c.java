package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c
  extends o
{
  private Context applicationContext;
  public e cCt;
  private int flags;
  
  public c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(208071);
    this.applicationContext = paramContext.getApplicationContext();
    if (this.applicationContext == null)
    {
      new StringBuilder("context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: ").append(paramContext.getApplicationInfo().nativeLibraryDir);
      this.applicationContext = paramContext;
    }
    this.flags = paramInt;
    this.cCt = new e(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), paramInt);
    AppMethodBeat.o(208071);
  }
  
  public static File aI(Context paramContext)
  {
    AppMethodBeat.i(208083);
    paramContext = new File(paramContext.getApplicationInfo().nativeLibraryDir);
    AppMethodBeat.o(208083);
    return paramContext;
  }
  
  public final boolean PQ()
  {
    AppMethodBeat.i(208097);
    File localFile1 = this.cCt.cCx;
    Context localContext = PR();
    File localFile2 = aI(localContext);
    if (!localFile1.equals(localFile2))
    {
      new StringBuilder("Native library directory updated from ").append(localFile1).append(" to ").append(localFile2);
      this.flags |= 0x1;
      this.cCt = new e(localFile2, this.flags);
      this.cCt.hi(this.flags);
      this.applicationContext = localContext;
      AppMethodBeat.o(208097);
      return true;
    }
    AppMethodBeat.o(208097);
    return false;
  }
  
  public final Context PR()
  {
    AppMethodBeat.i(208113);
    try
    {
      Context localContext = this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
      AppMethodBeat.o(208113);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localNameNotFoundException);
      AppMethodBeat.o(208113);
      throw localRuntimeException;
    }
  }
  
  public final int a(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    AppMethodBeat.i(208123);
    paramInt = this.cCt.a(paramString, paramInt, paramThreadPolicy);
    AppMethodBeat.o(208123);
    return paramInt;
  }
  
  protected final void hi(int paramInt)
  {
    AppMethodBeat.i(208134);
    this.cCt.hi(paramInt);
    AppMethodBeat.o(208134);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208143);
    String str = this.cCt.toString();
    AppMethodBeat.o(208143);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.c
 * JD-Core Version:    0.7.0.1
 */