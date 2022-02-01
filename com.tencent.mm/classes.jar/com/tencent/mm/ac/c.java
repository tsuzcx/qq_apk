package com.tencent.mm.ac;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import d.a.j;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"codeConsume", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tag", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "T", "list", "", "createMMHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "name", "createMediaCodecThread", "Landroid/os/HandlerThread;", "isAfterAutoSafeQuit", "", "idle", "long2UnsignedString", "seq", "", "multiLet", "T1", "", "T2", "p1", "p2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "opAddFlag", "", "value", "flag", "opCheckFlag", "opCleanFlag", "removeUiRunnable", "task", "Ljava/lang/Runnable;", "reverseConsumeList", "rxPipeLine", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Ljava/lang/Void;", "threadPool", "threadName", "threadPoolTag", "toBitmap8888", "Landroid/graphics/Bitmap;", "source", "uiThread", "delay", "unsignedString2Long", "filter", "Landroid/util/LongSparseArray;", "func", "Lkotlin/ParameterName;", "k", "v", "forEach", "getLocationOnScreen", "", "Landroid/view/View;", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeGetBoolean", "Lorg/json/JSONObject;", "key", "safeGetInt", "default", "safeGetString", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedForEach", "", "action", "synchronizedForEachIndexed", "index", "synchronizedIndexOfFirst", "predicate", "synchronizedLastOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedRemoveAll", "", "synchronizedRemoveFirstOrNull", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "t", "(Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "thread", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Landroid/database/Cursor;", "toLinkedList", "Ljava/util/LinkedList;", "ui", "wxRemoveFirst", "wxRemoveIf", "libktcomm_release"})
public final class c
{
  public static final <R> HandlerThread a(String paramString, final boolean paramBoolean, final d.g.a.a<? extends R> parama)
  {
    AppMethodBeat.i(182804);
    p.h(paramString, "name");
    p.h(parama, "block");
    paramString = com.tencent.e.c.d.hh(paramString, 5);
    paramString.start();
    new aq(paramString.getLooper()).post((Runnable)new b(paramString, parama, paramBoolean));
    p.g(paramString, "SpecialThreadFactory.cre…        }\n        }\n    }");
    AppMethodBeat.o(182804);
    return paramString;
  }
  
  public static final <T> LongSparseArray<T> a(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, Boolean> paramm)
  {
    AppMethodBeat.i(209731);
    p.h(paramLongSparseArray, "$this$filter");
    p.h(paramm, "func");
    LongSparseArray localLongSparseArray = new LongSparseArray();
    int j = paramLongSparseArray.size();
    int i = 0;
    while (i < j)
    {
      long l = paramLongSparseArray.keyAt(i);
      Object localObject = paramLongSparseArray.valueAt(i);
      if (((Boolean)paramm.p(Long.valueOf(l), localObject)).booleanValue()) {
        localLongSparseArray.put(l, localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(209731);
    return localLongSparseArray;
  }
  
  public static final <T extends com.tencent.mm.bw.a> T a(T paramT, byte[] paramArrayOfByte, b<? super Exception, z> paramb)
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
      ae.l("safeParser", "", new Object[] { paramT });
      paramb.invoke(paramT);
      AppMethodBeat.o(153455);
    }
    return null;
  }
  
  public static final <R, T> com.tencent.mm.vending.g.c<R> a(com.tencent.mm.vending.g.c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168824);
    p.h(paramc, "$this$thread");
    p.h(paramb, "func");
    paramc = paramc.b((com.tencent.mm.vending.h.d)g.gIA).c((com.tencent.mm.vending.c.a)new c(paramb));
    p.g(paramc, "`$`(ThreadScheduler).next {\n        func(it)\n    }");
    AppMethodBeat.o(168824);
    return paramc;
  }
  
