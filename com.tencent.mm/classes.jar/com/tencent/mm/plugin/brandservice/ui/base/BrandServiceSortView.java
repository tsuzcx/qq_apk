package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.m.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.BaseSortView.a;
import com.tencent.mm.ui.widget.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BrandServiceSortView
  extends BaseSortView
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener, com.tencent.mm.plugin.brandservice.b.c.a, BaseSortView.a
{
  private boolean ZN;
  private String ikj;
  private boolean jTW;
  private int jUm;
  private int jUn;
  private HashMap<String, SpannableString> jVa;
  private c jVb;
  private int jVc;
  private a jVd;
  private boolean jVe;
  private ListView jVf;
  private BrandServiceSortView.a jVg;
  private String jVh;
  private View jVi;
  private TextView jVj;
  private n.d jVk;
  
  public BrandServiceSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(14062);
    this.jVa = new HashMap();
    this.jVb = new c();
    this.jVc = 251658241;
    this.jUm = 0;
    this.jUn = 0;
    this.jVk = new BrandServiceSortView.3(this);
    this.jVe = false;
    setShowFooterView(false);
    refresh();
    paramContext = this.jVb;
    if (!paramContext.jSL.contains(this))
    {
      ab.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
      paramContext.jSL.add(this);
    }
    this.jVd = new a(getContext());
    setDataSetObserver(this);
    setOnItemClickListener(new BrandServiceSortView.1(this));
    setOnItemLongClickListener(this);
    AppMethodBeat.o(14062);
  }
  
  private static List<com.tencent.mm.ui.base.sortview.d> aR(List<me> paramList)
  {
    AppMethodBeat.i(14064);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        me localme = (me)paramList.get(i);
        com.tencent.mm.ui.base.sortview.d locald;
        int j;
        if ((localme != null) && (localme.contact != null))
        {
          locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = localme;
          int k = localme.contact.field_showHead;
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
        for (locald.zsM = ((char)j);; locald.zsM = "#")
        {
          localArrayList.add(locald);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(14064);
      return localArrayList;
    }
    AppMethodBeat.o(14064);
    return null;
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(14066);
    if ((!bo.isNullOrNil(paramString)) && (paramd != null))
    {
      this.jVh = paramString;
      paramd = (me)paramd.data;
      if ((paramd == null) || (paramd.contact == null))
      {
        ab.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
        AppMethodBeat.o(14066);
        return false;
      }
      Object localObject = paramd.contact;
      paramd = ((ad)localObject).Of();
      String str = ((ad)localObject).Ht();
      localObject = ((ad)localObject).Hu();
      paramString = paramString.toUpperCase();
      if (((!bo.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bo.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(14066);
        return true;
      }
    }
    AppMethodBeat.o(14066);
    return false;
  }
  
  public final void aS(List<com.tencent.mm.ui.base.sortview.d> paramList)
  {
    AppMethodBeat.i(14076);
    if ((this.jVj != null) && (paramList != null)) {
      this.jVj.setText(getContext().getString(2131297810, new Object[] { Integer.valueOf(paramList.size()) }));
    }
    AppMethodBeat.o(14076);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(14073);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jUm = ((int)paramMotionEvent.getRawX());
      this.jUn = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(14073);
    return bool;
  }
  
  public BrandServiceSortView.a getITransferToChildOnTouchListener()
  {
    return this.jVg;
  }
  
  public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator()
  {
    AppMethodBeat.i(14071);
    BrandServiceSortView.2 local2 = new BrandServiceSortView.2(this);
    AppMethodBeat.o(14071);
    return local2;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(14069);
    this.jVf = ((ListView)findViewById(2131821736));
    if (this.jVi == null)
    {
      this.jVi = inflate(getContext(), 2130969279, null);
      if ((this.jVf != null) && (this.jVi != null))
      {
        this.jVj = ((TextView)this.jVi.findViewById(2131823263));
        this.jVf.addFooterView(this.jVi, null, false);
      }
    }
    ListView localListView = this.jVf;
    AppMethodBeat.o(14069);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(14070);
    View localView = findViewById(2131821961);
    AppMethodBeat.o(14070);
    return localView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(14068);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131821737);
    AppMethodBeat.o(14068);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(14067);
    View localView = View.inflate(getContext(), 2130968902, this);
    AppMethodBeat.o(14067);
    return localView;
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(14072);
    refresh();
    AppMethodBeat.o(14072);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(14075);
    if (paramContextMenuInfo == null)
    {
      ab.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
      AppMethodBeat.o(14075);
      return;
    }
    ab.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramView = (com.tencent.mm.ui.base.sortview.d)((AdapterView)paramView).getItemAtPosition(paramContextMenuInfo.position);
    if ((paramView == null) || (paramView.data == null))
    {
      ab.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[] { paramView });
      AppMethodBeat.o(14075);
      return;
    }
    paramView = ((me)paramView.data).contact;
    if (paramView == null)
    {
      ab.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
      AppMethodBeat.o(14075);
      return;
    }
    this.ikj = paramView.field_username;
    String str = paramView.Of();
    paramContextMenu.setHeaderTitle(j.b(getContext(), str));
    paramView = f.rS(paramView.field_username);
    if ((paramView != null) && (!paramView.aef())) {
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, 2131301402);
    }
    AppMethodBeat.o(14075);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(14078);
    if (this.jVg != null) {
      this.jVg.aWA();
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(14078);
      return true;
    }
    AppMethodBeat.o(14078);
    return false;
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(14074);
    this.jVd.AIF = paramView;
    this.jVd.a(paramAdapterView, paramInt, paramLong, this, this.jVk, this.jUm, this.jUn);
    AppMethodBeat.o(14074);
    return true;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(14063);
    this.jVb.init();
    dI(aR(this.jVb.rW(this.jVc)));
    super.refresh();
    AppMethodBeat.o(14063);
  }
  
  public final void release()
  {
    AppMethodBeat.i(14065);
    if (g.RG()) {
      z.afs().afc();
    }
    this.jVb.release();
    AppMethodBeat.o(14065);
  }
  
  public void setITransferToChildOnTouchListener(BrandServiceSortView.a parama)
  {
    this.jVg = parama;
  }
  
  public void setReturnResult(boolean paramBoolean)
  {
    this.jTW = paramBoolean;
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    AppMethodBeat.i(14077);
    this.ZN = paramBoolean;
    y(this.jVj, paramBoolean);
    AppMethodBeat.o(14077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView
 * JD-Core Version:    0.7.0.1
 */