package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.a;
import com.tencent.mm.ui.base.sortview.a.b;

public final class h
  extends a
{
  private static a.b pnV;
  
  public h(Object paramObject)
  {
    super(0, paramObject);
    this.OZN = true;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs) {}
  
  public final a.b clS()
  {
    AppMethodBeat.i(5793);
    if (pnV == null) {
      pnV = new a.b()
      {
        public final void a(Context paramAnonymousContext, a.a paramAnonymousa, a paramAnonymousVarArgs) {}
        
        public final void a(View paramAnonymousView, a.a paramAnonymousa) {}
        
        public final boolean a(Context paramAnonymousContext, a paramAnonymousa, Object... paramAnonymousVarArgs)
        {
          return true;
        }
        
        public final View c(Context paramAnonymousContext, View paramAnonymousView)
        {
          AppMethodBeat.i(5792);
          View localView = paramAnonymousView;
          if (paramAnonymousView == null) {
            localView = new View(paramAnonymousContext);
          }
          AppMethodBeat.o(5792);
          return localView;
        }
      };
    }
    a.b localb = pnV;
    AppMethodBeat.o(5793);
    return localb;
  }
  
  public final a.a clT()
  {
    AppMethodBeat.i(5794);
    a locala = new a();
    AppMethodBeat.o(5794);
    return locala;
  }
  
  public static final class a
    implements a.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.h
 * JD-Core Version:    0.7.0.1
 */