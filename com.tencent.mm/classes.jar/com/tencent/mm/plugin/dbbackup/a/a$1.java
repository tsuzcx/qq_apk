package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.repair.RepairKit.Callback;

final class a$1
  implements RepairKit.Callback
{
  private int kUT = 0;
  private boolean kUU = false;
  private int ym = 0;
  
  a$1(a parama, int[] paramArrayOfInt) {}
  
  public final int onProgress(String paramString, int paramInt, Cursor paramCursor)
  {
    AppMethodBeat.i(19002);
    if (this.kUT == 0) {
      if (paramString.equalsIgnoreCase("message")) {
        this.kUT = paramInt;
      }
    }
    while (this.kUT == paramInt)
    {
      paramInt = this.ym;
      this.ym = (paramInt + 1);
      if (paramInt % 1000 == 0) {
        a.b(this.kUW, new Integer[] { Integer.valueOf(2), Integer.valueOf(this.ym - 1), Integer.valueOf(a.a(this.kUW)) });
      }
      paramString = this.kUV;
      paramString[0] += 1;
      AppMethodBeat.o(19002);
      return 0;
      AppMethodBeat.o(19002);
      return 0;
    }
    if (!this.kUU)
    {
      this.kUU = true;
      a.a(this.kUW, new Integer[] { Integer.valueOf(3) });
    }
    AppMethodBeat.o(19002);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.1
 * JD-Core Version:    0.7.0.1
 */