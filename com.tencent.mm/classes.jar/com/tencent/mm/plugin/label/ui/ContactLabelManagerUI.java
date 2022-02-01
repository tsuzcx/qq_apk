package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.am.c.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.label.d;
import com.tencent.mm.plugin.label.ui.widget.a.a;
import com.tencent.mm.plugin.label.ui.widget.c.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.updater.a.c;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.contact.privacy.SelectPrivacyContactsFromRangeUI;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, com.tencent.mm.am.h, u.i
{
  private a JUX;
  private View JUY;
  private View JUZ;
  private a.a JVA;
  private View.OnClickListener JVB;
  private MStorage.IOnStorageChange JVC;
  private MStorageEx.IOnStorageChange JVD;
  private MenuItem.OnMenuItemClickListener JVE;
  private WeImageView JVa;
  private View JVb;
  private View JVc;
  private Button JVd;
  private Button JVe;
  private TextView JVf;
  private TextView JVg;
  private com.tencent.mm.plugin.label.ui.widget.b JVh;
  private boolean JVi;
  private View JVj;
  protected boolean JVk;
  private String JVl;
  protected boolean JVm;
  private com.tencent.mm.plugin.label.ui.widget.c JVn;
  private ArrayList<aw> JVo;
  private ArrayList<aw> JVp;
  private HashMap<Integer, Long> JVq;
  private HashMap<Integer, Integer> JVr;
  private HashMap<Integer, Integer> JVs;
  private HashSet<String> JVt;
  private boolean JVu;
  private boolean JVv;
  private TextView JVw;
  private boolean JVx;
  private View JVy;
  private int JVz;
  private View bEA;
  private View bEx;
  private MMHandler mHandler;
  private RecyclerView mRecyclerView;
  e pjp;
  private LinearLayoutManager uQP;
  private com.tencent.mm.ui.widget.b.a vEV;
  private View xTc;
  private int x_down;
  private int y_down;
  
  public ContactLabelManagerUI()
  {
    AppMethodBeat.i(26228);
    this.JUX = a.JVP;
    this.JVi = false;
    this.JVk = false;
    this.JVm = false;
    this.JVo = new ArrayList();
    this.JVp = new ArrayList();
    this.JVq = new HashMap();
    this.JVr = new HashMap();
    this.JVs = new HashMap();
    this.JVt = new HashSet();
    this.JVu = true;
    this.JVv = false;
    this.x_down = 0;
    this.y_down = 0;
    this.JVx = true;
    this.JVz = -1;
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26206);
        int i = paramAnonymousMessage.what;
        Log.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.a(ContactLabelManagerUI.this);
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.this.aJO(ContactLabelManagerUI.this.getString(R.l.app_waiting));
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.this.hideLoading();
        }
      }
    };
    this.JVA = new a.a()
    {
      boolean JVL = false;
      
      public final void fTs()
      {
        AppMethodBeat.i(268807);
        com.tencent.mm.plugin.label.ui.widget.c localc = ContactLabelManagerUI.b(ContactLabelManagerUI.this);
        if (localc.JYx != localc.JYw) {
          localc.JYv += 1;
        }
        localc.JYx = -1;
        localc.JYw = -1;
        this.JVL = false;
        AppMethodBeat.o(268807);
      }
      
      public final void onItemSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(268802);
        ContactLabelManagerUI.b(ContactLabelManagerUI.this).JYx = paramAnonymousInt;
        if (!this.JVL) {
          ax.jlo();
        }
        this.JVL = true;
        AppMethodBeat.o(268802);
      }
      
      public final boolean onMove(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(268822);
        ContactLabelManagerUI.b(ContactLabelManagerUI.this).JYw = paramAnonymousInt2;
        if (paramAnonymousInt2 == 0)
        {
          AppMethodBeat.o(268822);
          return false;
        }
        if (ContactLabelManagerUI.b(ContactLabelManagerUI.this).mlK != null)
        {
          if (!ContactLabelManagerUI.b(ContactLabelManagerUI.this).JYt)
          {
            if (!ContactLabelManagerUI.c(ContactLabelManagerUI.this))
            {
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, true);
              ContactLabelManagerUI localContactLabelManagerUI = ContactLabelManagerUI.this;
              Object localObject = ContactLabelManagerUI.this;
              String str = ContactLabelManagerUI.this.getResources().getString(R.l.gMA);
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(26208);
                  Log.i("MicroMsg.Label.ContactLabelManagerUI", "can not drag.");
                  ContactLabelManagerUI.a(ContactLabelManagerUI.this, false);
                  ContactLabelManagerUI.b(ContactLabelManagerUI.this).bZE.notifyChanged();
                  AppMethodBeat.o(26208);
                }
              };
              if ((localContactLabelManagerUI.pjp == null) || (!localContactLabelManagerUI.pjp.isShowing()))
              {
                localObject = new g.a((Context)localObject);
                ((g.a)localObject).bDE(str);
                ((g.a)localObject).Xdm = true;
                ((g.a)localObject).aEX(a.c.app_i_know);
                ((g.a)localObject).b(new ContactLabelManagerUI.14(localContactLabelManagerUI, local1));
                localContactLabelManagerUI.pjp = ((g.a)localObject).pRv;
                ((g.a)localObject).show();
              }
            }
            AppMethodBeat.o(268822);
            return true;
          }
          Collections.swap(ContactLabelManagerUI.b(ContactLabelManagerUI.this).mlK, paramAnonymousInt1, paramAnonymousInt2);
          ContactLabelManagerUI.b(ContactLabelManagerUI.this).bz(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(268822);
          return true;
        }
        AppMethodBeat.o(268822);
        return false;
      }
    };
    this.pjp = null;
    this.JVB = new ContactLabelManagerUI.15(this);
    this.JVC = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(268791);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (ContactLabelManagerUI.e(ContactLabelManagerUI.this) != null))
        {
          ContactLabelManagerUI.e(ContactLabelManagerUI.this).removeMessages(5001);
          ContactLabelManagerUI.e(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5001, 400L);
        }
        AppMethodBeat.o(268791);
      }
    };
    this.JVD = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(268787);
        Log.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
        if (ContactLabelManagerUI.e(ContactLabelManagerUI.this) != null)
        {
          ContactLabelManagerUI.e(ContactLabelManagerUI.this).removeMessages(5001);
          ContactLabelManagerUI.e(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5001, 400L);
        }
        AppMethodBeat.o(268787);
      }
    };
    this.JVE = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(268784);
        if (ContactLabelManagerUI.f(ContactLabelManagerUI.this))
        {
          boolean bool = ContactLabelManagerUI.g(ContactLabelManagerUI.this);
          AppMethodBeat.o(268784);
          return bool;
        }
        ContactLabelManagerUI.this.finish();
        AppMethodBeat.o(268784);
        return false;
      }
    };
    AppMethodBeat.o(26228);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(268700);
    this.JUX = parama;
    switch (13.JVN[this.JUX.ordinal()])
    {
    default: 
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "unkonw mode:%s", new Object[] { this.JUX });
      AppMethodBeat.o(268700);
      return;
    case 1: 
      this.xTc.setVisibility(0);
      this.bEx.setVisibility(8);
      if (!this.JVk)
      {
        this.JVb.setVisibility(0);
        AppMethodBeat.o(268700);
        return;
      }
      this.JVb.setVisibility(8);
      AppMethodBeat.o(268700);
      return;
    }
    this.xTc.setVisibility(8);
    this.bEx.setVisibility(0);
    this.JVb.setVisibility(8);
    AppMethodBeat.o(268700);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(268688);
    if (this.JVm)
    {
      if ((this.JVn == null) || (this.JVn.JXy.size() <= 0)) {
        break label100;
      }
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      updateOptionMenuText(1, getString(b.j.app_nextstep) + "(" + this.JVn.JXy.size() + ")");
      AppMethodBeat.o(268688);
      return;
      label100:
      enableOptionMenu(1, false);
    }
  }
  
  private void aS(ArrayList<aw> paramArrayList)
  {
    AppMethodBeat.i(268719);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    this.JVn.setData((ArrayList)localObject);
    fTp();
    AppMethodBeat.o(268719);
  }
  
  private void aT(final ArrayList<aw> paramArrayList)
  {
    AppMethodBeat.i(268754);
    f localf = new f(this, 1, true);
    localf.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(268782);
        paramAnonymouss.a(0, ContactLabelManagerUI.this.getResources().getColor(R.e.fkI), ContactLabelManagerUI.this.getString(R.l.app_delete));
        AppMethodBeat.o(268782);
      }
    };
    localf.h(getString(R.l.gMx), 17, com.tencent.mm.cd.a.fromDPToPix(this, 14));
    localf.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(268785);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(268785);
          return;
          Object localObject;
          if (paramArrayList != null)
          {
            if (paramArrayList.size() > 0)
            {
              paramAnonymousMenuItem = new ArrayList();
              paramAnonymousInt = 0;
              while (paramAnonymousInt < paramArrayList.size())
              {
                localObject = (aw)paramArrayList.get(paramAnonymousInt);
                if (localObject != null)
                {
                  if (!paramAnonymousMenuItem.contains(((aw)localObject).field_labelID)) {
                    paramAnonymousMenuItem.add(((aw)localObject).field_labelID);
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
                }
                paramAnonymousInt += 1;
              }
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramAnonymousMenuItem, paramArrayList);
              ContactLabelManagerUI.c(ContactLabelManagerUI.this, 1);
              AppMethodBeat.o(268785);
            }
          }
          else
          {
            paramAnonymousMenuItem = new ArrayList();
            localObject = new ArrayList();
            if ((ContactLabelManagerUI.b(ContactLabelManagerUI.this) != null) && (ContactLabelManagerUI.b(ContactLabelManagerUI.this).JXy.size() > 0))
            {
              paramAnonymousInt = 0;
              while (paramAnonymousInt < ContactLabelManagerUI.b(ContactLabelManagerUI.this).JXy.size())
              {
                aw localaw = d.fTa().bxn((String)ContactLabelManagerUI.b(ContactLabelManagerUI.this).JXy.get(paramAnonymousInt));
                if (localaw != null)
                {
                  if (!((ArrayList)localObject).contains(localaw.field_labelID))
                  {
                    ((ArrayList)localObject).add(localaw.field_labelID);
                    paramAnonymousMenuItem.add(localaw);
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
                }
                paramAnonymousInt += 1;
              }
            }
            if (((ArrayList)localObject).size() > 0) {
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, (ArrayList)localObject, paramAnonymousMenuItem);
            }
            ContactLabelManagerUI.c(ContactLabelManagerUI.this, 2);
          }
        }
      }
    };
    localf.dDn();
    AppMethodBeat.o(268754);
  }
  
  private void bD(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(268741);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedList.iterator();
    label203:
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (this.JVr.containsKey(localInteger))
      {
        int i = ((Integer)this.JVr.get(localInteger)).intValue();
        long l = ((Long)this.JVq.get(Integer.valueOf(i))).longValue();
        paramLinkedList = d.fTa().bxn(String.valueOf(localInteger));
        if (paramLinkedList == null) {
          paramLinkedList = new aw();
        }
        for (;;)
        {
          if (paramLinkedList.field_createTime == l) {
            break label203;
          }
          paramLinkedList.field_createTime = l;
          localArrayList.add(paramLinkedList);
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "oldLebalId = " + i + ", newSortLabelId = " + localInteger + ", label.field_createTime = " + paramLinkedList.field_createTime + ", newCreateTime = " + l);
          break;
          if (paramLinkedList.field_isTemporary) {
            break;
          }
        }
      }
    }
    d.fTa().N(localArrayList, false);
    paramLinkedList = new ArrayList();
    paramLinkedList.addAll(this.JVn.mlK);
    this.JVo.clear();
    this.JVo.addAll(paramLinkedList);
    this.JVp.clear();
    this.JVp.addAll(paramLinkedList);
    this.JVr.clear();
    this.JVq.clear();
    AppMethodBeat.o(268741);
  }
  
  private void fTe()
  {
    AppMethodBeat.i(26241);
    hideLoading();
    aoP(getString(R.l.gEb));
    AppMethodBeat.o(26241);
  }
  
  private boolean fTn()
  {
    AppMethodBeat.i(268684);
    if (this.JVi)
    {
      if (!fTr()) {
        break label32;
      }
      fTq();
    }
    for (;;)
    {
      AppMethodBeat.o(268684);
      return true;
      label32:
      fTo();
    }
  }
  
  private void fTo()
  {
    AppMethodBeat.i(268713);
    removeAllOptionMenu();
    this.JVi = false;
    if (this.JVn.JYv > 0) {
      com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 8L, this.JVn.JYv, 0L, 0L);
    }
    this.JVn.JXV = 0;
    this.JVn.resetStatus();
    aS(this.JVo);
    this.JVh.xQ(false);
    this.JUY.setVisibility(0);
    this.JVb.setVisibility(0);
    this.JVc.setVisibility(8);
    setMMTitle(getString(R.l.gMd));
    setBackBtn(this.JVE, R.k.actionbar_icon_dark_back);
    this.JVj.setVisibility(8);
    AppMethodBeat.o(268713);
  }
  
  private void fTp()
  {
    boolean bool2 = true;
    AppMethodBeat.i(268724);
    Object localObject = this.JVn;
    int j = this.JVn.getItemCount();
    int i;
    if (this.JVn.JYA)
    {
      i = 2;
      if (j <= i) {
        break label124;
      }
      bool1 = true;
      label42:
      ((com.tencent.mm.plugin.label.ui.widget.c)localObject).xT(bool1);
      localObject = this.JVh;
      if (!this.JVi) {
        break label134;
      }
      j = this.JVn.getItemCount();
      if (!this.JVn.JYA) {
        break label129;
      }
      i = 2;
      label81:
      if (j <= i) {
        break label134;
      }
    }
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((com.tencent.mm.plugin.label.ui.widget.b)localObject).xQ(bool1);
      this.JVg.setTextColor(getResources().getColor(R.e.black_text_color_selector));
      AppMethodBeat.o(268724);
      return;
      i = 0;
      break;
      label124:
      bool1 = false;
      break label42;
      i = 0;
      break label81;
    }
  }
  
  private void fTq()
  {
    AppMethodBeat.i(268734);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.JVn.mlK);
    Object localObject = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      aw localaw = (aw)localIterator.next();
      if (localaw.field_isTemporary) {
        localLinkedList.add(localaw);
      } else {
        ((List)localObject).add(Integer.valueOf(localaw.field_labelID));
      }
    }
    localArrayList.removeAll(localLinkedList);
    if (((List)localObject).size() == 0)
    {
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
      AppMethodBeat.o(268734);
      return;
    }
    localObject = new com.tencent.mm.plugin.label.b.b((List)localObject);
    ((com.tencent.mm.plugin.label.b.b)localObject).JUk = localArrayList;
    bh.aZW().a((com.tencent.mm.am.p)localObject, 0);
    bD(((com.tencent.mm.plugin.label.b.b)localObject).JUj);
    fTo();
    AppMethodBeat.o(268734);
  }
  
  private boolean fTr()
  {
    AppMethodBeat.i(268747);
    if ((this.JVp == null) || (this.JVp.size() <= 1))
    {
      Log.i("MicroMsg.Label.ContactLabelManagerUI", "isSwapPosAdapter mAllContactLabelCopy error.");
      AppMethodBeat.o(268747);
      return false;
    }
    if ((this.JVn.mlK == null) || (this.JVn.mlK.size() <= 1))
    {
      Log.i("MicroMsg.Label.ContactLabelManagerUI", "isSwapPosAdapter mAdapter.getData() error.");
      AppMethodBeat.o(268747);
      return false;
    }
    this.JVr.clear();
    int i = 0;
    while (i < this.JVn.mlK.size())
    {
      if ((i < this.JVp.size()) && (((((aw)this.JVp.get(i)).field_labelID != -1000000) && (((aw)this.JVp.get(i)).field_labelID != -2000000)) || ((!((aw)this.JVp.get(i)).field_isTemporary) && (((aw)this.JVp.get(i)).field_labelID != ((aw)this.JVn.mlK.get(i)).field_labelID))))
      {
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "isSwapPosAdapter field_labelID no equal.");
        this.JVr.put(Integer.valueOf(((aw)this.JVn.mlK.get(i)).field_labelID), Integer.valueOf(((aw)this.JVp.get(i)).field_labelID));
      }
      i += 1;
    }
    if (this.JVr.size() > 0)
    {
      AppMethodBeat.o(268747);
      return true;
    }
    AppMethodBeat.o(268747);
    return false;
  }
  
  private static HashMap<Integer, List<String>> v(List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(268708);
    Object localObject = z.bAM();
    if (paramList != null)
    {
      if (!paramList.contains("filehelper")) {
        paramList.add("filehelper");
      }
      if (!paramList.contains(localObject)) {
        paramList.add(localObject);
      }
    }
    com.tencent.mm.kernel.h.baF();
    paramList = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(null, "", "@all.contact.without.chatroom.without.openim.without.openimfavour", "", paramList);
    localObject = new HashMap();
    if (paramList.getCount() == 0)
    {
      AppMethodBeat.o(268708);
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      do
      {
        int j;
        do
        {
          if (!paramList.moveToPosition(i)) {
            break;
          }
          Log.d("MicroMsg.Label.ContactLabelManagerUI", "create contact item index=%d", new Object[] { Integer.valueOf(i) });
          j = i + 1;
          au localau = new au();
          localau.convertFrom(paramList);
          localArrayList.add(localau.field_username);
          i = j;
        } while (!paramBoolean);
        i = j;
      } while (localArrayList.size() <= 10);
    }
    if (localArrayList.size() > 0) {
      ((HashMap)localObject).put(Integer.valueOf(paramList.getCount()), localArrayList);
    }
    paramList.close();
    AppMethodBeat.o(268708);
    return localObject;
  }
  
  private void xP(final boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(26238);
      Log.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268750);
          ContactLabelManagerUI.a(ContactLabelManagerUI.this, d.fTa().iZP());
          if (ContactLabelManagerUI.q(ContactLabelManagerUI.this) == null) {
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, new ArrayList());
          }
          ArrayList localArrayList1;
          int i;
          int j;
          if ((ContactLabelManagerUI.this.JVk) && (ContactLabelManagerUI.this.JVm))
          {
            localArrayList1 = new ArrayList();
            i = 0;
            while (i < ContactLabelManagerUI.q(ContactLabelManagerUI.this).size())
            {
              aw localaw = (aw)ContactLabelManagerUI.q(ContactLabelManagerUI.this).get(i);
              j = localaw.field_labelID;
              ArrayList localArrayList2 = d.fTa().bxk(String.valueOf(j));
              if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
                localArrayList1.add(localaw);
              }
              i += 1;
            }
            if (localArrayList1.size() > 0) {
              ContactLabelManagerUI.q(ContactLabelManagerUI.this).removeAll(localArrayList1);
            }
          }
          ContactLabelManagerUI.p(ContactLabelManagerUI.this).clear();
          if ((ContactLabelManagerUI.q(ContactLabelManagerUI.this) == null) || (ContactLabelManagerUI.q(ContactLabelManagerUI.this).size() <= 0))
          {
            Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.r(ContactLabelManagerUI.this))
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
              ContactLabelManagerUI.s(ContactLabelManagerUI.this);
            }
            ContactLabelManagerUI.t(ContactLabelManagerUI.this);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(268739);
                if (ContactLabelManagerUI.q(ContactLabelManagerUI.this).size() > 0) {
                  ContactLabelManagerUI.u(ContactLabelManagerUI.this);
                }
                for (;;)
                {
                  if ((ContactLabelManagerUI.9.this.JVI) && (ContactLabelManagerUI.e(ContactLabelManagerUI.this) != null))
                  {
                    ContactLabelManagerUI.e(ContactLabelManagerUI.this).removeMessages(5002);
                    ContactLabelManagerUI.e(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5003, 0L);
                  }
                  ContactLabelManagerUI.this.fTm();
                  AppMethodBeat.o(268739);
                  return;
                  ContactLabelManagerUI.b(ContactLabelManagerUI.this).resetStatus();
                  ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.a.JVQ);
                  ContactLabelManagerUI.v(ContactLabelManagerUI.this).setEnabled(false);
                  ContactLabelManagerUI.v(ContactLabelManagerUI.this).setTextColor(ContactLabelManagerUI.this.getResources().getColor(R.e.black_text_color_disabled));
                }
              }
            });
            AppMethodBeat.o(268750);
            return;
          }
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
          if (ContactLabelManagerUI.r(ContactLabelManagerUI.this))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            ContactLabelManagerUI.s(ContactLabelManagerUI.this);
          }
          if ((ContactLabelManagerUI.q(ContactLabelManagerUI.this) != null) && (ContactLabelManagerUI.q(ContactLabelManagerUI.this).size() > 0))
          {
            j = ContactLabelManagerUI.q(ContactLabelManagerUI.this).size();
            d.fTa().bja();
            i = 0;
            if (i < j)
            {
              int k = ((aw)ContactLabelManagerUI.q(ContactLabelManagerUI.this).get(i)).field_labelID;
              localArrayList1 = d.fTa().bxk(String.valueOf(k));
              if ((localArrayList1 != null) && (localArrayList1.size() > 0))
              {
                ContactLabelManagerUI.p(ContactLabelManagerUI.this).addAll(localArrayList1);
                ContactLabelManagerUI.w(ContactLabelManagerUI.this).put(Integer.valueOf(k), Integer.valueOf(localArrayList1.size()));
              }
              for (;;)
              {
                i += 1;
                break;
                ContactLabelManagerUI.w(ContactLabelManagerUI.this).put(Integer.valueOf(k), Integer.valueOf(0));
              }
            }
          }
          ContactLabelManagerUI.x(ContactLabelManagerUI.this);
          ContactLabelManagerUI.t(ContactLabelManagerUI.this);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(268732);
              ContactLabelManagerUI.u(ContactLabelManagerUI.this);
              if ((ContactLabelManagerUI.9.this.JVI) && (ContactLabelManagerUI.e(ContactLabelManagerUI.this) != null))
              {
                ContactLabelManagerUI.e(ContactLabelManagerUI.this).removeMessages(5002);
                ContactLabelManagerUI.e(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5003, 400L);
              }
              AppMethodBeat.o(268732);
            }
          });
          AppMethodBeat.o(268750);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(268756);
          String str = super.toString() + "|updateData";
          AppMethodBeat.o(268756);
          return str;
        }
      });
      AppMethodBeat.o(26238);
      return;
    }
    finally {}
  }
  
  protected final void fTm()
  {
    AppMethodBeat.i(268939);
    if (this.JVi)
    {
      Button localButton = this.JVe;
      boolean bool;
      if (this.JVn.JXy.size() > 0)
      {
        bool = true;
        localButton.setEnabled(bool);
        if (this.JVn.JXy.size() <= 0) {
          break label165;
        }
        this.JVw.setVisibility(8);
        this.JVe.setTextColor(getResources().getColor(R.e.fkI));
      }
      for (;;)
      {
        if (this.JVn.JXy.size() <= 0) {
          break label194;
        }
        this.JVe.setText(getResources().getString(R.l.fEU) + " (" + this.JVn.JXy.size() + ")");
        AppMethodBeat.o(268939);
        return;
        bool = false;
        break;
        label165:
        this.JVw.setVisibility(8);
        this.JVe.setTextColor(getResources().getColor(R.e.black_text_color_disabled));
      }
      label194:
      this.JVe.setText(getResources().getString(R.l.fEU));
    }
    AppMethodBeat.o(268939);
  }
  
  public int getCustomBounceId()
  {
    return R.h.fMc;
  }
  
  public int getLayoutId()
  {
    return R.i.gis;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(26229);
    this.JVk = getIntent().getBooleanExtra("select_label", false);
    this.JVl = getIntent().getStringExtra("privacy_source_type");
    this.JVm = getIntent().getBooleanExtra("intent_status_from_privacy_setting", false);
    setMMTitle(getString(R.l.gMd));
    setBackBtn(this.JVE, R.k.actionbar_icon_dark_back);
    this.JVn = new com.tencent.mm.plugin.label.ui.widget.c(this);
    this.xTc = findViewById(R.h.fMe);
    this.bEx = findViewById(R.h.fLX);
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.fMc));
    this.uQP = new LinearLayoutManager();
    this.mRecyclerView.setLayoutManager(this.uQP);
    this.mRecyclerView.setHasFixedSize(true);
    this.JVh = new com.tencent.mm.plugin.label.ui.widget.b(new com.tencent.mm.plugin.label.ui.widget.a(this.JVA));
    this.JVh.a(this.mRecyclerView);
    this.JVh.xQ(false);
    this.JVn.HPR = this.JVh;
    this.JVb = findViewById(R.h.fOg);
    this.JVc = findViewById(R.h.edit_footer);
    this.JVd = ((Button)findViewById(R.h.fOB));
    this.JVe = ((Button)findViewById(R.h.fEX));
    this.JUY = findViewById(R.h.fuR);
    this.JVf = ((TextView)findViewById(R.h.fQB));
    this.JVf.setOnClickListener(this.JVB);
    this.JVg = ((TextView)findViewById(R.h.edit_btn));
    this.JVw = ((TextView)findViewById(R.h.fJE));
    this.JVy = ((WeImageView)findViewById(a.g.actionbar_up_indicator_btn));
    this.JVd.setOnClickListener(new ContactLabelManagerUI.19(this));
    this.JVe.setOnClickListener(new ContactLabelManagerUI.20(this));
    this.JVg.setOnClickListener(new ContactLabelManagerUI.2(this));
    this.vEV = new com.tencent.mm.ui.widget.b.a(this);
    this.JVn.JXX = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(268727);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          ContactLabelManagerUI.a(ContactLabelManagerUI.this, (int)paramAnonymousMotionEvent.getRawX());
          ContactLabelManagerUI.b(ContactLabelManagerUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
        AppMethodBeat.o(268727);
        return false;
      }
    };
    this.mRecyclerView.setAdapter(this.JVn);
    if ((this.JVm) && (this.JVk)) {
      this.JVn.JXV = 2;
    }
    this.JVn.JVs = this.JVs;
    this.JVn.JYE = new c.e()
    {
      public final void aD(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(268725);
        if (ContactLabelManagerUI.b(ContactLabelManagerUI.this).getItemViewType(paramAnonymousInt) == 2)
        {
          ContactLabelManagerUI.j(ContactLabelManagerUI.this);
          AppMethodBeat.o(268725);
          return;
        }
        if ((ContactLabelManagerUI.b(ContactLabelManagerUI.this) != null) && (paramAnonymousInt >= 0))
        {
          aw localaw = ContactLabelManagerUI.b(ContactLabelManagerUI.this).Zz(paramAnonymousInt);
          if (localaw != null)
          {
            if (ContactLabelManagerUI.f(ContactLabelManagerUI.this))
            {
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramAnonymousView, localaw);
              AppMethodBeat.o(268725);
              return;
            }
            if (ContactLabelManagerUI.this.JVk)
            {
              if (ContactLabelManagerUI.this.JVm)
              {
                ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramAnonymousView, localaw);
                AppMethodBeat.o(268725);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("label_id", localaw.field_labelID);
              ContactLabelManagerUI.this.setResult(-1, paramAnonymousView);
              ContactLabelManagerUI.this.finish();
              AppMethodBeat.o(268725);
              return;
            }
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, localaw.field_labelID, localaw.field_labelName);
          }
        }
        AppMethodBeat.o(268725);
      }
      
      public final void aE(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(268738);
        if ((ContactLabelManagerUI.this.JVk) || (ContactLabelManagerUI.f(ContactLabelManagerUI.this)))
        {
          AppMethodBeat.o(268738);
          return;
        }
        aw localaw = ContactLabelManagerUI.b(ContactLabelManagerUI.this).Zz(paramAnonymousInt);
        if ((localaw != null) && (localaw.field_isTemporary) && (localaw.field_labelID == -1000000))
        {
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "onItemLongClick, is no lebal title item, position = ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(268738);
          return;
        }
        ContactLabelManagerUI.n(ContactLabelManagerUI.this).a(paramAnonymousView, paramAnonymousInt, -1L, ContactLabelManagerUI.this, ContactLabelManagerUI.this, ContactLabelManagerUI.l(ContactLabelManagerUI.this), ContactLabelManagerUI.m(ContactLabelManagerUI.this));
        AppMethodBeat.o(268738);
      }
      
      public final void aX(Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(268730);
        ContactLabelManagerUI.k(ContactLabelManagerUI.this);
        ContactLabelManagerUI.this.startActivityForResult(paramAnonymousIntent, 8001);
        AppMethodBeat.o(268730);
      }
    };
    if ((this.JVm) && (this.JVk))
    {
      addTextOptionMenu(1, getString(b.j.app_nextstep), new ContactLabelManagerUI.5(this), null, y.b.adEJ);
      aNr();
    }
    Object localObject = this.JVb;
    int i;
    if (!this.JVk)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      this.JUZ = findViewById(R.h.fQC);
      this.JUZ.setOnClickListener(this.JVB);
      this.JVa = ((WeImageView)findViewById(R.h.fQD));
      this.JVa.setImageDrawable(bb.m(this, R.k.icons_outlined_add, com.tencent.mm.cd.a.w(this, R.e.Link)));
      this.JVa.setIconColor(getResources().getColor(R.e.Link));
      this.JVe.setEnabled(false);
      com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 1L, 0L, 0L, 0L);
      localObject = this.JVn;
      if (this.JVk) {
        break label743;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.label.ui.widget.c)localObject).JYD = bool;
      this.JVj = findViewById(R.h.fMp);
      if (this.JVj != null) {
        this.JVj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(268740);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (ContactLabelManagerUI.b(ContactLabelManagerUI.this) != null) {
              ContactLabelManagerUI.b(ContactLabelManagerUI.this).fTJ();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(268740);
          }
        });
      }
      this.bEA = findViewById(R.h.fMU);
      if ((this.JVk) && ((this.bEA.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject = (ViewGroup.MarginLayoutParams)this.bEA.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
        this.bEA.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(26229);
      return;
      i = 8;
      break;
      label743:
      bool = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26239);
    Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(26239);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(26239);
      return;
      Object localObject1;
      Object localObject2;
      if ((this.JVk) && (this.JVm))
      {
        localObject1 = paramIntent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject1) });
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Select_Contact", (String)localObject1);
        setResult(-1, (Intent)localObject2);
        finish();
      }
      else
      {
        localObject1 = paramIntent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject1) });
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = new Intent(paramIntent);
          ((Intent)localObject2).putExtra("label_source", "label_source_Address");
          ((Intent)localObject2).putExtra("last_page_source_type", 1);
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUm, 1) == 1)
          {
            Log.i("MicroMsg.Label.ContactLabelManagerUI", "startActivity ContactEditLabel ");
            ((Intent)localObject2).setClass(this, ContactEditLabel.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("Select_Contact", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            Log.i("MicroMsg.Label.ContactLabelManagerUI", "startActivity ContactLabelEditUI ");
            ((Intent)localObject2).setClass(this, ContactLabelEditUI.class);
          }
          localObject1 = paramIntent.getStringExtra("contact_choose_label_list");
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject1) });
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject1 = Util.stringToList((String)localObject1, ",");
            try
            {
              localObject2 = ((List)localObject1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                String str = (String)((Iterator)localObject2).next();
                if ((!Util.isNullOrNil(str)) && (!this.JVn.JXy.contains(str))) {
                  this.JVn.JXy.add(str);
                }
              }
              com.tencent.mm.plugin.label.c.d(getIntent().getIntExtra("key_label_click_source", 0), 11L, ((List)localObject1).size(), 0L, 0L);
              this.JVn.bZE.notifyChanged();
              fTm();
            }
            catch (Exception localException) {}
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26230);
    super.onCreate(paramBundle);
    initView();
    bh.baH().postToWorker(new ContactLabelManagerUI.7(this));
    d.fTa().add(this.JVC);
    com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(26230);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26235);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.JVn != null) && (i >= 0))
    {
      aw localaw = this.JVn.Zz(i);
      if (localaw != null)
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.p.b(paramView.getContext(), localaw.field_labelName));
        paramContextMenu.add(0, 0, 0, getString(R.l.app_delete));
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(26235);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26233);
    d.fTa().remove(this.JVC);
    super.onDestroy();
    AppMethodBeat.o(26233);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(268958);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (this.JVi))
    {
      bool = fTn();
      AppMethodBeat.o(268958);
      return bool;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(268958);
    return bool;
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26236);
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.JVn != null) && (i >= 0))
    {
      paramMenuItem = this.JVn.Zz(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26236);
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMenuItem);
      aT(localArrayList);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26232);
    bh.aZW().b(636, this);
    bh.aZW().b(5882, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.JVD);
    super.onPause();
    AppMethodBeat.o(26232);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26231);
    bh.aZW().a(636, this);
    bh.aZW().a(5882, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.JVD);
    if (this.JVx) {
      xP(true);
    }
    for (;;)
    {
      super.onResume();
      AppMethodBeat.o(26231);
      return;
      this.JVx = true;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(26237);
    Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramp.getType())
    {
    default: 
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
      AppMethodBeat.o(26237);
      return;
    case 636: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.label.b.c)paramp).JUk;
        if (!d.fTa().mM(paramString))
        {
          Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
          fTe();
          AppMethodBeat.o(26237);
          return;
        }
        hideLoading();
        xP(false);
        if ((paramString != null) && (paramString.size() > 0))
        {
          if (this.JVn == null) {
            break label374;
          }
          paramp = paramString.iterator();
          aw localaw;
          for (paramInt1 = 0; paramp.hasNext(); paramInt1 = ((Integer)this.JVn.JVs.get(Integer.valueOf(localaw.field_labelID))).intValue() + paramInt1) {
            localaw = (aw)paramp.next();
          }
        }
      }
      break;
    }
    for (;;)
    {
      long l2 = getIntent().getIntExtra("key_label_click_source", 0);
      if (this.JVz == 2) {}
      for (long l1 = 7L;; l1 = 12L)
      {
        com.tencent.mm.plugin.label.c.d(l2, l1, paramString.size(), 0L, paramInt1);
        AppMethodBeat.o(26237);
        return;
      }
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
      fTe();
      AppMethodBeat.o(26237);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((ly)c.c.b(((com.tencent.mm.plugin.label.b.b)paramp).rr.otC)).YNr == 0)
        {
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "[onSceneEnd] sort success is this type.");
          AppMethodBeat.o(26237);
          return;
        }
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "[onSceneEnd] sort success no this type.");
        AppMethodBeat.o(26237);
        return;
      }
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "[onSceneEnd] sort fail.");
      AppMethodBeat.o(26237);
      return;
      label374:
      paramInt1 = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(26227);
      JVP = new a("Normal", 0);
      JVQ = new a("Empty", 1);
      JVR = new a[] { JVP, JVQ };
      AppMethodBeat.o(26227);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */