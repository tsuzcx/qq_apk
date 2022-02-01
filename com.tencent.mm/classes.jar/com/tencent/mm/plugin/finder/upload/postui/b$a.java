package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.location.LocationView.a;
import com.tencent.mm.protocal.protobuf.alt;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onClickLocationView"})
public final class b$a
  implements LocationView.a
{
  public b$a(b paramb) {}
  
  public final void cCK()
  {
    float f2 = 0.0F;
    AppMethodBeat.i(203547);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 6);
    alt localalt = this.rOt.rOp;
    if (localalt != null) {}
    for (float f1 = localalt.dmL;; f1 = 0.0F)
    {
      localIntent.putExtra("get_lat", f1);
      localalt = this.rOt.rOp;
      f1 = f2;
      if (localalt != null) {
        f1 = localalt.doB;
      }
      localIntent.putExtra("get_lng", f1);
      d.b((Context)this.rOt.activity, "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, this.rOt.jWt);
      AppMethodBeat.o(203547);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.b.a
 * JD-Core Version:    0.7.0.1
 */