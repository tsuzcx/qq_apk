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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
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
  implements com.tencent.mm.ak.f
{
  private String fIQ;
  private MMTagPanelScrollView viX;
  private MMLabelPanel viY;
  private TextView viZ;
  private boolean viy;
  private View vja;
  private View vjb;
  private TextView vjc;
  private MMLabelPanel vjd;
  private ListView vje;
  private ScrollView vjf;
  private b vjg;
  private String vjh;
  private ArrayList<String> vji;
  private HashSet<String> vjj;
  private HashSet<String> vjk;
  private ArrayList<String> vjl;
  private a vjm;
  private boolean vjn;
  private ArrayList<String> vjo;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.vjj = new HashSet();
    this.vjk = new HashSet();
    this.vjl = new ArrayList();
    this.vjm = a.vjr;
    this.vjn = false;
    this.viy = true;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.vjm = parama;
    switch (4.vjq[this.vjm.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.vje.setVisibility(8);
      if ((this.vjl != null) && (this.vjl.size() > 0))
      {
        this.vja.setVisibility(0);
        this.vjf.setVisibility(0);
      }
      for (;;)
      {
        this.viZ.setVisibility(8);
        AppMethodBeat.o(26310);
        return;
        this.vjf.setVisibility(8);
        this.vja.setVisibility(8);
      }
      this.vjf.setVisibility(8);
      this.vje.setVisibility(0);
      this.vja.setVisibility(8);
      this.viZ.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.vje.setVisibility(8);
      this.vjf.setVisibility(8);
      this.vja.setVisibility(8);
      this.viZ.setVisibility(0);
      this.viZ.setText(2131760616);
      AppMethodBeat.o(26310);
      return;
      this.vje.setVisibility(8);
      this.vjf.setVisibility(8);
      this.vja.setVisibility(8);
      this.viZ.setVisibility(0);
      this.viZ.setText(2131760616);
    }
  }
  
  private void bw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26311);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    paramString = paramString.trim();
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    ap localap = e.dif().aUC(paramString);
    if (paramBoolean) {
      if ((this.vjl == null) || (!this.vjl.contains(paramString)) || (localap == null)) {
        this.vjk.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.vjj != null) && (this.vjj.contains(paramString))) {
        this.vjj.remove(paramString);
      }
      if (dir()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.vjl == null) || (!this.vjl.contains(paramString)) || ((localap != null) && (localap.field_isTemporary))) {
        this.vjk.add(paramString);
      }
    }
  }
  
  private void dik()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    acP(getString(2131755143));
    AppMethodBeat.o(26314);
  }
  
  private void dip()
  {
    AppMethodBeat.i(26312);
    ae.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.viY != null)
    {
      ae.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.viY.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = com.tencent.mm.plugin.label.c.ep(e.dif().aQ((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new duw();
      ((duw)localObject3).GuH = ((String)localObject1);
      ((duw)localObject3).nIJ = this.fIQ;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      bc.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
      if (this.vjk == null) {
        break label338;
      }
    }
    label338:
    for (int i = this.vjk.size();; i = 0)
    {
      if (this.vji != null) {}
      for (int j = this.vji.size();; j = 0)
      {
        if (this.vjj != null) {}
        for (int k = this.vjj.size();; k = 0)
        {
          j = k + this.viY.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            ae.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            g.yxI.f(11220, new Object[] { v.aAC(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            g.yxI.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void diq()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.vjk.clear();
    this.vjj.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean dir()
  {
    AppMethodBeat.i(26315);
    if (this.viY != null)
    {
      if ((this.vji != null) && (this.vji.size() > 0))
      {
        if ((this.viY.getTagList() == null) && (this.viY.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.viY.getTagList();
        Collections.sort(this.vji);
        Collections.sort(localArrayList);
        if (!this.vji.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.viY.getTagList() != null) && (this.viY.getTagList().size() > 0))
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
    if (this.viY != null) {
      this.viY.fDd();
    }
    Intent localIntent = new Intent();
    if (dir()) {
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
    }, null, s.b.JwA);
    this.viX = ((MMTagPanelScrollView)findViewById(2131301298));
    this.viX.setMaxLine(3);
    this.viY = ((MMLabelPanel)findViewById(2131301297));
    this.viZ = ((TextView)findViewById(2131301300));
    this.vja = findViewById(2131301296);
    this.vjb = findViewById(2131301295);
    this.vjb.setBackgroundDrawable(null);
    this.vjc = ((TextView)this.vjb.findViewById(16908310));
    this.vjc.setText(2131760615);
    this.vjd = ((MMLabelPanel)findViewById(2131301293));
    this.vje = ((ListView)findViewById(2131301299));
    this.vjf = ((ScrollView)findViewById(2131301301));
    if (this.vjf != null) {
      this.vjf.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(26285);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          if (paramAnonymousMotionEvent.getAction() == 2) {
            ContactLabelUI.this.hideVKB();
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(26285);
          return false;
        }
      });
    }
    this.viY.JIo = true;
    this.viY.xK(true);
    this.viY.setTagEditTextBG(2131234289);
    this.viY.setCallBack(new MMTagPanel.a()
    {
      public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(26292);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
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
      
      public final void acT(String paramAnonymousString)
      {
        AppMethodBeat.i(26286);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cS(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26286);
      }
      
      public final void acU(String paramAnonymousString)
      {
        AppMethodBeat.i(26287);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(26287);
      }
      
      public final void acV(String paramAnonymousString)
      {
        AppMethodBeat.i(26288);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cS(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26288);
      }
      
      public final void acW(String paramAnonymousString)
      {
        AppMethodBeat.i(26290);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26290);
      }
      
      public final void acX(String paramAnonymousString)
      {
        AppMethodBeat.i(26291);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (bu.isNullOrNil(paramAnonymousString))
        {
          ae.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
          AppMethodBeat.o(26291);
          return;
        }
        ContactLabelUI.b(ContactLabelUI.this).cR(paramAnonymousString, true);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cS(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26291);
      }
      
      public final void cki()
      {
        AppMethodBeat.i(26289);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
        AppMethodBeat.o(26289);
      }
    });
    this.vjd.xK(false);
    this.vjd.setCallBack(new MMTagPanel.a()
    {
      public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void acT(String paramAnonymousString)
      {
        AppMethodBeat.i(26293);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26293);
      }
      
      public final void acU(String paramAnonymousString)
      {
        AppMethodBeat.i(26294);
        ae.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).cR(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26294);
      }
      
      public final void acV(String paramAnonymousString) {}
      
      public final void acW(String paramAnonymousString) {}
      
      public final void acX(String paramAnonymousString) {}
      
      public final void cki() {}
    });
    this.vje.setAdapter(this.vjg);
    this.vje.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26295);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (ContactLabelUI.f(ContactLabelUI.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(26295);
          return;
        }
        paramAnonymousAdapterView = ContactLabelUI.f(ContactLabelUI.this).getItem(paramAnonymousInt);
        if ((!bu.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.b(ContactLabelUI.this) != null))
        {
          ContactLabelUI.b(ContactLabelUI.this).fDb();
          ContactLabelUI.b(ContactLabelUI.this).cR(paramAnonymousAdapterView, true);
          ContactLabelUI.c(ContactLabelUI.this).cS(paramAnonymousAdapterView, true);
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
    if (dir())
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
      ae.printErrStackTrace("MicroMsg.Label.ContactLabelUI", localException, "", new Object[0]);
      AppMethodBeat.o(26309);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26304);
    super.onCreate(paramBundle);
    this.vjh = getIntent().getStringExtra("label_id_list");
    this.vji = getIntent().getStringArrayListExtra("label_str_list");
    this.fIQ = getIntent().getStringExtra("label_username");
    this.vjn = getIntent().getBooleanExtra("is_stranger", false);
    this.vjg = new b(this);
    initView();
    if ((!bu.isNullOrNil(this.vjh)) && (this.vji != null) && (this.vji.size() > 0)) {
      this.viY.a(this.vji, this.vji);
    }
    if (this.vjn)
    {
      this.vjo = getIntent().getStringArrayListExtra("label_str_list");
      this.viY.a(this.vjo, this.vjo);
    }
    g.yxI.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
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
    bc.ajj().b(635, this);
    bc.ajj().b(638, this);
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    bc.ajj().a(635, this);
    bc.ajj().a(638, this);
    ar.f(new Runnable()
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
            bc.aCg();
            localObject2 = com.tencent.mm.model.c.azG().arE(ContactLabelUI.i(ContactLabelUI.this));
            if (localObject2 != null) {
              localObject1 = ((cg)localObject2).field_contactLabels;
            }
            localObject3 = localObject1;
            if (bu.isNullOrNil((String)localObject1))
            {
              bc.aCg();
              an localan = com.tencent.mm.model.c.azF().BH(ContactLabelUI.i(ContactLabelUI.this));
              localObject3 = localan.field_encryptUsername;
              localObject2 = localObject1;
              if (!bu.isNullOrNil((String)localObject3))
              {
                bc.aCg();
                localObject3 = com.tencent.mm.model.c.azG().arE((String)localObject3);
                localObject2 = localObject1;
                if (localObject3 != null) {
                  localObject2 = ((cg)localObject3).field_contactLabels;
                }
              }
              localObject3 = localObject2;
              if (bu.isNullOrNil((String)localObject2))
              {
                localObject1 = localan.field_username;
                bc.aCg();
                localObject1 = com.tencent.mm.model.c.azG().arE((String)localObject1);
                localObject3 = localObject2;
                if (localObject1 != null) {
                  localObject3 = ((cg)localObject1).field_contactLabels;
                }
              }
            }
            localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.dig().app((String)localObject3);
            ContactLabelUI.b(ContactLabelUI.this).a((Collection)localObject1, (List)localObject1);
            ContactLabelUI.a(ContactLabelUI.this, (ArrayList)localObject1);
          }
        }
        else if (ContactLabelUI.c(ContactLabelUI.this) != null)
        {
          ContactLabelUI.b(ContactLabelUI.this, e.dif().fuo());
          if ((ContactLabelUI.j(ContactLabelUI.this) == null) || (ContactLabelUI.j(ContactLabelUI.this).size() <= 0)) {
            break label415;
          }
          ContactLabelUI.d(ContactLabelUI.this);
          ContactLabelUI.c(ContactLabelUI.this).a((Collection)localObject1, ContactLabelUI.j(ContactLabelUI.this));
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            g.yxI.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
        for (;;)
        {
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.vjr);
          AppMethodBeat.o(26298);
          return;
          bc.aCg();
          localObject3 = com.tencent.mm.model.c.azF().BH(ContactLabelUI.i(ContactLabelUI.this));
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          localObject3 = ((aw)localObject3).field_contactLabelIds;
          localObject1 = localObject2;
          if (bu.isNullOrNil((String)localObject3)) {
            break;
          }
          localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.dig().apq((String)localObject3);
          break;
          label415:
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            g.yxI.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
      }
    });
    super.onResume();
    AppMethodBeat.o(26305);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(26308);
    ae.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    case 636: 
    case 637: 
    default: 
      ae.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
      AppMethodBeat.o(26308);
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        dip();
        AppMethodBeat.o(26308);
        return;
      }
      dik();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      diq();
      AppMethodBeat.o(26308);
      return;
    }
    dik();
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
      vjr = new a("Normal", 0);
      vjs = new a("Search", 1);
      vjt = new a("OverMaxCount", 2);
      vju = new a("Invaildnput", 3);
      vjv = new a[] { vjr, vjs, vjt, vju };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */