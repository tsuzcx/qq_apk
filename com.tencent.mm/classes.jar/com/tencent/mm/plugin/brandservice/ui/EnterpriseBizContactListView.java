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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.an.o.a;
import com.tencent.mm.an.q;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.modelimage.r;
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
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.protocal.protobuf.fkn;
import com.tencent.mm.protocal.protobuf.fko;
import com.tencent.mm.protocal.protobuf.gdt;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EnterpriseBizContactListView
  extends BaseSortView
{
  private ListView qgc;
  private boolean vDG;
  private a vDH;
  private int vDI;
  private d vDJ;
  private c vDK;
  private final EnterpriseBizEntranceListUI.a vDL;
  private List<b> vDM;
  private String vDy;
  private int x_down;
  private int y_down;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(301549);
    this.vDI = -1;
    this.x_down = 0;
    this.y_down = 0;
    this.vDL = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String dcw()
      {
        AppMethodBeat.i(301614);
        String str = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
        AppMethodBeat.o(301614);
        return str;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(301611);
        Context localContext = EnterpriseBizContactListView.this.getContext();
        AppMethodBeat.o(301611);
        return localContext;
      }
    });
    AppMethodBeat.o(301549);
  }
  
  private void el(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(301554);
    if (this.vDM == null)
    {
      AppMethodBeat.o(301554);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.vDM.size());
    Iterator localIterator = this.vDM.iterator();
    while (localIterator.hasNext())
    {
      sa localsa = (sa)localIterator.next();
      com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
      locald.cpt = localsa;
      locald.aeaK = "!1";
      localArrayList.add(locald);
    }
    paramList.addAll(0, localArrayList);
    AppMethodBeat.o(301554);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    af.bHf();
    Cursor localCursor = f.U(this.vDy, this.vDG);
    while (localCursor.moveToNext())
    {
      b localb = new b();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new au();
        ((au)localObject).convertFrom(localCursor);
        com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
        localc.convertFrom(localCursor);
        localb.userName = ((az)localObject).field_username;
        localb.contact = ((au)localObject);
        localb.MVg = localc;
      }
      if (localb.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).cpt = localb;
        if (localb.MVg.aAR()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localb.contact.aSQ())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = "!2";
          }
          else
          {
            int j = localb.contact.aRH();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    el(localArrayList);
    this.vDI = localArrayList.size();
    Collections.sort(localArrayList, new f((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    af.bHr().bGW();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (sa)paramd.cpt;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((sa)localObject).contact.aSV();
      String str = ((sa)localObject).contact.aJt();
      localObject = ((sa)localObject).contact.aJu();
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
  
  public final void bDL()
  {
    AppMethodBeat.i(5705);
    List localList = getSortEntityList();
    if (this.vDH != null) {
      this.vDH.Hf(this.vDI);
    }
    lG(localList);
    super.bDL();
    AppMethodBeat.o(5705);
  }
  
  public final void dcv()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(301602);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(301602);
          return;
        }
        localObject = (EnterpriseBizContactListView.e)paramAnonymousAdapterView;
        if (((EnterpriseBizContactListView.e)localObject).vDX != null)
        {
          EnterpriseBizContactListView.b(EnterpriseBizContactListView.this).a(((EnterpriseBizContactListView.e)localObject).vDX);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(301602);
          return;
        }
        if (Util.isNullOrNil(((EnterpriseBizContactListView.e)localObject).username))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(301602);
          return;
        }
        boolean bool1 = g.MC(((EnterpriseBizContactListView.e)localObject).username);
        boolean bool2 = g.Dn(((EnterpriseBizContactListView.e)localObject).username);
        com.tencent.mm.api.c localc = g.hU(((EnterpriseBizContactListView.e)localObject).username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.aAT())
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
          com.tencent.mm.br.c.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(301602);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.br.c.g(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(301602);
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
          AppMethodBeat.i(301603);
          if (EnterpriseBizContactListView.c(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.c(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.c localc = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.d(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.e(EnterpriseBizContactListView.this);
          if (localc.vDS == null)
          {
            localObject = (EnterpriseBizContactListView)localc.vDT.get();
            if (localObject == null)
            {
              AppMethodBeat.o(301603);
              return false;
            }
            localc.vDS = new com.tencent.mm.ui.widget.h(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.e)))
          {
            AppMethodBeat.o(301603);
            return false;
          }
          localc.vDR = ((EnterpriseBizContactListView.e)localObject).username;
          if ((Util.isNullOrNil(localc.vDR)) || (g.Dn(localc.vDR)))
          {
            AppMethodBeat.o(301603);
            return false;
          }
          localc.vDS.agjs = paramAnonymousView;
          localc.vDS.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.c.1(localc, paramAnonymousInt), new EnterpriseBizContactListView.c.2(localc), i, j);
          AppMethodBeat.o(301603);
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
      this.x_down = ((int)paramMotionEvent.getRawX());
      this.y_down = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public final View fF()
  {
    AppMethodBeat.i(5711);
    View localView = View.inflate(getContext(), d.f.enterprise_biz_list_view_sort, this);
    AppMethodBeat.o(5711);
    return localView;
  }
  
  public int getContactCount()
  {
    return this.vDI;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local4 = new c.a()
    {
      public final View createView(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, ViewGroup paramAnonymousViewGroup, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(301598);
        long l = Util.currentTicks();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(d.f.enterprise_biz_list_item_sort, null);
          paramAnonymousViewGroup = new EnterpriseBizContactListView.e();
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
          Log.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(301598);
          return paramAnonymousView;
          paramAnonymousViewGroup = (EnterpriseBizContactListView.e)paramAnonymousView.getTag();
        }
        paramAnonymousInt1 = 0;
        if (localsa.MVg.aAR()) {
          paramAnonymousInt1 = 1;
        }
        if ((EnterpriseBizContactListView.this.aeaD) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.aeaK.equals("!2"))
          {
            paramAnonymousViewGroup.vCw.setText(EnterpriseBizContactListView.this.getContext().getString(d.i.enterprise_sub_placetop));
            paramAnonymousViewGroup.vCw.setVisibility(0);
            paramAnonymousViewGroup.vDX = null;
            if (paramAnonymousInt1 == 0) {
              break label505;
            }
            paramAnonymousViewGroup.username = localsa.userName;
            paramAnonymousViewGroup.lBC.setImageResource(d.h.enterprise_chat_entry_avatar);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(d.i.enterprise_chat_entry_title);
            EnterpriseBizContactListView.a(paramAnonymousViewGroup.lBD, localContext, paramAnonymousd, (int)paramAnonymousViewGroup.lBD.getTextSize());
            label299:
            Log.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localsa.MVg.field_status) });
            paramAnonymousd = paramAnonymousViewGroup.vDY;
            if (localsa.MVg.field_status != 1) {
              break label670;
            }
            paramAnonymousInt1 = 0;
            label344:
            paramAnonymousd.setVisibility(paramAnonymousInt1);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label677;
            }
            paramAnonymousViewGroup.vDZ.setBackground(null);
            label373:
            if (!EnterpriseBizContactListView.this.aeaE) {
              break label690;
            }
            paramAnonymousViewGroup.contentView.setPadding(paramAnonymousViewGroup.contentView.getPaddingLeft(), paramAnonymousViewGroup.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(d.c.AddressScrollBarWidth), paramAnonymousViewGroup.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(301598);
          return paramAnonymousView;
          if (!paramAnonymousd.aeaK.equals("!1"))
          {
            paramAnonymousViewGroup.vCw.setText(paramAnonymousd.aeaK);
            paramAnonymousViewGroup.vCw.setVisibility(0);
            break;
          }
          paramAnonymousViewGroup.vCw.setVisibility(8);
          break;
          label505:
          if (((localsa instanceof EnterpriseBizContactListView.b)) && (((EnterpriseBizContactListView.b)localsa).vDP))
          {
            paramAnonymousViewGroup.vDX = ((EnterpriseBizContactListView.b)localsa).vDQ;
            paramAnonymousViewGroup.iconUrl = paramAnonymousViewGroup.vDX.icon_url;
            r.bKe().a(paramAnonymousViewGroup.iconUrl, paramAnonymousViewGroup.lBC, EnterpriseBizEntranceListUI.d.af(localContext, d.h.enterprise_chat_entry_avatar));
            EnterpriseBizContactListView.a(paramAnonymousViewGroup.lBD, localContext, paramAnonymousViewGroup.vDX.MEz, (int)paramAnonymousViewGroup.lBD.getTextSize());
            break label299;
          }
          paramAnonymousViewGroup.username = localsa.userName;
          paramAnonymousViewGroup.iconUrl = localsa.MVg.field_brandIconURL;
          paramAnonymousViewGroup.lBC.setTag(localsa.userName);
          a.b.g(paramAnonymousViewGroup.lBC, paramAnonymousViewGroup.username);
          paramAnonymousd = localsa.contact.aSV();
          EnterpriseBizContactListView.a(paramAnonymousViewGroup.lBD, localContext, paramAnonymousd, (int)paramAnonymousViewGroup.lBD.getTextSize());
          break label299;
          label670:
          paramAnonymousInt1 = 8;
          break label344;
          label677:
          paramAnonymousViewGroup.vDZ.setBackgroundResource(d.d.list_item_normal);
          break label373;
          label690:
          paramAnonymousViewGroup.contentView.setPadding(paramAnonymousViewGroup.contentView.getPaddingLeft(), paramAnonymousViewGroup.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(d.c.NormalPadding), paramAnonymousViewGroup.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5715);
    return local4;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5713);
    this.qgc = ((ListView)findViewById(d.e.listview));
    ListView localListView = this.qgc;
    AppMethodBeat.o(5713);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5714);
    TextView localTextView = (TextView)findViewById(d.e.no_result);
    localTextView.setText(d.i.enterprise_no_sub_biz);
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
    if (this.vDJ != null) {}
    for (boolean bool = this.vDJ.dcu();; bool = false)
    {
      if ((bool) || (super.onInterceptTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(5716);
        return true;
      }
      AppMethodBeat.o(5716);
      return false;
    }
  }
  
  public void setEmptyListener(a parama)
  {
    this.vDH = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.vDG = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.vDy = paramString;
  }
  
  public void setFixedBrandServiceItem(List<b> paramList)
  {
    this.vDM = paramList;
  }
  
  public void setOnTouchListener(d paramd)
  {
    this.vDJ = paramd;
  }
  
  public static abstract interface a
  {
    public abstract void Hf(int paramInt);
  }
  
  public static final class b
    extends sa
  {
    private static gdt vDO;
    public boolean vDP = false;
    public gdt vDQ = vDO;
    
    static
    {
      AppMethodBeat.i(301563);
      vDO = new gdt();
      AppMethodBeat.o(301563);
    }
    
    public static b dcx()
    {
      AppMethodBeat.i(301560);
      b localb = new b();
      localb.contact = new au();
      localb.MVg = new com.tencent.mm.api.c();
      AppMethodBeat.o(301560);
      return localb;
    }
  }
  
  static final class c
    implements com.tencent.mm.am.h
  {
    private w tipDialog;
    public String vDR;
    com.tencent.mm.ui.widget.h vDS;
    WeakReference<EnterpriseBizContactListView> vDT;
    
    public c(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.vDT = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.h.aZW().b(1394, this);
      super.finalize();
      AppMethodBeat.o(5702);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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
      if (paramp.getType() == 1394)
      {
        paramString = ((com.tencent.mm.plugin.profile.a.d)paramp).gBg();
        Object localObject = ((com.tencent.mm.plugin.profile.a.d)paramp).gBf();
        if ((localObject == null) || (((fko)localObject).YRW == null) || (((fko)localObject).YRW.ret != 0))
        {
          if ((localObject != null) && (((fko)localObject).YRW != null))
          {
            Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(((fko)localObject).YRW.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramp.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.disable)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramp = g.hU(paramString.YRQ);
        paramp.field_brandFlag |= 0x1;
        localObject = new doz();
        ((doz)localObject).pSt = paramp.field_brandFlag;
        ((doz)localObject).UserName = paramString.YRQ;
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(47, (com.tencent.mm.bx.a)localObject));
        af.bHf().update(paramp, new String[0]);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxK(paramp.field_username);
        if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().byb(paramp.field_enterpriseFather) <= 0) {
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxK(paramp.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.vDT.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((q)com.tencent.mm.kernel.h.ax(q.class)).bzF().bvq(paramp.field_enterpriseFather);
        }
        paramString.bDL();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean dcu();
  }
  
  public static final class e
  {
    public View contentView;
    String iconUrl;
    ImageView lBC;
    TextView lBD;
    String username;
    public TextView vCw;
    gdt vDX;
    ImageView vDY;
    View vDZ;
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