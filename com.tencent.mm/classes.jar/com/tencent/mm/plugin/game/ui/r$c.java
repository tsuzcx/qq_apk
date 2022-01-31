package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r$c
{
  public int actionType;
  String appId;
  int cFj;
  int nCZ;
  int nDa;
  String nDe;
  String nDf;
  int position;
  int type;
  
  public r$c() {}
  
  public r$c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112174);
    this.actionType = paramInt1;
    this.type = paramInt2;
    this.appId = paramString1;
    if (paramInt1 == 2) {
      this.nDe = paramString2;
    }
    AppMethodBeat.o(112174);
  }
  
  public r$c(String paramString)
  {
    this.actionType = 2;
    this.nDe = paramString;
  }
  
  public r$c(String paramString, byte paramByte)
  {
    this.actionType = 2;
    this.type = 3;
    this.nDe = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r.c
 * JD-Core Version:    0.7.0.1
 */