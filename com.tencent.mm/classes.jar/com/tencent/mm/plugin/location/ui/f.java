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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.location.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class f
{
  Context context;
  private String fyN;
  private ao mHandler;
  private boolean mIsInit;
  MMHorList tZY;
  a tZZ;
  private int uaa;
  c uab;
  
  public f(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(55905);
    this.mIsInit = false;
    this.fyN = "";
    this.mHandler = new ao(Looper.getMainLooper());
    this.uab = null;
    this.context = paramContext;
    this.tZY = ((MMHorList)paramView);
    this.fyN = paramString;
    cXp();
    AppMethodBeat.o(55905);
  }
  
  private void ai(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(55907);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.uaf) {
        localb.cXs();
      }
    }
    this.uaa = a.fromDPToPix(this.context, 60);
    this.tZY.setOverScrollEnabled(true);
    this.tZY.setItemWidth(this.uaa);
    this.tZY.setCenterInParent(true);
    this.tZY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(55893);
        paramAnonymousAdapterView = (String)paramAnonymousView.getTag();
        if (!bs.isNullOrNil(paramAnonymousAdapterView))
        {
          h.wUl.f(10997, new Object[] { "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          if (f.this.uab != null) {
            f.this.uab.ajV(paramAnonymousAdapterView);
          }
        }
        AppMethodBeat.o(55893);
      }
    });
    this.tZZ = new a(paramArrayList);
    this.tZY.setAdapter(this.tZZ);
    AppMethodBeat.o(55907);
  }
  
  private void ajQ(String paramString)
  {
    AppMethodBeat.i(55908);
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.tZZ.ajU(paramString))
    {
      AppMethodBeat.o(55908);
      return;
    }
    paramString = new b(paramString);
    a locala = this.tZZ;
    locala.uae.add(paramString);
    locala.notifyDataSetChanged();
    this.tZY.invalidate();
    AppMethodBeat.o(55908);
  }
  
  private void ajR(String paramString)
  {
    AppMethodBeat.i(55909);
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    a locala;
    int i;
    if (this.tZZ.ajU(paramString))
    {
      locala = this.tZZ;
      i = 0;
      if (i >= locala.uae.size()) {
        break label108;
      }
      if (!((b)locala.uae.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.uae.remove(i);
        locala.notifyDataSetChanged();
      }
      this.tZY.invalidate();
      AppMethodBeat.o(55909);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void cXp()
  {
    AppMethodBeat.i(55906);
    Object localObject = n.cWW().DE(this.fyN);
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bs.isNullOrNil(str))
      {
        localArrayList1.add(new b(str));
        localArrayList2.add(str);
      }
    }
    ai(localArrayList1);
    aj(localArrayList2);
    this.tZY.invalidate();
    this.tZZ.notifyDataSetChanged();
    AppMethodBeat.o(55906);
  }
  
  public final void aj(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55912);
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.tZZ.cXr();
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
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[] { Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList1.size()) });
    if (localArrayList2.size() > 0)
    {
      paramArrayList = localArrayList2.iterator();
      while (paramArrayList.hasNext()) {
        ajQ((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        ajR((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(55912);
  }
  
  public final void ajS(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(55910);
    ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    final int i;
    if (this.tZZ.ajU(paramString))
    {
      this.tZZ.ajT(paramString).cXs();
      this.tZZ.notifyDataSetChanged();
      this.tZY.invalidate();
      if ((this.tZY.getIsTouching()) || (bs.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(55910);
        return;
      }
      a locala = this.tZZ;
      i = 0;
      if (i >= locala.uae.size()) {
        break label244;
      }
      if (!((b)locala.uae.get(i)).username.equals(paramString)) {
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
      ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      int m;
      if (j != -1)
      {
        m = j * this.uaa;
        i = this.tZY.getCurrentPosition();
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
              ac.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[] { Integer.valueOf(i) });
              f.this.tZY.ZZ(i);
              AppMethodBeat.o(55894);
            }
          });
          AppMethodBeat.o(55910);
          return;
          i += 1;
          break;
          if (m <= i + this.uaa * 3) {
            break label239;
          }
          i = m - this.uaa * 3;
          break label173;
        }
        i = 0;
      }
    }
  }
  
  public final void cXq()
  {
    AppMethodBeat.i(55911);
    a locala = this.tZZ;
    Iterator localIterator = locala.uae.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cXt();
    }
    locala.notifyDataSetChanged();
    this.tZY.invalidate();
    AppMethodBeat.o(55911);
  }
  
  final class a
    extends BaseAdapter
  {
    ArrayList<f.b> uae;
    
    public a()
    {
      AppMethodBeat.i(55895);
      this.uae = new ArrayList();
      Collection localCollection;
      this.uae.addAll(localCollection);
      AppMethodBeat.o(55895);
    }
    
    public final f.b ajT(String paramString)
    {
      AppMethodBeat.i(55899);
      int i = 0;
      while (i < this.uae.size())
      {
        if (((f.b)this.uae.get(i)).username.equals(paramString))
        {
          paramString = (f.b)this.uae.get(i);
          AppMethodBeat.o(55899);
          return paramString;
        }
        i += 1;
      }
      AppMethodBeat.o(55899);
      return null;
    }
    
    public final boolean ajU(String paramString)
    {
      AppMethodBeat.i(55900);
      int i = 0;
      while (i < this.uae.size())
      {
        if (((f.b)this.uae.get(i)).username.equals(paramString))
        {
          AppMethodBeat.o(55900);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(55900);
      return false;
    }
    
    public final ArrayList<String> cXr()
    {
      AppMethodBeat.i(55901);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.uae.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((f.b)localIterator.next()).username);
      }
      AppMethodBeat.o(55901);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(55896);
      int i = this.uae.size();
      AppMethodBeat.o(55896);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(55897);
      Object localObject = this.uae.get(paramInt);
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
      paramView = ((f.b)this.uae.get(paramInt)).uag.uah;
      AppMethodBeat.o(55898);
      return paramView;
    }
  }
  
  final class b
  {
    private LinearLayout.LayoutParams tna;
    boolean uaf;
    a uag;
    String username;
    
    public b(String paramString)
    {
      AppMethodBeat.i(55902);
      this.uaf = false;
      this.username = paramString;
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
        AppMethodBeat.o(55902);
        return;
      }
      this.uag = new a();
      this$1 = (LayoutInflater)f.this.context.getSystemService("layout_inflater");
      this.uag.uah = ((RelativeLayout)f.this.inflate(2131494599, null));
      this.uag.iDk = ((ImageView)this.uag.uah.findViewById(2131296996));
      a.b.d(this.uag.iDk, this.username);
      this.uag.uah.setTag(this.username);
      this.tna = new LinearLayout.LayoutParams(-2, -2);
      this.tna.leftMargin = BackwardSupportUtil.b.g(f.this.context, 5.0F);
      this.tna.rightMargin = BackwardSupportUtil.b.g(f.this.context, 5.0F);
      this.tna.gravity = 17;
      AppMethodBeat.o(55902);
    }
    
    public final void cXs()
    {
      AppMethodBeat.i(55903);
      ac.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
      this.uag.uah.setBackgroundResource(2131232903);
      this.uag.uah.invalidate();
      this.uaf = true;
      AppMethodBeat.o(55903);
    }
    
    public final void cXt()
    {
      AppMethodBeat.i(55904);
      ac.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
      this.uag.uah.setBackgroundResource(2131232902);
      this.uag.uah.invalidate();
      this.uaf = false;
      AppMethodBeat.o(55904);
    }
    
    final class a
    {
      ImageView iDk;
      RelativeLayout uah;
      
      a() {}
    }
  }
  
  public static abstract interface c
  {
    public abstract void ajV(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.f
 * JD-Core Version:    0.7.0.1
 */