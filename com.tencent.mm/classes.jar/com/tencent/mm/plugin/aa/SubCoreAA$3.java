package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cp;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.aa.model.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d.a;

class SubCoreAA$3
  extends IListener<cp>
{
  SubCoreAA$3(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(268378);
    this.__eventId = cp.class.getName().hashCode();
    AppMethodBeat.o(268378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.SubCoreAA.3
 * JD-Core Version:    0.7.0.1
 */