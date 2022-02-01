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
  private io.flutter.embedding.engine.a cPI;
  
  public b(io.flutter.embedding.engine.a parama, Context paramContext)
  {
    super(paramContext);
    this.cPI = parama;
  }
  
  public final m.c er(String paramString)
  {
    AppMethodBeat.i(159063);
    paramString = new a(super.er(paramString));
    AppMethodBeat.o(159063);
    return paramString;
  }
  
  public final class a
    implements m.c
  {
    private m.c cPJ;
    
    public a(m.c paramc)
    {
      this.cPJ = paramc;
    }
    
    public final Activity JY()
    {
      AppMethodBeat.i(159056);
      Activity localActivity;
      if (this.cPJ.JY() != null)
      {
        localActivity = this.cPJ.JY();
        AppMethodBeat.o(159056);
        return localActivity;
      }
      if (d.gdr().MHD != null)
      {
        localActivity = d.gdr().MHD.getActivity();
        AppMethodBeat.o(159056);
        return localActivity;
      }
      AppMethodBeat.o(159056);
      return null;
    }
    
    public final Context JZ()
    {
      AppMethodBeat.i(159057);
      Context localContext = this.cPJ.JZ();
      AppMethodBeat.o(159057);
      return localContext;
    }
    
    public final io.flutter.plugin.a.c Ka()
    {
      AppMethodBeat.i(159058);
      DartExecutor localDartExecutor = b.a(b.this).MZm;
      AppMethodBeat.o(159058);
      return localDartExecutor;
    }
    
    public final io.flutter.view.c Kb()
    {
      AppMethodBeat.i(159059);
      io.flutter.embedding.engine.b.a locala = b.a(b.this).MYh;
      AppMethodBeat.o(159059);
      return locala;
    }
    
    public final String L(String paramString1, String paramString2)
    {
      AppMethodBeat.i(159061);
      paramString1 = this.cPJ.L(paramString1, paramString2);
      AppMethodBeat.o(159061);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(159062);
      paramf = this.cPJ.a(paramf);
      AppMethodBeat.o(159062);
      return paramf;
    }
    
    public final String es(String paramString)
    {
      AppMethodBeat.i(159060);
      paramString = this.cPJ.es(paramString);
      AppMethodBeat.o(159060);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.b
 * JD-Core Version:    0.7.0.1
 */