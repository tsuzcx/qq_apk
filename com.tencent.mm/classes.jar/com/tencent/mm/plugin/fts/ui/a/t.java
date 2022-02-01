package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.ebu;
import org.json.JSONObject;

public final class t
  extends n
{
  public ebu sFg;
  public ebl sFt;
  private a sFu;
  
  public t(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112131);
    this.sFu = new a();
    AppMethodBeat.o(112131);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112132);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      if ("HOME".equals(new JSONObject(this.sFg.Ghg).optString("content_type", "")))
      {
        fP(2, 0);
        AppMethodBeat.o(112132);
        return;
      }
      fP(1, 0);
      AppMethodBeat.o(112132);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(112132);
    }
  }
  
  public final a.b adW()
  {
    return this.sFu;
  }
  
  public final class a
    extends n.b
  {
    public a()
    {
      super();
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112130);
      ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(paramContext, 60, "", t.this.sxM.syk);
      AppMethodBeat.o(112130);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.t
 * JD-Core Version:    0.7.0.1
 */