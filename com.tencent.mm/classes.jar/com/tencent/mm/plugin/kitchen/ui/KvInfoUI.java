package com.tencent.mm.plugin.kitchen.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI
  extends MMActivity
{
  private c gNn;
  private Button gtF;
  private MMSwitchBtn iDy;
  private ArrayAdapter mcR;
  private EditText nXG;
  private Button nXH;
  private ListView nXI;
  private TextView nXJ;
  private String nXK;
  
  private void RM(String paramString)
  {
    AppMethodBeat.i(114450);
    ab.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", new Object[] { paramString, this.nXK });
    this.nXK = paramString;
    paramString = (List)j.chT().qtl.get(this.nXK);
    if (paramString != null)
    {
      this.nXJ.setText(this.nXK + ":" + paramString.size());
      this.mcR.setNotifyOnChange(false);
      this.mcR.clear();
      this.mcR.addAll(paramString);
      this.mcR.notifyDataSetChanged();
      AppMethodBeat.o(114450);
      return;
    }
    this.nXJ.setText(this.nXK + ":0");
    this.mcR.clear();
    AppMethodBeat.o(114450);
  }
  
  public int getLayoutId()
  {
    return 2130969960;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(114449);
    super.onCreate(paramBundle);
    setMMTitle("Debug show kv log");
    setBackBtn(new KvInfoUI.1(this));
    this.nXG = ((EditText)$(2131825342));
    this.nXJ = ((TextView)$(2131825345));
    this.nXH = ((Button)$(2131825343));
    this.nXH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(114442);
        paramAnonymousView = j.chT().qtl;
        if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
        {
          paramAnonymousView = new ArrayList(paramAnonymousView.keySet());
          b localb = new b(KvInfoUI.this.getContext(), paramAnonymousView);
          localb.Rw(0);
          localb.AIW = new KvInfoUI.2.1(this, localb, paramAnonymousView);
          localb.Rv(a.fromDPToPix(KvInfoUI.this.getContext(), 288));
          localb.show();
        }
        AppMethodBeat.o(114442);
      }
    });
    this.iDy = ((MMSwitchBtn)$(2131825344));
    this.iDy.setCheck(j.chT().qrC);
    this.iDy.setSwitchListener(new KvInfoUI.3(this));
    this.gtF = ((Button)$(2131821015));
    this.gtF.setOnClickListener(new KvInfoUI.4(this));
    this.nXI = ((ListView)$(2131825346));
    this.mcR = new KvInfoUI.5(this, this);
    this.nXI.setAdapter(this.mcR);
    this.nXI.setOnItemClickListener(new KvInfoUI.6(this));
    AppMethodBeat.o(114449);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114451);
    if (this.mcR != null)
    {
      this.mcR.setNotifyOnChange(false);
      this.mcR.clear();
    }
    if (this.gNn != null) {
      this.gNn.dismiss();
    }
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(114451);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(114452);
    if (!bo.isNullOrNil(this.nXK)) {
      RM(this.nXK);
    }
    super.onResume();
    AppMethodBeat.o(114452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI
 * JD-Core Version:    0.7.0.1
 */