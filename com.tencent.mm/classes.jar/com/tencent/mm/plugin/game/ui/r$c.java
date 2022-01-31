package com.tencent.mm.plugin.game.ui;

public final class r$c
{
  public int actionType;
  String appId;
  int bXn;
  int lfe;
  int lff;
  String lfj;
  String lfk;
  int position;
  int type;
  
  public r$c() {}
  
  public r$c(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.actionType = paramInt1;
    this.type = paramInt2;
    this.appId = paramString1;
    if (paramInt1 == 2) {
      this.lfj = paramString2;
    }
  }
  
  public r$c(String paramString)
  {
    this.actionType = 2;
    this.lfj = paramString;
  }
  
  public r$c(String paramString, byte paramByte)
  {
    this.actionType = 2;
    this.type = 3;
    this.lfj = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r.c
 * JD-Core Version:    0.7.0.1
 */