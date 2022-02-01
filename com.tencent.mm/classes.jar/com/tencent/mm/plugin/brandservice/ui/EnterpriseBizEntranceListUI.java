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
import com.tencent.mm.an.i;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.fhh;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnterpriseBizEntranceListUI
  extends MMActivity
{
  private String lEm;
  private ListView niO;
  private int scene;
  private e sxO;
  private b syD;
  private a sye;
  private AdapterView.OnItemClickListener syv;
  
  public EnterpriseBizEntranceListUI()
  {
    AppMethodBeat.i(257944);
    this.sye = new a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String czE()
      {
        AppMethodBeat.i(264911);
        String str = EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this);
        AppMethodBeat.o(264911);
        return str;
      }
      
      public final Context getContext()
      {
        return EnterpriseBizEntranceListUI.this;
      }
    });
    AppMethodBeat.o(257944);
  }
  
  private void cs(List<fhh> paramList)
  {
    AppMethodBeat.i(257947);
    if (this.syD == null)
    {
      AppMethodBeat.o(257947);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.syD;
      LinkedList localLinkedList = new LinkedList();
      d locald = new d();
      locald.syL = d.h.enterprise_chat_entry_avatar;
      locald.syK.type = 1;
      locald.syK.GHJ = paramList.context.getString(d.i.svi);
      locald.syK.ufC = ("https://" + WeChatHosts.domainString(d.i.host_wwcdn_weixin_qq_com) + "/node/wework/images/icon_im.48490d44c5.png");
      localLinkedList.add(locald);
      locald = new d();
      locald.syK.GHJ = paramList.context.getString(d.i.svm);
      locald.syK.ufC = ("https://" + WeChatHosts.domainString(d.i.host_wwcdn_weixin_qq_com) + "/node/wework/images/icon_workspace.cb133ed72e.png");
      locald.syK.type = 2;
      localLinkedList.add(locald);
      paramList.syG = localLinkedList;
      AppMethodBeat.o(257947);
      return;
    }
    this.syD.cu(paramList);
    AppMethodBeat.o(257947);
  }
  
  public int getLayoutId()
  {
    return d.f.sul;
  }
  
  public void initView()
  {
    AppMethodBeat.i(257949);
    this.niO = ((ListView)findViewById(d.e.srP));
    if (this.syD == null)
    {
      this.syD = new b(this);
      cs(g.UG(this.lEm));
      af.bjF();
      com.tencent.mm.ao.e.a(this.lEm, new c(this));
      this.syv = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(263983);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "onItemClick position = %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          EnterpriseBizEntranceListUI.a(EnterpriseBizEntranceListUI.this, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(263983);
        }
      };
    }
    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.syD.getCount()) });
    Object localObject = ((n)h.ae(n.class)).bbL().RG(this.lEm);
    setMMTitle(((as)localObject).ayr());
    if ((localObject == null) || (!com.tencent.mm.contact.d.rk(((ax)localObject).field_type)) || (this.syD.getCount() <= 0))
    {
      this.niO.setVisibility(8);
      localObject = (TextView)findViewById(d.e.srQ);
      ((TextView)localObject).setText(d.i.svk);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(257673);
          EnterpriseBizEntranceListUI.this.hideVKB();
          EnterpriseBizEntranceListUI.this.finish();
          AppMethodBeat.o(257673);
          return true;
        }
      });
      setToTop(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(263903);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(263903);
        }
      });
      addIconOptionMenu(1, d.i.actionbar_title_new_group_chat, d.h.actionbar_icon_dark_add, this.sxO.czG());
      AppMethodBeat.o(257949);
      return;
      this.niO.setVisibility(0);
      this.niO.setAdapter(this.syD);
      this.niO.setOnItemClickListener(this.syv);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(257950);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.sxO.e(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(257950);
      return;
    }
    AppMethodBeat.o(257950);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257946);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.lEm = getIntent().getStringExtra("enterprise_biz_name");
    this.sxO = new e(this, this.lEm);
    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.lEm });
    initView();
    af.bjv().add(this.syD);
    ((n)h.ae(n.class)).bbL().add(this.syD);
    AppMethodBeat.o(257946);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(257953);
    af.bjv().remove(this.syD);
    ((n)h.ae(n.class)).bbL().remove(this.syD);
    super.onDestroy();
    AppMethodBeat.o(257953);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(257952);
    super.onPause();
    AppMethodBeat.o(257952);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(257951);
    super.onResume();
    if (!ab.Ql(this.lEm))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.lEm });
      finish();
      AppMethodBeat.o(257951);
      return;
    }
    AppMethodBeat.o(257951);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    private a syF;
    
    public a(a parama)
    {
      this.syF = parama;
    }
    
    private void apy(String paramString)
    {
      AppMethodBeat.i(265063);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      localIntent.addFlags(67108864);
      com.tencent.mm.by.c.b(this.syF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(265063);
    }
    
    private void czH()
    {
      AppMethodBeat.i(265061);
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setClassName(this.syF.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject).putExtra("enterprise_biz_name", this.syF.czE());
        ((Intent)localObject).putExtra("enterprise_biz_display_name", aa.PJ(this.syF.czE()));
        Context localContext = this.syF.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(265061);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", new Object[] { this.syF.czE(), localThrowable.getMessage() });
        AppMethodBeat.o(265061);
      }
    }
    
    private void czI()
    {
      AppMethodBeat.i(265062);
      Intent localIntent = new Intent();
      localIntent.putExtra("enterprise_from_scene", 1);
      localIntent.putExtra("enterprise_biz_name", this.syF.czE());
      com.tencent.mm.by.c.b(this.syF.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      AppMethodBeat.o(265062);
    }
    
    public final void a(fhh paramfhh)
    {
      AppMethodBeat.i(265059);
      switch (paramfhh.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(265059);
        return;
        czH();
        AppMethodBeat.o(265059);
        return;
        czI();
        AppMethodBeat.o(265059);
        return;
        apy(paramfhh.jump_url);
      }
    }
    
    public static abstract interface a
    {
      public abstract String czE();
      
      public abstract Context getContext();
    }
  }
  
  final class b
    extends BaseAdapter
    implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.d> syG;
    
    public b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void czJ()
    {
      AppMethodBeat.i(266370);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264959);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(d.e.srQ);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            as localas = ((n)h.ae(n.class)).bbL().RG(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localas != null) && (com.tencent.mm.contact.d.rk(localas.field_type))) {
              break label115;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.b.this.notifyDataSetChanged();
            AppMethodBeat.o(264959);
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
      AppMethodBeat.o(266370);
    }
    
    public final EnterpriseBizEntranceListUI.d GH(int paramInt)
    {
      AppMethodBeat.i(266375);
      EnterpriseBizEntranceListUI.d locald = (EnterpriseBizEntranceListUI.d)this.syG.get(paramInt);
      AppMethodBeat.o(266375);
      return locald;
    }
    
    public final void cu(List<fhh> paramList)
    {
      AppMethodBeat.i(266372);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.d((fhh)paramList.next()));
      }
      this.syG = localLinkedList;
      AppMethodBeat.o(266372);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(266374);
      int i = this.syG.size();
      AppMethodBeat.o(266374);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(266379);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, d.f.suj, null);
        paramViewGroup.mWb = ((ImageView)paramView.findViewById(d.e.nearby_friend_avatar_iv));
        paramViewGroup.mUr = ((TextView)paramView.findViewById(d.e.nearby_friend_name));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.d locald;
      for (;;)
      {
        locald = GH(paramInt);
        if (locald != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(266379);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.ci.a.m(localContext, d.d.comm_list_item_selector));
      paramView.setPadding(k, i, j, paramInt);
      String str = Util.nullAsNil(locald.syK.GHJ);
      paramViewGroup.mUr.setText(l.b(localContext, str, paramViewGroup.mUr.getTextSize()));
      paramViewGroup.mUr.setVisibility(0);
      paramViewGroup.mWb.setVisibility(0);
      com.tencent.mm.ay.q.bml().a(locald.syK.ufC, paramViewGroup.mWb, EnterpriseBizEntranceListUI.d.a(locald, localContext));
      AppMethodBeat.o(266379);
      return paramView;
    }
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(266367);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      czJ();
      AppMethodBeat.o(266367);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(266369);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      czJ();
      AppMethodBeat.o(266369);
    }
    
    final class a
    {
      TextView mUr;
      ImageView mWb;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(262538);
        if (this.mWb != null)
        {
          this.mWb.setImageDrawable(null);
          this.mWb.setVisibility(8);
        }
        if (this.mUr != null)
        {
          this.mUr.setText("");
          this.mUr.setVisibility(8);
        }
        AppMethodBeat.o(262538);
      }
    }
  }
  
  static final class c
    implements i
  {
    private final WeakReference<EnterpriseBizEntranceListUI> quK;
    
    public c(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(264166);
      this.quK = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(264166);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(264167);
      try
      {
        if (this.quK.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.quK.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(264167);
            return;
          }
          EnterpriseBizEntranceListUI.access$200(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(258308);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.sxV.TbW.RUY);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                AppMethodBeat.o(258308);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(258308);
              }
            }
          });
        }
        AppMethodBeat.o(264167);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(264167);
      }
    }
  }
  
  public static final class d
  {
    private static float syM = 0.1F;
    final fhh syK;
    int syL;
    
    d()
    {
      AppMethodBeat.i(265783);
      this.syL = 0;
      this.syK = new fhh();
      AppMethodBeat.o(265783);
    }
    
    d(fhh paramfhh)
    {
      this.syL = 0;
      this.syK = paramfhh;
    }
    
    public static com.tencent.mm.ay.a.a.c Y(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(265784);
      c.a locala = new c.a();
      locala.lRD = true;
      locala.kOl = true;
      locala.lRP = paramInt;
      locala.kPz = true;
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (locala.lRW = (syM * com.tencent.mm.ci.a.aZ(paramContext, com.tencent.mm.plugin.brandservice.d.c.BigLargeAvatarSize));; locala.lRW = (syM * com.tencent.mm.ci.a.aZ(paramContext, com.tencent.mm.plugin.brandservice.d.c.NormalAvatarSize)))
      {
        paramContext = locala.bmL();
        AppMethodBeat.o(265784);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */