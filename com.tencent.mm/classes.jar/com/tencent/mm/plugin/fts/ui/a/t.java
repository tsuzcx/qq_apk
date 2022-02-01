package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.protocal.protobuf.fdz;
import com.tencent.mm.protocal.protobuf.fei;
import org.json.JSONObject;

public final class t
  extends n
{
  public fei xdP;
  public fdz xee;
  private a xef;
  
  public t(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112131);
    this.xef = new a();
    AppMethodBeat.o(112131);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112132);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      if ("HOME".equals(new JSONObject(this.xdP.NzC).optString("content_type", "")))
      {
        gE(2, 0);
        AppMethodBeat.o(112132);
        return;
      }
      gE(1, 0);
      AppMethodBeat.o(112132);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(112132);
    }
  }
  
  public final a.b axc()
  {
    return this.xef;
  }
  
  public final class a
    extends n.b
  {
    public a()
    {
      super();
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(235408);
      ((com.tencent.mm.plugin.websearch.api.h)g.af(com.tencent.mm.plugin.websearch.api.h.class)).b(paramContext, 60, "", t.this.wWd.wWB);
      AppMethodBeat.o(235408);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.t
 * JD-Core Version:    0.7.0.1
 */