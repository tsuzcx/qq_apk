package com.tencent.mm.emoji.b.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/task/ProcessTask$IPCLoadEmoji;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b
  implements d<Bundle, Bundle>
{
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/loader/task/ProcessTask$IPCLoadEmoji$invoke$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h.a
  {
    a(f<Bundle> paramf) {}
    
    public final void onResult(boolean paramBoolean)
    {
      AppMethodBeat.i(242730);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("KEY_RESULT", paramBoolean);
      f localf = this.mht;
      if (localf != null) {
        localf.onCallback(localBundle);
      }
      AppMethodBeat.o(242730);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e.e.b
 * JD-Core Version:    0.7.0.1
 */