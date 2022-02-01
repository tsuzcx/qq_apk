package com.tencent.mm.plugin.expt.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;

public class ExptDebugUI
  extends MMActivity
{
  private Button nhC;
  private Button pYm;
  private Button zNA;
  private TextView zNB;
  private TextView zNC;
  private TextView zND;
  private TextView zNE;
  private TextView zNF;
  private EditText zNG;
  private Button zNH;
  private Button zNI;
  private int zNJ = 0;
  private TextView zNx;
  private Button zNy;
  
  public int getLayoutId()
  {
    return b.d.activity_expt_debug;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122477);
    super.onCreate(paramBundle);
    setMMTitle("Expt debug ui");
    setBackBtn(new ExptDebugUI.1(this));
    this.zNx = ((TextView)$(b.c.input_exptId));
    this.nhC = ((Button)$(b.c.confirm_btn));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122471);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = ExptDebugUI.a(ExptDebugUI.this).getText().toString().trim();
        ExptDebugUI.a(ExptDebugUI.this, Util.getInt(paramAnonymousView, 0));
        f.Ozc.kvStat(9999, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122471);
      }
    });
    this.zNG = ((EditText)$(b.c.expt_xml));
    this.zNH = ((Button)$(b.c.expt_xml_confirm));
    this.zNH.setOnClickListener(new ExptDebugUI.3(this));
    this.zNy = ((Button)$(b.c.expt_picker));
    this.zNy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(122474);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = com.tencent.mm.plugin.expt.model.a.dMQ().dMS();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new com.tencent.mm.ui.widget.picker.b(ExptDebugUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.b)localObject).aFq(0);
          ((com.tencent.mm.ui.widget.picker.b)localObject).agkc = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(122473);
              this.uTn.hide();
              int i = this.uTn.jIz();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptDebugUI.a(ExptDebugUI.this, Util.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(122473);
            }
          };
          ((com.tencent.mm.ui.widget.picker.b)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(122474);
      }
    });
    this.zNA = ((Button)$(b.c.req_expt));
    this.zNA.setOnClickListener(new ExptDebugUI.5(this));
    this.pYm = ((Button)$(b.c.expt_del));
    this.pYm.setOnClickListener(new ExptDebugUI.6(this));
    this.zNI = ((Button)$(b.c.expt_export));
    this.zNI.setOnClickListener(new ExptDebugUI.7(this));
    this.zNB = ((TextView)$(b.c.expt_id));
    this.zNC = ((TextView)$(b.c.group_id));
    this.zND = ((TextView)$(b.c.expt_seq));
    this.zNE = ((TextView)$(b.c.expt_time));
    this.zNF = ((TextView)$(b.c.expt_args));
    AppMethodBeat.o(122477);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI
 * JD-Core Version:    0.7.0.1
 */