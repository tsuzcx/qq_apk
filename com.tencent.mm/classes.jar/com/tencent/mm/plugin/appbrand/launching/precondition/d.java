package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d
  extends a
{
  private static final Map<String, d> inY;
  private final WeakReference<Context> aon;
  private final String inZ;
  private final String ioa;
  
  static
  {
    AppMethodBeat.i(132073);
    inY = new ConcurrentHashMap();
    AppMethodBeat.o(132073);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(132071);
    this.inZ = paramString;
    this.ioa = paramContext.getClass().getName();
    this.aon = new WeakReference(paramContext);
    this.inL = paramBoolean;
    inY.put(paramString, this);
    paramContext = new d.a(paramString);
    long l = TimeUnit.SECONDS.toMillis(300L);
    paramContext.ag(l, l);
    AppMethodBeat.o(132071);
  }
  
  public static d Dr(String paramString)
  {
    AppMethodBeat.i(132070);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132070);
      return null;
    }
    paramString = (d)inY.remove(paramString);
    AppMethodBeat.o(132070);
    return paramString;
  }
  
  protected final String aHs()
  {
    return this.ioa;
  }
  
  protected final Context aHu()
  {
    AppMethodBeat.i(132072);
    Context localContext = (Context)this.aon.get();
    AppMethodBeat.o(132072);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.d
 * JD-Core Version:    0.7.0.1
 */