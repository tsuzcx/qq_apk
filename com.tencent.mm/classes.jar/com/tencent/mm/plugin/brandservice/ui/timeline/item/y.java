package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class y
  extends af
{
  public View plj;
  public TextView vKF;
  public View vKG;
  public View vKH;
  public View vKI;
  public TextView vKJ;
  public MMNeat7extView vKK;
  public TextView vLA;
  public MMNeat7extView vLB;
  public View vLz;
  
  public y(Context paramContext, com.tencent.mm.plugin.brandservice.ui.timeline.b paramb)
  {
    AppMethodBeat.i(302767);
    super.a(paramContext, paramb);
    AppMethodBeat.o(302767);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(302772);
    if (this.vJU != null) {
      this.vJU.setVisibility(8);
    }
    AppMethodBeat.o(302772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.y
 * JD-Core Version:    0.7.0.1
 */