package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class f$1
  implements q.f
{
  f$1(int paramInt, Context paramContext) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(128018);
    if ((this.ncT & 0x1) != 0) {
      paramo.d(1, this.val$context.getString(r.j.reg_forgetpwd_byqq));
    }
    if ((this.ncT & 0x2) != 0) {
      paramo.d(2, this.val$context.getString(r.j.reg_forgetpwd_weixin));
    }
    if ((this.ncT & 0x4) != 0) {
      paramo.d(4, this.val$context.getString(r.j.reg_forgetpwd_bymobile));
    }
    if ((this.ncT & 0x8) > 0) {
      paramo.d(8, this.val$context.getString(r.j.wechat_safe_center));
    }
    AppMethodBeat.o(128018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f.1
 * JD-Core Version:    0.7.0.1
 */