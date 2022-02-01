package com.tencent.mm.plugin.label.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.e;
import com.tencent.mm.plugin.label.c;
import com.tencent.mm.plugin.label.d;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel.a;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.fve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.m.a;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.j.b;
import com.tencent.mm.ui.y.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  private boolean JVu;
  private ArrayList<String> JWA;
  private a JWB;
  private boolean JWC;
  private ArrayList<String> JWD;
  private HashSet<String> JWE;
  private HashSet<String> JWF;
  private HashSet<String> JWG;
  private HashSet<String> JWH;
  private boolean JWI;
  private ObjectAnimator JWJ;
  private m JWf;
  private boolean JWg;
  private boolean JWh;
  private MMTagPanelScrollView JWi;
  private MMLabelPanel JWj;
  private TextView JWk;
  private View JWl;
  private View JWm;
  private TextView JWn;
  private LinearLayout JWo;
  private MMLabelPanel JWp;
  private ListView JWq;
  private ScrollView JWr;
  private b JWs;
  private String JWt;
  private ArrayList<String> JWu;
  private HashSet<String> JWv;
  private HashSet<String> JWw;
  private ArrayList<String> JWx;
  private HashSet<String> JWy;
  private ArrayList<String> JWz;
  private i lKz;
  private String luk;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.JWg = false;
    this.JWh = false;
    this.JWv = new HashSet();
    this.JWw = new HashSet();
    this.JWx = new ArrayList();
    this.JWy = new HashSet();
    this.JWz = new ArrayList();
    this.JWA = new ArrayList();
    this.JWB = a.JWM;
    this.JWC = false;
    this.JWE = new HashSet();
    this.JWF = new HashSet();
    this.JWG = new HashSet();
    this.JWH = new HashSet();
    this.JVu = true;
    this.JWI = false;
    this.JWJ = null;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.JWB = parama;
    switch (9.JWL[this.JWB.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.JWq.setVisibility(8);
      this.JWl.setVisibility(0);
      this.JWr.setVisibility(0);
      this.JWk.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.JWr.setVisibility(8);
      this.JWq.setVisibility(0);
      this.JWl.setVisibility(8);
      this.JWk.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.JWq.setVisibility(8);
      this.JWr.setVisibility(8);
      this.JWl.setVisibility(8);
      this.JWk.setVisibility(0);
      this.JWk.setText(R.l.gMr);
      AppMethodBeat.o(26310);
      return;
      this.JWq.setVisibility(8);
      this.JWr.setVisibility(8);
      this.JWl.setVisibility(8);
      this.JWk.setVisibility(0);
      this.JWk.setText(R.l.gMr);
    }
  }
  
  private static void a(HashSet<String> paramHashSet, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(268720);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramArrayList.contains(str)) {
        localArrayList.add(str);
      }
    }
    paramHashSet.removeAll(localArrayList);
    AppMethodBeat.o(268720);
  }
  
  private void cl(String paramString, boolean paramBoolean)
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
    aw localaw = d.fTa().bxl(paramString);
    if (paramBoolean) {
      if ((this.JWz == null) || (!this.JWz.contains(paramString)) || (localaw == null)) {
        this.JWw.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.JWx != null) && (!this.JWx.contains(paramString))) {
        this.JWx.add(paramString);
      }
      if ((this.JWv != null) && (this.JWv.contains(paramString))) {
        this.JWv.remove(paramString);
      }
      if (fTx()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.JWz == null) || (!this.JWz.contains(paramString)) || ((localaw != null) && (localaw.field_isTemporary))) {
        this.JWw.add(paramString);
      }
    }
  }
  
  private void fTg()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    aoP(getString(R.l.gpI));
    AppMethodBeat.o(26314);
  }
  
  private void fTu()
  {
    AppMethodBeat.i(268699);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
    if (this.JWj != null)
    {
      localObject = this.JWj.getEditText();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).trim();
        this.JWj.cm((String)localObject, true);
        this.JWj.jmG();
        cl((String)localObject, this.JWC);
      }
    }
    Object localObject = new ArrayList();
    if (this.JWw != null)
    {
      Iterator localIterator = this.JWw.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!this.JWy.contains(str)) {
          ((ArrayList)localObject).add(str);
        }
      }
    }
    if (!((ArrayList)localObject).isEmpty())
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
      localObject = new com.tencent.mm.plugin.label.b.a((List)localObject);
      bh.aZW().a((p)localObject, 0);
      if ((this.JWz == null) || (this.JWw.isEmpty()))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(268699);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(268699);
      return;
    }
    if ((this.JWw != null) && (!this.JWw.isEmpty()))
    {
      if ((this.JWz != null) && (!this.JWw.isEmpty())) {
        break label329;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    }
    for (;;)
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
      fTv();
      AppMethodBeat.o(268699);
      return;
      label329:
      com.tencent.mm.plugin.report.service.h.OAn.b(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
  }
  
  private void fTv()
  {
    AppMethodBeat.i(26312);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.JWj != null)
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.JWj.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = c.iF(d.fTa().bY((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new fve();
      ((fve)localObject3).ZqN = ((String)localObject1);
      ((fve)localObject3).UserName = this.luk;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new e((LinkedList)localObject2);
      bh.aZW().a((p)localObject1, 0);
      if (this.JWw == null) {
        break label341;
      }
    }
    label341:
    for (int i = this.JWw.size();; i = 0)
    {
      if (this.JWu != null) {}
      for (int j = this.JWu.size();; j = 0)
      {
        if (this.JWv != null) {}
        for (int k = this.JWv.size();; k = 0)
        {
          j = k + this.JWj.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            Log.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.OAn.b(11220, new Object[] { z.bAM(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void fTw()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.JWw.clear();
    this.JWv.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean fTx()
  {
    AppMethodBeat.i(26315);
    if (this.JWj != null)
    {
      if ((this.JWu != null) && (this.JWu.size() > 0))
      {
        if ((this.JWj.getTagList() == null) && (this.JWj.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.JWj.getTagList();
        Collections.sort(this.JWu);
        Collections.sort(localArrayList);
        if (!this.JWu.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.JWj.getTagList() != null) && (this.JWj.getTagList().size() > 0))
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
    if (this.JWj != null) {
      this.JWj.jmH();
    }
    Intent localIntent = new Intent();
    if (fTx()) {
      localIntent.putExtra("hasLableChange", true);
    }
    for (;;)
    {
      localIntent.putExtra("result_label_id_list", this.JWj.getSelectTagList());
      Object localObject2 = this.JWj.getSelectTagList();
      localObject1 = this.JWp.getSelectTagList();
      localArrayList = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (!((ArrayList)localObject1).contains(str)) {
          localArrayList.add(str);
        }
      }
      localIntent.putExtra("hasLableChange", false);
    }
    if (getIntent().getStringArrayExtra("contact_search_label_new_list") != null)
    {
      localObject1 = getIntent().getStringArrayExtra("contact_search_label_new_list");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localObject1[i]);
        i += 1;
      }
    }
    localIntent.putExtra("contact_search_label_new_list", localArrayList);
    ArrayList localArrayList = d.fTa().iZN();
    Object localObject1 = new ArrayList();
    a(this.JWF, localArrayList);
    ((ArrayList)localObject1).addAll(this.JWF);
    localIntent.putExtra("contact_search_label_add_list", (Serializable)localObject1);
    localObject1 = new ArrayList();
    a(this.JWH, localArrayList);
    ((ArrayList)localObject1).addAll(this.JWH);
    localIntent.putExtra("contact_select_label_add_list", (Serializable)localObject1);
    localObject1 = new ArrayList();
    a(this.JWG, localArrayList);
    ((ArrayList)localObject1).addAll(this.JWG);
    localIntent.putExtra("contact_select_label_new_list", (Serializable)localObject1);
    setResult(-1, localIntent);
    super.finish();
    AppMethodBeat.o(26316);
  }
  
  public int getLayoutId()
  {
    return R.i.giw;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26303);
    setMMTitle(getString(R.l.gpL));
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
    if (this.JWg) {}
    Object localObject1;
    int j;
    Object localObject2;
    for (int i = R.l.app_ok;; i = R.l.app_save)
    {
      addTextOptionMenu(0, getString(i), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          int j = 1;
          AppMethodBeat.i(26284);
          int i;
          if (ContactLabelUI.a(ContactLabelUI.this))
          {
            paramAnonymousMenuItem = ContactLabelUI.b(ContactLabelUI.this).iterator();
            i = 0;
            if (paramAnonymousMenuItem.hasNext())
            {
              String str = (String)paramAnonymousMenuItem.next();
              if (ContactLabelUI.c(ContactLabelUI.this).contains(str)) {
                break label121;
              }
              i = 1;
            }
          }
          label121:
          for (;;)
          {
            break;
            if (!Util.isNullOrNil(ContactLabelUI.d(ContactLabelUI.this).getEdittextText())) {
              i = j;
            }
            for (;;)
            {
              if (i == 0) {
                ContactLabelUI.this.finish();
              }
              for (;;)
              {
                AppMethodBeat.o(26284);
                return false;
                ContactLabelUI.e(ContactLabelUI.this);
              }
            }
          }
        }
      }, null, y.b.adEJ);
      this.JWi = ((MMTagPanelScrollView)findViewById(R.h.fMk));
      this.JWi.setMaxLine(3);
      this.JWj = ((MMLabelPanel)findViewById(R.h.fMj));
      this.JWk = ((TextView)findViewById(R.h.fMm));
      this.JWi.setBackgroundColor(getResources().getColor(R.e.white));
      this.JWl = findViewById(R.h.fMi);
      this.JWm = findViewById(R.h.fMh);
      this.JWm.setBackgroundDrawable(null);
      this.JWn = ((TextView)this.JWm.findViewById(16908310));
      this.JWn.setText(R.l.gMt);
      this.JWo = ((LinearLayout)this.JWm.findViewById(R.h.fGy));
      this.JWo.setVisibility(0);
      this.JWo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268678);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactLabelUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent(ContactLabelUI.this, ContactLabelManagerUI.class);
          paramAnonymousView.putExtra("last_page_source_type", 1);
          paramAnonymousView.putExtra("key_label_click_source", 1);
          paramAnonymousView.putExtra("label_edit_mode", true);
          ContactLabelUI.this.startActivityForResult(paramAnonymousView, 100);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268678);
        }
      });
      this.JWp = ((MMLabelPanel)findViewById(R.h.fMf));
      this.JWp.setNeedNewLebal(true);
      localObject1 = this.JWp;
      i = com.tencent.mm.cd.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 12.0F);
      j = com.tencent.mm.cd.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 5.0F);
      int k = com.tencent.mm.cd.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 12.0F);
      int m = com.tencent.mm.cd.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 6.0F);
      if (((MMTagPanel)localObject1).adTR != null) {
        ((MMTagPanel)localObject1).adTR.setPadding(i, j, k, m);
      }
      this.JWp.setClickNewLebalCallBack(new MMLabelPanel.a()
      {
        public final void fTy()
        {
          AppMethodBeat.i(268695);
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.this.getResources().getString(R.l.gMs), ContactLabelUI.this.getResources().getString(R.l.gMq));
          AppMethodBeat.o(268695);
        }
      });
      this.JWq = ((ListView)findViewById(R.h.fMl));
      this.JWr = ((ScrollView)findViewById(R.h.fMn));
      if (this.JWr != null) {
        this.JWr.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(268670);
            if (paramAnonymousMotionEvent.getAction() == 2) {
              ContactLabelUI.this.hideVKB();
            }
            AppMethodBeat.o(268670);
            return false;
          }
        });
      }
      this.JWj.adTH = true;
      this.JWj.LD(true);
      this.JWj.setEdittextMaxSize(36);
      this.JWj.setCallBack(new MMTagPanel.a()
      {
        public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(268716);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousBoolean)
          {
            ContactLabelUI.this.enableOptionMenu(false);
            ContactLabelUI.m(ContactLabelUI.this).setVisibility(8);
            AppMethodBeat.o(268716);
            return;
          }
          ContactLabelUI.this.enableOptionMenu(true);
          ContactLabelUI.m(ContactLabelUI.this).setVisibility(8);
          AppMethodBeat.o(268716);
        }
        
        public final void aoT(String paramAnonymousString)
        {
          AppMethodBeat.i(268686);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
          ContactLabelUI.d(ContactLabelUI.this).aue(paramAnonymousString);
          if (ContactLabelUI.h(ContactLabelUI.this) != null) {
            ContactLabelUI.h(ContactLabelUI.this).eg(paramAnonymousString, false);
          }
          ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
          if (ContactLabelUI.k(ContactLabelUI.this).contains(paramAnonymousString)) {
            ContactLabelUI.k(ContactLabelUI.this).remove(paramAnonymousString);
          }
          AppMethodBeat.o(268686);
        }
        
        public final void aoU(String paramAnonymousString)
        {
          AppMethodBeat.i(268692);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(268692);
        }
        
        public final void aoV(String paramAnonymousString)
        {
          AppMethodBeat.i(268697);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
          if (ContactLabelUI.h(ContactLabelUI.this) != null) {
            ContactLabelUI.h(ContactLabelUI.this).eg(paramAnonymousString, false);
          }
          ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
          AppMethodBeat.o(268697);
        }
        
        public final void aoW(String paramAnonymousString)
        {
          AppMethodBeat.i(268705);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
          ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
          AppMethodBeat.o(268705);
        }
        
        public final void aoX(String paramAnonymousString)
        {
          AppMethodBeat.i(268712);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
          if (Util.isNullOrNil(paramAnonymousString))
          {
            Log.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
            AppMethodBeat.o(268712);
            return;
          }
          ContactLabelUI.d(ContactLabelUI.this).cm(paramAnonymousString, true);
          if (ContactLabelUI.h(ContactLabelUI.this) != null) {
            ContactLabelUI.h(ContactLabelUI.this).eg(paramAnonymousString, true);
          }
          ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.l(ContactLabelUI.this));
          AppMethodBeat.o(268712);
        }
        
        public final void dCx()
        {
          AppMethodBeat.i(268702);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
          AppMethodBeat.o(268702);
        }
      });
      if (getIntent().getStringArrayExtra("contact_search_label_add_list") == null) {
        break;
      }
      localObject1 = getIntent().getStringArrayExtra("contact_search_label_add_list");
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.JWF.add(localObject2);
        i += 1;
      }
    }
    if (getIntent().getStringArrayExtra("contact_select_label_add_list") != null)
    {
      localObject1 = getIntent().getStringArrayExtra("contact_select_label_add_list");
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.JWH.add(localObject2);
        i += 1;
      }
    }
    if (getIntent().getStringArrayExtra("contact_select_label_new_list") != null)
    {
      localObject1 = getIntent().getStringArrayExtra("contact_select_label_new_list");
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.JWG.add(localObject2);
        i += 1;
      }
    }
    this.JWp.LD(false);
    this.JWp.setNeedNewLebal(true);
    this.JWp.setCallBack(new MMTagPanel.a()
    {
      public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void aoT(String paramAnonymousString)
      {
        AppMethodBeat.i(268698);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.d(ContactLabelUI.this) != null) {
          ContactLabelUI.d(ContactLabelUI.this).aue(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        if (ContactLabelUI.n(ContactLabelUI.this)) {
          ContactLabelUI.this.enableOptionMenu(true);
        }
        if (ContactLabelUI.o(ContactLabelUI.this).contains(paramAnonymousString)) {
          ContactLabelUI.o(ContactLabelUI.this).remove(paramAnonymousString);
        }
        AppMethodBeat.o(268698);
      }
      
      public final void aoU(String paramAnonymousString)
      {
        AppMethodBeat.i(268703);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.d(ContactLabelUI.this) != null) {
          ContactLabelUI.d(ContactLabelUI.this).cm(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.l(ContactLabelUI.this));
        if (ContactLabelUI.n(ContactLabelUI.this)) {
          ContactLabelUI.this.enableOptionMenu(true);
        }
        if (!ContactLabelUI.o(ContactLabelUI.this).contains(paramAnonymousString)) {
          ContactLabelUI.o(ContactLabelUI.this).add(paramAnonymousString);
        }
        AppMethodBeat.o(268703);
      }
      
      public final void aoV(String paramAnonymousString) {}
      
      public final void aoW(String paramAnonymousString) {}
      
      public final void aoX(String paramAnonymousString) {}
      
      public final void dCx() {}
    });
    this.JWq.setAdapter(this.JWs);
    this.JWq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(268709);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactLabelUI$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (ContactLabelUI.p(ContactLabelUI.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(268709);
          return;
        }
        paramAnonymousAdapterView = ContactLabelUI.p(ContactLabelUI.this).getItem(paramAnonymousInt);
        if ((!Util.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.d(ContactLabelUI.this) != null))
        {
          ContactLabelUI.d(ContactLabelUI.this).jmG();
          ContactLabelUI.d(ContactLabelUI.this).cm(paramAnonymousAdapterView, true);
          ContactLabelUI.h(ContactLabelUI.this).eg(paramAnonymousAdapterView, true);
          ContactLabelUI.k(ContactLabelUI.this).add(paramAnonymousAdapterView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(268709);
      }
    });
    enableOptionMenu(false);
    AppMethodBeat.o(26303);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26309);
    if (fTx())
    {
      k.b(this, getString(R.l.save_label_msg), "", getString(R.l.gvW), getString(R.l.gvX), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(268691);
          ContactLabelUI.e(ContactLabelUI.this);
          AppMethodBeat.o(268691);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(268714);
          ContactLabelUI.q(ContactLabelUI.this);
          AppMethodBeat.o(268714);
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
    this.JWt = getIntent().getStringExtra("label_id_list");
    this.JWu = getIntent().getStringArrayListExtra("label_str_list");
    this.luk = getIntent().getStringExtra("label_username");
    this.JWC = getIntent().getBooleanExtra("is_stranger", false);
    this.JWg = getIntent().getBooleanExtra("save_label_to_contact_on_prepage", false);
    this.JWs = new b(this);
    initView();
    if ((!Util.isNullOrNil(this.JWt)) && (this.JWu != null) && (this.JWu.size() > 0)) {
      this.JWj.a(this.JWu, this.JWu);
    }
    if (this.JWC)
    {
      this.JWD = getIntent().getStringArrayListExtra("label_str_list");
      this.JWj.a(this.JWD, this.JWD);
    }
    this.JWA = d.fTa().iZN();
    com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(26304);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26307);
    super.onDestroy();
    AppMethodBeat.o(26307);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(268879);
    Log.i("MicroMsg.Label.ContactLabelUI", "onKeyboardHeightChanged, height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.JWJ != null) && (this.JWJ.isRunning())) {
      this.JWJ.cancel();
    }
    if ((this.JWf == null) || (this.JWf.rootView == null) || (this.JWf.rootView.getParent() == null))
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "onKeyboardHeightChanged, mAddLebalTipsDialog: isNull");
      AppMethodBeat.o(268879);
      return;
    }
    View localView = null;
    if ((this.JWf.rootView.getParent() instanceof View)) {
      localView = (View)this.JWf.rootView.getParent();
    }
    if (localView == null)
    {
      AppMethodBeat.o(268879);
      return;
    }
    if (paramInt > 0) {
      if (localView.getTranslationY() != 0.0F) {
        localView.setTranslationY(0.0F);
      }
    }
    for (this.JWJ = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, -paramInt });; this.JWJ = ObjectAnimator.ofFloat(localView, "translationY", new float[] { localView.getTranslationY(), 0.0F }))
    {
      this.JWJ.setDuration(200L);
      this.JWJ.setInterpolator(new androidx.g.a.a.b());
      this.JWJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(268671);
          Log.i("MicroMsg.Label.ContactLabelUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(268671);
        }
      });
      this.JWJ.start();
      AppMethodBeat.o(268879);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26306);
    bh.aZW().b(635, this);
    bh.aZW().b(638, this);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    bh.aZW().a(635, this);
    bh.aZW().a(638, this);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268723);
        ContactLabelUI.a(ContactLabelUI.this, d.fTa().iZN());
        if (!ContactLabelUI.r(ContactLabelUI.this))
        {
          ContactLabelUI.t(ContactLabelUI.this).addAll(ContactLabelUI.s(ContactLabelUI.this));
          ContactLabelUI.u(ContactLabelUI.this);
          ContactLabelUI.d(ContactLabelUI.this).a(ContactLabelUI.t(ContactLabelUI.this), ContactLabelUI.t(ContactLabelUI.this));
          if (ContactLabelUI.h(ContactLabelUI.this) != null)
          {
            if ((ContactLabelUI.c(ContactLabelUI.this) == null) || (ContactLabelUI.c(ContactLabelUI.this).size() <= 0)) {
              break label739;
            }
            ContactLabelUI.l(ContactLabelUI.this);
            ContactLabelUI.h(ContactLabelUI.this).a(ContactLabelUI.t(ContactLabelUI.this), ContactLabelUI.c(ContactLabelUI.this));
            if (ContactLabelUI.y(ContactLabelUI.this))
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
              ContactLabelUI.z(ContactLabelUI.this);
            }
          }
        }
        for (;;)
        {
          ContactLabelUI.b(ContactLabelUI.this, ContactLabelUI.s(ContactLabelUI.this));
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.JWM);
          AppMethodBeat.o(268723);
          return;
          HashSet localHashSet1 = new HashSet();
          ArrayList localArrayList1 = new ArrayList();
          HashSet localHashSet2 = new HashSet();
          ArrayList localArrayList2 = new ArrayList();
          Object localObject1 = new ArrayList();
          Object localObject2 = ContactLabelUI.v(ContactLabelUI.this).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            if (!ContactLabelUI.c(ContactLabelUI.this).contains(localObject3)) {
              localArrayList2.add(localObject3);
            }
          }
          localObject2 = ContactLabelUI.w(ContactLabelUI.this);
          String str;
          if ((ContactLabelUI.s(ContactLabelUI.this) != null) && (localObject2 != null))
          {
            localObject3 = ContactLabelUI.s(ContactLabelUI.this).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              str = (String)((Iterator)localObject3).next();
              if (!((List)localObject2).contains(str)) {
                ((ArrayList)localObject1).add(str);
              }
            }
            ContactLabelUI.s(ContactLabelUI.this).clear();
            ContactLabelUI.s(ContactLabelUI.this).addAll((Collection)localObject2);
          }
          Object localObject3 = ContactLabelUI.d(ContactLabelUI.this).getSelectTagList().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            if (!localArrayList2.contains(str))
            {
              if ((!localArrayList1.contains(str)) && (!((ArrayList)localObject1).contains(str))) {
                localArrayList1.add(str);
              }
              if (ContactLabelUI.b(ContactLabelUI.this).contains(str)) {
                localHashSet1.add(str);
              }
            }
          }
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (!localArrayList1.contains(localObject2)) {
              localArrayList1.add(localObject2);
            }
          }
          localObject1 = ContactLabelUI.c(ContactLabelUI.this).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if ((!localArrayList2.contains(localObject2)) && (ContactLabelUI.x(ContactLabelUI.this).contains(localObject2))) {
              localHashSet2.add(localObject2);
            }
          }
          ContactLabelUI.x(ContactLabelUI.this).clear();
          ContactLabelUI.x(ContactLabelUI.this).addAll(localHashSet2);
          ContactLabelUI.b(ContactLabelUI.this).clear();
          ContactLabelUI.t(ContactLabelUI.this).clear();
          ContactLabelUI.b(ContactLabelUI.this).addAll(localHashSet1);
          ContactLabelUI.t(ContactLabelUI.this).addAll(localArrayList1);
          ContactLabelUI.v(ContactLabelUI.this).clear();
          ContactLabelUI.v(ContactLabelUI.this).addAll(ContactLabelUI.c(ContactLabelUI.this));
          break;
          label739:
          ContactLabelUI.h(ContactLabelUI.this).a(ContactLabelUI.t(ContactLabelUI.this), ContactLabelUI.c(ContactLabelUI.this));
          if (ContactLabelUI.y(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
            ContactLabelUI.z(ContactLabelUI.this);
          }
        }
      }
    });
    if (this.lKz != null) {
      this.lKz.start();
    }
    super.onResume();
    AppMethodBeat.o(26305);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(26308);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramp.getType())
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
        if ((this.JWh) && ((paramp instanceof com.tencent.mm.plugin.label.b.a)))
        {
          this.JWh = false;
          hideLoading();
          paramString = ((com.tencent.mm.plugin.label.b.a)paramp).fTc().YFs;
          if ((paramString != null) && (paramString.size() > 0))
          {
            paramInt1 = 0;
            if (paramInt1 < paramString.size())
            {
              if (paramString.get(paramInt1) == null) {
                Log.d("MicroMsg.Label.ContactLabelUI", "tag1 is null.");
              }
              for (;;)
              {
                paramInt1 += 1;
                break;
                paramp = ((dgk)paramString.get(paramInt1)).aaLA;
                Log.d("MicroMsg.Label.ContactLabelUI", "tag:%s", new Object[] { String.valueOf(paramp) });
                if (Util.isNullOrNil(paramp))
                {
                  Log.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                  AppMethodBeat.o(26308);
                  return;
                }
                this.JWj.fL(paramp, this.JWj.getChildCount() - 1);
                this.JWp.fL(paramp, this.JWp.getChildCount() - 1);
                cl(paramp, this.JWC);
                this.JWG.add(paramp);
                this.JWy.add(paramp);
                this.JWA.add(paramp);
              }
            }
          }
          AppMethodBeat.o(26308);
          return;
        }
        if (!this.JWg)
        {
          Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.asd");
          fTv();
          AppMethodBeat.o(26308);
          return;
        }
        fTw();
        AppMethodBeat.o(26308);
        return;
      }
      fTg();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      fTw();
      AppMethodBeat.o(26308);
      return;
    }
    fTg();
    AppMethodBeat.o(26308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(268892);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(268892);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(26301);
      JWM = new a("Normal", 0);
      JWN = new a("Search", 1);
      JWO = new a("OverMaxCount", 2);
      JWP = new a("Invaildnput", 3);
      JWQ = new a[] { JWM, JWN, JWO, JWP };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */