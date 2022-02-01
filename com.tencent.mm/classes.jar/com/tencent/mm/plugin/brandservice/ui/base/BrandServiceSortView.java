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
import com.tencent.mm.al.af;
import com.tencent.mm.al.n.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.f.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.widget.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, f.a, BaseSortView.a
{
  private boolean ahM;
  private String lhM;
  private int mServiceType;
  private boolean nwE;
  private int nwY;
  private int nwZ;
  private HashMap<String, SpannableString> nyk;
  private com.tencent.mm.plugin.brandservice.b.f nyl;
  private a nym;
  private boolean nyn;
  private ListView nyo;
  private a nyp;
  private String nyq;
  private View nyr;
  private TextView nys;
  private n.d nyt;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5799);
    this.nyk = new HashMap();
    this.nyl = new com.tencent.mm.plugin.brandservice.b.f();
    this.mServiceType = 251658241;
    this.nwY = 0;
    this.nwZ = 0;
    this.nyt = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(5797);
        if (bs.isNullOrNil(BrandServiceSortView.d(BrandServiceSortView.this)))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(5797);
          return;
        }
        if (paramAnonymousMenuItem.getItemId() == 0)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(BrandServiceSortView.d(BrandServiceSortView.this));
          com.tencent.mm.api.c localc = com.tencent.mm.al.f.dX(BrandServiceSortView.d(BrandServiceSortView.this));
          BrandServiceSortView.a(BrandServiceSortView.this, localc, BrandServiceSortView.this.getContext(), localai, paramAnonymousMenuItem.getGroupId());
        }
        AppMethodBeat.o(5797);
      }
    };
    setDataSetObserver(this);
    this.nyn = false;
    setShowFooterView(false);
    refresh();
    paramContext = this.nyl;
    if (!paramContext.nvi.contains(this))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.nvi.add(this);
    }
    this.nym = new a(getContext());
    setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(5795);
        paramAnonymousAdapterView = paramAnonymousView.getTag();
        if ((paramAnonymousAdapterView == null) || (!(paramAnonymousAdapterView instanceof BrandServiceSortView.b)))
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
          AppMethodBeat.o(5795);
          return;
        }
        paramAnonymousView = (BrandServiceSortView.b)paramAnonymousAdapterView;
        if (bs.isNullOrNil(paramAnonymousView.username))
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
          AppMethodBeat.o(5795);
          return;
        }
        ad.aAy(paramAnonymousView.username);
        com.tencent.mm.ui.contact.ac.u(BrandServiceSortView.a(BrandServiceSortView.this), 12, 4, paramAnonymousInt - 1);
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
        paramAnonymousView = new Intent().putExtra("Chat_User", paramAnonymousView);
        paramAnonymousView.putExtra("finish_direct", true);
        paramAnonymousView.putExtra("chat_from_scene", 2);
        paramAnonymousView.putExtra("specific_chat_from_scene", 4);
        paramAnonymousView.putExtra("img_gallery_enter_from_chatting_ui", true);
        b.iyx.d(paramAnonymousView, paramAnonymousAdapterView);
        AppMethodBeat.o(5795);
      }
    });
    setOnItemLongClickListener(this);
    AppMethodBeat.o(5799);
  }
  
  private static List<d> cg(List<oo> paramList)
  {
    AppMethodBeat.i(5801);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        oo localoo = (oo)paramList.get(i);
        d locald;
        int j;
        if ((localoo != null) && (localoo.contact != null))
        {
          locald = new d();
          locald.data = localoo;
          int k = localoo.contact.field_showHead;
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
        for (locald.HGs = ((char)j);; locald.HGs = "#")
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
    if ((!bs.isNullOrNil(paramString)) && (paramd != null))
    {
      this.nyq = paramString;
      paramd = (oo)paramd.data;
      if ((paramd == null) || (paramd.contact == null))
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(5803);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((ai)localObject).aaS();
      String str = ((ai)localObject).To();
      localObject = ((ai)localObject).Tp();
      paramString = paramString.toUpperCase();
      if (((!bs.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bs.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(5803);
        return true;
      }
    }
    AppMethodBeat.o(5803);
    return false;
  }
  
  public final void ch(List<d> paramList)
  {
    AppMethodBeat.i(5813);
    if ((this.nys != null) && (paramList != null)) {
      this.nys.setText(getContext().getString(2131756736, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(5813);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5810);
    if (paramMotionEvent.getAction() == 0)
    {
      this.nwY = ((int)paramMotionEvent.getRawX());
      this.nwZ = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(5810);
    return bool;
  }
  
  public a getITransferToChildOnTouchListener()
  {
    return this.nyp;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(5808);
    c.a local2 = new c.a()
    {
      public final View a(d paramAnonymousd, View paramAnonymousView, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(5796);
        long l = bs.Gn();
        Context localContext = BrandServiceSortView.this.getContext();
        BrandServiceSortView.b localb;
        if (paramAnonymousView == null)
        {
          paramAnonymousView = LayoutInflater.from(localContext).inflate(2131493240, null);
          localb = new BrandServiceSortView.b();
          localb.nvL = ((TextView)paramAnonymousView.findViewById(2131297925));
          localb.contentView = paramAnonymousView.findViewById(2131298746);
          localb.fuY = ((ImageView)paramAnonymousView.findViewById(2131296683));
          localb.nxn = ((ImageView)paramAnonymousView.findViewById(2131302787));
          localb.fuZ = ((TextView)paramAnonymousView.findViewById(2131297508));
          localb.nxo = paramAnonymousView.findViewById(2131304545);
          paramAnonymousView.setTag(localb);
        }
        oo localoo;
        for (;;)
        {
          localoo = (oo)paramAnonymousd.data;
          if (localoo != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BrandServiceSortView", "should not be empty");
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb = (BrandServiceSortView.b)paramAnonymousView.getTag();
        }
        if ((BrandServiceSortView.this.HGk) && (paramAnonymousBoolean1))
        {
          localb.nvL.setText(paramAnonymousd.HGs);
          localb.nvL.setVisibility(0);
          localb.username = localoo.userName;
          localb.fuY.setTag(localoo.userName);
          a.b.d(localb.fuY, localb.username);
          paramAnonymousd = localoo.contact.aaS();
          BrandServiceSortView.a(BrandServiceSortView.this, localb.fuZ, localContext, paramAnonymousd, (int)localb.fuZ.getTextSize());
          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localoo.vIG.field_status) });
          paramAnonymousd = localb.nxn;
          if ((!BrandServiceSortView.c(BrandServiceSortView.this)) || (localoo.vIG.field_status != 1)) {
            break label461;
          }
          paramAnonymousInt = 0;
          label330:
          paramAnonymousd.setVisibility(paramAnonymousInt);
          if ((BrandServiceSortView.this.getMode() != 0) || (!paramAnonymousBoolean2)) {
            break label467;
          }
          localb.nxo.setBackgroundResource(2131231820);
          label360:
          if (!BrandServiceSortView.this.HGl) {
            break label480;
          }
          localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)BrandServiceSortView.this.getContext().getResources().getDimension(2131165185), localb.contentView.getPaddingBottom());
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
          AppMethodBeat.o(5796);
          return paramAnonymousView;
          localb.nvL.setVisibility(8);
          break;
          label461:
          paramAnonymousInt = 8;
          break label330;
          label467:
          localb.nxo.setBackgroundResource(2131232867);
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
    this.nyo = ((ListView)findViewById(2131301457));
    if (this.nyr == null)
    {
      this.nyr = inflate(getContext(), 2131493667, null);
      if ((this.nyo != null) && (this.nyr != null))
      {
        this.nys = ((TextView)this.nyr.findViewById(2131298799));
        this.nyo.addFooterView(this.nyr, null, false);
      }
    }
    ListView localListView = this.nyo;
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
      AppMethodBeat.o(5812);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
    if ((paramView == null) || (paramView.data == null))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(5812);
      return;
    }
    paramView = ((oo)paramView.data).contact;
    if (paramView == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(5812);
      return;
    }
    this.lhM = paramView.field_username;
    String str = paramView.aaS();
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), str));
    paramView = com.tencent.mm.al.f.dX(paramView.field_username);
    if ((paramView != null) && (!paramView.IM())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, 2131761049);
    }
    AppMethodBeat.o(5812);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(5815);
    if (this.nyp != null) {
      this.nyp.bJC();
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
    this.nym.JiQ = paramView;
    this.nym.a(paramAdapterView, paramInt, paramLong, this, this.nyt, this.nwY, this.nwZ);
    AppMethodBeat.o(5811);
    return true;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(5800);
    this.nyl.init();
    gh(cg(this.nyl.yx(this.mServiceType)));
    super.refresh();
    AppMethodBeat.o(5800);
  }
  
  public final void release()
  {
    AppMethodBeat.i(5802);
    if (g.agM()) {
      af.aDg().aCM();
    }
    this.nyl.release();
    AppMethodBeat.o(5802);
  }
  
  public void setITransferToChildOnTouchListener(a parama)
  {
    this.nyp = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.nwE = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(5814);
    this.ahM = paramBoolean;
    x(this.nys, paramBoolean);
    AppMethodBeat.o(5814);
  }
  
  public static abstract interface a
  {
    public abstract boolean bJC();
  }
  
  public static final class b
  {
    static Bitmap nyv = null;
    public View contentView;
    ImageView fuY;
    TextView fuZ;
    public TextView nvL;
    ImageView nxn;
    View nxo;
    String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */