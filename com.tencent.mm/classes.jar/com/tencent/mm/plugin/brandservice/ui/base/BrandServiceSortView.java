package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.o.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.brandservice.b.g.a;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.contact.ae;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, g.a, BaseSortView.a
{
  private s jhZ;
  private int mServiceType;
  private String pRV;
  private boolean qm;
  private boolean sxI;
  private int syc;
  private int syd;
  private HashMap<String, SpannableString> szo;
  private com.tencent.mm.plugin.brandservice.b.g szp;
  private com.tencent.mm.ui.widget.b.a szq;
  private boolean szr;
  private ListView szs;
  private a szt;
  private boolean szu;
  private String szv;
  private View szw;
  private TextView szx;
  private q.g szy;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.szo = new HashMap();
    this.szp = new com.tencent.mm.plugin.brandservice.b.g();
    this.mServiceType = 251658241;
    this.szu = true;
    this.syc = 0;
    this.syd = 0;
    this.szy = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(261497);
        if (Util.isNullOrNil(BrandServiceSortView.j(BrandServiceSortView.this)))
        {
          Log.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(261497);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          Log.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(BrandServiceSortView.j(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = com.tencent.mm.ao.g.gu(BrandServiceSortView.j(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localas, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(261497);
      }
    };
    setDataSetObserver(this);
    this.szr = false;
    setShowFooterView(false);
    bfU();
    paramContext = this.szp;
    if (!paramContext.swm.contains(this))
    {
      Log.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.swm.add(this);
    }
    this.szq = new com.tencent.mm.ui.widget.b.a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof BrandServiceSortView.b)))
        {
          Log.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5795);
          return;
        }
        paramAnonymousView = (BrandServiceSortView.b)paramAnonymousAdapterView;
        if (Util.isNullOrNil(paramAnonymousView.username))
        {
          Log.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5795);
          return;
        }
        am.biS(paramAnonymousView.username);
        ae.y(BrandServiceSortView.a(BrandServiceSortView.this), 12, 4, paramAnonymousInt - 1);
        if (BrandServiceSortView.b(BrandServiceSortView.this))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Select_Contact", paramAnonymousView.username);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", paramAnonymousView.username);
          if ((BrandServiceSortView.this.getContext() instanceof Activity))
          {
            paramAnonymousView = (Activity)BrandServiceSortView.this.getContext();
            paramAnonymousView.setResult(-1, paramAnonymousAdapterView);
            paramAnonymousView.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(5795);
            return;
          }
        }
        com.tencent.mm.plugin.brandservice.b.b(paramAnonymousView.username, BrandServiceSortView.this.getContext());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(5795);
      }
    });
    setOnItemLongClickListener(this);
    AppMethodBeat.o(5799);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(5803);
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      this.szv = paramString;
      paramd = (qp)paramd.bnW;
      if ((paramd == null) || (paramd.contact == null))
      {
        Log.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((as)localObject).ays();
      String str = ((as)localObject).aph();
      localObject = ((as)localObject).api();
      paramString = paramString.toUpperCase();
      if (((!Util.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5803);
        return true;
      }
    }
    AppMethodBeat.o(5803);
    return false;
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(5800);
    com.tencent.e.h.ZvG.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257709);
        if (BrandServiceSortView.c(BrandServiceSortView.this))
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1378L, 8L, 1L, false);
          BrandServiceSortView.d(BrandServiceSortView.this);
          BrandServiceSortView.a(BrandServiceSortView.this, com.tencent.mm.ui.base.h.a(BrandServiceSortView.this.getContext(), BrandServiceSortView.this.getContext().getString(c.i.app_waiting), true, null));
        }
        AppMethodBeat.o(257709);
      }
    }, 1000L);
    this.szp.ao(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(263528);
        BrandServiceSortView localBrandServiceSortView = BrandServiceSortView.this;
        Object localObject = BrandServiceSortView.f(BrandServiceSortView.this);
        switch (BrandServiceSortView.e(BrandServiceSortView.this))
        {
        }
        for (localObject = ((com.tencent.mm.plugin.brandservice.b.g)localObject).swp;; localObject = ((com.tencent.mm.plugin.brandservice.b.g)localObject).swo)
        {
          localBrandServiceSortView.ig(BrandServiceSortView.cw((List)localObject));
          BrandServiceSortView.g(BrandServiceSortView.this);
          BrandServiceSortView.d(BrandServiceSortView.this);
          if ((BrandServiceSortView.h(BrandServiceSortView.this) != null) && (BrandServiceSortView.h(BrandServiceSortView.this).isShowing()))
          {
            BrandServiceSortView.h(BrandServiceSortView.this).dismiss();
            BrandServiceSortView.h(BrandServiceSortView.this).setCancelMessage(null);
            BrandServiceSortView.h(BrandServiceSortView.this).setDismissMessage(null);
          }
          AppMethodBeat.o(263528);
          return;
        }
      }
    });
    AppMethodBeat.o(5800);
  }
  
  public final void cv(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.szx != null) && (paramList != null)) {
      this.szx.setText(getContext().getString(d.i.svd, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.syc = ((int)paramMotionEvent.getRawX());
      this.syd = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public final View eI()
  {
    AppMethodBeat.i(5804);
    View localView = View.inflate(getContext(), d.f.sug, this);
    AppMethodBeat.o(5804);
    return localView;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.szt;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local4 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(265106);
        long l = Util.currentTicks();
        Context localContext = BrandServiceSortView.this.getContext();
        BrandServiceSortView.b localb;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(d.f.suf, null);
          localb = new BrandServiceSortView.b();
          localb.swP = ((TextView)paramAnonymousView.findViewById(d.e.catalogTV));
          localb.contentView = paramAnonymousView.findViewById(d.e.contentView);
          localb.iZG = ((ImageView)paramAnonymousView.findViewById(d.e.spN));
          localb.syr = ((ImageView)paramAnonymousView.findViewById(d.e.ssf));
          localb.iZH = ((TextView)paramAnonymousView.findViewById(d.e.srw));
          localb.sys = paramAnonymousView.findViewById(d.e.fFT);
          paramAnonymousView.setTag(localb);
        }
        qp localqp;
        for (;;)
        {
          localqp = (qp)paramAnonymousd.bnW;
          if (localqp != null) {
            break;
          }
          Log.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(265106);
          return paramAnonymousView;
          localb = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.Wtj) && (paramAnonymousBoolean1))
        {
          localb.swP.setText(paramAnonymousd.Wtr);
          localb.swP.setVisibility(0);
          localb.username = localqp.userName;
          localb.iZG.setTag(localqp.userName);
          a.b.d(localb.iZG, localb.username);
          paramAnonymousd = localqp.contact.ays();
          BrandServiceSortView.a(BrandServiceSortView.this, localb.iZH, localContext, paramAnonymousd, (int)localb.iZH.getTextSize());
          Log.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localqp.GXj.field_status) });
          paramAnonymousd = localb.syr;
          if ((!BrandServiceSortView.i(BrandServiceSortView.this)) || (localqp.GXj.field_status != 1)) {
            break label468;
          }
          paramAnonymousInt = 0;
          label335:
          paramAnonymousd.setVisibility(paramAnonymousInt);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label474;
          }
          localb.sys.setBackgroundResource(d.d.comm_list_item_selector_no_divider);
          label366:
          if (!BrandServiceSortView.this.Wtk) {
            break label488;
          }
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(d.c.AddressScrollBarWidth), localb.contentView.getPaddingBottom());
        }
        for (;;)
        {
          Log.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(265106);
          return paramAnonymousView;
          localb.swP.setVisibility(8);
          break;
          label468:
          paramAnonymousInt = 8;
          break label335;
          label474:
          localb.sys.setBackgroundResource(d.d.list_item_normal);
          break label366;
          label488:
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(d.c.NormalPadding), localb.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5808);
    return local4;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5806);
    this.szs = ((ListView)findViewById(d.e.listview));
    if (this.szw == null)
    {
      this.szw = inflate(getContext(), d.f.sui, null);
      if ((this.szs != null) && (this.szw != null))
      {
        this.szx = ((TextView)this.szw.findViewById(d.e.dCM));
        this.szs.addFooterView(this.szw, null, false);
      }
    }
    ListView localListView = this.szs;
    AppMethodBeat.o(5806);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5807);
    View localView = findViewById(d.e.no_result);
    AppMethodBeat.o(5807);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(5805);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(d.e.sidrbar);
    AppMethodBeat.o(5805);
    return localVerticalScrollBar;
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(5809);
    bfU();
    AppMethodBeat.o(5809);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(5812);
    if (paramContextMenuInfo == null)
    {
      Log.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
      AppMethodBeat.o(5812);
      return;
    }
    Log.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
    if ((paramView == null) || (paramView.bnW == null))
    {
      Log.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(5812);
      return;
    }
    paramView = ((qp)paramView.bnW).contact;
    if (paramView == null)
    {
      Log.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.pRV = paramView.field_username;
    String str = paramView.ays();
    paramContextMenu.setHeaderTitle(l.c(getContext(), str));
    paramView = com.tencent.mm.ao.g.gu(paramView.field_username);
    if ((paramView != null) && (!paramView.YW())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, d.i.eLi);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.szt != null) {
      this.szt.czC();
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(5815);
      return true;
    }
    AppMethodBeat.o(5815);
    return false;
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5811);
    this.szq.Yre = paramView;
    this.szq.a(paramAdapterView, paramInt, paramLong, this, this.szy, this.syc, this.syd);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (com.tencent.mm.kernel.h.aHB()) {
      af.bjG().bjm();
    }
    this.szp.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.szt = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.sxI = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.qm = paramBoolean;
    C(this.szx, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean czC();
  }
  
  public static final class b
  {
    static Bitmap fgf = null;
    public View contentView;
    ImageView iZG;
    TextView iZH;
    public TextView swP;
    ImageView syr;
    View sys;
    String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */