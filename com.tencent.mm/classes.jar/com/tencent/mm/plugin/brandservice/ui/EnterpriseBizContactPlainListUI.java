package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String eeM;
  private ListView fry;
  private EnterpriseBizContactPlainListUI.a idJ;
  private long idK;
  private AdapterView.OnItemClickListener idL;
  private int scene;
  
  protected final int getLayoutId()
  {
    return b.e.enterprise_biz_list_normal;
  }
  
  protected final void initView()
  {
    this.fry = ((ListView)findViewById(b.d.enterprist_biz_child_lv));
    if (this.idJ == null)
    {
      this.idJ = new EnterpriseBizContactPlainListUI.a(this, this);
      this.idL = new EnterpriseBizContactPlainListUI.1(this);
    }
    y.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.idJ.getCount()) });
    Object localObject = ((j)g.r(j.class)).Fw().abl(this.eeM);
    if (this.scene == 2)
    {
      setMMTitle(b.h.enterprise_disable);
      if ((localObject != null) && (a.gR(((ao)localObject).field_type)) && (this.idJ.getCount() > 0)) {
        break label203;
      }
      this.fry.setVisibility(8);
      localObject = (TextView)findViewById(b.d.enterprist_biz_child_not_found);
      ((TextView)localObject).setText(b.h.enterprise_no_sub_biz);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new EnterpriseBizContactPlainListUI.2(this));
      new EnterpriseBizContactPlainListUI.3(this);
      return;
      if (localObject == null) {
        break;
      }
      setMMTitle(((ad)localObject).Bp());
      break;
      label203:
      this.fry.setVisibility(0);
      this.fry.setAdapter(this.idJ);
      this.fry.setOnItemClickListener(this.idL);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.scene == 4) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.eeM = getIntent().getStringExtra("enterprise_biz_name");
    this.idK = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    y.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.eeM });
    initView();
    z.My().c(this.idJ);
    ((j)g.r(j.class)).Fw().a(this.idJ);
  }
  
  protected void onDestroy()
  {
    z.My().d(this.idJ);
    ((j)g.r(j.class)).Fw().b(this.idJ);
    this.idJ.bcS();
    EnterpriseBizContactPlainListUI.a locala = this.idJ;
    if (locala.ffG != null)
    {
      locala.ffG.detach();
      locala.ffG = null;
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!s.hk(this.eeM))
    {
      y.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.eeM });
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI
 * JD-Core Version:    0.7.0.1
 */