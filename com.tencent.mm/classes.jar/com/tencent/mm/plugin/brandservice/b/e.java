package com.tencent.mm.plugin.brandservice.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.an.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

public final class e
{
  public static btn bNG()
  {
    AppMethodBeat.i(5569);
    try
    {
      g.ajD();
      Object localObject = (String)g.ajC().ajl().get(67591, null);
      if (localObject != null)
      {
        btn localbtn = new btn();
        localObject = ((String)localObject).split(",");
        localbtn.Ggw = Integer.valueOf(localObject[0]).intValue();
        localbtn.Ggz = Integer.valueOf(localObject[1]).intValue();
        localbtn.FOB = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localbtn.FOA = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ad.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localbtn.FOB), Float.valueOf(localbtn.FOA) });
        AppMethodBeat.o(5569);
        return localbtn;
      }
      ad.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(5569);
      return null;
    }
    catch (Exception localException)
    {
      ad.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(5569);
    }
    return null;
  }
  
  public static final class a
    implements f
  {
    private Context context;
    private String dld;
    private long dle;
    private boolean dlf;
    private int fromScene;
    private an nWF;
    private int offset;
    private String title;
    
    public a(Context paramContext, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean, an paraman)
    {
      this.context = paramContext;
      this.dld = paramString1;
      this.dle = paramLong;
      this.offset = paramInt1;
      this.fromScene = paramInt2;
      this.title = paramString2;
      this.dlf = paramBoolean;
      this.nWF = paraman;
    }
    
    private void jm(boolean paramBoolean)
    {
      AppMethodBeat.i(5568);
      g.aiU().b(1071, this);
      if ((this.nWF != null) && (this.nWF.dlb.dlg != null))
      {
        this.nWF.dlc.dlh = paramBoolean;
        this.nWF.dlb.dlg.run();
      }
      AppMethodBeat.o(5568);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(5567);
      ad.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        jm(false);
        AppMethodBeat.o(5567);
        return;
      }
      if (paramn == null)
      {
        ad.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
        jm(false);
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
      paramString = ((l)paramn).bNO();
      if ((paramString == null) || (paramString.ugO == null))
      {
        ad.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
        jm(false);
        AppMethodBeat.o(5567);
        return;
      }
      ad.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[] { paramString.FMt });
      paramn = new Intent(this.context, BizSearchDetailPageUI.class);
      paramn.putExtra("addContactScene", 35);
      paramn.putExtra("fromScene", this.fromScene);
      paramn.putExtra("keyword", this.dld);
      paramn.putExtra("businessType", this.dle);
      paramn.putExtra("offset", this.offset);
      paramn.putExtra("title", this.title);
      paramn.putExtra("showEditText", this.dlf);
      try
      {
        paramn.putExtra("result", paramString.toByteArray());
        if (!(this.context instanceof Activity)) {
          paramn.addFlags(268435456);
        }
        jm(true);
        return;
      }
      catch (Exception paramString)
      {
        jm(false);
        ad.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", paramString, "", new Object[0]);
        return;
      }
      finally
      {
        AppMethodBeat.o(5567);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */