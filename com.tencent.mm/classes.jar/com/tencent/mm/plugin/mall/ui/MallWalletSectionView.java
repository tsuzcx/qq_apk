package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class MallWalletSectionView
  extends LinearLayout
{
  public MallWalletSectionView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66158);
    init(paramContext);
    AppMethodBeat.o(66158);
  }
  
  public MallWalletSectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66159);
    init(paramContext);
    AppMethodBeat.o(66159);
  }
  
  public MallWalletSectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66160);
    init(paramContext);
    AppMethodBeat.o(66160);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66161);
    inflate(paramContext, 2131494728, this);
    setOrientation(1);
    AppMethodBeat.o(66161);
  }
  
  public final void a(brb parambrb, boolean paramBoolean)
  {
    AppMethodBeat.i(66162);
    if (parambrb.Heh != null)
    {
      g.ajS();
      String str1 = (String)g.ajR().ajA().get(am.a.IWL, "");
      if (!bu.isNullOrNil(str1)) {}
      JSONObject localJSONObject;
      int j;
      int k;
      int i;
      dmr localdmr;
      label279:
      String str2;
      for (;;)
      {
        long l;
        try
        {
          localJSONObject = new JSONObject(str1);
          j = getChildCount();
          k = parambrb.Heh.size();
          ae.i("MicroMsg.MallWalletSectionView", "cell size: %s", new Object[] { Integer.valueOf(k) });
          i = 0;
          if (i >= k) {
            break label439;
          }
          localdmr = (dmr)parambrb.Heh.get(i);
          str1 = null;
          if (!"balance_cell".equals(localdmr.FUn)) {
            break label279;
          }
          l = ((Long)((a)g.ad(a.class)).getWalletCacheStg().get(am.a.IXh, Long.valueOf(0L))).longValue();
          str1 = getContext().getString(2131765813) + f.C(f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
          if (i >= j) {
            break;
          }
          ae.d("MicroMsg.MallWalletSectionView", "update view");
          localMallWalletSectionCellView = (MallWalletSectionCellView)getChildAt(i);
          if (i >= k - 1) {
            break label373;
          }
          bool = true;
          localMallWalletSectionCellView.a(localdmr, localJSONObject, bool, str1, paramBoolean);
          i += 1;
          continue;
          localJSONObject = null;
        }
        catch (JSONException localJSONException)
        {
          ae.printErrStackTrace("MicroMsg.MallWalletSectionView", localJSONException, "", new Object[0]);
        }
        continue;
        if ("lqt_cell".equals(localdmr.FUn))
        {
          l = ((Long)((a)g.ad(a.class)).getWalletCacheStg().get(am.a.IXi, Long.valueOf(0L))).longValue();
          str2 = getContext().getString(2131765813) + f.C(f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
          continue;
          label373:
          bool = false;
        }
      }
      ae.d("MicroMsg.MallWalletSectionView", "insert view");
      MallWalletSectionCellView localMallWalletSectionCellView = new MallWalletSectionCellView(getContext());
      if (i < k - 1) {}
      for (boolean bool = true;; bool = false)
      {
        localMallWalletSectionCellView.a(localdmr, localJSONObject, bool, str2, paramBoolean);
        addView(localMallWalletSectionCellView);
        break;
      }
      label439:
      if (j > k)
      {
        ae.d("MicroMsg.MallWalletSectionView", "remove layout");
        removeViews(k, j - k);
      }
    }
    AppMethodBeat.o(66162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionView
 * JD-Core Version:    0.7.0.1
 */