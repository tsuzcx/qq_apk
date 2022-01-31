package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.c;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class ContactLabelUI
  extends ContactLabelBaseUI
  implements com.tencent.mm.ah.f
{
  private String djD;
  private MMTagPanelScrollView lBR;
  private MMLabelPanel lBS;
  private TextView lBT;
  private View lBU;
  private View lBV;
  private TextView lBW;
  private MMLabelPanel lBX;
  private ListView lBY;
  private ScrollView lBZ;
  private boolean lBs = true;
  private b lCa;
  private String lCb;
  private ArrayList<String> lCc;
  private HashSet<String> lCd = new HashSet();
  private HashSet<String> lCe = new HashSet();
  private ArrayList<String> lCf = new ArrayList();
  private ContactLabelUI.a lCg = ContactLabelUI.a.lCl;
  private boolean lCh = false;
  private ArrayList<String> lCi;
  
  private void a(ContactLabelUI.a parama)
  {
    this.lCg = parama;
    switch (ContactLabelUI.4.lCk[this.lCg.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.lBY.setVisibility(8);
      if ((this.lCf != null) && (this.lCf.size() > 0))
      {
        this.lBU.setVisibility(0);
        this.lBZ.setVisibility(0);
      }
      for (;;)
      {
        this.lBT.setVisibility(8);
        return;
        this.lBZ.setVisibility(8);
        this.lBU.setVisibility(8);
      }
    case 2: 
      this.lBZ.setVisibility(8);
      this.lBY.setVisibility(0);
      this.lBU.setVisibility(8);
      this.lBT.setVisibility(8);
      return;
    case 3: 
      this.lBY.setVisibility(8);
      this.lBZ.setVisibility(8);
      this.lBU.setVisibility(8);
      this.lBT.setVisibility(0);
      this.lBT.setText(R.l.label_panel_max_tips);
      return;
    }
    this.lBY.setVisibility(8);
    this.lBZ.setVisibility(8);
    this.lBU.setVisibility(8);
    this.lBT.setVisibility(0);
    this.lBT.setText(R.l.label_panel_max_tips);
  }
  
  private void aI(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
      return;
    }
    paramString = paramString.trim();
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
      return;
    }
    af localaf = e.bdz().abb(paramString);
    if (paramBoolean) {
      if ((this.lCf == null) || (!this.lCf.contains(paramString)) || (localaf == null)) {
        this.lCe.add(paramString);
      }
    }
    for (;;)
    {
      if ((this.lCd != null) && (this.lCd.contains(paramString))) {
        this.lCd.remove(paramString);
      }
      if (!bdM()) {
        break;
      }
      enableOptionMenu(true);
      return;
      if ((this.lCf == null) || (!this.lCf.contains(paramString)) || ((localaf != null) && (localaf.field_isTemporary))) {
        this.lCe.add(paramString);
      }
    }
  }
  
  private void bdF()
  {
    bdC();
    AY(getString(R.l.add_label_fail_msg));
  }
  
  private void bdK()
  {
    y.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
    if (this.lBS != null)
    {
      y.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
      Object localObject2 = "";
      Object localObject3 = this.lBS.getTagList();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0) {
          localObject1 = c.bG(e.bdz().ad((ArrayList)localObject3));
        }
      }
      localObject2 = new LinkedList();
      localObject3 = new cce();
      ((cce)localObject3).sQu = ((String)localObject1);
      ((cce)localObject3).hPY = this.djD;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = new d((LinkedList)localObject2);
      au.Dk().a((m)localObject1, 0);
      if (this.lCe == null) {
        break label326;
      }
    }
    label326:
    for (int i = this.lCe.size();; i = 0)
    {
      if (this.lCc != null) {}
      for (int j = this.lCc.size();; j = 0)
      {
        if (this.lCd != null) {}
        for (int k = this.lCd.size();; k = 0)
        {
          j = k + this.lBS.getTagList().size() - j - i;
          if ((i > 0) || (j > 0))
          {
            y.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.nFQ.f(11220, new Object[] { q.Gj(), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0) });
          }
          if (i > 0) {
            com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1) });
          }
          return;
        }
      }
    }
  }
  
  private void bdL()
  {
    bdC();
    this.lCe.clear();
    this.lCd.clear();
    finish();
  }
  
  private boolean bdM()
  {
    if (this.lBS != null)
    {
      if ((this.lCc != null) && (this.lCc.size() > 0)) {
        if ((this.lBS.getTagList() != null) || (this.lBS.getTagList().size() > 0)) {}
      }
      while ((this.lBS.getTagList() != null) && (this.lBS.getTagList().size() > 0))
      {
        ArrayList localArrayList;
        do
        {
          return true;
          localArrayList = this.lBS.getTagList();
          Collections.sort(this.lCc);
          Collections.sort(localArrayList);
        } while (!this.lCc.equals(localArrayList));
        return false;
      }
    }
    return false;
  }
  
  public void finish()
  {
    if (this.lBS != null) {
      this.lBS.cBb();
    }
    Intent localIntent = new Intent();
    if (bdM()) {
      localIntent.putExtra("hasLableChange", true);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      super.finish();
      return;
      localIntent.putExtra("hasLableChange", false);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_label_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(getString(R.l.add_label_title));
    setBackBtn(new ContactLabelUI.1(this));
    a(0, getString(R.l.app_save), new ContactLabelUI.5(this), s.b.uNx);
    this.lBR = ((MMTagPanelScrollView)findViewById(R.h.label_panel_scroll));
    this.lBR.setMaxLine(3);
    this.lBS = ((MMLabelPanel)findViewById(R.h.label_panel_input));
    this.lBT = ((TextView)findViewById(R.h.label_panel_tips));
    this.lBU = findViewById(R.h.label_panel_container);
    this.lBV = findViewById(R.h.label_panel_all_title_pref);
    this.lBV.setBackgroundDrawable(null);
    this.lBW = ((TextView)this.lBV.findViewById(16908310));
    this.lBW.setText(R.l.label_panel_all);
    this.lBX = ((MMLabelPanel)findViewById(R.h.label_panel_all));
    this.lBY = ((ListView)findViewById(R.h.label_panel_suggest));
    this.lBZ = ((ScrollView)findViewById(R.h.label_scroll_view));
    if (this.lBZ != null) {
      this.lBZ.setOnTouchListener(new ContactLabelUI.6(this));
    }
    this.lBS.uYa = true;
    this.lBS.nc(true);
    this.lBS.setTagEditTextBG(R.g.tag_edittext_gb);
    this.lBS.setCallBack(new MMTagPanel.a()
    {
      public final void Bc(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).bI(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
      }
      
      public final void Bd(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[] { paramAnonymousString });
      }
      
      public final void Be(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).bI(paramAnonymousString, false);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
      }
      
      public final void Bf(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[] { paramAnonymousString });
        ContactLabelUI.b(ContactLabelUI.this, paramAnonymousString);
      }
      
      public final void Bg(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[] { paramAnonymousString });
        if (bk.bl(paramAnonymousString))
        {
          y.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
          return;
        }
        ContactLabelUI.b(ContactLabelUI.this).bH(paramAnonymousString, true);
        if (ContactLabelUI.c(ContactLabelUI.this) != null) {
          ContactLabelUI.c(ContactLabelUI.this).bI(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
      }
      
      public final void aJI()
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
      }
      
      public final void i(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[] { String.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousBoolean)
        {
          ContactLabelUI.this.enableOptionMenu(false);
          ContactLabelUI.e(ContactLabelUI.this).setVisibility(0);
          ContactLabelUI.e(ContactLabelUI.this).setText(R.l.label_panel_max_tips);
          ContactLabelUI.e(ContactLabelUI.this).setText(String.format(ContactLabelUI.this.getString(R.l.label_panel_max_tips), new Object[] { Integer.valueOf(com.tencent.mm.ui.tools.f.bi(36, "")), Integer.valueOf(paramAnonymousInt) }));
          return;
        }
        ContactLabelUI.this.enableOptionMenu(true);
        ContactLabelUI.e(ContactLabelUI.this).setVisibility(8);
      }
    });
    this.lBX.nc(false);
    this.lBX.setCallBack(new MMTagPanel.a()
    {
      public final void Bc(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).removeTag(paramAnonymousString);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString);
      }
      
      public final void Bd(String paramAnonymousString)
      {
        y.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[] { paramAnonymousString });
        if (ContactLabelUI.b(ContactLabelUI.this) != null) {
          ContactLabelUI.b(ContactLabelUI.this).bH(paramAnonymousString, true);
        }
        ContactLabelUI.a(ContactLabelUI.this, paramAnonymousString, ContactLabelUI.d(ContactLabelUI.this));
      }
      
      public final void Be(String paramAnonymousString) {}
      
      public final void Bf(String paramAnonymousString) {}
      
      public final void Bg(String paramAnonymousString) {}
      
      public final void aJI() {}
      
      public final void i(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
    });
    this.lBY.setAdapter(this.lCa);
    this.lBY.setOnItemClickListener(new ContactLabelUI.9(this));
    enableOptionMenu(false);
  }
  
  public void onBackPressed()
  {
    if (bdM())
    {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.save_label_msg), "", getString(R.l.btn_save), getString(R.l.btn_unsave), new ContactLabelUI.2(this), new ContactLabelUI.3(this));
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lCb = getIntent().getStringExtra("label_id_list");
    this.lCc = getIntent().getStringArrayListExtra("label_str_list");
    this.djD = getIntent().getStringExtra("label_username");
    this.lCh = getIntent().getBooleanExtra("is_stranger", false);
    this.lCa = new b(this);
    initView();
    if ((!bk.bl(this.lCb)) && (this.lCc != null) && (this.lCc.size() > 0)) {
      this.lBS.a(this.lCc, this.lCc);
    }
    if (this.lCh)
    {
      this.lCi = getIntent().getStringArrayListExtra("label_str_list");
      this.lBS.a(this.lCi, this.lCi);
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1) });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    au.Dk().b(635, this);
    au.Dk().b(638, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    au.Dk().a(635, this);
    au.Dk().a(638, this);
    com.tencent.mm.sdk.platformtools.ai.d(new ContactLabelUI.12(this));
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    switch (paramm.getType())
    {
    case 636: 
    case 637: 
    default: 
      y.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
      return;
    case 635: 
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bdK();
        return;
      }
      bdF();
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
      bdL();
      return;
    }
    bdF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI
 * JD-Core Version:    0.7.0.1
 */