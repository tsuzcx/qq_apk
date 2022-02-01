package com.tencent.mm.plugin.finder.live.olympic.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import com.tencent.d.a.a.a.b.b.d;
import com.tencent.d.a.a.a.b.b.d.a;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.live.olympic.n;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bl;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/util/OlympicUtils;", "", "()V", "FINLDER_LIVE_OLYMPIC_CERT_BUBBLE_SHOW", "", "FINLDER_LIVE_OLYMPIC_CERT_LOCATION_SHOW", "LBS_TAB_LOCATION_DURATION", "", "LOW_DEVICE_RATE", "", "TAG", "originDensity", "checkLocationPermission", "", "doTpPx", "dp", "getCertificateIdString", "num", "", "getCertificateStatePath", "getLocationValidTime", "getScaleDensity", "context", "Landroid/content/Context;", "getTorcherCountString", "isLowScreenDevice", "isNeedShowCertBubble", "isNeedShowLocationDialog", "makeCommentText", "Landroid/text/SpannableStringBuilder;", "data", "Lcom/tencent/mm/protocal/protobuf/Comment;", "nicknameColor", "commentColor", "setHasShowCertBubble", "", "hasShow", "setHasShowLocation", "setConfigResources", "Landroid/widget/ImageView;", "resourcesType", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsOlympics$ResType;", "defaultId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a CRW;
  private static final float CRX;
  
  static
  {
    AppMethodBeat.i(360724);
    CRW = new a();
    CRX = c.iRA();
    AppMethodBeat.o(360724);
  }
  
  public static int OT(int paramInt)
  {
    AppMethodBeat.i(360708);
    Log.i("OlympicUtils", kotlin.g.b.s.X("doTpPx originDensity: ", Float.valueOf(CRX)));
    paramInt = kotlin.h.a.eH(CRX * paramInt);
    AppMethodBeat.o(360708);
    return paramInt;
  }
  
  public static SpannableStringBuilder a(Context paramContext, aep paramaep, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(360674);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramaep, "data");
    int i = paramaep.type;
    Object localObject1 = b.d.ahoj;
    Object localObject2;
    String str;
    if (i == b.d.a.jVW())
    {
      localObject1 = new SpannableStringBuilder((CharSequence)kotlin.g.b.s.X(paramaep.nickname, ": "));
      localObject2 = new ForegroundColorSpan(paramInt1);
      str = paramaep.nickname;
      if (str == null)
      {
        paramInt1 = 0;
        ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, paramInt1 + 1, 17);
      }
    }
    for (;;)
    {
      localObject2 = paramaep.msg;
      paramaep = (aep)localObject2;
      if (localObject2 == null) {
        paramaep = "";
      }
      ((SpannableStringBuilder)localObject1).append((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)paramaep));
      paramaep = bb.m(paramContext, p.g.finder_olympics_star, paramInt2);
      paramaep.setBounds(0, 0, (int)paramContext.getResources().getDimension(p.c.Edge_2_5_A), (int)paramContext.getResources().getDimension(p.c.Edge_2_5_A));
      paramContext = new com.tencent.mm.ui.widget.a(paramaep, 0);
      ((SpannableStringBuilder)localObject1).insert(0, (CharSequence)" ");
      ((SpannableStringBuilder)localObject1).setSpan(paramContext, 0, 1, 17);
      AppMethodBeat.o(360674);
      return localObject1;
      paramInt1 = str.length();
      break;
      localObject1 = new SpannableStringBuilder((CharSequence)kotlin.g.b.s.X(paramaep.nickname, " "));
    }
  }
  
  public static void a(final ImageView paramImageView, b.j paramj, final int paramInt)
  {
    AppMethodBeat.i(360717);
    kotlin.g.b.s.u(paramImageView, "<this>");
    kotlin.g.b.s.u(paramj, "resourcesType");
    j.a(ar.kBZ(), null, null, (m)new a(paramj, paramImageView, paramInt, null), 3);
    AppMethodBeat.o(360717);
  }
  
  public static int eop()
  {
    AppMethodBeat.i(360648);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      n localn = n.COU;
      int i = ((Number)n.enM().bmg()).intValue();
      if (i == 0)
      {
        AppMethodBeat.o(360648);
        return 600000;
      }
      AppMethodBeat.o(360648);
      return i;
    }
    AppMethodBeat.o(360648);
    return 600000;
  }
  
  public static String eoq()
  {
    AppMethodBeat.i(360663);
    Object localObject = bm.GlZ;
    localObject = kotlin.g.b.s.X(bm.fim(), "olympic_state.jpg");
    AppMethodBeat.o(360663);
    return localObject;
  }
  
  public static boolean eor()
  {
    AppMethodBeat.i(360678);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.aBP().getInt("finder_live_olympic_cert_bubble_show", 0) == 0)
    {
      AppMethodBeat.o(360678);
      return true;
    }
    AppMethodBeat.o(360678);
    return false;
  }
  
  public static void eos()
  {
    AppMethodBeat.i(360681);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.aBP().putInt("finder_live_olympic_cert_bubble_show", 1);
    AppMethodBeat.o(360681);
  }
  
  public static boolean eot()
  {
    AppMethodBeat.i(360690);
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    boolean bool = ((g)com.tencent.mm.ui.component.k.cn(cn.class).cq(g.class)).dUi();
    AppMethodBeat.o(360690);
    return bool;
  }
  
  public static boolean eou()
  {
    AppMethodBeat.i(360695);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.aBP().getInt("finder_live_olympic_cert_location_show", 0) == 0)
    {
      AppMethodBeat.o(360695);
      return true;
    }
    AppMethodBeat.o(360695);
    return false;
  }
  
  public static void eov()
  {
    AppMethodBeat.i(360703);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.aBP().putInt("finder_live_olympic_cert_location_show", 1);
    AppMethodBeat.o(360703);
  }
  
  public static float gy(Context paramContext)
  {
    AppMethodBeat.i(360713);
    kotlin.g.b.s.u(paramContext, "context");
    float f = com.tencent.mm.cd.a.getScaleSize(paramContext);
    if (f < 1.0F)
    {
      AppMethodBeat.o(360713);
      return 1.0F;
    }
    Log.i("OlympicUtils", kotlin.g.b.s.X("getScaleDensity currentScale: ", Float.valueOf(f)));
    f = 1.0F / f;
    AppMethodBeat.o(360713);
    return f;
  }
  
  public static boolean jdp()
  {
    AppMethodBeat.i(371591);
    if (bf.bf(MMApplicationContext.getContext()).x / bf.bf(MMApplicationContext.getContext()).y >= 0.54F)
    {
      AppMethodBeat.o(371591);
      return true;
    }
    AppMethodBeat.o(371591);
    return false;
  }
  
  public static String on(long paramLong)
  {
    AppMethodBeat.i(360656);
    String str = new DecimalFormat("0000000000").format(paramLong);
    kotlin.g.b.s.s(str, "DecimalFormat(\"0000000000\").format(num)");
    AppMethodBeat.o(360656);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(b.j paramj, ImageView paramImageView, int paramInt, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(360649);
      paramObject = (kotlin.d.d)new a(this.CRY, paramImageView, paramInt, paramd);
      AppMethodBeat.o(360649);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(360642);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(360642);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new ah.f();
        paramObject.aqH = "";
        localObject1 = new ah.a();
        f localf = (f)bg.kCi();
        m localm = (m)new kotlin.d.b.a.k(paramObject, this.CRY)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(360645);
            paramAnonymousObject = (kotlin.d.d)new 1(this.CRs, this.CRY, this.CQx, paramAnonymousd);
            AppMethodBeat.o(360645);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(360640);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(360640);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.CRs;
            localObject = bl.GlV;
            paramAnonymousObject.aqH = bl.b(this.CRY).bsC;
            this.CQx.aiwY = y.ZC((String)this.CRs.aqH);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(360640);
            return paramAnonymousObject;
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localObject1;
        this.label = 1;
        if (l.a(localf, localm, locald) == localObject2)
        {
          AppMethodBeat.o(360642);
          return localObject2;
        }
        break;
      case 1: 
        localObject1 = (ah.a)this.Uf;
        localObject2 = (ah.f)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject2;
      }
      for (;;)
      {
        Log.i("OlympicUtils", "resourcesType: " + this.CRY + " , isFileExit: " + ((ah.a)localObject1).aiwY + " , resPath: " + (String)paramObject.aqH + ' ');
        if (!((ah.a)localObject1).aiwY) {
          paramImageView.setImageResource(paramInt);
        }
        for (;;)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(360642);
          return paramObject;
          localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
          com.tencent.mm.plugin.finder.loader.p.eCl().dj(new com.tencent.mm.plugin.finder.loader.s((String)paramObject.aqH, v.FKY)).d(paramImageView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.util.a
 * JD-Core Version:    0.7.0.1
 */