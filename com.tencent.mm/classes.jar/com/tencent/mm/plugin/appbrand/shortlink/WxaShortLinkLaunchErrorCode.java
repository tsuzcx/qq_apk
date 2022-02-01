package com.tencent.mm.plugin.appbrand.shortlink;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "", "code", "", "errorMsg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "SUCCESS", "ILLEGAL_LINK", "DECODE_LINK_FAIL", "USER_CANCEL", "CONTEXT_RELEASE", "INTERRUPT", "LAUNCH_PHASE_FAIL", "luggage-wechat-full-sdk_release"})
@Keep
public enum WxaShortLinkLaunchErrorCode
{
  private final int code;
  private final String errorMsg;
  
  static
  {
    AppMethodBeat.i(243683);
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode1 = new WxaShortLinkLaunchErrorCode("SUCCESS", 0, 0, "OK");
    SUCCESS = localWxaShortLinkLaunchErrorCode1;
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode2 = new WxaShortLinkLaunchErrorCode("ILLEGAL_LINK", 1, -1001, "illegal link");
    ILLEGAL_LINK = localWxaShortLinkLaunchErrorCode2;
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode3 = new WxaShortLinkLaunchErrorCode("DECODE_LINK_FAIL", 2, -1002, "decode link fail");
    DECODE_LINK_FAIL = localWxaShortLinkLaunchErrorCode3;
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode4 = new WxaShortLinkLaunchErrorCode("USER_CANCEL", 3, -1003, "user cancel");
    USER_CANCEL = localWxaShortLinkLaunchErrorCode4;
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode5 = new WxaShortLinkLaunchErrorCode("CONTEXT_RELEASE", 4, -1004, "context release");
    CONTEXT_RELEASE = localWxaShortLinkLaunchErrorCode5;
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode6 = new WxaShortLinkLaunchErrorCode("INTERRUPT", 5, -1005, "interrupt");
    INTERRUPT = localWxaShortLinkLaunchErrorCode6;
    WxaShortLinkLaunchErrorCode localWxaShortLinkLaunchErrorCode7 = new WxaShortLinkLaunchErrorCode("LAUNCH_PHASE_FAIL", 6, -1006, "launch phase fail");
    LAUNCH_PHASE_FAIL = localWxaShortLinkLaunchErrorCode7;
    $VALUES = new WxaShortLinkLaunchErrorCode[] { localWxaShortLinkLaunchErrorCode1, localWxaShortLinkLaunchErrorCode2, localWxaShortLinkLaunchErrorCode3, localWxaShortLinkLaunchErrorCode4, localWxaShortLinkLaunchErrorCode5, localWxaShortLinkLaunchErrorCode6, localWxaShortLinkLaunchErrorCode7 };
    AppMethodBeat.o(243683);
  }
  
  private WxaShortLinkLaunchErrorCode(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.errorMsg = paramString;
  }
  
  public final int getCode()
  {
    return this.code;
  }
  
  public final String getErrorMsg()
  {
    return this.errorMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode
 * JD-Core Version:    0.7.0.1
 */