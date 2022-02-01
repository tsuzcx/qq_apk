package com.tencent.mm.plugin.crashfix.patch.phonestateoverflow;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aau;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

class PhoneStateOverflow$1
  extends IListener<aau>
{
  PhoneStateOverflow$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(261551);
    this.__eventId = aau.class.getName().hashCode();
    AppMethodBeat.o(261551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.phonestateoverflow.PhoneStateOverflow.1
 * JD-Core Version:    0.7.0.1
 */