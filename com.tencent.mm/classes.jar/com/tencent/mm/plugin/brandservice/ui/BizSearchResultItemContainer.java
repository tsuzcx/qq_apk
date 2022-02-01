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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.plugin.brandservice.b.m;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements com.tencent.mm.ak.g
{
  private int mScene;
  private int nvX;
  private ListView nwl;
  c nwm;
  private TextView nwn;
  c nwo;
  private a nwp;
  m nwq;
  private b nwr;
  private long[] nws;
  int nwt;
  private boolean nwu;
  private int nwv;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5640);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), 2131495328, this);
    this.nwo = new c((byte)0);
    this.nwp = new a((byte)0);
    this.nwn = ((TextView)paramContext.findViewById(2131299458));
    this.nwl = ((ListView)paramContext.findViewById(2131304139));
    AppMethodBeat.o(5640);
  }
  
  private void b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5642);
    this.nwo.nwB = true;
    com.tencent.mm.kernel.g.agi().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.nwm.rm(this.nws[(this.nws.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).nwk;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label201;
      }
      ac.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      localObject1 = localObject2;
      label108:
      if (localObject1 == null) {
        break label225;
      }
    }
    label201:
    label225:
    for (localObject1 = ((pm)localObject1).EfU;; localObject1 = "")
    {
      ac.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new l(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      this.nwp.updateStatus(1);
      AppMethodBeat.o(5642);
      return;
      localObject1 = null;
      break;
      localObject1 = (pm)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void ct(String paramString, int paramInt)
  {
    AppMethodBeat.i(5647);
    if (this.nwm.isEmpty()) {
      this.nwn.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(5647);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.nwo.cZL)) && (!this.nwu)))
    {
      AppMethodBeat.o(5647);
      return;
    }
    if (this.nwo.nwB)
    {
      AppMethodBeat.o(5647);
      return;
    }
    reset();
    this.nwo.nwB = true;
    this.nwo.cZL = paramString;
    this.nwt = paramInt;
    if (this.nwv != 1)
    {
      com.tencent.mm.kernel.g.agi().a(1070, this);
      this.nwq = new m(this.nwo.cZL, this.nwo.nvD, this.mScene);
      com.tencent.mm.kernel.g.agi().a(this.nwq, 0);
    }
    for (;;)
    {
      if (this.nwr != null) {
        this.nwr.bJA();
      }
      AppMethodBeat.o(5647);
      return;
      if (this.nws.length == 0)
      {
        ac.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(5647);
        return;
      }
      b(paramString, paramInt, this.nws[0]);
      this.nwp.updateStatus(0);
    }
  }
  
  public c getAdapter()
  {
    return this.nwm;
  }
  
  public b getIOnSearchStateChangedListener()
  {
    return this.nwr;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 3;
    AppMethodBeat.i(5643);
    ac.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.nwr != null) {
      this.nwr.bJB();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.nwo.nwB = false;
      this.nwu = true;
      Toast.makeText(getContext(), getContext().getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(5643);
      return;
    }
    this.nwu = false;
    if (paramn == null)
    {
      ac.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(5643);
      return;
    }
    if (paramn.getType() == 1070)
    {
      ac.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      com.tencent.mm.kernel.g.agi().b(1070, this);
      paramString = (m)paramn;
      if (paramString.nvE == null)
      {
        paramString = null;
        this.nwm.k(this.nwo.cZL, paramString);
        paramn = this.nwm.rm(this.nws[(this.nws.length - 1)]);
        if ((paramn != null) && (!paramn.nwj)) {
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
          paramString = (pm)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.nwo.offset = (paramString.EfV + this.nwt);
          }
        }
        if (!this.nwm.isEmpty()) {
          break label575;
        }
        new ao(Looper.getMainLooper()).post(new Runnable()
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
      this.nwo.continueFlag = paramInt1;
      this.nwp.updateStatus(paramInt2);
      this.nwo.nwB = false;
      ac.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.nwo.offset) });
      AppMethodBeat.o(5643);
      return;
      paramString = paramString.nvE.FFc;
      break;
      label398:
      paramInt1 = paramn.continueFlag;
      break label241;
      label407:
      paramInt2 = 2;
      break label248;
      if (paramn.getType() == 1071)
      {
        com.tencent.mm.kernel.g.agi().b(1071, this);
        ac.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((l)paramn).bJv();
        if ((paramString == null) || (paramString.tiT == null)) {
          ac.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
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
          this.nwm.a(paramString, true);
          if (paramString != null)
          {
            ac.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.EfU });
            this.nwo.offset = (paramString.EfV + this.nwt);
          }
          break;
          paramInt1 = paramString.EfS;
          break label475;
        }
      }
      ac.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(5643);
      return;
      label575:
      this.nwo.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(5644);
    this.nwm.bJz();
    this.nwp.updateStatus(0);
    this.nwo.isSearchMode = false;
    this.nwo.nwB = false;
    this.nwo.offset = 0;
    this.nwo.cZL = null;
    this.nwo.continueFlag = 1;
    AppMethodBeat.o(5644);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(5641);
    this.nwm = paramc;
    if (this.nwm != null)
    {
      this.nwm.setScene(this.mScene);
      paramc = this.nwl;
      a locala = this.nwp;
      View localView = View.inflate(getContext(), 2131494592, null);
      locala.nwy = localView.findViewById(2131301508);
      locala.nwz = localView.findViewById(2131301499);
      locala.nwA = localView.findViewById(2131301510);
      locala.nwy.setVisibility(8);
      locala.nwz.setVisibility(8);
      locala.nwA.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.nwl.setAdapter(this.nwm);
      this.nwl.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        boolean nww = false;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
          {
            this.nww = true;
            return;
          }
          this.nww = false;
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5636);
          if ((paramAnonymousInt == 0) && (this.nww) && (BizSearchResultItemContainer.a(BizSearchResultItemContainer.this))) {
            BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).cZL, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).offset, BizSearchResultItemContainer.c(BizSearchResultItemContainer.this)[(BizSearchResultItemContainer.c(BizSearchResultItemContainer.this).length - 1)]);
          }
          AppMethodBeat.o(5636);
        }
      });
      this.nwl.setOnItemClickListener(this.nwm);
      if (this.nwo.nvD == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(5641);
      }
    }
    else
    {
      this.nwl.setAdapter(this.nwm);
    }
    AppMethodBeat.o(5641);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(5649);
    this.nvX = paramInt;
    this.nwm.setAddContactScene(paramInt);
    AppMethodBeat.o(5649);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(5645);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.nws = paramVarArgs;
      this.nwo.nvD = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        c localc = this.nwo;
        localc.nvD |= paramVarArgs[i];
        i += 1;
      }
      this.nwm.b(paramVarArgs);
    }
    AppMethodBeat.o(5645);
  }
  
  public final void setDisplayArgs$25decb5(boolean paramBoolean)
  {
    AppMethodBeat.i(5650);
    this.nwm.F(paramBoolean, false);
    AppMethodBeat.o(5650);
  }
  
  public void setIOnSearchStateChangedListener(b paramb)
  {
    this.nwr = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.nwv = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(5651);
    super.setOnTouchListener(paramOnTouchListener);
    this.nwl.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(5651);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(5646);
    if (this.nwm != null) {
      this.nwm.setReporter(paramb);
    }
    AppMethodBeat.o(5646);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(5648);
    this.mScene = paramInt;
    this.nwm.setScene(this.mScene);
    AppMethodBeat.o(5648);
  }
  
  static final class a
  {
    View nwA;
    View nwy;
    View nwz;
    
    private void G(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(5639);
      View localView = this.nwy;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.nwz.setVisibility(8);
        localView = this.nwA;
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
        G(false, false);
        AppMethodBeat.o(5638);
        return;
      case 1: 
        G(true, false);
        AppMethodBeat.o(5638);
        return;
      case 2: 
        G(false, true);
        AppMethodBeat.o(5638);
        return;
      }
      G(false, false);
      AppMethodBeat.o(5638);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bJA();
    
    public abstract void bJB();
  }
  
  static final class c
  {
    public String cZL;
    public int continueFlag = 1;
    public boolean isSearchMode;
    public long nvD;
    public boolean nwB;
    public int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */