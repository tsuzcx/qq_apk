package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.a;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.sdk.event.IListener;

class ShareMapUI$5
  extends IListener<acn>
{
  ShareMapUI$5(h paramh, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(264971);
    this.__eventId = acn.class.getName().hashCode();
    AppMethodBeat.o(264971);
  }
  
  private boolean a(acn paramacn)
  {
    AppMethodBeat.i(56119);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(56119);
      return false;
    }
    if (paramacn.ifU.hId == 3)
    {
      h.a(this.Kkh).xX(false);
      h.b(this.Kkh).stop();
      h.b(this.Kkh).ZC(2);
      h.c(this.Kkh);
      i.fVi();
      this.Kkh.activity.finish();
    }
    AppMethodBeat.o(56119);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.ShareMapUI.5
 * JD-Core Version:    0.7.0.1
 */