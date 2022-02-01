package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.o.a;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EnterpriseBizContactListView
  extends BaseSortView
{
  private ListView jpT;
  private String nYj;
  private boolean nYr;
  private a nYs;
  private int nYt;
  private d nYu;
  private c nYv;
  private int nYw;
  private int nYx;
  private final EnterpriseBizEntranceListUI.a nYy;
  private List<b> nYz;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209450);
    this.nYt = -1;
    this.nYw = 0;
    this.nYx = 0;
    this.nYy = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String bNX()
      {
        AppMethodBeat.i(209444);
        String str = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
        AppMethodBeat.o(209444);
        return str;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(209443);
        Context localContext = EnterpriseBizContactListView.this.getContext();
        AppMethodBeat.o(209443);
        return localContext;
      }
    });
    AppMethodBeat.o(209450);
  }
  
  private void cf(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(209451);
    if (this.nYz == null)
    {
      AppMethodBeat.o(209451);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.nYz.size());
    Iterator localIterator = this.nYz.iterator();
    while (localIterator.hasNext())
    {
      pt localpt = (pt)localIterator.next();
      com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
      locald.data = localpt;
      locald.Juj = "!1";
      localArrayList.add(locald);
    }
    paramList.addAll(0, localArrayList);
    AppMethodBeat.o(209451);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    ag.aFZ();
    Cursor localCursor = com.tencent.mm.am.f.M(this.nYj, this.nYr);
    while (localCursor.moveToNext())
    {
      b localb = new b();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new am();
        ((am)localObject).convertFrom(localCursor);
        c localc = new c();
        localc.convertFrom(localCursor);
        localb.userName = ((aw)localObject).field_username;
        localb.contact = ((am)localObject);
        localb.wPN = localc;
      }
      if (localb.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localb;
        if (localb.wPN.Kp()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localb.contact.adq())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = "!2";
          }
          else
          {
            int j = localb.contact.acE();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    cf(localArrayList);
    this.nYt = localArrayList.size();
    Collections.sort(localArrayList, new f((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    ag.aGj().aFP();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!bt.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (pt)paramd.data;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((pt)localObject).contact.adv();
      String str = ((pt)localObject).contact.VD();
      localObject = ((pt)localObject).contact.VE();
      paramString = paramString.toUpperCase();
      if (((!bt.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5710);
        return true;
      }
    }
    AppMethodBeat.o(5710);
    return false;
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(209445);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(209445);
          return;
        }
        localObject = (EnterpriseBizContactListView.e)paramAnonymousAdapterView;
        if (((EnterpriseBizContactListView.e)localObject).nYK != null)
        {
          EnterpriseBizContactListView.b(EnterpriseBizContactListView.this).a(((EnterpriseBizContactListView.e)localObject).nYK);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(209445);
          return;
        }
        if (bt.isNullOrNil(((EnterpriseBizContactListView.e)localObject).username))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(209445);
          return;
        }
        boolean bool1 = com.tencent.mm.am.g.DR(((EnterpriseBizContactListView.e)localObject).username);
        boolean bool2 = com.tencent.mm.am.g.vd(((EnterpriseBizContactListView.e)localObject).username);
        c localc = com.tencent.mm.am.g.eS(((EnterpriseBizContactListView.e)localObject).username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.Kr())
        {
          paramAnonymousView = paramAnonymousAdapterView;
          if (paramAnonymousAdapterView == null) {
            paramAnonymousView = "";
          }
          if (!bool1) {
            break;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("rawUrl", paramAnonymousView);
          paramAnonymousAdapterView.putExtra("useJs", true);
          paramAnonymousAdapterView.putExtra("srcUsername", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
          paramAnonymousAdapterView.addFlags(67108864);
          com.tencent.mm.bs.d.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(209445);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.bs.d.f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(209445);
          return;
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("Chat_User", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
          com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, EnterpriseBizContactListView.this.getContext());
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 1);
        }
      }
    });
    if (getMode() == 0) {
      setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(209446);
          if (EnterpriseBizContactListView.c(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.c(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.c localc = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.d(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.e(EnterpriseBizContactListView.this);
          if (localc.nYF == null)
          {
            localObject = (EnterpriseBizContactListView)localc.nYG.get();
            if (localObject == null)
            {
              AppMethodBeat.o(209446);
              return false;
            }
            localc.nYF = new com.tencent.mm.ui.widget.f(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.e)))
          {
            AppMethodBeat.o(209446);
            return false;
          }
          localc.nYE = ((EnterpriseBizContactListView.e)localObject).username;
          if ((bt.isNullOrNil(localc.nYE)) || (com.tencent.mm.am.g.vd(localc.nYE)))
          {
            AppMethodBeat.o(209446);
            return false;
          }
          localc.nYF.Lah = paramAnonymousView;
          localc.nYF.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.c.1(localc, paramAnonymousInt), new EnterpriseBizContactListView.c.2(localc), i, j);
          AppMethodBeat.o(209446);
          return true;
        }
      });
    }
    AppMethodBeat.o(5707);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5706);
    if (paramMotionEvent.getAction() == 0)
    {
      this.nYw = ((int)paramMotionEvent.getRawX());
      this.nYx = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public int getContactCount()
  {
    return this.nYt;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local4 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(209447);
        long l = bt.HI();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        EnterpriseBizContactListView.e locale;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493840, null);
          locale = new EnterpriseBizContactListView.e();
          locale.nXj = ((TextView)paramAnonymousView.findViewById(2131297925));
          locale.contentView = paramAnonymousView.findViewById(2131298746);
          locale.fOf = ((ImageView)paramAnonymousView.findViewById(2131296683));
          locale.nYL = ((ImageView)paramAnonymousView.findViewById(2131302787));
          locale.fOg = ((TextView)paramAnonymousView.findViewById(2131297508));
          locale.nYM = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(locale);
        }
        pt localpt;
        for (;;)
        {
          localpt = (pt)paramAnonymousd.data;
          if (localpt != null) {
            break;
          }
          ad.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(209447);
          return paramAnonymousView;
          locale = (EnterpriseBizContactListView.e)paramAnonymousView.getTag();
        }
        paramAnonymousInt = 0;
        if (localpt.wPN.Kp()) {
          paramAnonymousInt = 1;
        }
        if ((EnterpriseBizContactListView.this.Jub) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.Juj.equals("!2"))
          {
            locale.nXj.setText(EnterpriseBizContactListView.this.getContext().getString(2131758450));
            locale.nXj.setVisibility(0);
            locale.nYK = null;
            if (paramAnonymousInt == 0) {
              break label512;
            }
            locale.username = localpt.userName;
            locale.fOf.setImageResource(2131690123);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(2131758431);
            EnterpriseBizContactListView.a(locale.fOg, localContext, paramAnonymousd, (int)locale.fOg.getTextSize());
            label302:
            ad.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localpt.wPN.field_status) });
            paramAnonymousd = locale.nYL;
            if (localpt.wPN.field_status != 1) {
              break label691;
            }
            paramAnonymousInt = 0;
            label347:
            paramAnonymousd.setVisibility(paramAnonymousInt);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label697;
            }
            locale.nYM.setBackground(null);
            label376:
            if (!EnterpriseBizContactListView.this.Juc) {
              break label711;
            }
            locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165185), locale.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          ad.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(bt.aO(l)) });
          AppMethodBeat.o(209447);
          return paramAnonymousView;
          if (!paramAnonymousd.Juj.equals("!1"))
          {
            locale.nXj.setText(paramAnonymousd.Juj);
            locale.nXj.setVisibility(0);
            break;
          }
          locale.nXj.setVisibility(8);
          break;
          label512:
          if (((localpt instanceof EnterpriseBizContactListView.b)) && (((EnterpriseBizContactListView.b)localpt).nYC))
          {
            locale.nYK = ((EnterpriseBizContactListView.b)localpt).nYD;
            locale.iconUrl = locale.nYK.pkr;
            com.tencent.mm.aw.q.aIJ().a(locale.iconUrl, locale.fOf, EnterpriseBizEntranceListUI.d.N(localContext, 2131690123));
            EnterpriseBizContactListView.a(locale.fOg, localContext, locale.nYK.wCQ, (int)locale.fOg.getTextSize());
            break label302;
          }
          locale.username = localpt.userName;
          locale.iconUrl = localpt.wPN.field_brandIconURL;
          locale.fOf.setTag(localpt.userName);
          a.b.c(locale.fOf, locale.username);
          paramAnonymousd = localpt.contact.adv();
          EnterpriseBizContactListView.a(locale.fOg, localContext, paramAnonymousd, (int)locale.fOg.getTextSize());
          break label302;
          label691:
          paramAnonymousInt = 8;
          break label347;
          label697:
          locale.nYM.setBackgroundResource(2131232867);
          break label376;
          label711:
          locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165516), locale.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5715);
    return local4;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5713);
    this.jpT = ((ListView)findViewById(2131301457));
    ListView localListView = this.jpT;
    AppMethodBeat.o(5713);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5714);
    TextView localTextView = (TextView)findViewById(2131302883);
    localTextView.setText(2131758444);
    AppMethodBeat.o(5714);
    return localTextView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(5712);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131304800);
    AppMethodBeat.o(5712);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(5711);
    View localView = View.inflate(getContext(), 2131493843, this);
    AppMethodBeat.o(5711);
    return localView;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5716);
    if (this.nYu != null) {
      this.nYu.bNV();
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(5716);
      return true;
    }
    AppMethodBeat.o(5716);
    return false;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(5705);
    List localList = getSortEntityList();
    if (this.nYs != null) {
      this.nYs.zm(this.nYt);
    }
    gs(localList);
    super.refresh();
    AppMethodBeat.o(5705);
  }
  
  public void setEmptyListener(a parama)
  {
    this.nYs = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.nYr = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.nYj = paramString;
  }
  
  public void setFixedBrandServiceItem(List<b> paramList)
  {
    this.nYz = paramList;
  }
  
  public void setOnTouchListener(d paramd)
  {
    this.nYu = paramd;
  }
  
  public static abstract interface a
  {
    public abstract void zm(int paramInt);
  }
  
  public static final class b
    extends pt
  {
    private static eaw nYB;
    public boolean nYC = false;
    public eaw nYD = nYB;
    
    static
    {
      AppMethodBeat.i(209449);
      nYB = new eaw();
      AppMethodBeat.o(209449);
    }
    
    public static b bNY()
    {
      AppMethodBeat.i(209448);
      b localb = new b();
      localb.contact = new am();
      localb.wPN = new c();
      AppMethodBeat.o(209448);
      return localb;
    }
  }
  
  static final class c
    implements com.tencent.mm.al.f
  {
    public String nYE;
    com.tencent.mm.ui.widget.f nYF;
    WeakReference<EnterpriseBizContactListView> nYG;
    p tipDialog;
    
    public c(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.nYG = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.g.aiU().b(1394, this);
      super.finalize();
      AppMethodBeat.o(5702);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(5703);
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(5703);
        return;
      }
      if (paramn.getType() == 1394)
      {
        paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dAr();
        Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dAq();
        if ((localObject == null) || (((dld)localObject).FHh == null) || (((dld)localObject).FHh.ret != 0))
        {
          if ((localObject != null) && (((dld)localObject).FHh != null))
          {
            ad.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dld)localObject).FHh.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          ad.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.lSG)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramn = com.tencent.mm.am.g.eS(paramString.FHb);
        paramn.field_brandFlag |= 0x1;
        localObject = new bzi();
        ((bzi)localObject).jdq = paramn.field_brandFlag;
        ((bzi)localObject).nDo = paramString.FHb;
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new k.a(47, (com.tencent.mm.bx.a)localObject));
        ag.aFZ().update(paramn, new String[0]);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx(paramn.field_username);
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTL(paramn.field_enterpriseFather) <= 0) {
          ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx(paramn.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.nYG.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((com.tencent.mm.am.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.q.class)).azu().aSv(paramn.field_enterpriseFather);
        }
        paramString.refresh();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean bNV();
  }
  
  public static final class e
  {
    public View contentView;
    ImageView fOf;
    TextView fOg;
    String iconUrl;
    public TextView nXj;
    eaw nYK;
    ImageView nYL;
    View nYM;
    String username;
  }
  
  final class f
    implements Comparator<com.tencent.mm.ui.base.sortview.d>
  {
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView
 * JD-Core Version:    0.7.0.1
 */