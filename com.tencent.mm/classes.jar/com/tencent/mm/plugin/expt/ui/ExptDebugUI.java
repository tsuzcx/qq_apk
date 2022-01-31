package com.tencent.mm.plugin.expt.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.a;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class ExptDebugUI
  extends MMActivity
{
  private Button fbO;
  private Button fks;
  private TextView jJa;
  private Button jJb;
  private Button jJc;
  private TextView jJd;
  private TextView jJe;
  private TextView jJf;
  private TextView jJg;
  private TextView jJh;
  private EditText jJi;
  private Button jJj;
  private int jJk = 0;
  
  protected final int getLayoutId()
  {
    return b.c.activity_expt_debug;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle("Expt debug ui");
    setBackBtn(new ExptDebugUI.1(this));
    this.jJa = ((TextView)findViewById(b.b.input_exptId));
    this.fbO = ((Button)findViewById(b.b.confirm_btn));
    this.fbO.setOnClickListener(new ExptDebugUI.2(this));
    this.jJi = ((EditText)findViewById(b.b.expt_xml));
    this.jJj = ((Button)findViewById(b.b.expt_xml_confirm));
    this.jJj.setOnClickListener(new ExptDebugUI.3(this));
    this.jJb = ((Button)findViewById(b.b.expt_picker));
    this.jJb.setOnClickListener(new ExptDebugUI.4(this));
    this.jJc = ((Button)findViewById(b.b.req_expt));
    this.jJc.setOnClickListener(new ExptDebugUI.5(this));
    this.fks = ((Button)findViewById(b.b.expt_del));
    this.fks.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new ArrayList();
        paramAnonymousView.add(Integer.valueOf(ExptDebugUI.c(ExptDebugUI.this)));
        if (a.aMZ().bh(paramAnonymousView) > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ExptDebugUI.d(ExptDebugUI.this).setText(" del :" + ExptDebugUI.c(ExptDebugUI.this) + " " + bool);
          return;
        }
      }
    });
    this.jJd = ((TextView)findViewById(b.b.expt_id));
    this.jJe = ((TextView)findViewById(b.b.group_id));
    this.jJf = ((TextView)findViewById(b.b.expt_seq));
    this.jJg = ((TextView)findViewById(b.b.expt_time));
    this.jJh = ((TextView)findViewById(b.b.expt_args));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI
 * JD-Core Version:    0.7.0.1
 */