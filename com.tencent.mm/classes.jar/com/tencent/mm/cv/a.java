package com.tencent.mm.cv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.Arrays;
import java.util.List;

public final class a
{
  public static final WeChatBrands.AppInfo.WhichApp YXY;
  public static final WeChatBrands.AppInfo.WhichApp YXZ;
  public static final WeChatBrands.AppInfo.WhichApp YYa;
  public static final WeChatBrands.AppInfo.WhichApp YYb;
  public static final List<WeChatBrands.AppInfo.WhichApp> YYc;
  
  static
  {
    AppMethodBeat.i(248975);
    YXY = new WeChatBrands.AppInfo.WhichApp("com.wechat.mm", "WeChatUSApp", 3);
    YXZ = new WeChatBrands.AppInfo.WhichApp("com.wechatus.im", "WeChatUSApp", 3);
    WeChatBrands.AppInfo.WhichApp localWhichApp = new WeChatBrands.AppInfo.WhichApp("com.tencent.mm", "Weixin", 0);
    YYa = localWhichApp;
    YYb = localWhichApp;
    YYc = Arrays.asList(new WeChatBrands.AppInfo.WhichApp[] { YYa, YXY, YXZ });
    AppMethodBeat.o(248975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cv.a
 * JD-Core Version:    0.7.0.1
 */