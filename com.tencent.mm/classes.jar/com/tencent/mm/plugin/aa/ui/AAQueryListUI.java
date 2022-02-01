package com.tencent.mm.plugin.aa.ui;

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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.l;
import java.util.HashSet;
import java.util.List;

public class AAQueryListUI
  extends BaseAAPresenterActivity
{
  private int mode;
  private com.tencent.mm.plugin.aa.model.b.b pIN;
  private ListView pIO;
  private b pIP;
  private Dialog pIQ;
  private boolean pIR;
  private boolean pIS;
  private View pIT;
  private AAQueryListH5UrlFooterView pIU;
  private String pIV;
  
  public AAQueryListUI()
  {
    AppMethodBeat.i(63518);
    this.pIN = ((com.tencent.mm.plugin.aa.model.b.b)aI(com.tencent.mm.plugin.aa.model.b.b.class));
    this.pIR = false;
    this.pIS = false;
    this.mode = 1;
    AppMethodBeat.o(63518);
  }
  
  private void m(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(63520);
    if (this.pIR)
    {
      Log.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
      AppMethodBeat.o(63520);
      return;
    }
    if (paramBoolean)
    {
      this.pIS = false;
      this.pIO.removeFooterView(this.pIU);
    }
    this.pIR = true;
    this.pIN.pHN.l(paramBoolean, paramInt).f(new com.tencent.mm.vending.c.a() {}).a(new d.a()
    {
      public final void onInterrupt(Object paramAnonymousObject)
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
        Toast.makeText(AAQueryListUI.this, a.i.get_aa_list_record_failed, 1).show();
        AppMethodBeat.o(63515);
      }
    });
    AppMethodBeat.o(63520);
  }
  
  public int getLayoutId()
  {
    return a.g.aa_query_list_ui;
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
        this.pIO.setSelectionFromTop(i, j);
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
    setMMTitle(a.i.aa_record_list_launch_title);
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63514);
        paramAnonymousMenuItem = new f(AAQueryListUI.this, 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(63512);
            paramAnonymous2s.add(0, 1, 1, a.i.aa_record_list_menu_launch);
            paramAnonymous2s.add(1, 2, 1, a.i.aa_record_list_menu_pay);
            AppMethodBeat.o(63512);
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
              AAQueryListUI.this.setMMTitle(a.i.aa_record_list_launch_title);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).bVt();
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
              AAQueryListUI.this.setMMTitle(a.i.aa_record_list_pay_title);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).bVt();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, 2);
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
            }
          }
        };
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(63514);
        return true;
      }
    });
    this.pIO = ((ListView)findViewById(a.f.aa_query_listview));
    this.pIO.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.pIO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63511);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          paramAnonymousView = (n)AAQueryListUI.f(AAQueryListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (Util.isNullOrNil(paramAnonymousView.YAb)) {
              break label215;
            }
            i.p(AAQueryListUI.this.getContext(), paramAnonymousView.YAb, true);
          }
        }
        for (;;)
        {
          h.OAn.b(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/AAQueryListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(63511);
          return;
          label215:
          if (!Util.isNullOrNil(paramAnonymousView.YzL))
          {
            paramAnonymousAdapterView = null;
            if (paramAnonymousView.role == 2) {
              paramAnonymousAdapterView = z.bAM();
            }
            localObject = new Intent(AAQueryListUI.this, PaylistAAUI.class);
            ((Intent)localObject).putExtra("bill_no", paramAnonymousView.YzL);
            ((Intent)localObject).putExtra("launcher_user_name", paramAnonymousAdapterView);
            ((Intent)localObject).putExtra("enter_scene", 4);
            ((Intent)localObject).putExtra("chatroom", paramAnonymousView.YzM);
            ((Intent)localObject).putExtra("item_position", paramAnonymousInt);
            ((Intent)localObject).putExtra("item_offset", i);
            AAQueryListUI.this.startActivityForResult((Intent)localObject, 1);
          }
        }
      }
    });
    this.pIT = new AAQueryListLoadingMoreView(this);
    this.pIU = new AAQueryListH5UrlFooterView(this);
    this.pIQ = l.c(this, false, null);
    this.pIP = new b(this, this.mode);
    this.pIO.setAdapter(this.pIP);
    this.pIO.setVisibility(4);
    m(false, this.mode);
    AppMethodBeat.o(63519);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268503);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(268503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListUI
 * JD-Core Version:    0.7.0.1
 */