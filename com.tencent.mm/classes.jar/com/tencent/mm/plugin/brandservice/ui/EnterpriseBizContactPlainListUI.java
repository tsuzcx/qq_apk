package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;

public class EnterpriseBizContactPlainListUI
  extends MMActivity
{
  private String fuO;
  private ListView gJa;
  private EnterpriseBizContactPlainListUI.a jUx;
  private long jUy;
  private AdapterView.OnItemClickListener jUz;
  private int scene;
  
  public int getLayoutId()
  {
    return 2130969429;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13997);
    this.gJa = ((ListView)findViewById(2131823733));
    if (this.jUx == null)
    {
      this.jUx = new EnterpriseBizContactPlainListUI.a(this, this);
      this.jUz = new EnterpriseBizContactPlainListUI.1(this);
    }
    ab.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[] { Integer.valueOf(this.jUx.getCount()) });
    Object localObject = ((j)g.E(j.class)).YA().arw(this.fuO);
    if (this.scene == 2)
    {
      setMMTitle(2131299311);
      if ((localObject != null) && (a.je(((aq)localObject).field_type)) && (this.jUx.getCount() > 0)) {
        break label218;
      }
      this.gJa.setVisibility(8);
      localObject = (TextView)findViewById(2131823734);
      ((TextView)localObject).setText(2131299317);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      setBackBtn(new EnterpriseBizContactPlainListUI.2(this));
      setToTop(new EnterpriseBizContactPlainListUI.3(this));
      AppMethodBeat.o(13997);
      return;
      if (localObject == null) {
        break;
      }
      setMMTitle(((ad)localObject).Oe());
      break;
      label218:
      this.gJa.setVisibility(0);
      this.gJa.setAdapter(this.jUx);
      this.gJa.setOnItemClickListener(this.jUz);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(14001);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.scene == 4) {
      finish();
    }
    AppMethodBeat.o(14001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13996);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enterprise_scene", 2);
    this.fuO = getIntent().getStringExtra("enterprise_biz_name");
    this.jUy = getIntent().getLongExtra("biz_chat_chat_id", -1L);
    ab.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[] { this.fuO });
    initView();
    z.afi().add(this.jUx);
    ((j)g.E(j.class)).YA().a(this.jUx);
    AppMethodBeat.o(13996);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(14000);
    z.afi().remove(this.jUx);
    ((j)g.E(j.class)).YA().b(this.jUx);
    this.jUx.bKb();
    EnterpriseBizContactPlainListUI.a locala = this.jUx;
    if (locala.gxo != null)
    {
      locala.gxo.detach();
      locala.gxo = null;
    }
    super.onDestroy();
    AppMethodBeat.o(14000);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13999);
    super.onPause();
    AppMethodBeat.o(13999);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13998);
    super.onResume();
    if (!t.nT(this.fuO))
    {
      ab.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[] { this.fuO });
      finish();
      AppMethodBeat.o(13998);
      return;
    }
    AppMethodBeat.o(13998);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI
 * JD-Core Version:    0.7.0.1
 */