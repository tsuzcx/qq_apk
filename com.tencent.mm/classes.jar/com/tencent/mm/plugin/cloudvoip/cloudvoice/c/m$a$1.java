package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

final class m$a$1
  extends n.a
{
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(156168);
    Object localObject = at.gU(ah.getContext());
    String str = ah.getProcessName();
    ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramInt), localObject, m.a.access$000() });
    localObject = new Bundle();
    ((Bundle)localObject).putString("from_process", str);
    ((Bundle)localObject).putInt("newState", paramInt);
    f.a(m.a.access$000(), (Parcelable)localObject, m.a.a.class, new m.a.1.1(this, str));
    AppMethodBeat.o(156168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.m.a.1
 * JD-Core Version:    0.7.0.1
 */