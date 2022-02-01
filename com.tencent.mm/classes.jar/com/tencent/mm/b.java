package com.tencent.mm;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.m.c;
import io.flutter.a.a.m.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.f;

public final class b
  extends io.flutter.app.c
{
  private io.flutter.embedding.engine.a cGL;
  
  public b(io.flutter.embedding.engine.a parama, Context paramContext)
  {
    super(paramContext);
    this.cGL = parama;
  }
  
  public final m.c dB(String paramString)
  {
    AppMethodBeat.i(159063);
    paramString = new a(super.dB(paramString));
    AppMethodBeat.o(159063);
    return paramString;
  }
  
  public final class a
    implements m.c
  {
    private m.c cGM;
    
    public a(m.c paramc)
    {
      this.cGM = paramc;
    }
    
    public final Activity IH()
    {
      AppMethodBeat.i(159056);
      Activity localActivity = this.cGM.IH();
      AppMethodBeat.o(159056);
      return localActivity;
    }
    
    public final Context II()
    {
      AppMethodBeat.i(159057);
      Context localContext = this.cGM.II();
      AppMethodBeat.o(159057);
      return localContext;
    }
    
    public final io.flutter.a.a.c IJ()
    {
      AppMethodBeat.i(159058);
      DartExecutor localDartExecutor = b.a(b.this).IYe;
      AppMethodBeat.o(159058);
      return localDartExecutor;
    }
    
    public final f IK()
    {
      AppMethodBeat.i(159059);
      io.flutter.embedding.engine.b.a locala = b.a(b.this).IXd;
      AppMethodBeat.o(159059);
      return locala;
    }
    
    public final String J(String paramString1, String paramString2)
    {
      AppMethodBeat.i(159061);
      paramString1 = this.cGM.J(paramString1, paramString2);
      AppMethodBeat.o(159061);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(159062);
      paramf = this.cGM.a(paramf);
      AppMethodBeat.o(159062);
      return paramf;
    }
    
    public final String dC(String paramString)
    {
      AppMethodBeat.i(159060);
      paramString = this.cGM.dC(paramString);
      AppMethodBeat.o(159060);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.b
 * JD-Core Version:    0.7.0.1
 */