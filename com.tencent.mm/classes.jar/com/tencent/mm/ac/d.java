package com.tencent.mm.ac;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"checkUICost", "T", "tag", "", "thresholdMs", "", "isThrowException", "", "call", "Lkotlin/Function0;", "(Ljava/lang/String;JZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "codeConsume", "R", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "list", "", "createMMHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "name", "createMediaCodecThread", "Landroid/os/HandlerThread;", "isAfterAutoSafeQuit", "drawable2Bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getCaller", "idle", "long2UnsignedString", "seq", "multiLet", "T1", "", "T2", "p1", "p2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "opAddFlag", "", "value", "flag", "opCheckFlag", "opCleanFlag", "removeUiRunnable", "task", "Ljava/lang/Runnable;", "reverseConsumeList", "rxPipeLine", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Ljava/lang/Void;", "threadPool", "taskName", "isPrintLog", "threadPoolTag", "threadPoolTagDelayed", "delay", "toBitmap8888", "source", "uiThread", "unsignedString2Long", "copyBooleanExtra", "Landroid/content/Intent;", "other", "key", "defaultValue", "bundle", "Landroid/os/Bundle;", "copyIntExtra", "copyStringArrayListExtra", "copyStringExtra", "filter", "Landroid/util/LongSparseArray;", "func", "Lkotlin/ParameterName;", "k", "v", "forEach", "getLocationInWindow", "", "Landroid/view/View;", "getLocationOnScreen", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeGetBoolean", "Lorg/json/JSONObject;", "safeGetInt", "default", "safeGetString", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedFilter", "", "predicate", "", "K", "V", "", "synchronizedFilterIndexed", "index", "synchronizedForEach", "action", "synchronizedForEachIndexed", "synchronizedIndexOfFirst", "synchronizedLastOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedRemoveAll", "", "synchronizedRemoveFirstOrNull", "Ljava/util/HashSet;", "t", "(Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "thread", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Landroid/database/Cursor;", "toLinkedList", "Ljava/util/LinkedList;", "ui", "wxRemoveFirst", "wxRemoveIf", "wxSubString", "start", "end", "libktcomm_release"})
public final class d
{
  public static final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(204379);
    p.h(paramRunnable, "task");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (p.j(localThread, localLooper.getThread()))
    {
      paramRunnable.run();
      AppMethodBeat.o(204379);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(204379);
  }
  
  public static final void C(Runnable paramRunnable)
  {
    AppMethodBeat.i(204381);
    p.h(paramRunnable, "task");
    MMHandlerThread.removeRunnable(paramRunnable);
    AppMethodBeat.o(204381);
  }
  
