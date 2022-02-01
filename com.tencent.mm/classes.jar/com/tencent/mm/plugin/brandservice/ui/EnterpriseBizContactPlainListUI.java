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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String hSG;
  private ListView jsM;
  private a oew;
  private long oex;
  private AdapterView.OnItemClickListener oey;
  private int scene;
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5736);
    this.jsM = ((ListView)findViewById(2131299505));
    if (this.oew == null)
    {
      this.oew = new a(this);
      this.oey = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5719);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          ae.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5719);
        }
      };
    }
    ae.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.oew.getCount()) });
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.hSG);
    if (this.scene == 2)
    {
      setMMTitle(2131758438);
      if ((localObject != null) && (com.tencent.mm.contact.c.lO(((aw)localObject).field_type)) && (this.oew.getCount() > 0)) {
        break label218;
      }
      this.jsM.setVisibility(8);
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
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(5721);
        }
      });
      AppMethodBeat.o(5736);
      return;
      if (localObject == null) {
        break;
      }
      setMMTitle(((an)localObject).adF());
      break;
      label218:
      this.jsM.setVisibility(0);
      this.jsM.setAdapter(this.oew);
      this.jsM.setOnItemClickListener(this.oey);
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
    this.hSG = getIntent().getStringExtra("enterprise_biz_name");
    this.oex = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    ae.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.hSG });
    initView();
    ag.aGp().add(this.oew);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this.oew);
    AppMethodBeat.o(5735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5739);
    ag.aGp().remove(this.oew);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this.oew);
    this.oew.dhl();
    a locala = this.oew;
    if (locala.jgu != null)
    {
      locala.jgu.detach();
      locala.jgu = null;
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
    if (!x.An(this.hSG))
    {
      ae.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.hSG });
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
    extends r<pv>
    implements n.b
  {
    com.tencent.mm.ui.applet.b jgu;
    private b.b jgv;
    
    public a(Context paramContext)
    {
      super(new pv());
      AppMethodBeat.i(5729);
      this.jgv = null;
      this.jgu = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Kc(String paramAnonymousString)
        {
          AppMethodBeat.i(5724);
          paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(5724);
          return paramAnonymousString;
        }
      });
      ZD();
      AppMethodBeat.o(5729);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(5733);
      if (!com.tencent.mm.kernel.g.ajM())
      {
        ae.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        AppMethodBeat.o(5733);
        return;
      }
      dhl();
      Object localObject2 = null;
      Object localObject1;
      switch (EnterpriseBizContactPlainListUI.b(EnterpriseBizContactPlainListUI.this))
      {
      default: 
        ag.aGp();
        localObject1 = f.M(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), true);
      }
      for (;;)
      {
        setCursor((Cursor)localObject1);
        AppMethodBeat.o(5733);
        return;
        ag.aGp();
        localObject1 = f.am(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 25);
        continue;
        ag.aGp();
        localObject1 = f.Eh(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        continue;
        ag.aGp();
        localObject1 = f.am(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 128);
        continue;
        com.tencent.mm.api.c localc = com.tencent.mm.al.g.eX(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localObject2;
          if (localc.field_enterpriseFather != null) {
            localObject1 = ag.aGp().Eg(localc.field_enterpriseFather);
          }
        }
      }
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(224124);
      ZD();
      AppMethodBeat.o(224124);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(5730);
      ae.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5725);
          EnterpriseBizContactPlainListUI.a.this.ZE();
          TextView localTextView = (TextView)EnterpriseBizContactPlainListUI.this.findViewById(2131299506);
          if ((EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this) != null) && (localTextView != null))
          {
            an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
            if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
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
      if (this.jgv == null) {
        this.jgv = new b.b()
        {
          public final int aTk()
          {
            AppMethodBeat.i(5727);
            int i = EnterpriseBizContactPlainListUI.a.this.getCount();
            AppMethodBeat.o(5727);
            return i;
          }
          
          public final String rq(int paramAnonymousInt)
          {
            AppMethodBeat.i(5726);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= EnterpriseBizContactPlainListUI.a.this.getCount()))
            {
              ae.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
              AppMethodBeat.o(5726);
              return null;
            }
            Object localObject = (pv)EnterpriseBizContactPlainListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(5726);
              return null;
            }
            localObject = ((pv)localObject).userName;
            AppMethodBeat.o(5726);
            return localObject;
          }
        };
      }
      if (this.jgu != null) {
        this.jgu.a(paramInt, this.jgv);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131493839, null);
        paramViewGroup.jgy = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jeP = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      pv localpv;
      for (;;)
      {
        localpv = (pv)getItem(paramInt);
        if (localpv != null) {
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
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231818));
      paramView.setPadding(k, i, j, paramInt);
      String str = bu.nullAsNil(localpv.contact.adF());
      paramViewGroup.jeP.setText(k.b(this.context, str, paramViewGroup.jeP.getTextSize()));
      paramViewGroup.jeP.setVisibility(0);
      paramViewGroup.jgy.setVisibility(0);
      if (!bu.isNullOrNil(localpv.contact.field_username)) {
        a.b.c(paramViewGroup.jgy, localpv.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup.jgy.setImageDrawable(null);
      }
    }
    
    final class a
    {
      TextView jeP;
      ImageView jgy;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(5728);
        if (this.jgy != null)
        {
          this.jgy.setImageDrawable(null);
          this.jgy.setVisibility(8);
        }
        if (this.jeP != null)
        {
          this.jeP.setText("");
          this.jeP.setVisibility(8);
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