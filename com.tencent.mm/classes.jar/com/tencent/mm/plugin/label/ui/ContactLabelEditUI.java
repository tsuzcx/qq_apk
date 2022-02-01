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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.ak.f
{
  private ProgressDialog jbE;
  private aq mHandler;
  private boolean vbP;
  private String vhU;
  private String vhV;
  private String vhW;
  private ap vhX;
  private boolean vhY;
  private boolean vhZ;
  private String vib;
  private com.tencent.mm.ui.base.preference.f vic;
  private ContactListExpandPreference vid;
  private InputClearablePreference vie;
  private Preference vif;
  private PreferenceTitleCategory vig;
  private boolean vih;
  private ArrayList<String> vii;
  private ArrayList<String> vij;
  private HashSet<String> vik;
  private HashSet<String> vil;
  private HashSet<String> vim;
  private String vin;
  private String vio;
  private boolean vip;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(26178);
    this.vhZ = false;
    this.vih = true;
    this.vbP = true;
    this.vii = new ArrayList();
    this.vij = new ArrayList();
    this.vik = new HashSet();
    this.vil = new HashSet();
    this.vim = new HashSet();
    this.mHandler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26162);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ae.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(26162);
          return;
        case 6001: 
          ContactLabelEditUI.a(ContactLabelEditUI.this);
          AppMethodBeat.o(26162);
          return;
        }
        com.tencent.mm.plugin.label.a.iUA.MM();
        AppMethodBeat.o(26162);
      }
    };
    AppMethodBeat.o(26178);
  }
  
  private void a(ap paramap)
  {
    AppMethodBeat.i(26197);
    if (!e.dif().a(paramap, new String[] { "labelID" }))
    {
      ae.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      dim();
      AppMethodBeat.o(26197);
      return;
    }
    din();
    AppMethodBeat.o(26197);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(26195);
    h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(26195);
  }
  
  private void aps(String paramString)
  {
    AppMethodBeat.i(26193);
    getString(2131755906);
    this.jbE = h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(26163);
        bc.ajj().cancel(635);
        bc.ajj().cancel(637);
        AppMethodBeat.o(26163);
      }
    });
    AppMethodBeat.o(26193);
  }
  
  private void apt(String paramString)
  {
    AppMethodBeat.i(26188);
    if (bu.isNullOrNil(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(26188);
      return;
    }
  }
  
  private static boolean apu(String paramString)
  {
    AppMethodBeat.i(26191);
    if (!bu.isNullOrNil(e.dif().apo(paramString)))
    {
      AppMethodBeat.o(26191);
      return true;
    }
    AppMethodBeat.o(26191);
    return false;
  }
  
  private void dii()
  {
    AppMethodBeat.i(26187);
    if (this.vid != null)
    {
      this.vid.B(null, this.vii);
      if ((this.vii == null) || (this.vii.size() <= 0)) {
        this.vid.fgv();
      }
    }
    if (this.vie != null) {
      this.vie.setText(this.vhV);
    }
    AppMethodBeat.o(26187);
  }
  
  private void dij()
  {
    AppMethodBeat.i(26189);
    ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.vik != null) {}
    for (int i = this.vik.size();; i = 0)
    {
      if (this.vim != null) {}
      for (int j = this.vim.size();; j = 0)
      {
        ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.vil.size();
          int n = Math.max(0, i - m);
          localObject = g.yxI;
          String str = v.aAC();
          if (this.vhY)
          {
            k = 1;
            ((g)localObject).f(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.vih) {
            break label299;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.vhV);
          setResult(0, (Intent)localObject);
          if (!this.vip) {
            break label262;
          }
          g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(26189);
          return;
          k = 2;
          break;
          label262:
          g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label299:
        if (i > 0)
        {
          if (this.vip) {
            g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label344:
          if (j > 0)
          {
            if (!this.vip) {
              break label434;
            }
            g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label344;
          label434:
          g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void dik()
  {
    AppMethodBeat.i(26190);
    ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    acP(getString(2131755143));
    AppMethodBeat.o(26190);
  }
  
  private void dil()
  {
    AppMethodBeat.i(26192);
    int i;
    if (this.vik == null)
    {
      i = 0;
      if (this.vim != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.vim.size())
    {
      ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.vik == null) || (this.vik.size() <= 0)) {
        break label238;
      }
      this.vik.size();
      localIterator = this.vik.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bc.aCg();
        localObject2 = com.tencent.mm.model.c.azF().BH((String)localObject2);
        localObject3 = ((aw)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hK((String)localObject3, this.vhW);
        ae.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new duw();
          ((duw)localObject3).nIJ = ((aw)localObject2).field_username;
          ((duw)localObject3).GuH = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.vik.size();
      break;
    }
    label238:
    if ((this.vim != null) && (this.vim.size() > 0))
    {
      this.vim.size();
      localIterator = this.vim.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        bc.aCg();
        localObject3 = com.tencent.mm.model.c.azF().BH((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.hL((String)localObject3, this.vhW);
        ae.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new duw();
          ((duw)localObject3).nIJ = ((String)localObject2);
          ((duw)localObject3).GuH = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      bc.ajj().a((n)localObject1, 0);
      AppMethodBeat.o(26192);
      return;
    }
    dij();
    AppMethodBeat.o(26192);
  }
  
  private void dim()
  {
    AppMethodBeat.i(26198);
    acP(getString(2131758023));
    AppMethodBeat.o(26198);
  }
  
  private void din()
  {
    AppMethodBeat.i(26199);
    setResult(-1);
    finish();
    AppMethodBeat.o(26199);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(26194);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    AppMethodBeat.o(26194);
  }
  
  public String getIdentString()
  {
    if (this.vih) {
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
    if (this.vip)
    {
      g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!bu.isNullOrNil(this.vhW)) {
        break label561;
      }
      this.vih = true;
      this.vib = getString(2131762004);
      label73:
      setMMTitle(this.vib);
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
      }, null, com.tencent.mm.ui.s.b.JwA);
      this.vic = getPreferenceScreen();
      this.vid = ((ContactListExpandPreference)this.vic.aXe("contact_label_contact_list"));
      this.vid.a(this.vic, this.vid.mKey);
      this.vid.vW(true);
      this.vid.vX(true);
      this.vid.fgx();
      this.vid.fgr();
      this.vid.a(new com.tencent.mm.pluginsdk.ui.applet.s.b()
      {
        public final boolean lg(int paramAnonymousInt)
        {
          return false;
        }
      });
      this.vid.a(new ContactListExpandPreference.a()
      {
        public final void YS()
        {
          AppMethodBeat.i(26169);
          if (ContactLabelEditUI.c(ContactLabelEditUI.this) != null) {
            ContactLabelEditUI.c(ContactLabelEditUI.this).fgv();
          }
          AppMethodBeat.o(26169);
        }
        
        public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
        {
          AppMethodBeat.i(186483);
          Intent localIntent;
          if (ContactLabelEditUI.c(ContactLabelEditUI.this).ZC(paramAnonymousInt))
          {
            paramAnonymousViewGroup = ContactLabelEditUI.c(ContactLabelEditUI.this).ZD(paramAnonymousInt);
            String str = ContactLabelEditUI.c(ContactLabelEditUI.this).ZE(paramAnonymousInt);
            if (bu.isNullOrNil(paramAnonymousViewGroup))
            {
              AppMethodBeat.o(186483);
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
            com.tencent.mm.plugin.label.a.iUz.c(localIntent, ContactLabelEditUI.this);
            AppMethodBeat.o(186483);
            return;
          }
        }
        
        public final void le(int paramAnonymousInt)
        {
          AppMethodBeat.i(26171);
          String str = ContactLabelEditUI.c(ContactLabelEditUI.this).ZD(paramAnonymousInt);
          ae.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[] { Integer.valueOf(paramAnonymousInt), str });
          ContactLabelEditUI.a(ContactLabelEditUI.this, str);
          AppMethodBeat.o(26171);
        }
        
        public final void lf(int paramAnonymousInt)
        {
          AppMethodBeat.i(26170);
          ContactLabelEditUI.e(ContactLabelEditUI.this);
          AppMethodBeat.o(26170);
        }
      });
      this.vie = ((InputClearablePreference)this.vic.aXe("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.vie;
      localInputClearablePreference.vjz = getString(2131760607);
      if (localInputClearablePreference.vjE != null) {
        localInputClearablePreference.vjE.setHint(localInputClearablePreference.vjz);
      }
      this.vie.iIJ = getString(2131760616);
      localInputClearablePreference = this.vie;
      localInputClearablePreference.vjA = getString(2131755144);
      if (localInputClearablePreference.vjG != null) {
        localInputClearablePreference.vjG.setText(localInputClearablePreference.vjA);
      }
      this.vie.vjB = 36;
      this.vie.vjD = this.vih;
      this.vie.vjI = new InputClearablePreference.a()
      {
        public final void aiT(String paramAnonymousString)
        {
          AppMethodBeat.i(26172);
          ContactLabelEditUI.b(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.c(ContactLabelEditUI.this, paramAnonymousString);
          ContactLabelEditUI.f(ContactLabelEditUI.this).nW(false);
          AppMethodBeat.o(26172);
        }
        
        public final void nU(boolean paramAnonymousBoolean)
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
      this.vie.setText(this.vhV);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.vih) {
        break label611;
      }
      if ((this.vii == null) || (this.vii.size() <= 0)) {
        break label594;
      }
      this.vid.B(null, this.vii);
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
      this.vif = this.vic.aXe("contact_label_delete");
      this.vig = ((PreferenceTitleCategory)this.vic.aXe("contact_label_empty_category"));
      if (!this.vih) {
        break label629;
      }
      this.vic.d(this.vif);
      this.vic.d(this.vig);
      AppMethodBeat.o(26183);
      return;
      g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.vih = false;
      this.vhX = e.dif().aUD(this.vhW);
      this.vib = getString(2131762003);
      break label73;
      label594:
      this.vid.aO(new ArrayList());
      continue;
      label611:
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26174);
          ArrayList localArrayList = e.dif().aUB(ContactLabelEditUI.j(ContactLabelEditUI.this));
          if (localArrayList == null)
          {
            ae.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
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
    if (!this.vhZ) {
      this.vic.d(this.vif);
    }
    AppMethodBeat.o(26183);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26184);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!bu.isNullOrNil(str))
      {
        paramIntent = bu.U(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!bu.isNullOrNil(str))
            {
              if ((!x.An(str)) || (this.vii.contains(str)) || (str.equals(this.vin))) {
                break label312;
              }
              this.vii.add(str);
              if ((this.vij != null) && (!this.vij.contains(paramIntent.get(paramInt1)))) {
                this.vik.add(str);
              }
              if (bool) {
                this.vil.add(str);
              }
              if ((this.vim != null) && (this.vim.contains(str))) {
                this.vim.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label312:
              ae.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
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
    if (((!bu.isNullOrNil(this.vhV)) && (!this.vhV.equals(this.vhU))) || ((this.vik != null) && (this.vik.size() > 0)) || ((this.vim != null) && (this.vim.size() > 0)))
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
    this.vin = v.aAC();
    this.vhW = getIntent().getStringExtra("label_id");
    this.vhU = getIntent().getStringExtra("label_name");
    this.vhV = getIntent().getStringExtra("label_name");
    this.vhY = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.vio = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.vio != null) && (this.vio.equals("label_source_Address")))
    {
      bool = true;
      this.vip = bool;
      this.vhZ = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (bu.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = bu.U(paramBundle.split(","));
      this.vii = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label322;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label322;
      }
      str = (String)paramBundle.get(i);
      if (!bu.isNullOrNil(str))
      {
        if ((!x.An(str)) || (this.vii.contains(str)) || (str.equals(this.vin))) {
          break label302;
        }
        this.vii.add(str);
        this.vik.add(str);
        if (this.vhY) {
          this.vil.add(str);
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
      ae.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label322:
    bc.ajj().a(635, this);
    bc.ajj().a(637, this);
    bc.ajj().a(638, this);
    initView();
    AppMethodBeat.o(26179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26182);
    bc.ajj().b(635, this);
    bc.ajj().b(637, this);
    bc.ajj().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(26182);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26181);
    com.tencent.mm.modelstat.d.d(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    bc.ajj().b(636, this);
    super.onPause();
    AppMethodBeat.o(26181);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(26185);
    paramf = paramPreference.mKey;
    if (bu.isNullOrNil(paramf))
    {
      ae.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
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
    ae.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    AppMethodBeat.o(26185);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26180);
    com.tencent.mm.modelstat.d.d(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    bc.ajj().a(636, this);
    apt(this.vhV);
    dii();
    super.onResume();
    AppMethodBeat.o(26180);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26186);
    ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.label.b.a)paramn).dih().FNr;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (bts)paramString.get(0);
          ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.HgP, paramString.HgO });
          this.vhW = paramString.HgP;
          dil();
          AppMethodBeat.o(26186);
          return;
        }
        dik();
        AppMethodBeat.o(26186);
        return;
      }
      dik();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.vhW;
        String str = this.vhV;
        ae.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramn = e.dif().aUD(paramString);
            paramString = paramn;
            if (paramn == null) {
              paramString = new ap();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.Jk(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.Jl(str);
            e.dif().b(true, paramString, new String[] { "labelID" });
            dil();
            AppMethodBeat.o(26186);
            return;
          }
        }
        catch (Exception paramn)
        {
          for (;;)
          {
            ae.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { String.valueOf(paramString) });
            paramInt1 = -1;
            continue;
            dik();
          }
        }
      }
      dik();
      AppMethodBeat.o(26186);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        dij();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(26186);
        }
      }
      else
      {
        dik();
        AppMethodBeat.o(26186);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.vhX);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(26186);
          }
        }
        else
        {
          ae.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          dim();
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