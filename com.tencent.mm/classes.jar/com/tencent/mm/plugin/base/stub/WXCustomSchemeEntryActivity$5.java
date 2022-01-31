package com.tencent.mm.plugin.base.stub;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class WXCustomSchemeEntryActivity$5
  implements e.a
{
  WXCustomSchemeEntryActivity$5(WXCustomSchemeEntryActivity paramWXCustomSchemeEntryActivity) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(153503);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof com.tencent.mm.modelsimple.ab)))
    {
      paramString = ((com.tencent.mm.modelsimple.ab)paramm).ajY();
      if ((paramString != null) && (!this.jMj.isFinishing())) {
        t.makeText(this.jMj, this.jMj.getString(2131297087) + " : " + bo.nullAsNil(paramString.xVH), 0).show();
      }
    }
    this.jMj.finish();
    AppMethodBeat.o(153503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity.5
 * JD-Core Version:    0.7.0.1
 */