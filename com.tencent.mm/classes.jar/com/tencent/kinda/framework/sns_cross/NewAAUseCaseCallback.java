package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.ui.AARemittanceUI;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class NewAAUseCaseCallback
  implements ISnsUseCaseCallback
{
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18713);
    Object localObject = this.mBean.getContext();
    if (("1".equals(paramITransmitKvData.getString("closeLoading"))) && ((localObject instanceof PaylistAAUI)))
    {
      ((PaylistAAUI)localObject).hideLoading();
      AppMethodBeat.o(18713);
      return;
    }
    String str = paramITransmitKvData.getString("transaction_id");
    if (paramITransmitKvData.getInt("retcode") == 1) {}
    for (int i = -1; (localObject instanceof PaylistAAUI); i = 0)
    {
      paramITransmitKvData = (PaylistAAUI)localObject;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_trans_id", str);
      paramITransmitKvData.b(i, (Intent)localObject);
      AppMethodBeat.o(18713);
      return;
    }
    if ((localObject instanceof AARemittanceUI))
    {
      paramITransmitKvData = (AARemittanceUI)localObject;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_trans_id", str);
      paramITransmitKvData.b(i, (Intent)localObject);
    }
    AppMethodBeat.o(18713);
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(18712);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(18712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.NewAAUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */