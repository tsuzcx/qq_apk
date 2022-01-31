package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class IPCallMyGiftCardUI
  extends MMActivity
  implements f
{
  private ProgressDialog gsr;
  private ListView mListView;
  private IPCallMyGiftCardUI.a nTZ;
  private d nUa;
  private View xy;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969941;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22216);
    super.onCreate(paramBundle);
    aw.Rc().a(288, this);
    setMMTitle(2131300927);
    setBackBtn(new IPCallMyGiftCardUI.1(this));
    addTextOptionMenu(0, getContext().getString(2131300925), new IPCallMyGiftCardUI.2(this));
    this.xy = findViewById(2131825301);
    this.mListView = ((ListView)findViewById(2131825300));
    this.nTZ = new IPCallMyGiftCardUI.a(this);
    this.mListView.setAdapter(this.nTZ);
    paramBundle = getContext();
    getString(2131297087);
    this.gsr = h.b(paramBundle, getString(2131300856), true, new IPCallMyGiftCardUI.3(this));
    this.nUa = new d();
    aw.Rc().a(this.nUa, 0);
    AppMethodBeat.o(22216);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22218);
    super.onDestroy();
    aw.Rc().b(288, this);
    AppMethodBeat.o(22218);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22217);
    super.onResume();
    AppMethodBeat.o(22217);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(22219);
    ab.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((d)paramm).nOR;
        if ((this.gsr != null) && (this.gsr.isShowing())) {
          this.gsr.dismiss();
        }
        this.nTZ.nxh = paramString.xhf;
        this.nTZ.nUd = paramString;
        this.nTZ.notifyDataSetChanged();
        if (paramString.xhf.size() == 0) {
          this.xy.setVisibility(0);
        }
        AppMethodBeat.o(22219);
        return;
      }
      if ((this.gsr != null) && (this.gsr.isShowing())) {
        this.gsr.dismiss();
      }
      this.xy.setVisibility(0);
      Toast.makeText(getContext(), getString(2131300853), 0).show();
    }
    AppMethodBeat.o(22219);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI
 * JD-Core Version:    0.7.0.1
 */