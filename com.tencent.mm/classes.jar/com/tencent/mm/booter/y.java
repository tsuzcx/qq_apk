package com.tencent.mm.booter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class y
{
  static final String gmO;
  Context context;
  
  static
  {
    AppMethodBeat.i(231498);
    gmO = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/reportdevice";
    AppMethodBeat.o(231498);
  }
  
  public y(Context paramContext)
  {
    this.context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.y
 * JD-Core Version:    0.7.0.1
 */