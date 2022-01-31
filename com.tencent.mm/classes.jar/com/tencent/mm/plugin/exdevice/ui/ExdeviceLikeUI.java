package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.br.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI
  extends MMActivity
{
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> jDl;
  private boolean jDm;
  private ListView jDn;
  private ExdeviceLikeUI.a jDo;
  private final int jDp = 30;
  private String mAppName;
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_like_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mAppName = getIntent().getStringExtra("app_username");
    paramBundle = getIntent().getStringExtra("key_rank_info");
    Object localObject1 = getIntent().getStringExtra("key_rank_semi");
    this.jDm = getIntent().getBooleanExtra("key_is_like_read_only", false);
    if (!bk.bl(paramBundle))
    {
      String str = this.mAppName;
      y.d("MicroMsg.ExdeviceMsgXmlParser", paramBundle);
      if (bk.bl(paramBundle)) {
        y.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
      }
      Map localMap;
      do
      {
        do
        {
          paramBundle = null;
          this.jDl = paramBundle;
          this.jDn = ((ListView)findViewById(R.h.exdevice_list));
          this.jDn.setEmptyView(findViewById(R.h.empty));
          this.jDo = new ExdeviceLikeUI.a(this);
          this.jDn.setAdapter(this.jDo);
          if (!this.jDm) {
            this.jDn.setOnItemClickListener(new ExdeviceLikeUI.3(this));
          }
          this.jDn.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              paramAnonymousAdapterView = (com.tencent.mm.plugin.exdevice.f.b.a.e)ExdeviceLikeUI.c(ExdeviceLikeUI.this).get(paramAnonymousInt);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rank_id", paramAnonymousAdapterView.field_rankID);
              paramAnonymousView.putExtra("device_type", 1);
              paramAnonymousView.putExtra("locate_to_username", paramAnonymousAdapterView.field_username);
              paramAnonymousView.putExtra("app_username", r.gV("gh_43f2581f6fd6"));
              d.b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", paramAnonymousView);
            }
          });
          setMMTitle(R.l.exdevice_like_title);
          if (!this.jDm) {
            addTextOptionMenu(0, getString(R.l.exdevice_like_see_recent), new ExdeviceLikeUI.1(this));
          }
          setBackBtn(new ExdeviceLikeUI.2(this));
          return;
          paramBundle = g.a.M(paramBundle, (String)localObject1);
        } while (paramBundle == null);
        localMap = paramBundle.dQt;
        localObject1 = new ArrayList();
      } while ((localMap == null) || (localMap.isEmpty()));
      int i = 0;
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      if (i == 0) {}
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        localObject2 = (String)localMap.get(paramBundle + ".username");
        if (!bk.bl((String)localObject2)) {
          break label355;
        }
        y.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
        paramBundle = (Bundle)localObject1;
        break;
      }
      label355:
      Object localObject3 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      label373:
      Object localObject4;
      label417:
      Object localObject5;
      if (i == 0)
      {
        paramBundle = "";
        localObject3 = (String)localMap.get(paramBundle + ".rankid");
        localObject4 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
        if (i != 0) {
          break label556;
        }
        paramBundle = "";
        localObject4 = (String)localMap.get(paramBundle + ".liketip");
        localObject5 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
        if (i != 0) {
          break label564;
        }
      }
      label556:
      label564:
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        paramBundle = (String)localMap.get(paramBundle + ".timestamp");
        localObject5 = new com.tencent.mm.plugin.exdevice.f.b.a.e();
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_appusername = str;
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_rankID = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_timestamp = bk.getInt(paramBundle, 0);
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_liketips = ((String)localObject4);
        ((ArrayList)localObject1).add(localObject5);
        i += 1;
        break;
        paramBundle = Integer.valueOf(i);
        break label373;
        paramBundle = Integer.valueOf(i);
        break label417;
      }
    }
    paramBundle = getIntent().getStringExtra("rank_id");
    if (!bk.bl(paramBundle)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jDl = ad.aLQ().BD(paramBundle);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI
 * JD-Core Version:    0.7.0.1
 */