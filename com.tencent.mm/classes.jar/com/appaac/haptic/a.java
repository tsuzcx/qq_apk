package com.appaac.haptic;

import android.content.Context;
import android.os.Build.VERSION;
import com.appaac.haptic.c.b;
import com.appaac.haptic.c.c;
import com.appaac.haptic.c.c.-CC;
import com.appaac.haptic.c.d;
import com.appaac.haptic.c.e;
import com.appaac.haptic.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
  implements c
{
  private static final ExecutorService cqD;
  private d cqC;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(208410);
    cqD = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(208410);
  }
  
  private a() {}
  
  private a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(208404);
    new StringBuilder("sdk version:").append(com.appaac.haptic.a.a.VERSION_NAME).append(" versionCode:").append(com.appaac.haptic.a.a.VERSION_CODE).append(",playerType:").append(paramInt);
    this.mContext = paramContext;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(208404);
      return;
    case 0: 
      this.cqC = new b(this.mContext);
      AppMethodBeat.o(208404);
      return;
    case 2: 
      this.cqC = new e(this.mContext);
      AppMethodBeat.o(208404);
      return;
    }
    this.cqC = new f(this.mContext);
    AppMethodBeat.o(208404);
  }
  
  private static a A(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(208406);
    if (Build.VERSION.SDK_INT < 26)
    {
      AppMethodBeat.o(208406);
      return null;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(208406);
      return null;
    }
    if (!c.-CC.gX(paramInt))
    {
      AppMethodBeat.o(208406);
      return null;
    }
    paramContext = new a(paramContext, paramInt);
    AppMethodBeat.o(208406);
    return paramContext;
  }
  
  public static a aE(Context paramContext)
  {
    AppMethodBeat.i(208409);
    if (c.-CC.gX(2))
    {
      paramContext = A(paramContext, 2);
      AppMethodBeat.o(208409);
      return paramContext;
    }
    if (c.-CC.gX(1))
    {
      paramContext = A(paramContext, 1);
      AppMethodBeat.o(208409);
      return paramContext;
    }
    paramContext = A(paramContext, 0);
    AppMethodBeat.o(208409);
    return paramContext;
  }
  
  public final void Nn()
  {
    AppMethodBeat.i(208444);
    if (this.cqC != null) {
      this.cqC.Nn();
    }
    AppMethodBeat.o(208444);
  }
  
  public final void a(File paramFile, com.appaac.haptic.sync.a parama)
  {
    AppMethodBeat.i(208414);
    if (this.cqC == null)
    {
      AppMethodBeat.o(208414);
      return;
    }
    this.cqC.a(paramFile, parama);
    AppMethodBeat.o(208414);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(208440);
    if (this.cqC == null)
    {
      AppMethodBeat.o(208440);
      return;
    }
    this.cqC.pause();
    AppMethodBeat.o(208440);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(208420);
    if (this.cqC == null)
    {
      AppMethodBeat.o(208420);
      return;
    }
    this.cqC.prepare();
    AppMethodBeat.o(208420);
  }
  
  public final void release()
  {
    AppMethodBeat.i(208418);
    if (this.cqC != null) {
      this.cqC.release();
    }
    AppMethodBeat.o(208418);
  }
  
  public final void start()
  {
    AppMethodBeat.i(208425);
    if (this.cqC == null)
    {
      AppMethodBeat.o(208425);
      return;
    }
    this.cqC.start();
    AppMethodBeat.o(208425);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(208435);
    if (this.cqC == null)
    {
      AppMethodBeat.o(208435);
      return;
    }
    this.cqC.Nx();
    AppMethodBeat.o(208435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.a
 * JD-Core Version:    0.7.0.1
 */