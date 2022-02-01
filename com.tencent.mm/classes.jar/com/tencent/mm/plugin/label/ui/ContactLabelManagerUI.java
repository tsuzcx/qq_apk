package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, i, o.g
{
  private int apU;
  private MMHandler mHandler;
  private ListView mListView;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private View rhx;
  private HashMap<Integer, Integer> yCA;
  private boolean yCB;
  private View.OnClickListener yCC;
  private MStorage.IOnStorageChange yCD;
  private MStorageEx.IOnStorageChange yCE;
  private b yCu;
  private View yCv;
  private View yCw;
  private boolean yCx;
  private a yCy;
  private ArrayList<au> yCz;
  
  public ContactLabelManagerUI()
  {
    AppMethodBeat.i(26228);
    this.yCu = b.yCK;
    this.ppd = 0;
    this.ppe = 0;
    this.yCx = false;
    this.yCz = new ArrayList();
    this.yCA = new HashMap();
    this.yCB = true;
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
          ContactLabelManagerUI.this.aCL(ContactLabelManagerUI.this.getString(2131756029));
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.this.hideLoading();
        }
      }
    };
    this.yCC = new ContactLabelManagerUI.6(this);
    this.yCD = new ContactLabelManagerUI.7(this);
    this.yCE = new MStorageEx.IOnStorageChange()
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
  
  private void aCO(String paramString)
  {
    AppMethodBeat.i(26240);
    if (!e.ecf().gC(paramString))
    {
      Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
      ecm();
      AppMethodBeat.o(26240);
      return;
    }
    ecn();
    AppMethodBeat.o(26240);
  }
  
  private void ecm()
  {
    AppMethodBeat.i(26241);
    hideLoading();
    amW(getString(2131758275));
    AppMethodBeat.o(26241);
  }
  
  private void ecn()
  {
    AppMethodBeat.i(26242);
    hideLoading();
    qE(false);
    AppMethodBeat.o(26242);
  }
  
  private void qE(final boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(26238);
      Log.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26210);
          ContactLabelManagerUI.a(ContactLabelManagerUI.this, e.ecf().gBV());
          if ((ContactLabelManagerUI.g(ContactLabelManagerUI.this) == null) || (ContactLabelManagerUI.g(ContactLabelManagerUI.this).size() <= 0))
          {
            Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.h(ContactLabelManagerUI.this))
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
              ContactLabelManagerUI.i(ContactLabelManagerUI.this);
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(26208);
                ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.yCL);
                if ((ContactLabelManagerUI.4.this.yCH) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
                {
                  ContactLabelManagerUI.c(ContactLabelManagerUI.this).removeMessages(5002);
                  ContactLabelManagerUI.c(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5003, 0L);
                }
                AppMethodBeat.o(26208);
              }
            });
            AppMethodBeat.o(26210);
            return;
          }
          Log.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
          if (ContactLabelManagerUI.h(ContactLabelManagerUI.this))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            ContactLabelManagerUI.i(ContactLabelManagerUI.this);
          }
          if ((ContactLabelManagerUI.g(ContactLabelManagerUI.this) != null) && (ContactLabelManagerUI.g(ContactLabelManagerUI.this).size() > 0))
          {
            int j = ContactLabelManagerUI.g(ContactLabelManagerUI.this).size();
            e.ecf().aHn();
            int i = 0;
            if (i < j)
            {
              int k = ((au)ContactLabelManagerUI.g(ContactLabelManagerUI.this).get(i)).field_labelID;
              ArrayList localArrayList = e.ecf().bjA(String.valueOf(k));
              if ((localArrayList != null) && (localArrayList.size() > 0)) {
                ContactLabelManagerUI.j(ContactLabelManagerUI.this).put(Integer.valueOf(k), Integer.valueOf(localArrayList.size()));
              }
              for (;;)
              {
                i += 1;
                break;
                ContactLabelManagerUI.j(ContactLabelManagerUI.this).put(Integer.valueOf(k), Integer.valueOf(0));
              }
            }
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(26209);
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.yCK);
              ContactLabelManagerUI.a locala = ContactLabelManagerUI.k(ContactLabelManagerUI.this);
              locala.mData = ContactLabelManagerUI.g(ContactLabelManagerUI.this);
              locala.notifyDataSetChanged();
              ContactLabelManagerUI.k(ContactLabelManagerUI.this).notifyDataSetInvalidated();
              if ((ContactLabelManagerUI.4.this.yCH) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
              {
                ContactLabelManagerUI.c(ContactLabelManagerUI.this).removeMessages(5002);
                ContactLabelManagerUI.c(ContactLabelManagerUI.this).sendEmptyMessageDelayed(5003, 400L);
              }
              AppMethodBeat.o(26209);
            }
          });
          AppMethodBeat.o(26210);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(26211);
          String str = super.toString() + "|updateData";
          AppMethodBeat.o(26211);
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
    return 2131493778;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26229);
    this.yCx = getIntent().getBooleanExtra("select_label", false);
    this.apU = com.tencent.mm.cb.a.aG(getContext(), 2131165535);
    setMMTitle(getString(2131762115));
    if (!this.yCx) {
      addTextOptionMenu(0, getString(2131762124), new ContactLabelManagerUI.9(this));
    }
    setBackBtn(new ContactLabelManagerUI.10(this));
    this.yCy = new a();
    this.rhx = findViewById(2131302987);
    this.yCv = findViewById(2131302980);
    this.yCw = findViewById(2131302988);
    this.yCw.setOnClickListener(this.yCC);
    this.mListView = ((ListView)findViewById(2131302986));
    if (!this.yCx)
    {
      this.pqr = new com.tencent.mm.ui.widget.b.a(this);
      this.mListView.setOnTouchListener(new ContactLabelManagerUI.11(this));
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
    this.mListView.setAdapter(this.yCy);
    this.mListView.setOnItemClickListener(this);
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
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      Log.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject) });
      if (!Util.isNullOrNil((String)localObject))
      {
        Intent localIntent = new Intent(paramIntent);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        localIntent.putExtra("Select_Contact", (String)localObject);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26230);
    super.onCreate(paramBundle);
    initView();
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26220);
        bg.azz().a(new com.tencent.mm.plugin.label.b.c(), 0);
        AppMethodBeat.o(26220);
      }
    });
    e.ecf().add(this.yCD);
    com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(26230);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26235);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.yCy != null) && (i >= 0))
    {
      au localau = this.yCy.Pt(i);
      if (localau != null)
      {
        paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), localau.field_labelName));
        paramContextMenu.add(0, 0, 0, getString(2131755778));
        paramContextMenu.add(0, 1, 1, getString(2131755792));
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(26235);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26233);
    e.ecf().remove(this.yCD);
    super.onDestroy();
    AppMethodBeat.o(26233);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(26234);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if ((this.yCy != null) && (paramInt >= 0))
    {
      paramView = this.yCy.Pt(paramInt);
      if (paramView != null)
      {
        if (!this.yCx) {
          break label145;
        }
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("label_id", paramView.field_labelID);
        setResult(-1, paramAdapterView);
        finish();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(26234);
      return;
      label145:
      paramAdapterView = paramView.field_labelID;
      paramView = paramView.field_labelName;
      localObject = new Intent();
      ((Intent)localObject).putExtra("label_id", paramAdapterView);
      ((Intent)localObject).putExtra("label_name", paramView);
      ((Intent)localObject).putExtra("label_source", "label_source_Address");
      ((Intent)localObject).setClass(this, ContactLabelEditUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (Util.isNullOrNil(paramAdapterView)) {
        if ((this.yCz == null) || (this.yCz.isEmpty())) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
        } else {
          com.tencent.mm.plugin.report.service.h.CyF.a(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        }
      }
    }
  }
  
  public void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26236);
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.yCy != null) && (i >= 0))
    {
      paramMenuItem = this.yCy.Pt(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26236);
      return;
      com.tencent.mm.ui.base.h.c(this, getString(2131762117), "", getString(2131755778), getString(2131755761), new DialogInterface.OnClickListener()new ContactLabelManagerUI.3
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26207);
          if (paramMenuItem != null)
          {
            if (!paramMenuItem.field_isTemporary) {
              break label91;
            }
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramMenuItem.field_labelID);
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
            AppMethodBeat.o(26207);
            return;
            label91:
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, paramMenuItem);
          }
        }
      }, new ContactLabelManagerUI.3(this));
      AppMethodBeat.o(26236);
      return;
      Intent localIntent = new Intent();
      localIntent.setClass(this, ContactLabelEditUI.class);
      localIntent.putExtra("label_id", paramMenuItem.field_labelID);
      localIntent.putExtra("label_name", paramMenuItem.field_labelName);
      localIntent.putExtra("label_source", "label_source_Address");
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramMenuItem.axQ(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramMenuItem.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26232);
    bg.azz().b(636, this);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.yCE);
    super.onPause();
    AppMethodBeat.o(26232);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26231);
    bg.azz().a(636, this);
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.yCE);
    qE(true);
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
      aCO(((com.tencent.mm.plugin.label.b.b)paramq).yBU);
      AppMethodBeat.o(26237);
      return;
    }
    Log.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
    ecm();
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
    ArrayList<au> mData;
    
    a() {}
    
    public final au Pt(int paramInt)
    {
      AppMethodBeat.i(26222);
      if ((this.mData == null) || (paramInt > this.mData.size()))
      {
        AppMethodBeat.o(26222);
        return null;
      }
      au localau = (au)this.mData.get(paramInt);
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
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(ContactLabelManagerUI.this).inflate(2131493776, paramViewGroup, false);
        paramViewGroup = new c(paramView);
        Object localObject = paramViewGroup.yDB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cb.a.aH(ContactLabelManagerUI.this, 2131165585) * com.tencent.mm.cb.a.jj(ContactLabelManagerUI.this)));
        paramViewGroup.yDB.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setTag(paramViewGroup);
        localObject = Pt(paramInt);
        SpannableString localSpannableString = l.e(ContactLabelManagerUI.this.getContext(), ((au)localObject).field_labelName, ContactLabelManagerUI.l(ContactLabelManagerUI.this));
        paramViewGroup.yDz.setText(localSpannableString);
        if ((ContactLabelManagerUI.j(ContactLabelManagerUI.this) == null) || (!ContactLabelManagerUI.j(ContactLabelManagerUI.this).containsKey(Integer.valueOf(((au)localObject).field_labelID)))) {
          break label231;
        }
        paramViewGroup.yDA.setVisibility(0);
        paramViewGroup.yDA.setText("(" + ContactLabelManagerUI.j(ContactLabelManagerUI.this).get(Integer.valueOf(((au)localObject).field_labelID)) + ")");
      }
      for (;;)
      {
        AppMethodBeat.o(26223);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        paramViewGroup.yDA.setVisibility(0);
        paramViewGroup.yDA.setText("(0)");
      }
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(26227);
      yCK = new b("Normal", 0);
      yCL = new b("Empty", 1);
      yCM = new b[] { yCK, yCL };
      AppMethodBeat.o(26227);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */