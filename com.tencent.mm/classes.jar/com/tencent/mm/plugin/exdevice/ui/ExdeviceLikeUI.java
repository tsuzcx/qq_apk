package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI
  extends MMActivity
{
  private String mAppName;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> qqQ;
  private boolean qqR;
  private ListView qqS;
  private a qqT;
  private final int qqU = 30;
  
  public int getLayoutId()
  {
    return 2131493868;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24044);
    super.onCreate(paramBundle);
    this.mAppName = getIntent().getStringExtra("app_username");
    paramBundle = getIntent().getStringExtra("key_rank_info");
    Object localObject1 = getIntent().getStringExtra("key_rank_semi");
    this.qqR = getIntent().getBooleanExtra("key_is_like_read_only", false);
    if (!bu.isNullOrNil(paramBundle))
    {
      String str = this.mAppName;
      ae.d("MicroMsg.ExdeviceMsgXmlParser", paramBundle);
      if (bu.isNullOrNil(paramBundle)) {
        ae.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
      }
      Map localMap;
      do
      {
        do
        {
          paramBundle = null;
          this.qqQ = paramBundle;
          this.qqS = ((ListView)findViewById(2131299554));
          this.qqS.setEmptyView(findViewById(2131299457));
          this.qqT = new a();
          this.qqS.setAdapter(this.qqT);
          if (!this.qqR) {
            this.qqS.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(24039);
                b localb = new b();
                localb.bd(paramAnonymousAdapterView);
                localb.bd(paramAnonymousView);
                localb.mu(paramAnonymousInt);
                localb.rl(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
                paramAnonymousView = (com.tencent.mm.plugin.exdevice.g.b.a.e)ExdeviceLikeUI.b(ExdeviceLikeUI.this).getItem(paramAnonymousInt);
                paramAnonymousAdapterView = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                paramAnonymousAdapterView.putExtra("app_username", paramAnonymousView.field_appusername);
                paramAnonymousAdapterView.putExtra("rank_id", paramAnonymousView.field_rankID);
                paramAnonymousAdapterView.putExtra("device_type", 1);
                paramAnonymousView = ExdeviceLikeUI.this;
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ExdeviceLikeUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(24039);
              }
            });
          }
          this.qqS.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(24040);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.rl(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
              paramAnonymousAdapterView = (com.tencent.mm.plugin.exdevice.g.b.a.e)ExdeviceLikeUI.c(ExdeviceLikeUI.this).get(paramAnonymousInt);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rank_id", paramAnonymousAdapterView.field_rankID);
              paramAnonymousView.putExtra("device_type", 1);
              paramAnonymousView.putExtra("locate_to_username", paramAnonymousAdapterView.field_username);
              paramAnonymousView.putExtra("app_username", w.zP("gh_43f2581f6fd6"));
              d.b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(24040);
            }
          });
          setMMTitle(2131758550);
          if (!this.qqR) {
            addTextOptionMenu(0, getString(2131758548), new MenuItem.OnMenuItemClickListener()
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          paramBundle = k.b.aB(paramBundle, (String)localObject1);
        } while (paramBundle == null);
        localMap = paramBundle.hCA;
        localObject1 = new ArrayList();
      } while ((localMap == null) || (localMap.isEmpty()));
      int i = 0;
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      if (i == 0) {}
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        localObject2 = (String)localMap.get(paramBundle + ".username");
        if (!bu.isNullOrNil((String)localObject2)) {
          break label363;
        }
        ae.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
        paramBundle = (Bundle)localObject1;
        break;
      }
      label363:
      Object localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      label381:
      Object localObject4;
      label425:
      Object localObject5;
      if (i == 0)
      {
        paramBundle = "";
        localObject3 = (String)localMap.get(paramBundle + ".rankid");
        localObject4 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
        if (i != 0) {
          break label564;
        }
        paramBundle = "";
        localObject4 = (String)localMap.get(paramBundle + ".liketip");
        localObject5 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
        if (i != 0) {
          break label572;
        }
      }
      label564:
      label572:
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        paramBundle = (String)localMap.get(paramBundle + ".timestamp");
        localObject5 = new com.tencent.mm.plugin.exdevice.g.b.a.e();
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_appusername = str;
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_rankID = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_timestamp = bu.getInt(paramBundle, 0);
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_liketips = ((String)localObject4);
        ((ArrayList)localObject1).add(localObject5);
        i += 1;
        break;
        paramBundle = Integer.valueOf(i);
        break label381;
        paramBundle = Integer.valueOf(i);
        break label425;
      }
    }
    paramBundle = getIntent().getStringExtra("rank_id");
    if (!bu.isNullOrNil(paramBundle)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.qqQ = ad.cmO().adx(paramBundle);
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(24041);
      if (ExdeviceLikeUI.c(ExdeviceLikeUI.this) == null)
      {
        AppMethodBeat.o(24041);
        return 0;
      }
      int i = ExdeviceLikeUI.c(ExdeviceLikeUI.this).size();
      AppMethodBeat.o(24041);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(24042);
      Object localObject = ExdeviceLikeUI.c(ExdeviceLikeUI.this).get(paramInt);
      AppMethodBeat.o(24042);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(24043);
      com.tencent.mm.plugin.exdevice.g.b.a.e locale = (com.tencent.mm.plugin.exdevice.g.b.a.e)ExdeviceLikeUI.c(ExdeviceLikeUI.this).get(paramInt);
      if (paramView == null) {
        if (ExdeviceLikeUI.d(ExdeviceLikeUI.this))
        {
          paramView = LayoutInflater.from(ExdeviceLikeUI.this).inflate(2131493867, paramViewGroup, false);
          paramViewGroup = new a();
          paramViewGroup.fTj = ((ImageView)paramView.findViewById(2131299543));
          paramViewGroup.qqW = ((NoMeasuredTextView)paramView.findViewById(2131299597));
          paramViewGroup.iFP = ((TextView)paramView.findViewById(2131299589));
          paramViewGroup.timeTv = ((TextView)paramView.findViewById(2131299588));
          paramViewGroup.qqW.setTextSize(0, ExdeviceLikeUI.this.getResources().getDimension(2131165517));
          paramViewGroup.qqW.setTextColor(ExdeviceLikeUI.this.getResources().getColor(2131100711));
          paramViewGroup.qqW.setSingleLine(true);
          paramViewGroup.qqW.setShouldEllipsize(true);
          paramView.setTag(paramViewGroup);
          label172:
          a.b.v(paramViewGroup.fTj, locale.field_username);
          paramViewGroup.qqW.setText(k.b(ExdeviceLikeUI.this, w.zP(locale.field_username), paramViewGroup.qqW.getTextSize()));
          if ((bu.isNullOrNil(locale.field_liketips)) || (paramViewGroup.iFP == null)) {
            break label343;
          }
          paramViewGroup.iFP.setVisibility(0);
          paramViewGroup.iFP.setText(locale.field_liketips);
          label251:
          paramInt = (int)((System.currentTimeMillis() / 1000L - locale.field_timestamp) / 60L + 1L);
          if (paramInt > 30) {
            break label362;
          }
          paramViewGroup.timeTv.setText(ExdeviceLikeUI.this.getString(2131758549, new Object[] { Integer.valueOf(paramInt) }));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(24043);
        return paramView;
        paramView = LayoutInflater.from(ExdeviceLikeUI.this).inflate(2131493866, paramViewGroup, false);
        break;
        paramViewGroup = (a)paramView.getTag();
        break label172;
        label343:
        if (paramViewGroup.iFP == null) {
          break label251;
        }
        paramViewGroup.iFP.setVisibility(8);
        break label251;
        label362:
        paramViewGroup.timeTv.setText(i.c(ExdeviceLikeUI.this, locale.field_timestamp * 1000L, true));
      }
    }
    
    final class a
    {
      ImageView fTj;
      TextView iFP;
      NoMeasuredTextView qqW;
      TextView timeTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI
 * JD-Core Version:    0.7.0.1
 */