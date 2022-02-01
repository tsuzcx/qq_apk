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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.o.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.ewv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;
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
  private ListView krb;
  private String poQ;
  private boolean poY;
  private a poZ;
  private int ppa;
  private d ppb;
  private c ppc;
  private int ppd;
  private int ppe;
  private final EnterpriseBizEntranceListUI.a ppf;
  private List<b> ppg;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194869);
    this.ppa = -1;
    this.ppd = 0;
    this.ppe = 0;
    this.ppf = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String cma()
      {
        AppMethodBeat.i(194863);
        String str = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
        AppMethodBeat.o(194863);
        return str;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(194862);
        Context localContext = EnterpriseBizContactListView.this.getContext();
        AppMethodBeat.o(194862);
        return localContext;
      }
    });
    AppMethodBeat.o(194869);
  }
  
  private void cw(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(194870);
    if (this.ppg == null)
    {
      AppMethodBeat.o(194870);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.ppg.size());
    Iterator localIterator = this.ppg.iterator();
    while (localIterator.hasNext())
    {
      qw localqw = (qw)localIterator.next();
      com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
      locald.data = localqw;
      locald.Pae = "!1";
      localArrayList.add(locald);
    }
    paramList.addAll(0, localArrayList);
    AppMethodBeat.o(194870);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    ag.bah();
    Cursor localCursor = com.tencent.mm.al.f.O(this.poQ, this.poY);
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
        localb.Bdk = localc;
      }
      if (localb.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localb;
        if (localb.Bdk.UH()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localb.contact.arE())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = "!2";
          }
          else
          {
            int j = localb.contact.aqN();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    cw(localArrayList);
    this.ppa = localArrayList.size();
    Collections.sort(localArrayList, new f((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    ag.bas().aZX();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!Util.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (qw)paramd.data;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((qw)localObject).contact.arJ();
      String str = ((qw)localObject).contact.ajz();
      localObject = ((qw)localObject).contact.ajA();
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
  
  public final void clZ()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(194864);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194864);
          return;
        }
        localObject = (EnterpriseBizContactListView.e)paramAnonymousAdapterView;
        if (((EnterpriseBizContactListView.e)localObject).ppr != null)
        {
          EnterpriseBizContactListView.b(EnterpriseBizContactListView.this).a(((EnterpriseBizContactListView.e)localObject).ppr);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194864);
          return;
        }
        if (Util.isNullOrNil(((EnterpriseBizContactListView.e)localObject).username))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194864);
          return;
        }
        boolean bool1 = com.tencent.mm.al.g.Nh(((EnterpriseBizContactListView.e)localObject).username);
        boolean bool2 = com.tencent.mm.al.g.DQ(((EnterpriseBizContactListView.e)localObject).username);
        com.tencent.mm.api.c localc = com.tencent.mm.al.g.fJ(((EnterpriseBizContactListView.e)localObject).username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.UJ())
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
          AppMethodBeat.o(194864);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", ((EnterpriseBizContactListView.e)localObject).username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.br.c.f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/EnterpriseBizContactListView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194864);
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
          AppMethodBeat.i(194865);
          if (EnterpriseBizContactListView.c(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.c(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.c localc = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.d(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.e(EnterpriseBizContactListView.this);
          if (localc.ppm == null)
          {
            localObject = (EnterpriseBizContactListView)localc.ppn.get();
            if (localObject == null)
            {
              AppMethodBeat.o(194865);
              return false;
            }
            localc.ppm = new com.tencent.mm.ui.widget.f(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.e)))
          {
            AppMethodBeat.o(194865);
            return false;
          }
          localc.ppl = ((EnterpriseBizContactListView.e)localObject).username;
          if ((Util.isNullOrNil(localc.ppl)) || (com.tencent.mm.al.g.DQ(localc.ppl)))
          {
            AppMethodBeat.o(194865);
            return false;
          }
          localc.ppm.QSr = paramAnonymousView;
          localc.ppm.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.c.1(localc, paramAnonymousInt), new EnterpriseBizContactListView.c.2(localc), i, j);
          AppMethodBeat.o(194865);
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
      this.ppd = ((int)paramMotionEvent.getRawX());
      this.ppe = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public int getContactCount()
  {
    return this.ppa;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local4 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(194866);
        long l = Util.currentTicks();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        EnterpriseBizContactListView.e locale;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493995, null);
          locale = new EnterpriseBizContactListView.e();
          locale.pnP = ((TextView)paramAnonymousView.findViewById(2131298244));
          locale.contentView = paramAnonymousView.findViewById(2131299189);
          locale.gvv = ((ImageView)paramAnonymousView.findViewById(2131296772));
          locale.pps = ((ImageView)paramAnonymousView.findViewById(2131305356));
          locale.gvw = ((TextView)paramAnonymousView.findViewById(2131297734));
          locale.ppt = paramAnonymousView.findViewById(2131307573);
          paramAnonymousView.setTag(locale);
        }
        qw localqw;
        for (;;)
        {
          localqw = (qw)paramAnonymousd.data;
          if (localqw != null) {
            break;
          }
          Log.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(194866);
          return paramAnonymousView;
          locale = (EnterpriseBizContactListView.e)paramAnonymousView.getTag();
        }
        paramAnonymousInt = 0;
        if (localqw.Bdk.UH()) {
          paramAnonymousInt = 1;
        }
        if ((EnterpriseBizContactListView.this.OZW) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.Pae.equals("!2"))
          {
            locale.pnP.setText(EnterpriseBizContactListView.this.getContext().getString(2131758748));
            locale.pnP.setVisibility(0);
            locale.ppr = null;
            if (paramAnonymousInt == 0) {
              break label512;
            }
            locale.username = localqw.userName;
            locale.gvv.setImageResource(2131690156);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(2131758728);
            EnterpriseBizContactListView.a(locale.gvw, localContext, paramAnonymousd, (int)locale.gvw.getTextSize());
            label302:
            Log.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localqw.Bdk.field_status) });
            paramAnonymousd = locale.pps;
            if (localqw.Bdk.field_status != 1) {
              break label691;
            }
            paramAnonymousInt = 0;
            label347:
            paramAnonymousd.setVisibility(paramAnonymousInt);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label697;
            }
            locale.ppt.setBackground(null);
            label376:
            if (!EnterpriseBizContactListView.this.OZX) {
              break label711;
            }
            locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165188), locale.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          Log.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          AppMethodBeat.o(194866);
          return paramAnonymousView;
          if (!paramAnonymousd.Pae.equals("!1"))
          {
            locale.pnP.setText(paramAnonymousd.Pae);
            locale.pnP.setVisibility(0);
            break;
          }
          locale.pnP.setVisibility(8);
          break;
          label512:
          if (((localqw instanceof EnterpriseBizContactListView.b)) && (((EnterpriseBizContactListView.b)localqw).ppj))
          {
            locale.ppr = ((EnterpriseBizContactListView.b)localqw).ppk;
            locale.iconUrl = locale.ppr.qGB;
            com.tencent.mm.av.q.bcV().a(locale.iconUrl, locale.gvv, EnterpriseBizEntranceListUI.d.S(localContext, 2131690156));
            EnterpriseBizContactListView.a(locale.gvw, localContext, locale.ppr.AOv, (int)locale.gvw.getTextSize());
            break label302;
          }
          locale.username = localqw.userName;
          locale.iconUrl = localqw.Bdk.field_brandIconURL;
          locale.gvv.setTag(localqw.userName);
          a.b.c(locale.gvv, locale.username);
          paramAnonymousd = localqw.contact.arJ();
          EnterpriseBizContactListView.a(locale.gvw, localContext, paramAnonymousd, (int)locale.gvw.getTextSize());
          break label302;
          label691:
          paramAnonymousInt = 8;
          break label347;
          label697:
          locale.ppt.setBackgroundResource(2131233327);
          break label376;
          label711:
          locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165534), locale.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5715);
    return local4;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5713);
    this.krb = ((ListView)findViewById(2131303242));
    ListView localListView = this.krb;
    AppMethodBeat.o(5713);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(5714);
    TextView localTextView = (TextView)findViewById(2131305459);
    localTextView.setText(2131758742);
    AppMethodBeat.o(5714);
    return localTextView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(5712);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131307882);
    AppMethodBeat.o(5712);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(5711);
    View localView = View.inflate(getContext(), 2131493998, this);
    AppMethodBeat.o(5711);
    return localView;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5716);
    if (this.ppb != null) {
      this.ppb.clY();
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
    if (this.poZ != null) {
      this.poZ.Da(this.ppa);
    }
    hy(localList);
    super.refresh();
    AppMethodBeat.o(5705);
  }
  
  public void setEmptyListener(a parama)
  {
    this.poZ = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.poY = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.poQ = paramString;
  }
  
  public void setFixedBrandServiceItem(List<b> paramList)
  {
    this.ppg = paramList;
  }
  
  public void setOnTouchListener(d paramd)
  {
    this.ppb = paramd;
  }
  
  public static abstract interface a
  {
    public abstract void Da(int paramInt);
  }
  
  public static final class b
    extends qw
  {
    private static ewv ppi;
    public boolean ppj = false;
    public ewv ppk = ppi;
    
    static
    {
      AppMethodBeat.i(194868);
      ppi = new ewv();
      AppMethodBeat.o(194868);
    }
    
    public static b cmb()
    {
      AppMethodBeat.i(194867);
      b localb = new b();
      localb.contact = new as();
      localb.Bdk = new com.tencent.mm.api.c();
      AppMethodBeat.o(194867);
      return localb;
    }
  }
  
  static final class c
    implements i
  {
    public String ppl;
    com.tencent.mm.ui.widget.f ppm;
    WeakReference<EnterpriseBizContactListView> ppn;
    com.tencent.mm.ui.base.q tipDialog;
    
    public c(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.ppn = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.g.azz().b(1394, this);
      super.finalize();
      AppMethodBeat.o(5702);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
        paramString = ((com.tencent.mm.plugin.profile.b.d)paramq).eDZ();
        Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramq).eDY();
        if ((localObject == null) || (((efn)localObject).KTz == null) || (((efn)localObject).KTz.ret != 0))
        {
          if ((localObject != null) && (((efn)localObject).KTz != null))
          {
            Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(((efn)localObject).KTz.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          Log.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramq.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.neT)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramq = com.tencent.mm.al.g.fJ(paramString.KTt);
        paramq.field_brandFlag |= 0x1;
        localObject = new cpe();
        ((cpe)localObject).kem = paramq.field_brandFlag;
        ((cpe)localObject).UserName = paramString.KTt;
        ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new k.a(47, (com.tencent.mm.bw.a)localObject));
        ag.bah().update(paramq, new String[0]);
        ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjW(paramq.field_username);
        if (((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkk(paramq.field_enterpriseFather) <= 0) {
          ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjW(paramq.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.ppn.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class)).aSS().biO(paramq.field_enterpriseFather);
        }
        paramString.refresh();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean clY();
  }
  
  public static final class e
  {
    public View contentView;
    ImageView gvv;
    TextView gvw;
    String iconUrl;
    public TextView pnP;
    ewv ppr;
    ImageView pps;
    View ppt;
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