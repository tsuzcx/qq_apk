package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.og;
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
  private String iNV;
  private ListView krb;
  private e poP;
  private b ppE;
  private a ppf;
  private AdapterView.OnItemClickListener ppw;
  private int scene;
  
  public EnterpriseBizEntranceListUI()
  {
    AppMethodBeat.i(194903);
    this.ppf = new a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String cma()
      {
        AppMethodBeat.i(194882);
        String str = EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this);
        AppMethodBeat.o(194882);
        return str;
      }
      
      public final Context getContext()
      {
        return EnterpriseBizEntranceListUI.this;
      }
    });
    AppMethodBeat.o(194903);
  }
  
  private void cv(List<ewv> paramList)
  {
    AppMethodBeat.i(194905);
    if (this.ppE == null)
    {
      AppMethodBeat.o(194905);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = this.ppE;
      LinkedList localLinkedList = new LinkedList();
      d locald = new d();
      locald.ppM = 2131690156;
      locald.ppL.type = 1;
      locald.ppL.AOv = paramList.context.getString(2131758728);
      locald.ppL.qGB = ("https://" + WeChatHosts.domainString(2131761752) + "/node/wework/images/icon_im.48490d44c5.png");
      localLinkedList.add(locald);
      locald = new d();
      locald.ppL.AOv = paramList.context.getString(2131758747);
      locald.ppL.qGB = ("https://" + WeChatHosts.domainString(2131761752) + "/node/wework/images/icon_workspace.cb133ed72e.png");
      locald.ppL.type = 2;
      localLinkedList.add(locald);
      paramList.ppH = localLinkedList;
      AppMethodBeat.o(194905);
      return;
    }
    this.ppE.cx(paramList);
    AppMethodBeat.o(194905);
  }
  
  public int getLayoutId()
  {
    return 2131493996;
  }
  
  public void initView()
  {
    AppMethodBeat.i(194906);
    this.krb = ((ListView)findViewById(2131300142));
    if (this.ppE == null)
    {
      this.ppE = new b(this);
      cv(com.tencent.mm.al.g.Nk(this.iNV));
      ag.bar();
      com.tencent.mm.al.e.a(this.iNV, new c(this));
      this.ppw = new EnterpriseBizEntranceListUI.1(this);
    }
    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "count = %s", new Object[] { Integer.valueOf(this.ppE.getCount()) });
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.iNV);
    setMMTitle(((as)localObject).arI());
    if ((localObject == null) || (!com.tencent.mm.contact.c.oR(((ax)localObject).field_type)) || (this.ppE.getCount() <= 0))
    {
      this.krb.setVisibility(8);
      localObject = (TextView)findViewById(2131300143);
      ((TextView)localObject).setText(2131758742);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new EnterpriseBizEntranceListUI.2(this));
      setToTop(new EnterpriseBizEntranceListUI.3(this));
      addIconOptionMenu(1, 2131755152, 2131689491, this.poP.cmc());
      AppMethodBeat.o(194906);
      return;
      this.krb.setVisibility(0);
      this.krb.setAdapter(this.ppE);
      this.krb.setOnItemClickListener(this.ppw);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(194907);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.poP.e(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(194907);
      return;
    }
    AppMethodBeat.o(194907);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194904);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.iNV = getIntent().getStringExtra("enterprise_biz_name");
    this.poP = new e(this, this.iNV);
    Log.i("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "bizName = %s", new Object[] { this.iNV });
    initView();
    ag.bah().add(this.ppE);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this.ppE);
    AppMethodBeat.o(194904);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(194910);
    ag.bah().remove(this.ppE);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this.ppE);
    super.onDestroy();
    AppMethodBeat.o(194910);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(194909);
    super.onPause();
    AppMethodBeat.o(194909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(194908);
    super.onResume();
    if (!ab.IS(this.iNV))
    {
      Log.e("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "%s !isContact", new Object[] { this.iNV });
      finish();
      AppMethodBeat.o(194908);
      return;
    }
    AppMethodBeat.o(194908);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
  {
    private a ppG;
    
    public a(a parama)
    {
      this.ppG = parama;
    }
    
    private void ahM(String paramString)
    {
      AppMethodBeat.i(194886);
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      localIntent.addFlags(67108864);
      com.tencent.mm.br.c.b(this.ppG.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(194886);
    }
    
    private void cmd()
    {
      AppMethodBeat.i(194884);
      try
      {
        Object localObject = new Intent();
        ((Intent)localObject).setClassName(this.ppG.getContext(), "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject).putExtra("enterprise_biz_name", this.ppG.cma());
        ((Intent)localObject).putExtra("enterprise_biz_display_name", aa.getDisplayName(this.ppG.cma()));
        Context localContext = this.ppG.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizEntranceListUI$BizEntranceListItemBinding", "jumpToMsgListUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(194884);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.w("MicroMsg.BrandService.EnterpriseBizEntranceListUI", "jumpToMsgListUI fail, father=%s, error msg: %s", new Object[] { this.ppG.cma(), localThrowable.getMessage() });
        AppMethodBeat.o(194884);
      }
    }
    
    private void cme()
    {
      AppMethodBeat.i(194885);
      Intent localIntent = new Intent();
      localIntent.putExtra("enterprise_from_scene", 1);
      localIntent.putExtra("enterprise_biz_name", this.ppG.cma());
      com.tencent.mm.br.c.b(this.ppG.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      AppMethodBeat.o(194885);
    }
    
    public final void a(ewv paramewv)
    {
      AppMethodBeat.i(194883);
      switch (paramewv.type)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(194883);
        return;
        cmd();
        AppMethodBeat.o(194883);
        return;
        cme();
        AppMethodBeat.o(194883);
        return;
        ahM(paramewv.pTL);
      }
    }
    
    public static abstract interface a
    {
      public abstract String cma();
      
      public abstract Context getContext();
    }
  }
  
  final class b
    extends BaseAdapter
    implements MStorage.IOnStorageChange, MStorageEx.IOnStorageChange
  {
    final Context context;
    LinkedList<EnterpriseBizEntranceListUI.d> ppH;
    
    public b(Context paramContext)
    {
      this.context = paramContext;
    }
    
    private void cmf()
    {
      AppMethodBeat.i(194891);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194887);
          TextView localTextView = (TextView)EnterpriseBizEntranceListUI.this.findViewById(2131300143);
          if ((EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this) != null) && (localTextView != null))
          {
            as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(EnterpriseBizEntranceListUI.c(EnterpriseBizEntranceListUI.this));
            if ((localas != null) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
              break label114;
            }
            EnterpriseBizEntranceListUI.b(EnterpriseBizEntranceListUI.this).setVisibility(8);
            localTextView.setVisibility(0);
          }
          for (;;)
          {
            EnterpriseBizEntranceListUI.b.this.notifyDataSetChanged();
            AppMethodBeat.o(194887);
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
      AppMethodBeat.o(194891);
    }
    
    public final EnterpriseBizEntranceListUI.d Db(int paramInt)
    {
      AppMethodBeat.i(194894);
      EnterpriseBizEntranceListUI.d locald = (EnterpriseBizEntranceListUI.d)this.ppH.get(paramInt);
      AppMethodBeat.o(194894);
      return locald;
    }
    
    public final void cx(List<ewv> paramList)
    {
      AppMethodBeat.i(194892);
      LinkedList localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localLinkedList.add(new EnterpriseBizEntranceListUI.d((ewv)paramList.next()));
      }
      this.ppH = localLinkedList;
      AppMethodBeat.o(194892);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(194893);
      int i = this.ppH.size();
      AppMethodBeat.o(194893);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(194895);
      Context localContext = paramViewGroup.getContext();
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(localContext, 2131493994, null);
        paramViewGroup.keC = ((ImageView)paramView.findViewById(2131305241));
        paramViewGroup.kcS = ((TextView)paramView.findViewById(2131305247));
        paramView.setTag(paramViewGroup);
      }
      EnterpriseBizEntranceListUI.d locald;
      for (;;)
      {
        locald = Db(paramInt);
        if (locald != null) {
          break;
        }
        paramViewGroup.clear();
        AppMethodBeat.o(194895);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.clear();
      paramInt = paramView.getPaddingBottom();
      int i = paramView.getPaddingTop();
      int j = paramView.getPaddingRight();
      int k = paramView.getPaddingLeft();
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.l(localContext, 2131231898));
      paramView.setPadding(k, i, j, paramInt);
      String str = Util.nullAsNil(locald.ppL.AOv);
      paramViewGroup.kcS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localContext, str, paramViewGroup.kcS.getTextSize()));
      paramViewGroup.kcS.setVisibility(0);
      paramViewGroup.keC.setVisibility(0);
      com.tencent.mm.av.q.bcV().a(locald.ppL.qGB, paramViewGroup.keC, EnterpriseBizEntranceListUI.d.a(locald, localContext));
      AppMethodBeat.o(194895);
      return paramView;
    }
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(194889);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange1 %d", new Object[] { Integer.valueOf(paramInt) });
      cmf();
      AppMethodBeat.o(194889);
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(194890);
      Log.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange2 %s", new Object[] { paramString });
      cmf();
      AppMethodBeat.o(194890);
    }
    
    final class a
    {
      TextView kcS;
      ImageView keC;
      
      a() {}
      
      public final void clear()
      {
        AppMethodBeat.i(194888);
        if (this.keC != null)
        {
          this.keC.setImageDrawable(null);
          this.keC.setVisibility(8);
        }
        if (this.kcS != null)
        {
          this.kcS.setText("");
          this.kcS.setVisibility(8);
        }
        AppMethodBeat.o(194888);
      }
    }
  }
  
  static final class c
    implements i
  {
    private final WeakReference<EnterpriseBizEntranceListUI> nsR;
    
    public c(EnterpriseBizEntranceListUI paramEnterpriseBizEntranceListUI)
    {
      AppMethodBeat.i(194898);
      this.nsR = new WeakReference(paramEnterpriseBizEntranceListUI);
      AppMethodBeat.o(194898);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(194899);
      try
      {
        if (this.nsR.get() != null)
        {
          paramString = (EnterpriseBizEntranceListUI)this.nsR.get();
          boolean bool = paramString.isFinishing();
          if (bool)
          {
            AppMethodBeat.o(194899);
            return;
          }
          EnterpriseBizEntranceListUI.access$200(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194897);
              try
              {
                EnterpriseBizEntranceListUI.a(paramString, this.poW.LTl.KUa);
                EnterpriseBizEntranceListUI.a(paramString).notifyDataSetChanged();
                AppMethodBeat.o(194897);
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(194897);
              }
            }
          });
        }
        AppMethodBeat.o(194899);
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(194899);
      }
    }
  }
  
  public static final class d
  {
    private static float ppN = 0.1F;
    final ewv ppL;
    int ppM;
    
    d()
    {
      AppMethodBeat.i(194900);
      this.ppM = 0;
      this.ppL = new ewv();
      AppMethodBeat.o(194900);
    }
    
    d(ewv paramewv)
    {
      this.ppM = 0;
      this.ppL = paramewv;
    }
    
    public static com.tencent.mm.av.a.a.c S(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(194901);
      c.a locala = new c.a();
      locala.jbf = true;
      locala.hZF = true;
      locala.jbq = paramInt;
      locala.iaT = true;
      if (com.tencent.mm.cb.a.jk(paramContext)) {}
      for (locala.jbx = (ppN * com.tencent.mm.cb.a.aH(paramContext, 2131165193));; locala.jbx = (ppN * com.tencent.mm.cb.a.aH(paramContext, 2131165526)))
      {
        paramContext = locala.bdv();
        AppMethodBeat.o(194901);
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizEntranceListUI
 * JD-Core Version:    0.7.0.1
 */