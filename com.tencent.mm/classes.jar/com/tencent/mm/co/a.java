package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.Arrays;
import java.util.List;

public final class a
{
  public static final WeChatBrands.AppInfo.WhichApp agWd;
  public static final WeChatBrands.AppInfo.WhichApp agWe;
  public static final WeChatBrands.AppInfo.WhichApp agWf;
  public static final WeChatBrands.AppInfo.WhichApp agWg;
  public static final List<WeChatBrands.AppInfo.WhichApp> agWh;
  
  static
  {
    AppMethodBeat.i(233921);
    agWd = new WeChatBrands.AppInfo.WhichApp("com.wechat.mm", "WeChatUSApp", 3);
    agWe = new WeChatBrands.AppInfo.WhichApp("com.wechatus.im", "WeChatUSApp", 3);
    WeChatBrands.AppInfo.WhichApp localWhichApp = new WeChatBrands.AppInfo.WhichApp("com.tencent.mm", "Weixin", 0);
    agWf = localWhichApp;
    agWg = localWhichApp;
    agWh = Arrays.asList(new WeChatBrands.AppInfo.WhichApp[] { agWf, agWd, agWe });
    AppMethodBeat.o(233921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.co.a
 * JD-Core Version:    0.7.0.1
 */