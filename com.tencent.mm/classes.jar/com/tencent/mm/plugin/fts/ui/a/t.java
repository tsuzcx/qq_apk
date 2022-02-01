package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.ejp;
import org.json.JSONObject;

public final class t
  extends n
{
  public ejp tMP;
  public ejg tNe;
  private a tNf;
  
  public t(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112131);
    this.tNf = new a();
    AppMethodBeat.o(112131);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112132);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      if ("HOME".equals(new JSONObject(this.tMP.ImA).optString("content_type", "")))
      {
        gf(2, 0);
        AppMethodBeat.o(112132);
        return;
      }
      gf(1, 0);
      AppMethodBeat.o(112132);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(112132);
    }
  }
  
  public final a.b agQ()
  {
    return this.tNf;
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
      ((com.tencent.mm.plugin.websearch.api.h)g.ab(com.tencent.mm.plugin.websearch.api.h.class)).a(paramContext, 60, "", t.this.tFe.tFC);
      AppMethodBeat.o(112130);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.t
 * JD-Core Version:    0.7.0.1
 */