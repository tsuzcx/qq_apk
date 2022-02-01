package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.ae;

public final class e$a
  implements f
{
  private Context context;
  private String dmf;
  private long dmg;
  private boolean dmh;
  private int fromScene;
  private an oco;
  private int offset;
  private String title;
  
  public e$a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, an paraman)
  {
    this.context = paramContext;
    this.dmf = paramString1;
    this.dmg = paramLong;
    this.offset = paramInt1;
    this.fromScene = paramInt2;
    this.title = paramString2;
    this.dmh = paramBoolean;
    this.oco = paraman;
  }
  
  private void jl(boolean paramBoolean)
  {
    AppMethodBeat.i(5568);
    g.ajj().b(1071, this);
    if ((this.oco != null) && (this.oco.dmd.dmi != null))
    {
      this.oco.dme.dmj = paramBoolean;
      this.oco.dmd.dmi.run();
    }
    AppMethodBeat.o(5568);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(5567);
    ae.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      jl(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramn == null)
    {
      ae.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
      jl(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramn.getType() != 1071)
    {
      ae.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
      AppMethodBeat.o(5567);
      return;
    }
    ae.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
    paramString = ((l)paramn).bOL();
    if ((paramString == null) || (paramString.usl == null))
    {
      ae.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
      jl(false);
      AppMethodBeat.o(5567);
      return;
    }
    ae.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.GeS });
    paramn = new Intent(this.context, BizSearchDetailPageUI.class);
    paramn.putExtra("addContactScene", 35);
    paramn.putExtra("fromScene", this.fromScene);
    paramn.putExtra("keyword", this.dmf);
    paramn.putExtra("businessType", this.dmg);
    paramn.putExtra("offset", this.offset);
    paramn.putExtra("title", this.title);
    paramn.putExtra("showEditText", this.dmh);
    try
    {
      paramn.putExtra("result", paramString.toByteArray());
      if (!(this.context instanceof Activity)) {
        paramn.addFlags(268435456);
      }
      jl(true);
      return;
    }
    catch (Exception paramString)
    {
      jl(false);
      ae.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
      return;
    }
    finally
    {
      AppMethodBeat.o(5567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e.a
 * JD-Core Version:    0.7.0.1
 */