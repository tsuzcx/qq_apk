package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper;", "", "()V", "TAG", "", "finderWindow", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "getFinderWindow", "()Lcom/tencent/mm/ui/base/MMPopupWindow;", "setFinderWindow", "(Lcom/tencent/mm/ui/base/MMPopupWindow;)V", "menu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getMenu", "()Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "setMenu", "(Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;)V", "calPopupMenuWidth", "", "context", "Landroid/content/Context;", "dimiss", "", "isShowing", "reportAction", "", "action", "menuConfig", "Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper$PopupMenuConfig;", "show", "listener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateContextMMMenuListener;", "selectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onDimissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "topMenuConfig", "Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper$TopMemuConfig;", "showFinderWindow", "view", "Landroid/view/View;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "x", "y", "isAssistant", "showTopMemuItem", "width", "PopupMenuConfig", "TopMemuConfig", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private static com.tencent.mm.ui.widget.b.a GAa;
  private static com.tencent.mm.ui.base.v GAb;
  public static final i GzZ;
  
  static
  {
    AppMethodBeat.i(344719);
    GzZ = new i();
    AppMethodBeat.o(344719);
  }
  
  private static void a(int paramInt, i.a parama)
  {
    int i = 1;
    AppMethodBeat.i(370622);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      j.Dob.Pg(paramInt);
      AppMethodBeat.o(370622);
      return;
    }
    if ((parama != null) && (parama.akim == true)) {}
    while (i != 0)
    {
      com.tencent.mm.plugin.finder.live.report.k.Doi.aa(paramInt, parama.adma, parama.akin);
      AppMethodBeat.o(370622);
      return;
      i = 0;
    }
    com.tencent.mm.plugin.finder.live.report.k.Doi.Pn(paramInt);
    AppMethodBeat.o(370622);
  }
  
  private static final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    int i = 1;
    AppMethodBeat.i(344697);
    kotlin.g.b.s.u(paramOnDismissListener, "$onDimissListener");
    com.tencent.mm.ui.base.v localv = GAb;
    if ((localv != null) && (localv.isShowing() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localv = GAb;
        if (localv != null) {
          localv.dismiss();
        }
        GAb = null;
      }
      paramOnDismissListener.onDismiss();
      AppMethodBeat.o(344697);
      return;
      i = 0;
    }
  }
  
  private static final void a(i.a parama, u.i parami, t paramt, View paramView)
  {
    AppMethodBeat.i(370625);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(parami);
    localb.cH(paramt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$menuConfig");
    kotlin.g.b.s.u(parami, "$selectedListener");
    a(3, parama);
    parami.onMMMenuItemSelected((MenuItem)paramt, 0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(370625);
  }
  
  public static void a(u.f paramf, u.i parami, PopupWindow.OnDismissListener paramOnDismissListener, i.a parama, i.b paramb)
  {
    AppMethodBeat.i(370621);
    kotlin.g.b.s.u(paramf, "listener");
    kotlin.g.b.s.u(parami, "selectedListener");
    kotlin.g.b.s.u(paramOnDismissListener, "onDimissListener");
    kotlin.g.b.s.u(parama, "menuConfig");
    Object localObject1 = new int[2];
    parama.aeMz.getLocationInWindow((int[])localObject1);
    int i3 = localObject1[0] + (int)(parama.aeMz.getWidth() / 2.0F);
    int i2 = localObject1[1];
    boolean bool;
    int j;
    label319:
    label334:
    int k;
    label341:
    int m;
    label348:
    int i;
    Object localObject2;
    Object localObject3;
    if ((i3 > 0) && (i2 > 0))
    {
      bool = paramb.akio;
      localObject1 = new com.tencent.mm.ui.widget.b.a(parama.aeMz.getContext());
      GAa = (com.tencent.mm.ui.widget.b.a)localObject1;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((com.tencent.mm.ui.widget.b.a)localObject1).agjw = true;
      localObject1 = GAa;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.b.a)localObject1).akil = parama.akil;
      }
      if (bool)
      {
        localObject1 = GAa;
        kotlin.g.b.s.checkNotNull(localObject1);
        ((com.tencent.mm.ui.widget.b.a)localObject1).agjy = ((int)MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_22A));
      }
      localObject1 = GAa;
      kotlin.g.b.s.checkNotNull(localObject1);
      ((com.tencent.mm.ui.widget.b.a)localObject1).afLp = new i..ExternalSyntheticLambda2(paramOnDismissListener);
      paramOnDismissListener = GAa;
      kotlin.g.b.s.checkNotNull(paramOnDismissListener);
      paramOnDismissListener.a(parama.aeMz, paramf, parami, i3, i2);
      a(1, parama);
      label468:
      label479:
      label490:
      label499:
      label508:
      Object localObject4;
      if (paramb.akip != null)
      {
        a(2, parama);
        paramf = GAa;
        kotlin.g.b.s.checkNotNull(paramf);
        int i4 = paramf.kMq();
        int i5 = (int)MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_A);
        paramOnDismissListener = parama.aeMz.getContext();
        kotlin.g.b.s.s(paramOnDismissListener, "menuConfig.anchorView.context");
        paramf = GAa;
        kotlin.g.b.s.checkNotNull(paramf);
        int i6;
        if (paramf.Vtk != null)
        {
          j = paramf.Vtk.size();
          i6 = com.tencent.mm.ui.widget.b.a.kMr();
          paramf = View.inflate(paramOnDismissListener, a.g.grid_popup_layout, null);
          if (paramf != null) {
            break label468;
          }
          paramf = null;
          paramOnDismissListener = View.inflate(paramOnDismissListener, a.g.pop_grid_menu_item, null);
          if (paramOnDismissListener != null) {
            break label479;
          }
          paramOnDismissListener = null;
          if (paramf != null) {
            break label490;
          }
          k = 0;
          if (paramf != null) {
            break label499;
          }
          m = 0;
          if (paramOnDismissListener != null) {
            break label508;
          }
          i = 0;
        }
        int n;
        for (;;)
        {
          int i1 = (int)MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_22A);
          n = i1;
          if (i > 0)
          {
            n = i1;
            if (j > 0)
            {
              n = i1;
              if (i6 > 0) {
                n = kotlin.k.k.qu(kotlin.k.k.qv(j, i6) * i + (k + m), i1);
              }
            }
          }
          localObject2 = parama.aeMz;
          localObject1 = parama.Ddj;
          localObject3 = paramb.akip;
          bool = paramb.akiq;
          if ((localObject3 != null) && (localObject1 != null)) {
            break label532;
          }
          AppMethodBeat.o(370621);
          return;
          j = 0;
          break;
          paramf = paramf.findViewById(p.e.pop_bubble);
          break label319;
          paramOnDismissListener = paramOnDismissListener.findViewById(p.e.container);
          break label334;
          k = paramf.getPaddingLeft();
          break label341;
          m = paramf.getPaddingRight();
          break label348;
          paramf = paramOnDismissListener.getLayoutParams();
          if (paramf == null) {
            i = 0;
          } else {
            i = paramf.width;
          }
        }
        label532:
        localObject4 = View.inflate(((View)localObject2).getContext(), p.f.Ccy, null);
        paramb = (ImageView)((View)localObject4).findViewById(p.e.BEQ);
        TextView localTextView = (TextView)((View)localObject4).findViewById(p.e.BER);
        ((View)localObject4).findViewById(p.e.RqN).setVisibility(8);
        if (bool)
        {
          paramf = ((bgh)localObject1).contact;
          if (paramf == null)
          {
            paramf = "";
            a.b.g(paramb, paramf);
            paramf = aw.Gjk;
            paramf = ((bgh)localObject1).contact;
            if (paramf != null) {
              break label853;
            }
            paramf = "";
            label628:
            paramOnDismissListener = ((bgh)localObject1).contact;
            if (paramOnDismissListener != null) {
              break label871;
            }
            paramOnDismissListener = "";
            label642:
            paramf = aw.rV(paramf, paramOnDismissListener);
            paramOnDismissListener = ((View)localObject2).getContext();
          }
        }
        for (;;)
        {
          localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramOnDismissListener, (CharSequence)paramf));
          paramf = new com.tencent.mm.ui.base.v((View)localObject4, n, -2);
          GAb = paramf;
          paramf.setFocusable(false);
          paramf = GAb;
          if (paramf != null) {
            paramf.setOutsideTouchable(false);
          }
          paramf = GAb;
          if (paramf != null) {
            paramf.setAnimationStyle(p.i.PopCenterAnimation);
          }
          paramf = GAb;
          if (paramf != null) {
            paramf.setInputMethodMode(2);
          }
          paramf = GAb;
          if (paramf != null) {
            paramf.setOnDismissListener(i..ExternalSyntheticLambda4.INSTANCE);
          }
          ((View)localObject4).setOnClickListener(new i..ExternalSyntheticLambda0(parama, parami, (t)localObject3));
          i = kotlin.k.k.qu(i3 - n / 2, bd.fromDPToPix(((View)localObject2).getContext(), 12));
          ((View)localObject4).measure(0, 0);
          j = ((View)localObject4).getMeasuredHeight();
          paramf = GAb;
          if (paramf != null) {
            paramf.showAtLocation((View)localObject2, 0, i, i2 - i4 - i5 - j);
          }
          AppMethodBeat.o(370621);
          return;
          paramOnDismissListener = paramf.username;
          paramf = paramOnDismissListener;
          if (paramOnDismissListener != null) {
            break;
          }
          paramf = "";
          break;
          label853:
          paramOnDismissListener = paramf.username;
          paramf = paramOnDismissListener;
          if (paramOnDismissListener != null) {
            break label628;
          }
          paramf = "";
          break label628;
          label871:
          paramb = paramOnDismissListener.nickname;
          paramOnDismissListener = paramb;
          if (paramb != null) {
            break label642;
          }
          paramOnDismissListener = "";
          break label642;
          paramf = com.tencent.mm.plugin.finder.loader.p.ExI;
          d locald = com.tencent.mm.plugin.finder.loader.p.eCp();
          paramf = ((bgh)localObject1).contact;
          if (paramf == null) {
            paramf = "";
          }
          for (;;)
          {
            paramf = new com.tencent.mm.plugin.finder.loader.b(paramf, com.tencent.mm.plugin.finder.storage.v.FLG);
            kotlin.g.b.s.s(paramb, "avatarView");
            paramOnDismissListener = com.tencent.mm.plugin.finder.loader.p.ExI;
            locald.a(paramf, paramb, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
            paramb = ((View)localObject2).getContext();
            paramf = ((bgh)localObject1).contact;
            if (paramf != null) {
              break label998;
            }
            paramf = "";
            paramOnDismissListener = paramb;
            break;
            paramOnDismissListener = paramf.headUrl;
            paramf = paramOnDismissListener;
            if (paramOnDismissListener == null) {
              paramf = "";
            }
          }
          label998:
          localObject1 = paramf.nickname;
          paramf = (u.f)localObject1;
          paramOnDismissListener = paramb;
          if (localObject1 == null)
          {
            paramf = "";
            paramOnDismissListener = paramb;
          }
        }
      }
      paramOnDismissListener = parama.Ddj;
      label1179:
      if (paramOnDismissListener != null)
      {
        paramf = paramOnDismissListener.contact;
        if (paramf != null) {
          break label1436;
        }
        paramf = "";
        if ((!au.bwV(paramf)) || (!bool)) {
          break label1457;
        }
        i = 1;
        label1062:
        if (i == 0) {
          break label1463;
        }
        label1067:
        if (paramOnDismissListener != null)
        {
          a(2, null);
          i = (int)MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_A);
          paramb = parama.aeMz;
          paramf = GAa;
          kotlin.g.b.s.checkNotNull(paramf);
          j = paramf.kMq();
          bool = parama.DUe;
          localObject1 = View.inflate(paramb.getContext(), p.f.Ccy, null);
          localObject3 = (ImageView)((View)localObject1).findViewById(p.e.BEQ);
          localObject2 = (TextView)((View)localObject1).findViewById(p.e.BER);
          paramf = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject4 = com.tencent.mm.plugin.finder.loader.p.eCp();
          paramf = paramOnDismissListener.contact;
          if (paramf != null) {
            break label1468;
          }
          paramf = "";
          paramf = new com.tencent.mm.plugin.finder.loader.b(paramf, com.tencent.mm.plugin.finder.storage.v.FLG);
          kotlin.g.b.s.s(localObject3, "avatarView");
          parama = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject4).a(paramf, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
          localObject3 = paramb.getContext();
          paramf = paramOnDismissListener.contact;
          if (paramf != null) {
            break label1486;
          }
          paramf = "";
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)paramf));
      k = (int)MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_22A);
      paramf = new com.tencent.mm.ui.base.v((View)localObject1, k, -2);
      GAb = paramf;
      paramf.setFocusable(false);
      paramf = GAb;
      if (paramf != null) {
        paramf.setOutsideTouchable(false);
      }
      paramf = GAb;
      if (paramf != null) {
        paramf.setAnimationStyle(p.i.PopCenterAnimation);
      }
      paramf = GAb;
      if (paramf != null) {
        paramf.setInputMethodMode(2);
      }
      paramf = GAb;
      if (paramf != null) {
        paramf.setOnDismissListener(i..ExternalSyntheticLambda3.INSTANCE);
      }
      ((View)localObject1).setOnClickListener(new i..ExternalSyntheticLambda1(parami, paramb, paramOnDismissListener, bool));
      k = kotlin.k.k.qu(i3 - k / 2, bd.fromDPToPix(paramb.getContext(), 12));
      ((View)localObject1).measure(0, 0);
      m = ((View)localObject1).getMeasuredHeight();
      paramf = GAb;
      if (paramf != null) {
        paramf.showAtLocation(paramb, 0, k, i2 - j - i - m);
      }
      AppMethodBeat.o(370621);
      return;
      label1436:
      paramb = paramf.username;
      paramf = paramb;
      if (paramb != null) {
        break;
      }
      paramf = "";
      break;
      label1457:
      i = 0;
      break label1062;
      label1463:
      paramOnDismissListener = null;
      break label1067;
      label1468:
      parama = paramf.headUrl;
      paramf = parama;
      if (parama != null) {
        break label1179;
      }
      paramf = "";
      break label1179;
      label1486:
      parama = paramf.nickname;
      paramf = parama;
      if (parama == null) {
        paramf = "";
      }
    }
  }
  
  private static final void a(u.i parami, View paramView1, bgh parambgh, boolean paramBoolean, View paramView2)
  {
    AppMethodBeat.i(370627);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView1);
    localb.cH(parambgh);
    localb.fv(paramBoolean);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parami, "$selectedListener");
    kotlin.g.b.s.u(paramView1, "$view");
    kotlin.g.b.s.u(parambgh, "$contact");
    paramView2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      parami.onMMMenuItemSelected((MenuItem)new t(paramView1.getContext(), 163, 0), 0);
      if (!paramBoolean) {
        break label259;
      }
      aND(9);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(370627);
      return;
      paramView2 = new Intent();
      parami = parambgh.contact;
      if (parami == null) {
        parami = "";
      }
      for (;;)
      {
        paramView2.putExtra("finder_username", parami);
        parami = (f)h.ax(f.class);
        paramView1 = paramView1.getContext();
        kotlin.g.b.s.s(paramView1, "view.context");
        parami.enterFinderProfileUI(paramView1, paramView2);
        parami = GAb;
        if (parami == null) {
          break;
        }
        parami.dismiss();
        break;
        parambgh = parami.username;
        parami = parambgh;
        if (parambgh == null) {
          parami = "";
        }
      }
      label259:
      aND(3);
    }
  }
  
  public static boolean fkK()
  {
    boolean bool2 = true;
    AppMethodBeat.i(344685);
    Object localObject = GAa;
    int i;
    if ((localObject != null) && (((com.tencent.mm.ui.widget.b.a)localObject).jIv() == true))
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
      localObject = GAa;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.b.a)localObject).diW();
      }
      localObject = GAb;
      bool1 = bool2;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.v)localObject).dismiss();
      }
    }
    label76:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      GAa = null;
      AppMethodBeat.o(344685);
      return bool1;
      i = 0;
      break;
    }
  }
  
  public static boolean isShowing()
  {
    AppMethodBeat.i(344691);
    com.tencent.mm.ui.widget.b.a locala = GAa;
    if ((locala != null) && (locala.jIv() == true))
    {
      AppMethodBeat.o(344691);
      return true;
    }
    AppMethodBeat.o(344691);
    return false;
  }
  
  private static final void kLD()
  {
    AppMethodBeat.i(370624);
    fkK();
    GAb = null;
    AppMethodBeat.o(370624);
  }
  
  private static final void kLE()
  {
    AppMethodBeat.i(370626);
    fkK();
    GAb = null;
    AppMethodBeat.o(370626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.i
 * JD-Core Version:    0.7.0.1
 */