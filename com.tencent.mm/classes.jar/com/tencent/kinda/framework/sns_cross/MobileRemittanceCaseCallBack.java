package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;

public class MobileRemittanceCaseCallBack
  implements ISnsUseCaseCallback
{
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(263130);
    Object localObject = this.mBean.getContext();
    if ((localObject instanceof MobileRemittanceUI))
    {
      localObject = (MobileRemittanceUI)localObject;
      if (paramITransmitKvData.getString("closeLoading").equals("1"))
      {
        ((MobileRemittanceUI)localObject).hideProgress();
        AppMethodBeat.o(263130);
        return;
      }
      if (paramITransmitKvData.getInt("retcode") != 1) {
        break label163;
      }
    }
    label163:
    for (int i = -1;; i = 0)
    {
      ((MobileRemittanceUI)localObject).hideProgress();
      ((MobileRemittanceUI)localObject).hideLoading();
      Log.i("MicroMsg.mobileRemit.MobileRemittanceUI", "resultCode :%s", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        paramITransmitKvData = ((MobileRemittanceUI)localObject).IkJ;
        paramITransmitKvData = new com.tencent.mm.hellhoundlib.b.a().bm(paramITransmitKvData);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramITransmitKvData.aFh(), "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI", "onMobileRemittanceResult", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileRemittanceUI)localObject).startActivity((Intent)paramITransmitKvData.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI", "onMobileRemittanceResult", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      AppMethodBeat.o(263130);
      return;
    }
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(263129);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(263129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.MobileRemittanceCaseCallBack
 * JD-Core Version:    0.7.0.1
 */