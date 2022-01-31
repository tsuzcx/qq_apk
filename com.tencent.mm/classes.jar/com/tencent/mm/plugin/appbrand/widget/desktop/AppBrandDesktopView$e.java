package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import java.util.ArrayList;

final class AppBrandDesktopView$e
  extends RecyclerView.a
{
  private AppBrandDesktopView$e(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  private AppBrandDesktopView.c qd(int paramInt)
  {
    AppMethodBeat.i(133849);
    if ((paramInt < AppBrandDesktopView.n(this.jfg).size()) && (paramInt >= 0))
    {
      AppBrandDesktopView.c localc = (AppBrandDesktopView.c)AppBrandDesktopView.n(this.jfg).get(paramInt);
      AppMethodBeat.o(133849);
      return localc;
    }
    AppMethodBeat.o(133849);
    return null;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(133845);
    if (paramInt == 1)
    {
      paramViewGroup = new e(w.hM(this.jfg.getContext()).inflate(2130968775, paramViewGroup, false));
      AppMethodBeat.o(133845);
      return paramViewGroup;
    }
    if (paramInt == 2)
    {
      ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
      AppBrandDesktopView.a(this.jfg, new RecentAppBrandViewContainer(this.jfg.getContext()));
      paramViewGroup = new RecyclerView.LayoutParams(-1, -2);
      AppBrandDesktopView.d(this.jfg).setLayoutParams(paramViewGroup);
      AppBrandDesktopView.d(this.jfg).setItemPadding(AppBrandDesktopView.v(this.jfg));
      AppBrandDesktopView.a(this.jfg, AppBrandDesktopView.d(this.jfg).getRecentView());
      if (AppBrandDesktopView.f(this.jfg) != null)
      {
        AppBrandDesktopView.f(this.jfg).setReporter(AppBrandDesktopView.c(this.jfg));
        AppBrandDesktopView.f(this.jfg).setOnItemClickListener(new AppBrandDesktopView.e.1(this));
      }
      AppBrandDesktopView.d(this.jfg).setDataList(AppBrandDesktopView.e(this.jfg));
      AppBrandDesktopView.d(this.jfg).setOnMoreClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(133843);
          AppBrandDesktopView.w(AppBrandDesktopView.e.this.jfg);
          AppBrandDesktopView.x(AppBrandDesktopView.e.this.jfg);
          AppBrandDesktopView.y(AppBrandDesktopView.e.this.jfg);
          AppBrandDesktopView.z(AppBrandDesktopView.e.this.jfg);
          AppBrandDesktopView.c(AppBrandDesktopView.e.this.jfg, 9);
          ((l)g.E(l.class)).D(paramAnonymousView.getContext(), 13);
          AppMethodBeat.o(133843);
        }
      });
      paramViewGroup = new AppBrandDesktopView.e.3(this, AppBrandDesktopView.d(this.jfg));
      AppMethodBeat.o(133845);
      return paramViewGroup;
    }
    RecyclerView.LayoutParams localLayoutParams;
    if (paramInt == 3)
    {
      paramViewGroup = new View(this.jfg.getContext());
      localLayoutParams = new RecyclerView.LayoutParams(-1, AppBrandDesktopView.m(this.jfg));
      localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.v(this.jfg), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.v(this.jfg), localLayoutParams.bottomMargin);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new AppBrandDesktopView.h(this.jfg, paramViewGroup);
      AppMethodBeat.o(133845);
      return paramViewGroup;
    }
    if (paramInt == 6) {
      try
      {
        AppBrandDesktopView.a(this.jfg, w.hM(this.jfg.getContext()).inflate(2130968679, paramViewGroup, false));
        paramViewGroup = new AppBrandDesktopView.g(this.jfg, AppBrandDesktopView.A(this.jfg));
        AppMethodBeat.o(133845);
        return paramViewGroup;
      }
      catch (Exception paramViewGroup)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", paramViewGroup, "alvinluo init searchView exception", new Object[0]);
        paramViewGroup = new AppBrandDesktopView.g(this.jfg, new View(this.jfg.getContext()));
        AppMethodBeat.o(133845);
        return paramViewGroup;
      }
    }
    if (paramInt == 7)
    {
      paramViewGroup = w.hM(this.jfg.getContext()).inflate(2130968775, paramViewGroup, false);
      localLayoutParams = new RecyclerView.LayoutParams(-1, -2);
      localLayoutParams.setMargins(localLayoutParams.leftMargin + AppBrandDesktopView.v(this.jfg), localLayoutParams.topMargin, localLayoutParams.rightMargin + AppBrandDesktopView.v(this.jfg), localLayoutParams.bottomMargin);
      paramViewGroup.setLayoutParams(localLayoutParams);
      AppBrandDesktopView.b(this.jfg, paramViewGroup);
      paramViewGroup = new e(paramViewGroup);
      AppMethodBeat.o(133845);
      return paramViewGroup;
    }
    if (paramInt == 8)
    {
      paramViewGroup = w.hM(this.jfg.getContext()).inflate(2130968671, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.f(this.jfg, paramViewGroup);
      AppMethodBeat.o(133845);
      return paramViewGroup;
    }
    if (paramInt == 9)
    {
      paramViewGroup = w.hM(this.jfg.getContext()).inflate(2130968674, paramViewGroup, false);
      paramViewGroup = new AppBrandDesktopView.d(this.jfg, paramViewGroup);
      AppMethodBeat.o(133845);
      return paramViewGroup;
    }
    paramViewGroup = w.hM(this.jfg.getContext()).inflate(2130970333, paramViewGroup, false);
    paramViewGroup = new AppBrandDesktopView.h(this.jfg, paramViewGroup);
    AppMethodBeat.o(133845);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(133847);
    int j = paramv.aky;
    Object localObject1;
    if (j == 3)
    {
      paramInt = AppBrandDesktopView.m(this.jfg);
      if (AppBrandDesktopView.B(this.jfg) == 0) {
        AppBrandDesktopView.f(this.jfg, AppBrandDesktopView.C(this.jfg).getViewHeight());
      }
      i = AppBrandDesktopView.B(this.jfg) - com.tencent.mm.cb.a.fromDPToPix(this.jfg.getContext(), 56) - com.tencent.mm.cb.a.fromDPToPix(this.jfg.getContext(), 48);
      j = AppBrandDesktopView.l(this.jfg);
      if (j > AppBrandDesktopView.p(this.jfg) + i) {
        AppBrandDesktopView.g(this.jfg, AppBrandDesktopView.D(this.jfg));
      }
      for (;;)
      {
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(AppBrandDesktopView.o(this.jfg)), Integer.valueOf(AppBrandDesktopView.q(this.jfg)), Integer.valueOf(j), Integer.valueOf(AppBrandDesktopView.m(this.jfg)), Integer.valueOf(paramInt), Integer.valueOf(AppBrandDesktopView.p(this.jfg)) });
        paramv.aku.setVisibility(4);
        localObject1 = (RecyclerView.LayoutParams)paramv.aku.getLayoutParams();
        ((RecyclerView.LayoutParams)localObject1).height = AppBrandDesktopView.m(this.jfg);
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", new Object[] { Integer.valueOf(AppBrandDesktopView.m(this.jfg)) });
        paramv.aku.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        AppMethodBeat.o(133847);
        return;
        if (j > i) {
          AppBrandDesktopView.g(this.jfg, AppBrandDesktopView.p(this.jfg) - (j - i));
        } else {
          AppBrandDesktopView.g(this.jfg, i - j + AppBrandDesktopView.p(this.jfg));
        }
      }
    }
    Object localObject2;
    if ((j == 10) || (j == 11))
    {
      if (paramv == null)
      {
        AppMethodBeat.o(133847);
        return;
      }
      localObject1 = paramv.aku;
      paramInt = AppBrandDesktopView.v(this.jfg) + (int)(com.tencent.mm.cb.a.fromDPToPix(this.jfg.getContext(), 8) * d.dr(this.jfg.getContext()));
      localObject2 = new RecyclerView.LayoutParams(-1, -2);
      ((RecyclerView.LayoutParams)localObject2).setMargins(((RecyclerView.LayoutParams)localObject2).leftMargin + paramInt, ((RecyclerView.LayoutParams)localObject2).topMargin, paramInt + ((RecyclerView.LayoutParams)localObject2).rightMargin, ((RecyclerView.LayoutParams)localObject2).bottomMargin);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (AppBrandDesktopView.o(this.jfg) == 0)
      {
        localObject1 = paramv.aku;
        ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", new Object[] { Integer.valueOf(((View)localObject1).getMeasuredHeight()), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
        AppBrandDesktopView.d(this.jfg, ((View)localObject1).getMeasuredHeight());
      }
      paramv = ((AppBrandDesktopView.h)paramv).titleTv;
      if (j == 10) {}
      for (paramInt = 2131302333;; paramInt = 2131301736)
      {
        paramv.setText(paramInt);
        AppMethodBeat.o(133847);
        return;
      }
    }
    if (j == 8)
    {
      paramv = (AppBrandDesktopView.f)paramv;
      boolean bool;
      if (!AppBrandDesktopView.s(this.jfg))
      {
        bool = true;
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b, itemHeight: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(AppBrandDesktopView.q(paramv.jfg)) });
        if (!bool) {
          break label693;
        }
      }
      label693:
      for (paramInt = i;; paramInt = 4)
      {
        if ((AppBrandDesktopView.E(paramv.jfg) != null) && (bool)) {
          AppBrandDesktopView.E(paramv.jfg).getLayoutParams().height = AppBrandDesktopView.q(paramv.jfg);
        }
        if (paramv.aku != null) {
          paramv.aku.setVisibility(paramInt);
        }
        AppMethodBeat.o(133847);
        return;
        bool = false;
        break;
      }
    }
    if (j == 6)
    {
      AppBrandDesktopView.c(this.jfg, paramv.aku);
      AppMethodBeat.o(133847);
      return;
    }
    if ((j == 2) || (j == 9))
    {
      AppMethodBeat.o(133847);
      return;
    }
    if ((j == 1) || (j == 7))
    {
      localObject1 = (e)paramv;
      ((e)localObject1).aku.setPadding(AppBrandDesktopView.v(this.jfg), com.tencent.mm.cb.a.fromDPToPix(this.jfg.getContext(), 8), AppBrandDesktopView.v(this.jfg), com.tencent.mm.cb.a.fromDPToPix(this.jfg.getContext(), 16));
      i = (int)d.dq(this.jfg.getContext());
      ((e)localObject1).jft.getLayoutParams().width = ((int)(com.tencent.mm.cb.a.ap(this.jfg.getContext(), 2131427854) * 2 * d.dr(this.jfg.getContext())) + i);
      ((e)localObject1).jft.getLayoutParams().height = ((int)(com.tencent.mm.cb.a.ap(this.jfg.getContext(), 2131427854) * 2 * d.dr(this.jfg.getContext())) + i);
      ((e)localObject1).ivs.getLayoutParams().width = i;
      ((e)localObject1).ivs.getLayoutParams().height = i;
      ((e)localObject1).jfs.getLayoutParams().width = i;
      ((e)localObject1).jfs.getLayoutParams().height = i;
      paramv.aku.setVisibility(0);
      if (AppBrandDesktopView.q(this.jfg) == 0)
      {
        localObject2 = paramv.aku;
        ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", new Object[] { Integer.valueOf(((View)localObject2).getMeasuredHeight()), Integer.valueOf(((View)localObject2).getMeasuredWidth()) });
        AppBrandDesktopView.e(this.jfg, ((View)localObject2).getMeasuredHeight());
      }
      if (j == 7)
      {
        paramv.aku.setVisibility(4);
        if (((paramInt - AppBrandDesktopView.g(this.jfg) + 1) % 4 == 1) && (paramInt > AppBrandDesktopView.g(this.jfg)))
        {
          paramv.aku.getLayoutParams().height = 1;
          ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder height: %d", new Object[] { Integer.valueOf(paramv.aku.getLayoutParams().height) });
        }
        AppMethodBeat.o(133847);
        return;
      }
      localObject2 = qd(paramInt);
      if (localObject2 == null)
      {
        AppMethodBeat.o(133847);
        return;
      }
      ((AppBrandDesktopView.c)localObject2).position = paramInt;
      ((e)localObject1).jfw = ((AppBrandDesktopView.c)localObject2);
      if (((AppBrandDesktopView.c)localObject2).jfk == null) {
        break label1532;
      }
      if (bo.isNullOrNil(((AppBrandDesktopView.c)localObject2).jfk.bDi)) {
        break label1369;
      }
      ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.c.b.FF(((AppBrandDesktopView.c)localObject2).jfk.bDi));
      ((e)localObject1).titleTv.setVisibility(0);
      ((e)localObject1).jfs.setVisibility(0);
      if (bo.isNullOrNil(((AppBrandDesktopView.c)localObject2).jfk.hcN)) {
        break label1505;
      }
      com.tencent.mm.modelappbrand.a.b.acD().a(((e)localObject1).ivs, ((AppBrandDesktopView.c)localObject2).jfk.hcN, com.tencent.mm.modelappbrand.a.a.acC(), f.fqU);
      label1252:
      if (bo.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.b.nj(((AppBrandDesktopView.c)localObject2).jfk.hcr))) {
        break label1519;
      }
      ((e)localObject1).jfu.setVisibility(0);
      ((e)localObject1).jfu.setText(com.tencent.mm.plugin.appbrand.appcache.b.nj(((AppBrandDesktopView.c)localObject2).jfk.hcr));
      label1297:
      ((e)localObject1).aku.setOnClickListener(new AppBrandDesktopView.e.4(this, (AppBrandDesktopView.c)localObject2, (e)localObject1));
    }
    for (;;)
    {
      if (this.jfg.getDragRubbishView() != null)
      {
        localObject1 = this.jfg.getDragRubbishView();
        if (((DragFeatureView)localObject1).getVisibility() != 8)
        {
          if (((DragFeatureView)localObject1).jfB == paramInt)
          {
            paramv.aku.setVisibility(4);
            AppMethodBeat.o(133847);
            return;
            label1369:
            if (!bo.isNullOrNil(((AppBrandDesktopView.c)localObject2).jfk.nickname))
            {
              ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.c.b.FF(((AppBrandDesktopView.c)localObject2).jfk.nickname));
              ((e)localObject1).titleTv.setVisibility(0);
              break;
            }
            if (!bo.isNullOrNil(((AppBrandDesktopView.c)localObject2).jfk.username))
            {
              ((e)localObject1).titleTv.setText(com.tencent.mm.plugin.appbrand.widget.desktop.c.b.FF(((AppBrandDesktopView.c)localObject2).jfk.nickname));
              ((e)localObject1).titleTv.setVisibility(0);
              break;
            }
            ab.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", new Object[] { ((AppBrandDesktopView.c)localObject2).jfk.username, ((AppBrandDesktopView.c)localObject2).jfk.appId });
            ((e)localObject1).titleTv.setVisibility(4);
            break;
            label1505:
            ((e)localObject1).ivs.setImageDrawable(com.tencent.mm.modelappbrand.a.a.acC());
            break label1252;
            label1519:
            ((e)localObject1).jfu.setVisibility(8);
            break label1297;
            label1532:
            com.tencent.mm.modelappbrand.a.b.acD().a(((e)localObject1).ivs, "", com.tencent.mm.modelappbrand.a.a.acC(), f.fqU);
            ((e)localObject1).titleTv.setVisibility(0);
            ((e)localObject1).jfu.setVisibility(8);
            ((e)localObject1).titleTv.setText("");
            continue;
          }
          paramv.aku.setVisibility(0);
        }
      }
    }
    AppMethodBeat.o(133847);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(133848);
    int i = AppBrandDesktopView.n(this.jfg).size();
    AppMethodBeat.o(133848);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(133846);
    AppBrandDesktopView.c localc = qd(paramInt);
    if (localc != null)
    {
      paramInt = localc.type;
      AppMethodBeat.o(133846);
      return paramInt;
    }
    AppMethodBeat.o(133846);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.e
 * JD-Core Version:    0.7.0.1
 */