package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.aa.model.b.b.a;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class AAQueryListUI
  extends BaseAAPresenterActivity
{
  private com.tencent.mm.plugin.aa.model.b.b iVa;
  private ListView iVb;
  private b iVc;
  private Dialog iVd;
  private boolean iVe;
  private boolean iVf;
  private View iVg;
  private AAQueryListH5UrlFooterView iVh;
  private String iVi;
  private int mode;
  
  public AAQueryListUI()
  {
    AppMethodBeat.i(63518);
    this.iVa = ((com.tencent.mm.plugin.aa.model.b.b)am(com.tencent.mm.plugin.aa.model.b.b.class));
    this.iVe = false;
    this.iVf = false;
    this.mode = 1;
    AppMethodBeat.o(63518);
  }
  
  private void n(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(63520);
    if (this.iVe)
    {
      ad.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
      AppMethodBeat.o(63520);
      return;
    }
    if (paramBoolean)
    {
      this.iVf = false;
      this.iVb.removeFooterView(this.iVh);
    }
    this.iVe = true;
    this.iVa.iUe.m(paramBoolean, paramInt).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void ce(Object paramAnonymousObject)
      {
        AppMethodBeat.i(63515);
        ad.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[] { paramAnonymousObject });
        if (AAQueryListUI.g(AAQueryListUI.this) != null)
        {
          AAQueryListUI.g(AAQueryListUI.this).dismiss();
          AAQueryListUI.h(AAQueryListUI.this);
        }
        AAQueryListUI.i(AAQueryListUI.this);
        if (AAQueryListUI.a(AAQueryListUI.this).getFooterViewsCount() > 0) {
          AAQueryListUI.a(AAQueryListUI.this).removeFooterView(AAQueryListUI.d(AAQueryListUI.this));
        }
        if ((paramAnonymousObject instanceof String))
        {
          Toast.makeText(AAQueryListUI.this, paramAnonymousObject.toString(), 1).show();
          AppMethodBeat.o(63515);
          return;
        }
        Toast.makeText(AAQueryListUI.this, 2131760064, 1).show();
        AppMethodBeat.o(63515);
      }
    });
    AppMethodBeat.o(63520);
  }
  
  public int getLayoutId()
  {
    return 2131492886;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(63521);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      boolean bool = paramIntent.getBooleanExtra("close_aa", false);
      int i = paramIntent.getIntExtra("item_position", 0);
      int j = paramIntent.getIntExtra("item_offset", 0);
      if (bool)
      {
        this.iVb.setSelectionFromTop(i, j);
        n(true, this.mode);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(63521);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63519);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63509);
        AAQueryListUI.this.finish();
        AppMethodBeat.o(63509);
        return false;
      }
    });
    setMMTitle(2131755060);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63514);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(AAQueryListUI.this, 1, false);
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(63512);
            paramAnonymous2l.add(0, 1, 1, 2131755061);
            paramAnonymous2l.add(1, 2, 1, 2131755062);
            AppMethodBeat.o(63512);
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(63513);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(63513);
              return;
              ad.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(AAQueryListUI.this)) });
              if (AAQueryListUI.e(AAQueryListUI.this) == 1)
              {
                AppMethodBeat.o(63513);
                return;
              }
              AAQueryListUI.a(AAQueryListUI.this, 1);
              AAQueryListUI.this.setMMTitle(2131755060);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).aRr();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
              AppMethodBeat.o(63513);
              return;
              ad.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(AAQueryListUI.this)) });
              if (AAQueryListUI.e(AAQueryListUI.this) == 2)
              {
                AppMethodBeat.o(63513);
                return;
              }
              AAQueryListUI.this.setMMTitle(2131755063);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).aRr();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, 2);
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
            }
          }
        };
        paramAnonymousMenuItem.cMW();
        AppMethodBeat.o(63514);
        return true;
      }
    });
    this.iVb = ((ListView)findViewById(2131296298));
    this.iVb.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(63510);
        if ((AAQueryListUI.a(AAQueryListUI.this).getLastVisiblePosition() == AAQueryListUI.a(AAQueryListUI.this).getCount() - 1) && (AAQueryListUI.a(AAQueryListUI.this).getCount() > 0) && (!AAQueryListUI.b(AAQueryListUI.this)) && (!AAQueryListUI.c(AAQueryListUI.this)))
        {
          AAQueryListUI.a(AAQueryListUI.this).addFooterView(AAQueryListUI.d(AAQueryListUI.this));
          AAQueryListUI.a(AAQueryListUI.this, false, AAQueryListUI.e(AAQueryListUI.this));
        }
        AppMethodBeat.o(63510);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.iVb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63511);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int i;
        if (AAQueryListUI.f(AAQueryListUI.this) != null)
        {
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= AAQueryListUI.f(AAQueryListUI.this).getCount()))
          {
            ad.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(63511);
            return;
          }
          i = paramAnonymousView.getTop();
          paramAnonymousView = (k)AAQueryListUI.f(AAQueryListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (bt.isNullOrNil(paramAnonymousView.FpV)) {
              break label215;
            }
            com.tencent.mm.wallet_core.ui.e.o(AAQueryListUI.this.getContext(), paramAnonymousView.FpV, true);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(63511);
          return;
          label215:
          if (!bt.isNullOrNil(paramAnonymousView.FpG))
          {
            paramAnonymousAdapterView = null;
            if (paramAnonymousView.role == 2) {
              paramAnonymousAdapterView = u.aAm();
            }
            localObject = new Intent(AAQueryListUI.this, PaylistAAUI.class);
            ((Intent)localObject).putExtra("bill_no", paramAnonymousView.FpG);
            ((Intent)localObject).putExtra("launcher_user_name", paramAnonymousAdapterView);
            ((Intent)localObject).putExtra("enter_scene", 4);
            ((Intent)localObject).putExtra("chatroom", paramAnonymousView.FpH);
            ((Intent)localObject).putExtra("item_position", paramAnonymousInt);
            ((Intent)localObject).putExtra("item_offset", i);
            AAQueryListUI.this.startActivityForResult((Intent)localObject, 1);
          }
        }
      }
    });
    this.iVg = new AAQueryListLoadingMoreView(this);
    this.iVh = new AAQueryListH5UrlFooterView(this);
    this.iVd = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
    this.iVc = new b(this, this.mode);
    this.iVb.setAdapter(this.iVc);
    this.iVb.setVisibility(4);
    n(false, this.mode);
    AppMethodBeat.o(63519);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI
 * JD-Core Version:    0.7.0.1
 */