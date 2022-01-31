package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.t;

@i
public class BrandServiceIndexUI
  extends MMActivity
  implements k.a
{
  private int fmF = 251658241;
  private TextView jTT = null;
  private BrandServiceSortView jTU;
  private boolean jTV = false;
  private boolean jTW = false;
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(13925);
    ab.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[] { paramString });
    this.jTV = true;
    AppMethodBeat.o(13925);
  }
  
  public int getLayoutId()
  {
    return 2130968898;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13923);
    setMMTitle(2131296487);
    this.jTU = ((BrandServiceSortView)findViewById(2131821952));
    this.jTU.setShowFooterView(true);
    this.jTU.setReturnResult(this.jTW);
    this.jTT = ((TextView)findViewById(2131821951));
    this.jTT.setOnClickListener(new BrandServiceIndexUI.1(this));
    this.jTT.setVisibility(8);
    setBackBtn(new BrandServiceIndexUI.2(this));
    addIconOptionMenu(0, 2131304318, 2131230741, new BrandServiceIndexUI.3(this));
    addIconOptionMenu(1, 2131296537, 2131230736, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(13918);
        if (aa.Je(0)) {
          ((com.tencent.mm.plugin.websearch.api.m)g.E(com.tencent.mm.plugin.websearch.api.m.class)).a(ah.getContext(), new BrandServiceIndexUI.4.1(this));
        }
        for (;;)
        {
          BrandServiceIndexUI.this.enableOptionMenu(1, false);
          AppMethodBeat.o(13918);
          return true;
          ab.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
        }
      }
    });
    AppMethodBeat.o(13923);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13924);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (this.jTW))
    {
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(13924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13919);
    super.onCreate(paramBundle);
    this.fmF = getIntent().getIntExtra("intent_service_type", 251658241);
    this.jTW = t.hI(getIntent().getIntExtra("list_attr", 0), 16384);
    initView();
    com.tencent.mm.aj.z.afi().add(this);
    AppMethodBeat.o(13919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13922);
    if (g.RG())
    {
      this.jTU.release();
      com.tencent.mm.aj.z.afi().remove(this);
    }
    super.onDestroy();
    AppMethodBeat.o(13922);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13921);
    g.RM();
    g.RL().Ru().set(233474, Long.valueOf(System.currentTimeMillis()));
    g.RM();
    g.RL().Ru().set(233473, Long.valueOf(System.currentTimeMillis()));
    g.RM();
    g.RL().Ru().set(233476, Long.valueOf(System.currentTimeMillis()));
    super.onPause();
    AppMethodBeat.o(13921);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13920);
    if (this.jTV)
    {
      this.jTV = false;
      this.jTU.refresh();
    }
    super.onResume();
    d.aNX();
    enableOptionMenu(1, true);
    AppMethodBeat.o(13920);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI
 * JD-Core Version:    0.7.0.1
 */