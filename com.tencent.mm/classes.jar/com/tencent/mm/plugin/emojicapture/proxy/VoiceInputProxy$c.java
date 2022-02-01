package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
public final class VoiceInputProxy$c
  implements g.b
{
  public final void aOo()
  {
    AppMethodBeat.i(423);
    ae.i(VoiceInputProxy.access$getTAG$p(this.qaP), "onRecordFin");
    AppMethodBeat.o(423);
  }
  
  public final void aOs()
  {
    AppMethodBeat.i(424);
    ae.i(VoiceInputProxy.access$getTAG$p(this.qaP), "onRecognizeFinish");
    this.qaP.CLIENT_CALL("onRecognizeFinish", new Object[0]);
    AppMethodBeat.o(424);
  }
  
  public final void b(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(421);
    if (paramArrayOfString != null)
    {
      int i;
      if (paramArrayOfString.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label113;
        }
        i = 1;
        label23:
        if (i == 0) {
          break label154;
        }
        if (((CharSequence)paramArrayOfString[0]).length() <= 0) {
          break label118;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramList = paramArrayOfString[0];
          ae.i(VoiceInputProxy.access$getTAG$p(this.qaP), "onRes remote ".concat(String.valueOf(paramList)));
          i = n.g((CharSequence)paramList, "。");
          paramArrayOfString = paramList;
          if (i >= 0)
          {
            if (paramList == null)
            {
              paramArrayOfString = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(421);
              throw paramArrayOfString;
              i = 0;
              break;
              label113:
              i = 0;
              break label23;
              label118:
              i = 0;
              continue;
            }
            paramArrayOfString = paramList.substring(0, i);
            p.g(paramArrayOfString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
          this.qaP.CLIENT_CALL("onRes", new Object[] { paramArrayOfString });
        }
      }
    }
    label154:
    AppMethodBeat.o(421);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(422);
    ae.w(VoiceInputProxy.access$getTAG$p(this.qaP), "onError " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramLong);
    AppMethodBeat.o(422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.c
 * JD-Core Version:    0.7.0.1
 */