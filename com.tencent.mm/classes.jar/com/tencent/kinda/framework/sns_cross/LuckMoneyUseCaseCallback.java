package com.tencent.kinda.framework.sns_cross;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class LuckMoneyUseCaseCallback
  implements ISnsUseCaseCallback
{
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    boolean bool = false;
    AppMethodBeat.i(144598);
    Object localObject = this.mBean.getContext();
    if ((localObject instanceof LuckyMoneyPrepareUI))
    {
      localObject = (LuckyMoneyPrepareUI)localObject;
      if (paramITransmitKvData.getString("closeLoading").equals("1"))
      {
        if ((((LuckyMoneyPrepareUI)localObject).gKM != null) && (((LuckyMoneyPrepareUI)localObject).gKM.isShowing())) {
          ((LuckyMoneyPrepareUI)localObject).gKM.dismiss();
        }
        AppMethodBeat.o(144598);
        return;
      }
      int i = paramITransmitKvData.getInt("retcode");
      paramITransmitKvData = paramITransmitKvData.getString("transaction_id");
      PayInfo localPayInfo = this.mBean.getPayInfo();
      if (i == 1) {}
      Intent localIntent;
      for (i = -1;; i = 0)
      {
        localIntent = new Intent();
        localIntent.putExtra("key_trans_id", paramITransmitKvData);
        if (localPayInfo.wgv != null) {
          bool = localPayInfo.wgv.getBoolean("isF2FHongBao", false);
        }
        if (!bool) {
          break;
        }
        ((LuckyMoneyPrepareUI)localObject).h(i, localIntent);
        AppMethodBeat.o(144598);
        return;
      }
      ((LuckyMoneyPrepareUI)localObject).i(i, localIntent);
    }
    AppMethodBeat.o(144598);
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(144597);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(144597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.LuckMoneyUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */