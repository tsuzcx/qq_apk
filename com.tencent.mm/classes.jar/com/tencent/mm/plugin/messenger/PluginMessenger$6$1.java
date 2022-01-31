package com.tencent.mm.plugin.messenger;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.a;
import java.lang.ref.WeakReference;
import java.util.Map;

final class PluginMessenger$6$1
  extends a
{
  PluginMessenger$6$1(PluginMessenger.6 param6, Map paramMap, String paramString1, Bundle paramBundle, WeakReference paramWeakReference, String paramString2) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(136881);
    PluginMessenger.access$000(this.oCP.oCK, this.oCN, this.oCO, this.val$params, this.eej, this.irs, true);
    AppMethodBeat.o(136881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.6.1
 * JD-Core Version:    0.7.0.1
 */