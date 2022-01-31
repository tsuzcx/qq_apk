package com.d.a.a;

final class n$e
{
  long aYt;
  boolean aYu = y.bbQ;
  
  private n$e(n paramn) {}
  
  final void aH(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((this.aYu ^ paramBoolean))
    {
      if (!this.aYu) {
        break label146;
      }
      paramBoolean = false;
      this.aYu = paramBoolean;
      this.aYv.aXV.pq();
      this.aYv.aXV.ps();
      this.aYv.aXS.aH(this.aYu);
      this.aYv.pf();
      if (y.bbL)
      {
        localStringBuilder = new StringBuilder("vehicle mode: ");
        if (!this.aYu) {
          break label151;
        }
      }
    }
    label146:
    label151:
    for (String str = "enable";; str = "disable")
    {
      str = str;
      o.m("filter_input_log_" + y.bbS, str);
      o.m("filter_output_log_" + y.bbS, str);
      return;
      paramBoolean = true;
      break;
    }
  }
  
  final void reset()
  {
    this.aYt = 0L;
    this.aYu = y.bbQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.n.e
 * JD-Core Version:    0.7.0.1
 */