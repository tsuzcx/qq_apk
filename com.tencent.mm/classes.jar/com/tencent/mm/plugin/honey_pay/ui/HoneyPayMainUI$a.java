package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.g.a.b;

public class HoneyPayMainUI$a
  extends MMBaseAccessibilityConfig
{
  public HoneyPayMainUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(267349);
    root(a.g.honey_pay_main_ui).view(a.f.hpou_empty_header_tv).desc(a.f.hpou_empty_header_tv).type(ViewType.Button);
    root(a.f.hpmu_content_layout).view(a.f.hpcl_layout).desc(new b() {}).type(ViewType.Button);
    root(a.f.hpou_root_view).view(a.f.hpou_add_friend_layout).desc(a.f.hpou_add_friend_tv).type(ViewType.Button);
    AppMethodBeat.o(267349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.a
 * JD-Core Version:    0.7.0.1
 */