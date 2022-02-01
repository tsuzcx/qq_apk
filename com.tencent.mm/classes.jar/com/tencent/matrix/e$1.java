package com.tencent.matrix;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class e$1
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/matrix/MatrixSettingUIHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.i("Matrix.UISettingHandler", "[onClick] FrameDecorator");
    localObject = new Intent();
    ((Intent)localObject).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(268435456);
    paramView = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/matrix/MatrixSettingUIHandler$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/matrix/MatrixSettingUIHandler$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/matrix/MatrixSettingUIHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.1
 * JD-Core Version:    0.7.0.1
 */