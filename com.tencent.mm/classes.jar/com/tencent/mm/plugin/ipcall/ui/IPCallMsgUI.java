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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IPCallMsgUI
  extends MMActivity
{
  private a DWx;
  private MStorage.IOnStorageChange DWy;
  private ListView list;
  private View sxR;
  private View tzj;
  private boolean tzk;
  
  public IPCallMsgUI()
  {
    AppMethodBeat.i(25824);
    this.tzk = true;
    this.DWy = new MStorage.IOnStorageChange()
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
    return R.i.eib;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25827);
    setMMTitle(R.l.eJG);
    this.sxR = findViewById(R.h.dKc);
    this.list = ((ListView)findViewById(R.h.dKd));
    this.tzj = ad.kS(this).inflate(R.i.mm_footerview, null);
    this.list.addFooterView(this.tzj);
    this.DWx = new a(this, new g());
    this.DWx.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(25805);
        int i = IPCallMsgUI.a(IPCallMsgUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(25805);
        return i;
      }
    });
    this.DWx.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(25806);
        IPCallMsgUI.a(IPCallMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(25806);
      }
    });
    this.DWx.a(new v.a()
    {
      public final void bxN()
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
    this.list.setAdapter(this.DWx);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25808);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = (g)IPCallMsgUI.b(IPCallMsgUI.this).getItem(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.field_descUrl))
        {
          paramAnonymousInt = paramAnonymousAdapterView.field_msgType;
          com.tencent.mm.plugin.report.service.h.IzE.a(13780, new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_descUrl);
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.by.c.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
          if (paramAnonymousAbsListView.cJI()) {
            if (IPCallMsgUI.d(paramAnonymousAbsListView.DWz).getParent() != null) {
              IPCallMsgUI.a(paramAnonymousAbsListView.DWz).removeFooterView(IPCallMsgUI.d(paramAnonymousAbsListView.DWz));
            }
          }
          for (;;)
          {
            IPCallMsgUI.b(IPCallMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(25809);
            return;
            paramAnonymousAbsListView.tzm += 10;
            if (paramAnonymousAbsListView.tzm > paramAnonymousAbsListView.jlf) {
              paramAnonymousAbsListView.tzm = paramAnonymousAbsListView.jlf;
            }
          }
        }
        AppMethodBeat.o(25809);
      }
    });
    if (this.DWx.getCount() == 0)
    {
      this.list.setVisibility(8);
      this.sxR.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.DWx.cJI()) {
        this.list.removeFooterView(this.tzj);
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
      if (this.DWx.cJI()) {
        this.list.removeFooterView(this.tzj);
      }
      AppMethodBeat.o(25827);
      return;
      this.list.setVisibility(0);
      this.sxR.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25825);
    super.onCreate(paramBundle);
    i.eJz().add(this.DWy);
    initView();
    AppMethodBeat.o(25825);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25826);
    Log.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    i.eJz().remove(this.DWy);
    this.DWx.eKd();
    com.tencent.mm.plugin.ipcall.model.h.h localh = i.eJz();
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
    extends v<g>
  {
    private Set<MMSlideDelView> DWB;
    int jlf;
    protected MMSlideDelView.g snh;
    protected MMSlideDelView.c sni;
    protected MMSlideDelView.d snk;
    int tzm;
    
    public a(Context paramContext, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(25817);
      this.DWB = new HashSet();
      this.snk = new MMSlideDelView.d()
      {
        public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25813);
          if (paramAnonymousBoolean)
          {
            DWB.add(paramAnonymousMMSlideDelView);
            AppMethodBeat.o(25813);
            return;
          }
          DWB.remove(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(25813);
        }
        
        public final boolean eKl()
        {
          AppMethodBeat.i(25814);
          if (DWB.size() > 0)
          {
            AppMethodBeat.o(25814);
            return true;
          }
          AppMethodBeat.o(25814);
          return false;
        }
        
        public final void eKm()
        {
          AppMethodBeat.i(25815);
          Iterator localIterator = DWB.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.hJY();
            }
          }
          DWB.clear();
          AppMethodBeat.o(25815);
        }
        
        public final void eKn()
        {
          AppMethodBeat.i(25816);
          Iterator localIterator = DWB.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.hJX();
            }
          }
          DWB.clear();
          AppMethodBeat.o(25816);
        }
      };
      this.tzm = 10;
      this.jlf = this.tzm;
      AppMethodBeat.o(25817);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(25821);
      this.jlf = i.eJz().getCount();
      v(i.eJz().Vo(this.tzm));
      notifyDataSetChanged();
      AppMethodBeat.o(25821);
    }
    
    public final void ats()
    {
      AppMethodBeat.i(25819);
      eKd();
      atr();
      AppMethodBeat.o(25819);
    }
    
    public final boolean cJI()
    {
      return this.tzm >= this.jlf;
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
        localView = ad.kS(this.context).inflate(R.i.eia, null);
        paramViewGroup = new a();
        paramViewGroup.titleTv = ((TextView)localView.findViewById(R.h.titleTv));
        paramViewGroup.kMh = ((TextView)localView.findViewById(R.h.dCH));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(R.h.timeTv));
        localView.setTag(paramViewGroup);
        paramViewGroup.titleTv.setText(localg.field_title);
        paramViewGroup.kMh.setText(localg.field_content);
        TextView localTextView = paramViewGroup.timeTv;
        paramView = IPCallMsgUI.this.getContext();
        l1 = localg.field_pushTime * 1000L;
        localObject1 = new GregorianCalendar();
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
        localObject1 = (String)DateFormat.format(paramView.getString(R.l.fmt_date), l1);
        if (((String)localObject1).indexOf("-") <= 0) {
          break label377;
        }
        localObject2 = localObject1.split("-")[0];
        localObject1 = localObject1.split("-")[1];
        localObject2 = com.tencent.mm.plugin.ipcall.a.c.br(paramView, (String)localObject2);
        localObject1 = (String)localObject1 + " " + (String)localObject2 + " ";
        paramView = (String)localObject1 + " " + (String)com.tencent.mm.plugin.ipcall.a.c.k(paramView, l1);
        label313:
        localTextView.setText(paramView);
        if (localg.field_isRead != 1) {
          break label536;
        }
        paramInt = 1;
        label330:
        if (paramInt == 0) {
          break label541;
        }
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(R.e.dkw));
      }
      for (;;)
      {
        AppMethodBeat.o(25822);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label377:
        long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = (String)com.tencent.mm.plugin.ipcall.a.c.k(paramView, l1);
          break label313;
        }
        l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = paramView.getString(R.l.fmt_pre_yesterday) + " " + (String)com.tencent.mm.plugin.ipcall.a.c.k(paramView, l1);
          break label313;
        }
        paramView = (String)localObject1 + " " + (String)com.tencent.mm.plugin.ipcall.a.c.k(paramView, l1);
        break label313;
        label536:
        paramInt = 0;
        break label330;
        label541:
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(R.e.dkx));
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
      this.sni = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.snh = paramg;
    }
    
    final class a
    {
      TextView kMh;
      TextView timeTv;
      TextView titleTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI
 * JD-Core Version:    0.7.0.1
 */