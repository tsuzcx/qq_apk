package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  Context context;
  private String eis;
  private ak mHandler;
  private boolean mIsInit;
  MMHorList ocZ;
  h.a oda;
  private int odb;
  h.c odc;
  
  public h(Context paramContext, View paramView, String paramString)
  {
    AppMethodBeat.i(113504);
    this.mIsInit = false;
    this.eis = "";
    this.mHandler = new ak(Looper.getMainLooper());
    this.odc = null;
    this.context = paramContext;
    this.ocZ = ((MMHorList)paramView);
    this.eis = paramString;
    bLJ();
    AppMethodBeat.o(113504);
  }
  
  private void G(ArrayList<h.b> paramArrayList)
  {
    AppMethodBeat.i(113506);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      h.b localb = (h.b)localIterator.next();
      if (localb.odg) {
        localb.bLM();
      }
    }
    this.odb = a.fromDPToPix(this.context, 60);
    this.ocZ.setOverScrollEnabled(true);
    this.ocZ.setItemWidth(this.odb);
    this.ocZ.setCenterInParent(true);
    this.ocZ.setOnItemClickListener(new h.1(this));
    this.oda = new h.a(this, paramArrayList);
    this.ocZ.setAdapter(this.oda);
    AppMethodBeat.o(113506);
  }
  
  private void Sc(String paramString)
  {
    AppMethodBeat.i(113507);
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[] { paramString });
    if (this.oda.Sg(paramString))
    {
      AppMethodBeat.o(113507);
      return;
    }
    paramString = new h.b(this, paramString);
    h.a locala = this.oda;
    locala.odf.add(paramString);
    locala.notifyDataSetChanged();
    this.ocZ.invalidate();
    AppMethodBeat.o(113507);
  }
  
  private void Sd(String paramString)
  {
    AppMethodBeat.i(113508);
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[] { paramString });
    h.a locala;
    int i;
    if (this.oda.Sg(paramString))
    {
      locala = this.oda;
      i = 0;
      if (i >= locala.odf.size()) {
        break label108;
      }
      if (!((h.b)locala.odf.get(i)).username.equals(paramString)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        locala.odf.remove(i);
        locala.notifyDataSetChanged();
      }
      this.ocZ.invalidate();
      AppMethodBeat.o(113508);
      return;
      label101:
      i += 1;
      break;
      label108:
      i = -1;
    }
  }
  
  private void bLJ()
  {
    AppMethodBeat.i(113505);
    Object localObject = l.bLs().uN(this.eis);
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bo.isNullOrNil(str))
      {
        localArrayList1.add(new h.b(this, str));
        localArrayList2.add(str);
      }
    }
    G(localArrayList1);
    H(localArrayList2);
    this.ocZ.invalidate();
    this.oda.notifyDataSetChanged();
    AppMethodBeat.o(113505);
  }
  
  public final void H(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(113511);
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = this.oda.bLL();
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
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[] { Integer.valueOf(localArrayList2.size()), Integer.valueOf(localArrayList1.size()) });
    if (localArrayList2.size() > 0)
    {
      paramArrayList = localArrayList2.iterator();
      while (paramArrayList.hasNext()) {
        Sc((String)paramArrayList.next());
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = localArrayList1.iterator();
      while (paramArrayList.hasNext()) {
        Sd((String)paramArrayList.next());
      }
    }
    AppMethodBeat.o(113511);
  }
  
  public final void Se(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(113509);
    ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[] { paramString });
    int i;
    if (this.oda.Sg(paramString))
    {
      this.oda.Sf(paramString).bLM();
      this.oda.notifyDataSetChanged();
      this.ocZ.invalidate();
      if ((this.ocZ.getIsTouching()) || (bo.isNullOrNil(paramString)))
      {
        AppMethodBeat.o(113509);
        return;
      }
      h.a locala = this.oda;
      i = 0;
      if (i >= locala.odf.size()) {
        break label243;
      }
      if (!((h.b)locala.odf.get(i)).username.equals(paramString)) {
        break label202;
      }
    }
    label172:
    label202:
    label209:
    label238:
    label243:
    for (int j = i;; j = -1)
    {
      ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[] { Integer.valueOf(j) });
      int m;
      if (j != -1)
      {
        m = j * this.odb;
        i = this.ocZ.getCurrentPosition();
        if (m >= i) {
          break label209;
        }
      }
      for (;;)
      {
        if (j == 0) {
          i = k;
        }
        for (;;)
        {
          this.mHandler.post(new h.2(this, i));
          AppMethodBeat.o(113509);
          return;
          i += 1;
          break;
          if (m <= i + this.odb * 3) {
            break label238;
          }
          i = m - this.odb * 3;
          break label172;
        }
        i = 0;
      }
    }
  }
  
  public final void bLK()
  {
    AppMethodBeat.i(113510);
    h.a locala = this.oda;
    Iterator localIterator = locala.odf.iterator();
    while (localIterator.hasNext()) {
      ((h.b)localIterator.next()).bLN();
    }
    locala.notifyDataSetChanged();
    this.ocZ.invalidate();
    AppMethodBeat.o(113510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h
 * JD-Core Version:    0.7.0.1
 */