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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI
  extends ContactLabelBaseUI
  implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener, f, n.e
{
  private int apI;
  private aq mHandler;
  private ListView mListView;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private View pQy;
  private k.a viA;
  private n.b viB;
  private b vir;
  private View vis;
  private View vit;
  private boolean viu;
  private a viv;
  private ArrayList<ap> viw;
  private HashMap<Integer, Integer> vix;
  private boolean viy;
  private View.OnClickListener viz;
  
  public ContactLabelManagerUI()
  {
    AppMethodBeat.i(26228);
    this.vir = b.viH;
    this.oef = 0;
    this.oeg = 0;
    this.viu = false;
    this.viw = new ArrayList();
    this.vix = new HashMap();
    this.viy = true;
    this.mHandler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26206);
        int i = paramAnonymousMessage.what;
        ae.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
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
          ContactLabelManagerUI.this.aps(ContactLabelManagerUI.this.getString(2131755936));
          AppMethodBeat.o(26206);
          return;
          ContactLabelManagerUI.this.hideLoading();
        }
      }
    };
    this.viz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26213);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ContactLabelManagerUI.b(ContactLabelManagerUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26213);
      }
    };
    this.viA = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(26214);
        if (!bu.isNullOrNil(paramAnonymousString)) {
          ContactLabelManagerUI.a(ContactLabelManagerUI.this);
        }
        AppMethodBeat.o(26214);
      }
    };
    this.viB = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26215);
        ae.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
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
  
  private void apv(String paramString)
  {
    AppMethodBeat.i(26240);
    if (!e.dif().Dc(paramString))
    {
      ae.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
      dim();
      AppMethodBeat.o(26240);
      return;
    }
    din();
    AppMethodBeat.o(26240);
  }
  
  private void dim()
  {
    AppMethodBeat.i(26241);
    hideLoading();
    acP(getString(2131758023));
    AppMethodBeat.o(26241);
  }
  
  private void din()
  {
    AppMethodBeat.i(26242);
    hideLoading();
    nV(false);
    AppMethodBeat.o(26242);
  }
  
  private void nV(final boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(26238);
      ae.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[] { String.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessageDelayed(5002, 400L);
      }
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26210);
          ContactLabelManagerUI.a(ContactLabelManagerUI.this, e.dif().fup());
          if ((ContactLabelManagerUI.g(ContactLabelManagerUI.this) == null) || (ContactLabelManagerUI.g(ContactLabelManagerUI.this).size() <= 0))
          {
            ae.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.h(ContactLabelManagerUI.this))
            {
              g.yxI.f(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
              ContactLabelManagerUI.i(ContactLabelManagerUI.this);
            }
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(26208);
                ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.viI);
                if ((ContactLabelManagerUI.4.this.viE) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
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
          ae.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
          if (ContactLabelManagerUI.h(ContactLabelManagerUI.this))
          {
            g.yxI.f(11346, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
            ContactLabelManagerUI.i(ContactLabelManagerUI.this);
          }
          if ((ContactLabelManagerUI.g(ContactLabelManagerUI.this) != null) && (ContactLabelManagerUI.g(ContactLabelManagerUI.this).size() > 0))
          {
            int j = ContactLabelManagerUI.g(ContactLabelManagerUI.this).size();
            e.dif().aoM();
            int i = 0;
            if (i < j)
            {
              int k = ((ap)ContactLabelManagerUI.g(ContactLabelManagerUI.this).get(i)).field_labelID;
              ArrayList localArrayList = e.dif().aUB(String.valueOf(k));
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
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(26209);
              ContactLabelManagerUI.a(ContactLabelManagerUI.this, ContactLabelManagerUI.b.viH);
              ContactLabelManagerUI.a locala = ContactLabelManagerUI.k(ContactLabelManagerUI.this);
              locala.mData = ContactLabelManagerUI.g(ContactLabelManagerUI.this);
              locala.notifyDataSetChanged();
              ContactLabelManagerUI.k(ContactLabelManagerUI.this).notifyDataSetInvalidated();
              if ((ContactLabelManagerUI.4.this.viE) && (ContactLabelManagerUI.c(ContactLabelManagerUI.this) != null))
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
    this.viu = getIntent().getBooleanExtra("select_label", false);
    this.apI = com.tencent.mm.cb.a.ax(getContext(), 2131165517);
    setMMTitle(getString(2131760603));
    if (!this.viu) {
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
    this.viv = new a();
    this.pQy = findViewById(2131301290);
    this.vis = findViewById(2131301283);
    this.vit = findViewById(2131301291);
    this.vit.setOnClickListener(this.viz);
    this.mListView = ((ListView)findViewById(2131301289));
    if (!this.viu)
    {
      this.ofu = new com.tencent.mm.ui.widget.b.a(this);
      this.mListView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(26218);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            ContactLabelManagerUI.a(ContactLabelManagerUI.this, (int)paramAnonymousMotionEvent.getRawX());
            ContactLabelManagerUI.b(ContactLabelManagerUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
    this.mListView.setAdapter(this.viv);
    this.mListView.setOnItemClickListener(this);
    AppMethodBeat.o(26229);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26239);
    ae.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ae.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[] { String.valueOf(localObject) });
      if (!bu.isNullOrNil((String)localObject))
      {
        Intent localIntent = new Intent(paramIntent);
        localIntent.putExtra("label_source", "label_source_Address");
        localIntent.setClass(this, ContactLabelEditUI.class);
        localIntent.putExtra("Select_Contact", (String)localObject);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26230);
    super.onCreate(paramBundle);
    initView();
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26220);
        bc.ajj().a(new com.tencent.mm.plugin.label.b.c(), 0);
        AppMethodBeat.o(26220);
      }
    });
    e.dif().add(this.viA);
    g.yxI.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2) });
    AppMethodBeat.o(26230);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(26235);
    int i = ((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).position;
    if ((this.viv != null) && (i >= 0))
    {
      ap localap = this.viv.Jq(i);
      if (localap != null)
      {
        paramContextMenu.setHeaderTitle(k.c(paramView.getContext(), localap.field_labelName));
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
    e.dif().remove(this.viA);
    super.onDestroy();
    AppMethodBeat.o(26233);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(26234);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if ((this.viv != null) && (paramInt >= 0))
    {
      paramView = this.viv.Jq(paramInt);
      if (paramView != null)
      {
        if (!this.viu) {
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
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "startLabelEditUI", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (bu.isNullOrNil(paramAdapterView)) {
        if ((this.viw == null) || (this.viw.isEmpty())) {
          g.yxI.f(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
        } else {
          g.yxI.f(11347, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
        }
      }
    }
  }
  
  public void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26236);
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if ((this.viv != null) && (i >= 0))
    {
      paramMenuItem = this.viv.Jq(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26236);
      return;
      h.e(this, getString(2131760605), "", getString(2131755707), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            g.yxI.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
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
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramMenuItem.ahE(), "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelManagerUI", "doEdit", "(Lcom/tencent/mm/storage/ContactLabel;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26232);
    bc.ajj().b(636, this);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.viB);
    super.onPause();
    AppMethodBeat.o(26232);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26231);
    bc.ajj().a(636, this);
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.viB);
    nV(true);
    super.onResume();
    AppMethodBeat.o(26231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(26237);
    ae.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    default: 
      ae.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
      AppMethodBeat.o(26237);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      apv(((com.tencent.mm.plugin.label.b.b)paramn).vhQ);
      AppMethodBeat.o(26237);
      return;
    }
    ae.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
    dim();
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
    ArrayList<ap> mData;
    
    a() {}
    
    public final ap Jq(int paramInt)
    {
      AppMethodBeat.i(26222);
      if ((this.mData == null) || (paramInt > this.mData.size()))
      {
        AppMethodBeat.o(26222);
        return null;
      }
      ap localap = (ap)this.mData.get(paramInt);
      AppMethodBeat.o(26222);
      return localap;
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
        Object localObject = paramViewGroup.vjy.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cb.a.ay(ContactLabelManagerUI.this, 2131165567) * com.tencent.mm.cb.a.iq(ContactLabelManagerUI.this)));
        paramViewGroup.vjy.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setTag(paramViewGroup);
        localObject = Jq(paramInt);
        SpannableString localSpannableString = k.b(ContactLabelManagerUI.this.getContext(), ((ap)localObject).field_labelName, ContactLabelManagerUI.l(ContactLabelManagerUI.this));
        paramViewGroup.vjw.setText(localSpannableString);
        if ((ContactLabelManagerUI.j(ContactLabelManagerUI.this) == null) || (!ContactLabelManagerUI.j(ContactLabelManagerUI.this).containsKey(Integer.valueOf(((ap)localObject).field_labelID)))) {
          break label231;
        }
        paramViewGroup.vjx.setVisibility(0);
        paramViewGroup.vjx.setText("(" + ContactLabelManagerUI.j(ContactLabelManagerUI.this).get(Integer.valueOf(((ap)localObject).field_labelID)) + ")");
      }
      for (;;)
      {
        AppMethodBeat.o(26223);
        return paramView;
        paramViewGroup = (c)paramView.getTag();
        break;
        label231:
        paramViewGroup.vjx.setVisibility(0);
        paramViewGroup.vjx.setText("(0)");
      }
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(26227);
      viH = new b("Normal", 0);
      viI = new b("Empty", 1);
      viJ = new b[] { viH, viI };
      AppMethodBeat.o(26227);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelManagerUI
 * JD-Core Version:    0.7.0.1
 */