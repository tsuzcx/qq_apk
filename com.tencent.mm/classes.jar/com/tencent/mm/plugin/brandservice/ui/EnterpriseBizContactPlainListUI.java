package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String hxt;
  private ListView iWK;
  private a nxp;
  private long nxq;
  private AdapterView.OnItemClickListener nxr;
  private int scene;
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5736);
    this.iWK = ((ListView)findViewById(2131299505));
    if (this.nxp == null)
    {
      this.nxp = new a(this);
      this.nxr = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5719);
          ac.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this, paramAnonymousInt);
          AppMethodBeat.o(5719);
        }
      };
    }
    ac.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.nxp.getCount()) });
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.hxt);
    if (this.scene == 2)
    {
      setMMTitle(2131758438);
      if ((localObject != null) && (com.tencent.mm.n.b.ln(((av)localObject).field_type)) && (this.nxp.getCount() > 0)) {
        break label218;
      }
      this.iWK.setVisibility(8);
      localObject = (TextView)findViewById(2131299506);
      ((TextView)localObject).setText(2131758444);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(5720);
          EnterpriseBizContactPlainListUI.this.hideVKB();
          EnterpriseBizContactPlainListUI.this.finish();
          AppMethodBeat.o(5720);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5721);
          paramAnonymousView = EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(5721);
        }
      });
      AppMethodBeat.o(5736);
      return;
      if (localObject == null) {
        break;
      }
      setMMTitle(((ai)localObject).aaR());
      break;
      label218:
      this.iWK.setVisibility(0);
      this.iWK.setAdapter(this.nxp);
      this.iWK.setOnItemClickListener(this.nxr);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5740);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.scene == 4) {
      finish();
    }
    AppMethodBeat.o(5740);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5735);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.hxt = getIntent().getStringExtra("enterprise_biz_name");
    this.nxq = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    ac.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.hxt });
    initView();
    af.aCW().add(this.nxp);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this.nxp);
    AppMethodBeat.o(5735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5739);
    af.aCW().remove(this.nxp);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this.nxp);
    this.nxp.cVi();
    a locala = this.nxp;
    if (locala.iKs != null)
    {
      locala.iKs.detach();
      locala.iKs = null;
    }
    super.onDestroy();
    AppMethodBeat.o(5739);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5738);
    super.onPause();
    AppMethodBeat.o(5738);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5737);
    super.onResume();
    if (!w.wG(this.hxt))
    {
      ac.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.hxt });
      finish();
      AppMethodBeat.o(5737);
      return;
    }
    AppMethodBeat.o(5737);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<oo>
    implements n.b
  {
    com.tencent.mm.ui.applet.b iKs;
    private b.b iKt;
    
    public a(Context paramContext)
    {
      super(new oo());
      AppMethodBeat.i(5729);
      this.iKt = null;
      this.iKs = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Go(String paramAnonymousString)
        {
          AppMethodBeat.i(5724);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(5724);
          return paramAnonymousString;
        }
      });
      Xb();
      AppMethodBeat.o(5729);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(5733);
      if (!g.agM())
      {
        ac.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        AppMethodBeat.o(5733);
        return;
      }
      cVi();
      Object localObject2 = null;
      Object localObject1;
      switch (EnterpriseBizContactPlainListUI.b(EnterpriseBizContactPlainListUI.this))
      {
      default: 
        af.aCW();
        localObject1 = e.M(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), true);
      }
      for (;;)
      {
        setCursor((Cursor)localObject1);
        AppMethodBeat.o(5733);
        return;
        af.aCW();
        localObject1 = e.ah(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 25);
        continue;
        af.aCW();
        localObject1 = e.AG(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        continue;
        af.aCW();
        localObject1 = e.ah(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 128);
        continue;
        com.tencent.mm.api.c localc = f.dX(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localObject2;
          if (localc.field_enterpriseFather != null) {
            localObject1 = af.aCW().AF(localc.field_enterpriseFather);
          }
        }
      }
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(210004);
      Xb();
      AppMethodBeat.o(210004);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(5730);
      ac.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5725);
          EnterpriseBizContactPlainListUI.a.this.Xc();
          TextView localTextView = (TextView)EnterpriseBizContactPlainListUI.this.findViewById(2131299506);
          if ((EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this) != null) && (localTextView != null))
          {
            ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
            if ((localai != null) && (com.tencent.mm.n.b.ln(localai.field_type))) {
              break label123;
            }
            EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizContactPlainListUI.a.this.notifyDataSetChanged();
            AppMethodBeat.o(5725);
            return;
            label123:
            if (EnterpriseBizContactPlainListUI.d(EnterpriseBizContactPlainListUI.this).getCount() <= 0)
            {
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setVisibility(8);
              localTextView.setVisibility(0);
            }
            else
            {
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setVisibility(0);
              localTextView.setVisibility(8);
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setAdapter(EnterpriseBizContactPlainListUI.d(EnterpriseBizContactPlainListUI.this));
              EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this).setOnItemClickListener(EnterpriseBizContactPlainListUI.e(EnterpriseBizContactPlainListUI.this));
            }
          }
        }
      });
      AppMethodBeat.o(5730);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(5731);
      if (this.iKt == null) {
        this.iKt = new b.b()
        {
          public final int aPz()
          {
            AppMethodBeat.i(5727);
            int i = EnterpriseBizContactPlainListUI.a.this.getCount();
            AppMethodBeat.o(5727);
            return i;
          }
          
          public final String qN(int paramAnonymousInt)
          {
            AppMethodBeat.i(5726);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= EnterpriseBizContactPlainListUI.a.this.getCount()))
            {
              ac.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
              AppMethodBeat.o(5726);
              return null;
            }
            Object localObject = (oo)EnterpriseBizContactPlainListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(5726);
              return null;
            }
            localObject = ((oo)localObject).userName;
            AppMethodBeat.o(5726);
            return localObject;
          }
        };
      }
      if (this.iKs != null) {
        this.iKs.a(paramInt, this.iKt);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131493839, null);
        paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iIN = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      oo localoo;
      for (;;)
      {
        localoo = (oo)getItem(paramInt);
        if (localoo != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231818));
      paramView.setPadding(k, i, j, paramInt);
      String str = bs.nullAsNil(localoo.contact.aaR());
      paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramViewGroup.iIN.getTextSize()));
      paramViewGroup.iIN.setVisibility(0);
      paramViewGroup.iKw.setVisibility(0);
      if (!bs.isNullOrNil(localoo.contact.field_username)) {
        a.b.c(paramViewGroup.iKw, localoo.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup.iKw.setImageDrawable(null);
      }
    }
    
    final class a
    {
      TextView iIN;
      ImageView iKw;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(5728);
        if (this.iKw != null)
        {
          this.iKw.setImageDrawable(null);
          this.iKw.setVisibility(8);
        }
        if (this.iIN != null)
        {
          this.iIN.setText("");
          this.iIN.setVisibility(8);
        }
        AppMethodBeat.o(5728);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI
 * JD-Core Version:    0.7.0.1
 */