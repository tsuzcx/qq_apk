package com.tencent.mm.plugin.finder.feed.jumper;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.BackgroundShapeConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.b;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.h;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.live.model.ay;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.MiniAppInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/AdStoreJumperViewHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/BaseJumperEventHandler;", "()V", "doPreload", "", "enterAdStore", "jumpView", "Landroid/view/View;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "onClickDo", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "shouldPreload", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  public static final c.a Bds;
  
  static
  {
    AppMethodBeat.i(364214);
    Bds = new c.a((byte)0);
    AppMethodBeat.o(364214);
  }
  
  public final void a(j paramj, View paramView, k paramk)
  {
    AppMethodBeat.i(364236);
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    Object localObject2 = paramk.hVf;
    paramj = ((FinderJumpInfo)localObject2).mini_app_info;
    label55:
    Object localObject3;
    Object localObject1;
    if (paramj == null)
    {
      paramj = "";
      paramk = ((FinderJumpInfo)localObject2).mini_app_info;
      if (paramk != null) {
        break label432;
      }
      paramk = "";
      localObject3 = Util.getUuidRandom();
      localObject1 = new com.tencent.mm.plugin.appbrand.api.g();
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).appId = paramj;
      paramj = ((FinderJumpInfo)localObject2).mini_app_info;
      if (paramj != null) {
        break label452;
      }
      paramj = null;
      label87:
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).username = paramj;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAF = paramk;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).scene = 1184;
      paramj = ((FinderJumpInfo)localObject2).mini_app_info;
      if (paramj != null) {
        break label460;
      }
      paramj = "";
      label120:
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).hzx = paramj;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAT = new HalfScreenConfig(true, ((com.tencent.mm.plugin.g)h.ax(com.tencent.mm.plugin.g.class)).bUw(), HalfScreenConfig.a.rae, false, null, false, null, HalfScreenConfig.c.rao, false, true, null, HalfScreenConfig.h.raE, false, false, null, false, null, 0, 0, 0, false, false, false, null, 16770424);
      paramj = new ay();
      paramj.Azu = paramj.Azu;
      paramj.CIG = "";
      paramj.awE("push");
      paramj.CIH = 2;
      paramj.CII = ((byte[])localObject3);
      paramk = ah.aiuX;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAG = ((com.tencent.mm.plugin.appbrand.api.d)paramj);
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAL = 1000;
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).euz = 0;
      paramk = new StringBuilder("[enterAdStore]  appId=").append(((com.tencent.mm.plugin.appbrand.api.g)localObject1).appId).append(" enterPath=").append(((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAF).append(" sceneNote=");
      paramj = ((FinderJumpInfo)localObject2).mini_app_info;
      if (paramj != null) {
        break label477;
      }
      paramj = null;
      label296:
      Log.i("Finder.AdStoreJumperClickHandler", paramj);
      localObject2 = new HalfScreenConfig.BackgroundShapeConfig(MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_1_5_A), true, true, 24);
      paramj = new AdStoreJumperViewHandler.enterAdStore.halfScreenStateChangeListener.1();
      paramk = paramView.getClass().getName();
      s.s(paramk, "jumpView.javaClass.name");
      paramk = new HalfScreenConfig.CloseWhenClickEmptyAreaConfig(paramk, HalfScreenConfig.a.rae);
      localObject3 = ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAT;
      if (localObject3 != null) {
        break label485;
      }
      paramj = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAT = paramj;
      ((t)h.ax(t.class)).a(paramView.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject1);
      AppMethodBeat.o(364236);
      return;
      paramk = paramj.app_id;
      paramj = paramk;
      if (paramk != null) {
        break;
      }
      paramj = "";
      break;
      label432:
      localObject1 = paramk.path;
      paramk = (k)localObject1;
      if (localObject1 != null) {
        break label55;
      }
      paramk = "";
      break label55;
      label452:
      paramj = paramj.appusername;
      break label87;
      label460:
      paramk = paramj.request_id;
      paramj = paramk;
      if (paramk != null) {
        break label120;
      }
      paramj = "";
      break label120;
      label477:
      paramj = paramj.request_id;
      break label296;
      label485:
      localObject3 = ((HalfScreenConfig)localObject3).ckQ();
      if (localObject3 == null)
      {
        paramj = null;
      }
      else
      {
        localObject3 = ((HalfScreenConfig.b)localObject3).ix(true);
        if (localObject3 == null)
        {
          paramj = null;
        }
        else
        {
          localObject3 = ((HalfScreenConfig.b)localObject3).iy(true);
          if (localObject3 == null)
          {
            paramj = null;
          }
          else
          {
            localObject2 = ((HalfScreenConfig.b)localObject3).a((HalfScreenConfig.BackgroundShapeConfig)localObject2);
            if (localObject2 == null)
            {
              paramj = null;
            }
            else
            {
              localObject2 = ((HalfScreenConfig.b)localObject2).iz(true);
              if (localObject2 == null)
              {
                paramj = null;
              }
              else
              {
                paramk = ((HalfScreenConfig.b)localObject2).a(paramk);
                if (paramk == null)
                {
                  paramj = null;
                }
                else
                {
                  paramk = paramk.iA(true);
                  if (paramk == null)
                  {
                    paramj = null;
                  }
                  else
                  {
                    paramj = paramk.a((WeAppHalfScreenStatusChangeListener)paramj);
                    if (paramj == null) {
                      paramj = null;
                    } else {
                      paramj = paramj.ckR();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean ape()
  {
    return true;
  }
  
  public final void edu()
  {
    AppMethodBeat.i(364248);
    k localk = edw();
    if (localk != null)
    {
      r localr = r.Bej;
      r.b(localk);
    }
    AppMethodBeat.o(364248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.c
 * JD-Core Version:    0.7.0.1
 */