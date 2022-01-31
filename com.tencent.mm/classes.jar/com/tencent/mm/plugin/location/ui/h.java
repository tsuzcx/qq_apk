package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  Context context;
  private String dqQ = "";
  MMHorList lFM;
  h.a lFN;
  private int lFO;
  h.c lFP = null;
  private ah mHandler = new ah(Looper.getMainLooper());
  private boolean mIsInit = false;
  
  public h(Context paramContext, View paramView, String paramString)
  {
    this.context = paramContext;
    this.lFM = ((MMHorList)paramView);
    this.dqQ = paramString;
    bep();
  }
  
  private void F(ArrayList<h.b> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      h.b localb = (h.b)localIterator.next();
      if (localb.lFT) {
        localb.bes();
      }
    }
    this.lFO = a.fromDPToPix(this.context, 60);
    this.lFM.setOverScrollEnabled(true);
    this.lFM.setItemWidth(this.lFO);
    this.lFM.setCenterInParent(true);
    this.lFM.setOnItemClickListener(new h.1(this));
    this.lFN = new h.a(this, paramArrayList);
    this.lFM.setAdapter(this.lFN);
  }
  
  private void GA(String paramString)
  {
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    h.a locala;
    int i;
    if (this.lFN.GD(paramString))
    {
      locala = this.lFN;
      i = 0;
      if (i >= locala.lFS.size()) {
        break label98;
      }
      if (!((h.b)locala.lFS.get(i)).username.equals(paramString)) {
        break label91;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.lFS.remove(i);
        locala.notifyDataSetChanged();
      }
      this.lFM.invalidate();
      return;
      label91:
      i += 1;
      break;
      label98:
      i = -1;
    }
  }
  
  private void Gz(String paramString)
  {
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.lFN.GD(paramString)) {
      return;
    }
    paramString = new h.b(this, paramString);
    h.a locala = this.lFN;
    locala.lFS.add(paramString);
    locala.notifyDataSetChanged();
    this.lFM.invalidate();
  }
  
  private void bep()
  {
    Object localObject = l.bdY().nz(this.dqQ);
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bk.bl(str))
      {
        localArrayList1.add(new h.b(this, str));
        localArrayList2.add(str);
      }
    }
    F(localArrayList1);
    G(localArrayList2);
    this.lFM.invalidate();
    this.lFN.notifyDataSetChanged();
  }
  
  public final void G(ArrayList<String> paramArrayList)
  {
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.lFN.ber();
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
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[] { Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList1.size()) });
    if (localArrayList2.size() > 0)
    {
      paramArrayList = localArrayList2.iterator();
      while (paramArrayList.hasNext()) {
        Gz((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        GA((String)paramArrayList.next());
      }
    }
  }
  
  public final void GB(String paramString)
  {
    int k = 0;
    y.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    if (this.lFN.GD(paramString))
    {
      this.lFN.GC(paramString).bes();
      this.lFN.notifyDataSetChanged();
      this.lFM.invalidate();
      if ((!this.lFM.getIsTouching()) && (!bk.bl(paramString))) {}
    }
    else
    {
      return;
    }
    h.a locala = this.lFN;
    int i = 0;
    if (i < locala.lFS.size()) {
      if (!((h.b)locala.lFS.get(i)).username.equals(paramString)) {}
    }
    for (int j = i;; j = -1)
    {
      y.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      if (j == -1) {
        break;
      }
      int m = j * this.lFO;
      i = this.lFM.getCurrentPosition();
      if (m < i) {}
      for (;;)
      {
        label161:
        if (j == 0) {
          i = k;
        }
        for (;;)
        {
          this.mHandler.post(new h.2(this, i));
          return;
          i += 1;
          break;
          if (m <= i + this.lFO * 3) {
            break label222;
          }
          i = m - this.lFO * 3;
          break label161;
        }
        label222:
        i = 0;
      }
    }
  }
  
  public final void beq()
  {
    h.a locala = this.lFN;
    Iterator localIterator = locala.lFS.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).bet();
    }
    locala.notifyDataSetChanged();
    this.lFM.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h
 * JD-Core Version:    0.7.0.1
 */