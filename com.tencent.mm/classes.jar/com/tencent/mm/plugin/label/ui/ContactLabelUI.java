package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements g
{
  private String flk;
  private boolean sMD;
  private MMTagPanelScrollView sNc;
  private MMLabelPanel sNd;
  private TextView sNe;
  private View sNf;
  private View sNg;
  private TextView sNh;
  private MMLabelPanel sNi;
  private ListView sNj;
  private ScrollView sNk;
  private b sNl;
  private String sNm;
  private ArrayList<String> sNn;
  private HashSet<String> sNo;
  private HashSet<String> sNp;
  private ArrayList<String> sNq;
  private a sNr;
  private boolean sNs;
  private ArrayList<String> sNt;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.sNo = new HashSet();
    this.sNp = new HashSet();
    this.sNq = new ArrayList();
    this.sNr = a.sNw;
    this.sNs = false;
    this.sMD = true;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.sNr = parama;
    switch (4.sNv[this.sNr.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.sNj.setVisibility(8);
      if ((this.sNq != null) && (this.sNq.size() > 0))
      {
        this.sNf.setVisibility(0);
        this.sNk.setVisibility(0);
      }
      for (;;)
      {
        this.sNe.setVisibility(8);
        AppMethodBeat.o(26310);
        return;
        this.sNk.setVisibility(8);
        this.sNf.setVisibility(8);
      }
      this.sNk.setVisibility(8);
      this.sNj.setVisibility(0);
      this.sNf.setVisibility(8);
      this.sNe.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.sNj.setVisibility(8);
      this.sNk.setVisibility(8);
      this.sNf.setVisibility(8);
      this.sNe.setVisibility(0);
      this.sNe.setText(2131760616);
      AppMethodBeat.o(26310);
      return;
      this.sNj.setVisibility(8);
      this.sNk.setVisibility(8);
      this.sNf.setVisibility(8);
      this.sNe.setVisibility(0);
      this.sNe.setText(2131760616);
    }
  }
  
  private void bg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26311);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    paramString = paramString.trim();
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    ah localah = e.cIR().aHO(paramString);
    if (paramBoolean) {
      if ((this.sNq == null) || (!this.sNq.contains(paramString)) || (localah == null)) {
        this.sNp.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.sNo != null) && (this.sNo.contains(paramString))) {
        this.sNo.remove(paramString);
      }
      if (cJd()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.sNq == null) || (!this.sNq.contains(paramString)) || ((localah != null) && (localah.field_isTemporary))) {
        this.sNp.add(paramString);
      }
    }
  }
  
  private void cIW()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    Ug(getString(2131755143));
    AppMethodBeat.o(26314);
  }
  
  private void cJb()
  {
    AppMethodBeat.i(26312);
    ad.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.sNd != null)
    {
      ad.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.sNd.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = com.tencent.mm.plugin.label.c.dU(e.cIR().aG((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new dit();
      ((dit)localObject3).DbA = ((String)localObject1);
      ((dit)localObject3).mAQ = this.flk;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      az.aeS().a((n)localObject1, 0);
      if (this.sNp == null) {
        break label338;
      }
    }
    label338:
    for (int i = this.sNp.size();; i = 0)
    {
      if (this.sNn != null) {}
      for (int j = this.sNn.size();; j = 0)
      {
        if (this.sNo != null) {}
        for (int k = this.sNo.size();; k = 0)
        {
          j = k + this.sNd.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            ad.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.vKh.f(11220, new Object[] { u.aqG(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void cJc()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.sNp.clear();
    this.sNo.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean cJd()
  {
    AppMethodBeat.i(26315);
    if (this.sNd != null)
    {
      if ((this.sNn != null) && (this.sNn.size() > 0))
      {
        if ((this.sNd.getTagList() == null) && (this.sNd.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.sNd.getTagList();
        Collections.sort(this.sNn);
        Collections.sort(localArrayList);
        if (!this.sNn.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.sNd.getTagList() != null) && (this.sNd.getTagList().size() > 0))
      {
        AppMethodBeat.o(26315);
        return true;
      }
    }
    AppMethodBeat.o(26315);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(26316);
    if (this.sNd != null) {
      this.sNd.eTc();
    }
    Intent localIntent = new Intent();
    if (cJd()) {
      localIntent.putExtra("hasLableChange", true);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      super.finish();
      AppMethodBeat.o(26316);
      return;
      localIntent.putExtra("hasLableChange", false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493651;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26303);
    setMMTitle(getString(2131755146));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26280);
        ContactLabelUI.this.onBackPressed();
        AppMethodBeat.o(26280);
        return false;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26284);
        ContactLabelUI.a(ContactLabelUI.this);
        AppMethodBeat.o(26284);
        return false;
      }
    }, null, r.b.FOB);
    this.sNc = ((MMTagPanelScrollView)findViewById(2131301298));
    this.sNc.setMaxLine(3);
    this.sNd = ((MMLabelPanel)findViewById(2131301297));
    this.sNe = ((TextView)findViewById(2131301300));
    this.sNf = findViewById(2131301296);
    this.sNg = findViewById(2131301295);
    this.sNg.setBackgroundDrawable(null);
    this.sNh = ((TextView)this.sNg.findViewById(16908310));
    this.sNh.setText(2131760615);
    this.sNi = ((MMLabelPanel)findViewById(2131301293));
    this.sNj = ((ListView)findViewById(2131301299));
    this.sNk = ((ScrollView)findViewById(2131301301));
    if (this.sNk != null) {
      this.sNk.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(26285);
          if (paramAnonymousMotionEvent.getAction() == 2) {
            ContactLabelUI.this.hideVKB();
          }
          AppMethodBeat.o(26285);
          return false;
        }
      });
    }
    this.sNd.FZU = true;
    this.sNd.vN(true);
    this.sNd.setTagEditTextBG(2131234289);
    this.sNd.setCallBack(new MMTagPanel.a()
    {
      public final void B(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(26292);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousBoolean)
        {
          ContactLabelUI.this.enableOptionMenu(false);
          ContactLabelUI.e(ContactLabelUI.this).setVisibility(0);
          ContactLabelUI.e(ContactLabelUI.this).setText(2131760616);
          ContactLabelUI.e(ContactLabelUI.this).setText(String.format(ContactLabelUI.this.getString(2131760616), new Object[] { Integer.valueOf(f.cJ(36, "")), Integer.valueOf(paramAnonymousInt) }));
          AppMethodBeat.o(26292);
          return;
        }
        ContactLabelUI.this.enableOptionMenu(true);
        ContactLabelUI.e(ContactLabelUI.this).setVisibility(8);
        AppMethodBeat.o(26292);
      }
      
      public final void Uk(String paramAnonymousString)
      {
        AppMethodBeat.i(26286);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cD(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26286);
      }
      
      public final void Ul(String paramAnonymousString)
      {
        AppMethodBeat.i(26287);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(26287);
      }
      
      public final void Um(String paramAnonymousString)
      {
        AppMethodBeat.i(26288);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cD(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26288);
      }
      
      public final void Un(String paramAnonymousString)
      {
        AppMethodBeat.i(26290);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26290);
      }
      
      public final void Uo(String paramAnonymousString)
      {
        AppMethodBeat.i(26291);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (bt.isNullOrNil(paramAnonymousString))
        {
          ad.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
          AppMethodBeat.o(26291);
          return;
        }
        ContactLabelUI.b(ContactLabelUI.this).cC(paramAnonymousString, true);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cD(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26291);
      }
      
      public final void bXc()
      {
        AppMethodBeat.i(26289);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
        AppMethodBeat.o(26289);
      }
    });
    this.sNi.vN(false);
    this.sNi.setCallBack(new MMTagPanel.a()
    {
      public final void B(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void Uk(String paramAnonymousString)
      {
        AppMethodBeat.i(26293);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26293);
      }
      
      public final void Ul(String paramAnonymousString)
      {
        AppMethodBeat.i(26294);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).cC(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26294);
      }
      
      public final void Um(String paramAnonymousString) {}
      
      public final void Un(String paramAnonymousString) {}
      
      public final void Uo(String paramAnonymousString) {}
      
      public final void bXc() {}
    });
    this.sNj.setAdapter(this.sNl);
    this.sNj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26295);
        if (ContactLabelUI.f(ContactLabelUI.this) == null)
        {
          AppMethodBeat.o(26295);
          return;
        }
        paramAnonymousAdapterView = ContactLabelUI.f(ContactLabelUI.this).getItem(paramAnonymousInt);
        if ((!bt.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.b(ContactLabelUI.this) != null))
        {
          ContactLabelUI.b(ContactLabelUI.this).eTa();
          ContactLabelUI.b(ContactLabelUI.this).cC(paramAnonymousAdapterView, true);
          ContactLabelUI.c(ContactLabelUI.this).cD(paramAnonymousAdapterView, true);
        }
        AppMethodBeat.o(26295);
      }
    });
    enableOptionMenu(false);
    AppMethodBeat.o(26303);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26309);
    if (cJd())
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131762782), "", getString(2131756751), getString(2131756754), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26281);
          ContactLabelUI.a(ContactLabelUI.this);
          AppMethodBeat.o(26281);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26282);
          ContactLabelUI.this.finish();
          AppMethodBeat.o(26282);
        }
      });
      AppMethodBeat.o(26309);
      return;
    }
    try
    {
      super.onBackPressed();
      AppMethodBeat.o(26309);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Label.ContactLabelUI", localException, "", new Object[0]);
      AppMethodBeat.o(26309);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26304);
    super.onCreate(paramBundle);
    this.sNm = getIntent().getStringExtra("label_id_list");
    this.sNn = getIntent().getStringArrayListExtra("label_str_list");
    this.flk = getIntent().getStringExtra("label_username");
    this.sNs = getIntent().getBooleanExtra("is_stranger", false);
    this.sNl = new b(this);
    initView();
    if ((!bt.isNullOrNil(this.sNm)) && (this.sNn != null) && (this.sNn.size() > 0)) {
      this.sNd.a(this.sNn, this.sNn);
    }
    if (this.sNs)
    {
      this.sNt = getIntent().getStringArrayListExtra("label_str_list");
      this.sNd.a(this.sNt, this.sNt);
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(26304);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26307);
    super.onDestroy();
    AppMethodBeat.o(26307);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26306);
    az.aeS().b(635, this);
    az.aeS().b(638, this);
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    az.aeS().a(635, this);
    az.aeS().a(638, this);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(26298);
        ContactLabelUI.g(ContactLabelUI.this).clear();
        ContactLabelUI.h(ContactLabelUI.this).clear();
        Object localObject1 = null;
        Object localObject2 = null;
        Object localObject3;
        if (ContactLabelUI.b(ContactLabelUI.this) != null)
        {
          if (ContactLabelUI.d(ContactLabelUI.this))
          {
            localObject1 = null;
            az.arV();
            localObject2 = com.tencent.mm.model.c.apN().agQ(ContactLabelUI.i(ContactLabelUI.this));
            if (localObject2 != null) {
              localObject1 = ((bw)localObject2).field_contactLabels;
            }
            localObject3 = localObject1;
            if (bt.isNullOrNil((String)localObject1))
            {
              az.arV();
              af localaf = com.tencent.mm.model.c.apM().aHY(ContactLabelUI.i(ContactLabelUI.this));
              localObject3 = localaf.field_encryptUsername;
              localObject2 = localObject1;
              if (!bt.isNullOrNil((String)localObject3))
              {
                az.arV();
                localObject3 = com.tencent.mm.model.c.apN().agQ((String)localObject3);
                localObject2 = localObject1;
                if (localObject3 != null) {
                  localObject2 = ((bw)localObject3).field_contactLabels;
                }
              }
              localObject3 = localObject2;
              if (bt.isNullOrNil((String)localObject2))
              {
                localObject1 = localaf.field_username;
                az.arV();
                localObject1 = com.tencent.mm.model.c.apN().agQ((String)localObject1);
                localObject3 = localObject2;
                if (localObject1 != null) {
                  localObject3 = ((bw)localObject1).field_contactLabels;
                }
              }
            }
            localObject1 = (ArrayList)a.cIS().aeJ((String)localObject3);
            ContactLabelUI.b(ContactLabelUI.this).a((Collection)localObject1, (List)localObject1);
            ContactLabelUI.a(ContactLabelUI.this, (ArrayList)localObject1);
          }
        }
        else if (ContactLabelUI.c(ContactLabelUI.this) != null)
        {
          ContactLabelUI.b(ContactLabelUI.this, e.cIR().eKJ());
          if ((ContactLabelUI.j(ContactLabelUI.this) == null) || (ContactLabelUI.j(ContactLabelUI.this).size() <= 0)) {
            break label415;
          }
          ContactLabelUI.d(ContactLabelUI.this);
          ContactLabelUI.c(ContactLabelUI.this).a((Collection)localObject1, ContactLabelUI.j(ContactLabelUI.this));
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
        for (;;)
        {
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.sNw);
          AppMethodBeat.o(26298);
          return;
          az.arV();
          localObject3 = com.tencent.mm.model.c.apM().aHY(ContactLabelUI.i(ContactLabelUI.this));
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          localObject3 = ((au)localObject3).field_contactLabelIds;
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject3)) {
            break;
          }
          localObject1 = (ArrayList)a.cIS().aeK((String)localObject3);
          break;
          label415:
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
      }
    });
    super.onResume();
    AppMethodBeat.o(26305);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26308);
    ad.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    case 636: 
    case 637: 
    default: 
      ad.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
      AppMethodBeat.o(26308);
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        cJb();
        AppMethodBeat.o(26308);
        return;
      }
      cIW();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      cJc();
      AppMethodBeat.o(26308);
      return;
    }
    cIW();
    AppMethodBeat.o(26308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(26301);
      sNw = new a("Normal", 0);
      sNx = new a("Search", 1);
      sNy = new a("OverMaxCount", 2);
      sNz = new a("Invaildnput", 3);
      sNA = new a[] { sNw, sNx, sNy, sNz };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */