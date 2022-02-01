package com.tencent.luggage.sdk.launching;

import android.os.Looper;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultEventSender;", "R", "Landroid/os/Parcelable;", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;", "instance", "", "processName", "", "(ILjava/lang/String;)V", "getInstance", "()I", "isReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getProcessName", "()Ljava/lang/String;", "finalize", "", "onWXAppResult", "result", "(Landroid/os/Parcelable;)V", "release", "sendMessage", "message", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultXPCMessage;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<R extends Parcelable>
  implements b<R>
{
  private static final a etx;
  private final int etw;
  private final AtomicBoolean ety;
  private final String processName;
  
  static
  {
    AppMethodBeat.i(220556);
    etx = new a((byte)0);
    AppMethodBeat.o(220556);
  }
  
  public a(int paramInt, String paramString)
  {
    AppMethodBeat.i(220531);
    this.etw = paramInt;
    this.processName = paramString;
    this.ety = new AtomicBoolean(false);
    AppMethodBeat.o(220531);
  }
  
  private final void a(OnWXAppResultXPCMessage paramOnWXAppResultXPCMessage)
  {
    AppMethodBeat.i(220540);
    CharSequence localCharSequence = (CharSequence)this.processName;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.OnWXAppResultEventSender", s.X("sendMessage, processName empty, message:", Integer.valueOf(paramOnWXAppResultXPCMessage.action)));
      AppMethodBeat.o(220540);
      return;
    }
    if (!MMApplicationContext.isProcessExist(this.processName))
    {
      Log.e("MicroMsg.OnWXAppResultEventSender", s.X("sendMessage, process dead, message:", Integer.valueOf(paramOnWXAppResultXPCMessage.action)));
      AppMethodBeat.o(220540);
      return;
    }
    com.tencent.mm.ipcinvoker.a.a(this.processName, (Parcelable)paramOnWXAppResultXPCMessage, (d)a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(220540);
  }
  
  private static final void a(OnWXAppResultXPCMessage paramOnWXAppResultXPCMessage, f paramf)
  {
    AppMethodBeat.i(220550);
    if (paramOnWXAppResultXPCMessage == null)
    {
      if (paramf != null) {
        paramf.onCallback(IPCVoid.mzv);
      }
      AppMethodBeat.o(220550);
      return;
    }
    try
    {
      c localc = new c();
      localc.etw = paramOnWXAppResultXPCMessage.etw;
      localc.action = paramOnWXAppResultXPCMessage.action;
      localc.etA = paramOnWXAppResultXPCMessage.etA;
      localc.asyncPublish(Looper.getMainLooper());
      return;
    }
    finally
    {
      if (paramf != null) {
        paramf.onCallback(IPCVoid.mzv);
      }
      AppMethodBeat.o(220550);
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(220575);
    release();
    AppMethodBeat.o(220575);
  }
  
  public final void onWXAppResult(R paramR)
  {
    AppMethodBeat.i(220566);
    a(new OnWXAppResultXPCMessage(this.etw, 1, paramR));
    AppMethodBeat.o(220566);
  }
  
  public final void release()
  {
    AppMethodBeat.i(220572);
    if (!this.ety.getAndSet(true)) {
      a(new OnWXAppResultXPCMessage(this.etw, 2, null));
    }
    AppMethodBeat.o(220572);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultEventSender$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.a
 * JD-Core Version:    0.7.0.1
 */