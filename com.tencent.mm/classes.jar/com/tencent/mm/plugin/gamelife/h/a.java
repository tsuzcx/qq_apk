package com.tencent.mm.plugin.gamelife.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.du;
import com.tencent.mm.plugin.game.d.h;
import com.tencent.mm.plugin.game.d.k;
import com.tencent.mm.plugin.game.d.u;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/panel/GameLifePanelControlService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifePanelControlService;", "()V", "shouldShowAttachButton", "", "shouldShowCamera", "shouldShowSendPic", "wordForCameraIfDisabled", "", "sessionId", "wordForDynamicPanelIfDisabled", "panelType", "", "wordForSendPicIfDisabled", "wordForStaticPanelIfDisabled", "plugin-gamelife_release"})
public final class a
  implements d
{
  private static String dW(String paramString, int paramInt)
  {
    AppMethodBeat.i(212171);
    if (paramString == null)
    {
      AppMethodBeat.o(212171);
      return null;
    }
    paramString = ((f)g.ab(f.class)).anD(paramString);
    if (paramString != null)
    {
      paramString = paramString.ddw();
      if (paramString != null)
      {
        if ((paramString.uIN & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(212171);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.cZz();
        if (paramString != null)
        {
          paramString = paramString.uqR;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((du)paramString).uqG == paramInt)
              {
                i = 1;
                label125:
                if (i == 0) {
                  break label213;
                }
                label129:
                paramString = (du)paramString;
                if (paramString == null) {
                  break label225;
                }
                paramString = paramString.uqM;
                if (paramString == null) {
                  break label225;
                }
                localIterator = ((Iterable)paramString).iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  paramString = localIterator.next();
                } while (!p.i(((u)paramString).qkN, ad.fom()));
              }
            }
            for (;;)
            {
              paramString = (u)paramString;
              if (paramString == null) {
                break label225;
              }
              paramString = paramString.urq;
              AppMethodBeat.o(212171);
              return paramString;
              i = 0;
              break label125;
              label213:
              break;
              paramString = null;
              break label129;
              paramString = null;
            }
          }
        }
        label225:
        paramString = com.tencent.mm.cb.a.az((Context)com.tencent.mm.sdk.platformtools.e.fnL(), 2131767102);
        AppMethodBeat.o(212171);
        return paramString;
      }
    }
    AppMethodBeat.o(212171);
    return null;
  }
  
  public final String anB(String paramString)
  {
    AppMethodBeat.i(212168);
    paramString = dW(paramString, 1);
    AppMethodBeat.o(212168);
    return paramString;
  }
  
  public final String anC(String paramString)
  {
    AppMethodBeat.i(212169);
    paramString = dW(paramString, 2);
    AppMethodBeat.o(212169);
    return paramString;
  }
  
  public final String dV(String paramString, int paramInt)
  {
    AppMethodBeat.i(212170);
    if (paramString == null)
    {
      AppMethodBeat.o(212170);
      return null;
    }
    paramString = ((f)g.ab(f.class)).anD(paramString);
    if (paramString != null)
    {
      paramString = paramString.ddw();
      if (paramString != null)
      {
        if ((paramString.uIO & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(212170);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.cZz();
        if (paramString != null)
        {
          paramString = paramString.uqQ;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((h)paramString).uqG == paramInt)
              {
                i = 1;
                label128:
                if (i == 0) {
                  break label219;
                }
                label132:
                paramString = (h)paramString;
                if (paramString == null) {
                  break label231;
                }
                paramString = paramString.uqM;
                if (paramString == null) {
                  break label231;
                }
                localIterator = ((Iterable)paramString).iterator();
                do
                {
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  paramString = localIterator.next();
                } while (!p.i(((u)paramString).qkN, ad.fom()));
              }
            }
            for (;;)
            {
              paramString = (u)paramString;
              if (paramString == null) {
                break label231;
              }
              paramString = paramString.urq;
              AppMethodBeat.o(212170);
              return paramString;
              i = 0;
              break label128;
              label219:
              break;
              paramString = null;
              break label132;
              paramString = null;
            }
          }
        }
        label231:
        paramString = com.tencent.mm.cb.a.az((Context)com.tencent.mm.sdk.platformtools.e.fnL(), 2131767102);
        AppMethodBeat.o(212170);
        return paramString;
      }
    }
    AppMethodBeat.o(212170);
    return null;
  }
  
  public final boolean ddt()
  {
    AppMethodBeat.i(212165);
    Object localObject = com.tencent.mm.plugin.game.commlib.a.cZz();
    if (localObject != null)
    {
      Collection localCollection = (Collection)((k)localObject).uqR;
      if ((localCollection == null) || (localCollection.isEmpty()))
      {
        i = 1;
        if (i != 0)
        {
          localObject = (Collection)((k)localObject).uqQ;
          if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
            break label79;
          }
        }
      }
      label79:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label84;
        }
        AppMethodBeat.o(212165);
        return true;
        i = 0;
        break;
      }
    }
    label84:
    AppMethodBeat.o(212165);
    return false;
  }
  
  public final boolean ddu()
  {
    AppMethodBeat.i(212166);
    Object localObject = com.tencent.mm.plugin.game.commlib.a.cZz();
    if (localObject != null)
    {
      localObject = ((k)localObject).uqR;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        int i;
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          du localdu = (du)localObject;
          if ((localdu != null) && (localdu.uqG == 1))
          {
            i = 1;
            label70:
            if (i == 0) {
              break label91;
            }
          }
        }
        for (;;)
        {
          if ((du)localObject == null) {
            break label98;
          }
          AppMethodBeat.o(212166);
          return true;
          i = 0;
          break label70;
          label91:
          break;
          localObject = null;
        }
      }
    }
    label98:
    AppMethodBeat.o(212166);
    return false;
  }
  
  public final boolean ddv()
  {
    AppMethodBeat.i(212167);
    Object localObject = com.tencent.mm.plugin.game.commlib.a.cZz();
    if (localObject != null)
    {
      localObject = ((k)localObject).uqR;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        int i;
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          du localdu = (du)localObject;
          if ((localdu != null) && (localdu.uqG == 2))
          {
            i = 1;
            label70:
            if (i == 0) {
              break label91;
            }
          }
        }
        for (;;)
        {
          if ((du)localObject == null) {
            break label98;
          }
          AppMethodBeat.o(212167);
          return true;
          i = 0;
          break label70;
          label91:
          break;
          localObject = null;
        }
      }
    }
    label98:
    AppMethodBeat.o(212167);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.a
 * JD-Core Version:    0.7.0.1
 */