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
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.g.a.b;

public class HoneyPayCardManagerUI$a
  extends MMBaseAccessibilityConfig
{
  public HoneyPayCardManagerUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public final void fPC()
  {
    AppMethodBeat.i(267343);
    h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267314);
        ViewGroup localViewGroup = (ViewGroup)HoneyPayCardManagerUI.a.this.findViewById(a.f.hpcs_top_layout);
        if (localViewGroup != null) {
          localViewGroup.sendAccessibilityEvent(8);
        }
        AppMethodBeat.o(267314);
      }
    }, 300L);
    AppMethodBeat.o(267343);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(267341);
    root(a.f.hpcs_header_layout).view(a.f.hpcs_payway_layout).desc(HoneyPayCardManagerUI.a..ExternalSyntheticLambda0.INSTANCE).type(ViewType.Button);
    root(a.g.honey_pay_card_setting_item_layout).view(a.f.hpci_item_layout).desc(new b() {}).type(ViewType.Button);
    root(a.g.honey_pay_card_setting_footer_more_layout).view(a.f.hpcm_more_footer_layout).desc(a.i.honey_pay_card_manager_no_record_text).type(ViewType.Button);
    AppMethodBeat.o(267341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.a
 * JD-Core Version:    0.7.0.1
 */