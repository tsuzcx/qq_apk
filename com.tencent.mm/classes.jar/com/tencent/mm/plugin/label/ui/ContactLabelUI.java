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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.s.b;
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
  private String foE;
  private MMTagPanelScrollView tUH;
  private MMLabelPanel tUI;
  private TextView tUJ;
  private View tUK;
  private View tUL;
  private TextView tUM;
  private MMLabelPanel tUN;
  private ListView tUO;
  private ScrollView tUP;
  private b tUQ;
  private String tUR;
  private ArrayList<String> tUS;
  private HashSet<String> tUT;
  private HashSet<String> tUU;
  private ArrayList<String> tUV;
  private a tUW;
  private boolean tUX;
  private ArrayList<String> tUY;
  private boolean tUi;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.tUT = new HashSet();
    this.tUU = new HashSet();
    this.tUV = new ArrayList();
    this.tUW = a.tVb;
    this.tUX = false;
    this.tUi = true;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.tUW = parama;
    switch (4.tVa[this.tUW.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.tUO.setVisibility(8);
      if ((this.tUV != null) && (this.tUV.size() > 0))
      {
        this.tUK.setVisibility(0);
        this.tUP.setVisibility(0);
      }
      for (;;)
      {
        this.tUJ.setVisibility(8);
        AppMethodBeat.o(26310);
        return;
        this.tUP.setVisibility(8);
        this.tUK.setVisibility(8);
      }
      this.tUP.setVisibility(8);
      this.tUO.setVisibility(0);
      this.tUK.setVisibility(8);
      this.tUJ.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.tUO.setVisibility(8);
      this.tUP.setVisibility(8);
      this.tUK.setVisibility(8);
      this.tUJ.setVisibility(0);
      this.tUJ.setText(2131760616);
      AppMethodBeat.o(26310);
      return;
      this.tUO.setVisibility(8);
      this.tUP.setVisibility(8);
      this.tUK.setVisibility(8);
      this.tUJ.setVisibility(0);
      this.tUJ.setText(2131760616);
    }
  }
  
  private void bn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26311);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    paramString = paramString.trim();
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    ak localak = e.cWc().aNj(paramString);
    if (paramBoolean) {
      if ((this.tUV == null) || (!this.tUV.contains(paramString)) || (localak == null)) {
        this.tUU.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.tUT != null) && (this.tUT.contains(paramString))) {
        this.tUT.remove(paramString);
      }
      if (cWo()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.tUV == null) || (!this.tUV.contains(paramString)) || ((localak != null) && (localak.field_isTemporary))) {
        this.tUU.add(paramString);
      }
    }
  }
  
  private void cWh()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    Ys(getString(2131755143));
    AppMethodBeat.o(26314);
  }
  
  private void cWm()
  {
    AppMethodBeat.i(26312);
    ac.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.tUI != null)
    {
      ac.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.tUI.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = com.tencent.mm.plugin.label.c.dY(e.cWc().aS((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new doi();
      ((doi)localObject3).EuG = ((String)localObject1);
      ((doi)localObject3).ncR = this.foE;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      az.agi().a((n)localObject1, 0);
      if (this.tUU == null) {
        break label338;
      }
    }
    label338:
    for (int i = this.tUU.size();; i = 0)
    {
      if (this.tUS != null) {}
      for (int j = this.tUS.size();; j = 0)
      {
        if (this.tUT != null) {}
        for (int k = this.tUT.size();; k = 0)
        {
          j = k + this.tUI.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            ac.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.wUl.f(11220, new Object[] { u.axw(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void cWn()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.tUU.clear();
    this.tUT.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean cWo()
  {
    AppMethodBeat.i(26315);
    if (this.tUI != null)
    {
      if ((this.tUS != null) && (this.tUS.size() > 0))
      {
        if ((this.tUI.getTagList() == null) && (this.tUI.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.tUI.getTagList();
        Collections.sort(this.tUS);
        Collections.sort(localArrayList);
        if (!this.tUS.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.tUI.getTagList() != null) && (this.tUI.getTagList().size() > 0))
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
    if (this.tUI != null) {
      this.tUI.fiM();
    }
    Intent localIntent = new Intent();
    if (cWo()) {
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
    }, null, s.b.Hom);
    this.tUH = ((MMTagPanelScrollView)findViewById(2131301298));
    this.tUH.setMaxLine(3);
    this.tUI = ((MMLabelPanel)findViewById(2131301297));
    this.tUJ = ((TextView)findViewById(2131301300));
    this.tUK = findViewById(2131301296);
    this.tUL = findViewById(2131301295);
    this.tUL.setBackgroundDrawable(null);
    this.tUM = ((TextView)this.tUL.findViewById(16908310));
    this.tUM.setText(2131760615);
    this.tUN = ((MMLabelPanel)findViewById(2131301293));
    this.tUO = ((ListView)findViewById(2131301299));
    this.tUP = ((ScrollView)findViewById(2131301301));
    if (this.tUP != null) {
      this.tUP.setOnTouchListener(new View.OnTouchListener()
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
    this.tUI.HzI = true;
    this.tUI.wR(true);
    this.tUI.setTagEditTextBG(2131234289);
    this.tUI.setCallBack(new MMTagPanel.a()
    {
      public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(26292);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousBoolean)
        {
          ContactLabelUI.this.enableOptionMenu(false);
          ContactLabelUI.e(ContactLabelUI.this).setVisibility(0);
          ContactLabelUI.e(ContactLabelUI.this).setText(2131760616);
          ContactLabelUI.e(ContactLabelUI.this).setText(String.format(ContactLabelUI.this.getString(2131760616), new Object[] { Integer.valueOf(f.cM(36, "")), Integer.valueOf(paramAnonymousInt) }));
          AppMethodBeat.o(26292);
          return;
        }
        ContactLabelUI.this.enableOptionMenu(true);
        ContactLabelUI.e(ContactLabelUI.this).setVisibility(8);
        AppMethodBeat.o(26292);
      }
      
      public final void YA(String paramAnonymousString)
      {
        AppMethodBeat.i(26291);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (bs.isNullOrNil(paramAnonymousString))
        {
          ac.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
          AppMethodBeat.o(26291);
          return;
        }
        ContactLabelUI.b(ContactLabelUI.this).cI(paramAnonymousString, true);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cJ(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26291);
      }
      
      public final void Yw(String paramAnonymousString)
      {
        AppMethodBeat.i(26286);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cJ(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26286);
      }
      
      public final void Yx(String paramAnonymousString)
      {
        AppMethodBeat.i(26287);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(26287);
      }
      
      public final void Yy(String paramAnonymousString)
      {
        AppMethodBeat.i(26288);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).cJ(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26288);
      }
      
      public final void Yz(String paramAnonymousString)
      {
        AppMethodBeat.i(26290);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26290);
      }
      
      public final void cep()
      {
        AppMethodBeat.i(26289);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
        AppMethodBeat.o(26289);
      }
    });
    this.tUN.wR(false);
    this.tUN.setCallBack(new MMTagPanel.a()
    {
      public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void YA(String paramAnonymousString) {}
      
      public final void Yw(String paramAnonymousString)
      {
        AppMethodBeat.i(26293);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26293);
      }
      
      public final void Yx(String paramAnonymousString)
      {
        AppMethodBeat.i(26294);
        ac.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).cI(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26294);
      }
      
      public final void Yy(String paramAnonymousString) {}
      
      public final void Yz(String paramAnonymousString) {}
      
      public final void cep() {}
    });
    this.tUO.setAdapter(this.tUQ);
    this.tUO.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
        if ((!bs.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.b(ContactLabelUI.this) != null))
        {
          ContactLabelUI.b(ContactLabelUI.this).fiK();
          ContactLabelUI.b(ContactLabelUI.this).cI(paramAnonymousAdapterView, true);
          ContactLabelUI.c(ContactLabelUI.this).cJ(paramAnonymousAdapterView, true);
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
    if (cWo())
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
      ac.printErrStackTrace("MicroMsg.Label.ContactLabelUI", localException, "", new Object[0]);
      AppMethodBeat.o(26309);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26304);
    super.onCreate(paramBundle);
    this.tUR = getIntent().getStringExtra("label_id_list");
    this.tUS = getIntent().getStringArrayListExtra("label_str_list");
    this.foE = getIntent().getStringExtra("label_username");
    this.tUX = getIntent().getBooleanExtra("is_stranger", false);
    this.tUQ = new b(this);
    initView();
    if ((!bs.isNullOrNil(this.tUR)) && (this.tUS != null) && (this.tUS.size() > 0)) {
      this.tUI.a(this.tUS, this.tUS);
    }
    if (this.tUX)
    {
      this.tUY = getIntent().getStringArrayListExtra("label_str_list");
      this.tUI.a(this.tUY, this.tUY);
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
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
    az.agi().b(635, this);
    az.agi().b(638, this);
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    az.agi().a(635, this);
    az.agi().a(638, this);
    ap.f(new Runnable()
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
            az.ayM();
            localObject2 = com.tencent.mm.model.c.awC().alK(ContactLabelUI.i(ContactLabelUI.this));
            if (localObject2 != null) {
              localObject1 = ((bz)localObject2).field_contactLabels;
            }
            localObject3 = localObject1;
            if (bs.isNullOrNil((String)localObject1))
            {
              az.ayM();
              ai localai = com.tencent.mm.model.c.awB().aNt(ContactLabelUI.i(ContactLabelUI.this));
              localObject3 = localai.field_encryptUsername;
              localObject2 = localObject1;
              if (!bs.isNullOrNil((String)localObject3))
              {
                az.ayM();
                localObject3 = com.tencent.mm.model.c.awC().alK((String)localObject3);
                localObject2 = localObject1;
                if (localObject3 != null) {
                  localObject2 = ((bz)localObject3).field_contactLabels;
                }
              }
              localObject3 = localObject2;
              if (bs.isNullOrNil((String)localObject2))
              {
                localObject1 = localai.field_username;
                az.ayM();
                localObject1 = com.tencent.mm.model.c.awC().alK((String)localObject1);
                localObject3 = localObject2;
                if (localObject1 != null) {
                  localObject3 = ((bz)localObject1).field_contactLabels;
                }
              }
            }
            localObject1 = (ArrayList)a.cWd().ajB((String)localObject3);
            ContactLabelUI.b(ContactLabelUI.this).a((Collection)localObject1, (List)localObject1);
            ContactLabelUI.a(ContactLabelUI.this, (ArrayList)localObject1);
          }
        }
        else if (ContactLabelUI.c(ContactLabelUI.this) != null)
        {
          ContactLabelUI.b(ContactLabelUI.this, e.cWc().fal());
          if ((ContactLabelUI.j(ContactLabelUI.this) == null) || (ContactLabelUI.j(ContactLabelUI.this).size() <= 0)) {
            break label415;
          }
          ContactLabelUI.d(ContactLabelUI.this);
          ContactLabelUI.c(ContactLabelUI.this).a((Collection)localObject1, ContactLabelUI.j(ContactLabelUI.this));
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
        for (;;)
        {
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.tVb);
          AppMethodBeat.o(26298);
          return;
          az.ayM();
          localObject3 = com.tencent.mm.model.c.awB().aNt(ContactLabelUI.i(ContactLabelUI.this));
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          localObject3 = ((av)localObject3).field_contactLabelIds;
          localObject1 = localObject2;
          if (bs.isNullOrNil((String)localObject3)) {
            break;
          }
          localObject1 = (ArrayList)a.cWd().ajC((String)localObject3);
          break;
          label415:
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
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
    ac.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramn.getType())
    {
    case 636: 
    case 637: 
    default: 
      ac.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
      AppMethodBeat.o(26308);
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        cWm();
        AppMethodBeat.o(26308);
        return;
      }
      cWh();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      cWn();
      AppMethodBeat.o(26308);
      return;
    }
    cWh();
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
      tVb = new a("Normal", 0);
      tVc = new a("Search", 1);
      tVd = new a("OverMaxCount", 2);
      tVe = new a("Invaildnput", 3);
      tVf = new a[] { tVb, tVc, tVd, tVe };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */