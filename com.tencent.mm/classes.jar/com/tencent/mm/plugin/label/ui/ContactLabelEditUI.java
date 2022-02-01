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
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.w.b;
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
  private boolean DUt;
  private boolean EdA;
  private ArrayList<String> EdB;
  private ArrayList<String> EdC;
  private HashSet<String> EdD;
  private HashSet<String> EdE;
  private HashSet<String> EdF;
  private String EdG;
  private String EdH;
  private boolean EdI;
  private String Edo;
  private String Edp;
  private String Edq;
  private au Edr;
  private boolean Eds;
  private boolean Edt;
  private String Edu;
  private com.tencent.mm.ui.base.preference.f Edv;
  private ContactListExpandPreference Edw;
  private InputClearablePreference Edx;
  private Preference Edy;
  private PreferenceTitleCategory Edz;
  private MMHandler mHandler;
  private ProgressDialog mRa;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.Edt = false;
    this.EdA = true;
    this.DUt = true;
    this.EdB = new ArrayList();
    this.EdC = new ArrayList();
    this.EdD = new HashSet();
    this.EdE = new HashSet();
    this.EdF = new HashSet();
    this.mHandler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26162);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          Log.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(26162);
          return;
        case 6001: 
          ContactLabelEditUI.a(ContactLabelEditUI.this);
          AppMethodBeat.o(26162);
          return;
        }
        com.tencent.mm.plugin.label.a.mIH.abC();
        AppMethodBeat.o(26162);
      }
    };
    AppMethodBeat.o(26178);
  }
  
  private void a(au paramau)
  {
    AppMethodBeat.i(26197);
    if (!e.eLd().a(paramau, new String[] { "labelID" }))
    {
      Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      eLk();
      AppMethodBeat.o(26197);
      return;
    }
    eLl();
    AppMethodBeat.o(26197);
  }
  
  private void aMS(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(R.l.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        bh.aGY().cancel(635);
        bh.aGY().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void aMT(String paramString)
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
  
  private static boolean aMU(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!Util.isNullOrNil(e.eLd().aMO(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(26195);
    com.tencent.mm.ui.base.h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void eLg()
  {
    AppMethodBeat.i(26187);
    if (this.Edw != null)
    {
      this.Edw.s(null, this.EdB);
      if ((this.EdB == null) || (this.EdB.size() <= 0)) {
        this.Edw.hkC();
      }
    }
    if (this.Edx != null) {
      this.Edx.setText(this.Edp);
    }
    AppMethodBeat.o(26187);
  }
  
  private void eLh()
  {
    AppMethodBeat.i(26189);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.EdD != null) {}
    for (int i = this.EdD.size();; i = 0)
    {
      if (this.EdF != null) {}
      for (int j = this.EdF.size();; j = 0)
      {
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.EdE.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.IzE;
          String str = z.bcZ();
          if (this.Eds)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).a(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.EdA) {
            break label319;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.Edp);
          ((Intent)localObject).putStringArrayListExtra("k_sns_label_add_label_usernames", new ArrayList(this.EdD));
          setResult(0, (Intent)localObject);
          if (!this.EdI) {
            break label282;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          k = 2;
          break;
          label282:
          com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label319:
        if (i > 0)
        {
          if (this.EdI) {
            com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label364:
          if (j > 0)
          {
            if (!this.EdI) {
              break label454;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label364;
          label454:
          com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void eLi()
  {
    AppMethodBeat.i(26190);
    Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    auQ(getString(R.l.emH));
    AppMethodBeat.o(26190);
  }
  
  private void eLj()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.EdD == null)
    {
      i = 0;
      if (this.EdF != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.EdF.size())
    {
      Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.EdD == null) || (this.EdD.size() <= 0)) {
        break label238;
      }
      this.EdD.size();
      localIterator = this.EdD.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bh.beI();
        localObject2 = com.tencent.mm.model.c.bbL().RG((String)localObject2);
        localObject3 = ((com.tencent.mm.f.c.ax)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.iG((String)localObject3, this.Edq);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new ezd();
          ((ezd)localObject3).UserName = ((com.tencent.mm.f.c.ax)localObject2).field_username;
          ((ezd)localObject3).SrJ = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.EdD.size();
      break;
    }
    label238:
    if ((this.EdF != null) && (this.EdF.size() > 0))
    {
      this.EdF.size();
      localIterator = this.EdF.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bh.beI();
        localObject3 = com.tencent.mm.model.c.bbL().RG((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.iH((String)localObject3, this.Edq);
        Log.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new ezd();
          ((ezd)localObject3).UserName = ((String)localObject2);
          ((ezd)localObject3).SrJ = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      bh.aGY().a((q)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    eLh();
    AppMethodBeat.o(26192);
  }
  
  private void eLk()
  {
    AppMethodBeat.i(26198);
    auQ(getString(R.l.eAZ));
    AppMethodBeat.o(26198);
  }
  
  private void eLl()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  public String getIdentString()
  {
    if (this.EdA) {
      return "_New";
    }
    return "_Edit";
  }
  
  public int getResourceId()
  {
    return R.o.eXF;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26183);
    if (this.EdI)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!Util.isNullOrNil(this.Edq)) {
        break label561;
      }
      this.EdA = true;
      this.Edu = getString(R.l.eOZ);
      label73:
      setMMTitle(this.Edu);
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
      addTextOptionMenu(0, getString(R.l.app_save), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(26167);
          ContactLabelEditUI.b(ContactLabelEditUI.this);
          AppMethodBeat.o(26167);
          return true;
        }
      }, null, w.b.Wao);
      this.Edv = getPreferenceScreen();
      this.Edw = ((ContactListExpandPreference)this.Edv.byG("contact_label_contact_list"));
      this.Edw.a(this.Edv, this.Edw.mKey);
      this.Edw.DZ(true);
      this.Edw.Ea(true);
      this.Edw.hkE();
      this.Edw.hky();
      this.Edw.a(new s.b()
      {
        public final boolean qx(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.Edw.a(new ContactListExpandPreference.a()
      {
        public final void asG()
        {
          AppMethodBeat.i(26169);
          if (ContactLabelEditUI.c(ContactLabelEditUI.this) != null) {
            ContactLabelEditUI.c(ContactLabelEditUI.this).hkC();
          }
          AppMethodBeat.o(26169);
        }
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(277715);
          Intent localIntent;
          if (ContactLabelEditUI.c(ContactLabelEditUI.this).aqp(paramAnonymousInt))
          {
            paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).aqq(paramAnonymousInt);
            String str = ContactLabelEditUI.c(ContactLabelEditUI.this).aqr(paramAnonymousInt);
            if (Util.isNullOrNil(paramAnonymousViewGroup))
            {
              AppMethodBeat.o(277715);
              return;
            }
            localIntent = new Intent();
            localIntent.putExtra("Contact_User", paramAnonymousViewGroup);
            localIntent.putExtra("Contact_RoomNickname", str);
            if (!ContactLabelEditUI.d(ContactLabelEditUI.this)) {
              break label125;
            }
          }
          label125:
          for (paramAnonymousInt = 17;; paramAnonymousInt = 15)
          {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", paramAnonymousInt);
            com.tencent.mm.plugin.label.a.mIG.c(localIntent, ContactLabelEditUI.this);
            AppMethodBeat.o(277715);
            return;
          }
        }
        
        public final void qv(int paramAnonymousInt)
        {
          AppMethodBeat.i(26171);
          String str = ContactLabelEditUI.c(ContactLabelEditUI.this).aqq(paramAnonymousInt);
          Log.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
          ContactLabelEditUI.a(ContactLabelEditUI.this, str);
          AppMethodBeat.o(26171);
        }
        
        public final void qw(int paramAnonymousInt)
        {
          AppMethodBeat.i(26170);
          ContactLabelEditUI.e(ContactLabelEditUI.this);
          AppMethodBeat.o(26170);
        }
      });
      this.Edx = ((InputClearablePreference)this.Edv.byG("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.Edx;
      localInputClearablePreference.Efh = getString(R.l.eKz);
      if (localInputClearablePreference.Efm != null) {
        localInputClearablePreference.Efm.setHint(localInputClearablePreference.Efh);
      }
      this.Edx.mvQ = getString(R.l.eKE);
      localInputClearablePreference = this.Edx;
      localInputClearablePreference.Efi = getString(R.l.emI);
      if (localInputClearablePreference.Efo != null) {
        localInputClearablePreference.Efo.setText(localInputClearablePreference.Efi);
      }
      this.Edx.Efj = 36;
      this.Edx.Efl = this.EdA;
      this.Edx.Efq = new InputClearablePreference.a()
      {
        public final void aEm(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).tH(false);
          AppMethodBeat.o(26172);
        }
        
        public final void tF(boolean paramAnonymousBoolean)
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
      this.Edx.setText(this.Edp);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.EdA) {
        break label611;
      }
      if ((this.EdB == null) || (this.EdB.size() <= 0)) {
        break label594;
      }
      this.Edw.s(null, this.EdB);
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
      this.Edy = this.Edv.byG("contact_label_delete");
      this.Edz = ((PreferenceTitleCategory)this.Edv.byG("contact_label_empty_category"));
      if (!this.EdA) {
        break label629;
      }
      this.Edv.d(this.Edy);
      this.Edv.d(this.Edz);
      AppMethodBeat.o(26183);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.EdA = false;
      this.Edr = e.eLd().bvZ(this.Edq);
      this.Edu = getString(R.l.eOY);
      break label73;
      label594:
      this.Edw.bv(new ArrayList());
      continue;
      label611:
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = e.eLd().bvX(ContactLabelEditUI.j(ContactLabelEditUI.this));
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
    if (!this.Edt) {
      this.Edv.d(this.Edy);
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
              if ((!ab.Ql(str)) || (this.EdB.contains(str)) || (str.equals(this.EdG))) {
                break label312;
              }
              this.EdB.add(str);
              if ((this.EdC != null) && (!this.EdC.contains(paramIntent.get(paramInt1)))) {
                this.EdD.add(str);
              }
              if (bool) {
                this.EdE.add(str);
              }
              if ((this.EdF != null) && (this.EdF.contains(str))) {
                this.EdF.remove(str);
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
    if (((!Util.isNullOrNil(this.Edp)) && (!this.Edp.equals(this.Edo))) || ((this.EdD != null) && (this.EdD.size() > 0)) || ((this.EdF != null) && (this.EdF.size() > 0)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.save_label_msg), "", getString(R.l.etA), getString(R.l.etB), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    this.EdG = z.bcZ();
    this.Edq = getIntent().getStringExtra("label_id");
    this.Edo = getIntent().getStringExtra("label_name");
    this.Edp = getIntent().getStringExtra("label_name");
    this.Eds = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.EdH = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.EdH != null) && (this.EdH.equals("label_source_Address")))
    {
      bool = true;
      this.EdI = bool;
      this.Edt = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = Util.stringsToList(paramBundle.split(","));
      this.EdB = new ArrayList();
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
        if ((!ab.Ql(str)) || (this.EdB.contains(str)) || (str.equals(this.EdG))) {
          break label302;
        }
        this.EdB.add(str);
        this.EdD.add(str);
        if (this.Eds) {
          this.EdE.add(str);
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
    bh.aGY().a(635, this);
    bh.aGY().a(637, this);
    bh.aGY().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    bh.aGY().b(635, this);
    bh.aGY().b(637, this);
    bh.aGY().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    bh.aGY().b(636, this);
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
      com.tencent.mm.ui.base.h.c(this, getString(R.l.eKx), "", getString(R.l.app_delete), getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    bh.aGY().a(636, this);
    aMT(this.Edp);
    eLg();
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
        paramString = ((com.tencent.mm.plugin.label.b.a)paramq).eLf().RIq;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (cpq)paramString.get(0);
          Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.TwW, paramString.TwV });
          this.Edq = paramString.TwW;
          eLj();
          AppMethodBeat.o(26186);
          return;
        }
        eLi();
        AppMethodBeat.o(26186);
        return;
      }
      eLi();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.Edq;
        String str = this.Edp;
        Log.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramq = e.eLd().bvZ(paramString);
            paramString = paramq;
            if (paramq == null) {
              paramString = new au();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.ZJ(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.ZK(str);
            e.eLd().b(true, paramString, new String[] { "labelID" });
            eLj();
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
            eLi();
          }
        }
      }
      eLi();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        eLh();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        eLi();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.Edr);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          Log.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          eLk();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */