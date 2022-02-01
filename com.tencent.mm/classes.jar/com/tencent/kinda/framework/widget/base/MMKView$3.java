package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback;
import com.tencent.kinda.gen.KViewOnClickCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.a.a.a;
import java.lang.ref.WeakReference;

class MMKView$3
  implements View.OnClickListener
{
  private byte _hellAccFlag_;
  
  MMKView$3(MMKView paramMMKView) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(226610);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (MMKView.access$500(this.this$0) != null) {
      MMKView.access$500(this.this$0).onClick(this.this$0);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226610);
      return;
      paramView = (MMKView)MMKView.access$600(this.this$0).get();
      if ((paramView == null) || (!a.a.jlv().jls()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/MMKView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226610);
        return;
      }
      if ((paramView instanceof MMKRichLabelView))
      {
        localObject = (MMKRichLabelView)paramView;
        if (((MMKRichLabelView)localObject).linkCallback != null) {
          ((MMKRichLabelView)localObject).linkCallback.call();
        } else if (MMKView.access$500(paramView) != null) {
          MMKView.access$500(paramView).onClick(paramView);
        }
      }
      else if ((paramView instanceof KindaSwitchViewImpl))
      {
        paramView = (KindaSwitchViewImpl)paramView;
        if (paramView.onChangeSwitchCallback != null) {
          paramView.onChangeSwitchCallback.onChangeSwitch();
        }
      }
      else if (MMKView.access$500(paramView) != null)
      {
        MMKView.access$500(paramView).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKView.3
 * JD-Core Version:    0.7.0.1
 */