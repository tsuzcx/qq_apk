package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.bv;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private ProgressDialog faz;
  private String lAR;
  private String lAS;
  private String lAT;
  private af lAU;
  private boolean lAV;
  private boolean lAW = false;
  private String lAX;
  private com.tencent.mm.ui.base.preference.f lAY;
  private ContactListExpandPreference lAZ;
  private InputClearablePreference lBa;
  private Preference lBb;
  private PreferenceTitleCategory lBc;
  private boolean lBd = true;
  private ArrayList<String> lBe = new ArrayList();
  private ArrayList<String> lBf = new ArrayList();
  private HashSet<String> lBg = new HashSet();
  private HashSet<String> lBh = new HashSet();
  private HashSet<String> lBi = new HashSet();
  private String lBj;
  private boolean lBk;
  private boolean luw = true;
  private ah mHandler = new ContactLabelEditUI.1(this, Looper.getMainLooper());
  private String mSource;
  
  private void AY(String paramString)
  {
    com.tencent.mm.ui.base.h.a(this, paramString, "", new ContactLabelEditUI.4(this));
  }
  
  private void Gp(String paramString)
  {
    getString(R.l.app_tip);
    this.faz = com.tencent.mm.ui.base.h.b(this, paramString, true, new ContactLabelEditUI.3(this));
  }
  
  private void Gq(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      return;
    }
  }
  
  private static boolean Gr(String paramString)
  {
    return !bk.bl(e.bdz().Gl(paramString));
  }
  
  private void a(af paramaf)
  {
    if (!e.bdz().a(true, paramaf, new String[] { "labelID" }))
    {
      y.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      bdH();
      return;
    }
    setResult(-1);
    finish();
  }
  
  private void bdC()
  {
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  private void bdD()
  {
    if (this.lAZ != null)
    {
      this.lAZ.s(null, this.lBe);
      if ((this.lBe == null) || (this.lBe.size() <= 0)) {
        this.lAZ.cmP();
      }
    }
    if (this.lBa != null) {
      this.lBa.setText(this.lAS);
    }
  }
  
  private void bdE()
  {
    y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    bdC();
    if (this.lBg != null) {}
    for (int i = this.lBg.size();; i = 0)
    {
      if (this.lBi != null) {}
      for (int j = this.lBi.size();; j = 0)
      {
        y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.lBh.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.nFQ;
          String str = q.Gj();
          if (this.lAV)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).f(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.lBd) {
            break label287;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.lAS);
          setResult(0, (Intent)localObject);
          if (!this.lBk) {
            break label250;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          return;
          k = 2;
          break;
          label250:
          com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label287:
        if (i > 0)
        {
          if (this.lBk) {
            com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label332:
          if (j > 0)
          {
            if (!this.lBk) {
              break label422;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(3) });
          break label332;
          label422:
          com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void bdF()
  {
    y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    bdC();
    AY(getString(R.l.add_label_fail_msg));
  }
  
  private void bdG()
  {
    int i;
    if (this.lBg == null)
    {
      i = 0;
      if (this.lBi != null) {
        break label221;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label221:
    for (int j = 0;; j = this.lBi.size())
    {
      y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.lBg == null) || (this.lBg.size() <= 0)) {
        break label232;
      }
      this.lBg.size();
      localIterator = this.lBg.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        au.Hx();
        localObject2 = com.tencent.mm.model.c.Fw().abl((String)localObject2);
        localObject3 = ((ao)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.dH((String)localObject3, this.lAT);
        y.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new cce();
          ((cce)localObject3).hPY = ((ao)localObject2).field_username;
          ((cce)localObject3).sQu = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.lBg.size();
      break;
    }
    label232:
    if ((this.lBi != null) && (this.lBi.size() > 0))
    {
      this.lBi.size();
      localIterator = this.lBi.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        au.Hx();
        localObject3 = com.tencent.mm.model.c.Fw().abl((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.dI((String)localObject3, this.lAT);
        y.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new cce();
          ((cce)localObject3).hPY = ((String)localObject2);
          ((cce)localObject3).sQu = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      au.Dk().a((m)localObject1, 0);
      return;
    }
    bdE();
  }
  
  private void bdH()
  {
    AY(getString(R.l.del_label_failed_msg));
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (bk.bl(paramf))
    {
      y.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
      return false;
    }
    if (paramf.equals("contact_label_delete")) {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.label_delete_confirm), "", getString(R.l.app_delete), getString(R.l.app_cancel), new ContactLabelEditUI.14(this), new ContactLabelEditUI.2(this));
    }
    y.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    return false;
  }
  
  protected final String bdI()
  {
    if (this.lBd) {
      return "_New";
    }
    return "_Edit";
  }
  
  protected final void initView()
  {
    if (this.lBk)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!bk.bl(this.lAT)) {
        break label548;
      }
      this.lBd = true;
      this.lAX = getString(R.l.pref_label_new_title);
      label67:
      setMMTitle(this.lAX);
      setBackBtn(new ContactLabelEditUI.7(this));
      a(0, getString(R.l.app_save), new ContactLabelEditUI.8(this), s.b.uNx);
      this.lAY = this.vdd;
      this.lAZ = ((ContactListExpandPreference)this.lAY.add("contact_label_contact_list"));
      this.lAZ.a(this.lAY, this.lAZ.mKey);
      this.lAZ.lS(true);
      this.lAZ.lT(true);
      this.lAZ.cmO();
      this.lAZ.cmR();
      this.lAZ.a(new ContactLabelEditUI.9(this));
      this.lAZ.a(new ContactLabelEditUI.10(this));
      this.lBa = ((InputClearablePreference)this.lAY.add("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.lBa;
      localInputClearablePreference.lCt = getString(R.l.label_input_tip);
      if (localInputClearablePreference.lCy != null) {
        localInputClearablePreference.lCy.setHint(localInputClearablePreference.lCt);
      }
      this.lBa.gio = getString(R.l.label_panel_max_tips);
      localInputClearablePreference = this.lBa;
      localInputClearablePreference.lCu = getString(R.l.add_label_invaild_msg);
      if (localInputClearablePreference.lCA != null) {
        localInputClearablePreference.lCA.setText(localInputClearablePreference.lCu);
      }
      this.lBa.lCv = 36;
      this.lBa.lCx = this.lBd;
      this.lBa.lCC = new ContactLabelEditUI.11(this);
      this.lBa.setText(this.lAS);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.lBd) {
        break label598;
      }
      if ((this.lBe == null) || (this.lBe.size() <= 0)) {
        break label581;
      }
      this.lAZ.s(null, this.lBe);
      label418:
      if (this.lwE != null) {
        this.lwE.setOnScrollListener(new ContactLabelEditUI.13(this));
      }
      this.lBb = this.lAY.add("contact_label_delete");
      this.lBc = ((PreferenceTitleCategory)this.lAY.add("contact_label_empty_category"));
      if (!this.lBd) {
        break label616;
      }
      this.lAY.c(this.lBb);
      this.lAY.c(this.lBc);
    }
    label548:
    label581:
    label598:
    label616:
    while (this.lAW)
    {
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      this.lBd = false;
      this.lAU = e.bdz().abc(this.lAT);
      this.lAX = getString(R.l.pref_label_edit_title);
      break label67;
      this.lAZ.ac(new ArrayList());
      break label418;
      au.DS().O(new ContactLabelEditUI.12(this));
      break label418;
    }
    this.lAY.c(this.lBb);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1) {}
    label291:
    do
    {
      String str;
      boolean bool;
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
        str = paramIntent.getStringExtra("Select_Contact");
        bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { str });
      } while (bk.bl(str));
      paramIntent = bk.G(str.split(","));
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramInt2 = paramIntent.size();
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          str = (String)paramIntent.get(paramInt1);
          if (!bk.bl(str))
          {
            if ((!s.hk(str)) || (this.lBe.contains(str)) || (str.equals(this.lBj))) {
              break label291;
            }
            this.lBe.add(str);
            if ((this.lBf != null) && (!this.lBf.contains(paramIntent.get(paramInt1)))) {
              this.lBg.add(str);
            }
            if (bool) {
              this.lBh.add(str);
            }
            if ((this.lBi != null) && (this.lBi.contains(str))) {
              this.lBi.remove(str);
            }
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            y.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
          }
        }
      }
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessage(6001);
  }
  
  public void onBackPressed()
  {
    if (((!bk.bl(this.lAS)) && (!this.lAS.equals(this.lAR))) || ((this.lBg != null) && (this.lBg.size() > 0)) || ((this.lBi != null) && (this.lBi.size() > 0)))
    {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.save_label_msg), "", getString(R.l.btn_save), getString(R.l.btn_unsave), new ContactLabelEditUI.5(this), new ContactLabelEditUI.6(this));
      return;
    }
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lBj = q.Gj();
    this.lAT = getIntent().getStringExtra("label_id");
    this.lAR = getIntent().getStringExtra("label_name");
    this.lAS = getIntent().getStringExtra("label_name");
    this.lAV = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.mSource = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label189:
    String str;
    if ((this.mSource != null) && (this.mSource.equals("label_source_Address")))
    {
      bool = true;
      this.lBk = bool;
      this.lAW = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (bk.bl(paramBundle)) {
        break label316;
      }
      paramBundle = bk.G(paramBundle.split(","));
      this.lBe = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label316;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label316;
      }
      str = (String)paramBundle.get(i);
      if (!bk.bl(str))
      {
        if ((!s.hk(str)) || (this.lBe.contains(str)) || (str.equals(this.lBj))) {
          break label296;
        }
        this.lBe.add(str);
        this.lBg.add(str);
        if (this.lAV) {
          this.lBh.add(str);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label189;
      bool = false;
      break;
      label296:
      y.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label316:
    au.Dk().a(635, this);
    au.Dk().a(637, this);
    au.Dk().a(638, this);
    initView();
  }
  
  protected void onDestroy()
  {
    au.Dk().b(635, this);
    au.Dk().b(637, this);
    au.Dk().b(638, this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    com.tencent.mm.modelstat.d.b(4, "ContactLabelEditUI" + bdI(), hashCode());
    au.Dk().b(636, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    com.tencent.mm.modelstat.d.b(3, "ContactLabelEditUI" + bdI(), hashCode());
    au.Dk().a(636, this);
    Gq(this.lAS);
    bdD();
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((a)paramm).bdB().svt;
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramString = (atc)paramString.get(0);
            y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.toI, paramString.toH });
            this.lAT = paramString.toI;
            bdG();
            return;
          }
          bdF();
          return;
        }
        bdF();
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = this.lAT;
          String str = this.lAS;
          y.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
          try
          {
            paramInt1 = Integer.valueOf(paramString).intValue();
            if (paramInt1 != -1)
            {
              paramm = e.bdz().abc(paramString);
              paramString = paramm;
              if (paramm == null) {
                paramString = new af();
              }
              paramString.field_labelID = paramInt1;
              paramString.field_labelName = str;
              paramString.field_labelPYFull = g.oY(str);
              paramString.field_labelPYShort = g.oZ(str);
              e.bdz().b(true, paramString, new String[] { "labelID" });
              bdG();
              return;
            }
          }
          catch (Exception paramm)
          {
            for (;;)
            {
              y.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { paramString });
              paramInt1 = -1;
              continue;
              bdF();
            }
          }
        }
        bdF();
        return;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break;
        }
        bdE();
      } while (this.mHandler == null);
      this.mHandler.sendEmptyMessageDelayed(6002, 300L);
      return;
      bdF();
      return;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      a(this.lAU);
    } while (this.mHandler == null);
    this.mHandler.sendEmptyMessageDelayed(6002, 300L);
    return;
    y.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
    bdH();
  }
  
  public final int xj()
  {
    return R.o.label_edit_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */