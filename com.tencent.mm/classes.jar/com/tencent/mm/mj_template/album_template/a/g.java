package com.tencent.mm.mj_template.album_template.a;

import androidx.compose.runtime.bm;
import com.tencent.maas.model.MJLyricInfo;
import com.tencent.maas.model.MJMusicInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/widget/MusicState;", "", "musicInfoListState", "Landroidx/compose/runtime/State;", "", "Lcom/tencent/maas/model/MJMusicInfo;", "musicInfoState", "selectMusic", "Lkotlin/Function1;", "", "", "musicMutedState", "", "originMutedState", "currentLyricInfoGetter", "Lkotlin/Function0;", "Lcom/tencent/maas/model/MJLyricInfo;", "switchMovieOption", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "musicMuted", "originMuted", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "getCurrentLyricInfoGetter", "()Lkotlin/jvm/functions/Function0;", "getMusicInfoListState", "()Landroidx/compose/runtime/State;", "getMusicInfoState", "getMusicMutedState", "getOriginMutedState", "getSelectMusic", "()Lkotlin/jvm/functions/Function1;", "getSwitchMovieOption", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  final bm<List<MJMusicInfo>> nYV;
  public final bm<MJMusicInfo> nYW;
  final b<String, ah> nYX;
  public final bm<Boolean> nYY;
  public final bm<Boolean> nYZ;
  final a<List<MJLyricInfo>> nZa;
  final m<Boolean, Boolean, ah> nZb;
  
  public g(bm<? extends List<? extends MJMusicInfo>> parambm, bm<? extends MJMusicInfo> parambm1, b<? super String, ah> paramb, bm<Boolean> parambm2, bm<Boolean> parambm3, a<? extends List<? extends MJLyricInfo>> parama, m<? super Boolean, ? super Boolean, ah> paramm)
  {
    AppMethodBeat.i(240582);
    this.nYV = parambm;
    this.nYW = parambm1;
    this.nYX = paramb;
    this.nYY = parambm2;
    this.nYZ = parambm3;
    this.nZa = parama;
    this.nZb = paramm;
    AppMethodBeat.o(240582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240595);
    if (this == paramObject)
    {
      AppMethodBeat.o(240595);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.nYV, paramObject.nYV))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    if (!s.p(this.nYW, paramObject.nYW))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    if (!s.p(this.nYX, paramObject.nYX))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    if (!s.p(this.nYY, paramObject.nYY))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    if (!s.p(this.nYZ, paramObject.nYZ))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    if (!s.p(this.nZa, paramObject.nZa))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    if (!s.p(this.nZb, paramObject.nZb))
    {
      AppMethodBeat.o(240595);
      return false;
    }
    AppMethodBeat.o(240595);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(240590);
    int i = this.nYV.hashCode();
    int j = this.nYW.hashCode();
    int k = this.nYX.hashCode();
    int m = this.nYY.hashCode();
    int n = this.nYZ.hashCode();
    int i1 = this.nZa.hashCode();
    int i2 = this.nZb.hashCode();
    AppMethodBeat.o(240590);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240587);
    String str = "MusicState(musicInfoListState=" + this.nYV + ", musicInfoState=" + this.nYW + ", selectMusic=" + this.nYX + ", musicMutedState=" + this.nYY + ", originMutedState=" + this.nYZ + ", currentLyricInfoGetter=" + this.nZa + ", switchMovieOption=" + this.nZb + ')';
    AppMethodBeat.o(240587);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.g
 * JD-Core Version:    0.7.0.1
 */