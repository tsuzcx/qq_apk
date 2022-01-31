package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class b
{
  public static azu acv()
  {
    AppMethodBeat.i(13828);
    try
    {
      g.RM();
      Object localObject = (String)g.RL().Ru().get(67591, null);
      if (localObject != null)
      {
        azu localazu = new azu();
        localObject = ((String)localObject).split(",");
        localazu.wSk = Integer.valueOf(localObject[0]).intValue();
        localazu.wSn = Integer.valueOf(localObject[1]).intValue();
        localazu.wDi = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localazu.wDh = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ab.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localazu.wDi), Float.valueOf(localazu.wDh) });
        AppMethodBeat.o(13828);
        return localazu;
      }
      ab.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(13828);
      return null;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(13828);
    }
    return null;
  }
  
  public static final class a
    implements f
  {
    private String cnv;
    private long cnw;
    private boolean cnx;
    private Context context;
    private int fromScene;
    private aj jSK;
    private int offset;
    private String title;
    
    public a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, aj paramaj)
    {
      this.context = paramContext;
      this.cnv = paramString1;
      this.cnw = paramLong;
      this.offset = paramInt1;
      this.fromScene = paramInt2;
      this.title = paramString2;
      this.cnx = paramBoolean;
      this.jSK = paramaj;
    }
    
    private void fL(boolean paramBoolean)
    {
      AppMethodBeat.i(13827);
      g.Rc().b(1071, this);
      if ((this.jSK != null) && (this.jSK.cnt.cny != null))
      {
        this.jSK.cnu.cnz = paramBoolean;
        this.jSK.cnt.cny.run();
      }
      AppMethodBeat.o(13827);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
    {
      AppMethodBeat.i(13826);
      ab.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        fL(false);
        AppMethodBeat.o(13826);
        return;
      }
      if (paramm == null)
      {
        ab.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
        fL(false);
        AppMethodBeat.o(13826);
        return;
      }
      if (paramm.getType() != 1071)
      {
        ab.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
        AppMethodBeat.o(13826);
        return;
      }
      ab.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
      paramString = ((h)paramm).aWt();
      if ((paramString == null) || (paramString.nrw == null))
      {
        ab.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
        fL(false);
        AppMethodBeat.o(13826);
        return;
      }
      ab.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.wBZ });
      paramm = new Intent(this.context, BizSearchDetailPageUI.class);
      paramm.putExtra("addContactScene", 35);
      paramm.putExtra("fromScene", this.fromScene);
      paramm.putExtra("keyword", this.cnv);
      paramm.putExtra("businessType", this.cnw);
      paramm.putExtra("offset", this.offset);
      paramm.putExtra("title", this.title);
      paramm.putExtra("showEditText", this.cnx);
      try
      {
        paramm.putExtra("result", paramString.toByteArray());
        if (!(this.context instanceof Activity)) {
          paramm.addFlags(268435456);
        }
        fL(true);
        return;
      }
      catch (Exception paramString)
      {
        fL(false);
        ab.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
        return;
      }
      finally
      {
        AppMethodBeat.o(13826);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */