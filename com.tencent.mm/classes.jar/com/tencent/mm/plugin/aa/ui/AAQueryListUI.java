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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.wallet_core.ui.g;
import java.util.List;

public class AAQueryListUI
  extends BaseAAPresenterActivity
{
  private com.tencent.mm.plugin.aa.model.b.b iBQ;
  private ListView iBR;
  private b iBS;
  private Dialog iBT;
  private boolean iBU;
  private boolean iBV;
  private View iBW;
  private AAQueryListH5UrlFooterView iBX;
  private String iBY;
  private int mode;
  
  public AAQueryListUI()
  {
    AppMethodBeat.i(63518);
    this.iBQ = ((com.tencent.mm.plugin.aa.model.b.b)am(com.tencent.mm.plugin.aa.model.b.b.class));
    this.iBU = false;
    this.iBV = false;
    this.mode = 1;
    AppMethodBeat.o(63518);
  }
  
  private void o(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(63520);
    if (this.iBU)
    {
      ac.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
      AppMethodBeat.o(63520);
      return;
    }
    if (paramBoolean)
    {
      this.iBV = false;
      this.iBR.removeFooterView(this.iBX);
    }
    this.iBU = true;
    this.iBQ.iAU.n(paramBoolean, paramInt).f(new a() {}).a(new d.a()
    {
      public final void cc(Object paramAnonymousObject)
      {
        AppMethodBeat.i(63515);
        ac.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[] { paramAnonymousObject });
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
        this.iBR.setSelectionFromTop(i, j);
        o(true, this.mode);
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
        paramAnonymousMenuItem.ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(63512);
            paramAnonymous2l.add(0, 1, 1, 2131755061);
            paramAnonymous2l.add(1, 2, 1, 2131755062);
            AppMethodBeat.o(63512);
          }
        };
        paramAnonymousMenuItem.ISv = new n.d()
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
              ac.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(AAQueryListUI.this)) });
              if (AAQueryListUI.e(AAQueryListUI.this) == 1)
              {
                AppMethodBeat.o(63513);
                return;
              }
              AAQueryListUI.a(AAQueryListUI.this, 1);
              AAQueryListUI.this.setMMTitle(2131755060);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).aOf();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
              AppMethodBeat.o(63513);
              return;
              ac.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[] { Integer.valueOf(AAQueryListUI.e(AAQueryListUI.this)) });
              if (AAQueryListUI.e(AAQueryListUI.this) == 2)
              {
                AppMethodBeat.o(63513);
                return;
              }
              AAQueryListUI.this.setMMTitle(2131755063);
              AAQueryListUI.f(AAQueryListUI.this).mode = AAQueryListUI.e(AAQueryListUI.this);
              AAQueryListUI.f(AAQueryListUI.this).aOf();
              AAQueryListUI.f(AAQueryListUI.this).notifyDataSetChanged();
              AAQueryListUI.a(AAQueryListUI.this, 2);
              AAQueryListUI.a(AAQueryListUI.this, true, AAQueryListUI.e(AAQueryListUI.this));
            }
          }
        };
        paramAnonymousMenuItem.cED();
        AppMethodBeat.o(63514);
        return true;
      }
    });
    this.iBR = ((ListView)findViewById(2131296298));
    this.iBR.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.iBR.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(63511);
        int i;
        if (AAQueryListUI.f(AAQueryListUI.this) != null)
        {
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= AAQueryListUI.f(AAQueryListUI.this).getCount()))
          {
            ac.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(63511);
            return;
          }
          i = paramAnonymousView.getTop();
          paramAnonymousView = (k)AAQueryListUI.f(AAQueryListUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (bs.isNullOrNil(paramAnonymousView.DKP)) {
              break label140;
            }
            com.tencent.mm.wallet_core.ui.e.o(AAQueryListUI.this.getContext(), paramAnonymousView.DKP, true);
          }
        }
        for (;;)
        {
          h.wUl.f(13721, new Object[] { Integer.valueOf(5), Integer.valueOf(3) });
          AppMethodBeat.o(63511);
          return;
          label140:
          if (!bs.isNullOrNil(paramAnonymousView.DKA))
          {
            paramAnonymousAdapterView = null;
            if (paramAnonymousView.role == 2) {
              paramAnonymousAdapterView = u.axw();
            }
            Intent localIntent = new Intent(AAQueryListUI.this, PaylistAAUI.class);
            localIntent.putExtra("bill_no", paramAnonymousView.DKA);
            localIntent.putExtra("launcher_user_name", paramAnonymousAdapterView);
            localIntent.putExtra("enter_scene", 4);
            localIntent.putExtra("chatroom", paramAnonymousView.DKB);
            localIntent.putExtra("item_position", paramAnonymousInt);
            localIntent.putExtra("item_offset", i);
            AAQueryListUI.this.startActivityForResult(localIntent, 1);
          }
        }
      }
    });
    this.iBW = new AAQueryListLoadingMoreView(this);
    this.iBX = new AAQueryListH5UrlFooterView(this);
    this.iBT = g.a(this, false, null);
    this.iBS = new b(this, this.mode);
    this.iBR.setAdapter(this.iBS);
    this.iBR.setVisibility(4);
    o(false, this.mode);
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