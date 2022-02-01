package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
{
  Context context;
  private String fvg;
  private ap mHandler;
  private boolean mIsInit;
  MMHorList sRL;
  a sRM;
  private int sRN;
  c sRO;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.fvg = "";
    this.mHandler = new ap(Looper.getMainLooper());
    this.sRO = null;
    this.context = paramContext;
    this.sRL = ((MMHorList)paramView);
    this.fvg = paramString;
    cJK();
    AppMethodBeat.o(55905);
  }
  
  private void X(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.sRS) {
        localb.cJN();
      }
    }
    this.sRN = a.fromDPToPix(this.context, 60);
    this.sRL.setOverScrollEnabled(true);
    this.sRL.setItemWidth(this.sRN);
    this.sRL.setCenterInParent(true);
    this.sRL.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(55893);
        paramAnonymousAdapterView = (String)paramAnonymousView.getTag();
        if (!bt.isNullOrNil(paramAnonymousAdapterView))
        {
          h.vKh.f(10997, new Object[] { "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          if (f.this.sRO != null) {
            f.this.sRO.afb(paramAnonymousAdapterView);
          }
        }
        AppMethodBeat.o(55893);
      }
    });
    this.sRM = new a(paramArrayList);
    this.sRL.setAdapter(this.sRM);
    AppMethodBeat.o(55907);
  }
  
  private void aeW(String paramString)
  {
    AppMethodBeat.i(55908);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.sRM.afa(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.sRM;
    locala.sRR.add(paramString);
    locala.notifyDataSetChanged();
    this.sRL.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void aeX(String paramString)
  {
    AppMethodBeat.i(55909);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.sRM.afa(paramString))
    {
      locala = this.sRM;
      i = 0;
      if (i >= locala.sRR.size()) {
        break label108;
      }
      if (!((b)locala.sRR.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.sRR.remove(i);
        locala.notifyDataSetChanged();
      }
      this.sRL.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void cJK()
  {
    AppMethodBeat.i(55906);
    Object localObject = n.cJr().zz(this.fvg);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bt.isNullOrNil(str))
      {
        localArrayList1.add(new b(str));
        localArrayList2.add(str);
      }
    }
    X(localArrayList1);
    Y(localArrayList2);
    this.sRL.invalidate();
    this.sRM.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void Y(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.sRM.cJM();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (((ArrayList)localObject1).indexOf(str) == -1) {
        localArrayList2.add(str);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (paramArrayList.indexOf(localObject2) == -1) {
        localArrayList1.add(localObject2);
      }
    }
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[] { Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList1.size()) });
    if (localArrayList2.size() > 0)
    {
      paramArrayList = localArrayList2.iterator();
      while (paramArrayList.hasNext()) {
        aeW((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        aeX((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void aeY(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.sRM.afa(paramString))
    {
      this.sRM.aeZ(paramString).cJN();
      this.sRM.notifyDataSetChanged();
      this.sRL.invalidate();
      if ((this.sRL.getIsTouching()) || (bt.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.sRM;
      i = 0;
      if (i >= locala.sRR.size()) {
        break label244;
      }
      if (!((b)locala.sRR.get(i)).username.equals(paramString)) {
        break label203;
      }
    }
    label173:
    label203:
    label210:
    label239:
    label244:
    for (int j = i;; j = -1)
    {
      ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      int m;
      if (j != -1)
      {
        m = j * this.sRN;
        i = this.sRL.getCurrentPosition();
        if (m >= i) {
          break label210;
        }
      }
      for (;;)
      {
        if (j == 0) {
          i = k;
        }
        for (;;)
        {
          this.mHandler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(55894);
              ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[] { Integer.valueOf(i) });
              f.this.sRL.XO(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.sRN * 3) {
            break label239;
          }
          i = m - this.sRN * 3;
          break label173;
        }
        i = 0;
      }
    }
  }
  
  public final void cJL()
  {
    AppMethodBeat.i(55911);
    a locala = this.sRM;
    Iterator localIterator = locala.sRR.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cJO();
    }
    locala.notifyDataSetChanged();
    this.sRL.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> sRR;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.sRR = new ArrayList();
      Collection localCollection;
      this.sRR.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b aeZ(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.sRR.size())
      {
        if (((f.b)this.sRR.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.sRR.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean afa(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.sRR.size())
      {
        if (((f.b)this.sRR.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> cJM()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.sRR.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.sRR.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.sRR.get(paramInt);
      AppMethodBeat.o(55897);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(55898);
      paramView = ((f.b)this.sRR.get(paramInt)).sRT.sRU;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    boolean sRS;
    a sRT;
    private LinearLayout.LayoutParams sfh;
    String username;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.sRS = false;
      this.username = paramString;
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.sRT = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.sRT.sRU = ((RelativeLayout)f.this.inflate(2131494599, null));
      this.sRT.ida = ((ImageView)this.sRT.sRU.findViewById(2131296996));
      a.b.d(this.sRT.ida, this.username);
      this.sRT.sRU.setTag(this.username);
      this.sfh = new LinearLayout.LayoutParams(-2, -2);
      this.sfh.leftMargin = BackwardSupportUtil.b.g(f.this.context, 5.0F);
      this.sfh.rightMargin = BackwardSupportUtil.b.g(f.this.context, 5.0F);
      this.sfh.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void cJN()
    {
      AppMethodBeat.i(55903);
      ad.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.sRT.sRU.setBackgroundResource(2131232903);
      this.sRT.sRU.invalidate();
      this.sRS = true;
      AppMethodBeat.o(55903);
    }
    
    public final void cJO()
    {
      AppMethodBeat.i(55904);
      ad.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.sRT.sRU.setBackgroundResource(2131232902);
      this.sRT.sRU.invalidate();
      this.sRS = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      ImageView ida;
      RelativeLayout sRU;
      
      a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void afb(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */