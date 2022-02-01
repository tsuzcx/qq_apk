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
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.label.b.b;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, g, n.d
{
  private int anQ;
  private ao mHandler;
  private ListView mListView;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private View pgr;
  private b tUb;
  private View tUc;
  private View tUd;
  private boolean tUe;
  private a tUf;
  private ArrayList<ak> tUg;
  private HashMap<Integer, Integer> tUh;
  private boolean tUi;
  private View.OnClickListener tUj;
  private k.a tUk;
  private n.b tUl;
  
  public ContactLabelManagerUI()
  {
    AppMethodBeat.i(26228);
    this.tUb = b.tUr;
    this.nwY = 0;
    this.nwZ = 0;
    this.tUe = false;
    this.tUg = new ArrayList();
    this.tUh = new HashMap();
    this.tUi = true;
    this.mHandler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26206);
        int i = paramAnonymousMessage.what;
        ac.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
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
          ContactLabelManagerUI.this.ajE(ContactLabelManagerUI.this.getString(2131755936));
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.this.hideLoading();
        }
      }
    };
    this.tUj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26213);
        ContactLabelManagerUI.b(ContactLabelManagerUI.this);
        AppMethodBeat.o(26213);
      }
    };
    this.tUk = new ContactLabelManagerUI.7(this);
    this.tUl = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26215);
        ac.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
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
  
  private void ajH(String paramString)
  {
    AppMethodBeat.i(26240);
    if (!e.cWc().zB(paramString))
    {
      ac.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
      cWj();
      AppMethodBeat.o(26240);
      return;
    }
    cWk();
    AppMethodBeat.o(26240);
  }
  
  private void cWj()
  {
    AppMethodBeat.i(26241);
    hideLoading();
    Ys(getString(2131758023));
    AppMethodBeat.o(26241);
  }
  
  private void cWk()
  {
    AppMethodBeat.i(26242);
    hideLoading();
    nx(false);
    AppMethodBeat.o(26242);
  }
  
  private void nx(final boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(26238);
      ac.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26210);
          ContactLabelManagerUI.a(ContactLabelManagerUI.this, e.cWc().fam());
          if ((ContactLabelManagerUI.g(ContactLabelManagerUI.this) == null) || (ContactLabelManagerUI.g(ContactLabelManagerUI.this).size() <= 0))
          {
            ac.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.h(ContactLabelManagerUI.this))
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
              ContactLabelManagerUI.i(ContactLabelManagerUI.this);
            }
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(26208);
                ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.tUs);
                if ((ContactLabelManagerUI.4.this.tUo) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
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
          ac.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
          if (ContactLabelManagerUI.h(ContactLabelManagerUI.this))
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            ContactLabelManagerUI.i(ContactLabelManagerUI.this);
          }
          if ((ContactLabelManagerUI.g(ContactLabelManagerUI.this) != null) && (ContactLabelManagerUI.g(ContactLabelManagerUI.this).size() > 0))
          {
            int j = ContactLabelManagerUI.g(ContactLabelManagerUI.this).size();
            e.cWc().alK();
            int i = 0;
            if (i < j)
            {
              int k = ((ak)ContactLabelManagerUI.g(ContactLabelManagerUI.this).get(i)).field_labelID;
              ArrayList localArrayList = e.cWc().aNi(String.valueOf(k));
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
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(26209);
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.tUr);
              ContactLabelManagerUI.a locala = ContactLabelManagerUI.k(ContactLabelManagerUI.this);
              locala.mData = ContactLabelManagerUI.g(ContactLabelManagerUI.this);
              locala.notifyDataSetChanged();
              ContactLabelManagerUI.k(ContactLabelManagerUI.this).notifyDataSetInvalidated();
              if ((ContactLabelManagerUI.4.this.tUo) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
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
    return 2131493648;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26229);
    this.tUe = getIntent().getBooleanExtra("select_label", false);
    this.anQ = com.tencent.mm.cc.a.au(getContext(), 2131165517);
    setMMTitle(getString(2131760603));
    if (!this.tUe) {
      addTextOptionMenu(0, getString(2131760612), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26216);
          ContactLabelManagerUI.b(ContactLabelManagerUI.this);
          AppMethodBeat.o(26216);
          return false;
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26217);
        ContactLabelManagerUI.this.finish();
        AppMethodBeat.o(26217);
        return false;
      }
    });
    this.tUf = new a();
    this.pgr = findViewById(2131301290);
    this.tUc = findViewById(2131301283);
    this.tUd = findViewById(2131301291);
    this.tUd.setOnClickListener(this.tUj);
    this.mListView = ((ListView)findViewById(2131301289));
    if (!this.tUe)
    {
      this.nym = new com.tencent.mm.ui.widget.b.a(this);
      this.mListView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(26218);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, (int)paramAnonymousMotionEvent.getRawX());
            ContactLabelManagerUI.b(ContactLabelManagerUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(26218);
          return false;
        }
      });
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
    this.mListView.setAdapter(this.tUf);
    this.mListView.setOnItemClickListener(this);
    AppMethodBeat.o(26229);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26239);
    ac.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ac.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject) });
      if (!bs.isNullOrNil((String)localObject))
      {
        Intent localIntent = new Intent(paramIntent);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        localIntent.putExtra("Select_Contact", (String)localObject);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26230);
    super.onCreate(paramBundle);
    initView();
    az.agU().az(new ContactLabelManagerUI.13(this));
    e.cWc().add(this.tUk);
    com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(26230);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26235);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.tUf != null) && (i >= 0))
    {
      ak localak = this.tUf.Hw(i);
      if (localak != null)
      {
        paramContextMenu.setHeaderTitle(k.c(paramView.getContext(), localak.field_labelName));
        paramContextMenu.add(0, 0, 0, getString(2131755707));
        paramContextMenu.add(0, 1, 1, getString(2131755721));
      }
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(26235);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26233);
    e.cWc().remove(this.tUk);
    super.onDestroy();
    AppMethodBeat.o(26233);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(26234);
    if ((this.tUf != null) && (paramInt >= 0))
    {
      paramView = this.tUf.Hw(paramInt);
      if (paramView != null)
      {
        if (this.tUe)
        {
          paramAdapterView = new Intent();
          paramAdapterView.putExtra("label_id", paramView.field_labelID);
          setResult(-1, paramAdapterView);
          finish();
          AppMethodBeat.o(26234);
          return;
        }
        paramAdapterView = paramView.field_labelID;
        paramView = paramView.field_labelName;
        Intent localIntent = new Intent();
        localIntent.putExtra("label_id", paramAdapterView);
        localIntent.putExtra("label_name", paramView);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.aeD(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (bs.isNullOrNil(paramAdapterView))
        {
          if ((this.tUg == null) || (this.tUg.isEmpty()))
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
            AppMethodBeat.o(26234);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        }
      }
    }
    AppMethodBeat.o(26234);
  }
  
  public void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26236);
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.tUf != null) && (i >= 0))
    {
      paramMenuItem = this.tUf.Hw(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26236);
      return;
      com.tencent.mm.ui.base.h.d(this, getString(2131760605), "", getString(2131755707), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
            AppMethodBeat.o(26207);
            return;
            label91:
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
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramMenuItem.aeD(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26232);
    az.agi().b(636, this);
    az.ayM();
    com.tencent.mm.model.c.awB().b(this.tUl);
    super.onPause();
    AppMethodBeat.o(26232);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26231);
    az.agi().a(636, this);
    az.ayM();
    com.tencent.mm.model.c.awB().a(this.tUl);
    nx(true);
    super.onResume();
    AppMethodBeat.o(26231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(26237);
    ac.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    default: 
      ac.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
      AppMethodBeat.o(26237);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ajH(((b)paramn).tTB);
      AppMethodBeat.o(26237);
      return;
    }
    ac.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
    cWj();
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
    ArrayList<ak> mData;
    
    a() {}
    
    public final ak Hw(int paramInt)
    {
      AppMethodBeat.i(26222);
      if ((this.mData == null) || (paramInt > this.mData.size()))
      {
        AppMethodBeat.o(26222);
        return null;
      }
      ak localak = (ak)this.mData.get(paramInt);
      AppMethodBeat.o(26222);
      return localak;
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
        paramView = LayoutInflater.from(ContactLabelManagerUI.this).inflate(2131493646, paramViewGroup, false);
        paramViewGroup = new c(paramView);
        Object localObject = paramViewGroup.tVi.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cc.a.av(ContactLabelManagerUI.this, 2131165567) * com.tencent.mm.cc.a.ic(ContactLabelManagerUI.this)));
        paramViewGroup.tVi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setTag(paramViewGroup);
        localObject = Hw(paramInt);
        SpannableString localSpannableString = k.b(ContactLabelManagerUI.this.getContext(), ((ak)localObject).field_labelName, ContactLabelManagerUI.l(ContactLabelManagerUI.this));
        paramViewGroup.tVg.setText(localSpannableString);
        if ((ContactLabelManagerUI.j(ContactLabelManagerUI.this) == null) || (!ContactLabelManagerUI.j(ContactLabelManagerUI.this).containsKey(Integer.valueOf(((ak)localObject).field_labelID)))) {
          break label231;
        }
        paramViewGroup.tVh.setVisibility(0);
        paramViewGroup.tVh.setText("(" + ContactLabelManagerUI.j(ContactLabelManagerUI.this).get(Integer.valueOf(((ak)localObject).field_labelID)) + ")");
      }
      for (;;)
      {
        AppMethodBeat.o(26223);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        paramViewGroup.tVh.setVisibility(0);
        paramViewGroup.tVh.setText("(0)");
      }
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(26227);
      tUr = new b("Normal", 0);
      tUs = new b("Empty", 1);
      tUt = new b[] { tUr, tUs };
      AppMethodBeat.o(26227);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */