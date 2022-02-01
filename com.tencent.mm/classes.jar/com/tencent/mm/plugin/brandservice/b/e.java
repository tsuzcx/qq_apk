package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class e
{
  public static chl clJ()
  {
    AppMethodBeat.i(5569);
    try
    {
      g.aAi();
      Object localObject = (String)g.aAh().azQ().get(67591, null);
      if (localObject != null)
      {
        chl localchl = new chl();
        localObject = ((String)localObject).split(",");
        localchl.LuT = Integer.valueOf(localObject[0]).intValue();
        localchl.LuW = Integer.valueOf(localObject[1]).intValue();
        localchl.LbD = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localchl.LbC = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localchl.LbD), Float.valueOf(localchl.LbC) });
        AppMethodBeat.o(5569);
        return localchl;
      }
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(5569);
      return null;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(5569);
    }
    return null;
  }
  
  public static final class a
    implements i
  {
    private Context context;
    private String dDv;
    private long dDw;
    private boolean dDx;
    private int fromScene;
    private int offset;
    private ap pnn;
    private String title;
    
    public a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, ap paramap)
    {
      this.context = paramContext;
      this.dDv = paramString1;
      this.dDw = paramLong;
      this.offset = paramInt1;
      this.fromScene = paramInt2;
      this.title = paramString2;
      this.dDx = paramBoolean;
      this.pnn = paramap;
    }
    
    private void kk(boolean paramBoolean)
    {
      AppMethodBeat.i(5568);
      g.azz().b(1071, this);
      if ((this.pnn != null) && (this.pnn.dDt.dDy != null))
      {
        this.pnn.dDu.dDz = paramBoolean;
        this.pnn.dDt.dDy.run();
      }
      AppMethodBeat.o(5568);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(5567);
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        kk(false);
        AppMethodBeat.o(5567);
        return;
      }
      if (paramq == null)
      {
        Log.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
        kk(false);
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
      paramString = ((l)paramq).clR();
      if ((paramString == null) || (paramString.xKD == null))
      {
        Log.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
        kk(false);
        AppMethodBeat.o(5567);
        return;
      }
      Log.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.KZj });
      paramq = new Intent(this.context, BizSearchDetailPageUI.class);
      paramq.putExtra("addContactScene", 35);
      paramq.putExtra("fromScene", this.fromScene);
      paramq.putExtra("keyword", this.dDv);
      paramq.putExtra("businessType", this.dDw);
      paramq.putExtra("offset", this.offset);
      paramq.putExtra("title", this.title);
      paramq.putExtra("showEditText", this.dDx);
      try
      {
        paramq.putExtra("result", paramString.toByteArray());
        if (!(this.context instanceof Activity)) {
          paramq.addFlags(268435456);
        }
        kk(true);
        return;
      }
      catch (Exception paramString)
      {
        kk(false);
        Log.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
        return;
      }
      finally
      {
        AppMethodBeat.o(5567);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */