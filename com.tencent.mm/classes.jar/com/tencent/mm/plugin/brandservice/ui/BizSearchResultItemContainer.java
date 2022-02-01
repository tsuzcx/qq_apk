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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.plugin.brandservice.b.m;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements f
{
  private int mScene;
  int odA;
  private boolean odB;
  private int odC;
  private int ode;
  private ListView ods;
  c odt;
  private TextView odu;
  c odv;
  private a odw;
  m odx;
  private b ody;
  private long[] odz;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5640);
    this.mScene = 0;
    paramContext = View.inflate(getContext(), 2131495328, this);
    this.odv = new c((byte)0);
    this.odw = new a((byte)0);
    this.odu = ((TextView)paramContext.findViewById(2131299458));
    this.ods = ((ListView)paramContext.findViewById(2131304139));
    AppMethodBeat.o(5640);
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(5642);
    this.odv.odI = true;
    g.ajj().a(1071, this);
    Object localObject2 = null;
    Object localObject1 = this.odt.ty(this.odz[(this.odz.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).odr;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label201;
      }
      ae.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      localObject1 = localObject2;
      label108:
      if (localObject1 == null) {
        break label225;
      }
    }
    label201:
    label225:
    for (localObject1 = ((qt)localObject1).GeS;; localObject1 = "")
    {
      ae.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new l(paramString, paramLong, paramInt, this.mScene, (String)localObject1);
      g.ajj().a(paramString, 0);
      this.odw.updateStatus(1);
      AppMethodBeat.o(5642);
      return;
      localObject1 = null;
      break;
      localObject1 = (qt)((List)localObject1).get(((List)localObject1).size() - 1);
      break label108;
    }
  }
  
  public final void cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(5647);
    if (this.odt.isEmpty()) {
      this.odu.setVisibility(8);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(5647);
      return;
    }
    paramString = paramString.trim();
    if (("".equals(paramString)) || ((paramString.equals(this.odv.dmf)) && (!this.odB)))
    {
      AppMethodBeat.o(5647);
      return;
    }
    if (this.odv.odI)
    {
      AppMethodBeat.o(5647);
      return;
    }
    reset();
    this.odv.odI = true;
    this.odv.dmf = paramString;
    this.odA = paramInt;
    if (this.odC != 1)
    {
      g.ajj().a(1070, this);
      this.odx = new m(this.odv.dmf, this.odv.ocK, this.mScene);
      g.ajj().a(this.odx, 0);
    }
    for (;;)
    {
      if (this.ody != null) {
        this.ody.bOQ();
      }
      AppMethodBeat.o(5647);
      return;
      if (this.odz.length == 0)
      {
        ae.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
        AppMethodBeat.o(5647);
        return;
      }
      c(paramString, paramInt, this.odz[0]);
      this.odw.updateStatus(0);
    }
  }
  
  public c getAdapter()
  {
    return this.odt;
  }
  
  public b getIOnSearchStateChangedListener()
  {
    return this.ody;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 3;
    AppMethodBeat.i(5643);
    ae.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.ody != null) {
      this.ody.bOR();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.odv.odI = false;
      this.odB = true;
      Toast.makeText(getContext(), getContext().getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(5643);
      return;
    }
    this.odB = false;
    if (paramn == null)
    {
      ae.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      AppMethodBeat.o(5643);
      return;
    }
    if (paramn.getType() == 1070)
    {
      ae.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      g.ajj().b(1070, this);
      paramString = (m)paramn;
      if (paramString.ocL == null)
      {
        paramString = null;
        this.odt.l(this.odv.dmf, paramString);
        paramn = this.odt.ty(this.odz[(this.odz.length - 1)]);
        if ((paramn != null) && (!paramn.odq)) {
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
          paramString = (qt)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.odv.offset = (paramString.GeT + this.odA);
          }
        }
        if (!this.odt.isEmpty()) {
          break label575;
        }
        new aq(Looper.getMainLooper()).post(new Runnable()
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
      this.odv.continueFlag = paramInt1;
      this.odw.updateStatus(paramInt2);
      this.odv.odI = false;
      ae.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.odv.offset) });
      AppMethodBeat.o(5643);
      return;
      paramString = paramString.ocL.HJd;
      break;
      label398:
      paramInt1 = paramn.continueFlag;
      break label241;
      label407:
      paramInt2 = 2;
      break label248;
      if (paramn.getType() == 1071)
      {
        g.ajj().b(1071, this);
        ae.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((l)paramn).bOL();
        if ((paramString == null) || (paramString.usl == null)) {
          ae.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
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
          this.odt.a(paramString, true);
          if (paramString != null)
          {
            ae.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.GeS });
            this.odv.offset = (paramString.GeT + this.odA);
          }
          break;
          paramInt1 = paramString.GeQ;
          break label475;
        }
      }
      ae.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramn.getType()) });
      AppMethodBeat.o(5643);
      return;
      label575:
      this.odv.isSearchMode = true;
    }
  }
  
  final void reset()
  {
    AppMethodBeat.i(5644);
    this.odt.bOP();
    this.odw.updateStatus(0);
    this.odv.isSearchMode = false;
    this.odv.odI = false;
    this.odv.offset = 0;
    this.odv.dmf = null;
    this.odv.continueFlag = 1;
    AppMethodBeat.o(5644);
  }
  
  public void setAdapter(c paramc)
  {
    AppMethodBeat.i(5641);
    this.odt = paramc;
    if (this.odt != null)
    {
      this.odt.setScene(this.mScene);
      paramc = this.ods;
      a locala = this.odw;
      View localView = View.inflate(getContext(), 2131494592, null);
      locala.odF = localView.findViewById(2131301508);
      locala.odG = localView.findViewById(2131301499);
      locala.odH = localView.findViewById(2131301510);
      locala.odF.setVisibility(8);
      locala.odG.setVisibility(8);
      locala.odH.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.ods.setAdapter(this.odt);
      this.ods.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        boolean odD = false;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
          {
            this.odD = true;
            return;
          }
          this.odD = false;
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(5636);
          if ((paramAnonymousInt == 0) && (this.odD) && (BizSearchResultItemContainer.a(BizSearchResultItemContainer.this))) {
            BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).dmf, BizSearchResultItemContainer.b(BizSearchResultItemContainer.this).offset, BizSearchResultItemContainer.c(BizSearchResultItemContainer.this)[(BizSearchResultItemContainer.c(BizSearchResultItemContainer.this).length - 1)]);
          }
          AppMethodBeat.o(5636);
        }
      });
      this.ods.setOnItemClickListener(this.odt);
      if (this.odv.ocK == 0L)
      {
        setBusinessTypes(new long[] { 1L });
        AppMethodBeat.o(5641);
      }
    }
    else
    {
      this.ods.setAdapter(this.odt);
    }
    AppMethodBeat.o(5641);
  }
  
  public void setAddContactScene(int paramInt)
  {
    AppMethodBeat.i(5649);
    this.ode = paramInt;
    this.odt.setAddContactScene(paramInt);
    AppMethodBeat.o(5649);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    AppMethodBeat.i(5645);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.odz = paramVarArgs;
      this.odv.ocK = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        c localc = this.odv;
        localc.ocK |= paramVarArgs[i];
        i += 1;
      }
      this.odt.b(paramVarArgs);
    }
    AppMethodBeat.o(5645);
  }
  
  public final void setDisplayArgs$25decb5(boolean paramBoolean)
  {
    AppMethodBeat.i(5650);
    this.odt.G(paramBoolean, false);
    AppMethodBeat.o(5650);
  }
  
  public void setIOnSearchStateChangedListener(b paramb)
  {
    this.ody = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.odC = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(5651);
    super.setOnTouchListener(paramOnTouchListener);
    this.ods.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(5651);
  }
  
  public void setReporter(c.b paramb)
  {
    AppMethodBeat.i(5646);
    if (this.odt != null) {
      this.odt.setReporter(paramb);
    }
    AppMethodBeat.o(5646);
  }
  
  public void setScene(int paramInt)
  {
    AppMethodBeat.i(5648);
    this.mScene = paramInt;
    this.odt.setScene(this.mScene);
    AppMethodBeat.o(5648);
  }
  
  static final class a
  {
    View odF;
    View odG;
    View odH;
    
    private void H(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(5639);
      View localView = this.odF;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.odG.setVisibility(8);
        localView = this.odH;
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
    public abstract void bOQ();
    
    public abstract void bOR();
  }
  
  static final class c
  {
    public int continueFlag = 1;
    public String dmf;
    public boolean isSearchMode;
    public long ocK;
    public boolean odI;
    public int offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */