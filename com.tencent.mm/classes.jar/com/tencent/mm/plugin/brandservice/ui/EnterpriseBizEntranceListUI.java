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
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI
  extends MMActivity
{
  private String hSG;
  private ListView jsM;
  private e odR;
  private b oeG;
  private a oeh;
  private AdapterView.OnItemClickListener oey;
  private int scene;
  
  public EnterpriseBizEntranceListUI()
  {
    AppMethodBeat.i(208438);
    this.oeh = new a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String bOU()
      {
        AppMethodBeat.i(208417);
        String str = EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this);
        AppMethodBeat.o(208417);
        return str;
      }
      
      public final Context getContext()
      {
        return EnterpriseBizEntranceListUI.this;
      }
    });
    AppMethodBeat.o(208438);
  }
  
  private void cg(List<ecn> paramList)
  {
    AppMethodBeat.i(208440);
    if (this.oeG == null)
    {
      AppMethodBeat.o(208440);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.oeG;
      LinkedList localLinkedList = new LinkedList();
      d locald = new d();
      locald.oeO = 2131690123;
      locald.oeN.type = 1;
      locald.oeN.wSB = paramList.context.getString(2131758431);
      locald.oeN.pqW = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      localLinkedList.add(locald);
      locald = new d();
      locald.oeN.wSB = paramList.context.getString(2131758449);
      locald.oeN.pqW = "https://wwcdn.weixin.qq.com/node/wework/images/icon_workspace.cb133ed72e.png";
      locald.oeN.type = 2;
      localLinkedList.add(locald);
      paramList.oeJ = localLinkedList;
      AppMethodBeat.o(208440);
      return;
    }
    this.oeG.ci(paramList);
    AppMethodBeat.o(208440);
  }
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(208441);
    this.jsM = ((ListView)findViewById(2131299505));
    if (this.oeG == null)
    {
      this.oeG = new b(this);
      cg(com.tencent.mm.al.g.Ew(this.hSG));
      ag.aGy();
      com.tencent.mm.al.e.a(this.hSG, new c(this));
      this.oey = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(208414);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          ae.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(208414);
        }
      };
    }
    ae.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.oeG.getCount()) });
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.hSG);
    setMMTitle(((an)localObject).adF());
    if ((localObject == null) || (!com.tencent.mm.contact.c.lO(((aw)localObject).field_type)) || (this.oeG.getCount() <= 0))
    {
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
          AppMethodBeat.i(208415);
          EnterpriseBizEntranceListUI.this.hideVKB();
          EnterpriseBizEntranceListUI.this.finish();
          AppMethodBeat.o(208415);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(208416);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208416);
        }
      });
      addIconOptionMenu(1, 2131755134, 2131689489, this.odR.bOW());
      AppMethodBeat.o(208441);
      return;
      this.jsM.setVisibility(0);
      this.jsM.setAdapter(this.oeG);
      this.jsM.setOnItemClickListener(this.oey);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(208442);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.odR.d(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(208442);
      return;
    }
    AppMethodBeat.o(208442);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208439);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.hSG = getIntent().getStringExtra("enterprise_biz_name");
    this.odR = new e(this, this.hSG);
    ae.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.hSG });
    initView();
    ag.aGp().add(this.oeG);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().a(this.oeG);
    AppMethodBeat.o(208439);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(208445);
    ag.aGp().remove(this.oeG);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().b(this.oeG);
    super.onDestroy();
    AppMethodBeat.o(208445);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(208444);
    super.onPause();
    AppMethodBeat.o(208444);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(208443);
    super.onResume();
    if (!x.An(this.hSG))
    {
      ae.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.hSG });
      finish();
      AppMethodBeat.o(208443);
      return;
    }
    AppMethodBeat.o(208443);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    private a oeI;
    
    public a(a parama)
    {
      this.oeI = parama;
    }
    
    private void XP(String paramString)
    {
      AppMethodBeat.i(208421);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      localIntent.addFlags(67108864);
      d.b(this.oeI.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(208421);
    }
    
    private void bOX()
    {
      AppMethodBeat.i(208419);
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setClassName(this.oeI.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject).putExtra("enterprise_biz_name", this.oeI.bOU());
        ((Intent)localObject).putExtra("enterprise_biz_display_name", w.zP(this.oeI.bOU()));
        Context localContext = this.oeI.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(208419);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", new Object[] { this.oeI.bOU(), localThrowable.getMessage() });
        AppMethodBeat.o(208419);
      }
    }
    
    private void bOY()
    {
      AppMethodBeat.i(208420);
      Intent localIntent = new Intent();
      localIntent.putExtra("enterprise_from_scene", 1);
      localIntent.putExtra("enterprise_biz_name", this.oeI.bOU());
      d.b(this.oeI.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      AppMethodBeat.o(208420);
    }
    
    public final void a(ecn paramecn)
    {
      AppMethodBeat.i(208418);
      switch (paramecn.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208418);
        return;
        bOX();
        AppMethodBeat.o(208418);
        return;
        bOY();
        AppMethodBeat.o(208418);
        return;
        XP(paramecn.oGf);
      }
    }
    
    public static abstract interface a
    {
      public abstract String bOU();
      
      public abstract Context getContext();
    }
  }
  
  final class b
    extends BaseAdapter
    implements k.a, n.b
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.d> oeJ;
    
    public b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void bOZ()
    {
      AppMethodBeat.i(208426);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208422);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(2131299506);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
              break label114;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.b.this.notifyDataSetChanged();
            AppMethodBeat.o(208422);
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
      AppMethodBeat.o(208426);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
    {
      AppMethodBeat.i(208424);
      ae.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      bOZ();
      AppMethodBeat.o(208424);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(208425);
      ae.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      bOZ();
      AppMethodBeat.o(208425);
    }
    
    public final void ci(List<ecn> paramList)
    {
      AppMethodBeat.i(208427);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.d((ecn)paramList.next()));
      }
      this.oeJ = localLinkedList;
      AppMethodBeat.o(208427);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(208428);
      int i = this.oeJ.size();
      AppMethodBeat.o(208428);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(208430);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, 2131493839, null);
        paramViewGroup.jgy = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.jeP = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.d locald;
      for (;;)
      {
        locald = zw(paramInt);
        if (locald != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(208430);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(localContext, 2131231818));
      paramView.setPadding(k, i, j, paramInt);
      String str = bu.nullAsNil(locald.oeN.wSB);
      paramViewGroup.jeP.setText(k.b(localContext, str, paramViewGroup.jeP.getTextSize()));
      paramViewGroup.jeP.setVisibility(0);
      paramViewGroup.jgy.setVisibility(0);
      q.aJb().a(locald.oeN.pqW, paramViewGroup.jgy, EnterpriseBizEntranceListUI.d.a(locald, localContext));
      AppMethodBeat.o(208430);
      return paramView;
    }
    
    public final EnterpriseBizEntranceListUI.d zw(int paramInt)
    {
      AppMethodBeat.i(208429);
      EnterpriseBizEntranceListUI.d locald = (EnterpriseBizEntranceListUI.d)this.oeJ.get(paramInt);
      AppMethodBeat.o(208429);
      return locald;
    }
    
    final class a
    {
      TextView jeP;
      ImageView jgy;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(208423);
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
        AppMethodBeat.o(208423);
      }
    }
  }
  
  static final class c
    implements com.tencent.mm.ak.f
  {
    private final WeakReference<EnterpriseBizEntranceListUI> mix;
    
    public c(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(208433);
      this.mix = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(208433);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(208434);
      try
      {
        if (this.mix.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.mix.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(208434);
            return;
          }
          EnterpriseBizEntranceListUI.ac(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208432);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.odY.GPf.Gag);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                AppMethodBeat.o(208432);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(208432);
              }
            }
          });
        }
        AppMethodBeat.o(208434);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(208434);
      }
    }
  }
  
  public static final class d
  {
    private static float oeP = 0.1F;
    final ecn oeN;
    int oeO;
    
    d()
    {
      AppMethodBeat.i(208435);
      this.oeO = 0;
      this.oeN = new ecn();
      AppMethodBeat.o(208435);
    }
    
    d(ecn paramecn)
    {
      this.oeO = 0;
      this.oeN = paramecn;
    }
    
    public static com.tencent.mm.av.a.a.c N(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(208436);
      c.a locala = new c.a();
      locala.igk = true;
      locala.hgL = true;
      locala.igv = paramInt;
      locala.hhW = true;
      if (com.tencent.mm.cb.a.ir(paramContext)) {}
      for (locala.igC = (oeP * com.tencent.mm.cb.a.ay(paramContext, 2131165190));; locala.igC = (oeP * com.tencent.mm.cb.a.ay(paramContext, 2131165508)))
      {
        paramContext = locala.aJu();
        AppMethodBeat.o(208436);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */