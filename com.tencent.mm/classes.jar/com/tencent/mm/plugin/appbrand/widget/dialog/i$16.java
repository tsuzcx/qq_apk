package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.fsp;
import com.tencent.mm.sdk.platformtools.Log;

public final class i$16
  implements View.OnClickListener
{
  public i$16(i parami, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49880);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (this.uCF.uCS != null)
    {
      int i = (int)this.uCF.uCS.getRating();
      paramView = this.uCF;
      localObject = new fsp();
      ((fsp)localObject).username = paramView.userName;
      ((fsp)localObject).abRe = 3;
      ((fsp)localObject).abRf = new aoe();
      ((fsp)localObject).abRf.score = i;
      paramView.uCR = i;
      Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateScore, userName:%s, score:%d", new Object[] { paramView.userName, Integer.valueOf(i) });
      paramView.a((fsp)localObject);
      Toast.makeText(this.val$context, this.val$context.getString(ba.i.app_brand_evaluate_dialog_submited), 0).show();
      this.uCF.uCN = true;
      this.uCF.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandEvaluateDialogHelper$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(49880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.16
 * JD-Core Version:    0.7.0.1
 */