package com.tencent.mm.ai;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.LinkedList;

public final class x
  extends s
{
  public x()
  {
    AppMethodBeat.i(116419);
    this.gKx = new v();
    AppMethodBeat.o(116419);
  }
  
  private String apC()
  {
    AppMethodBeat.i(116422);
    String str = r.aAK(b.q(this.gKx.gKD, 4));
    AppMethodBeat.o(116422);
    return str;
  }
  
  public static boolean mW(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final String SI()
  {
    if (this.type == 285212721) {}
    for (int i = 1; i != 0; i = 0) {
      return this.userName;
    }
    return this.dfT;
  }
  
  public final void s(Bundle paramBundle)
  {
    AppMethodBeat.i(116421);
    try
    {
      if ((((h)g.afy().aeZ()).agu()) && ((this.gKx.type == 5) || (this.gKx.type == 8)) && (this.gKy.size() == 0)) {
        this.gKy.add(apC());
      }
      paramBundle.putByteArray("biz_mp_msg_info", toByteArray());
      paramBundle.putString("rawUrl", this.gKx.url);
      AppMethodBeat.o(116421);
      return;
    }
    catch (IOException paramBundle)
    {
      ad.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116421);
    }
  }
  
  public final void t(Intent paramIntent)
  {
    AppMethodBeat.i(116420);
    try
    {
      if ((((h)g.afy().aeZ()).agu()) && ((this.gKx.type == 5) || (this.gKx.type == 8)) && (this.gKy.size() == 0)) {
        this.gKy.add(apC());
      }
      paramIntent.putExtra("biz_mp_msg_info", toByteArray());
      paramIntent.putExtra("rawUrl", this.gKx.url);
      AppMethodBeat.o(116420);
      return;
    }
    catch (IOException paramIntent)
    {
      ad.e("MicroMsg.MPMsgInfo", "writeToIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116420);
    }
  }
  
  public final void t(Bundle paramBundle)
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
      ad.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116424);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.MPMsgInfo", "parseFromBundle %s", new Object[] { paramBundle.getMessage() });
      AppMethodBeat.o(116424);
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
      ad.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116423);
      return;
    }
    catch (Exception paramIntent)
    {
      ad.e("MicroMsg.MPMsgInfo", "parseFromIntent %s", new Object[] { paramIntent.getMessage() });
      AppMethodBeat.o(116423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.x
 * JD-Core Version:    0.7.0.1
 */