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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.o.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.protocal.protobuf.fhh;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
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
  private ListView niO;
  private String sxP;
  private boolean sxX;
  private a sxY;
  private int sxZ;
  private d sya;
  private c syb;
  private int syc;
  private int syd;
  private final EnterpriseBizEntranceListUI.a sye;
  private List<b> syf;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(257642);
    this.sxZ = -1;
    this.syc = 0;
    this.syd = 0;
    this.sye = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String czE()
      {
        AppMethodBeat.i(265944);
        String str = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
        AppMethodBeat.o(265944);
        return str;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(265943);
        Context localContext = EnterpriseBizContactListView.this.getContext();
        AppMethodBeat.o(265943);
        return localContext;
      }
    });
    AppMethodBeat.o(257642);
  }
  
  private void ct(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(257647);
    if (this.syf == null)
    {
      AppMethodBeat.o(257647);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.syf.size());
    Iterator localIterator = this.syf.iterator();
    while (localIterator.hasNext())
    {
      qp localqp = (qp)localIterator.next();
      com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
      locald.bnW = localqp;
      locald.Wtr = "!1";
      localArrayList.add(locald);
    }
    paramList.addAll(0, localArrayList);
    AppMethodBeat.o(257647);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    af.bjv();
    Cursor localCursor = f.Q(this.sxP, this.sxX);
    while (localCursor.moveToNext())
    {
      b localb = new b();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new as();
        ((as)localObject).convertFrom(localCursor);
        com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
        localc.convertFrom(localCursor);
        localb.userName = ((ax)localObject).field_username;
        localb.contact = ((as)localObject);
        localb.GXj = localc;
      }
      if (localb.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).bnW = localb;
        if (localb.GXj.YZ()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localb.contact.ayn())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = "!2";
          }
          else
          {
            int j = localb.contact.axh();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    ct(localArrayList);
    this.sxZ = localArrayList.size();
    Collections.sort(localArrayList, new f((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    af.bjG().bjm();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (qp)paramd.bnW;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((qp)localObject).contact.ays();
      String str = ((qp)localObject).contact.aph();
      localObject = ((qp)localObject).contact.api();
      paramString = paramString.toUpperCase();
      if (((!Util.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5710);
        return true;
      }
    }
    AppMethodBeat.o(5710);
    return false;
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(5705);
    List localList = getSortEntityList();
    if (this.sxY != null) {
      this.sxY.GG(this.sxZ);
    }
    ig(localList);
    super.bfU();
    AppMethodBeat.o(5705);
  }
  
  public final void czD()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(267086);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(267086);
          return;
        }
        localObject = (EnterpriseBizContactListView.e)paramAnonymousAdapterView;
        if (((EnterpriseBizContactListView.e)localObject).syq != null)
        {
          EnterpriseBizContactListView.b(EnterpriseBizContactListView.this).a(((EnterpriseBizContactListView.e)localObject).syq);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(267086);
          return;
        }
        if (Util.isNullOrNil(((EnterpriseBizContactListView.e)localObject).username))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(267086);
          return;
        }
        boolean bool1 = g.UD(((EnterpriseBizContactListView.e)localObject).username);
        boolean bool2 = g.KI(((EnterpriseBizContactListView.e)localObject).username);
        com.tencent.mm.api.c localc = g.gu(((EnterpriseBizContactListView.e)localObject).username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.Zb())
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
          com.tencent.mm.by.c.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(267086);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.by.c.f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(267086);
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
          AppMethodBeat.i(267004);
          if (EnterpriseBizContactListView.c(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.c(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.c localc = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.d(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.e(EnterpriseBizContactListView.this);
          if (localc.syl == null)
          {
            localObject = (EnterpriseBizContactListView)localc.sym.get();
            if (localObject == null)
            {
              AppMethodBeat.o(267004);
              return false;
            }
            localc.syl = new com.tencent.mm.ui.widget.h(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.e)))
          {
            AppMethodBeat.o(267004);
            return false;
          }
          localc.syk = ((EnterpriseBizContactListView.e)localObject).username;
          if ((Util.isNullOrNil(localc.syk)) || (g.KI(localc.syk)))
          {
            AppMethodBeat.o(267004);
            return false;
          }
          localc.syl.Yre = paramAnonymousView;
          localc.syl.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.c.1(localc, paramAnonymousInt), new EnterpriseBizContactListView.c.2(localc), i, j);
          AppMethodBeat.o(267004);
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
      this.syc = ((int)paramMotionEvent.getRawX());
      this.syd = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public final View eI()
  {
    AppMethodBeat.i(5711);
    View localView = View.inflate(getContext(), d.f.suo, this);
    AppMethodBeat.o(5711);
    return localView;
  }
  
  public int getContactCount()
  {
    return this.sxZ;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local4 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(266430);
        long l = Util.currentTicks();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        EnterpriseBizContactListView.e locale;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(d.f.suk, null);
          locale = new EnterpriseBizContactListView.e();
          locale.swP = ((TextView)paramAnonymousView.findViewById(d.e.catalogTV));
          locale.contentView = paramAnonymousView.findViewById(d.e.contentView);
          locale.iZG = ((ImageView)paramAnonymousView.findViewById(d.e.spN));
          locale.syr = ((ImageView)paramAnonymousView.findViewById(d.e.ssf));
          locale.iZH = ((TextView)paramAnonymousView.findViewById(d.e.srw));
          locale.sys = paramAnonymousView.findViewById(d.e.fFT);
          paramAnonymousView.setTag(locale);
        }
        qp localqp;
        for (;;)
        {
          localqp = (qp)paramAnonymousd.bnW;
          if (localqp != null) {
            break;
          }
          Log.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(266430);
          return paramAnonymousView;
          locale = (EnterpriseBizContactListView.e)paramAnonymousView.getTag();
        }
        paramAnonymousInt = 0;
        if (localqp.GXj.YZ()) {
          paramAnonymousInt = 1;
        }
        if ((EnterpriseBizContactListView.this.Wtj) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.Wtr.equals("!2"))
          {
            locale.swP.setText(EnterpriseBizContactListView.this.getContext().getString(d.i.eCx));
            locale.swP.setVisibility(0);
            locale.syq = null;
            if (paramAnonymousInt == 0) {
              break label525;
            }
            locale.username = localqp.userName;
            locale.iZG.setImageResource(d.h.enterprise_chat_entry_avatar);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(d.i.svi);
            EnterpriseBizContactListView.a(locale.iZH, localContext, paramAnonymousd, (int)locale.iZH.getTextSize());
            label312:
            Log.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localqp.GXj.field_status) });
            paramAnonymousd = locale.syr;
            if (localqp.GXj.field_status != 1) {
              break label705;
            }
            paramAnonymousInt = 0;
            label357:
            paramAnonymousd.setVisibility(paramAnonymousInt);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label711;
            }
            locale.sys.setBackground(null);
            label386:
            if (!EnterpriseBizContactListView.this.Wtk) {
              break label725;
            }
            locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(d.c.AddressScrollBarWidth), locale.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(266430);
          return paramAnonymousView;
          if (!paramAnonymousd.Wtr.equals("!1"))
          {
            locale.swP.setText(paramAnonymousd.Wtr);
            locale.swP.setVisibility(0);
            break;
          }
          locale.swP.setVisibility(8);
          break;
          label525:
          if (((localqp instanceof EnterpriseBizContactListView.b)) && (((EnterpriseBizContactListView.b)localqp).syi))
          {
            locale.syq = ((EnterpriseBizContactListView.b)localqp).syj;
            locale.iconUrl = locale.syq.ufC;
            com.tencent.mm.ay.q.bml().a(locale.iconUrl, locale.iZG, EnterpriseBizEntranceListUI.d.Y(localContext, d.h.enterprise_chat_entry_avatar));
            EnterpriseBizContactListView.a(locale.iZH, localContext, locale.syq.GHJ, (int)locale.iZH.getTextSize());
            break label312;
          }
          locale.username = localqp.userName;
          locale.iconUrl = localqp.GXj.field_brandIconURL;
          locale.iZG.setTag(localqp.userName);
          a.b.c(locale.iZG, locale.username);
          paramAnonymousd = localqp.contact.ays();
          EnterpriseBizContactListView.a(locale.iZH, localContext, paramAnonymousd, (int)locale.iZH.getTextSize());
          break label312;
          label705:
          paramAnonymousInt = 8;
          break label357;
          label711:
          locale.sys.setBackgroundResource(d.d.list_item_normal);
          break label386;
          label725:
          locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(d.c.NormalPadding), locale.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5715);
    return local4;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5713);
    this.niO = ((ListView)findViewById(d.e.listview));
    ListView localListView = this.niO;
    AppMethodBeat.o(5713);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5714);
    TextView localTextView = (TextView)findViewById(d.e.no_result);
    localTextView.setText(d.i.svk);
    AppMethodBeat.o(5714);
    return localTextView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(5712);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(d.e.sidrbar);
    AppMethodBeat.o(5712);
    return localVerticalScrollBar;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5716);
    if (this.sya != null) {
      this.sya.czC();
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(5716);
      return true;
    }
    AppMethodBeat.o(5716);
    return false;
  }
  
  public void setEmptyListener(a parama)
  {
    this.sxY = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.sxX = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.sxP = paramString;
  }
  
  public void setFixedBrandServiceItem(List<b> paramList)
  {
    this.syf = paramList;
  }
  
  public void setOnTouchListener(d paramd)
  {
    this.sya = paramd;
  }
  
  public static abstract interface a
  {
    public abstract void GG(int paramInt);
  }
  
  public static final class b
    extends qp
  {
    private static fhh syh;
    public boolean syi = false;
    public fhh syj = syh;
    
    static
    {
      AppMethodBeat.i(264425);
      syh = new fhh();
      AppMethodBeat.o(264425);
    }
    
    public static b czF()
    {
      AppMethodBeat.i(264424);
      b localb = new b();
      localb.contact = new as();
      localb.GXj = new com.tencent.mm.api.c();
      AppMethodBeat.o(264424);
      return localb;
    }
  }
  
  static final class c
    implements i
  {
    public String syk;
    com.tencent.mm.ui.widget.h syl;
    WeakReference<EnterpriseBizContactListView> sym;
    private s tipDialog;
    
    public c(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.sym = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.h.aGY().b(1394, this);
      super.finalize();
      AppMethodBeat.o(5702);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      if (paramq.getType() == 1394)
      {
        paramString = ((com.tencent.mm.plugin.profile.b.d)paramq).fpS();
        Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramq).fpR();
        if ((localObject == null) || (((epp)localObject).RUv == null) || (((epp)localObject).RUv.ret != 0))
        {
          if ((localObject != null) && (((epp)localObject).RUv != null))
          {
            Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(((epp)localObject).RUv.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramq.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.qfB)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramq = g.gu(paramString.RUp);
        paramq.field_brandFlag |= 0x1;
        localObject = new cxu();
        ((cxu)localObject).mVM = paramq.field_brandFlag;
        ((cxu)localObject).UserName = paramString.RUp;
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(47, (com.tencent.mm.cd.a)localObject));
        af.bjv().update(paramq, new String[0]);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv(paramq.field_username);
        if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwI(paramq.field_enterpriseFather) <= 0) {
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv(paramq.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.sym.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((com.tencent.mm.ao.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.ao.q.class)).bbQ().bvi(paramq.field_enterpriseFather);
        }
        paramString.bfU();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean czC();
  }
  
  public static final class e
  {
    public View contentView;
    ImageView iZG;
    TextView iZH;
    String iconUrl;
    public TextView swP;
    fhh syq;
    ImageView syr;
    View sys;
    String username;
  }
  
  final class f
    implements Comparator<com.tencent.mm.ui.base.sortview.d>
  {
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView
 * JD-Core Version:    0.7.0.1
 */