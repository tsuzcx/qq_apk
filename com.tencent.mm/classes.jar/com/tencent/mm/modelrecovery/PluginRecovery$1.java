package com.tencent.mm.modelrecovery;

import com.tencent.mm.h.a.nf;
import com.tencent.mm.h.a.nf.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;

final class PluginRecovery$1
  extends c<nf>
{
  PluginRecovery$1(PluginRecovery paramPluginRecovery)
  {
    this.udX = nf.class.getName().hashCode();
  }
  
  private static boolean a(nf paramnf)
  {
    switch (paramnf.bWX.action)
    {
    default: 
      return false;
    case 2: 
      a.PM();
      return false;
    case 1: 
      paramnf = ae.getContext();
      localBuilder = new CommonOptions.Builder();
      localBuilder.wKY = WXRecoveryHandleService.class.getName();
      localBuilder.wKZ = WXRecoveryUploadService.class.getName();
      localBuilder.clientVersion = d.CLIENT_VERSION;
      localBuilder.wKU = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
      localBuilder.dCX = WXUtil.hw(paramnf);
      RecoveryLogic.a(paramnf, localBuilder.cOD(), new RecoveryContext());
      return false;
    }
    paramnf = ae.getContext();
    CommonOptions.Builder localBuilder = new CommonOptions.Builder();
    localBuilder.wKY = WXRecoveryHandleService.class.getName();
    localBuilder.wKZ = WXRecoveryUploadService.class.getName();
    localBuilder.clientVersion = d.CLIENT_VERSION;
    localBuilder.wKU = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
    localBuilder.dCX = WXUtil.hw(paramnf);
    RecoveryLogic.a(paramnf, localBuilder.cOD(), new RecoveryContext());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.1
 * JD-Core Version:    0.7.0.1
 */