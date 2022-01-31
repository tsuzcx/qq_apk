package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
public final class VoiceInputProxy$c
  implements g.b
{
  public final void amK()
  {
    AppMethodBeat.i(2845);
    ab.i(VoiceInputProxy.access$getTAG$p(this.lwP), "onRecordFin");
    AppMethodBeat.o(2845);
  }
  
  public final void amO()
  {
    AppMethodBeat.i(2846);
    ab.i(VoiceInputProxy.access$getTAG$p(this.lwP), "onRecognizeFinish");
    this.lwP.CLIENT_CALL("onRecognizeFinish", new Object[0]);
    AppMethodBeat.o(2846);
  }
  
  public final void b(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138029);
    if (paramArrayOfString != null)
    {
      int i;
      if (paramArrayOfString.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label111;
        }
        i = 1;
        label22:
        if (i == 0) {
          break label152;
        }
        if (((CharSequence)paramArrayOfString[0]).length() <= 0) {
          break label116;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramList = paramArrayOfString[0];
          ab.i(VoiceInputProxy.access$getTAG$p(this.lwP), "onRes remote ".concat(String.valueOf(paramList)));
          i = m.d((CharSequence)paramList, "。");
          paramArrayOfString = paramList;
          if (i >= 0)
          {
            if (paramList == null)
            {
              paramArrayOfString = new v("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(138029);
              throw paramArrayOfString;
              i = 0;
              break;
              label111:
              i = 0;
              break label22;
              label116:
              i = 0;
              continue;
            }
            paramArrayOfString = paramList.substring(0, i);
            j.p(paramArrayOfString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
          this.lwP.CLIENT_CALL("onRes", new Object[] { paramArrayOfString });
        }
      }
    }
    label152:
    AppMethodBeat.o(138029);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(2844);
    ab.w(VoiceInputProxy.access$getTAG$p(this.lwP), "onError " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramLong);
    AppMethodBeat.o(2844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.c
 * JD-Core Version:    0.7.0.1
 */