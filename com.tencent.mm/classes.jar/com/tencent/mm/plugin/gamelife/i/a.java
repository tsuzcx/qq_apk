package com.tencent.mm.plugin.gamelife.i;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.ab;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.dz;
import com.tencent.mm.plugin.game.protobuf.l;
import com.tencent.mm.plugin.game.protobuf.w;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/panel/GameLifePanelControlService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifePanelControlService;", "()V", "enableAttachButton", "", "enableCamera", "enableEmoji", "enablePic", "setButtonConfig", "", "shouldShowAttachButton", "shouldShowCamera", "shouldShowEmoji", "shouldShowSendPic", "wordForCameraIfDisabled", "", "sessionId", "wordForDynamicPanelIfDisabled", "panelType", "", "wordForSendPicIfDisabled", "wordForStaticPanelIfDisabled", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d
{
  private boolean JbK;
  private boolean JbL;
  private boolean JbM;
  private boolean enableCamera;
  
  private static String fz(String paramString, int paramInt)
  {
    AppMethodBeat.i(267734);
    if (paramString == null)
    {
      AppMethodBeat.o(267734);
      return null;
    }
    paramString = ((f)com.tencent.mm.kernel.h.ax(f.class)).aHz(paramString);
    if (paramString != null)
    {
      paramString = paramString.fIq();
      if (paramString != null)
      {
        if ((paramString.JaD & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(267734);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.fDX();
        if (paramString != null)
        {
          paramString = paramString.IHy;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((dz)paramString).IHj == paramInt)
              {
                i = 1;
                label125:
                if (i == 0) {
                  break label213;
                }
                label129:
                paramString = (dz)paramString;
                if (paramString == null) {
                  break label225;
                }
                paramString = paramString.IHq;
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
                } while (!s.p(((w)paramString).yts, LocaleUtil.getApplicationLanguage()));
              }
            }
            for (;;)
            {
              paramString = (w)paramString;
              if (paramString == null) {
                break label225;
              }
              paramString = paramString.IHZ;
              AppMethodBeat.o(267734);
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
        paramString = com.tencent.mm.cd.a.bt((Context)ApplicationGlobal.context(), d.f.Jaw);
        AppMethodBeat.o(267734);
        return paramString;
      }
    }
    AppMethodBeat.o(267734);
    return null;
  }
  
  public final String aHx(String paramString)
  {
    AppMethodBeat.i(267758);
    paramString = fz(paramString, 1);
    AppMethodBeat.o(267758);
    return paramString;
  }
  
  public final String aHy(String paramString)
  {
    AppMethodBeat.i(267763);
    paramString = fz(paramString, 2);
    AppMethodBeat.o(267763);
    return paramString;
  }
  
  public final void fIl()
  {
    Object localObject2 = null;
    AppMethodBeat.i(267741);
    Object localObject3 = com.tencent.mm.plugin.game.commlib.a.fDX();
    int i;
    if (localObject3 != null)
    {
      localObject1 = (Collection)((l)localObject3).IHy;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label277;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = (Collection)((l)localObject3).IHx;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label282;
        }
        i = 1;
        label69:
        if (i != 0) {}
      }
      else
      {
        this.JbM = true;
      }
      localObject1 = ((l)localObject3).IHy;
      Object localObject4;
      if (localObject1 != null)
      {
        localObject4 = ((Iterable)localObject1).iterator();
        label99:
        if (!((Iterator)localObject4).hasNext()) {
          break label292;
        }
        localObject1 = ((Iterator)localObject4).next();
        dz localdz = (dz)localObject1;
        if ((localdz == null) || (localdz.IHj != 2)) {
          break label287;
        }
        i = 1;
        label139:
        if (i == 0) {
          break label290;
        }
        label143:
        if ((dz)localObject1 != null) {
          this.enableCamera = true;
        }
      }
      localObject1 = ((l)localObject3).IHy;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        label176:
        if (!((Iterator)localObject3).hasNext()) {
          break label302;
        }
        localObject1 = ((Iterator)localObject3).next();
        localObject4 = (dz)localObject1;
        if ((localObject4 == null) || (((dz)localObject4).IHj != 1)) {
          break label297;
        }
        i = 1;
        label216:
        if (i == 0) {
          break label300;
        }
        label220:
        if ((dz)localObject1 != null) {
          this.JbK = true;
        }
      }
    }
    if (com.tencent.mm.plugin.game.commlib.a.IsN != null)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.game.commlib.a.IsN.GameLifeSetting == null) {}
    }
    for (Object localObject1 = com.tencent.mm.plugin.game.commlib.a.IsN.GameLifeSetting.IJu;; localObject1 = localObject2)
    {
      if (localObject1 != null) {
        this.JbL = ((ab)localObject1).IHR;
      }
      AppMethodBeat.o(267741);
      return;
      label277:
      i = 0;
      break;
      label282:
      i = 0;
      break label69;
      label287:
      i = 0;
      break label139;
      label290:
      break label99;
      label292:
      localObject1 = null;
      break label143;
      label297:
      i = 0;
      break label216;
      label300:
      break label176;
      label302:
      localObject1 = null;
      break label220;
      com.tencent.mm.plugin.game.commlib.a.fDQ();
    }
  }
  
  public final boolean fIm()
  {
    return this.JbM;
  }
  
  public final boolean fIn()
  {
    return this.JbK;
  }
  
  public final boolean fIo()
  {
    return this.enableCamera;
  }
  
  public final boolean fIp()
  {
    return this.JbL;
  }
  
  public final String fy(String paramString, int paramInt)
  {
    AppMethodBeat.i(267767);
    if (paramString == null)
    {
      AppMethodBeat.o(267767);
      return null;
    }
    paramString = ((f)com.tencent.mm.kernel.h.ax(f.class)).aHz(paramString);
    if (paramString != null)
    {
      paramString = paramString.fIq();
      if (paramString != null)
      {
        if ((paramString.JaE & 1 << paramInt - 1) == 0L)
        {
          AppMethodBeat.o(267767);
          return null;
        }
        paramString = com.tencent.mm.plugin.game.commlib.a.fDX();
        if (paramString != null)
        {
          paramString = paramString.IHx;
          if (paramString != null)
          {
            Iterator localIterator = ((Iterable)paramString).iterator();
            int i;
            if (localIterator.hasNext())
            {
              paramString = localIterator.next();
              if (((com.tencent.mm.plugin.game.protobuf.h)paramString).IHj == paramInt)
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
                paramString = paramString.IHq;
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
                } while (!s.p(((w)paramString).yts, LocaleUtil.getApplicationLanguage()));
              }
            }
            for (;;)
            {
              paramString = (w)paramString;
              if (paramString == null) {
                break label231;
              }
              paramString = paramString.IHZ;
              AppMethodBeat.o(267767);
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
        paramString = com.tencent.mm.cd.a.bt((Context)ApplicationGlobal.context(), d.f.Jaw);
        AppMethodBeat.o(267767);
        return paramString;
      }
    }
    AppMethodBeat.o(267767);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.a
 * JD-Core Version:    0.7.0.1
 */