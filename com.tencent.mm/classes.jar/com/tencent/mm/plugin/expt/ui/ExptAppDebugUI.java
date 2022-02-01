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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import java.util.List;

public class ExptAppDebugUI
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
  private Button zNz;
  
  public int getLayoutId()
  {
    return b.d.activity_expt_app_debug;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299618);
    super.onCreate(paramBundle);
    setMMTitle("Expt App debug ui");
    setBackBtn(new ExptAppDebugUI.1(this));
    this.zNx = ((TextView)$(b.c.input_exptId));
    this.nhC = ((Button)$(b.c.confirm_btn));
    this.nhC.setOnClickListener(new ExptAppDebugUI.2(this));
    this.zNG = ((EditText)$(b.c.expt_xml));
    this.zNG.setVisibility(8);
    this.zNH = ((Button)$(b.c.expt_xml_confirm));
    this.zNH.setVisibility(8);
    this.zNy = ((Button)$(b.c.expt_picker));
    this.zNy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(299592);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        com.tencent.mm.plugin.expt.model.a.dMQ();
        localObject = com.tencent.mm.plugin.expt.model.a.dMU();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          paramAnonymousView = new String[((ArrayList)localObject).size()];
          int i = 0;
          while (i < paramAnonymousView.length)
          {
            paramAnonymousView[i] = ((ArrayList)localObject).get(i);
            i += 1;
          }
          localObject = new com.tencent.mm.ui.widget.picker.b(ExptAppDebugUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.b)localObject).aFq(0);
          ((com.tencent.mm.ui.widget.picker.b)localObject).agkc = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(299586);
              this.uTn.hide();
              int i = this.uTn.jIz();
              paramAnonymous2Object1 = paramAnonymousView[i];
              ExptAppDebugUI.a(ExptAppDebugUI.this, Util.getInt(paramAnonymous2Object1, 0));
              AppMethodBeat.o(299586);
            }
          };
          ((com.tencent.mm.ui.widget.picker.b)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(299592);
      }
    });
    this.zNz = ((Button)$(b.c.report_msg));
    this.zNz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(299589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.expt.a.a.dHH();
        com.tencent.mm.plugin.expt.a.a.dHI();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(299589);
      }
    });
    this.zNA = ((Button)$(b.c.req_expt));
    this.zNA.setOnClickListener(new ExptAppDebugUI.5(this));
    this.pYm = ((Button)$(b.c.expt_del));
    this.pYm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(299588);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptAppDebugUI.b(ExptAppDebugUI.this)));
        com.tencent.mm.plugin.expt.model.a.dMQ();
        com.tencent.mm.plugin.expt.model.a.b(0, paramAnonymousView, null);
        com.tencent.mm.plugin.expt.model.a.dMQ();
        com.tencent.mm.plugin.expt.model.a.pd(true);
        ExptAppDebugUI.c(ExptAppDebugUI.this).setText(" del :" + ExptAppDebugUI.b(ExptAppDebugUI.this) + " true");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(299588);
      }
    });
    this.zNI = ((Button)$(b.c.expt_export));
    this.zNI.setVisibility(8);
    this.zNB = ((TextView)$(b.c.expt_id));
    this.zNC = ((TextView)$(b.c.group_id));
    this.zND = ((TextView)$(b.c.expt_seq));
    this.zNE = ((TextView)$(b.c.expt_time));
    this.zNF = ((TextView)$(b.c.expt_args));
    AppMethodBeat.o(299618);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptAppDebugUI
 * JD-Core Version:    0.7.0.1
 */