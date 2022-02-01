package com.tencent.mm.plugin.brandservice.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.av;
import com.tencent.mm.autogen.a.av.a;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;

public final class f$a
  implements com.tencent.mm.am.h
{
  private long beV;
  private Context context;
  private int fromScene;
  private String hAB;
  private boolean hAC;
  private int offset;
  private String title;
  private av vBS;
  
  public f$a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, av paramav)
  {
    this.context = paramContext;
    this.hAB = paramString1;
    this.beV = paramLong;
    this.offset = paramInt1;
    this.fromScene = paramInt2;
    this.title = paramString2;
    this.hAC = paramBoolean;
    this.vBS = paramav;
  }
  
  private void mO(boolean paramBoolean)
  {
    AppMethodBeat.i(5568);
    com.tencent.mm.kernel.h.aZW().b(1071, this);
    if ((this.vBS != null) && (this.vBS.hAz.hAD != null))
    {
      this.vBS.hAA.hAE = paramBoolean;
      this.vBS.hAz.hAD.run();
    }
    AppMethodBeat.o(5568);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(5567);
    Log.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      mO(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramp == null)
    {
      Log.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
      mO(false);
      AppMethodBeat.o(5567);
      return;
    }
    if (paramp.getType() != 1071)
    {
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
      AppMethodBeat.o(5567);
      return;
    }
    Log.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
    paramString = ((m)paramp).dcn();
    if ((paramString == null) || (paramString.IIU == null))
    {
      Log.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
      mO(false);
      AppMethodBeat.o(5567);
      return;
    }
    Log.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.YYr });
    paramp = new Intent(this.context, BizSearchDetailPageUI.class);
    paramp.putExtra("addContactScene", 35);
    paramp.putExtra("fromScene", this.fromScene);
    paramp.putExtra("keyword", this.hAB);
    paramp.putExtra("businessType", this.beV);
    paramp.putExtra("offset", this.offset);
    paramp.putExtra("title", this.title);
    paramp.putExtra("showEditText", this.hAC);
    try
    {
      paramp.putExtra("result", paramString.toByteArray());
      if (!(this.context instanceof Activity)) {
        paramp.addFlags(268435456);
      }
      mO(true);
      return;
    }
    catch (Exception paramString)
    {
      mO(false);
      Log.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
      return;
    }
    finally
    {
      AppMethodBeat.o(5567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.f.a
 * JD-Core Version:    0.7.0.1
 */