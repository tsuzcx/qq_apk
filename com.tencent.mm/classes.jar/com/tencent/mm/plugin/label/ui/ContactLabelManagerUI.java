package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, i, q.g
{
  private b EdK;
  private View EdL;
  private View EdM;
  private boolean EdN;
  private String EdO;
  private boolean EdP;
  private a EdQ;
  private ArrayList<com.tencent.mm.storage.au> EdR;
  private HashMap<Integer, Integer> EdS;
  private boolean EdT;
  private View.OnClickListener EdU;
  private MStorage.IOnStorageChange EdV;
  private MStorageEx.IOnStorageChange EdW;
  private int ahN;
  private MMHandler mHandler;
  private ListView mListView;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private View uKG;
  
  public ContactLabelManagerUI()
  {
    AppMethodBeat.i(26228);
    this.EdK = b.Eee;
    this.syc = 0;
    this.syd = 0;
    this.EdN = false;
    this.EdP = false;
    this.EdR = new ArrayList();
    this.EdS = new HashMap();
    this.EdT = true;
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
          ContactLabelManagerUI.this.aMS(ContactLabelManagerUI.this.getString(R.l.app_waiting));
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.this.hideLoading();
        }
      }
    };
    this.EdU = new ContactLabelManagerUI.7(this);
    this.EdV = new ContactLabelManagerUI.8(this);
    this.EdW = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26215);
        Log.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
        if (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null)
        {
          ContactLabelManagerUI.c(ContactLabelManagerUI.this).removeMessages(5001);
          ContactLabelManagerUI.c(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5001, 400L);
        }
        AppMethodBeat.o(26215);
      }
    };
    AppMethodBeat.o(26228);
  }
  
  private void aMV(String paramString)
  {
    AppMethodBeat.i(26240);
    if (!e.eLd().ho(paramString))
    {
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
      eLk();
      AppMethodBeat.o(26240);
      return;
    }
    eLl();
    AppMethodBeat.o(26240);
  }
  
  private void atk()
  {
    AppMethodBeat.i(288900);
    if ((this.EdQ != null) && (this.EdQ.Eec.size() > 0)) {
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      updateOptionMenuText(1, getString(i.j.app_nextstep) + "(" + this.EdQ.Eec.size() + ")");
      AppMethodBeat.o(288900);
      return;
      enableOptionMenu(1, false);
    }
  }
  
  private void eLk()
  {
    AppMethodBeat.i(26241);
    hideLoading();
    auQ(getString(R.l.eAZ));
    AppMethodBeat.o(26241);
  }
  
  private void eLl()
  {
    AppMethodBeat.i(26242);
    hideLoading();
    tG(false);
    AppMethodBeat.o(26242);
  }
  
  private void tG(final boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(26238);
      Log.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268171);
          ContactLabelManagerUI.a(ContactLabelManagerUI.this, e.eLd().hyh());
          ArrayList localArrayList1;
          int i;
          int j;
          if ((ContactLabelManagerUI.h(ContactLabelManagerUI.this)) && (ContactLabelManagerUI.i(ContactLabelManagerUI.this)))
          {
            localArrayList1 = new ArrayList();
            i = 0;
            while (i < ContactLabelManagerUI.j(ContactLabelManagerUI.this).size())
            {
              com.tencent.mm.storage.au localau = (com.tencent.mm.storage.au)ContactLabelManagerUI.j(ContactLabelManagerUI.this).get(i);
              j = localau.field_labelID;
              ArrayList localArrayList2 = e.eLd().bvX(String.valueOf(j));
              if ((localArrayList2 == null) || (localArrayList2.size() <= 0)) {
                localArrayList1.add(localau);
              }
              i += 1;
            }
            if (localArrayList1.size() > 0) {
              ContactLabelManagerUI.j(ContactLabelManagerUI.this).removeAll(localArrayList1);
            }
            ContactLabelManagerUI.k(ContactLabelManagerUI.this).setVisibility(8);
          }
          if ((ContactLabelManagerUI.j(ContactLabelManagerUI.this) == null) || (ContactLabelManagerUI.j(ContactLabelManagerUI.this).size() <= 0))
          {
            Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.l(ContactLabelManagerUI.this))
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
              ContactLabelManagerUI.m(ContactLabelManagerUI.this);
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(270316);
                ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.Eef);
                if ((ContactLabelManagerUI.5.this.EdZ) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
                {
                  ContactLabelManagerUI.c(ContactLabelManagerUI.this).removeMessages(5002);
                  ContactLabelManagerUI.c(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5003, 0L);
                }
                AppMethodBeat.o(270316);
              }
            });
            AppMethodBeat.o(268171);
            return;
          }
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
          if (ContactLabelManagerUI.l(ContactLabelManagerUI.this))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            ContactLabelManagerUI.m(ContactLabelManagerUI.this);
          }
          if ((ContactLabelManagerUI.j(ContactLabelManagerUI.this) != null) && (ContactLabelManagerUI.j(ContactLabelManagerUI.this).size() > 0))
          {
            j = ContactLabelManagerUI.j(ContactLabelManagerUI.this).size();
            e.eLd().aPn();
            i = 0;
            if (i < j)
            {
              int k = ((com.tencent.mm.storage.au)ContactLabelManagerUI.j(ContactLabelManagerUI.this).get(i)).field_labelID;
              localArrayList1 = e.eLd().bvX(String.valueOf(k));
              if ((localArrayList1 != null) && (localArrayList1.size() > 0)) {
                ContactLabelManagerUI.n(ContactLabelManagerUI.this).put(Integer.valueOf(k), Integer.valueOf(localArrayList1.size()));
              }
              for (;;)
              {
                i += 1;
                break;
                ContactLabelManagerUI.n(ContactLabelManagerUI.this).put(Integer.valueOf(k), Integer.valueOf(0));
              }
            }
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(248782);
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.Eee);
              ContactLabelManagerUI.a locala = ContactLabelManagerUI.o(ContactLabelManagerUI.this);
              locala.mData = ContactLabelManagerUI.j(ContactLabelManagerUI.this);
              locala.notifyDataSetChanged();
              ContactLabelManagerUI.o(ContactLabelManagerUI.this).notifyDataSetInvalidated();
              if ((ContactLabelManagerUI.5.this.EdZ) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
              {
                ContactLabelManagerUI.c(ContactLabelManagerUI.this).removeMessages(5002);
                ContactLabelManagerUI.c(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5003, 400L);
              }
              AppMethodBeat.o(248782);
            }
          });
          AppMethodBeat.o(268171);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(268172);
          String str = super.toString() + "|updateData";
          AppMethodBeat.o(268172);
          return str;
        }
      });
      AppMethodBeat.o(26238);
      return;
    }
    finally {}
  }
  
  public int getLayoutId()
  {
    return R.i.efv;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26229);
    this.EdN = getIntent().getBooleanExtra("select_label", false);
    this.EdO = getIntent().getStringExtra("privacy_source_type");
    this.EdP = getIntent().getBooleanExtra("intent_status_from_privacy_setting", false);
    this.ahN = com.tencent.mm.ci.a.aY(getContext(), R.f.NormalTextSize);
    setMMTitle(getString(R.l.eKw));
    if (!this.EdN) {
      addTextOptionMenu(0, getString(R.l.eKC), new ContactLabelManagerUI.10(this));
    }
    setBackBtn(new ContactLabelManagerUI.11(this));
    this.EdQ = new a();
    this.uKG = findViewById(R.h.dKE);
    this.EdL = findViewById(R.h.dKy);
    this.EdM = findViewById(R.h.dKF);
    this.EdM.setOnClickListener(this.EdU);
    this.mListView = ((ListView)findViewById(R.h.dKD));
    if (!this.EdN)
    {
      this.szq = new com.tencent.mm.ui.widget.b.a(this);
      this.mListView.setOnTouchListener(new ContactLabelManagerUI.12(this));
      this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(26219);
          ContactLabelManagerUI.f(ContactLabelManagerUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ContactLabelManagerUI.this, ContactLabelManagerUI.this, ContactLabelManagerUI.d(ContactLabelManagerUI.this), ContactLabelManagerUI.e(ContactLabelManagerUI.this));
          AppMethodBeat.o(26219);
          return true;
        }
      });
    }
    this.mListView.setAdapter(this.EdQ);
    this.mListView.setOnItemClickListener(this);
    if ((this.EdP) && (this.EdN))
    {
      addTextOptionMenu(1, getString(i.j.app_nextstep), new ContactLabelManagerUI.14(this), null, w.b.Wao);
      atk();
    }
    AppMethodBeat.o(26229);
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
      Object localObject;
      Intent localIntent;
      if ((this.EdN) && (this.EdP))
      {
        localObject = paramIntent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject) });
        localIntent = new Intent();
        localIntent.putExtra("Select_Contact", (String)localObject);
        setResult(-1, localIntent);
        finish();
      }
      else
      {
        localObject = paramIntent.getStringExtra("Select_Contact");
        Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject) });
        if (!Util.isNullOrNil((String)localObject))
        {
          localIntent = new Intent(paramIntent);
          localIntent.putExtra("label_source", "label_source_Address");
          localIntent.setClass(this, ContactLabelEditUI.class);
          localIntent.putExtra("Select_Contact", (String)localObject);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26230);
    super.onCreate(paramBundle);
    initView();
    bh.aHJ().postToWorker(new ContactLabelManagerUI.2(this));
    e.eLd().add(this.EdV);
    com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(26230);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26235);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.EdQ != null) && (i >= 0))
    {
      com.tencent.mm.storage.au localau = this.EdQ.VC(i);
      if (localau != null)
      {
        paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), localau.field_labelName));
        paramContextMenu.add(0, 0, 0, getString(R.l.app_delete));
        paramContextMenu.add(0, 1, 1, getString(R.l.app_edit));
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(26235);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26233);
    e.eLd().remove(this.EdV);
    super.onDestroy();
    AppMethodBeat.o(26233);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(26234);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if ((this.EdQ != null) && (paramInt >= 0))
    {
      paramAdapterView = this.EdQ.VC(paramInt);
      if (paramAdapterView != null)
      {
        if (!this.EdN) {
          break label265;
        }
        if (this.EdP) {
          break label152;
        }
        paramView = new Intent();
        paramView.putExtra("label_id", paramAdapterView.field_labelID);
        setResult(-1, paramView);
        finish();
      }
    }
    label265:
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(26234);
      return;
      label152:
      if (((paramView.getTag() instanceof c)) && (((c)paramView.getTag()).Eff != null))
      {
        paramView = ((c)paramView.getTag()).Eff;
        boolean bool;
        if (!paramView.isChecked())
        {
          bool = true;
          label196:
          paramView.setChecked(bool);
          if (!paramView.isChecked()) {
            break label242;
          }
          this.EdQ.Eec.add(String.valueOf(paramAdapterView.field_labelID));
        }
        for (;;)
        {
          atk();
          break;
          bool = false;
          break label196;
          label242:
          this.EdQ.Eec.remove(String.valueOf(paramAdapterView.field_labelID));
        }
        paramView = paramAdapterView.field_labelID;
        paramAdapterView = paramAdapterView.field_labelName;
        localObject = new Intent();
        ((Intent)localObject).putExtra("label_id", paramView);
        ((Intent)localObject).putExtra("label_name", paramAdapterView);
        ((Intent)localObject).putExtra("label_source", "label_source_Address");
        ((Intent)localObject).setClass(this, ContactLabelEditUI.class);
        paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aFh(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramAdapterView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (Util.isNullOrNil(paramView)) {
          if ((this.EdR == null) || (this.EdR.isEmpty())) {
            com.tencent.mm.plugin.report.service.h.IzE.a(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.a(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          }
        }
      }
    }
  }
  
  public void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26236);
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.EdQ != null) && (i >= 0))
    {
      paramMenuItem = this.EdQ.VC(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26236);
      return;
      com.tencent.mm.ui.base.h.c(this, getString(R.l.eKx), "", getString(R.l.app_delete), getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(267383);
          if (paramMenuItem != null)
          {
            if (!paramMenuItem.field_isTemporary) {
              break label89;
            }
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramMenuItem.field_labelID);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
            AppMethodBeat.o(267383);
            return;
            label89:
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramMenuItem);
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(26236);
      return;
      Intent localIntent = new Intent();
      localIntent.setClass(this, ContactLabelEditUI.class);
      localIntent.putExtra("label_id", paramMenuItem.field_labelID);
      localIntent.putExtra("label_name", paramMenuItem.field_labelName);
      localIntent.putExtra("label_source", "label_source_Address");
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramMenuItem.aFh(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26232);
    bh.aGY().b(636, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.EdW);
    super.onPause();
    AppMethodBeat.o(26232);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26231);
    bh.aGY().a(636, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.EdW);
    tG(true);
    super.onResume();
    AppMethodBeat.o(26231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(26237);
    Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramq.getType())
    {
    default: 
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
      AppMethodBeat.o(26237);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      aMV(((com.tencent.mm.plugin.label.b.b)paramq).Edk);
      AppMethodBeat.o(26237);
      return;
    }
    Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
    eLk();
    AppMethodBeat.o(26237);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    public List<String> Eec;
    ArrayList<com.tencent.mm.storage.au> mData;
    
    a()
    {
      AppMethodBeat.i(221224);
      this.Eec = new LinkedList();
      AppMethodBeat.o(221224);
    }
    
    public final com.tencent.mm.storage.au VC(int paramInt)
    {
      AppMethodBeat.i(26222);
      if ((this.mData == null) || (paramInt > this.mData.size()))
      {
        AppMethodBeat.o(26222);
        return null;
      }
      com.tencent.mm.storage.au localau = (com.tencent.mm.storage.au)this.mData.get(paramInt);
      AppMethodBeat.o(26222);
      return localau;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(26221);
      if (this.mData == null)
      {
        AppMethodBeat.o(26221);
        return 0;
      }
      int i = this.mData.size();
      AppMethodBeat.o(26221);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(26223);
      final com.tencent.mm.storage.au localau = VC(paramInt);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(ContactLabelManagerUI.this).inflate(R.i.efu, paramViewGroup, false);
        paramViewGroup = new c(paramView);
        Object localObject = paramViewGroup.Efe.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.ci.a.aZ(ContactLabelManagerUI.this, R.f.SmallListHeight) * com.tencent.mm.ci.a.kn(ContactLabelManagerUI.this)));
        paramViewGroup.Efe.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramViewGroup.Efg.setImageDrawable(com.tencent.mm.ui.au.o(ContactLabelManagerUI.this, i.i.sns_label_more_btn, ContactLabelManagerUI.this.getResources().getColor(i.c.BW_50)));
        if ((ContactLabelManagerUI.i(ContactLabelManagerUI.this)) && (ContactLabelManagerUI.h(ContactLabelManagerUI.this)))
        {
          paramViewGroup.Efg.setVisibility(0);
          paramViewGroup.Eff.setVisibility(0);
          paramViewGroup.Efg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(283468);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$LabelAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, localau.field_labelID, localau.field_labelName);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$LabelAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(283468);
            }
          });
          paramView.setTag(paramViewGroup);
          label180:
          localObject = l.d(ContactLabelManagerUI.this.getContext(), localau.field_labelName, ContactLabelManagerUI.p(ContactLabelManagerUI.this));
          paramViewGroup.Efc.setText((CharSequence)localObject);
          if ((ContactLabelManagerUI.n(ContactLabelManagerUI.this) == null) || (!ContactLabelManagerUI.n(ContactLabelManagerUI.this).containsKey(Integer.valueOf(localau.field_labelID)))) {
            break label338;
          }
          paramViewGroup.Efd.setVisibility(0);
          paramViewGroup.Efd.setText("(" + ContactLabelManagerUI.n(ContactLabelManagerUI.this).get(Integer.valueOf(localau.field_labelID)) + ")");
        }
      }
      for (;;)
      {
        AppMethodBeat.o(26223);
        return paramView;
        paramViewGroup.Efg.setVisibility(8);
        paramViewGroup.Eff.setVisibility(8);
        break;
        paramViewGroup = (c)paramView.getTag();
        break label180;
        label338:
        paramViewGroup.Efd.setVisibility(0);
        paramViewGroup.Efd.setText("(0)");
      }
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(26227);
      Eee = new b("Normal", 0);
      Eef = new b("Empty", 1);
      Eeg = new b[] { Eee, Eef };
      AppMethodBeat.o(26227);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */