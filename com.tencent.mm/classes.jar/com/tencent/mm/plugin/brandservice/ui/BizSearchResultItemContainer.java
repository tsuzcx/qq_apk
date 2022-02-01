package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.plugin.brandservice.b.m;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements f
{
  private int mScene;
  private ListView nXJ;
  c nXK;
  private TextView nXL;
  c nXM;
  private a nXN;
  m nXO;
  private b nXP;
  private long[] nXQ;
  int nXR;
  private boolean nXS;
  private int nXT;
  private int nXv;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5640);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), 2131495328, this);
    this.nXM = new c((byte)0);
    this.nXN = new a((byte)0);
    this.nXL = ((TextView)paramContext.findViewById(2131299458));
    this.nXJ = ((ListView)paramContext.findViewById(2131304139));
    AppMethodBeat.o(5640);
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5642);
    this.nXM.nXZ = true;
    g.aiU().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.nXK.tk(this.nXQ[(this.nXQ.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).nXI;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label201;
      }
      ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      localObject1 = localObject2;
      label108:
      if (localObject1 == null) {
        break label225;
      }
    }
    label201:
    label225:
    for (localObject1 = ((qr)localObject1).FMt;; localObject1 = "")
    {
      ad.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new l(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      g.aiU().a(paramString, 0);
      this.nXN.updateStatus(1);
      AppMethodBeat.o(5642);
      return;
      localObject1 = null;
      break;
      localObject1 = (qr)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void cw(String paramString, int paramInt)
  {
    AppMethodBeat.i(5647);
    if (this.nXK.isEmpty()) {
      this.nXL.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(5647);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.nXM.dld)) && (!this.nXS)))
    {
      AppMethodBeat.o(5647);
      return;
    }
    if (this.nXM.nXZ)
    {
      AppMethodBeat.o(5647);
      return;
    }
    reset();
    this.nXM.nXZ = true;
    this.nXM.dld = paramString;
    this.nXR = paramInt;
    if (this.nXT != 1)
    {
      g.aiU().a(1070, this);
      this.nXO = new m(this.nXM.dld, this.nXM.nXb, this.mScene);
      g.aiU().a(this.nXO, 0);
    }
    for (;;)
    {
      if (this.nXP != null) {
        this.nXP.bNT();
      }
      AppMethodBeat.o(5647);
      return;
      if (this.nXQ.length == 0)
      {
        ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(5647);
        return;
      }
      c(paramString, paramInt, this.nXQ[0]);
      this.nXN.updateStatus(0);
    }
  }
  
  public c getAdapter()
  {
    return this.nXK;
  }
  
  public b getIOnSearchStateChangedListener()
  {
    return this.nXP;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 3;
    AppMethodBeat.i(5643);
    ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.nXP != null) {
      this.nXP.bNU();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.nXM.nXZ = false;
      this.nXS = true;
      Toast.makeText(getContext(), getContext().getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(5643);
      return;
    }
    this.nXS = false;
    if (paramn == null)
    {
      ad.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(5643);
      return;
    }
    if (paramn.getType() == 1070)
    {
      ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      g.aiU().b(1070, this);
      paramString = (m)paramn;
      if (paramString.nXc == null)
      {
        paramString = null;
        this.nXK.l(this.nXM.dld, paramString);
        paramn = this.nXK.tk(this.nXQ[(this.nXQ.length - 1)]);
        if ((paramn != null) && (!paramn.nXH)) {
          break label398;
        }
        paramInt1 = 0;
        label241:
        if (paramInt1 != 0) {
          break label407;
        }
        paramInt2 = i;
        label248:
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (qr)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.nXM.offset = (paramString.FMu + this.nXR);
          }
        }
        if (!this.nXK.isEmpty()) {
          break label575;
        }
        new ap(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(5637);
            TextView localTextView = BizSearchResultItemContainer.e(BizSearchResultItemContainer.this);
            if (BizSearchResultItemContainer.d(BizSearchResultItemContainer.this).isEmpty()) {}
            for (int i = 0;; i = 8)
            {
              localTextView.setVisibility(i);
              AppMethodBeat.o(5637);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      this.nXM.continueFlag = paramInt1;
      this.nXN.updateStatus(paramInt2);
      this.nXM.nXZ = false;
      ad.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.nXM.offset) });
      AppMethodBeat.o(5643);
      return;
      paramString = paramString.nXc.HpB;
      break;
      label398:
      paramInt1 = paramn.continueFlag;
      break label241;
      label407:
      paramInt2 = 2;
      break label248;
      if (paramn.getType() == 1071)
      {
        g.aiU().b(1071, this);
        ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((l)paramn).bNO();
        if ((paramString == null) || (paramString.ugO == null)) {
          ad.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
        }
        if (paramString == null)
        {
          paramInt1 = 0;
          label475:
          if (paramInt1 != 0) {
            break label540;
          }
        }
        label540:
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          this.nXK.a(paramString, true);
          if (paramString != null)
          {
            ad.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.FMt });
            this.nXM.offset = (paramString.FMu + this.nXR);
          }
          break;
          paramInt1 = paramString.FMr;
          break label475;
        }
      }
      ad.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(5643);
      return;
      label575:
      this.nXM.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(5644);
    this.nXK.bNS();
    this.nXN.updateStatus(0);
    this.nXM.isSearchMode = false;
    this.nXM.nXZ = false;
    this.nXM.offset = 0;
    this.nXM.dld = null;
    this.nXM.continueFlag = 1;
    AppMethodBeat.o(5644);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(5641);
    this.nXK = paramc;
    if (this.nXK != null)
    {
      this.nXK.setScene(this.mScene);
      paramc = this.nXJ;
      a locala = this.nXN;
      View localView = View.inflate(getContext(), 2131494592, null);
      locala.nXW = localView.findViewById(2131301508);
      locala.nXX = localView.findViewById(2131301499);
      locala.nXY = localView.findViewById(2131301510);
      locala.nXW.setVisibility(8);
      locala.nXX.setVisibility(8);
      locala.nXY.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.nXJ.setAdapter(this.nXK);
      this.nXJ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        boolean nXU = false;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
          {
            this.nXU = true;
            return;
          }
          this.nXU = false;
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5636);
          if ((paramAnonymousInt == 0) && (this.nXU) && (BizSearchResultItemContainer.a(BizSearchResultItemContainer.this))) {
            BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).dld, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).offset, BizSearchResultItemContainer.c(BizSearchResultItemContainer.this)[(BizSearchResultItemContainer.c(BizSearchResultItemContainer.this).length - 1)]);
          }
          AppMethodBeat.o(5636);
        }
      });
      this.nXJ.setOnItemClickListener(this.nXK);
      if (this.nXM.nXb == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(5641);
      }
    }
    else
    {
      this.nXJ.setAdapter(this.nXK);
    }
    AppMethodBeat.o(5641);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(5649);
    this.nXv = paramInt;
    this.nXK.setAddContactScene(paramInt);
    AppMethodBeat.o(5649);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(5645);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.nXQ = paramVarArgs;
      this.nXM.nXb = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        c localc = this.nXM;
        localc.nXb |= paramVarArgs[i];
        i += 1;
      }
      this.nXK.b(paramVarArgs);
    }
    AppMethodBeat.o(5645);
  }
  
  public final void setDisplayArgs$25decb5(boolean paramBoolean)
  {
    AppMethodBeat.i(5650);
    this.nXK.G(paramBoolean, false);
    AppMethodBeat.o(5650);
  }
  
  public void setIOnSearchStateChangedListener(b paramb)
  {
    this.nXP = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.nXT = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(5651);
    super.setOnTouchListener(paramOnTouchListener);
    this.nXJ.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(5651);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(5646);
    if (this.nXK != null) {
      this.nXK.setReporter(paramb);
    }
    AppMethodBeat.o(5646);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(5648);
    this.mScene = paramInt;
    this.nXK.setScene(this.mScene);
    AppMethodBeat.o(5648);
  }
  
  static final class a
  {
    View nXW;
    View nXX;
    View nXY;
    
    private void H(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(5639);
      View localView = this.nXW;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.nXX.setVisibility(8);
        localView = this.nXY;
        if (!paramBoolean2) {
          break label68;
        }
      }
      label68:
      for (int i = j;; i = 8)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(5639);
        return;
        i = 8;
        break;
      }
    }
    
    public final void updateStatus(int paramInt)
    {
      AppMethodBeat.i(5638);
      switch (paramInt)
      {
      default: 
        H(false, false);
        AppMethodBeat.o(5638);
        return;
      case 1: 
        H(true, false);
        AppMethodBeat.o(5638);
        return;
      case 2: 
        H(false, true);
        AppMethodBeat.o(5638);
        return;
      }
      H(false, false);
      AppMethodBeat.o(5638);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bNT();
    
    public abstract void bNU();
  }
  
  static final class c
  {
    public int continueFlag = 1;
    public String dld;
    public boolean isSearchMode;
    public boolean nXZ;
    public long nXb;
    public int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */