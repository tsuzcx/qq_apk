package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.api.r;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.w;
import java.util.Map;

@k
public class BrandServiceIndexUI
  extends MMActivity
  implements MStorage.IOnStorageChange
{
  private int serviceType = 251658241;
  private boolean tXv = false;
  private TextView vDp = null;
  private BrandServiceSortView vDq;
  private boolean vDr = false;
  
  public int getLayoutId()
  {
    return d.f.brand_service_index;
  }
  
  public void initView()
  {
    AppMethodBeat.i(5663);
    setMMTitle(d.i.address_official_accounts_title);
    this.vDq = ((BrandServiceSortView)findViewById(d.e.sort_and_search_view));
    this.vDq.setShowFooterView(true);
    this.vDq.setReturnResult(this.vDr);
    this.vDp = ((TextView)findViewById(d.e.out_of_date_tv));
    this.vDp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5654);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/brandservice/ui/BrandServiceIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.a(this, "com/tencent/mm/plugin/brandservice/ui/BrandServiceIndexUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(5654);
      }
    });
    this.vDp.setVisibility(8);
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
    if (((r)com.tencent.mm.kernel.h.ax(r.class)).aBv())
    {
      addIconOptionMenu(0, d.i.top_item_desc_search, d.h.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(5656);
          if (BrandServiceIndexUI.a(BrandServiceIndexUI.this))
          {
            paramAnonymousMenuItem = new Intent(BrandServiceIndexUI.this, BrandServiceLocalSearchUI.class);
            paramAnonymousMenuItem.putExtra("is_return_result", BrandServiceIndexUI.a(BrandServiceIndexUI.this));
            paramAnonymousMenuItem.addFlags(67108864);
            BrandServiceIndexUI.this.startActivityForResult(paramAnonymousMenuItem, 1);
          }
          for (;;)
          {
            AppMethodBeat.o(5656);
            return true;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Search_Scene", 5);
            paramAnonymousMenuItem.putExtra("detail_type", -7);
            d.d(BrandServiceIndexUI.this, ".ui.FTSBizDetailUI", paramAnonymousMenuItem);
          }
        }
      });
      if (!aj.aBu()) {
        addIconOptionMenu(1, d.i.app_add, d.h.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(5658);
            if (aj.asX(0)) {
              ((i)com.tencent.mm.kernel.h.ax(i.class)).a(MMApplicationContext.getContext(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(5657);
                  Intent localIntent = aj.ipS();
                  localIntent.putExtra("KRightBtn", true);
                  localIntent.putExtra("ftsneedkeyboard", true);
                  localIntent.putExtra("key_load_js_without_delay", true);
                  localIntent.putExtra("ftsType", 1);
                  localIntent.putExtra("ftsbizscene", 6);
                  Map localMap = aj.r(6, true, 0);
                  String str = aj.asV(Util.safeParseInt((String)localMap.get("scene")));
                  localMap.put("sessionId", str);
                  localMap.put("subSessionId", str);
                  localIntent.putExtra("sessionId", str);
                  localIntent.putExtra("rawUrl", aj.bo(localMap));
                  com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", localIntent);
                  AppMethodBeat.o(5657);
                }
              });
            }
            for (;;)
            {
              BrandServiceIndexUI.this.enableOptionMenu(1, false);
              AppMethodBeat.o(5658);
              return true;
              Log.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
            }
          }
        });
      }
    }
    AppMethodBeat.o(5663);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(5664);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (this.vDr))
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
    this.serviceType = getIntent().getIntExtra("intent_service_type", 251658241);
    this.vDr = w.hasAttr(getIntent().getIntExtra("list_attr", 0), 16384);
    initView();
    af.bHf().add(this);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1378L, 7L, 1L, false);
    AppMethodBeat.o(5659);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5662);
    if (com.tencent.mm.kernel.h.baz())
    {
      this.vDq.release();
      af.bHf().remove(this);
    }
    super.onDestroy();
    AppMethodBeat.o(5662);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(5665);
    Log.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[] { paramString });
    this.tXv = true;
    AppMethodBeat.o(5665);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(5661);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(233474, Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(233473, Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().B(233476, Long.valueOf(System.currentTimeMillis()));
    super.onPause();
    AppMethodBeat.o(5661);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(5660);
    if (this.tXv)
    {
      this.tXv = false;
      this.vDq.bDL();
    }
    super.onResume();
    com.tencent.mm.xwebutil.c.jQE();
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