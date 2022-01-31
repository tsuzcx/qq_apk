package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.b.b;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, f, n.d
{
  private int afO;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private View lmC;
  private ak mHandler;
  private ListView mListView;
  private View nYA;
  private ContactLabelManagerUI.a nYB;
  private ArrayList<af> nYC;
  private HashMap<Integer, Integer> nYD;
  private boolean nYE;
  private View.OnClickListener nYF;
  private k.a nYG;
  private n.b nYH;
  private ContactLabelManagerUI.b nYy;
  private View nYz;
  
  public ContactLabelManagerUI()
  {
    AppMethodBeat.i(22606);
    this.nYy = ContactLabelManagerUI.b.nYN;
    this.jUm = 0;
    this.jUn = 0;
    this.nYC = new ArrayList();
    this.nYD = new HashMap();
    this.nYE = true;
    this.mHandler = new ContactLabelManagerUI.1(this);
    this.nYF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22591);
        ContactLabelManagerUI.b(ContactLabelManagerUI.this);
        AppMethodBeat.o(22591);
      }
    };
    this.nYG = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(22592);
        if (!bo.isNullOrNil(paramAnonymousString)) {
          ContactLabelManagerUI.a(ContactLabelManagerUI.this);
        }
        AppMethodBeat.o(22592);
      }
    };
    this.nYH = new ContactLabelManagerUI.8(this);
    AppMethodBeat.o(22606);
  }
  
  private void RW(String paramString)
  {
    AppMethodBeat.i(22618);
    if (!e.bKU().qD(paramString))
    {
      ab.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
      bLb();
      AppMethodBeat.o(22618);
      return;
    }
    bLc();
    AppMethodBeat.o(22618);
  }
  
  private void bLb()
  {
    AppMethodBeat.i(22619);
    hideLoading();
    La(getString(2131298938));
    AppMethodBeat.o(22619);
  }
  
  private void bLc()
  {
    AppMethodBeat.i(22620);
    hideLoading();
    iP(false);
    AppMethodBeat.o(22620);
  }
  
  private void iP(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(22616);
      ab.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      aw.RO().ac(new ContactLabelManagerUI.4(this, paramBoolean));
      AppMethodBeat.o(22616);
      return;
    }
    finally {}
  }
  
  public int getLayoutId()
  {
    return 2130969260;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22607);
    this.afO = com.tencent.mm.cb.a.ao(getContext(), 2131427809);
    setMMTitle(getString(2131301000));
    addTextOptionMenu(0, getString(2131301009), new ContactLabelManagerUI.9(this));
    setBackBtn(new ContactLabelManagerUI.10(this));
    this.nYB = new ContactLabelManagerUI.a(this);
    this.lmC = findViewById(2131823170);
    this.nYz = findViewById(2131823172);
    this.nYA = findViewById(2131823173);
    this.nYA.setOnClickListener(this.nYF);
    this.mListView = ((ListView)findViewById(2131823171));
    this.jVd = new com.tencent.mm.ui.widget.c.a(this);
    this.mListView.setOnTouchListener(new ContactLabelManagerUI.11(this));
    this.mListView.setOnItemLongClickListener(new ContactLabelManagerUI.12(this));
    this.mListView.setAdapter(this.nYB);
    this.mListView.setOnItemClickListener(this);
    AppMethodBeat.o(22607);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22617);
    ab.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(22617);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(22617);
      return;
      String str = paramIntent.getStringExtra("Select_Contact");
      ab.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!bo.isNullOrNil(str))
      {
        Intent localIntent = new Intent(paramIntent);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        localIntent.putExtra("Select_Contact", str);
        startActivity(localIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22608);
    super.onCreate(paramBundle);
    initView();
    aw.RO().ac(new ContactLabelManagerUI.13(this));
    e.bKU().add(this.nYG);
    com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(22608);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(22613);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.nYB != null) && (i >= 0))
    {
      af localaf = this.nYB.xZ(i);
      if (localaf != null)
      {
        paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localaf.field_labelName));
        paramContextMenu.add(0, 0, 0, getString(2131296901));
        paramContextMenu.add(0, 1, 1, getString(2131296914));
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(22613);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22611);
    e.bKU().remove(this.nYG);
    super.onDestroy();
    AppMethodBeat.o(22611);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(22612);
    if ((this.nYB != null) && (paramInt >= 0))
    {
      paramView = this.nYB.xZ(paramInt);
      if (paramView != null)
      {
        paramAdapterView = paramView.field_labelID;
        paramView = paramView.field_labelName;
        Intent localIntent = new Intent();
        localIntent.putExtra("label_id", paramAdapterView);
        localIntent.putExtra("label_name", paramView);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        startActivity(localIntent);
        if (bo.isNullOrNil(paramAdapterView))
        {
          if ((this.nYC == null) || (this.nYC.isEmpty()))
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(22612);
            return;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        }
      }
    }
    AppMethodBeat.o(22612);
  }
  
  public void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(22614);
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.nYB != null) && (i >= 0))
    {
      paramMenuItem = this.nYB.xZ(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(22614);
      return;
      com.tencent.mm.ui.base.h.d(this, getString(2131301002), "", getString(2131296901), getString(2131296888), new ContactLabelManagerUI.2(this, paramMenuItem), new ContactLabelManagerUI.3(this));
      AppMethodBeat.o(22614);
      return;
      Intent localIntent = new Intent();
      localIntent.setClass(this, ContactLabelEditUI.class);
      localIntent.putExtra("label_id", paramMenuItem.field_labelID);
      localIntent.putExtra("label_name", paramMenuItem.field_labelName);
      localIntent.putExtra("label_source", "label_source_Address");
      startActivity(localIntent);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22610);
    aw.Rc().b(636, this);
    aw.aaz();
    c.YA().b(this.nYH);
    super.onPause();
    AppMethodBeat.o(22610);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22609);
    aw.Rc().a(636, this);
    aw.aaz();
    c.YA().a(this.nYH);
    iP(true);
    super.onResume();
    AppMethodBeat.o(22609);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(22615);
    ab.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    default: 
      ab.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
      AppMethodBeat.o(22615);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      RW(((b)paramm).nXY);
      AppMethodBeat.o(22615);
      return;
    }
    ab.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
    bLb();
    AppMethodBeat.o(22615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */