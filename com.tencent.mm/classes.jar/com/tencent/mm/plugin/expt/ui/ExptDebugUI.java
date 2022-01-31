package com.tencent.mm.plugin.expt.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExptDebugUI
  extends MMActivity
{
  private Button gBJ;
  private Button gtF;
  private TextView mde;
  private Button mdf;
  private Button mdg;
  private TextView mdh;
  private TextView mdi;
  private TextView mdj;
  private TextView mdk;
  private TextView mdl;
  private EditText mdm;
  private Button mdn;
  private int mdo = 0;
  
  public int getLayoutId()
  {
    return 2130968625;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73639);
    super.onCreate(paramBundle);
    setMMTitle("Expt debug ui");
    setBackBtn(new ExptDebugUI.1(this));
    this.mde = ((TextView)$(2131821014));
    this.gtF = ((Button)$(2131821015));
    this.gtF.setOnClickListener(new ExptDebugUI.2(this));
    this.mdm = ((EditText)$(2131821024));
    this.mdn = ((Button)$(2131821025));
    this.mdn.setOnClickListener(new ExptDebugUI.3(this));
    this.mdf = ((Button)$(2131821016));
    this.mdf.setOnClickListener(new ExptDebugUI.4(this));
    this.mdg = ((Button)$(2131821017));
    this.mdg.setOnClickListener(new ExptDebugUI.5(this));
    this.gBJ = ((Button)$(2131821018));
    this.gBJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(73638);
        paramAnonymousView = com.tencent.mm.plugin.expt.b.a.bsG().vu(ExptDebugUI.c(ExptDebugUI.this));
        if ((paramAnonymousView != null) && (paramAnonymousView.btc()))
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
          com.tencent.mm.plugin.expt.b.a.bsG();
          com.tencent.mm.plugin.expt.b.a.a(null, null, localLinkedList);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.btd()))
        {
          com.tencent.mm.plugin.expt.b.a.bsG();
          com.tencent.mm.plugin.expt.b.a.e("", false, true);
        }
        if ((paramAnonymousView != null) && (paramAnonymousView.bte()))
        {
          com.tencent.mm.plugin.expt.b.a.bsG();
          com.tencent.mm.plugin.expt.b.a.aJ("", true);
        }
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
        if (com.tencent.mm.plugin.expt.b.a.bsG().by(paramAnonymousView) > 0) {}
        for (;;)
        {
          ExptDebugUI.d(ExptDebugUI.this).setText(" del :" + ExptDebugUI.c(ExptDebugUI.this) + " " + bool);
          AppMethodBeat.o(73638);
          return;
          bool = false;
        }
      }
    });
    this.mdh = ((TextView)$(2131821019));
    this.mdi = ((TextView)$(2131821020));
    this.mdj = ((TextView)$(2131821021));
    this.mdk = ((TextView)$(2131821022));
    this.mdl = ((TextView)$(2131821023));
    AppMethodBeat.o(73639);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI
 * JD-Core Version:    0.7.0.1
 */