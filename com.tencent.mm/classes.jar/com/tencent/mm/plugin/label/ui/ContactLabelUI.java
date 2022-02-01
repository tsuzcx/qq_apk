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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements i
{
  private String goe;
  private boolean yCB;
  private MMTagPanelScrollView yDa;
  private MMLabelPanel yDb;
  private TextView yDc;
  private View yDd;
  private View yDe;
  private TextView yDf;
  private MMLabelPanel yDg;
  private ListView yDh;
  private ScrollView yDi;
  private b yDj;
  private String yDk;
  private ArrayList<String> yDl;
  private HashSet<String> yDm;
  private HashSet<String> yDn;
  private ArrayList<String> yDo;
  private a yDp;
  private boolean yDq;
  private ArrayList<String> yDr;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.yDm = new HashSet();
    this.yDn = new HashSet();
    this.yDo = new ArrayList();
    this.yDp = a.yDu;
    this.yDq = false;
    this.yCB = true;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.yDp = parama;
    switch (4.yDt[this.yDp.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.yDh.setVisibility(8);
      if ((this.yDo != null) && (this.yDo.size() > 0))
      {
        this.yDd.setVisibility(0);
        this.yDi.setVisibility(0);
      }
      for (;;)
      {
        this.yDc.setVisibility(8);
        AppMethodBeat.o(26310);
        return;
        this.yDi.setVisibility(8);
        this.yDd.setVisibility(8);
      }
      this.yDi.setVisibility(8);
      this.yDh.setVisibility(0);
      this.yDd.setVisibility(8);
      this.yDc.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.yDh.setVisibility(8);
      this.yDi.setVisibility(8);
      this.yDd.setVisibility(8);
      this.yDc.setVisibility(0);
      this.yDc.setText(2131762128);
      AppMethodBeat.o(26310);
      return;
      this.yDh.setVisibility(8);
      this.yDi.setVisibility(8);
      this.yDd.setVisibility(8);
      this.yDc.setVisibility(0);
      this.yDc.setText(2131762128);
    }
  }
  
  private void bL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26311);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    paramString = paramString.trim();
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
      AppMethodBeat.o(26311);
      return;
    }
    au localau = e.ecf().bjB(paramString);
    if (paramBoolean) {
      if ((this.yDo == null) || (!this.yDo.contains(paramString)) || (localau == null)) {
        this.yDn.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.yDm != null) && (this.yDm.contains(paramString))) {
        this.yDm.remove(paramString);
      }
      if (ecr()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.yDo == null) || (!this.yDo.contains(paramString)) || ((localau != null) && (localau.field_isTemporary))) {
        this.yDn.add(paramString);
      }
    }
  }
  
  private void eck()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    amW(getString(2131755161));
    AppMethodBeat.o(26314);
  }
  
  private void ecp()
  {
    AppMethodBeat.i(26312);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.yDb != null)
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.yDb.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = com.tencent.mm.plugin.label.c.fj(e.ecf().bi((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new eov();
      ((eov)localObject3).Lqm = ((String)localObject1);
      ((eov)localObject3).UserName = this.goe;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      bg.azz().a((q)localObject1, 0);
      if (this.yDn == null) {
        break label338;
      }
    }
    label338:
    for (int i = this.yDn.size();; i = 0)
    {
      if (this.yDl != null) {}
      for (int j = this.yDl.size();; j = 0)
      {
        if (this.yDm != null) {}
        for (int k = this.yDm.size();; k = 0)
        {
          j = k + this.yDb.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            Log.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.CyF.a(11220, new Object[] { z.aTY(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void ecq()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.yDn.clear();
    this.yDm.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean ecr()
  {
    AppMethodBeat.i(26315);
    if (this.yDb != null)
    {
      if ((this.yDl != null) && (this.yDl.size() > 0))
      {
        if ((this.yDb.getTagList() == null) && (this.yDb.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.yDb.getTagList();
        Collections.sort(this.yDl);
        Collections.sort(localArrayList);
        if (!this.yDl.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.yDb.getTagList() != null) && (this.yDb.getTagList().size() > 0))
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
    if (this.yDb != null) {
      this.yDb.gLe();
    }
    Intent localIntent = new Intent();
    if (ecr()) {
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
    return 2131493781;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26303);
    setMMTitle(getString(2131755164));
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
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26284);
        ContactLabelUI.a(ContactLabelUI.this);
        AppMethodBeat.o(26284);
        return false;
      }
    }, null, t.b.OGU);
    this.yDa = ((MMTagPanelScrollView)findViewById(2131302995));
    this.yDa.setMaxLine(3);
    this.yDb = ((MMLabelPanel)findViewById(2131302994));
    this.yDc = ((TextView)findViewById(2131302997));
    this.yDd = findViewById(2131302993);
    this.yDe = findViewById(2131302992);
    this.yDe.setBackgroundDrawable(null);
    this.yDf = ((TextView)this.yDe.findViewById(16908310));
    this.yDf.setText(2131762127);
    this.yDg = ((MMLabelPanel)findViewById(2131302990));
    this.yDh = ((ListView)findViewById(2131302996));
    this.yDi = ((ScrollView)findViewById(2131302999));
    if (this.yDi != null) {
      this.yDi.setOnTouchListener(new View.OnTouchListener()
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
    this.yDb.OTh = true;
    this.yDb.Bz(true);
    this.yDb.setTagEditTextBG(2131235168);
    this.yDb.setCallBack(new MMTagPanel.a()
    {
      public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        AppMethodBeat.i(26292);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousBoolean)
        {
          ContactLabelUI.this.enableOptionMenu(false);
          ContactLabelUI.e(ContactLabelUI.this).setVisibility(0);
          ContactLabelUI.e(ContactLabelUI.this).setText(2131762128);
          ContactLabelUI.e(ContactLabelUI.this).setText(String.format(ContactLabelUI.this.getString(2131762128), new Object[] { Integer.valueOf(f.dp(36, "")), Integer.valueOf(paramAnonymousInt) }));
          AppMethodBeat.o(26292);
          return;
        }
        ContactLabelUI.this.enableOptionMenu(true);
        ContactLabelUI.e(ContactLabelUI.this).setVisibility(8);
        AppMethodBeat.o(26292);
      }
      
      public final void anb(String paramAnonymousString)
      {
        AppMethodBeat.i(26286);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).dn(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26286);
      }
      
      public final void anc(String paramAnonymousString)
      {
        AppMethodBeat.i(26287);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(26287);
      }
      
      public final void and(String paramAnonymousString)
      {
        AppMethodBeat.i(26288);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).dn(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26288);
      }
      
      public final void ane(String paramAnonymousString)
      {
        AppMethodBeat.i(26290);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26290);
      }
      
      public final void anf(String paramAnonymousString)
      {
        AppMethodBeat.i(26291);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
          AppMethodBeat.o(26291);
          return;
        }
        ContactLabelUI.b(ContactLabelUI.this).dm(paramAnonymousString, true);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).dn(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26291);
      }
      
      public final void cIk()
      {
        AppMethodBeat.i(26289);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
        AppMethodBeat.o(26289);
      }
    });
    this.yDg.Bz(false);
    this.yDg.setCallBack(new MMTagPanel.a()
    {
      public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void anb(String paramAnonymousString)
      {
        AppMethodBeat.i(26293);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        AppMethodBeat.o(26293);
      }
      
      public final void anc(String paramAnonymousString)
      {
        AppMethodBeat.i(26294);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).dm(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
        AppMethodBeat.o(26294);
      }
      
      public final void and(String paramAnonymousString) {}
      
      public final void ane(String paramAnonymousString) {}
      
      public final void anf(String paramAnonymousString) {}
      
      public final void cIk() {}
    });
    this.yDh.setAdapter(this.yDj);
    this.yDh.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26295);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (ContactLabelUI.f(ContactLabelUI.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(26295);
          return;
        }
        paramAnonymousAdapterView = ContactLabelUI.f(ContactLabelUI.this).getItem(paramAnonymousInt);
        if ((!Util.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.b(ContactLabelUI.this) != null))
        {
          ContactLabelUI.b(ContactLabelUI.this).gLc();
          ContactLabelUI.b(ContactLabelUI.this).dm(paramAnonymousAdapterView, true);
          ContactLabelUI.c(ContactLabelUI.this).dn(paramAnonymousAdapterView, true);
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
    if (ecr())
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131764867), "", getString(2131756913), getString(2131756916), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      Log.printErrStackTrace("MicroMsg.Label.ContactLabelUI", localException, "", new Object[0]);
      AppMethodBeat.o(26309);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26304);
    super.onCreate(paramBundle);
    this.yDk = getIntent().getStringExtra("label_id_list");
    this.yDl = getIntent().getStringArrayListExtra("label_str_list");
    this.goe = getIntent().getStringExtra("label_username");
    this.yDq = getIntent().getBooleanExtra("is_stranger", false);
    this.yDj = new b(this);
    initView();
    if ((!Util.isNullOrNil(this.yDk)) && (this.yDl != null) && (this.yDl.size() > 0)) {
      this.yDb.a(this.yDl, this.yDl);
    }
    if (this.yDq)
    {
      this.yDr = getIntent().getStringArrayListExtra("label_str_list");
      this.yDb.a(this.yDr, this.yDr);
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
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
    bg.azz().b(635, this);
    bg.azz().b(638, this);
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    bg.azz().a(635, this);
    bg.azz().a(638, this);
    MMHandlerThread.postToMainThread(new Runnable()
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
            bg.aVF();
            localObject2 = com.tencent.mm.model.c.aSO().aEZ(ContactLabelUI.i(ContactLabelUI.this));
            if (localObject2 != null) {
              localObject1 = ((cn)localObject2).field_contactLabels;
            }
            localObject3 = localObject1;
            if (Util.isNullOrNil((String)localObject1))
            {
              bg.aVF();
              as localas = com.tencent.mm.model.c.aSN().Kn(ContactLabelUI.i(ContactLabelUI.this));
              localObject3 = localas.field_encryptUsername;
              localObject2 = localObject1;
              if (!Util.isNullOrNil((String)localObject3))
              {
                bg.aVF();
                localObject3 = com.tencent.mm.model.c.aSO().aEZ((String)localObject3);
                localObject2 = localObject1;
                if (localObject3 != null) {
                  localObject2 = ((cn)localObject3).field_contactLabels;
                }
              }
              localObject3 = localObject2;
              if (Util.isNullOrNil((String)localObject2))
              {
                localObject1 = localas.field_username;
                bg.aVF();
                localObject1 = com.tencent.mm.model.c.aSO().aEZ((String)localObject1);
                localObject3 = localObject2;
                if (localObject1 != null) {
                  localObject3 = ((cn)localObject1).field_contactLabels;
                }
              }
            }
            localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCI((String)localObject3);
            ContactLabelUI.b(ContactLabelUI.this).a((Collection)localObject1, (List)localObject1);
            ContactLabelUI.a(ContactLabelUI.this, (ArrayList)localObject1);
          }
        }
        else if (ContactLabelUI.c(ContactLabelUI.this) != null)
        {
          ContactLabelUI.b(ContactLabelUI.this, e.ecf().gBU());
          if ((ContactLabelUI.j(ContactLabelUI.this) == null) || (ContactLabelUI.j(ContactLabelUI.this).size() <= 0)) {
            break label415;
          }
          ContactLabelUI.d(ContactLabelUI.this);
          ContactLabelUI.c(ContactLabelUI.this).a((Collection)localObject1, ContactLabelUI.j(ContactLabelUI.this));
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
        for (;;)
        {
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.yDu);
          AppMethodBeat.o(26298);
          return;
          bg.aVF();
          localObject3 = com.tencent.mm.model.c.aSN().Kn(ContactLabelUI.i(ContactLabelUI.this));
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          localObject3 = ((com.tencent.mm.g.c.ax)localObject3).field_contactLabelIds;
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject3)) {
            break;
          }
          localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCJ((String)localObject3);
          break;
          label415:
          if (ContactLabelUI.k(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.CyF.a(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
            ContactLabelUI.l(ContactLabelUI.this);
          }
        }
      }
    });
    super.onResume();
    AppMethodBeat.o(26305);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(26308);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramq.getType())
    {
    case 636: 
    case 637: 
    default: 
      Log.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
      AppMethodBeat.o(26308);
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ecp();
        AppMethodBeat.o(26308);
        return;
      }
      eck();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      ecq();
      AppMethodBeat.o(26308);
      return;
    }
    eck();
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
      yDu = new a("Normal", 0);
      yDv = new a("Search", 1);
      yDw = new a("OverMaxCount", 2);
      yDx = new a("Invaildnput", 3);
      yDy = new a[] { yDu, yDv, yDw, yDx };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */