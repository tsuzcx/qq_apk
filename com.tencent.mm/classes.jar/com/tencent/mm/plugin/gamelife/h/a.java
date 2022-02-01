package com.tencent.mm.plugin.gamelife.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.aa;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.game.protobuf.v;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/panel/GameLifePanelControlService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifePanelControlService;", "()V", "enableAttachButton", "", "enableCamera", "enableEmoji", "enablePic", "setButtonConfig", "", "shouldShowAttachButton", "shouldShowCamera", "shouldShowEmoji", "shouldShowSendPic", "wordForCameraIfDisabled", "", "sessionId", "wordForDynamicPanelIfDisabled", "panelType", "", "wordForSendPicIfDisabled", "wordForStaticPanelIfDisabled", "plugin-gamelife_release"})
public final class a
  implements d
{
  private boolean DhT;
  private boolean DhU;
  private boolean DhV;
  private boolean enableCamera;
  
  private static String eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(203947);
    if (paramString == null)
    {
      AppMethodBeat.o(203947);
      return null;
    }
    paramString = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.eAq();
      if (paramString != null)
      {
        if ((paramString.DgJ & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(203947);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.ewh();
        if (paramString != null)
        {
          paramString = paramString.CNq;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((dv)paramString).CNe == paramInt)
              {
                i = 1;
                label125:
                if (i == 0) {
                  break label213;
                }
                label129:
                paramString = (dv)paramString;
                if (paramString == null) {
                  break label225;
                }
                paramString = paramString.CNl;
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
                } while (!p.h(((v)paramString).vhq, LocaleUtil.getApplicationLanguage()));
              }
            }
            for (;;)
            {
              paramString = (v)paramString;
              if (paramString == null) {
                break label225;
              }
              paramString = paramString.CNP;
              AppMethodBeat.o(203947);
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
        paramString = com.tencent.mm.ci.a.ba((Context)ApplicationGlobal.context(), d.f.DgC);
        AppMethodBeat.o(203947);
        return paramString;
      }
    }
    AppMethodBeat.o(203947);
    return null;
  }
  
  public final String aKH(String paramString)
  {
    AppMethodBeat.i(203941);
    paramString = eJ(paramString, 1);
    AppMethodBeat.o(203941);
    return paramString;
  }
  
  public final String aKI(String paramString)
  {
    AppMethodBeat.i(203943);
    paramString = eJ(paramString, 2);
    AppMethodBeat.o(203943);
    return paramString;
  }
  
  public final void eAl()
  {
    AppMethodBeat.i(203938);
    Object localObject2 = com.tencent.mm.plugin.game.commlib.a.ewh();
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      localObject1 = (Collection)((k)localObject2).CNq;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label243;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = (Collection)((k)localObject2).CNp;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label248;
        }
        i = 1;
        label63:
        if (i != 0) {}
      }
      else
      {
        this.DhV = true;
      }
      localObject1 = ((k)localObject2).CNq;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        label92:
        if (!((Iterator)localObject3).hasNext()) {
          break label258;
        }
        localObject1 = ((Iterator)localObject3).next();
        dv localdv = (dv)localObject1;
        if ((localdv == null) || (localdv.CNe != 2)) {
          break label253;
        }
        i = 1;
        label132:
        if (i == 0) {
          break label256;
        }
        label136:
        if ((dv)localObject1 != null) {
          this.enableCamera = true;
        }
      }
      localObject1 = ((k)localObject2).CNq;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        label167:
        if (!((Iterator)localObject2).hasNext()) {
          break label268;
        }
        localObject1 = ((Iterator)localObject2).next();
        localObject3 = (dv)localObject1;
        if ((localObject3 == null) || (((dv)localObject3).CNe != 1)) {
          break label263;
        }
        i = 1;
        label205:
        if (i == 0) {
          break label266;
        }
      }
    }
    for (;;)
    {
      if ((dv)localObject1 != null) {
        this.DhT = true;
      }
      localObject1 = com.tencent.mm.plugin.game.commlib.a.ewi();
      if (localObject1 == null) {
        break label273;
      }
      this.DhU = ((aa)localObject1).CNJ;
      AppMethodBeat.o(203938);
      return;
      label243:
      i = 0;
      break;
      label248:
      i = 0;
      break label63;
      label253:
      i = 0;
      break label132;
      label256:
      break label92;
      label258:
      localObject1 = null;
      break label136;
      label263:
      i = 0;
      break label205;
      label266:
      break label167;
      label268:
      localObject1 = null;
    }
    label273:
    AppMethodBeat.o(203938);
  }
  
  public final boolean eAm()
  {
    return this.DhV;
  }
  
  public final boolean eAn()
  {
    return this.DhT;
  }
  
  public final boolean eAo()
  {
    return this.enableCamera;
  }
  
  public final boolean eAp()
  {
    return this.DhU;
  }
  
  public final String eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(203944);
    if (paramString == null)
    {
      AppMethodBeat.o(203944);
      return null;
    }
    paramString = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ(paramString);
    if (paramString != null)
    {
      paramString = paramString.eAq();
      if (paramString != null)
      {
        if ((paramString.DgK & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(203944);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.ewh();
        if (paramString != null)
        {
          paramString = paramString.CNp;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((com.tencent.mm.plugin.game.protobuf.h)paramString).CNe == paramInt)
              {
                i = 1;
                label128:
                if (i == 0) {
                  break label219;
                }
                label132:
                paramString = (com.tencent.mm.plugin.game.protobuf.h)paramString;
                if (paramString == null) {
                  break label231;
                }
                paramString = paramString.CNl;
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
                } while (!p.h(((v)paramString).vhq, LocaleUtil.getApplicationLanguage()));
              }
            }
            for (;;)
            {
              paramString = (v)paramString;
              if (paramString == null) {
                break label231;
              }
              paramString = paramString.CNP;
              AppMethodBeat.o(203944);
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
        paramString = com.tencent.mm.ci.a.ba((Context)ApplicationGlobal.context(), d.f.DgC);
        AppMethodBeat.o(203944);
        return paramString;
      }
    }
    AppMethodBeat.o(203944);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.a
 * JD-Core Version:    0.7.0.1
 */