package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ListView mListView;
  private ExdeviceManageDeviceUI.a pGV;
  
  public int getLayoutId()
  {
    return 2131493871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24068);
    this.mListView = ((ListView)findViewById(2131301457));
    this.pGV = new ExdeviceManageDeviceUI.a(this);
    View.inflate(this, 2131493859, null);
    this.mListView.setAdapter(this.pGV);
    AppMethodBeat.o(24068);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24069);
    this.pGV.U(ad.cgP().chu());
    this.pGV.notifyDataSetChanged();
    AppMethodBeat.o(24069);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24067);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24052);
        ExdeviceManageDeviceUI.this.finish();
        AppMethodBeat.o(24052);
        return true;
      }
    });
    setMMTitle(2131758553);
    paramBundle = new ds();
    paramBundle.ddp.ddq = true;
    a.GpY.l(paramBundle);
    initView();
    az.agi().a(537, this.pGV);
    AppMethodBeat.o(24067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24070);
    super.onDestroy();
    az.agi().b(537, this.pGV);
    AppMethodBeat.o(24070);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24071);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.pGV.pGX))
    {
      updateOptionMenuText(0, getString(2131755721));
      paramKeyEvent = this.pGV;
      if (paramKeyEvent.pGX)
      {
        paramKeyEvent.pGX = false;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24056);
            ExdeviceManageDeviceUI.this.notifyDataSetChanged();
            AppMethodBeat.o(24056);
          }
        });
      }
      AppMethodBeat.o(24071);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(24071);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */