package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.s.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AASelectContactUI
  extends MMBaseSelectContactUI
{
  private String chatroomName;
  private HashSet<String> eXS;
  private HashSet<String> eXT;
  private long eXU;
  private int eXV;
  private CheckBox eXW;
  private View eXX;
  private String title;
  
  private void xU()
  {
    if (this.eXT.size() > 0) {
      updateOptionMenuText(1, getString(a.i.aa_confirm_num, new Object[] { Integer.valueOf(this.eXT.size()) }));
    }
    while ((this.eXT.size() == 1) && (this.eXT.contains(q.Gj())))
    {
      enableOptionMenu(1, false);
      return;
      updateOptionMenuText(1, getString(a.i.app_ok));
    }
    enableOptionMenu(1, true);
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    return this.title;
  }
  
  protected final o VF()
  {
    return new d(this, this.chatroomName);
  }
  
  protected final m VG()
  {
    return new e(this, this.chatroomName);
  }
  
  public final boolean a(a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final boolean b(a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXS.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.aa_select_contact_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    a(1, getString(a.i.app_ok), new AASelectContactUI.3(this), s.b.uNx);
    xU();
    this.mbR.setOnContactDeselectListener(this);
    setBackBtn(new AASelectContactUI.4(this));
  }
  
  public final void jP(int paramInt)
  {
    n localn = cHE();
    Object localObject = localn.HK(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null) {}
    while (((a)localObject).dnp == null) {
      return;
    }
    y.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[] { ((a)localObject).dnp.field_username });
    localObject = ((a)localObject).dnp.field_username;
    if (((String)localObject).equals(q.Gj()))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(4) });
      cHK();
      if (!this.eXT.contains(localObject)) {
        break label190;
      }
      this.eXT.remove(localObject);
      label121:
      if (this.eXT.size() != com.tencent.mm.plugin.aa.a.h.pr(this.chatroomName).size()) {
        break label202;
      }
      this.eXW.setChecked(true);
    }
    for (;;)
    {
      localn.notifyDataSetChanged();
      xU();
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
      break;
      label190:
      this.eXT.add(localObject);
      break label121;
      label202:
      this.eXW.setChecked(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("always_select_contact");
    if (!bk.bl(paramBundle)) {
      this.eXS.addAll(bk.G(paramBundle.split(",")));
    }
  }
  
  public final void pw(String paramString)
  {
    this.eXT.remove(paramString);
    cHE().notifyDataSetChanged();
  }
  
  protected final void xK()
  {
    super.xK();
    this.title = getIntent().getStringExtra("titile");
    this.eXU = getIntent().getLongExtra("max_select_num", 20L);
    this.eXV = getIntent().getIntExtra("select_type", 1);
    this.chatroomName = getIntent().getStringExtra("chatroomName");
    if (!s.fn(this.chatroomName)) {
      y.i("MicroMsg.AASelectContactUI", "is single chat");
    }
    this.eXT = new HashSet();
    this.eXS = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bk.bl(str)) {
      this.eXS.addAll(Arrays.asList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bk.bl(str))
    {
      this.eXT.addAll(bk.G(str.split(",")));
      xU();
    }
    this.eXW = ((CheckBox)findViewById(a.f.toggle_select_all));
    this.eXX = findViewById(a.f.toggle_select_all_click_area);
    this.eXX.setOnClickListener(new AASelectContactUI.1(this));
    if (this.eXT.size() == com.tencent.mm.plugin.aa.a.h.pr(this.chatroomName).size()) {
      this.eXW.setChecked(true);
    }
    for (;;)
    {
      this.eXW.setOnCheckedChangeListener(new AASelectContactUI.2(this));
      return;
      this.eXW.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI
 * JD-Core Version:    0.7.0.1
 */