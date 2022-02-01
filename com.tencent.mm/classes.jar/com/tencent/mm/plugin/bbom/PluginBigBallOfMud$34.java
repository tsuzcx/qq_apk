package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.a.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class PluginBigBallOfMud$34
  implements a.a
{
  PluginBigBallOfMud$34(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String bll()
  {
    AppMethodBeat.i(22406);
    if (ChannelUtil.isNokiaAol)
    {
      str = MMApplicationContext.getContext().getString(R.l.safe_device_android_device_nm);
      AppMethodBeat.o(22406);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(R.l.safe_device_android_device);
    AppMethodBeat.o(22406);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.34
 * JD-Core Version:    0.7.0.1
 */