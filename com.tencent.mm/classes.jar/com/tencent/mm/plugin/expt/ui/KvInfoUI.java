package com.tencent.mm.plugin.expt.ui;

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
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI
  extends MMActivity
{
  private Button nhC;
  private e qkG;
  private ArrayAdapter zMT;
  private EditText zNT;
  private Button zNU;
  private ListView zNV;
  private TextView zNW;
  private MMSwitchBtn zNX;
  private String zNY;
  
  private void att(String paramString)
  {
    AppMethodBeat.i(299600);
    Log.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", new Object[] { paramString, this.zNY });
    this.zNY = paramString;
    paramString = (List)com.tencent.mm.plugin.expt.kvdebug.a.dMK().zLR.get(this.zNY);
    if (paramString != null)
    {
      this.zNW.setText(this.zNY + ":" + paramString.size());
      this.zMT.setNotifyOnChange(false);
      this.zMT.clear();
      this.zMT.addAll(paramString);
      this.zMT.notifyDataSetChanged();
      AppMethodBeat.o(299600);
      return;
    }
    this.zNW.setText(this.zNY + ":0");
    this.zMT.clear();
    AppMethodBeat.o(299600);
  }
  
  public int getLayoutId()
  {
    return b.d.kv_info_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299629);
    super.onCreate(paramBundle);
    setMMTitle("Debug show kv log");
    setBackBtn(new KvInfoUI.1(this));
    this.zNT = ((EditText)$(b.c.input_log));
    this.zNW = ((TextView)$(b.c.select_id_info));
    this.zNU = ((Button)$(b.c.log_picker));
    this.zNU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(299604);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = com.tencent.mm.plugin.expt.kvdebug.a.dMK().zLR;
        if ((paramAnonymousView != null) && (paramAnonymousView.size() > 0))
        {
          paramAnonymousView = new ArrayList(paramAnonymousView.keySet());
          localObject = new com.tencent.mm.ui.widget.picker.b(KvInfoUI.this.getContext(), paramAnonymousView);
          ((com.tencent.mm.ui.widget.picker.b)localObject).aFq(0);
          ((com.tencent.mm.ui.widget.picker.b)localObject).agkc = new b.b()
          {
            public final void onResult(boolean paramAnonymous2Boolean, Object paramAnonymous2Object1, Object paramAnonymous2Object2)
            {
              AppMethodBeat.i(299608);
              this.uTn.hide();
              int i = this.uTn.jIz();
              paramAnonymous2Object1 = (String)paramAnonymousView.get(i);
              KvInfoUI.a(KvInfoUI.this, paramAnonymous2Object1);
              AppMethodBeat.o(299608);
            }
          };
          ((com.tencent.mm.ui.widget.picker.b)localObject).show();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/KvInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(299604);
      }
    });
    this.zNX = ((MMSwitchBtn)$(b.c.debug_flag));
    this.zNX.setCheck(com.tencent.mm.plugin.expt.kvdebug.a.dMK().zLQ);
    this.zNX.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(299601);
        com.tencent.mm.plugin.expt.kvdebug.a.dMK().zLQ = paramAnonymousBoolean;
        AppMethodBeat.o(299601);
      }
    });
    this.nhC = ((Button)$(b.c.confirm_btn));
    this.nhC.setOnClickListener(new KvInfoUI.4(this));
    this.zNV = ((ListView)$(b.c.kv_log_list));
    this.zMT = new ArrayAdapter(this, b.d.kv_info_ui_item, b.c.kv_info_ui_tv)
    {
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        AppMethodBeat.i(299597);
        paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
        paramAnonymousViewGroup = (com.tencent.mm.plugin.expt.kvdebug.b)KvInfoUI.b(KvInfoUI.this).getItem(paramAnonymousInt);
        TextView localTextView = (TextView)paramAnonymousView.findViewById(b.c.kv_info_ui_tv);
        if ((paramAnonymousViewGroup != null) && (paramAnonymousViewGroup.zLW)) {
          localTextView.setBackgroundResource(b.a.wechat_green);
        }
        for (;;)
        {
          AppMethodBeat.o(299597);
          return paramAnonymousView;
          localTextView.setBackgroundResource(b.a.transparent);
        }
      }
    };
    this.zNV.setAdapter(this.zMT);
    AppMethodBeat.o(299629);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(299643);
    if (this.zMT != null)
    {
      this.zMT.setNotifyOnChange(false);
      this.zMT.clear();
    }
    if (this.qkG != null) {
      this.qkG.dismiss();
    }
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(299643);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(299651);
    if (!Util.isNullOrNil(this.zNY)) {
      att(this.zNY);
    }
    super.onResume();
    AppMethodBeat.o(299651);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.KvInfoUI
 * JD-Core Version:    0.7.0.1
 */