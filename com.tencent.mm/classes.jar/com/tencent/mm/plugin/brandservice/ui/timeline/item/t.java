package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.x;
import com.tencent.mm.br.d;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class t
  extends w
{
  public View iFF;
  public TextView ojL;
  public View ojM;
  public View ojN;
  public View ojO;
  public TextView ojP;
  public MMNeat7extView ojQ;
  public View okE;
  public TextView okF;
  public MMNeat7extView okG;
  
  public t(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(208485);
    super.b(paramContext, paramb);
    AppMethodBeat.o(208485);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(208486);
    if (this.oiV != null) {
      this.oiV.setVisibility(8);
    }
    AppMethodBeat.o(208486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.t
 * JD-Core Version:    0.7.0.1
 */