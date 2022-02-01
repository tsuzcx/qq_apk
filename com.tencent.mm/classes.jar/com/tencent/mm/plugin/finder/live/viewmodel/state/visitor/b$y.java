package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.ac;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.au;
import com.tencent.mm.plugin.finder.live.plugin.ay;
import com.tencent.mm.plugin.finder.live.plugin.bb;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.bk;
import com.tencent.mm.plugin.finder.live.plugin.cq;
import com.tencent.mm.plugin.finder.live.plugin.r;
import com.tencent.mm.plugin.finder.live.view.a.b;
import com.tencent.mm.plugin.finder.live.view.router.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC$onBindData$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$ExternalCallback;", "callback", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "params", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$y
  implements a.b
{
  b$y(b paramb, c paramc, bui parambui) {}
  
  public final void b(b.c paramc)
  {
    AppMethodBeat.i(357419);
    s.u(paramc, "status");
    switch (b.y.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(357419);
      return;
      b.s(this.Eld);
      AppMethodBeat.o(357419);
      return;
      b.t(this.Eld);
      AppMethodBeat.o(357419);
      return;
      if (b.u(this.Eld) == null)
      {
        b.a(this.Eld, new au((ViewGroup)b.k(p.e.BLK, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj));
        paramc = b.u(this.Eld);
        if (paramc != null) {
          paramc.tO(8);
        }
        paramc = b.u(this.Eld);
        if (paramc != null)
        {
          paramc.mount();
          AppMethodBeat.o(357419);
          return;
          b localb = this.Eld;
          Object localObject = b.v(this.Eld);
          paramc = (b.c)localObject;
          if (localObject == null) {
            paramc = new bk((ViewGroup)b.k(p.e.BNF, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj, this.Elk);
          }
          b.a(localb, paramc);
          paramc = b.v(this.Eld);
          if (paramc != null) {
            paramc.tO(8);
          }
          paramc = b.v(this.Eld);
          if (paramc != null)
          {
            paramc.mount();
            AppMethodBeat.o(357419);
            return;
            if (b.w(this.Eld) == null)
            {
              b.a(this.Eld, new ac((ViewGroup)b.k(p.e.BHb, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj));
              paramc = b.w(this.Eld);
              if (paramc != null) {
                paramc.tO(8);
              }
              paramc = b.w(this.Eld);
              if (paramc != null)
              {
                paramc.mount();
                AppMethodBeat.o(357419);
                return;
                if (b.x(this.Eld) == null)
                {
                  localObject = this.Eld;
                  if (((e)this.Eld.business(e.class)).DUe) {}
                  for (paramc = (bb)new r((ViewGroup)b.k(p.e.BGI, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj);; paramc = (bb)new cq((ViewGroup)b.k(p.e.BTM, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj))
                  {
                    b.a((b)localObject, paramc);
                    paramc = b.x(this.Eld);
                    if (paramc != null) {
                      paramc.tO(8);
                    }
                    paramc = b.x(this.Eld);
                    if (paramc == null) {
                      break;
                    }
                    paramc.mount();
                    AppMethodBeat.o(357419);
                    return;
                  }
                  if (b.m(this.Eld) == null)
                  {
                    b.a(this.Eld, new bj((ViewGroup)b.k(p.e.BPo, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj));
                    paramc = b.m(this.Eld);
                    if (paramc != null) {
                      paramc.tO(8);
                    }
                    paramc = b.m(this.Eld);
                    if (paramc != null)
                    {
                      paramc.mount();
                      AppMethodBeat.o(357419);
                      return;
                      if (b.y(this.Eld) == null)
                      {
                        paramc = (ViewGroup)b.k(p.e.BWQ, (View)this.Elj);
                        b.a(this.Eld, new ay(paramc, (com.tencent.mm.live.b.b)this.Elj));
                        paramc = b.y(this.Eld);
                        if (paramc != null) {
                          paramc.tO(8);
                        }
                        paramc = b.y(this.Eld);
                        if (paramc != null)
                        {
                          paramc.mount();
                          AppMethodBeat.o(357419);
                          return;
                          if (b.z(this.Eld) == null)
                          {
                            b.a(this.Eld, new af((ViewGroup)b.k(p.e.BJo, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj));
                            paramc = b.z(this.Eld);
                            if (paramc != null) {
                              paramc.tO(8);
                            }
                            paramc = b.z(this.Eld);
                            if (paramc != null)
                            {
                              paramc.mount();
                              AppMethodBeat.o(357419);
                              return;
                              if (b.A(this.Eld) == null)
                              {
                                b.a(this.Eld, new al((ViewGroup)b.k(p.e.BKz, (View)this.Elj), (com.tencent.mm.live.b.b)this.Elj, (byte)0));
                                paramc = b.A(this.Eld);
                                if (paramc != null) {
                                  paramc.tO(8);
                                }
                                paramc = b.A(this.Eld);
                                if (paramc != null) {
                                  paramc.mount();
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
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.b.y
 * JD-Core Version:    0.7.0.1
 */