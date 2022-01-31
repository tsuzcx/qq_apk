package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private ProgressDialog gsr;
  private ak mHandler;
  private boolean nRO;
  private String nYc;
  private String nYd;
  private String nYe;
  private af nYf;
  private boolean nYg;
  private boolean nYh;
  private String nYi;
  private com.tencent.mm.ui.base.preference.f nYj;
  private ContactListExpandPreference nYk;
  private InputClearablePreference nYl;
  private Preference nYm;
  private PreferenceTitleCategory nYn;
  private boolean nYo;
  private ArrayList<String> nYp;
  private ArrayList<String> nYq;
  private HashSet<String> nYr;
  private HashSet<String> nYs;
  private HashSet<String> nYt;
  private String nYu;
  private String nYv;
  private boolean nYw;
  
  public ContactLabelEditUI()
  {
    AppMethodBeat.i(22556);
    this.nYh = false;
    this.nYo = true;
    this.nRO = true;
    this.nYp = new ArrayList();
    this.nYq = new ArrayList();
    this.nYr = new HashSet();
    this.nYs = new HashSet();
    this.nYt = new HashSet();
    this.mHandler = new ContactLabelEditUI.1(this, Looper.getMainLooper());
    AppMethodBeat.o(22556);
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(22573);
    com.tencent.mm.ui.base.h.a(this, paramString, "", new ContactLabelEditUI.4(this));
    AppMethodBeat.o(22573);
  }
  
  private void RS(String paramString)
  {
    AppMethodBeat.i(22571);
    getString(2131297087);
    this.gsr = com.tencent.mm.ui.base.h.b(this, paramString, true, new ContactLabelEditUI.3(this));
    AppMethodBeat.o(22571);
  }
  
  private void RT(String paramString)
  {
    AppMethodBeat.i(22566);
    if (bo.isNullOrNil(paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      enableOptionMenu(bool);
      AppMethodBeat.o(22566);
      return;
    }
  }
  
  private static boolean RU(String paramString)
  {
    AppMethodBeat.i(22569);
    if (!bo.isNullOrNil(e.bKU().RO(paramString)))
    {
      AppMethodBeat.o(22569);
      return true;
    }
    AppMethodBeat.o(22569);
    return false;
  }
  
  private void a(af paramaf)
  {
    AppMethodBeat.i(22575);
    if (!e.bKU().a(paramaf, new String[] { "labelID" }))
    {
      ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
      bLb();
      AppMethodBeat.o(22575);
      return;
    }
    bLc();
    AppMethodBeat.o(22575);
  }
  
  private void bKX()
  {
    AppMethodBeat.i(22565);
    if (this.nYk != null)
    {
      this.nYk.v(null, this.nYp);
      if ((this.nYp == null) || (this.nYp.size() <= 0)) {
        this.nYk.dnF();
      }
    }
    if (this.nYl != null) {
      this.nYl.setText(this.nYd);
    }
    AppMethodBeat.o(22565);
  }
  
  private void bKY()
  {
    AppMethodBeat.i(22567);
    ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
    hideLoading();
    if (this.nYr != null) {}
    for (int i = this.nYr.size();; i = 0)
    {
      if (this.nYt != null) {}
      for (int j = this.nYt.size();; j = 0)
      {
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.nYs.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.qsU;
          String str = r.Zn();
          if (this.nYg)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).e(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.nYo) {
            break label299;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.nYd);
          setResult(0, (Intent)localObject);
          if (!this.nYw) {
            break label262;
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(22567);
          return;
          k = 2;
          break;
          label262:
          com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label299:
        if (i > 0)
        {
          if (this.nYw) {
            com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label344:
          if (j > 0)
          {
            if (!this.nYw) {
              break label434;
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(3) });
          break label344;
          label434:
          com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private void bKZ()
  {
    AppMethodBeat.i(22568);
    ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
    hideLoading();
    La(getString(2131296415));
    AppMethodBeat.o(22568);
  }
  
  private void bLa()
  {
    AppMethodBeat.i(22570);
    int i;
    if (this.nYr == null)
    {
      i = 0;
      if (this.nYt != null) {
        break label227;
      }
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    String str;
    label227:
    for (int j = 0;; j = this.nYt.size())
    {
      ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.nYr == null) || (this.nYr.size() <= 0)) {
        break label238;
      }
      this.nYr.size();
      localIterator = this.nYr.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        aw.aaz();
        localObject2 = com.tencent.mm.model.c.YA().arw((String)localObject2);
        localObject3 = ((aq)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.eZ((String)localObject3, this.nYe);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[] { localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new cpk();
          ((cpk)localObject3).jJA = ((aq)localObject2).field_username;
          ((cpk)localObject3).wOV = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
      i = this.nYr.size();
      break;
    }
    label238:
    if ((this.nYt != null) && (this.nYt.size() > 0))
    {
      this.nYt.size();
      localIterator = this.nYt.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        aw.aaz();
        localObject3 = com.tencent.mm.model.c.YA().arw((String)localObject2).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.fa((String)localObject3, this.nYe);
        ab.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject2, localObject3, str });
        if (!str.equalsIgnoreCase((String)localObject3))
        {
          localObject3 = new cpk();
          ((cpk)localObject3).jJA = ((String)localObject2);
          ((cpk)localObject3).wOV = str;
          ((LinkedList)localObject1).add(localObject3);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new com.tencent.mm.plugin.label.b.d((LinkedList)localObject1);
      aw.Rc().a((m)localObject1, 0);
      AppMethodBeat.o(22570);
      return;
    }
    bKY();
    AppMethodBeat.o(22570);
  }
  
  private void bLb()
  {
    AppMethodBeat.i(22576);
    La(getString(2131298938));
    AppMethodBeat.o(22576);
  }
  
  private void bLc()
  {
    AppMethodBeat.i(22577);
    setResult(-1);
    finish();
    AppMethodBeat.o(22577);
  }
  
  private void hideLoading()
  {
    AppMethodBeat.i(22572);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(22572);
  }
  
  public String getIdentString()
  {
    if (this.nYo) {
      return "_New";
    }
    return "_Edit";
  }
  
  public int getResourceId()
  {
    return 2131165246;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22561);
    if (this.nYw)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if (!bo.isNullOrNil(this.nYe)) {
        break label561;
      }
      this.nYo = true;
      this.nYi = getString(2131302162);
      label73:
      setMMTitle(this.nYi);
      setBackBtn(new ContactLabelEditUI.7(this));
      addTextOptionMenu(0, getString(2131297063), new ContactLabelEditUI.8(this), null, q.b.zby);
      this.nYj = getPreferenceScreen();
      this.nYk = ((ContactListExpandPreference)this.nYj.atx("contact_label_contact_list"));
      this.nYk.a(this.nYj, this.nYk.mKey);
      this.nYk.pf(true);
      this.nYk.pg(true);
      this.nYk.dnH();
      this.nYk.dnB();
      this.nYk.a(new ContactLabelEditUI.9(this));
      this.nYk.a(new ContactLabelEditUI.10(this));
      this.nYl = ((InputClearablePreference)this.nYj.atx("contact_label_name"));
      InputClearablePreference localInputClearablePreference = this.nYl;
      localInputClearablePreference.nZF = getString(2131301004);
      if (localInputClearablePreference.nZK != null) {
        localInputClearablePreference.nZK.setHint(localInputClearablePreference.nZF);
      }
      this.nYl.hBF = getString(2131301013);
      localInputClearablePreference = this.nYl;
      localInputClearablePreference.nZG = getString(2131296416);
      if (localInputClearablePreference.nZM != null) {
        localInputClearablePreference.nZM.setText(localInputClearablePreference.nZG);
      }
      this.nYl.nZH = 36;
      this.nYl.nZJ = this.nYo;
      this.nYl.nZO = new ContactLabelEditUI.11(this);
      this.nYl.setText(this.nYd);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(6001);
      }
      if (!this.nYo) {
        break label611;
      }
      if ((this.nYp == null) || (this.nYp.size() <= 0)) {
        break label594;
      }
      this.nYk.v(null, this.nYp);
    }
    for (;;)
    {
      if (getListView() != null) {
        getListView().setOnScrollListener(new ContactLabelEditUI.13(this));
      }
      this.nYm = this.nYj.atx("contact_label_delete");
      this.nYn = ((PreferenceTitleCategory)this.nYj.atx("contact_label_empty_category"));
      if (!this.nYo) {
        break label629;
      }
      this.nYj.d(this.nYm);
      this.nYj.d(this.nYn);
      AppMethodBeat.o(22561);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(3) });
      break;
      label561:
      this.nYo = false;
      this.nYf = e.bKU().arn(this.nYe);
      this.nYi = getString(2131302161);
      break label73;
      label594:
      this.nYk.ah(new ArrayList());
      continue;
      label611:
      aw.RO().ac(new ContactLabelEditUI.12(this));
    }
    label629:
    if (!this.nYh) {
      this.nYj.d(this.nYm);
    }
    AppMethodBeat.o(22561);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22562);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(22562);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22562);
      return;
      String str = paramIntent.getStringExtra("Select_Contact");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[] { String.valueOf(str) });
      if (!bo.isNullOrNil(str))
      {
        paramIntent = bo.P(str.split(","));
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!bo.isNullOrNil(str))
            {
              if ((!t.nT(str)) || (this.nYp.contains(str)) || (str.equals(this.nYu))) {
                break label312;
              }
              this.nYp.add(str);
              if ((this.nYq != null) && (!this.nYq.contains(paramIntent.get(paramInt1)))) {
                this.nYr.add(str);
              }
              if (bool) {
                this.nYs.add(str);
              }
              if ((this.nYt != null) && (this.nYt.contains(str))) {
                this.nYt.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label312:
              ab.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
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
    AppMethodBeat.i(22574);
    if (((!bo.isNullOrNil(this.nYd)) && (!this.nYd.equals(this.nYc))) || ((this.nYr != null) && (this.nYr.size() > 0)) || ((this.nYt != null) && (this.nYt.size() > 0)))
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131302870), "", getString(2131297825), getString(2131297826), new ContactLabelEditUI.5(this), new ContactLabelEditUI.6(this));
      AppMethodBeat.o(22574);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(22574);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22557);
    super.onCreate(paramBundle);
    this.nYu = r.Zn();
    this.nYe = getIntent().getStringExtra("label_id");
    this.nYc = getIntent().getStringExtra("label_name");
    this.nYd = getIntent().getStringExtra("label_name");
    this.nYg = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.nYv = getIntent().getStringExtra("label_source");
    boolean bool;
    int i;
    label195:
    String str;
    if ((this.nYv != null) && (this.nYv.equals("label_source_Address")))
    {
      bool = true;
      this.nYw = bool;
      this.nYh = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (bo.isNullOrNil(paramBundle)) {
        break label322;
      }
      paramBundle = bo.P(paramBundle.split(","));
      this.nYp = new ArrayList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label322;
      }
      int j = paramBundle.size();
      i = 0;
      if (i >= j) {
        break label322;
      }
      str = (String)paramBundle.get(i);
      if (!bo.isNullOrNil(str))
      {
        if ((!t.nT(str)) || (this.nYp.contains(str)) || (str.equals(this.nYu))) {
          break label302;
        }
        this.nYp.add(str);
        this.nYr.add(str);
        if (this.nYg) {
          this.nYs.add(str);
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
      ab.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
    }
    label322:
    aw.Rc().a(635, this);
    aw.Rc().a(637, this);
    aw.Rc().a(638, this);
    initView();
    AppMethodBeat.o(22557);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22560);
    aw.Rc().b(635, this);
    aw.Rc().b(637, this);
    aw.Rc().b(638, this);
    super.onDestroy();
    AppMethodBeat.o(22560);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22559);
    com.tencent.mm.modelstat.d.b(4, "ContactLabelEditUI" + getIdentString(), hashCode());
    aw.Rc().b(636, this);
    super.onPause();
    AppMethodBeat.o(22559);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(22563);
    paramf = paramPreference.mKey;
    if (bo.isNullOrNil(paramf))
    {
      ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
      AppMethodBeat.o(22563);
      return false;
    }
    if (paramf.equals("contact_label_delete")) {
      com.tencent.mm.ui.base.h.d(this, getString(2131301002), "", getString(2131296901), getString(2131296888), new ContactLabelEditUI.14(this), new ContactLabelEditUI.2(this));
    }
    ab.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[] { paramf });
    AppMethodBeat.o(22563);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22558);
    com.tencent.mm.modelstat.d.b(3, "ContactLabelEditUI" + getIdentString(), hashCode());
    aw.Rc().a(636, this);
    RT(this.nYd);
    bKX();
    super.onResume();
    AppMethodBeat.o(22558);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22564);
    ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22564);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((a)paramm).bKW().woA;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (azf)paramString.get(0);
          ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.xoC, paramString.xoB });
          this.nYe = paramString.xoC;
          bLa();
          AppMethodBeat.o(22564);
          return;
        }
        bKZ();
        AppMethodBeat.o(22564);
        return;
      }
      bKZ();
      AppMethodBeat.o(22564);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.nYe;
        String str = this.nYd;
        ab.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
        try
        {
          paramInt1 = Integer.valueOf(paramString).intValue();
          if (paramInt1 != -1)
          {
            paramm = e.bKU().arn(paramString);
            paramString = paramm;
            if (paramm == null) {
              paramString = new af();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = g.wq(str);
            paramString.field_labelPYShort = g.wr(str);
            e.bKU().b(true, paramString, new String[] { "labelID" });
            bLa();
            AppMethodBeat.o(22564);
            return;
          }
        }
        catch (Exception paramm)
        {
          for (;;)
          {
            ab.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[] { String.valueOf(paramString) });
            paramInt1 = -1;
            continue;
            bKZ();
          }
        }
      }
      bKZ();
      AppMethodBeat.o(22564);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bKY();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(22564);
        }
      }
      else
      {
        bKZ();
        AppMethodBeat.o(22564);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          a(this.nYf);
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(22564);
          }
        }
        else
        {
          ab.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
          bLb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelEditUI
 * JD-Core Version:    0.7.0.1
 */