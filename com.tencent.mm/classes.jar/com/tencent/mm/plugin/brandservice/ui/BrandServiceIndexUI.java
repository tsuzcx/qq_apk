package com.tencent.mm.plugin.brandservice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.u;
import java.util.Map;

@com.tencent.mm.kernel.i
public class BrandServiceIndexUI
  extends MMActivity
  implements k.a
{
  private int cIB = 251658241;
  private boolean lxH = false;
  private TextView mUk = null;
  private BrandServiceSortView mUl;
  private boolean mUm = false;
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(5665);
    ad.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[] { paramString });
    this.lxH = true;
    AppMethodBeat.o(5665);
  }
  
  public int getLayoutId()
  {
    return 2131493238;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5663);
    setMMTitle(2131755219);
    this.mUl = ((BrandServiceSortView)findViewById(2131305113));
    this.mUl.setShowFooterView(true);
    this.mUl.setReturnResult(this.mUm);
    this.mUk = ((TextView)findViewById(2131303112));
    this.mUk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5654);
        AppMethodBeat.o(5654);
      }
    });
    this.mUk.setVisibility(8);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5655);
        BrandServiceIndexUI.this.finish();
        AppMethodBeat.o(5655);
        return true;
      }
    });
    addIconOptionMenu(0, 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5656);
        ad.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
        paramAnonymousMenuItem = new Intent(BrandServiceIndexUI.this, BrandServiceLocalSearchUI.class);
        paramAnonymousMenuItem.putExtra("is_return_result", BrandServiceIndexUI.a(BrandServiceIndexUI.this));
        paramAnonymousMenuItem.addFlags(67108864);
        BrandServiceIndexUI.this.startActivityForResult(paramAnonymousMenuItem, 1);
        AppMethodBeat.o(5656);
        return true;
      }
    });
    addIconOptionMenu(1, 2131755272, 2131689489, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(5658);
        if (aa.Sa(0)) {
          ((com.tencent.mm.plugin.websearch.api.i)g.ab(com.tencent.mm.plugin.websearch.api.i.class)).a(aj.getContext(), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(5657);
              Intent localIntent = aa.ehS();
              localIntent.putExtra("KRightBtn", true);
              localIntent.putExtra("ftsneedkeyboard", true);
              localIntent.putExtra("key_load_js_without_delay", true);
              localIntent.putExtra("ftsType", 1);
              localIntent.putExtra("ftsbizscene", 6);
              Map localMap = aa.f(6, true, 0);
              String str = aa.RY(bt.aGh((String)localMap.get("scene")));
              localMap.put("sessionId", str);
              localMap.put("subSessionId", str);
              localIntent.putExtra("sessionId", str);
              localIntent.putExtra("rawUrl", aa.aR(localMap));
              com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
              AppMethodBeat.o(5657);
            }
          });
        }
        for (;;)
        {
          BrandServiceIndexUI.this.enableOptionMenu(1, false);
          AppMethodBeat.o(5658);
          return true;
          ad.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
        }
      }
    });
    AppMethodBeat.o(5663);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5664);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (this.mUm))
    {
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(5664);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(5659);
    super.onCreate(paramBundle);
    this.cIB = getIntent().getIntExtra("intent_service_type", 251658241);
    this.mUm = u.hasAttr(getIntent().getIntExtra("list_attr", 0), 16384);
    initView();
    af.awe().add(this);
    AppMethodBeat.o(5659);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5662);
    if (g.afw())
    {
      this.mUl.release();
      af.awe().remove(this);
    }
    super.onDestroy();
    AppMethodBeat.o(5662);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5661);
    g.afC();
    g.afB().afk().set(233474, Long.valueOf(System.currentTimeMillis()));
    g.afC();
    g.afB().afk().set(233473, Long.valueOf(System.currentTimeMillis()));
    g.afC();
    g.afB().afk().set(233476, Long.valueOf(System.currentTimeMillis()));
    super.onPause();
    AppMethodBeat.o(5661);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5660);
    if (this.lxH)
    {
      this.lxH = false;
      this.mUl.refresh();
    }
    super.onResume();
    com.tencent.mm.cr.d.fkP();
    enableOptionMenu(1, true);
    AppMethodBeat.o(5660);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI
 * JD-Core Version:    0.7.0.1
 */