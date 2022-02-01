package com.tencent.mm.plugin.flutter.thumbplayer.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/SnsCdnTaskFactory;", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/ICdnTaskFactory;", "()V", "TAG", "", "getSupportCdnMediaType", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;", "parse", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "proto", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  final String TAG = "MicroMsg.SnsCdnTaskFactory";
  
  public final Object a(byte[] paramArrayOfByte, kotlin.d.d<? super h> paramd)
  {
    AppMethodBeat.i(263228);
    paramArrayOfByte = l.a((f)bg.kCi(), (m)new d.a(this, paramArrayOfByte, null), paramd);
    AppMethodBeat.o(263228);
    return paramArrayOfByte;
  }
  
  public final a fve()
  {
    return a.HkZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.a.d
 * JD-Core Version:    0.7.0.1
 */