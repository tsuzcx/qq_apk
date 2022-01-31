package com.tencent.mm.as.a.f;

public final class a
  implements Runnable
{
  private final com.tencent.mm.as.a.a.c eqR;
  private final com.tencent.mm.as.a.c.a eqT;
  private final com.tencent.mm.as.a.c.b eqU;
  private final com.tencent.mm.as.a.a.b eqy;
  private final com.tencent.mm.as.a.b erP;
  private final com.tencent.mm.as.a.c.c erQ;
  private final String url;
  
  public a(String paramString, com.tencent.mm.as.a.a.c paramc, com.tencent.mm.as.a.b paramb, com.tencent.mm.as.a.c.c paramc1)
  {
    this.url = paramString;
    this.erP = paramb;
    this.eqy = this.erP.eqy;
    if (paramc == null)
    {
      this.eqR = this.eqy.eqR;
      this.erQ = paramc1;
      if (this.eqR.eqU == null) {
        break label87;
      }
    }
    label87:
    for (this.eqU = this.eqR.eqU;; this.eqU = this.eqy.eqU)
    {
      this.eqT = this.eqy.eqT;
      return;
      this.eqR = paramc;
      break;
    }
  }
  
  public final void run()
  {
    new com.tencent.mm.as.a.d.b();
    com.tencent.mm.as.a.d.b localb = this.eqU.ms(this.url);
    if (localb == null) {
      this.erQ.a(false, this.eqR.erJ);
    }
    do
    {
      do
      {
        return;
        if (((com.tencent.mm.sdk.platformtools.c.decodeByteArray(localb.data, 10, 10) == null) && (this.eqR.erG)) || (!this.eqT.a(this.url, localb.data, this.eqR))) {
          break;
        }
      } while (this.erQ == null);
      this.erQ.a(true, this.eqR.erJ);
      return;
    } while (this.erQ == null);
    this.erQ.a(false, this.eqR.erJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.a.f.a
 * JD-Core Version:    0.7.0.1
 */