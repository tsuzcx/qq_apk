package com.tencent.mm.plugin.finder.live.view.convert;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.w.a.a.a.i;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "Lcom/tencent/mm/protocal/protobuf/FinderShopCouponInfo;", "data", "(Lcom/tencent/mm/protocal/protobuf/FinderShopCouponInfo;)V", "anchorSending", "", "getAnchorSending", "()Z", "setAnchorSending", "(Z)V", "couponId", "", "getCouponId", "()Ljava/lang/String;", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderShopCouponInfo;", "discount", "getDiscount", "setDiscount", "(Ljava/lang/String;)V", "discountDesc", "getDiscountDesc", "setDiscountDesc", "dueDate", "getDueDate", "setDueDate", "extBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getExtBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setExtBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "format", "Ljava/text/DecimalFormat;", "getFormat", "()Ljava/text/DecimalFormat;", "mPromoteId", "", "getMPromoteId", "()J", "setMPromoteId", "(J)V", "remainCount", "getRemainCount", "setRemainCount", "source", "getSource", "setSource", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "stockId", "getStockId", "title", "getTitle", "setTitle", "type", "getType", "setType", "useCondition", "getUseCondition", "setUseCondition", "visitorCanReceive", "getVisitorCanReceive", "setVisitorCanReceive", "visitorReceiveActionWording", "getVisitorReceiveActionWording", "setVisitorReceiveActionWording", "visitorReceived", "getVisitorReceived", "setVisitorReceived", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "other", "", "getExBuf", "getItemId", "getItemType", "getPromoteData", "getPromoteId", "hashCode", "showSuccessToast", "", "context", "Landroid/content/Context;", "toString", "update", "buttonWording", "couponStatus", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements cc, com.tencent.mm.plugin.j<bvo>
{
  public static final a DUU;
  private static final SimpleDateFormat DVh;
  public long DUI;
  public b DUJ;
  public final bvo DUV;
  private final String DUW;
  public String DUX;
  public String DUY;
  public long DUZ;
  public String DVa;
  public String DVb;
  public boolean DVc;
  public boolean DVd;
  public boolean DVe;
  public String DVf;
  private final DecimalFormat DVg;
  public final String mdN;
  public String source;
  private int sourceType;
  public String title;
  public int type;
  
  static
  {
    AppMethodBeat.i(358235);
    DUU = new a((byte)0);
    DVh = new SimpleDateFormat(a.bt(MMApplicationContext.getContext(), a.i.fmt_longdate_with_full), Locale.ENGLISH);
    AppMethodBeat.o(358235);
  }
  
  public j(bvo parambvo)
  {
    AppMethodBeat.i(358232);
    this.DUV = parambvo;
    this.DUW = this.DUV.aadf;
    this.mdN = this.DUV.mdE;
    this.type = this.DUV.type;
    this.sourceType = this.DUV.aadm;
    this.DVf = "";
    this.DVg = new DecimalFormat("0.##");
    Object localObject1 = MMApplicationContext.getContext();
    long l;
    label145:
    int i;
    switch (this.type)
    {
    default: 
      if (this.DUV.aadk == 0L)
      {
        l = 4294967295L;
        parambvo = this.DUV.aadq;
        if (parambvo == null) {
          break label914;
        }
        if (((CharSequence)parambvo).length() <= 0) {
          break label909;
        }
        i = 1;
        label171:
        if (i != 1) {
          break label914;
        }
        i = 1;
        label178:
        if (i == 0) {
          break label919;
        }
      }
      break;
    }
    for (this.DVa = this.DUV.aadq;; this.DVa = parambvo)
    {
      this.DUZ = this.DUV.aadl;
      this.title = this.DUV.ZbX;
      this.DVb = this.DUY;
      if (this.DUV.aadg == 2) {
        bool = true;
      }
      this.DVc = bool;
      this.source = this.DUV.aadn;
      localObject1 = this.DUV.wul;
      parambvo = (bvo)localObject1;
      if (localObject1 == null) {
        parambvo = "";
      }
      eA(parambvo, this.DUV.ZUG);
      Log.i("MicroMsg.ShopWindowCouponItem", toString());
      AppMethodBeat.o(358232);
      return;
      this.DUX = this.DVg.format(this.DUV.aadh / 100.0D);
      parambvo = am.aixg;
      parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_price_break_discount_desc);
      s.s(parambvo, "getString(context, R.str…rice_break_discount_desc)");
      Object localObject2 = this.DVg;
      aff localaff = this.DUV.aadp;
      if (localaff == null) {}
      for (i = 0;; i = localaff.MRD)
      {
        parambvo = String.format(parambvo, Arrays.copyOf(new Object[] { ((DecimalFormat)localObject2).format(i / 100.0D) }, 1));
        s.s(parambvo, "java.lang.String.format(format, *args)");
        this.DUY = parambvo;
        break;
      }
      this.DUX = this.DVg.format(this.DUV.aadh / 1000.0D);
      parambvo = this.DUV.aadp;
      if (parambvo == null)
      {
        i = 0;
        label456:
        if (i <= 0) {
          break label561;
        }
        parambvo = am.aixg;
        parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_price_break_discount_desc);
        s.s(parambvo, "getString(context, R.str…rice_break_discount_desc)");
        localObject2 = this.DVg;
        localaff = this.DUV.aadp;
        if (localaff != null) {
          break label552;
        }
        i = 0;
        label502:
        parambvo = String.format(parambvo, Arrays.copyOf(new Object[] { ((DecimalFormat)localObject2).format(i / 100.0D) }, 1));
        s.s(parambvo, "java.lang.String.format(format, *args)");
      }
      for (;;)
      {
        this.DUY = parambvo;
        break;
        i = parambvo.MRD;
        break label456;
        label552:
        i = localaff.MRD;
        break label502;
        label561:
        parambvo = this.DUV.aadp;
        if (parambvo == null)
        {
          i = 0;
          label575:
          if (i <= 0) {
            break label662;
          }
          parambvo = am.aixg;
          parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_condition_count);
          s.s(parambvo, "getString(context, R.str…g_coupon_condition_count)");
          localObject2 = this.DUV.aadp;
          if (localObject2 != null) {
            break label653;
          }
        }
        label653:
        for (i = 0;; i = ((aff)localObject2).ZnA)
        {
          parambvo = String.format(parambvo, Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
          s.s(parambvo, "java.lang.String.format(format, *args)");
          break;
          i = parambvo.ZnA;
          break label575;
        }
        label662:
        if (this.DUV.aado > 0) {
          parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_direct_discount_desc);
        } else {
          parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_contractral_discount_desc);
        }
      }
      this.DUX = this.DVg.format(this.DUV.aadh / 100.0D);
      if (this.DUV.aado > 0) {}
      for (parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_direct_discount_desc);; parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_contractral_discount_desc))
      {
        this.DUY = parambvo;
        break;
      }
      if (this.DUV.aadh == 0L) {}
      for (parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_free);; parambvo = this.DVg.format(this.DUV.aadh / 100.0D))
      {
        this.DUX = parambvo;
        this.DUY = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_trade_discount_desc);
        break;
      }
      int j = a.i.finder_live_shopping_coupon_buy_get;
      parambvo = this.DUV.aadp;
      if (parambvo == null) {}
      for (i = 0;; i = parambvo.ZnA)
      {
        this.DUX = ((Context)localObject1).getString(j, new Object[] { Integer.valueOf(i), Long.valueOf(this.DUV.aadh) });
        this.DUY = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_buy_one_get_one_desc);
        break;
      }
      l = this.DUV.aadk;
      break label145;
      label909:
      i = 0;
      break label171;
      label914:
      i = 0;
      break label178;
      label919:
      parambvo = am.aixg;
      parambvo = a.bt((Context)localObject1, a.i.finder_live_shopping_coupon_due_date);
      s.s(parambvo, "getString(context, R.str…shopping_coupon_due_date)");
      parambvo = String.format(parambvo, Arrays.copyOf(new Object[] { DVh.format(new Date(l * 1000L)) }, 1));
      s.s(parambvo, "java.lang.String.format(format, *args)");
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358275);
    s.u(paramk, "obj");
    if (((paramk instanceof j)) && (s.p(((j)paramk).mdN, this.mdN)))
    {
      AppMethodBeat.o(358275);
      return 0;
    }
    AppMethodBeat.o(358275);
    return -1;
  }
  
  public final b bUA()
  {
    return this.DUJ;
  }
  
  public final long bUz()
  {
    return this.DUI;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(358263);
    String str = this.mdN;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = i;
      AppMethodBeat.o(358263);
      return l;
    }
  }
  
  public final int bZB()
  {
    return 2;
  }
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(358249);
    int i;
    if (paramString != null) {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label78;
        }
        i = 1;
        label31:
        if (i != 0) {
          this.DVf = paramString;
        }
        if (paramInt != 0)
        {
          this.DUV.ZUG = paramInt;
          if (paramInt != 1) {
            break label83;
          }
        }
      }
    }
    label78:
    label83:
    for (boolean bool = true;; bool = false)
    {
      this.DVe = bool;
      AppMethodBeat.o(358249);
      return;
      i = 0;
      break;
      i = 0;
      break label31;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(358280);
    if (this == paramObject)
    {
      AppMethodBeat.o(358280);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(358280);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.convert.ShopWindowCouponItem");
      AppMethodBeat.o(358280);
      throw paramObject;
    }
    if (!s.p(this.mdN, ((j)paramObject).mdN))
    {
      AppMethodBeat.o(358280);
      return false;
    }
    AppMethodBeat.o(358280);
    return true;
  }
  
  public final void gH(Context paramContext)
  {
    AppMethodBeat.i(358252);
    s.u(paramContext, "context");
    if (this.sourceType == 1)
    {
      aa.showTextToast(paramContext, a.bt(paramContext, a.i.finder_live_shopping_coupon_received_pay));
      AppMethodBeat.o(358252);
      return;
    }
    aa.db(paramContext, a.bt(paramContext, a.i.finder_live_shopping_coupon_received));
    AppMethodBeat.o(358252);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(358285);
    String str = this.mdN;
    if (str == null)
    {
      AppMethodBeat.o(358285);
      return 0;
    }
    int i = str.hashCode();
    AppMethodBeat.o(358285);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358258);
    String str = "ShopWindowCouponItem " + this.mdN + ' ' + this.type + ' ' + this.title + ' ' + this.DUY + ' ' + this.DUX + ' ' + this.DUV.aadg + ' ' + this.DUV.ZUG + ' ' + this.DVf + ' ' + this.sourceType + ' ' + this.DUZ;
    AppMethodBeat.o(358258);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem$Companion;", "", "()V", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "getDATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.j
 * JD-Core Version:    0.7.0.1
 */