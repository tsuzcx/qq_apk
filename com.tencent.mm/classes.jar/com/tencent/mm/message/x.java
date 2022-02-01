package com.tencent.mm.message;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;

public final class x
  extends s
{
  public x()
  {
    AppMethodBeat.i(116419);
    this.nUG = new v();
    AppMethodBeat.o(116419);
  }
  
  private String bwr()
  {
    AppMethodBeat.i(116422);
    String str = y.bpF(b.U(this.nUG.nUM, 4));
    AppMethodBeat.o(116422);
    return str;
  }
  
  public static boolean uE(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void N(Bundle paramBundle)
  {
    AppMethodBeat.i(116421);
    try
    {
      if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) && ((this.nUG.type == 5) || (this.nUG.type == 8)) && (this.nUH.size() == 0)) {
        this.nUH.add(bwr());
      }
      paramBundle.putByteArray("biz_mp_msg_info", toByteArray());
      paramBundle.putString("rawUrl", this.nUG.url);
      AppMethodBeat.o(116421);
      return;
    }
    catch (IOException paramBundle)
    {
      Log.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116421);
    }
  }
  
  public final String aJK()
  {
    if (this.type == 285212721) {}
    for (int i = 1; i != 0; i = 0) {
      return this.userName;
    }
    return this.hEE;
  }
  
  public final void w(Intent paramIntent)
  {
    AppMethodBeat.i(116420);
    try
    {
      if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) && ((this.nUG.type == 5) || (this.nUG.type == 8)) && (this.nUH.size() == 0)) {
        this.nUH.add(bwr());
      }
      paramIntent.putExtra("biz_mp_msg_info", toByteArray());
      paramIntent.putExtra("rawUrl", this.nUG.url);
      AppMethodBeat.o(116420);
      return;
    }
    catch (IOException paramIntent)
    {
      Log.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.message.x
 * JD-Core Version:    0.7.0.1
 */