package com.tencent.mm.plugin.expt.d;

import android.content.Context;
import android.provider.Settings.Secure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/biz/SensitiveApiCallPatch$Companion$monitor$9", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "ANDROID_ID", "", "onHook", "", "innerClassName", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a$d
  implements c
{
  private String zxT;
  
  public final Object onHook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(299561);
    Log.d("MicroMsg.SensitiveApiCallPatch", "otherSensitiveMethods. hook call " + paramString4 + " from " + paramString1 + '#' + paramString2);
    if (s.p(paramString4, "getString"))
    {
      s.checkNotNull(paramArrayOfObject);
      paramString1 = paramArrayOfObject[1];
      if (paramString1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(299561);
        throw paramString1;
      }
      if (s.p((String)paramString1, "android_id"))
      {
        if (this.zxT == null) {
          this.zxT = Settings.Secure.getString(MMApplicationContext.getContext().getContentResolver(), "android_id");
        }
        paramString1 = this.zxT;
        AppMethodBeat.o(299561);
        return paramString1;
      }
      paramString1 = MMApplicationContext.getContext().getContentResolver();
      paramString2 = paramArrayOfObject[1];
      if (paramString2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(299561);
        throw paramString1;
      }
      paramString1 = Settings.Secure.getString(paramString1, (String)paramString2);
      AppMethodBeat.o(299561);
      return paramString1;
    }
    AppMethodBeat.o(299561);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.c.a.d
 * JD-Core Version:    0.7.0.1
 */