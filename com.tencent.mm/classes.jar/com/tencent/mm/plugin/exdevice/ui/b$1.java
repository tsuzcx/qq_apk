package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements ExdeviceLikeView.a
{
  b$1(b paramb, com.tencent.mm.plugin.exdevice.f.b.a.d paramd) {}
  
  public final boolean aMA()
  {
    if (b.a(this.jFh) != null) {
      return b.a(this.jFh).BT(this.jFg.field_username);
    }
    return true;
  }
  
  public final void gl(int paramInt)
  {
    y.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramInt) });
    if (b.a(this.jFh) != null) {
      b.a(this.jFh).bz(this.jFg.field_username, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b.1
 * JD-Core Version:    0.7.0.1
 */