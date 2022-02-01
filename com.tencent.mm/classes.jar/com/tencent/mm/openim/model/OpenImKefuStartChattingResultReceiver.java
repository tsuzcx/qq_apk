package com.tencent.mm.openim.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "callback", "Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;", "(Landroid/os/Handler;Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;)V", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "Companion", "ReceiveResultCallback", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenImKefuStartChattingResultReceiver
  extends ResultReceiver
{
  public static final a ptd;
  private final b pte;
  
  static
  {
    AppMethodBeat.i(235806);
    ptd = new a((byte)0);
    AppMethodBeat.o(235806);
  }
  
  public OpenImKefuStartChattingResultReceiver(Handler paramHandler, b paramb)
  {
    super(paramHandler);
    AppMethodBeat.i(235802);
    this.pte = paramb;
    AppMethodBeat.o(235802);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(235808);
    this.pte.R(paramBundle);
    AppMethodBeat.o(235808);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;", "", "onReceiveResult", "", "resultData", "Landroid/os/Bundle;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void R(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver
 * JD-Core Version:    0.7.0.1
 */