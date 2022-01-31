package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public class ExdeviceRankDataSourceUI
  extends MMActivity
  implements f
{
  private ExdeviceRankDataSourceUI.b lOQ;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return 2130969470;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20125);
    this.mListView = ((ListView)findViewById(2131821736));
    View localView1 = View.inflate(this, 2130969472, null);
    View localView2 = View.inflate(this, 2130969471, null);
    this.mListView.addHeaderView(localView1, null, false);
    this.mListView.addFooterView(localView2, null, false);
    this.lOQ = new ExdeviceRankDataSourceUI.b();
    this.mListView.setAdapter(this.lOQ);
    ((ScrollView)findViewById(2131823222)).scrollTo(0, 0);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20115);
        paramAnonymousView = new Intent(ExdeviceRankDataSourceUI.this.getContext(), ExdeviceAddDataSourceUI.class);
        ExdeviceRankDataSourceUI.this.startActivityForResult(paramAnonymousView, 1);
        AppMethodBeat.o(20115);
      }
    });
    AppMethodBeat.o(20125);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20128);
    ab.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("device_mac", 0L);
      paramIntent.getIntExtra("step", 0);
      if (l == 0L)
      {
        ab.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
        AppMethodBeat.o(20128);
        return;
      }
      paramIntent = com.tencent.mm.plugin.exdevice.j.b.jw(l);
      if (paramIntent == null)
      {
        ab.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", new Object[] { paramIntent });
        AppMethodBeat.o(20128);
        return;
      }
      if (this.lOQ.LT(paramIntent) != null)
      {
        ab.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
        AppMethodBeat.o(20128);
        return;
      }
      paramIntent = ad.bpY().jv(l);
      if (paramIntent == null)
      {
        ab.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(20128);
        return;
      }
      if (this.lOQ.dY(paramIntent.field_deviceID, paramIntent.field_deviceType) != null)
      {
        ab.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
        AppMethodBeat.o(20128);
        return;
      }
      aw.Rc().a(1267, this);
      aw.Rc().a(new q(), 0);
    }
    AppMethodBeat.o(20128);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(20126);
    finish();
    AppMethodBeat.o(20126);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20124);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceRankDataSourceUI.1(this));
    setMMTitle(2131298725);
    aw.Rc().a(1267, this);
    initView();
    aw.Rc().a(new q(), 0);
    AppMethodBeat.o(20124);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20127);
    super.onDestroy();
    aw.Rc().b(1267, this);
    AppMethodBeat.o(20127);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(20129);
    if (paramm == null)
    {
      ab.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(20129);
      return;
    }
    if ((paramm instanceof q))
    {
      aw.Rc().b(1267, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aqc)((q)paramm).rr.fsW.fta;
        if (paramString.wZO == null) {
          break label127;
        }
      }
    }
    label127:
    for (paramInt1 = paramString.wZO.size();; paramInt1 = 0)
    {
      ab.d("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, get sport device list succ.(size : %d)", new Object[] { Integer.valueOf(paramInt1) });
      runOnUiThread(new ExdeviceRankDataSourceUI.3(this, paramString.wZO));
      AppMethodBeat.o(20129);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class b$a
  {
    TextView gzk;
    ImageView ivs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI
 * JD-Core Version:    0.7.0.1
 */