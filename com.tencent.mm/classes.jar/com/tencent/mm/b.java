package com.tencent.mm;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.m.c;
import io.flutter.plugin.a.m.f;

public final class b
  extends io.flutter.app.c
{
  private io.flutter.embedding.engine.a cDT;
  
  public b(io.flutter.embedding.engine.a parama, Context paramContext)
  {
    super(paramContext);
    this.cDT = parama;
  }
  
  public final m.c dq(String paramString)
  {
    AppMethodBeat.i(159063);
    paramString = new a(super.dq(paramString));
    AppMethodBeat.o(159063);
    return paramString;
  }
  
  public final class a
    implements m.c
  {
    private m.c cDU;
    
    public a(m.c paramc)
    {
      this.cDU = paramc;
    }
    
    public final Activity Iq()
    {
      AppMethodBeat.i(159056);
      if (this.cDU.Iq() != null)
      {
        localActivity = this.cDU.Iq();
        AppMethodBeat.o(159056);
        return localActivity;
      }
      Activity localActivity = d.fHA().KuF;
      AppMethodBeat.o(159056);
      return localActivity;
    }
    
    public final Context Ir()
    {
      AppMethodBeat.i(159057);
      Context localContext = this.cDU.Ir();
      AppMethodBeat.o(159057);
      return localContext;
    }
    
    public final io.flutter.plugin.a.c Is()
    {
      AppMethodBeat.i(159058);
      DartExecutor localDartExecutor = b.a(b.this).KLk;
      AppMethodBeat.o(159058);
      return localDartExecutor;
    }
    
    public final io.flutter.view.c It()
    {
      AppMethodBeat.i(159059);
      io.flutter.embedding.engine.b.a locala = b.a(b.this).KKo;
      AppMethodBeat.o(159059);
      return locala;
    }
    
    public final String K(String paramString1, String paramString2)
    {
      AppMethodBeat.i(159061);
      paramString1 = this.cDU.K(paramString1, paramString2);
      AppMethodBeat.o(159061);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(159062);
      paramf = this.cDU.a(paramf);
      AppMethodBeat.o(159062);
      return paramf;
    }
    
    public final String dr(String paramString)
    {
      AppMethodBeat.i(159060);
      paramString = this.cDU.dr(paramString);
      AppMethodBeat.o(159060);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.b
 * JD-Core Version:    0.7.0.1
 */