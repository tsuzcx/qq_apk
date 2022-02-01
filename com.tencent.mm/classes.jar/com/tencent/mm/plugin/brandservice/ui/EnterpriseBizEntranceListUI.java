package com.tencent.mm.plugin.brandservice.ui;

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
import com.tencent.mm.am.c.c;
import com.tencent.mm.an.af;
import com.tencent.mm.an.e;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.gdt;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI
  extends MMActivity
{
  private String ovT;
  private ListView qgc;
  private int scene;
  private a vDL;
  private f vDx;
  private AdapterView.OnItemClickListener vEc;
  private b vEk;
  
  public EnterpriseBizEntranceListUI()
  {
    AppMethodBeat.i(301570);
    this.vDL = new a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String dcw()
      {
        AppMethodBeat.i(301719);
        String str = EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this);
        AppMethodBeat.o(301719);
        return str;
      }
      
      public final Context getContext()
      {
        return EnterpriseBizEntranceListUI.this;
      }
    });
    AppMethodBeat.o(301570);
  }
  
  private void ek(List<gdt> paramList)
  {
    AppMethodBeat.i(301575);
    if (this.vEk == null)
    {
      AppMethodBeat.o(301575);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.vEk;
      LinkedList localLinkedList = new LinkedList();
      d locald = new d();
      locald.vEs = d.h.enterprise_chat_entry_avatar;
      locald.vEr.type = 1;
      locald.vEr.MEz = paramList.context.getString(d.i.enterprise_chat_entry_title);
      locald.vEr.icon_url = ("https://" + WeChatHosts.domainString(d.i.host_wwcdn_weixin_qq_com) + "/node/wework/images/icon_im.48490d44c5.png");
      localLinkedList.add(locald);
      locald = new d();
      locald.vEr.MEz = paramList.context.getString(d.i.enterprise_sub_entry_title);
      locald.vEr.icon_url = ("https://" + WeChatHosts.domainString(d.i.host_wwcdn_weixin_qq_com) + "/node/wework/images/icon_workspace.cb133ed72e.png");
      locald.vEr.type = 2;
      localLinkedList.add(locald);
      paramList.vEn = localLinkedList;
      AppMethodBeat.o(301575);
      return;
    }
    this.vEk.em(paramList);
    AppMethodBeat.o(301575);
  }
  
  public int getLayoutId()
  {
    return d.f.enterprise_biz_list_normal;
  }
  
  public void initView()
  {
    AppMethodBeat.i(301606);
    this.qgc = ((ListView)findViewById(d.e.enterprist_biz_child_lv));
    if (this.vEk == null)
    {
      this.vEk = new b(this);
      ek(g.MF(this.ovT));
      af.bHq();
      e.a(this.ovT, new c(this));
      this.vEc = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(301715);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(301715);
        }
      };
    }
    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.vEk.getCount()) });
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.ovT);
    setMMTitle(((au)localObject).aSU());
    if ((localObject == null) || (!d.rs(((az)localObject).field_type)) || (this.vEk.getCount() <= 0))
    {
      this.qgc.setVisibility(8);
      localObject = (TextView)findViewById(d.e.enterprist_biz_child_not_found);
      ((TextView)localObject).setText(d.i.enterprise_no_sub_biz);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(301714);
          EnterpriseBizEntranceListUI.this.hideVKB();
          EnterpriseBizEntranceListUI.this.finish();
          AppMethodBeat.o(301714);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(301711);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          paramAnonymousView = EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(301711);
        }
      });
      addIconOptionMenu(1, d.i.actionbar_title_new_group_chat, d.h.actionbar_icon_dark_add, this.vDx.dcy());
      AppMethodBeat.o(301606);
      return;
      this.qgc.setVisibility(0);
      this.qgc.setAdapter(this.vEk);
      this.qgc.setOnItemClickListener(this.vEc);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(301612);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.vDx.h(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(301612);
      return;
    }
    AppMethodBeat.o(301612);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(301600);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.ovT = getIntent().getStringExtra("enterprise_biz_name");
    this.vDx = new f(this, this.ovT);
    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.ovT });
    initView();
    af.bHf().add(this.vEk);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().add(this.vEk);
    AppMethodBeat.o(301600);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(301626);
    af.bHf().remove(this.vEk);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().remove(this.vEk);
    super.onDestroy();
    AppMethodBeat.o(301626);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(301620);
    super.onPause();
    AppMethodBeat.o(301620);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(301616);
    super.onResume();
    if (!ab.IR(this.ovT))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.ovT });
      finish();
      AppMethodBeat.o(301616);
      return;
    }
    AppMethodBeat.o(301616);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    private a vEm;
    
    public a(a parama)
    {
      this.vEm = parama;
    }
    
    private void aiT(String paramString)
    {
      AppMethodBeat.i(301628);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      localIntent.addFlags(67108864);
      com.tencent.mm.br.c.b(this.vEm.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(301628);
    }
    
    private void dcA()
    {
      AppMethodBeat.i(301623);
      Intent localIntent = new Intent();
      localIntent.putExtra("enterprise_from_scene", 1);
      localIntent.putExtra("enterprise_biz_name", this.vEm.dcw());
      com.tencent.mm.br.c.b(this.vEm.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      AppMethodBeat.o(301623);
    }
    
    private void dcz()
    {
      AppMethodBeat.i(301621);
      try
      {
        Object localObject2 = new Intent();
        ((Intent)localObject2).setClassName(this.vEm.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject2).putExtra("enterprise_biz_name", this.vEm.dcw());
        ((Intent)localObject2).putExtra("enterprise_biz_display_name", aa.getDisplayName(this.vEm.dcw()));
        Context localContext = this.vEm.getContext();
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(301621);
        return;
      }
      finally
      {
        Log.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", new Object[] { this.vEm.dcw(), localObject1.getMessage() });
        AppMethodBeat.o(301621);
      }
    }
    
    public final void a(gdt paramgdt)
    {
      AppMethodBeat.i(301631);
      switch (paramgdt.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(301631);
        return;
        dcz();
        AppMethodBeat.o(301631);
        return;
        dcA();
        AppMethodBeat.o(301631);
        return;
        aiT(paramgdt.jump_url);
      }
    }
    
    public static abstract interface a
    {
      public abstract String dcw();
      
      public abstract Context getContext();
    }
  }
  
  final class b
    extends BaseAdapter
    implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.d> vEn;
    
    public b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void dcB()
    {
      AppMethodBeat.i(301622);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(301569);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(d.e.enterprist_biz_child_not_found);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localau != null) && (d.rs(localau.field_type))) {
              break label115;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.b.this.notifyDataSetChanged();
            AppMethodBeat.o(301569);
            return;
            label115:
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
      AppMethodBeat.o(301622);
    }
    
    public final EnterpriseBizEntranceListUI.d Hg(int paramInt)
    {
      AppMethodBeat.i(301650);
      EnterpriseBizEntranceListUI.d locald = (EnterpriseBizEntranceListUI.d)this.vEn.get(paramInt);
      AppMethodBeat.o(301650);
      return locald;
    }
    
    public final void em(List<gdt> paramList)
    {
      AppMethodBeat.i(301639);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.d((gdt)paramList.next()));
      }
      this.vEn = localLinkedList;
      AppMethodBeat.o(301639);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(301643);
      int i = this.vEn.size();
      AppMethodBeat.o(301643);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(301662);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, d.f.enterprise_biz_list_item_normal, null);
        paramViewGroup.avatar = ((ImageView)paramView.findViewById(d.e.nearby_friend_avatar_iv));
        paramViewGroup.pQZ = ((TextView)paramView.findViewById(d.e.nearby_friend_name));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.d locald;
      for (;;)
      {
        locald = Hg(paramInt);
        if (locald != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(301662);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.cd.a.m(localContext, d.d.comm_list_item_selector));
      paramView.setPadding(k, i, j, paramInt);
      String str = Util.nullAsNil(locald.vEr.MEz);
      paramViewGroup.pQZ.setText(com.tencent.mm.pluginsdk.ui.span.p.b(localContext, str, paramViewGroup.pQZ.getTextSize()));
      paramViewGroup.pQZ.setVisibility(0);
      paramViewGroup.avatar.setVisibility(0);
      r.bKe().a(locald.vEr.icon_url, paramViewGroup.avatar, EnterpriseBizEntranceListUI.d.a(locald, localContext));
      AppMethodBeat.o(301662);
      return paramView;
    }
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(301627);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      dcB();
      AppMethodBeat.o(301627);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(301633);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      dcB();
      AppMethodBeat.o(301633);
    }
    
    final class a
    {
      ImageView avatar;
      TextView pQZ;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(301544);
        if (this.avatar != null)
        {
          this.avatar.setImageDrawable(null);
          this.avatar.setVisibility(8);
        }
        if (this.pQZ != null)
        {
          this.pQZ.setText("");
          this.pQZ.setVisibility(8);
        }
        AppMethodBeat.o(301544);
      }
    }
  }
  
  static final class c
    implements com.tencent.mm.am.h
  {
    private final WeakReference<EnterpriseBizEntranceListUI> tzB;
    
    public c(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(301617);
      this.tzB = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(301617);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(301619);
      try
      {
        if (this.tzB.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.tzB.get();
          boolean bool = paramString.isFinishing();
          if (bool) {
            return;
          }
          EnterpriseBizEntranceListUI.access$200(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(301702);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.vDE.aapi.YSw);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                return;
              }
              finally
              {
                AppMethodBeat.o(301702);
              }
            }
          });
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(301619);
      }
    }
  }
  
  public static final class d
  {
    private static float vEt = 0.1F;
    final gdt vEr;
    int vEs;
    
    d()
    {
      AppMethodBeat.i(301618);
      this.vEs = 0;
      this.vEr = new gdt();
      AppMethodBeat.o(301618);
    }
    
    d(gdt paramgdt)
    {
      this.vEs = 0;
      this.vEr = paramgdt;
    }
    
    public static com.tencent.mm.modelimage.loader.a.c af(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(301625);
      c.a locala = new c.a();
      locala.oKp = true;
      locala.nqa = true;
      locala.oKB = paramInt;
      locala.nrc = true;
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (locala.oKI = (vEt * com.tencent.mm.cd.a.bs(paramContext, d.c.BigLargeAvatarSize));; locala.oKI = (vEt * com.tencent.mm.cd.a.bs(paramContext, d.c.NormalAvatarSize)))
      {
        paramContext = locala.bKx();
        AppMethodBeat.o(301625);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */