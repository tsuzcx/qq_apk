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
  Context context;
  private String gzn;
  private MMHandler mHandler;
  private boolean mIsInit;
  MMHorList yII;
  a yIJ;
  private int yIK;
  f.c yIL;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.gzn = "";
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.yIL = null;
    this.context = paramContext;
    this.yII = ((MMHorList)paramView);
    this.gzn = paramString;
    edl();
    AppMethodBeat.o(55905);
  }
  
  private void aDb(String paramString)
  {
    AppMethodBeat.i(55908);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.yIJ.aDf(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.yIJ;
    locala.yIO.add(paramString);
    locala.notifyDataSetChanged();
    this.yII.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void aDc(String paramString)
  {
    AppMethodBeat.i(55909);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.yIJ.aDf(paramString))
    {
      locala = this.yIJ;
      i = 0;
      if (i >= locala.yIO.size()) {
        break label108;
      }
      if (!((b)locala.yIO.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.yIO.remove(i);
        locala.notifyDataSetChanged();
      }
      this.yII.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void av(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.yIP) {
        localb.edo();
      }
    }
    this.yIK = a.fromDPToPix(this.context, 60);
    this.yII.setOverScrollEnabled(true);
    this.yII.setItemWidth(this.yIK);
    this.yII.setCenterInParent(true);
    this.yII.setOnItemClickListener(new f.1(this));
    this.yIJ = new a(paramArrayList);
    this.yII.setAdapter(this.yIJ);
    AppMethodBeat.o(55907);
  }
  
  private void edl()
  {
    AppMethodBeat.i(55906);
    Object localObject = n.ecS().PY(this.gzn);
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
    av(localArrayList1);
    aw(localArrayList2);
    this.yII.invalidate();
    this.yIJ.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void aDd(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.yIJ.aDf(paramString))
    {
      this.yIJ.aDe(paramString).edo();
      this.yIJ.notifyDataSetChanged();
      this.yII.invalidate();
      if ((this.yII.getIsTouching()) || (Util.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.yIJ;
      i = 0;
      if (i >= locala.yIO.size()) {
        break label242;
      }
      if (!((b)locala.yIO.get(i)).username.equals(paramString)) {
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
        m = j * this.yIK;
        i = this.yII.getCurrentPosition();
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
              f.this.yII.alA(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.yIK * 3) {
            break label237;
          }
          i = m - this.yIK * 3;
          break label171;
        }
        i = 0;
      }
    }
  }
  
  public final void aw(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.yIJ.edn();
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
        aDb((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        aDc((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void edm()
  {
    AppMethodBeat.i(55911);
    a locala = this.yIJ;
    Iterator localIterator = locala.yIO.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).edp();
    }
    locala.notifyDataSetChanged();
    this.yII.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> yIO;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.yIO = new ArrayList();
      Collection localCollection;
      this.yIO.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b aDe(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.yIO.size())
      {
        if (((f.b)this.yIO.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.yIO.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean aDf(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.yIO.size())
      {
        if (((f.b)this.yIO.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> edn()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.yIO.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.yIO.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.yIO.get(paramInt);
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
      paramView = ((f.b)this.yIO.get(paramInt)).yIQ.yIR;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    String username;
    private LinearLayout.LayoutParams xOV;
    boolean yIP;
    a yIQ;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.yIP = false;
      this.username = paramString;
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.yIQ = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.yIQ.yIR = ((RelativeLayout)f.this.inflate(2131495310, null));
      this.yIQ.jWS = ((ImageView)this.yIQ.yIR.findViewById(2131297119));
      a.b.d(this.yIQ.jWS, this.username);
      this.yIQ.yIR.setTag(this.username);
      this.xOV = new LinearLayout.LayoutParams(-2, -2);
      this.xOV.leftMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0F);
      this.xOV.rightMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0F);
      this.xOV.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void edo()
    {
      AppMethodBeat.i(55903);
      Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.yIQ.yIR.setBackgroundResource(2131233546);
      this.yIQ.yIR.invalidate();
      this.yIP = true;
      AppMethodBeat.o(55903);
    }
    
    public final void edp()
    {
      AppMethodBeat.i(55904);
      Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.yIQ.yIR.setBackgroundResource(2131233545);
      this.yIQ.yIR.invalidate();
      this.yIP = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      ImageView jWS;
      RelativeLayout yIR;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */