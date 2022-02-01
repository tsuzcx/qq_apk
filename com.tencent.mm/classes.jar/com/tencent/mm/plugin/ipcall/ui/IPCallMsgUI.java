package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class IPCallMsgUI
  extends MMActivity
{
  private ListView list;
  private View poS;
  private View qdm;
  private boolean qdn;
  private a ywt;
  private MStorage.IOnStorageChange ywu;
  
  public IPCallMsgUI()
  {
    AppMethodBeat.i(25824);
    this.qdn = true;
    this.ywu = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(25812);
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25811);
            synchronized (IPCallMsgUI.b(IPCallMsgUI.this))
            {
              Log.v("MicroMsg.IPCallMsgUI", "comment notify");
              IPCallMsgUI.b(IPCallMsgUI.this).onNotifyChange(null, null);
              AppMethodBeat.o(25811);
              return;
            }
          }
        });
        AppMethodBeat.o(25812);
      }
    };
    AppMethodBeat.o(25824);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495109;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25827);
    setMMTitle(2131761970);
    this.poS = findViewById(2131302780);
    this.list = ((ListView)findViewById(2131302781));
    this.qdm = aa.jQ(this).inflate(2131495522, null);
    this.list.addFooterView(this.qdm);
    this.ywt = new a(this, new g());
    this.ywt.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(25805);
        int i = IPCallMsgUI.a(IPCallMsgUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(25805);
        return i;
      }
    });
    this.ywt.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(25806);
        IPCallMsgUI.a(IPCallMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(25806);
      }
    });
    this.ywt.a(new s.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(25807);
        if (IPCallMsgUI.b(IPCallMsgUI.this).getCount() == 0)
        {
          IPCallMsgUI.a(IPCallMsgUI.this).setVisibility(8);
          IPCallMsgUI.c(IPCallMsgUI.this).setVisibility(0);
          AppMethodBeat.o(25807);
          return;
        }
        IPCallMsgUI.a(IPCallMsgUI.this).setVisibility(0);
        IPCallMsgUI.c(IPCallMsgUI.this).setVisibility(8);
        AppMethodBeat.o(25807);
      }
    });
    this.list.setAdapter(this.ywt);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25808);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = (g)IPCallMsgUI.b(IPCallMsgUI.this).getItem(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.field_descUrl))
        {
          paramAnonymousInt = paramAnonymousAdapterView.field_msgType;
          com.tencent.mm.plugin.report.service.h.CyF.a(13780, new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_descUrl);
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.c.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(25808);
      }
    });
    this.list.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(25809);
        if (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1)
        {
          paramAnonymousAbsListView = IPCallMsgUI.b(IPCallMsgUI.this);
          if (paramAnonymousAbsListView.cwg()) {
            if (IPCallMsgUI.d(paramAnonymousAbsListView.ywv).getParent() != null) {
              IPCallMsgUI.a(paramAnonymousAbsListView.ywv).removeFooterView(IPCallMsgUI.d(paramAnonymousAbsListView.ywv));
            }
          }
          for (;;)
          {
            IPCallMsgUI.b(IPCallMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(25809);
            return;
            paramAnonymousAbsListView.qdp += 10;
            if (paramAnonymousAbsListView.qdp > paramAnonymousAbsListView.gAZ) {
              paramAnonymousAbsListView.qdp = paramAnonymousAbsListView.gAZ;
            }
          }
        }
        AppMethodBeat.o(25809);
      }
    });
    if (this.ywt.getCount() == 0)
    {
      this.list.setVisibility(8);
      this.poS.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.ywt.cwg()) {
        this.list.removeFooterView(this.qdm);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(25810);
          IPCallMsgUI.this.finish();
          AppMethodBeat.o(25810);
          return true;
        }
      });
      if (this.ywt.cwg()) {
        this.list.removeFooterView(this.qdm);
      }
      AppMethodBeat.o(25827);
      return;
      this.list.setVisibility(0);
      this.poS.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25825);
    super.onCreate(paramBundle);
    i.eaB().add(this.ywu);
    initView();
    AppMethodBeat.o(25825);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25826);
    Log.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    i.eaB().remove(this.ywu);
    this.ywt.ebf();
    com.tencent.mm.plugin.ipcall.model.h.h localh = i.eaB();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isRead", Short.valueOf((short)1));
    localh.db.update(localh.getTableName(), localContentValues, "isRead!=? ", new String[] { "1" });
    super.onDestroy();
    AppMethodBeat.o(25826);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends s<g>
  {
    int gAZ;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb;
    int qdp;
    private Set<MMSlideDelView> ywx;
    
    public a(Context paramContext, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(25817);
      this.ywx = new HashSet();
      this.plb = new IPCallMsgUI.a.1(this);
      this.qdp = 10;
      this.gAZ = this.qdp;
      AppMethodBeat.o(25817);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(25821);
      this.gAZ = i.eaB().getCount();
      setCursor(i.eaB().Pf(this.qdp));
      notifyDataSetChanged();
      AppMethodBeat.o(25821);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(25819);
      ebf();
      anp();
      AppMethodBeat.o(25819);
    }
    
    public final boolean cwg()
    {
      return this.qdp >= this.gAZ;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(25818);
      long l = ((g)getItem(paramInt)).systemRowid;
      AppMethodBeat.o(25818);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25822);
      g localg = (g)getItem(paramInt);
      View localView;
      long l1;
      Object localObject1;
      Object localObject2;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = aa.jQ(this.context).inflate(2131495108, null);
        paramViewGroup = new a();
        paramViewGroup.titleTv = ((TextView)localView.findViewById(2131309199));
        paramViewGroup.hXC = ((TextView)localView.findViewById(2131299188));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131309090));
        localView.setTag(paramViewGroup);
        paramViewGroup.titleTv.setText(localg.field_title);
        paramViewGroup.hXC.setText(localg.field_content);
        TextView localTextView = paramViewGroup.timeTv;
        paramView = IPCallMsgUI.this.getContext();
        l1 = localg.field_pushTime * 1000L;
        localObject1 = new GregorianCalendar();
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
        localObject1 = (String)DateFormat.format(paramView.getString(2131760813), l1);
        if (((String)localObject1).indexOf("-") <= 0) {
          break label371;
        }
        localObject2 = localObject1.split("-")[0];
        localObject1 = localObject1.split("-")[1];
        localObject2 = com.tencent.mm.plugin.ipcall.a.c.bf(paramView, (String)localObject2);
        localObject1 = (String)localObject1 + " " + (String)localObject2 + " ";
        paramView = (String)localObject1 + " " + (String)com.tencent.mm.plugin.ipcall.a.c.j(paramView, l1);
        label308:
        localTextView.setText(paramView);
        if (localg.field_isRead != 1) {
          break label530;
        }
        paramInt = 1;
        label325:
        if (paramInt == 0) {
          break label535;
        }
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(2131100653));
      }
      for (;;)
      {
        AppMethodBeat.o(25822);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label371:
        long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = (String)com.tencent.mm.plugin.ipcall.a.c.j(paramView, l1);
          break label308;
        }
        l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = paramView.getString(2131760868) + " " + (String)com.tencent.mm.plugin.ipcall.a.c.j(paramView, l1);
          break label308;
        }
        paramView = (String)localObject1 + " " + (String)com.tencent.mm.plugin.ipcall.a.c.j(paramView, l1);
        break label308;
        label530:
        paramInt = 0;
        break label325;
        label535:
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(2131100654));
      }
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      try
      {
        AppMethodBeat.i(25820);
        super.onNotifyChange(paramString, paramMStorageEventData);
        AppMethodBeat.o(25820);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.pkZ = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.pkY = paramg;
    }
    
    final class a
    {
      TextView hXC;
      TextView timeTv;
      TextView titleTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI
 * JD-Core Version:    0.7.0.1
 */