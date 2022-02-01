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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
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
  private String fSa;
  private ap mHandler;
  private boolean mIsInit;
  MMHorList vcH;
  a vcI;
  private int vcJ;
  f.c vcK;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.fSa = "";
    this.mHandler = new ap(Looper.getMainLooper());
    this.vcK = null;
    this.context = paramContext;
    this.vcH = ((MMHorList)paramView);
    this.fSa = paramString;
    dgB();
    AppMethodBeat.o(55905);
  }
  
  private void ah(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.vcO) {
        localb.dgE();
      }
    }
    this.vcJ = a.fromDPToPix(this.context, 60);
    this.vcH.setOverScrollEnabled(true);
    this.vcH.setItemWidth(this.vcJ);
    this.vcH.setCenterInParent(true);
    this.vcH.setOnItemClickListener(new f.1(this));
    this.vcI = new a(paramArrayList);
    this.vcH.setAdapter(this.vcI);
    AppMethodBeat.o(55907);
  }
  
  private void aoD(String paramString)
  {
    AppMethodBeat.i(55908);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.vcI.aoH(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.vcI;
    locala.vcN.add(paramString);
    locala.notifyDataSetChanged();
    this.vcH.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void aoE(String paramString)
  {
    AppMethodBeat.i(55909);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.vcI.aoH(paramString))
    {
      locala = this.vcI;
      i = 0;
      if (i >= locala.vcN.size()) {
        break label108;
      }
      if (!((b)locala.vcN.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.vcN.remove(i);
        locala.notifyDataSetChanged();
      }
      this.vcH.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void dgB()
  {
    AppMethodBeat.i(55906);
    Object localObject = n.dgi().GJ(this.fSa);
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
    ah(localArrayList1);
    ai(localArrayList2);
    this.vcH.invalidate();
    this.vcI.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.vcI.dgD();
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
        aoD((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        aoE((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void aoF(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    ad.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.vcI.aoH(paramString))
    {
      this.vcI.aoG(paramString).dgE();
      this.vcI.notifyDataSetChanged();
      this.vcH.invalidate();
      if ((this.vcH.getIsTouching()) || (bt.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.vcI;
      i = 0;
      if (i >= locala.vcN.size()) {
        break label244;
      }
      if (!((b)locala.vcN.get(i)).username.equals(paramString)) {
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
        m = j * this.vcJ;
        i = this.vcH.getCurrentPosition();
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
              f.this.vcH.acj(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.vcJ * 3) {
            break label239;
          }
          i = m - this.vcJ * 3;
          break label173;
        }
        i = 0;
      }
    }
  }
  
  public final void dgC()
  {
    AppMethodBeat.i(55911);
    a locala = this.vcI;
    Iterator localIterator = locala.vcN.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).dgF();
    }
    locala.notifyDataSetChanged();
    this.vcH.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> vcN;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.vcN = new ArrayList();
      Collection localCollection;
      this.vcN.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b aoG(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.vcN.size())
      {
        if (((f.b)this.vcN.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.vcN.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean aoH(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.vcN.size())
      {
        if (((f.b)this.vcN.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> dgD()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.vcN.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.vcN.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.vcN.get(paramInt);
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
      paramView = ((f.b)this.vcN.get(paramInt)).vcP.vcQ;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    private LinearLayout.LayoutParams uly;
    String username;
    boolean vcO;
    a vcP;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.vcO = false;
      this.username = paramString;
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.vcP = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.vcP.vcQ = ((RelativeLayout)f.this.inflate(2131494599, null));
      this.vcP.iWu = ((ImageView)this.vcP.vcQ.findViewById(2131296996));
      a.b.d(this.vcP.iWu, this.username);
      this.vcP.vcQ.setTag(this.username);
      this.uly = new LinearLayout.LayoutParams(-2, -2);
      this.uly.leftMargin = BackwardSupportUtil.b.g(f.this.context, 5.0F);
      this.uly.rightMargin = BackwardSupportUtil.b.g(f.this.context, 5.0F);
      this.uly.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void dgE()
    {
      AppMethodBeat.i(55903);
      ad.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.vcP.vcQ.setBackgroundResource(2131232903);
      this.vcP.vcQ.invalidate();
      this.vcO = true;
      AppMethodBeat.o(55903);
    }
    
    public final void dgF()
    {
      AppMethodBeat.i(55904);
      ad.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.vcP.vcQ.setBackgroundResource(2131232902);
      this.vcP.vcQ.invalidate();
      this.vcO = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      ImageView iWu;
      RelativeLayout vcQ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */