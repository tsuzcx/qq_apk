package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class VerifyCodeInfo
{
  public int appSeq;
  public int ssoSeq;
  public int svrSeqNo;
  public String uin;
  public String verifyNote;
  public byte[] verifyimage;
  public String verifyurl;
  public String vpicSid;
  public int wupSeq;
  
  public static VerifyCodeInfo getVerifyCodeInfo(FromServiceMsg paramFromServiceMsg)
  {
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.verifyimage = ((byte[])paramFromServiceMsg.getAttribute("resp_verify_image"));
    localVerifyCodeInfo.verifyNote = ((String)paramFromServiceMsg.getAttribute("resp_verify_msg"));
    localVerifyCodeInfo.svrSeqNo = ((Integer)paramFromServiceMsg.getAttribute("resp_verify_svrSeq")).intValue();
    localVerifyCodeInfo.vpicSid = ((String)paramFromServiceMsg.getAttribute("resp_verify_picSid"));
    localVerifyCodeInfo.wupSeq = ((Integer)paramFromServiceMsg.getAttribute("resp_verify_wupSeq")).intValue();
    localVerifyCodeInfo.ssoSeq = ((Integer)paramFromServiceMsg.getAttribute("resp_verify_ssoSeq")).intValue();
    localVerifyCodeInfo.uin = paramFromServiceMsg.getUin();
    localVerifyCodeInfo.verifyurl = ((String)paramFromServiceMsg.getAttribute("resp_verify_url"));
    localVerifyCodeInfo.appSeq = paramFromServiceMsg.getAppSeq();
    return localVerifyCodeInfo;
  }
  
  public static VerifyCodeInfo getVerifyCodeInfo(ToServiceMsg paramToServiceMsg)
  {
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.verifyimage = ((byte[])paramToServiceMsg.getAttribute("resp_verify_image"));
    localVerifyCodeInfo.verifyNote = ((String)paramToServiceMsg.getAttribute("resp_verify_msg"));
    localVerifyCodeInfo.svrSeqNo = ((Integer)paramToServiceMsg.getAttribute("resp_verify_svrSeq")).intValue();
    localVerifyCodeInfo.vpicSid = ((String)paramToServiceMsg.getAttribute("resp_verify_picSid"));
    localVerifyCodeInfo.wupSeq = ((Integer)paramToServiceMsg.getAttribute("resp_verify_wupSeq")).intValue();
    localVerifyCodeInfo.ssoSeq = ((Integer)paramToServiceMsg.getAttribute("resp_verify_ssoSeq")).intValue();
    localVerifyCodeInfo.uin = paramToServiceMsg.getUin();
    localVerifyCodeInfo.verifyurl = ((String)paramToServiceMsg.getAttribute("resp_verify_url"));
    localVerifyCodeInfo.appSeq = paramToServiceMsg.getAppSeq();
    return localVerifyCodeInfo;
  }
  
  public static void putVerifyCodeInfo(FromServiceMsg paramFromServiceMsg, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null) {
      return;
    }
    paramFromServiceMsg.addAttribute("resp_verify_image", paramVerifyCodeInfo.verifyimage);
    paramFromServiceMsg.addAttribute("resp_verify_msg", paramVerifyCodeInfo.verifyNote);
    paramFromServiceMsg.addAttribute("resp_verify_svrSeq", Integer.valueOf(paramVerifyCodeInfo.svrSeqNo));
    paramFromServiceMsg.addAttribute("resp_verify_picSid", paramVerifyCodeInfo.vpicSid);
    paramFromServiceMsg.addAttribute("resp_verify_wupSeq", Integer.valueOf(paramVerifyCodeInfo.wupSeq));
    paramFromServiceMsg.addAttribute("resp_verify_ssoSeq", Integer.valueOf(paramVerifyCodeInfo.ssoSeq));
    paramFromServiceMsg.addAttribute("resp_verify_uin", paramFromServiceMsg.getUin());
    paramFromServiceMsg.addAttribute("resp_verify_url", paramVerifyCodeInfo.verifyurl);
    paramFromServiceMsg.addAttribute("resp_verify_appseq", Integer.valueOf(paramFromServiceMsg.getAppSeq()));
  }
  
  public static void putVerifyCodeInfo(ToServiceMsg paramToServiceMsg, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if ((paramToServiceMsg == null) || (paramVerifyCodeInfo == null)) {
      return;
    }
    paramToServiceMsg.addAttribute("resp_verify_image", paramVerifyCodeInfo.verifyimage);
    paramToServiceMsg.addAttribute("resp_verify_msg", paramVerifyCodeInfo.verifyNote);
    paramToServiceMsg.addAttribute("resp_verify_svrSeq", Integer.valueOf(paramVerifyCodeInfo.svrSeqNo));
    paramToServiceMsg.addAttribute("resp_verify_picSid", paramVerifyCodeInfo.vpicSid);
    paramToServiceMsg.addAttribute("resp_verify_wupSeq", Integer.valueOf(paramVerifyCodeInfo.wupSeq));
    paramToServiceMsg.addAttribute("resp_verify_ssoSeq", Integer.valueOf(paramVerifyCodeInfo.ssoSeq));
    paramToServiceMsg.addAttribute("resp_verify_uin", paramToServiceMsg.getUin());
    paramToServiceMsg.addAttribute("resp_verify_url", paramVerifyCodeInfo.verifyurl);
    paramToServiceMsg.addAttribute("resp_verify_appseq", Integer.valueOf(paramToServiceMsg.getAppSeq()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.VerifyCodeInfo
 * JD-Core Version:    0.7.0.1
 */