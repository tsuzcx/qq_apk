package com.tencent.mm.mj_template.maas.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "reportResult", "", "Lcom/tencent/mm/autogen/mmdata/rpt/MaasSdkResStruct;", "success", "", "plugin-mj-template_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG = "MicroMsg.MaasSdkResReport";
  
  public static final void a(jo paramjo, boolean paramBoolean)
  {
    AppMethodBeat.i(239947);
    s.u(paramjo, "<this>");
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramjo.iUn = i;
      Log.i(TAG, s.X("reportResult: ", paramjo.aIF()));
      paramjo.bMH();
      AppMethodBeat.o(239947);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.b.e
 * JD-Core Version:    0.7.0.1
 */