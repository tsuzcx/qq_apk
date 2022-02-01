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
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String hPO;
  private ListView jpT;
  private a nYN;
  private long nYO;
  private AdapterView.OnItemClickListener nYP;
  private int scene;
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5736);
    this.jpT = ((ListView)findViewById(2131299505));
    if (this.nYN == null)
    {
      this.nYN = new a(this);
      this.nYP = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5719);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          ad.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5719);
        }
      };
    }
    ad.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.nYN.getCount()) });
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.hPO);
    if (this.scene == 2)
    {
      setMMTitle(2131758438);
      if ((localObject != null) && (com.tencent.mm.o.b.lM(((aw)localObject).field_type)) && (this.nYN.getCount() > 0)) {
        break label218;
      }
      this.jpT.setVisibility(8);
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
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
      setMMTitle(((am)localObject).adu());
      break;
      label218:
      this.jpT.setVisibility(0);
      this.jpT.setAdapter(this.nYN);
      this.jpT.setOnItemClickListener(this.nYP);
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
    this.hPO = getIntent().getStringExtra("enterprise_biz_name");
    this.nYO = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    ad.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.hPO });
    initView();
    ag.aFZ().add(this.nYN);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this.nYN);
    AppMethodBeat.o(5735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5739);
    ag.aFZ().remove(this.nYN);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this.nYN);
    this.nYN.det();
    a locala = this.nYN;
    if (locala.jdB != null)
    {
      locala.jdB.detach();
      locala.jdB = null;
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
    if (!w.zD(this.hPO))
    {
      ad.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.hPO });
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
    extends r<pt>
    implements n.b
  {
    com.tencent.mm.ui.applet.b jdB;
    private b.b jdC;
    
    public a(Context paramContext)
    {
      super(new pt());
      AppMethodBeat.i(5729);
      this.jdC = null;
      this.jdB = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap JD(String paramAnonymousString)
        {
          AppMethodBeat.i(5724);
          paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(5724);
          return paramAnonymousString;
        }
      });
      Zu();
      AppMethodBeat.o(5729);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(5733);
      if (!com.tencent.mm.kernel.g.ajx())
      {
        ad.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        AppMethodBeat.o(5733);
        return;
      }
      det();
      Object localObject2 = null;
      Object localObject1;
      switch (EnterpriseBizContactPlainListUI.b(EnterpriseBizContactPlainListUI.this))
      {
      default: 
        ag.aFZ();
        localObject1 = f.M(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), true);
      }
      for (;;)
      {
        setCursor((Cursor)localObject1);
        AppMethodBeat.o(5733);
        return;
        ag.aFZ();
        localObject1 = f.al(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 25);
        continue;
        ag.aFZ();
        localObject1 = f.DF(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        continue;
        ag.aFZ();
        localObject1 = f.al(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 128);
        continue;
        com.tencent.mm.api.c localc = com.tencent.mm.am.g.eS(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localObject2;
          if (localc.field_enterpriseFather != null) {
            localObject1 = ag.aFZ().DE(localc.field_enterpriseFather);
          }
        }
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(221696);
      Zu();
      AppMethodBeat.o(221696);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(5730);
      ad.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(5725);
          EnterpriseBizContactPlainListUI.a.this.Zv();
          TextView localTextView = (TextView)EnterpriseBizContactPlainListUI.this.findViewById(2131299506);
          if ((EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this) != null) && (localTextView != null))
          {
            am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
            if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type))) {
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
      if (this.jdC == null) {
        this.jdC = new b.b()
        {
          public final int aSL()
          {
            AppMethodBeat.i(5727);
            int i = EnterpriseBizContactPlainListUI.a.this.getCount();
            AppMethodBeat.o(5727);
            return i;
          }
          
          public final String rn(int paramAnonymousInt)
          {
            AppMethodBeat.i(5726);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= EnterpriseBizContactPlainListUI.a.this.getCount()))
            {
              ad.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
              AppMethodBeat.o(5726);
              return null;
            }
            Object localObject = (pt)EnterpriseBizContactPlainListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(5726);
              return null;
            }
            localObject = ((pt)localObject).userName;
            AppMethodBeat.o(5726);
            return localObject;
          }
        };
      }
      if (this.jdB != null) {
        this.jdB.a(paramInt, this.jdC);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131493839, null);
        paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jbW = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      pt localpt;
      for (;;)
      {
        localpt = (pt)getItem(paramInt);
        if (localpt != null) {
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
      String str = bt.nullAsNil(localpt.contact.adu());
      paramViewGroup.jbW.setText(k.b(this.context, str, paramViewGroup.jbW.getTextSize()));
      paramViewGroup.jbW.setVisibility(0);
      paramViewGroup.jdF.setVisibility(0);
      if (!bt.isNullOrNil(localpt.contact.field_username)) {
        a.b.c(paramViewGroup.jdF, localpt.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup.jdF.setImageDrawable(null);
      }
    }
    
    final class a
    {
      TextView jbW;
      ImageView jdF;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(5728);
        if (this.jdF != null)
        {
          this.jdF.setImageDrawable(null);
          this.jdF.setVisibility(8);
        }
        if (this.jbW != null)
        {
          this.jbW.setText("");
          this.jbW.setVisibility(8);
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