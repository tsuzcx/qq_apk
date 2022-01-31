package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceManageDeviceUI
  extends MMActivity
{
  private ExdeviceManageDeviceUI.a lMZ;
  private ListView mListView;
  
  public int getLayoutId()
  {
    return 2130969459;
  }
  
  public void initView()
  {
    AppMethodBeat.i(19998);
    this.mListView = ((ListView)findViewById(2131821736));
    this.lMZ = new ExdeviceManageDeviceUI.a(this);
    View.inflate(this, 2130969447, null);
    this.mListView.setAdapter(this.lMZ);
    AppMethodBeat.o(19998);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(19999);
    this.lMZ.bt(ad.bpY().bqD());
    this.lMZ.notifyDataSetChanged();
    AppMethodBeat.o(19999);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19997);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceManageDeviceUI.1(this));
    setMMTitle(2131299423);
    paramBundle = new dl();
    paramBundle.cqY.cqZ = true;
    a.ymk.l(paramBundle);
    initView();
    aw.Rc().a(537, this.lMZ);
    AppMethodBeat.o(19997);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20000);
    super.onDestroy();
    aw.Rc().b(537, this.lMZ);
    AppMethodBeat.o(20000);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20001);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (this.lMZ.lNb))
    {
      updateOptionMenuText(0, getString(2131296914));
      paramKeyEvent = this.lMZ;
      if (paramKeyEvent.lNb)
      {
        paramKeyEvent.lNb = false;
        al.d(new ExdeviceManageDeviceUI.a.5(paramKeyEvent));
      }
      AppMethodBeat.o(20001);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(20001);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a$a
  {
    TextView gzk;
    ImageView ivs;
    View lNh;
    View lNi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI
 * JD-Core Version:    0.7.0.1
 */