package com.tencent.mm.plugin.card.model;

import com.tencent.mm.sdk.e.e;

public final class j
  extends com.tencent.mm.sdk.e.i<i>
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(i.buS, "CardQrCodeConfi") };
  private e dXw;
  
  public j(e parame)
  {
    super(parame, i.buS, "CardQrCodeConfi", null);
    this.dXw = parame;
  }
  
  public final i yj(String paramString)
  {
    i locali = new i();
    locali.field_card_id = paramString;
    if (b(locali, new String[0])) {
      return locali;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.j
 * JD-Core Version:    0.7.0.1
 */