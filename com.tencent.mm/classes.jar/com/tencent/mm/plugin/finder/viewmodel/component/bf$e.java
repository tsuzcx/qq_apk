package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.res.Resources;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class bf$e
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  bf$e(bf parambf, ah.d paramd, long paramLong, d<? super e> paramd1)
  {
    super(2, paramd1);
  }
  
  private static final void a(long paramLong, bf parambf, String paramString)
  {
    AppMethodBeat.i(337628);
    if (paramLong > 0L) {
      bf.b(parambf).postDelayed(bf.c(parambf), paramLong);
    }
    bf.d(parambf);
    Log.i("FinderWifiHintUIC", s.X("[showHint] hint:", paramString));
    AppMethodBeat.o(337628);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(337643);
    paramObject = (d)new e(this.GWl, this.GWo, this.GWp, paramd);
    AppMethodBeat.o(337643);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(337638);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(337638);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = this.GWl.getActivity().getResources().getString(this.GWo.aixb);
    s.s(paramObject, "activity.resources.getString(hintRes)");
    bf.b(this.GWl).setText((CharSequence)paramObject);
    bf.b(this.GWl).setVisibility(0);
    bf.b(this.GWl).post(new bf.e..ExternalSyntheticLambda0(this.GWp, this.GWl, paramObject));
    paramObject = ah.aiuX;
    AppMethodBeat.o(337638);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bf.e
 * JD-Core Version:    0.7.0.1
 */