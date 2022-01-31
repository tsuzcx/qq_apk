package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$e
{
  long bpa;
  boolean bpb = y.bsw;
  
  private n$e(n paramn) {}
  
  private void reset()
  {
    this.bpa = 0L;
    this.bpb = y.bsw;
  }
  
  final void aV(boolean paramBoolean)
  {
    AppMethodBeat.i(55683);
    StringBuilder localStringBuilder;
    if ((this.bpb ^ paramBoolean))
    {
      if (!this.bpb) {
        break label156;
      }
      paramBoolean = false;
      this.bpb = paramBoolean;
      this.bpc.boC.tw();
      this.bpc.boC.ty();
      this.bpc.boz.aV(this.bpb);
      this.bpc.tl();
      if (y.bsr)
      {
        localStringBuilder = new StringBuilder("vehicle mode: ");
        if (!this.bpb) {
          break label161;
        }
      }
    }
    label156:
    label161:
    for (String str = "enable";; str = "disable")
    {
      str = str;
      o.r("filter_input_log_" + y.bsy, str);
      o.r("filter_output_log_" + y.bsy, str);
      AppMethodBeat.o(55683);
      return;
      paramBoolean = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.b.a.a.n.e
 * JD-Core Version:    0.7.0.1
 */