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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.model.m;
import com.tencent.mm.plugin.brandservice.model.n;
import com.tencent.mm.protocal.protobuf.evw;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements com.tencent.mm.am.h
{
  private int mScene;
  private int vCI;
  private ListView vCW;
  c vCX;
  private TextView vCY;
  c vCZ;
  private a vDa;
  n vDb;
  private b vDc;
  private long[] vDd;
  int vDe;
  private boolean vDf;
  private int vDg;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5640);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), d.f.search_result_lv, this);
    this.vCZ = new c((byte)0);
    this.vDa = new a((byte)0);
    this.vCY = ((TextView)paramContext.findViewById(d.e.emptyTipsTV));
    this.vCW = ((ListView)paramContext.findViewById(d.e.resultLV));
    AppMethodBeat.o(5640);
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5642);
    this.vCZ.vDm = true;
    com.tencent.mm.kernel.h.aZW().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.vCX.ki(this.vDd[(this.vDd.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).vCV;
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
    for (localObject1 = ((sy)localObject1).YYr;; localObject1 = "")
    {
      Log.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new m(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      this.vDa.updateStatus(1);
      AppMethodBeat.o(5642);
      return;
      localObject1 = null;
      break;
      localObject1 = (sy)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void dE(String paramString, int paramInt)
  {
    AppMethodBeat.i(5647);
    if (this.vCX.isEmpty()) {
      this.vCY.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(5647);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.vCZ.hAB)) && (!this.vDf)))
    {
      AppMethodBeat.o(5647);
      return;
    }
    if (this.vCZ.vDm)
    {
      AppMethodBeat.o(5647);
      return;
    }
    reset();
    this.vCZ.vDm = true;
    this.vCZ.hAB = paramString;
    this.vDe = paramInt;
    if (this.vDg != 1)
    {
      com.tencent.mm.kernel.h.aZW().a(1070, this);
      this.vDb = new n(this.vCZ.hAB, this.vCZ.vCo, this.mScene);
      com.tencent.mm.kernel.h.aZW().a(this.vDb, 0);
    }
    for (;;)
    {
      if (this.vDc != null) {
        this.vDc.dcs();
      }
      AppMethodBeat.o(5647);
      return;
      if (this.vDd.length == 0)
      {
        Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(5647);
        return;
      }
      c(paramString, paramInt, this.vDd[0]);
      this.vDa.updateStatus(0);
    }
  }
  
  public c getAdapter()
  {
    return this.vCX;
  }
  
  public b getIOnSearchStateChangedListener()
  {
    return this.vDc;
  }
  
  public final void mP(boolean paramBoolean)
  {
    AppMethodBeat.i(5650);
    this.vCX.N(paramBoolean, false);
    AppMethodBeat.o(5650);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 3;
    AppMethodBeat.i(5643);
    Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.vDc != null) {
      this.vDc.dct();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.vCZ.vDm = false;
      this.vDf = true;
      Toast.makeText(getContext(), getContext().getString(d.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(5643);
      return;
    }
    this.vDf = false;
    if (paramp == null)
    {
      Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(5643);
      return;
    }
    if (paramp.getType() == 1070)
    {
      Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      com.tencent.mm.kernel.h.aZW().b(1070, this);
      paramString = (n)paramp;
      if (paramString.vCp == null)
      {
        paramString = null;
        this.vCX.r(this.vCZ.hAB, paramString);
        paramp = this.vCX.ki(this.vDd[(this.vDd.length - 1)]);
        if ((paramp != null) && (!paramp.vCU)) {
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
          paramString = (sy)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.vCZ.offset = (paramString.YYs + this.vDe);
          }
        }
        if (!this.vCX.isEmpty()) {
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
      this.vCZ.continueFlag = paramInt1;
      this.vDa.updateStatus(paramInt2);
      this.vCZ.vDm = false;
      Log.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.vCZ.offset) });
      AppMethodBeat.o(5643);
      return;
      paramString = paramString.vCp.abyx;
      break;
      label399:
      paramInt1 = paramp.continueFlag;
      break label242;
      label408:
      paramInt2 = 2;
      break label249;
      if (paramp.getType() == 1071)
      {
        com.tencent.mm.kernel.h.aZW().b(1071, this);
        Log.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((m)paramp).dcn();
        if ((paramString == null) || (paramString.IIU == null)) {
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
          this.vCX.a(paramString, true);
          if (paramString != null)
          {
            Log.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.YYr });
            this.vCZ.offset = (paramString.YYs + this.vDe);
          }
          break;
          paramInt1 = paramString.YYp;
          break label476;
        }
      }
      Log.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramp.getType()) });
      AppMethodBeat.o(5643);
      return;
      label576:
      this.vCZ.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(5644);
    this.vCX.dcr();
    this.vDa.updateStatus(0);
    this.vCZ.isSearchMode = false;
    this.vCZ.vDm = false;
    this.vCZ.offset = 0;
    this.vCZ.hAB = null;
    this.vCZ.continueFlag = 1;
    AppMethodBeat.o(5644);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(5641);
    this.vCX = paramc;
    if (this.vCX != null)
    {
      this.vCX.setScene(this.mScene);
      paramc = this.vCW;
      a locala = this.vDa;
      View localView = View.inflate(getContext(), d.f.loading_footer, null);
      locala.vDj = localView.findViewById(d.e.loading_progress);
      locala.vDk = localView.findViewById(d.e.loading_end);
      locala.vDl = localView.findViewById(d.e.loading_tip);
      locala.vDj.setVisibility(8);
      locala.vDk.setVisibility(8);
      locala.vDl.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.vCW.setAdapter(this.vCX);
      this.vCW.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        boolean vDh = false;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
          {
            this.vDh = true;
            return;
          }
          this.vDh = false;
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5636);
          if ((paramAnonymousInt == 0) && (this.vDh) && (BizSearchResultItemContainer.a(BizSearchResultItemContainer.this))) {
            BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).hAB, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).offset, BizSearchResultItemContainer.c(BizSearchResultItemContainer.this)[(BizSearchResultItemContainer.c(BizSearchResultItemContainer.this).length - 1)]);
          }
          AppMethodBeat.o(5636);
        }
      });
      this.vCW.setOnItemClickListener(this.vCX);
      if (this.vCZ.vCo == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(5641);
      }
    }
    else
    {
      this.vCW.setAdapter(this.vCX);
    }
    AppMethodBeat.o(5641);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(5649);
    this.vCI = paramInt;
    this.vCX.setAddContactScene(paramInt);
    AppMethodBeat.o(5649);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(5645);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.vDd = paramVarArgs;
      this.vCZ.vCo = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        c localc = this.vCZ;
        localc.vCo |= paramVarArgs[i];
        i += 1;
      }
      this.vCX.d(paramVarArgs);
    }
    AppMethodBeat.o(5645);
  }
  
  public void setIOnSearchStateChangedListener(b paramb)
  {
    this.vDc = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.vDg = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(5651);
    super.setOnTouchListener(paramOnTouchListener);
    this.vCW.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(5651);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(5646);
    if (this.vCX != null) {
      this.vCX.setReporter(paramb);
    }
    AppMethodBeat.o(5646);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(5648);
    this.mScene = paramInt;
    this.vCX.setScene(this.mScene);
    AppMethodBeat.o(5648);
  }
  
  static final class a
  {
    View vDj;
    View vDk;
    View vDl;
    
    private void O(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(5639);
      View localView = this.vDj;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.vDk.setVisibility(8);
        localView = this.vDl;
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
        O(false, false);
        AppMethodBeat.o(5638);
        return;
      case 1: 
        O(true, false);
        AppMethodBeat.o(5638);
        return;
      case 2: 
        O(false, true);
        AppMethodBeat.o(5638);
        return;
      }
      O(false, false);
      AppMethodBeat.o(5638);
    }
  }
  
  public static abstract interface b
  {
    public abstract void dcs();
    
    public abstract void dct();
  }
  
  static final class c
  {
    public int continueFlag = 1;
    public String hAB;
    public boolean isSearchMode;
    public int offset;
    public long vCo;
    public boolean vDm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */