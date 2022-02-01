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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI
  extends MMActivity
{
  private String mAppName;
  private ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> rIl;
  private boolean rIm;
  private ListView rIn;
  private a rIo;
  private final int rIp = 30;
  
  public int getLayoutId()
  {
    return 2131494026;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24044);
    super.onCreate(paramBundle);
    this.mAppName = getIntent().getStringExtra("app_username");
    paramBundle = getIntent().getStringExtra("key_rank_info");
    Object localObject1 = getIntent().getStringExtra("key_rank_semi");
    this.rIm = getIntent().getBooleanExtra("key_is_like_read_only", false);
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
          this.rIl = paramBundle;
          this.rIn = ((ListView)findViewById(2131300202));
          this.rIn.setEmptyView(findViewById(2131300076));
          this.rIo = new a();
          this.rIn.setAdapter(this.rIo);
          if (!this.rIm) {
            this.rIn.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
              public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
              {
                AppMethodBeat.i(24039);
                b localb = new b();
                localb.bm(paramAnonymousAdapterView);
                localb.bm(paramAnonymousView);
                localb.pH(paramAnonymousInt);
                localb.zo(paramAnonymousLong);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
                paramAnonymousView = (com.tencent.mm.plugin.exdevice.g.b.a.e)ExdeviceLikeUI.b(ExdeviceLikeUI.this).getItem(paramAnonymousInt);
                paramAnonymousAdapterView = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                paramAnonymousAdapterView.putExtra("app_username", paramAnonymousView.field_appusername);
                paramAnonymousAdapterView.putExtra("rank_id", paramAnonymousView.field_rankID);
                paramAnonymousAdapterView.putExtra("device_type", 1);
                paramAnonymousView = ExdeviceLikeUI.this;
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ExdeviceLikeUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(24039);
              }
            });
          }
          this.rIn.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(24040);
              b localb = new b();
              localb.bm(paramAnonymousAdapterView);
              localb.bm(paramAnonymousView);
              localb.pH(paramAnonymousInt);
              localb.zo(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
          setMMTitle(2131758849);
          if (!this.rIm) {
            addTextOptionMenu(0, getString(2131758847), new MenuItem.OnMenuItemClickListener()
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
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceLikeUI$1", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
          paramBundle = k.b.aD(paramBundle, (String)localObject1);
        } while (paramBundle == null);
        localMap = paramBundle.iwG;
        localObject1 = new ArrayList();
      } while ((localMap == null) || (localMap.isEmpty()));
      int i = 0;
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      if (i == 0) {}
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        localObject2 = (String)localMap.get(paramBundle + ".username");
        if (!Util.isNullOrNil((String)localObject2)) {
          break label363;
        }
        Log.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
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
        ((com.tencent.mm.plugin.exdevice.g.b.a.e)localObject5).field_timestamp = Util.getInt(paramBundle, 0);
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
    if (!Util.isNullOrNil(paramBundle)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.rIl = ad.cKQ().anG(paramBundle);
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
          paramView = LayoutInflater.from(ExdeviceLikeUI.this).inflate(2131494025, paramViewGroup, false);
          paramViewGroup = new a();
          paramViewGroup.gyr = ((ImageView)paramView.findViewById(2131300191));
          paramViewGroup.rIr = ((NoMeasuredTextView)paramView.findViewById(2131300225));
          paramViewGroup.jBS = ((TextView)paramView.findViewById(2131300219));
          paramViewGroup.timeTv = ((TextView)paramView.findViewById(2131300218));
          paramViewGroup.rIr.setTextSize(0, ExdeviceLikeUI.this.getResources().getDimension(2131165535));
          paramViewGroup.rIr.setTextColor(ExdeviceLikeUI.this.getResources().getColor(2131100904));
          paramViewGroup.rIr.setSingleLine(true);
          paramViewGroup.rIr.setShouldEllipsize(true);
          paramView.setTag(paramViewGroup);
          label172:
          a.b.z(paramViewGroup.gyr, locale.field_username);
          paramViewGroup.rIr.setText(l.b(ExdeviceLikeUI.this, aa.getDisplayName(locale.field_username), paramViewGroup.rIr.getTextSize()));
          if ((Util.isNullOrNil(locale.field_liketips)) || (paramViewGroup.jBS == null)) {
            break label343;
          }
          paramViewGroup.jBS.setVisibility(0);
          paramViewGroup.jBS.setText(locale.field_liketips);
          label251:
          paramInt = (int)((System.currentTimeMillis() / 1000L - locale.field_timestamp) / 60L + 1L);
          if (paramInt > 30) {
            break label362;
          }
          paramViewGroup.timeTv.setText(ExdeviceLikeUI.this.getString(2131758848, new Object[] { Integer.valueOf(paramInt) }));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(24043);
        return paramView;
        paramView = LayoutInflater.from(ExdeviceLikeUI.this).inflate(2131494024, paramViewGroup, false);
        break;
        paramViewGroup = (a)paramView.getTag();
        break label172;
        label343:
        if (paramViewGroup.jBS == null) {
          break label251;
        }
        paramViewGroup.jBS.setVisibility(8);
        break label251;
        label362:
        paramViewGroup.timeTv.setText(f.c(ExdeviceLikeUI.this, locale.field_timestamp * 1000L, true));
      }
    }
    
    final class a
    {
      ImageView gyr;
      TextView jBS;
      NoMeasuredTextView rIr;
      TextView timeTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI
 * JD-Core Version:    0.7.0.1
 */