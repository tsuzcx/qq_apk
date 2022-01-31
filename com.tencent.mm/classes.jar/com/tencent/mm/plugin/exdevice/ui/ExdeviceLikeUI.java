package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI
  extends MMActivity
{
  private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> lMK;
  private boolean lML;
  private ListView lMM;
  private ExdeviceLikeUI.a lMN;
  private final int lMO = 30;
  private String mAppName;
  
  public int getLayoutId()
  {
    return 2130969456;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19975);
    super.onCreate(paramBundle);
    this.mAppName = getIntent().getStringExtra("app_username");
    paramBundle = getIntent().getStringExtra("key_rank_info");
    Object localObject1 = getIntent().getStringExtra("key_rank_semi");
    this.lML = getIntent().getBooleanExtra("key_is_like_read_only", false);
    if (!bo.isNullOrNil(paramBundle))
    {
      String str = this.mAppName;
      ab.d("MicroMsg.ExdeviceMsgXmlParser", paramBundle);
      if (bo.isNullOrNil(paramBundle)) {
        ab.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
      }
      Map localMap;
      do
      {
        do
        {
          paramBundle = null;
          this.lMK = paramBundle;
          this.lMM = ((ListView)findViewById(2131823778));
          this.lMM.setEmptyView(findViewById(2131821788));
          this.lMN = new ExdeviceLikeUI.a(this);
          this.lMM.setAdapter(this.lMN);
          if (!this.lML) {
            this.lMM.setOnItemClickListener(new ExdeviceLikeUI.3(this));
          }
          this.lMM.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(19971);
              paramAnonymousAdapterView = (com.tencent.mm.plugin.exdevice.f.b.a.e)ExdeviceLikeUI.c(ExdeviceLikeUI.this).get(paramAnonymousInt);
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rank_id", paramAnonymousAdapterView.field_rankID);
              paramAnonymousView.putExtra("device_type", 1);
              paramAnonymousView.putExtra("locate_to_username", paramAnonymousAdapterView.field_username);
              paramAnonymousView.putExtra("app_username", s.nE("gh_43f2581f6fd6"));
              d.b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", paramAnonymousView);
              AppMethodBeat.o(19971);
            }
          });
          setMMTitle(2131299422);
          if (!this.lML) {
            addTextOptionMenu(0, getString(2131299420), new ExdeviceLikeUI.1(this));
          }
          setBackBtn(new ExdeviceLikeUI.2(this));
          AppMethodBeat.o(19975);
          return;
          paramBundle = j.b.ab(paramBundle, (String)localObject1);
        } while (paramBundle == null);
        localMap = paramBundle.fgu;
        localObject1 = new ArrayList();
      } while ((localMap == null) || (localMap.isEmpty()));
      int i = 0;
      Object localObject2 = new StringBuilder(".msg.appmsg.hardwareinfo.likeuserlist.userinfo");
      if (i == 0) {}
      for (paramBundle = "";; paramBundle = Integer.valueOf(i))
      {
        localObject2 = (String)localMap.get(paramBundle + ".username");
        if (!bo.isNullOrNil((String)localObject2)) {
          break label363;
        }
        ab.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[] { Integer.valueOf(i) });
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
        localObject5 = new com.tencent.mm.plugin.exdevice.f.b.a.e();
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_appusername = str;
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_rankID = ((String)localObject3);
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_username = ((String)localObject2);
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_timestamp = bo.getInt(paramBundle, 0);
        ((com.tencent.mm.plugin.exdevice.f.b.a.e)localObject5).field_liketips = ((String)localObject4);
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
    if (!bo.isNullOrNil(paramBundle)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.lMK = ad.bqd().LF(paramBundle);
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