package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ai;
import com.tencent.mm.h.a.ai.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.y;

public final class b$a
  implements f
{
  private String bGm;
  private long bGn;
  private boolean bGo;
  private Context context;
  private int fromScene;
  private ai ibU;
  private int offset;
  private String title;
  
  public b$a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, ai paramai)
  {
    this.context = paramContext;
    this.bGm = paramString1;
    this.bGn = paramLong;
    this.offset = paramInt1;
    this.fromScene = paramInt2;
    this.title = paramString2;
    this.bGo = paramBoolean;
    this.ibU = paramai;
  }
  
  private void et(boolean paramBoolean)
  {
    g.Dk().b(1071, this);
    if ((this.ibU != null) && (this.ibU.bGk.bGp != null))
    {
      this.ibU.bGl.bGq = paramBoolean;
      this.ibU.bGk.bGp.run();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      et(false);
      return;
    }
    if (paramm == null)
    {
      y.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
      et(false);
      return;
    }
    if (paramm.getType() != 1071)
    {
      y.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
      return;
    }
    y.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
    paramString = ((h)paramm).axv();
    if ((paramString == null) || (paramString.kTw == null))
    {
      y.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
      et(false);
      return;
    }
    y.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.sFF });
    paramm = new Intent(this.context, BizSearchDetailPageUI.class);
    paramm.putExtra("addContactScene", 35);
    paramm.putExtra("fromScene", this.fromScene);
    paramm.putExtra("keyword", this.bGm);
    paramm.putExtra("businessType", this.bGn);
    paramm.putExtra("offset", this.offset);
    paramm.putExtra("title", this.title);
    paramm.putExtra("showEditText", this.bGo);
    try
    {
      paramm.putExtra("result", paramString.toByteArray());
      if (!(this.context instanceof Activity)) {
        paramm.addFlags(268435456);
      }
      et(true);
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      et(false);
      y.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b.a
 * JD-Core Version:    0.7.0.1
 */