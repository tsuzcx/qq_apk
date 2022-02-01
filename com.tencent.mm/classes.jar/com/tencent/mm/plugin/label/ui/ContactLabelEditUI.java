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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
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
  implements com.tencent.mm.al.f
{
  private ProgressDialog iYL;
  private ap mHandler;
  private boolean uQd;
  private String uWA;
  private boolean uWB;
  private String uWh;
  private String uWi;
  private String uWj;
  private ao uWk;
  private boolean uWl;
  private boolean uWm;
  private String uWn;
  private com.tencent.mm.ui.base.preference.f uWo;
  private ContactListExpandPreference uWp;
  private InputClearablePreference uWq;
  private Preference uWr;
  private PreferenceTitleCategory uWs;
  private boolean uWt;
  private ArrayList<String> uWu;
  private ArrayList<String> uWv;
  private HashSet<String> uWw;
  private HashSet<String> uWx;
  private HashSet<String> uWy;
  private String uWz;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.uWm = false;
    this.uWt = true;
    this.uQd = true;
    this.uWu = new ArrayList();
    this.uWv = new ArrayList();
    this.uWw = new HashSet();
    this.uWx = new HashSet();
    this.uWy = new HashSet();
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
        com.tencent.mm.plugin.label.a.iRH.MR();
        AppMethodBeat.o(26162);
      }
    };
    AppMethodBeat.o(26178);
  }
  
  private void a(ao paramao)
  {
    AppMethodBeat.i(26197);
    if (!e.dfn().a(paramao, new String[] { "labelID" }))
    {
      ad.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      dfu();
      AppMethodBeat.o(26197);
      return;
    }
    dfv();
    AppMethodBeat.o(26197);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(26195);
    h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void aoq(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(2131755906);
    this.iYL = h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        ba.aiU().cancel(635);
        ba.aiU().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void aor(String paramString)
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
  
  private static boolean aos(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!bt.isNullOrNil(e.dfn().aom(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void dfq()
  {
    AppMethodBeat.i(26187);
    if (this.uWp != null)
    {
      this.uWp.A(null, this.uWu);
      if ((this.uWu == null) || (this.uWu.size() <= 0)) {
        this.uWp.fcH();
      }
    }
    if (this.uWq != null) {
      this.uWq.setText(this.uWi);
    }
    AppMethodBeat.o(26187);
  }
  
  private void dfr()
  {
    AppMethodBeat.i(26189);
    ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.uWw != null) {}
    for (int i = this.uWw.size();; i = 0)
    {
      if (this.uWy != null) {}
      for (int j = this.uWy.size();; j = 0)
      {
        ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.uWx.size();
          int n = Math.max(0, i - m);
          localObject = g.yhR;
          String str = u.aAm();
          if (this.uWl)
          {
            k = 1;
            ((g)localObject).f(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.uWt) {
            break label299;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.uWi);
          setResult(0, (Intent)localObject);
          if (!this.uWB) {
            break label262;
          }
          g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          k = 2;
          break;
          label262:
          g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label299:
        if (i > 0)
        {
          if (this.uWB) {
            g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label344:
          if (j > 0)
          {
            if (!this.uWB) {
              break label434;
            }
            g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label344;
          label434:
          g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void dfs()
  {
    AppMethodBeat.i(26190);
    ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    abY(getString(2131755143));
    AppMethodBeat.o(26190);
  }
  
  private void dft()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.uWw == null)
    {
      i = 0;
      if (this.uWy != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.uWy.size())
    {
      ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.uWw == null) || (this.uWw.size() <= 0)) {
        break label238;
      }
      this.uWw.size();
      localIterator = this.uWw.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        ba.aBQ();
        localObject2 = com.tencent.mm.model.c.azp().Bf((String)localObject2);
        localObject3 = ((aw)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hD((String)localObject3, this.uWj);
        ad.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new dtz();
          ((dtz)localObject3).nDo = ((aw)localObject2).field_username;
          ((dtz)localObject3).Gca = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.uWw.size();
      break;
    }
    label238:
    if ((this.uWy != null) && (this.uWy.size() > 0))
    {
      this.uWy.size();
      localIterator = this.uWy.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        ba.aBQ();
        localObject3 = com.tencent.mm.model.c.azp().Bf((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hE((String)localObject3, this.uWj);
        ad.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new dtz();
          ((dtz)localObject3).nDo = ((String)localObject2);
          ((dtz)localObject3).Gca = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      ba.aiU().a((n)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    dfr();
    AppMethodBeat.o(26192);
  }
  
  private void dfu()
  {
    AppMethodBeat.i(26198);
    abY(getString(2131758023));
    AppMethodBeat.o(26198);
  }
  
  private void dfv()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  public String getIdentString()
  {
    if (this.uWt) {
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
    if (this.uWB)
    {
      g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!bt.isNullOrNil(this.uWj)) {
        break label561;
      }
      this.uWt = true;
      this.uWn = getString(2131762004);
      label73:
      setMMTitle(this.uWn);
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
      }, null, com.tencent.mm.ui.s.b.JbS);
      this.uWo = getPreferenceScreen();
      this.uWp = ((ContactListExpandPreference)this.uWo.aVD("contact_label_contact_list"));
      this.uWp.a(this.uWo, this.uWp.mKey);
      this.uWp.vO(true);
      this.uWp.vP(true);
      this.uWp.fcJ();
      this.uWp.fcD();
      this.uWp.a(new com.tencent.mm.pluginsdk.ui.applet.s.b()
      {
        public final boolean le(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.uWp.a(new ContactListExpandPreference.a()
      {
        public final void YJ()
        {
          AppMethodBeat.i(26169);
          if (ContactLabelEditUI.c(ContactLabelEditUI.this) != null) {
            ContactLabelEditUI.c(ContactLabelEditUI.this).fcH();
          }
          AppMethodBeat.o(26169);
        }
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(193223);
          Intent localIntent;
          if (ContactLabelEditUI.c(ContactLabelEditUI.this).YW(paramAnonymousInt))
          {
            paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).YX(paramAnonymousInt);
            String str = ContactLabelEditUI.c(ContactLabelEditUI.this).YY(paramAnonymousInt);
            if (bt.isNullOrNil(paramAnonymousViewGroup))
            {
              AppMethodBeat.o(193223);
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
            com.tencent.mm.plugin.label.a.iRG.c(localIntent, ContactLabelEditUI.this);
            AppMethodBeat.o(193223);
            return;
          }
        }
        
        public final void lc(int paramAnonymousInt)
        {
          AppMethodBeat.i(26171);
          String str = ContactLabelEditUI.c(ContactLabelEditUI.this).YX(paramAnonymousInt);
          ad.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
          ContactLabelEditUI.a(ContactLabelEditUI.this, str);
          AppMethodBeat.o(26171);
        }
        
        public final void ld(int paramAnonymousInt)
        {
          AppMethodBeat.i(26170);
          ContactLabelEditUI.e(ContactLabelEditUI.this);
          AppMethodBeat.o(26170);
        }
      });
      this.uWq = ((InputClearablePreference)this.uWo.aVD("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.uWq;
      localInputClearablePreference.uXL = getString(2131760607);
      if (localInputClearablePreference.uXQ != null) {
        localInputClearablePreference.uXQ.setHint(localInputClearablePreference.uXL);
      }
      this.uWq.iFQ = getString(2131760616);
      localInputClearablePreference = this.uWq;
      localInputClearablePreference.uXM = getString(2131755144);
      if (localInputClearablePreference.uXS != null) {
        localInputClearablePreference.uXS.setText(localInputClearablePreference.uXM);
      }
      this.uWq.uXN = 36;
      this.uWq.uXP = this.uWt;
      this.uWq.uXU = new InputClearablePreference.a()
      {
        public final void ahV(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).nS(false);
          AppMethodBeat.o(26172);
        }
        
        public final void nQ(boolean paramAnonymousBoolean)
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
      this.uWq.setText(this.uWi);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.uWt) {
        break label611;
      }
      if ((this.uWu == null) || (this.uWu.size() <= 0)) {
        break label594;
      }
      this.uWp.A(null, this.uWu);
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
      this.uWr = this.uWo.aVD("contact_label_delete");
      this.uWs = ((PreferenceTitleCategory)this.uWo.aVD("contact_label_empty_category"));
      if (!this.uWt) {
        break label629;
      }
      this.uWo.d(this.uWr);
      this.uWo.d(this.uWs);
      AppMethodBeat.o(26183);
      return;
      g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.uWt = false;
      this.uWk = e.dfn().aTc(this.uWj);
      this.uWn = getString(2131762003);
      break label73;
      label594:
      this.uWp.aN(new ArrayList());
      continue;
      label611:
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = e.dfn().aTa(ContactLabelEditUI.j(ContactLabelEditUI.this));
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
    if (!this.uWm) {
      this.uWo.d(this.uWr);
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
        paramIntent = bt.U(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!bt.isNullOrNil(str))
            {
              if ((!w.zD(str)) || (this.uWu.contains(str)) || (str.equals(this.uWz))) {
                break label312;
              }
              this.uWu.add(str);
              if ((this.uWv != null) && (!this.uWv.contains(paramIntent.get(paramInt1)))) {
                this.uWw.add(str);
              }
              if (bool) {
                this.uWx.add(str);
              }
              if ((this.uWy != null) && (this.uWy.contains(str))) {
                this.uWy.remove(str);
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
    if (((!bt.isNullOrNil(this.uWi)) && (!this.uWi.equals(this.uWh))) || ((this.uWw != null) && (this.uWw.size() > 0)) || ((this.uWy != null) && (this.uWy.size() > 0)))
    {
      h.e(this, getString(2131762782), "", getString(2131756751), getString(2131756754), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    this.uWz = u.aAm();
    this.uWj = getIntent().getStringExtra("label_id");
    this.uWh = getIntent().getStringExtra("label_name");
    this.uWi = getIntent().getStringExtra("label_name");
    this.uWl = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.uWA = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.uWA != null) && (this.uWA.equals("label_source_Address")))
    {
      bool = true;
      this.uWB = bool;
      this.uWm = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (bt.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = bt.U(paramBundle.split(","));
      this.uWu = new ArrayList();
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
        if ((!w.zD(str)) || (this.uWu.contains(str)) || (str.equals(this.uWz))) {
          break label302;
        }
        this.uWu.add(str);
        this.uWw.add(str);
        if (this.uWl) {
          this.uWx.add(str);
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
    ba.aiU().a(635, this);
    ba.aiU().a(637, this);
    ba.aiU().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    ba.aiU().b(635, this);
    ba.aiU().b(637, this);
    ba.aiU().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    ba.aiU().b(636, this);
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
      h.e(this, getString(2131760605), "", getString(2131755707), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    com.tencent.mm.modelstat.d.d(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    ba.aiU().a(636, this);
    aor(this.uWi);
    dfq();
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
        paramString = ((com.tencent.mm.plugin.label.b.a)paramn).dfp().FuT;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (bsy)paramString.get(0);
          ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.GNp, paramString.GNo });
          this.uWj = paramString.GNp;
          dft();
          AppMethodBeat.o(26186);
          return;
        }
        dfs();
        AppMethodBeat.o(26186);
        return;
      }
      dfs();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.uWj;
        String str = this.uWi;
        ad.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramn = e.dfn().aTc(paramString);
            paramString = paramn;
            if (paramn == null) {
              paramString = new ao();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.IL(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.IM(str);
            e.dfn().b(true, paramString, new String[] { "labelID" });
            dft();
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
            dfs();
          }
        }
      }
      dfs();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        dfr();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        dfs();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.uWk);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          ad.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          dfu();
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