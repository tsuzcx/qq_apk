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
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.h.h;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
import java.util.Set;

public class IPCallMsgUI
  extends MMActivity
{
  private ListView list;
  private View nYl;
  private View oIW;
  private boolean oIX;
  private a uSh;
  private k.a uSi;
  
  public IPCallMsgUI()
  {
    AppMethodBeat.i(25824);
    this.oIX = true;
    this.uSi = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(25812);
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(25811);
            synchronized (IPCallMsgUI.b(IPCallMsgUI.this))
            {
              ad.v("MicroMsg.IPCallMsgUI", "comment notify");
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
    this.nYl = findViewById(2131301126);
    this.list = ((ListView)findViewById(2131301127));
    this.oIW = z.jO(this).inflate(2131494788, null);
    this.list.addFooterView(this.oIW);
    this.uSh = new a(this, new com.tencent.mm.plugin.ipcall.model.h.g());
    this.uSh.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(25805);
        int i = IPCallMsgUI.a(IPCallMsgUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(25805);
        return i;
      }
    });
    this.uSh.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(25806);
        IPCallMsgUI.a(IPCallMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(25806);
      }
    });
    this.uSh.a(new r.a()
    {
      public final void aSs()
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
    this.list.setAdapter(this.uSh);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25808);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/ipcall/ui/IPCallMsgUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = (com.tencent.mm.plugin.ipcall.model.h.g)IPCallMsgUI.b(IPCallMsgUI.this).getItem(paramAnonymousInt);
        if (!bt.isNullOrNil(paramAnonymousAdapterView.field_descUrl))
        {
          paramAnonymousInt = paramAnonymousAdapterView.field_msgType;
          com.tencent.mm.plugin.report.service.g.yhR.f(13780, new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView.field_descUrl);
          paramAnonymousView.putExtra("showShare", false);
          d.b(IPCallMsgUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
          if (paramAnonymousAbsListView.bXb()) {
            if (IPCallMsgUI.d(paramAnonymousAbsListView.uSj).getParent() != null) {
              IPCallMsgUI.a(paramAnonymousAbsListView.uSj).removeFooterView(IPCallMsgUI.d(paramAnonymousAbsListView.uSj));
            }
          }
          for (;;)
          {
            IPCallMsgUI.b(IPCallMsgUI.this).a(null, null);
            AppMethodBeat.o(25809);
            return;
            paramAnonymousAbsListView.oIZ += 10;
            if (paramAnonymousAbsListView.oIZ > paramAnonymousAbsListView.fTM) {
              paramAnonymousAbsListView.oIZ = paramAnonymousAbsListView.fTM;
            }
          }
        }
        AppMethodBeat.o(25809);
      }
    });
    if (this.uSh.getCount() == 0)
    {
      this.list.setVisibility(8);
      this.nYl.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.uSh.bXb()) {
        this.list.removeFooterView(this.oIW);
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
      if (this.uSh.bXb()) {
        this.list.removeFooterView(this.oIW);
      }
      AppMethodBeat.o(25827);
      return;
      this.list.setVisibility(0);
      this.nYl.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25825);
    super.onCreate(paramBundle);
    i.ddP().add(this.uSi);
    initView();
    AppMethodBeat.o(25825);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25826);
    ad.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    i.ddP().remove(this.uSi);
    this.uSh.det();
    h localh = i.ddP();
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
    extends r<com.tencent.mm.plugin.ipcall.model.h.g>
  {
    int fTM;
    protected MMSlideDelView.g nUw;
    protected MMSlideDelView.c nUx;
    protected MMSlideDelView.d nUz;
    int oIZ;
    private Set<MMSlideDelView> uSl;
    
    public a(Context paramContext, com.tencent.mm.plugin.ipcall.model.h.g paramg)
    {
      super(paramg);
      AppMethodBeat.i(25817);
      this.uSl = new HashSet();
      this.nUz = new IPCallMsgUI.a.1(this);
      this.oIZ = 10;
      this.fTM = this.oIZ;
      AppMethodBeat.o(25817);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(25821);
      this.fTM = i.ddP().getCount();
      setCursor(i.ddP().IE(this.oIZ));
      notifyDataSetChanged();
      AppMethodBeat.o(25821);
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(25819);
      det();
      Zu();
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
    
    public final boolean bXb()
    {
      return this.oIZ >= this.fTM;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(25818);
      long l = ((com.tencent.mm.plugin.ipcall.model.h.g)getItem(paramInt)).systemRowid;
      AppMethodBeat.o(25818);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(25822);
      com.tencent.mm.plugin.ipcall.model.h.g localg = (com.tencent.mm.plugin.ipcall.model.h.g)getItem(paramInt);
      View localView;
      long l1;
      Object localObject1;
      Object localObject2;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = z.jO(this.context).inflate(2131494516, null);
        paramViewGroup = new a();
        paramViewGroup.titleTv = ((TextView)localView.findViewById(2131305906));
        paramViewGroup.hca = ((TextView)localView.findViewById(2131298745));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131305812));
        localView.setTag(paramViewGroup);
        paramViewGroup.titleTv.setText(localg.field_title);
        paramViewGroup.hca.setText(localg.field_content);
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
        localObject2 = c.aQ(paramView, (String)localObject2);
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
      this.nUx = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.nUw = paramg;
    }
    
    final class a
    {
      TextView hca;
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