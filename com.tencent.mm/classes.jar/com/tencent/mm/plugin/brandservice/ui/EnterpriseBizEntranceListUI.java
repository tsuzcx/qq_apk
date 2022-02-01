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
import com.tencent.mm.am.d;
import com.tencent.mm.am.f;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI
  extends MMActivity
{
  private String gWU;
  private ListView iwH;
  private AdapterView.OnItemClickListener mUR;
  private a mUZ;
  private e mUs;
  private int scene;
  
  private void cc(List<dpl> paramList)
  {
    AppMethodBeat.i(192960);
    if (this.mUZ == null)
    {
      AppMethodBeat.o(192960);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.mUZ;
      LinkedList localLinkedList = new LinkedList();
      c localc = new c();
      localc.mVh = 2131690123;
      localc.mVg.type = 1;
      localc.mVg.uoA = paramList.context.getString(2131758431);
      localc.mVg.odo = "https://wwcdn.weixin.qq.com/node/wework/images/icon_im.48490d44c5.png";
      localLinkedList.add(localc);
      localc = new c();
      localc.mVg.uoA = paramList.context.getString(2131758449);
      localc.mVg.odo = "https://wwcdn.weixin.qq.com/node/wework/images/icon_workspace.cb133ed72e.png";
      localc.mVg.type = 2;
      localLinkedList.add(localc);
      paramList.mVb = localLinkedList;
      AppMethodBeat.o(192960);
      return;
    }
    this.mUZ.cd(paramList);
    AppMethodBeat.o(192960);
  }
  
  public int getLayoutId()
  {
    return 2131493841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(192961);
    this.iwH = ((ListView)findViewById(2131299505));
    if (this.mUZ == null)
    {
      this.mUZ = new a(this);
      cc(f.wP(this.gWU));
      com.tencent.mm.am.af.awn();
      d.a(this.gWU, new b(this));
      this.mUR = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(192941);
          ad.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, paramAnonymousInt);
          AppMethodBeat.o(192941);
        }
      };
    }
    ad.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.mUZ.getCount()) });
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.gWU);
    setMMTitle(((com.tencent.mm.storage.af)localObject).ZW());
    if ((localObject == null) || (!com.tencent.mm.n.b.ls(((au)localObject).field_type)) || (this.mUZ.getCount() <= 0))
    {
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
          AppMethodBeat.i(192942);
          EnterpriseBizEntranceListUI.this.hideVKB();
          EnterpriseBizEntranceListUI.this.finish();
          AppMethodBeat.o(192942);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192943);
          paramAnonymousView = EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          AppMethodBeat.o(192943);
        }
      });
      addIconOptionMenu(1, 2131755134, 2131689489, new e.1(this.mUs));
      AppMethodBeat.o(192961);
      return;
      this.iwH.setVisibility(0);
      this.iwH.setAdapter(this.mUZ);
      this.iwH.setOnItemClickListener(this.mUR);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192962);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mUs.d(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(192962);
      return;
    }
    AppMethodBeat.o(192962);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192959);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.gWU = getIntent().getStringExtra("enterprise_biz_name");
    this.mUs = new e(this, this.gWU);
    ad.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.gWU });
    initView();
    com.tencent.mm.am.af.awe().add(this.mUZ);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().a(this.mUZ);
    AppMethodBeat.o(192959);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(192965);
    com.tencent.mm.am.af.awe().remove(this.mUZ);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().b(this.mUZ);
    super.onDestroy();
    AppMethodBeat.o(192965);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(192964);
    super.onPause();
    AppMethodBeat.o(192964);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(192963);
    super.onResume();
    if (!w.sD(this.gWU))
    {
      ad.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.gWU });
      finish();
      AppMethodBeat.o(192963);
      return;
    }
    AppMethodBeat.o(192963);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
    implements k.a, n.b
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.c> mVb;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void bCB()
    {
      AppMethodBeat.i(192948);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192944);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(2131299506);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localaf != null) && (com.tencent.mm.n.b.ls(localaf.field_type))) {
              break label114;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.a.this.notifyDataSetChanged();
            AppMethodBeat.o(192944);
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
      AppMethodBeat.o(192948);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
    {
      AppMethodBeat.i(192946);
      ad.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      bCB();
      AppMethodBeat.o(192946);
    }
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(192947);
      ad.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      bCB();
      AppMethodBeat.o(192947);
    }
    
    public final void cd(List<dpl> paramList)
    {
      AppMethodBeat.i(192949);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.c((dpl)paramList.next()));
      }
      this.mVb = localLinkedList;
      AppMethodBeat.o(192949);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(192950);
      int i = this.mVb.size();
      AppMethodBeat.o(192950);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(192952);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, 2131493839, null);
        paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131302687));
        paramViewGroup.iiF = ((TextView)paramView.findViewById(2131302693));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.c localc;
      for (;;)
      {
        localc = xM(paramInt);
        if (localc != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(192952);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.cd.a.l(localContext, 2131231818));
      paramView.setPadding(k, i, j, paramInt);
      String str = bt.nullAsNil(localc.mVg.uoA);
      paramViewGroup.iiF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localContext, str, paramViewGroup.iiF.getTextSize()));
      paramViewGroup.iiF.setVisibility(0);
      paramViewGroup.ikp.setVisibility(0);
      o.ayJ().a(localc.mVg.odo, paramViewGroup.ikp, EnterpriseBizEntranceListUI.c.a(localc, localContext));
      AppMethodBeat.o(192952);
      return paramView;
    }
    
    public final EnterpriseBizEntranceListUI.c xM(int paramInt)
    {
      AppMethodBeat.i(192951);
      EnterpriseBizEntranceListUI.c localc = (EnterpriseBizEntranceListUI.c)this.mVb.get(paramInt);
      AppMethodBeat.o(192951);
      return localc;
    }
    
    final class a
    {
      TextView iiF;
      ImageView ikp;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(192945);
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
        AppMethodBeat.o(192945);
      }
    }
  }
  
  static final class b
    implements com.tencent.mm.al.g
  {
    private final WeakReference<EnterpriseBizEntranceListUI> leJ;
    
    public b(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(192955);
      this.leJ = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(192955);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(192956);
      try
      {
        if (this.leJ.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.leJ.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(192956);
            return;
          }
          EnterpriseBizEntranceListUI.ad(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192954);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.mVe.DrA.CJw);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                AppMethodBeat.o(192954);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(192954);
              }
            }
          });
        }
        AppMethodBeat.o(192956);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(192956);
      }
    }
  }
  
  static final class c
  {
    private static float mVi = 0.1F;
    final dpl mVg;
    int mVh;
    
    c()
    {
      AppMethodBeat.i(192957);
      this.mVh = 0;
      this.mVg = new dpl();
      AppMethodBeat.o(192957);
    }
    
    c(dpl paramdpl)
    {
      this.mVh = 0;
      this.mVg = paramdpl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */