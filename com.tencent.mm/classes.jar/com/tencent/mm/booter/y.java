package com.tencent.mm.booter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class y
{
  static final String iQX;
  Context context;
  
  static
  {
    AppMethodBeat.i(241750);
    iQX = "https://" + WeChatHosts.domainString(R.l.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/reportdevice";
    AppMethodBeat.o(241750);
  }
  
  public y(Context paramContext)
  {
    this.context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.y
 * JD-Core Version:    0.7.0.1
 */