  public static final long Ga(String paramString)
  {
    AppMethodBeat.i(168822);
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label34;
      }
    }
    label34:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168822);
      return 0L;
    }
    try
    {
      l = new BigInteger(paramString).longValue();
      AppMethodBeat.o(168822);
      return l;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("Common.Kt", paramString, "", new Object[0]);
        long l = 0L;
      }
    }
  }
  
  public static final String Gb(String paramString)
  {
    AppMethodBeat.i(204397);
    p.h(paramString, "$this$wxSubString");
    if (1 > paramString.length())
    {
      paramString = paramString.toString();
      AppMethodBeat.o(204397);
      return paramString;
    }
    paramString = paramString.substring(0, 1);
    p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(204397);
    return paramString;
  }
  
  public static final <R> HandlerThread a(String paramString, final boolean paramBoolean, final kotlin.g.a.a<? extends R> parama)
  {
    AppMethodBeat.i(182804);
    p.h(paramString, "name");
    p.h(parama, "block");
    paramString = com.tencent.f.c.d.hB(paramString, 5);
    paramString.start();
    new MMHandler(paramString.getLooper()).post((Runnable)new b(paramString, parama, paramBoolean));
    p.g(paramString, "SpecialThreadFactory.cre…        }\n        }\n    }");
    AppMethodBeat.o(182804);
    return paramString;
  }
  
  public static final <T> LongSparseArray<T> a(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, Boolean> paramm)
  {
    AppMethodBeat.i(204389);
    p.h(paramLongSparseArray, "$this$filter");
    p.h(paramm, "func");
    LongSparseArray localLongSparseArray = new LongSparseArray();
    int j = paramLongSparseArray.size();
    int i = 0;
    while (i < j)
    {
      long l = paramLongSparseArray.keyAt(i);
      Object localObject = paramLongSparseArray.valueAt(i);
      if (((Boolean)paramm.invoke(Long.valueOf(l), localObject)).booleanValue()) {
        localLongSparseArray.put(l, localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(204389);
    return localLongSparseArray;
  }
  
  public static final <T extends com.tencent.mm.bw.a> T a(T paramT, byte[] paramArrayOfByte, b<? super Exception, x> paramb)
  {
    AppMethodBeat.i(153455);
    p.h(paramT, "$this$safeParser");
    p.h(paramb, "block");
    try
    {
      paramT.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(153455);
      return paramT;
    }
    catch (Exception paramT)
    {
      Log.printDebugStack("safeParser", "", new Object[] { paramT });
      paramb.invoke(paramT);
      AppMethodBeat.o(153455);
    }
    return null;
  }
  
  public static final <R, T> c<R> a(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168824);
    p.h(paramc, "$this$thread");
    p.h(paramb, "func");
    paramc = paramc.b((com.tencent.mm.vending.h.d)h.hvt).c((com.tencent.mm.vending.c.a)new c(paramb));
    p.g(paramc, "`$`(ThreadScheduler).next {\n        func(it)\n    }");
    AppMethodBeat.o(168824);
    return paramc;
  }
  
  public static final <T> T a(HashSet<T> paramHashSet, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(204388);
    p.h(paramHashSet, "$this$wxRemoveFirst");
    p.h(paramb, "func");
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      Object localObject = paramHashSet.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        paramHashSet.remove();
        AppMethodBeat.o(204388);
        return localObject;
      }
    }
    AppMethodBeat.o(204388);
    return null;
  }
  
  public static final void a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(204380);
    p.h(paramRunnable, "task");
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(204380);
  }
  
  public static final void a(long paramLong, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(153451);
    p.h(parama, "block");
    MMHandlerThread.postToMainThreadDelayed((Runnable)new e(parama), paramLong);
    AppMethodBeat.o(153451);
  }
  
  public static final void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(204391);
    p.h(paramIntent, "$this$copyStringExtra");
    p.h(paramString, "key");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString(paramString);; paramBundle = null)
    {
      paramIntent.putExtra(paramString, paramBundle);
      AppMethodBeat.o(204391);
      return;
    }
  }
  
  public static final <T> boolean a(ArrayList<T> paramArrayList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(204387);
    p.h(paramArrayList, "$this$wxRemoveIf");
    p.h(paramb, "func");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
        localArrayList.add(localObject);
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      paramb = ((Iterable)localArrayList).iterator();
      while (paramb.hasNext()) {
        paramArrayList.remove(paramb.next());
      }
    }
    AppMethodBeat.o(204387);
    return bool;
  }
  
  public static final <T> boolean a(LinkedList<T> paramLinkedList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(168826);
    p.h(paramLinkedList, "$this$wxRemoveIf");
    p.h(paramb, "func");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
        localLinkedList.add(localObject);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      paramb = ((Iterable)localLinkedList).iterator();
      while (paramb.hasNext()) {
        paramLinkedList.remove(paramb.next());
      }
    }
    AppMethodBeat.o(168826);
    return bool;
  }
  
  public static final <T> boolean a(List<T> paramList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(204386);
    p.h(paramList, "$this$synchronizedRemoveAll");
    p.h(paramb, "predicate");
    try
    {
      boolean bool = j.c(paramList, paramb);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(204386);
    }
  }
  
  public static final c<Void> aBx()
  {
    AppMethodBeat.i(168823);
    c localc = g.hdG();
    p.g(localc, "QuickAccess.pipeline()");
    AppMethodBeat.o(168823);
    return localc;
  }
  
  public static final <T> LongSparseArray<T> b(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, x> paramm)
  {
    AppMethodBeat.i(204390);
    p.h(paramLongSparseArray, "$this$forEach");
    p.h(paramm, "func");
    int i = 0;
    int j = paramLongSparseArray.size();
    while (i < j)
    {
      paramm.invoke(Long.valueOf(paramLongSparseArray.keyAt(i)), paramLongSparseArray.valueAt(i));
      i += 1;
    }
    AppMethodBeat.o(204390);
    return paramLongSparseArray;
  }
  
  public static final <T, R> c<R> b(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168825);
    p.h(paramc, "$this$ui");
    p.h(paramb, "func");
    paramc = paramc.f((com.tencent.mm.vending.c.a)new g(paramb));
    p.g(paramc, "`$ui` {\n        func(it)\n    }");
    AppMethodBeat.o(168825);
    return paramc;
  }
  
  public static final void b(String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(204383);
    p.h(paramString, "taskName");
    p.h(parama, "block");
    com.tencent.f.h.RTc.aX((Runnable)new d.d(paramString, parama, true));
    AppMethodBeat.o(204383);
  }
  
  public static final void c(String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(204384);
    p.h(paramString, "tag");
    p.h(parama, "block");
    p.h(paramString, "tag");
    p.h(parama, "block");
    com.tencent.f.h.RTc.b((Runnable)new d.e(paramString, parama), paramString);
    AppMethodBeat.o(204384);
  }
  
  public static final boolean cW(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static final int[] cm(View paramView)
  {
    AppMethodBeat.i(204395);
    p.h(paramView, "$this$getLocationOnScreen");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    AppMethodBeat.o(204395);
    return arrayOfInt;
  }
  
  public static final int[] cn(View paramView)
  {
    AppMethodBeat.i(204396);
    p.h(paramView, "$this$getLocationInWindow");
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    AppMethodBeat.o(204396);
    return arrayOfInt;
  }
  
  public static final void d(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(204394);
    p.h(paramIntent, "$this$copyStringArrayListExtra");
    p.h(paramString, "key");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getStringArrayList(paramString);; paramBundle = null)
    {
      paramIntent.putExtra(paramString, (Serializable)paramBundle);
      AppMethodBeat.o(204394);
      return;
    }
  }
  
  public static final void f(TextView paramTextView)
  {
    AppMethodBeat.i(153457);
    p.h(paramTextView, "textView");
    paramTextView.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 3), 0.0F, com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 1), -2147483648);
    AppMethodBeat.o(153457);
  }
  
  private static String getCaller()
  {
    AppMethodBeat.i(204385);
    try
    {
      Object localObject1 = new Throwable().getStackTrace();
      if ((localObject1 == null) || (localObject1.length < 4))
      {
        AppMethodBeat.o(204385);
        return "";
      }
      localObject3 = localObject1[3];
      p.g(localObject3, "stackTrace[3]");
      localObject3 = ((StackTraceElement)localObject3).getClassName();
      p.g(localObject3, "stackTrace[3].className");
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(204385);
        throw ((Throwable)localObject1);
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(204385);
      return "";
    }
    Object localObject3 = ((String)localObject3).substring(15);
    p.g(localObject3, "(this as java.lang.String).substring(startIndex)");
    localObject3 = new StringBuilder().append((String)localObject3).append(":");
    Object localObject4 = localThrowable[3];
    p.g(localObject4, "stackTrace[3]");
    localObject3 = localObject4.getMethodName();
    localObject3 = new StringBuilder().append((String)localObject3).append("[");
    Object localObject2 = localThrowable[3];
    p.g(localObject2, "stackTrace[3]");
    localObject2 = ((StackTraceElement)localObject2).getLineNumber() + "]";
    AppMethodBeat.o(204385);
    return localObject2;
  }
  
  public static final void h(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(153450);
    p.h(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (p.j(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(153450);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new e(parama));
    AppMethodBeat.o(153450);
  }
  
  public static final void i(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(204382);
    p.h(parama, "block");
    b(getCaller(), parama);
    AppMethodBeat.o(204382);
  }
  
  public static final String zs(long paramLong)
  {
    AppMethodBeat.i(168821);
    String str = Long.toBinaryString(paramLong);
    p.g(str, "java.lang.Long.toBinaryString(seq)");
    str = new BigInteger(str, 2).toString();
    p.g(str, "big.toString()");
    AppMethodBeat.o(168821);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
  public static final class a
    extends q
    implements kotlin.g.a.a<T>
  {
    public a(z.d paramd, List paramList)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(153446);
      if ((this.hvi.SYE < 0) || (this.hvi.SYE >= this.hvj.size()))
      {
        AppMethodBeat.o(153446);
        return null;
      }
      Object localObject = this.hvj;
      z.d locald = this.hvi;
      int i = locald.SYE;
      locald.SYE = (i + 1);
      localObject = ((List)localObject).get(i);
      AppMethodBeat.o(153446);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "R", "run", "com/tencent/mm/kt/CommonKt$createMediaCodecThread$1$1"})
  static final class b
    implements Runnable
  {
    b(HandlerThread paramHandlerThread, kotlin.g.a.a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(182801);
      parama.invoke();
      if (paramBoolean) {
        this.hvk.quitSafely();
      }
      AppMethodBeat.o(182801);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168819);
      paramT = this.hvn.invoke(paramT);
      AppMethodBeat.o(168819);
      return paramT;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class g<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    g(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168820);
      paramT = this.hvn.invoke(paramT);
      AppMethodBeat.o(168820);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.d
 * JD-Core Version:    0.7.0.1
 */