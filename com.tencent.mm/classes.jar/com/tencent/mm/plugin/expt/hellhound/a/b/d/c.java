package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.a;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(156448);
    if (paramFragment == null)
    {
      AppMethodBeat.o(156448);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156448);
      return;
      bI(paramFragment);
      AppMethodBeat.o(156448);
      return;
      bJ(paramFragment);
    }
  }
  
  private static void a(Object paramObject, bki parambki)
  {
    AppMethodBeat.i(156451);
    d.bsf();
    Object localObject1 = d.bsg();
    if ((localObject1 == null) || (((cag)localObject1).eht))
    {
      ab.w("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnActivity, sessionConfigCloud.isDel true");
      AppMethodBeat.o(156451);
      return;
    }
    Object localObject2 = ((cag)localObject1).fjy.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (cah)((Iterator)localObject2).next();
      if (localObject1 != null)
      {
        localObject2 = paramObject.getClass().getSimpleName();
        ab.i("HellSessionUBAParamsCatcher", "habbyge-mali, _catchSessionPageParamsOnActivity: " + (String)localObject2 + " | " + ((cah)localObject1).xkf);
        if (((String)localObject2).equals(((cah)localObject1).xkf))
        {
          localObject2 = ((cah)localObject1).xLP.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (bkh)((Iterator)localObject2).next();
            if (localObject1 != null)
            {
              parambki = com.tencent.mm.plugin.expt.hellhound.a.b.c.b.b(parambki, paramObject.getClass().getSimpleName());
              if (parambki != null)
              {
                localObject2 = (auy)parambki.get(0);
                ab.i("HellSessionUBAParamsCatcher", "HABBYGE-MALI, HellSessionUBA, _catchPageParamsOnActivity, flowItem: " + ((auy)localObject2).czq + " | " + ((auy)localObject2).xkf);
                b.a(paramObject, (bkh)localObject1, (auy)localObject2, true);
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((auy)localObject2, ((Integer)parambki.get(1)).intValue());
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(156451);
  }
  
  public static void bI(Object paramObject)
  {
    AppMethodBeat.i(156449);
    ab.i("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnResume: " + paramObject.getClass().getSimpleName());
    bki localbki = a.bsj();
    if (localbki == null)
    {
      ab.w("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnResume, not support unknown page !!!");
      AppMethodBeat.o(156449);
      return;
    }
    ab.i("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnResume: " + localbki.czq);
    a(paramObject, localbki);
    AppMethodBeat.o(156449);
  }
  
  public static void bJ(Object paramObject)
  {
    AppMethodBeat.i(156450);
    ab.i("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnFinishActivity: " + paramObject.getClass().getSimpleName());
    bki localbki = a.bsj();
    if (localbki == null)
    {
      ab.w("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnFinishActivity, not support unknown page !!!");
      AppMethodBeat.o(156450);
      return;
    }
    ab.i("HellSessionUBAParamsCatcher", "HABBYGE-MALI, _catchOnFinishActivity: " + localbki.czq);
    a(paramObject, localbki);
    AppMethodBeat.o(156450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.c
 * JD-Core Version:    0.7.0.1
 */