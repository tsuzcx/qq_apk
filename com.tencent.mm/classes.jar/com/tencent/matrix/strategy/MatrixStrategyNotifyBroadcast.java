package com.tencent.matrix.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.e;
import com.tencent.matrix.e.c;
import com.tencent.matrix.f;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixStrategyNotifyBroadcast
  extends BroadcastReceiver
{
  public static final String fdj = ;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    if (paramIntent == null)
    {
      c.e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
      return;
    }
    paramContext = paramIntent.getAction();
    Object localObject = IntentUtil.getStringExtra(paramIntent, "strategy");
    c.i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s action:%s", new Object[] { MMApplicationContext.getProcessName(), localObject, paramContext });
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      b.azA();
      return;
    }
    if (paramContext.equals("statusNotify"))
    {
      paramContext = new HashMap();
      localObject = paramIntent.getStringArrayListExtra("StatusChangeKey");
      paramIntent = paramIntent.getIntegerArrayListExtra("StatusChangeValue");
      boolean bool1;
      if ((localObject == null) || (paramIntent == null))
      {
        if (localObject == null) {}
        for (bool1 = true;; bool1 = false)
        {
          if (paramIntent == null) {
            bool2 = true;
          }
          Log.w("Matrix.StrategyNotifyBroadcast", "keys=%s values=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return;
        }
      }
      if (((List)localObject).size() != paramIntent.size())
      {
        Log.w("Matrix.StrategyNotifyBroadcast", "keys.size(%s) != values.size(%s)", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(paramIntent.size()) });
        return;
      }
      int i = 0;
      if (i < ((List)localObject).size())
      {
        String str = (String)((List)localObject).get(i);
        if (((Integer)paramIntent.get(i)).intValue() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramContext.put(str, Boolean.valueOf(bool1));
          i += 1;
          break;
        }
      }
      e.eLE.eLI.o(paramContext);
      return;
    }
    f.l(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast
 * JD-Core Version:    0.7.0.1
 */