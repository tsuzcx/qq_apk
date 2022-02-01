package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI
  extends MMPreference
  implements i
{
  private ProgressDialog jZH;
  private MMHandler mHandler;
  private String yBY;
  private String yBZ;
  private String yCa;
  private au yCb;
  private boolean yCc;
  private boolean yCd;
  private String yCe;
  private com.tencent.mm.ui.base.preference.f yCf;
  private ContactListExpandPreference yCg;
  private InputClearablePreference yCh;
  private Preference yCi;
  private PreferenceTitleCategory yCj;
  private boolean yCk;
  private ArrayList<String> yCl;
  private ArrayList<String> yCm;
  private HashSet<String> yCn;
  private HashSet<String> yCo;
  private HashSet<String> yCp;
  private String yCq;
  private String yCr;
  private boolean yCs;
  private boolean yup;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.yCd = false;
    this.yCk = true;
    this.yup = true;
    this.yCl = new ArrayList();
    this.yCm = new ArrayList();
    this.yCn = new HashSet();
    this.yCo = new HashSet();
    this.yCp = new HashSet();
    this.mHandler = new ContactLabelEditUI.1(this, Looper.getMainLooper());
    AppMethodBeat.o(26178);
  }
  
  private void a(au paramau)
  {
    AppMethodBeat.i(26197);
    if (!e.ecf().a(paramau, new String[] { "labelID" }))
    {
      Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      ecm();
      AppMethodBeat.o(26197);
      return;
    }
    ecn();
    AppMethodBeat.o(26197);
  }
  
  private void aCL(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(2131755998);
    this.jZH = com.tencent.mm.ui.base.h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        bg.azz().cancel(635);
        bg.azz().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void aCM(String paramString)
  {
    AppMethodBeat.i(26188);
    if (Util.isNullOrNil(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(26188);
      return;
    }
  }
  
  private static boolean aCN(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!Util.isNullOrNil(e.ecf().aCH(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(26195);
    com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void eci()
  {
    AppMethodBeat.i(26187);
    if (this.yCg != null)
    {
      this.yCg.H(null, this.yCl);
      if ((this.yCl == null) || (this.yCl.size() <= 0)) {
        this.yCg.gpE();
      }
    }
    if (this.yCh != null) {
      this.yCh.setText(this.yBZ);
    }
    AppMethodBeat.o(26187);
  }
  
  private void ecj()
  {
    AppMethodBeat.i(26189);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.yCn != null) {}
    for (int i = this.yCn.size();; i = 0)
    {
      if (this.yCp != null) {}
      for (int j = this.yCp.size();; j = 0)
      {
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.yCo.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.CyF;
          String str = z.aTY();
          if (this.yCc)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).a(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.yCk) {
            break label299;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.yBZ);
          setResult(0, (Intent)localObject);
          if (!this.yCs) {
            break label262;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          k = 2;
          break;
          label262:
          com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label299:
        if (i > 0)
        {
          if (this.yCs) {
            com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label344:
          if (j > 0)
          {
            if (!this.yCs) {
              break label434;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label344;
          label434:
          com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void eck()
  {
    AppMethodBeat.i(26190);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    amW(getString(2131755161));
    AppMethodBeat.o(26190);
  }
  
  private void ecl()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.yCn == null)
    {
      i = 0;
      if (this.yCp != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.yCp.size())
    {
      Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.yCn == null) || (this.yCn.size() <= 0)) {
        break label238;
      }
      this.yCn.size();
      localIterator = this.yCn.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bg.aVF();
        localObject2 = com.tencent.mm.model.c.aSN().Kn((String)localObject2);
        localObject3 = ((com.tencent.mm.g.c.ax)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.it((String)localObject3, this.yCa);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new eov();
          ((eov)localObject3).UserName = ((com.tencent.mm.g.c.ax)localObject2).field_username;
          ((eov)localObject3).Lqm = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.yCn.size();
      break;
    }
    label238:
    if ((this.yCp != null) && (this.yCp.size() > 0))
    {
      this.yCp.size();
      localIterator = this.yCp.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bg.aVF();
        localObject3 = com.tencent.mm.model.c.aSN().Kn((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.iu((String)localObject3, this.yCa);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new eov();
          ((eov)localObject3).UserName = ((String)localObject2);
          ((eov)localObject3).Lqm = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      bg.azz().a((q)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    ecj();
    AppMethodBeat.o(26192);
  }
  
  private void ecm()
  {
    AppMethodBeat.i(26198);
    amW(getString(2131758275));
    AppMethodBeat.o(26198);
  }
  
  private void ecn()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  public String getIdentString()
  {
    if (this.yCk) {
      return "_New";
    }
    return "_Edit";
  }
  
  public int getResourceId()
  {
    return 2132017230;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26183);
    if (this.yCs)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!Util.isNullOrNil(this.yCa)) {
        break label561;
      }
      this.yCk = true;
      this.yCe = getString(2131764014);
      label73:
      setMMTitle(this.yCe);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26166);
          ContactLabelEditUI.this.onBackPressed();
          AppMethodBeat.o(26166);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26167);
          ContactLabelEditUI.b(ContactLabelEditUI.this);
          AppMethodBeat.o(26167);
          return true;
        }
      }, null, t.b.OGU);
      this.yCf = getPreferenceScreen();
      this.yCg = ((ContactListExpandPreference)this.yCf.bmg("contact_label_contact_list"));
      this.yCg.a(this.yCf, this.yCg.mKey);
      this.yCg.zU(true);
      this.yCg.zV(true);
      this.yCg.gpG();
      this.yCg.gpA();
      this.yCg.a(new s.b()
      {
        public final boolean oi(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.yCg.a(new ContactLabelEditUI.10(this));
      this.yCh = ((InputClearablePreference)this.yCf.bmg("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.yCh;
      localInputClearablePreference.yDC = getString(2131762119);
      if (localInputClearablePreference.yDH != null) {
        localInputClearablePreference.yDH.setHint(localInputClearablePreference.yDC);
      }
      this.yCh.jFn = getString(2131762128);
      localInputClearablePreference = this.yCh;
      localInputClearablePreference.yDD = getString(2131755162);
      if (localInputClearablePreference.yDJ != null) {
        localInputClearablePreference.yDJ.setText(localInputClearablePreference.yDD);
      }
      this.yCh.yDE = 36;
      this.yCh.yDG = this.yCk;
      this.yCh.yDL = new InputClearablePreference.a()
      {
        public final void auW(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).qF(false);
          AppMethodBeat.o(26172);
        }
        
        public final void qD(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(26173);
          if ((!ContactLabelEditUI.g(ContactLabelEditUI.this)) && (ContactLabelEditUI.h(ContactLabelEditUI.this)))
          {
            ContactLabelEditUI.this.enableOptionMenu(false);
            ContactLabelEditUI.i(ContactLabelEditUI.this);
            AppMethodBeat.o(26173);
            return;
          }
          ContactLabelEditUI.this.enableOptionMenu(paramAnonymousBoolean);
          AppMethodBeat.o(26173);
        }
      };
      this.yCh.setText(this.yBZ);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.yCk) {
        break label611;
      }
      if ((this.yCl == null) || (this.yCl.size() <= 0)) {
        break label594;
      }
      this.yCg.H(null, this.yCl);
    }
    for (;;)
    {
      if (getListView() != null) {
        getListView().setOnScrollListener(new AbsListView.OnScrollListener()
        {
          public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
          {
            AppMethodBeat.i(26176);
            if ((paramAnonymousInt == 2) || (paramAnonymousInt == 1)) {
              ContactLabelEditUI.this.hideVKB();
            }
            AppMethodBeat.o(26176);
          }
        });
      }
      this.yCi = this.yCf.bmg("contact_label_delete");
      this.yCj = ((PreferenceTitleCategory)this.yCf.bmg("contact_label_empty_category"));
      if (!this.yCk) {
        break label629;
      }
      this.yCf.e(this.yCi);
      this.yCf.e(this.yCj);
      AppMethodBeat.o(26183);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.yCk = false;
      this.yCb = e.ecf().bjC(this.yCa);
      this.yCe = getString(2131764013);
      break label73;
      label594:
      this.yCg.bg(new ArrayList());
      continue;
      label611:
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = e.ecf().bjA(ContactLabelEditUI.j(ContactLabelEditUI.this));
          if (localArrayList == null)
          {
            Log.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
            AppMethodBeat.o(26174);
            return;
          }
          if (localArrayList != null)
          {
            ContactLabelEditUI.a(ContactLabelEditUI.this, localArrayList);
            if (ContactLabelEditUI.k(ContactLabelEditUI.this) != null) {
              break label119;
            }
            ContactLabelEditUI.b(ContactLabelEditUI.this, new ArrayList());
          }
          for (;;)
          {
            ContactLabelEditUI.k(ContactLabelEditUI.this).addAll(localArrayList);
            if (ContactLabelEditUI.l(ContactLabelEditUI.this) != null) {
              ContactLabelEditUI.l(ContactLabelEditUI.this).sendEmptyMessage(6001);
            }
            AppMethodBeat.o(26174);
            return;
            label119:
            ContactLabelEditUI.k(ContactLabelEditUI.this).clear();
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(26175);
          String str = super.toString() + "|initView";
          AppMethodBeat.o(26175);
          return str;
        }
      });
    }
    label629:
    if (!this.yCd) {
      this.yCf.e(this.yCi);
    }
    AppMethodBeat.o(26183);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26184);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(26184);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26184);
      return;
      String str = paramIntent.getStringExtra("Select_Contact");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!Util.isNullOrNil(str))
      {
        paramIntent = Util.stringsToList(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!Util.isNullOrNil(str))
            {
              if ((!ab.IS(str)) || (this.yCl.contains(str)) || (str.equals(this.yCq))) {
                break label312;
              }
              this.yCl.add(str);
              if ((this.yCm != null) && (!this.yCm.contains(paramIntent.get(paramInt1)))) {
                this.yCn.add(str);
              }
              if (bool) {
                this.yCo.add(str);
              }
              if ((this.yCp != null) && (this.yCp.contains(str))) {
                this.yCp.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label312:
              Log.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
            }
          }
        }
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(6001);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26196);
    if (((!Util.isNullOrNil(this.yBZ)) && (!this.yBZ.equals(this.yBY))) || ((this.yCn != null) && (this.yCn.size() > 0)) || ((this.yCp != null) && (this.yCp.size() > 0)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131764867), "", getString(2131756913), getString(2131756916), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26164);
          ContactLabelEditUI.b(ContactLabelEditUI.this);
          AppMethodBeat.o(26164);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26165);
          ContactLabelEditUI.this.setResult(0);
          ContactLabelEditUI.this.finish();
          AppMethodBeat.o(26165);
        }
      });
      AppMethodBeat.o(26196);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(26196);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26179);
    super.onCreate(paramBundle);
    this.yCq = z.aTY();
    this.yCa = getIntent().getStringExtra("label_id");
    this.yBY = getIntent().getStringExtra("label_name");
    this.yBZ = getIntent().getStringExtra("label_name");
    this.yCc = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.yCr = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.yCr != null) && (this.yCr.equals("label_source_Address")))
    {
      bool = true;
      this.yCs = bool;
      this.yCd = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = Util.stringsToList(paramBundle.split(","));
      this.yCl = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label322;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label322;
      }
      str = (String)paramBundle.get(i);
      if (!Util.isNullOrNil(str))
      {
        if ((!ab.IS(str)) || (this.yCl.contains(str)) || (str.equals(this.yCq))) {
          break label302;
        }
        this.yCl.add(str);
        this.yCn.add(str);
        if (this.yCc) {
          this.yCo.add(str);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label195;
      bool = false;
      break;
      label302:
      Log.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label322:
    bg.azz().a(635, this);
    bg.azz().a(637, this);
    bg.azz().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    bg.azz().b(635, this);
    bg.azz().b(637, this);
    bg.azz().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    bg.azz().b(636, this);
    super.onPause();
    AppMethodBeat.o(26181);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26185);
    paramf = paramPreference.mKey;
    if (Util.isNullOrNil(paramf))
    {
      Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
      AppMethodBeat.o(26185);
      return false;
    }
    if (paramf.equals("contact_label_delete")) {
      com.tencent.mm.ui.base.h.c(this, getString(2131762117), "", getString(2131755778), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26177);
          ContactLabelEditUI.m(ContactLabelEditUI.this);
          AppMethodBeat.o(26177);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    AppMethodBeat.o(26185);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26180);
    com.tencent.mm.modelstat.d.d(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    bg.azz().a(636, this);
    aCM(this.yBZ);
    eci();
    super.onResume();
    AppMethodBeat.o(26180);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(26186);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((a)paramq).ech().KGW;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (cgu)paramString.get(0);
          Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.Mmc, paramString.Mmb });
          this.yCa = paramString.Mmc;
          ecl();
          AppMethodBeat.o(26186);
          return;
        }
        eck();
        AppMethodBeat.o(26186);
        return;
      }
      eck();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.yCa;
        String str = this.yBZ;
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramq = e.ecf().bjC(paramString);
            paramString = paramq;
            if (paramq == null) {
              paramString = new au();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.Sh(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.Si(str);
            e.ecf().b(true, paramString, new String[] { "labelID" });
            ecl();
            AppMethodBeat.o(26186);
            return;
          }
        }
        catch (Exception paramq)
        {
          for (;;)
          {
            Log.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { String.valueOf(paramString) });
            paramInt1 = -1;
            continue;
            eck();
          }
        }
      }
      eck();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ecj();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        eck();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.yCb);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          ecm();
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */