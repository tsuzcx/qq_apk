package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
{
  Context context;
  private String fUg;
  private aq mHandler;
  private boolean mIsInit;
  MMHorList voS;
  a voT;
  private int voU;
  f.c voV;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.fUg = "";
    this.mHandler = new aq(Looper.getMainLooper());
    this.voV = null;
    this.context = paramContext;
    this.voS = ((MMHorList)paramView);
    this.fUg = paramString;
    djA();
    AppMethodBeat.o(55905);
  }
  
  private void ah(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.voZ) {
        localb.djD();
      }
    }
    this.voU = a.fromDPToPix(this.context, 60);
    this.voS.setOverScrollEnabled(true);
    this.voS.setItemWidth(this.voU);
    this.voS.setCenterInParent(true);
    this.voS.setOnItemClickListener(new f.1(this));
    this.voT = new a(paramArrayList);
    this.voS.setAdapter(this.voT);
    AppMethodBeat.o(55907);
  }
  
  private void apI(String paramString)
  {
    AppMethodBeat.i(55908);
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.voT.apM(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.voT;
    locala.voY.add(paramString);
    locala.notifyDataSetChanged();
    this.voS.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void apJ(String paramString)
  {
    AppMethodBeat.i(55909);
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.voT.apM(paramString))
    {
      locala = this.voT;
      i = 0;
      if (i >= locala.voY.size()) {
        break label108;
      }
      if (!((b)locala.voY.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.voY.remove(i);
        locala.notifyDataSetChanged();
      }
      this.voS.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void djA()
  {
    AppMethodBeat.i(55906);
    Object localObject = n.djh().Hl(this.fUg);
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bu.isNullOrNil(str))
      {
        localArrayList1.add(new b(str));
        localArrayList2.add(str);
      }
    }
    ah(localArrayList1);
    ai(localArrayList2);
    this.voS.invalidate();
    this.voT.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.voT.djC();
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
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[] { Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList1.size()) });
    if (localArrayList2.size() > 0)
    {
      paramArrayList = localArrayList2.iterator();
      while (paramArrayList.hasNext()) {
        apI((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        apJ((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void apK(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.voT.apM(paramString))
    {
      this.voT.apL(paramString).djD();
      this.voT.notifyDataSetChanged();
      this.voS.invalidate();
      if ((this.voS.getIsTouching()) || (bu.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.voT;
      i = 0;
      if (i >= locala.voY.size()) {
        break label244;
      }
      if (!((b)locala.voY.get(i)).username.equals(paramString)) {
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
      ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      int m;
      if (j != -1)
      {
        m = j * this.voU;
        i = this.voS.getCurrentPosition();
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
              ae.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[] { Integer.valueOf(i) });
              f.this.voS.acQ(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.voU * 3) {
            break label239;
          }
          i = m - this.voU * 3;
          break label173;
        }
        i = 0;
      }
    }
  }
  
  public final void djB()
  {
    AppMethodBeat.i(55911);
    a locala = this.voT;
    Iterator localIterator = locala.voY.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).djE();
    }
    locala.notifyDataSetChanged();
    this.voS.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> voY;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.voY = new ArrayList();
      Collection localCollection;
      this.voY.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b apL(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.voY.size())
      {
        if (((f.b)this.voY.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.voY.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean apM(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.voY.size())
      {
        if (((f.b)this.voY.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> djC()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.voY.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.voY.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.voY.get(paramInt);
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
      paramView = ((f.b)this.voY.get(paramInt)).vpa.vpb;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    String username;
    private LinearLayout.LayoutParams uwV;
    boolean voZ;
    a vpa;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.voZ = false;
      this.username = paramString;
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.vpa = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.vpa.vpb = ((RelativeLayout)f.this.inflate(2131494599, null));
      this.vpa.iZn = ((ImageView)this.vpa.vpb.findViewById(2131296996));
      a.b.d(this.vpa.iZn, this.username);
      this.vpa.vpb.setTag(this.username);
      this.uwV = new LinearLayout.LayoutParams(-2, -2);
      this.uwV.leftMargin = BackwardSupportUtil.b.h(f.this.context, 5.0F);
      this.uwV.rightMargin = BackwardSupportUtil.b.h(f.this.context, 5.0F);
      this.uwV.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void djD()
    {
      AppMethodBeat.i(55903);
      ae.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.vpa.vpb.setBackgroundResource(2131232903);
      this.vpa.vpb.invalidate();
      this.voZ = true;
      AppMethodBeat.o(55903);
    }
    
    public final void djE()
    {
      AppMethodBeat.i(55904);
      ae.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.vpa.vpb.setBackgroundResource(2131232902);
      this.vpa.vpb.invalidate();
      this.voZ = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      ImageView iZn;
      RelativeLayout vpb;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */