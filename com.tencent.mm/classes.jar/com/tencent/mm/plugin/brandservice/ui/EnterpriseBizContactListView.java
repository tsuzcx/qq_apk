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
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.n.a;
import com.tencent.mm.api.c;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
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
  private ListView iWK;
  private String nwL;
  private boolean nwT;
  private a nwU;
  private int nwV;
  private d nwW;
  private c nwX;
  private int nwY;
  private int nwZ;
  private final EnterpriseBizEntranceListUI.a nxa;
  private List<b> nxb;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198644);
    this.nwV = -1;
    this.nwY = 0;
    this.nwZ = 0;
    this.nxa = new EnterpriseBizEntranceListUI.a(new EnterpriseBizEntranceListUI.a.a()
    {
      public final String bJE()
      {
        AppMethodBeat.i(198638);
        String str = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
        AppMethodBeat.o(198638);
        return str;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(198637);
        Context localContext = EnterpriseBizContactListView.this.getContext();
        AppMethodBeat.o(198637);
        return localContext;
      }
    });
    AppMethodBeat.o(198644);
  }
  
  private void ce(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(198645);
    if (this.nxb == null)
    {
      AppMethodBeat.o(198645);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.nxb.size());
    Iterator localIterator = this.nxb.iterator();
    while (localIterator.hasNext())
    {
      oo localoo = (oo)localIterator.next();
      com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
      locald.data = localoo;
      locald.HGs = "!1";
      localArrayList.add(locald);
    }
    paramList.addAll(0, localArrayList);
    AppMethodBeat.o(198645);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    af.aCW();
    Cursor localCursor = e.M(this.nwL, this.nwT);
    while (localCursor.moveToNext())
    {
      b localb = new b();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new ai();
        ((ai)localObject).convertFrom(localCursor);
        c localc = new c();
        localc.convertFrom(localCursor);
        localb.userName = ((av)localObject).field_username;
        localb.contact = ((ai)localObject);
        localb.vIG = localc;
      }
      if (localb.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localb;
        if (localb.vIG.IP()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localb.contact.aaN())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = "!2";
          }
          else
          {
            int j = localb.contact.aac();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    ce(localArrayList);
    this.nwV = localArrayList.size();
    Collections.sort(localArrayList, new f((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    af.aDg().aCM();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!bs.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (oo)paramd.data;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((oo)localObject).contact.aaS();
      String str = ((oo)localObject).contact.To();
      localObject = ((oo)localObject).contact.Tp();
      paramString = paramString.toUpperCase();
      if (((!bs.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bs.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5710);
        return true;
      }
    }
    AppMethodBeat.o(5710);
    return false;
  }
  
  public final void bJD()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(198639);
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.e)))
        {
          AppMethodBeat.o(198639);
          return;
        }
        EnterpriseBizContactListView.e locale = (EnterpriseBizContactListView.e)paramAnonymousAdapterView;
        if (locale.nxm != null)
        {
          EnterpriseBizContactListView.b(EnterpriseBizContactListView.this).a(locale.nxm);
          AppMethodBeat.o(198639);
          return;
        }
        if (bs.isNullOrNil(locale.username))
        {
          AppMethodBeat.o(198639);
          return;
        }
        boolean bool1 = com.tencent.mm.al.f.AS(locale.username);
        boolean bool2 = com.tencent.mm.al.f.so(locale.username);
        c localc = com.tencent.mm.al.f.dX(locale.username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.IR())
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
          paramAnonymousAdapterView.putExtra("srcUsername", locale.username);
          paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
          paramAnonymousAdapterView.addFlags(67108864);
          com.tencent.mm.br.d.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 2);
          AppMethodBeat.o(198639);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", locale.username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.br.d.e(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
          AppMethodBeat.o(198639);
          return;
        }
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.addFlags(67108864);
        paramAnonymousAdapterView.putExtra("finish_direct", true);
        paramAnonymousAdapterView.putExtra("Chat_User", locale.username);
        paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
        b.d(paramAnonymousAdapterView, EnterpriseBizContactListView.this.getContext());
        EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 1);
        AppMethodBeat.o(198639);
      }
    });
    if (getMode() == 0) {
      setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(198640);
          if (EnterpriseBizContactListView.c(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.c(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.c localc = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.d(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.e(EnterpriseBizContactListView.this);
          if (localc.nxh == null)
          {
            localObject = (EnterpriseBizContactListView)localc.nxi.get();
            if (localObject == null)
            {
              AppMethodBeat.o(198640);
              return false;
            }
            localc.nxh = new com.tencent.mm.ui.widget.f(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.e)))
          {
            AppMethodBeat.o(198640);
            return false;
          }
          localc.nxg = ((EnterpriseBizContactListView.e)localObject).username;
          if ((bs.isNullOrNil(localc.nxg)) || (com.tencent.mm.al.f.so(localc.nxg)))
          {
            AppMethodBeat.o(198640);
            return false;
          }
          localc.nxh.JiQ = paramAnonymousView;
          localc.nxh.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.c.1(localc, paramAnonymousInt), new EnterpriseBizContactListView.c.2(localc), i, j);
          AppMethodBeat.o(198640);
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
      this.nwY = ((int)paramMotionEvent.getRawX());
      this.nwZ = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public int getContactCount()
  {
    return this.nwV;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local4 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(198641);
        long l = bs.Gn();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        EnterpriseBizContactListView.e locale;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493840, null);
          locale = new EnterpriseBizContactListView.e();
          locale.nvL = ((TextView)paramAnonymousView.findViewById(2131297925));
          locale.contentView = paramAnonymousView.findViewById(2131298746);
          locale.fuY = ((ImageView)paramAnonymousView.findViewById(2131296683));
          locale.nxn = ((ImageView)paramAnonymousView.findViewById(2131302787));
          locale.fuZ = ((TextView)paramAnonymousView.findViewById(2131297508));
          locale.nxo = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(locale);
        }
        oo localoo;
        for (;;)
        {
          localoo = (oo)paramAnonymousd.data;
          if (localoo != null) {
            break;
          }
          ac.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(198641);
          return paramAnonymousView;
          locale = (EnterpriseBizContactListView.e)paramAnonymousView.getTag();
        }
        paramAnonymousInt = 0;
        if (localoo.vIG.IP()) {
          paramAnonymousInt = 1;
        }
        if ((EnterpriseBizContactListView.this.HGk) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.HGs.equals("!2"))
          {
            locale.nvL.setText(EnterpriseBizContactListView.this.getContext().getString(2131758450));
            locale.nvL.setVisibility(0);
            locale.nxm = null;
            if (paramAnonymousInt == 0) {
              break label512;
            }
            locale.username = localoo.userName;
            locale.fuY.setImageResource(2131690123);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(2131758431);
            EnterpriseBizContactListView.a(locale.fuZ, localContext, paramAnonymousd, (int)locale.fuZ.getTextSize());
            label302:
            ac.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localoo.vIG.field_status) });
            paramAnonymousd = locale.nxn;
            if (localoo.vIG.field_status != 1) {
              break label691;
            }
            paramAnonymousInt = 0;
            label347:
            paramAnonymousd.setVisibility(paramAnonymousInt);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label697;
            }
            locale.nxo.setBackground(null);
            label376:
            if (!EnterpriseBizContactListView.this.HGl) {
              break label711;
            }
            locale.contentView.setPadding(locale.contentView.getPaddingLeft(), locale.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165185), locale.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          ac.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
          AppMethodBeat.o(198641);
          return paramAnonymousView;
          if (!paramAnonymousd.HGs.equals("!1"))
          {
            locale.nvL.setText(paramAnonymousd.HGs);
            locale.nvL.setVisibility(0);
            break;
          }
          locale.nvL.setVisibility(8);
          break;
          label512:
          if (((localoo instanceof EnterpriseBizContactListView.b)) && (((EnterpriseBizContactListView.b)localoo).nxe))
          {
            locale.nxm = ((EnterpriseBizContactListView.b)localoo).nxf;
            locale.iconUrl = locale.nxm.oGN;
            o.aFB().a(locale.iconUrl, locale.fuY, EnterpriseBizEntranceListUI.d.M(localContext, 2131690123));
            EnterpriseBizContactListView.a(locale.fuZ, localContext, locale.nxm.vxw, (int)locale.fuZ.getTextSize());
            break label302;
          }
          locale.username = localoo.userName;
          locale.iconUrl = localoo.vIG.field_brandIconURL;
          locale.fuY.setTag(localoo.userName);
          a.b.c(locale.fuY, locale.username);
          paramAnonymousd = localoo.contact.aaS();
          EnterpriseBizContactListView.a(locale.fuZ, localContext, paramAnonymousd, (int)locale.fuZ.getTextSize());
          break label302;
          label691:
          paramAnonymousInt = 8;
          break label347;
          label697:
          locale.nxo.setBackgroundResource(2131232867);
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
    this.iWK = ((ListView)findViewById(2131301457));
    ListView localListView = this.iWK;
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
    if (this.nwW != null) {
      this.nwW.bJC();
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
    if (this.nwU != null) {
      this.nwU.yC(this.nwV);
    }
    gh(localList);
    super.refresh();
    AppMethodBeat.o(5705);
  }
  
  public void setEmptyListener(a parama)
  {
    this.nwU = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.nwT = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.nwL = paramString;
  }
  
  public void setFixedBrandServiceItem(List<b> paramList)
  {
    this.nxb = paramList;
  }
  
  public void setOnTouchListener(d paramd)
  {
    this.nwW = paramd;
  }
  
  public static abstract interface a
  {
    public abstract void yC(int paramInt);
  }
  
  public static final class b
    extends oo
  {
    private static dvc nxd;
    public boolean nxe = false;
    public dvc nxf = nxd;
    
    static
    {
      AppMethodBeat.i(198643);
      nxd = new dvc();
      AppMethodBeat.o(198643);
    }
    
    public static b bJF()
    {
      AppMethodBeat.i(198642);
      b localb = new b();
      localb.contact = new ai();
      localb.vIG = new c();
      AppMethodBeat.o(198642);
      return localb;
    }
  }
  
  static final class c
    implements com.tencent.mm.ak.g
  {
    public String nxg;
    com.tencent.mm.ui.widget.f nxh;
    WeakReference<EnterpriseBizContactListView> nxi;
    com.tencent.mm.ui.base.p tipDialog;
    
    public c(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.nxi = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.g.agi().b(1394, this);
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
        paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dpO();
        Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dpN();
        if ((localObject == null) || (((dfq)localObject).Eby == null) || (((dfq)localObject).Eby.ret != 0))
        {
          if ((localObject != null) && (((dfq)localObject).Eby != null))
          {
            ac.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dfq)localObject).Eby.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          ac.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.ltx)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramn = com.tencent.mm.al.f.dX(paramString.Ebs);
        paramn.field_brandFlag |= 0x1;
        localObject = new but();
        ((but)localObject).iKh = paramn.field_brandFlag;
        ((but)localObject).ncR = paramString.Ebs;
        ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new j.a(47, (com.tencent.mm.bw.a)localObject));
        af.aCW().update(paramn, new String[0]);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNG(paramn.field_username);
        if (((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNU(paramn.field_enterpriseFather) <= 0) {
          ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNG(paramn.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.nxi.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((com.tencent.mm.al.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.p.class)).awF().aMJ(paramn.field_enterpriseFather);
        }
        paramString.refresh();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean bJC();
  }
  
  public static final class e
  {
    public View contentView;
    ImageView fuY;
    TextView fuZ;
    String iconUrl;
    public TextView nvL;
    dvc nxm;
    ImageView nxn;
    View nxo;
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