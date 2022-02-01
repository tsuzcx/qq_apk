package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.utils.n.b;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ab;
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
    inflate(paramContext, a.g.mall_wallet_section_layout, this);
    setOrientation(1);
    AppMethodBeat.o(66161);
  }
  
  public final void a(ddc paramddc, boolean paramBoolean, com.tencent.mm.plugin.appbrand.api.i parami, n.b paramb)
  {
    AppMethodBeat.i(262401);
    if (paramddc.aaIH != null)
    {
      h.baF();
      String str1 = (String)h.baE().ban().get(at.a.acUU, "");
      if (!Util.isNullOrNil(str1)) {}
      JSONObject localJSONObject;
      int j;
      int k;
      int i;
      fll localfll;
      label291:
      String str2;
      for (;;)
      {
        long l;
        try
        {
          localJSONObject = new JSONObject(str1);
          j = getChildCount();
          k = paramddc.aaIH.size();
          Log.i("MicroMsg.MallWalletSectionView", "cell size: %s", new Object[] { Integer.valueOf(k) });
          i = 0;
          if (i >= k) {
            break label456;
          }
          localfll = (fll)paramddc.aaIH.get(i);
          str1 = null;
          if (!"balance_cell".equals(localfll.YMe)) {
            break label291;
          }
          l = ((Long)((a)h.az(a.class)).getWalletCacheStg().get(at.a.acVr, Long.valueOf(0L))).longValue();
          str1 = getContext().getString(a.i.wallet_rmb_symbol) + com.tencent.mm.wallet_core.ui.i.formatMoney2f(com.tencent.mm.wallet_core.ui.i.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
          if (i >= j) {
            break;
          }
          Log.d("MicroMsg.MallWalletSectionView", "update view");
          localMallWalletSectionCellView = (MallWalletSectionCellView)getChildAt(i);
          if (i >= k - 1) {
            break label386;
          }
          bool = true;
          localMallWalletSectionCellView.a(localfll, localJSONObject, bool, str1, paramBoolean, parami, paramb);
          i += 1;
          continue;
          localJSONObject = null;
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.MallWalletSectionView", localJSONException, "", new Object[0]);
        }
        continue;
        if ("lqt_cell".equals(localfll.YMe))
        {
          l = ((Long)((a)h.az(a.class)).getWalletCacheStg().get(at.a.acVs, Long.valueOf(0L))).longValue();
          str2 = getContext().getString(a.i.wallet_rmb_symbol) + com.tencent.mm.wallet_core.ui.i.formatMoney2f(com.tencent.mm.wallet_core.ui.i.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
          continue;
          label386:
          bool = false;
        }
      }
      Log.d("MicroMsg.MallWalletSectionView", "insert view");
      MallWalletSectionCellView localMallWalletSectionCellView = new MallWalletSectionCellView(getContext());
      if (i < k - 1) {}
      for (boolean bool = true;; bool = false)
      {
        localMallWalletSectionCellView.a(localfll, localJSONObject, bool, str2, paramBoolean, parami, paramb);
        addView(localMallWalletSectionCellView);
        break;
      }
      label456:
      if (j > k)
      {
        Log.d("MicroMsg.MallWalletSectionView", "remove layout");
        removeViews(k, j - k);
      }
    }
    AppMethodBeat.o(262401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionView
 * JD-Core Version:    0.7.0.1
 */