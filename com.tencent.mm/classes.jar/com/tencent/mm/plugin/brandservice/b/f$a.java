package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ar;
import com.tencent.mm.f.a.ar.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.Log;

public final class f$a
  implements i
{
  private Context context;
  private int fromScene;
  private String fwe;
  private long fwf;
  private boolean fwg;
  private int offset;
  private ar swl;
  private String title;
  
  public f$a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, ar paramar)
  {
    this.context = paramContext;
    this.fwe = paramString1;
    this.fwf = paramLong;
    this.offset = paramInt1;
    this.fromScene = paramInt2;
    this.title = paramString2;
    this.fwg = paramBoolean;
    this.swl = paramar;
  }
  
  private void lw(boolean paramBoolean)
  {
    AppMethodBeat.i(5568);
    h.aGY().b(1071, this);
    if ((this.swl != null) && (this.swl.fwc.fwh != null))
    {
      this.swl.fwd.fwi = paramBoolean;
      this.swl.fwc.fwh.run();
    }
    AppMethodBeat.o(5568);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(5567);
    Log.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      lw(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
      lw(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramq.getType() != 1071)
    {
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
      AppMethodBeat.o(5567);
      return;
    }
    Log.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
    paramString = ((m)paramq).czv();
    if ((paramString == null) || (paramString.COK == null))
    {
      Log.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
      lw(false);
      AppMethodBeat.o(5567);
      return;
    }
    Log.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.Sas });
    paramq = new Intent(this.context, BizSearchDetailPageUI.class);
    paramq.putExtra("addContactScene", 35);
    paramq.putExtra("fromScene", this.fromScene);
    paramq.putExtra("keyword", this.fwe);
    paramq.putExtra("businessType", this.fwf);
    paramq.putExtra("offset", this.offset);
    paramq.putExtra("title", this.title);
    paramq.putExtra("showEditText", this.fwg);
    try
    {
      paramq.putExtra("result", paramString.toByteArray());
      if (!(this.context instanceof Activity)) {
        paramq.addFlags(268435456);
      }
      lw(true);
      return;
    }
    catch (Exception paramString)
    {
      lw(false);
      Log.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
      return;
    }
    finally
    {
      AppMethodBeat.o(5567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f.a
 * JD-Core Version:    0.7.0.1
 */