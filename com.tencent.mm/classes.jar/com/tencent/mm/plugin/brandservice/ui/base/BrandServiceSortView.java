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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.o.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.b.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.contact.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, f.a, BaseSortView.a
{
  private boolean ajD;
  private String lEN;
  private int mServiceType;
  private boolean nYc;
  private int nYw;
  private int nYx;
  private HashMap<String, SpannableString> nZI;
  private f nZJ;
  private com.tencent.mm.ui.widget.b.a nZK;
  private boolean nZL;
  private ListView nZM;
  private a nZN;
  private String nZO;
  private View nZP;
  private TextView nZQ;
  private n.e nZR;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.nZI = new HashMap();
    this.nZJ = new f();
    this.mServiceType = 251658241;
    this.nYw = 0;
    this.nYx = 0;
    this.nZR = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(5797);
        if (bt.isNullOrNil(BrandServiceSortView.d(BrandServiceSortView.this)))
        {
          ad.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(5797);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          ad.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(BrandServiceSortView.d(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = com.tencent.mm.am.g.eS(BrandServiceSortView.d(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localam, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(5797);
      }
    };
    setDataSetObserver(this);
    this.nZL = false;
    setShowFooterView(false);
    refresh();
    paramContext = this.nZJ;
    if (!paramContext.nWG.contains(this))
    {
      ad.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.nWG.add(this);
    }
    this.nZK = new com.tencent.mm.ui.widget.b.a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof BrandServiceSortView.b)))
        {
          ad.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5795);
          return;
        }
        paramAnonymousView = (BrandServiceSortView.b)paramAnonymousAdapterView;
        if (bt.isNullOrNil(paramAnonymousView.username))
        {
          ad.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5795);
          return;
        }
        ah.aFS(paramAnonymousView.username);
        ac.u(BrandServiceSortView.a(BrandServiceSortView.this), 12, 4, paramAnonymousInt - 1);
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
        paramAnonymousView = paramAnonymousView.username;
        paramAnonymousAdapterView = BrandServiceSortView.this.getContext();
        ad.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
        paramAnonymousView = new Intent().putExtra("Chat_User", paramAnonymousView);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("chat_from_scene", 2);
        paramAnonymousView.putExtra("specific_chat_from_scene", 4);
        paramAnonymousView.putExtra("img_gallery_enter_from_chatting_ui", true);
        com.tencent.mm.plugin.brandservice.b.iRG.d(paramAnonymousView, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(5795);
      }
    });
    setOnItemLongClickListener(this);
    AppMethodBeat.o(5799);
  }
  
  private static List<d> ch(List<pt> paramList)
  {
    AppMethodBeat.i(5801);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        pt localpt = (pt)paramList.get(i);
        d locald;
        int j;
        if ((localpt != null) && (localpt.contact != null))
        {
          locald = new d();
          locald.data = localpt;
          int k = localpt.contact.field_showHead;
          j = k;
          if (k >= 97)
          {
            j = k;
            if (k <= 122) {
              j = k - 32;
            }
          }
          if ((j < 65) || (j > 90)) {
            break label151;
          }
        }
        label151:
        for (locald.Juj = ((char)j);; locald.Juj = "#")
        {
          localArrayList.add(locald);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(5801);
      return localArrayList;
    }
    AppMethodBeat.o(5801);
    return null;
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(5803);
    if ((!bt.isNullOrNil(paramString)) && (paramd != null))
    {
      this.nZO = paramString;
      paramd = (pt)paramd.data;
      if ((paramd == null) || (paramd.contact == null))
      {
        ad.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((am)localObject).adv();
      String str = ((am)localObject).VD();
      localObject = ((am)localObject).VE();
      paramString = paramString.toUpperCase();
      if (((!bt.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5803);
        return true;
      }
    }
    AppMethodBeat.o(5803);
    return false;
  }
  
  public final void ci(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.nZQ != null) && (paramList != null)) {
      this.nZQ.setText(getContext().getString(2131756736, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.nYw = ((int)paramMotionEvent.getRawX());
      this.nYx = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.nZN;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local2 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(5796);
        long l = bt.HI();
        Context localContext = BrandServiceSortView.this.getContext();
        BrandServiceSortView.b localb;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493240, null);
          localb = new BrandServiceSortView.b();
          localb.nXj = ((TextView)paramAnonymousView.findViewById(2131297925));
          localb.contentView = paramAnonymousView.findViewById(2131298746);
          localb.fOf = ((ImageView)paramAnonymousView.findViewById(2131296683));
          localb.nYL = ((ImageView)paramAnonymousView.findViewById(2131302787));
          localb.fOg = ((TextView)paramAnonymousView.findViewById(2131297508));
          localb.nYM = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(localb);
        }
        pt localpt;
        for (;;)
        {
          localpt = (pt)paramAnonymousd.data;
          if (localpt != null) {
            break;
          }
          ad.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.Jub) && (paramAnonymousBoolean1))
        {
          localb.nXj.setText(paramAnonymousd.Juj);
          localb.nXj.setVisibility(0);
          localb.username = localpt.userName;
          localb.fOf.setTag(localpt.userName);
          a.b.d(localb.fOf, localb.username);
          paramAnonymousd = localpt.contact.adv();
          BrandServiceSortView.a(BrandServiceSortView.this, localb.fOg, localContext, paramAnonymousd, (int)localb.fOg.getTextSize());
          ad.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localpt.wPN.field_status) });
          paramAnonymousd = localb.nYL;
          if ((!BrandServiceSortView.c(BrandServiceSortView.this)) || (localpt.wPN.field_status != 1)) {
            break label461;
          }
          paramAnonymousInt = 0;
          label330:
          paramAnonymousd.setVisibility(paramAnonymousInt);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label467;
          }
          localb.nYM.setBackgroundResource(2131231820);
          label360:
          if (!BrandServiceSortView.this.Juc) {
            break label480;
          }
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165185), localb.contentView.getPaddingBottom());
        }
        for (;;)
        {
          ad.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(bt.aO(l)) });
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb.nXj.setVisibility(8);
          break;
          label461:
          paramAnonymousInt = 8;
          break label330;
          label467:
          localb.nYM.setBackgroundResource(2131232867);
          break label360;
          label480:
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165516), localb.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5808);
    return local2;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5806);
    this.nZM = ((ListView)findViewById(2131301457));
    if (this.nZP == null)
    {
      this.nZP = inflate(getContext(), 2131493667, null);
      if ((this.nZM != null) && (this.nZP != null))
      {
        this.nZQ = ((TextView)this.nZP.findViewById(2131298799));
        this.nZM.addFooterView(this.nZP, null, false);
      }
    }
    ListView localListView = this.nZM;
    AppMethodBeat.o(5806);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5807);
    View localView = findViewById(2131302883);
    AppMethodBeat.o(5807);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(5805);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131304800);
    AppMethodBeat.o(5805);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(5804);
    View localView = View.inflate(getContext(), 2131493242, this);
    AppMethodBeat.o(5804);
    return localView;
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(5809);
    refresh();
    AppMethodBeat.o(5809);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(5812);
    if (paramContextMenuInfo == null)
    {
      ad.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
      AppMethodBeat.o(5812);
      return;
    }
    ad.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
    if ((paramView == null) || (paramView.data == null))
    {
      ad.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(5812);
      return;
    }
    paramView = ((pt)paramView.data).contact;
    if (paramView == null)
    {
      ad.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.lEN = paramView.field_username;
    String str = paramView.adv();
    paramContextMenu.setHeaderTitle(k.c(getContext(), str));
    paramView = com.tencent.mm.am.g.eS(paramView.field_username);
    if ((paramView != null) && (!paramView.Km())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, 2131761049);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.nZN != null) {
      this.nZN.bNV();
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
    this.nZK.Lah = paramView;
    this.nZK.a(paramAdapterView, paramInt, paramLong, this, this.nZR, this.nYw, this.nYx);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(5800);
    this.nZJ.init();
    gs(ch(this.nZJ.zh(this.mServiceType)));
    super.refresh();
    AppMethodBeat.o(5800);
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (com.tencent.mm.kernel.g.ajx()) {
      ag.aGj().aFP();
    }
    this.nZJ.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.nZN = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.nYc = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.ajD = paramBoolean;
    x(this.nZQ, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean bNV();
  }
  
  public static final class b
  {
    static Bitmap nZT = null;
    public View contentView;
    ImageView fOf;
    TextView fOg;
    public TextView nXj;
    ImageView nYL;
    View nYM;
    String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */