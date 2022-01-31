package com.tencent.mm.modelrecovery;

import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;
import java.util.ArrayList;

public class RecoveryTinkerResultService
  extends AbstractResultService
{
  public final void a(a parama)
  {
    RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", new Object[] { parama });
    CommonOptions localCommonOptions = OptionFactory.hq(this);
    ArrayList localArrayList = new ArrayList();
    RecoveryHandleItem localRecoveryHandleItem = new RecoveryHandleItem();
    localRecoveryHandleItem.dCX = localCommonOptions.dCX;
    localRecoveryHandleItem.clientVersion = localCommonOptions.clientVersion;
    localRecoveryHandleItem.timestamp = System.currentTimeMillis();
    localRecoveryHandleItem.key = "KeyPatchResultTotalCount";
    if (parama.bKQ)
    {
      RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
      localRecoveryHandleItem.key = "KeyPatchResultSuccessCount";
    }
    for (;;)
    {
      localArrayList.add(localRecoveryHandleItem);
      RecoveryLogic.a(this, localArrayList, WXRecoveryUploadService.class.getName());
      stopSelf();
      return;
      RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
      if (parama.wKQ != null)
      {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", new Object[] { parama.wKQ.getMessage() });
        localRecoveryHandleItem.key = String.format("%s[%s]", new Object[] { "KeyPatchResultFailCount", parama.wKQ.getMessage() });
      }
      else
      {
        localRecoveryHandleItem.key = "KeyPatchResultFailCount";
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
  }
  
  public void onDestroy()
  {
    RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.RecoveryTinkerResultService
 * JD-Core Version:    0.7.0.1
 */