package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.c;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements f
{
  private String eaX;
  private boolean nYE;
  private MMTagPanelScrollView nZd;
  private MMLabelPanel nZe;
  private TextView nZf;
  private View nZg;
  private View nZh;
  private TextView nZi;
  private MMLabelPanel nZj;
  private ListView nZk;
  private ScrollView nZl;
  private b nZm;
  private String nZn;
  private ArrayList<String> nZo;
  private HashSet<String> nZp;
  private HashSet<String> nZq;
  private ArrayList<String> nZr;
  private ContactLabelUI.a nZs;
  private boolean nZt;
  private ArrayList<String> nZu;
  
  public ContactLabelUI()
  {
    AppMethodBeat.i(22680);
    this.nZp = new HashSet();
    this.nZq = new HashSet();
    this.nZr = new ArrayList();
    this.nZs = ContactLabelUI.a.nZx;
    this.nZt = false;
    this.nYE = true;
    AppMethodBeat.o(22680);
  }
  
  private void a(ContactLabelUI.a parama)
  {
    AppMethodBeat.i(22688);
    this.nZs = parama;
    switch (ContactLabelUI.4.nZw[this.nZs.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22688);
      return;
      this.nZk.setVisibility(8);
      if ((this.nZr != null) && (this.nZr.size() > 0))
      {
        this.nZg.setVisibility(0);
        this.nZl.setVisibility(0);
      }
      for (;;)
      {
        this.nZf.setVisibility(8);
        AppMethodBeat.o(22688);
        return;
        this.nZl.setVisibility(8);
        this.nZg.setVisibility(8);
      }
      this.nZl.setVisibility(8);
      this.nZk.setVisibility(0);
      this.nZg.setVisibility(8);
      this.nZf.setVisibility(8);
      AppMethodBeat.o(22688);
      return;
      this.nZk.setVisibility(8);
      this.nZl.setVisibility(8);
      this.nZg.setVisibility(8);
      this.nZf.setVisibility(0);
      this.nZf.setText(2131301013);
      AppMethodBeat.o(22688);
      return;
      this.nZk.setVisibility(8);
      this.nZl.setVisibility(8);
      this.nZg.setVisibility(8);
      this.nZf.setVisibility(0);
      this.nZf.setText(2131301013);
    }
  }
  
  private void aX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(22689);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
      AppMethodBeat.o(22689);
      return;
    }
    paramString = paramString.trim();
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
      AppMethodBeat.o(22689);
      return;
    }
    af localaf = e.bKU().arm(paramString);
    if (paramBoolean) {
      if ((this.nZr == null) || (!this.nZr.contains(paramString)) || (localaf == null)) {
        this.nZq.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.nZp != null) && (this.nZp.contains(paramString))) {
        this.nZp.remove(paramString);
      }
      if (bLg()) {
        enableOptionMenu(true);
      }
      AppMethodBeat.o(22689);
      return;
      if ((this.nZr == null) || (!this.nZr.contains(paramString)) || ((localaf != null) && (localaf.field_isTemporary))) {
        this.nZq.add(paramString);
      }
    }
  }
  
  private void bKZ()
  {
    AppMethodBeat.i(22692);
    hideLoading();
    La(getString(2131296415));
    AppMethodBeat.o(22692);
  }
  
  private void bLe()
  {
    AppMethodBeat.i(22690);
    ab.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.nZe != null)
    {
      ab.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.nZe.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = c.cd(e.bKU().aj((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new cpk();
      ((cpk)localObject3).wOV = ((String)localObject1);
      ((cpk)localObject3).jJA = this.eaX;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      aw.Rc().a((m)localObject1, 0);
      if (this.nZq == null) {
        break label338;
      }
    }
    label338:
    for (int i = this.nZq.size();; i = 0)
    {
      if (this.nZo != null) {}
      for (int j = this.nZo.size();; j = 0)
      {
        if (this.nZp != null) {}
        for (int k = this.nZp.size();; k = 0)
        {
          j = k + this.nZe.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            ab.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.qsU.e(11220, new Object[] { r.Zn(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(22690);
          return;
        }
      }
    }
  }
  
  private void bLf()
  {
    AppMethodBeat.i(22691);
    hideLoading();
    this.nZq.clear();
    this.nZp.clear();
    finish();
    AppMethodBeat.o(22691);
  }
  
  private boolean bLg()
  {
    AppMethodBeat.i(22693);
    if (this.nZe != null)
    {
      if ((this.nZo != null) && (this.nZo.size() > 0))
      {
        if ((this.nZe.getTagList() == null) && (this.nZe.getTagList().size() <= 0))
        {
          AppMethodBeat.o(22693);
          return true;
        }
        ArrayList localArrayList = this.nZe.getTagList();
        Collections.sort(this.nZo);
        Collections.sort(localArrayList);
        if (!this.nZo.equals(localArrayList))
        {
          AppMethodBeat.o(22693);
          return true;
        }
        AppMethodBeat.o(22693);
        return false;
      }
      if ((this.nZe.getTagList() != null) && (this.nZe.getTagList().size() > 0))
      {
        AppMethodBeat.o(22693);
        return true;
      }
    }
    AppMethodBeat.o(22693);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(22694);
    if (this.nZe != null) {
      this.nZe.dEo();
    }
    Intent localIntent = new Intent();
    if (bLg()) {
      localIntent.putExtra("hasLableChange", true);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      super.finish();
      AppMethodBeat.o(22694);
      return;
      localIntent.putExtra("hasLableChange", false);
    }
  }
  
  public int getLayoutId()
  {
    return 2130969263;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22681);
    setMMTitle(getString(2131296418));
    setBackBtn(new ContactLabelUI.1(this));
    addTextOptionMenu(0, getString(2131297063), new ContactLabelUI.5(this), null, q.b.zby);
    this.nZd = ((MMTagPanelScrollView)findViewById(2131823175));
    this.nZd.setMaxLine(3);
    this.nZe = ((MMLabelPanel)findViewById(2131823176));
    this.nZf = ((TextView)findViewById(2131823177));
    this.nZg = findViewById(2131823179);
    this.nZh = findViewById(2131823181);
    this.nZh.setBackgroundDrawable(null);
    this.nZi = ((TextView)this.nZh.findViewById(16908310));
    this.nZi.setText(2131301012);
    this.nZj = ((MMLabelPanel)findViewById(2131823182));
    this.nZk = ((ListView)findViewById(2131823183));
    this.nZl = ((ScrollView)findViewById(2131823178));
    if (this.nZl != null) {
      this.nZl.setOnTouchListener(new ContactLabelUI.6(this));
    }
    this.nZe.zmr = true;
    this.nZe.qF(true);
    this.nZe.setTagEditTextBG(2130840500);
    this.nZe.setCallBack(new ContactLabelUI.7(this));
    this.nZj.qF(false);
    this.nZj.setCallBack(new ContactLabelUI.8(this));
    this.nZk.setAdapter(this.nZm);
    this.nZk.setOnItemClickListener(new ContactLabelUI.9(this));
    enableOptionMenu(false);
    AppMethodBeat.o(22681);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(22687);
    if (bLg())
    {
      com.tencent.mm.ui.base.h.d(this, getString(2131302870), "", getString(2131297825), getString(2131297826), new ContactLabelUI.2(this), new ContactLabelUI.3(this));
      AppMethodBeat.o(22687);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(22687);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22682);
    super.onCreate(paramBundle);
    this.nZn = getIntent().getStringExtra("label_id_list");
    this.nZo = getIntent().getStringArrayListExtra("label_str_list");
    this.eaX = getIntent().getStringExtra("label_username");
    this.nZt = getIntent().getBooleanExtra("is_stranger", false);
    this.nZm = new b(this);
    initView();
    if ((!bo.isNullOrNil(this.nZn)) && (this.nZo != null) && (this.nZo.size() > 0)) {
      this.nZe.a(this.nZo, this.nZo);
    }
    if (this.nZt)
    {
      this.nZu = getIntent().getStringArrayListExtra("label_str_list");
      this.nZe.a(this.nZu, this.nZu);
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(22682);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22685);
    super.onDestroy();
    AppMethodBeat.o(22685);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22684);
    aw.Rc().b(635, this);
    aw.Rc().b(638, this);
    super.onPause();
    AppMethodBeat.o(22684);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22683);
    aw.Rc().a(635, this);
    aw.Rc().a(638, this);
    al.d(new ContactLabelUI.12(this));
    super.onResume();
    AppMethodBeat.o(22683);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22686);
    ab.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    case 636: 
    case 637: 
    default: 
      ab.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
      AppMethodBeat.o(22686);
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bLe();
        AppMethodBeat.o(22686);
        return;
      }
      bKZ();
      AppMethodBeat.o(22686);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      bLf();
      AppMethodBeat.o(22686);
      return;
    }
    bKZ();
    AppMethodBeat.o(22686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */