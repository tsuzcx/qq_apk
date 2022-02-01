package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "", "code", "", "errorMsg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "SUCCESS", "ILLEGAL_LINK", "DECODE_LINK_FAIL", "USER_CANCEL", "CONTEXT_RELEASE", "INTERRUPT", "LAUNCH_PHASE_FAIL", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum WxaShortLinkLaunchErrorCode
{
  private final int code;
  private final String errorMsg;
  
  static
  {
    AppMethodBeat.i(321890);
    SUCCESS = new WxaShortLinkLaunchErrorCode("SUCCESS", 0, 0, "OK");
    ILLEGAL_LINK = new WxaShortLinkLaunchErrorCode("ILLEGAL_LINK", 1, -1001, "illegal link");
    DECODE_LINK_FAIL = new WxaShortLinkLaunchErrorCode("DECODE_LINK_FAIL", 2, -1002, "decode link fail");
    USER_CANCEL = new WxaShortLinkLaunchErrorCode("USER_CANCEL", 3, -1003, "user cancel");
    CONTEXT_RELEASE = new WxaShortLinkLaunchErrorCode("CONTEXT_RELEASE", 4, -1004, "context release");
    INTERRUPT = new WxaShortLinkLaunchErrorCode("INTERRUPT", 5, -1005, "interrupt");
    LAUNCH_PHASE_FAIL = new WxaShortLinkLaunchErrorCode("LAUNCH_PHASE_FAIL", 6, -1006, "launch phase fail");
    $VALUES = $values();
    AppMethodBeat.o(321890);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode
 * JD-Core Version:    0.7.0.1
 */