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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
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
  private ProgressDialog iFC;
  private ao mHandler;
  private boolean tNq;
  private String tTF;
  private String tTG;
  private String tTH;
  private ak tTI;
  private boolean tTJ;
  private boolean tTK;
  private String tTL;
  private com.tencent.mm.ui.base.preference.f tTM;
  private ContactListExpandPreference tTN;
  private InputClearablePreference tTO;
  private Preference tTP;
  private PreferenceTitleCategory tTQ;
  private boolean tTR;
  private ArrayList<String> tTS;
  private ArrayList<String> tTT;
  private HashSet<String> tTU;
  private HashSet<String> tTV;
  private HashSet<String> tTW;
  private String tTX;
  private String tTY;
  private boolean tTZ;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.tTK = false;
    this.tTR = true;
    this.tNq = true;
    this.tTS = new ArrayList();
    this.tTT = new ArrayList();
    this.tTU = new HashSet();
    this.tTV = new HashSet();
    this.tTW = new HashSet();
    this.mHandler = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26162);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ac.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(26162);
          return;
        case 6001: 
          ContactLabelEditUI.a(ContactLabelEditUI.this);
          AppMethodBeat.o(26162);
          return;
        }
        com.tencent.mm.plugin.label.a.iyy.Lj();
        AppMethodBeat.o(26162);
      }
    };
    AppMethodBeat.o(26178);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(26195);
    com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void a(ak paramak)
  {
    AppMethodBeat.i(26197);
    if (!e.cWc().a(paramak, new String[] { "labelID" }))
    {
      ac.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      cWj();
      AppMethodBeat.o(26197);
      return;
    }
    cWk();
    AppMethodBeat.o(26197);
  }
  
  private void ajE(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(2131755906);
    this.iFC = com.tencent.mm.ui.base.h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        az.agi().cancel(635);
        az.agi().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void ajF(String paramString)
  {
    AppMethodBeat.i(26188);
    if (bs.isNullOrNil(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(26188);
      return;
    }
  }
  
  private static boolean ajG(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!bs.isNullOrNil(e.cWc().ajA(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void cWf()
  {
    AppMethodBeat.i(26187);
    if (this.tTN != null)
    {
      this.tTN.y(null, this.tTS);
      if ((this.tTS == null) || (this.tTS.size() <= 0)) {
        this.tTN.eNI();
      }
    }
    if (this.tTO != null) {
      this.tTO.setText(this.tTG);
    }
    AppMethodBeat.o(26187);
  }
  
  private void cWg()
  {
    AppMethodBeat.i(26189);
    ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.tTU != null) {}
    for (int i = this.tTU.size();; i = 0)
    {
      if (this.tTW != null) {}
      for (int j = this.tTW.size();; j = 0)
      {
        ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.tTV.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.wUl;
          String str = u.axw();
          if (this.tTJ)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).f(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.tTR) {
            break label299;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.tTG);
          setResult(0, (Intent)localObject);
          if (!this.tTZ) {
            break label262;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          k = 2;
          break;
          label262:
          com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label299:
        if (i > 0)
        {
          if (this.tTZ) {
            com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label344:
          if (j > 0)
          {
            if (!this.tTZ) {
              break label434;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label344;
          label434:
          com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void cWh()
  {
    AppMethodBeat.i(26190);
    ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    Ys(getString(2131755143));
    AppMethodBeat.o(26190);
  }
  
  private void cWi()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.tTU == null)
    {
      i = 0;
      if (this.tTW != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.tTW.size())
    {
      ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.tTU == null) || (this.tTU.size() <= 0)) {
        break label238;
      }
      this.tTU.size();
      localIterator = this.tTU.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        az.ayM();
        localObject2 = com.tencent.mm.model.c.awB().aNt((String)localObject2);
        localObject3 = ((av)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hr((String)localObject3, this.tTH);
        ac.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new doi();
          ((doi)localObject3).ncR = ((av)localObject2).field_username;
          ((doi)localObject3).EuG = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.tTU.size();
      break;
    }
    label238:
    if ((this.tTW != null) && (this.tTW.size() > 0))
    {
      this.tTW.size();
      localIterator = this.tTW.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        az.ayM();
        localObject3 = com.tencent.mm.model.c.awB().aNt((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hs((String)localObject3, this.tTH);
        ac.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new doi();
          ((doi)localObject3).ncR = ((String)localObject2);
          ((doi)localObject3).EuG = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      az.agi().a((n)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    cWg();
    AppMethodBeat.o(26192);
  }
  
  private void cWj()
  {
    AppMethodBeat.i(26198);
    Ys(getString(2131758023));
    AppMethodBeat.o(26198);
  }
  
  private void cWk()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  public String getIdentString()
  {
    if (this.tTR) {
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
    if (this.tTZ)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!bs.isNullOrNil(this.tTH)) {
        break label561;
      }
      this.tTR = true;
      this.tTL = getString(2131762004);
      label73:
      setMMTitle(this.tTL);
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
      }, null, com.tencent.mm.ui.s.b.Hom);
      this.tTM = getPreferenceScreen();
      this.tTN = ((ContactListExpandPreference)this.tTM.aPN("contact_label_contact_list"));
      this.tTN.a(this.tTM, this.tTN.mKey);
      this.tTN.vc(true);
      this.tTN.vd(true);
      this.tTN.eNK();
      this.tTN.eNE();
      this.tTN.a(new com.tencent.mm.pluginsdk.ui.applet.s.b()
      {
        public final boolean kF(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.tTN.a(new ContactListExpandPreference.a()
      {
        public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(196006);
          paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).Xb(paramAnonymousInt);
          ac.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousViewGroup });
          ContactLabelEditUI.a(ContactLabelEditUI.this, paramAnonymousViewGroup);
          AppMethodBeat.o(196006);
        }
        
        public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(196003);
          Intent localIntent;
          if (ContactLabelEditUI.c(ContactLabelEditUI.this).Xa(paramAnonymousInt))
          {
            paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).Xb(paramAnonymousInt);
            paramAnonymousView = ContactLabelEditUI.c(ContactLabelEditUI.this).Xc(paramAnonymousInt);
            if (bs.isNullOrNil(paramAnonymousViewGroup))
            {
              AppMethodBeat.o(196003);
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
            com.tencent.mm.plugin.label.a.iyx.c(localIntent, ContactLabelEditUI.this);
            AppMethodBeat.o(196003);
            return;
          }
        }
        
        public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
        {
          AppMethodBeat.i(196005);
          ContactLabelEditUI.e(ContactLabelEditUI.this);
          AppMethodBeat.o(196005);
        }
        
        public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
        
        public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
        {
          AppMethodBeat.i(196004);
          if (ContactLabelEditUI.c(ContactLabelEditUI.this) != null) {
            ContactLabelEditUI.c(ContactLabelEditUI.this).eNI();
          }
          AppMethodBeat.o(196004);
        }
      });
      this.tTO = ((InputClearablePreference)this.tTM.aPN("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.tTO;
      localInputClearablePreference.tVj = getString(2131760607);
      if (localInputClearablePreference.tVo != null) {
        localInputClearablePreference.tVo.setHint(localInputClearablePreference.tVj);
      }
      this.tTO.imz = getString(2131760616);
      localInputClearablePreference = this.tTO;
      localInputClearablePreference.tVk = getString(2131755144);
      if (localInputClearablePreference.tVq != null) {
        localInputClearablePreference.tVq.setText(localInputClearablePreference.tVk);
      }
      this.tTO.tVl = 36;
      this.tTO.tVn = this.tTR;
      this.tTO.tVs = new InputClearablePreference.a()
      {
        public final void adW(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).ny(false);
          AppMethodBeat.o(26172);
        }
        
        public final void nw(boolean paramAnonymousBoolean)
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
      this.tTO.setText(this.tTG);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.tTR) {
        break label611;
      }
      if ((this.tTS == null) || (this.tTS.size() <= 0)) {
        break label594;
      }
      this.tTN.y(null, this.tTS);
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
      this.tTP = this.tTM.aPN("contact_label_delete");
      this.tTQ = ((PreferenceTitleCategory)this.tTM.aPN("contact_label_empty_category"));
      if (!this.tTR) {
        break label629;
      }
      this.tTM.d(this.tTP);
      this.tTM.d(this.tTQ);
      AppMethodBeat.o(26183);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.tTR = false;
      this.tTI = e.cWc().aNk(this.tTH);
      this.tTL = getString(2131762003);
      break label73;
      label594:
      this.tTN.aQ(new ArrayList());
      continue;
      label611:
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = e.cWc().aNi(ContactLabelEditUI.j(ContactLabelEditUI.this));
          if (localArrayList == null)
          {
            ac.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
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
    if (!this.tTK) {
      this.tTM.d(this.tTP);
    }
    AppMethodBeat.o(26183);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26184);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!bs.isNullOrNil(str))
      {
        paramIntent = bs.S(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!bs.isNullOrNil(str))
            {
              if ((!w.wG(str)) || (this.tTS.contains(str)) || (str.equals(this.tTX))) {
                break label312;
              }
              this.tTS.add(str);
              if ((this.tTT != null) && (!this.tTT.contains(paramIntent.get(paramInt1)))) {
                this.tTU.add(str);
              }
              if (bool) {
                this.tTV.add(str);
              }
              if ((this.tTW != null) && (this.tTW.contains(str))) {
                this.tTW.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label312:
              ac.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
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
    if (((!bs.isNullOrNil(this.tTG)) && (!this.tTG.equals(this.tTF))) || ((this.tTU != null) && (this.tTU.size() > 0)) || ((this.tTW != null) && (this.tTW.size() > 0)))
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
    this.tTX = u.axw();
    this.tTH = getIntent().getStringExtra("label_id");
    this.tTF = getIntent().getStringExtra("label_name");
    this.tTG = getIntent().getStringExtra("label_name");
    this.tTJ = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.tTY = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.tTY != null) && (this.tTY.equals("label_source_Address")))
    {
      bool = true;
      this.tTZ = bool;
      this.tTK = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (bs.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = bs.S(paramBundle.split(","));
      this.tTS = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label322;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label322;
      }
      str = (String)paramBundle.get(i);
      if (!bs.isNullOrNil(str))
      {
        if ((!w.wG(str)) || (this.tTS.contains(str)) || (str.equals(this.tTX))) {
          break label302;
        }
        this.tTS.add(str);
        this.tTU.add(str);
        if (this.tTJ) {
          this.tTV.add(str);
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
      ac.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label322:
    az.agi().a(635, this);
    az.agi().a(637, this);
    az.agi().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    az.agi().b(635, this);
    az.agi().b(637, this);
    az.agi().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    az.agi().b(636, this);
    super.onPause();
    AppMethodBeat.o(26181);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26185);
    paramf = paramPreference.mKey;
    if (bs.isNullOrNil(paramf))
    {
      ac.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
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
    ac.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    AppMethodBeat.o(26185);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26180);
    com.tencent.mm.modelstat.d.d(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    az.agi().a(636, this);
    ajF(this.tTG);
    cWf();
    super.onResume();
    AppMethodBeat.o(26180);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26186);
    ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.label.b.a)paramn).cWe().DPE;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (bol)paramString.get(0);
          ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.FdL, paramString.FdK });
          this.tTH = paramString.FdL;
          cWi();
          AppMethodBeat.o(26186);
          return;
        }
        cWh();
        AppMethodBeat.o(26186);
        return;
      }
      cWh();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tTH;
        String str = this.tTG;
        ac.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramn = e.cWc().aNk(paramString);
            paramString = paramn;
            if (paramn == null) {
              paramString = new ak();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.Fv(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.Fw(str);
            e.cWc().b(true, paramString, new String[] { "labelID" });
            cWi();
            AppMethodBeat.o(26186);
            return;
          }
        }
        catch (Exception paramn)
        {
          for (;;)
          {
            ac.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { String.valueOf(paramString) });
            paramInt1 = -1;
            continue;
            cWh();
          }
        }
      }
      cWh();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        cWg();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        cWh();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.tTI);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          ac.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          cWj();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */