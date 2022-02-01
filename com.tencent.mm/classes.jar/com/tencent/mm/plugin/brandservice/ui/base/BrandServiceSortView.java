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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.an.o.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.model.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.contact.aj;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, g.a, BaseSortView.a
{
  private w lKp;
  private int mServiceType;
  private boolean rj;
  private String sWX;
  private boolean vDr;
  private HashMap<String, SpannableString> vET;
  private com.tencent.mm.plugin.brandservice.model.g vEU;
  private com.tencent.mm.ui.widget.b.a vEV;
  private boolean vEW;
  private ListView vEX;
  private a vEY;
  private boolean vEZ;
  private String vFa;
  private View vFb;
  private TextView vFc;
  private u.i vFd;
  private int x_down;
  private int y_down;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.vET = new HashMap();
    this.vEU = new com.tencent.mm.plugin.brandservice.model.g();
    this.mServiceType = 251658241;
    this.vEZ = true;
    this.x_down = 0;
    this.y_down = 0;
    this.vFd = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(301739);
        if (Util.isNullOrNil(BrandServiceSortView.j(BrandServiceSortView.this)))
        {
          Log.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(301739);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          Log.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(BrandServiceSortView.j(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = com.tencent.mm.an.g.hU(BrandServiceSortView.j(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localau, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(301739);
      }
    };
    setDataSetObserver(this);
    this.vEW = false;
    setShowFooterView(false);
    bDL();
    paramContext = this.vEU;
    if (!paramContext.vBT.contains(this))
    {
      Log.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.vBT.add(this);
    }
    this.vEV = new com.tencent.mm.ui.widget.b.a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
        an.biA(paramAnonymousView.username);
        aj.y(BrandServiceSortView.a(BrandServiceSortView.this), 12, 4, paramAnonymousInt - 1);
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
      this.vFa = paramString;
      paramd = (sa)paramd.cpt;
      if ((paramd == null) || (paramd.contact == null))
      {
        Log.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((au)localObject).aSV();
      String str = ((au)localObject).aJt();
      localObject = ((au)localObject).aJu();
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
  
  public final void bDL()
  {
    AppMethodBeat.i(5800);
    com.tencent.threadpool.h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(301726);
        if (BrandServiceSortView.c(BrandServiceSortView.this))
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1378L, 8L, 1L, false);
          BrandServiceSortView.d(BrandServiceSortView.this);
          BrandServiceSortView.a(BrandServiceSortView.this, k.a(BrandServiceSortView.this.getContext(), BrandServiceSortView.this.getContext().getString(c.i.app_waiting), true, null));
        }
        AppMethodBeat.o(301726);
      }
    }, 1000L);
    this.vEU.aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(301725);
        BrandServiceSortView localBrandServiceSortView = BrandServiceSortView.this;
        Object localObject = BrandServiceSortView.f(BrandServiceSortView.this);
        switch (BrandServiceSortView.e(BrandServiceSortView.this))
        {
        }
        for (localObject = ((com.tencent.mm.plugin.brandservice.model.g)localObject).vBW;; localObject = ((com.tencent.mm.plugin.brandservice.model.g)localObject).vBV)
        {
          localBrandServiceSortView.lG(BrandServiceSortView.en((List)localObject));
          BrandServiceSortView.g(BrandServiceSortView.this);
          BrandServiceSortView.d(BrandServiceSortView.this);
          if ((BrandServiceSortView.h(BrandServiceSortView.this) != null) && (BrandServiceSortView.h(BrandServiceSortView.this).isShowing()))
          {
            BrandServiceSortView.h(BrandServiceSortView.this).dismiss();
            BrandServiceSortView.h(BrandServiceSortView.this).setCancelMessage(null);
            BrandServiceSortView.h(BrandServiceSortView.this).setDismissMessage(null);
          }
          AppMethodBeat.o(301725);
          return;
        }
      }
    });
    AppMethodBeat.o(5800);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.x_down = ((int)paramMotionEvent.getRawX());
      this.y_down = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public final View fF()
  {
    AppMethodBeat.i(5804);
    View localView = View.inflate(getContext(), d.f.brand_service_sortview, this);
    AppMethodBeat.o(5804);
    return localView;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.vEY;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local4 = new c.a()
    {
      public final View createView(d paramAnonymousd, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(301735);
        long l = Util.currentTicks();
        Context localContext = BrandServiceSortView.this.getContext();
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(d.f.brand_service_lv_item, null);
          paramAnonymousViewGroup = new BrandServiceSortView.b();
          paramAnonymousViewGroup.vCw = ((TextView)paramAnonymousView.findViewById(d.e.catalogTV));
          paramAnonymousViewGroup.contentView = paramAnonymousView.findViewById(d.e.contentView);
          paramAnonymousViewGroup.lBC = ((ImageView)paramAnonymousView.findViewById(d.e.app_avatar_iv));
          paramAnonymousViewGroup.vDY = ((ImageView)paramAnonymousView.findViewById(d.e.new_iv));
          paramAnonymousViewGroup.lBD = ((TextView)paramAnonymousView.findViewById(d.e.brand_service_nickname));
          paramAnonymousViewGroup.vDZ = paramAnonymousView.findViewById(d.e.selector);
          paramAnonymousView.setTag(paramAnonymousViewGroup);
        }
        sa localsa;
        for (;;)
        {
          localsa = (sa)paramAnonymousd.cpt;
          if (localsa != null) {
            break;
          }
          Log.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(301735);
          return paramAnonymousView;
          paramAnonymousViewGroup = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.aeaD) && (paramAnonymousBoolean1))
        {
          paramAnonymousViewGroup.vCw.setText(paramAnonymousd.aeaK);
          paramAnonymousViewGroup.vCw.setVisibility(0);
          paramAnonymousViewGroup.username = localsa.userName;
          paramAnonymousViewGroup.lBC.setTag(localsa.userName);
          a.b.h(paramAnonymousViewGroup.lBC, paramAnonymousViewGroup.username);
          paramAnonymousd = localsa.contact.aSV();
          BrandServiceSortView.a(BrandServiceSortView.this, paramAnonymousViewGroup.lBD, localContext, paramAnonymousd, (int)paramAnonymousViewGroup.lBD.getTextSize());
          Log.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localsa.MVg.field_status) });
          paramAnonymousd = paramAnonymousViewGroup.vDY;
          if ((!BrandServiceSortView.i(BrandServiceSortView.this)) || (localsa.MVg.field_status != 1)) {
            break label446;
          }
          paramAnonymousInt1 = 0;
          label318:
          paramAnonymousd.setVisibility(paramAnonymousInt1);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label453;
          }
          paramAnonymousViewGroup.vDZ.setBackgroundResource(d.d.comm_list_item_selector_no_divider);
          label349:
          if (!BrandServiceSortView.this.aeaE) {
            break label466;
          }
          paramAnonymousViewGroup.contentView.setPadding(paramAnonymousViewGroup.contentView.getPaddingLeft(), paramAnonymousViewGroup.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(d.c.AddressScrollBarWidth), paramAnonymousViewGroup.contentView.getPaddingBottom());
        }
        for (;;)
        {
          Log.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(301735);
          return paramAnonymousView;
          paramAnonymousViewGroup.vCw.setVisibility(8);
          break;
          label446:
          paramAnonymousInt1 = 8;
          break label318;
          label453:
          paramAnonymousViewGroup.vDZ.setBackgroundResource(d.d.list_item_normal);
          break label349;
          label466:
          paramAnonymousViewGroup.contentView.setPadding(paramAnonymousViewGroup.contentView.getPaddingLeft(), paramAnonymousViewGroup.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(d.c.NormalPadding), paramAnonymousViewGroup.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5808);
    return local4;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5806);
    this.vEX = ((ListView)findViewById(d.e.listview));
    if (this.vFb == null)
    {
      this.vFb = inflate(getContext(), d.f.count_view, null);
      if ((this.vEX != null) && (this.vFb != null))
      {
        this.vFc = ((TextView)this.vFb.findViewById(d.e.count_tv));
        this.vEX.addFooterView(this.vFb, null, false);
      }
    }
    ListView localListView = this.vEX;
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
    bDL();
    AppMethodBeat.o(5809);
  }
  
  public final void onChanged(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.vFc != null) && (paramList != null)) {
      this.vFc.setText(getContext().getString(d.i.brandservice_count, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
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
    if ((paramView == null) || (paramView.cpt == null))
    {
      Log.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(5812);
      return;
    }
    paramView = ((sa)paramView.cpt).contact;
    if (paramView == null)
    {
      Log.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.sWX = paramView.field_username;
    String str = paramView.aSV();
    paramContextMenu.setHeaderTitle(p.b(getContext(), str));
    paramView = com.tencent.mm.an.g.hU(paramView.field_username);
    if ((paramView != null) && (!paramView.aAO())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, d.i.main_conversation_longclick_delete_biz_service);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.vEY != null) {}
    for (boolean bool = this.vEY.dcu();; bool = false)
    {
      if ((bool) || (super.onInterceptTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(5815);
        return true;
      }
      AppMethodBeat.o(5815);
      return false;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5811);
    this.vEV.agjs = paramView;
    this.vEV.a(paramAdapterView, paramInt, paramLong, this, this.vFd, this.x_down, this.y_down);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (com.tencent.mm.kernel.h.baz()) {
      af.bHr().bGW();
    }
    this.vEU.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.vEY = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.vDr = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.rj = paramBoolean;
    I(this.vFc, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean dcu();
  }
  
  public static final class b
  {
    static Bitmap hkp = null;
    public View contentView;
    ImageView lBC;
    TextView lBD;
    String username;
    public TextView vCw;
    ImageView vDY;
    View vDZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */