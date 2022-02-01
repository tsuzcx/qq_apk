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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public class AAQueryListUI
  extends BaseAAPresenterActivity
{
  private com.tencent.mm.plugin.aa.model.b.b jUS;
  private ListView jUT;
  private b jUU;
  private Dialog jUV;
  private boolean jUW;
  private boolean jUX;
  private View jUY;
  private AAQueryListH5UrlFooterView jUZ;
  private String jVa;
  private int mode;
  
  public AAQueryListUI()
  {
    AppMethodBeat.i(63518);
    this.jUS = ((com.tencent.mm.plugin.aa.model.b.b)aq(com.tencent.mm.plugin.aa.model.b.b.class));
    this.jUW = false;
    this.jUX = false;
    this.mode = 1;
    AppMethodBeat.o(63518);
  }
  
  private void m(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(63520);
    if (this.jUW)
    {
      Log.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
      AppMethodBeat.o(63520);
      return;
    }
    if (paramBoolean)
    {
      this.jUX = false;
      this.jUT.removeFooterView(this.jUZ);
    }
    this.jUW = true;
    this.jUS.jTT.l(paramBoolean, paramInt).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void cn(Object paramAnonymousObject)
      {
        AppMethodBeat.i(63515);
        Log.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[] { paramAnonymousObject });
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
        Toast.makeText(AAQueryListUI.this, 2131761442, 1).show();
        AppMethodBeat.o(63515);
      }
    });
    AppMethodBeat.o(63520);
  }
  
  public int getLayoutId()
  {
    return 2131492902;
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
        this.jUT.setSelectionFromTop(i, j);
        m(true, this.mode);
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
    setMMTitle(2131755067);
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63514);
        paramAnonymousMenuItem = new e(AAQueryListUI.this, 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(63512);
            paramAnonymous2m.add(0, 1, 1, 2131755068);
            paramAnonymous2m.add(1, 2, 1, 2131755069);
            AppMethodBeat.o(63512);
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
              Log.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(AAQueryListUI.this)) });
              if (AAQueryListUI.e(AAQueryListUI.this) == 1)
              {
                AppMethodBeat.o(63513);
                return;
              }
              AAQueryListUI.a(AAQueryListUI.this, 1);
              AAQueryListUI.this.setMMTitle(2131755067);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).bmv();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
              AppMethodBeat.o(63513);
              return;
              Log.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(AAQueryListUI.this)) });
              if (AAQueryListUI.e(AAQueryListUI.this) == 2)
              {
                AppMethodBeat.o(63513);
                return;
              }
              AAQueryListUI.this.setMMTitle(2131755070);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).bmv();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, 2);
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
            }
          }
        };
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(63514);
        return true;
      }
    });
    this.jUT = ((ListView)findViewById(2131296302));
    this.jUT.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.jUT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63511);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        int i;
        if (AAQueryListUI.f(AAQueryListUI.this) != null)
        {
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= AAQueryListUI.f(AAQueryListUI.this).getCount()))
          {
            Log.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(63511);
            return;
          }
          i = paramAnonymousView.getTop();
          paramAnonymousView = (com.tencent.mm.protocal.protobuf.m)AAQueryListUI.f(AAQueryListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (Util.isNullOrNil(paramAnonymousView.KBH)) {
              break label215;
            }
            f.p(AAQueryListUI.this.getContext(), paramAnonymousView.KBH, true);
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(63511);
          return;
          label215:
          if (!Util.isNullOrNil(paramAnonymousView.KBs))
          {
            paramAnonymousAdapterView = null;
            if (paramAnonymousView.role == 2) {
              paramAnonymousAdapterView = z.aTY();
            }
            localObject = new Intent(AAQueryListUI.this, PaylistAAUI.class);
            ((Intent)localObject).putExtra("bill_no", paramAnonymousView.KBs);
            ((Intent)localObject).putExtra("launcher_user_name", paramAnonymousAdapterView);
            ((Intent)localObject).putExtra("enter_scene", 4);
            ((Intent)localObject).putExtra("chatroom", paramAnonymousView.KBt);
            ((Intent)localObject).putExtra("item_position", paramAnonymousInt);
            ((Intent)localObject).putExtra("item_offset", i);
            AAQueryListUI.this.startActivityForResult((Intent)localObject, 1);
          }
        }
      }
    });
    this.jUY = new AAQueryListLoadingMoreView(this);
    this.jUZ = new AAQueryListH5UrlFooterView(this);
    this.jUV = com.tencent.mm.wallet_core.ui.h.a(this, false, null);
    this.jUU = new b(this, this.mode);
    this.jUT.setAdapter(this.jUU);
    this.jUT.setVisibility(4);
    m(false, this.mode);
    AppMethodBeat.o(63519);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI
 * JD-Core Version:    0.7.0.1
 */