package com.tencent.mm.plugin.brandservice.ui.timeline.a;

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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class i
  extends j
{
  public View ijv;
  public TextView nBG;
  public View nBH;
  public View nBI;
  public View nBJ;
  public TextView nBK;
  public MMNeat7extView nBL;
  public View nCc;
  public TextView nCd;
  public MMNeat7extView nCe;
  
  public i(Context paramContext, c paramc)
  {
    AppMethodBeat.i(198716);
    super.b(paramContext, paramc);
    AppMethodBeat.o(198716);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(198717);
    if (this.nBh != null) {
      this.nBh.setVisibility(8);
    }
    AppMethodBeat.o(198717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.i
 * JD-Core Version:    0.7.0.1
 */