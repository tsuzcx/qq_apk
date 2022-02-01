package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.a;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.sdk.platformtools.ac;

public final class e$a
  implements com.tencent.mm.ak.g
{
  private String cZL;
  private long cZM;
  private boolean cZN;
  private Context context;
  private int fromScene;
  private an nvh;
  private int offset;
  private String title;
  
  public e$a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, an paraman)
  {
    this.context = paramContext;
    this.cZL = paramString1;
    this.cZM = paramLong;
    this.offset = paramInt1;
    this.fromScene = paramInt2;
    this.title = paramString2;
    this.cZN = paramBoolean;
    this.nvh = paraman;
  }
  
  private void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(5568);
    com.tencent.mm.kernel.g.agi().b(1071, this);
    if ((this.nvh != null) && (this.nvh.cZJ.cZO != null))
    {
      this.nvh.cZK.cZP = paramBoolean;
      this.nvh.cZJ.cZO.run();
    }
    AppMethodBeat.o(5568);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(5567);
    ac.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      jb(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramn == null)
    {
      ac.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
      jb(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramn.getType() != 1071)
    {
      ac.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
      AppMethodBeat.o(5567);
      return;
    }
    ac.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
    paramString = ((l)paramn).bJv();
    if ((paramString == null) || (paramString.tiT == null))
    {
      ac.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
      jb(false);
      AppMethodBeat.o(5567);
      return;
    }
    ac.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.EfU });
    paramn = new Intent(this.context, BizSearchDetailPageUI.class);
    paramn.putExtra("addContactScene", 35);
    paramn.putExtra("fromScene", this.fromScene);
    paramn.putExtra("keyword", this.cZL);
    paramn.putExtra("businessType", this.cZM);
    paramn.putExtra("offset", this.offset);
    paramn.putExtra("title", this.title);
    paramn.putExtra("showEditText", this.cZN);
    try
    {
      paramn.putExtra("result", paramString.toByteArray());
      if (!(this.context instanceof Activity)) {
        paramn.addFlags(268435456);
      }
      jb(true);
      return;
    }
    catch (Exception paramString)
    {
      jb(false);
      ac.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
      return;
    }
    finally
    {
      AppMethodBeat.o(5567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e.a
 * JD-Core Version:    0.7.0.1
 */