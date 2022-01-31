package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.pz.a;
import com.tencent.mm.kernel.g;

final class u$1
  implements f
{
  u$1(u paramu, pz parampz, Context paramContext) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40998);
    if ((this.kNW.gpx != null) && (this.kNW.gpx.isShowing()))
    {
      this.kNW.gpx.dismiss();
      this.kNW.gpx = null;
    }
    g.Rc().b(1800, this);
    paramString = (k)paramm;
    paramString.a(new u.1.3(this)).b(new u.1.2(this, paramString)).c(new u.1.1(this));
    this.kNV.cGy.callback.run();
    AppMethodBeat.o(40998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.u.1
 * JD-Core Version:    0.7.0.1
 */