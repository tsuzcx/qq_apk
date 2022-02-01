package com.tencent.mm.ae;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.LongSparseArray;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import com.tencent.e.i;
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
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"checkUICost", "T", "tag", "", "thresholdMs", "", "isThrowException", "", "call", "Lkotlin/Function0;", "(Ljava/lang/String;JZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "codeConsume", "R", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "list", "", "createMMHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "name", "createMediaCodecThread", "Landroid/os/HandlerThread;", "isAfterAutoSafeQuit", "drawable2Bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getCaller", "idle", "long2UnsignedString", "seq", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "multiLet", "T1", "", "T2", "p1", "p2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "opAddFlag", "", "value", "flag", "opCheckFlag", "opCleanFlag", "removeUiRunnable", "task", "Ljava/lang/Runnable;", "reverseConsumeList", "rxPipeLine", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Ljava/lang/Void;", "threadPool", "taskName", "isPrintLog", "threadPoolTag", "threadPoolTagDelayed", "delay", "toBitmap8888", "source", "uiThread", "unmarshall", "Landroid/os/Parcel;", "bytes", "creator", "Landroid/os/Parcelable$Creator;", "([BLandroid/os/Parcelable$Creator;)Ljava/lang/Object;", "unsignedString2Long", "afterLayout", "Landroid/view/View;", "copyBooleanExtra", "Landroid/content/Intent;", "other", "key", "defaultValue", "bundle", "Landroid/os/Bundle;", "copyIntExtra", "copyStringArrayListExtra", "copyStringExtra", "filter", "Landroid/util/LongSparseArray;", "func", "Lkotlin/ParameterName;", "k", "v", "forEach", "getLocationInWindow", "", "getLocationOnScreen", "isNullOrEmpty", "safeBufferToByte", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeGetBoolean", "Lorg/json/JSONObject;", "safeGetInt", "default", "safeGetString", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedFilter", "", "predicate", "", "K", "V", "", "synchronizedFilterIndexed", "index", "synchronizedFind", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedForEach", "action", "synchronizedForEachIndexed", "synchronizedIndexOfFirst", "synchronizedLastOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedRemoveAll", "", "synchronizedRemoveFirstOrNull", "Ljava/util/HashSet;", "t", "(Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "thread", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Landroid/database/Cursor;", "toLinkedList", "Ljava/util/LinkedList;", "ui", "whenLayout", "wxRemoveFirst", "wxRemoveIf", "wxSubString", "start", "end", "libktcomm_release"})
public final class d
{
  public static final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(243451);
    p.k(paramRunnable, "task");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (p.h(localThread, localLooper.getThread()))
    {
      paramRunnable.run();
      AppMethodBeat.o(243451);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(243451);
  }
  
  public static final void C(Runnable paramRunnable)
  {
    AppMethodBeat.i(243455);
    p.k(paramRunnable, "task");
    MMHandlerThread.removeRunnable(paramRunnable);
    AppMethodBeat.o(243455);
  }
  
  public static final String Fw(long paramLong)
  {
    AppMethodBeat.i(168821);
    String str = Long.toBinaryString(paramLong);
    p.j(str, "java.lang.Long.toBinaryString(seq)");
    str = new BigInteger(str, 2).toString();
    p.j(str, "big.toString()");
    AppMethodBeat.o(168821);
    return str;
  }
  
  public static final long Nb(String paramString)
  {
    AppMethodBeat.i(168822);
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label36;
      }
    }
    label36:
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
  
  public static final <R> HandlerThread a(String paramString, final boolean paramBoolean, final kotlin.g.a.a<? extends R> parama)
  {
    AppMethodBeat.i(182804);
    p.k(paramString, "name");
    p.k(parama, "block");
    paramString = com.tencent.e.c.d.il(paramString, 5);
    paramString.start();
    new MMHandler(paramString.getLooper()).post((Runnable)new c(paramString, parama, paramBoolean));
    p.j(paramString, "SpecialThreadFactory.cre…        }\n        }\n    }");
    AppMethodBeat.o(182804);
    return paramString;
  }
  
  public static final <T> LongSparseArray<T> a(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, Boolean> paramm)
  {
    AppMethodBeat.i(243465);
    p.k(paramLongSparseArray, "$this$filter");
    p.k(paramm, "func");
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
    AppMethodBeat.o(243465);
    return localLongSparseArray;
  }
  
  public static final <T extends com.tencent.mm.cd.a> T a(T paramT, byte[] paramArrayOfByte, b<? super Exception, x> paramb)
  {
    AppMethodBeat.i(153455);
    p.k(paramT, "$this$safeParser");
    p.k(paramb, "block");
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
    p.k(paramc, "$this$thread");
    p.k(paramb, "func");
    paramc = paramc.b((com.tencent.mm.vending.h.d)h.khr).c((com.tencent.mm.vending.c.a)new d.d(paramb));
    p.j(paramc, "`$`(ThreadScheduler).next {\n        func(it)\n    }");
    AppMethodBeat.o(168824);
    return paramc;
  }
  
  public static final <T> T a(HashSet<T> paramHashSet, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(243464);
    p.k(paramHashSet, "$this$wxRemoveFirst");
    p.k(paramb, "func");
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      Object localObject = paramHashSet.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        paramHashSet.remove();
        AppMethodBeat.o(243464);
        return localObject;
      }
    }
    AppMethodBeat.o(243464);
    return null;
  }
  
  public static final <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(243479);
    p.k(paramArrayOfByte, "bytes");
    p.k(paramCreator, "creator");
    p.k(paramArrayOfByte, "bytes");
    Parcel localParcel = Parcel.obtain();
    p.j(localParcel, "Parcel.obtain()");
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(243479);
    return paramArrayOfByte;
  }
  
  public static final void a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(243453);
    p.k(paramRunnable, "task");
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(243453);
  }
  
  public static final void a(long paramLong, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(153451);
    p.k(parama, "block");
    MMHandlerThread.postToMainThreadDelayed((Runnable)new e(parama), paramLong);
    AppMethodBeat.o(153451);
  }
  
  public static final void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(243466);
    p.k(paramIntent, "$this$copyStringExtra");
    p.k(paramString, "key");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString(paramString);; paramBundle = null)
    {
      paramIntent.putExtra(paramString, paramBundle);
      AppMethodBeat.o(243466);
      return;
    }
  }
  
  public static final void a(View paramView, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(243477);
    p.k(paramView, "$this$afterLayout");
    p.k(parama, "call");
    paramView.addOnLayoutChangeListener((View.OnLayoutChangeListener)new a(paramView, parama));
    AppMethodBeat.o(243477);
  }
  
  public static final <T> boolean a(ArrayList<T> paramArrayList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(243463);
    p.k(paramArrayList, "$this$wxRemoveIf");
    p.k(paramb, "func");
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
    AppMethodBeat.o(243463);
    return bool;
  }
  
  public static final <T> boolean a(LinkedList<T> paramLinkedList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(168826);
    p.k(paramLinkedList, "$this$wxRemoveIf");
    p.k(paramb, "func");
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
    AppMethodBeat.i(243462);
    p.k(paramList, "$this$synchronizedRemoveAll");
    p.k(paramb, "predicate");
    try
    {
      boolean bool = j.c(paramList, paramb);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(243462);
    }
  }
  
  public static final c<Void> aJa()
  {
    AppMethodBeat.i(168823);
    c localc = g.ieN();
    p.j(localc, "QuickAccess.pipeline()");
    AppMethodBeat.o(168823);
    return localc;
  }
  
  public static final String am(String paramString, int paramInt)
  {
    AppMethodBeat.i(243475);
    p.k(paramString, "$this$wxSubString");
    if ((paramInt > paramString.length()) || (paramInt < 0))
    {
      paramString = paramString.toString();
      AppMethodBeat.o(243475);
      return paramString;
    }
    paramString = paramString.substring(0, paramInt);
    p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(243475);
    return paramString;
  }
  
  public static final <T, R> c<R> b(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168825);
    p.k(paramc, "$this$ui");
    p.k(paramb, "func");
    paramc = paramc.f((com.tencent.mm.vending.c.a)new h(paramb));
    p.j(paramc, "`$ui` {\n        func(it)\n    }");
    AppMethodBeat.o(168825);
    return paramc;
  }
  
  public static final void b(String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(243457);
    p.k(paramString, "taskName");
    p.k(parama, "block");
    com.tencent.e.h.ZvG.be((Runnable)new d.e(paramString, parama, true));
    AppMethodBeat.o(243457);
  }
  
  public static final void c(String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(243458);
    p.k(paramString, "tag");
    p.k(parama, "block");
    p.k(paramString, "tag");
    p.k(parama, "block");
    com.tencent.e.h.ZvG.d((Runnable)new d.f(paramString, parama), paramString);
    AppMethodBeat.o(243458);
  }
  
  public static final byte[] c(Parcelable paramParcelable)
  {
    AppMethodBeat.i(243478);
    p.k(paramParcelable, "parcelable");
    Parcel localParcel = Parcel.obtain();
    p.j(localParcel, "Parcel.obtain()");
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    p.j(paramParcelable, "bytes");
    AppMethodBeat.o(243478);
    return paramParcelable;
  }
  
  public static final int[] cE(View paramView)
  {
    AppMethodBeat.i(243472);
    p.k(paramView, "$this$getLocationOnScreen");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    AppMethodBeat.o(243472);
    return arrayOfInt;
  }
  
  public static final int[] cF(View paramView)
  {
    AppMethodBeat.i(243473);
    p.k(paramView, "$this$getLocationInWindow");
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    AppMethodBeat.o(243473);
    return arrayOfInt;
  }
  
  public static final void d(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(243470);
    p.k(paramIntent, "$this$copyStringArrayListExtra");
    p.k(paramString, "key");
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getStringArrayList(paramString);; paramBundle = null)
    {
      paramIntent.putExtra(paramString, (Serializable)paramBundle);
      AppMethodBeat.o(243470);
      return;
    }
  }
  
  public static final boolean dr(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static final Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(243474);
    p.k(paramDrawable, "drawable");
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      p.j(localObject, "bitmap");
      AppMethodBeat.o(243474);
      return localObject;
    }
  }
  
  public static final void g(TextView paramTextView)
  {
    AppMethodBeat.i(153457);
    p.k(paramTextView, "textView");
    paramTextView.setShadowLayer(com.tencent.mm.ci.a.fromDPToPix(paramTextView.getContext(), 3), 0.0F, com.tencent.mm.ci.a.fromDPToPix(paramTextView.getContext(), 1), -2147483648);
    AppMethodBeat.o(153457);
  }
  
  private static String getCaller()
  {
    AppMethodBeat.i(243461);
    try
    {
      Object localObject1 = new Throwable().getStackTrace();
      if ((localObject1 == null) || (localObject1.length < 4))
      {
        AppMethodBeat.o(243461);
        return "";
      }
      localObject3 = localObject1[3];
      p.j(localObject3, "stackTrace[3]");
      localObject3 = ((StackTraceElement)localObject3).getClassName();
      p.j(localObject3, "stackTrace[3].className");
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(243461);
        throw ((Throwable)localObject1);
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(243461);
      return "";
    }
    Object localObject3 = ((String)localObject3).substring(15);
    p.j(localObject3, "(this as java.lang.String).substring(startIndex)");
    localObject3 = new StringBuilder().append((String)localObject3).append(":");
    Object localObject4 = localThrowable[3];
    p.j(localObject4, "stackTrace[3]");
    localObject3 = localObject4.getMethodName();
    localObject3 = new StringBuilder().append((String)localObject3).append("[");
    Object localObject2 = localThrowable[3];
    p.j(localObject2, "stackTrace[3]");
    localObject2 = ((StackTraceElement)localObject2).getLineNumber() + "]";
    AppMethodBeat.o(243461);
    return localObject2;
  }
  
  public static final void h(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(243456);
    p.k(parama, "block");
    b(getCaller(), parama);
    AppMethodBeat.o(243456);
  }
  
  public static final void uiThread(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(153450);
    p.k(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (p.h(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(153450);
      return;
    }
    MMHandlerThread.postToMainThread((Runnable)new e(parama));
    AppMethodBeat.o(153450);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$afterLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "libktcomm_release"})
  public static final class a
    implements View.OnLayoutChangeListener
  {
    a(View paramView, kotlin.g.a.a parama) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(243406);
      this.khe.post((Runnable)new a(this));
      this.khe.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(243406);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(243407);
        this.khg.khf.invoke();
        AppMethodBeat.o(243407);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "R", "run", "com/tencent/mm/kt/CommonKt$createMediaCodecThread$1$1"})
  static final class c
    implements Runnable
  {
    c(HandlerThread paramHandlerThread, kotlin.g.a.a parama, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(182801);
      parama.invoke();
      if (paramBoolean) {
        this.khj.quitSafely();
      }
      AppMethodBeat.o(182801);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "R", "T", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class h<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    h(b paramb) {}
    
    public final R call(T paramT)
    {
      AppMethodBeat.i(168820);
      paramT = this.khm.invoke(paramT);
      AppMethodBeat.o(168820);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ae.d
 * JD-Core Version:    0.7.0.1
 */