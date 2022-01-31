package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;

final class PluginBigBallOfMud$10
  implements a.a
{
  PluginBigBallOfMud$10(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String NX()
  {
    if (e.uen) {
      return ae.getContext().getString(R.l.safe_device_android_device_nm);
    }
    return ae.getContext().getString(R.l.safe_device_android_device);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.10
 * JD-Core Version:    0.7.0.1
 */