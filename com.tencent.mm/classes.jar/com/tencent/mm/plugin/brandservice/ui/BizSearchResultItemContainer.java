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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.protocal.c.bny;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class BizSearchResultItemContainer
  extends LinearLayout
  implements f
{
  private int fzn = 0;
  private ListView icN;
  c icO;
  private TextView icP;
  BizSearchResultItemContainer.c icQ;
  private BizSearchResultItemContainer.a icR;
  i icS;
  private BizSearchResultItemContainer.b icT;
  private long[] icU;
  int icV;
  private boolean icW;
  private int icX;
  private int icy;
  
  public BizSearchResultItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = View.inflate(getContext(), b.e.search_result_lv, this);
    this.icQ = new BizSearchResultItemContainer.c((byte)0);
    this.icR = new BizSearchResultItemContainer.a((byte)0);
    this.icP = ((TextView)paramContext.findViewById(b.d.emptyTipsTV));
    this.icN = ((ListView)paramContext.findViewById(b.d.resultLV));
  }
  
  private void c(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    this.icQ.idd = true;
    g.Dk().a(1071, this);
    Object localObject1 = this.icO.cN(this.icU[(this.icU.length - 1)]);
    if (localObject1 != null)
    {
      localObject1 = ((c.a)localObject1).icM;
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label189;
      }
      y.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      localObject1 = localObject2;
      label102:
      if (localObject1 == null) {
        break label213;
      }
    }
    label189:
    label213:
    for (localObject1 = ((kq)localObject1).sFF;; localObject1 = "")
    {
      y.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject1 });
      paramString = new h(paramString, paramLong, paramInt, this.fzn, (String)localObject1);
      g.Dk().a(paramString, 0);
      this.icR.ov(1);
      return;
      localObject1 = null;
      break;
      localObject1 = (kq)((List)localObject1).get(((List)localObject1).size() - 1);
      break label102;
    }
  }
  
  public final void bi(String paramString, int paramInt)
  {
    if (this.icO.isEmpty()) {
      this.icP.setVisibility(8);
    }
    if (paramString == null) {}
    for (;;)
    {
      return;
      paramString = paramString.trim();
      if ((!"".equals(paramString)) && ((!paramString.equals(this.icQ.bGm)) || (this.icW)) && (!this.icQ.idd))
      {
        reset();
        this.icQ.idd = true;
        this.icQ.bGm = paramString;
        this.icV = paramInt;
        if (this.icX != 1)
        {
          g.Dk().a(1070, this);
          this.icS = new i(this.icQ.bGm, this.icQ.icd, this.fzn);
          g.Dk().a(this.icS, 0);
        }
        while (this.icT != null)
        {
          this.icT.axA();
          return;
          if (this.icU.length == 0)
          {
            y.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
            return;
          }
          c(paramString, paramInt, this.icU[0]);
          this.icR.ov(0);
        }
      }
    }
  }
  
  public c getAdapter()
  {
    return this.icO;
  }
  
  public BizSearchResultItemContainer.b getIOnSearchStateChangedListener()
  {
    return this.icT;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 3;
    y.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.icT != null) {
      this.icT.axB();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.icQ.idd = false;
      this.icW = true;
      Toast.makeText(getContext(), getContext().getString(b.h.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
    this.icW = false;
    if (paramm == null)
    {
      y.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
      return;
    }
    if (paramm.getType() == 1070)
    {
      y.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
      g.Dk().b(1070, this);
      paramString = (i)paramm;
      if (paramString.ice == null)
      {
        paramString = null;
        this.icO.h(this.icQ.bGm, paramString);
        paramm = this.icO.cN(this.icU[(this.icU.length - 1)]);
        if ((paramm != null) && (!paramm.icL)) {
          break label374;
        }
        paramInt1 = 0;
        label223:
        if (paramInt1 != 0) {
          break label383;
        }
        paramInt2 = i;
        label230:
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = (kq)paramString.get(paramString.size() - 1);
          if (paramString != null) {
            this.icQ.offset = (paramString.sDT + this.icV);
          }
        }
        if (!this.icO.isEmpty()) {
          break label545;
        }
        new ah(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            TextView localTextView = BizSearchResultItemContainer.e(BizSearchResultItemContainer.this);
            if (BizSearchResultItemContainer.d(BizSearchResultItemContainer.this).isEmpty()) {}
            for (int i = 0;; i = 8)
            {
              localTextView.setVisibility(i);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      this.icQ.icI = paramInt1;
      this.icR.ov(paramInt2);
      this.icQ.idd = false;
      y.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[] { Integer.valueOf(this.icQ.offset) });
      return;
      paramString = paramString.ice.tGF;
      break;
      label374:
      paramInt1 = paramm.icI;
      break label223;
      label383:
      paramInt2 = 2;
      break label230;
      if (paramm.getType() == 1071)
      {
        g.Dk().b(1071, this);
        y.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
        paramString = ((h)paramm).axv();
        if ((paramString == null) || (paramString.kTw == null)) {
          y.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
        }
        if (paramString == null)
        {
          paramInt1 = 0;
          label451:
          if (paramInt1 != 0) {
            break label516;
          }
        }
        label516:
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          this.icO.a(paramString, true);
          if (paramString != null)
          {
            y.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[] { paramString.sFF });
            this.icQ.offset = (paramString.sDT + this.icV);
          }
          break;
          paramInt1 = paramString.sFD;
          break label451;
        }
      }
      y.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[] { Integer.valueOf(paramm.getType()) });
      return;
      label545:
      this.icQ.ide = true;
    }
  }
  
  final void reset()
  {
    this.icO.axz();
    this.icR.ov(0);
    this.icQ.ide = false;
    this.icQ.idd = false;
    this.icQ.offset = 0;
    this.icQ.bGm = null;
    this.icQ.icI = 1;
  }
  
  public void setAdapter(c paramc)
  {
    this.icO = paramc;
    if (this.icO != null)
    {
      this.icO.setScene(this.fzn);
      paramc = this.icN;
      BizSearchResultItemContainer.a locala = this.icR;
      View localView = View.inflate(getContext(), b.e.loading_footer, null);
      locala.ida = localView.findViewById(b.d.loading_progress);
      locala.idb = localView.findViewById(b.d.loading_end);
      locala.idc = localView.findViewById(b.d.loading_tip);
      locala.ida.setVisibility(8);
      locala.idb.setVisibility(8);
      locala.idc.setVisibility(8);
      paramc.addFooterView(localView, null, false);
      this.icN.setAdapter(this.icO);
      this.icN.setOnScrollListener(new BizSearchResultItemContainer.1(this));
      this.icN.setOnItemClickListener(this.icO);
      if (this.icQ.icd == 0L) {
        setBusinessTypes(new long[] { 1L });
      }
      return;
    }
    this.icN.setAdapter(this.icO);
  }
  
  public void setAddContactScene(int paramInt)
  {
    this.icy = paramInt;
    this.icO.setAddContactScene(paramInt);
  }
  
  public void setBusinessTypes(long... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      this.icU = paramVarArgs;
      this.icQ.icd = 0L;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        BizSearchResultItemContainer.c localc = this.icQ;
        localc.icd |= paramVarArgs[i];
        i += 1;
      }
      this.icO.e(paramVarArgs);
    }
  }
  
  public final void setDisplayArgs$25decb5(boolean paramBoolean)
  {
    this.icO.u(paramBoolean, false);
  }
  
  public void setIOnSearchStateChangedListener(BizSearchResultItemContainer.b paramb)
  {
    this.icT = paramb;
  }
  
  public void setMode(int paramInt)
  {
    this.icX = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    super.setOnTouchListener(paramOnTouchListener);
    this.icN.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setReporter(c.b paramb)
  {
    if (this.icO != null) {
      this.icO.setReporter(paramb);
    }
  }
  
  public void setScene(int paramInt)
  {
    this.fzn = paramInt;
    this.icO.setScene(this.fzn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer
 * JD-Core Version:    0.7.0.1
 */