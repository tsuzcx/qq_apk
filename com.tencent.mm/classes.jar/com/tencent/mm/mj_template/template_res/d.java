package com.tencent.mm.mj_template.template_res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/template_res/MaasTemplateResRecord;", "", "resId", "", "(I)V", "KEY_RESULT_UPDATE_TIME", "", "KEY_RES_UPDATE_TIME", "kvName", "getResId", "()I", "getKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "hasResUpdate", "", "onResUpdate", "", "onResultUpdate", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final String ogg;
  final String ogh;
  final String ogi;
  private final int resId;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(239505);
    this.resId = paramInt;
    this.ogg = "maas_template_res";
    this.ogh = (this.resId + "_RES_UPDATE_TIME");
    this.ogi = (this.resId + "_RESULT_UPDATE_TIME");
    AppMethodBeat.o(239505);
  }
  
  public final MultiProcessMMKV bxX()
  {
    AppMethodBeat.i(239507);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(this.ogg);
    s.s(localMultiProcessMMKV, "getMMKV(kvName)");
    AppMethodBeat.o(239507);
    return localMultiProcessMMKV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.template_res.d
 * JD-Core Version:    0.7.0.1
 */