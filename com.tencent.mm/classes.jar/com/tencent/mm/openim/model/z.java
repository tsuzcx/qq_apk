package com.tencent.mm.openim.model;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenIMKefuStartConversationEventDispatcher;", "", "()V", "sendCheckBindState", "", "resultReceiver", "Landroid/os/ResultReceiver;", "session", "", "success", "", "errCode", "", "errMsg", "", "sendConfirmCancelEvent", "sendConfirmEvent", "sendConfirmPageShownEvent", "sendGetContactEvent", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z ptb;
  
  static
  {
    AppMethodBeat.i(235836);
    ptb = new z();
    AppMethodBeat.o(235836);
  }
  
  public static final void a(ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(235832);
    if (paramResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("result_key_action", 5);
      ah localah = ah.aiuX;
      paramResultReceiver.send(0, localBundle);
    }
    AppMethodBeat.o(235832);
  }
  
  public static final void a(ResultReceiver paramResultReceiver, String paramString)
  {
    AppMethodBeat.i(235830);
    s.u(paramString, "errMsg");
    if (paramResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("result_key_err_code", 3);
      localBundle.putString("result_key_err_msg", paramString);
      localBundle.putInt("result_key_action", 6);
      paramString = ah.aiuX;
      paramResultReceiver.send(3, localBundle);
    }
    AppMethodBeat.o(235830);
  }
  
  public static final void a(ResultReceiver paramResultReceiver, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(235821);
    s.u(paramString, "errMsg");
    Bundle localBundle;
    if (paramResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("result_key_err_code", paramInt);
      localBundle.putString("result_key_err_msg", paramString);
      if (!paramBoolean) {
        break label74;
      }
    }
    label74:
    for (int i = 7;; i = 8)
    {
      localBundle.putInt("result_key_action", i);
      paramString = ah.aiuX;
      paramResultReceiver.send(paramInt, localBundle);
      AppMethodBeat.o(235821);
      return;
    }
  }
  
  public static final void b(ResultReceiver paramResultReceiver, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(235824);
    s.u(paramString, "errMsg");
    Bundle localBundle;
    if (paramResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("result_key_err_code", paramInt);
      localBundle.putString("result_key_err_msg", paramString);
      if (!paramBoolean) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("result_key_action", i);
      paramString = ah.aiuX;
      paramResultReceiver.send(paramInt, localBundle);
      AppMethodBeat.o(235824);
      return;
    }
  }
  
  public static final void c(ResultReceiver paramResultReceiver, boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(235827);
    s.u(paramString, "errMsg");
    Bundle localBundle;
    if (paramResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("result_key_err_code", paramInt);
      localBundle.putString("result_key_err_msg", paramString);
      if (!paramBoolean) {
        break label73;
      }
    }
    label73:
    for (int i = 3;; i = 4)
    {
      localBundle.putInt("result_key_action", i);
      paramString = ah.aiuX;
      paramResultReceiver.send(paramInt, localBundle);
      AppMethodBeat.o(235827);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.model.z
 * JD-Core Version:    0.7.0.1
 */