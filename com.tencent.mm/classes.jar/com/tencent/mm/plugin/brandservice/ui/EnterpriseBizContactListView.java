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
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.o.a;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.protocal.protobuf.ecn;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
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
  private ListView jsM;
  private String odS;
  private boolean oea;
  private a oeb;
  private int oec;
  private d oed;
  private c oee;
  private int oef;
  private int oeg;
  private final EnterpriseBizEntranceListUI.a oeh;
  private List<b> oei;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(208404);
    this.oec = -1;
    this.oef = 0;
    this.oeg = 0;
    this.oeh = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String bOU()
      {
        AppMethodBeat.i(208398);
        String str = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
        AppMethodBeat.o(208398);
        return str;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(208397);
        Context localContext = EnterpriseBizContactListView.this.getContext();
        AppMethodBeat.o(208397);
        return localContext;
      }
    });
    AppMethodBeat.o(208404);
  }
  
  private void ch(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(208405);
    if (this.oei == null)
    {
      AppMethodBeat.o(208405);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.oei.size());
    Iterator localIterator = this.oei.iterator();
    while (localIterator.hasNext())
    {
      pv localpv = (pv)localIterator.next();
      com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
      locald.data = localpv;
      locald.JOY = "!1";
      localArrayList.add(locald);
    }
    paramList.addAll(0, localArrayList);
    AppMethodBeat.o(208405);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    ag.aGp();
    Cursor localCursor = com.tencent.mm.al.f.M(this.odS, this.oea);
    while (localCursor.moveToNext())
    {
      b localb = new b();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new an();
        ((an)localObject).convertFrom(localCursor);
        c localc = new c();
        localc.convertFrom(localCursor);
        localb.userName = ((aw)localObject).field_username;
        localb.contact = ((an)localObject);
        localb.xfE = localc;
      }
      if (localb.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localb;
        if (localb.xfE.Kx()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localb.contact.adB())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = "!2";
          }
          else
          {
            int j = localb.contact.acP();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    ch(localArrayList);
    this.oec = localArrayList.size();
    Collections.sort(localArrayList, new f((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    ag.aGz().aGf();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!bu.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (pv)paramd.data;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((pv)localObject).contact.adG();
      String str = ((pv)localObject).contact.VL();
      localObject = ((pv)localObject).contact.VM();
      paramString = paramString.toUpperCase();
      if (((!bu.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bu.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5710);
        return true;
      }
    }
    AppMethodBeat.o(5710);
    return false;
  }
  
  public final void bOT()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(208399);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(208399);
          return;
        }
        localObject = (EnterpriseBizContactListView.e)paramAnonymousAdapterView;
        if (((EnterpriseBizContactListView.e)localObject).oet != null)
        {
          EnterpriseBizContactListView.b(EnterpriseBizContactListView.this).a(((EnterpriseBizContactListView.e)localObject).oet);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(208399);
          return;
        }
        if (bu.isNullOrNil(((EnterpriseBizContactListView.e)localObject).username))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(208399);
          return;
        }
        boolean bool1 = com.tencent.mm.al.g.Et(((EnterpriseBizContactListView.e)localObject).username);
        boolean bool2 = com.tencent.mm.al.g.vz(((EnterpriseBizContactListView.e)localObject).username);
        c localc = com.tencent.mm.al.g.eX(((EnterpriseBizContactListView.e)localObject).username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.Kz())
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
          com.tencent.mm.br.d.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(208399);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.br.d.f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(208399);
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
          AppMethodBeat.i(208400);
          if (EnterpriseBizContactListView.c(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.c(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.c localc = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.d(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.e(EnterpriseBizContactListView.this);
          if (localc.oeo == null)
          {
            localObject = (EnterpriseBizContactListView)localc.oep.get();
            if (localObject == null)
            {
              AppMethodBeat.o(208400);
              return false;
            }
            localc.oeo = new com.tencent.mm.ui.widget.f(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.e)))
          {
            AppMethodBeat.o(208400);
            return false;
          }
          localc.oen = ((EnterpriseBizContactListView.e)localObject).username;
          if ((bu.isNullOrNil(localc.oen)) || (com.tencent.mm.al.g.vz(localc.oen)))
          {
            AppMethodBeat.o(208400);
            return false;
          }
          localc.oeo.LwF = paramAnonymousView;
          localc.oeo.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.c.1(localc, paramAnonymousInt), new EnterpriseBizContactListView.c.2(localc), i, j);
          AppMethodBeat.o(208400);
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
      this.oef = ((int)paramMotionEvent.getRawX());
      this.oeg = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public int getContactCount()
  {
    return this.oec;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local4 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(208401);
        long l = bu.HQ();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        EnterpriseBizContactListView.e locale;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493840, null);
          locale = new EnterpriseBizContactListView.e();
          locale.ocS = ((TextView)paramAnonymousView.findViewById(2131297925));
          locale.contentView = paramAnonymousView.findViewById(2131298746);
          locale.fQl = ((ImageView)paramAnonymousView.findViewById(2131296683));
          locale.oeu = ((ImageView)paramAnonymousView.findViewById(2131302787));
          locale.fQm = ((TextView)paramAnonymousView.findViewById(2131297508));
          locale.oev = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(locale);
        }
        pv localpv;
        for (;;)
        {
          localpv = (pv)paramAnonymousd.data;
          if (localpv != null) {
            break;
          }
          ae.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(208401);
          return paramAnonymousView;
          locale = (EnterpriseBizContactListView.e)paramAnonymousView.getTag();
        }
        paramAnonymousInt = 0;
        if (localpv.xfE.Kx()) {
          paramAnonymousInt = 1;
        }
        if ((EnterpriseBizContactListView.this.JOQ) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.JOY.equals("!2"))
          {
            locale.ocS.setText(EnterpriseBizContactListView.this.getContext().getString(2131758450));
            locale.ocS.setVisibility(0);
            locale.oet = null;
            if (paramAnonymousInt == 0) {
              break label512;
            }
            locale.username = localpv.userName;
            locale.fQl.setImageResource(2131690123);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(2131758431);
            EnterpriseBizContactListView.a(locale.fQm, localContext, paramAnonymousd, (int)locale.fQm.getTextSize());
            label302:
            ae.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localpv.xfE.field_status) });
            paramAnonymousd = locale.oeu;
            if (localpv.xfE.field_status != 1) {
              break label691;
            }
            paramAnonymousInt = 0;
            label347:
            paramAnonymousd.setVisibility(paramAnonymousInt);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label697;
            }
            locale.oev.setBackground(null);
            label376:
            if (!EnterpriseBizContactListView.this.JOR) {
              break label711;
            }
            locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165185), locale.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          ae.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(bu.aO(l)) });
          AppMethodBeat.o(208401);
          return paramAnonymousView;
          if (!paramAnonymousd.JOY.equals("!1"))
          {
            locale.ocS.setText(paramAnonymousd.JOY);
            locale.ocS.setVisibility(0);
            break;
          }
          locale.ocS.setVisibility(8);
          break;
          label512:
          if (((localpv instanceof EnterpriseBizContactListView.b)) && (((EnterpriseBizContactListView.b)localpv).oel))
          {
            locale.oet = ((EnterpriseBizContactListView.b)localpv).oem;
            locale.iconUrl = locale.oet.pqW;
            com.tencent.mm.av.q.aJb().a(locale.iconUrl, locale.fQl, EnterpriseBizEntranceListUI.d.N(localContext, 2131690123));
            EnterpriseBizContactListView.a(locale.fQm, localContext, locale.oet.wSB, (int)locale.fQm.getTextSize());
            break label302;
          }
          locale.username = localpv.userName;
          locale.iconUrl = localpv.xfE.field_brandIconURL;
          locale.fQl.setTag(localpv.userName);
          a.b.c(locale.fQl, locale.username);
          paramAnonymousd = localpv.contact.adG();
          EnterpriseBizContactListView.a(locale.fQm, localContext, paramAnonymousd, (int)locale.fQm.getTextSize());
          break label302;
          label691:
          paramAnonymousInt = 8;
          break label347;
          label697:
          locale.oev.setBackgroundResource(2131232867);
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
    this.jsM = ((ListView)findViewById(2131301457));
    ListView localListView = this.jsM;
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
    if (this.oed != null) {
      this.oed.bOS();
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
    if (this.oeb != null) {
      this.oeb.zv(this.oec);
    }
    gB(localList);
    super.refresh();
    AppMethodBeat.o(5705);
  }
  
  public void setEmptyListener(a parama)
  {
    this.oeb = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.oea = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.odS = paramString;
  }
  
  public void setFixedBrandServiceItem(List<b> paramList)
  {
    this.oei = paramList;
  }
  
  public void setOnTouchListener(d paramd)
  {
    this.oed = paramd;
  }
  
  public static abstract interface a
  {
    public abstract void zv(int paramInt);
  }
  
  public static final class b
    extends pv
  {
    private static ecn oek;
    public boolean oel = false;
    public ecn oem = oek;
    
    static
    {
      AppMethodBeat.i(208403);
      oek = new ecn();
      AppMethodBeat.o(208403);
    }
    
    public static b bOV()
    {
      AppMethodBeat.i(208402);
      b localb = new b();
      localb.contact = new an();
      localb.xfE = new c();
      AppMethodBeat.o(208402);
      return localb;
    }
  }
  
  static final class c
    implements com.tencent.mm.ak.f
  {
    public String oen;
    com.tencent.mm.ui.widget.f oeo;
    WeakReference<EnterpriseBizContactListView> oep;
    p tipDialog;
    
    public c(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.oep = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.g.ajj().b(1394, this);
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
        paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dDI();
        Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dDH();
        if ((localObject == null) || (((dma)localObject).FZD == null) || (((dma)localObject).FZD.ret != 0))
        {
          if ((localObject != null) && (((dma)localObject).FZD != null))
          {
            ae.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dma)localObject).FZD.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          ae.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.lXh)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramn = com.tencent.mm.al.g.eX(paramString.FZx);
        paramn.field_brandFlag |= 0x1;
        localObject = new cac();
        ((cac)localObject).jgj = paramn.field_brandFlag;
        ((cac)localObject).nIJ = paramString.FZx;
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(47, (com.tencent.mm.bw.a)localObject));
        ag.aGp().update(paramn, new String[0]);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aUY(paramn.field_username);
        if (((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVm(paramn.field_enterpriseFather) <= 0) {
          ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aUY(paramn.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.oep.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.q.class)).azK().aTS(paramn.field_enterpriseFather);
        }
        paramString.refresh();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean bOS();
  }
  
  public static final class e
  {
    public View contentView;
    ImageView fQl;
    TextView fQm;
    String iconUrl;
    public TextView ocS;
    ecn oet;
    ImageView oeu;
    View oev;
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