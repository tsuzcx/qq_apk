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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.threadpool.i;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"checkUICost", "T", "tag", "", "thresholdMs", "", "isThrowException", "", "call", "Lkotlin/Function0;", "(Ljava/lang/String;JZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "codeConsume", "R", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "list", "", "createMMHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "name", "createMediaCodecThread", "Landroid/os/HandlerThread;", "isAfterAutoSafeQuit", "drawable2Bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getCaller", "idle", "long2UnsignedString", "seq", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "multiLet", "T1", "", "T2", "p1", "p2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "notUIThread", "opAddFlag", "", "value", "flag", "opCheckFlag", "opCleanFlag", "removeUiRunnable", "task", "Ljava/lang/Runnable;", "reverseConsumeList", "rxPipeLine", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Ljava/lang/Void;", "threadPool", "taskName", "isPrintLog", "threadPoolTag", "threadPoolTagDelayed", "delay", "toBitmap8888", "source", "uiThread", "unmarshall", "Landroid/os/Parcel;", "bytes", "creator", "Landroid/os/Parcelable$Creator;", "([BLandroid/os/Parcelable$Creator;)Ljava/lang/Object;", "unsignedString2Long", "afterDelayLayout", "Landroid/view/View;", "afterLayout", "copyBooleanExtra", "Landroid/content/Intent;", "other", "key", "defaultValue", "bundle", "Landroid/os/Bundle;", "copyIntExtra", "copyStringArrayListExtra", "copyStringExtra", "filter", "Landroid/util/LongSparseArray;", "func", "Lkotlin/ParameterName;", "k", "v", "forEach", "getLocationInWindow", "", "getLocationOnScreen", "ifNullOrEmpty", "isNullOrEmpty", "observeForeverWithNotify", "Landroidx/lifecycle/LiveData;", "observer", "Landroidx/lifecycle/Observer;", "observeWithNotify", "owner", "Landroidx/lifecycle/LifecycleOwner;", "safeBufferToByte", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeGetBoolean", "Lorg/json/JSONObject;", "safeGetInt", "default", "safeGetJSONArray", "Lorg/json/JSONArray;", "safeGetLong", "safeGetObj", "safeGetString", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronized", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedFilter", "", "predicate", "", "K", "V", "", "synchronizedFilterIndexed", "index", "synchronizedFind", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedForEach", "action", "synchronizedForEachIndexed", "synchronizedGetOrNull", "", "(Ljava/util/List;I)Ljava/lang/Object;", "synchronizedIndexOfFirst", "synchronizedLastOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedRemoveAll", "synchronizedRemoveFirstOrNull", "Ljava/util/HashSet;", "t", "(Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "thread", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Landroid/database/Cursor;", "toLinkedList", "Ljava/util/LinkedList;", "ui", "whenLayout", "wxRemoveFirst", "wxRemoveIf", "wxSubString", "start", "end", "libktcomm_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final void A(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233500);
    s.u(parama, "block");
    MMHandlerThread.removeRunnable(new d..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(233500);
  }
  
  public static final void B(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233506);
    s.u(parama, "block");
    d(getCaller(), parama);
    AppMethodBeat.o(233506);
  }
  
  private static final void C(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(233718);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(233718);
  }
  
  private static final void D(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(233722);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(233722);
  }
  
  public static final long FK(String paramString)
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
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("Common.Kt", paramString, "", new Object[0]);
        long l = 0L;
      }
    }
  }
  
  public static final void G(Runnable paramRunnable)
  {
    AppMethodBeat.i(233477);
    s.u(paramRunnable, "task");
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      paramRunnable.run();
      AppMethodBeat.o(233477);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(233477);
  }
  
  public static final void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(233494);
    s.u(paramRunnable, "task");
    MMHandlerThread.removeRunnable(paramRunnable);
    AppMethodBeat.o(233494);
  }
  
  public static final <T> LongSparseArray<T> a(LongSparseArray<T> paramLongSparseArray, m<? super Long, ? super T, Boolean> paramm)
  {
    AppMethodBeat.i(233625);
    s.u(paramLongSparseArray, "<this>");
    s.u(paramm, "func");
    LongSparseArray localLongSparseArray = new LongSparseArray();
    int i = 0;
    int k = paramLongSparseArray.size();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      long l = paramLongSparseArray.keyAt(i);
      Object localObject = paramLongSparseArray.valueAt(i);
      if (((Boolean)paramm.invoke(Long.valueOf(l), localObject)).booleanValue()) {
        localLongSparseArray.put(l, localObject);
      }
      if (j >= k)
      {
        AppMethodBeat.o(233625);
        return localLongSparseArray;
      }
      i = j;
    }
  }
  
  public static final <T extends com.tencent.mm.bx.a> T a(T paramT, byte[] paramArrayOfByte, b<? super Exception, ah> paramb)
  {
    AppMethodBeat.i(153455);
    s.u(paramT, "<this>");
    s.u(paramb, "block");
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
    s.u(paramc, "<this>");
    s.u(paramb, "func");
    paramc = paramc.b((com.tencent.mm.vending.h.d)h.mHQ).c(new d..ExternalSyntheticLambda0(paramb));
    s.s(paramc, "`$`(ThreadScheduler).next {\n        func(it)\n    }");
    AppMethodBeat.o(168824);
    return paramc;
  }
  
  public static final <T> T a(HashSet<T> paramHashSet, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(233620);
    s.u(paramHashSet, "<this>");
    s.u(paramb, "func");
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      Object localObject = paramHashSet.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue())
      {
        paramHashSet.remove();
        AppMethodBeat.o(233620);
        return localObject;
      }
    }
    AppMethodBeat.o(233620);
    return null;
  }
  
  private static final Object a(b paramb, Object paramObject)
  {
    AppMethodBeat.i(233730);
    s.u(paramb, "$func");
    paramb = paramb.invoke(paramObject);
    AppMethodBeat.o(233730);
    return paramb;
  }
  
  public static final <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(233707);
    s.u(paramArrayOfByte, "bytes");
    s.u(paramCreator, "creator");
    s.u(paramArrayOfByte, "bytes");
    Parcel localParcel = Parcel.obtain();
    s.s(localParcel, "obtain()");
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(233707);
    return paramArrayOfByte;
  }
  
  public static final void a(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(233487);
    s.u(paramRunnable, "task");
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(233487);
  }
  
  public static final void a(long paramLong, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(153451);
    s.u(parama, "block");
    MMHandlerThread.postToMainThreadDelayed(new d..ExternalSyntheticLambda3(parama), paramLong);
    AppMethodBeat.o(153451);
  }
  
  public static final void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(233629);
    s.u(paramIntent, "<this>");
    s.u(paramString, "key");
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getString(paramString))
    {
      paramIntent.putExtra(paramString, paramBundle);
      AppMethodBeat.o(233629);
      return;
    }
  }
  
  public static final void a(View paramView, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233691);
    s.u(paramView, "<this>");
    s.u(parama, "call");
    paramView.addOnLayoutChangeListener((View.OnLayoutChangeListener)new d.c(paramView, parama));
    AppMethodBeat.o(233691);
  }
  
  public static final <T> void a(LiveData<T> paramLiveData, q paramq, y<T> paramy)
  {
    AppMethodBeat.i(233711);
    s.u(paramLiveData, "<this>");
    s.u(paramq, "owner");
    s.u(paramy, "observer");
    uiThread((kotlin.g.a.a)new d.f(paramLiveData, paramq, paramy));
    AppMethodBeat.o(233711);
  }
  
  public static final void a(String paramString, boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233524);
    s.u(paramString, "tag");
    s.u(parama, "block");
    com.tencent.threadpool.h.ahAA.g((Runnable)new d.h(paramString, parama, paramBoolean), paramString);
    AppMethodBeat.o(233524);
  }
  
  public static final void a(String paramString, boolean paramBoolean, kotlin.g.a.a<ah> parama, long paramLong)
  {
    AppMethodBeat.i(233529);
    s.u(paramString, "tag");
    s.u(parama, "block");
    com.tencent.threadpool.h.ahAA.a((Runnable)new d.i(paramString, parama, paramBoolean), paramLong, paramString);
    AppMethodBeat.o(233529);
  }
  
  private static final void a(kotlin.g.a.a parama, boolean paramBoolean, HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(233724);
    s.u(parama, "$block");
    parama.invoke();
    if (paramBoolean) {
      paramHandlerThread.quitSafely();
    }
    AppMethodBeat.o(233724);
  }
  
  public static final <T> boolean a(ArrayList<T> paramArrayList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(233609);
    s.u(paramArrayList, "<this>");
    s.u(paramb, "func");
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
    AppMethodBeat.o(233609);
    return bool;
  }
  
  public static final <T> boolean a(LinkedList<T> paramLinkedList, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(168826);
    s.u(paramLinkedList, "<this>");
    s.u(paramb, "func");
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
    AppMethodBeat.i(233576);
    s.u(paramList, "<this>");
    s.u(paramb, "predicate");
    try
    {
      boolean bool = p.e(paramList, paramb);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(233576);
    }
  }
  
  public static final String av(String paramString, int paramInt)
  {
    AppMethodBeat.i(233686);
    s.u(paramString, "<this>");
    if ((paramInt > paramString.length()) || (paramInt < 0))
    {
      paramString = paramString.toString();
      AppMethodBeat.o(233686);
      return paramString;
    }
    paramString = paramString.substring(0, paramInt);
    s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(233686);
    return paramString;
  }
  
  public static final <R> HandlerThread b(String paramString, boolean paramBoolean, kotlin.g.a.a<? extends R> parama)
  {
    AppMethodBeat.i(182804);
    s.u(paramString, "name");
    s.u(parama, "block");
    paramString = com.tencent.threadpool.c.d.jx(paramString, 5);
    paramString.start();
    new MMHandler(paramString.getLooper()).post(new d..ExternalSyntheticLambda5(parama, paramBoolean, paramString));
    s.s(paramString, "createMediaCodecThread(n…        }\n        }\n    }");
    AppMethodBeat.o(182804);
    return paramString;
  }
  
  public static final <T, R> c<R> b(c<T> paramc, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(168825);
    s.u(paramc, "<this>");
    s.u(paramb, "func");
    paramc = paramc.f(new d..ExternalSyntheticLambda1(paramb));
    s.s(paramc, "`$ui` {\n        func(it)\n    }");
    AppMethodBeat.o(168825);
    return paramc;
  }
  
  private static final Object b(b paramb, Object paramObject)
  {
    AppMethodBeat.i(233734);
    s.u(paramb, "$func");
    paramb = paramb.invoke(paramObject);
    AppMethodBeat.o(233734);
    return paramb;
  }
  
  public static final <T> void b(LiveData<T> paramLiveData, y<T> paramy)
  {
    AppMethodBeat.i(233714);
    s.u(paramLiveData, "<this>");
    s.u(paramy, "observer");
    uiThread((kotlin.g.a.a)new d.e(paramLiveData, paramy));
    AppMethodBeat.o(233714);
  }
  
  public static final c<Void> bbX()
  {
    AppMethodBeat.i(168823);
    c localc = g.jJU();
    s.s(localc, "pipeline()");
    AppMethodBeat.o(168823);
    return localc;
  }
  
  public static final byte[] c(Parcelable paramParcelable)
  {
    AppMethodBeat.i(233698);
    s.u(paramParcelable, "parcelable");
    Parcel localParcel = Parcel.obtain();
    s.s(localParcel, "obtain()");
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    s.s(paramParcelable, "bytes");
    AppMethodBeat.o(233698);
    return paramParcelable;
  }
  
  public static final int[] cZ(View paramView)
  {
    AppMethodBeat.i(233662);
    s.u(paramView, "<this>");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    AppMethodBeat.o(233662);
    return arrayOfInt;
  }
  
  public static final void d(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(233656);
    s.u(paramIntent, "<this>");
    s.u(paramString, "key");
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getStringArrayList(paramString))
    {
      paramIntent.putExtra(paramString, (Serializable)paramBundle);
      AppMethodBeat.o(233656);
      return;
    }
  }
  
  public static final void d(String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233514);
    s.u(paramString, "taskName");
    s.u(parama, "block");
    com.tencent.threadpool.h.ahAA.bm((Runnable)new d.g(paramString, parama, true));
    AppMethodBeat.o(233514);
  }
  
  public static final int[] da(View paramView)
  {
    AppMethodBeat.i(233668);
    s.u(paramView, "<this>");
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    AppMethodBeat.o(233668);
    return arrayOfInt;
  }
  
  public static final Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(233678);
    s.u(paramDrawable, "drawable");
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      s.s(localObject, "bitmap");
      AppMethodBeat.o(233678);
      return localObject;
    }
  }
  
  public static final void e(String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233520);
    s.u(paramString, "tag");
    s.u(parama, "block");
    a(paramString, true, parama);
    AppMethodBeat.o(233520);
  }
  
  public static final boolean ee(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  private static String getCaller()
  {
    AppMethodBeat.i(233540);
    try
    {
      Object localObject1 = new Throwable().getStackTrace();
      if ((localObject1 == null) || (localObject1.length < 4)) {
        return "";
      }
      String str = localObject1[3].getClassName();
      s.s(str, "stackTrace[3].className");
      str = str.substring(15);
      s.s(str, "(this as java.lang.String).substring(startIndex)");
      str = str + ':' + localObject1[3].getMethodName();
      localObject1 = str + '[' + localObject1[3].getLineNumber() + ']';
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(233540);
    }
    return "";
  }
  
  public static final void h(TextView paramTextView)
  {
    AppMethodBeat.i(153457);
    s.u(paramTextView, "textView");
    paramTextView.setShadowLayer(com.tencent.mm.cd.a.fromDPToPix(paramTextView.getContext(), 3), 0.0F, com.tencent.mm.cd.a.fromDPToPix(paramTextView.getContext(), 1), -2147483648);
    AppMethodBeat.o(153457);
  }
  
  public static final String hF(long paramLong)
  {
    AppMethodBeat.i(168821);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    s.s(str, "big.toString()");
    AppMethodBeat.o(168821);
    return str;
  }
  
  public static final void uiThread(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(153450);
    s.u(parama, "block");
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(153450);
      return;
    }
    MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda4(parama));
    AppMethodBeat.o(153450);
  }
  
  private static final void uiThread$lambda-0(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(233716);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(233716);
  }
  
  public static final void z(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(233489);
    s.u(parama, "block");
    if (!s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(233489);
      return;
    }
    B(parama);
    AppMethodBeat.o(233489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ae.d
 * JD-Core Version:    0.7.0.1
 */