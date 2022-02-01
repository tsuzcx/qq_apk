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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.p;
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
  MMHorList Kfk;
  a Kfl;
  private int Kfm;
  f.c Kfn;
  Context context;
  private String lLV;
  private MMHandler mHandler;
  private boolean mIsInit;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.lLV = "";
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.Kfn = null;
    this.context = paramContext;
    this.Kfk = ((MMHorList)paramView);
    this.lLV = paramString;
    fUX();
    AppMethodBeat.o(55905);
  }
  
  private void aKg(String paramString)
  {
    AppMethodBeat.i(55908);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.Kfl.aKk(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.Kfl;
    locala.Kfq.add(paramString);
    locala.notifyDataSetChanged();
    this.Kfk.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void aKh(String paramString)
  {
    AppMethodBeat.i(55909);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.Kfl.aKk(paramString))
    {
      locala = this.Kfl;
      i = 0;
      if (i >= locala.Kfq.size()) {
        break label108;
      }
      if (!((b)locala.Kfq.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.Kfq.remove(i);
        locala.notifyDataSetChanged();
      }
      this.Kfk.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void aV(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.Kfr) {
        localb.fVa();
      }
    }
    this.Kfm = a.fromDPToPix(this.context, 60);
    this.Kfk.setOverScrollEnabled(true);
    this.Kfk.setItemWidth(this.Kfm);
    this.Kfk.setCenterInParent(true);
    this.Kfk.setOnItemClickListener(new f.1(this));
    this.Kfl = new a(paramArrayList);
    this.Kfk.setAdapter(this.Kfl);
    AppMethodBeat.o(55907);
  }
  
  private void fUX()
  {
    AppMethodBeat.i(55906);
    Object localObject = SubCoreLocation.fUC().Px(this.lLV);
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
    aV(localArrayList1);
    aW(localArrayList2);
    this.Kfk.invalidate();
    this.Kfl.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void aKi(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.Kfl.aKk(paramString))
    {
      this.Kfl.aKj(paramString).fVa();
      this.Kfl.notifyDataSetChanged();
      this.Kfk.invalidate();
      if ((this.Kfk.getIsTouching()) || (Util.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.Kfl;
      i = 0;
      if (i >= locala.Kfq.size()) {
        break label242;
      }
      if (!((b)locala.Kfq.get(i)).username.equals(paramString)) {
        break label201;
      }
    }
    label171:
    label201:
    label208:
    label237:
    label242:
    for (int j = i;; j = -1)
    {
      Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      int m;
      if (j != -1)
      {
        m = j * this.Kfm;
        i = this.Kfk.getCurrentPosition();
        if (m >= i) {
          break label208;
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
              f.this.Kfk.Wa(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.Kfm * 3) {
            break label237;
          }
          i = m - this.Kfm * 3;
          break label171;
        }
        i = 0;
      }
    }
  }
  
  public final void aW(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.Kfl.fUZ();
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
        aKg((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        aKh((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void fUY()
  {
    AppMethodBeat.i(55911);
    a locala = this.Kfl;
    Iterator localIterator = locala.Kfq.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).fVb();
    }
    locala.notifyDataSetChanged();
    this.Kfk.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> Kfq;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.Kfq = new ArrayList();
      Collection localCollection;
      this.Kfq.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b aKj(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.Kfq.size())
      {
        if (((f.b)this.Kfq.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.Kfq.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean aKk(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.Kfq.size())
      {
        if (((f.b)this.Kfq.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> fUZ()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Kfq.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.Kfq.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.Kfq.get(paramInt);
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
      paramView = ((f.b)this.Kfq.get(paramInt)).Kfs.Kft;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    private LinearLayout.LayoutParams INu;
    boolean Kfr;
    a Kfs;
    String username;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.Kfr = false;
      this.username = paramString;
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.Kfs = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.Kfs.Kft = ((RelativeLayout)f.this.inflate(a.f.location_share_header_avatar_layout, null));
      this.Kfs.pKM = ((ImageView)this.Kfs.Kft.findViewById(a.e.avatar));
      a.b.h(this.Kfs.pKM, this.username);
      this.Kfs.Kft.setTag(this.username);
      this.INu = new LinearLayout.LayoutParams(-2, -2);
      this.INu.leftMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0F);
      this.INu.rightMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0F);
      this.INu.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void fVa()
    {
      AppMethodBeat.i(55903);
      Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.Kfs.Kft.setBackgroundResource(a.d.location_share_avatar_bg_hl);
      this.Kfs.Kft.invalidate();
      this.Kfr = true;
      AppMethodBeat.o(55903);
    }
    
    public final void fVb()
    {
      AppMethodBeat.i(55904);
      Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.Kfs.Kft.setBackgroundResource(a.d.location_share_avatar_bg);
      this.Kfs.Kft.invalidate();
      this.Kfr = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      RelativeLayout Kft;
      ImageView pKM;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */