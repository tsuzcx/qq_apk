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
import com.tencent.mm.am.f;
import com.tencent.mm.am.n.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.g.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.contact.ac;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, g.a, BaseSortView.a
{
  private boolean agS;
  private String kGt;
  private int mUE;
  private int mUF;
  private boolean mUm;
  private HashMap<String, SpannableString> mVK;
  private com.tencent.mm.plugin.brandservice.b.g mVL;
  private int mVM;
  private a mVN;
  private boolean mVO;
  private ListView mVP;
  private a mVQ;
  private String mVR;
  private View mVS;
  private TextView mVT;
  private n.d mVU;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.mVK = new HashMap();
    this.mVL = new com.tencent.mm.plugin.brandservice.b.g();
    this.mVM = 251658241;
    this.mUE = 0;
    this.mUF = 0;
    this.mVU = new n.d()
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
          com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(BrandServiceSortView.d(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = f.ei(BrandServiceSortView.d(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localaf, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(5797);
      }
    };
    setDataSetObserver(this);
    this.mVO = false;
    setShowFooterView(false);
    refresh();
    paramContext = this.mVL;
    if (!paramContext.mSQ.contains(this))
    {
      ad.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.mSQ.add(this);
    }
    this.mVN = new a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof BrandServiceSortView.b)))
        {
          ad.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
          AppMethodBeat.o(5795);
          return;
        }
        paramAnonymousView = (BrandServiceSortView.b)paramAnonymousAdapterView;
        if (bt.isNullOrNil(paramAnonymousView.username))
        {
          ad.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(5795);
          return;
        }
        com.tencent.mm.plugin.websearch.api.af.avh(paramAnonymousView.username);
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
        b.hYt.d(paramAnonymousView, paramAnonymousAdapterView);
        AppMethodBeat.o(5795);
      }
    });
    setOnItemLongClickListener(this);
    AppMethodBeat.o(5799);
  }
  
  private static List<d> ce(List<oh> paramList)
  {
    AppMethodBeat.i(5801);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        oh localoh = (oh)paramList.get(i);
        d locald;
        int j;
        if ((localoh != null) && (localoh.contact != null))
        {
          locald = new d();
          locald.data = localoh;
          int k = localoh.contact.field_showHead;
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
        for (locald.GgC = ((char)j);; locald.GgC = "#")
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
      this.mVR = paramString;
      paramd = (oh)paramd.data;
      if ((paramd == null) || (paramd.contact == null))
      {
        ad.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((com.tencent.mm.storage.af)localObject).ZX();
      String str = ((com.tencent.mm.storage.af)localObject).Sv();
      localObject = ((com.tencent.mm.storage.af)localObject).Sw();
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
  
  public final void cf(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.mVT != null) && (paramList != null)) {
      this.mVT.setText(getContext().getString(2131756736, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.mUE = ((int)paramMotionEvent.getRawX());
      this.mUF = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.mVQ;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local2 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(5796);
        long l = bt.GC();
        Context localContext = BrandServiceSortView.this.getContext();
        BrandServiceSortView.b localb;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493240, null);
          localb = new BrandServiceSortView.b();
          localb.mTt = ((TextView)paramAnonymousView.findViewById(2131297925));
          localb.contentView = paramAnonymousView.findViewById(2131298746);
          localb.frr = ((ImageView)paramAnonymousView.findViewById(2131296683));
          localb.mUN = ((ImageView)paramAnonymousView.findViewById(2131302787));
          localb.frs = ((TextView)paramAnonymousView.findViewById(2131297508));
          localb.mUO = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(localb);
        }
        oh localoh;
        for (;;)
        {
          localoh = (oh)paramAnonymousd.data;
          if (localoh != null) {
            break;
          }
          ad.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.Ggu) && (paramAnonymousBoolean1))
        {
          localb.mTt.setText(paramAnonymousd.GgC);
          localb.mTt.setVisibility(0);
          localb.username = localoh.userName;
          localb.frr.setTag(localoh.userName);
          a.b.d(localb.frr, localb.username);
          paramAnonymousd = localoh.contact.ZX();
          BrandServiceSortView.a(BrandServiceSortView.this, localb.frs, localContext, paramAnonymousd, (int)localb.frs.getTextSize());
          ad.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localoh.uzN.field_status) });
          paramAnonymousd = localb.mUN;
          if ((!BrandServiceSortView.c(BrandServiceSortView.this)) || (localoh.uzN.field_status != 1)) {
            break label461;
          }
          paramAnonymousInt = 0;
          label330:
          paramAnonymousd.setVisibility(paramAnonymousInt);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label467;
          }
          localb.mUO.setBackgroundResource(2131231820);
          label360:
          if (!BrandServiceSortView.this.Ggv) {
            break label480;
          }
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165185), localb.contentView.getPaddingBottom());
        }
        for (;;)
        {
          ad.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(bt.aS(l)) });
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb.mTt.setVisibility(8);
          break;
          label461:
          paramAnonymousInt = 8;
          break label330;
          label467:
          localb.mUO.setBackgroundResource(2131232867);
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
    this.mVP = ((ListView)findViewById(2131301457));
    if (this.mVS == null)
    {
      this.mVS = inflate(getContext(), 2131493667, null);
      if ((this.mVP != null) && (this.mVS != null))
      {
        this.mVT = ((TextView)this.mVS.findViewById(2131298799));
        this.mVP.addFooterView(this.mVS, null, false);
      }
    }
    ListView localListView = this.mVP;
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
    paramView = ((oh)paramView.data).contact;
    if (paramView == null)
    {
      ad.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.kGt = paramView.field_username;
    String str = paramView.ZX();
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), str));
    paramView = f.ei(paramView.field_username);
    if ((paramView != null) && (!paramView.Jd())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, 2131761049);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.mVQ != null) {
      this.mVQ.bCz();
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
    this.mVN.HIt = paramView;
    this.mVN.a(paramAdapterView, paramInt, paramLong, this, this.mVU, this.mUE, this.mUF);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(5800);
    this.mVL.init();
    ga(ce(this.mVL.xF(this.mVM)));
    super.refresh();
    AppMethodBeat.o(5800);
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (com.tencent.mm.kernel.g.afw()) {
      com.tencent.mm.am.af.awo().avU();
    }
    this.mVL.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.mVQ = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.mUm = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.agS = paramBoolean;
    x(this.mVT, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean bCz();
  }
  
  public static final class b
  {
    static Bitmap mVW = null;
    public View contentView;
    ImageView frr;
    TextView frs;
    public TextView mTt;
    ImageView mUN;
    View mUO;
    String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */