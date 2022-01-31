package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(152397);
    if (paramFragment == null)
    {
      AppMethodBeat.o(152397);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152397);
      return;
      bI(paramFragment);
      AppMethodBeat.o(152397);
      return;
      bJ(paramFragment);
    }
  }
  
  private static void a(Object paramObject, bki parambki)
  {
    AppMethodBeat.i(152400);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bsb();
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bsc();
    if ((localObject1 == null) || (((bzz)localObject1).eht) || (!((bzz)localObject1).mzI))
    {
      ab.w("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnActivity, sessionConfigCloud.isDel true");
      AppMethodBeat.o(152400);
      return;
    }
    Object localObject3 = ((bzz)localObject1).xLD.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject2 = (cad)((Iterator)localObject3).next();
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mv(parambki.czq);
        if (com.tencent.mm.plugin.expt.hellhound.a.b.a.b.My(parambki.czq)) {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.d(parambki);
        }
        if (((cad)localObject2).sid.equals(localObject1))
        {
          localObject3 = paramObject.getClass().getSimpleName();
          localObject2 = ((cad)localObject2).xLz.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (cae)((Iterator)localObject2).next();
            if ((localObject1 != null) && (((String)localObject3).equals(((cae)localObject1).xkf)))
            {
              ab.d("HellPageParamsCatcher", "habbyge-mali, _catchSessionPageParamsOnActivity: ".concat(String.valueOf(localObject3)));
              parambki = com.tencent.mm.plugin.expt.hellhound.a.b.c.b.b(parambki, paramObject.getClass().getSimpleName());
              if (parambki != null)
              {
                localObject2 = (auy)parambki.get(0);
                ab.i("HellPageParamsCatcher", "HABBYGE-MALI, _catchPageParamsOnActivity, flowItem: " + ((auy)localObject2).czq + " | " + ((auy)localObject2).xkf);
                localObject1 = ((cae)localObject1).xLH.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (bkh)((Iterator)localObject1).next();
                  if (localObject3 != null) {
                    b.a(paramObject, (bkh)localObject3, (auy)localObject2, false);
                  }
                }
                com.tencent.mm.plugin.expt.hellhound.a.b.c.b.a((auy)localObject2, ((Integer)parambki.get(1)).intValue());
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(152400);
  }
  
  public static void bI(Object paramObject)
  {
    AppMethodBeat.i(152398);
    ab.i("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnResume: " + paramObject.getClass().getSimpleName());
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.w("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnResume, not support unknown page !!!");
      AppMethodBeat.o(152398);
      return;
    }
    ab.i("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnResume: " + localbki.czq);
    a(paramObject, localbki);
    AppMethodBeat.o(152398);
  }
  
  public static void bJ(Object paramObject)
  {
    AppMethodBeat.i(152399);
    ab.i("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnFinishActivity: " + paramObject.getClass().getSimpleName());
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.w("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnFinishActivity, not support unknown page !!!");
      AppMethodBeat.o(152399);
      return;
    }
    ab.i("HellPageParamsCatcher", "HABBYGE-MALI, _catchOnFinishActivity: " + localbki.czq);
    a(paramObject, localbki);
    AppMethodBeat.o(152399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */