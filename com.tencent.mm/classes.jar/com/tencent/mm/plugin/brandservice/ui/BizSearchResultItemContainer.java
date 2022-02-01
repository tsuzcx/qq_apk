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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.b.m;
import com.tencent.mm.plugin.brandservice.b.n;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements i
{
  private int mScene;
  private int sxb;
  private ListView sxp;
  c sxq;
  private TextView sxr;
  c sxs;
  private a sxt;
  n sxu;
  private b sxv;
  private long[] sxw;
  int sxx;
  private boolean sxy;
  private int sxz;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5640);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), d.f.search_result_lv, this);
    this.sxs = new c((byte)0);
    this.sxt = new a((byte)0);
    this.sxr = ((TextView)paramContext.findViewById(d.e.srN));
    this.sxp = ((ListView)paramContext.findViewById(d.e.ssP));
    AppMethodBeat.o(5640);
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5642);
    this.sxs.sxF = true;
    h.aGY().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.sxq.HR(this.sxw[(this.sxw.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).sxo;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label201;
      }
      Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      localObject1 = localObject2;
      label108:
      if (localObject1 == null) {
        break label225;
      }
    }
    label201:
    label225:
    for (localObject1 = ((rn)localObject1).Sas;; localObject1 = "")
    {
      Log.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new m(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      h.aGY().a(paramString, 0);
      this.sxt.updateStatus(1);
      AppMethodBeat.o(5642);
      return;
      localObject1 = null;
      break;
      localObject1 = (rn)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(5647);
    if (this.sxq.isEmpty()) {
      this.sxr.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(5647);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.sxs.fwe)) && (!this.sxy)))
    {
      AppMethodBeat.o(5647);
      return;
    }
    if (this.sxs.sxF)
    {
      AppMethodBeat.o(5647);
      return;
    }
    reset();
    this.sxs.sxF = true;
    this.sxs.fwe = paramString;
    this.sxx = paramInt;
    if (this.sxz != 1)
    {
      h.aGY().a(1070, this);
      this.sxu = new n(this.sxs.fwe, this.sxs.swH, this.mScene);
      h.aGY().a(this.sxu, 0);
    }
    for (;;)
    {
      if (this.sxv != null) {
        this.sxv.czA();
      }
      AppMethodBeat.o(5647);
      return;
      if (this.sxw.length == 0)
      {
        Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(5647);
        return;
      }
      c(paramString, paramInt, this.sxw[0]);
      this.sxt.updateStatus(0);
    }
  }
  
  public c getAdapter()
  {
    return this.sxq;
  }
  
  public b getIOnSearchStateChangedListener()
  {
    return this.sxv;
  }
  
  public final void lx(boolean paramBoolean)
  {
    AppMethodBeat.i(5650);
    this.sxq.J(paramBoolean, false);
    AppMethodBeat.o(5650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 3;
    AppMethodBeat.i(5643);
    Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.sxv != null) {
      this.sxv.czB();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.sxs.sxF = false;
      this.sxy = true;
      Toast.makeText(getContext(), getContext().getString(d.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(5643);
      return;
    }
    this.sxy = false;
    if (paramq == null)
    {
      Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(5643);
      return;
    }
    if (paramq.getType() == 1070)
    {
      Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      h.aGY().b(1070, this);
      paramString = (n)paramq;
      if (paramString.swI == null)
      {
        paramString = null;
        this.sxq.m(this.sxs.fwe, paramString);
        paramq = this.sxq.HR(this.sxw[(this.sxw.length - 1)]);
        if ((paramq != null) && (!paramq.sxn)) {
          break label399;
        }
        paramInt1 = 0;
        label242:
        if (paramInt1 != 0) {
          break label408;
        }
        paramInt2 = i;
        label249:
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (rn)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.sxs.offset = (paramString.Sat + this.sxx);
          }
        }
        if (!this.sxq.isEmpty()) {
          break label576;
        }
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
      this.sxs.continueFlag = paramInt1;
      this.sxt.updateStatus(paramInt2);
      this.sxs.sxF = false;
      Log.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.sxs.offset) });
      AppMethodBeat.o(5643);
      return;
      paramString = paramString.swI.UgW;
      break;
      label399:
      paramInt1 = paramq.continueFlag;
      break label242;
      label408:
      paramInt2 = 2;
      break label249;
      if (paramq.getType() == 1071)
      {
        h.aGY().b(1071, this);
        Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((m)paramq).czv();
        if ((paramString == null) || (paramString.COK == null)) {
          Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
        }
        if (paramString == null)
        {
          paramInt1 = 0;
          label476:
          if (paramInt1 != 0) {
            break label541;
          }
        }
        label541:
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          this.sxq.a(paramString, true);
          if (paramString != null)
          {
            Log.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.Sas });
            this.sxs.offset = (paramString.Sat + this.sxx);
          }
          break;
          paramInt1 = paramString.Saq;
          break label476;
        }
      }
      Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(5643);
      return;
      label576:
      this.sxs.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(5644);
    this.sxq.czz();
    this.sxt.updateStatus(0);
    this.sxs.isSearchMode = false;
    this.sxs.sxF = false;
    this.sxs.offset = 0;
    this.sxs.fwe = null;
    this.sxs.continueFlag = 1;
    AppMethodBeat.o(5644);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(5641);
    this.sxq = paramc;
    if (this.sxq != null)
    {
      this.sxq.setScene(this.mScene);
      paramc = this.sxp;
      a locala = this.sxt;
      View localView = View.inflate(getContext(), d.f.ein, null);
      locala.sxC = localView.findViewById(d.e.loading_progress);
      locala.sxD = localView.findViewById(d.e.loading_end);
      locala.sxE = localView.findViewById(d.e.dLy);
      locala.sxC.setVisibility(8);
      locala.sxD.setVisibility(8);
      locala.sxE.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.sxp.setAdapter(this.sxq);
      this.sxp.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        boolean sxA = false;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
          {
            this.sxA = true;
            return;
          }
          this.sxA = false;
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5636);
          if ((paramAnonymousInt == 0) && (this.sxA) && (BizSearchResultItemContainer.a(BizSearchResultItemContainer.this))) {
            BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).fwe, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).offset, BizSearchResultItemContainer.c(BizSearchResultItemContainer.this)[(BizSearchResultItemContainer.c(BizSearchResultItemContainer.this).length - 1)]);
          }
          AppMethodBeat.o(5636);
        }
      });
      this.sxp.setOnItemClickListener(this.sxq);
      if (this.sxs.swH == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(5641);
      }
    }
    else
    {
      this.sxp.setAdapter(this.sxq);
    }
    AppMethodBeat.o(5641);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(5649);
    this.sxb = paramInt;
    this.sxq.setAddContactScene(paramInt);
    AppMethodBeat.o(5649);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(5645);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.sxw = paramVarArgs;
      this.sxs.swH = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        c localc = this.sxs;
        localc.swH |= paramVarArgs[i];
        i += 1;
      }
      this.sxq.b(paramVarArgs);
    }
    AppMethodBeat.o(5645);
  }
  
  public void setIOnSearchStateChangedListener(b paramb)
  {
    this.sxv = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.sxz = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(5651);
    super.setOnTouchListener(paramOnTouchListener);
    this.sxp.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(5651);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(5646);
    if (this.sxq != null) {
      this.sxq.setReporter(paramb);
    }
    AppMethodBeat.o(5646);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(5648);
    this.mScene = paramInt;
    this.sxq.setScene(this.mScene);
    AppMethodBeat.o(5648);
  }
  
  static final class a
  {
    View sxC;
    View sxD;
    View sxE;
    
    private void K(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(5639);
      View localView = this.sxC;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.sxD.setVisibility(8);
        localView = this.sxE;
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
        K(false, false);
        AppMethodBeat.o(5638);
        return;
      case 1: 
        K(true, false);
        AppMethodBeat.o(5638);
        return;
      case 2: 
        K(false, true);
        AppMethodBeat.o(5638);
        return;
      }
      K(false, false);
      AppMethodBeat.o(5638);
    }
  }
  
  public static abstract interface b
  {
    public abstract void czA();
    
    public abstract void czB();
  }
  
  static final class c
  {
    public int continueFlag = 1;
    public String fwe;
    public boolean isSearchMode;
    public int offset;
    public long swH;
    public boolean sxF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */