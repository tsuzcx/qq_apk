package com.tencent.kinda.framework.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaTextStatusSetupManager;
import com.tencent.kinda.gen.VoidBoolStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.a.z.a;
import com.tencent.mm.plugin.textstatus.proto.m;
import com.tencent.mm.plugin.textstatus.proto.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaTextStatusSetupManagerImpl
  implements KindaTextStatusSetupManager
{
  private final String TAG = "MicorMsg.KindaTextStatusSetupManagerImpl";
  
  public void setupTextStatusImpl(String paramString1, final String paramString2, String paramString3, int paramInt, final VoidBoolStringCallback paramVoidBoolStringCallback)
  {
    AppMethodBeat.i(226389);
    Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "leadViewInfo click jump status");
    com.tencent.mm.plugin.textstatus.proto.k localk = new com.tencent.mm.plugin.textstatus.proto.k();
    localk.Oks = paramString2;
    localk.ToN = paramString3;
    paramString1 = new z.a().bdz(paramString1).a(localk).bdA(String.valueOf(paramInt)).ThX;
    com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(1), paramString2 });
    ((n)com.tencent.mm.kernel.h.ax(n.class)).a(KindaContext.get(), paramString1, new y()
    {
      public void onFinishAction(int paramAnonymousInt, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(226432);
        Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "onFinishAction result :%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousInt)
        {
        default: 
          Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "onFinishAction default");
        }
        do
        {
          do
          {
            AppMethodBeat.o(226432);
            return;
            Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "onFinishAction click ok");
            com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(3), paramString2 });
          } while ((paramVoidBoolStringCallback == null) || (paramAnonymousq == null) || (paramAnonymousq.action != 2));
          Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "desc :%s", new Object[] { paramAnonymousq.Tpn.Okz });
          paramVoidBoolStringCallback.call(true, KindaContext.get().getString(R.string.wallet_order_info_leadtail_desc, new Object[] { paramAnonymousq.Tpn.Okz }));
          AppMethodBeat.o(226432);
          return;
          Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "onFinishAction click error");
          com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(4), paramString2 });
          com.tencent.mm.ui.base.k.a(KindaContext.get(), KindaContext.get().getString(a.i.wallet_order_info_leadtail_error), "", KindaContext.get().getString(a.i.wallet_alert_btn_i_know), new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(226413);
              Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "click AlertDialog");
              AppMethodBeat.o(226413);
            }
          });
          AppMethodBeat.o(226432);
          return;
          Log.i("MicorMsg.KindaTextStatusSetupManagerImpl", "onFinishAction click cancel");
          com.tencent.mm.plugin.report.service.h.OAn.b(24498, new Object[] { Integer.valueOf(2), paramString2 });
        } while (paramVoidBoolStringCallback == null);
        paramVoidBoolStringCallback.call(false, "");
        AppMethodBeat.o(226432);
      }
    });
    AppMethodBeat.o(226389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaTextStatusSetupManagerImpl
 * JD-Core Version:    0.7.0.1
 */