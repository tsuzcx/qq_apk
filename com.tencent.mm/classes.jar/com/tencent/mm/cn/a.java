package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.Arrays;
import java.util.List;

public final class a
{
  public static final WeChatBrands.AppInfo.WhichApp RwA;
  public static final List<WeChatBrands.AppInfo.WhichApp> RwB;
  public static final WeChatBrands.AppInfo.WhichApp Rwx;
  public static final WeChatBrands.AppInfo.WhichApp Rwy;
  public static final WeChatBrands.AppInfo.WhichApp Rwz;
  
  static
  {
    AppMethodBeat.i(200985);
    Rwx = new WeChatBrands.AppInfo.WhichApp("com.wechat.mm", "WeChatUSApp", 3);
    Rwy = new WeChatBrands.AppInfo.WhichApp("com.wechatus.im", "WeChatUSApp", 3);
    WeChatBrands.AppInfo.WhichApp localWhichApp = new WeChatBrands.AppInfo.WhichApp("com.tencent.mm", "Weixin", 0);
    Rwz = localWhichApp;
    RwA = localWhichApp;
    RwB = Arrays.asList(new WeChatBrands.AppInfo.WhichApp[] { Rwz, Rwx, Rwy });
    AppMethodBeat.o(200985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cn.a
 * JD-Core Version:    0.7.0.1
 */