package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IPCallMsgUI
  extends MMActivity
{
  private a JNG;
  private MStorage.IOnStorageChange JNH;
  private ListView list;
  private View vDA;
  private View wDF;
  private boolean wDG;
  
  public IPCallMsgUI()
  {
    AppMethodBeat.i(25824);
    this.wDG = true;
    this.JNH = new MStorage.IOnStorageChange()
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
    return R.i.gkW;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25827);
    setMMTitle(R.l.gLn);
    this.vDA = findViewById(R.h.fLw);
    this.list = ((ListView)findViewById(R.h.fLx));
    this.wDF = af.mU(this).inflate(R.i.mm_footerview, null);
    this.list.addFooterView(this.wDF);
    this.JNG = new a(this, new g());
    this.JNG.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(25805);
        int i = IPCallMsgUI.a(IPCallMsgUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(25805);
        return i;
      }
    });
    this.JNG.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(25806);
        IPCallMsgUI.a(IPCallMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(25806);
      }
    });
    this.JNG.a(new x.a()
    {
      public final void bWC()
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
    this.list.setAdapter(this.JNG);
    this.list.setOnItemClickListener(new IPCallMsgUI.4(this));
    this.list.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(25809);
        if (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1)
        {
          paramAnonymousAbsListView = IPCallMsgUI.b(IPCallMsgUI.this);
          if (paramAnonymousAbsListView.dmY()) {
            if (IPCallMsgUI.d(paramAnonymousAbsListView.JNI).getParent() != null) {
              IPCallMsgUI.a(paramAnonymousAbsListView.JNI).removeFooterView(IPCallMsgUI.d(paramAnonymousAbsListView.JNI));
            }
          }
          for (;;)
          {
            IPCallMsgUI.b(IPCallMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(25809);
            return;
            paramAnonymousAbsListView.wDI += 10;
            if (paramAnonymousAbsListView.wDI > paramAnonymousAbsListView.lNX) {
              paramAnonymousAbsListView.wDI = paramAnonymousAbsListView.lNX;
            }
          }
        }
        AppMethodBeat.o(25809);
      }
    });
    if (this.JNG.getCount() == 0)
    {
      this.list.setVisibility(8);
      this.vDA.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (this.JNG.dmY()) {
        this.list.removeFooterView(this.wDF);
      }
      setBackBtn(new IPCallMsgUI.6(this));
      if (this.JNG.dmY()) {
        this.list.removeFooterView(this.wDF);
      }
      AppMethodBeat.o(25827);
      return;
      this.list.setVisibility(0);
      this.vDA.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25825);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.ipcall.model.h.fRz().add(this.JNH);
    initView();
    AppMethodBeat.o(25825);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25826);
    Log.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
    com.tencent.mm.plugin.ipcall.model.h.fRz().remove(this.JNH);
    this.JNG.fSd();
    com.tencent.mm.plugin.ipcall.model.h.h localh = com.tencent.mm.plugin.ipcall.model.h.fRz();
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
    extends x<g>
  {
    private Set<MMSlideDelView> JNK;
    int lNX;
    protected MMSlideDelView.g vzf;
    protected MMSlideDelView.c vzg;
    protected MMSlideDelView.d vzi;
    int wDI;
    
    public a(Context paramContext, g paramg)
    {
      super(paramg);
      AppMethodBeat.i(25817);
      this.JNK = new HashSet();
      this.vzi = new MMSlideDelView.d()
      {
        public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25813);
          if (paramAnonymousBoolean)
          {
            JNK.add(paramAnonymousMMSlideDelView);
            AppMethodBeat.o(25813);
            return;
          }
          JNK.remove(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(25813);
        }
        
        public final boolean fSl()
        {
          AppMethodBeat.i(25814);
          if (JNK.size() > 0)
          {
            AppMethodBeat.o(25814);
            return true;
          }
          AppMethodBeat.o(25814);
          return false;
        }
        
        public final void fSm()
        {
          AppMethodBeat.i(25815);
          Iterator localIterator = JNK.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.jmE();
            }
          }
          JNK.clear();
          AppMethodBeat.o(25815);
        }
        
        public final void fSn()
        {
          AppMethodBeat.i(25816);
          Iterator localIterator = JNK.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.jmD();
            }
          }
          JNK.clear();
          AppMethodBeat.o(25816);
        }
      };
      this.wDI = 10;
      this.lNX = this.wDI;
      AppMethodBeat.o(25817);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(25821);
      this.lNX = com.tencent.mm.plugin.ipcall.model.h.fRz().getCount();
      w(com.tencent.mm.plugin.ipcall.model.h.fRz().Zj(this.wDI));
      notifyDataSetChanged();
      AppMethodBeat.o(25821);
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(25819);
      fSd();
      aNy();
      AppMethodBeat.o(25819);
    }
    
    public final boolean dmY()
    {
      return this.wDI >= this.lNX;
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
        localView = af.mU(this.context).inflate(R.i.gkV, null);
        paramViewGroup = new a();
        paramViewGroup.titleTv = ((TextView)localView.findViewById(R.h.titleTv));
        paramViewGroup.noc = ((TextView)localView.findViewById(R.h.fDw));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(R.h.timeTv));
        localView.setTag(paramViewGroup);
        paramViewGroup.titleTv.setText(localg.field_title);
        paramViewGroup.noc.setText(localg.field_content);
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
        localObject2 = c.bt(paramView, (String)localObject2);
        localObject1 = (String)localObject1 + " " + (String)localObject2 + " ";
        paramView = (String)localObject1 + " " + (String)c.l(paramView, l1);
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
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(R.e.fkE));
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
          paramView = (String)c.l(paramView, l1);
          break label313;
        }
        l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramView = paramView.getString(R.l.fmt_pre_yesterday) + " " + (String)c.l(paramView, l1);
          break label313;
        }
        paramView = (String)localObject1 + " " + (String)c.l(paramView, l1);
        break label313;
        label536:
        paramInt = 0;
        break label330;
        label541:
        paramViewGroup.titleTv.setTextColor(IPCallMsgUI.this.getResources().getColor(R.e.fkF));
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
      this.vzg = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.vzf = paramg;
    }
    
    final class a
    {
      TextView noc;
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