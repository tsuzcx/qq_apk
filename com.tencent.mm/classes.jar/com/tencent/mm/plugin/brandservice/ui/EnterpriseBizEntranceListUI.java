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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI
  extends MMActivity
{
  private String hxt;
  private ListView iWK;
  private e nwK;
  private a nxa;
  private AdapterView.OnItemClickListener nxr;
  private b nxz;
  private int scene;
  
  public EnterpriseBizEntranceListUI()
  {
    AppMethodBeat.i(198678);
    this.nxa = new a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String bJE()
      {
        AppMethodBeat.i(198657);
        String str = EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this);
        AppMethodBeat.o(198657);
        return str;
      }
      
      public final Context getContext()
      {
        return EnterpriseBizEntranceListUI.this;
      }
    });
    AppMethodBeat.o(198678);
  }
  
  private void cd(List<dvc> paramList)
  {
    AppMethodBeat.i(198680);
    if (this.nxz == null)
    {
      AppMethodBeat.o(198680);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.nxz;
      LinkedList localLinkedList = new LinkedList();
      d locald = new d();
      locald.nxH = 2131690123;
      locald.nxG.type = 1;
      locald.nxG.vxw = paramList.context.getString(2131758431);
      locald.nxG.oGN = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      localLinkedList.add(locald);
      locald = new d();
      locald.nxG.vxw = paramList.context.getString(2131758449);
      locald.nxG.oGN = "https://wwcdn.weixin.qq.com/node/wework/images/icon_workspace.cb133ed72e.png";
      locald.nxG.type = 2;
      localLinkedList.add(locald);
      paramList.nxC = localLinkedList;
      AppMethodBeat.o(198680);
      return;
    }
    this.nxz.cf(paramList);
    AppMethodBeat.o(198680);
  }
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(198681);
    this.iWK = ((ListView)findViewById(2131299505));
    if (this.nxz == null)
    {
      this.nxz = new b(this);
      cd(f.AV(this.hxt));
      af.aDf();
      com.tencent.mm.al.d.a(this.hxt, new c(this));
      this.nxr = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(198654);
          ac.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, paramAnonymousInt);
          AppMethodBeat.o(198654);
        }
      };
    }
    ac.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.nxz.getCount()) });
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.hxt);
    setMMTitle(((ai)localObject).aaR());
    if ((localObject == null) || (!com.tencent.mm.n.b.ln(((av)localObject).field_type)) || (this.nxz.getCount() <= 0))
    {
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
          AppMethodBeat.i(198655);
          EnterpriseBizEntranceListUI.this.hideVKB();
          EnterpriseBizEntranceListUI.this.finish();
          AppMethodBeat.o(198655);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198656);
          paramAnonymousView = EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(198656);
        }
      });
      addIconOptionMenu(1, 2131755134, 2131689489, this.nwK.bJG());
      AppMethodBeat.o(198681);
      return;
      this.iWK.setVisibility(0);
      this.iWK.setAdapter(this.nxz);
      this.iWK.setOnItemClickListener(this.nxr);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(198682);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.nwK.d(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(198682);
      return;
    }
    AppMethodBeat.o(198682);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198679);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.hxt = getIntent().getStringExtra("enterprise_biz_name");
    this.nwK = new e(this, this.hxt);
    ac.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.hxt });
    initView();
    af.aCW().add(this.nxz);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().a(this.nxz);
    AppMethodBeat.o(198679);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(198685);
    af.aCW().remove(this.nxz);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().b(this.nxz);
    super.onDestroy();
    AppMethodBeat.o(198685);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(198684);
    super.onPause();
    AppMethodBeat.o(198684);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(198683);
    super.onResume();
    if (!w.wG(this.hxt))
    {
      ac.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.hxt });
      finish();
      AppMethodBeat.o(198683);
      return;
    }
    AppMethodBeat.o(198683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    private a nxB;
    
    public a(a parama)
    {
      this.nxB = parama;
    }
    
    private void Tw(String paramString)
    {
      AppMethodBeat.i(198661);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      localIntent.addFlags(67108864);
      com.tencent.mm.br.d.b(this.nxB.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(198661);
    }
    
    private void bJH()
    {
      AppMethodBeat.i(198659);
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setClassName(this.nxB.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject).putExtra("enterprise_biz_name", this.nxB.bJE());
        ((Intent)localObject).putExtra("enterprise_biz_display_name", v.wk(this.nxB.bJE()));
        Context localContext = this.nxB.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(198659);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", new Object[] { this.nxB.bJE(), localThrowable.getMessage() });
        AppMethodBeat.o(198659);
      }
    }
    
    private void bJI()
    {
      AppMethodBeat.i(198660);
      Intent localIntent = new Intent();
      localIntent.putExtra("enterprise_from_scene", 1);
      localIntent.putExtra("enterprise_biz_name", this.nxB.bJE());
      com.tencent.mm.br.d.b(this.nxB.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      AppMethodBeat.o(198660);
    }
    
    public final void a(dvc paramdvc)
    {
      AppMethodBeat.i(198658);
      switch (paramdvc.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(198658);
        return;
        bJH();
        AppMethodBeat.o(198658);
        return;
        bJI();
        AppMethodBeat.o(198658);
        return;
        Tw(paramdvc.nWj);
      }
    }
    
    public static abstract interface a
    {
      public abstract String bJE();
      
      public abstract Context getContext();
    }
  }
  
  final class b
    extends BaseAdapter
    implements k.a, n.b
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.d> nxC;
    
    public b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void bJJ()
    {
      AppMethodBeat.i(198666);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198662);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(2131299506);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localai != null) && (com.tencent.mm.n.b.ln(localai.field_type))) {
              break label114;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.b.this.notifyDataSetChanged();
            AppMethodBeat.o(198662);
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
      AppMethodBeat.o(198666);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
    {
      AppMethodBeat.i(198664);
      ac.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      bJJ();
      AppMethodBeat.o(198664);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(198665);
      ac.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      bJJ();
      AppMethodBeat.o(198665);
    }
    
    public final void cf(List<dvc> paramList)
    {
      AppMethodBeat.i(198667);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.d((dvc)paramList.next()));
      }
      this.nxC = localLinkedList;
      AppMethodBeat.o(198667);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(198668);
      int i = this.nxC.size();
      AppMethodBeat.o(198668);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(198670);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, 2131493839, null);
        paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iIN = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.d locald;
      for (;;)
      {
        locald = yD(paramInt);
        if (locald != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(198670);
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
      String str = bs.nullAsNil(locald.nxG.vxw);
      paramViewGroup.iIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localContext, str, paramViewGroup.iIN.getTextSize()));
      paramViewGroup.iIN.setVisibility(0);
      paramViewGroup.iKw.setVisibility(0);
      o.aFB().a(locald.nxG.oGN, paramViewGroup.iKw, EnterpriseBizEntranceListUI.d.a(locald, localContext));
      AppMethodBeat.o(198670);
      return paramView;
    }
    
    public final EnterpriseBizEntranceListUI.d yD(int paramInt)
    {
      AppMethodBeat.i(198669);
      EnterpriseBizEntranceListUI.d locald = (EnterpriseBizEntranceListUI.d)this.nxC.get(paramInt);
      AppMethodBeat.o(198669);
      return locald;
    }
    
    final class a
    {
      TextView iIN;
      ImageView iKw;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(198663);
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
        AppMethodBeat.o(198663);
      }
    }
  }
  
  static final class c
    implements com.tencent.mm.ak.g
  {
    private final WeakReference<EnterpriseBizEntranceListUI> lEz;
    
    public c(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(198673);
      this.lEz = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(198673);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(198674);
      try
      {
        if (this.lEz.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.lEz.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(198674);
            return;
          }
          EnterpriseBizEntranceListUI.af(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198672);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.nwR.EMC.EbY);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                AppMethodBeat.o(198672);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(198672);
              }
            }
          });
        }
        AppMethodBeat.o(198674);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(198674);
      }
    }
  }
  
  public static final class d
  {
    private static float nxI = 0.1F;
    final dvc nxG;
    int nxH;
    
    d()
    {
      AppMethodBeat.i(198675);
      this.nxH = 0;
      this.nxG = new dvc();
      AppMethodBeat.o(198675);
    }
    
    d(dvc paramdvc)
    {
      this.nxH = 0;
      this.nxG = paramdvc;
    }
    
    public static c M(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(198676);
      c.a locala = new c.a();
      locala.hKx = true;
      locala.gKm = true;
      locala.hKI = paramInt;
      locala.gLt = true;
      if (com.tencent.mm.cc.a.id(paramContext)) {}
      for (locala.hKP = (nxI * com.tencent.mm.cc.a.av(paramContext, 2131165190));; locala.hKP = (nxI * com.tencent.mm.cc.a.av(paramContext, 2131165508)))
      {
        paramContext = locala.aFT();
        AppMethodBeat.o(198676);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */