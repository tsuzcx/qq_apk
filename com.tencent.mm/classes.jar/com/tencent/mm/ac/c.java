package com.tencent.mm.ac;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"codeConsume", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tag", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "T", "list", "", "createMMHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "name", "createMediaCodecThread", "Landroid/os/HandlerThread;", "isAfterAutoSafeQuit", "", "idle", "long2UnsignedString", "seq", "", "opAddFlag", "", "value", "flag", "opCheckFlag", "opCleanFlag", "removeUiRunnable", "task", "Ljava/lang/Runnable;", "reverseConsumeList", "rxPipeLine", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Ljava/lang/Void;", "threadPool", "threadName", "threadPoolTag", "toBitmap8888", "Landroid/graphics/Bitmap;", "source", "uiThread", "delay", "unsignedString2Long", "filter", "Landroid/util/LongSparseArray;", "func", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "k", "v", "forEach", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeGetBoolean", "Lorg/json/JSONObject;", "key", "safeGetInt", "default", "safeGetString", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedForEach", "", "action", "synchronizedForEachIndexed", "index", "synchronizedRemoveFirstOrNull", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "t", "(Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "thread", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Landroid/database/Cursor;", "toLinkedList", "Ljava/util/LinkedList;", "ui", "wxRemoveFirst", "wxRemoveIf", "libktcomm_release"})
public final class c
{
  public static final void C(Runnable paramRunnable)
  {
    AppMethodBeat.i(200733);
    k.h(paramRunnable, "task");
    ap.aB(paramRunnable);
    AppMethodBeat.o(200733);
  }
  
  public static final <R> HandlerThread a(String paramString, final boolean paramBoolean, final d.g.a.a<? extends R> parama)
  {
    AppMethodBeat.i(182804);
    k.h(paramString, "name");
    k.h(parama, "block");
    paramString = com.tencent.e.c.d.gA(paramString, 5);
    paramString.start();
    new ao(paramString.getLooper()).post((Runnable)new b(paramString, parama, paramBoolean));
    k.g(paramString, "SpecialThreadFactory.cre…        }\n        }\n    }");
    AppMethodBeat.o(182804);
    return paramString;
  }
  
  public static final <T> LongSparseArray<T> a(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, Boolean> paramm)
  {
    AppMethodBeat.i(200736);
    k.h(paramLongSparseArray, "$this$filter");
    k.h(paramm, "func");
    LongSparseArray localLongSparseArray = new LongSparseArray();
    int j = paramLongSparseArray.size();
    int i = 0;
    while (i < j)
    {
      long l = paramLongSparseArray.keyAt(i);
      Object localObject = paramLongSparseArray.valueAt(i);
      if (((Boolean)paramm.n(Long.valueOf(l), localObject)).booleanValue()) {
        localLongSparseArray.put(l, localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(200736);
    return localLongSparseArray;
  }
  
  public static final <T extends com.tencent.mm.bw.a> T a(T paramT, byte[] paramArrayOfByte, b<? super Exception, y> paramb)
  {
    AppMethodBeat.i(153455);
    k.h(paramT, "$this$safeParser");
    k.h(paramb, "block");
    try
    {
      paramT.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(153455);
      return paramT;
    }
    catch (Exception paramT)
    {
      ac.l("safeParser", "", new Object[] { paramT });
      paramb.ay(paramT);
      AppMethodBeat.o(153455);
    }
    return null;
  }
  
  public static final <R, T> com.tencent.mm.vending.g.c<R> a(com.tencent.mm.vending.g.c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168824);
    k.h(paramc, "$this$thread");
    k.h(paramb, "func");
    paramc = paramc.b((com.tencent.mm.vending.h.d)g.gmk).c((com.tencent.mm.vending.c.a)new c(paramb));
    k.g(paramc, "`$`(ThreadScheduler).next {\n        func(it)\n    }");
    AppMethodBeat.o(168824);
    return paramc;
  }
  
  public static final <T> T a(HashSet<T> paramHashSet, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(200735);
    k.h(paramHashSet, "$this$wxRemoveFirst");
    k.h(paramb, "func");
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      Object localObject = paramHashSet.next();
      if (((Boolean)paramb.ay(localObject)).booleanValue())
      {
        paramHashSet.remove();
        AppMethodBeat.o(200735);
        return localObject;
      }
    }
    AppMethodBeat.o(200735);
    return null;
  }
  
  public static final void a(long paramLong, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(153451);
    k.h(parama, "block");
    ap.n((Runnable)new e(parama), paramLong);
    AppMethodBeat.o(153451);
  }
  
  public static final void a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(200732);
    k.h(paramRunnable, "task");
    ap.n(paramRunnable, paramLong);
    AppMethodBeat.o(200732);
  }
  
  public static final <T> boolean a(LinkedList<T> paramLinkedList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(168826);
    k.h(paramLinkedList, "$this$wxRemoveIf");
    k.h(paramb, "func");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((Boolean)paramb.ay(localObject)).booleanValue()) {
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
  
  public static final com.tencent.mm.vending.g.c<Void> aid()
  {
    AppMethodBeat.i(168823);
    com.tencent.mm.vending.g.c localc = com.tencent.mm.vending.g.g.fxs();
    k.g(localc, "QuickAccess.pipeline()");
    AppMethodBeat.o(168823);
    return localc;
  }
  
  public static final <T> LongSparseArray<T> b(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, y> paramm)
  {
    AppMethodBeat.i(200737);
    k.h(paramLongSparseArray, "$this$forEach");
    k.h(paramm, "func");
    int i = 0;
    int j = paramLongSparseArray.size();
    while (i < j)
    {
      paramm.n(Long.valueOf(paramLongSparseArray.keyAt(i)), paramLongSparseArray.valueAt(i));
      i += 1;
    }
    AppMethodBeat.o(200737);
    return paramLongSparseArray;
  }
  
  public static final <T, R> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.vending.g.c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168825);
    k.h(paramc, "$this$ui");
    k.h(paramb, "func");
    paramc = paramc.f((com.tencent.mm.vending.c.a)new f(paramb));
    k.g(paramc, "`$ui` {\n        func(it)\n    }");
    AppMethodBeat.o(168825);
    return paramc;
  }
  
  public static final void b(String paramString, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(153452);
    k.h(parama, "block");
    if ((paramString == null) || (h.JZN.aS((Runnable)new c.d(paramString, parama)) == null)) {
      h.JZN.aS((Runnable)new d(parama));
    }
    AppMethodBeat.o(153452);
  }
  
  public static final void c(String paramString, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(200734);
    k.h(paramString, "tag");
    k.h(parama, "block");
    h.JZN.f((Runnable)new c.e(parama), paramString);
    AppMethodBeat.o(200734);
  }
  
  public static final boolean cO(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static final void e(TextView paramTextView)
  {
    AppMethodBeat.i(153457);
    k.h(paramTextView, "textView");
    paramTextView.setShadowLayer(com.tencent.mm.cc.a.fromDPToPix(paramTextView.getContext(), 3), 0.0F, com.tencent.mm.cc.a.fromDPToPix(paramTextView.getContext(), 1), -2147483648);
    AppMethodBeat.o(153457);
  }
  
  public static final void g(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(153450);
    k.h(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    k.g(localLooper, "Looper.getMainLooper()");
    if (k.g(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(153450);
      return;
    }
    ap.f((Runnable)new e(parama));
    AppMethodBeat.o(153450);
  }
  
  public static final String pb(long paramLong)
  {
    AppMethodBeat.i(168821);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    k.g(str, "big.toString()");
    AppMethodBeat.o(168821);
    return str;
  }
  
  public static final long ur(String paramString)
  {
    AppMethodBeat.i(168822);
    k.h(paramString, "seq");
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
        ac.printErrStackTrace("Common.Kt", paramString, "", new Object[0]);
        long l = 0L;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "R", "run", "com/tencent/mm/kt/CommonKt$createMediaCodecThread$1$1"})
  static final class b
    implements Runnable
  {
    b(HandlerThread paramHandlerThread, d.g.a.a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(182801);
      parama.invoke();
      if (paramBoolean) {
        this.gme.quitSafely();
      }
      AppMethodBeat.o(182801);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168819);
      paramT = this.gmh.ay(paramT);
      AppMethodBeat.o(168819);
      return paramT;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168820);
      paramT = this.gmh.ay(paramT);
      AppMethodBeat.o(168820);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ac.c
 * JD-Core Version:    0.7.0.1
 */