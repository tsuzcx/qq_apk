package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class NewAAUseCaseCallback
  implements ISnsUseCaseCallback
{
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144601);
    Object localObject = this.mBean.getContext();
    if (("1".equals(paramITransmitKvData.getString("closeLoading"))) && ((localObject instanceof PaylistAAUI)))
    {
      ((PaylistAAUI)localObject).hideLoading();
      AppMethodBeat.o(144601);
      return;
    }
    String str = paramITransmitKvData.getString("transaction_id");
    if (paramITransmitKvData.getInt("retcode") == 1) {}
    for (int i = -1;; i = 0)
    {
      if ((localObject instanceof PaylistAAUI))
      {
        paramITransmitKvData = (PaylistAAUI)localObject;
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_trans_id", str);
        paramITransmitKvData.c(i, (Intent)localObject);
      }
      AppMethodBeat.o(144601);
      return;
    }
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(144600);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(144600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.NewAAUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */