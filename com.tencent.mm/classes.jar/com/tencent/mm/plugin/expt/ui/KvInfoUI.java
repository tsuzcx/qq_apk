package com.tencent.mm.plugin.expt.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI
  extends MMActivity
{
  private Button kEt;
  private d nnz;
  private ArrayAdapter wqR;
  private EditText wrN;
  private Button wrO;
  private ListView wrP;
  private TextView wrQ;
  private MMSwitchBtn wrR;
  private String wrS;
  
  private void azm(String paramString)
  {
    AppMethodBeat.i(255785);
    Log.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", new Object[] { paramString, this.wrS });
    this.wrS = paramString;
    paramString = (List)com.tencent.mm.plugin.expt.e.a.dga().wpO.get(this.wrS);
    if (paramString != null)
    {
      this.wrQ.setText(this.wrS + ":" + paramString.size());
      this.wqR.setNotifyOnChange(false);
      this.wqR.clear();
      this.wqR.addAll(paramString);
      this.wqR.notifyDataSetChanged();
      AppMethodBeat.o(255785);
      return;
    }
    this.wrQ.setText(this.wrS + ":0");
    this.wqR.clear();
    AppMethodBeat.o(255785);
  }
  
  public int getLayoutId()
  {
    return b.d.kv_info_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255782);
    super.onCreate(paramBundle);
    setMMTitle("Debug show kv log");
    setBackBtn(new KvInfoUI.1(this));
    this.wrN = ((EditText)$(b.c.input_log));
    this.wrQ = ((TextView)$(b.c.select_id_info));
    this.wrO = ((Button)$(b.c.log_picker));
    this.wrO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(252148);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.plugin.expt.e.a.dga().wpO;
        if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
        {
          paramAnonymousView = new ArrayList(paramAnonymousView.keySet());
          localObject = new com.tencent.mm.ui.widget.picker.b(KvInfoUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.b)localObject).ayK(0);
          ((com.tencent.mm.ui.widget.picker.b)localObject).YrN = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(251924);
              this.rHY.hide();
              int i = this.rHY.idp();
              paramAnonymous2Object1 = (String)paramAnonymousView.get(i);
              KvInfoUI.a(KvInfoUI.this, paramAnonymous2Object1);
              AppMethodBeat.o(251924);
            }
          };
          ((com.tencent.mm.ui.widget.picker.b)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252148);
      }
    });
    this.wrR = ((MMSwitchBtn)$(b.c.debug_flag));
    this.wrR.setCheck(com.tencent.mm.plugin.expt.e.a.dga().wpN);
    this.wrR.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(255107);
        com.tencent.mm.plugin.expt.e.a.dga().wpN = paramAnonymousBoolean;
        AppMethodBeat.o(255107);
      }
    });
    this.kEt = ((Button)$(b.c.confirm_btn));
    this.kEt.setOnClickListener(new KvInfoUI.4(this));
    this.wrP = ((ListView)$(b.c.kv_log_list));
    this.wqR = new ArrayAdapter(this, b.d.kv_info_ui_item, b.c.kv_info_ui_tv)
    {
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        AppMethodBeat.i(256645);
        paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        paramAnonymousViewGroup = (com.tencent.mm.plugin.expt.e.b)KvInfoUI.b(KvInfoUI.this).getItem(paramAnonymousInt);
        TextView localTextView = (TextView)paramAnonymousView.findViewById(b.c.kv_info_ui_tv);
        if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.wpT)) {
          localTextView.setBackgroundResource(b.a.wechat_green);
        }
        for (;;)
        {
          AppMethodBeat.o(256645);
          return paramAnonymousView;
          localTextView.setBackgroundResource(b.a.transparent);
        }
      }
    };
    this.wrP.setAdapter(this.wqR);
    AppMethodBeat.o(255782);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(255788);
    if (this.wqR != null)
    {
      this.wqR.setNotifyOnChange(false);
      this.wqR.clear();
    }
    if (this.nnz != null) {
      this.nnz.dismiss();
    }
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(255788);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(255790);
    if (!Util.isNullOrNil(this.wrS)) {
      azm(this.wrS);
    }
    super.onResume();
    AppMethodBeat.o(255790);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.KvInfoUI
 * JD-Core Version:    0.7.0.1
 */