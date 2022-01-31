package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cad;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  static boolean a(Activity paramActivity, cad paramcad)
  {
    AppMethodBeat.i(152356);
    if (paramcad.xLG.isEmpty())
    {
      AppMethodBeat.o(152356);
      return true;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramcad.xLG.iterator();
        if (localIterator.hasNext())
        {
          cac localcac = (cac)localIterator.next();
          Object localObject1 = paramActivity;
          if (paramActivity == null)
          {
            localObject1 = paramActivity;
            if ("MoreTabUI".equals(paramcad.xLx)) {
              localObject1 = b.bru();
            }
          }
          if ((localObject1 == null) || (localcac == null))
          {
            bool = false;
            paramActivity = (Activity)localObject1;
            if (bool) {
              continue;
            }
            AppMethodBeat.o(152356);
            return false;
          }
          paramActivity = Class.forName(localcac.className);
          if ((localcac.dataPath == null) || (localcac.dataPath.isEmpty())) {
            break label294;
          }
          String[] arrayOfString2 = localcac.dataPath.split(",");
          if (arrayOfString2.length <= 0)
          {
            bool = false;
            continue;
          }
          String[] arrayOfString1 = arrayOfString2[0].split("\\|");
          paramActivity = paramActivity.getDeclaredField(arrayOfString1[0]);
          paramActivity.setAccessible(true);
          paramActivity = paramActivity.get(localObject1);
          Object localObject2 = paramActivity;
          if (arrayOfString2.length != 1)
          {
            int i = 1;
            localObject2 = paramActivity;
            if (i < arrayOfString2.length)
            {
              localObject2 = Class.forName(arrayOfString1[1]);
              arrayOfString1 = arrayOfString2[i].split("\\|");
              localObject2 = ((Class)localObject2).getDeclaredField(arrayOfString1[0]);
              ((Field)localObject2).setAccessible(true);
              paramActivity = ((Field)localObject2).get(paramActivity);
              i += 1;
              continue;
            }
          }
          bool = localcac.xLy.equals(localObject2);
          continue;
        }
        AppMethodBeat.o(152356);
      }
      catch (Exception paramActivity)
      {
        AppMethodBeat.o(152356);
        return false;
      }
      return true;
      label294:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */