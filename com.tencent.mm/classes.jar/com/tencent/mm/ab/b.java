package com.tencent.mm.ab;

import a.f.b.j;
import a.l;
import a.y;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.math.BigInteger;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"codeConsume", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tag", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "T", "list", "", "freeMMHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "threadName", "freeThread", "opAddFlag", "", "value", "flag", "opCheckFlag", "", "opCleanFlag", "reverseConsumeList", "threadPool", "uiThread", "delay", "", "ulonglong", "seq", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedForEach", "", "action", "synchronizedForEachIndexed", "Lkotlin/Function2;", "index", "libktcomm_release"})
public final class b
{
  public static final <T extends com.tencent.mm.bv.a> T a(T paramT, byte[] paramArrayOfByte, a.f.a.b<? super Exception, y> paramb)
  {
    AppMethodBeat.i(155619);
    j.q(paramT, "receiver$0");
    j.q(paramb, "block");
    try
    {
      paramT.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(155619);
      return paramT;
    }
    catch (Exception paramT)
    {
      ab.a("safeParser", "", new Object[] { paramT });
      paramb.S(paramT);
      AppMethodBeat.o(155619);
    }
    return null;
  }
  
  public static final void a(long paramLong, a.f.a.a<y> parama)
  {
    AppMethodBeat.i(155615);
    j.q(parama, "block");
    al.p((Runnable)new c(parama), paramLong);
    AppMethodBeat.o(155615);
  }
  
  public static final <R> void a(a.f.a.a<? extends R> parama, String paramString)
  {
    AppMethodBeat.i(155617);
    j.q(parama, "block");
    j.q(paramString, "threadName");
    paramString = new al(paramString);
    paramString.ac((Runnable)new b.c(parama, paramString));
    AppMethodBeat.o(155617);
  }
  
  public static final void a(String paramString, a.f.a.a<y> parama)
  {
    AppMethodBeat.i(155616);
    j.q(paramString, "threadName");
    j.q(parama, "block");
    d.post((Runnable)new c(parama), paramString);
    AppMethodBeat.o(155616);
  }
  
  public static final <R> al b(a.f.a.a<? extends R> parama, String paramString)
  {
    AppMethodBeat.i(155618);
    j.q(parama, "block");
    j.q(paramString, "threadName");
    paramString = new al(paramString);
    paramString.ac((Runnable)new b.b(parama));
    AppMethodBeat.o(155618);
    return paramString;
  }
  
  public static final void b(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(155614);
    j.q(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    j.p(localLooper, "Looper.getMainLooper()");
    if (j.e(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(155614);
      return;
    }
    al.d((Runnable)new c(parama));
    AppMethodBeat.o(155614);
  }
  
  public static final boolean ck(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
  
  public static final void e(TextView paramTextView)
  {
    AppMethodBeat.i(155621);
    j.q(paramTextView, "textView");
    paramTextView.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 3), 0.0F, com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 1), -2147483648);
    AppMethodBeat.o(155621);
  }
  
  public static final String gj(long paramLong)
  {
    AppMethodBeat.i(155620);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    j.p(str, "big.toString()");
    AppMethodBeat.o(155620);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ab.b
 * JD-Core Version:    0.7.0.1
 */