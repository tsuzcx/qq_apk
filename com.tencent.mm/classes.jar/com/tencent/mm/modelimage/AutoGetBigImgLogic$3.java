package com.tencent.mm.modelimage;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ad;
import com.tencent.mm.autogen.a.ad.a;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;

class AutoGetBigImgLogic$3
  extends IListener<ad>
{
  AutoGetBigImgLogic$3(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(238986);
    this.__eventId = ad.class.getName().hashCode();
    AppMethodBeat.o(238986);
  }
  
  private boolean a(ad arg1)
  {
    AppMethodBeat.i(150514);
    this.oFW.oFS = ???.hzY.mode;
    Log.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.oFW.oFS);
    d.bId();
    if (!d.bIe()) {}
    synchronized (this.oFW.oFK)
    {
      this.oFW.oFK.clear();
      AppMethodBeat.o(150514);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.AutoGetBigImgLogic.3
 * JD-Core Version:    0.7.0.1
 */