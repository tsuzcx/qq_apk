package com.tencent.mm.accessibility.core;

import android.content.Context;
import android.text.TextUtils.SimpleStringSplitter;
import android.text.format.DateUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.autogen.mmdata.rpt.lx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.auth.a.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccReporter;", "", "()V", "TAG", "", "autoAuthCallback", "Lcom/tencent/mm/vending/callbacks/CallbackProperty;", "addHasReportedType", "", "types", "", "", "getAccServiceTypeArray", "", "getHasReportedType", "", "getLastRepReportTime", "", "initListener", "overwriteHasReportedType", "releaseListener", "reportAppTypeIfNeed", "reportInternal", "reportTouchExplorationEnable", "saveReportTime", "time", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccReporter
{
  public static final AccReporter INSTANCE;
  public static final String TAG = "MicroMsg.Acc.AccReporter";
  private static com.tencent.mm.vending.b.b<?> autoAuthCallback;
  
  static
  {
    AppMethodBeat.i(234197);
    INSTANCE = new AccReporter();
    AppMethodBeat.o(234197);
  }
  
  private final void addHasReportedType(int... paramVarArgs)
  {
    AppMethodBeat.i(234164);
    Set localSet = p.u((Iterable)getHasReportedType());
    Collection localCollection = (Collection)localSet;
    s.u(paramVarArgs, "$this$toTypedArray");
    Integer[] arrayOfInteger = new Integer[paramVarArgs.length];
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramVarArgs[i]);
      i += 1;
    }
    p.a(localCollection, arrayOfInteger);
    paramVarArgs = p.a((Iterable)localSet, (CharSequence)";", null, null, 0, null, null, 62);
    MultiProcessMMKV.getDefault().putString("HasReportDataString", paramVarArgs);
    AppMethodBeat.o(234164);
  }
  
  private final List<Integer> getHasReportedType()
  {
    AppMethodBeat.i(234179);
    Object localObject2 = MultiProcessMMKV.getDefault().getString("HasReportDataString", "");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = (Iterable)n.a((CharSequence)localObject1, new String[] { ";" });
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = n.bJF((String)((Iterator)localObject2).next());
      if (localInteger != null) {
        ((Collection)localObject1).add(localInteger);
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(234179);
    return localObject1;
  }
  
  private final long getLastRepReportTime()
  {
    AppMethodBeat.i(234154);
    long l = MultiProcessMMKV.getDefault().getLong("LastReportTimeLong", 0L);
    AppMethodBeat.o(234154);
    return l;
  }
  
  private final void overwriteHasReportedType(int... paramVarArgs)
  {
    AppMethodBeat.i(234170);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getDefault();
    s.u(paramVarArgs, "$this$toSet");
    switch (paramVarArgs.length)
    {
    default: 
      paramVarArgs = (Set)k.a(paramVarArgs, (Collection)new LinkedHashSet(ak.aKi(paramVarArgs.length)));
    }
    for (;;)
    {
      localMultiProcessMMKV.putString("HasReportDataString", p.a((Iterable)paramVarArgs, (CharSequence)";", null, null, 0, null, null, 62));
      AppMethodBeat.o(234170);
      return;
      paramVarArgs = (Set)ad.aivA;
      continue;
      paramVarArgs = ar.setOf(Integer.valueOf(paramVarArgs[0]));
    }
  }
  
  private final void reportInternal(List<Integer> paramList)
  {
    AppMethodBeat.i(234187);
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      int i = ((Number)paramList.next()).intValue();
      Log.i("MicroMsg.Acc.AccReporter", s.X("reportInternal: ", Integer.valueOf(i)));
      lx locallx = new lx();
      locallx.jax = i;
      locallx.bMH();
    }
    AppMethodBeat.o(234187);
  }
  
  private final void saveReportTime(long paramLong)
  {
    AppMethodBeat.i(234145);
    MultiProcessMMKV.getDefault().putLong("LastReportTimeLong", paramLong);
    AppMethodBeat.o(234145);
  }
  
  public final List<Integer> getAccServiceTypeArray()
  {
    AppMethodBeat.i(234223);
    Object localObject = MMApplicationContext.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("enabled_accessibility_services").cG(localObject);
    String str = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/accessibility/core/AccReporter", "getAccServiceTypeArray", "()Ljava/util/List;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    localObject = (List)new ArrayList();
    if (str != null)
    {
      TextUtils.SimpleStringSplitter localSimpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
      localSimpleStringSplitter.setString(str);
      while (localSimpleStringSplitter.hasNext())
      {
        str = localSimpleStringSplitter.next();
        s.s(str, "splitter.next()");
        Log.i("MicroMsg.Acc.AccReporter", s.X("getAccServiceTypeArray: ", str));
        if ((n.i((CharSequence)str, (CharSequence)"TalkBackService")) && (n.i((CharSequence)str, (CharSequence)"com.google.android.marvin"))) {
          ((List)localObject).add(Integer.valueOf(1));
        } else if ((n.i((CharSequence)str, (CharSequence)"ScreenReaderService")) && (n.i((CharSequence)str, (CharSequence)"com.bjbyhd.screenreader_huawei"))) {
          ((List)localObject).add(Integer.valueOf(2));
        } else if ((n.i((CharSequence)str, (CharSequence)"TalkManAccessibilityService")) && (n.i((CharSequence)str, (CharSequence)"com.nirenr.talkman"))) {
          ((List)localObject).add(Integer.valueOf(4));
        } else if ((n.i((CharSequence)str, (CharSequence)"MyAccessibilityService")) && (n.i((CharSequence)str, (CharSequence)"com.dianming.phoneapp"))) {
          ((List)localObject).add(Integer.valueOf(3));
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      ((List)localObject).add(Integer.valueOf(0));
    }
    AppMethodBeat.o(234223);
    return localObject;
  }
  
  public final void initListener()
  {
    AppMethodBeat.i(234201);
    autoAuthCallback = ((c)h.az(c.class)).addHandleAuthResponse((com.tencent.mm.plugin.auth.a.b)new com.tencent.mm.plugin.auth.a.b()
    {
      public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234149);
        s.u(paramAnonymoush, "req");
        s.u(paramAnonymousi, "resp");
        AccReporter.INSTANCE.reportAppTypeIfNeed();
        AppMethodBeat.o(234149);
      }
      
      public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234155);
        s.u(paramAnonymousb, "resp");
        s.u(paramAnonymousString1, "alias");
        s.u(paramAnonymousString2, "nick");
        s.u(paramAnonymousString3, "mobile");
        AppMethodBeat.o(234155);
      }
    });
    AppMethodBeat.o(234201);
  }
  
  public final void releaseListener()
  {
    AppMethodBeat.i(234205);
    com.tencent.mm.vending.b.b localb = autoAuthCallback;
    if (localb != null) {
      localb.dead();
    }
    AppMethodBeat.o(234205);
  }
  
  public final void reportAppTypeIfNeed()
  {
    int j = 1;
    AppMethodBeat.i(234211);
    if (!h.baz())
    {
      AppMethodBeat.o(234211);
      return;
    }
    if (AccUtil.INSTANCE.isAccessibilityEnabled()) {
      if (DateUtils.isToday(getLastRepReportTime())) {
        break label156;
      }
    }
    label156:
    for (int i = 1;; i = 0)
    {
      Object localObject = getAccServiceTypeArray();
      if (!((Collection)localObject).isEmpty()) {
        if (j != 0)
        {
          if (i == 0) {
            break label109;
          }
          reportInternal((List)localObject);
          localObject = p.I((Collection)localObject);
          overwriteHasReportedType(Arrays.copyOf((int[])localObject, localObject.length));
        }
      }
      for (;;)
      {
        saveReportTime(System.currentTimeMillis());
        AppMethodBeat.o(234211);
        return;
        j = 0;
        break;
        label109:
        ((List)localObject).removeAll((Collection)INSTANCE.getHasReportedType());
        ah localah = ah.aiuX;
        reportInternal((List)localObject);
        localObject = p.I((Collection)localObject);
        addHasReportedType(Arrays.copyOf((int[])localObject, localObject.length));
      }
    }
  }
  
  public final void reportTouchExplorationEnable()
  {
    AppMethodBeat.i(234230);
    f.Ozc.idkeyStat(1784L, 0L, 1L, false);
    AppMethodBeat.o(234230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.AccReporter
 * JD-Core Version:    0.7.0.1
 */