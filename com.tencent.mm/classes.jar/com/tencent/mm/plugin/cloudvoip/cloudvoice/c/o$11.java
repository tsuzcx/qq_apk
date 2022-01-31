package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$11
  extends PhoneStateListener
{
  o$11(o paramo) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(135528);
    super.onCallStateChanged(paramInt, paramString);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(135528);
      return;
      this.kLI.O(new o.11.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.11
 * JD-Core Version:    0.7.0.1
 */