package com.tencent.matrix.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.d;
import com.tencent.matrix.e;
import com.tencent.matrix.g.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixStrategyNotifyBroadcast
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    if (paramIntent == null)
    {
      c.e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
      return;
    }
    paramContext = paramIntent.getAction();
    Object localObject1 = y.getStringExtra(paramIntent, "strategy");
    c.i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s action:%s", new Object[] { aj.getProcessName(), localObject1, paramContext });
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      b.HL();
      return;
    }
    if (paramContext.equals("statusNotify"))
    {
      paramContext = new HashMap();
      localObject1 = paramIntent.getStringArrayListExtra("StatusChangeKey");
      paramIntent = paramIntent.getIntegerArrayListExtra("StatusChangeValue");
      boolean bool1;
      if ((localObject1 == null) || (paramIntent == null))
      {
        if (localObject1 == null) {}
        for (bool1 = true;; bool1 = false)
        {
          if (paramIntent == null) {
            bool2 = true;
          }
          ad.w("Matrix.StrategyNotifyBroadcast", "keys=%s values=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          return;
        }
      }
      if (((List)localObject1).size() != paramIntent.size())
      {
        ad.w("Matrix.StrategyNotifyBroadcast", "keys.size(%s) != values.size(%s)", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramIntent.size()) });
        return;
      }
      int i = 0;
      if (i < ((List)localObject1).size())
      {
        Object localObject2 = ((List)localObject1).get(i);
        if (((Integer)paramIntent.get(i)).intValue() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          paramContext.put(localObject2, Boolean.valueOf(bool1));
          i += 1;
          break;
        }
      }
      d.ctd.cth.h(paramContext);
      return;
    }
    e.j(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast
 * JD-Core Version:    0.7.0.1
 */