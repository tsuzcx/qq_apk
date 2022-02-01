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
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements com.tencent.mm.al.f
{
  private String fGM;
  private boolean uWK;
  private ArrayList<String> uXA;
  private MMTagPanelScrollView uXj;
  private MMLabelPanel uXk;
  private TextView uXl;
  private View uXm;
  private View uXn;
  private TextView uXo;
  private MMLabelPanel uXp;
  private ListView uXq;
  private ScrollView uXr;
  private b uXs;
  private String uXt;
  private ArrayList<String> uXu;
  private HashSet<String> uXv;
  private HashSet<String> uXw;
  private ArrayList<String> uXx;
  private a uXy;
  private boolean uXz;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.uXv = new HashSet();
    this.uXw = new HashSet();
    this.uXx = new ArrayList();
    this.uXy = a.uXD;
    this.uXz = false;
    this.uWK = true;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.uXy = parama;
    switch (4.uXC[this.uXy.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.uXq.setVisibility(8);
      if ((this.uXx != null) && (this.uXx.size() > 0))
      {
        this.uXm.setVisibility(0);
        this.uXr.setVisibility(0);
      }
      for (;;)
      {
        this.uXl.setVisibility(8);
        AppMethodBeat.o(26310);
        return;
        this.uXr.setVisibility(8);
        this.uXm.setVisibility(8);
      }
      this.uXr.setVisibility(8);
      this.uXq.setVisibility(0);
      this.uXm.setVisibility(8);
      this.uXl.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.uXq.setVisibility(8);
      this.uXr.setVisibility(8);
      this.uXm.setVisibility(8);
      this.uXl.setVisibility(0);
      this.uXl.setText(2131760616);
      AppMethodBeat.o(26310);
      return;
      this.uXq.setVisibility(8);
      this.uXr.setVisibility(8);
      this.uXm.setVisibility(8);
      this.uXl.setVisibility(0);
      this.uXl.setText(2131760616);
    }
  }
  
  private void bt(String paramString, boolean paramBoolean)
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
    ao localao = e.dfn().aTb(paramString);
    if (paramBoolean) {
      if ((this.uXx == null) || (!this.uXx.contains(paramString)) || (localao == null)) {
        this.uXw.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.uXv != null) && (this.uXv.contains(paramString))) {
        this.uXv.remove(paramString);
      }
      if (dfz()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.uXx == null) || (!this.uXx.contains(paramString)) || ((localao != null) && (localao.field_isTemporary))) {
        this.uXw.add(paramString);
      }
    }
  }
  
  private void dfs()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    abY(getString(2131755143));
    AppMethodBeat.o(26314);
  }
  
  private void dfx()
  {
    AppMethodBeat.i(26312);
    ad.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.uXk != null)
    {
      ad.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.uXk.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = com.tencent.mm.plugin.label.c.el(e.dfn().aP((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new dtz();
      ((dtz)localObject3).Gca = ((String)localObject1);
      ((dtz)localObject3).nDo = this.fGM;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      ba.aiU().a((com.tencent.mm.al.n)localObject1, 0);
      if (this.uXw == null) {
        break label338;
      }
    }
    label338:
    for (int i = this.uXw.size();; i = 0)
    {
      if (this.uXu != null) {}
      for (int j = this.uXu.size();; j = 0)
      {
        if (this.uXv != null) {}
        for (int k = this.uXv.size();; k = 0)
        {
          j = k + this.uXk.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            ad.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            g.yhR.f(11220, new Object[] { u.aAm(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            g.yhR.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void dfy()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.uXw.clear();
    this.uXv.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean dfz()
  {
    AppMethodBeat.i(26315);
    if (this.uXk != null)
    {
      if ((this.uXu != null) && (this.uXu.size() > 0))
      {
        if ((this.uXk.getTagList() == null) && (this.uXk.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.uXk.getTagList();
        Collections.sort(this.uXu);
        Collections.sort(localArrayList);
        if (!this.uXu.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.uXk.getTagList() != null) && (this.uXk.getTagList().size() > 0))
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
    if (this.uXk != null) {
      this.uXk.fzb();
    }
    Intent localIntent = new Intent();
    if (dfz()) {
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
    }, null, s.b.JbS);
    this.uXj = ((MMTagPanelScrollView)findViewById(2131301298));
    this.uXj.setMaxLine(3);
    this.uXk = ((MMLabelPanel)findViewById(2131301297));
    this.uXl = ((TextView)findViewById(2131301300));
    this.uXm = findViewById(2131301296);
    this.uXn = findViewById(2131301295);
    this.uXn.setBackgroundDrawable(null);
    this.uXo = ((TextView)this.uXn.findViewById(16908310));
    this.uXo.setText(2131760615);
    this.uXp = ((MMLabelPanel)findViewById(2131301293));
    this.uXq = ((ListView)findViewById(2131301299));
    this.uXr = ((ScrollView)findViewById(2131301301));
    if (this.uXr != null) {
      this.uXr.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(26285);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (paramAnonymousMotionEvent.getAction() == 2) {
            ContactLabelUI.this.hideVKB();
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(26285);
          return false;
        }
      });
    }
    this.uXk.Jnz = true;
    this.uXk.xC(true);
    this.uXk.setTagEditTextBG(2131234289);
    this.uXk.setCallBack(new MMTagPanel.a()
    {
      public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(26292);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousBoolean)
        {
          ContactLabelUI.this.enableOptionMenu(false);
          ContactLabelUI.e(ContactLabelUI.this).setVisibility(0);
          ContactLabelUI.e(ContactLabelUI.this).setText(2131760616);
          ContactLabelUI.e(ContactLabelUI.this).setText(String.format(ContactLabelUI.this.getString(2131760616), new Object[] { Integer.valueOf(com.tencent.mm.ui.tools.f.cU(36, "")), Integer.valueOf(paramAnonymousInt) }));
          AppMethodBeat.o(26292);
          return;
        }
        ContactLabelUI.this.enableOptionMenu(true);
        ContactLabelUI.e(ContactLabelUI.this).setVisibility(8);
        AppMethodBeat.o(26292);
      }
      
      public final void acc(String paramAnonymousString)
      {
        AppMethodBeat.i(26286);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cO(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26286);
      }
      
      public final void acd(String paramAnonymousString)
      {
        AppMethodBeat.i(26287);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(26287);
      }
      
      public final void ace(String paramAnonymousString)
      {
        AppMethodBeat.i(26288);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cO(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26288);
      }
      
      public final void acf(String paramAnonymousString)
      {
        AppMethodBeat.i(26290);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26290);
      }
      
      public final void acg(String paramAnonymousString)
      {
        AppMethodBeat.i(26291);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (bt.isNullOrNil(paramAnonymousString))
        {
          ad.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
          AppMethodBeat.o(26291);
          return;
        }
        ContactLabelUI.b(ContactLabelUI.this).cN(paramAnonymousString, true);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cO(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26291);
      }
      
      public final void ciS()
      {
        AppMethodBeat.i(26289);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
        AppMethodBeat.o(26289);
      }
    });
    this.uXp.xC(false);
    this.uXp.setCallBack(new MMTagPanel.a()
    {
      public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void acc(String paramAnonymousString)
      {
        AppMethodBeat.i(26293);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26293);
      }
      
      public final void acd(String paramAnonymousString)
      {
        AppMethodBeat.i(26294);
        ad.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).cN(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26294);
      }
      
      public final void ace(String paramAnonymousString) {}
      
      public final void acf(String paramAnonymousString) {}
      
      public final void acg(String paramAnonymousString) {}
      
      public final void ciS() {}
    });
    this.uXq.setAdapter(this.uXs);
    this.uXq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26295);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (ContactLabelUI.f(ContactLabelUI.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(26295);
          return;
        }
        paramAnonymousAdapterView = ContactLabelUI.f(ContactLabelUI.this).getItem(paramAnonymousInt);
        if ((!bt.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.b(ContactLabelUI.this) != null))
        {
          ContactLabelUI.b(ContactLabelUI.this).fyZ();
          ContactLabelUI.b(ContactLabelUI.this).cN(paramAnonymousAdapterView, true);
          ContactLabelUI.c(ContactLabelUI.this).cO(paramAnonymousAdapterView, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26295);
      }
    });
    enableOptionMenu(false);
    AppMethodBeat.o(26303);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26309);
    if (dfz())
    {
      h.e(this, getString(2131762782), "", getString(2131756751), getString(2131756754), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    this.uXt = getIntent().getStringExtra("label_id_list");
    this.uXu = getIntent().getStringArrayListExtra("label_str_list");
    this.fGM = getIntent().getStringExtra("label_username");
    this.uXz = getIntent().getBooleanExtra("is_stranger", false);
    this.uXs = new b(this);
    initView();
    if ((!bt.isNullOrNil(this.uXt)) && (this.uXu != null) && (this.uXu.size() > 0)) {
      this.uXk.a(this.uXu, this.uXu);
    }
    if (this.uXz)
    {
      this.uXA = getIntent().getStringArrayListExtra("label_str_list");
      this.uXk.a(this.uXA, this.uXA);
    }
    g.yhR.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
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
    ba.aiU().b(635, this);
    ba.aiU().b(638, this);
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    ba.aiU().a(635, this);
    ba.aiU().a(638, this);
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
            ba.aBQ();
            localObject2 = com.tencent.mm.model.c.azq().aqz(ContactLabelUI.i(ContactLabelUI.this));
            if (localObject2 != null) {
              localObject1 = ((cf)localObject2).field_contactLabels;
            }
            localObject3 = localObject1;
            if (bt.isNullOrNil((String)localObject1))
            {
              ba.aBQ();
              am localam = com.tencent.mm.model.c.azp().Bf(ContactLabelUI.i(ContactLabelUI.this));
              localObject3 = localam.field_encryptUsername;
              localObject2 = localObject1;
              if (!bt.isNullOrNil((String)localObject3))
              {
                ba.aBQ();
                localObject3 = com.tencent.mm.model.c.azq().aqz((String)localObject3);
                localObject2 = localObject1;
                if (localObject3 != null) {
                  localObject2 = ((cf)localObject3).field_contactLabels;
                }
              }
              localObject3 = localObject2;
              if (bt.isNullOrNil((String)localObject2))
              {
                localObject1 = localam.field_username;
                ba.aBQ();
                localObject1 = com.tencent.mm.model.c.azq().aqz((String)localObject1);
                localObject3 = localObject2;
                if (localObject1 != null) {
                  localObject3 = ((cf)localObject1).field_contactLabels;
                }
              }
            }
            localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aon((String)localObject3);
            ContactLabelUI.b(ContactLabelUI.this).a((Collection)localObject1, (List)localObject1);
            ContactLabelUI.a(ContactLabelUI.this, (ArrayList)localObject1);
          }
        }
        else if (ContactLabelUI.c(ContactLabelUI.this) != null)
        {
          ContactLabelUI.b(ContactLabelUI.this, e.dfn().fqo());
          if ((ContactLabelUI.j(ContactLabelUI.this) == null) || (ContactLabelUI.j(ContactLabelUI.this).size() <= 0)) {
            break label415;
          }
          ContactLabelUI.d(ContactLabelUI.this);
          ContactLabelUI.c(ContactLabelUI.this).a((Collection)localObject1, ContactLabelUI.j(ContactLabelUI.this));
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            g.yhR.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
        for (;;)
        {
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.uXD);
          AppMethodBeat.o(26298);
          return;
          ba.aBQ();
          localObject3 = com.tencent.mm.model.c.azp().Bf(ContactLabelUI.i(ContactLabelUI.this));
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          localObject3 = ((aw)localObject3).field_contactLabelIds;
          localObject1 = localObject2;
          if (bt.isNullOrNil((String)localObject3)) {
            break;
          }
          localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aoo((String)localObject3);
          break;
          label415:
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            g.yhR.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
      }
    });
    super.onResume();
    AppMethodBeat.o(26305);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
        dfx();
        AppMethodBeat.o(26308);
        return;
      }
      dfs();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      dfy();
      AppMethodBeat.o(26308);
      return;
    }
    dfs();
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
      uXD = new a("Normal", 0);
      uXE = new a("Search", 1);
      uXF = new a("OverMaxCount", 2);
      uXG = new a("Invaildnput", 3);
      uXH = new a[] { uXD, uXE, uXF, uXG };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */