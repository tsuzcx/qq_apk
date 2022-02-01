package com.tencent.mm.plugin.emojicapture.model.b;

import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "", "()V", "decodeFrameCallback", "Lkotlin/Function1;", "", "", "getDecodeFrameCallback", "()Lkotlin/jvm/functions/Function1;", "setDecodeFrameCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDecodeFinish", "Lkotlin/Function0;", "getOnDecodeFinish", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeFinish", "(Lkotlin/jvm/functions/Function0;)V", "init", "", "release", "setPauseDecode", "pause", "", "startDecode", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class k
{
  b<? super Long, ah> yiC;
  a<ah> yiD;
  
  public abstract void dEv();
  
  public abstract int init();
  
  public abstract void startDecode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.k
 * JD-Core Version:    0.7.0.1
 */