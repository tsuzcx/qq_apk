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
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
import com.tencent.mm.ui.z;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IPCallMsgUI
  extends MMActivity
{
  private ListView list;
  private View nwN;
  private View ofD;
  private boolean ofE;
  private a tPu;
  private k.a tPv;
  
  public IPCallMsgUI()
  {
    AppMethodBeat.i(25824);
    this.ofE = true;
    this.tPv = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(25812);
        new ao(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25811);
            synchronized (IPCallMsgUI.b(IPCallMsgUI.this))
            {
              ac.v("MicroMsg.IPCallMsgUI", "comment notify");
              IPCallMsgUI.b(IPCallMsgUI.this).a(null, null);
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
    return 2131494517;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25827);
    setMMTitle(2131760525);
    this.nwN = findViewById(2131301126);
    this.list = ((ListView)findViewById(2131301127));
    this.ofD = z.jD(this).inflate(2131494788, null);
    this.list.addFooterView(this.ofD);
    this.tPu = new a(this, new g());
    this.tPu.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(25805);
        int i = IPCallMsgUI.a(IPCallMsgUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(25805);
        return i;
      }
    });
    this.tPu.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(25806);
        IPCallMsgUI.a(IPCallMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(25806);
      }
    });
    this.tPu.a(new r.a()
    {
      public final void aPg()
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
    this.list.setAdapter(this.tPu);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25808);
        paramAnonymousAdapterView = (g)IPCallMsgUI.b(IPCallMsgUI.this).getItem(paramAnonymousInt);
        if (!bs.isNullOrNil(paramAnonymousAdapterView.field_descUrl))
        {
          paramAnonymousInt = paramAnonymousAdapterView.field_msgType;
          com.tencent.mm.plugin.report.service.h.wUl.f(13780, new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_descUrl);
          paramAnonymousView.putExtra("showShare", false);
          d.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        }
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
          if (paramAnonymousAbsListView.bSw()) {
            if (IPCallMsgUI.d(paramAnonymousAbsListView.tPw).getParent() != null) {
              IPCallMsgUI.a(paramAnonymousAbsListView.tPw).removeFooterView(IPCallMsgUI.d(paramAnonymousAbsListView.tPw));
            }
          }
          for (;;)
          {
            IPCallMsgUI.b(IPCallMsgUI.this).a(null, null);
            AppMethodBeat.o(25809);
            return;
            paramAnonymousAbsListView.ofG += 10;
            if (paramAnonymousAbsListView.ofG > paramAnonymousAbsListView.fAw) {
              paramAnonymousAbsListView.ofG = paramAnonymousAbsListView.fAw;
            }
          }
        }
        AppMethodBeat.o(25809);
      }
    });
    if (this.tPu.getCount() == 0)
    {
      this.list.setVisibility(8);
      this.nwN.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.tPu.bSw()) {
        this.list.removeFooterView(this.ofD);
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
      if (this.tPu.bSw()) {
        this.list.removeFooterView(this.ofD);
      }
      AppMethodBeat.o(25827);
      return;
      this.list.setVisibility(0);
      this.nwN.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25825);
    super.onCreate(paramBundle);
    i.cUE().add(this.tPv);
    initView();
    AppMethodBeat.o(25825);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25826);
    ac.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    i.cUE().remove(this.tPv);
    this.tPu.cVi();
    com.tencent.mm.plugin.ipcall.model.h.h localh = i.cUE();
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
    extends r<g>
  {
    int fAw;
    protected MMSlideDelView.g ntA;
    protected MMSlideDelView.c ntB;
    protected MMSlideDelView.d ntD;
    int ofG;
    private Set<MMSlideDelView> tPy;
    
    public a(Context paramContext, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(25817);
      this.tPy = new HashSet();
      this.ntD = new MMSlideDelView.d()
      {
        public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25813);
          if (paramAnonymousBoolean)
          {
            tPy.add(paramAnonymousMMSlideDelView);
            AppMethodBeat.o(25813);
            return;
          }
          tPy.remove(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(25813);
        }
        
        public final boolean cVq()
        {
          AppMethodBeat.i(25814);
          if (tPy.size() > 0)
          {
            AppMethodBeat.o(25814);
            return true;
          }
          AppMethodBeat.o(25814);
          return false;
        }
        
        public final void cVr()
        {
          AppMethodBeat.i(25815);
          Iterator localIterator = tPy.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.fiI();
            }
          }
          tPy.clear();
          AppMethodBeat.o(25815);
        }
        
        public final void cVs()
        {
          AppMethodBeat.i(25816);
          Iterator localIterator = tPy.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.fiH();
            }
          }
          tPy.clear();
          AppMethodBeat.o(25816);
        }
      };
      this.ofG = 10;
      this.fAw = this.ofG;
      AppMethodBeat.o(25817);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(25821);
      this.fAw = i.cUE().getCount();
      setCursor(i.cUE().Hi(this.ofG));
      notifyDataSetChanged();
      AppMethodBeat.o(25821);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(25819);
      cVi();
      Xb();
      AppMethodBeat.o(25819);
    }
    
    public final void a(String paramString, m paramm)
    {
      try
      {
        AppMethodBeat.i(25820);
        super.a(paramString, paramm);
        AppMethodBeat.o(25820);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final boolean bSw()
    {
      return this.ofG >= this.fAw;
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
        localView = z.jD(this.context).inflate(2131494516, null);
        paramViewGroup = new a();
        paramViewGroup.titleTv = ((TextView)localView.findViewById(2131305906));
        paramViewGroup.gIq = ((TextView)localView.findViewById(2131298745));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131305812));
        localView.setTag(paramViewGroup);
        paramViewGroup.titleTv.setText(localg.field_title);
        paramViewGroup.gIq.setText(localg.field_content);
        TextView localTextView = paramViewGroup.timeTv;
        paramView = IPCallMsgUI.this.getContext();
        l1 = localg.field_pushTime * 1000L;
        localObject1 = new GregorianCalendar();
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
        localObject1 = (String)DateFormat.format(paramView.getString(2131759498), l1);
        if (((String)localObject1).indexOf("-") <= 0) {
          break label372;
        }
        localObject2 = localObject1.split("-")[0];
        localObject1 = localObject1.split("-")[1];
        localObject2 = c.aN(paramView, (String)localObject2);
        localObject1 = (String)localObject1 + " " + (String)localObject2 + " ";
        paramView = (String)localObject1 + " " + (String)c.m(paramView, l1);
        label308:
        localTextView.setText(paramView);
        if (localg.field_isRead != 1) {
          break label531;
        }
        paramInt = 1;
        label325:
        if (paramInt == 0) {
          break label536;
        }
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(2131100516));
      }
      for (;;)
      {
        AppMethodBeat.o(25822);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label372:
        long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = (String)c.m(paramView, l1);
          break label308;
        }
        l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = paramView.getString(2131759551) + " " + (String)c.m(paramView, l1);
          break label308;
        }
        paramView = (String)localObject1 + " " + (String)c.m(paramView, l1);
        break label308;
        label531:
        paramInt = 0;
        break label325;
        label536:
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(2131100517));
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.ntB = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.ntA = paramg;
    }
    
    final class a
    {
      TextView gIq;
      TextView timeTv;
      TextView titleTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI
 * JD-Core Version:    0.7.0.1
 */