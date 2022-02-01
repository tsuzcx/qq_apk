package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.x;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class i
  extends j
{
  public View hIU;
  public View mZE;
  public TextView mZF;
  public MMNeat7extView mZG;
  public TextView mZi;
  public View mZj;
  public View mZk;
  public View mZl;
  public TextView mZm;
  public MMNeat7extView mZn;
  
  public i(Context paramContext, c paramc)
  {
    AppMethodBeat.i(192994);
    super.b(paramContext, paramc);
    AppMethodBeat.o(192994);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(192995);
    if (this.mYI != null) {
      this.mYI.setVisibility(8);
    }
    AppMethodBeat.o(192995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.i
 * JD-Core Version:    0.7.0.1
 */