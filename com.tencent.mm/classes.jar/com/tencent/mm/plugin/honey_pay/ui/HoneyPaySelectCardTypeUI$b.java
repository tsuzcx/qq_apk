package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.g.a.b;

public class HoneyPaySelectCardTypeUI$b
  extends MMBaseAccessibilityConfig
{
  public HoneyPaySelectCardTypeUI$b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(267319);
    root(a.f.hpsc_top_layout).view(a.f.hpsc_layout).desc(new b() {}).type(ViewType.Button);
    focusFirst(a.f.hpsc_header_maintitle);
    h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267362);
        TextView localTextView = (TextView)HoneyPaySelectCardTypeUI.b.this.findViewById(a.f.hpsc_header_maintitle);
        if (localTextView != null) {
          localTextView.sendAccessibilityEvent(8);
        }
        AppMethodBeat.o(267362);
      }
    }, 300L);
    AppMethodBeat.o(267319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.b
 * JD-Core Version:    0.7.0.1
 */