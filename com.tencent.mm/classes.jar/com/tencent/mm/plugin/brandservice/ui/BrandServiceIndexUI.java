package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.cl.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.j;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;

@j
public class BrandServiceIndexUI
  extends MMActivity
  implements j.a
{
  private int dWx = 251658241;
  private TextView idf = null;
  private BrandServiceSortView idg;
  private boolean idh = false;
  private boolean idi = false;
  
  public final void a(String paramString, l paraml)
  {
    y.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[] { paramString });
    this.idh = true;
  }
  
  protected final int getLayoutId()
  {
    return b.e.brand_service_index;
  }
  
  protected final void initView()
  {
    setMMTitle(b.h.address_official_accounts_title);
    this.idg = ((BrandServiceSortView)findViewById(b.d.sort_and_search_view));
    this.idg.setShowFooterView(true);
    this.idg.setReturnResult(this.idi);
    this.idf = ((TextView)findViewById(b.d.out_of_date_tv));
    this.idf.setOnClickListener(new BrandServiceIndexUI.1(this));
    this.idf.setVisibility(8);
    setBackBtn(new BrandServiceIndexUI.2(this));
    addIconOptionMenu(0, b.h.top_item_desc_search, b.g.actionbar_icon_dark_search, new BrandServiceIndexUI.3(this));
    addIconOptionMenu(1, b.h.app_add, b.g.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (aa.Br(0)) {
          ((m)g.r(m.class)).a(ae.getContext(), new BrandServiceIndexUI.4.1(this));
        }
        for (;;)
        {
          BrandServiceIndexUI.this.enableOptionMenu(1, false);
          return true;
          y.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (this.idi))
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dWx = getIntent().getIntExtra("intent_service_type", 251658241);
    this.idi = s.fA(getIntent().getIntExtra("list_attr", 0), 16384);
    initView();
    com.tencent.mm.ai.z.My().c(this);
  }
  
  protected void onDestroy()
  {
    if (g.DK())
    {
      this.idg.release();
      com.tencent.mm.ai.z.My().d(this);
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    g.DQ();
    g.DP().Dz().o(233474, Long.valueOf(System.currentTimeMillis()));
    g.DQ();
    g.DP().Dz().o(233473, Long.valueOf(System.currentTimeMillis()));
    g.DQ();
    g.DP().Dz().o(233476, Long.valueOf(System.currentTimeMillis()));
    super.onPause();
  }
  
  protected void onResume()
  {
    if (this.idh)
    {
      this.idh = false;
      this.idg.refresh();
    }
    super.onResume();
    b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    enableOptionMenu(1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI
 * JD-Core Version:    0.7.0.1
 */