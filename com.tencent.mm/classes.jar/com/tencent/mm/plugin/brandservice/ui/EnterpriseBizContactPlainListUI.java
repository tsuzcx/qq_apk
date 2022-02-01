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
import com.tencent.mm.am.e;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.q;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String gWU;
  private ListView iwH;
  private a mUP;
  private long mUQ;
  private AdapterView.OnItemClickListener mUR;
  private int scene;
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5736);
    this.iwH = ((ListView)findViewById(2131299505));
    if (this.mUP == null)
    {
      this.mUP = new a(this);
      this.mUR = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5719);
          ad.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this, paramAnonymousInt);
          AppMethodBeat.o(5719);
        }
      };
    }
    ad.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.mUP.getCount()) });
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.gWU);
    if (this.scene == 2)
    {
      setMMTitle(2131758438);
      if ((localObject != null) && (com.tencent.mm.n.b.ls(((au)localObject).field_type)) && (this.mUP.getCount() > 0)) {
        break label218;
      }
      this.iwH.setVisibility(8);
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
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactPlainListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(5721);
        }
      });
      AppMethodBeat.o(5736);
      return;
      if (localObject == null) {
        break;
      }
      setMMTitle(((com.tencent.mm.storage.af)localObject).ZW());
      break;
      label218:
      this.iwH.setVisibility(0);
      this.iwH.setAdapter(this.mUP);
      this.iwH.setOnItemClickListener(this.mUR);
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
    this.gWU = getIntent().getStringExtra("enterprise_biz_name");
    this.mUQ = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    ad.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.gWU });
    initView();
    com.tencent.mm.am.af.awe().add(this.mUP);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().a(this.mUP);
    AppMethodBeat.o(5735);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5739);
    com.tencent.mm.am.af.awe().remove(this.mUP);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this.mUP);
    this.mUP.cHX();
    a locala = this.mUP;
    if (locala.ikl != null)
    {
      locala.ikl.detach();
      locala.ikl = null;
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
    if (!w.sD(this.gWU))
    {
      ad.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.gWU });
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
    extends q<oh>
    implements n.b
  {
    com.tencent.mm.ui.applet.b ikl;
    private b.b ikm;
    
    public a(Context paramContext)
    {
      super(new oh());
      AppMethodBeat.i(5729);
      this.ikm = null;
      this.ikl = new com.tencent.mm.ui.applet.b(new b.a()
      {
        public final Bitmap Cl(String paramAnonymousString)
        {
          AppMethodBeat.i(5724);
          paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
          AppMethodBeat.o(5724);
          return paramAnonymousString;
        }
      });
      Wd();
      AppMethodBeat.o(5729);
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(5733);
      if (!g.afw())
      {
        ad.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        AppMethodBeat.o(5733);
        return;
      }
      cHX();
      Object localObject2 = null;
      Object localObject1;
      switch (EnterpriseBizContactPlainListUI.b(EnterpriseBizContactPlainListUI.this))
      {
      default: 
        com.tencent.mm.am.af.awe();
        localObject1 = e.L(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), true);
      }
      for (;;)
      {
        setCursor((Cursor)localObject1);
        AppMethodBeat.o(5733);
        return;
        com.tencent.mm.am.af.awe();
        localObject1 = e.ad(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 25);
        continue;
        com.tencent.mm.am.af.awe();
        localObject1 = e.wA(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        continue;
        com.tencent.mm.am.af.awe();
        localObject1 = e.ad(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this), 128);
        continue;
        com.tencent.mm.api.c localc = f.ei(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localObject2;
          if (localc.field_enterpriseFather != null) {
            localObject1 = com.tencent.mm.am.af.awe().wz(localc.field_enterpriseFather);
          }
        }
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(205022);
      Wd();
      AppMethodBeat.o(205022);
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
          EnterpriseBizContactPlainListUI.a.this.We();
          TextView localTextView = (TextView)EnterpriseBizContactPlainListUI.this.findViewById(2131299506);
          if ((EnterpriseBizContactPlainListUI.a(EnterpriseBizContactPlainListUI.this) != null) && (localTextView != null))
          {
            com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(EnterpriseBizContactPlainListUI.c(EnterpriseBizContactPlainListUI.this));
            if ((localaf != null) && (com.tencent.mm.n.b.ls(localaf.field_type))) {
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
      if (this.ikm == null) {
        this.ikm = new b.b()
        {
          public final int aII()
          {
            AppMethodBeat.i(5727);
            int i = EnterpriseBizContactPlainListUI.a.this.getCount();
            AppMethodBeat.o(5727);
            return i;
          }
          
          public final String qa(int paramAnonymousInt)
          {
            AppMethodBeat.i(5726);
            if ((paramAnonymousInt < 0) || (paramAnonymousInt >= EnterpriseBizContactPlainListUI.a.this.getCount()))
            {
              ad.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
              AppMethodBeat.o(5726);
              return null;
            }
            Object localObject = (oh)EnterpriseBizContactPlainListUI.a.this.getItem(paramAnonymousInt);
            if (localObject == null)
            {
              AppMethodBeat.o(5726);
              return null;
            }
            localObject = ((oh)localObject).userName;
            AppMethodBeat.o(5726);
            return localObject;
          }
        };
      }
      if (this.ikl != null) {
        this.ikl.a(paramInt, this.ikm);
      }
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131493839, null);
        paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iiF = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      oh localoh;
      for (;;)
      {
        localoh = (oh)getItem(paramInt);
        if (localoh != null) {
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
      paramView.setBackgroundDrawable(com.tencent.mm.cd.a.l(this.context, 2131231818));
      paramView.setPadding(k, i, j, paramInt);
      String str = bt.nullAsNil(localoh.contact.ZW());
      paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, str, paramViewGroup.iiF.getTextSize()));
      paramViewGroup.iiF.setVisibility(0);
      paramViewGroup.ikp.setVisibility(0);
      if (!bt.isNullOrNil(localoh.contact.field_username)) {
        a.b.c(paramViewGroup.ikp, localoh.contact.field_username);
      }
      for (;;)
      {
        AppMethodBeat.o(5731);
        return paramView;
        paramViewGroup.ikp.setImageDrawable(null);
      }
    }
    
    final class a
    {
      TextView iiF;
      ImageView ikp;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(5728);
        if (this.ikp != null)
        {
          this.ikp.setImageDrawable(null);
          this.ikp.setVisibility(8);
        }
        if (this.iiF != null)
        {
          this.iiF.setText("");
          this.iiF.setVisibility(8);
        }
        AppMethodBeat.o(5728);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI
 * JD-Core Version:    0.7.0.1
 */