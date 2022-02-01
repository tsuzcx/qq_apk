package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(20591);
    RecoveryLog.i("Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", new Object[] { parama });
    CommonOptions localCommonOptions = OptionFactory.getCommonOptions(this);
    ArrayList localArrayList = new ArrayList();
    RecoveryHandleItem localRecoveryHandleItem = new RecoveryHandleItem();
    localRecoveryHandleItem.uuid = localCommonOptions.getUUID();
    localRecoveryHandleItem.clientVersion = localCommonOptions.getClientVersion();
    localRecoveryHandleItem.timestamp = System.currentTimeMillis();
    localRecoveryHandleItem.key = "KeyPatchResultTotalCount";
    if (parama.isSuccess)
    {
      RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
      localRecoveryHandleItem.key = "KeyPatchResultSuccessCount";
    }
    for (;;)
    {
      localArrayList.add(localRecoveryHandleItem);
      RecoveryLogic.startReportService(this, localArrayList, WXRecoveryUploadService.class.getName());
      stopSelf();
      AppMethodBeat.o(20591);
      return;
      RecoveryLog.i("Recovery.RecoveryTinkerResultService", "patch fail ", new Object[0]);
      if (parama.e != null)
      {
        RecoveryLog.i("Recovery.RecoveryTinkerResultService", "fail reason %s", new Object[] { parama.e.getMessage() });
        localRecoveryHandleItem.key = String.format("%s[%s]", new Object[] { "KeyPatchResultFailCount", parama.e.getMessage() });
      }
      else
      {
        localRecoveryHandleItem.key = "KeyPatchResultFailCount";
      }
    }
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(20589);
    super.onCreate();
    RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onCreate", new Object[0]);
    AppMethodBeat.o(20589);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20590);
    RecoveryLog.i("Recovery.RecoveryTinkerResultService", "onDestroy", new Object[0]);
    super.onDestroy();
    AppMethodBeat.o(20590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.RecoveryTinkerResultService
 * JD-Core Version:    0.7.0.1
 */