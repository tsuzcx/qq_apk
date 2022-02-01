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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
{
  MMHorList EmB;
  a EmC;
  private int EmD;
  f.c EmE;
  Context context;
  private String jjq;
  private MMHandler mHandler;
  private boolean mIsInit;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.jjq = "";
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.EmE = null;
    this.context = paramContext;
    this.EmB = ((MMHorList)paramView);
    this.jjq = paramString;
    eME();
    AppMethodBeat.o(55905);
  }
  
  private void aC(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.EmI) {
        localb.eMH();
      }
    }
    this.EmD = a.fromDPToPix(this.context, 60);
    this.EmB.setOverScrollEnabled(true);
    this.EmB.setItemWidth(this.EmD);
    this.EmB.setCenterInParent(true);
    this.EmB.setOnItemClickListener(new f.1(this));
    this.EmC = new a(paramArrayList);
    this.EmB.setAdapter(this.EmC);
    AppMethodBeat.o(55907);
  }
  
  private void aNl(String paramString)
  {
    AppMethodBeat.i(55908);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.EmC.aNp(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.EmC;
    locala.EmH.add(paramString);
    locala.notifyDataSetChanged();
    this.EmB.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void aNm(String paramString)
  {
    AppMethodBeat.i(55909);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.EmC.aNp(paramString))
    {
      locala = this.EmC;
      i = 0;
      if (i >= locala.EmH.size()) {
        break label108;
      }
      if (!((b)locala.EmH.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.EmH.remove(i);
        locala.notifyDataSetChanged();
      }
      this.EmB.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void eME()
  {
    AppMethodBeat.i(55906);
    Object localObject = n.eMk().Xv(this.jjq);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(str))
      {
        localArrayList1.add(new b(str));
        localArrayList2.add(str);
      }
    }
    aC(localArrayList1);
    aD(localArrayList2);
    this.EmB.invalidate();
    this.EmC.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void aD(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.EmC.eMG();
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
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[] { Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList1.size()) });
    if (localArrayList2.size() > 0)
    {
      paramArrayList = localArrayList2.iterator();
      while (paramArrayList.hasNext()) {
        aNl((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        aNm((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void aNn(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.EmC.aNp(paramString))
    {
      this.EmC.aNo(paramString).eMH();
      this.EmC.notifyDataSetChanged();
      this.EmB.invalidate();
      if ((this.EmB.getIsTouching()) || (Util.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.EmC;
      i = 0;
      if (i >= locala.EmH.size()) {
        break label244;
      }
      if (!((b)locala.EmH.get(i)).username.equals(paramString)) {
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
      Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      int m;
      if (j != -1)
      {
        m = j * this.EmD;
        i = this.EmB.getCurrentPosition();
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
              Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[] { Integer.valueOf(i) });
              f.this.EmB.auy(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.EmD * 3) {
            break label239;
          }
          i = m - this.EmD * 3;
          break label173;
        }
        i = 0;
      }
    }
  }
  
  public final void eMF()
  {
    AppMethodBeat.i(55911);
    a locala = this.EmC;
    Iterator localIterator = locala.EmH.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).eMI();
    }
    locala.notifyDataSetChanged();
    this.EmB.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> EmH;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.EmH = new ArrayList();
      Collection localCollection;
      this.EmH.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b aNo(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.EmH.size())
      {
        if (((f.b)this.EmH.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.EmH.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean aNp(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.EmH.size())
      {
        if (((f.b)this.EmH.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> eMG()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.EmH.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.EmH.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.EmH.get(paramInt);
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
      paramView = ((f.b)this.EmH.get(paramInt)).EmJ.EmK;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    private LinearLayout.LayoutParams CTe;
    boolean EmI;
    a EmJ;
    String username;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.EmI = false;
      this.username = paramString;
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.EmJ = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.EmJ.EmK = ((RelativeLayout)f.this.inflate(a.f.location_share_header_avatar_layout, null));
      this.EmJ.mOe = ((ImageView)this.EmJ.EmK.findViewById(a.e.avatar));
      a.b.d(this.EmJ.mOe, this.username);
      this.EmJ.EmK.setTag(this.username);
      this.CTe = new LinearLayout.LayoutParams(-2, -2);
      this.CTe.leftMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0F);
      this.CTe.rightMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0F);
      this.CTe.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void eMH()
    {
      AppMethodBeat.i(55903);
      Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.EmJ.EmK.setBackgroundResource(a.d.location_share_avatar_bg_hl);
      this.EmJ.EmK.invalidate();
      this.EmI = true;
      AppMethodBeat.o(55903);
    }
    
    public final void eMI()
    {
      AppMethodBeat.i(55904);
      Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.EmJ.EmK.setBackgroundResource(a.d.location_share_avatar_bg);
      this.EmJ.EmK.invalidate();
      this.EmI = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      RelativeLayout EmK;
      ImageView mOe;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */