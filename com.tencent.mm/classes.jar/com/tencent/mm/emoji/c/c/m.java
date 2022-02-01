package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "", "wordVersion", "", "wordType", "", "wordSize", "preloadSessionId", "", "(JIILjava/lang/String;)V", "getPreloadSessionId", "()Ljava/lang/String;", "setPreloadSessionId", "(Ljava/lang/String;)V", "getWordSize", "()I", "setWordSize", "(I)V", "getWordType", "setWordType", "getWordVersion", "()J", "setWordVersion", "(J)V", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public int mjT;
  public long mjU;
  public int mkc;
  public String mkd;
  
  public m()
  {
    this(0L, 0, 0, null, 15);
  }
  
  private m(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(242676);
    this.mjU = paramLong;
    this.mjT = paramInt1;
    this.mkc = paramInt2;
    this.mkd = paramString;
    AppMethodBeat.o(242676);
  }
  
  public final void Eu(String paramString)
  {
    AppMethodBeat.i(242694);
    s.u(paramString, "<set-?>");
    this.mkd = paramString;
    AppMethodBeat.o(242694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.m
 * JD-Core Version:    0.7.0.1
 */