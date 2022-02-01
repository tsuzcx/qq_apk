package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.protocal.protobuf.dvu;
import com.tencent.mm.protocal.protobuf.dwd;
import org.json.JSONObject;

public final class t
  extends n
{
  public dvu rwB;
  private a rwC;
  public dwd rwo;
  
  public t(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112131);
    this.rwC = new a();
    AppMethodBeat.o(112131);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112132);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      if ("HOME".equals(new JSONObject(this.rwo.EJU).optString("content_type", "")))
      {
        fI(2, 0);
        AppMethodBeat.o(112132);
        return;
      }
      fI(1, 0);
      AppMethodBeat.o(112132);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(112132);
    }
  }
  
  public final a.b acQ()
  {
    return this.rwC;
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
      ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(paramContext, 60, "", t.this.roS.rpq);
      AppMethodBeat.o(112130);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.t
 * JD-Core Version:    0.7.0.1
 */