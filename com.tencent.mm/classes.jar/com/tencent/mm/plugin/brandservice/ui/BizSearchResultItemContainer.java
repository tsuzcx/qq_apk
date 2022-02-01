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
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.brandservice.b.m;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements com.tencent.mm.al.g
{
  private int mScene;
  private int mTF;
  private ListView mTT;
  c mTU;
  private TextView mTV;
  c mTW;
  private a mTX;
  com.tencent.mm.plugin.brandservice.b.n mTY;
  private b mTZ;
  private long[] mUa;
  int mUb;
  private boolean mUc;
  private int mUd;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5640);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), 2131495328, this);
    this.mTW = new c((byte)0);
    this.mTX = new a((byte)0);
    this.mTV = ((TextView)paramContext.findViewById(2131299458));
    this.mTT = ((ListView)paramContext.findViewById(2131304139));
    AppMethodBeat.o(5640);
  }
  
  private void b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5642);
    this.mTW.mUj = true;
    com.tencent.mm.kernel.g.aeS().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.mTU.nA(this.mUa[(this.mUa.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).mTS;
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
    for (localObject1 = ((pf)localObject1).CNs;; localObject1 = "")
    {
      ad.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new m(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      this.mTX.updateStatus(1);
      AppMethodBeat.o(5642);
      return;
      localObject1 = null;
      break;
      localObject1 = (pf)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void co(String paramString, int paramInt)
  {
    AppMethodBeat.i(5647);
    if (this.mTU.isEmpty()) {
      this.mTV.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(5647);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.mTW.dcm)) && (!this.mUc)))
    {
      AppMethodBeat.o(5647);
      return;
    }
    if (this.mTW.mUj)
    {
      AppMethodBeat.o(5647);
      return;
    }
    reset();
    this.mTW.mUj = true;
    this.mTW.dcm = paramString;
    this.mUb = paramInt;
    if (this.mUd != 1)
    {
      com.tencent.mm.kernel.g.aeS().a(1070, this);
      this.mTY = new com.tencent.mm.plugin.brandservice.b.n(this.mTW.dcm, this.mTW.mTl, this.mScene);
      com.tencent.mm.kernel.g.aeS().a(this.mTY, 0);
    }
    for (;;)
    {
      if (this.mTZ != null) {
        this.mTZ.bCx();
      }
      AppMethodBeat.o(5647);
      return;
      if (this.mUa.length == 0)
      {
        ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(5647);
        return;
      }
      b(paramString, paramInt, this.mUa[0]);
      this.mTX.updateStatus(0);
    }
  }
  
  public c getAdapter()
  {
    return this.mTU;
  }
  
  public b getIOnSearchStateChangedListener()
  {
    return this.mTZ;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 3;
    AppMethodBeat.i(5643);
    ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.mTZ != null) {
      this.mTZ.bCy();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.mTW.mUj = false;
      this.mUc = true;
      Toast.makeText(getContext(), getContext().getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(5643);
      return;
    }
    this.mUc = false;
    if (paramn == null)
    {
      ad.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(5643);
      return;
    }
    if (paramn.getType() == 1070)
    {
      ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      com.tencent.mm.kernel.g.aeS().b(1070, this);
      paramString = (com.tencent.mm.plugin.brandservice.b.n)paramn;
      if (paramString.mTm == null)
      {
        paramString = null;
        this.mTU.m(this.mTW.dcm, paramString);
        paramn = this.mTU.nA(this.mUa[(this.mUa.length - 1)]);
        if ((paramn != null) && (!paramn.mTR)) {
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
          paramString = (pf)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.mTW.offset = (paramString.CNt + this.mUb);
          }
        }
        if (!this.mTU.isEmpty()) {
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
      this.mTW.continueFlag = paramInt1;
      this.mTX.updateStatus(paramInt2);
      this.mTW.mUj = false;
      ad.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.mTW.offset) });
      AppMethodBeat.o(5643);
      return;
      paramString = paramString.mTm.Eie;
      break;
      label398:
      paramInt1 = paramn.continueFlag;
      break label241;
      label407:
      paramInt2 = 2;
      break label248;
      if (paramn.getType() == 1071)
      {
        com.tencent.mm.kernel.g.aeS().b(1071, this);
        ad.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((m)paramn).bCs();
        if ((paramString == null) || (paramString.saZ == null)) {
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
          this.mTU.a(paramString, true);
          if (paramString != null)
          {
            ad.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.CNs });
            this.mTW.offset = (paramString.CNt + this.mUb);
          }
          break;
          paramInt1 = paramString.CNq;
          break label475;
        }
      }
      ad.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(5643);
      return;
      label575:
      this.mTW.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(5644);
    this.mTU.bCw();
    this.mTX.updateStatus(0);
    this.mTW.isSearchMode = false;
    this.mTW.mUj = false;
    this.mTW.offset = 0;
    this.mTW.dcm = null;
    this.mTW.continueFlag = 1;
    AppMethodBeat.o(5644);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(5641);
    this.mTU = paramc;
    if (this.mTU != null)
    {
      this.mTU.setScene(this.mScene);
      paramc = this.mTT;
      a locala = this.mTX;
      View localView = View.inflate(getContext(), 2131494592, null);
      locala.mUg = localView.findViewById(2131301508);
      locala.mUh = localView.findViewById(2131301499);
      locala.mUi = localView.findViewById(2131301510);
      locala.mUg.setVisibility(8);
      locala.mUh.setVisibility(8);
      locala.mUi.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.mTT.setAdapter(this.mTU);
      this.mTT.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        boolean mUe = false;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
          {
            this.mUe = true;
            return;
          }
          this.mUe = false;
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5636);
          if ((paramAnonymousInt == 0) && (this.mUe) && (BizSearchResultItemContainer.a(BizSearchResultItemContainer.this))) {
            BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).dcm, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).offset, BizSearchResultItemContainer.c(BizSearchResultItemContainer.this)[(BizSearchResultItemContainer.c(BizSearchResultItemContainer.this).length - 1)]);
          }
          AppMethodBeat.o(5636);
        }
      });
      this.mTT.setOnItemClickListener(this.mTU);
      if (this.mTW.mTl == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(5641);
      }
    }
    else
    {
      this.mTT.setAdapter(this.mTU);
    }
    AppMethodBeat.o(5641);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(5649);
    this.mTF = paramInt;
    this.mTU.setAddContactScene(paramInt);
    AppMethodBeat.o(5649);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(5645);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.mUa = paramVarArgs;
      this.mTW.mTl = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        c localc = this.mTW;
        localc.mTl |= paramVarArgs[i];
        i += 1;
      }
      this.mTU.b(paramVarArgs);
    }
    AppMethodBeat.o(5645);
  }
  
  public final void setDisplayArgs$25decb5(boolean paramBoolean)
  {
    AppMethodBeat.i(5650);
    this.mTU.E(paramBoolean, false);
    AppMethodBeat.o(5650);
  }
  
  public void setIOnSearchStateChangedListener(b paramb)
  {
    this.mTZ = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.mUd = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(5651);
    super.setOnTouchListener(paramOnTouchListener);
    this.mTT.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(5651);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(5646);
    if (this.mTU != null) {
      this.mTU.setReporter(paramb);
    }
    AppMethodBeat.o(5646);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(5648);
    this.mScene = paramInt;
    this.mTU.setScene(this.mScene);
    AppMethodBeat.o(5648);
  }
  
  static final class a
  {
    View mUg;
    View mUh;
    View mUi;
    
    private void F(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(5639);
      View localView = this.mUg;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.mUh.setVisibility(8);
        localView = this.mUi;
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
        F(false, false);
        AppMethodBeat.o(5638);
        return;
      case 1: 
        F(true, false);
        AppMethodBeat.o(5638);
        return;
      case 2: 
        F(false, true);
        AppMethodBeat.o(5638);
        return;
      }
      F(false, false);
      AppMethodBeat.o(5638);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bCx();
    
    public abstract void bCy();
  }
  
  static final class c
  {
    public int continueFlag = 1;
    public String dcm;
    public boolean isSearchMode;
    public long mTl;
    public boolean mUj;
    public int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */