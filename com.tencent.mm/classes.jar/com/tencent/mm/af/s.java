package com.tencent.mm.af;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;

public final class s
  extends n
{
  public s()
  {
    AppMethodBeat.i(105480);
    this.fjD = new q();
    AppMethodBeat.o(105480);
  }
  
  private String Yq()
  {
    AppMethodBeat.i(141570);
    String str = p.aln(com.tencent.mm.at.q.ts(this.fjD.fjJ));
    AppMethodBeat.o(141570);
    return str;
  }
  
  public static boolean kr(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final String HD()
  {
    if (this.type == 285212721) {}
    for (int i = 1; i != 0; i = 0) {
      return this.userName;
    }
    return this.cqX;
  }
  
  public final void q(Bundle paramBundle)
  {
    AppMethodBeat.i(141569);
    try
    {
      if ((((h)g.RI().Rj()).SD()) && ((this.fjD.type == 5) || (this.fjD.type == 8)) && (this.fjE.size() == 0)) {
        this.fjE.add(Yq());
      }
      paramBundle.putByteArray("biz_mp_msg_info", toByteArray());
      paramBundle.putString("rawUrl", this.fjD.url);
      AppMethodBeat.o(141569);
      return;
    }
    catch (IOException paramBundle)
    {
      ab.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(141569);
    }
  }
  
  public final void r(Bundle paramBundle)
  {
    AppMethodBeat.i(141572);
    try
    {
      parseFrom(paramBundle.getByteArray("biz_mp_msg_info"));
      AppMethodBeat.o(141572);
      return;
    }
    catch (IOException paramBundle)
    {
      ab.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(141572);
      return;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(141572);
    }
  }
  
  public final void t(Intent paramIntent)
  {
    AppMethodBeat.i(141568);
    try
    {
      if ((((h)g.RI().Rj()).SD()) && ((this.fjD.type == 5) || (this.fjD.type == 8)) && (this.fjE.size() == 0)) {
        this.fjE.add(Yq());
      }
      paramIntent.putExtra("biz_mp_msg_info", toByteArray());
      paramIntent.putExtra("rawUrl", this.fjD.url);
      AppMethodBeat.o(141568);
      return;
    }
    catch (IOException paramIntent)
    {
      ab.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(141568);
    }
  }
  
  public final void u(Intent paramIntent)
  {
    AppMethodBeat.i(141571);
    try
    {
      parseFrom(paramIntent.getByteArrayExtra("biz_mp_msg_info"));
      AppMethodBeat.o(141571);
      return;
    }
    catch (IOException paramIntent)
    {
      ab.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(141571);
      return;
    }
    catch (Exception paramIntent)
    {
      ab.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(141571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.af.s
 * JD-Core Version:    0.7.0.1
 */