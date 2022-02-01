package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KindaPayCardManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;

public class KindaPayCardManagerImpl
  implements KindaPayCardManager
{
  public void addPayCardImpl(final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18461);
    Object localObject = KindaContext.get();
    if (!(localObject instanceof MMActivity))
    {
      Log.e("KindaPayCardManagerImpl", "Fail to start addPayCardImpl due to incompatible context(%s)", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(18461);
      return;
    }
    localObject = (Activity)localObject;
    ((Activity)localObject).getIntent().putExtra("process_id", b.class.hashCode());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_bind_scene", 0);
    localBundle.putBoolean("is_from_new_cashier", true);
    localBundle.putString("start_activity_class", localObject.getClass().getName());
    a.a((Activity)localObject, b.class, localBundle);
    localObject = a.bF((Activity)localObject);
    if (!(localObject instanceof b))
    {
      Log.e("KindaPayCardManagerImpl", "Fail to get correct wallet process in addPayCardImpl, expect BindCardProcess got %s", new Object[] { localObject.getClass().getName() });
      AppMethodBeat.o(18461);
      return;
    }
    ((b)localObject).OHE = new b.a()
    {
      public void run(int paramAnonymousInt)
      {
        AppMethodBeat.i(18460);
        if (paramAnonymousInt == -1)
        {
          paramVoidCallback1.call();
          AppMethodBeat.o(18460);
          return;
        }
        paramVoidCallback2.call();
        AppMethodBeat.o(18460);
      }
    };
    AppMethodBeat.o(18461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPayCardManagerImpl
 * JD-Core Version:    0.7.0.1
 */