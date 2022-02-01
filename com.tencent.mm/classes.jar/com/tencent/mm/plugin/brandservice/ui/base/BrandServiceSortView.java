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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.o.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.b.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private String lJm;
  private int mServiceType;
  private boolean odL;
  private int oef;
  private int oeg;
  private TextView ofA;
  private n.e ofB;
  private HashMap<String, SpannableString> ofs;
  private f oft;
  private com.tencent.mm.ui.widget.b.a ofu;
  private boolean ofv;
  private ListView ofw;
  private a ofx;
  private String ofy;
  private View ofz;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.ofs = new HashMap();
    this.oft = new f();
    this.mServiceType = 251658241;
    this.oef = 0;
    this.oeg = 0;
    this.ofB = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(5797);
        if (bu.isNullOrNil(BrandServiceSortView.d(BrandServiceSortView.this)))
        {
          ae.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(5797);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          ae.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(BrandServiceSortView.d(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = com.tencent.mm.al.g.eX(BrandServiceSortView.d(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localan, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(5797);
      }
    };
    setDataSetObserver(this);
    this.ofv = false;
    setShowFooterView(false);
    refresh();
    paramContext = this.oft;
    if (!paramContext.ocp.contains(this))
    {
      ae.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.ocp.add(this);
    }
    this.ofu = new com.tencent.mm.ui.widget.b.a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof BrandServiceSortView.b)))
        {
          ae.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5795);
          return;
        }
        paramAnonymousView = (BrandServiceSortView.b)paramAnonymousAdapterView;
        if (bu.isNullOrNil(paramAnonymousView.username))
        {
          ae.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(5795);
          return;
        }
        ah.aHm(paramAnonymousView.username);
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
        ae.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
        paramAnonymousView = new Intent().putExtra("Chat_User", paramAnonymousView);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("chat_from_scene", 2);
        paramAnonymousView.putExtra("specific_chat_from_scene", 4);
        paramAnonymousView.putExtra("img_gallery_enter_from_chatting_ui", true);
        com.tencent.mm.plugin.brandservice.b.iUz.d(paramAnonymousView, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(5795);
      }
    });
    setOnItemLongClickListener(this);
    AppMethodBeat.o(5799);
  }
  
  private static List<d> cj(List<pv> paramList)
  {
    AppMethodBeat.i(5801);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        pv localpv = (pv)paramList.get(i);
        d locald;
        int j;
        if ((localpv != null) && (localpv.contact != null))
        {
          locald = new d();
          locald.data = localpv;
          int k = localpv.contact.field_showHead;
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
        for (locald.JOY = ((char)j);; locald.JOY = "#")
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
    if ((!bu.isNullOrNil(paramString)) && (paramd != null))
    {
      this.ofy = paramString;
      paramd = (pv)paramd.data;
      if ((paramd == null) || (paramd.contact == null))
      {
        ae.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((an)localObject).adG();
      String str = ((an)localObject).VL();
      localObject = ((an)localObject).VM();
      paramString = paramString.toUpperCase();
      if (((!bu.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bu.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5803);
        return true;
      }
    }
    AppMethodBeat.o(5803);
    return false;
  }
  
  public final void ck(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.ofA != null) && (paramList != null)) {
      this.ofA.setText(getContext().getString(2131756736, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.oef = ((int)paramMotionEvent.getRawX());
      this.oeg = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.ofx;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local2 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(5796);
        long l = bu.HQ();
        Context localContext = BrandServiceSortView.this.getContext();
        BrandServiceSortView.b localb;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493240, null);
          localb = new BrandServiceSortView.b();
          localb.ocS = ((TextView)paramAnonymousView.findViewById(2131297925));
          localb.contentView = paramAnonymousView.findViewById(2131298746);
          localb.fQl = ((ImageView)paramAnonymousView.findViewById(2131296683));
          localb.oeu = ((ImageView)paramAnonymousView.findViewById(2131302787));
          localb.fQm = ((TextView)paramAnonymousView.findViewById(2131297508));
          localb.oev = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(localb);
        }
        pv localpv;
        for (;;)
        {
          localpv = (pv)paramAnonymousd.data;
          if (localpv != null) {
            break;
          }
          ae.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.JOQ) && (paramAnonymousBoolean1))
        {
          localb.ocS.setText(paramAnonymousd.JOY);
          localb.ocS.setVisibility(0);
          localb.username = localpv.userName;
          localb.fQl.setTag(localpv.userName);
          a.b.d(localb.fQl, localb.username);
          paramAnonymousd = localpv.contact.adG();
          BrandServiceSortView.a(BrandServiceSortView.this, localb.fQm, localContext, paramAnonymousd, (int)localb.fQm.getTextSize());
          ae.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localpv.xfE.field_status) });
          paramAnonymousd = localb.oeu;
          if ((!BrandServiceSortView.c(BrandServiceSortView.this)) || (localpv.xfE.field_status != 1)) {
            break label461;
          }
          paramAnonymousInt = 0;
          label330:
          paramAnonymousd.setVisibility(paramAnonymousInt);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label467;
          }
          localb.oev.setBackgroundResource(2131231820);
          label360:
          if (!BrandServiceSortView.this.JOR) {
            break label480;
          }
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165185), localb.contentView.getPaddingBottom());
        }
        for (;;)
        {
          ae.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(bu.aO(l)) });
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb.ocS.setVisibility(8);
          break;
          label461:
          paramAnonymousInt = 8;
          break label330;
          label467:
          localb.oev.setBackgroundResource(2131232867);
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
    this.ofw = ((ListView)findViewById(2131301457));
    if (this.ofz == null)
    {
      this.ofz = inflate(getContext(), 2131493667, null);
      if ((this.ofw != null) && (this.ofz != null))
      {
        this.ofA = ((TextView)this.ofz.findViewById(2131298799));
        this.ofw.addFooterView(this.ofz, null, false);
      }
    }
    ListView localListView = this.ofw;
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
      ae.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
      AppMethodBeat.o(5812);
      return;
    }
    ae.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
    if ((paramView == null) || (paramView.data == null))
    {
      ae.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(5812);
      return;
    }
    paramView = ((pv)paramView.data).contact;
    if (paramView == null)
    {
      ae.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.lJm = paramView.field_username;
    String str = paramView.adG();
    paramContextMenu.setHeaderTitle(k.c(getContext(), str));
    paramView = com.tencent.mm.al.g.eX(paramView.field_username);
    if ((paramView != null) && (!paramView.Ku())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, 2131761049);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.ofx != null) {
      this.ofx.bOS();
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
    this.ofu.LwF = paramView;
    this.ofu.a(paramAdapterView, paramInt, paramLong, this, this.ofB, this.oef, this.oeg);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(5800);
    this.oft.init();
    gB(cj(this.oft.zq(this.mServiceType)));
    super.refresh();
    AppMethodBeat.o(5800);
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (com.tencent.mm.kernel.g.ajM()) {
      ag.aGz().aGf();
    }
    this.oft.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.ofx = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.odL = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.ajD = paramBoolean;
    y(this.ofA, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean bOS();
  }
  
  public static final class b
  {
    static Bitmap ofD = null;
    public View contentView;
    ImageView fQl;
    TextView fQm;
    public TextView ocS;
    ImageView oeu;
    View oev;
    String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */