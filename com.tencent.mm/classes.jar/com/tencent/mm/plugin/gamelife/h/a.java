package com.tencent.mm.plugin.gamelife.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.protobuf.du;
import com.tencent.mm.plugin.game.protobuf.h;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.game.protobuf.u;
import com.tencent.mm.plugin.game.protobuf.z;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/panel/GameLifePanelControlService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifePanelControlService;", "()V", "enableAttachButton", "", "enableCamera", "enableEmoji", "enablePic", "setButtonConfig", "", "shouldShowAttachButton", "shouldShowCamera", "shouldShowEmoji", "shouldShowSendPic", "wordForCameraIfDisabled", "", "sessionId", "wordForDynamicPanelIfDisabled", "panelType", "", "wordForSendPicIfDisabled", "wordForStaticPanelIfDisabled", "plugin-gamelife_release"})
public final class a
  implements d
{
  private boolean ycn;
  private boolean yco;
  private boolean ycp;
  private boolean ycq;
  
  private static String el(String paramString, int paramInt)
  {
    AppMethodBeat.i(241412);
    if (paramString == null)
    {
      AppMethodBeat.o(241412);
      return null;
    }
    paramString = ((f)g.af(f.class)).aAW(paramString);
    if (paramString != null)
    {
      paramString = paramString.dXh();
      if (paramString != null)
      {
        if ((paramString.ybb & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(241412);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.dSZ();
        if (paramString != null)
        {
          paramString = paramString.xJj;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((du)paramString).xIY == paramInt)
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
                paramString = paramString.xJe;
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
                } while (!p.j(((u)paramString).rBI, LocaleUtil.getApplicationLanguage()));
              }
            }
            for (;;)
            {
              paramString = (u)paramString;
              if (paramString == null) {
                break label225;
              }
              paramString = paramString.xJH;
              AppMethodBeat.o(241412);
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
        paramString = com.tencent.mm.cb.a.aI((Context)ApplicationGlobal.context(), 2131761388);
        AppMethodBeat.o(241412);
        return paramString;
      }
    }
    AppMethodBeat.o(241412);
    return null;
  }
  
  public final String aAU(String paramString)
  {
    AppMethodBeat.i(241409);
    paramString = el(paramString, 1);
    AppMethodBeat.o(241409);
    return paramString;
  }
  
  public final String aAV(String paramString)
  {
    AppMethodBeat.i(241410);
    paramString = el(paramString, 2);
    AppMethodBeat.o(241410);
    return paramString;
  }
  
  public final void dXc()
  {
    AppMethodBeat.i(241408);
    Object localObject2 = com.tencent.mm.plugin.game.commlib.a.dSZ();
    Object localObject1;
    int i;
    if (localObject2 != null)
    {
      localObject1 = (Collection)((k)localObject2).xJj;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label243;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = (Collection)((k)localObject2).xJi;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label248;
        }
        i = 1;
        label63:
        if (i != 0) {}
      }
      else
      {
        this.ycq = true;
      }
      localObject1 = ((k)localObject2).xJj;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        label92:
        if (!((Iterator)localObject3).hasNext()) {
          break label258;
        }
        localObject1 = ((Iterator)localObject3).next();
        du localdu = (du)localObject1;
        if ((localdu == null) || (localdu.xIY != 2)) {
          break label253;
        }
        i = 1;
        label132:
        if (i == 0) {
          break label256;
        }
        label136:
        if ((du)localObject1 != null) {
          this.ycn = true;
        }
      }
      localObject1 = ((k)localObject2).xJj;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        label167:
        if (!((Iterator)localObject2).hasNext()) {
          break label268;
        }
        localObject1 = ((Iterator)localObject2).next();
        localObject3 = (du)localObject1;
        if ((localObject3 == null) || (((du)localObject3).xIY != 1)) {
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
      if ((du)localObject1 != null) {
        this.yco = true;
      }
      localObject1 = com.tencent.mm.plugin.game.commlib.a.dTa();
      if (localObject1 == null) {
        break label273;
      }
      this.ycp = ((z)localObject1).xJV;
      AppMethodBeat.o(241408);
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
    AppMethodBeat.o(241408);
  }
  
  public final boolean dXd()
  {
    return this.ycq;
  }
  
  public final boolean dXe()
  {
    return this.yco;
  }
  
  public final boolean dXf()
  {
    return this.ycn;
  }
  
  public final boolean dXg()
  {
    return this.ycp;
  }
  
  public final String ek(String paramString, int paramInt)
  {
    AppMethodBeat.i(241411);
    if (paramString == null)
    {
      AppMethodBeat.o(241411);
      return null;
    }
    paramString = ((f)g.af(f.class)).aAW(paramString);
    if (paramString != null)
    {
      paramString = paramString.dXh();
      if (paramString != null)
      {
        if ((paramString.ybc & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(241411);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.dSZ();
        if (paramString != null)
        {
          paramString = paramString.xJi;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((h)paramString).xIY == paramInt)
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
                paramString = paramString.xJe;
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
                } while (!p.j(((u)paramString).rBI, LocaleUtil.getApplicationLanguage()));
              }
            }
            for (;;)
            {
              paramString = (u)paramString;
              if (paramString == null) {
                break label231;
              }
              paramString = paramString.xJH;
              AppMethodBeat.o(241411);
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
        paramString = com.tencent.mm.cb.a.aI((Context)ApplicationGlobal.context(), 2131761388);
        AppMethodBeat.o(241411);
        return paramString;
      }
    }
    AppMethodBeat.o(241411);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.a
 * JD-Core Version:    0.7.0.1
 */