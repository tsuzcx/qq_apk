package com.tencent.mm.ag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class x
  extends s
{
  public x()
  {
    AppMethodBeat.i(116419);
    this.iAi = new v();
    AppMethodBeat.o(116419);
  }
  
  private String aSA()
  {
    AppMethodBeat.i(116422);
    String str = com.tencent.mm.pluginsdk.model.s.bdu(b.u(this.iAi.iAo, 4));
    AppMethodBeat.o(116422);
    return str;
  }
  
  public static boolean rK(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void A(Bundle paramBundle)
  {
    AppMethodBeat.i(116424);
    try
    {
      parseFrom(paramBundle.getByteArray("biz_mp_msg_info"));
      AppMethodBeat.o(116424);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116424);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116424);
    }
  }
  
  public final String ajO()
  {
    if (this.type == 285212721) {}
    for (int i = 1; i != 0; i = 0) {
      return this.userName;
    }
    return this.dHc;
  }
  
  public final void t(Intent paramIntent)
  {
    AppMethodBeat.i(116420);
    try
    {
      if ((((h)g.aAe().azG()).aBb()) && ((this.iAi.type == 5) || (this.iAi.type == 8)) && (this.iAj.size() == 0)) {
        this.iAj.add(aSA());
      }
      paramIntent.putExtra("biz_mp_msg_info", toByteArray());
      paramIntent.putExtra("rawUrl", this.iAi.url);
      AppMethodBeat.o(116420);
      return;
    }
    catch (IOException paramIntent)
    {
      Log.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116420);
    }
  }
  
  public final void u(Intent paramIntent)
  {
    AppMethodBeat.i(116423);
    try
    {
      parseFrom(paramIntent.getByteArrayExtra("biz_mp_msg_info"));
      AppMethodBeat.o(116423);
      return;
    }
    catch (IOException paramIntent)
    {
      Log.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116423);
      return;
    }
    catch (Exception paramIntent)
    {
      Log.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116423);
    }
  }
  
  public final void z(Bundle paramBundle)
  {
    AppMethodBeat.i(116421);
    try
    {
      if ((((h)g.aAe().azG()).aBb()) && ((this.iAi.type == 5) || (this.iAi.type == 8)) && (this.iAj.size() == 0)) {
        this.iAj.add(aSA());
      }
      paramBundle.putByteArray("biz_mp_msg_info", toByteArray());
      paramBundle.putString("rawUrl", this.iAi.url);
      AppMethodBeat.o(116421);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.x
 * JD-Core Version:    0.7.0.1
 */