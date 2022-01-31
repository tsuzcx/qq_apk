package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.platformtools.ab;

public final class f$6
  implements View.OnClickListener
{
  public f$6(f paramf, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134258);
    if (this.jjB.jjx != null)
    {
      int i = (int)this.jjB.jjx.getRating();
      paramView = this.jjB;
      cnl localcnl = new cnl();
      localcnl.username = paramView.userName;
      localcnl.xWx = 3;
      localcnl.xWy = new aaa();
      localcnl.xWy.score = i;
      paramView.jjv = i;
      ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateScore, userName:%s, score:%d", new Object[] { paramView.userName, Integer.valueOf(i) });
      paramView.a(localcnl);
      Toast.makeText(this.val$context, this.val$context.getString(2131296636), 0).show();
      this.jjB.jju = true;
      this.jjB.dismiss();
    }
    AppMethodBeat.o(134258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.6
 * JD-Core Version:    0.7.0.1
 */