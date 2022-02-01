package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI
  extends MMPreference
  implements g
{
  private ProgressDialog ift;
  private ap mHandler;
  private boolean sFJ;
  private String sMa;
  private String sMb;
  private String sMc;
  private ah sMd;
  private boolean sMe;
  private boolean sMf;
  private String sMg;
  private com.tencent.mm.ui.base.preference.f sMh;
  private ContactListExpandPreference sMi;
  private InputClearablePreference sMj;
  private Preference sMk;
  private PreferenceTitleCategory sMl;
  private boolean sMm;
  private ArrayList<String> sMn;
  private ArrayList<String> sMo;
  private HashSet<String> sMp;
  private HashSet<String> sMq;
  private HashSet<String> sMr;
  private String sMs;
  private String sMt;
  private boolean sMu;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.sMf = false;
    this.sMm = true;
    this.sFJ = true;
    this.sMn = new ArrayList();
    this.sMo = new ArrayList();
    this.sMp = new HashSet();
    this.sMq = new HashSet();
    this.sMr = new HashSet();
    this.mHandler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26162);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ad.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(26162);
          return;
        case 6001: 
          ContactLabelEditUI.a(ContactLabelEditUI.this);
          AppMethodBeat.o(26162);
          return;
        }
        com.tencent.mm.plugin.label.a.hYu.Ll();
        AppMethodBeat.o(26162);
      }
    };
    AppMethodBeat.o(26178);
  }
  
  private void Ug(String paramString)
  {
    AppMethodBeat.i(26195);
    com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void a(ah paramah)
  {
    AppMethodBeat.i(26197);
    if (!e.cIR().a(paramah, new String[] { "labelID" }))
    {
      ad.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      cIY();
      AppMethodBeat.o(26197);
      return;
    }
    cIZ();
    AppMethodBeat.o(26197);
  }
  
  private void aeM(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(2131755906);
    this.ift = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        az.aeS().cancel(635);
        az.aeS().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void aeN(String paramString)
  {
    AppMethodBeat.i(26188);
    if (bt.isNullOrNil(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(26188);
      return;
    }
  }
  
  private static boolean aeO(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!bt.isNullOrNil(e.cIR().aeI(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void cIU()
  {
    AppMethodBeat.i(26187);
    if (this.sMi != null)
    {
      this.sMi.B(null, this.sMn);
      if ((this.sMn == null) || (this.sMn.size() <= 0)) {
        this.sMi.eyo();
      }
    }
    if (this.sMj != null) {
      this.sMj.setText(this.sMb);
    }
    AppMethodBeat.o(26187);
  }
  
  private void cIV()
  {
    AppMethodBeat.i(26189);
    ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.sMp != null) {}
    for (int i = this.sMp.size();; i = 0)
    {
      if (this.sMr != null) {}
      for (int j = this.sMr.size();; j = 0)
      {
        ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.sMq.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.vKh;
          String str = u.aqG();
          if (this.sMe)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).f(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.sMm) {
            break label299;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.sMb);
          setResult(0, (Intent)localObject);
          if (!this.sMu) {
            break label262;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          k = 2;
          break;
          label262:
          com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label299:
        if (i > 0)
        {
          if (this.sMu) {
            com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label344:
          if (j > 0)
          {
            if (!this.sMu) {
              break label434;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label344;
          label434:
          com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void cIW()
  {
    AppMethodBeat.i(26190);
    ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    Ug(getString(2131755143));
    AppMethodBeat.o(26190);
  }
  
  private void cIX()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.sMp == null)
    {
      i = 0;
      if (this.sMr != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.sMr.size())
    {
      ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.sMp == null) || (this.sMp.size() <= 0)) {
        break label238;
      }
      this.sMp.size();
      localIterator = this.sMp.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        az.arV();
        localObject2 = com.tencent.mm.model.c.apM().aHY((String)localObject2);
        localObject3 = ((au)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.ha((String)localObject3, this.sMc);
        ad.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new dit();
          ((dit)localObject3).mAQ = ((au)localObject2).field_username;
          ((dit)localObject3).DbA = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.sMp.size();
      break;
    }
    label238:
    if ((this.sMr != null) && (this.sMr.size() > 0))
    {
      this.sMr.size();
      localIterator = this.sMr.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        az.arV();
        localObject3 = com.tencent.mm.model.c.apM().aHY((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hb((String)localObject3, this.sMc);
        ad.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new dit();
          ((dit)localObject3).mAQ = ((String)localObject2);
          ((dit)localObject3).DbA = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      az.aeS().a((n)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    cIV();
    AppMethodBeat.o(26192);
  }
  
  private void cIY()
  {
    AppMethodBeat.i(26198);
    Ug(getString(2131758023));
    AppMethodBeat.o(26198);
  }
  
  private void cIZ()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  public String getIdentString()
  {
    if (this.sMm) {
      return "_New";
    }
    return "_Edit";
  }
  
  public int getResourceId()
  {
    return 2131951688;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26183);
    if (this.sMu)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!bt.isNullOrNil(this.sMc)) {
        break label561;
      }
      this.sMm = true;
      this.sMg = getString(2131762004);
      label73:
      setMMTitle(this.sMg);
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
      addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26167);
          ContactLabelEditUI.b(ContactLabelEditUI.this);
          AppMethodBeat.o(26167);
          return true;
        }
      }, null, r.b.FOB);
      this.sMh = getPreferenceScreen();
      this.sMi = ((ContactListExpandPreference)this.sMh.aKk("contact_label_contact_list"));
      this.sMi.a(this.sMh, this.sMi.mKey);
      this.sMi.ub(true);
      this.sMi.uc(true);
      this.sMi.eyq();
      this.sMi.eyk();
      this.sMi.a(new s.b()
      {
        public final boolean kL(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.sMi.a(new ContactListExpandPreference.a()
      {
        public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(204851);
          paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).US(paramAnonymousInt);
          ad.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousViewGroup });
          ContactLabelEditUI.a(ContactLabelEditUI.this, paramAnonymousViewGroup);
          AppMethodBeat.o(204851);
        }
        
        public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(204848);
          Intent localIntent;
          if (ContactLabelEditUI.c(ContactLabelEditUI.this).UR(paramAnonymousInt))
          {
            paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).US(paramAnonymousInt);
            paramAnonymousView = ContactLabelEditUI.c(ContactLabelEditUI.this).UT(paramAnonymousInt);
            if (bt.isNullOrNil(paramAnonymousViewGroup))
            {
              AppMethodBeat.o(204848);
              return;
            }
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
            localIntent.putExtra("Contact_RoomNickname", paramAnonymousView);
            if (!ContactLabelEditUI.d(ContactLabelEditUI.this)) {
              break label125;
            }
          }
          label125:
          for (paramAnonymousInt = 17;; paramAnonymousInt = 15)
          {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", paramAnonymousInt);
            com.tencent.mm.plugin.label.a.hYt.c(localIntent, ContactLabelEditUI.this);
            AppMethodBeat.o(204848);
            return;
          }
        }
        
        public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
        
        public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(204850);
          ContactLabelEditUI.e(ContactLabelEditUI.this);
          AppMethodBeat.o(204850);
        }
        
        public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
        {
          AppMethodBeat.i(204849);
          if (ContactLabelEditUI.c(ContactLabelEditUI.this) != null) {
            ContactLabelEditUI.c(ContactLabelEditUI.this).eyo();
          }
          AppMethodBeat.o(204849);
        }
      });
      this.sMj = ((InputClearablePreference)this.sMh.aKk("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.sMj;
      localInputClearablePreference.sNE = getString(2131760607);
      if (localInputClearablePreference.sNJ != null) {
        localInputClearablePreference.sNJ.setHint(localInputClearablePreference.sNE);
      }
      this.sMj.hMd = getString(2131760616);
      localInputClearablePreference = this.sMj;
      localInputClearablePreference.sNF = getString(2131755144);
      if (localInputClearablePreference.sNL != null) {
        localInputClearablePreference.sNL.setText(localInputClearablePreference.sNF);
      }
      this.sMj.sNG = 36;
      this.sMj.sNI = this.sMm;
      this.sMj.sNN = new InputClearablePreference.a()
      {
        public final void Zo(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).mF(false);
          AppMethodBeat.o(26172);
        }
        
        public final void mD(boolean paramAnonymousBoolean)
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
      this.sMj.setText(this.sMb);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.sMm) {
        break label611;
      }
      if ((this.sMn == null) || (this.sMn.size() <= 0)) {
        break label594;
      }
      this.sMi.B(null, this.sMn);
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
      this.sMk = this.sMh.aKk("contact_label_delete");
      this.sMl = ((PreferenceTitleCategory)this.sMh.aKk("contact_label_empty_category"));
      if (!this.sMm) {
        break label629;
      }
      this.sMh.d(this.sMk);
      this.sMh.d(this.sMl);
      AppMethodBeat.o(26183);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.sMm = false;
      this.sMd = e.cIR().aHP(this.sMc);
      this.sMg = getString(2131762003);
      break label73;
      label594:
      this.sMi.aE(new ArrayList());
      continue;
      label611:
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = e.cIR().aHN(ContactLabelEditUI.j(ContactLabelEditUI.this));
          if (localArrayList == null)
          {
            ad.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
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
    if (!this.sMf) {
      this.sMh.d(this.sMk);
    }
    AppMethodBeat.o(26183);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26184);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!bt.isNullOrNil(str))
      {
        paramIntent = bt.S(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!bt.isNullOrNil(str))
            {
              if ((!w.sD(str)) || (this.sMn.contains(str)) || (str.equals(this.sMs))) {
                break label312;
              }
              this.sMn.add(str);
              if ((this.sMo != null) && (!this.sMo.contains(paramIntent.get(paramInt1)))) {
                this.sMp.add(str);
              }
              if (bool) {
                this.sMq.add(str);
              }
              if ((this.sMr != null) && (this.sMr.contains(str))) {
                this.sMr.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label312:
              ad.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
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
    if (((!bt.isNullOrNil(this.sMb)) && (!this.sMb.equals(this.sMa))) || ((this.sMp != null) && (this.sMp.size() > 0)) || ((this.sMr != null) && (this.sMr.size() > 0)))
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131762782), "", getString(2131756751), getString(2131756754), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    this.sMs = u.aqG();
    this.sMc = getIntent().getStringExtra("label_id");
    this.sMa = getIntent().getStringExtra("label_name");
    this.sMb = getIntent().getStringExtra("label_name");
    this.sMe = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.sMt = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.sMt != null) && (this.sMt.equals("label_source_Address")))
    {
      bool = true;
      this.sMu = bool;
      this.sMf = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (bt.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = bt.S(paramBundle.split(","));
      this.sMn = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label322;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label322;
      }
      str = (String)paramBundle.get(i);
      if (!bt.isNullOrNil(str))
      {
        if ((!w.sD(str)) || (this.sMn.contains(str)) || (str.equals(this.sMs))) {
          break label302;
        }
        this.sMn.add(str);
        this.sMp.add(str);
        if (this.sMe) {
          this.sMq.add(str);
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
      ad.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label322:
    az.aeS().a(635, this);
    az.aeS().a(637, this);
    az.aeS().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    az.aeS().b(635, this);
    az.aeS().b(637, this);
    az.aeS().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.c(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    az.aeS().b(636, this);
    super.onPause();
    AppMethodBeat.o(26181);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26185);
    paramf = paramPreference.mKey;
    if (bt.isNullOrNil(paramf))
    {
      ad.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
      AppMethodBeat.o(26185);
      return false;
    }
    if (paramf.equals("contact_label_delete")) {
      com.tencent.mm.ui.base.h.d(this, getString(2131760605), "", getString(2131755707), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    ad.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    AppMethodBeat.o(26185);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26180);
    com.tencent.mm.modelstat.d.c(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    az.aeS().a(636, this);
    aeN(this.sMb);
    cIU();
    super.onResume();
    AppMethodBeat.o(26180);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26186);
    ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.label.b.a)paramn).cIT().Cxi;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (bkp)paramString.get(0);
          ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.DIq, paramString.DIp });
          this.sMc = paramString.DIq;
          cIX();
          AppMethodBeat.o(26186);
          return;
        }
        cIW();
        AppMethodBeat.o(26186);
        return;
      }
      cIW();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.sMc;
        String str = this.sMb;
        ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramn = e.cIR().aHP(paramString);
            paramString = paramn;
            if (paramn == null) {
              paramString = new ah();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.Br(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.Bs(str);
            e.cIR().b(true, paramString, new String[] { "labelID" });
            cIX();
            AppMethodBeat.o(26186);
            return;
          }
        }
        catch (Exception paramn)
        {
          for (;;)
          {
            ad.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { String.valueOf(paramString) });
            paramInt1 = -1;
            continue;
            cIW();
          }
        }
      }
      cIW();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        cIV();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        cIW();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.sMd);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          ad.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          cIY();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */