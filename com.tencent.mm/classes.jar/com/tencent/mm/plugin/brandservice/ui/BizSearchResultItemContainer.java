package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements f
{
  private ListView jTC;
  c jTD;
  private TextView jTE;
  BizSearchResultItemContainer.c jTF;
  private BizSearchResultItemContainer.a jTG;
  i jTH;
  private BizSearchResultItemContainer.b jTI;
  private long[] jTJ;
  int jTK;
  private boolean jTL;
  private int jTM;
  private int jTn;
  private int mScene;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13902);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), 2130970633, this);
    this.jTF = new BizSearchResultItemContainer.c((byte)0);
    this.jTG = new BizSearchResultItemContainer.a((byte)0);
    this.jTE = ((TextView)paramContext.findViewById(2131827505));
    this.jTC = ((ListView)paramContext.findViewById(2131827506));
    AppMethodBeat.o(13902);
  }
  
  private void b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13904);
    this.jTF.jTS = true;
    g.Rc().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.jTD.hP(this.jTJ[(this.jTJ.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).jTB;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label201;
      }
      ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      localObject1 = localObject2;
      label108:
      if (localObject1 == null) {
        break label225;
      }
    }
    label201:
    label225:
    for (localObject1 = ((nc)localObject1).wBZ;; localObject1 = "")
    {
      ab.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new h(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      g.Rc().a(paramString, 0);
      this.jTG.sb(1);
      AppMethodBeat.o(13904);
      return;
      localObject1 = null;
      break;
      localObject1 = (nc)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void bJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(13909);
    if (this.jTD.isEmpty()) {
      this.jTE.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(13909);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.jTF.cnv)) && (!this.jTL)))
    {
      AppMethodBeat.o(13909);
      return;
    }
    if (this.jTF.jTS)
    {
      AppMethodBeat.o(13909);
      return;
    }
    reset();
    this.jTF.jTS = true;
    this.jTF.cnv = paramString;
    this.jTK = paramInt;
    if (this.jTM != 1)
    {
      g.Rc().a(1070, this);
      this.jTH = new i(this.jTF.cnv, this.jTF.jST, this.mScene);
      g.Rc().a(this.jTH, 0);
    }
    for (;;)
    {
      if (this.jTI != null) {
        this.jTI.aWy();
      }
      AppMethodBeat.o(13909);
      return;
      if (this.jTJ.length == 0)
      {
        ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(13909);
        return;
      }
      b(paramString, paramInt, this.jTJ[0]);
      this.jTG.sb(0);
    }
  }
  
  public c getAdapter()
  {
    return this.jTD;
  }
  
  public BizSearchResultItemContainer.b getIOnSearchStateChangedListener()
  {
    return this.jTI;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 3;
    AppMethodBeat.i(13905);
    ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jTI != null) {
      this.jTI.aWz();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.jTF.jTS = false;
      this.jTL = true;
      Toast.makeText(getContext(), getContext().getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(13905);
      return;
    }
    this.jTL = false;
    if (paramm == null)
    {
      ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(13905);
      return;
    }
    if (paramm.getType() == 1070)
    {
      ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      g.Rc().b(1070, this);
      paramString = (i)paramm;
      if (paramString.jSU == null)
      {
        paramString = null;
        this.jTD.i(this.jTF.cnv, paramString);
        paramm = this.jTD.hP(this.jTJ[(this.jTJ.length - 1)]);
        if ((paramm != null) && (!paramm.jTA)) {
          break label397;
        }
        paramInt1 = 0;
        label240:
        if (paramInt1 != 0) {
          break label406;
        }
        paramInt2 = i;
        label247:
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (nc)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.jTF.offset = (paramString.wzS + this.jTK);
          }
        }
        if (!this.jTD.isEmpty()) {
          break label574;
        }
        new ak(Looper.getMainLooper()).post(new BizSearchResultItemContainer.2(this));
      }
    }
    for (;;)
    {
      this.jTF.jTx = paramInt1;
      this.jTG.sb(paramInt2);
      this.jTF.jTS = false;
      ab.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.jTF.offset) });
      AppMethodBeat.o(13905);
      return;
      paramString = paramString.jSU.xKt;
      break;
      label397:
      paramInt1 = paramm.jTx;
      break label240;
      label406:
      paramInt2 = 2;
      break label247;
      if (paramm.getType() == 1071)
      {
        g.Rc().b(1071, this);
        ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((h)paramm).aWt();
        if ((paramString == null) || (paramString.nrw == null)) {
          ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
        }
        if (paramString == null)
        {
          paramInt1 = 0;
          label474:
          if (paramInt1 != 0) {
            break label539;
          }
        }
        label539:
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          this.jTD.a(paramString, true);
          if (paramString != null)
          {
            ab.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.wBZ });
            this.jTF.offset = (paramString.wzS + this.jTK);
          }
          break;
          paramInt1 = paramString.wBX;
          break label474;
        }
      }
      ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramm.getType()) });
      AppMethodBeat.o(13905);
      return;
      label574:
      this.jTF.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(13906);
    this.jTD.aWx();
    this.jTG.sb(0);
    this.jTF.isSearchMode = false;
    this.jTF.jTS = false;
    this.jTF.offset = 0;
    this.jTF.cnv = null;
    this.jTF.jTx = 1;
    AppMethodBeat.o(13906);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(13903);
    this.jTD = paramc;
    if (this.jTD != null)
    {
      this.jTD.setScene(this.mScene);
      paramc = this.jTC;
      BizSearchResultItemContainer.a locala = this.jTG;
      View localView = View.inflate(getContext(), 2130969988, null);
      locala.jTP = localView.findViewById(2131825426);
      locala.jTQ = localView.findViewById(2131822313);
      locala.jTR = localView.findViewById(2131825427);
      locala.jTP.setVisibility(8);
      locala.jTQ.setVisibility(8);
      locala.jTR.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.jTC.setAdapter(this.jTD);
      this.jTC.setOnScrollListener(new BizSearchResultItemContainer.1(this));
      this.jTC.setOnItemClickListener(this.jTD);
      if (this.jTF.jST == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(13903);
      }
    }
    else
    {
      this.jTC.setAdapter(this.jTD);
    }
    AppMethodBeat.o(13903);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(13911);
    this.jTn = paramInt;
    this.jTD.setAddContactScene(paramInt);
    AppMethodBeat.o(13911);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(13907);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.jTJ = paramVarArgs;
      this.jTF.jST = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        BizSearchResultItemContainer.c localc = this.jTF;
        localc.jST |= paramVarArgs[i];
        i += 1;
      }
      this.jTD.c(paramVarArgs);
    }
    AppMethodBeat.o(13907);
  }
  
  public final void setDisplayArgs$25decb5(boolean paramBoolean)
  {
    AppMethodBeat.i(13912);
    this.jTD.v(paramBoolean, false);
    AppMethodBeat.o(13912);
  }
  
  public void setIOnSearchStateChangedListener(BizSearchResultItemContainer.b paramb)
  {
    this.jTI = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.jTM = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(13913);
    super.setOnTouchListener(paramOnTouchListener);
    this.jTC.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(13913);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(13908);
    if (this.jTD != null) {
      this.jTD.setReporter(paramb);
    }
    AppMethodBeat.o(13908);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(13910);
    this.mScene = paramInt;
    this.jTD.setScene(this.mScene);
    AppMethodBeat.o(13910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */