package com.tencent.mm.plugin.kitchen.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.kitchen.b.a;
import com.tencent.mm.plugin.kitchen.b.b;
import com.tencent.mm.plugin.report.service.d;

final class KvInfoUI$5
  extends ArrayAdapter
{
  KvInfoUI$5(KvInfoUI paramKvInfoUI, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (d)KvInfoUI.b(this.lAA).getItem(paramInt);
    TextView localTextView = (TextView)paramView.findViewById(b.b.kv_info_ui_tv);
    if ((paramViewGroup != null) && (paramViewGroup.nFx))
    {
      localTextView.setBackgroundResource(b.a.wechat_green);
      return paramView;
    }
    localTextView.setBackgroundResource(b.a.transparent);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.5
 * JD-Core Version:    0.7.0.1
 */