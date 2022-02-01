package com.tencent.mm.plugin.label.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.c;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel.a;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.g.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  private boolean EdT;
  private View EeA;
  private View EeB;
  private TextView EeC;
  private MMLabelPanel EeD;
  private ListView EeE;
  private ScrollView EeF;
  private b EeG;
  private String EeH;
  private ArrayList<String> EeI;
  private HashSet<String> EeJ;
  private HashSet<String> EeK;
  private HashSet<String> EeL;
  private ArrayList<String> EeM;
  private a EeN;
  private boolean EeO;
  private ArrayList<String> EeP;
  private HashSet<String> EeQ;
  private HashSet<String> EeR;
  private HashSet<String> EeS;
  private HashSet<String> EeT;
  private ObjectAnimator EeU;
  private k Eeu;
  private boolean Eev;
  private boolean Eew;
  private MMTagPanelScrollView Eex;
  private MMLabelPanel Eey;
  private TextView Eez;
  private String iSn;
  private com.tencent.mm.ui.tools.i jij;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(26302);
    this.Eev = false;
    this.Eew = false;
    this.EeJ = new HashSet();
    this.EeK = new HashSet();
    this.EeL = new HashSet();
    this.EeM = new ArrayList();
    this.EeN = a.EeX;
    this.EeO = false;
    this.EeQ = new HashSet();
    this.EeR = new HashSet();
    this.EeS = new HashSet();
    this.EeT = new HashSet();
    this.EdT = true;
    this.EeU = null;
    AppMethodBeat.o(26302);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(26310);
    this.EeN = parama;
    switch (8.EeW[this.EeN.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26310);
      return;
      this.EeE.setVisibility(8);
      this.EeA.setVisibility(0);
      this.EeF.setVisibility(0);
      this.Eez.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.EeF.setVisibility(8);
      this.EeE.setVisibility(0);
      this.EeA.setVisibility(8);
      this.Eez.setVisibility(8);
      AppMethodBeat.o(26310);
      return;
      this.EeE.setVisibility(8);
      this.EeF.setVisibility(8);
      this.EeA.setVisibility(8);
      this.Eez.setVisibility(0);
      this.Eez.setText(R.l.eKE);
      AppMethodBeat.o(26310);
      return;
      this.EeE.setVisibility(8);
      this.EeF.setVisibility(8);
      this.EeA.setVisibility(8);
      this.Eez.setVisibility(0);
      this.Eez.setText(R.l.eKE);
    }
  }
  
  private void bQ(String paramString, boolean paramBoolean)
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
    au localau = e.eLd().bvY(paramString);
    if (paramBoolean) {
      if ((this.EeM == null) || (!this.EeM.contains(paramString)) || (localau == null)) {
        this.EeK.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.EeJ != null) && (this.EeJ.contains(paramString))) {
        this.EeJ.remove(paramString);
      }
      if (eLq()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(26311);
      return;
      if ((this.EeM == null) || (!this.EeM.contains(paramString)) || ((localau != null) && (localau.field_isTemporary))) {
        this.EeK.add(paramString);
      }
    }
  }
  
  private void eLi()
  {
    AppMethodBeat.i(26314);
    hideLoading();
    auQ(getString(R.l.emH));
    AppMethodBeat.o(26314);
  }
  
  private void eLn()
  {
    AppMethodBeat.i(278327);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
    if (this.Eey != null)
    {
      localObject = this.Eey.getEditText();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).trim();
        this.Eey.bR((String)localObject, true);
        this.Eey.hKa();
        bQ((String)localObject, this.EeO);
      }
    }
    Object localObject = new ArrayList();
    if (this.EeK != null)
    {
      Iterator localIterator = this.EeK.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!this.EeL.contains(str)) {
          ((ArrayList)localObject).add(str);
        }
      }
    }
    if (!((ArrayList)localObject).isEmpty())
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
      localObject = new com.tencent.mm.plugin.label.b.a((List)localObject);
      bh.aGY().a((q)localObject, 0);
      if ((this.EeM == null) || (this.EeK.isEmpty()))
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
        AppMethodBeat.o(278327);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      AppMethodBeat.o(278327);
      return;
    }
    if ((this.EeK != null) && (!this.EeK.isEmpty()))
    {
      if ((this.EeM != null) && (!this.EeK.isEmpty())) {
        break label329;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    }
    for (;;)
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
      eLo();
      AppMethodBeat.o(278327);
      return;
      label329:
      com.tencent.mm.plugin.report.service.h.IzE.a(11347, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
  }
  
  private void eLo()
  {
    AppMethodBeat.i(26312);
    Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.Eey != null)
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.Eey.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = c.fI(e.eLd().bx((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new ezd();
      ((ezd)localObject3).SrJ = ((String)localObject1);
      ((ezd)localObject3).UserName = this.iSn;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      bh.aGY().a((q)localObject1, 0);
      if (this.EeK == null) {
        break label341;
      }
    }
    label341:
    for (int i = this.EeK.size();; i = 0)
    {
      if (this.EeI != null) {}
      for (int j = this.EeI.size();; j = 0)
      {
        if (this.EeJ != null) {}
        for (int k = this.EeJ.size();; k = 0)
        {
          j = k + this.Eey.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            Log.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.IzE.a(11220, new Object[] { z.bcZ(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(26312);
          return;
        }
      }
    }
  }
  
  private void eLp()
  {
    AppMethodBeat.i(26313);
    hideLoading();
    this.EeK.clear();
    this.EeJ.clear();
    finish();
    AppMethodBeat.o(26313);
  }
  
  private boolean eLq()
  {
    AppMethodBeat.i(26315);
    if (this.Eey != null)
    {
      if ((this.EeI != null) && (this.EeI.size() > 0))
      {
        if ((this.Eey.getTagList() == null) && (this.Eey.getTagList().size() <= 0))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        ArrayList localArrayList = this.Eey.getTagList();
        Collections.sort(this.EeI);
        Collections.sort(localArrayList);
        if (!this.EeI.equals(localArrayList))
        {
          AppMethodBeat.o(26315);
          return true;
        }
        AppMethodBeat.o(26315);
        return false;
      }
      if ((this.Eey.getTagList() != null) && (this.Eey.getTagList().size() > 0))
      {
        AppMethodBeat.o(26315);
        return true;
      }
    }
    AppMethodBeat.o(26315);
    return false;
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(278322);
    Log.i("MicroMsg.Label.ContactLabelUI", "onKeyboardHeightChanged, height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.EeU != null) && (this.EeU.isRunning())) {
      this.EeU.cancel();
    }
    if ((this.Eeu == null) || (this.Eeu.oFW == null) || (this.Eeu.oFW.getParent() == null))
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "onKeyboardHeightChanged, mAddLebalTipsDialog: isNull");
      AppMethodBeat.o(278322);
      return;
    }
    View localView = null;
    if ((this.Eeu.oFW.getParent() instanceof View)) {
      localView = (View)this.Eeu.oFW.getParent();
    }
    if (localView == null)
    {
      AppMethodBeat.o(278322);
      return;
    }
    if (paramInt > 0) {
      if (localView.getTranslationY() != 0.0F) {
        localView.setTranslationY(0.0F);
      }
    }
    for (this.EeU = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, -paramInt });; this.EeU = ObjectAnimator.ofFloat(localView, "translationY", new float[] { localView.getTranslationY(), 0.0F }))
    {
      this.EeU.setDuration(200L);
      this.EeU.setInterpolator(new androidx.f.a.a.b());
      this.EeU.addUpdateListener(new ContactLabelUI.15(this));
      this.EeU.start();
      AppMethodBeat.o(278322);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(26316);
    if (this.Eey != null) {
      this.Eey.hKb();
    }
    Intent localIntent = new Intent();
    if (eLq()) {
      localIntent.putExtra("hasLableChange", true);
    }
    Object localObject1;
    for (;;)
    {
      localIntent.putExtra("result_label_id_list", this.Eey.getSelectTagList());
      Object localObject2 = this.Eey.getSelectTagList();
      localObject1 = this.EeD.getSelectTagList();
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
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.EeR);
    localIntent.putExtra("contact_search_label_add_list", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.addAll(this.EeT);
    localIntent.putExtra("contact_select_label_add_list", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.addAll(this.EeS);
    localIntent.putExtra("contact_select_label_new_list", localArrayList);
    setResult(-1, localIntent);
    super.finish();
    AppMethodBeat.o(26316);
  }
  
  public int getLayoutId()
  {
    return R.i.efy;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26303);
    setMMTitle(getString(R.l.emK));
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
    if (this.Eev) {}
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
      }, null, w.b.Wao);
      this.Eex = ((MMTagPanelScrollView)findViewById(R.h.dKL));
      this.Eex.setMaxLine(3);
      this.Eey = ((MMLabelPanel)findViewById(R.h.dKK));
      this.Eez = ((TextView)findViewById(R.h.dKN));
      this.Eex.setBackgroundColor(getResources().getColor(R.e.white));
      this.EeA = findViewById(R.h.dKJ);
      this.EeB = findViewById(R.h.dKI);
      this.EeB.setBackgroundDrawable(null);
      this.EeC = ((TextView)this.EeB.findViewById(16908310));
      this.EeC.setText(R.l.eKG);
      this.EeD = ((MMLabelPanel)findViewById(R.h.dKG));
      this.EeD.setNeedNewLebal(true);
      localObject1 = this.EeD;
      i = com.tencent.mm.ci.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 12.0F);
      j = com.tencent.mm.ci.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 5.0F);
      int k = com.tencent.mm.ci.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 12.0F);
      int m = com.tencent.mm.ci.a.fromDPToPix(((MMLabelPanel)localObject1).mContext, 6.0F);
      if (((MMTagPanel)localObject1).WmE != null) {
        ((MMTagPanel)localObject1).WmE.setPadding(i, j, k, m);
      }
      this.EeD.setClickNewLebalCallBack(new MMLabelPanel.a()
      {
        public final void eLr()
        {
          AppMethodBeat.i(282519);
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.this.getResources().getString(R.l.eKF), ContactLabelUI.this.getResources().getString(R.l.eKD));
          AppMethodBeat.o(282519);
        }
      });
      this.EeE = ((ListView)findViewById(R.h.dKM));
      this.EeF = ((ScrollView)findViewById(R.h.dKO));
      if (this.EeF != null) {
        this.EeF.setOnTouchListener(new ContactLabelUI.14(this));
      }
      this.Eey.Wmu = true;
      this.Eey.FR(true);
      this.Eey.setEdittextMaxSize(36);
      this.Eey.setCallBack(new MMTagPanel.a()
      {
        public final void I(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          AppMethodBeat.i(273604);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousBoolean)
          {
            ContactLabelUI.this.enableOptionMenu(false);
            ContactLabelUI.m(ContactLabelUI.this).setVisibility(8);
            AppMethodBeat.o(273604);
            return;
          }
          ContactLabelUI.this.enableOptionMenu(true);
          ContactLabelUI.m(ContactLabelUI.this).setVisibility(8);
          AppMethodBeat.o(273604);
        }
        
        public final void auV(String paramAnonymousString)
        {
          AppMethodBeat.i(273598);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
          ContactLabelUI.d(ContactLabelUI.this).removeTag(paramAnonymousString);
          if (ContactLabelUI.h(ContactLabelUI.this) != null) {
            ContactLabelUI.h(ContactLabelUI.this).dy(paramAnonymousString, false);
          }
          ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
          if (ContactLabelUI.k(ContactLabelUI.this).contains(paramAnonymousString)) {
            ContactLabelUI.k(ContactLabelUI.this).remove(paramAnonymousString);
          }
          AppMethodBeat.o(273598);
        }
        
        public final void auW(String paramAnonymousString)
        {
          AppMethodBeat.i(273599);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(273599);
        }
        
        public final void auX(String paramAnonymousString)
        {
          AppMethodBeat.i(273600);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
          if (ContactLabelUI.h(ContactLabelUI.this) != null) {
            ContactLabelUI.h(ContactLabelUI.this).dy(paramAnonymousString, false);
          }
          ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
          AppMethodBeat.o(273600);
        }
        
        public final void auY(String paramAnonymousString)
        {
          AppMethodBeat.i(273602);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
          ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
          AppMethodBeat.o(273602);
        }
        
        public final void auZ(String paramAnonymousString)
        {
          AppMethodBeat.i(273603);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
          if (Util.isNullOrNil(paramAnonymousString))
          {
            Log.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
            AppMethodBeat.o(273603);
            return;
          }
          ContactLabelUI.d(ContactLabelUI.this).bR(paramAnonymousString, true);
          if (ContactLabelUI.h(ContactLabelUI.this) != null) {
            ContactLabelUI.h(ContactLabelUI.this).dy(paramAnonymousString, true);
          }
          ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.l(ContactLabelUI.this));
          AppMethodBeat.o(273603);
        }
        
        public final void cWR()
        {
          AppMethodBeat.i(273601);
          Log.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
          AppMethodBeat.o(273601);
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
        this.EeR.add(localObject2);
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
        this.EeT.add(localObject2);
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
        this.EeS.add(localObject2);
        i += 1;
      }
    }
    this.EeD.FR(false);
    this.EeD.setNeedNewLebal(true);
    this.EeD.setCallBack(new MMTagPanel.a()
    {
      public final void I(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
      
      public final void auV(String paramAnonymousString)
      {
        AppMethodBeat.i(272124);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.d(ContactLabelUI.this) != null) {
          ContactLabelUI.d(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
        if (ContactLabelUI.n(ContactLabelUI.this)) {
          ContactLabelUI.this.enableOptionMenu(true);
        }
        if (ContactLabelUI.o(ContactLabelUI.this).contains(paramAnonymousString)) {
          ContactLabelUI.o(ContactLabelUI.this).remove(paramAnonymousString);
        }
        AppMethodBeat.o(272124);
      }
      
      public final void auW(String paramAnonymousString)
      {
        AppMethodBeat.i(272126);
        Log.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { String.valueOf(paramAnonymousString) });
        if (ContactLabelUI.d(ContactLabelUI.this) != null) {
          ContactLabelUI.d(ContactLabelUI.this).bR(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.l(ContactLabelUI.this));
        if (ContactLabelUI.n(ContactLabelUI.this)) {
          ContactLabelUI.this.enableOptionMenu(true);
        }
        if (!ContactLabelUI.o(ContactLabelUI.this).contains(paramAnonymousString)) {
          ContactLabelUI.o(ContactLabelUI.this).add(paramAnonymousString);
        }
        AppMethodBeat.o(272126);
      }
      
      public final void auX(String paramAnonymousString) {}
      
      public final void auY(String paramAnonymousString) {}
      
      public final void auZ(String paramAnonymousString) {}
      
      public final void cWR() {}
    });
    this.EeE.setAdapter(this.EeG);
    this.EeE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(289444);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactLabelUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (ContactLabelUI.p(ContactLabelUI.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(289444);
          return;
        }
        paramAnonymousAdapterView = ContactLabelUI.p(ContactLabelUI.this).getItem(paramAnonymousInt);
        if ((!Util.isNullOrNil(paramAnonymousAdapterView)) && (ContactLabelUI.d(ContactLabelUI.this) != null))
        {
          ContactLabelUI.d(ContactLabelUI.this).hKa();
          ContactLabelUI.d(ContactLabelUI.this).bR(paramAnonymousAdapterView, true);
          ContactLabelUI.h(ContactLabelUI.this).dy(paramAnonymousAdapterView, true);
          ContactLabelUI.k(ContactLabelUI.this).add(paramAnonymousAdapterView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactLabelUI$11", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(289444);
      }
    });
    enableOptionMenu(false);
    AppMethodBeat.o(26303);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(26309);
    if (eLq())
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.save_label_msg), "", getString(R.l.etA), getString(R.l.etB), new ContactLabelUI.5(this), new ContactLabelUI.6(this));
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
    paramBundle = getIntent().getStringArrayListExtra("contact_net_label_list");
    if (paramBundle != null) {
      this.EeQ.addAll(paramBundle);
    }
    this.EeH = getIntent().getStringExtra("label_id_list");
    this.EeI = getIntent().getStringArrayListExtra("label_str_list");
    this.iSn = getIntent().getStringExtra("label_username");
    this.EeO = getIntent().getBooleanExtra("is_stranger", false);
    this.Eev = getIntent().getBooleanExtra("save_label_to_contact_on_prepage", false);
    this.EeG = new b(this);
    initView();
    if ((!Util.isNullOrNil(this.EeH)) && (this.EeI != null) && (this.EeI.size() > 0)) {
      this.Eey.a(this.EeI, this.EeI);
    }
    if (this.EeO)
    {
      this.EeP = getIntent().getStringArrayListExtra("label_str_list");
      this.Eey.a(this.EeP, this.EeP);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
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
    bh.aGY().b(635, this);
    bh.aGY().b(638, this);
    if (this.jij != null) {
      this.jij.close();
    }
    super.onPause();
    AppMethodBeat.o(26306);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26305);
    bh.aGY().a(635, this);
    bh.aGY().a(638, this);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289761);
        ContactLabelUI.r(ContactLabelUI.this).clear();
        ContactLabelUI.b(ContactLabelUI.this).clear();
        ContactLabelUI.d(ContactLabelUI.this).a(ContactLabelUI.s(ContactLabelUI.this), ContactLabelUI.s(ContactLabelUI.this));
        if (ContactLabelUI.h(ContactLabelUI.this) != null)
        {
          ContactLabelUI.a(ContactLabelUI.this, e.eLd().hyg());
          if ((ContactLabelUI.c(ContactLabelUI.this) == null) || (ContactLabelUI.c(ContactLabelUI.this).size() <= 0)) {
            break label203;
          }
          ContactLabelUI.l(ContactLabelUI.this);
          ContactLabelUI.h(ContactLabelUI.this).a(ContactLabelUI.s(ContactLabelUI.this), ContactLabelUI.c(ContactLabelUI.this));
          if (ContactLabelUI.t(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
            ContactLabelUI.u(ContactLabelUI.this);
          }
        }
        for (;;)
        {
          ContactLabelUI.b(ContactLabelUI.this, ContactLabelUI.s(ContactLabelUI.this));
          ContactLabelUI.a(ContactLabelUI.this, ContactLabelUI.a.EeX);
          AppMethodBeat.o(289761);
          return;
          label203:
          ContactLabelUI.h(ContactLabelUI.this).a(ContactLabelUI.s(ContactLabelUI.this), ContactLabelUI.c(ContactLabelUI.this));
          if (ContactLabelUI.t(ContactLabelUI.this))
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
            ContactLabelUI.u(ContactLabelUI.this);
          }
        }
      }
    });
    if (this.jij != null) {
      this.jij.start();
    }
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
        if ((this.Eew) && ((paramq instanceof com.tencent.mm.plugin.label.b.a)))
        {
          this.Eew = false;
          hideLoading();
          paramString = ((com.tencent.mm.plugin.label.b.a)paramq).eLf().RIq;
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
                paramq = ((cpq)paramString.get(paramInt1)).TwV;
                Log.d("MicroMsg.Label.ContactLabelUI", "tag:%s", new Object[] { String.valueOf(paramq) });
                if (Util.isNullOrNil(paramq))
                {
                  Log.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                  AppMethodBeat.o(26308);
                  return;
                }
                this.Eey.eT(paramq, this.Eey.getChildCount() - 1);
                this.EeD.eT(paramq, this.EeD.getChildCount() - 1);
                bQ(paramq, this.EeO);
                this.EeS.add(paramq);
                this.EeL.add(paramq);
              }
            }
          }
          AppMethodBeat.o(26308);
          return;
        }
        if (!this.Eev)
        {
          Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.asd");
          eLo();
          AppMethodBeat.o(26308);
          return;
        }
        eLp();
        AppMethodBeat.o(26308);
        return;
      }
      eLi();
      AppMethodBeat.o(26308);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      eLp();
      AppMethodBeat.o(26308);
      return;
    }
    eLi();
    AppMethodBeat.o(26308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(278324);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(278324);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(26301);
      EeX = new a("Normal", 0);
      EeY = new a("Search", 1);
      EeZ = new a("OverMaxCount", 2);
      Efa = new a("Invaildnput", 3);
      Efb = new a[] { EeX, EeY, EeZ, Efa };
      AppMethodBeat.o(26301);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */