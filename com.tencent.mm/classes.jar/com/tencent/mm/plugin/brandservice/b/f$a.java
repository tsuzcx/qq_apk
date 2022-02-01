package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.ad;

public final class f$a
  implements com.tencent.mm.al.g
{
  private Context context;
  private String dcm;
  private long dcn;
  private boolean dco;
  private int fromScene;
  private am mSP;
  private int offset;
  private String title;
  
  public f$a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, am paramam)
  {
    this.context = paramContext;
    this.dcm = paramString1;
    this.dcn = paramLong;
    this.offset = paramInt1;
    this.fromScene = paramInt2;
    this.title = paramString2;
    this.dco = paramBoolean;
    this.mSP = paramam;
  }
  
  private void iy(boolean paramBoolean)
  {
    AppMethodBeat.i(5568);
    com.tencent.mm.kernel.g.aeS().b(1071, this);
    if ((this.mSP != null) && (this.mSP.dck.dcp != null))
    {
      this.mSP.dcl.dcq = paramBoolean;
      this.mSP.dck.dcp.run();
    }
    AppMethodBeat.o(5568);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(5567);
    ad.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      iy(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramn == null)
    {
      ad.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
      iy(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramn.getType() != 1071)
    {
      ad.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
      AppMethodBeat.o(5567);
      return;
    }
    ad.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
    paramString = ((m)paramn).bCs();
    if ((paramString == null) || (paramString.saZ == null))
    {
      ad.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
      iy(false);
      AppMethodBeat.o(5567);
      return;
    }
    ad.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.CNs });
    paramn = new Intent(this.context, BizSearchDetailPageUI.class);
    paramn.putExtra("addContactScene", 35);
    paramn.putExtra("fromScene", this.fromScene);
    paramn.putExtra("keyword", this.dcm);
    paramn.putExtra("businessType", this.dcn);
    paramn.putExtra("offset", this.offset);
    paramn.putExtra("title", this.title);
    paramn.putExtra("showEditText", this.dco);
    try
    {
      paramn.putExtra("result", paramString.toByteArray());
      if (!(this.context instanceof Activity)) {
        paramn.addFlags(268435456);
      }
      iy(true);
      return;
    }
    catch (Exception paramString)
    {
      iy(false);
      ad.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
      return;
    }
    finally
    {
      AppMethodBeat.o(5567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f.a
 * JD-Core Version:    0.7.0.1
 */