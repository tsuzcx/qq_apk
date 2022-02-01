package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI
  extends MMActivity
{
  private String mAppName;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> yAp;
  private boolean yAq;
  private ListView yAr;
  private ExdeviceLikeUI.a yAs;
  private final int yAt = 30;
  
  public int getLayoutId()
  {
    return R.i.gjp;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24044);
    super.onCreate(paramBundle);
    this.mAppName = getIntent().getStringExtra("app_username");
    paramBundle = getIntent().getStringExtra("key_rank_info");
    Object localObject1 = getIntent().getStringExtra("key_rank_semi");
    this.yAq = getIntent().getBooleanExtra("key_is_like_read_only", false);
    if (!Util.isNullOrNil(paramBundle))
    {
      String str = this.mAppName;
      Log.d("MicroMsg.ExdeviceMsgXmlParser", paramBundle);
      if (Util.isNullOrNil(paramBundle)) {
        Log.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
      }
      Map localMap;
      do
      {
        do
        {
          paramBundle = null;
          this.yAp = paramBundle;
          this.yAr = ((ListView)findViewById(R.h.fHe));
          this.yAr.setEmptyView(findViewById(R.h.empty));
          this.yAs = new ExdeviceLikeUI.a(this);
          this.yAr.setAdapter(this.yAs);
          if (!this.yAq) {
            this.yAr.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(24039);
                b localb = new b();
                localb.cH(paramAnonymousAdapterView);
                localb.cH(paramAnonymousView);
                localb.sc(paramAnonymousInt);
                localb.hB(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
                paramAnonymousView = (com.tencent.mm.plugin.exdevice.g.b.a.e)ExdeviceLikeUI.b(ExdeviceLikeUI.this).getItem(paramAnonymousInt);
                paramAnonymousAdapterView = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                paramAnonymousAdapterView.putExtra("app_username", paramAnonymousView.field_appusername);
                paramAnonymousAdapterView.putExtra("rank_id", paramAnonymousView.field_rankID);
                paramAnonymousAdapterView.putExtra("device_type", 1);
                paramAnonymousView = ExdeviceLikeUI.this;
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ExdeviceLikeUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(24039);
              }
            });
          }
          this.yAr.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(24040);
              b localb = new b();
              localb.cH(paramAnonymousAdapterView);
              localb.cH(paramAnonymousView);
              localb.sc(paramAnonymousInt);
              localb.hB(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
              paramAnonymousAdapterView = (com.tencent.mm.plugin.exdevice.g.b.a.e)ExdeviceLikeUI.c(ExdeviceLikeUI.this).get(paramAnonymousInt);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rank_id", paramAnonymousAdapterView.field_rankID);
              paramAnonymousView.putExtra("device_type", 1);
              paramAnonymousView.putExtra("locate_to_username", paramAnonymousAdapterView.field_username);
              paramAnonymousView.putExtra("app_username", aa.getDisplayName("gh_43f2581f6fd6"));
              c.b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(24040);
            }
          });
          setMMTitle(R.l.gGq);
          if (!this.yAq) {
            addTextOptionMenu(0, getString(R.l.gGo), new MenuItem.OnMenuItemClickListener()
            {
              public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
              {
                AppMethodBeat.i(24037);
                Object localObject = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                ((Intent)localObject).putExtra("app_username", ExdeviceLikeUI.a(ExdeviceLikeUI.this));
                ((Intent)localObject).putExtra("rank_id", "#");
                ((Intent)localObject).putExtra("key_is_latest", true);
                ((Intent)localObject).putExtra("device_type", 1);
                paramAnonymousMenuItem = ExdeviceLikeUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ExdeviceLikeUI.this.finish();
                AppMethodBeat.o(24037);
                return false;
              }
            });
          }
          setBackBtn(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(24038);
              ExdeviceLikeUI.this.finish();
              AppMethodBeat.o(24038);
              return false;
            }
          });
          AppMethodBeat.o(24044);
          return;
          paramBundle = k.b.aP(paramBundle, (String)localObject1);
        } while (paramBundle == null);
        localMap = paramBundle.nRb;
        localObject1 = new ArrayList();
      } while ((localMap == null) || (localMap.isEmpty()));
      int i = 0;
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      if (i == 0) {}
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        localObject2 = (String)localMap.get(paramBundle + ".username");
        if (!Util.isNullOrNil((String)localObject2)) {
          break label367;
        }
        Log.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
        paramBundle = (Bundle)localObject1;
        break;
      }
      label367:
      Object localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      label385:
      Object localObject4;
      label429:
      Object localObject5;
      if (i == 0)
      {
        paramBundle = "";
        localObject3 = (String)localMap.get(paramBundle + ".rankid");
        localObject4 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
        if (i != 0) {
          break label568;
        }
        paramBundle = "";
        localObject4 = (String)localMap.get(paramBundle + ".liketip");
        localObject5 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
        if (i != 0) {
          break label576;
        }
      }
      label568:
      label576:
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        paramBundle = (String)localMap.get(paramBundle + ".timestamp");
        localObject5 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_appusername = str;
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_rankID = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_timestamp = Util.getInt(paramBundle, 0);
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_liketips = ((String)localObject4);
        ((ArrayList)localObject1).add(localObject5);
        i += 1;
        break;
        paramBundle = Integer.valueOf(i);
        break label385;
        paramBundle = Integer.valueOf(i);
        break label429;
      }
    }
    paramBundle = getIntent().getStringExtra("rank_id");
    if (!Util.isNullOrNil(paramBundle)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.yAp = ah.dFW().apF(paramBundle);
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI
 * JD-Core Version:    0.7.0.1
 */