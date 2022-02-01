package com.tencent.matrix;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class e$1
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    ac.i("Matrix.UISettingHandler", "[onClick] FrameDecorator");
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(ai.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(268435456);
    paramView = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/matrix/MatrixSettingUIHandler$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/matrix/MatrixSettingUIHandler$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.1
 * JD-Core Version:    0.7.0.1
 */