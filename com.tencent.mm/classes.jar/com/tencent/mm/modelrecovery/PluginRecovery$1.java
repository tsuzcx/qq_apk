package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;

final class PluginRecovery$1
  extends c<oc>
{
  PluginRecovery$1(PluginRecovery paramPluginRecovery)
  {
    AppMethodBeat.i(16523);
    this.__eventId = oc.class.getName().hashCode();
    AppMethodBeat.o(16523);
  }
  
  private static boolean a(oc paramoc)
  {
    AppMethodBeat.i(16524);
    switch (paramoc.cEO.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16524);
      return false;
      a.aiR();
      continue;
      paramoc = ah.getContext();
      CommonOptions.Builder localBuilder = new CommonOptions.Builder();
      localBuilder.Bix = WXRecoveryHandleService.class.getName();
      localBuilder.Biy = WXRecoveryUploadService.class.getName();
      localBuilder.clientVersion = f.CLIENT_VERSION;
      localBuilder.Biu = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
      localBuilder.eAx = WXUtil.iY(paramoc);
      RecoveryLogic.a(paramoc, localBuilder.dUs(), new RecoveryContext());
      continue;
      paramoc = ah.getContext();
      localBuilder = new CommonOptions.Builder();
      localBuilder.Bix = WXRecoveryHandleService.class.getName();
      localBuilder.Biy = WXRecoveryUploadService.class.getName();
      localBuilder.clientVersion = f.CLIENT_VERSION;
      localBuilder.Biu = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
      localBuilder.eAx = WXUtil.iY(paramoc);
      RecoveryLogic.a(paramoc, localBuilder.dUs(), new RecoveryContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.1
 * JD-Core Version:    0.7.0.1
 */