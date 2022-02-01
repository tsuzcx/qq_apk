package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI
  extends MMActivity
{
  private String hPO;
  private ListView jpT;
  private AdapterView.OnItemClickListener nYP;
  private b nYX;
  private e nYi;
  private a nYy;
  private int scene;
  
  public EnterpriseBizEntranceListUI()
  {
    AppMethodBeat.i(209484);
    this.nYy = new a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String bNX()
      {
        AppMethodBeat.i(209463);
        String str = EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this);
        AppMethodBeat.o(209463);
        return str;
      }
      
      public final Context getContext()
      {
        return EnterpriseBizEntranceListUI.this;
      }
    });
    AppMethodBeat.o(209484);
  }
  
  private void ce(List<eaw> paramList)
  {
    AppMethodBeat.i(209486);
    if (this.nYX == null)
    {
      AppMethodBeat.o(209486);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.nYX;
      LinkedList localLinkedList = new LinkedList();
      d locald = new d();
      locald.nZf = 2131690123;
      locald.nZe.type = 1;
      locald.nZe.wCQ = paramList.context.getString(2131758431);
      locald.nZe.pkr = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      localLinkedList.add(locald);
      locald = new d();
      locald.nZe.wCQ = paramList.context.getString(2131758449);
      locald.nZe.pkr = "https://wwcdn.weixin.qq.com/node/wework/images/icon_workspace.cb133ed72e.png";
      locald.nZe.type = 2;
      localLinkedList.add(locald);
      paramList.nZa = localLinkedList;
      AppMethodBeat.o(209486);
      return;
    }
    this.nYX.cg(paramList);
    AppMethodBeat.o(209486);
  }
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(209487);
    this.jpT = ((ListView)findViewById(2131299505));
    if (this.nYX == null)
    {
      this.nYX = new b(this);
      ce(com.tencent.mm.am.g.DU(this.hPO));
      ag.aGi();
      com.tencent.mm.am.e.a(this.hPO, new c(this));
      this.nYP = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(209460);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          ad.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(209460);
        }
      };
    }
    ad.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.nYX.getCount()) });
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.hPO);
    setMMTitle(((am)localObject).adu());
    if ((localObject == null) || (!com.tencent.mm.o.b.lM(((aw)localObject).field_type)) || (this.nYX.getCount() <= 0))
    {
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
          AppMethodBeat.i(209461);
          EnterpriseBizEntranceListUI.this.hideVKB();
          EnterpriseBizEntranceListUI.this.finish();
          AppMethodBeat.o(209461);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(209462);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(209462);
        }
      });
      addIconOptionMenu(1, 2131755134, 2131689489, this.nYi.bNZ());
      AppMethodBeat.o(209487);
      return;
      this.jpT.setVisibility(0);
      this.jpT.setAdapter(this.nYX);
      this.jpT.setOnItemClickListener(this.nYP);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(209488);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.nYi.d(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(209488);
      return;
    }
    AppMethodBeat.o(209488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(209485);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.hPO = getIntent().getStringExtra("enterprise_biz_name");
    this.nYi = new e(this, this.hPO);
    ad.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.hPO });
    initView();
    ag.aFZ().add(this.nYX);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().a(this.nYX);
    AppMethodBeat.o(209485);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(209491);
    ag.aFZ().remove(this.nYX);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().b(this.nYX);
    super.onDestroy();
    AppMethodBeat.o(209491);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(209490);
    super.onPause();
    AppMethodBeat.o(209490);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(209489);
    super.onResume();
    if (!w.zD(this.hPO))
    {
      ad.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.hPO });
      finish();
      AppMethodBeat.o(209489);
      return;
    }
    AppMethodBeat.o(209489);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    private a nYZ;
    
    public a(a parama)
    {
      this.nYZ = parama;
    }
    
    private void Xd(String paramString)
    {
      AppMethodBeat.i(209467);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      localIntent.addFlags(67108864);
      d.b(this.nYZ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(209467);
    }
    
    private void bOa()
    {
      AppMethodBeat.i(209465);
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setClassName(this.nYZ.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject).putExtra("enterprise_biz_name", this.nYZ.bNX());
        ((Intent)localObject).putExtra("enterprise_biz_display_name", v.zf(this.nYZ.bNX()));
        Context localContext = this.nYZ.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(209465);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", new Object[] { this.nYZ.bNX(), localThrowable.getMessage() });
        AppMethodBeat.o(209465);
      }
    }
    
    private void bOb()
    {
      AppMethodBeat.i(209466);
      Intent localIntent = new Intent();
      localIntent.putExtra("enterprise_from_scene", 1);
      localIntent.putExtra("enterprise_biz_name", this.nYZ.bNX());
      d.b(this.nYZ.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      AppMethodBeat.o(209466);
    }
    
    public final void a(eaw parameaw)
    {
      AppMethodBeat.i(209464);
      switch (parameaw.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(209464);
        return;
        bOa();
        AppMethodBeat.o(209464);
        return;
        bOb();
        AppMethodBeat.o(209464);
        return;
        Xd(parameaw.ozD);
      }
    }
    
    public static abstract interface a
    {
      public abstract String bNX();
      
      public abstract Context getContext();
    }
  }
  
  final class b
    extends BaseAdapter
    implements k.a, n.b
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.d> nZa;
    
    public b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void bOc()
    {
      AppMethodBeat.i(209472);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209468);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(2131299506);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type))) {
              break label114;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.b.this.notifyDataSetChanged();
            AppMethodBeat.o(209468);
            return;
            label114:
            if (EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this).getCount() <= 0)
            {
              EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
              localTextView.setVisibility(0);
            }
            else
            {
              EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(0);
              localTextView.setVisibility(8);
              EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setAdapter(EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this));
              EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setOnItemClickListener(EnterpriseBizEntranceListUI.d(EnterpriseBizEntranceListUI.this));
            }
          }
        }
      });
      AppMethodBeat.o(209472);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
    {
      AppMethodBeat.i(209470);
      ad.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      bOc();
      AppMethodBeat.o(209470);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(209471);
      ad.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      bOc();
      AppMethodBeat.o(209471);
    }
    
    public final void cg(List<eaw> paramList)
    {
      AppMethodBeat.i(209473);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.d((eaw)paramList.next()));
      }
      this.nZa = localLinkedList;
      AppMethodBeat.o(209473);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(209474);
      int i = this.nZa.size();
      AppMethodBeat.o(209474);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(209476);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, 2131493839, null);
        paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jbW = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.d locald;
      for (;;)
      {
        locald = zn(paramInt);
        if (locald != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(209476);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.cc.a.l(localContext, 2131231818));
      paramView.setPadding(k, i, j, paramInt);
      String str = bt.nullAsNil(locald.nZe.wCQ);
      paramViewGroup.jbW.setText(k.b(localContext, str, paramViewGroup.jbW.getTextSize()));
      paramViewGroup.jbW.setVisibility(0);
      paramViewGroup.jdF.setVisibility(0);
      q.aIJ().a(locald.nZe.pkr, paramViewGroup.jdF, EnterpriseBizEntranceListUI.d.a(locald, localContext));
      AppMethodBeat.o(209476);
      return paramView;
    }
    
    public final EnterpriseBizEntranceListUI.d zn(int paramInt)
    {
      AppMethodBeat.i(209475);
      EnterpriseBizEntranceListUI.d locald = (EnterpriseBizEntranceListUI.d)this.nZa.get(paramInt);
      AppMethodBeat.o(209475);
      return locald;
    }
    
    final class a
    {
      TextView jbW;
      ImageView jdF;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(209469);
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
        AppMethodBeat.o(209469);
      }
    }
  }
  
  static final class c
    implements com.tencent.mm.al.f
  {
    private final WeakReference<EnterpriseBizEntranceListUI> med;
    
    public c(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(209479);
      this.med = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(209479);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(209480);
      try
      {
        if (this.med.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.med.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(209480);
            return;
          }
          EnterpriseBizEntranceListUI.ae(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209478);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.nYp.GvG.FHK);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                AppMethodBeat.o(209478);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(209478);
              }
            }
          });
        }
        AppMethodBeat.o(209480);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(209480);
      }
    }
  }
  
  public static final class d
  {
    private static float nZg = 0.1F;
    final eaw nZe;
    int nZf;
    
    d()
    {
      AppMethodBeat.i(209481);
      this.nZf = 0;
      this.nZe = new eaw();
      AppMethodBeat.o(209481);
    }
    
    d(eaw parameaw)
    {
      this.nZf = 0;
      this.nZe = parameaw;
    }
    
    public static c N(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(209482);
      c.a locala = new c.a();
      locala.idr = true;
      locala.hdX = true;
      locala.idD = paramInt;
      locala.hfi = true;
      if (com.tencent.mm.cc.a.im(paramContext)) {}
      for (locala.idK = (nZg * com.tencent.mm.cc.a.ay(paramContext, 2131165190));; locala.idK = (nZg * com.tencent.mm.cc.a.ay(paramContext, 2131165508)))
      {
        paramContext = locala.aJc();
        AppMethodBeat.o(209482);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */