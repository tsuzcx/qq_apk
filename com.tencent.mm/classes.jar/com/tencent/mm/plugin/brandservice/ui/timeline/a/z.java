package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class z
  extends j
{
  public View ijv;
  public View nCJ;
  public View nCK;
  public ImageView nCo;
  public MMNeat7extView nCy;
  public TextView nDK;
  public ImageView nDM;
  public ImageView nDN;
  public MMNeat7extView nDO;
  public View nDl;
  
  public final View a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(6071);
    super.b(paramContext, paramc);
    if (this.nBh != null)
    {
      paramContext = this.nBh;
      AppMethodBeat.o(6071);
      return paramContext;
    }
    this.nBh = View.inflate(paramContext, 2131493231, null);
    bKj();
    this.nCy = ((MMNeat7extView)this.nBh.findViewById(2131305948));
    this.nDK = ((TextView)this.nBh.findViewById(2131303288));
    this.nCo = ((ImageView)this.nBh.findViewById(2131297219));
    this.nDl = this.nBh.findViewById(2131298114);
    this.ijv = this.nBh.findViewById(2131306012);
    this.nDO = ((MMNeat7extView)this.nBh.findViewById(2131305938));
    this.nCJ = this.nBh.findViewById(2131297350);
    this.nCK = this.nBh.findViewById(2131304857);
    this.nDM = ((ImageView)this.nBh.findViewById(2131303284));
    this.nDN = ((ImageView)this.nBh.findViewById(2131298824));
    paramContext = this.nBh;
    AppMethodBeat.o(6071);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.z
 * JD-Core Version:    0.7.0.1
 */