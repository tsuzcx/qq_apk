package com.tencent.luggage.e;

import android.text.TextUtils;

final class n$2
  extends l
{
  n$2(n paramn) {}
  
  public final void bc(String paramString)
  {
    if (this.biY.qr() != null) {
      this.biY.qr().a(this.biY, paramString);
    }
  }
  
  public final void bd(String paramString)
  {
    if (this.biY.qr() != null) {
      this.biY.qr().b(this.biY, paramString);
    }
    this.biY.bik.k(i.e.class);
  }
  
  public final String qq()
  {
    n localn = this.biY;
    if (localn.biW == null)
    {
      String str2 = localn.qq();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
      localn.biW = str1;
    }
    return localn.biW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.e.n.2
 * JD-Core Version:    0.7.0.1
 */