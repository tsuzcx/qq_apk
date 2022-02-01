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
import com.tencent.mm.am.e;
import com.tencent.mm.am.n.a;
import com.tencent.mm.api.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView
  extends BaseSortView
{
  private ListView iwH;
  private int mUB = -1;
  private c mUC;
  private b mUD;
  private int mUE = 0;
  private int mUF = 0;
  private String mUt;
  private boolean mUy;
  private a mUz;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(5708);
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.am.af.awe();
    Cursor localCursor = e.L(this.mUt, this.mUy);
    while (localCursor.moveToNext())
    {
      oh localoh = new oh();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new com.tencent.mm.storage.af();
        ((com.tencent.mm.storage.af)localObject).convertFrom(localCursor);
        c localc = new c();
        localc.convertFrom(localCursor);
        localoh.userName = ((au)localObject).field_username;
        localoh.contact = ((com.tencent.mm.storage.af)localObject);
        localoh.uzN = localc;
      }
      if (localoh.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localoh;
        if (localoh.uzN.Jg()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localoh.contact.ZS())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = "!2";
          }
          else
          {
            int j = localoh.contact.Zh();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    this.mUB = localArrayList.size();
    Collections.sort(localArrayList, new e((byte)0));
    AppMethodBeat.o(5708);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(5709);
    com.tencent.mm.am.af.awo().avU();
    AppMethodBeat.o(5709);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(5710);
    if ((!bt.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (oh)paramd.data;
      if (localObject == null)
      {
        AppMethodBeat.o(5710);
        return false;
      }
      paramd = ((oh)localObject).contact.ZX();
      String str = ((oh)localObject).contact.Sv();
      localObject = ((oh)localObject).contact.Sw();
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
  
  public final void bCA()
  {
    AppMethodBeat.i(5707);
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5694);
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof EnterpriseBizContactListView.d)))
        {
          AppMethodBeat.o(5694);
          return;
        }
        EnterpriseBizContactListView.d locald = (EnterpriseBizContactListView.d)paramAnonymousAdapterView;
        if (bt.isNullOrNil(locald.username))
        {
          AppMethodBeat.o(5694);
          return;
        }
        boolean bool1 = com.tencent.mm.am.f.wM(locald.username);
        boolean bool2 = com.tencent.mm.am.f.pc(locald.username);
        c localc = com.tencent.mm.am.f.ei(locald.username);
        if (localc == null) {}
        for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localc.Ji())
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
          paramAnonymousAdapterView.putExtra("srcUsername", locald.username);
          paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
          paramAnonymousAdapterView.addFlags(67108864);
          com.tencent.mm.bs.d.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
          EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 2);
          AppMethodBeat.o(5694);
          return;
        }
        if (bool2)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Contact_User", locald.username);
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
          com.tencent.mm.bs.d.e(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
          AppMethodBeat.o(5694);
          return;
        }
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.addFlags(67108864);
        paramAnonymousAdapterView.putExtra("finish_direct", true);
        paramAnonymousAdapterView.putExtra("Chat_User", locald.username);
        paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
        b.d(paramAnonymousAdapterView, EnterpriseBizContactListView.this.getContext());
        EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, localc, 1);
        AppMethodBeat.o(5694);
      }
    });
    if (getMode() == 0) {
      setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(5695);
          if (EnterpriseBizContactListView.a(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.b(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.b localb = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.b(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          if (localb.mUI == null)
          {
            localObject = (EnterpriseBizContactListView)localb.mUJ.get();
            if (localObject == null)
            {
              AppMethodBeat.o(5695);
              return false;
            }
            localb.mUI = new com.tencent.mm.ui.widget.f(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.d)))
          {
            AppMethodBeat.o(5695);
            return false;
          }
          localb.mUH = ((EnterpriseBizContactListView.d)localObject).username;
          if ((bt.isNullOrNil(localb.mUH)) || (com.tencent.mm.am.f.pc(localb.mUH)))
          {
            AppMethodBeat.o(5695);
            return false;
          }
          localb.mUI.HIt = paramAnonymousView;
          localb.mUI.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.b.1(localb, paramAnonymousInt), new EnterpriseBizContactListView.b.2(localb), i, j);
          AppMethodBeat.o(5695);
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
      this.mUE = ((int)paramMotionEvent.getRawX());
      this.mUF = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5706);
    return bool;
  }
  
  public int getContactCount()
  {
    return this.mUB;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5715);
    c.a local3 = new c.a()
    {
      public final View a(com.tencent.mm.ui.base.sortview.d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(5696);
        long l = bt.GC();
        Context localContext = EnterpriseBizContactListView.this.getContext();
        EnterpriseBizContactListView.d locald;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493840, null);
          locald = new EnterpriseBizContactListView.d();
          locald.mTt = ((TextView)paramAnonymousView.findViewById(2131297925));
          locald.contentView = paramAnonymousView.findViewById(2131298746);
          locald.frr = ((ImageView)paramAnonymousView.findViewById(2131296683));
          locald.mUN = ((ImageView)paramAnonymousView.findViewById(2131302787));
          locald.frs = ((TextView)paramAnonymousView.findViewById(2131297508));
          locald.mUO = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(locald);
        }
        oh localoh;
        for (;;)
        {
          localoh = (oh)paramAnonymousd.data;
          if (localoh != null) {
            break;
          }
          ad.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
          AppMethodBeat.o(5696);
          return paramAnonymousView;
          locald = (EnterpriseBizContactListView.d)paramAnonymousView.getTag();
        }
        paramAnonymousInt = 0;
        if (localoh.uzN.Jg()) {
          paramAnonymousInt = 1;
        }
        if ((EnterpriseBizContactListView.this.Ggu) && (paramAnonymousBoolean1)) {
          if (paramAnonymousd.GgC.equals("!2"))
          {
            locald.mTt.setText(EnterpriseBizContactListView.this.getContext().getString(2131758450));
            locald.mTt.setVisibility(0);
            if (paramAnonymousInt == 0) {
              break label509;
            }
            locald.username = localoh.userName;
            locald.frr.setImageResource(2131690123);
            paramAnonymousd = EnterpriseBizContactListView.this.getResources().getString(2131758431);
            EnterpriseBizContactListView.a(locald.frs, localContext, paramAnonymousd, (int)locald.frs.getTextSize());
            label298:
            ad.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localoh.uzN.field_status) });
            paramAnonymousd = locald.mUN;
            if (localoh.uzN.field_status != 1) {
              break label590;
            }
            paramAnonymousInt = 0;
            label343:
            paramAnonymousd.setVisibility(paramAnonymousInt);
            if ((EnterpriseBizContactListView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
              break label596;
            }
            locald.mUO.setBackground(null);
            label372:
            if (!EnterpriseBizContactListView.this.Ggv) {
              break label610;
            }
            locald.contentView.setPadding(locald.contentView.getPaddingLeft(), locald.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165185), locald.contentView.getPaddingBottom());
          }
        }
        for (;;)
        {
          ad.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(bt.aS(l)) });
          AppMethodBeat.o(5696);
          return paramAnonymousView;
          if (!paramAnonymousd.GgC.equals("!1"))
          {
            locald.mTt.setText(paramAnonymousd.GgC);
            locald.mTt.setVisibility(0);
            break;
          }
          locald.mTt.setVisibility(8);
          break;
          label509:
          locald.username = localoh.userName;
          locald.iconUrl = localoh.uzN.field_brandIconURL;
          locald.frr.setTag(localoh.userName);
          a.b.c(locald.frr, locald.username);
          paramAnonymousd = localoh.contact.ZX();
          EnterpriseBizContactListView.a(locald.frs, localContext, paramAnonymousd, (int)locald.frs.getTextSize());
          break label298;
          label590:
          paramAnonymousInt = 8;
          break label343;
          label596:
          locald.mUO.setBackgroundResource(2131232867);
          break label372;
          label610:
          locald.contentView.setPadding(locald.contentView.getPaddingLeft(), locald.contentView.getPaddingTop(), (int)EnterpriseBizContactListView.this.getContext().getResources().getDimension(2131165516), locald.contentView.getPaddingBottom());
        }
      }
    };
    AppMethodBeat.o(5715);
    return local3;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(5713);
    this.iwH = ((ListView)findViewById(2131301457));
    ListView localListView = this.iwH;
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
    if (this.mUC != null) {
      this.mUC.bCz();
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
    if (this.mUz != null) {
      this.mUz.xL(this.mUB);
    }
    ga(localList);
    super.refresh();
    AppMethodBeat.o(5705);
  }
  
  public void setEmptyListener(a parama)
  {
    this.mUz = parama;
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.mUy = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.mUt = paramString;
  }
  
  public void setOnTouchListener(c paramc)
  {
    this.mUC = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void xL(int paramInt);
  }
  
  static final class b
    implements com.tencent.mm.al.g
  {
    public String mUH;
    com.tencent.mm.ui.widget.f mUI;
    WeakReference<EnterpriseBizContactListView> mUJ;
    com.tencent.mm.ui.base.p tipDialog;
    
    public b(EnterpriseBizContactListView paramEnterpriseBizContactListView)
    {
      AppMethodBeat.i(5701);
      this.mUJ = new WeakReference(paramEnterpriseBizContactListView);
      AppMethodBeat.o(5701);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(5702);
      com.tencent.mm.kernel.g.aeS().b(1394, this);
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
        paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dcg();
        Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dcf();
        if ((localObject == null) || (((dae)localObject).CIW == null) || (((dae)localObject).CIW.ret != 0))
        {
          if ((localObject != null) && (((dae)localObject).CIW != null))
          {
            ad.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dae)localObject).CIW.ret) });
            AppMethodBeat.o(5703);
            return;
          }
          ad.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
          AppMethodBeat.o(5703);
          return;
        }
        if (!paramString.kRX)
        {
          AppMethodBeat.o(5703);
          return;
        }
        paramn = com.tencent.mm.am.f.ei(paramString.CIQ);
        paramn.field_brandFlag |= 0x1;
        localObject = new bqc();
        ((bqc)localObject).ika = paramn.field_brandFlag;
        ((bqc)localObject).mAQ = paramString.CIQ;
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new j.a(47, (a)localObject));
        com.tencent.mm.am.af.awe().update(paramn, new String[0]);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIl(paramn.field_username);
        if (((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIy(paramn.field_enterpriseFather) <= 0) {
          ((k)com.tencent.mm.kernel.g.ab(k.class)).apR().aIl(paramn.field_enterpriseFather);
        }
        for (;;)
        {
          paramString = (EnterpriseBizContactListView)this.mUJ.get();
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(5703);
          return;
          ((com.tencent.mm.am.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.p.class)).apQ().aHp(paramn.field_enterpriseFather);
        }
        paramString.refresh();
      }
      AppMethodBeat.o(5703);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean bCz();
  }
  
  public static final class d
  {
    public View contentView;
    ImageView frr;
    TextView frs;
    String iconUrl;
    public TextView mTt;
    ImageView mUN;
    View mUO;
    String username;
  }
  
  final class e
    implements Comparator<com.tencent.mm.ui.base.sortview.d>
  {
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView
 * JD-Core Version:    0.7.0.1
 */