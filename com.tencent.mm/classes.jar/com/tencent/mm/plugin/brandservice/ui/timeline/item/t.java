package com.tencent.mm.plugin.brandservice.ui.timeline.item;

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
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class t
  extends v
{
  public View iCM;
  public TextView odV;
  public View odW;
  public View odX;
  public View odY;
  public TextView odZ;
  public View oeL;
  public TextView oeM;
  public MMNeat7extView oeN;
  public MMNeat7extView oea;
  
  public t(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(209529);
    super.b(paramContext, paramb);
    AppMethodBeat.o(209529);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(209530);
    if (this.odh != null) {
      this.odh.setVisibility(8);
    }
    AppMethodBeat.o(209530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.t
 * JD-Core Version:    0.7.0.1
 */