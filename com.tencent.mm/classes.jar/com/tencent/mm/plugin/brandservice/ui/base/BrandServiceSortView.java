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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.brandservice.b.f;
import com.tencent.mm.plugin.brandservice.b.f.a;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.o.g;
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
  private boolean ajQ;
  private String mRa;
  private int mServiceType;
  private boolean poJ;
  private int ppd;
  private int ppe;
  private HashMap<String, SpannableString> pqp;
  private f pqq;
  private com.tencent.mm.ui.widget.b.a pqr;
  private boolean pqs;
  private ListView pqt;
  private a pqu;
  private String pqv;
  private View pqw;
  private TextView pqx;
  private o.g pqy;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.pqp = new HashMap();
    this.pqq = new f();
    this.mServiceType = 251658241;
    this.ppd = 0;
    this.ppe = 0;
    this.pqy = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(5797);
        if (Util.isNullOrNil(BrandServiceSortView.d(BrandServiceSortView.this)))
        {
          Log.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(5797);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          Log.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(BrandServiceSortView.d(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = com.tencent.mm.al.g.fJ(BrandServiceSortView.d(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localas, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(5797);
      }
    };
    setDataSetObserver(this);
    this.pqs = false;
    setShowFooterView(false);
    refresh();
    paramContext = this.pqq;
    if (!paramContext.pno.contains(this))
    {
      Log.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.pno.add(this);
    }
    this.pqr = new com.tencent.mm.ui.widget.b.a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
        am.aXh(paramAnonymousView.username);
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
        Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
        paramAnonymousView = new Intent().putExtra("Chat_User", paramAnonymousView);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("chat_from_scene", 2);
        paramAnonymousView.putExtra("specific_chat_from_scene", 4);
        paramAnonymousView.putExtra("img_gallery_enter_from_chatting_ui", true);
        com.tencent.mm.plugin.brandservice.b.jRt.d(paramAnonymousView, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/base/BrandServiceSortView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(5795);
      }
    });
    setOnItemLongClickListener(this);
    AppMethodBeat.o(5799);
  }
  
  private static List<d> cy(List<qw> paramList)
  {
    AppMethodBeat.i(5801);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        qw localqw = (qw)paramList.get(i);
        d locald;
        int j;
        if ((localqw != null) && (localqw.contact != null))
        {
          locald = new d();
          locald.data = localqw;
          int k = localqw.contact.field_showHead;
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
        for (locald.Pae = ((char)j);; locald.Pae = "#")
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
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      this.pqv = paramString;
      paramd = (qw)paramd.data;
      if ((paramd == null) || (paramd.contact == null))
      {
        Log.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((as)localObject).arJ();
      String str = ((as)localObject).ajz();
      localObject = ((as)localObject).ajA();
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
  
  public final void cz(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.pqx != null) && (paramList != null)) {
      this.pqx.setText(getContext().getString(2131756898, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.ppd = ((int)paramMotionEvent.getRawX());
      this.ppe = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.pqu;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local2 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(5796);
        long l = Util.currentTicks();
        Context localContext = BrandServiceSortView.this.getContext();
        BrandServiceSortView.b localb;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493322, null);
          localb = new BrandServiceSortView.b();
          localb.pnP = ((TextView)paramAnonymousView.findViewById(2131298244));
          localb.contentView = paramAnonymousView.findViewById(2131299189);
          localb.gvv = ((ImageView)paramAnonymousView.findViewById(2131296772));
          localb.pps = ((ImageView)paramAnonymousView.findViewById(2131305356));
          localb.gvw = ((TextView)paramAnonymousView.findViewById(2131297734));
          localb.ppt = paramAnonymousView.findViewById(2131307573);
          paramAnonymousView.setTag(localb);
        }
        qw localqw;
        for (;;)
        {
          localqw = (qw)paramAnonymousd.data;
          if (localqw != null) {
            break;
          }
          Log.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.OZW) && (paramAnonymousBoolean1))
        {
          localb.pnP.setText(paramAnonymousd.Pae);
          localb.pnP.setVisibility(0);
          localb.username = localqw.userName;
          localb.gvv.setTag(localqw.userName);
          a.b.d(localb.gvv, localb.username);
          paramAnonymousd = localqw.contact.arJ();
          BrandServiceSortView.a(BrandServiceSortView.this, localb.gvw, localContext, paramAnonymousd, (int)localb.gvw.getTextSize());
          Log.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localqw.Bdk.field_status) });
          paramAnonymousd = localb.pps;
          if ((!BrandServiceSortView.c(BrandServiceSortView.this)) || (localqw.Bdk.field_status != 1)) {
            break label461;
          }
          paramAnonymousInt = 0;
          label330:
          paramAnonymousd.setVisibility(paramAnonymousInt);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label467;
          }
          localb.ppt.setBackgroundResource(2131231901);
          label360:
          if (!BrandServiceSortView.this.OZX) {
            break label480;
          }
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165188), localb.contentView.getPaddingBottom());
        }
        for (;;)
        {
          Log.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb.pnP.setVisibility(8);
          break;
          label461:
          paramAnonymousInt = 8;
          break label330;
          label467:
          localb.ppt.setBackgroundResource(2131233327);
          break label360;
          label480:
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165534), localb.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5808);
    return local2;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5806);
    this.pqt = ((ListView)findViewById(2131303242));
    if (this.pqw == null)
    {
      this.pqw = inflate(getContext(), 2131493797, null);
      if ((this.pqt != null) && (this.pqw != null))
      {
        this.pqx = ((TextView)this.pqw.findViewById(2131299258));
        this.pqt.addFooterView(this.pqw, null, false);
      }
    }
    ListView localListView = this.pqt;
    AppMethodBeat.o(5806);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5807);
    View localView = findViewById(2131305459);
    AppMethodBeat.o(5807);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(5805);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131307882);
    AppMethodBeat.o(5805);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(5804);
    View localView = View.inflate(getContext(), 2131493324, this);
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
      Log.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
      AppMethodBeat.o(5812);
      return;
    }
    Log.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
    if ((paramView == null) || (paramView.data == null))
    {
      Log.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(5812);
      return;
    }
    paramView = ((qw)paramView.data).contact;
    if (paramView == null)
    {
      Log.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.mRa = paramView.field_username;
    String str = paramView.arJ();
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), str));
    paramView = com.tencent.mm.al.g.fJ(paramView.field_username);
    if ((paramView != null) && (!paramView.UE())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, 2131762835);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.pqu != null) {
      this.pqu.clY();
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
    this.pqr.QSr = paramView;
    this.pqr.a(paramAdapterView, paramInt, paramLong, this, this.pqy, this.ppd, this.ppe);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(5800);
    this.pqq.init();
    hy(cy(this.pqq.CV(this.mServiceType)));
    super.refresh();
    AppMethodBeat.o(5800);
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (com.tencent.mm.kernel.g.aAc()) {
      ag.bas().aZX();
    }
    this.pqq.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.pqu = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.poJ = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.ajQ = paramBoolean;
    A(this.pqx, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean clY();
  }
  
  public static final class b
  {
    static Bitmap pqA = null;
    public View contentView;
    ImageView gvv;
    TextView gvw;
    public TextView pnP;
    ImageView pps;
    View ppt;
    String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */