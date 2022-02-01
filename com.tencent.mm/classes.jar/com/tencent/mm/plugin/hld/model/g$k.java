package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/model/ImeKeyboardSwitch$viewSaveToImage$1$1$1$1", "Lcom/tencent/mm/plugin/hld/utils/WxImeUIUtil$OnSaveListEner;", "onFailure", "", "error", "", "onFinish", "onStart", "onSucceed", "filePath", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$k
  implements k.a
{
  g$k(int paramInt) {}
  
  public final void eW(String paramString)
  {
    AppMethodBeat.i(311964);
    Log.i("WxIme.ImeKeyboardSwitch", "onFailure " + this.Jvu + ' ' + paramString);
    AppMethodBeat.o(311964);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(311979);
    Log.i("WxIme.ImeKeyboardSwitch", s.X("onFinish ", Integer.valueOf(this.Jvu)));
    AppMethodBeat.o(311979);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(311930);
    Log.i("WxIme.ImeKeyboardSwitch", s.X("onStart ", Integer.valueOf(this.Jvu)));
    AppMethodBeat.o(311930);
  }
  
  public final void onSucceed(String paramString)
  {
    AppMethodBeat.i(311949);
    Log.i("WxIme.ImeKeyboardSwitch", "onSucceed " + this.Jvu + ' ' + paramString);
    AppMethodBeat.o(311949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.g.k
 * JD-Core Version:    0.7.0.1
 */