  public static final <T> T a(HashSet<T> paramHashSet, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(209730);
    p.h(paramHashSet, "$this$wxRemoveFirst");
    p.h(paramb, "func");
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      Object localObject = paramHashSet.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        paramHashSet.remove();
        AppMethodBeat.o(209730);
        return localObject;
      }
    }
    AppMethodBeat.o(209730);
    return null;
  }
  
  public static final void a(long paramLong, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(153451);
    p.h(parama, "block");
    ar.o((Runnable)new e(parama), paramLong);
    AppMethodBeat.o(153451);
  }
  
  public static final void a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(209726);
    p.h(paramRunnable, "task");
    ar.o(paramRunnable, paramLong);
    AppMethodBeat.o(209726);
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
    AppMethodBeat.i(209729);
    p.h(paramList, "$this$synchronizedRemoveAll");
    p.h(paramb, "predicate");
    try
    {
      boolean bool = j.c(paramList, paramb);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(209729);
    }
  }
  
  public static final com.tencent.mm.vending.g.c<Void> ale()
  {
    AppMethodBeat.i(168823);
    com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fSA();
    p.g(localc, "QuickAccess.pipeline()");
    AppMethodBeat.o(168823);
    return localc;
  }
  
  public static final <T> LongSparseArray<T> b(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, z> paramm)
  {
    AppMethodBeat.i(209732);
    p.h(paramLongSparseArray, "$this$forEach");
    p.h(paramm, "func");
    int i = 0;
    int j = paramLongSparseArray.size();
    while (i < j)
    {
      paramm.p(Long.valueOf(paramLongSparseArray.keyAt(i)), paramLongSparseArray.valueAt(i));
      i += 1;
    }
    AppMethodBeat.o(209732);
    return paramLongSparseArray;
  }
  
  public static final <T, R> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.vending.g.c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168825);
    p.h(paramc, "$this$ui");
    p.h(paramb, "func");
    paramc = paramc.f((com.tencent.mm.vending.c.a)new f(paramb));
    p.g(paramc, "`$ui` {\n        func(it)\n    }");
    AppMethodBeat.o(168825);
    return paramc;
  }
  
  public static final void b(String paramString, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(153452);
    p.h(parama, "block");
    if ((paramString == null) || (h.MqF.aO((Runnable)new c.d(paramString, parama)) == null)) {
      h.MqF.aO((Runnable)new d(parama));
    }
    AppMethodBeat.o(153452);
  }
  
  public static final void c(String paramString, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(209728);
    p.h(paramString, "tag");
    p.h(parama, "block");
    h.MqF.f((Runnable)new c.e(parama), paramString);
    AppMethodBeat.o(209728);
  }
  
  public static final boolean cQ(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static final int[] cw(View paramView)
  {
    AppMethodBeat.i(209733);
    p.h(paramView, "$this$getLocationOnScreen");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    AppMethodBeat.o(209733);
    return arrayOfInt;
  }
  
  public static final void e(TextView paramTextView)
  {
    AppMethodBeat.i(153457);
    p.h(paramTextView, "textView");
    paramTextView.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 3), 0.0F, com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 1), -2147483648);
    AppMethodBeat.o(153457);
  }
  
  public static final void h(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(153450);
    p.h(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (p.i(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(153450);
      return;
    }
    ar.f((Runnable)new e(parama));
    AppMethodBeat.o(153450);
  }
  
  public static final String rp(long paramLong)
  {
    AppMethodBeat.i(168821);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    p.g(str, "big.toString()");
    AppMethodBeat.o(168821);
    return str;
  }
  
  public static final long xQ(String paramString)
  {
    AppMethodBeat.i(168822);
    p.h(paramString, "seq");
    if (((CharSequence)paramString).length() == 0) {}
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
        ae.printErrStackTrace("Common.Kt", paramString, "", new Object[0]);
        long l = 0L;
      }
    }
  }
  
  public static final void z(Runnable paramRunnable)
  {
    AppMethodBeat.i(209727);
    p.h(paramRunnable, "task");
    ar.ay(paramRunnable);
    AppMethodBeat.o(209727);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "R", "run", "com/tencent/mm/kt/CommonKt$createMediaCodecThread$1$1"})
  static final class b
    implements Runnable
  {
    b(HandlerThread paramHandlerThread, d.g.a.a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(182801);
      parama.invoke();
      if (paramBoolean) {
        this.gIu.quitSafely();
      }
      AppMethodBeat.o(182801);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168819);
      paramT = this.gIx.invoke(paramT);
      AppMethodBeat.o(168819);
      return paramT;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168820);
      paramT = this.gIx.invoke(paramT);
      AppMethodBeat.o(168820);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ac.c
 * JD-Core Version:    0.7.0.1
 */